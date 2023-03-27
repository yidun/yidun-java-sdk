package com.netease.yidun.sdk.core.validation.limitation;

import com.netease.yidun.sdk.core.validation.limitation.Limitation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Limitation
public @interface CheckName {
    String message() default "姓名格式非法";

    Class<?>[] groups() default {};

}
