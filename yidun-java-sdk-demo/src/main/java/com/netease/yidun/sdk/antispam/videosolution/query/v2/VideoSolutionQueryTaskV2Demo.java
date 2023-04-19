
package com.netease.yidun.sdk.antispam.videosolution.query.v2;

import java.util.HashSet;
import java.util.Set;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionClient;
import com.netease.yidun.sdk.antispam.videosolution.query.v2.request.VideoSolutionQueryV2Req;
import com.netease.yidun.sdk.antispam.videosolution.query.v2.response.VideoSolutionQueryV2Resp;

public class VideoSolutionQueryTaskV2Demo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoSolutionClient client = new VideoSolutionClient(antispamRequester);
        // 构建点播音视频查询请求
        VideoSolutionQueryV2Req solutionQueryV2Req = new VideoSolutionQueryV2Req();
        Set<String> taskIdSet = new HashSet<>();
        taskIdSet.add("t6qzz7e88iausn4drtn4qp0h0200a02w");
        Set<String> dataIds = new HashSet<>();
        // dataIds.add("asdf asdf");
        solutionQueryV2Req.setDataIds(dataIds);
        solutionQueryV2Req.setTaskIds(taskIdSet);
        solutionQueryV2Req.setDomain("as.test.dun.163.com");
        VideoSolutionQueryV2Resp solutionQueryV2Resp = null;
        try {
            solutionQueryV2Resp = client.queryTaskV2(solutionQueryV2Req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (solutionQueryV2Resp != null && solutionQueryV2Resp.getCode() == 200
                && solutionQueryV2Resp.getResult() != null) {
            for (VideoSolutionQueryV2Resp.VideoSolutionQueryV2Result queryV2Result : solutionQueryV2Resp.getResult()) {
                // 查询点播音视频查询结果
            }
        }

    }

}
