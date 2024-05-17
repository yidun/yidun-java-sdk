package com.netease.yidun.sdk.irisk.v1.mediacheck;


import java.util.List;

/**
 * @author zhouyutong01
 * 图片检测-结果查询
 */
public class IRiskMediaQueryResult {

    /**
     * 请求收到时间
     */
    private Long receiveTime;

    /**
     * ip
     */
    private String ip;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String nickname;

    /**
     * 角色服务器
     */
    private String server;

    /**
     * 状态：-1:未检测 0:正常 1:异常
     */
    private Integer status;

    /**
     * 标记
     */
    private List<String> tagNameList;

    /**
     * 详情
     */
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Long receiveTime) {
        this.receiveTime = receiveTime;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getTagNameList() {
        return tagNameList;
    }

    public void setTagNameList(List<String> tagNameList) {
        this.tagNameList = tagNameList;
    }

    @Override
    public String toString() {
        return "IRiskMediaQueryResult(" +
                "receiveTime=" + receiveTime +
                ", ip='" + ip +
                ", roleId='" + roleId +
                ", nickname='" + nickname +
                ", server='" + server +
                ", status=" + status +
                ", tagNameList=" + tagNameList +
                ", reason=" + reason +
                ')';
    }
}
