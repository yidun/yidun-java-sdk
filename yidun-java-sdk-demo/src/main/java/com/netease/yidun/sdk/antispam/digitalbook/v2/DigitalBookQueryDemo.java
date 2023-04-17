package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.query.request.DigitalBookQueryRequestV2;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字阅读解决方案Demo
 * 回调查询接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/601492044329328640?docId=601495376906039296
 */
public class DigitalBookQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        DigitalBookClient digitalBookClient = new DigitalBookClient(antispamRequester);

        // 实例化请求对象
        DigitalBookQueryRequestV2 request = new DigitalBookQueryRequestV2();
        List<String> taskIdList = new ArrayList<>();
        taskIdList.add("your taskId");
        request.setTaskIds(taskIdList);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        DigitalBookCallbackResponseV2 response = null;
        try {
            // 发起同步检测的请求
            response = digitalBookClient.query(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (DigitalBookCallbackResponseV2.DigitalBookCheckResult result : response.getResult()) {
                // doSomething
            }
        }

    }
}
