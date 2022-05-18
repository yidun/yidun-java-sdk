package com.netease.yidun.sdk.antispam.videosolution;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.VideoSolutionCallback;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.request.VideoSolutionCallbackV2Req;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.request.VideoSolutionFeedbackV1Req;
import com.netease.yidun.sdk.antispam.videosolution.feedback.v1.response.VideoSolutionFeedbackV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryImageV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.request.VideoSolutionSubmitV2Req;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.response.VideoSolutionSubmitV2Resp;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public class VideoSolutionClient {

    private AntispamRequester requester;

    public VideoSolutionClient(AntispamRequester requester) {
        AssertUtils.notNull(requester, "requester can not be null");
        this.requester = requester;
    }

    public VideoSolutionClient(AntispamRequester requester, VideoSolutionCallback videoSolutionCallback) {
        AssertUtils.notNull(requester, "requester can not be null");

        this.requester = requester;
        if (videoSolutionCallback != null) {
            if (videoSolutionCallback.getAntispamRequester() == null) {
                videoSolutionCallback.setAntispamRequester(requester);
            }
            videoSolutionCallback.start();
        }
    }

    /**
     * 点播解决方案提交检测
     * 
     * @param request
     * @return
     */
    public VideoSolutionSubmitV2Resp check(VideoSolutionSubmitV2Req request) {
        return requester.getVideoSolutionCheckClient().check(request);
    }

    /**
     * 获取回调结果
     *
     * @param request 回调请求
     * @return 回调响应
     */
    public VideoSolutionCallbackV2Resp callback(VideoSolutionCallbackV2Req request) {
        return requester.getVideoSolutionCommonClient().callback(request);
    }

    /**
     * 获取反馈结果
     *
     * @param request 反馈请求
     * @return 回调响应
     */
    public VideoSolutionFeedbackV1Resp feedback(VideoSolutionFeedbackV1Req request) {
        return requester.getVideoSolutionCommonClient().feedback(request);
    }

    /**
     * 点播音视频解决方案截图查询
     *
     * @param request 查询请求
     * @return 查询响应
     */
    public VideoSolutionQueryImageV1Resp query(VideoSolutionQueryImageV1Req request) {
        return requester.getVideoSolutionCommonClient().query(request);
    }

    /**
     * 点播音视频解决方案查询
     *
     * @param request 查询请求
     * @return 查询响应
     */
    public VideoSolutionQueryV1Resp query(VideoSolutionQueryV1Req request) {
        return requester.getVideoSolutionCommonClient().query(request);
    }
}
