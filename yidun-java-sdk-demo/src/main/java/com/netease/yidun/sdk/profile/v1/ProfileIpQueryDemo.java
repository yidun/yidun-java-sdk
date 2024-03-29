package com.netease.yidun.sdk.profile.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryRequest;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryResponse;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpQueryResult;
import com.netease.yidun.sdk.profile.v1.ipquery.ProfileIpRiskResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 【风险画像】IP风险画像数据获取接口demo
 */
public class ProfileIpQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        ProfileClient profileClient = new ProfileClient("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        ProfileClient client = new ProfileClient(profile);
        // 填充请求参数
        ProfileIpQueryRequest request = new ProfileIpQueryRequest("businessId");
        // 需要请求风险画像数据的IP列表
        List<String> ips = new ArrayList<>();
        ips.add("10.152.96.171");
        request.setIps(ips);

        ProfileIpQueryResponse checkResponse = null;
        try {
            checkResponse = profileClient.ipQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            ProfileIpQueryResult data = checkResponse.getData();
            List<ProfileIpRiskResult> riskDetails = data.getRiskDetails();
            // riskDetails包含风险信息和ip归属地详情等信息，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }
}
