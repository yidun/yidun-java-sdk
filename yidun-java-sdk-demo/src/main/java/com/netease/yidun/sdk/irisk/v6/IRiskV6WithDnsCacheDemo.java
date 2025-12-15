package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Request;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;
import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * IRiskV6Client 使用示例 - 配置DNS缓存
 * <p>
 * 本示例演示如何使用 IRiskV6Client 调用智能风控在线检测接口，
 * 并通过配置DNS缓存来加速请求，绕过DNS解析。
 * </p>
 */
public class IRiskV6WithDnsCacheDemo {

    private static final String YOUR_SECRET_ID = "e6dc277ccccb2dad0a1ecfd08d46eeab";
    private static final String YOUR_SECRET_KEY = "57680aef84db35652ec73e3f6924e82b";
    private static final String YOUR_BUSINESS_ID = "69f553c6fe2e3b54b18e8c35a0b097f1";

    /**
     * 示例1：基本使用 - 配置DNS缓存并调用风控检测接口
     */
    public static void basicUsage(String secretId, String secretKey) {
        System.out.println("========== 示例1：基本使用 ==========");

        // 步骤1：配置DNS缓存，将风控API域名映射到指定IP
        // 这样可以绕过DNS解析，加速请求响应
        Map<String, String> dnsCache = new HashMap<>();
        // 实际使用时，请替换为真实的IP地址
        dnsCache.put("ir-open-usva.dun.163.com", "170.106.34.73");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.dnsCache(dnsCache);

        // 步骤2：创建客户端配置
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .httpClientConfig(httpClientConfig);

        // 步骤3：创建 IRiskV6Client
        IRiskV6Client iriskClient = new IRiskV6Client(profile);

        // 步骤4：构建风控检测请求（以V600版本为例）
        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
        request.setDomain("ir-open-usva.dun.163.com");

        // 设置必填参数
        request.setIp("123.45.67.89");              // 用户IP地址
        request.setRoleId("player_12345");          // 用户角色ID
        request.setAccount("account_12345");        // 用户账号

        // 设置可选参数
        request.setServer("server-1");              // 服务器名称
        request.setNickname("玩家昵称");            // 用户昵称
        request.setPhone("13812345678");           // 手机号
        request.setActivityId("login");            // 活动场景：登录
        request.setLevel("50");                    // 用户等级

        // 步骤5：调用风控检测接口
        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);

