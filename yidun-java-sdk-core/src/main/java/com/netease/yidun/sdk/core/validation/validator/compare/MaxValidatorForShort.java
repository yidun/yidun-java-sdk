
package com.netease.yidun.sdk.core.validation.validator.compare;


import com.netease.yidun.sdk.core.validation.limitation.Max;

public class MaxValidatorForShort extends AbstractMaxValidator<Short> {

    public MaxValidatorForShort(Max max) {
        super(max);
    }

    @Override
    protected int compare(Short number) {
        return ((Long) number.longValue()).compareTo(maxValue);
    }
}
