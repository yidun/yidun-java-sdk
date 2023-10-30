package com.netease.yidun.sdk.antispam.list.user;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.ListClient;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryResponse;

/**
 * 忽略词查询demo
 */
public class ListQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ListClient listClient = ListClient.getInstance(antispamRequester);
        // 实例化请求对象
        ListQueryRequest queryRequest = new ListQueryRequest();
        // 设置易盾内容安全分配的businessId
        queryRequest.setBusinessId("BusinessId");

        // 设置查询内容
        queryRequest.setEntity("entity");
        queryRequest.setUuid("uuid");
        queryRequest.setListType(1);
        queryRequest.setEntityType(1);
        queryRequest.setStatus(1);
        queryRequest.setSpamType(100);
        queryRequest.setStartTime(System.currentTimeMillis() - 10 * 60 * 1000);
        queryRequest.setEndTime(System.currentTimeMillis() + 10 * 60 * 1000);
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(20);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ListQueryResponse queryResponse = null;
        try {
            // 发起查询请求
            queryResponse = listClient.queryList(queryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (queryResponse != null && queryResponse.getCode() == 200) {
            if (queryResponse.getResult() != null
                    && queryResponse.getResult().getCount() > 0L) {
                for (ListQueryResponse.Row list : queryResponse.getResult().getRows()) {
                    // 根据需要获取每个忽略词的查询结果，具体返回字段的说明，请参考官方接口文档中字段说明
                }
            }
        }
    }


}
