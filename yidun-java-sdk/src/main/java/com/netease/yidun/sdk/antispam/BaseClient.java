package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.core.utils.AssertUtils;

public class BaseClient {
    protected AntispamRequester requester;

    public BaseClient(AntispamRequester requester) {
        AssertUtils.notNull(requester, "AntispamRequester can not be null");
        this.requester = requester;
    }

    public BaseClient(AntispamRequester requester, AbstractCallbackHandler... callbacks) {
        AssertUtils.notNull(requester, "AntispamRequester can not be null");

        this.requester = requester;
        if (callbacks != null && callbacks.length > 0) {
            for (AbstractCallbackHandler callback : callbacks) {
                if (callback.getAntispamRequester() == null) {
                    callback.setAntispamRequester(requester);
                }
                callback.start();
            }
        }
    }

}
