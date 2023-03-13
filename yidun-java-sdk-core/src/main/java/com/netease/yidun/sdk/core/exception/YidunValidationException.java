package com.netease.yidun.sdk.core.exception;

public class YidunValidationException extends RuntimeException {

    private static final long serialVersionUID = 6608380447932421582L;

    public YidunValidationException(String message) {
        super(message);
    }

    public YidunValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public YidunValidationException(Throwable cause) {
        super(cause);
    }

    protected YidunValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
