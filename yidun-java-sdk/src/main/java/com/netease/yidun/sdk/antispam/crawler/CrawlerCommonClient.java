package com.netease.yidun.sdk.antispam.crawler;

import com.netease.yidun.sdk.antispam.AntispamClient;
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
import com.netease.yidun.sdk.antispam.crawler.v1.update.request.CrawlerJobUpdateV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.update.request.OfficialAccountsUpdateV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.update.request.WeiboUpdateV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.update.response.CrawlerJobUpdateV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.update.response.OfficialAccountsUpdateV1Response;
import com.netease.yidun.sdk.antispam.crawler.v1.update.response.WeiboUpdateV1Response;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 网站检测client
 */
public class CrawlerCommonClient extends AntispamClient {

    public CrawlerCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public CrawlerResourceCallbackV3Response callbackResource(CrawlerResourceCallbackV3Request request) {
        return client.execute(request);
    }

    public CrawlerResourceCallbackV3Response callback(CrawlerQueryRequest request) {
        return client.execute(request);
    }

    public CrawlerResourceCallbackV3Response query(CrawlerQueryRequest request) {
        return client.execute(request);
    }

    public JobCallbackQueryResponse jobResultQuery(JobCallbackQueryRequest request) {
        return client.execute(request);
    }

    /**
     * 删除主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobDeleteV1Response deleteCrawlerJob(CrawlerJobDeleteV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量查询主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobBatchQueryV1Response batchQueryCrawlerJob(CrawlerJobBatchQueryV1Request request) {
        return client.execute(request);
    }

    /**
     * 更新主站任务
     *
     * @param request
     * @return
     */
    public CrawlerJobUpdateV1Response updateCrawlerJob(CrawlerJobUpdateV1Request request) {
        return client.execute(request);
    }

    /**
     * 删除公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsDeleteV1Response deleteOfficialAccounts(OfficialAccountsDeleteV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量查询公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsBatchQueryV1Response batchQueryOfficialAccounts(OfficialAccountsBatchQueryV1Request request) {
        return client.execute(request);
    }

    /**
     * 更新公众号任务
     *
     * @param request
     * @return
     */
    public OfficialAccountsUpdateV1Response updateOfficialAccounts(OfficialAccountsUpdateV1Request request) {
        return client.execute(request);
    }

    /**
     * 删除微博任务
     *
     * @param request
     * @return
     */
    public WeiboDeleteV1Response deleteWeibo(WeiboDeleteV1Request request) {
        return client.execute(request);
    }

    /**
     * 批量查询微博任务
     *
     * @param request
     * @return
     */
    public WeiboBatchQueryV1Response batchQueryWeibo(WeiboBatchQueryV1Request request) {
        return client.execute(request);
    }

    /**
     * 更新微博任务
     *
     * @param request
     * @return
     */
    public WeiboUpdateV1Response updateWeibo(WeiboUpdateV1Request request) {
        return client.execute(request);
    }
}
