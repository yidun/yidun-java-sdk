package com.netease.yidun.sdk.profile;

import com.netease.yidun.sdk.profile.v1.ProfileClient;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryRequest;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryResponse;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneQueryResult;
import com.netease.yidun.sdk.profile.v1.phonequery.ProfilePhoneRiskResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 【风险画像】手机号风险画像数据获取接口demo
 */
public class ProfilePhoneQueryDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        ProfileClient profileClient = new ProfileClient("SecretId", "SecretKey");
        // 填充请求参数
        ProfilePhoneQueryRequest request = new ProfilePhoneQueryRequest("businessId");
        // 需要请求风险画像数据的手机号列表
        List<String> phones = new ArrayList<>();
        phones.add("15622221111");
        request.setPhones(phones);

        ProfilePhoneQueryResponse checkResponse = null;
        try {
            checkResponse = profileClient.phoneQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            ProfilePhoneQueryResult data = checkResponse.getData();
            List<ProfilePhoneRiskResult> riskDetails = data.getRiskDetails();
            // riskDetails包含风险信息和手机号详情等信息，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }
}
