
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

public class MinValidatorForInteger extends AbstractMinValidator<Integer> {

    public MinValidatorForInteger(Min min) {
        super(min);
    }

    @Override
    protected int compare(Integer number) {
        return ((Long) number.longValue()).compareTo(minValue);
    }
}
