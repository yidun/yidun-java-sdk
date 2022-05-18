package com.netease.yidun.sdk.antispam.text.v5;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;

/**
 * 文本单次同步检测demo
 */
public class TextSingleSyncCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = new TextClient(antispamRequester);

        // 实例化请求对象
        TextCheckRequest checkRequest = new TextCheckRequest();
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId("BusinessId");

        // 根据需要设置请求的检测节点，默认杭州，现阶段只支持检测接口
        checkRequest.setRegionCode("cn-hangzhou");

        // 设置检测内容
        checkRequest.setDataId("数据唯一标识");
        checkRequest.setContent("待检测内容");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        TextCheckResponse checkResponse = null;
        try {
            // 发起同步检测的请求
            checkResponse = textClient.syncCheckText(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            // 获取文本的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            TextCheckResult textResult = checkResponse.getResult();
        }

    }
}
