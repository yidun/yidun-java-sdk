
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArraysOfChar implements LimitationValidator<NotEmpty, char[]> {

    @Override
    public boolean isValid(char[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
