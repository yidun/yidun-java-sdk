/*
 * @(#) MediaAigc.java 2025-08-12
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageAigcV5Detail;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import com.netease.yidun.sdk.core.response.BaseResponse;

/**
 * @version 2025-08-12
 */
public class MediaAigc implements Serializable{
    private static final long serialVersionUID = -2710613242117266355L;
    private List<MediaAigcImageUnit> images;
    private List<MediaAigcVideoUnit> audiovideos;

    public MediaAigc() {
        //
    }

    public List<MediaAigcImageUnit> getImages() {
        return images;
    }

    public void setImages(List<MediaAigcImageUnit> images) {
        this.images = images;
    }

    public List<MediaAigcVideoUnit> getAudiovideos() {
        return audiovideos;
    }

    public void setAudiovideos(List<MediaAigcVideoUnit> audiovideos) {
        this.audiovideos = audiovideos;
    }

    public class MediaAigcImageUnit extends MediaValueAddServiceResponse.ValueServiceBaseResponse {
        private List<ImageAigcV5Detail> details;

        public List<ImageAigcV5Detail> getDetails() {
            return details;
        }

        public void setDetails(List<ImageAigcV5Detail> details) {
            this.details = details;
        }
    }


    public class MediaAigcVideoUnit {
        private String taskId;
        private String dataId;
        private String field;
        /**
         * 是否aigc命中
         */
        private Boolean isAigc;
        private Float aigcRate;
        private Integer aigcLevel;
        /**
         * aigc命中信息
         */
        private MediaSignageInfo signage;

        private List<MediaAigcVideoDetail> pictures;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public List<MediaAigcVideoDetail> getPictures() {
            return pictures;
        }

        public void setPictures(List<MediaAigcVideoDetail> pictures) {
            this.pictures = pictures;
        }

        public Boolean getAigc() {
            return isAigc;
        }

        public void setAigc(Boolean aigc) {
            isAigc = aigc;
        }

        public Float getAigcRate() {
            return aigcRate;
        }

        public void setAigcRate(Float aigcRate) {
            this.aigcRate = aigcRate;
        }

        public Integer getAigcLevel() {
            return aigcLevel;
        }

        public void setAigcLevel(Integer aigcLevel) {
            this.aigcLevel = aigcLevel;
        }

        public MediaSignageInfo getSignage() {
            return signage;
        }

        public void setSignage(MediaSignageInfo signage) {
            this.signage = signage;
        }
    }

    public class MediaAigcVideoDetail implements BaseResponse {
        private Long startTime;
        private Long endTime;
        private String pictureId;
        private List<MediaAigcVideoItemBo> details = new ArrayList<>();

        public Long getStartTime() {
            return startTime;
        }

        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }

        public Long getEndTime() {
            return endTime;
        }

        public void setEndTime(Long endTime) {
            this.endTime = endTime;
        }

        public String getPictureId() {
            return pictureId;
        }

        public void setPictureId(String pictureId) {
            this.pictureId = pictureId;
        }

        public List<MediaAigcVideoItemBo> getDetails() {
            return details;
        }

        public void setDetails(List<MediaAigcVideoItemBo> details) {
            this.details = details;
        }
    }

    public class MediaAigcVideoItemBo implements Serializable {
        /**
         * 是否aigc
         */
        private Boolean isAigc;
        /**
         * aigc分数
         */
        private Float aigcRate;
        /**
         * aigc等级
         */
        private Integer aigcLevel;

        /**
         * aigc命中信息
         */
        private MediaSignageInfo signageInfoDo;

        public Boolean getAigc() {
            return isAigc;
        }

        public void setAigc(Boolean aigc) {
            isAigc = aigc;
        }

        public Float getAigcRate() {
            return aigcRate;
        }

        public void setAigcRate(Float aigcRate) {
            this.aigcRate = aigcRate;
        }

        public Integer getAigcLevel() {
            return aigcLevel;
        }

        public void setAigcLevel(Integer aigcLevel) {
            this.aigcLevel = aigcLevel;
        }

        public MediaSignageInfo getSignageInfoDo() {
            return signageInfoDo;
        }

        public void setSignageInfoDo(MediaSignageInfo signageInfoDo) {
            this.signageInfoDo = signageInfoDo;
        }
    }
}
