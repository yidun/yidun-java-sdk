package com.netease.yidun.sdk.antispam.list.user.v2;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 自定义关键词client
 */
public class ListClient {

    private AntispamRequester listRequester;

    public ListClient(AntispamRequester listRequester) {
        AssertUtils.notNull(listRequester, "listRequester can not be null");
        this.listRequester = listRequester;
    }

    public ListSubmitResponse submit(ListSubmitRequest request) {
        return listRequester.getListCommonClient().submit(request);
    }

    public ListUpdateResponse update(ListUpdateRequest request) {
        return listRequester.getListCommonClient().update(request);
    }

    public ListDeleteResponse delete(ListDeleteRequest request) {
        return listRequester.getListCommonClient().delete(request);
    }

    public ListQueryResponse query(ListQueryRequest request) {
        return listRequester.getListCommonClient().query(request);
    }
}
