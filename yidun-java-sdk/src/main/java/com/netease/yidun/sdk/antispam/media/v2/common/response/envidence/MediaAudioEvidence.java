package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

/**
 * 融媒体机审-音频证据信息
 */

public class MediaAudioEvidence extends MediaAudioEvidenceCommon {
    private String dataId;
    private String field;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
