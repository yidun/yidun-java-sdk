package com.netease.yidun.sdk.antispam.media.v2;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.MediaAntispamEvidence;
import org.junit.Assert;
import org.junit.Test;

public class MediaLlmEvidenceTest {

    private static final Gson GSON = new Gson();

    @Test
    public void testDeserializeProductLlmExtension() {
        String extension = "{\"category\":\"饰品/玄学\",\"QA\":\"1\"}";
        String json = "{\"llms\":[{\"subLabel\":\"400017\",\"keyword\":\"\",\"extension\":"
                + GSON.toJson(extension) + "}]}";

        MediaAntispamEvidence evidence = GSON.fromJson(json, MediaAntispamEvidence.class);

        Assert.assertEquals(1, evidence.getLlms().size());
        Assert.assertEquals("400017", evidence.getLlms().get(0).getSubLabel());
        Assert.assertEquals(extension, evidence.getLlms().get(0).getExtension());
    }
}
