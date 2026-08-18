package com.netease.yidun.sdk.core.request;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.validation.ConditionalFieldValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class SensitiveEncryptRequest<T extends BaseResponse> extends BizPostFormRequest<T>
        implements ConditionalFieldValidation {

    private static final Pattern HEX_CIPHERTEXT_PATTERN = Pattern.compile("^[0-9a-fA-F]{32}(?:[0-9a-fA-F]{32})*$");

    protected abstract String getEncryptType();

    protected abstract Map<String, String> getSensitiveFields();

    @Override
    public boolean shouldSkipFieldValidation(String fieldName) {
        return requiresCiphertextValidation() && getSensitiveFields().containsKey(fieldName);
    }

    @Override
    public List<String> validateConditionalFields() {
        List<String> errors = new ArrayList<>();
        if (!requiresCiphertextValidation()) {
            return errors;
        }
        for (Map.Entry<String, String> field : getSensitiveFields().entrySet()) {
            if (!isHexCiphertext(field.getValue())) {
                errors.add(field.getKey() + "密文格式不合法");
            }
        }
        return errors;
    }

    private boolean requiresCiphertextValidation() {
        return "3".equals(getEncryptType()) || "4".equals(getEncryptType());
    }

    private boolean isHexCiphertext(String value) {
        return value != null && HEX_CIPHERTEXT_PATTERN.matcher(value).matches();
    }
}
