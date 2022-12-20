package com.netease.yidun.sdk.antispam.callback;

import com.netease.yidun.sdk.core.response.CommonResponse;

public class ActiveCallbackResp extends CommonResponse {

    public static final int SIGN_ERROR = 400;
    public static final int SERVER_ERROR = 500;

    public ActiveCallbackResp(int code, String msg) {
        super(code, msg);
    }

    public static ActiveCallbackResp ok() {
        return new ActiveCallbackResp(200, null);
    }

    public static ActiveCallbackResp fail(int code) {
        return new ActiveCallbackResp(code, null);
    }
}
