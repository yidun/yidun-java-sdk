package com.netease.yidun.sdk.antispam.keyword;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.keyword.v1.delete.KeywordDeleteRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.delete.KeywordDeleteResponse;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryResponse;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitResponse;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateRequest;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class KeywordCommonClient extends AntispamClient {

    public KeywordCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public KeywordSubmitResponse submit(KeywordSubmitRequest request) {
        return client.execute(request);
    }

    public KeywordUpdateResponse update(KeywordUpdateRequest request) {
        return client.execute(request);
    }

    public KeywordDeleteResponse delete(KeywordDeleteRequest request) {
        return client.execute(request);
    }

    public KeywordQueryResponse query(KeywordQueryRequest request) {
        return client.execute(request);
    }
}
