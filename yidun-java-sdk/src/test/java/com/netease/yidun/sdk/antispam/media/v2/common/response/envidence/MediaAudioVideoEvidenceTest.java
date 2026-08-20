package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class MediaAudioVideoEvidenceTest {

    private final Gson gson = new Gson();

    @Test
    public void shouldDeserializePicCount() {
        MediaAudioVideoEvidence evidence = gson.fromJson("{\"picCount\":37}", MediaAudioVideoEvidence.class);

        Assert.assertEquals(Long.valueOf(37L), evidence.getPicCount());
    }

    @Test
    public void shouldPreserveZeroPicCount() {
        MediaAudioVideoEvidence evidence = gson.fromJson("{\"picCount\":0}", MediaAudioVideoEvidence.class);

        Assert.assertEquals(Long.valueOf(0L), evidence.getPicCount());
    }

    @Test
    public void shouldKeepPicCountNullWhenMissing() {
        MediaAudioVideoEvidence evidence = gson.fromJson("{}", MediaAudioVideoEvidence.class);

        Assert.assertNull(evidence.getPicCount());
    }

    @Test
    public void shouldSerializePicCountWithExpectedJsonName() {
        MediaAudioVideoEvidence evidence = new MediaAudioVideoEvidence();
        evidence.setPicCount(37L);

        Assert.assertEquals("{\"picCount\":37}", gson.toJson(evidence));
    }
}
