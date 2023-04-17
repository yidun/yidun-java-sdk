package com.netease.yidun.sdk.antispam.keyword;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.KeywordCategory;
import com.netease.yidun.sdk.antispam.enums.KeywordCustomLevel;
import com.netease.yidun.sdk.antispam.enums.KeywordType;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitRequest;
import com.netease.yidun.sdk.antispam.keyword.v1.submit.KeywordSubmitResponse;

import java.util.HashSet;
import java.util.Set;

/**
 * 关键词添加demo
 */
public class KeywordSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        KeywordClient keywordClient = new KeywordClient(antispamRequester);
        // 实例化请求对象
        KeywordSubmitRequest submitRequest = new KeywordSubmitRequest();
        // 设置易盾内容安全分配的businessId
        submitRequest.setBusinessId("BusinessId");

        // 设置提交内容
        submitRequest.setCategory(KeywordCategory.PORN.getValue());
        submitRequest.setSubLabel("100001");
        Set<String> wordList = new HashSet<>();
        wordList.add("自定义关键词1");
        wordList.add("自定义关键词2");
        submitRequest.setKeywords(wordList);
        submitRequest.setLevel(KeywordCustomLevel.UN_PASS.getCode());
        submitRequest.setType(KeywordType.NORMAL.getValue());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        KeywordSubmitResponse submitResponse = null;
        try {
            // 发起提交请求
            submitResponse = keywordClient.submit(submitRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (submitResponse != null && submitResponse.getCode() == 200) {
            for (KeywordSubmitResponse.KeywordSubmitResult textResult : submitResponse.getResult()) {
                // 根据需要获取每个关键词的提交结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }
    }


}
