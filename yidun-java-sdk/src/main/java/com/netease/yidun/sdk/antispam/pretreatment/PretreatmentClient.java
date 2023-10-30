package com.netease.yidun.sdk.antispam.pretreatment;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v1.update.PretreatmentUpdateRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.update.PretreatmentUpdateResponse;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 自定义忽略词client
 */
public class PretreatmentClient {

    private AntispamRequester pretreatmentRequester;

    /**
     * 获取secretId对应的唯一实例
     *
     * @param pretreatmentRequester
     * @return
     */
    public static PretreatmentClient getInstance(AntispamRequester pretreatmentRequester) {
        return ClientRegistry.register(pretreatmentRequester, PretreatmentClient.class);
    }

    public PretreatmentClient(AntispamRequester pretreatmentRequester) {
        AssertUtils.notNull(pretreatmentRequester, "pretreatmentRequester can not be null");
        this.pretreatmentRequester = pretreatmentRequester;
    }

    public PretreatmentAddResponse add(PretreatmentAddRequest request) {
        return pretreatmentRequester.getPretreatmentCommonClient().add(request);
    }

    public PretreatmentDeleteResponse delete(PretreatmentDeleteRequest request) {
        return pretreatmentRequester.getPretreatmentCommonClient().delete(request);
    }

    public PretreatmentQueryResponse query(PretreatmentQueryRequest request) {
        return pretreatmentRequester.getPretreatmentCommonClient().query(request);
    }

    public PretreatmentUpdateResponse update(PretreatmentUpdateRequest request) {
        return pretreatmentRequester.getPretreatmentCommonClient().update(request);
    }
}
