package com.netease.yidun.sdk.profile.v1.userquery;

import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.junit.Assert.assertEquals;

public class ProfileUserQueryTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String account = "testAccount";

    private static final String taskId = "edf9b0cd14a44edc9f25b996dfdca5bd";
    private static final long currentTimeMillis = 1623036428207L;

    private static final String expectedRequestBody = "signature=31ede23c0d73ee3ca686a26e06ccb334" +
            "&businessId=" + businessId +
            "&secretId=" + secretId +
            "&accounts=%5B%22testAccount%22%5D" +
            "&version=v1" +
            "&nonce=" + nonce +
            "&timestamp=" + currentTimeMillis;

    private static final String responseBody = "{\n" +
            "     \"code\": 200,\n" +
            "     \"msg\": \"成功\",\n" +
            "     \"data\": {\n" +
            "          \"riskDetails\": [\n" +
            "               {\n" +
            "                    \"riskInfoList\": [],\n" +
            "                    \"account\": \"testAccount\"\n" +
            "               }\n" +
            "          ],\n" +
            "          \"success\": true,\n" +
            "          \"taskId\": \"" + taskId + "\"\n" +
            "     }\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("rp.dun.163.com")
                        .post("/v1/profile/user/multiple/query")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void ProfileUserQueryTest() {
        ProfileUserQueryRequest request = new ProfileUserQueryRequest(businessId);
        List<String> accounts = new ArrayList<>();
        accounts.add(account);
        request.setAccounts(accounts);
        request.protocol(ProtocolEnum.HTTP);
        request.setNonce(nonce);
        request.setTimestamp(currentTimeMillis);

        ProfileUserQueryResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        ProfileUserQueryResult data = response.getData();

        assertEquals(true, data.getSuccess());
        assertEquals(1, data.getRiskDetails().size());
        assertEquals(taskId, data.getTaskId());
    }


}