
package com.netease.yidun.sdk.antispam.videosolution;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.request.VideoSolutionCallbackV2Req;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request.VideoSolutionFeedbackV1Req;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.response.VideoSolutionFeedbackV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryImageV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryV1Resp;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class VideoSolutionCommonClient extends AntispamClient {
    public VideoSolutionCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public VideoSolutionCallbackV2Resp callback(VideoSolutionCallbackV2Req request) {
        return client.execute(request);
    }

    /**
     * 获取反馈结果
     *
     * @param request 反馈请求
     * @return 回调响应
     */
    public VideoSolutionFeedbackV1Resp feedback(VideoSolutionFeedbackV1Req request) {
        return client.execute(request);
    }

    /**
     * 点播音视频解决方案截图查询
     * 
     * @param request 查询请求
     * @return 查询响应
     */
    public VideoSolutionQueryImageV1Resp query(VideoSolutionQueryImageV1Req request) {
        return client.execute(request);
    }

    /**
     * 点播音视频解决方案查询
     *
     * @param request 查询请求
     * @return 查询响应
     */
    public VideoSolutionQueryV1Resp query(VideoSolutionQueryV1Req request) {
        return client.execute(request);
    }

}
