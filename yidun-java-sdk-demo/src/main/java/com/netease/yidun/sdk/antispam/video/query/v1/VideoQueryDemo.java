
package com.netease.yidun.sdk.antispam.video.query.v1;

import java.util.List;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.video.VideoClient;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoImageQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoTaskIdQueryReq;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoImageQueryResp;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoTaskIdQueryResp;
import com.netease.yidun.sdk.common.Page;

public class VideoQueryDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        // 实例化发起请求的client对象
        VideoClient client = new VideoClient(antispamRequester);
        VideoImageQueryReq imageQueryReq = new VideoImageQueryReq();
        VideoImageQueryResp imageQueryResp = null;
        try {
            imageQueryResp = client.query(imageQueryReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (imageQueryResp != null && imageQueryResp.getCode() == 200 && imageQueryResp.getResult() != null) {
            VideoImageQueryResp.VideoImageQueryResult result = imageQueryResp.getResult();
            // 处理视频截图查询响应
            Integer status = result.getStatus();
            Page<VideoImageQueryResp.VideoImageQueryUnit> images = result.getImages();
            long count = images.getCount();
            if (count > 0 && images.getRows() != null) {
                for (VideoImageQueryResp.VideoImageQueryUnit row : images.getRows()) {

                }
            }
        }

        VideoTaskIdQueryReq taskIdQueryReq = new VideoTaskIdQueryReq();
        VideoTaskIdQueryResp taskIdQueryResp = null;
        try {
            taskIdQueryResp = client.query(taskIdQueryReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (taskIdQueryResp != null && taskIdQueryResp.getCode() == 200 && taskIdQueryResp.getResult() != null) {
            for (VideoTaskIdQueryResp.VideoTaskIdQueryResult videoTaskIdQueryResult : taskIdQueryResp.getResult()) {
                // 处理查询响应
                Integer status = videoTaskIdQueryResult.getStatus();
                Integer level = videoTaskIdQueryResult.getLevel();
                List<VideoTaskIdQueryResp.VideoEvidence> evidences = videoTaskIdQueryResult.getEvidences();
            }
        }
    }
}
