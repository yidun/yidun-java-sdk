package com.netease.yidun.sdk.core.http;

import org.apache.hc.client5.http.DnsResolver;
import org.apache.hc.client5.http.SystemDefaultDnsResolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 支持DNS缓存的DNS解析器
 * <p>
 * 允许将特定域名映射到指定的IP地址，从而绕过DNS解析，加速请求。
 * DNS缓存配置在初始化后不可变，适用于域名IP固定或变更频率低的场景。
 * </p>
 */
public class DnsCacheResolver implements DnsResolver {

    private final Map<String, String> dnsCache;

    /**
     * 创建DNS缓存解析器
     * <p>
     * 不使用DNS缓存，所有域名都将使用系统DNS解析
     * </p>
     */
    public DnsCacheResolver() {
        this.dnsCache = Collections.emptyMap();
    }

    /**
     * 创建DNS缓存解析器并初始化DNS缓存映射
     * <p>
     * DNS缓存配置在初始化后不可变。如果需要更新DNS映射，需要重新创建HttpClient。
     * </p>
     *
     * @param dnsCache 域名到IP的映射Map，传入null或空map表示不使用DNS缓存
     */
    public DnsCacheResolver(Map<String, String> dnsCache) {
        this.dnsCache = (dnsCache != null && !dnsCache.isEmpty())
                ? Collections.unmodifiableMap(new HashMap<>(dnsCache))
                : Collections.emptyMap();
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
        // 如果命中DNS缓存，返回原始域名（而不是IP地址）
        // 这样更符合"规范主机名"的语义，且与高层协议（HTTP、TLS等）兼容
        String ip = dnsCache.get(host);
        if (ip != null) {
            return host;  // ✅ 返回原始域名，如 "as.dun.163.com"
        }

        // 未命中缓存，使用系统DNS解析
        return SystemDefaultDnsResolver.INSTANCE.resolveCanonicalHostname(host);
    }

    /**
     * 获取所有DNS缓存映射（只读）
     * <p>
     * 返回的Map是不可变的，不支持修改操作
     * </p>
     *
     * @return 不可修改的DNS缓存映射视图
     */
    public Map<String, String> getAll() {
        return dnsCache;
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
