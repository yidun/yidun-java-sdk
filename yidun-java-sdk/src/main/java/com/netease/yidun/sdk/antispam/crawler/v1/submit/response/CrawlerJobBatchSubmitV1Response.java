

package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * 网站任务检测提交接口响应对象v1.0
 *
 * @author huangwu
 * @version 2021-11-02
 */
public class CrawlerJobBatchSubmitV1Response extends CommonResponse {

    private List<CrawlerJobSubmitV1Response.CrawlerJobSubmitResult> result;

    public List<CrawlerJobSubmitV1Response.CrawlerJobSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<CrawlerJobSubmitV1Response.CrawlerJobSubmitResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CrawlerJobBatchSubmitV1Response{" +
                "result=" + result +
                '}';
    }
}
