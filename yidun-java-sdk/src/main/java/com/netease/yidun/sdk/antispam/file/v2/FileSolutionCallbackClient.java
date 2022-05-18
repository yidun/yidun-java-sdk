package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.file.v2.callback.request.FileCallbackV2Request;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 文档提交
 */
public class FileSolutionCallbackClient extends AntispamClient {

    public FileSolutionCallbackClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public FileCallbackV2Response callback(FileCallbackV2Request request) {
        return client.execute(request);
    }

}
