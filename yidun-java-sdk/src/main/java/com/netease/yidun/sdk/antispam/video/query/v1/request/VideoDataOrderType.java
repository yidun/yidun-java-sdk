package com.netease.yidun.sdk.antispam.video.query.v1.request;

import java.util.HashMap;
import java.util.Map;

/**
 * 点播截图排序枚举
 */
public enum VideoDataOrderType {
    // @formatter:off
    DEFAULT(0, ""),
    RECEIVE_TIME_ASC(3, " ReceiveTime ASC "),
    RECEIVE_TIME_DESC(4, " ReceiveTime DESC "),
    ;
    // @formatter:off

    private static final Map<Integer, VideoDataOrderType> CODE_MAP = new HashMap<>();

    static {
        for (VideoDataOrderType orderType : VideoDataOrderType.values()) {
            CODE_MAP.put(orderType.getCode(), orderType);
        }
    }

    private int code;
    private String orderStr;

    VideoDataOrderType(int code, String orderStr) {
        this.code = code;
        this.orderStr = orderStr;
    }

    public static String getStrByCode(Integer code) {
        if (null == code) {
            return VideoDataOrderType.DEFAULT.getOrderStr();
        }
        VideoDataOrderType orderType = CODE_MAP.get(code);
        return orderType == null ? VideoDataOrderType.DEFAULT.getOrderStr() : orderType.getOrderStr();
    }

    public int getCode() {
        return code;
    }

    public String getOrderStr() {
        return orderStr;
    }

}
