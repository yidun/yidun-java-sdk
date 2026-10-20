package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class VideoCallbackUnitV4ResponseTest {

    private final Gson gson = new Gson();

    @Test
    public void shouldDeserializeSubLabelLevel() {
        String json = "{\"pictures\":[{\"labels\":[{\"label\":200,\"level\":2,"
                + "\"subLabels\":[{\"subLabel\":\"200001\",\"level\":2}]}]}]}";

        VideoCallbackUnitV4Response response =
                gson.fromJson(json, VideoCallbackUnitV4Response.class);

        ImageV5SubLabelResp subLabel = response.getPictures().get(0)
                .getLabels().get(0).getSubLabels().get(0);
        Assert.assertEquals(Integer.valueOf(2), subLabel.getLevel());
    }

    @Test
    public void shouldKeepSubLabelLevelNullWhenMissing() {
        String json = "{\"pictures\":[{\"labels\":[{\"subLabels\":[{\"subLabel\":\"200001\"}]}]}]}";

        VideoCallbackUnitV4Response response =
                gson.fromJson(json, VideoCallbackUnitV4Response.class);

        Assert.assertNull(response.getPictures().get(0).getLabels().get(0)
                .getSubLabels().get(0).getLevel());
    }
}
