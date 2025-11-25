package com.netease.yidun.sdk;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.http.DnsCacheResolver;
import com.netease.yidun.sdk.core.http.HttpClientConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * DNS缓存配置演示
 * 通过配置域名到IP的映射，可以绕过DNS解析，加速请求响应
 * <p>
 * 支持两种模式：
 * 1. 静态配置模式：初始化时配置，运行时不可修改
 * 2. 动态更新模式：支持运行时动态添加、删除和更新DNS映射
 * </p>
 */
public class DnsCacheDemo {

    /**
     * 创建带有DNS缓存的AntispamRequester（静态配置模式）
     *
     * @param secretId  产品密钥ID
     * @param secretKey 产品私有密钥
     * @return 配置了DNS缓存的AntispamRequester
     */
    public static AntispamRequester createAntispamRequesterWithDnsCache(String secretId, String secretKey) {
        // 创建HTTP客户端配置
        HttpClientConfig httpClientConfig = new HttpClientConfig();

        // 配置DNS缓存，将域名映射到指定的IP地址
        // 这样可以绕过DNS解析，直接连接到指定的IP，从而减少DNS耗时，加速请求
        Map<String, String> dnsCache = new HashMap<>();

        // 示例：配置内容安全API的域名到IP映射
        // 实际使用时，请替换成真实的IP地址
        dnsCache.put("as.dun.163.com", "110.110.110.110");
        dnsCache.put("as.dun.163yun.com", "120.120.120.120");

        // 示例：配置短信服务API的域名到IP映射
        dnsCache.put("sms.dun.163.com", "130.130.130.130");
        dnsCache.put("sms.dun.163yun.com", "140.140.140.140");

        // 示例：配置智能风控API的域名到IP映射
        dnsCache.put("ac.dun.163.com", "150.150.150.150");
        dnsCache.put("ac.dun.163yun.com", "160.160.160.160");

        // 应用DNS缓存配置
        httpClientConfig.dnsCache(dnsCache);

        // 创建客户端配置
        ClientProfile clientProfile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        clientProfile.setHttpClientConfig(httpClientConfig);

        // 创建AntispamRequester实例
        AntispamRequester antispamRequester = AntispamRequester.getInstance(clientProfile);

        return antispamRequester;
    }

    /**
     * 使用场景一：从配置中心动态加载DNS映射
     */
    public static void loadDnsCacheFromConfigCenter(DnsCacheResolver dnsResolver) {
        // 假设从Nacos、Apollo等配置中心获取DNS配置
        Map<String, String> dnsFromConfigCenter = new HashMap<>();
        dnsFromConfigCenter.put("as.dun.163.com", "110.110.110.110");
        dnsFromConfigCenter.put("as.dun.163yun.com", "120.120.120.120");

        // 批量更新DNS缓存
        dnsResolver.putAll(dnsFromConfigCenter);
    }

    /**
     * 使用场景二：动态切换流量（蓝绿发布、灰度发布）
     */
    public static void switchTraffic(DnsCacheResolver dnsResolver, String newIp) {
        // 将流量切换到新的服务器IP
        dnsResolver.put("as.dun.163.com", newIp);

        // 可以逐步切流：通过更新缓存中的IP地址
        // 例如：从110.110.110.110切换到120.120.120.120
    }

    /**
     * 使用场景三：故障转移
     */
    public static void failover(DnsCacheResolver dnsResolver) {
        // 检测到主IP故障，切换到备用IP
        String primaryIp = dnsResolver.get("as.dun.163.com");
        if (isUnhealthy(primaryIp)) { // 假设的健康检查逻辑
            // 切换到备用IP
            dnsResolver.put("as.dun.163.com", "192.168.1.100");
        }
    }

    private static boolean isUnhealthy(String ip) {
        // 实现健康检查逻辑
        return false;
    }

    /**
     * 显示当前DNS缓存状态
     */
    public static void printDnsCacheStatus(DnsCacheResolver dnsResolver) {
        System.out.println("DNS缓存大小: " + dnsResolver.size());
        System.out.println("DNS缓存内容: " + dnsResolver.getAll());
    }

    /**
     * 使用场景四：使用配置中心获取DNS配置并初始化
     */
    public static ClientProfile createProfileWithDynamicDnsCache(String secretId, String secretKey) {
        ClientProfile clientProfile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));

        // 从环境变量、配置中心获取DNS配置
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("as.dun.163.com", System.getenv("AS_DUN_IP"));

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.dnsCache(dnsCache);
        clientProfile.setHttpClientConfig(httpClientConfig);

        return clientProfile;
    }

    /**
     * 包装类：包含AntispamRequester和DnsCacheResolver
     */
    public static class AntispamRequesterWithDns {
        public final AntispamRequester requester;
        public final DnsCacheResolver dnsResolver;

        public AntispamRequesterWithDns(AntispamRequester requester, DnsCacheResolver dnsResolver) {
            this.requester = requester;
            this.dnsResolver = dnsResolver;
        }
    }

    /**
     * 使用场景说明：
     *
     * 1. 性能优化：在高并发场景下，DNS解析可能成为性能瓶颈。
     *    通过配置DNS缓存，可以消除DNS查询延迟，提升请求响应速度
     *
     * 2. DNS故障恢复：当DNS服务器出现故障时，可以通过配置固定的IP地址
     *    来绕过DNS解析，保证服务的可用性
     *
     * 3. 测试环境：在测试环境中，可能需要将域名指向特定的测试服务器IP
     *
     * 4. 多活容灾：在多活部署场景中，可以将域名映射到不同机房的IP地址，
     *    实现流量调度和容灾切换
     *
     * 5. 动态容灾：支持运行时动态切换IP，无需重启应用
     *
     * 6. 配置中心集成：可以从Nacos、Apollo等配置中心动态加载DNS配置
     */
}
