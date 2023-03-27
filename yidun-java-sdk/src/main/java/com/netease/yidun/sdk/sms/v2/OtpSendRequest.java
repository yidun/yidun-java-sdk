package com.netease.yidun.sdk.sms.v2;

import java.util.Map;

import com.netease.yidun.sdk.core.validation.limitation.Max;
import com.netease.yidun.sdk.core.validation.limitation.Min;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;

/**
 * 验证码短信发送请求。若需要易盾帮你生成并校验验证码（纯数字），则使用此请求。
 */
public class OtpSendRequest extends SmsSendRequest {

    /**
     * 验证码数字个数。最少4个，最多10个
     */
    @Min(value = 4, message = "codeLen最小值4，最大值10")
    @Max(value = 10, message = "codeLen最小值4，最大值10")
    private int codeLen = 6;

    /**
     * 验证码在短信模板中的变量名
     */
    @NotBlank(message = "codeName不能为空")
    private String codeName;

    /**
     * 验证码有效期。单位：秒。最短300秒，最长1800秒
     */
    @Min(value = 300, message = "codeValidSec最小值300，最大值1800")
    @Max(value = 1800, message = "codeValidSec最小值300，最大值1800")
    private int codeValidSec = 600;

    public int getCodeLen() {
        return codeLen;
    }

    public void setCodeLen(int codeLen) {
        this.codeLen = codeLen;
    }

    public int codeLen() {
        return codeLen;
    }

    public OtpSendRequest codeLen(int codeLen) {
        this.codeLen = codeLen;
        return this;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String codeName() {
        return codeName;
    }

    public OtpSendRequest codeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    public int getCodeValidSec() {
        return codeValidSec;
    }

    public void setCodeValidSec(int codeValidSec) {
        this.codeValidSec = codeValidSec;
    }

    public int codeValidSec() {
        return codeValidSec;
    }

    public OtpSendRequest codeValidSec(int codeValidSec) {
        this.codeValidSec = codeValidSec;
        return this;
    }

    /**
     * @param mobile 接收短信的手机号。单次调用仅支持一个手机号。发送国际短信，请去掉手机号前的0
     * @param templateId 短信模板ID。需事先创建模板并通过审核
     * @param codeName 验证码在短信模板中的变量名
     */
    public OtpSendRequest(String businessId, String mobile, String templateId, String codeName) {
        super(businessId, mobile, templateId);
        this.codeName = codeName;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("codeLen", String.valueOf(codeLen));
        params.put("codeName", codeName);
        params.put("codeValidSec", String.valueOf(codeValidSec));

        return params;
    }

    @Override
    public String toString() {
        return "OtpSendRequest("
                + "super=" + super.toString()
                + ", codeLen=" + codeLen
                + ", codeName=" + codeName
                + ", codeValidSec=" + codeValidSec
                + ")";
    }
}
