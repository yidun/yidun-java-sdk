package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import java.io.Serializable;

/**
 * URL过滤条件
 *
 * @author huangwu
 * @version 2021-10-20
 */
public class CrawlerUrlFilter implements Serializable {

    private static final long serialVersionUID = 8307601059148223467L;

    /**
     * 过滤类型 {@link com.netease.yidun.sdk.antispam.enums.CrawlerUrlFilterType}
     */
    private Integer type;
    private String url;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
