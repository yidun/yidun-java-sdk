/*
 * @(#) ValueAddService.java 2023-12-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5OcrResp;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackOcrV4Response;

import java.util.List;

/**
 * 内容安全增值服务信息
 * @author xietieli
 * @version 2023-12-01
 */
public class ValueAddService{
    private Ocr ocr;

    public Ocr getOcr() {
        return ocr;
    }

    public void setOcr(Ocr ocr) {
        this.ocr = ocr;
    }

    /**
     * 图片反垃圾ocr信息
     */
    public static class Ocr{
        private List<ImageV5OcrResp> images;

        private List<VideoCallbackOcrV4Response> videos;

        public List<ImageV5OcrResp> getImages() {
            return images;
        }

        public void setImages(List<ImageV5OcrResp> images) {
            this.images = images;
        }

        public List<VideoCallbackOcrV4Response> getVideos() {
            return videos;
        }

        public void setVideos(List<VideoCallbackOcrV4Response> videos) {
            this.videos = videos;
        }

        @Override
        public String toString() {
            return "Ocr{" +
                    "images=" + images +
                    ", videos=" + videos +
                    '}';
        }
    }

}
