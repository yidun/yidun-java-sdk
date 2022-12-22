/*
 * @(#) TextActiveCallbackDemo.java 2022-12-22
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.text.v5;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.text.v5.callback.request.TextV5ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("callback/receive")
public class TextActiveCallbackDemo {
    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("text")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, TextV5ActiveCallbackRequest callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            TextCheckResult textCheckResult = callbackResp.parseTextCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/588434277524447232?docId=589231544060317696


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
