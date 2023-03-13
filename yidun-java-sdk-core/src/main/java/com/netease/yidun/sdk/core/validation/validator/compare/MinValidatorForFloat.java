
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Min;

import java.math.BigDecimal;

public class MinValidatorForFloat extends AbstractMinValidator<Float> {

    public MinValidatorForFloat(Min min) {
        super(min);
    }

    @Override
    protected int compare(Float number) {
        return BigDecimal.valueOf(number).compareTo(BigDecimal.valueOf(minValue));
    }
}
