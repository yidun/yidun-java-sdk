package com.netease.yidun.sdk.irisk.v1.antigold;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;

import java.util.Map;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 16:50
 */
public class IRiskAntiGoldCheckRequest extends BizPostJsonRequest<IRiskAntiGoldCheckResponse> {

    /**
     * 实际记录日志的时间，采用RFC 3339时间格式，例如，"2023-09-08T16:00:43+08:00"（UTC+8）。
     */
    @NotEmpty(message = "logTime不能为空")
    @Length(max = 128, message = "logTime长度不能超过128")
    private String logTime;

    /**
     * 用户账号标识，建议使用业务方用户的UID，标记用户的唯一身份。
     */
    @NotEmpty(message = "account不能为空")
    @Length(max = 256, message = "account长度不能超过256")
    private String account;

    /**
     * 用户角色ID，适用于支持同一个账号下创建不同角色的业务（如游戏不同区服的角色）。
     */
    @NotEmpty(message = "roleId不能为空")
    @Length(max = 256, message = "roleId长度不能超过256")
    private String roleId;

    /**
     * 用户角色的昵称。
     */
    @NotEmpty(message = "nickname不能为空")
    @Length(max = 256, message = "nickname长度不能超过256")
    private String nickname;

    /**
     * 当前游戏角色所在游戏区服的ID（所属服务器ID)
     */
    @NotEmpty(message = "serverId不能为空")
    @Length(max = 32, message = "serverId长度不能超过128")
    private String serverId;

    /**
     * 日志类型
     */
    @NotEmpty(message = "logType不能为空")
    private String logType;

    /**
     * 日志数据，json格式
     */
    @NotEmpty(message = "logData不能为空")
    private String logData;

    public IRiskAntiGoldCheckRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/risk/antiGoldCheck";
        this.businessId = businessId;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    @Override
    public Class<IRiskAntiGoldCheckResponse> getResponseClass() {
        return IRiskAntiGoldCheckResponse.class;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("logTime", logTime);
        customSignParams.put("account", account);
        customSignParams.put("roleId", roleId);
        customSignParams.put("nickname", nickname);
        customSignParams.put("serverId", serverId);
        customSignParams.put("logType", logType);
        customSignParams.put("logData", logData);
        return customSignParams;
    }

    @Override
    public String toString() {
        return "IRiskReportDataRequest(" +
                "super=" + super.toString() +
                ", logTime=" + logTime +
                ", account=" + account +
                ", roleId=" + roleId +
                ", nickname=" + nickname +
                ", serverId=" + serverId +
                ", logType=" + logType +
                ", logData=" + logData +
                ")";
    }
}
