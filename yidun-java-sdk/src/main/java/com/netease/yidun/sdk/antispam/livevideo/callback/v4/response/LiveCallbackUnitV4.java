package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import lombok.Data;

@Data
public class LiveCallbackUnitV4 {
    private LiveWallCallbackUnitV4 antispam;
    private LiveDataCallbackOcrUnitV4 ocr;
    private LiveDataCallbackDiscernUnitV4 discern;
    private LiveDataCallbackLogoUnitV4 logo;
    private LiveDataCallbackQualityUnitV4 quality;
    private LiveDataCallbackFaceUnitV4 face;

    @Data
    public static class LiveWallCallbackUnitV4 {
        /**
         * 数据唯一uuid
         */
        private String taskId;

        /**
         * 数据id
         */
        private String dataId;

        /**
         * 回调参数
         */
        private String callback;
        /**
         * 审核来源
         */
        private Integer censorSource;
        /**
         * 策略类型
         */
        private Integer strategySource;
        /**
         * 状态
         */
        private Integer status;
        /**
         * 检测状态 @See LiveVideoCallbackCodeStatus
         */
        private Integer failureReason;
        /**
         * 审核操作来源
         */
        private Integer operationSource;

        /**
         * 机审结果
         */
        private MachineEvidences evidences;

        /**
         * 人审结果
         */
        private ReviewEvidences reviewEvidences;
        private Integer riskLevel;
        private Integer riskScore;
        private Long duration;
    }
}
