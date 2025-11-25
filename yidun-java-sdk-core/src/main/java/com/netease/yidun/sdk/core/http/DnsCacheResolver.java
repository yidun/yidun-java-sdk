package com.netease.yidun.sdk.core.http;

import org.apache.hc.client5.http.DnsResolver;
import org.apache.hc.client5.http.SystemDefaultDnsResolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支持DNS缓存的DNS解析器
 * 允许将特定域名映射到指定的IP地址，从而绕过DNS解析，加速请求
 * <p>
 * 支持动态添加、删除和更新DNS缓存映射
 * </p>
 */
public class DnsCacheResolver implements DnsResolver {

    private final Map<String, String> dnsCache;

    /**
     * 创建DNS缓存解析器
     * <p>
     * 创建支持动态更新的DNS缓存解析器，无初始配置
     * </p>
     */
    public DnsCacheResolver() {
        this.dnsCache = new ConcurrentHashMap<>();
    }

    /**
     * 创建DNS缓存解析器并初始化
     * <p>
     * 创建支持动态更新的DNS缓存解析器，并传入初始DNS映射配置
     * 后续可以通过 put/putAll/remove 等方法动态更新DNS映射
     * </p>
     *
     * @param initialCache 初始DNS缓存映射，传入null或空map表示无初始配置
     */
    public DnsCacheResolver(Map<String, String> initialCache) {
        this.dnsCache = new ConcurrentHashMap<>();
        if (initialCache != null && !initialCache.isEmpty()) {
            this.dnsCache.putAll(initialCache);
        }
    }

    @Override
    public InetAddress[] resolve(String host) throws UnknownHostException {
        String ip = dnsCache.get(host);
        if (ip != null) {
            try {
                InetAddress address = InetAddress.getByName(ip);
                return new InetAddress[]{address};
            } catch (UnknownHostException e) {
                return SystemDefaultDnsResolver.INSTANCE.resolve(host);
            }
        }
        return SystemDefaultDnsResolver.INSTANCE.resolve(host);
    }

    @Override
    public String resolveCanonicalHostname(String host) throws UnknownHostException {
        InetAddress[] addresses = resolve(host);
        return addresses[0].getCanonicalHostName();
    }

    /**
     * 添加或更新DNS缓存映射
     *
     * @param host 域名（如：as.dun.163.com）
     * @param ip   IP地址（如：110.110.110.110）
     * @return 之前的IP地址，如果没有则为null
     */
    public String put(String host, String ip) {
        return dnsCache.put(host, ip);
    }

    /**
     * 批量添加DNS缓存映射
     *
     * @param mappings 域名到IP的映射
     */
    public void putAll(Map<String, String> mappings) {
        if (mappings != null && !mappings.isEmpty()) {
            dnsCache.putAll(mappings);
        }
    }

    /**
     * 删除DNS缓存映射
     *
     * @param host 域名
     * @return 被删除的IP地址，如果没有则为null
     */
    public String remove(String host) {
        return dnsCache.remove(host);
    }

    /**
     * 清空所有DNS缓存映射
     */
    public void clear() {
        dnsCache.clear();
    }

    /**
     * 获取所有DNS缓存映射（只读）
     *
     * @return 不可修改的DNS缓存映射视图
     */
    public Map<String, String> getAll() {
        return Collections.unmodifiableMap(dnsCache);
    }

    /**
     * 获取指定域名的IP缓存
     *
     * @param host 域名
     * @return IP地址，如果没有缓存则返回null
     */
    public String get(String host) {
        return dnsCache.get(host);
    }

    /**
     * 获取当前缓存大小
     *
     * @return DNS缓存映射的数量
     */
    public int size() {
        return dnsCache.size();
    }
}
