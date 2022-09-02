

package com.netease.yidun.sdk.antispam.livevideosolution;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.livevideosolution.barrage.v1.request.LiveWallSolutionBarrageV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.barrage.v1.response.LiveWallSolutionBarrageV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.LiveVideoSolutionCallback;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.request.LiveWallSolutionCallbackV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveWallSolutionCallbackV3Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.request.LiveWallSolutionFeedbackV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.response.LiveWallSolutionFeedbackV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryAudioV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryImageV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryMonitorV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryAudioV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryMonitorV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.request.LiveWallSolutionSubmitV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.response.LiveWallSolutionSubmitV3Resp;


public class LiveVideoSolutionClient extends BaseClient {

    public LiveVideoSolutionClient(AntispamRequester requester) {
        super(requester);
    }

    public LiveVideoSolutionClient(AntispamRequester requester, LiveVideoSolutionCallback liveVideoSolutionCallback) {
        super(requester, liveVideoSolutionCallback);
    }

    /**
     * 提交直播解决方案检测
     * 
     * @param request
     * @return
     */
    public LiveWallSolutionSubmitV3Resp check(LiveWallSolutionSubmitV3Req request) {
        return requester.getLiveVideoSolutionCheckClient().check(request);
    }

    /**
     * 提交弹幕检测
     *
     * @param request
     * @return
     */
    public LiveWallSolutionBarrageV1Resp pushBarrage(LiveWallSolutionBarrageV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().pushBarrage(request);
    }

    /**
     * 获取直播音视频解决方案回调结果
     *
     * @param request
     * @return
     */
    public LiveWallSolutionCallbackV3Resp callback(LiveWallSolutionCallbackV3Req request) {

        return requester.getLiveVideoSolutionCommonClient().callback(request);
    }

    /**
     * 实时更新视频直播流相关信息
     *
     * @param request
     * @return
     */
    public LiveWallSolutionFeedbackV1Resp feedback(LiveWallSolutionFeedbackV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().feedback(request);
    }

    /**
     * 实时查询音频断句信息
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryAudioV1Resp query(LiveWallSolutionQueryAudioV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * 实时查询视频截图信息
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryImageV1Resp query(LiveWallSolutionQueryImageV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * 查询人审操作记录
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryMonitorV1Resp query(LiveWallSolutionQueryMonitorV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * 根据 taskId 查询
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryV1Resp query(LiveWallSolutionQueryV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }
}
