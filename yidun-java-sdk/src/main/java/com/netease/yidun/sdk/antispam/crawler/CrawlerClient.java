package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.request.CrawlerJobDeleteV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.request.OfficialAccountsDeleteV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.request.WeiboDeleteV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.CrawlerJobDeleteV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.OfficialAccountsDeleteV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.delete.response.WeiboDeleteV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.CrawlerJobBatchQueryV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.JobCallbackQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.OfficialAccountsBatchQueryV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.WeiboBatchQueryV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.CrawlerJobBatchQueryV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.JobCallbackQueryResponse;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.OfficialAccountsBatchQueryV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.WeiboBatchQueryV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.OfficialAccountsSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.WeiboSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.WeiboSubmitV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.CrawlerCallback;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;

/**
 * 网站检测client
 */
public class CrawlerClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @return
     */
    public static CrawlerClient getInstance(AntispamRequester requester) {
        return ClientRegistry.register(requester, CrawlerClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param requester
     * @param crawlerCallback
     * @return
     */
    public static CrawlerClient getInstance(AntispamRequester requester, CrawlerCallback... crawlerCallback) {
        CallbackRegistry.register(requester, crawlerCallback);
        return ClientRegistry.register(requester, CrawlerClient.class);
    }

    public CrawlerClient(AntispamRequester antispamRequester) {
        super(antispamRequester);
    }

    public CrawlerClient(AntispamRequester antispamRequester, CrawlerCallback crawlerCallback) {
        super(antispamRequester, crawlerCallback);
    }

    public CrawlerJobSubmitV1Response submitJob(CrawlerJobSubmitV1Request request) {
        return requester.getCrawlerSubmitClient().submitJob(request);
    }

    public CrawlerResourceSubmitV3Response submitResource(CrawlerResourceSubmitV3Request request) {
        return requester.getCrawlerSubmitClient().submitResource(request);
    }

    public CrawlerResourceCallbackV3Response callbackResource(CrawlerResourceCallbackV3Request request) {
        return requester.getCrawlerCommonClient().callbackResource(request);
    }

    public CrawlerResourceCallbackV3Response callback(CrawlerQueryRequest request) {
        return requester.getCrawlerCommonClient().callback(request);
    }

    public CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return requester.getCrawlerCommonClient().query(request);
    }

    public JobCallbackQueryResponse jobResultQuery(JobCallbackQueryRequest request) {
        return requester.getCrawlerCommonClient().jobResultQuery(request);
    }

    /**
     * 删除主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobDeleteV1Response deleteCrawlerJob(CrawlerJobDeleteV1Request request) {
        return requester.getCrawlerCommonClient().deleteCrawlerJob(request);
    }

    /**
     * 批量查询主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobBatchQueryV1Response batchQueryCrawlerJob(CrawlerJobBatchQueryV1Request request) {
        return requester.getCrawlerCommonClient().batchQueryCrawlerJob(request);
    }

    /**
     * 提交公众号检测任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsSubmitV1Response submitOfficialAccounts(OfficialAccountsSubmitV1Request request) {
        return requester.getCrawlerSubmitClient().submitOfficialAccounts(request);
    }

    /**
     * 删除公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsDeleteV1Response deleteOfficialAccounts(OfficialAccountsDeleteV1Request request) {
        return requester.getCrawlerCommonClient().deleteOfficialAccounts(request);
    }

    /**
     * 批量查询公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsBatchQueryV1Response batchQueryOfficialAccounts(OfficialAccountsBatchQueryV1Request request) {
        return requester.getCrawlerCommonClient().batchQueryOfficialAccounts(request);
    }

    /**
     * 提交微博检测任务
     *
     * @param request
     * @return
     */
    public WeiboSubmitV1Response submitWeibo(WeiboSubmitV1Request request) {
        return requester.getCrawlerSubmitClient().submitWeibo(request);
    }

    /**
     * 删除微博任务
     *
     * @param request
     * @return
     */
    public WeiboDeleteV1Response deleteWeibo(WeiboDeleteV1Request request) {
        return requester.getCrawlerCommonClient().deleteWeibo(request);
    }

    /**
     * 批量查询微博任务
     *
     * @param request
     * @return
     */
    public WeiboBatchQueryV1Response batchQueryWeibo(WeiboBatchQueryV1Request request) {
        return requester.getCrawlerCommonClient().batchQueryWeibo(request);
    }
}
