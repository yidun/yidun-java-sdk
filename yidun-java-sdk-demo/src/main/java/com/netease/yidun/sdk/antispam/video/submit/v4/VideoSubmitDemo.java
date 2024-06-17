
package com.netease.yidun.sdk.antispam.video.submit.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.video.VideoClient;
import com.netease.yidun.sdk.antispam.video.submit.v4.request.VideoCheckReq;
import com.netease.yidun.sdk.antispam.video.submit.v4.response.VideoCheckResp;

public class VideoSubmitDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoClient client = VideoClient.getInstance(antispamRequester);
        // 点播视频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile profile = new CallbackProfile("BusinessId");
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // profile.setConcurrency(2);
        // VideoCallback callback = new VideoCallback(profile) {
        // @Override
        // public void handle(List<VideoCallbackV4Result> callbackData) {
        // // 处理轮询回调的结果，需保证幂等性
        // // 注意需保证这里是不抛出异常的，建议做好try catch处理，否则会一直获取当前处理失败的回调数据
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 callback.close()
        // VideoClient client = VideoClient.getInstance(antispamRequester, callback);

        VideoCheckReq request = new VideoCheckReq();
        // 根据需要设置请求的检测节点，默认杭州
        request.setRegionCode("cn-hangzhou");
        request.setBusinessId("BusinessId");
        // 设置点播音频的 url
        request.setUrl("检测 url ");
        // 设置数据的唯一标识
        request.setDataId("数据标识");
        request.setTitle("标题");
        // 其他字段填写详细信息建议参数官网文档，帮助中心 -> 视频检测 -> 点播视频接口
        VideoCheckResp response = null;
        try {
            response = client.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            // 处理提交结果
            VideoCheckResp.VideoCheckResult result = response.getResult();
            String taskId = result.getTaskId();
            int status = result.getStatus();
            long dealingCount = result.getDealingCount();
        }
    }
}
