package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsSubmitV1Response;
import com.netease.yidun.sdk.common.CustomSignParamRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Set;

/**
 * 公众号检测提交接口v1.0
 */
public class OfficialAccountsSubmitV1Request extends OfficialAccountsBaseSubmitV1Request<OfficialAccountsSubmitV1Response> {

    /**
     * 数据唯一标识，能够根据该值定位到该条数据，如对数据结果有异议，可以发送该值给客户经理查询
     */
    @Length(max = 128, message = "最大长度128")
    private String dataId;
    /**
     * 微信号
     */
    @NotNull
    @Length(max = 64, message = "最大长度64")
    private String wechatAccount;
    /**
     * 公众号名称
     */
    @Length(max = 64, message = "最大长度64")
    private String officialAccountName;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getOfficialAccountName() {
        return officialAccountName;
    }

    public void setOfficialAccountName(String officialAccountName) {
        this.officialAccountName = officialAccountName;
    }

    @Override
    public Class<OfficialAccountsSubmitV1Response> getResponseClass() {
        return OfficialAccountsSubmitV1Response.class;
    }

    public OfficialAccountsSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsSubmitV1Request{" +
                "dataId='" + dataId + '\'' +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", officialAccountName='" + officialAccountName + '\'' +
                '}' + " " + super.toString();
    }
}
