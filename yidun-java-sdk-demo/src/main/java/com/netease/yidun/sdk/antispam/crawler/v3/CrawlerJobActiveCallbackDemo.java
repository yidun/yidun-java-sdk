/*
 * @(#) CrawlerJobActiveCallbackDemo.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.crawler.v1.callback.request.CrawlerJobActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceActiveCallbackRequestV3;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xietieli
 * @version 2023-12-05
 */
@RestController
@RequestMapping("callback/receive")
public class CrawlerJobActiveCallbackDemo {
    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("/crawlerJob")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, CrawlerJobActiveCallbackRequest callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            CrawlerJobActiveCallbackRequest activeCallbackResult = callbackResp.parseCrawlerJobCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明 https://support.dun.163.com/documents/606191408732381184?docId=611046942165569536
            System.out.println(activeCallbackResult);
            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
