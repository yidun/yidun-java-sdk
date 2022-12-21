package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackResp;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceActiveCallbackRequestV3;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.utils.SignatureUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主动回调解析结果demo
 */
@RestController
@RequestMapping("callback/receive")
public class CrawlerResourceActiveCallbackDemo {

    private static final String SECRET_KEY = "SECRET_KEY";

    @RequestMapping("crawlerResource")
    public ActiveCallbackResp receiveCallback(HttpServletRequest request, CrawlerResourceActiveCallbackRequestV3 callbackResp) {
        try {
            if (!SignatureUtils.verifySignature(request.getParameterMap(), SECRET_KEY)) {
                return ActiveCallbackResp.fail(ActiveCallbackResp.SIGN_ERROR);
            }
            CrawlerResourceCallbackV3Response.CrawlerResourceResult activeCallbackResult = callbackResp.parseCrawlerResourceCallbackData();
            // 根据需要解析字段，具体返回字段的说明，请参考官方接口文档中字段说明https://support.dun.163.com/documents/606191408732381184?docId=606214890950840320


            return ActiveCallbackResp.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ActiveCallbackResp.fail(ActiveCallbackResp.SERVER_ERROR);
        }
    }
}
