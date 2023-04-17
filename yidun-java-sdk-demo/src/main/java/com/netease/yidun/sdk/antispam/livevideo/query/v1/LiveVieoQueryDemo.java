
package com.netease.yidun.sdk.antispam.livevideo.query.v1;

import static com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveWallMonitorRecordQueryResp.LiveWallMonitorRecordQueryResult.TASK_ID_QUERY_SUCCESS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.CallbackStatusEnum;
import com.netease.yidun.sdk.antispam.enums.LevelEnum;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoClient;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveVideoImageQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveVideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.request.LiveWallMonitorRecordQueryReq;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoImageQueryResp;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoTaskIdQueryResp;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveWallMonitorRecordQueryResp;

public class LiveVieoQueryDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        // 实例化发起请求的client对象
        LiveVideoClient client = new LiveVideoClient(antispamRequester);
        LiveVideoImageQueryReq videoImageQueryReq = new LiveVideoImageQueryReq();
        videoImageQueryReq.setBusinessId("BusinessId");
        // 设置直播查询的任务 id
        videoImageQueryReq.setTaskId("任务 id");
        // 查询的分类级别
        List<Integer> levels = new ArrayList<>();
        levels.add(LevelEnum.NORMAL.getCode());
        levels.add(LevelEnum.SUSPECT.getCode());
        videoImageQueryReq.setLevels(levels);
        // 查询的回调状态
        videoImageQueryReq.setCallbackStatus(CallbackStatusEnum.TOBE_CALLBACK.getCode());
        LiveVideoImageQueryResp imageQueryResp = null;
        try {
            imageQueryResp = client.query(videoImageQueryReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (imageQueryResp != null && imageQueryResp.getCode() == 200 && imageQueryResp.getResult() != null) {
            // 处理查询结果
            LiveVideoImageQueryResp.LiveVideoImageQueryResult result = imageQueryResp.getResult();
        }
        LiveVideoTaskIdQueryReq videoTaskIdQueryReq = new LiveVideoTaskIdQueryReq();
        videoTaskIdQueryReq.setBusinessId("BusinessId");
        // 设置查询直播的任务 id
        List<String> taskIds = new ArrayList<>();
        taskIds.add("任务 id ");
        taskIds.add("任务 id ");
        videoTaskIdQueryReq.setTaskIds(taskIds);
        LiveVideoTaskIdQueryResp taskIdQueryResp = null;
        try {
            taskIdQueryResp = client.query(videoTaskIdQueryReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (taskIdQueryResp != null && taskIdQueryResp.getCode() == 200 && taskIdQueryResp.getResult() != null) {
            // 处理查询结果
            for (LiveVideoTaskIdQueryResp.LiveVideoTaskIdQueryResult result : taskIdQueryResp.getResult()) {
            }
        }
        LiveWallMonitorRecordQueryReq monitorRecordQueryReq = new LiveWallMonitorRecordQueryReq();
        monitorRecordQueryReq.setBusinessId("BusinessId");
        monitorRecordQueryReq.setTaskId("任务 id");
        LiveWallMonitorRecordQueryResp monitorRecordQueryResp = null;
        try {
            monitorRecordQueryResp = client.query(monitorRecordQueryReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (monitorRecordQueryResp != null && monitorRecordQueryResp.getCode() == 200
                && monitorRecordQueryResp.getResult() != null) {
            LiveWallMonitorRecordQueryResp.LiveWallMonitorRecordQueryResult result = monitorRecordQueryResp.getResult();
            // 查询成功
            if (Objects.equals(TASK_ID_QUERY_SUCCESS, result.getStatus())) {

            } else {
                // 重试查询或检查参数
            }
        }
    }
}
