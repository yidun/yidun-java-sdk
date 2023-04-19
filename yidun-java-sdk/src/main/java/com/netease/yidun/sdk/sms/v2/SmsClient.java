package com.netease.yidun.sdk.sms.v2;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

public class SmsClient {

    private final Client client;

    public SmsClient(Client client) {
        this.client = client;
    }

    public SmsClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new SmsSendRequest(null, null, null),
                        new OtpSendRequest(null, null, null, null),
                        new OtpVerifyRequest(null, null, null));

        client = new DefaultClient(profile);
    }

    public SmsClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 发送一条短信
     */
    public SmsSendResponse sendSms(SmsSendRequest request) {
        return client.execute(request);
    }

    /**
     * 发送一条验证码短信，且由易盾帮你生成校验码。配合 {@link #verifyOtp(OtpVerifyRequest)} 验证终端用户填写的校验码是否正确
     */
    public SmsSendResponse sendOtp(OtpSendRequest request) {
        return client.execute(request);
    }

    /**
     * 验证校验码是否正确。先通过 {@link #sendOtp(OtpSendRequest)} 发送校验码，再通过此方法验证终端用户填写的校验码是否正确
     */
    public OtpVerifyResponse verifyOtp(OtpVerifyRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "SmsClient("
                + "client=" + client
                + ")";
    }
}
