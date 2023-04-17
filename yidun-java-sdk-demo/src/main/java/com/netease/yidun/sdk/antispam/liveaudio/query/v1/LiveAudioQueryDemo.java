
package com.netease.yidun.sdk.antispam.liveaudio.query.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioClient;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryExtraV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryMonitorV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQuerySegmentV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.request.LiveAudioQueryTaskIdV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryExtraV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryMonitorV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQuerySegmentV1Resp;
import com.netease.yidun.sdk.antispam.liveaudio.query.v1.response.LiveAudioQueryTaskIdV1Resp;

public class LiveAudioQueryDemo extends AbstractDemo {

    private static final int MILLIS_PER_MINUTE = 60000;

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveAudioClient client = new LiveAudioClient(antispamRequester);

        // 实例化查询直播音频额外信息请求对象
        LiveAudioQueryExtraV1Req queryExtraV1Req = new LiveAudioQueryExtraV1Req();
        queryExtraV1Req.setBusinessId("BusinessId");
        // 设置查询开始时间和结束时间
        queryExtraV1Req.setStartTime(System.currentTimeMillis() - 5 * MILLIS_PER_MINUTE);
        queryExtraV1Req.setEndTime(System.currentTimeMillis());
        queryExtraV1Req.setTaskId("任务 id");
        LiveAudioQueryExtraV1Resp queryExtraV1Resp = null;
        try {
            queryExtraV1Resp = client.query(queryExtraV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryExtraV1Resp != null && queryExtraV1Resp.getCode() == 200 && queryExtraV1Resp.getResult() != null) {
            LiveAudioQueryExtraV1Resp.LiveAudioQueryExtraV1Result queryExtraV1RespResult = queryExtraV1Resp.getResult();
        }
        // 设置直播音频监控查询请求
        LiveAudioQueryMonitorV1Req queryMonitorV1Req = new LiveAudioQueryMonitorV1Req();
        // 设置监控的直播任务 id
        queryMonitorV1Req.setTaskId("任务 id");
        LiveAudioQueryMonitorV1Resp queryMonitorV1Resp = null;
        try {
            queryMonitorV1Resp = client.query(queryMonitorV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (queryMonitorV1Resp != null && queryMonitorV1Resp.getCode() == 200
                && queryMonitorV1Resp.getResult() != null) {
            LiveAudioQueryMonitorV1Resp.LiveAudioQueryMonitorV1Result monitorV1RespResult = queryMonitorV1Resp
                    .getResult();
        }

        // 设置直播音频断句查询请求
        LiveAudioQuerySegmentV1Req querySegmentV1Req = new LiveAudioQuerySegmentV1Req();
        querySegmentV1Req.setBusinessId("BusinessId");
        // 设置查询开始时间和结束时间
        querySegmentV1Req.setStartTime(System.currentTimeMillis() - 5 * MILLIS_PER_MINUTE);
        querySegmentV1Req.setEndTime(System.currentTimeMillis());
        querySegmentV1Req.setTaskId("任务 id");
        LiveAudioQuerySegmentV1Resp querySegmentV1Resp = null;
        try {
            querySegmentV1Resp = client.query(querySegmentV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (querySegmentV1Resp != null && querySegmentV1Resp.getCode() == 200
                && querySegmentV1Resp.getResult() != null) {
            // 处理直播音频断句结果
            for (LiveAudioQuerySegmentV1Resp.LiveAudioQuerySegmentV1Result segmentV1Result : querySegmentV1Resp
                    .getResult()) {

            }

        }
        // 设置直播音频任务查询请求
        LiveAudioQueryTaskIdV1Req queryTaskIdV1Req = new LiveAudioQueryTaskIdV1Req();
        queryTaskIdV1Req.setBusinessId("BusinessId");
        queryTaskIdV1Req.setStartTime(System.currentTimeMillis() - 5 * MILLIS_PER_MINUTE);
        queryTaskIdV1Req.setEndTime(System.currentTimeMillis());
        queryTaskIdV1Req.setTaskId("任务 id");
        LiveAudioQueryTaskIdV1Resp taskIdV1Resp = null;
        try {
            taskIdV1Resp = client.query(queryTaskIdV1Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (taskIdV1Resp != null && taskIdV1Resp.getCode() == 200 && taskIdV1Resp.getResult() != null) {
            // 处理直播音频查询结果
            for (LiveAudioQueryTaskIdV1Resp.LiveAudioQueryV1Result liveAudioQueryV1Result : taskIdV1Resp.getResult()) {
                // 分类级别 LabelEnum
                Integer action = liveAudioQueryV1Result.getAction();

            }
        }
    }
}
