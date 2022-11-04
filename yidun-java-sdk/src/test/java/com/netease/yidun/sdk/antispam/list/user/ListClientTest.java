package com.netease.yidun.sdk.antispam.list.user;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.Constants;
import com.netease.yidun.sdk.antispam.list.ListClient;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ListClientTest {

    private static final Gson GSON = new Gson();
    private static long currentTimeMillis = System.currentTimeMillis();
    private static ListClient client;

    @Before
    public void pre() {
        AntispamRequester antispamRequester = new AntispamRequester(Constants.SECRET_ID, Constants.SECRET_KEY);
        client = new ListClient(antispamRequester);
    }

    @Test
    public void testCase() {

        // 测试add
        ListSubmitResponse response = add();

        String entity = response.getResult().get(0).getEntity();
        String uuid = response.getResult().get(0).getUuid();

        // 测试query
        ListQueryRequest ListQueryRequest = query(entity, uuid);

        // 测试update
        update(entity, uuid);

        // 测试update后的query
        queryAfterupdate(ListQueryRequest);

        // 测试delete
        delete(entity, uuid);

        // 测试delete后的query
        queryAfteDelete(ListQueryRequest);
    }

    private void queryAfteDelete(ListQueryRequest ListQueryRequest) {
        ListQueryRequest.setStatus(null);
        ListQueryResponse ListQueryResponseAfterDelete = client.queryList(ListQueryRequest);
        Assert.assertNotNull(ListQueryResponseAfterDelete);
        Assert.assertEquals(0, (long) ListQueryResponseAfterDelete.getResult().getCount());
    }

    private void delete(String entity, String uuid) {
        ListDeleteRequest ListDeleteRequest = new ListDeleteRequest();
        ListDeleteRequest.protocol(ProtocolEnum.HTTP);
        ListDeleteRequest.setBusinessId(Constants.BUSINESS_ID);
        ListDeleteRequest.nonce(String.valueOf(currentTimeMillis++));
        Set<String> entities = new HashSet<>();
        entities.add(entity);
        ListDeleteRequest.setEntities(GSON.toJson(entities));
        Set<String> uuids = new HashSet<>();
        uuids.add(uuid);
        ListDeleteRequest.setUuids(GSON.toJson(uuids));
        ListDeleteRequest.setListType(1);
        ListDeleteRequest.setEntityType(1);
        ListDeleteResponse ListDeleteResponse = client.deleteList(ListDeleteRequest);
        Assert.assertTrue(ListDeleteResponse.getResult());
    }

    private ListSubmitResponse add() {
        ListSubmitRequest ListSubmitRequest = new ListSubmitRequest();
        ListSubmitRequest.protocol(ProtocolEnum.HTTP);
        ListSubmitRequest.nonce(String.valueOf(currentTimeMillis++));
        ListSubmitRequest.setBusinessId(Constants.BUSINESS_ID);
        Set<String> entities = new HashSet<>();
        entities.add("12345678");
        entities.add("87654321");
        ListSubmitRequest.setEntities(GSON.toJson(entities));
        ListSubmitRequest.setListType(1);
        ListSubmitRequest.setEntityType(1);
        ListSubmitRequest.setSpamType(100);
        ListSubmitRequest.setDescription("用户名单描述");

        ListSubmitResponse response = client.submitList(ListSubmitRequest);
        System.out.print(response.toString());
        Assert.assertNotNull(response);
        Assert.assertEquals(200, response.getCode());
        Assert.assertNotNull(response.getResult());
        return response;
    }

    private ListQueryRequest query(String entity, String uuid) {
        ListQueryRequest ListQueryRequest = new ListQueryRequest();
        ListQueryRequest.protocol(ProtocolEnum.HTTP);
        ListQueryRequest.setBusinessId(Constants.BUSINESS_ID);
        ListQueryRequest.nonce(String.valueOf(currentTimeMillis++));
        ListQueryRequest.setEntity(entity);
        ListQueryRequest.setUuid(uuid);
        ListQueryRequest.setListType(1);
        ListQueryRequest.setEntityType(1);
        ListQueryRequest.setStatus(1);
        ListQueryRequest.setSpamType(100);
        ListQueryRequest.setStartTime(System.currentTimeMillis() - 10 * 60 * 1000);
        ListQueryRequest.setEndTime(System.currentTimeMillis() + 10 * 60 * 1000);
        ListQueryRequest.setPageNum(1);
        ListQueryRequest.setPageSize(20);
        ListQueryResponse ListQueryResponse = client.queryList(ListQueryRequest);
        Assert.assertNotNull(ListQueryResponse);
        return ListQueryRequest;
    }

    private void update(String entity, String uuid) {
        ListUpdateRequest ListUpdateRequest = new ListUpdateRequest();
        ListUpdateRequest.protocol(ProtocolEnum.HTTP);
        ListUpdateRequest.setBusinessId(Constants.BUSINESS_ID);
        ListUpdateRequest.nonce(String.valueOf(currentTimeMillis++));
        ListUpdateRequest.setUuid(uuid);
        ListUpdateRequest.setEntity(entity);
        ListUpdateRequest.setListType(1);
        ListUpdateRequest.setEntityType(1);
        ListUpdateRequest.setStatus(0);
        ListUpdateResponse ListUpdateResponse = client.updateList(ListUpdateRequest);
        Assert.assertEquals(200, ListUpdateResponse.getCode());
        Assert.assertTrue(ListUpdateResponse.getResult());
    }

    private void queryAfterupdate(ListQueryRequest ListQueryRequest) {
        ListQueryResponse ListQueryResponseAfterUpdate = client.queryList(ListQueryRequest);
        Assert.assertNotNull(ListQueryResponseAfterUpdate);
        Assert.assertEquals(200, ListQueryResponseAfterUpdate.getCode());
        Assert.assertEquals(0, (long) ListQueryResponseAfterUpdate.getResult().getCount());
        ListQueryRequest.setStatus(0);
        ListQueryResponse ListQueryInvalidResponseAfterUpdate = client.queryList(ListQueryRequest);
        Assert.assertNotNull(ListQueryInvalidResponseAfterUpdate);
        Assert.assertEquals(200, ListQueryInvalidResponseAfterUpdate.getCode());
        Assert.assertEquals(1, (long) ListQueryInvalidResponseAfterUpdate.getResult().getCount());
    }
}
