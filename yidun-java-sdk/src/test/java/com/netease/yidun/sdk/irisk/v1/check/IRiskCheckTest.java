package com.netease.yidun.sdk.irisk.v1.check;

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

public class IRiskCheckTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String token = "12345";
    private static final String ip = "123.123.123.123";
    private static final String registerIp = "124.124.124.124";
    private static final String roleId = "testRole";
    private static final String roleName = "testRoleName";
    private static final String roleServer = "testRoleServer";
    private static final String account = "testAccount";
    private static final String phone = "17612341234";
    private static final String roleLevel = "150";
    private static final String gameVersion = "1.0.2";
    private static final String assetVersion = "0.2.1";
    private static final String activityId = "testId";
    private static final String target = "targetMan";
    private static final String email = "testEmail";
    private static final String extData = "ttttttdddddaaaattttaaaa";
    private static final Long registerTime = 1623036428207L;
    private static final long currentTimeMillis = 1623036428207L;

    private static final String expectedRequestBody = "" +
            "registerIp=" + registerIp +
            "&roleServer=" + roleServer +
            "&registerTime=" + registerTime +
            "&signature=d8e06231caf24dc92b04973d98c9e40e" +
            "&roleId=" + roleId +
            "&ip=" + ip +
            "&businessId=" + businessId +
            "&secretId=" + secretId +
            "&version=400" +
            "&nonce=" + nonce +
            "&token=" + token +
            "&target=" + target +
            "&activityId=" + activityId +
            "&phone=" + phone +
            "&extData=" + extData +
            "&assetVersion=" + assetVersion +
            "&roleName=" + roleName +
            "&gameVersion=" + gameVersion +
            "&roleLevel=" + roleLevel +
            "&account=" + account +
            "&email=" + email +
            "&timestamp=" + currentTimeMillis;

    private static final String responseBody = "{\n" +
            "    \"code\":200,\n" +
            "    \"msg\":\"ok!\",\n" +
            "    \"data\":{\n" +
            "        \"riskLevel\":10,\n" +
            "        \"hitInfos\":[\n" +
            "            {\n" +
            "                \"type\":\"...\",\n" +
            "                \"name\":\"xx风险-xxx-xxx\",\n" +
            "                \"desc\":\"...\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"type\":\"...\",\n" +
            "                \"name\":\"xx风险-xxx-xxx\",\n" +
            "                \"desc\":\"...\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"taskId\":\"b0bcmo3aa617x1n62tlhtragdd009wyr\",\n" +
            "        \"sdkRespData\":\"...\",\n" +
            "        \"deviceId\":\"389xfu028f2083u230fuc2\"\n" +
            "    },\n" +
            "    \"ok\":true\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("ir-open.dun.163.com")
                        .post("/v5/risk/check")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void iRiskCheckTest() {
        IRiskCheckRequest request = new IRiskCheckRequest(businessId);
        request.setToken(token);
        request.setIp(ip);
        request.setRoleId(roleId);
        request.setRoleName(roleName);
        request.setRoleServer(roleServer);
        request.setAccount(account);
        request.setPhone(phone);
        request.setActivityId(activityId);
        request.setTarget(target);
        request.setEmail(email);
        request.setRegisterTime(registerTime);
        request.setRegisterIp(registerIp);
        request.setRoleLevel(roleLevel);
        request.setGameVersion(gameVersion);
        request.setAssetVersion(assetVersion);
        request.setExtData(extData);

        request.timestamp(currentTimeMillis)
                .nonce(nonce)
                .protocol(ProtocolEnum.HTTP);

        IRiskCheckResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        IRiskCheckResult result = response.getData();
        assertEquals("b0bcmo3aa617x1n62tlhtragdd009wyr", result.getTaskId());
        assertEquals(2, result.getHitInfos().size());
        assertEquals(String.valueOf(10), String.valueOf(result.getRiskLevel()));
        assertEquals("389xfu028f2083u230fuc2", result.getDeviceId());
        assertEquals("...", result.getSdkRespData());
    }

}