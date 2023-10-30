package com.netease.yidun.sdk.antispam.grammarfix;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitRequest;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 *文本纠错检测client
 */
public class GrammarfixClient {

    private AntispamRequester grammarfixRequester;

    /**
     * 获取secretId对应的唯一实例
     *
     * @param grammarfixRequester
     * @return
     */
    public static GrammarfixClient getInstance(AntispamRequester grammarfixRequester) {
        return ClientRegistry.register(grammarfixRequester, GrammarfixClient.class);
    }

    public GrammarfixClient(AntispamRequester grammarfixRequester) {
        AssertUtils.notNull(grammarfixRequester, "grammarfixRequester can not be null");
        this.grammarfixRequester = grammarfixRequester;
    }

    public GrammarfixSubmitResponse submit(GrammarfixSubmitRequest request) {
        return grammarfixRequester.getGrammarfixCommonClient().submit(request);
    }
}
