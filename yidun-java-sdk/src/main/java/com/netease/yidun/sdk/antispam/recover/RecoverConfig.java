package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.core.utils.NetUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;
import lombok.Data;

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
     * 默认5s秒
     */
    private long recoverFailRetryIntervalInSec = 5L;

    /**
     * 兼容老逻辑
     * 可以被覆盖
     * base path, should not endsWith /
     */
    private String recoverFileDir = System.getProperty("log.dir");

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
     * 默认 -1, < 0 时代表不限制
     */
    private long recoverFileSizeLimitInMB = -1;

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
        return StringUtils.isNotBlank(appName) ?
                recoverFileDir + "/" + appName : recoverFileDir;
    }

    public String getRecoverFilePath(String dbName) {
        return ipIsolateEnable ? String.format("%s/%s_%s%s", getBasePath(), localAddress, dbName, RECOVER_FILE_SUFFIX)
                : String.format("%s/%s%s", getBasePath(), dbName, RECOVER_FILE_SUFFIX);
    }


    public String getRecoverErrorFilePath(String dbName) {
        return String.format("%s/%s%s", getBasePath(), dbName, RECOVER_ERROR_FILE_SUFFIX);
    }

    public String getRecoverLockFilePath() {
        return String.format("%s/recovery.lock", getBasePath());
    }

    public boolean fileSizeLimitEnable() {
        return recoverFileSizeLimitInMB > 0;
    }

    private final static long ONE_MB_IN_BYTE = 1024 * 1024;

    public long getRecoverFileSizeLimitInByte() {
        return recoverFileSizeLimitInMB * ONE_MB_IN_BYTE;
    }
}
