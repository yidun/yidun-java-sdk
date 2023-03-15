
package com.netease.yidun.sdk.core.validation.validator.notempty;

import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForArray implements LimitationValidator<NotEmpty, Object[]> {

    @Override
    public boolean isValid(Object[] array) {
        if (array == null) {
            return false;
        }
        return array.length > 0;
    }
}
