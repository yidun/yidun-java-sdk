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

    @Test
    public void testDeserializeAudioAndAudioVideoSubLabelLevel() {
        String json = "{\"result\":[{\"antispam\":{\"evidences\":{"
                + "\"audios\":[{\"segments\":[{\"labels\":[{\"label\":200,"
                + "\"subLabels\":[{\"subLabel\":\"200001\",\"level\":2}]}]}]}],"
                + "\"audiovideos\":[{\"evidences\":{"
                + "\"audio\":{\"segments\":[{\"labels\":[{\"subLabels\":["
                + "{\"subLabel\":\"200002\",\"level\":1}]}]}]},"
                + "\"video\":{\"pictures\":[{\"labels\":[{\"subLabels\":["
                + "{\"subLabel\":\"200003\",\"level\":2}]}]}]}"
                + "}}]"
                + "}}}]}";

        MediaCallbackResponseV2 response = GSON.fromJson(json, MediaCallbackResponseV2.class);
        MediaAntispamEvidence evidence = response.getResult().get(0).getAntispam().getEvidences();

        MediaAudioEvidenceCommon.AudioSubLabel audioSubLabel = evidence.getAudios().get(0)
                .getSegments().get(0).getLabels().get(0).getSubLabels().get(0);
        MediaAudioVideoEvidence.MediaAudioVideoDetailEvidence audioVideoEvidence = evidence
                .getAudiovideos().get(0).getEvidences();
        MediaAudioEvidenceCommon.AudioSubLabel audioVideoAudioSubLabel = audioVideoEvidence.getAudio()
                .getSegments().get(0).getLabels().get(0).getSubLabels().get(0);
        MediaAudioVideoEvidence.AudioSubLabel audioVideoVideoSubLabel = audioVideoEvidence.getVideo()
                .getPictures().get(0).getLabels().get(0).getSubLabels().get(0);

        Assert.assertEquals(Integer.valueOf(2), audioSubLabel.getLevel());
        Assert.assertEquals(Integer.valueOf(1), audioVideoAudioSubLabel.getLevel());
        Assert.assertEquals(Integer.valueOf(2), audioVideoVideoSubLabel.getLevel());
    }
}
