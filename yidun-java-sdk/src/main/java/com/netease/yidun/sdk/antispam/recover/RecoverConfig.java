package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.core.utils.NetUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;
import lombok.Data;

import java.io.File;

/**
 * @author ruicha
 * @version 2022-06-23
 */
@Data
public class RecoverConfig {

    public final static String RECOVER_FILE_SUFFIX = ".recover";
    public final static String RECOVER_ERROR_FILE_SUFFIX = ".error";

    /**
     * 恢复器恢复失败之后间隔的时间
     * 默认30s秒
     */
    private long recoverFailRetryIntervalInSec = 30L;

    /**
     * 恢复任务初始延时
     */
    private long initialDelayInSec = 180;

    /**
     * 恢复文件所在的目录
     * base path, should not endsWith /
     */
    private String recoverFileDir;

    /**
     * appName
     */
    private String appName;

    /**
     * 是否ip隔离（当k8s集群使用共享存储pvc挂载恢复文件时使用）
     */
    private boolean ipIsolateEnable;

    /**
     * 单个恢复文件大小限制
     * 默认 20G, < 0 时代表不限制
     */
    private long recoverFileSizeLimitInMB = 1024 * 20;

    /**
     * 恢复文件清理任务 - 执行间隔
     * 根据业务特点，设置不同的interval
     */
    private long clusterCleanIntervalInSec = 60L;

    /**
     * 对于某条数据，恢复的次数上限
     */
    private int recoverThreshold = 15;

    /**
     * 每个恢复文件，每次恢复的行数
     */
    private int recoverLinesPerTime = 100;

    /**
     * true：当尝试恢复数据次数达到上限时，抛弃当前数据
     * 默认为false，即重新追加写入到当前节点的恢复文件中
     */
    private boolean recoverFailAbortEnable = false;

    /**
     * 并行执行恢复任务的线程池大小
     * 业务根据自身情况配置
     */
    private int clusterRecoverPoolSize = 2;

    private final String localAddress = NetUtils.getLocalHost();

    public String getBasePath() {
        String dir = recoverFileDir;
        if(!recoverFileDir.endsWith(File.separator)){
            dir += File.separator;
        }

        return StringUtils.isNotBlank(appName) ?
                dir + appName + File.separator : dir;
    }

    public String getRecoverFilePath(String dbName) {
        return ipIsolateEnable ? getBasePath() + String.format("%s_%s%s", localAddress, dbName, RECOVER_FILE_SUFFIX)
                : getBasePath() + String.format("%s%s", dbName, RECOVER_FILE_SUFFIX);
    }


    public String getRecoverErrorFilePath(String dbName) {
        return getBasePath() + dbName + RECOVER_ERROR_FILE_SUFFIX;
    }

    public String getRecoverLockFilePath() {
        return getBasePath() + "recovery.lock";
    }

    public boolean fileSizeLimitEnable() {
        return recoverFileSizeLimitInMB > 0;
    }

    private final static long ONE_MB_IN_BYTE = 1024 * 1024;

    public long getRecoverFileSizeLimitInByte() {
        return recoverFileSizeLimitInMB * ONE_MB_IN_BYTE;
    }
}
