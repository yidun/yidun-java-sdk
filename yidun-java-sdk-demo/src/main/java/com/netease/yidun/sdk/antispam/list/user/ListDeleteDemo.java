package com.netease.yidun.sdk.antispam.list.user;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.ListClient;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteResponse;

import java.util.HashSet;
import java.util.Set;

/**
 * 忽略词删除demo
 */
public class ListDeleteDemo extends AbstractDemo {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ListClient listClient = new ListClient(antispamRequester);
        // 实例化请求对象
        ListDeleteRequest deleteRequest = new ListDeleteRequest();
        // 设置易盾内容安全分配的businessId
        deleteRequest.setBusinessId("BusinessId");

        // 设置删除内容
        Set<String> entities = new HashSet<>();
        entities.add("entity");
        deleteRequest.setEntities(GSON.toJson(entities));
        Set<String> uuids = new HashSet<>();
        uuids.add("uuid");
        deleteRequest.setUuids(GSON.toJson(uuids));
        deleteRequest.setListType(1);
        deleteRequest.setEntityType(1);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ListDeleteResponse deleteResponse = null;
        try {
            // 发起删除请求
            deleteResponse = listClient.deleteList(deleteRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (deleteResponse != null && deleteResponse.getCode() == 200) {
            Boolean result = deleteResponse.getResult();
            // 根据需要获取忽略词的删除结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
