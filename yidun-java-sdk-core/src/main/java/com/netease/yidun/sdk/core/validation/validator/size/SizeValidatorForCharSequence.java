
package com.netease.yidun.sdk.core.validation.validator.size;

import com.netease.yidun.sdk.core.validation.limitation.Size;

public class SizeValidatorForCharSequence extends AbstractSizeValidator<CharSequence> {

    public SizeValidatorForCharSequence(Size size) {
        super(size);
    }

    @Override
    public boolean isValid(CharSequence array) {
        if (array == null) {
            return true;
        }
        int length = array.length();
        return length >= min && length <= max;
    }
}
