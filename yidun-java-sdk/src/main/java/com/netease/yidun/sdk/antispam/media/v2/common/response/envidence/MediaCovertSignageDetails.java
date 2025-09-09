/*
 * @(#) CovertSignageDetails.java 2025-09-08
 *
 * Copyright 2025 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzchenyingyou
 * @version 2025-09-08
 */
public class MediaCovertSignageDetails implements Serializable {

    private static final long serialVersionUID = -1882338926731782509L;

    /**
     * 角色
     *
     * @see com.netease.is.antispam.business.video.common.enums.AigcRoleEnum
     */
    private Integer role;
    /**
     * 平台信息
     */
    private MediaCovertSignagePlatform platform;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public MediaCovertSignagePlatform getPlatform() {
        return platform;
    }

    public void setPlatform(MediaCovertSignagePlatform platform) {
        this.platform = platform;
    }
}
