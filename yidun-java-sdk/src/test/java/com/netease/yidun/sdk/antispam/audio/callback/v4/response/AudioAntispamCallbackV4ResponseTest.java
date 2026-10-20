package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class AudioAntispamCallbackV4ResponseTest {

    private final Gson gson = new Gson();

    @Test
    public void shouldDeserializeSubLabelLevel() {
        String json = "{\"segments\":[{\"labels\":[{\"label\":200,\"level\":2,"
                + "\"subLabels\":[{\"subLabel\":\"200001\",\"level\":2}]}]}]}";

        AudioAntispamCallbackV4Response response =
                gson.fromJson(json, AudioAntispamCallbackV4Response.class);

        AudioAntispamCallbackV4Response.AudioSubLabel subLabel = response.getSegments().get(0)
                .getLabels().get(0).getSubLabels().get(0);
        Assert.assertEquals(Integer.valueOf(2), subLabel.getLevel());
    }

    @Test
    public void shouldKeepSubLabelLevelNullWhenMissing() {
        String json = "{\"segments\":[{\"labels\":[{\"subLabels\":[{\"subLabel\":\"200001\"}]}]}]}";

        AudioAntispamCallbackV4Response response =
                gson.fromJson(json, AudioAntispamCallbackV4Response.class);

        Assert.assertNull(response.getSegments().get(0).getLabels().get(0)
                .getSubLabels().get(0).getLevel());
    }
}
