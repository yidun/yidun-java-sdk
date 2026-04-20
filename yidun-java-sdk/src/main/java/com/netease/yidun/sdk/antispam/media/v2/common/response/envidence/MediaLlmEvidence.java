package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

/**
 * 融媒体产品维度大模型证据信息
 */
public class MediaLlmEvidence {
    private String subLabel;
    private String explain;
    private String keyword;
    /**
     * true: 大小模型融合检测; false: 小模型标签证据补充
     */
    private Boolean isLlmCheck;

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getIsLlmCheck() {
        return isLlmCheck;
    }

    public void setIsLlmCheck(Boolean isLlmCheck) {
        this.isLlmCheck = isLlmCheck;
    }
}
