package com.netease.yidun.sdk.antispam.keyword;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.KeywordCategory;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateRequest;
import com.netease.yidun.sdk.antispam.keyword.v2.update.KeywordUpdateResponse;

/**
 * 关键词修改demo
 */
public class KeywordUpdateDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        KeywordClient keywordClient = new KeywordClient(antispamRequester);
        // 实例化请求对象
        KeywordUpdateRequest updateRequest = new KeywordUpdateRequest();
        // 设置易盾内容安全分配的businessId
        updateRequest.setBusinessId("BusinessId");

        // 设置修改内容
        updateRequest.setCategory(KeywordCategory.PORN.getValue());
        updateRequest.setSubLabel("100001");
        updateRequest.setIds("1,2");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        KeywordUpdateResponse updateResponse = null;
        try {
            // 发起修改请求
            updateResponse = keywordClient.update(updateRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (updateResponse != null && updateResponse.getCode() == 200) {
            Boolean result = updateResponse.getResult();
            // 根据需要获取关键词的修改结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
