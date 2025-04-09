package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;

public class ImageV5AdDetail implements Serializable {
    private static final long serialVersionUID = 4340424076688152703L;
    /**
     * 广告识别类型:1 聊天截屏,2 手机商品图,3 诱导按键,4:广告表情包,5:图片弹窗,6:重复图片
     */
    private Integer type;
    /**
     * 广告识别标识，当type为6表示重复图片时，note为图片md5码
     */
    private String note;
    /**
     * 广告识别分数
     */
    private Float rate;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
