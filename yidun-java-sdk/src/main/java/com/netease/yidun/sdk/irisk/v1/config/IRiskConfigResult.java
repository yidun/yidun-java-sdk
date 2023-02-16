package com.netease.yidun.sdk.irisk.v1.config;


public class IRiskConfigResult {

    /**
     * 配置参数加密数据，应用/游戏方可转交给风控 sdk 解析处理。
     */
    private String configData;


    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }

    @Override
    public String toString() {
        return "IRiskConfigResult(" +
                "configData=" + configData +
                ")";
    }
}