package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.WeiboBatchSubmitV1Response;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * 微博检测提交接口v1.0
 */
public class WeiboBatchSubmitV1Request extends WeiboBaseSubmitV1Request<WeiboBatchSubmitV1Response> {

    private List<WeiboConfig> weiboBloggers;

    public List<WeiboConfig> getWeiboBloggers() {
        return weiboBloggers;
    }

    public void setWeiboBloggers(List<WeiboConfig> weiboBloggers) {
        this.weiboBloggers = weiboBloggers;
    }

    @Override
    public Class<WeiboBatchSubmitV1Response> getResponseClass() {
        return WeiboBatchSubmitV1Response.class;
    }

    public WeiboBatchSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/crawler/weibo-job/batch-submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "WeiboBatchSubmitV1Request{" +
                "weiboBloggers=" + weiboBloggers +
                '}';
    }

    public static class WeiboConfig implements Serializable {

        private static final long serialVersionUID = -9215570570011365452L;
        /**
         * 微博主页链接
         */
        @NotNull
        @Length(max = 1024)
        private String url;
        /**
         * 微博名
         */
        @Length(max = 64)
        private String blogger;
        /**
         * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
         */
        @Length(max = 128, message = "最大长度128")
        private String dataId;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBlogger() {
            return blogger;
        }

        public void setBlogger(String blogger) {
            this.blogger = blogger;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public String toString() {
            return "WeiboConfig{" +
                    ", url='" + url + '\'' +
                    ", blogger='" + blogger + '\'' +
                    ", dataId='" + dataId + '\'' +
                    '}' + " " + super.toString();
        }
    }
}
