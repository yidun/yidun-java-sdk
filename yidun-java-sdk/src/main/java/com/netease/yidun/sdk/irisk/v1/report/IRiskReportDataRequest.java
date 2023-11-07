package com.netease.yidun.sdk.irisk.v1.report;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Map;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 16:33
 */
public class IRiskReportDataRequest extends BizPostJsonRequest<IRiskReportDataResponse> {

    /**
     * 举报渠道\入口
     */
    @Length(max = 64, message = "reportChannel长度最长为64位")
    private String reportChannel;

    /**
     * 举报时间
     */
    @NotNull(message = "reportTime不能为空")
    private Long reportTime;

    /**
     * 举报人
     * json格式：字段详情见：
     */
    @NotEmpty(message = "whistleblower不能为空")
    private String whistleblower;

    /**
     * 被举报人
     * json格式：字段详情见：
     */
    @NotEmpty(message = "reportedPerson不能为空")
    private String reportedPerson;

    /**
     * 举报类型
     */
    @Length(max = 64, message = "reportType长度最长为64位")
    private String reportType;

    /**
     * 举报场景/地点
     */
    @Length(max = 32, message = "reportScene长度最长为32位")
    private String reportScene;

    /**
     * 举报内容详情
     */
    @Length(max = 256, message = "reportData长度最长为256位")
    private String reportData;

    public IRiskReportDataRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/risk/reportData";
        this.businessId = businessId;
    }

    public String getReportChannel() {
        return reportChannel;
    }

    public void setReportChannel(String reportChannel) {
        this.reportChannel = reportChannel;
    }

    public Long getReportTime() {
        return reportTime;
    }

    public void setReportTime(Long reportTime) {
        this.reportTime = reportTime;
    }

    public String getWhistleblower() {
        return whistleblower;
    }

    public void setWhistleblower(String whistleblower) {
        this.whistleblower = whistleblower;
    }

    public String getReportedPerson() {
        return reportedPerson;
    }

    public void setReportedPerson(String reportedPerson) {
        this.reportedPerson = reportedPerson;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportScene() {
        return reportScene;
    }

    public void setReportScene(String reportScene) {
        this.reportScene = reportScene;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    @Override
    public Class<IRiskReportDataResponse> getResponseClass() {
        return IRiskReportDataResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("reportChannel", reportChannel);
        customSignParams.put("reportTime", String.valueOf(reportTime));
        customSignParams.put("whistleblower", whistleblower);
        customSignParams.put("reportedPerson", reportedPerson);
        customSignParams.put("reportType", reportType);
        customSignParams.put("reportScene", reportScene);
        customSignParams.put("reportData", reportData);
        return customSignParams;
    }

    @Override
    public String toString() {
        return "IRiskReportDataRequest(" +
                "super=" + super.toString() +
                ", reportChannel=" + reportChannel +
                ", reportTime=" + reportTime +
                ", whistleblower=" + whistleblower +
                ", reportedPerson=" + reportedPerson +
                ", reportType=" + reportType +
                ", reportScene=" + reportScene +
                ", reportData=" + reportData +
                ")";
    }
}
