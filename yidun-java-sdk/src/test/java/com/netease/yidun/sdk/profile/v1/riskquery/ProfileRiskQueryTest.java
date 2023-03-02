package com.netease.yidun.sdk.profile.v1.riskquery;

import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.profile.v1.common.Portrait;
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

public class ProfileRiskQueryTest {

    // 这些都是随机生成的内容，仅用于本地SDK测试，无法通过其它环境校验（包括生产环境与测试环境）
    private static final String secretId = "ea5293c22736992fd1e4a0c01f16f1ed";
    private static final String secretKey = "f03e795e12934534b711a1959ea1a689";
    private static final DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
    private static final String businessId = "d45f112069264f92bfeb4d474f3c7c5c";
    private static final String nonce = "3e4235a28d4c4129953ff7751abb664e";
    private static final String phone = "17312341234";
    private static final String ip = "127.0.0.1";
    private static final String account = "testAccount";

    private static final String taskId = "830efd1d1145499b95d2596ce2b99bf8";
    private static final long currentTimeMillis = 1623036428207L;

    private static final String expectedRequestBody = "signature=2ddcc4669d7cfb4d8e5a325fc708859e" +
            "&secretId=" + secretId +
            "&portrait=%7B%22queryPhoneInfo%22%3A%7B%22businessKey%22%3A%22d45f112069264f92bfeb4d474f3c7c5c%22%2C%22phones%22%3A%5B%2217312341234%22%5D%7D%2C%22queryAccountInfo%22%3A%7B%22businessKey%22%3A%22d45f112069264f92bfeb4d474f3c7c5c%22%2C%22accounts%22%3A%5B%22testAccount%22%5D%7D%2C%22queryIpInfo%22%3A%7B%22businessKey%22%3A%22d45f112069264f92bfeb4d474f3c7c5c%22%2C%22ips%22%3A%5B%22127.0.0.1%22%5D%7D%7D" +
            "&version=v1" +
            "&nonce=" + nonce +
            "&timestamp=" + currentTimeMillis;

    private static final String responseBody = "{\n" +
            "    \"code\":200,\n" +
            "    \"msg\":\"成功\",\n" +
            "    \"data\":{\n" +
            "        \"details\":{\n" +
            "            \"accountDetail\":{\n" +
            "                \"riskDetails\":[\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskModel\":\"model2\",\n" +
            "                                \"riskType\":11001,\n" +
            "                                \"riskScore\":0.5\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"under18\":{\n" +
            "                                \"score\":1,\n" +
            "                                \"isUnder18\":1\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"account\":\"123\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskModel\":\"model2\",\n" +
            "                                \"riskType\":11002,\n" +
            "                                \"riskScore\":0.6\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskModel\":\"model1\",\n" +
            "                                \"riskType\":11001,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"account\":\"123456\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"success\":true\n" +
            "            },\n" +
            "            \"phoneDetail\":{\n" +
            "                \"riskDetails\":[\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":14001,\n" +
            "                                \"riskScore\":0.3\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":14002,\n" +
            "                                \"riskScore\":0.3\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"phoneLocation\":{\n" +
            "                                \"carrier\":\"中国移动\",\n" +
            "                                \"province\":\"广东\",\n" +
            "                                \"city\":\"中山\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"phone\":\"13500142791\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":14001,\n" +
            "                                \"riskScore\":0.3\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":14002,\n" +
            "                                \"riskScore\":0.8\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"phoneLocation\":{\n" +
            "                                \"carrier\":\"中国移动\",\n" +
            "                                \"province\":\"辽宁\",\n" +
            "                                \"city\":\"本溪\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"phone\":\"13500445294\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":14001,\n" +
            "                                \"riskScore\":0.5\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":14002,\n" +
            "                                \"riskScore\":0.9\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"phoneLocation\":{\n" +
            "                                \"carrier\":\"中国移动\",\n" +
            "                                \"province\":\"广东\",\n" +
            "                                \"city\":\"广州\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"phone\":\"13500031765\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"success\":true\n" +
            "            },\n" +
            "            \"ipDetail\":{\n" +
            "                \"riskDetails\":[\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":13002,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":13001,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"ipLocation\":{\n" +
            "                                \"isp\":\"\",\n" +
            "                                \"country\":\"澳大利亚\",\n" +
            "                                \"province\":\"\",\n" +
            "                                \"city\":\"\",\n" +
            "                                \"longitude\":\"151.211354\",\n" +
            "                                \"latitude\":\"-33.862640\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"ip\":\"" + ip + "\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":13001,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":13002,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"ipLocation\":{\n" +
            "                                \"isp\":\"\",\n" +
            "                                \"country\":\"澳大利亚\",\n" +
            "                                \"province\":\"\",\n" +
            "                                \"city\":\"\",\n" +
            "                                \"longitude\":\"151.211354\",\n" +
            "                                \"latitude\":\"-33.862640\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"ip\":\"" + ip + "\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"riskInfoList\":[\n" +
            "                            {\n" +
            "                                \"riskLevel\":2,\n" +
            "                                \"riskType\":13002,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"riskLevel\":1,\n" +
            "                                \"riskType\":13001,\n" +
            "                                \"riskScore\":0.4\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"propDetails\":{\n" +
            "                            \"ipLocation\":{\n" +
            "                                \"isp\":\"\",\n" +
            "                                \"country\":\"澳大利亚\",\n" +
            "                                \"province\":\"\",\n" +
            "                                \"city\":\"\",\n" +
            "                                \"longitude\":\"151.211354\",\n" +
            "                                \"latitude\":\"-33.862640\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"ip\":\"" + ip + "\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"success\":true\n" +
            "            }\n" +
            "        },\n" +
            "        \"success\":true,\n" +
            "        \"taskId\":\"" + taskId + "\"\n" +
            "    }\n" +
            "}";

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

