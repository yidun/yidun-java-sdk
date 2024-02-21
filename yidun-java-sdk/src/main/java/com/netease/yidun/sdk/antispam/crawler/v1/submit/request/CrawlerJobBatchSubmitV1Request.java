

package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobBatchSubmitV1Response;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 网站任务检测提交接口v1.0
 */
public class CrawlerJobBatchSubmitV1Request extends CrawlerJobBaseSubmitV1Request<CrawlerJobBatchSubmitV1Response> {

    /**
     * 网站任务列表
     */
    private List<CrawlerJobWebSite> websites;

    public List<CrawlerJobWebSite> getWebsites() {
        return websites;
    }

    public void setWebsites(List<CrawlerJobWebSite> websites) {
        this.websites = websites;
    }

    public static class CrawlerJobWebSite implements Serializable {

        private static final long serialVersionUID = -7571746587149467618L;
        /**
         * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
         */
        private String dataId;
        /**
         * 主站URL
         */
        private String siteUrl;
        /**
         * 网站名称
         */
        private String siteName;
        /**
         * 重点关注资源
         */
        private Set<String> focusList;
        /**
         * URL过滤条件集
         */
        private Set<CrawlerUrlFilter> urlFilters;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getSiteUrl() {
            return siteUrl;
        }

        public void setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public Set<String> getFocusList() {
            return focusList;
        }

        public void setFocusList(Set<String> focusList) {
            this.focusList = focusList;
        }

        public Set<CrawlerUrlFilter> getUrlFilters() {
            return urlFilters;
        }

        public void setUrlFilters(Set<CrawlerUrlFilter> urlFilters) {
            this.urlFilters = urlFilters;
        }

        @Override
        public String toString() {
            return "CrawlerJobWebSite{" +
                    "dataId='" + dataId + '\'' +
                    ", siteUrl='" + siteUrl + '\'' +
                    ", siteName='" + siteName + '\'' +
                    ", focusList=" + focusList +
                    ", urlFilters=" + urlFilters +
                    '}';
        }
    }

    @Override
    public Class<CrawlerJobBatchSubmitV1Response> getResponseClass() {
        return CrawlerJobBatchSubmitV1Response.class;
    }

    public CrawlerJobBatchSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/job/batch-submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "CrawlerJobBatchSubmitV1Request{" +
                "webSites=" + websites +
                '}' + " " + super.toString();
    }
}
