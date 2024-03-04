package com.netease.yidun.sdk.irisk.v1.list;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Map;

/**
 * @author zhouyutong01
 * 名单查询
 */
public class IRiskListQueryRequest extends BizPostJsonRequest<IRiskListQueryResponse> {

    @NotBlank(message = "名单库编号不能为空")
    private String listGroupCode;

    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;

    private Long beginModifyTime;

    private Long endModifyTime;

    public String getListGroupCode() {
        return listGroupCode;
    }

    public void setListGroupCode(String listGroupCode) {
        this.listGroupCode = listGroupCode;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getBeginModifyTime() {
        return beginModifyTime;
    }

    public void setBeginModifyTime(Long beginModifyTime) {
        this.beginModifyTime = beginModifyTime;
    }

    public Long getEndModifyTime() {
        return endModifyTime;
    }

    public void setEndModifyTime(Long endModifyTime) {
        this.endModifyTime = endModifyTime;
    }

    @Override
    public Class<IRiskListQueryResponse> getResponseClass() {
        return IRiskListQueryResponse.class;
    }

    @Override
    public String toString() {
        return "IRiskListQueryRequest(" +
                "listGroupCode='" + listGroupCode + '\'' +
                ", pageNum=" + pageNum +
                ", beginModifyTime=" + beginModifyTime +
                ", endModifyTime=" + endModifyTime +
                ')';
    }

    public IRiskListQueryRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/list/query";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("listGroupCode", listGroupCode);
        customSignParams.put("beginModifyTime", String.valueOf(beginModifyTime));
        customSignParams.put("endModifyTime", String.valueOf(endModifyTime));
        customSignParams.put("pageNum", String.valueOf(pageNum));
        return customSignParams;
    }
}
