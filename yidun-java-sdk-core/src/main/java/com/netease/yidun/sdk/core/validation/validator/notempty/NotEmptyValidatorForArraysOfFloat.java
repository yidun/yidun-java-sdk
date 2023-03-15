
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfFloat implements LimitationValidator<NotEmpty, float[]> {

    @Override
    public boolean isValid(float[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
