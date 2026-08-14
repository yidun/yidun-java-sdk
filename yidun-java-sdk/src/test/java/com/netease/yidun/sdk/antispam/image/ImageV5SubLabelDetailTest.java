package com.netease.yidun.sdk.antispam.image;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5SubLabelDetail;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ImageV5SubLabelDetailTest {

    private static final Gson GSON = new Gson();

    @Test
    public void shouldDeserializeCoordinateLocationsUnderLlm() {
        String json = "{\"llm\":{\"keyword\":\"全网销量第一,未命中\","
                + "\"locations\":[{\"keyword\":\"全网销量第一\",\"x1\":0.2446,\"y1\":0.4053,"
                + "\"x2\":0.5963,\"y2\":0.4435},{\"keyword\":\"未命中\"}]}}";

        ImageV5SubLabelDetail.SubLabelDetails details =
                GSON.fromJson(json, ImageV5SubLabelDetail.SubLabelDetails.class);

        Assert.assertNotNull(details.getLlm());
        Assert.assertEquals("全网销量第一,未命中", details.getLlm().getKeyword());

        List<ImageV5SubLabelDetail.LlmInfo> locations = details.getLlm().getLocations();
        assertLocations(locations);
        Assert.assertFalse(GSON.toJson(details).contains("\"llms\""));
    }

    @Test
    public void shouldKeepLegacyPayloadCompatibleWhenLocationsAreAbsent() {
        String json = "{\"llm\":{\"keyword\":\"全网销量第一\"}}";

        ImageV5SubLabelDetail.SubLabelDetails details =
                GSON.fromJson(json, ImageV5SubLabelDetail.SubLabelDetails.class);

        Assert.assertNotNull(details.getLlm());
        Assert.assertEquals("全网销量第一", details.getLlm().getKeyword());
        Assert.assertNull(details.getLlm().getLocations());
    }

    @Test
    public void shouldDeserializeMediaImageDetailThroughSharedLlmModel() {
        String json = "{\"llm\":{\"keyword\":\"全网销量第一,未命中\","
                + "\"locations\":[{\"keyword\":\"全网销量第一\",\"x1\":0.2446,\"y1\":0.4053,"
                + "\"x2\":0.5963,\"y2\":0.4435},{\"keyword\":\"未命中\"}]}}";

        com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.ImageSubLabelDetail details =
                GSON.fromJson(json,
                        com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.ImageSubLabelDetail.class);

        Assert.assertNotNull(details.getLlm());
        Assert.assertEquals("全网销量第一,未命中", details.getLlm().getKeyword());
        assertLocations(details.getLlm().getLocations());
    }

    @Test
    public void shouldDeserializeFileImageDetailThroughSharedLlmModel() {
        String json = "{\"details\":{\"llm\":{\"keyword\":\"全网销量第一,未命中\","
                + "\"locations\":[{\"keyword\":\"全网销量第一\",\"x1\":0.2446,\"y1\":0.4053,"
                + "\"x2\":0.5963,\"y2\":0.4435},{\"keyword\":\"未命中\"}]}}}";

        com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response.ImageSubLabel subLabel =
                GSON.fromJson(json,
                        com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response.ImageSubLabel.class);

        Assert.assertNotNull(subLabel.getDetails());
        Assert.assertNotNull(subLabel.getDetails().getLlm());
        Assert.assertEquals("全网销量第一,未命中", subLabel.getDetails().getLlm().getKeyword());
        assertLocations(subLabel.getDetails().getLlm().getLocations());
    }

    private static void assertLocations(List<ImageV5SubLabelDetail.LlmInfo> locations) {
        Assert.assertEquals(2, locations.size());
        Assert.assertEquals("全网销量第一", locations.get(0).getKeyword());
        Assert.assertEquals(Float.valueOf(0.2446F), locations.get(0).getX1());
        Assert.assertEquals(Float.valueOf(0.4053F), locations.get(0).getY1());
        Assert.assertEquals(Float.valueOf(0.5963F), locations.get(0).getX2());
        Assert.assertEquals(Float.valueOf(0.4435F), locations.get(0).getY2());
        Assert.assertEquals("未命中", locations.get(1).getKeyword());
        Assert.assertNull(locations.get(1).getX1());
        Assert.assertNull(locations.get(1).getY1());
        Assert.assertNull(locations.get(1).getX2());
        Assert.assertNull(locations.get(1).getY2());
    }
}
