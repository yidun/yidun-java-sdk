

package com.netease.yidun.sdk.core.exception;

public class YidunSdkRespException extends YidunSdkException {

    public static final Integer SERVER = 1;
    public static final Integer OTHER = 2;

    private static final long serialVersionUID = 8599413962196676770L;

    private Integer code;

    public YidunSdkRespException(String message) {
        super(message);
    }

    public YidunSdkRespException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public YidunSdkRespException(Throwable cause) {
        super(cause);
    }

    public YidunSdkRespException(String message, Throwable cause) {
        super(message, cause);
    }

    public YidunSdkRespException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
