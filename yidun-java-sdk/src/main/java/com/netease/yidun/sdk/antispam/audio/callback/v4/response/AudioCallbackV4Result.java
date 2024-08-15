
package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

public class AudioCallbackV4Result {
    /**
     * 反垃圾结果
     */
    private AudioAntispamCallbackV4Response antispam;
    /**
     * 语种检测结果
     */
    private AudioLanguageCallbackV4Response language;
    /**
     * 性别检测结果
     */
    private AudioVoiceCallbackV4Response voice;
    /**
     * 语音识别检测结果
     */
    private AudioAsrCallbackV4Response asr;

    /**
     * 质量检测结果
     */
    private AudioQualityCallbackV4Response quality;
    /**
     * 广告检测结果
     */
    private AudioAdCallbackUnitV4Response ad;

    public AudioAntispamCallbackV4Response getAntispam() {
        return antispam;
    }

    public void setAntispam(AudioAntispamCallbackV4Response antispam) {
        this.antispam = antispam;
    }

    public AudioLanguageCallbackV4Response getLanguage() {
        return language;
    }

    public void setLanguage(AudioLanguageCallbackV4Response language) {
        this.language = language;
    }

    public AudioVoiceCallbackV4Response getVoice() {
        return voice;
    }

    public void setVoice(AudioVoiceCallbackV4Response voice) {
        this.voice = voice;
    }

    public AudioAsrCallbackV4Response getAsr() {
        return asr;
    }

    public void setAsr(AudioAsrCallbackV4Response asr) {
        this.asr = asr;
    }

    public AudioQualityCallbackV4Response getQuality() {
        return quality;
    }

    public void setQuality(AudioQualityCallbackV4Response quality) {
        this.quality = quality;
    }

    public AudioAdCallbackUnitV4Response getAd() {
        return ad;
    }

    public void setAd(AudioAdCallbackUnitV4Response ad) {
        this.ad = ad;
    }
}
