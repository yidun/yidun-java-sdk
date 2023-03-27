package com.netease.yidun.sdk.sms.v2;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 短信发送请求
 */
public class SmsSendRequest extends BizPostFormRequest<SmsSendResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 接收短信的手机号。单次调用仅支持一个手机号。发送国际短信，请去掉手机号前的0
     */
    @NotBlank(message = "mobile不能为空")
    private String mobile;

    /**
     * 短信模板ID。需事先创建模板并通过审核
     */
    @NotBlank(message = "templateId不能为空")
    @Size(max = 20, message = "templateId最长20个字符")
    private String templateId;

    /**
     * 短信模板中替换变量的内容。key是变量名称，value是变量的值
     */
    private Map<String, String> params = new StringHashMap();

    /**
     * 国际电话区号。国内短信业务不需要此参数
     */
    private String countryCallingCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String mobile() {
        return mobile;
    }

    public SmsSendRequest mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String templateId() {
        return templateId;
    }

    public SmsSendRequest templateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> params() {
        return params;
    }

    public SmsSendRequest params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    /**
     * 设置短信模板中的变量值
     *
     * @param name 变量名称
     * @param value 变量值
     */
    public void setParam(String name, String value) {
        params.put(name, value);
    }

    public SmsSendRequest param(String name, String value) {
        params.put(name, value);
        return this;
    }

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    public String countryCallingCode() {
        return countryCallingCode;
    }

    public SmsSendRequest countryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
        return this;
    }

    /**
     * @param mobile 接收短信的手机号。单次调用仅支持一个手机号。发送国际短信，请去掉手机号前的0
     * @param templateId 短信模板ID。需事先创建模板并通过审核
     */
    public SmsSendRequest(String businessId, String mobile, String templateId) {
        productCode = "sms";
        version = "v2";
        uriPattern = "/v2/sendsms";
        this.businessId = businessId;
        this.mobile = mobile;
        this.templateId = templateId;
    }

    @Override
    public Class<SmsSendResponse> getResponseClass() {
        return SmsSendResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> paramMap = super.getCustomSignParams();
        paramMap.put("mobile", mobile);
        paramMap.put("templateId", templateId);
        paramMap.put("params", params == null ? "{}" : GSON.toJson(params));
        paramMap.put("paramType", "json");
        paramMap.put("internationalCode", countryCallingCode);

        return paramMap;
    }

    @Override
    public String toString() {
        return "SmsSendRequest("
                + "super=" + super.toString()
                + ", mobile=" + mobile
                + ", templateId=" + templateId
                + ", params=" + params
                + ", countryCallingCode=" + countryCallingCode
                + ")";
    }
}
