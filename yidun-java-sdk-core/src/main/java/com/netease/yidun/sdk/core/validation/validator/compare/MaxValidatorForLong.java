
package com.netease.yidun.sdk.core.validation.validator.compare;


import com.netease.yidun.sdk.core.validation.limitation.Max;

public class MaxValidatorForLong extends AbstractMaxValidator<Long> {

    public MaxValidatorForLong(Max max) {
        super(max);
    }

    @Override
    protected int compare(Long number) {
        return number.compareTo(maxValue);
    }
}
