package com.netease.yidun.sdk.antispam.text.v1;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.*;

import java.util.*;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 文本特征接口demo
 */
public class TextFeatureDemo extends AbstractDemo {
    private static final Gson gson = new Gson();

    // 配置信息 - 使用时请替换为实际值
    private static final String SECRET_ID = "your secret id";
    private static final String SECRET_KEY = "your secret key";
    private static final String BUSINESS_ID = "your business id";

    public static void main(String[] args) {
        System.out.println("文本特征管理Demo - 请根据需要调用相应的演示方法");
        System.out.println("使用前请先在代码中配置正确的SECRET_ID、SECRET_KEY和BUSINESS_ID");
        System.out.println();

        // 根据调试需求，可以选择性地调用以下方法：

        // 1. 演示添加文本特征
        demoAddTextFeature();

        // 2. 演示查询文本特征
        demoQueryTextFeature();

        // 3. 演示修改文本特征状态（需要先有文本特征存在）
        // demoEditTextFeatureStatus();

        // 4. 演示删除文本特征（需要先有文本特征存在）
        // demoDeleteTextFeature();
    }

    /**
     * 创建文本客户端
     */
    private static TextClient createTextClient() {
        AntispamRequester antispamRequester = createAntispamRequester(SECRET_ID, SECRET_KEY);
        return TextClient.getInstance(antispamRequester);
    }

    /**
     * 获取现有文本特征的UUID列表（用于编辑和删除演示）
     */
    private static List<String> getExistingTextFeatureUuids() {
        TextClient textClient = createTextClient();
        TextFeatureQueryRequest queryRequest = new TextFeatureQueryRequest();
        queryRequest.setProtocol(ProtocolEnum.HTTP);
        queryRequest.setBusinessId(BUSINESS_ID);
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(10);
        queryRequest.setScope(1);

        TextFeatureQueryResponse queryResponse = textClient.queryTextFeature(queryRequest);
        List<String> uuidList = new ArrayList<>();

        if (queryResponse != null && queryResponse.getResult() != null && queryResponse.getResult().getRows() != null) {
            for (TextFeatureQueryResponse.TextFeatureInfo info : queryResponse.getResult().getRows()) {
                uuidList.add(info.getUuid());
            }
        }

        return uuidList;
    }

    /**
     * 演示添加文本特征
     */
    public static void demoAddTextFeature() {
        System.out.println("========== 演示添加文本特征 ==========");

        TextClient textClient = createTextClient();

        TextFeatureAddRequest addRequest = new TextFeatureAddRequest();
        addRequest.setProtocol(ProtocolEnum.HTTP);
        addRequest.setBusinessId(BUSINESS_ID);
        addRequest.setFeatureType(2);
        addRequest.setLevel(2);
        addRequest.setMatchType(1);
        addRequest.setSpamType(100);
        addRequest.setSubLabel("100001");
        addRequest.setDescription("色情文本特征");
        addRequest.setEntities(gson.toJson(Arrays.asList("色情文本内容一一一aaaa", "色情文本内容二二二bbbbb")));
        addRequest.setScope(1);

        TextFeatureAddResponse addResponse = textClient.addTextFeature(addRequest);
        System.out.println("addTextFeature response: " + gson.toJson(addResponse));

        if (addResponse != null && addResponse.getCode() == 200) {
            System.out.println("文本特征添加成功！");
        } else {
            System.out.println("文本特征添加失败！");
        }
        System.out.println();
    }

    /**
     * 演示查询文本特征
     */
    public static void demoQueryTextFeature() {
        System.out.println("========== 演示查询文本特征 ==========");

        TextClient textClient = createTextClient();

        TextFeatureQueryRequest queryRequest = new TextFeatureQueryRequest();
        queryRequest.setProtocol(ProtocolEnum.HTTP);
        queryRequest.setBusinessId(BUSINESS_ID);
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(10);
        queryRequest.setScope(1);

        TextFeatureQueryResponse queryResponse = textClient.queryTextFeature(queryRequest);
        System.out.println("queryTextFeature response: " + gson.toJson(queryResponse));

        if (queryResponse != null && queryResponse.getCode() == 200) {
            System.out.println("文本特征查询成功！");
            if (queryResponse.getResult() != null && queryResponse.getResult().getRows() != null) {
                System.out.println("共查询到 " + queryResponse.getResult().getRows().size() + " 条文本特征");
            }
        } else {
            System.out.println("文本特征查询失败！");
        }
        System.out.println();
    }

    /**
     * 演示修改文本特征状态
     */
    public static void demoEditTextFeatureStatus() {
        System.out.println("========== 演示修改文本特征状态 ==========");

        TextClient textClient = createTextClient();
        List<String> uuidList = getExistingTextFeatureUuids();

        if (!uuidList.isEmpty()) {
            TextFeatureEditStatusRequest editStatusRequest = new TextFeatureEditStatusRequest();
            editStatusRequest.setProtocol(ProtocolEnum.HTTP);
            editStatusRequest.setBusinessId(BUSINESS_ID);
            editStatusRequest.setUuids(gson.toJson(uuidList));
            editStatusRequest.setStatus(2); // 失效

            TextFeatureEditStatusResponse editStatusResponse = textClient.editTextFeatureStatus(editStatusRequest);
            System.out.println("editTextFeatureStatus response: " + gson.toJson(editStatusResponse));

            if (editStatusResponse != null && editStatusResponse.getCode() == 200) {
                System.out.println("文本特征状态修改成功！");
            } else {
                System.out.println("文本特征状态修改失败！");
            }
        } else {
            System.out.println("没有找到现有的文本特征进行状态修改演示");
        }
        System.out.println();
    }

    /**
     * 演示删除文本特征
     */
    public static void demoDeleteTextFeature() {
        System.out.println("========== 演示删除文本特征 ==========");

        TextClient textClient = createTextClient();
        List<String> uuidList = getExistingTextFeatureUuids();

        if (!uuidList.isEmpty()) {
            TextFeatureDeleteRequest deleteRequest = new TextFeatureDeleteRequest();
            deleteRequest.setProtocol(ProtocolEnum.HTTP);
            deleteRequest.setBusinessId(BUSINESS_ID);
            deleteRequest.setUuids(gson.toJson(uuidList));

            TextFeatureDeleteResponse deleteResponse = textClient.deleteTextFeature(deleteRequest);
            System.out.println("deleteTextFeature response: " + gson.toJson(deleteResponse));

            if (deleteResponse != null && deleteResponse.getCode() == 200) {
                System.out.println("文本特征删除成功！");
            } else {
                System.out.println("文本特征删除失败！");
            }
        } else {
            System.out.println("没有找到现有的文本特征进行删除演示");
        }
        System.out.println();
    }

    
}