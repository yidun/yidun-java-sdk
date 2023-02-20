package com.netease.yidun.sdk.irisk.v1.detail;

import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.junit.Assert.assertEquals;

public class IRiskDetailTest {
    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String ip = "123.123.123.123";
    private static final String account = "testAccount";
    private static final String configData = "b0bcmo3aa617x1n62tlhtragdd009wyr";
    private static final String sdkData = "flkjlk135lknlnfanj23knnlknl23n5bl6j";
    private static final Integer riskLevel = 1;
    private static final String appVersion = "1.0.2";
    private static final String packageName = "com.aaa.bbb";

    private static final String matchRules = "R20220929143720059;R20220929110507299;R20220929112305870";
    private static final String roleId = "yyyyyyy";
    private static final String startFlag = "test";
    private static final long currentTimeMillis = 1623036428207L;
    private static final long beginTime = 1667959831798L;
    private static final long endTime = 1667959915103L;
    private static final String expectedRequestBody =
            "{\"startFlag\":\"" + startFlag + "\"," +
                    "\"appVersion\":\"" + appVersion + "\"," +
                    "\"riskLevel\":\"" + riskLevel + "\"," +
                    "\"beginTimestamp\":\"" + beginTime + "\"," +
                    "\"signature\":\"d351e7f59714844e62746c9eb4a93ea0\"," +
                    "\"roleId\":\"" + roleId + "\"," +
                    "\"ip\":\"" + ip + "\"," +
                    "\"businessId\":\"" + businessId + "\"," +
                    "\"secretId\":\"" + secretId + "\"," +
                    "\"version\":\"400\"," +
                    "\"nonce\":\"" + nonce + "\"," +
                    "\"packageName\":\"" + packageName + "\"," +
                    "\"endTimestamp\":\"" + endTime + "\"," +
                    "\"account\":\"" + account + "\"," +
                    "\"timestamp\":\"" + currentTimeMillis + "\"}";

    private static final String responseBody = "{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"ok!\",\n" +
            "    \"data\": {\n" +
            "        \"size\": 100,\n" +
            "        \"startFlag\": \"\",\n" +
            "        \"detail\": [\n" +
            "            {\n" +
            "                \"roleServer\": \"xxxx\",\n" +
            "                \"appVersion\": \"2.1.1\",\n" +
            "                \"riskLevel\": \"高风险\",\n" +
            "                \"matchedRules\": \"" + matchRules + "\",\n" +
            "                \"deviceOs\": \"IOS\",\n" +
            "                \"deviceId\": \"CAhLczArTdNFSlQBUQaQSjg3eyndeBft\",\n" +
            "                \"osVersion\": \"11.0\",\n" +
            "                \"model\": \"iPhone 12\",\n" +
            "                \"roleLevel\": \"\",\n" +
            "                \"packageName\": \"com.aaa.bbb\",\n" +
            "                \"networkType\": \"2G\",\n" +
            "                \"deviceType\": \"模拟器\",\n" +
            "                \"signHash\": \"2022a0b1ccddeeffa0b1ccdd99bb9977\",\n" +
            "                \"roleId\": \"RoT-1025788773\",\n" +
            "                \"appName\": \"appName001\",\n" +
            "                \"execAction\": \"放行\",\n" +
            "                \"ip\": \"115.236.119.140\",\n" +
            "                \"sessionId\": \"sessionId001\",\n" +
            "                \"token\": \"rMc6A1zRxhFEDFRQAQKVXsA+utHq5o3l\",\n" +
            "                \"emulatorDid\": \"\",\n" +
            "                \"receiveTime\": \"2022-09-29 14:39:45\",\n" +
            "                \"matchedRiskTags\": \"环境风险-模拟器-通用模拟器;环境风险-云真机-云真机设备;外挂风险-加速挂-烧饼加速器\",\n" +
            "                \"localFeatureVersion\": \"99\",\n" +
            "                \"assetVersion\": \"0.1.1\",\n" +
            "                \"roleName\": \"rolename9\",\n" +
            "                \"gameVersion\": \"1.0.1\",\n" +
            "                \"signMd5\": \"adffdgsdfgsfdhgdsfgh\",\n" +
            "                \"sdkVersion\": \"1.1.3\",\n" +
            "                \"location\": \"中国-浙江-杭州\",\n" +
            "                \"account\": \"roleaccount887142103\",\n" +
            "                \"currentOnlineTime\": \"10h 13min 9s\"\n" +
            "            }\n" +
            "        ]\n" +
            "  },\n" +
            "  \"ok\":true\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("ir-open.dun.163.com")
                        .post("/v5/risk/detail")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void iRiskGetDetailTest() {
        IRiskDetailRequest request = new IRiskDetailRequest(businessId);
        request.setIp(ip);
        request.setAccount(account);
        request.setRiskLevel(riskLevel);
        request.setAppVersion(appVersion);
        request.setBeginTimestamp(beginTime);
        request.setEndTimestamp(endTime);
        request.setPackageName(packageName);
        request.setRoleId(roleId);
        request.setStartFlag(startFlag);

        request.timestamp(currentTimeMillis)
                .nonce(nonce)
                .protocol(ProtocolEnum.HTTP);

        IRiskDetailResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        IRiskDetailResult result = response.getData();
        assertEquals(String.valueOf(100), String.valueOf(result.getSize()));
        assertEquals("", result.getStartFlag());
        assertEquals(matchRules, result.getDetail().get(0).getMatchedRules());
    }
}