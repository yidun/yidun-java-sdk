package com.netease.yidun.sdk.sms.v2;

public class MatchInfo {

    /**
     * 验证码是否匹配。true：匹配；false：不匹配
     */
    private boolean match;
    /**
     * 结果代号。1：验证码一致；2：验证码不一致；3：requestId过期或不存在
     */
    private int reasonType;

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public int getReasonType() {
        return reasonType;
    }

    public void setReasonType(int reasonType) {
        this.reasonType = reasonType;
    }

    @Override
    public String toString() {
        return "MatchInfo("
                + "match=" + match
                + ", reasonType=" + reasonType
                + ")";
    }
}
