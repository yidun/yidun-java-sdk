package com.netease.yidun.sdk.antispam.livevideo.query.v1.request;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 * 直播截图排序
 */
public enum LiveDataOrderType {
    // @formatter:off
    DEFAULT(0, ""),
    RECEIVETIME_ASC(9, " ReceiveTime ASC "),
    RECEIVETIME_DESC(10, " ReceiveTime DESC "),
    ;
    // @formatter:off

    private static final Map<Integer, LiveDataOrderType> CODE_MAP = new HashMap<>();

    static {
        for (LiveDataOrderType liveDataOrderType : LiveDataOrderType.values()) {
            CODE_MAP.put(liveDataOrderType.getCode(), liveDataOrderType);
        }
    }

    @Getter
    private int code;

    @Getter
    private String orderStr;

    LiveDataOrderType(int code, String orderStr) {
        this.code = code;
        this.orderStr = orderStr;
    }

    public static String getStrByCode(Integer code) {
        LiveDataOrderType liveDataOrderType = CODE_MAP.get(code);
        return liveDataOrderType == null ? LiveDataOrderType.DEFAULT.getOrderStr() : liveDataOrderType.getOrderStr();
    }
}
