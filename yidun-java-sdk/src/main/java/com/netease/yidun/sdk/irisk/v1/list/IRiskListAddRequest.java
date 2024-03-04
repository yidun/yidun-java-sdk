package com.netease.yidun.sdk.irisk.v1.list;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Map;


/**
 * @author zhouyutong01
 * 名单添加
 */
public class IRiskListAddRequest extends BizPostJsonRequest<IRiskListAddResponse> {

    @NotBlank(message = "名单库编号不能为空")
    private String listGroupCode;

    @NotBlank(message = "名单项不能为空")
    private String content;

    @NotNull(message = "释放时间不能为空")
    private Long expireTime;

    @Length(max = 100, message = "添加原因长度最大为100")
    private String description;

    @Override
    public Class<IRiskListAddResponse> getResponseClass() {
        return IRiskListAddResponse.class;
    }

    public IRiskListAddRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/list/add";
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "IRiskListAddRequest(" +
                "listGroupCode='" + listGroupCode + '\'' +
                ", content='" + content + '\'' +
                ", expireTime=" + expireTime +
                ", description='" + description + '\'' +
                ')';
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("listGroupCode", listGroupCode);
        customSignParams.put("content", content);
        customSignParams.put("description", description);
        customSignParams.put("expireTime", String.valueOf(expireTime));
        return customSignParams;
    }

    public String getListGroupCode() {
        return listGroupCode;
    }

    public void setListGroupCode(String listGroupCode) {
        this.listGroupCode = listGroupCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
