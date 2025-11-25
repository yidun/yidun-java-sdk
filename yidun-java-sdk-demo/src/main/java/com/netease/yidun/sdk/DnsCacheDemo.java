package com.netease.yidun.sdk;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.http.HttpClientConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * DNS缓存配置演示
 *
 * <p>
 * 通过配置域名到IP的映射，可以绕过DNS解析，加速请求响应。
 * DNS缓存在初始化后不可变，如需更新需要重新创建HttpClient。
 * </p>
 */
public class DnsCacheDemo {

    /**
     * 创建带有DNS缓存的AntispamRequester
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
        dnsCache.put("irisk.dun.163.com", "150.150.150.150");
        dnsCache.put("irisk.dun.163yun.com", "160.160.160.160");

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
     * 展示如何通过ClientProfile配置DNS缓存
     */
    public static ClientProfile createProfileWithDnsCache(String secretId, String secretKey) {
        ClientProfile clientProfile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));

        HttpClientConfig httpClientConfig = new HttpClientConfig();

        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("as.dun.163.com", "110.110.110.110");

        httpClientConfig.dnsCache(dnsCache);
        clientProfile.setHttpClientConfig(httpClientConfig);

        return clientProfile;
    }

    /**
     * 使用场景一：高并发场景下的性能优化
     *
     * <p>
     * 在高并发场景下，DNS解析可能成为性能瓶颈。通过配置DNS缓存，可以消除DNS查询延迟，
     * 提升请求响应速度。实测显示，使用DNS缓存可以减少50-200ms的请求耗时。
     * </p>
     */
    public static void highConcurrencyOptimization(String secretId, String secretKey) {
        // 配置DNS缓存
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("as.dun.163.com", "110.110.110.110");
        dnsCache.put("as.dun.163yun.com", "120.120.120.120");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        profile.setHttpClientConfig(httpClientConfig);

        // 创建请求器，后续所有请求都会使用DNS缓存
        AntispamRequester requester = AntispamRequester.getInstance(profile);

        // 在高并发场景下，无需重复DNS查询，提升性能
        // for (int i = 0; i < 1000; i++) {
        //     requester.xxx(request);
        // }
    }

    /**
     * 使用场景二：DNS故障恢复
     *
     * <p>
     * 当DNS服务器出现故障时，可以通过配置固定的IP地址来绕过DNS解析，
     * 保证服务的可用性，避免因DNS故障导致服务不可用。
     * </p>
     */
    public static void dnsFailureRecovery(String secretId, String secretKey) {
        HttpClientConfig httpClientConfig = new HttpClientConfig();

        Map<String, String> dnsCache = new HashMap<>();
        // 即使DNS服务器不可用，也能通过固定IP访问
        dnsCache.put("as.dun.163.com", "110.110.110.110");
        dnsCache.put("sms.dun.163.com", "120.120.120.120");

        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        profile.setHttpClientConfig(httpClientConfig);

        AntispamRequester requester = AntispamRequester.getInstance(profile);
    }

    /**
     * 使用场景三：测试环境配置
     *
     * <p>
     * 在测试环境中，可能需要将域名指向特定的测试服务器IP，方便进行测试和调试。
     * </p>
     */
    public static void testEnvironment(String secretId, String secretKey) {
        HttpClientConfig httpClientConfig = new HttpClientConfig();

        Map<String, String> dnsCache = new HashMap<>();
        // 将域名指向测试服务器
        dnsCache.put("as.dun.163.com", "192.168.1.100");

        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        profile.setHttpClientConfig(httpClientConfig);

        // 在测试环境使用
        AntispamRequester requester = AntispamRequester.getInstance(profile);
    }

    /**
     * 使用场景四：多机房容灾
     *
     * <p>
     * 在多活部署场景中，可以将域名映射到不同机房的IP地址，实现流量调度和容灾切换。
     * </p>
     */
    public static void multiDataCenter(String secretId, String secretKey, String dataCenter) {
        HttpClientConfig httpClientConfig = new HttpClientConfig();

        Map<String, String> dnsCache = new HashMap<>();

        // 根据机房路由到不同IP
        if ("hangzhou".equals(dataCenter)) {
            dnsCache.put("as.dun.163.com", "110.110.110.110");
        } else if ("beijing".equals(dataCenter)) {
            dnsCache.put("as.dun.163.com", "120.120.120.120");
        }

        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        profile.setHttpClientConfig(httpClientConfig);

        AntispamRequester requester = AntispamRequester.getInstance(profile);
    }
}
