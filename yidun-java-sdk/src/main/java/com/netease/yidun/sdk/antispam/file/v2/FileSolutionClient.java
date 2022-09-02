package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.file.v2.callback.FileCallback;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileCallbackV2Request;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.antispam.file.v2.submit.request.FileSubmitV2Request;
import com.netease.yidun.sdk.antispam.file.v2.submit.response.FileSubmitV2Response;

/**
 * 文档提交
 */
public class FileSolutionClient extends BaseClient {

    public FileSolutionClient(AntispamRequester antispamRequester) {
        super(antispamRequester);
    }

    public FileSolutionClient(AntispamRequester antispamRequester, FileCallback fileCallback) {
        super(antispamRequester, fileCallback);
    }

    public FileSubmitV2Response check(FileSubmitV2Request request) {
        return requester.getFileSolutionCheckClient().check(request);
    }

    public FileCallbackV2Response callback(FileCallbackV2Request request) {
        return requester.getFileSolutionQueryClient().callback(request);
    }

}
