package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * 公众号检测提交接口响应对象v1.0
 */
public class OfficialAccountsBatchSubmitV1Response extends CommonResponse {
    private static final long serialVersionUID = 5851294563638619044L;
    private List<OfficialAccountsSubmitV1Response.OfficialAccountsSubmitResult> result;

    public List<OfficialAccountsSubmitV1Response.OfficialAccountsSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<OfficialAccountsSubmitV1Response.OfficialAccountsSubmitResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OfficialAccountsBatchSubmitV1Response{" +
                "result=" + result +
                '}';
    }

}
