package com.netease.yidun.sdk.core.validation.descriptor;

import com.netease.yidun.sdk.core.utils.ArrayUtils;
import com.netease.yidun.sdk.core.utils.ClassUtils;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidatorManager;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitationDescriptor {

    private Map<String, Object> attributes;

    private Annotation limitation;

    private Field field;

    private Type fieldType;

    private LimitationValidator limitationValidator;

    public LimitationDescriptor(Annotation limitation, Field field) {
        this.limitation = limitation;
        this.attributes = getAnnotationAttributes(this.limitation);
        this.field = makeAccessField(field);
        this.fieldType = ClassUtils.boxedType(field.getType());
        this.limitationValidator = LimitationValidatorManager.createValidator(this.fieldType, limitation);
    }

    public Map<String, Object> getAnnotationAttributes(Annotation annotation) {
        final Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        if (ArrayUtils.isEmpty(declaredMethods)) {
            return Collections.emptyMap();
        }

        Map<String, Object> attributes = new HashMap<>(declaredMethods.length);

        for (Method m : declaredMethods) {
            if (m.isSynthetic()) {
                continue;
            }

            m.setAccessible(true);
            try {
                attributes.put(m.getName(), m.invoke(annotation));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                // should never happen
                e.printStackTrace();
            }
        }
        return Collections.unmodifiableMap(attributes);
    }

    private Field makeAccessField(Field field) {
        field.setAccessible(true);
        return field;
    }

    public String getMessage() {
        return getAttribute("message");
    }

    public <T> T getAttribute(String attributeName) {
        Object value = attributes.get(attributeName);
        if (value == null) {
            return null;
        }
        return (T) value;
    }

    public LimitationValidator getLimitationValidator() {
        return limitationValidator;
    }

    public Field getField() {
        return field;
    }
}
