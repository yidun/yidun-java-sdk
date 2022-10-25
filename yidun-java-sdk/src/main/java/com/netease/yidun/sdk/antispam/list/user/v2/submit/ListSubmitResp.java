package com.netease.yidun.sdk.antispam.list.user.v2.submit;

import lombok.Data;

import java.io.Serializable;

/**
 * @author longfan
 * @version 2022-10-24
 */
@Data
public class ListSubmitResp implements Serializable {
    /**
     * 名单类型，1: 用户名单，2: IP名单，3: 设备名单 6: 直播账号名单
     */
    private Integer entityType;
    /**
     * 添加时传入的名单值
     */
    private String entity;
    /**
     * 名单唯一标识，通常为32位长度由数字或者字母组成，用来删除修改和查询
     */
    private String uuid;
    /**
     * 名单是否已存在，false：不存在；true：已存在
     */
    private Boolean exist;
}
