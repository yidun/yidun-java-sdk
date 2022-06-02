

package com.netease.yidun.sdk.core.exception;

public class YidunSdkException extends RuntimeException {

    private static final long serialVersionUID = -5279264116296505331L;

    public YidunSdkException(String message) {
        super(message);
    }

    public YidunSdkException(Throwable cause) {
        super(cause);
    }

    public YidunSdkException(String message, Throwable cause) {
        super(message, cause);
    }
}
