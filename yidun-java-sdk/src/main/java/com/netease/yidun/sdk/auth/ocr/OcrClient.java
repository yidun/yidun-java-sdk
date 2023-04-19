package com.netease.yidun.sdk.auth.ocr;

import com.netease.yidun.sdk.auth.ocr.bankcard.v1.BankCardOcrRequest;
import com.netease.yidun.sdk.auth.ocr.bankcard.v1.BankCardOcrResponse;
import com.netease.yidun.sdk.auth.ocr.businesslicense.v1.BusinessLicenseOcrRequest;
import com.netease.yidun.sdk.auth.ocr.businesslicense.v1.BusinessLicenseOcrResponse;
import com.netease.yidun.sdk.auth.ocr.idcard.v1.IdCardOcrRequest;
import com.netease.yidun.sdk.auth.ocr.idcard.v1.IdCardOcrResponse;
import com.netease.yidun.sdk.auth.ocr.licenseplate.v1.LicensePlateOcrRequest;
import com.netease.yidun.sdk.auth.ocr.licenseplate.v1.LicensePlateOcrResponse;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：OCR信息识别
 */
public class OcrClient {

    private final Client client;

    public OcrClient(Client client) {
        this.client = client;
    }

    public OcrClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new BankCardOcrRequest(null),
                        new BusinessLicenseOcrRequest(null),
                        new IdCardOcrRequest(null),
                        new LicensePlateOcrRequest(null));

        client = new DefaultClient(profile);
    }

    public OcrClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 识别营业执照
     */
    public BusinessLicenseOcrResponse checkBusinessLicense(BusinessLicenseOcrRequest request) {
        return client.execute(request);
    }

    /**
     * 识别身份证
     */
    public IdCardOcrResponse checkIdCard(IdCardOcrRequest request) {
        return client.execute(request);
    }

    /**
     * 识别银行卡
     */
    public BankCardOcrResponse checkBankCard(BankCardOcrRequest request) {
        return client.execute(request);
    }

    /**
     * 识别车牌
     */
    public LicensePlateOcrResponse checkLicensePlate(LicensePlateOcrRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "OcrClient(" +
                "client=" + client +
                ")";
    }
}
