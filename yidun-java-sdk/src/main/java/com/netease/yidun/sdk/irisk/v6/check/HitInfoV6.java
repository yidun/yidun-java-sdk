package com.netease.yidun.sdk.irisk.v6.check;

/**
 * 命中标签信息
 */
public class HitInfoV6 {

    /**
     * 命中的风险标签type
     */
    private String type;

    /**
     * 命中的风险标签对应的名称，命中的标签的上下级名称采用‘-’进行拼接
     */
    private String name;

    /**
     * 风险标签的描述信息
     */
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HitInfoV6(" +
                "type=" + type +
                ", name=" + name +
                ", desc=" + desc +
                ")";
    }
}