    @Before
    public void prepare() {
        hoverflyRule.simulate(
                dsl(service("rp.dun.163.com")
                        .post("/v1/profile/risk/multiple/query")
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .body(expectedRequestBody)
                        .willReturn(success()
                                .header("Content-Type", "application/json;charset=utf-8")
                                .body(responseBody))));
    }


    @Test
    public void ProfileRiskQueryTest() {
        ProfileRiskQueryRequest request = new ProfileRiskQueryRequest();

        Portrait portrait = getPortrait();

        request.setPortrait(portrait);
        request.protocol(ProtocolEnum.HTTP);
        request.setNonce(nonce);
        request.setTimestamp(currentTimeMillis);

        ProfileRiskQueryResponse response = client.execute(request);
        assertEquals(200, response.getCode());

        ProfileRiskQueryResult data = response.getData();

        assertEquals(true, data.getSuccess());
        ProfileRiskResult details = data.getDetails();

        assertEquals(ip, details.getIpDetail().getRiskDetails().get(0).getIp());
        assertEquals(taskId, data.getTaskId());
    }

    private Portrait getPortrait() {
        Portrait portrait = new Portrait();
        List<String> ips = new ArrayList<>();
        ips.add(ip);

        List<String> accounts = new ArrayList<>();
        accounts.add(account);

        List<String> phones = new ArrayList<>();
        phones.add(phone);

        QueryIpInfo queryIpInfo = new QueryIpInfo();
        queryIpInfo.setIps(ips);
        queryIpInfo.setBusinessKey(businessId);
        portrait.setQueryIpInfo(queryIpInfo);

        QueryAccountInfo queryAccountInfo = new QueryAccountInfo();
        queryAccountInfo.setAccounts(accounts);
        queryAccountInfo.setBusinessKey(businessId);
        portrait.setQueryAccountInfo(queryAccountInfo);

        QueryPhoneInfo queryPhoneInfo = new QueryPhoneInfo();
        queryPhoneInfo.setPhones(phones);
        queryPhoneInfo.setBusinessKey(businessId);
        portrait.setQueryPhoneInfo(queryPhoneInfo);
        return portrait;
    }


}