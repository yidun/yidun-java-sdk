
package com.netease.yidun.sdk.antispam.audio.check.async.v4;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.AudioClient;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.request.AudioAsyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.async.v4.response.AudioAsyncCheckResponse;

public class AudioAsyncCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        String secretId = System.getenv("SECRET_ID");
        String secretKey = System.getenv("SECRET_KEY");
        String businessId = System.getenv("BUSINESS_ID");

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester(secretId, secretKey);

        // 实例化发起请求的client对象
        AudioClient audioClient = AudioClient.getInstance(antispamRequester);

        // 点播音频异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
        // CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
        // // 调整轮询回调的最大线程数，不设置则默认值为3
        // callbackProfile.setConcurrency(2);
        // AudioCallback audioCallback = new AudioCallback(callbackProfile) {
        // @Override
        // public void handle(List<AudioCallbackV4Result> callbackData) {
        // // 处理轮询回调的结果，需保证幂等性
        // }
        // };
        // // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 audioCallback.close()
        // AudioClient audioClient = AudioClient.getInstance(antispamRequester, audioCallback);

        // 实例化请求对象
        AudioAsyncCheckRequest checkRequest = new AudioAsyncCheckRequest();
        // 根据需要设置请求的检测节点，默认杭州
        checkRequest.setRegionCode("cn-hangzhou");
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId(businessId);
        // 必填，要检测的音频 url
        checkRequest.setUrl("音频下载 url");
        // 非必填，建议设置获取最新的检测结果。主动回调数据接口超时时间默认设置为2s，为了保证顺利接收数据，需保证接收接口性能稳定并且保证幂等性。
        checkRequest.setCallbackUrl("主动回调地址");
        // 非必填，检测去重字段，填入后使用此字段去重，如果没填入则默认使用url进行去重
        checkRequest.setUniqueKey("检测去重字段");
        // 其他字段详细填写信息可参考官网文档 帮助中心 -> 音频检测 -> 点播音频接口

        AudioAsyncCheckResponse checkResponse = null;
        try {
            // 发起异步检测的请求
            checkResponse = audioClient.asyncCheckAudio(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            AudioAsyncCheckResponse.AudioSubmitV4Result submitResult = checkResponse.getResult();
            if (submitResult != null && submitResult.getStatus() != null) {
                // 提交成功
                if (submitResult.getStatus() == 0) {
                    // 获取检测任务 id
                    String taskId = submitResult.getTaskId();
                    // 获取缓冲池数量
                    Integer dealingCount = submitResult.getDealingCount();
                } else if (submitResult.getStatus() == 1) {
                    // 提交失败，可重试提交
                }
            }
        }

    }
}
