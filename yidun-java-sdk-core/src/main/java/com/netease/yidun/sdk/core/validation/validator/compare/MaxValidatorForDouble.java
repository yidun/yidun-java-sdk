
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Max;

import java.math.BigDecimal;

public class MaxValidatorForDouble extends AbstractMaxValidator<Double> {

    public MaxValidatorForDouble(Max max) {
        super(max);
    }

    @Override
    protected int compare(Double number) {
        return BigDecimal.valueOf(number).compareTo(BigDecimal.valueOf(maxValue));
    }
}
