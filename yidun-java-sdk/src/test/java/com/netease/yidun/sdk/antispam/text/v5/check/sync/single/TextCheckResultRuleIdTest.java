package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * TextCheckResult.AntispamSubLabelDetailRule.ruleId 字段单元测试
 * 覆盖新增字段的反序列化、旧响应兼容性、toString 输出与序列化往返
 *
 * @since 1.4.3
 */
public class TextCheckResultRuleIdTest {

    private Gson gson;

    @Before
    public void setUp() {
        gson = new Gson();
    }

    /**
     * 反序列化完整响应结构，能读到规则详情中的 ruleId
     */
    @Test
    public void testRuleIdDeserializationFromFullResponse() {
        String json = "{\n" +
                "  \"antispam\": {\n" +
                "    \"taskId\": \"task-001\",\n" +
                "    \"labels\": [\n" +
                "      {\n" +
                "        \"label\": 100,\n" +
                "        \"subLabels\": [\n" +
                "          {\n" +
                "            \"subLabel\": 200,\n" +
                "            \"details\": {\n" +
                "              \"rules\": [\n" +
                "                {\"name\": \"敏感词过滤\", \"ruleId\": 12345}\n" +
                "              ]\n" +
                "            }\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        TextCheckResult result = gson.fromJson(json, TextCheckResult.class);

        TextCheckResult.AntispamSubLabelDetailRule rule = result.getAntispam()
                .getLabels().get(0)
                .getSubLabels().get(0)
                .getDetails()
                .getRules().get(0);

        Assert.assertEquals("敏感词过滤", rule.getName());
        Assert.assertEquals(Long.valueOf(12345L), rule.getRuleId());
    }

    /**
     * 旧响应不返回 ruleId 时，应正常解析且 getRuleId() 为 null
     */
    @Test
    public void testMissingRuleIdGracefulHandling() {
        String json = "{\n" +
                "  \"antispam\": {\n" +
                "    \"labels\": [\n" +
                "      {\n" +
                "        \"subLabels\": [\n" +
                "          {\n" +
                "            \"details\": {\n" +
                "              \"rules\": [\n" +
                "                {\"name\": \"敏感词过滤\"}\n" +
                "              ]\n" +
                "            }\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        TextCheckResult result = gson.fromJson(json, TextCheckResult.class);

        TextCheckResult.AntispamSubLabelDetailRule rule = result.getAntispam()
                .getLabels().get(0)
                .getSubLabels().get(0)
                .getDetails()
                .getRules().get(0);

        Assert.assertEquals("敏感词过滤", rule.getName());
        Assert.assertNull("ruleId should be null when not provided", rule.getRuleId());
    }

    /**
     * setter / getter 往返
     */
    @Test
    public void testRuleIdSetterGetterRoundTrip() {
        TextCheckResult.AntispamSubLabelDetailRule rule = new TextCheckResult.AntispamSubLabelDetailRule();
        rule.setName("敏感词过滤");
        rule.setRuleId(12345L);

        Assert.assertEquals(Long.valueOf(12345L), rule.getRuleId());
    }

    /**
     * toString 输出包含 ruleId
     */
    @Test
    public void testToStringContainsRuleId() {
        TextCheckResult.AntispamSubLabelDetailRule rule = new TextCheckResult.AntispamSubLabelDetailRule();
        rule.setName("敏感词过滤");
        rule.setRuleId(12345L);

        String toString = rule.toString();
        Assert.assertTrue("toString should contain ruleId, but was: " + toString, toString.contains("ruleId"));
        Assert.assertTrue("toString should contain ruleId value, but was: " + toString, toString.contains("12345"));
    }

    /**
     * 序列化往返后 ruleId 不丢失
     */
    @Test
    public void testRuleIdSerializationRoundTrip() throws Exception {
        TextCheckResult.AntispamSubLabelDetailRule rule = new TextCheckResult.AntispamSubLabelDetailRule();
        rule.setName("敏感词过滤");
        rule.setRuleId(12345L);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buffer);
        out.writeObject(rule);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        TextCheckResult.AntispamSubLabelDetailRule restored =
                (TextCheckResult.AntispamSubLabelDetailRule) in.readObject();
        in.close();

        Assert.assertEquals("敏感词过滤", restored.getName());
        Assert.assertEquals(Long.valueOf(12345L), restored.getRuleId());
    }
}
