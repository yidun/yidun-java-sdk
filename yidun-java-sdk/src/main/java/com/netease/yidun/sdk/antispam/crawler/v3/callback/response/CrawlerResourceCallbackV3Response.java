

package com.netease.yidun.sdk.antispam.crawler.v3.callback.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaCensorResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 网站资源检测v3回调结果
 *
 * @author huangwu
 * @version 2021-11-02
 */
public class CrawlerResourceCallbackV3Response extends CommonResponse {

    private List<CrawlerResourceResult> result;

    public List<CrawlerResourceResult> getResult() {
        return result;
    }

    public void setResult(List<CrawlerResourceResult> result) {
        this.result = result;
    }

    public static class CrawlerResourceResult {
        /**
         * 反垃圾结果
         */
        private CrawlerAntispamResponse antispam;

        /**
         * 审核信息
         */
        private CrawlerCensorResponse censor;

        public CrawlerAntispamResponse getAntispam() {
            return antispam;
        }

        public void setAntispam(CrawlerAntispamResponse antispam) {
            this.antispam = antispam;
        }

        public CrawlerCensorResponse getCensor() {
            return censor;
        }

        public void setCensor(CrawlerCensorResponse censor) {
            this.censor = censor;
        }

        @Override
        public String toString() {
            return "CrawlerResourceResult{" +
                    "antispam=" + antispam +
                    '}';
        }
    }

    public static class CrawlerAntispamResponse extends MediaAntispamResponse {
        /**
         * 检测失败原因，检测失败时才返回该字段；<br/>
         * 1：爬虫失败；2：试用量超限；3：业务已关闭；4：爬取内容为空；<br/>
         * 5：连接失败；6：404网页不存在；7：正在爬取中,重复提交；100：其他原因-内容检测失败；<br/>
         */
        private Integer failureReason;

        public Integer getFailureReason() {
            return failureReason;
        }

        public void setFailureReason(Integer failureReason) {
            this.failureReason = failureReason;
        }
    }

    public static class CrawlerCensorResponse extends MediaCensorResponse {

        private String siteName;
        private String siteUrl;
        /**
         * 快照URL
         * 支持人工审核不通过，对目标网站截图
         */
        private String snapshotUrl;

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSiteUrl() {
            return siteUrl;
        }

        public void setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
        }

        public String getSnapshotUrl() {
            return snapshotUrl;
        }

        public void setSnapshotUrl(String snapshotUrl) {
            this.snapshotUrl = snapshotUrl;
        }
    }

    @Override
    public String toString() {
        return "CrawlerResourceCallbackResponseV3{" +
                "result=" + result +
                "} " + super.toString();
    }
}
