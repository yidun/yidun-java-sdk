/*
 * @(#) ClusterOfflineNodesCleanStarter.java 2022-06-15
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.recover.recovery;

import com.netease.yidun.sdk.antispam.recover.LifeCycle;
import com.netease.yidun.sdk.antispam.recover.RecoverConfig;
import com.netease.yidun.sdk.core.utils.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 恢复文件处理
 * @author ruicha
 * @version 2022-06-15
 */
public class RecoverManager implements LifeCycle {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * 恢复任务初始延时
     */
    private final static long initialDelayInSec = 300;

    private final RecoverConfig recoverConfig;
    private final ScheduledThreadPoolExecutor recoverScheduled;

    public RecoverManager(RecoverConfig recoverConfig) {
        this.recoverConfig = recoverConfig;
        recoverScheduled = new ScheduledThreadPoolExecutor(
                1, new NamedThreadFactory("recover-task", true));
    }

    @Override
    public void start() {
        log.info("RecoverManager start, recoverConfig: {}", recoverConfig);
        try {
            doStart();
        } catch (Throwable e) {
            throw new RuntimeException("RecoverManager start error", e);
        }
    }

    private void doStart() throws IOException {
        // create base dir first, If the directory exists, no exception thrown.
        Files.createDirectories(Paths.get(recoverConfig.getBasePath()));

        recoverScheduled.scheduleWithFixedDelay(
                new RecoverTask(recoverConfig), initialDelayInSec,
                recoverConfig.getClusterCleanIntervalInSec(), TimeUnit.SECONDS
        );
    }

    @Override
    public void stop() {
        recoverScheduled.shutdown();
        try {
            if (!recoverScheduled.awaitTermination(10, TimeUnit.SECONDS)) {
                log.error("await recoverScheduled thread process 10 seconds,don't await anymore");
                recoverScheduled.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("awaitTermination recoverScheduled error", e);
        }
    }
}