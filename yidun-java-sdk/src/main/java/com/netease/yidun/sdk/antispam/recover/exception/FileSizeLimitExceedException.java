/*
 * @(#) FileSizeLimitExceedException.java 2022-07-28
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.recover.exception;

/**
 * @author ruicha
 * @version 2022-07-28
 */
public class FileSizeLimitExceedException extends RuntimeException {

    private static final long serialVersionUID = 6314925228044966088L;

    /**
     * Constructs an <code>FileSizeLimitExceedException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     */
    public FileSizeLimitExceedException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>FileSizeLimitExceedException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     */
    public FileSizeLimitExceedException(String s, Exception ex) {
        super(s, ex);
    }
}
