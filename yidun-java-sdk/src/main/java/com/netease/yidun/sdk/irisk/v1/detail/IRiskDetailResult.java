package com.netease.yidun.sdk.irisk.v1.detail;

import java.util.List;


public class IRiskDetailResult {

    /**
     * 本次查询返回的数据条数
     */
    private Integer size;

    /**
     * 用于分批查询的关联标记。1. 当查询需要分批返回数据时，表示下一批数据起始标记。2. 当该值返回为空字符串""时，表示数据都已经返回，不需要继续执行下一批查询
     */
    private String startFlag;

    /**
     * 具体返回数据，每条数据类型见明细数据DetailData结构
     */
    private List<DetailData> detail;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public List<DetailData> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailData> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "IRiskDetailResult(" +
                "size=" + size +
                ", startFlag=" + startFlag +
                ", detail=" + detail +
                ")";
    }
}