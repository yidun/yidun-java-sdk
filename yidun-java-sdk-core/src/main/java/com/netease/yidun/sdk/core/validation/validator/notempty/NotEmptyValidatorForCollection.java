
package com.netease.yidun.sdk.core.validation.validator.notempty;


import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

import java.util.Collection;

public class NotEmptyValidatorForCollection implements LimitationValidator<NotEmpty, Collection> {

    @Override
    public boolean isValid(Collection collection) {
        if (collection == null) {
            return false;
        }
        return collection.size() > 0;
    }
}
