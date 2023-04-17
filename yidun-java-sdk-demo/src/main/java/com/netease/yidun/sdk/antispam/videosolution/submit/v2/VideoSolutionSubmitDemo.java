
package com.netease.yidun.sdk.antispam.videosolution.submit.v2;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum;
import com.netease.yidun.sdk.antispam.videosolution.VideoSolutionClient;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.request.VideoSolutionSubmitV2Req;
import com.netease.yidun.sdk.antispam.videosolution.submit.v2.response.VideoSolutionSubmitV2Resp;

public class VideoSolutionSubmitDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        VideoSolutionClient client = new VideoSolutionClient(antispamRequester);
        // 点播视频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile profile = new CallbackProfile();
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // profile.setConcurrency(2);
        // VideoSolutionCallback callback = new VideoSolutionCallback(profile) {
        // @Override
        // public void handle(List<VideoSolutionCallbackV2Result> callbackData) {
        // // 处理轮询回调的结果，需保证幂等性
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 callback.close()
        // VideoClient client = new VideoClient(antispamRequester, callback);
        VideoSolutionSubmitV2Req request = new VideoSolutionSubmitV2Req();
        // 根据需要设置请求的检测节点，默认杭州
        request.setRegionCode("cn-hangzhou");
        // 点播音视频解决方案 url
        request.setUrl("点播音视频解决方案 url");
        request.setDataId("数据唯一标识");
        request.setTitle("音视频标题");
        request.setContent("音视频简介");
        // 设置音视频封面图片
        // 图片最多 10 张或 5 MB
        List<VideoSolutionSubmitV2Req.ImageBeanRequest> images = new ArrayList<>();
        VideoSolutionSubmitV2Req.ImageBeanRequest image = new VideoSolutionSubmitV2Req.ImageBeanRequest();
        image.setName("图片标识");
        // 根据 type 的不同设置 相应的 data 类型
        image.setType(ImageTypeEnum.URL.getType());
        image.setData("封面图片 url 地址");
        images.add(image);
        request.setImages(images);
        // 其他字段详细信息建议参考官网文档 帮助中心 -> 音视频解决方案 -> 点播音视频 -> 异步检测
        // 提交点播音视频解决方案
        VideoSolutionSubmitV2Resp response = client.check(request);
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            VideoSolutionSubmitV2Resp.VideoSolutionSubmitV1Result result = response.getResult();
            String taskId = result.getTaskId();
            String dataId = result.getDataId();
            Long dealingCount = result.getDealingCount();
        }
    }
}
