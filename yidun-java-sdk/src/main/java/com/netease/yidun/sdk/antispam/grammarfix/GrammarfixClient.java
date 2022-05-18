package com.netease.yidun.sdk.antispam.grammarfix;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitRequest;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 *文本纠错检测client
 */
public class GrammarfixClient {

    private AntispamRequester grammarfixRequester;

    public GrammarfixClient(AntispamRequester grammarfixRequester) {
        AssertUtils.notNull(grammarfixRequester, "grammarfixRequester can not be null");
        this.grammarfixRequester = grammarfixRequester;
    }

    public GrammarfixSubmitResponse submit(GrammarfixSubmitRequest request) {
        return grammarfixRequester.getGrammarfixCommonClient().submit(request);
    }
}
