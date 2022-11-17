
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDataOcrDetailBo {

    /**
     * ocr文本
     */
    private String content;
    /**
     * ocr文本详情
     */
    private List<OcrLineContent> lineContents;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OcrLineContent {
        /**
         * 行ocr文本
         */
        private String lineContent;
        /**
         * 相对坐标
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
        /**
         * 语种信息
         */
        private String lang;
    }
}
