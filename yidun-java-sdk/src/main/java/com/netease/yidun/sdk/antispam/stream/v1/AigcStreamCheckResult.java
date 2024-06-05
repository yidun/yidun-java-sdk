/*
 * @(#) AigcStreamCheckResult.java 2024-06-04
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;

import java.io.Serializable;

/**
 * @author ruicha
 * @version 2024-06-04
 */
public class AigcStreamCheckResult implements Serializable {

    /**
     * 当前流式检测活跃会话的主数据 sessionTaskId，能够根据该值定位到该条数据，如对检测结果有异议，可以发送该值给策略经理查询。
     */
    private String sessionTaskId;
    /**
     * 当前流式检测活跃会话的会话ID
     */
    private String sessionId;
    /**
     * 文本内容安全检测结果
     */
    private TextCheckResult.Antispam antispam;
    /**
     * 文本语种检测结果
     */
    private TextCheckResult.Language language;
    /**
     * aigc提示分析结果
     */
    private TextCheckResult.AigcPrompt aigcPrompt;

    public String getSessionTaskId() {
        return sessionTaskId;
    }

    public void setSessionTaskId(String sessionTaskId) {
        this.sessionTaskId = sessionTaskId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public TextCheckResult.Antispam getAntispam() {
        return antispam;
    }

    public void setAntispam(TextCheckResult.Antispam antispam) {
        this.antispam = antispam;
    }

    public TextCheckResult.Language getLanguage() {
        return language;
    }

    public void setLanguage(TextCheckResult.Language language) {
        this.language = language;
    }

    public TextCheckResult.AigcPrompt getAigcPrompt() {
        return aigcPrompt;
    }

    public void setAigcPrompt(TextCheckResult.AigcPrompt aigcPrompt) {
        this.aigcPrompt = aigcPrompt;
    }

    @Override
    public String toString() {
        return "AigcStreamCheckResult{" +
                "sessionTaskId='" + sessionTaskId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", antispam=" + antispam +
                ", language=" + language +
                ", aigcPrompt=" + aigcPrompt +
                '}';
    }
}
