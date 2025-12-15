package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.irisk.v1.report.IRiskReportDataRequest;
import com.netease.yidun.sdk.irisk.v1.report.IRiskReportDataResponse;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/7 10:08
 */
public class IRiskReportDataDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
        // ClientProfile profile = createProfile("secretId", "secretKey");
        // IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskReportDataRequest request = new IRiskReportDataRequest("businessId");
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
        // 举报渠道
        request.setReportChannel("reportChannel");
        // 举报时间
        request.setReportTime(System.currentTimeMillis());
        // 被举报用户
        request.setReportedPerson("{\"account\":\"账号ID\",\"roleId\":\"角色ID\",\"roleName\":\"角色名称\",\"serverId\":\"服务器ID/名称\",\"level\":\"等级\",\"recharge\":10000000}");
        // 举报用户
        request.setWhistleblower("{\"account\":\"账号ID\",\"roleId\":\"角色ID\",\"roleName\":\"角色名称\",\"serverId\":\"服务器ID/名称\",\"level\":\"等级\",\"recharge\":10000000}");
        // 举报类型
        request.setReportType("reportType");
        // 举报场景/地点
        request.setReportScene("reportScene");
        // 举报内容详情
        request.setReportData("reportData");
        IRiskReportDataResponse reportDataResponse = null;
        try {
            reportDataResponse = iRiskClient.reportData(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reportDataResponse != null && reportDataResponse.getCode() == 200) {
            // 上报成功
        }
    }
}
