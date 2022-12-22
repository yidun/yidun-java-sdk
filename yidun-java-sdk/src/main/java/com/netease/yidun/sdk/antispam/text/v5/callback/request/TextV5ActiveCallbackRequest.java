/*
 * @(#) TextV5ActiveCallbackRequest.java 2022-12-22
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.text.v5.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;

public class TextV5ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = 833196491023960562L;

    public TextCheckResult parseTextCallbackData() {
        return parseCallbackData(TextCheckResult.class);
    }

}
