package com.netease.yidun.sdk.antispam.audio.feedback.v1.response;

import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.Data;

@Data
public class AudioFeedbackUnitResp implements BaseResponse {
    /**
     * 唯一ID
     */
    private String taskId;

    /**
     * 提交状态 0-成功，1-异常，2-数据不存在
     */
    private Integer result;
}
