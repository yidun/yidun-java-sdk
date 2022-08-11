

package com.netease.yidun.sdk.antispam.callback;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.core.utils.AssertUtils;
import com.netease.yidun.sdk.core.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 用于处理回调相关
 *
 * @author zhaojipu
 * @version 2022-02-18
 */
@Slf4j
public abstract class AbstractCallbackHandler<T> {

    private static final Integer PARK_TIME_MILLS = 100;
    private static final Integer LONG_PARK_TIME_MILLS = 1000;
    private static final Long WASTE_COUNT_THRESHOLD = 20L;

    /**
     * 存储当前时间的QPS
     */
    protected final ThreadPoolExecutor callbackExecutor;
    private CallbackProfile profile;
    protected AntispamRequester antispamRequester;
    private volatile Boolean isClose = false;

    public AbstractCallbackHandler(AntispamRequester antispamRequester) {
        this(antispamRequester, new CallbackProfile());
    }

    public AbstractCallbackHandler(AntispamRequester antispamRequester, String businessId) {
        this(antispamRequester, new CallbackProfile(businessId));
    }

    /**
     * 回调相关设置
     *
     * @param profile
     */
    public AbstractCallbackHandler(AntispamRequester antispamRequester, CallbackProfile profile) {
        AssertUtils.notNull(profile, "profile can not be null");
        AssertUtils.notNull(profile.getConcurrency(), "concurrency can not be null");

        this.antispamRequester = antispamRequester;
        this.profile = profile;
        this.callbackExecutor = new ThreadPoolExecutor(profile.getConcurrency(), profile.getConcurrency(), 60L,
                TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() {
            private AtomicInteger sn = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Callback-Thread-" + sn.getAndIncrement());
            }
        });

    }

    public void start() {
        AssertUtils.notNull(profile.getConcurrency(), "concurrency can not be null");
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");

        for (int i = 0; i < profile.getConcurrency(); i++) {
            callbackExecutor.execute(() -> {
                long wasteCount = 0;
                // 不停循环获取待回调数据
                String requestId = generateRequestId();
                CallbackContext context = new CallbackContext();
                while (!isClose) {
                    List<T> callbackData = null;
                    try {
                        callbackData = requestCallback(profile.getBusinessId(), requestId);
                    } catch (Exception e) {
                        log.error("fetch callback data fails, retry!", e);
                    }
                    try {
                        if (callbackData != null && callbackData.size() > 0) {
                            handle(callbackData);
                            context.setRequestId(requestId);
                            postHandle(context);
                            wasteCount = 0;
                            // 如果用户handle爆出exception，则这里不会更新，下次获取到重复的数据，重复推送给handle方法
                            requestId = generateRequestId();
                        } else {
                            ++wasteCount;
                            // 获取不到新数据，则可能没有回调数据，等待一段时间，再重试获取
                            if (wasteCount > WASTE_COUNT_THRESHOLD) {
                                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(LONG_PARK_TIME_MILLS));
                            } else {
                                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(PARK_TIME_MILLS));
                            }
                        }
                    } catch (Exception e) {
                        log.error("handle callback data fails !", e);
                    }
                }
            });
        }
    }

    public void setAntispamRequester(AntispamRequester antispamRequester) {
        this.antispamRequester = antispamRequester;
    }

    public AntispamRequester getAntispamRequester() {
        return antispamRequester;
    }

    public void close() throws InterruptedException {
        isClose = true;
        callbackExecutor.shutdown();
        // 等待一段时间执行完线程中正在执行的现有流程
        if(!callbackExecutor.awaitTermination(10, TimeUnit.SECONDS)){
            callbackExecutor.shutdownNow();
        }
    }

    protected abstract List<T> requestCallback(String businessId, String requestId);

    /**
     * 获取到待回调数据交给业务方处理，现阶段的实现方式，无法保证数据不重复
     *
     * @param callbackData
     */
    public abstract void handle(List<T> callbackData);

    /**
     * 用于handle业务处理完成后做一些事情
     */
    protected void postHandle(CallbackContext context){
        // do nothing
    }

    protected String generateRequestId(){
        return UUIDUtils.randomUUID();
    }
}
