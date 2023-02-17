package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotBlank;
import java.util.Map;


public class IRiskMediaCheckRequest extends BizPostFormRequest<IRiskMediaCheckResponse> {

    /**
     * 图片数据，图片支持类型为BASE64的数据，无需包含base64协议请求头部分
     */
    @NotBlank
    private String mediaData;

    /**
     * 图片文件名，格式如xxx.jpg，需要包含.格式的文件后缀名
     */
    @NotBlank
    private String mediaName;

    /**
     * 用户/ 玩家的IP，或当前客户端业务事件发生时的公网IP地址（ipv4）
     */
    @NotBlank
    private String ip;

    /**
     * 用户/玩家的角色 ID
     */
    @NotBlank
    private String roleId;

    /**
     * 用户/玩家的角色名称
     */
    @NotBlank
    private String roleName;

    /**
     * 用户/玩家的角色的服务器名称
     */
    @NotBlank
    private String roleServer;

    public IRiskMediaCheckRequest(String businessId) {
        productCode = "irisk";
        version = "400";
        uriPattern = "/v5/risk/mediaCheck";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("mediaData", mediaData);
        customSignParams.put("mediaName", mediaName);
        customSignParams.put("ip", ip);
        customSignParams.put("roleId", roleId);
        customSignParams.put("roleName", roleName);
        customSignParams.put("roleServer", roleServer);
        return customSignParams;
    }

    @Override
    public Class<IRiskMediaCheckResponse> getResponseClass() {
        return IRiskMediaCheckResponse.class;
    }

    public String getMediaData() {
        return mediaData;
    }

    public void setMediaData(String mediaData) {
        this.mediaData = mediaData;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleServer() {
        return roleServer;
    }

    public void setRoleServer(String roleServer) {
        this.roleServer = roleServer;
    }


    public IRiskMediaCheckRequest mediaData(String mediaData) {
        this.mediaData = mediaData;
        return this;
    }

    public IRiskMediaCheckRequest mediaName(String mediaName) {
        this.mediaName = mediaName;
        return this;
    }

    public IRiskMediaCheckRequest ip(String ip) {
        this.ip = ip;
        return this;
    }

    public IRiskMediaCheckRequest roleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public IRiskMediaCheckRequest roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public IRiskMediaCheckRequest roleServer(String roleServer) {
        this.roleServer = roleServer;
        return this;
    }

    @Override
    public String toString() {
        return "IRiskMediaCheckRequest(" +
                "super=" + super.toString() +
                ", mediaData=" + mediaData +
                ", mediaName=" + mediaName +
                ", ip=" + ip +
                ", roleId=" + roleId +
                ", roleName=" + roleName +
                ", roleServer=" + roleServer +
                ")";
    }
}
