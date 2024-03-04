package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListAddRequest;
import com.netease.yidun.sdk.irisk.v1.list.IRiskListAddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhouyutong01
 * 名单-添加
 */
public class IRiskListAddDemo extends AbstractDemo {
    private static final Logger logger = LoggerFactory.getLogger(IRiskListAddDemo.class);

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//         ClientProfile profile = createProfile("secretId", "secretKey");
//         IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskListAddRequest request = new IRiskListAddRequest("businessId");
        // 设置名单库编号
        request.setListGroupCode("ayp76c2dmh2k0ktd8jyia2cg22009v02");
        // 设置名单项内容
        request.setContent("CE25575A6C937275EAB775491CA0BF64");
        // 设置添加原因
        request.setDescription("xx添加原因2");
        // 设置释放时间
        request.setExpireTime(1809275212936L);

        IRiskListAddResponse listAddResponse = null;
        try {
            listAddResponse = iRiskClient.listAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listAddResponse != null) {
            if (listAddResponse.getCode() == 200) {
                logger.info("添加成功");
            } else if (listAddResponse.getCode() == 5514) {
                logger.error("请求处理超时");
            } else if (listAddResponse.getCode() == 5515) {
                logger.error("添加失败");
            } else if (listAddResponse.getCode() == 5516) {
                logger.error("名单量超出限制");
            }
            // else if 其它情况 ......
        }
    }
}
