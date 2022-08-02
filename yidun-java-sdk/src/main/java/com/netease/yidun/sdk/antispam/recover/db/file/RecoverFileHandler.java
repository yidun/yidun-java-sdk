package com.netease.yidun.sdk.antispam.recover.db.file;

/**
 * 恢复文件读处理器
 *
 * @author hzleishaobo
 * @version 2017年9月6日
 */
public interface RecoverFileHandler {

    boolean handle(String line);

}
