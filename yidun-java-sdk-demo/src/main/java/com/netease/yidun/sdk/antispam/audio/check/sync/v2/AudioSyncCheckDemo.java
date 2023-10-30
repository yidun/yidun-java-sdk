
package com.netease.yidun.sdk.antispam.audio.check.sync.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.audio.AudioClient;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.request.AudioSyncCheckRequest;
import com.netease.yidun.sdk.antispam.audio.check.sync.v2.response.AudioSyncCheckResponse;
import com.netease.yidun.sdk.antispam.enums.AudioCheckDataTypeEnum;

public class AudioSyncCheckDemo extends AbstractDemo {
    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AudioClient audioClient = AudioClient.getInstance(antispamRequester);
        // 实例化请求对象
        AudioSyncCheckRequest checkRequest = new AudioSyncCheckRequest();
        // 根据需要设置请求的检测节点，默认杭州
        checkRequest.setRegionCode("cn-hangzhou");
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId("BusinessId");
        // 设置同步检测的音频类型（BASE64 和 URL 二选一）
        checkRequest.setDataCheckType(AudioCheckDataTypeEnum.URL.getCode());
        // 检测类型为 url 时必填，要检测的音频 url
        checkRequest.setUrl("音频下载 url");
        // 设置同步检测的音频类型为 base64
        // checkRequest.setDataCheckType(AudioCheckDataTypeEnum.BASE64.getCode());
        // 检测类型为 base64 时必填，要检测的音频 base64
        // checkRequest.setData("音频 base64 数据");

        // 非必填，检测去重字段，填入后使用此字段去重，如果没填入则默认使用url进行去重
        checkRequest.setUniqueKey("检测去重字段");
        // 其他字段详细填写信息可参考官网文档 帮助中心 -> 音频检测 -> 点播音频接口

        AudioSyncCheckResponse checkResponse = null;
        try {
            // 发起同步检测的请求，可联系运营调整后台配置，提升检测效果
            checkResponse = audioClient.syncCheckAudio(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            // 同步检测结果
            AudioSyncCheckResponse.AudioCheckV2Result checkResult = checkResponse.getResult();

        }

    }
}
