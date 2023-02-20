package com.netease.yidun.sdk.irisk.v1.mediacheck;

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

public class IRiskMediaCheckTest {
    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String ip = "123.123.123.123";
    private static final String mediaData = "tesetdatatatasldksglkjklljlkglkslk123lkjlgkalskdglk";
    private static final String mediaName = "xxx.jpg";
    private static final String roleId = "testRoleId";

    private static final String roleName = "testRoleName";
    private static final String roleServer = "testRoleServer";
    private static final long currentTimeMillis = 1623036428207L;

    private static final String taskId = "b0bcmo3aa617x1n62tlhtragdd009wyr";

    private static final String expectedRequestBody =
            "{\"roleServer\":\"" + roleServer + "\"," +
                    "\"mediaData\":\"" + mediaData + "\"," +
                    "\"signature\":\"bf887e3beb468185aaf85f94cc9ee763\"," +
                    "\"roleId\":\"" + roleId + "\"," +
                    "\"ip\":\"" + ip + "\"," +
                    "\"businessId\":\"" + businessId + "\"," +
                    "\"roleName\":\"" + roleName + "\"," +
                    "\"secretId\":\"" + secretId + "\"," +
                    "\"version\":\"400\"," +
                    "\"nonce\":\"" + nonce + "\"," +
                    "\"mediaName\":\"" + mediaName + "\"," +
                    "\"timestamp\":\"" + currentTimeMillis + "\"}";

    private static final String responseBody = "{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"ok!\",\n" +
            "    \"data\": {\n" +
            "        \"taskId\":\"" + taskId + "\"\n" +
            "  \t},\n" +
            "    \"ok\":true\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("ir-open.dun.163.com")
                        .post("/v5/risk/mediaCheck")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void iRiskGetConfigTest() {
        IRiskMediaCheckRequest request = new IRiskMediaCheckRequest(businessId);
        request.setRoleServer(roleServer);
        request.setIp(ip);
        request.setMediaData(mediaData);
        request.setMediaName(mediaName);
        request.setRoleId(roleId);
        request.setRoleName(roleName);

        request.timestamp(currentTimeMillis)
                .nonce(nonce)
                .protocol(ProtocolEnum.HTTP);

        IRiskMediaCheckResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        IRiskMediaCheckResult result = response.getData();
        assertEquals(taskId, result.getTaskId());
    }
}