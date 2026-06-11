/*
 * @(#) ValueAddService.java 2023-12-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLlmCheckCallbackV4Response;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5OcrResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.LlmCheckInfo;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackLlmCheckV4Info;

import java.util.List;

/**
 * 内容安全增值服务信息
 * @author xietieli
 * @version 2023-12-01
 */
public class ValueAddService{
    private Ocr ocr;
    /**
     * 大模型检测信息
     */
    private LlmCheckResult llmCheckInfo;

    public Ocr getOcr() {
        return ocr;
    }

    public void setOcr(Ocr ocr) {
        this.ocr = ocr;
    }

    public LlmCheckResult getLlmCheckInfo() {
        return llmCheckInfo;
    }

    public void setLlmCheckInfo(LlmCheckResult llmCheckInfo) {
        this.llmCheckInfo = llmCheckInfo;
    }

    /**
     * 图片反垃圾ocr信息
     */
    public static class Ocr{
        private List<ImageV5OcrResp> images;

        public List<ImageV5OcrResp> getImages() {
            return images;
        }

        public void setImages(List<ImageV5OcrResp> images) {
            this.images = images;
        }
    }

    /**
     * 大模型检测信息
     */
    public static class LlmCheckResult {
        private List<TextLlmCheckDetail> texts;
        private List<ImageLlmCheckDetail> images;
        private List<VideoLlmCheckDetail> videos;
        private List<AudioLlmCheckDetail> audios;

        public List<TextLlmCheckDetail> getTexts() {
            return texts;
        }

        public void setTexts(List<TextLlmCheckDetail> texts) {
            this.texts = texts;
        }

        public List<ImageLlmCheckDetail> getImages() {
            return images;
        }

        public void setImages(List<ImageLlmCheckDetail> images) {
            this.images = images;
        }

        public List<VideoLlmCheckDetail> getVideos() {
            return videos;
        }

        public void setVideos(List<VideoLlmCheckDetail> videos) {
            this.videos = videos;
        }

        public List<AudioLlmCheckDetail> getAudios() {
            return audios;
        }

        public void setAudios(List<AudioLlmCheckDetail> audios) {
            this.audios = audios;
        }

        @Override
        public String toString() {
            return "LlmCheckResult{" +
                    "texts=" + texts +
                    ", images=" + images +
                    ", videos=" + videos +
                    ", audios=" + audios +
                    '}';
        }
    }

    /**
     * 文本大模型检测结果单元
     */
    public static class TextLlmCheckDetail {
        private String dataId;
        private String taskId;
        private List<TextCheckResult.LlmCheckInfoDetail> details;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public List<TextCheckResult.LlmCheckInfoDetail> getDetails() {
            return details;
        }

        public void setDetails(List<TextCheckResult.LlmCheckInfoDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "TextLlmCheckDetail{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

    /**
     * 图片大模型检测结果单元
     */
    public static class ImageLlmCheckDetail {
        private String dataId;
        private String taskId;
        private List<LlmCheckInfo> details;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public List<LlmCheckInfo> getDetails() {
            return details;
        }

        public void setDetails(List<LlmCheckInfo> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "ImageLlmCheckDetail{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

    /**
     * 视频大模型检测结果单元
     */
    public static class VideoLlmCheckDetail {
        private String dataId;
        private String taskId;
        private List<VideoCallbackLlmCheckV4Info.LlmCheckPicture> pictures;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public List<VideoCallbackLlmCheckV4Info.LlmCheckPicture> getPictures() {
            return pictures;
        }

        public void setPictures(List<VideoCallbackLlmCheckV4Info.LlmCheckPicture> pictures) {
            this.pictures = pictures;
        }

        @Override
        public String toString() {
            return "VideoLlmCheckDetail{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", pictures=" + pictures +
                    '}';
        }
    }

    /**
     * 音频大模型检测结果单元
     */
    public static class AudioLlmCheckDetail {
        private String dataId;
        private String taskId;
        private List<AudioLlmCheckCallbackV4Response.LlmCheckDetail> details;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public List<AudioLlmCheckCallbackV4Response.LlmCheckDetail> getDetails() {
            return details;
        }

        public void setDetails(List<AudioLlmCheckCallbackV4Response.LlmCheckDetail> details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "AudioLlmCheckDetail{" +
                    "dataId='" + dataId + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", details=" + details +
                    '}';
        }
    }

}
