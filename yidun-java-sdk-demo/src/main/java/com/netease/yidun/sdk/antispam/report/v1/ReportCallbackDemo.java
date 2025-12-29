package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.report.v1.callback.request.ReportCallbackRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * 投诉举报解决方案Demo
 * 结果获取-轮询模式
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/593963923786141696?docId=594019682267926528
 */
public class ReportCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ReportClient reportClient = ReportClient.getInstance(antispamRequester);

        // 实例化请求对象
        ReportCallbackRequestV1 request = new ReportCallbackRequestV1();
        request.setProtocol(ProtocolEnum.HTTP);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        ReportCallbackResponseV1 response = null;
        try {
            // 发起同步检测的请求
            response = reportClient.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (ReportCallbackResponseV1.ReportCheckResult result : response.getResult()) {
                // doSomething
            }
        }

    }
}
