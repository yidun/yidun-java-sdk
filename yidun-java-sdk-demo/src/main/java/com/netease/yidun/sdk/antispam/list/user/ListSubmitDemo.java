package com.netease.yidun.sdk.antispam.list.user;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.user.v2.ListClient;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResp;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResponse;

import java.util.HashSet;
import java.util.Set;

/**
 * 忽略词添加demo
 */
public class ListSubmitDemo extends AbstractDemo {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ListClient listClient = new ListClient(antispamRequester);
        // 实例化请求对象
        ListSubmitRequest submitRequest = new ListSubmitRequest();
        // 设置易盾内容安全分配的businessId
        submitRequest.setBusinessId("BusinessId");

        // 设置添加忽略词内容
        Set<String> entities = new HashSet<>();
        entities.add("entity1");
        entities.add("entity2");
        submitRequest.setEntities(GSON.toJson(entities));
        submitRequest.setListType(1);
        submitRequest.setEntityType(1);
        submitRequest.setSpamType(100);
        submitRequest.setDescription("用户名单描述");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ListSubmitResponse submitResponse = null;
        try {
            // 发起提交请求
            submitResponse = listClient.submit(submitRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (submitResponse != null && submitResponse.getCode() == 200) {
            ListSubmitResp result = submitResponse.getResult();
            // 根据需要获取忽略词的添加结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
