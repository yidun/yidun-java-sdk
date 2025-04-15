package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response.LiveVideoSolutionCallbackV3Result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoEvidence {
    private Integer suggestion;
    private Integer suggestionLevel;
    private Integer label;
    private String secondLabel;
    private String thirdLabel;
    private int type;
    private String url;
    private long beginTime;
    private long endTime;
    private String speakerId;
    private List<LiveVideoSolutionCallbackV3Result.RelatedPicInfo> frontPics;
    /**
     * 专项信息
     */
    private String publicOpinionInfo;
    /**
     * 建议风险等级
     */
    private Integer suggestionRiskLevel;
}
