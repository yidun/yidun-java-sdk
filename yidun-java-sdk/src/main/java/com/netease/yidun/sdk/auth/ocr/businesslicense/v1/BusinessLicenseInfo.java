package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

import java.util.Map;

/**
 * 营业执照OCR所得信息
 */
public class BusinessLicenseInfo {

    /** 识别结果数，表示wordsResult的元素个数 */
    private int wordsResultNum;

    /**
     * 识别数据项
     * 
     * @formatter:off
     * key:数据项名称
     * value:数据项文字信息
     * @formatter:on
     */
    private Map<String, WordInfo> wordsResult;

    /** 图像方向
     *
     * @formatter:off
     * -1:未定义
     * 0:正向
     * 1:逆时针90度
     * 2:逆时针180度
     * 3:逆时针270度 
     * @formatter:on
     */
    private int direction = -1;

    public int getWordsResultNum() {
        return wordsResultNum;
    }

    public void setWordsResultNum(int wordsResultNum) {
        this.wordsResultNum = wordsResultNum;
    }

    public Map<String, WordInfo> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(Map<String, WordInfo> wordsResult) {
        this.wordsResult = wordsResult;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "BusinessLicenseInfo(" +
                "wordsResultNum=" + wordsResultNum +
                ", wordsResult=" + wordsResult +
                ", direction=" + direction +
                ")";
    }
}
