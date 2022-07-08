package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;


import java.io.Serializable;

/**
 * @author wangmiao5
 * @version 2020-11-19 14:00
 */
public class ImageAnticheatHitInfo implements Serializable {

    private Integer hitType;

    private String hitMsg;

    public Integer getHitType() {
        return hitType;
    }

    public void setHitType(Integer hitType) {
        this.hitType = hitType;
    }

    public String getHitMsg() {
        return hitMsg;
    }

    public void setHitMsg(String hitMsg) {
        this.hitMsg = hitMsg;
    }
}
