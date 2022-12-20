package com.netease.yidun.sdk.antispam.liveaudio.callback.v4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.request.LiveAudioV4ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackV4Result;
import com.netease.yidun.sdk.core.utils.SignatureUtils;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class LiveAudioActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("liveAudio")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request,
            LiveAudioV4ActiveCallbackRequest callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            LiveAudioCallbackV4Result liveAudioCallbackV4Result = callbackResp.parseCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明
            // https://support.dun.163.com/documents/588434426518708224?docId=600817330300723200

            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
