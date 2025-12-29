
package com.netease.yidun.sdk.antispam.videosolution.query.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionClient;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryImageV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.request.VideoSolutionQueryV1Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryV1Resp;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public class VideoSolutionQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoSolutionClient client = VideoSolutionClient.getInstance(antispamRequester);
        // 构建点播音视频查询请求
        VideoSolutionQueryV1Req solutionQueryV1Req = new VideoSolutionQueryV1Req();
        solutionQueryV1Req.setProtocol(ProtocolEnum.HTTP);
        VideoSolutionQueryV1Resp solutionQueryV1Resp = null;
        try {
            solutionQueryV1Resp = client.query(solutionQueryV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (solutionQueryV1Resp != null && solutionQueryV1Resp.getCode() == 200
                && solutionQueryV1Resp.getResult() != null) {
            for (VideoSolutionQueryV1Resp.VideoSolutionQueryV1Result queryV1Result : solutionQueryV1Resp.getResult()) {
                // 查询点播音视频查询结果
            }
        }
        // 构建点播音视频图片查询请求
        VideoSolutionQueryImageV1Req queryImageV1Req = new VideoSolutionQueryImageV1Req();
        queryImageV1Req.setProtocol(ProtocolEnum.HTTP);
        VideoSolutionQueryImageV1Resp queryImageV1Resp = null;
        try {
            queryImageV1Resp = client.query(queryImageV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryImageV1Resp != null && queryImageV1Resp.getCode() == 200 && queryImageV1Resp.getResult() != null) {
            VideoSolutionQueryImageV1Resp.VideoSolutionQueryImageResult result = queryImageV1Resp.getResult();
            // 处理点播音视频截图查询请求
        }
    }

}
