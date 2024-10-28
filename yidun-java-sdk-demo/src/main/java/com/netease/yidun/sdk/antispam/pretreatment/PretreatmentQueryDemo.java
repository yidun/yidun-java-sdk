package com.netease.yidun.sdk.antispam.pretreatment;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.query.PretreatmentQueryResponse;

/**
 * 忽略词查询demo
 */
public class PretreatmentQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        PretreatmentClient pretreatmentClient = PretreatmentClient.getInstance(antispamRequester);
        // 实例化请求对象
        PretreatmentQueryRequest queryRequest = new PretreatmentQueryRequest();
        // 设置易盾内容安全分配的businessId
        queryRequest.setBusinessId("BusinessId");

        // 设置查询内容
        queryRequest.setStartTime(1000000000000L);
        queryRequest.setEndTime(1234567891011L);
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(20);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        PretreatmentQueryResponse queryResponse = null;
        try {
            // 发起查询请求
            queryResponse = pretreatmentClient.query(queryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (queryResponse != null && queryResponse.getCode() == 200) {
            if (queryResponse.getResult() != null
                    && queryResponse.getResult().getCount() > 0L) {
                for (PretreatmentQueryResponse.Row pretreatment : queryResponse.getResult().getRows()) {
                    // 根据需要获取每个忽略词的查询结果，具体返回字段的说明，请参考官方接口文档中字段说明
                }
            }
        }
    }


}
