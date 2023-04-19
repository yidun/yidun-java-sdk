package com.netease.yidun.sdk.auth.face;

import com.netease.yidun.sdk.auth.face.compare.v1.FaceCompareRequest;
import com.netease.yidun.sdk.auth.face.compare.v1.FaceCompareResponse;
import com.netease.yidun.sdk.auth.face.detect.v1.FaceDetectRequest;
import com.netease.yidun.sdk.auth.face.detect.v1.FaceDetectResponse;
import com.netease.yidun.sdk.auth.face.recognize.register.v1.FaceRegisterRequest;
import com.netease.yidun.sdk.auth.face.recognize.register.v1.FaceRegisterResponse;
import com.netease.yidun.sdk.auth.face.recognize.v1.FaceRecognizeRequest;
import com.netease.yidun.sdk.auth.face.recognize.v1.FaceRecognizeResponse;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：人脸检测、比对、检索
 */
public class FaceClient {

    private final Client client;

    public FaceClient(Client client) {
        this.client = client;
    }

    public FaceClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new FaceCompareRequest(null),
                        new FaceDetectRequest(null),
                        new FaceRegisterRequest(null),
                        new FaceRecognizeRequest(null));

        client = new DefaultClient(profile);
    }

    public FaceClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 比对人脸
     */
    public FaceCompareResponse compareFace(FaceCompareRequest request) {
        return client.execute(request);
    }

    /**
     * 检测人脸
     */
    public FaceDetectResponse detectFace(FaceDetectRequest request) {
        return client.execute(request);
    }

    /**
     * 注册人脸
     */
    public FaceRegisterResponse registerFace(FaceRegisterRequest request) {
        return client.execute(request);
    }

    /**
     * 检索人脸
     */
    public FaceRecognizeResponse recognizeFace(FaceRecognizeRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "FaceClient(" +
                "client=" + client +
                ")";
    }
}
