package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.file.v2.callback.FileCallback;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileCallbackV2Request;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.antispam.file.v2.submit.request.FileSubmitV2Request;
import com.netease.yidun.sdk.antispam.file.v2.submit.response.FileSubmitV2Response;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 文档提交
 */
public class FileSolutionClient {
    private AntispamRequester antispamRequester;

    public FileSolutionClient(AntispamRequester antispamRequester) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");
        this.antispamRequester = antispamRequester;
    }

    public FileSolutionClient(AntispamRequester antispamRequester, FileCallback fileCallback) {
        AssertUtils.notNull(antispamRequester, "antispamRequester can not be null");
        this.antispamRequester = antispamRequester;
        if (fileCallback != null) {
            if (fileCallback.getAntispamRequester() == null) {
                fileCallback.setAntispamRequester(antispamRequester);
            }
            fileCallback.start();
        }
    }

    public FileSubmitV2Response check(FileSubmitV2Request request) {
        return antispamRequester.getFileSolutionCheckClient().check(request);
    }

    public FileCallbackV2Response callback(FileCallbackV2Request request) {
        return antispamRequester.getFileSolutionQueryClient().callback(request);
    }

}
