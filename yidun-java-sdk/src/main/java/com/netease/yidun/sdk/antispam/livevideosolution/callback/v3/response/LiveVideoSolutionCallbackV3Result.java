package com.netease.yidun.sdk.antispam.livevideosolution.callback.v3.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response.LiveAudioCallbackUnitRespV4;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.ImageV5SubLabelResp;
import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LiveVideoSolutionCallbackV3Result implements BaseResponse {
    LiveVideoSolutionCallbackAntispamV3Result antispam;

    @Data
    public static class LiveVideoSolutionCallbackAntispamV3Result {
        private String taskId;
        private String callback;
        private String dataId;
        private Integer status;
        private Long time;
        private Integer censorSource;
        private LiveSolutionDataCallbackResult evidences;
        private LiveSolutionCensorCallbackResult reviewEvidences;
        private Integer riskLevel;
        private Integer riskScore;
        private Long duration;
    }

    @Data
    public static class LiveSolutionDataCallbackResult implements BaseResponse {
        private LiveAudioCallbackUnitRespV4 audio;
        private MachineEvidences video;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SegmentsInfo implements BaseResponse {
        private int label;
        private int level;
        private List<AudioSubLabel> subLabels;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioSubLabel implements BaseResponse {
        private HintInfo details;
        private String subLabel;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HintInfo implements BaseResponse {
        private String evidence;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MachineEvidences implements BaseResponse {
        private VideoEvidence evidence;
        private List<CallbackImageLabel> labels;
    }

    @Data
    public static class CallbackImageLabel implements BaseResponse {
        private Integer label;
        private Integer level;
        private Float rate;
        private List<ImageV5SubLabelResp> subLabels;
    }

    @Data
    public static class ImageSubLabel implements BaseResponse {
        /**
         * ???????????????label
         */
        private int subLabel;
        /**
         * ???????????????0-?????????1-????????????2-??????
         */
        private float rate;
        /**
         * ??????????????????0???1
         */
        private SubLabelDetails details;
    }

    @Data
    public static class SubLabelDetails implements BaseResponse {
        /**
         * ????????????????????????????????????????????????????????????
         */
        private Set<String> hitInfos = new HashSet<>();

        /**
         * ???????????????
         */
        private AnticheatInfo anticheatInfo;
        /**
         * ????????????????????????
         */
        private List<ImageTagInfo> imageTagInfos;
        /**
         * ????????????????????????????????????
         */
        private List<ImageListInfo> imageListInfos;
        /**
         * ????????????????????????
         */
        private List<HitLocationInfo> hitLocationInfos;
    }

    @Data
    public static class AnticheatInfo implements BaseResponse {
        private Integer hitType;
    }

    @Data
    public static class ImageTagInfo implements BaseResponse {
        private String tagName;
        private String tagGroup;
    }

    @Data
    public static class ImageListInfo implements BaseResponse {
        /**
         * 1???????????????????????????2?????????????????????
         */
        private Integer type;
        private String url;
        private Integer hitCount;
        private String word;
    }

    @Data
    public static class HitLocationInfo implements BaseResponse {
        /**
         * ????????????
         */
        private String hitInfo;
        /**
         * ?????????????????? ????????????
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoEvidence implements BaseResponse {
        private Integer suggestion;
        private int type;
        private String url;
        private long beginTime;
        private long endTime;
        private String speakerId;
        private List<RelatedPicInfo> frontPics;
    }

    @Data
    public static class RelatedPicInfo {
        private String url;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LiveSolutionCensorCallbackResult implements BaseResponse {
        /**
         * ??????
         */
        private int action;
        /**
         * ???????????????
         */
        private long actionTime;
        /**
         * ????????????
         */
        private int label;
        /**
         * ????????????
         */
        private String detail;
        /**
         * ????????????
         */
        private int warnCount;
        /**
         * ????????????
         */
        private List<Evidence> evidence;
    }

    @Data
    @AllArgsConstructor
    public static class Evidence implements BaseResponse {
        private String snapshot;
    }
}
