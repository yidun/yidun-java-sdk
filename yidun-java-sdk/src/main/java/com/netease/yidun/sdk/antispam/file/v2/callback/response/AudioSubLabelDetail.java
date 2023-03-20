package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import java.util.List;

/**
 * 音频标签详细信息
 */
public class AudioSubLabelDetail {

    /**
     * 反垃圾自定义敏感词结果
     */
    private List<AudioSubLabelKeyword> keywords;
    /**
     * 反垃圾自定义图片名单结果
     */
    private List<AudioSubLabelLibInfo> libInfos;
    /**
     * 反垃圾其他命中信息
     */
    private List<AudioSubLabelHitInfo> hitInfos;

    public List<AudioSubLabelKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<AudioSubLabelKeyword> keywords) {
        this.keywords = keywords;
    }

    public List<AudioSubLabelLibInfo> getLibInfos() {
        return libInfos;
    }

    public void setLibInfos(List<AudioSubLabelLibInfo> libInfos) {
        this.libInfos = libInfos;
    }

    public List<AudioSubLabelHitInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<AudioSubLabelHitInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }

    @Override
    public String toString() {
        return "AudioSubLabelDetail{" +
                "keywords=" + keywords +
                ", libInfos=" + libInfos +
                ", hitInfos=" + hitInfos +
                '}';
    }

    public static class AudioSubLabelKeyword {
        /**
         * 自定义添加敏感词
         */
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return "AudioSubLabelLibInfo{" +
                    "word='" + word + '\'' +
                    '}';
        }
    }

    public static class AudioSubLabelLibInfo {
        /**
         * 名单类型
         */
        private Integer listType;
        /**
         * 名单内容
         */
        private String entity;

        public Integer getListType() {
            return listType;
        }

        public void setListType(Integer listType) {
            this.listType = listType;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        @Override
        public String toString() {
            return "AudioSubLabelLibInfo{" +
                    "listType=" + listType +
                    ", entity='" + entity + '\'' +
                    '}';
        }
    }


    public static class AudioSubLabelHitInfo {
        /**
         * 命中的敏感词或者声纹检测的分值
         */
        private String value;
        /**
         * 命中的涉政歌曲名称
         */
        private String songName;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        @Override
        public String toString() {
            return "AudioSubLabelKeyword{" +
                    "value='" + value + '\'' +
                    ", songName='" + songName + '\'' +
                    '}';
        }
    }
}
