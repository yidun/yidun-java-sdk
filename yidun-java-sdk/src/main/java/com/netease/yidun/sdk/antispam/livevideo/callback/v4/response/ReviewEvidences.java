package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import lombok.Data;

/**
 * 电视墙人审回调证据信息
 */
@Data
public class ReviewEvidences {

    /**
     * 操作
     */
    private int action;

    /**
     * 判断时间点
     */
    private long actionTime;

    /**
     * 违规类型
     */
    private int label;

    /**
     * 违规详情
     */
    private String detail;

    /**
     * 警告次数
     */
    private int warnCount;

    private String speakerId;

    private String censorAccount;
    /**
     * 截图证据
     */
    private List<Evidence> evidence;
}
