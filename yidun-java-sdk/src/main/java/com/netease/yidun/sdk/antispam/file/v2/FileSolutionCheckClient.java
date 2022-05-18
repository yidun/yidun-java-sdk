package com.netease.yidun.sdk.antispam.file.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.file.v2.submit.request.FileSubmitV2Request;
import com.netease.yidun.sdk.antispam.file.v2.submit.response.FileSubmitV2Response;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 文档提交
 */
public class FileSolutionCheckClient extends AntispamClient {

    public FileSolutionCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public FileSubmitV2Response check(FileSubmitV2Request request) {
        return client.execute(request);
    }

}
