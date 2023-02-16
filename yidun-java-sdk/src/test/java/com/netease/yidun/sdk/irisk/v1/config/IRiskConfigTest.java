package com.netease.yidun.sdk.irisk.v1.config;

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

public class IRiskConfigTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String ip = "123.123.123.123";

    private static final String configData = "b0bcmo3aa617x1n62tlhtragdd009wyr";
    private static final String sdkData = "flkjlk135lknlnfanj23knnlknl23n5bl6j";
    private static final long currentTimeMillis = 1623036428207L;

    private static final String expectedRequestBody = "" +
            "sdkData=" + sdkData +
            "&signature=325ad64ab03bba3742f7b86de4246ab3" +
            "&ip=" + ip +
            "&businessId=" + businessId +
            "&secretId=" + secretId +
            "&version=400" +
            "&nonce=" + nonce +
            "&timestamp=" + currentTimeMillis;

    private static final String responseBody = "{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"ok!\",\n" +
            "    \"data\": {\n" +
            "        \"configData\": \"" + configData + "\"\n" +
            "    },\n" +
            "    \"ok\":true\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("ir-open.dun.163.com")
                        .post("/v5/risk/getConfig")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void iRiskGetConfigTest() {
        IRiskConfigRequest request = new IRiskConfigRequest(businessId);
        request.setIp(ip);
        request.setSdkData(sdkData);

        request.timestamp(currentTimeMillis)
                .nonce(nonce)
                .protocol(ProtocolEnum.HTTP);

        IRiskConfigResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        IRiskConfigResult result = response.getData();
        assertEquals(configData, result.getConfigData());
    }
}