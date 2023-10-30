package com.netease.yidun.sdk.antispam.keyword;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.keyword.v1.delete.KeywordDeleteRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.delete.KeywordDeleteResponse;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryResponse;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitResponse;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateRequest;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 自定义关键词client
 */
public class KeywordClient {

    private AntispamRequester keywordRequester;

    /**
     * 获取secretId对应的唯一实例
     *
     * @param keywordRequester
     * @return
     */
    public static KeywordClient getInstance(AntispamRequester keywordRequester) {
        return ClientRegistry.register(keywordRequester, KeywordClient.class);
    }

    public KeywordClient(AntispamRequester keywordRequester) {
        AssertUtils.notNull(keywordRequester, "keywordRequester can not be null");
        this.keywordRequester = keywordRequester;
    }

    public KeywordSubmitResponse submit(KeywordSubmitRequest request) {
        return keywordRequester.getKeywordCommonClient().submit(request);
    }

    public KeywordUpdateResponse update(KeywordUpdateRequest request) {
        return keywordRequester.getKeywordCommonClient().update(request);
    }

    public KeywordDeleteResponse delete(KeywordDeleteRequest request) {
        return keywordRequester.getKeywordCommonClient().delete(request);
    }

    public KeywordQueryResponse query(KeywordQueryRequest request) {
        return keywordRequester.getKeywordCommonClient().query(request);
    }
}
