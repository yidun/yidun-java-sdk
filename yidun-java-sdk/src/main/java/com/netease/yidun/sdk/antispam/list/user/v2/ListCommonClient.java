package com.netease.yidun.sdk.antispam.list.user.v2;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class ListCommonClient extends AntispamClient {

    public ListCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ListSubmitResponse submit(ListSubmitRequest request) {
        return client.execute(request);
    }

    public ListUpdateResponse update(ListUpdateRequest request) {
        return client.execute(request);
    }

    public ListDeleteResponse delete(ListDeleteRequest request) {
        return client.execute(request);
    }

    public ListQueryResponse query(ListQueryRequest request) {
        return client.execute(request);
    }
}
