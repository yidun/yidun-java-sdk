package com.netease.yidun.sdk.core.utils;

import com.netease.yidun.sdk.core.validation.limitation.Max;
import com.netease.yidun.sdk.core.validation.limitation.Min;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import com.netease.yidun.sdk.core.validation.limitation.Valid;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidationUtilsTest {

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


        ValidationUtils.preheatByInstance(Arrays.asList(obj));
        IllegalArgumentException e = null;

        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            try {
                ValidationUtils.validate(obj);
            } catch (IllegalArgumentException ex) {
                e = ex;
            }
            System.out.println(System.currentTimeMillis() - start);
            assertTrue(System.currentTimeMillis() - start < 10);
        }

        Set<String> subMsgSet = Arrays.stream(e.getMessage().split("\\.")).collect(Collectors.toSet());
        assertEquals(10, subMsgSet.size());

        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为空")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("Int不能为null")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String长度超出范围 1 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("array长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("list长度超出范围 2 - 3")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("int值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("double值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("String值太小, need >= 1")));
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("decimal值太大, need <= -1")));
    }

    @Test
    public void testValidateObject() {
        TestObject obj = new TestObject();
        obj.setFieldObject(new TestFieldObject());


        ValidationUtils.preheatByInstance(Arrays.asList(obj));
        IllegalArgumentException e = null;

        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            try {
                ValidationUtils.validate(obj);
            } catch (IllegalArgumentException ex) {
                e = ex;
            }
            System.out.println(System.currentTimeMillis() - start);
            assertTrue(System.currentTimeMillis() - start < 5);
        }

        String[] subMsgs = e.getMessage().split("\\.");
        assertEquals(11, subMsgs.length);

        Set<String> subMsgSet = Arrays.stream(subMsgs).collect(Collectors.toSet());
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
        assertTrue(subMsgSet.stream().anyMatch(s -> s.contains("decimal值太大, need <= -1")));
    }


    private static class TestSuperObject {
        @Max(value = -1, message = "decimal值太大, need <= {value}")
        private BigDecimal e2 = BigDecimal.ZERO;
    }

    private static class TestObject {

        @NotNull(message = "obj不能为null")
        @Valid
        private List<List<TestListFieldObject>> listField;

        @Valid
        private TestFieldObject fieldObject;

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

     private static class TestFieldObject extends TestSuperObject {

         @Max(value = -1, message = "Long值太大, need <= {value}")
         private Long e = 0L;

         @Max(value = -1, message = "Byte值太大, need <= {value}")
         private Byte e1 = 0;
     }

    private static class TestListFieldObject extends TestSuperObject {
        @NotBlank(message = "不能为空")
        private String a;

        @NotNull(message = "不能为null")
        private String b;

        @Valid
        private Map<String, List<TestListFieldObject>> testMap = new HashMap<>();

        public Map<String, List<TestListFieldObject>> getTestMap() {
            return testMap;
        }
    }
}
