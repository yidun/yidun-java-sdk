

package com.netease.yidun.sdk.antispam.liveaudio;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.request.LiveAudioBarrageV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.response.LiveAudioBarrageV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request.LiveAudioCallbackV4Req;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Resp;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.request.LiveAudioFeedbackV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.feedback.v1.response.LiveAudioFeedbackV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryExtraV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryMonitorV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQuerySegmentV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryTaskIdV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryExtraV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryMonitorV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQuerySegmentV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryTaskIdV1Resp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class LiveAudioCommonClient extends AntispamClient {
    public LiveAudioCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public LiveAudioCallbackV4Resp callback(LiveAudioCallbackV4Req request) {
        return client.execute(request);
    }

    /**
     * 推送弹幕
     *
     * @param request 推送弹幕请求
     * @return 回调响应
     */
    public LiveAudioBarrageV1Resp pushBarrage(LiveAudioBarrageV1Req request) {
        return client.execute(request);
    }

    /**
     * 直播音频停止检测
     *
     * @param request 停止检测请求
     * @return 停止检测响应
     */
    public LiveAudioFeedbackV1Resp feedback(LiveAudioFeedbackV1Req request) {
        return client.execute(request);
    }

    /**
     * 根据 taskId 查询直播音频
     *
     * @param request 根据 taskId 查询请求
     * @return 查询响应
     */
    public LiveAudioQueryTaskIdV1Resp query(LiveAudioQueryTaskIdV1Req request) {
        return client.execute(request);
    }

    /**
     * 查询asr等增值检测服务
     *
     * @param request
     * @return
     */
    public LiveAudioQueryExtraV1Resp query(LiveAudioQueryExtraV1Req request) {
        return client.execute(request);
    }

    /**
     * 直播语音查询人审操作记录
     *
     * @param request
     * @return
     */
    public LiveAudioQueryMonitorV1Resp query(LiveAudioQueryMonitorV1Req request) {
        return client.execute(request);
    }

    /**
     * 直播语音查询录制切片
     *
     * @param request
     * @return
     */
    public LiveAudioQuerySegmentV1Resp query(LiveAudioQuerySegmentV1Req request) {
        return client.execute(request);
    }

}
