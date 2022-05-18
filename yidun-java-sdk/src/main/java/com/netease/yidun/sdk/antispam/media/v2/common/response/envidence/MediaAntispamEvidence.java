package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.util.List;

/**
 * 融媒体机审证据信息
 */
public class MediaAntispamEvidence {
    private List<MediaTextEvidence> texts;
    private List<MediaImageEvidence> images;
    private List<MediaAudioEvidence> audios;
    private List<MediaAudioVideoEvidence> audiovideos;
    private List<MediaFileEvidence> files;

    public List<MediaTextEvidence> getTexts() {
        return texts;
    }

    public void setTexts(List<MediaTextEvidence> texts) {
        this.texts = texts;
    }

    public List<MediaImageEvidence> getImages() {
        return images;
    }

    public void setImages(List<MediaImageEvidence> images) {
        this.images = images;
    }

    public List<MediaAudioEvidence> getAudios() {
        return audios;
    }

    public void setAudios(List<MediaAudioEvidence> audios) {
        this.audios = audios;
    }

    public List<MediaAudioVideoEvidence> getAudiovideos() {
        return audiovideos;
    }

    public void setAudiovideos(List<MediaAudioVideoEvidence> audiovideos) {
        this.audiovideos = audiovideos;
    }

    public List<MediaFileEvidence> getFiles() {
        return files;
    }

    public void setFiles(List<MediaFileEvidence> files) {
        this.files = files;
    }
}
