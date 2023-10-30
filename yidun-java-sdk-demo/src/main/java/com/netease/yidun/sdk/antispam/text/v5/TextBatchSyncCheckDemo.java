package com.netease.yidun.sdk.antispam.text.v5;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.batch.TextBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckSceneRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本批量同步检测demo
 */
public class TextBatchSyncCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);

        // 实例化请求对象
        TextBatchCheckRequest checkRequest = new TextBatchCheckRequest();
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId("BusinessId");

        // 根据需要设置请求的检测节点，默认杭州，现阶段只支持检测接口
        checkRequest.setRegionCode("cn-hangzhou");

        // 设置检测内容
        checkRequest.setTexts(createTexts());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        TextBatchCheckResponse checkResponse = null;
        try {
            // 发起批量同步检测的请求
            checkResponse = textClient.syncBatchCheckText(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            // 获取文本的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            for (TextCheckResult textResult : checkResponse.getResult()) {
                // 根据需要获取每个文本的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }

    }

    /**
     * 创建批量文本数据
     */
    private static List<TextCheckSceneRequest> createTexts() {
        int contentCount = 5;
        List<TextCheckSceneRequest> textObj = new ArrayList<>(contentCount);
        TextCheckSceneRequest request = null;
        for (int i = 0; i < contentCount; i++) {
            request = new TextCheckSceneRequest();
            request.setDataId("数据唯一标识");
            request.setContent("待检测内容");
            // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
            textObj.add(request);
        }
        return textObj;
    }
}
