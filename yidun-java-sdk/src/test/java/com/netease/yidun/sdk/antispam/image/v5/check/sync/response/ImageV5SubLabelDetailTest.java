package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

public class ImageV5SubLabelDetailTest {

    private static final Gson GSON = new Gson();

    @Test
    public void testDeserializeLlmExtensionFromImageLabels() {
        String extension = " {\"riskCode\":\"A01\",\"score\":0.98} ";
        ImageV5SubLabelDetail.LlmKeyWord llm = parseLlm("风险词", extension);

        Assert.assertEquals("风险词", llm.getKeyword());
        Assert.assertEquals(extension, llm.getExtension());
    }

    @Test
    public void testDeserializeExtensionOnlyLlm() {
        String extension = "{\"riskCode\":\"A02\"}";
        ImageV5SubLabelDetail.LlmKeyWord llm = parseLlm(null, extension);

        Assert.assertNull(llm.getKeyword());
        Assert.assertEquals(extension, llm.getExtension());
    }

    @Test
    public void testKeywordOnlyLlmRemainsCompatible() {
        ImageV5SubLabelDetail.LlmKeyWord llm = parseLlm("风险词", null);

        Assert.assertEquals("风险词", llm.getKeyword());
        Assert.assertNull(llm.getExtension());

        ImageV5SubLabelDetail.LlmKeyWord legacy = new ImageV5SubLabelDetail.LlmKeyWord("旧关键词");
        Assert.assertEquals("旧关键词", legacy.getKeyword());
        Assert.assertNull(legacy.getExtension());
        Assert.assertEquals("{\"keyword\":\"旧关键词\"}", GSON.toJson(legacy));
    }

    private ImageV5SubLabelDetail.LlmKeyWord parseLlm(String keyword, String extension) {
        JsonObject llmJson = new JsonObject();
        if (keyword != null) {
            llmJson.addProperty("keyword", keyword);
        }
        if (extension != null) {
            llmJson.addProperty("extension", extension);
        }
        String json = "{\"result\":[{\"antispam\":{\"labels\":[{\"label\":100,\"subLabels\":["
                + "{\"subLabel\":\"100\",\"details\":{\"llm\":" + GSON.toJson(llmJson) + "}}]}]}}]}";

        ImageV5CheckResponse response = GSON.fromJson(json, ImageV5CheckResponse.class);
        return response.getResult().get(0).getAntispam().getLabels().get(0)
                .getSubLabels().get(0).getDetails().getLlm();
    }
}
