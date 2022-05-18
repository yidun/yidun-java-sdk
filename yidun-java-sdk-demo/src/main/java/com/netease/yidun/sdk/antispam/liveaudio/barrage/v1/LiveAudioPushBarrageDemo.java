
package com.netease.yidun.sdk.antispam.liveaudio.barrage.v1;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LabelEnum;
import com.netease.yidun.sdk.antispam.enums.LevelEnum;
import com.netease.yidun.sdk.antispam.liveaudio.LiveAudioClient;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.request.LiveAudioBarrage;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.request.LiveAudioBarrageV1Req;
import com.netease.yidun.sdk.antispam.liveaudio.barrage.v1.response.LiveAudioBarrageV1Resp;

public class LiveAudioPushBarrageDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        LiveAudioClient liveAudioClient = new LiveAudioClient(antispamRequester);
        // 实例化请求对象
        LiveAudioBarrageV1Req request = new LiveAudioBarrageV1Req();
        // 设置易盾内容安全分配的businessId
        request.setBusinessId("BusinessId");
        // 初始化弹幕列表
        List<LiveAudioBarrage> barrages = new ArrayList<>();
        // 要发送的弹幕
        LiveAudioBarrage barrage = new LiveAudioBarrage();
        barrage.setId("弹幕 id ");
        // 直播 id
        barrage.setTaskId("直播任务 id");
        barrage.setDataId("数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询");
        barrage.setContent("弹幕内容");
        // 弹幕分类级别
        barrage.setLevel(LevelEnum.SUSPECT.getCode());
        // 弹幕垃圾分类，与 level 需要保持逻辑
        barrage.setSpamType(LabelEnum.AD.getCode());
        // 高亮标签
        List<String> hint = new ArrayList<>();
        hint.add("弹幕");
        barrage.setHint(hint);
        barrages.add(barrage);
        // 设置弹幕列表
        request.setBarrages(barrages);
        LiveAudioBarrageV1Resp response = null;
        try {
            // 发起推送弹幕的请求
            response = liveAudioClient.pushBarrage(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            // 获取弹幕发送结果
            Boolean result = response.getResult();
        }
    }
}
