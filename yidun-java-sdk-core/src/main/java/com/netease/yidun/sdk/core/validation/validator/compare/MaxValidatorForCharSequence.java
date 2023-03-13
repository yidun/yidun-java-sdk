
package com.netease.yidun.sdk.core.validation.validator.compare;

import com.netease.yidun.sdk.core.validation.limitation.Max;

import java.math.BigDecimal;

public class MaxValidatorForCharSequence extends AbstractMaxValidator<CharSequence> {

    public MaxValidatorForCharSequence(Max max) {
        super(max);
    }

    @Override
    protected int compare(CharSequence number) {
        try {
            return new BigDecimal(number.toString()).compareTo(BigDecimal.valueOf(maxValue));
        } catch (NumberFormatException nfe) {
            return 1;
        }
    }
}
