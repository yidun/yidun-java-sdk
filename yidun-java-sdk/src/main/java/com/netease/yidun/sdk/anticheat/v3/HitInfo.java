package com.netease.yidun.sdk.anticheat.v3;

/**
 * 反作弊检测命中信息
 */
public class HitInfo {

    /**
     * 命中类型。详见官网<a href="https://support.dun.163.com/documents/15588071870066688?docId=429073890435571712">说明文档</a>
     */
    private int hitType;
    /**
     * 命中类型的中文描述
     */
    private String hitTypeDesc;
    /**
     * 命中详情，开通正式定制版后支持返回，可定制返回值
     */
    private String hitMsg;

    public int getHitType() {
        return hitType;
    }

    public void setHitType(int hitType) {
        this.hitType = hitType;
    }

    public String getHitTypeDesc() {
        return hitTypeDesc;
    }

    public void setHitTypeDesc(String hitTypeDesc) {
        this.hitTypeDesc = hitTypeDesc;
    }

    public String getHitMsg() {
        return hitMsg;
    }

    public void setHitMsg(String hitMsg) {
        this.hitMsg = hitMsg;
    }

    @Override
    public String toString() {
        return "HitInfo("
                + "hitType=" + hitType
                + ", hitTypeDesc=" + hitTypeDesc
                + ", hitMsg=" + hitMsg
                + ")";
    }
}
