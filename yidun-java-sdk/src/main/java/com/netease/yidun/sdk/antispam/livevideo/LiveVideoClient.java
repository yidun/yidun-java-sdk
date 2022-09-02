

package com.netease.yidun.sdk.antispam.livevideo;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.LiveVideoCallback;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.request.LiveVideoCallbackReq;
import com.netease.yidun.sdk.antispam.livevideo.callback.v4.response.LiveVideoCallbackResp;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.request.LiveVideoFeedbackReq;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.response.LiveVideoFeedbackResp;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveVideoImageQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveVideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveWallMonitorRecordQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoImageQueryResp;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoTaskIdQueryResp;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveWallMonitorRecordQueryResp;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.request.LiveVideoCheckReq;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.response.LiveVideoCheckResp;


public class LiveVideoClient extends BaseClient {

    public LiveVideoClient(AntispamRequester requester) {
        super(requester);
    }

    public LiveVideoClient(AntispamRequester requester, LiveVideoCallback liveVideoCallback) {
        super(requester, liveVideoCallback);
    }

    public LiveVideoClient(AntispamRequester requester, LiveVideoCallback... liveVideoCallback) {
        super(requester, liveVideoCallback);
    }

    /**
     * 提交直播视频检测请求
     *
     * @param request
     * @return
     */
    public LiveVideoCheckResp check(LiveVideoCheckReq request) {

        return requester.getLiveVideoCheckClient().check(request);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public LiveVideoCallbackResp callback(LiveVideoCallbackReq request) {
        return requester.getLiveVideoCommonClient().callback(request);
    }

    /**
     * 直播实时数据提交
     *
     * @param request
     * @return
     */
    public LiveVideoFeedbackResp feedback(LiveVideoFeedbackReq request) {
        return requester.getLiveVideoCommonClient().feedback(request);
    }

    /**
     * 直播截图查询
     *
     * @param request
     * @return
     */
    public LiveVideoImageQueryResp query(LiveVideoImageQueryReq request) {
        return requester.getLiveVideoCommonClient().query(request);
    }

    /**
     * taskId查询
     *
     * @param request
     * @return
     */
    public LiveVideoTaskIdQueryResp query(LiveVideoTaskIdQueryReq request) {
        return requester.getLiveVideoCommonClient().query(request);
    }

    /**
     * taskId视频监控记录查询
     *
     * @param request
     * @return
     */
    public LiveWallMonitorRecordQueryResp query(LiveWallMonitorRecordQueryReq request) {
        return requester.getLiveVideoCommonClient().query(request);
    }
}
