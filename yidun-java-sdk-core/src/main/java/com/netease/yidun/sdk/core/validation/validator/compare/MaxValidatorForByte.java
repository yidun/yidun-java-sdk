
package com.netease.yidun.sdk.core.validation.validator.compare;


import com.netease.yidun.sdk.core.validation.limitation.Max;

public class MaxValidatorForByte extends AbstractMaxValidator<Byte> {

    public MaxValidatorForByte(Max max) {
        super(max);
    }

    @Override
    protected int compare(Byte number) {
        return ((Long) number.longValue()).compareTo(maxValue);
    }
}
