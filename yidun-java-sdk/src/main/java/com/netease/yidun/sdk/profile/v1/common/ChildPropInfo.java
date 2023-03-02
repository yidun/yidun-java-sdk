/*
 * @(#) ChildPropInfo.java 2022-06-08
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.profile.v1.common;

public class ChildPropInfo {

    /**
     * 置信分数
     */
    private Double score;

    /**
     * 是否为未成年人 0：否  1：是
     */
    private int isUnder18;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getIsUnder18() {
        return isUnder18;
    }

    public void setIsUnder18(int isUnder18) {
        this.isUnder18 = isUnder18;
    }

}
