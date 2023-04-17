package com.netease.yidun.sdk.profile.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryRequest;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryResponse;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserQueryResult;
import com.netease.yidun.sdk.profile.v1.userquery.ProfileUserRiskResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 【风险画像】账号风险画像数据获取接口demo
 */
public class ProfileUserQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        ProfileClient profileClient = new ProfileClient("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        ProfileClient client = new ProfileClient(profile);
        // 填充请求参数
        ProfileUserQueryRequest request = new ProfileUserQueryRequest("businessId");
        // 需要请求风险画像数据的账号列表
        List<String> accounts = new ArrayList<>();
        accounts.add("testAccount");
        request.setAccounts(accounts);

        ProfileUserQueryResponse checkResponse = null;
        try {
            checkResponse = profileClient.userQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            ProfileUserQueryResult data = checkResponse.getData();
            List<ProfileUserRiskResult> riskDetails = data.getRiskDetails();
            // riskDetails包含风险信息和用户详情等信息，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }
}
