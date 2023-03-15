package com.netease.yidun.sdk.core.validation.limitation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Limitation
@Target({FIELD})
@Retention(RUNTIME)
public @interface Length {

    String message() default "length must be between {min} and {max}";

    int min() default 0;

    int max() default Integer.MAX_VALUE;
}
