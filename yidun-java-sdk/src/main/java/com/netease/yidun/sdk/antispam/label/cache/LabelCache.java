package com.netease.yidun.sdk.antispam.label.cache;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.label.LabelClient;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryInfo;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;
import com.netease.yidun.sdk.antispam.label.query.response.SubLabel;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.utils.AssertUtils;
import com.netease.yidun.sdk.core.utils.CollectionUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class LabelCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabelCache.class);

    private static volatile Map<String, LabelCacheItem> codeNameMap;

    private static volatile List<LabelClient> labelClients;

    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);

    /**
     * 根据code获取名称
     *
     * @param labelCode
     * @return
     */
    public static String getLabelName(String labelCode) {
        if (codeNameMap == null) {
            return null;
        }
        LabelCacheItem cacheItem = codeNameMap.get(labelCode);
        if (cacheItem == null) {
            return null;
        }
        return cacheItem.getName();
    }

    /**
     * 初始化缓存
     *
     * @param request
     */
    public static void initCache(ClientProfile clientProfile, LabelQueryRequest request) {
        AssertUtils.notNull(clientProfile, "clientProfile can not be null");
        List<ClientProfile> clientProfiles = new ArrayList<>(1);
        clientProfiles.add(clientProfile);
        CacheProperty cacheProperty = new CacheProperty();
        cacheProperty.setRefreshIntervalMinute(60);
        initCache(clientProfiles, request, cacheProperty);
    }

    /**
     * 初始化缓存
     *
     * @param request
     */
    public static void initCache(List<ClientProfile> clientProfiles, LabelQueryRequest request, CacheProperty cacheProperty) {
        AssertUtils.notNull(request, "request can not be null");
        AssertUtils.notEmpty(clientProfiles, "clientProfiles can not be null or empty");
        AssertUtils.notNull(cacheProperty, "cacheProperty can not be null");
        boolean initSuccess = INITIALIZED.compareAndSet(false, true);
        if (!initSuccess) {
            LOGGER.warn("label cache has been initialized");
            return;
        }

        codeNameMap = new ConcurrentHashMap<>();
        labelClients = clientProfiles.stream()
                .map(profile -> LabelClient.getInstance(AntispamRequester.getInstance(profile)))
                .collect(Collectors.toList());
        refreshCache(request, cacheProperty);
    }

    /**
     * 刷新缓存
     *
     * @param request
     */
    private static void refreshCache(LabelQueryRequest request, CacheProperty cacheProperty) {
        ScheduledExecutorService cacheRefresherExec = new ScheduledThreadPoolExecutor(1, r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setName("label-cache-refresher");
            thread.setDaemon(true);
            return thread;
        });
        cacheRefresherExec.scheduleWithFixedDelay(() -> {
            try {
                long currentTime = System.currentTimeMillis();
                boolean buildSuccess = buildCache(request, currentTime);
                if (buildSuccess) {
                    expireCache(currentTime);
                }
            } catch (Exception e) {
                LOGGER.error("refresh label cache error", e);
            }
        }, cacheProperty.getRefreshIntervalMinute(), cacheProperty.getRefreshIntervalMinute(), TimeUnit.MINUTES);
        buildCache(request, System.currentTimeMillis());
    }

    /**
     * 构建缓存
     *
     * @param request
     */
    private static boolean buildCache(LabelQueryRequest request, long currentTime) {
        boolean success = true;
        for (LabelClient labelClient : labelClients) {
            LabelQueryResponse labelQueryResponse;
            try {
                labelQueryResponse = labelClient.queryLabel(request);
            } catch (Exception e) {
                LOGGER.error("query label for label cache error", e);
                success = false;
                continue;
            }
            if (labelQueryResponse == null || !Objects.equals(labelQueryResponse.getCode(), 200) ||
                    CollectionUtils.isEmpty(labelQueryResponse.getData())) {
                LOGGER.error("query label for label cache empty, response code {}, msg {}",
                        Optional.ofNullable(labelQueryResponse).map(LabelQueryResponse::getCode).orElse(null),
                        Optional.ofNullable(labelQueryResponse).map(LabelQueryResponse::getMsg).orElse(null));
                success = false;
                continue;
            }

            for (LabelQueryInfo labelQueryInfo : labelQueryResponse.getData()) {
                if (labelQueryInfo == null) {
                    continue;
                }
                if (labelQueryInfo.getLabel() != null) {
                    putInCache(String.valueOf(labelQueryInfo.getLabel()), labelQueryInfo.getName(), currentTime);
                }
                recursiveSubLabels(labelQueryInfo.getSubLabels(), currentTime);
            }
        }
        return success;
    }

    /**
     * 过期缓存
     *
     * @param lastUpdateTime
     */
    private static void expireCache(long lastUpdateTime) {
        Iterator<Map.Entry<String, LabelCacheItem>> iterator = codeNameMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, LabelCacheItem> entry = iterator.next();
            // 老的缓存数据，删除
            if (entry.getValue().getUpdateTime() < lastUpdateTime) {
                iterator.remove(); // 使用迭代器的remove方法删除元素
            }
        }
    }

    /**
     * 递归遍历子标签
     *
     * @param subLabels
     * @param currentTime
     */
    private static void recursiveSubLabels(List<SubLabel> subLabels, long currentTime) {
        if (CollectionUtils.isEmpty(subLabels)) {
            return;
        }
        for (SubLabel subLabel : subLabels) {
            if (subLabel == null) {
                continue;
            }
            putInCache(subLabel.getCode(), subLabel.getName(), currentTime);
            recursiveSubLabels(subLabel.getSubLabels(), currentTime);
        }
    }

    /**
     * 将labelCode和labelName放入缓存
     *
     * @param labelCode
     * @param labelName
     * @param currentTime
     */
    private static void putInCache(String labelCode, String labelName, long currentTime) {
        if (StringUtils.isBlank(labelCode) || StringUtils.isBlank(labelName)) {
            return;
        }
        LabelCacheItem cacheItem = codeNameMap.putIfAbsent(labelCode, new LabelCacheItem(labelName, currentTime));
        if (cacheItem == null) {
            // 表示是cache直接新增的，直接返回
            return;
        }
        if (!Objects.equals(cacheItem.getName(), labelName)) {
            cacheItem.setName(labelName);
        }
        cacheItem.setUpdateTime(currentTime);
    }

}
