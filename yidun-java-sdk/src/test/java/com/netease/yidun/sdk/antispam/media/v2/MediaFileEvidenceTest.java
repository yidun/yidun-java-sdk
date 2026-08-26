package com.netease.yidun.sdk.antispam.media.v2;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.antispam.media.v2.common.response.envidence.MediaAntispamEvidence;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class MediaFileEvidenceTest {

    private static final Gson GSON = new Gson();

    @Test
    public void testDeserializeFileTextSubLabels() {
        String json = "{\"files\":[{\"evidences\":{\"texts\":[{\"labels\":[{\"label\":500,\"level\":2,"
                + "\"subLabels\":[{\"subLabel\":\"500001\",\"subLabelDepth\":2,\"secondLabel\":\"500001\","
                + "\"riskDescription\":\"涉政|政治敏感话题\",\"rate\":1.0}]}]}]}}]}";

        MediaAntispamEvidence evidence = GSON.fromJson(json, MediaAntispamEvidence.class);

        Assert.assertEquals(1, evidence.getFiles().size());
        Assert.assertEquals(1, evidence.getFiles().get(0).getEvidences().getTexts().size());
        Assert.assertEquals(1, evidence.getFiles().get(0).getEvidences().getTexts().get(0).getLabels().size());
        List<FileCallbackV2Response.TextSubLabel> subLabels = evidence.getFiles().get(0).getEvidences()
                .getTexts().get(0).getLabels().get(0).getSubLabels();
        Assert.assertEquals("500001", subLabels.get(0).getSubLabel());
        Assert.assertEquals("涉政|政治敏感话题", subLabels.get(0).getRiskDescription());
        Assert.assertEquals(Double.valueOf(1.0), subLabels.get(0).getRate());

        String serialized = GSON.toJson(evidence);
        Assert.assertTrue(serialized.contains("\"subLabel\":\"500001\""));
        Assert.assertFalse(serialized.contains("\"label\":null"));
    }
}
