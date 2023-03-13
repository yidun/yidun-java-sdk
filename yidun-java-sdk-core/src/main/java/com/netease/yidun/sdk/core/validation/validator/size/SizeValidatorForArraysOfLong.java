
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;

public class SizeValidatorForArraysOfLong extends AbstractSizeValidator<long[]> {

    public SizeValidatorForArraysOfLong(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(long[] array) {
        if (array == null) {
            return true;
        }
        return array.length >= min && array.length <= max;
    }
}
