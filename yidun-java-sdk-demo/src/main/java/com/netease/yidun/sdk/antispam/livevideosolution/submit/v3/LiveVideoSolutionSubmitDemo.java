
package com.netease.yidun.sdk.antispam.livevideosolution.submit.v3;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideosolution.LiveVideoSolutionClient;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.request.LiveWallSolutionSubmitV3Req;
import com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.response.LiveWallSolutionSubmitV3Resp;

public class LiveVideoSolutionSubmitDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveVideoSolutionClient client = new LiveVideoSolutionClient(antispamRequester);
        // 直播音视频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile profile = new CallbackProfile();
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // profile.setConcurrency(2);
        // LiveVideoSolutionCallback callback = new LiveVideoSolutionCallback(profile) {
        // @Override
        // public void handle(List<LiveVideoSolutionCallbackV3Result> callbackData) {
        // // 处理轮询回调的结果，需保证幂等性
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 callback.close()
        // LiveVideoSolutionClient client = new LiveVideoSolutionClient(antispamRequester, callback);
        // 创建提交检测请求对象
        LiveWallSolutionSubmitV3Req request = new LiveWallSolutionSubmitV3Req();
        // 根据需要设置请求的检测节点，默认杭州
        request.setRegionCode("cn-hangzhou");
        // 设置直播的 url
        request.setUrl("直播推流 url");
        // 设置数据唯一标识
        request.setDataId("数据唯一标识");
        // 设置自定义的去重字段，如不填默认以 url 去重
        request.setUniqueKey("自定义去重key");
        // 其他字段详细信息建议参考官网文档 帮助中心 -> 音视频解决方案 -> 直播音视频
        LiveWallSolutionSubmitV3Resp response = client.check(request);
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            // 处理直播音视频解决方案回调结果
            LiveWallSolutionSubmitV3Resp.LiveVideoSolutionSubmitV2Result result = response.getResult();
        }
    }
}
