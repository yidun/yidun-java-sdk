package com.netease.yidun.sdk.antispam.pretreatment;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteRequest;
import com.netease.yidun.sdk.antispam.pretreatment.v1.delete.PretreatmentDeleteResponse;

/**
 * 忽略词删除demo
 */
public class PretreatmentDeleteDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        PretreatmentClient pretreatmentClient = PretreatmentClient.getInstance(antispamRequester);
        // 实例化请求对象
        PretreatmentDeleteRequest deleteRequest = new PretreatmentDeleteRequest();
        // 设置易盾内容安全分配的businessId
        deleteRequest.setBusinessId("BusinessId");

        // 设置删除内容
        deleteRequest.setIds("1,2");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        PretreatmentDeleteResponse deleteResponse = null;
        try {
            // 发起删除请求
            deleteResponse = pretreatmentClient.delete(deleteRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (deleteResponse != null && deleteResponse.getCode() == 200) {
            Boolean result = deleteResponse.getResult();
            // 根据需要获取忽略词的删除结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
