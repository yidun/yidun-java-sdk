
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;

public class SizeValidatorForArraysOfChar extends AbstractSizeValidator<char[]> {

    public SizeValidatorForArraysOfChar(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(char[] array) {
        if (array == null) {
            return true;
        }
        return array.length >= min && array.length <= max;
    }
}