        // 步骤6：处理响应结果
        if (response != null && response.getCode() == 200) {
            IRiskCheckV600Result<HitInfo> result = response.getData();
            System.out.println("请求成功！");
            System.out.println("风险等级: " + result.getRiskLevel());
            System.out.println("任务ID: " + result.getTaskId());
            System.out.println("设备ID: " + result.getDeviceId());

            // 输出命中的规则
            if (result.getMatchedRules() != null && !result.getMatchedRules().isEmpty()) {
                System.out.println("命中规则: " + result.getMatchedRules());
            }

            // 输出命中的自定义规则
            if (result.getMatchedCustomRules() != null && !result.getMatchedCustomRules().isEmpty()) {
                System.out.println("命中自定义规则: " + result.getMatchedCustomRules());
            }

            // 输出证据信息
            if (result.getEvidences() != null && !result.getEvidences().isEmpty()) {
                System.out.println("证据信息: " + result.getEvidences());
            }

            // 输出命中标签信息（如果有）
            if (result.getHitInfos() != null && !result.getHitInfos().isEmpty()) {
                System.out.println("命中标签详情:");
                for (HitInfo hitInfo : result.getHitInfos()) {
                    System.out.println("  - 标签类型: " + hitInfo.getType());
                    System.out.println("    标签名称: " + hitInfo.getName());
                    System.out.println("    标签描述: " + hitInfo.getDesc());
                }
            }
        } else {
            System.err.println("请求失败！");
            System.err.println("错误码: " + (response != null ? response.getCode() : "null"));
            System.err.println("错误信息: " + (response != null ? response.getMsg() : "null"));
        }
    }

    /**
     * 不使用DNS缓存的basicUsage版本（用于对比测试）
     */
    public static void basicUsageWithoutCache(String secretId, String secretKey) {
        System.out.println("========== basicUsage（无DNS缓存） ==========");

        // 步骤1：创建客户端配置（不使用DNS缓存）
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);

        // 步骤2：创建 IRiskV6Client
        IRiskV6Client iriskClient = new IRiskV6Client(profile);

        // 步骤3：构建风控检测请求（以V600版本为例）
        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        request.setDomain("ir-open-usva.dun.163.com");

        // 设置必填参数
        request.setIp("123.45.67.89");              // 用户IP地址
        request.setRoleId("player_12345");          // 用户角色ID
        request.setAccount("account_12345");        // 用户账号

        // 设置可选参数
        request.setServer("server-1");              // 服务器名称
        request.setNickname("玩家昵称");            // 用户昵称
        request.setPhone("13812345678");           // 手机号
        request.setActivityId("login");            // 活动场景：登录
        request.setLevel("50");                    // 用户等级

        // 步骤4：调用风控检测接口
        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);

        // 步骤5：处理响应结果
        if (response != null && response.getCode() == 200) {
            IRiskCheckV600Result<HitInfo> result = response.getData();
            System.out.println("请求成功！");
            System.out.println("风险等级: " + result.getRiskLevel());
            System.out.println("任务ID: " + result.getTaskId());
            System.out.println("设备ID: " + result.getDeviceId());

            // 输出命中的规则
            if (result.getMatchedRules() != null && !result.getMatchedRules().isEmpty()) {
                System.out.println("命中规则: " + result.getMatchedRules());
            }

            // 输出命中的自定义规则
            if (result.getMatchedCustomRules() != null && !result.getMatchedCustomRules().isEmpty()) {
                System.out.println("命中自定义规则: " + result.getMatchedCustomRules());
            }

            // 输出证据信息
            if (result.getEvidences() != null && !result.getEvidences().isEmpty()) {
                System.out.println("证据信息: " + result.getEvidences());
            }

            // 输出命中标签信息（如果有）
            if (result.getHitInfos() != null && !result.getHitInfos().isEmpty()) {
                System.out.println("命中标签详情:");
                for (HitInfo hitInfo : result.getHitInfos()) {
                    System.out.println("  - 标签类型: " + hitInfo.getType());
                    System.out.println("    标签名称: " + hitInfo.getName());
                    System.out.println("    标签描述: " + hitInfo.getDesc());
                }
            }
        } else {
            System.err.println("请求失败！");
            System.err.println("错误码: " + (response != null ? response.getCode() : "null"));
            System.err.println("错误信息: " + (response != null ? response.getMsg() : "null"));
        }
    }

    /**
     * 示例2：多场景使用 - 不同业务场景的DNS缓存配置
     */
    public static void multiScenarios(String secretId, String secretKey) {
        System.out.println("\n========== 示例2：多场景使用 ==========");

        // 登录场景
        loginCheck(secretId, secretKey);

        // 注册场景
        registerCheck(secretId, secretKey);

        // 支付场景
        paymentCheck(secretId, secretKey);
    }

    /**
     * 登录场景检测
     */
    public static void loginCheck(String secretId, String secretKey) {
        System.out.println("\n--- 登录场景风控检测 ---");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("irisk.dun.163.com", "110.110.110.110");
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey)
                                             .httpClientConfig(httpClientConfig);
        IRiskV6Client iriskClient = new IRiskV6Client(profile);

        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        request.setIp("192.168.1.100");
        request.setRoleId("user_001");
        request.setAccount("user_login_account");
        request.setActivityId("login");  // 登录场景
        request.setExtData("{\"loginType\":\"password\"}");

        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);
        printResult(response);
    }

    /**
     * 注册场景检测
     */
    public static void registerCheck(String secretId, String secretKey) {
        System.out.println("\n--- 注册场景风控检测 ---");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("irisk.dun.163.com", "110.110.110.110");
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey)
                                             .httpClientConfig(httpClientConfig);
        IRiskV6Client iriskClient = new IRiskV6Client(profile);

        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        request.setIp("192.168.1.101");
        request.setRoleId("new_user_001");
        request.setAccount("new_account");
        request.setActivityId("register");  // 注册场景
        request.setPhone("13912345678");
        request.setRegisterIp("192.168.1.101");
        request.setRegisterTime(System.currentTimeMillis());

        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);
        printResult(response);
    }

    /**
     * 支付场景检测
     */
    public static void paymentCheck(String secretId, String secretKey) {
        System.out.println("\n--- 支付场景风控检测 ---");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("irisk.dun.163.com", "110.110.110.110");
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey)
                                             .httpClientConfig(httpClientConfig);
        IRiskV6Client iriskClient = new IRiskV6Client(profile);

        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        request.setIp("192.168.1.102");
        request.setRoleId("player_12345");
        request.setAccount("pay_account");
        request.setActivityId("payment");  // 支付场景
        request.setLevel("30");
        request.setExtData("{\"amount\":100,\"currency\":\"CNY\",\"payMethod\":\"wechat\"}");

        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);
        printResult(response);
    }

    /**
     * 示例3：动态更新DNS缓存 - 运行时修改DNS映射
     */
    public static void dynamicDnsCacheUpdate(String secretId, String secretKey) {
        System.out.println("\n========== 示例3：动态更新DNS缓存 ==========");

        // 初始配置DNS缓存
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("irisk.dun.163.com", "110.110.110.110");

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey)
                                             .httpClientConfig(httpClientConfig);

        // 创建自定义的 DefaultClient，以便获取 DnsCacheResolver
        DefaultClient defaultClient = new DefaultClient(profile);
        IRiskV6Client iriskClient = new IRiskV6Client(defaultClient);

        // 执行第一次请求（使用初始IP）
        System.out.println("\n--- 第一次请求（使用初始DNS配置） ---");
        IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
        request.setIp("192.168.1.100");
        request.setRoleId("user_001");
        request.setAccount("account_001");
        DataResponse<IRiskCheckV600Result<HitInfo>> response = iriskClient.check(request);
        printResult(response);

        // 模拟：从配置中心获取新的DNS配置（例如：故障切换到备用IP）
        System.out.println("\n--- 更新DNS缓存（模拟故障切换到备用IP） ---");
        Map<String, String> updatedDnsCache = new HashMap<>();
        updatedDnsCache.put("irisk.dun.163.com", "192.168.200.100");  // 切换到新的IP

        // 注意：这里的更新逻辑需要获取到 DnsCacheResolver 实例
        // 在实际应用中，可以通过以下方式获取：
        // DnsCacheResolver dnsResolver = ... // 从配置中心或管理接口获取
        // dnsResolver.putAll(updatedDnsCache);

        System.out.println("DNS缓存已更新，后续请求将使用新的IP地址");
    }

    /**
     * 打印响应结果
     */
    public static void printResult(DataResponse<IRiskCheckV600Result<HitInfo>> response) {
        if (response == null) {
            System.err.println("响应为空！");
            return;
        }

        if (response.getCode() == 200) {
            IRiskCheckV600Result<HitInfo> result = response.getData();
            System.out.println("✓ 请求成功");
            System.out.println("  - 风险等级: " + result.getRiskLevel());
            System.out.println("  - 任务ID: " + result.getTaskId());

            if (result.getMatchedRules() != null && !result.getMatchedRules().isEmpty()) {
                System.out.println("  - 命中规则: " + result.getMatchedRules());
            }
        } else {
            System.err.println("✗ 请求失败");
            System.err.println("  错误码: " + response.getCode());
            System.err.println("  错误信息: " + response.getMsg());
        }
    }

    /**
     * 示例4：性能测试 - 对比使用DNS缓存前后的性能差异
     */
    public static void performanceComparison(String secretId, String secretKey) {
        System.out.println("\n========== 示例4：性能测试 ==========");

        // 不使用DNS缓存
        System.out.println("\n--- 测试1：不使用DNS缓存（使用系统DNS解析） ---");
        ClientProfile profile1 = ClientProfile.defaultProfile(secretId, secretKey);
        IRiskV6Client client1 = new IRiskV6Client(profile1);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
            request.setIp("192.168.1.10" + i);
            request.setRoleId("test_user_" + i);
            request.setAccount("test_account_" + i);
            client1.check(request);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("10次请求耗时: " + (end1 - start1) + "ms");

        // 使用DNS缓存
        System.out.println("\n--- 测试2：使用DNS缓存（绕过DNS解析） ---");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        Map<String, String> dnsCache = new HashMap<>();
        dnsCache.put("irisk.dun.163.com", "110.110.110.110");
        httpClientConfig.dnsCache(dnsCache);

        ClientProfile profile2 = ClientProfile.defaultProfile(secretId, secretKey)
                                              .httpClientConfig(httpClientConfig);
        IRiskV6Client client2 = new IRiskV6Client(profile2);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            IRiskCheckV600Request request = new IRiskCheckV600Request(YOUR_BUSINESS_ID);
            request.setIp("192.168.1.10" + i);
            request.setRoleId("test_user_" + i);
            request.setAccount("test_account_" + i);
            client2.check(request);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("10次请求耗时: " + (end2 - start2) + "ms");
        System.out.println("\n注意：在高并发场景下，DNS缓存的性能优势会更加明显！");
    }

    /**
     * 示例5：basicUsage对比验证 - 测试DNS缓存对响应时间的影响
     */
    public static void basicUsagePerformanceComparison() {
        System.out.println("\n========== 示例5：basicUsage对比验证 ==========");

        // 测试2：使用DNS缓存
        System.out.println("\n--- 测试2：使用DNS缓存（绕过DNS解析） ---");
        long startWithCache = System.currentTimeMillis();
        basicUsage(YOUR_SECRET_ID, YOUR_SECRET_KEY);
        long endWithCache = System.currentTimeMillis();
        long timeWithCache = endWithCache - startWithCache;
        System.out.println("总耗时: " + timeWithCache + "ms");

        // 测试1：不使用DNS缓存
        System.out.println("\n--- 测试1：不使用DNS缓存（系统DNS解析） ---");
        long startWithoutCache = System.currentTimeMillis();
        basicUsageWithoutCache(YOUR_SECRET_ID, YOUR_SECRET_KEY);
        long endWithoutCache = System.currentTimeMillis();
        long timeWithoutCache = endWithoutCache - startWithoutCache;
        System.out.println("总耗时: " + timeWithoutCache + "ms");

        // 性能对比分析
        System.out.println("\n========== 性能对比分析 ==========");
        System.out.println("不使用缓存: " + timeWithoutCache + "ms");
        System.out.println("使用缓存: " + timeWithCache + "ms");
        if (timeWithoutCache > 0) {
            double improvement = ((double) (timeWithoutCache - timeWithCache) / timeWithoutCache) * 100;
            System.out.printf("性能提升: %.2f%%\n", improvement);
        }
        System.out.println("\n说明：DNS缓存减少了DNS解析时间，降低了RT延迟");
    }

    /**
     * 主方法 - 运行所有示例
     */
    public static void main(String[] args) {
        // 注意：请替换为你的真实密钥（修改下面的静态常量）

        // 示例1：基本使用（使用DNS缓存）
        //basicUsage(YOUR_SECRET_ID, YOUR_SECRET_KEY);

        // 示例2：多场景使用
        //multiScenarios(YOUR_SECRET_ID, YOUR_SECRET_KEY);

        // 示例3：动态DNS缓存更新（演示）
        //dynamicDnsCacheUpdate(YOUR_SECRET_ID, YOUR_SECRET_KEY);

        // 示例4：性能测试（批量请求对比）
        performanceComparison(YOUR_SECRET_ID, YOUR_SECRET_KEY);

        // 示例5：basicUsage对比验证 - 对比使用和不使用DNS缓存的响应时间差异
        basicUsagePerformanceComparison();
    }
}
