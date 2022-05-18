
package com.netease.yidun.sdk.antispam.liveaudio.submit.v4;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LiveAudioSubmitCodeEnum;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioClient;
import com.netease.yidun.sdk.antispam.liveaudio.submit.v4.request.LiveAudioSubmitV4Req;
import com.netease.yidun.sdk.antispam.liveaudio.submit.v4.response.LiveAudioSubmitV4Resp;

public class LiveAudioSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveAudioClient client = new LiveAudioClient(antispamRequester);
        // 直播音频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // callbackProfile.setConcurrency(2);
        // LiveAudioCallback audioCallback = new LiveAudioCallback(callbackProfile) {
        // @Override
        // public void handle(List<LiveAudioCallbackV4Result> callbackData) {
        //
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 audioCallback.close()
        // LiveAudioClient client = new LiveAudioClient(antispamRequester, audioCallback);
        // 构建直播音频提交请求
        LiveAudioSubmitV4Req request = new LiveAudioSubmitV4Req();
        // 设置易盾内容安全分配的businessId
        request.setBusinessId("BusinessId");
        // 设置直播 url，使用拉流检测为直播流地址；使用SDK检测请根据不同服务商生成相应的 url
        request.setUrl("直播 url ");
        // 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
        request.setDataId("dataId");
        // 直播语音标题
        request.setTitle("直播标题");
        request.setIp("ip 地址");
        // 用户唯一标识，如果无需登录则为空
        request.setAccount("主播账号");
        // 设置主播房间号
        request.setRoomNo("主播房间号");
        // 其他参数建议参考官网文档 帮助中心 -> 音频检测 -> 直播音频接口
        // 提交检测请求
        LiveAudioSubmitV4Resp response = null;
        try {
            response = client.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200 && response.getResult() != null) {
            LiveAudioSubmitV4Resp.LiveAudioSubmitV4Result result = response.getResult();
            // 直播任务 id
            String taskId = result.getTaskId();
            // 直播语音提交检测状态，参考 LiveAudioSubmitCodeEnum，进行处理
            Integer status = result.getStatus();
            LiveAudioSubmitCodeEnum liveAudioSubmitCodeEnum = LiveAudioSubmitCodeEnum.getByCode(status);
        }
    }
}
