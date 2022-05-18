package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5VersionDetail implements Serializable {
    private static final long serialVersionUID = 342173180915644515L;
    /**
     * 垃圾类别
     */
    private Integer label;
    /**
     * 版本
     */
    private String version;

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
