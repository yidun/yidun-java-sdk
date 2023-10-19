package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

/**
 * @author wangmiao5
 * @version 2020-11-19 14:00
 */
public class ImageRiskControlHitInfo implements Serializable {
    /**
     * 风险标签type
     */
    private String type;
    /**
     * 风险标签名称
     */
    private String name;
    /**
     * 风险标签描述信息
     */
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
