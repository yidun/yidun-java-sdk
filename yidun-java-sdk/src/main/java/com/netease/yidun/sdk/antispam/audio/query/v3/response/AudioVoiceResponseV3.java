package com.netease.yidun.sdk.antispam.audio.query.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioVoiceResponseV3 {
    private String taskId;
    private String mainGender;
    private Integer status;
}
