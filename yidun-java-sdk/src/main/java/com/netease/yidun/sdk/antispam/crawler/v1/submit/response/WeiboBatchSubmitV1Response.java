package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * 微博检测提交接口响应对象v1.0
 */
public class WeiboBatchSubmitV1Response extends CommonResponse {

    private static final long serialVersionUID = 1128347123649598960L;
    private List<WeiboSubmitV1Response.WeiboSubmitResult> result;

    public List<WeiboSubmitV1Response.WeiboSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<WeiboSubmitV1Response.WeiboSubmitResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeiboBatchSubmitV1Response{" +
                "result=" + result +
                '}';
    }
}
