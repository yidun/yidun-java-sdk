package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobBatchSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.OfficialAccountsBatchSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.OfficialAccountsSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.WeiboBatchSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.WeiboSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobBatchSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsBatchSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.WeiboBatchSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.WeiboSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 网站检测client
 */
public class CrawlerSubmitClient extends AntispamClient {

    public CrawlerSubmitClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public CrawlerJobSubmitV1Response submitJob(CrawlerJobSubmitV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量提交主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobBatchSubmitV1Response batchSubmitJob(CrawlerJobBatchSubmitV1Request request) {
        return client.execute(request);
    }

    public CrawlerResourceSubmitV3Response submitResource(CrawlerResourceSubmitV3Request request) {
        return client.execute(request);
    }

    /**
     * 公众号检测提交接口
     *
     * @param request 请求对象
     * @return 响应对象
     */
    public OfficialAccountsSubmitV1Response submitOfficialAccounts(OfficialAccountsSubmitV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量提交公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsBatchSubmitV1Response batchSubmitOfficialAccounts(OfficialAccountsBatchSubmitV1Request request) {
        return client.execute(request);
    }

    /**
     * 微博检测提交接口
     *
     * @param request 请求对象
     * @return 响应对象
     */
    public WeiboSubmitV1Response submitWeibo(WeiboSubmitV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量提交微博任务
     *
     * @param request
     * @return
     */
    public WeiboBatchSubmitV1Response batchSubmitWeibo(WeiboBatchSubmitV1Request request) {
        return client.execute(request);
    }

    @Override
    protected String clientName() {
        return "CrawlerSubmit";
    }

}
