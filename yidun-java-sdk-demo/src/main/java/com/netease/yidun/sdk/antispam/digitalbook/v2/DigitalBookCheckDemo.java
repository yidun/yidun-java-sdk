package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.request.DigitalBookSubmitRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response.DigitalBookCheckResponseV2;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 数字阅读解决方案Demo
 * 检测提交接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/601492044329328640?docId=601494878194049024
 */
public class DigitalBookCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        DigitalBookClient digitalBookClient = DigitalBookClient.getInstance(antispamRequester);

        // 实例化请求对象
        DigitalBookSubmitRequestV2 request = new DigitalBookSubmitRequestV2();
        request.setProtocol(ProtocolEnum.HTTP);
        request.type("1");
        request.bookId("001");
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        DigitalBookCheckResponseV2 response = null;
        try {
            // 发起同步检测的请求
            response = digitalBookClient.submit(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if(response.getResult() != null){
                //doSomething
            }
        }

    }
}
