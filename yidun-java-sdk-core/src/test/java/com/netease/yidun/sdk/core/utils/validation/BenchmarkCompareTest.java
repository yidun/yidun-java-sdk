package com.netease.yidun.sdk.core.utils.validation;

import org.junit.Test;

public class BenchmarkCompareTest {

    @Test
    public void test() {
        HibernateValidationUtilsTest hibernateValidationUtilsTest = new HibernateValidationUtilsTest();
        ValidationUtilsTest validationUtilsTest = new ValidationUtilsTest();

        for (int i = 0; i < 5; i++) {
            long hCost = hibernateValidationUtilsTest.averageValidate();
            long yCost = validationUtilsTest.averageValidate();
            System.out.println(hCost);
            System.out.println(yCost);
            System.out.println(String.format("%.2f", yCost * 100.0 / hCost));
            System.out.println("-------------------------------------");
        }
    }
}
