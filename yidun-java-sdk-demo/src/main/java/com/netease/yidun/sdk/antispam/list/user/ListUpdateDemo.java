package com.netease.yidun.sdk.antispam.list.user;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.user.v2.ListClient;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateResponse;

/**
 * 忽略词修改demo
 */
public class ListUpdateDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ListClient listClient = new ListClient(antispamRequester);
        // 实例化请求对象
        ListUpdateRequest updateRequest = new ListUpdateRequest();
        // 设置易盾内容安全分配的businessId
        updateRequest.setBusinessId("BusinessId");

        // 设置修改内容
        updateRequest.setUuid("uuid");
        updateRequest.setEntity("entity");
        updateRequest.setListType(1);
        updateRequest.setEntityType(1);
        updateRequest.setStatus(0);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        ListUpdateResponse updateResponse = null;
        try {
            // 发起修改请求
            updateResponse = listClient.update(updateRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (updateResponse != null && updateResponse.getCode() == 200) {
            Boolean result = updateResponse.getResult();
            // 根据需要获取忽略词的修改结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }
    }


}
