package com.netease.yidun.sdk.antispam.keyword;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.query.KeywordQueryResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 关键词查询demo
 */
public class KeywordQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        KeywordClient keywordClient = KeywordClient.getInstance(antispamRequester);
        // 实例化请求对象
        KeywordQueryRequest queryRequest = new KeywordQueryRequest();
        queryRequest.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        queryRequest.setBusinessId("BusinessId");

        // 设置查询内容
        queryRequest.setKeyword("查询关键词");
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(20);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        KeywordQueryResponse queryResponse = null;
        try {
            // 发起查询请求
            queryResponse = keywordClient.query(queryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (queryResponse != null && queryResponse.getCode() == 200) {
            if (queryResponse.getResult() != null
                    && queryResponse.getResult().getWords() != null && queryResponse.getResult().getWords().getCount() > 0L) {
                for (KeywordQueryResponse.Row keyword : queryResponse.getResult().getWords().getRows()) {
                    // 根据需要获取每个关键词的查询结果，具体返回字段的说明，请参考官方接口文档中字段说明
                }
            }
        }
    }


}
