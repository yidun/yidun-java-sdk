

package com.netease.yidun.sdk.antispam.livevideosolution;

import com.netease.yidun.sdk.antispam.AntispamRequester;
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
import com.netease.yidun.sdk.core.utils.AssertUtils;


public class LiveVideoSolutionClient {
    private AntispamRequester requester;

    public LiveVideoSolutionClient(AntispamRequester requester) {
        AssertUtils.notNull(requester, "requester can not be null");
        this.requester = requester;
    }

    public LiveVideoSolutionClient(AntispamRequester requester, LiveVideoSolutionCallback liveVideoSolutionCallback) {
        AssertUtils.notNull(requester, "requester can not be null");

        this.requester = requester;
        if (liveVideoSolutionCallback != null) {
            if (liveVideoSolutionCallback.getAntispamRequester() == null) {
                liveVideoSolutionCallback.setAntispamRequester(requester);
            }
            liveVideoSolutionCallback.start();
        }
    }

    /**
     * ??????????????????????????????
     * 
     * @param request
     * @return
     */
    public LiveWallSolutionSubmitV3Resp check(LiveWallSolutionSubmitV3Req request) {
        return requester.getLiveVideoSolutionCheckClient().check(request);
    }

    /**
     * ??????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionBarrageV1Resp pushBarrage(LiveWallSolutionBarrageV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().pushBarrage(request);
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionCallbackV3Resp callback(LiveWallSolutionCallbackV3Req request) {

        return requester.getLiveVideoSolutionCommonClient().callback(request);
    }

    /**
     * ???????????????????????????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionFeedbackV1Resp feedback(LiveWallSolutionFeedbackV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().feedback(request);
    }

    /**
     * ??????????????????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryAudioV1Resp query(LiveWallSolutionQueryAudioV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * ??????????????????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryImageV1Resp query(LiveWallSolutionQueryImageV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * ????????????????????????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryMonitorV1Resp query(LiveWallSolutionQueryMonitorV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }

    /**
     * ?????? taskId ??????
     *
     * @param request
     * @return
     */
    public LiveWallSolutionQueryV1Resp query(LiveWallSolutionQueryV1Req request) {
        return requester.getLiveVideoSolutionCommonClient().query(request);
    }
}
