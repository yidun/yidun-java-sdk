
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfInt implements LimitationValidator<NotEmpty, int[]> {

    @Override
    public boolean isValid(int[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
