
package com.netease.yidun.sdk.antispam.livevideosolution.query.v3;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionClient;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryAudioV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryImageV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryMonitorV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request.LiveWallSolutionQueryV1Req;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryAudioV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryMonitorV1Resp;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryV1Resp;

public class LiveVideoSolutionQueryDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveVideoSolutionClient client = new LiveVideoSolutionClient(antispamRequester);
        LiveWallSolutionQueryV1Req queryV1Req = new LiveWallSolutionQueryV1Req();
        LiveWallSolutionQueryV1Resp queryV1Resp = null;
        try {
            queryV1Resp = client.query(queryV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryV1Resp != null && queryV1Resp.getCode() == 200 && queryV1Resp.getResult() != null) {
            // 处理直播音视频查询响应
            for (LiveWallSolutionQueryV1Resp.LiveWallSolutionQueryV1Result result : queryV1Resp.getResult()) {

            }
        }

        // 构建查询音频请求
        LiveWallSolutionQueryAudioV1Req queryAudioV1Req = new LiveWallSolutionQueryAudioV1Req();
        LiveWallSolutionQueryAudioV1Resp queryAudioV1Resp = null;
        try {
            queryAudioV1Resp = client.query(queryAudioV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryAudioV1Resp != null && queryAudioV1Resp.getCode() == 200 && queryAudioV1Resp.getResult() != null) {
            // 处理查询音频任务响应
            for (LiveWallSolutionQueryAudioV1Resp.LiveAudioQueryV1Result result : queryAudioV1Resp.getResult()) {

            }
        }
        // 构建查询截图请求
        LiveWallSolutionQueryImageV1Req queryImageV1Req = new LiveWallSolutionQueryImageV1Req();
        LiveWallSolutionQueryImageV1Resp queryImageV1Resp = null;
        try {
            queryImageV1Resp = client.query(queryImageV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryImageV1Resp != null && queryImageV1Resp.getCode() == 200 && queryImageV1Resp.getResult() != null) {
            // 处理直播截图查询响应
            LiveWallSolutionQueryImageV1Resp.LiveWallSolutionQueryImageV1Result result = queryImageV1Resp.getResult();
        }
        // 构建查询监控请求
        LiveWallSolutionQueryMonitorV1Req queryMonitorV1Req = new LiveWallSolutionQueryMonitorV1Req();
        LiveWallSolutionQueryMonitorV1Resp monitorV1Resp = null;
        try {
            monitorV1Resp = client.query(queryMonitorV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (monitorV1Resp != null && monitorV1Resp.getCode() == 200 && monitorV1Resp.getResult() != null) {
            // 处理监控查询响应
            LiveWallSolutionQueryMonitorV1Resp.LiveWallSolutionQueryMonitorV1Result result = monitorV1Resp.getResult();

        }

    }
}
