package com.netease.yidun.sdk.core.utils.validation;

import com.netease.yidun.sdk.core.utils.ValidationUtils;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.Max;
import com.netease.yidun.sdk.core.validation.limitation.Min;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import com.netease.yidun.sdk.core.validation.limitation.Valid;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidationUtilsTest {

    public long averageValidate() {
        TestObject obj = new TestObject();
        obj.setFieldObject(new TestFieldObject());

        ValidationUtils.preheatByInstance(Arrays.asList(obj));

        int total = 50;
        long count = 0;
        for (int i = 0; i < total; i++) {
            long start = LocalDateTime.now().getNano();
            try {
                ValidationUtils.validate(obj);
            } catch (IllegalArgumentException ex) {
                count += (LocalDateTime.now().getNano() - start) / 1000;
            }
        }

        return count / total;
    }

    @Test
    public void testValidateList() {
        TestObject obj = new TestObject();

        List<TestListFieldObject> listFieldObjects = Arrays.asList(new TestListFieldObject());
        obj.setListField(Arrays.asList(listFieldObjects));

        // 测试循环引用和重复引用
        TestListFieldObject testListFieldObject = obj.getListField().get(0).get(0);
        testListFieldObject.getTestMap().put("key1", Arrays.asList(new TestListFieldObject()));
        testListFieldObject.getTestMap().put("key2", listFieldObjects);
        testListFieldObject.getTestMap().put("key3", Arrays.asList(testListFieldObject));


        IllegalArgumentException e = null;
        try {
            ValidationUtils.validate(obj);
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        Set<String> subMsgSet = Arrays.stream(e.getMessage().split("\\.")).collect(Collectors.toSet());
        assertEquals(11, subMsgSet.size());

        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为空")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Int不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String长度超出范围 1 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("array长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("list长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("int值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("double值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Long值太大, need <= -1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("decimal值太大, need <= -1")));
    }

    @Test
    public void testValidateObject() {
        TestObject obj = new TestObject();
        obj.setFieldObject(new TestFieldObject());


        IllegalArgumentException e = null;
        try {
            ValidationUtils.validate(obj);
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        Set<String> subMsgSet = Arrays.stream(e.getMessage().split("\\.")).collect(Collectors.toSet());
        assertEquals(12, subMsgSet.size());

        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为空")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("obj不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Int不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String长度超出范围 1 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("array长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("list长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("int值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("double值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Long值太大, need <= -1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Byte值太大, need <= -1")));
    }

    @Test
    public void testLimitation() {
        IllegalArgumentException e = null;
        try {
            ValidationUtils.validate(new TestLimitation());
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        Set<String> subMsgSet = Arrays.stream(e.getMessage().split("\\.")).collect(Collectors.toSet());
        assertEquals(3, subMsgSet.size());

        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("最长1个字符")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("int[]不能为空")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("list不能为空")));
    }

    private static class TestLimitation {
        @Length(max = 1, message = "最长{max}个字符")
        private String url = "111";

        @NotEmpty(message = "int[]不能为空")
        private int[] array = new int[0];

        @NotEmpty(message = "list不能为空")
        private List<String> list = new ArrayList<>();
    }

    private static class TestObject {

        @NotNull(message = "obj不能为null")
        @Valid
        private List<List<TestListFieldObject>> listField;

        @Valid
        private TestFieldObject fieldObject;

        @NotBlank(message = "不能为空")
        private String a;

        @NotNull(message = "不能为null")
        private String b;

        @NotNull(message = "Int不能为null")
        private Integer b1;

        @Size(min = 1, max = 3, message = "String长度超出范围 {min} - {max}")
        private String c = "";

        @Size(min = 2, max = 3, message = "array长度超出范围 {min} - {max}")
        private int[] c1 = new int[]{1};

        @Size(min = 2, max = 3, message = "list长度超出范围 {min} - {max}")
        private List<Long> c2 = Arrays.asList(1L, 2L, 3L, 4L);

        @Min(value = 1, message = "int值太小, need >= {value}")
        private int d;

        @Min(value = 1, message = "double值太小, need >= {value}")
        private double d1 = 0.23d;

        @Min(value = 1, message = "String值太小, need >= {value}")
        private String d2 = "0.23";

        public List<List<TestListFieldObject>> getListField() {
            return listField;
        }

        public void setListField(List<List<TestListFieldObject>> listField) {
            this.listField = listField;
        }

        public TestFieldObject getFieldObject() {
            return fieldObject;
        }

        public void setFieldObject(TestFieldObject fieldObject) {
            this.fieldObject = fieldObject;
        }
    }

    private static class TestSuperObject {
        @Max(value = -1, message = "Long值太大, need <= {value}")
        private Long e = 0L;
    }


    private static class TestFieldObject extends TestSuperObject {

        @Max(value = -1, message = "Byte值太大, need <= {value}")
        private Byte e1 = 0;
    }

    private static class TestListFieldObject extends TestSuperObject {

        @Max(value = -1, message = "decimal值太大, need <= {value}")
        private BigDecimal e2 = BigDecimal.ZERO;

        @Valid
        private Map<String, List<TestListFieldObject>> testMap = new HashMap<>();

        public Map<String, List<TestListFieldObject>> getTestMap() {
            return testMap;
        }
    }
}
