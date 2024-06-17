
package com.netease.yidun.sdk.antispam.livevideo.submit.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.livevideo.LiveVideoClient;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.request.LiveVideoCheckReq;
import com.netease.yidun.sdk.antispam.livevideo.submit.v4.response.LiveVideoCheckResp;

public class LiveVideoSubmitDemo extends AbstractDemo {
    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveVideoClient client = LiveVideoClient.getInstance(antispamRequester);
        // 直播视频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // callbackProfile.setConcurrency(2);
        // LiveVideoCallback callback = new LiveVideoCallback(callbackProfile) {
        // @Override
        // public void handle(List<LiveCallbackUnitV4> callbackData) {
        // // 处理轮询回调的结果，需保证幂等性
        // // 注意需保证这里是不抛出异常的，建议做好try catch处理，否则会一直获取当前处理失败的回调数据
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 callback.close()
        // LiveVideoClient client = LiveVideoClient.getInstance(antispamRequester, callback);
        LiveVideoCheckReq request = new LiveVideoCheckReq();
        request.setBusinessId("BusinessId");
        // 设置直播流地址
        request.setUrl("直播流地址");
        request.setDataId("数据唯一标志");
        // 客户个性化直播流唯一性标识，传入后，将以此值作为重复检测依据，若不传，默认以URL作为查重依据
        request.setUniqueKey("去重检测依据");
        // 其他参数说明建议参考官网文档说明 帮助中心 -> 视频检测 -> 直播视频接口
        LiveVideoCheckResp response = client.check(request);
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            LiveVideoCheckResp.LiveVideoCheckResult result = response.getResult();
            String taskId = result.getTaskId();
            int status = result.getStatus();
        }
    }
}
