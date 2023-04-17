package com.netease.yidun.sdk.antispam.report.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.media.v2.common.constant.DataType;
import com.netease.yidun.sdk.antispam.report.v1.submit.request.ReportSubmitRequestV1;
import com.netease.yidun.sdk.antispam.report.v1.submit.response.ReportCheckResponseV1;
import java.util.ArrayList;
import java.util.List;


/**
 * 投诉举报解决方案Demo
 * 检测提交接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/593963923786141696?docId=594019617235243008
 */
public class ReportCheckSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ReportClient reportClient = new ReportClient(antispamRequester);

        // 构建一个文本解析内容
        // 详见官方文档了解更多可解析内容
        List<ReportSubmitRequestV1.DataItem> list = new ArrayList<>();
        ReportSubmitRequestV1.DataItem dataItem = new ReportSubmitRequestV1.DataItem(); dataItem.data("我是测试文本").type(DataType.TEXT.getType()).dataId("123");
        list.add(dataItem);

        // 实例化请求对象
        ReportSubmitRequestV1 request = new ReportSubmitRequestV1()
                .ip("127.0.0.1")
                .content(list)
                .evidence(list)
                .reportedId("i am reportedId")
                .dataId("i am dataId")
                .scenarios("i am scenarios")
                .roomId("i am roomId")
                .reportType("i am reportType")
                .account("i am account");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        ReportCheckResponseV1 response = null;
        try {
            // 发起同步检测的请求
            response = reportClient.submit(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if (response.getResult() != null){
                //doSomething
            }
        }

    }
}
