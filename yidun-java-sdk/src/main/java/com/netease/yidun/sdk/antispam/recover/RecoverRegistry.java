/*
 * @(#) RecoverHandlerRegistry.java 2022-06-15
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.antispam.recover.db.file.ErrorRecoverFile;
import com.netease.yidun.sdk.antispam.recover.db.file.RecoverFile;
import com.netease.yidun.sdk.antispam.recover.db.file.RecoverFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ruicha
 * @version 2022-06-15
 */
public final class RecoverRegistry {

    private static final Map<String, RecoverFileHandler> RECOVER_HANDLER_MAP = new ConcurrentHashMap<>();
    private static final Map<String, RecoverFile> LOCAL_RECOVER_FILE_MAP = new ConcurrentHashMap<>();
    private static final List<ErrorRecoverFile> ERROR_RECOVER_FILE_LIST = new ArrayList<>();

    public static void register(String dbName, RecoverFile recoverFile, ErrorRecoverFile errorRecoverFile) {
        if (recoverFile == null || recoverFile.getRecoverFileHandler() == null || errorRecoverFile == null) {
            throw new IllegalArgumentException("Bad argument for RecoverRegistry");
        }
        RECOVER_HANDLER_MAP.put(dbName, recoverFile.getRecoverFileHandler());
        LOCAL_RECOVER_FILE_MAP.put(dbName, recoverFile);
        ERROR_RECOVER_FILE_LIST.add(errorRecoverFile);
    }

    public static RecoverFileHandler lookupHandler(String dbName) {
        return RECOVER_HANDLER_MAP.get(dbName);
    }
    public static RecoverFile lookupFile(String dbName) {
        return LOCAL_RECOVER_FILE_MAP.get(dbName);
    }

    public static List<ErrorRecoverFile> getErrorRecoverFileList() {
        return ERROR_RECOVER_FILE_LIST;
    }
}
