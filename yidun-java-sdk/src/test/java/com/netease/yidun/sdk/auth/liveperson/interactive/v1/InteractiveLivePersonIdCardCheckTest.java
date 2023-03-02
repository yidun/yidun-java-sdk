package com.netease.yidun.sdk.auth.liveperson.interactive.v1;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1.InteractiveLivePersonIdCardCheckRequest;
import com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1.InteractiveLivePersonIdCardCheckResponse;
import com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1.InteractiveLivePersonIdCardCheckResult;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.utils.UrlUtils;

import io.specto.hoverfly.junit.rule.HoverflyRule;

public class InteractiveLivePersonIdCardCheckTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final Boolean needAvatar = true;
    private static final String dataId = "123456";
    private static final PicType picType = PicType.URL;
    private static final String token = "1234678979";
    private static final String name = "张三";
    private static final String cardNo = "111234120001011236";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final long currentTimeMillis = 1623036428207L;
    private static final String requestId = "bf7d3414792144738312f6a14034a62c";
    private static final String expectedRequestBody = "" +
            "needAvatar=" + needAvatar +
            "&dataId=" + dataId +
            "&picType=" + picType.getType() +
            "&signature=bec34e7ec8df2aa3c77c473b192603bc" +
            "&businessId=" + businessId +
            "&name=" + UrlUtils.encode(name) +
            "&secretId=" + secretId +
            "&cardNo=" + cardNo +
            "&version=v1" +
            "&nonce=" + nonce +
            "&token=" + token +
            "&timestamp=" + currentTimeMillis;
    private static final String responseBody = "{" +
            "  \"code\":200," +
            "  \"msg\":\"ok\"," +
            "  \"result\":{" +
            "    \"status\":1," +
            "    \"faceMatched\":1," +
            "    \"picType\":1," +
            "    \"reasonType\":1," +
            "    \"avatar\":\"https://test.com\"," +
            "    \"similarityScore\":0.88," +
            "    \"actionImages\":[{\"action\":\"1\",\"image\":\"https://test.com\"}]," +
            "    \"taskId\":\"" + requestId + "\"" +
            "  }" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("verify.dun.163.com")
                        .post("/v1/liveperson/audit")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void interactiveLivePersonIdCardCheckTest() {
        InteractiveLivePersonIdCardCheckRequest request = new InteractiveLivePersonIdCardCheckRequest(businessId)
                .cardNo(cardNo)
                .dataId(dataId)
                .name(name)
                .needAvatar(needAvatar)
                .picType(picType)
                .token(token);

        request.timestamp(currentTimeMillis)
                .nonce(nonce)
                .protocol(ProtocolEnum.HTTP);

        InteractiveLivePersonIdCardCheckResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        InteractiveLivePersonIdCardCheckResult result = response.getResult();
        assertEquals(Integer.valueOf(1), result.getStatus());
        assertEquals(Integer.valueOf(1), result.getReasonType());
        assertEquals(Integer.valueOf(1), result.getFaceMatched());
        assertEquals(Integer.valueOf(1), result.getPicType());
        assertEquals(Double.valueOf(0.88), result.getSimilarityScore());
        assertEquals("1", result.getActionImages().get(0).getAction());
        assertEquals("https://test.com", result.getActionImages().get(0).getImage());
        assertEquals("https://test.com", result.getAvatar());
        assertEquals(requestId, result.getTaskId());
    }
}
