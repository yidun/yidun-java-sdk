package com.netease.yidun.sdk.antispam.audio.query.v3.response;

import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.Data;

@Data
public class AudioQueryV3Response extends CommonResponse {
    private List<AudioQueryUnitResponseV3> antispam;
    private List<AudioLanguageResponseV3> language;
    private List<AudioAsrContextResponseV3> asr;
    private List<AudioVoiceResponseV3> voice;

}
