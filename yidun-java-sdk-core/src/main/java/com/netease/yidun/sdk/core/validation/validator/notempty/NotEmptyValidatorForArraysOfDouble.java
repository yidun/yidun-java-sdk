
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfDouble implements LimitationValidator<NotEmpty, double[]> {

    @Override
    public boolean isValid(double[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
