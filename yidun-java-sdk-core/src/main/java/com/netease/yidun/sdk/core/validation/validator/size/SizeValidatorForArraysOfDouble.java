
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;

public class SizeValidatorForArraysOfDouble extends AbstractSizeValidator<double[]> {

    public SizeValidatorForArraysOfDouble(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(double[] array) {
        if (array == null) {
            return true;
        }
        return array.length >= min && array.length <= max;
    }
}
