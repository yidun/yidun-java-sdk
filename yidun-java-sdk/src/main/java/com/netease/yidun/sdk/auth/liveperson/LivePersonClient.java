package com.netease.yidun.sdk.auth.liveperson;

import com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1.InteractiveLivePersonIdCardCheckRequest;
import com.netease.yidun.sdk.auth.liveperson.interactive.composite.v1.InteractiveLivePersonIdCardCheckResponse;
import com.netease.yidun.sdk.auth.liveperson.interactive.v1.InteractiveLivePersonCheckRequest;
import com.netease.yidun.sdk.auth.liveperson.interactive.v1.InteractiveLivePersonCheckResponse;
import com.netease.yidun.sdk.auth.liveperson.video.composite.v1.VideoLivePersonIdCardCheckRequest;
import com.netease.yidun.sdk.auth.liveperson.video.composite.v1.VideoLivePersonIdCardCheckResponse;
import com.netease.yidun.sdk.auth.liveperson.video.v1.VideoLivePersonCheckRequest;
import com.netease.yidun.sdk.auth.liveperson.video.v1.VideoLivePersonCheckResponse;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;

/**
 * 适用场景：活体检测
 */
public class LivePersonClient {

    private final Client client;

    public LivePersonClient(Client client) {
        this.client = client;
    }

    public LivePersonClient(String secretId, String secretKey) {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .preheatRequestsForValidation(
                        new InteractiveLivePersonIdCardCheckRequest(null),
                        new InteractiveLivePersonCheckRequest(null),
                        new VideoLivePersonIdCardCheckRequest(null),
                        new VideoLivePersonCheckRequest(null));

        client = new DefaultClient(profile);
    }

    public LivePersonClient(ClientProfile profile) {
        this(new DefaultClient(profile));
    }

    public Client getClient() {
        return client;
    }

    public Client client() {
        return client;
    }

    /**
     * 执行交互式活体检测
     */
    public InteractiveLivePersonCheckResponse checkInteractive(InteractiveLivePersonCheckRequest request) {
        return client.execute(request);
    }

    /**
     * 执行交互式活体人脸核身检测
     */
    public InteractiveLivePersonIdCardCheckResponse checkCompositeInteractive(
            InteractiveLivePersonIdCardCheckRequest request) {
        return client.execute(request);
    }

    /**
     * 执行视频活体检测
     */
    public VideoLivePersonCheckResponse checkVideo(VideoLivePersonCheckRequest request) {
        return client.execute(request);
    }

    /**
     * 执行视频人脸核身检测
     */
    public VideoLivePersonIdCardCheckResponse checkCompositeVideo(VideoLivePersonIdCardCheckRequest request) {
        return client.execute(request);
    }

    @Override
    public String toString() {
        return "LivePersonClient(" +
                "client=" + client +
                ")";
    }
}
