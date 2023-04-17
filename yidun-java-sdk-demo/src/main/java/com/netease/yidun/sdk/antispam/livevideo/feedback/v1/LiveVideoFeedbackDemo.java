
package com.netease.yidun.sdk.antispam.livevideo.feedback.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoClient;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.request.LiveRealTimeInfo;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.request.LiveVideoFeedbackReq;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.response.LiveVideoFeedbackResp;

public class LiveVideoFeedbackDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        // 实例化发起请求的client对象
        LiveVideoClient client = new LiveVideoClient(antispamRequester);
        LiveVideoFeedbackReq request = new LiveVideoFeedbackReq();
        request.setBusinessId("BusinessId");
        // 设置实时反馈信息列表
        List<LiveRealTimeInfo> realTimeInfoList = new ArrayList<>();
        LiveRealTimeInfo realTimeInfo = new LiveRealTimeInfo();
        realTimeInfo.setTaskId("直播任务 id ");
        realTimeInfo.setLabels(Arrays.asList("标签1", "标签2"));
        // 观看人数
        realTimeInfo.setViewCount(1);
        // 礼物数
        realTimeInfo.setGiftCount(2);
        // 弹幕数量
        realTimeInfo.setBarrageCount(3);
        LiveRealTimeInfo.LiveTag liveTag = new LiveRealTimeInfo.LiveTag();
        // 设置直播标签
        liveTag.setLabels(Arrays.asList("标签3", "标签4"));
        // 标签更新时间，用于辅助排序
        liveTag.setUpdateTime(System.currentTimeMillis());
        realTimeInfo.setLiveTag(liveTag);
        realTimeInfoList.add(realTimeInfo);
        // 必填项
        request.setRealTimeInfoList(realTimeInfoList);
        LiveVideoFeedbackResp response = null;
        try {
            response = client.feedback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            for (LiveVideoFeedbackResp.LiveVideoFeedbackResult result : response.getResult()) {
                // 处理反馈结果
            }
        }

    }
}
