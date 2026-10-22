package com.netease.yidun.sdk.antispam.videosolution.callback.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionAntispamCallbackV2Response;

/**
 * 视频解决方案回调大模型证据解析测试
 *
 * @author zhaojipu
 * @version 2026-10-22
 */
public class VideoSolutionAntispamCallbackV2ResponseTest {

    /**
     * 解析 evidences.llm.videos
     */
    @Test
    public void shouldParseLlmEvidence() {
        String json = "{\"evidences\":{\"llm\":{\"videos\":[{"
                + "\"subLabel\":\"100001\",\"explain\":\"命中说明\",\"keyword\":\"关键词\","
                + "\"isLlmCheck\":true,\"llmStatus\":1}]}}}";

        VideoSolutionAntispamCallbackV2Response response =
                new Gson().fromJson(json, VideoSolutionAntispamCallbackV2Response.class);

        assertEquals(1, response.getEvidences().getLlm().getVideos().size());
        VideoSolutionAntispamCallbackV2Response.LlmEvidenceUnitResponse unit =
                response.getEvidences().getLlm().getVideos().get(0);
        assertEquals("100001", unit.getSubLabel());
        assertEquals("命中说明", unit.getExplain());
        assertEquals("关键词", unit.getKeyword());
        assertTrue(unit.getIsLlmCheck());
        assertEquals(Integer.valueOf(1), unit.getLlmStatus());
    }
}
