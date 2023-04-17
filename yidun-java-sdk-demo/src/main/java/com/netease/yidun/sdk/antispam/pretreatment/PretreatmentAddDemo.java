package com.netease.yidun.sdk.antispam.pretreatment;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v2.add.PretreatmentAddResponse;

/**
 * 忽略词添加demo
 */
public class PretreatmentAddDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        PretreatmentClient pretreatmentClient = new PretreatmentClient(antispamRequester);
        // 实例化请求对象
        PretreatmentAddRequest addRequest = new PretreatmentAddRequest();
        // 设置易盾内容安全分配的businessId
        addRequest.setBusinessId("BusinessId");

        // 设置添加忽略词内容
        addRequest.entitys("忽略词1,忽略词2");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        PretreatmentAddResponse addResponse = null;
        try {
            // 发起提交请求
            addResponse = pretreatmentClient.add(addRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (addResponse != null && addResponse.getCode() == 200) {
            PretreatmentAddResponse.PretreatmentAddResult result = addResponse.getResult();
            // 根据需要获取忽略词的添加结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
