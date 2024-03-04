package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListQueryPageResponse;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListQueryRequest;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListItemResponse;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author zhouyutong01
 * 名单查询
 */
public class IRiskListQueryDemo extends AbstractDemo {
    private static final Logger logger = LoggerFactory.getLogger(IRiskListQueryDemo.class);

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//         ClientProfile profile = createProfile("secretId", "secretKey");
//         IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskListQueryRequest request = new IRiskListQueryRequest("businessId");
        // 设置名单库编号
        request.setListGroupCode("ayp76c2dmh2k0ktd8jyia2cg22009v02");
        // 设置查询分页参数pageNum=n;pageSize默认为50
        request.setPageNum(1);
        // 设置（起）更新时间
        request.setBeginModifyTime(1656296583895L);
        // 设置（止）更新时间
        request.setEndModifyTime(1722752006000L);

        IRiskListQueryResponse listQueryResponse = null;
        try {
            listQueryResponse = iRiskClient.listQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 成功获取
        if (listQueryResponse != null && listQueryResponse.getCode() == 200) {
            IRiskListQueryPageResponse data = listQueryResponse.getData();
            // 总数
            long count = data.getCount();
            if (count == 0) {
                return;
            }
            // 详情列表数据
            List<IRiskListItemResponse> rows = data.getRows();
            for (IRiskListItemResponse row : rows) {
                logger.info("row: {}", row);
            }
        }
    }
}
