
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

public class NotEmptyValidatorForCharSequence implements LimitationValidator<NotEmpty, CharSequence> {

    @Override
    public boolean isValid(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return charSequence.length() > 0;
    }
}
