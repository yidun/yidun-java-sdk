package com.netease.yidun.sdk.irisk.v1.list;

import java.util.List;

/**
 * @author zhouyutong01
 * 名单查询-分页结果
 */
public class IRiskListQueryPageResponse {
    /**
     * 总数
     */
    private long count;
    /**
     * 详情数据列表
     */
    private List<IRiskListItemResponse> rows;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<IRiskListItemResponse> getRows() {
        return rows;
    }

    public void setRows(List<IRiskListItemResponse> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "IRiskListQueryPageResponse(" +
                "count=" + count +
                ", rows=" + rows +
                ')';
    }
}
