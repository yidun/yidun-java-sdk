package com.netease.yidun.sdk.antispam.audio.query.v3.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class AudioQueryUnitResponseV3 {

    private Integer action;

    /**
     * 语音翻译状态
     */
    private int asrStatus;

    /**
     * 语音翻译失败错误码
     */
    private Integer asrResult;

    private String taskId;

    private List<LabelInfo> labels;

    private int status;

    private String callback;
    private Integer censorSource;
    private Long censorTime;

    public AudioQueryUnitResponseV3(String taskId, int status) {
        this.taskId = taskId;
        this.status = status;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LabelInfo implements BaseResponse {
        private int label;
        private int level;
        private HintInfo details;
        private List<String> subLabels;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HintInfo implements BaseResponse {
        private List<HintDetail> hint;
        private int hitType;
        private List<AudioHitInfo> hitInfos;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioHitInfo {

        /**
         * 命中类型
         */
        private Integer hitType;

        /**
         * 命中原因
         */
        private Integer hitReason;

        /**
         * 命中线索，敏感词/名单
         */
        private List<String> hitClues;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HintDetail implements BaseResponse {
        private String value;
        private List<SegmentsInfo> segments;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SegmentsInfo implements BaseResponse {
        private int startTime;
        private int endTime;
    }
}