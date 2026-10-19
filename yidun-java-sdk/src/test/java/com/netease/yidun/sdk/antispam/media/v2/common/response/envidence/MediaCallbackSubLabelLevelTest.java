package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import org.junit.Assert;
import org.junit.Test;

public class MediaCallbackSubLabelLevelTest {

    private static final Gson GSON = new Gson();

    @Test
    public void testDeserializeTextAndImageSubLabelLevel() {
        String json = "{\"result\":[{\"antispam\":{\"evidences\":{"
                + "\"texts\":[{\"labels\":[{\"label\":500,\"subLabels\":["
                + "{\"subLabel\":\"500087\",\"level\":2}]}]}],"
                + "\"images\":[{\"labels\":[{\"label\":500,\"subLabels\":["
                + "{\"subLabel\":\"50000\",\"level\":1}]}]}]"
                + "}}}]}";

        MediaCallbackResponseV2 response = GSON.fromJson(json, MediaCallbackResponseV2.class);
        MediaAntispamEvidence evidence = response.getResult().get(0).getAntispam().getEvidences();

        MediaTextEvidence.TextSubLabel textSubLabel = evidence.getTexts().get(0)
                .getLabels().get(0).getSubLabels().get(0);
        MediaImageEvidence.ImageSubLabel imageSubLabel = evidence.getImages().get(0)
                .getLabels().get(0).getSubLabels().get(0);

        Assert.assertEquals("500087", textSubLabel.getSubLabel());
        Assert.assertEquals(Integer.valueOf(2), textSubLabel.getLevel());
        Assert.assertEquals("50000", imageSubLabel.getSubLabel());
        Assert.assertEquals(Integer.valueOf(1), imageSubLabel.getLevel());
    }

    @Test
    public void testMissingSubLabelLevelRemainsNull() {
        String json = "{\"result\":[{\"antispam\":{\"evidences\":{"
                + "\"texts\":[{\"labels\":[{\"label\":500,\"subLabels\":["
                + "{\"subLabel\":\"500087\"}]}]}]"
                + "}}}]}";

        MediaCallbackResponseV2 response = GSON.fromJson(json, MediaCallbackResponseV2.class);
        MediaTextEvidence.TextSubLabel subLabel = response.getResult().get(0).getAntispam()
                .getEvidences().getTexts().get(0).getLabels().get(0).getSubLabels().get(0);

        Assert.assertNull(subLabel.getLevel());
    }
}
