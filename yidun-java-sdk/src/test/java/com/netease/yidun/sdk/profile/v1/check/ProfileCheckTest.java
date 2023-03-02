package com.netease.yidun.sdk.profile.v1.check;

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

public class ProfileCheckTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String account = "testAccount";
    private static final String content = "testContent";
    private static final String ip = "127.0.0.1";
    private static final String phone = "17312341234";
    private static final String title = "testTitle";
    private static final String receiveUid = "testUid";
    private static final String dataId = "124hk15k1j2h5k1jh2k5j1h5k";
    private static final String token = "5045100d3c80451bbcc848ead630e3e2";

    private static final long publishTime = 1677665115000L;
    private static final long currentTimeMillis = 1623036428207L;

    private static final String expectedRequestBody = "texts=%5B%7B%22account%22%3A%22testAccount%22%2C%22phone%22%3A%2217312341234%22%2C%22receiveUid%22%3A%22testUid%22%2C%22ip%22%3A%22127.0.0.1%22%2C%22dataId%22%3A%22124hk15k1j2h5k1jh2k5j1h5k%22%2C%22content%22%3A%22testContent%22%2C%22title%22%3A%22testTitle%22%2C%22publishTime%22%3A1677665115000%7D%5D" +
            "&signature=d37a49afe1cd6bdb5f9020119db70c30" +
            "&businessId=" + businessId +
            "&secretId=" + secretId +
            "&version=v1" +
            "&nonce=" + nonce +
            "&timestamp=" + currentTimeMillis;

    private static final String responseBody = "{    \n" +
            "\t\"code\": 200,    \n" +
            "\t\"msg\": \"ok\",    \n" +
            "\t\"data\": {\n" +
            "\t\t\"success\": true,\n" +
            "\t\t\"token\": \"" + token + "\"\n" +
            "\t} \n" +
            "}\n";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("rp.dun.163.com")
                        .post("/v1/profile/user/async/check")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }

    @Test
    public void ProfileCheckTest() {
        ProfileCheckRequest request = new ProfileCheckRequest(businessId);
        request.setNonce(nonce);
        request.setTimestamp(currentTimeMillis);

        List<CollectInfo> texts = new ArrayList<>();
        CollectInfo collectInfo = new CollectInfo();
        collectInfo.account(account)
                .content(content)
                .ip(ip)
                .phone(phone)
                .title(title)
                .receiveUid(receiveUid)
                .publishTime(publishTime)
                .dataId(dataId);

        texts.add(collectInfo);
        request.setTexts(texts);
        request.setProtocol(ProtocolEnum.HTTP);

        ProfileCheckResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        ProfileCheckResult data = response.getData();
        assertEquals(true, data.getSuccess());
        assertEquals(token, data.getToken());
    }

}