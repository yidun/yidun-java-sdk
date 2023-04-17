package com.netease.yidun.sdk.mobileverify.oneclicklogin.v1;

import com.netease.yidun.sdk.AbstractDemo;

/**
 * 一键登录接口demo
 */
public class OneClickLoginDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        OneClickLoginClient oneClickLoginClient = new OneClickLoginClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        OneClickLoginClient client = new OneClickLoginClient(profile);
        // 填充参数
        MobileNumberGetRequest request = new MobileNumberGetRequest("businessId")
                // 【不可重复使用】易盾token(有效期2分钟)
                .token("8bba09963a1a4070aab5a785c81ec962")
                // 【不可重复使用】运营商授权码(有效期2分钟)
                .accessToken("c05807ba0e1741bcbd781f598d751608");

        MobileNumberGetResponse response = null;
        try {
            response = oneClickLoginClient.getMobileNumber(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            MobileNumberResult data = response.getData();
            // data 为手机号取号结果，具体字段详细信息可参考官网文档
        }
    }
}
