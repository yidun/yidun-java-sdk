package com.netease.yidun.sdk.antispam.text.v1;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v1.textfeature.*;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TextFeatureTest {
    private final static String SECRET_ID = "your secret id";
    private final static String SECRET_KEY = "your secret key";
    private final static String BUSINESS_ID = "your business id";
    private static final Gson gson = new Gson();

    /**
     * 创建文本客户端
     */
    private TextClient createTextClient() {
        AntispamRequester antispamRequester = new AntispamRequester(SECRET_ID, SECRET_KEY);
        return new TextClient(antispamRequester);
    }

    @Test
    public void testAddTextFeature() {
        TextClient textClient = createTextClient();

        // 添加文本特征
        TextFeatureAddRequest addRequest = new TextFeatureAddRequest();
        addRequest.protocol(ProtocolEnum.HTTP);
        addRequest.setBusinessId(BUSINESS_ID);
        addRequest.setFeatureType(2);
        addRequest.setLevel(2);
        addRequest.setMatchType(1);
        addRequest.setSpamType(100);
        addRequest.setSubLabel("100001");
        addRequest.setDescription("色情文本特征");
        addRequest.setEntities(gson.toJson(Arrays.asList("色情文本-1-aaaaaa", "色情文本-2-bbbbbb")));
        addRequest.setScope(1);
        
        TextFeatureAddResponse addResponse = textClient.addTextFeature(addRequest);
        System.out.println("addTextFeature: " + gson.toJson(addResponse));
        
        Assert.assertNotNull(addResponse);
        Assert.assertEquals(200, addResponse.getCode());
    }

    @Test
    public void testQueryTextFeature() {
        TextClient textClient = createTextClient();

        // 查询文本特征
        TextFeatureQueryRequest queryRequest = new TextFeatureQueryRequest();
        queryRequest.protocol(ProtocolEnum.HTTP);
        queryRequest.setBusinessId(BUSINESS_ID);
        queryRequest.setPageNum(1);
        queryRequest.setPageSize(10);
        queryRequest.setScope(1);
        
        TextFeatureQueryResponse queryResponse = textClient.queryTextFeature(queryRequest);
        System.out.println("queryTextFeature: " + gson.toJson(queryResponse));
        
        Assert.assertNotNull(queryResponse);
        Assert.assertEquals(200, queryResponse.getCode());
    }

    @Test
    public void testEditTextFeatureStatus() {
        TextClient textClient = createTextClient();
        List<String> uuidList = Arrays.asList("uuid from query");

        // 只有在存在文本特征时才进行状态修改测试
        if (!uuidList.isEmpty()) {
            TextFeatureEditStatusRequest editStatusRequest = new TextFeatureEditStatusRequest();
            editStatusRequest.protocol(ProtocolEnum.HTTP);
            editStatusRequest.setBusinessId(BUSINESS_ID);
            editStatusRequest.setUuids(gson.toJson(uuidList));
            editStatusRequest.setStatus(2); // 失效
            
            TextFeatureEditStatusResponse editStatusResponse = textClient.editTextFeatureStatus(editStatusRequest);
            System.out.println("editTextFeatureStatus: " + gson.toJson(editStatusResponse));
            
            Assert.assertNotNull(editStatusResponse);
            Assert.assertEquals(200, editStatusResponse.getCode());
        } else {
            System.out.println("No existing text features found for status edit test");
        }
    }

    @Test
    public void testDeleteTextFeature() {
        TextClient textClient = createTextClient();
        List<String> uuidList = Arrays.asList("uuid from query");

        // 只有在存在文本特征时才进行删除测试
        if (!uuidList.isEmpty()) {
            TextFeatureDeleteRequest deleteRequest = new TextFeatureDeleteRequest();
            deleteRequest.protocol(ProtocolEnum.HTTP);
            deleteRequest.setBusinessId(BUSINESS_ID);
            deleteRequest.setUuids(gson.toJson(uuidList));
            
            TextFeatureDeleteResponse deleteResponse = textClient.deleteTextFeature(deleteRequest);
            System.out.println("deleteTextFeature: " + gson.toJson(deleteResponse));
            
            Assert.assertNotNull(deleteResponse);
            Assert.assertEquals(200, deleteResponse.getCode());
        } else {
            System.out.println("No existing text features found for delete test");
        }
    }
}
