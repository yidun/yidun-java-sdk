package com.netease.yidun.sdk.antispam.crawler.v1.submit.request;

import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.OfficialAccountsBatchSubmitV1Response;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.List;

/**
 * 公众号检测提交接口v1.0
 */
public class OfficialAccountsBatchSubmitV1Request extends OfficialAccountsBaseSubmitV1Request<OfficialAccountsBatchSubmitV1Response> {

    private List<OfficialAccountsConfig> officialAccounts;

    public List<OfficialAccountsConfig> getOfficialAccounts() {
        return officialAccounts;
    }

    public void setOfficialAccounts(List<OfficialAccountsConfig> officialAccounts) {
        this.officialAccounts = officialAccounts;
    }

    @Override
    public Class<OfficialAccountsBatchSubmitV1Response> getResponseClass() {
        return OfficialAccountsBatchSubmitV1Response.class;
    }

    public OfficialAccountsBatchSubmitV1Request() {
        productCode = "crawler";
        uriPattern = "/v1/official-accounts/job/batch-submit";
        version = "v1.0";
    }

    @Override
    public String toString() {
        return "OfficialAccountsBatchSubmitV1Request{" +
                "officialAccounts=" + officialAccounts +
                '}' + " " + super.toString();
    }

    public static class OfficialAccountsConfig {

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
        public String toString() {
            return "OfficialAccountsConfig{" +
                    "dataId='" + dataId + '\'' +
                    ", wechatAccount='" + wechatAccount + '\'' +
                    ", officialAccountName='" + officialAccountName + '\'' +
                    '}';
        }
    }
}
