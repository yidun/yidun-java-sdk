

package com.netease.yidun.sdk.antispam.livevideo;

import com.netease.yidun.sdk.antispam.AntispamClient;
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
import com.netease.yidun.sdk.core.client.ClientProfile;


public class LiveVideoCommonClient extends AntispamClient {
    public LiveVideoCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public LiveVideoCallbackResp callback(LiveVideoCallbackReq request) {
        return client.execute(request);
    }

    /**
     * 直播实时数据提交
     *
     * @param request
     * @return
     */
    public LiveVideoFeedbackResp feedback(LiveVideoFeedbackReq request) {
        return client.execute(request);
    }

    /**
     * 直播截图查询
     *
     * @param request
     * @return
     */
    public LiveVideoImageQueryResp query(LiveVideoImageQueryReq request) {
        return client.execute(request);
    }

    /**
     * taskId查询
     *
     * @param request
     * @return
     */
    public LiveVideoTaskIdQueryResp query(LiveVideoTaskIdQueryReq request) {
        return client.execute(request);
    }

    /**
     * taskId视频监控记录查询
     *
     * @param request
     * @return
     */
    public LiveWallMonitorRecordQueryResp query(LiveWallMonitorRecordQueryReq request) {
        return client.execute(request);
    }
}
