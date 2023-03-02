package com.netease.yidun.sdk.profile;

import com.netease.yidun.sdk.profile.v1.ProfileClient;
import com.netease.yidun.sdk.profile.v1.common.Portrait;
import com.netease.yidun.sdk.profile.v1.riskquery.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 【风险画像】混合风险画像数据获取接口demo
 */
public class ProfileRiskQueryDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        ProfileClient profileClient = new ProfileClient("SecretId", "SecretKey");
        // 填充请求参数
        ProfileRiskQueryRequest request = new ProfileRiskQueryRequest();

        Portrait portrait = new Portrait();
        // 支持同时三种查询（账号、ip、手机号）,注意填写对应的BusinessKey,且三种的BusinessKey归属于同一个产品下。
        QueryIpInfo queryIpInfo = new QueryIpInfo();
        List<String> ips = new ArrayList<>();
        // 添加要查询的ip
        ips.add("10.152.96.171");
        queryIpInfo.setIps(ips);
        queryIpInfo.setBusinessKey("开通的ip风险画像的businessId");
        portrait.setQueryIpInfo(queryIpInfo);

        QueryAccountInfo queryAccountInfo = new QueryAccountInfo();
        List<String> accounts = new ArrayList<>();
        // 添加要查询的账号
        accounts.add("123");
        queryAccountInfo.setAccounts(accounts);
        queryAccountInfo.setBusinessKey("开通的用户风险画像的businessId");
        portrait.setQueryAccountInfo(queryAccountInfo);

        QueryPhoneInfo phoneInfo = new QueryPhoneInfo();
        List<String> phones = new ArrayList<>();
        // 添加要查询的手机号
        phones.add("17312341234");
        phoneInfo.setPhones(phones);
        phoneInfo.setBusinessKey("开通的手机风险画像的businessId");
        portrait.setQueryPhoneInfo(phoneInfo);

        request.setPortrait(portrait);

        ProfileRiskQueryResponse checkResponse = null;
        try {
            checkResponse = profileClient.riskQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            ProfileRiskQueryResult data = checkResponse.getData();
            ProfileRiskResult details = data.getDetails();
            // details中包含了查询的对应的详情数据，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }
}
