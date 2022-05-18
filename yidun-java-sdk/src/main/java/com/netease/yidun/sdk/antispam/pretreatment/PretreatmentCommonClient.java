package com.netease.yidun.sdk.antispam.pretreatment;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v1.update.PretreatmentUpdateRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.update.PretreatmentUpdateResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

/**
 * 自定义忽略词client
 */
public class PretreatmentCommonClient extends AntispamClient {

    public PretreatmentCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public PretreatmentAddResponse add(PretreatmentAddRequest request) {
        return client.execute(request);
    }

    public PretreatmentDeleteResponse delete(PretreatmentDeleteRequest request) {
        return client.execute(request);
    }

    public PretreatmentQueryResponse query(PretreatmentQueryRequest request) {
        return client.execute(request);
    }

    public PretreatmentUpdateResponse update(PretreatmentUpdateRequest request) {
        return client.execute(request);
    }
}
