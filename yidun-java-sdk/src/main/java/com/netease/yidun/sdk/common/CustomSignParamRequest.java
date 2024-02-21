package com.netease.yidun.sdk.common;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.ClassUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class CustomSignParamRequest<T extends BaseResponse> extends PostFormRequest<T> {

    /**
     * 通用的请求参数赋值
     */
    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        Class clazz = this.getClass();
        // 所有图像都请求都是继承这个父类，所以这个父类底下的子类的进行序列化的参数检查
        while (clazz != CustomSignParamRequest.class) {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (Modifier.isStatic(declaredField.getModifiers())) {
                    continue;
                }
                try {
                    Object value = getFieldValue(clazz, declaredField);
                    if (value == null) {
                        continue;
                    }
                    if (value instanceof String) {
                        customSignParams.put(declaredField.getName(), (String) value);
                        continue;
                    }
                    if (value instanceof Collection && declaredField.getGenericType() != null &&
                            declaredField.getGenericType() instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) declaredField.getGenericType();
                        Type[] typeArguments = parameterizedType.getActualTypeArguments();
                        if (typeArguments.length > 0 && typeArguments[0] instanceof Class && ClassUtils.isPrimitiveOrWrapper((Class<?>) typeArguments[0])) {
                            // value 的声明类型是泛型类型是基础类型的集合
                            Object signValue = ((Collection) value).stream().map(String::valueOf).collect(Collectors.joining(","));
                            customSignParams.put(declaredField.getName(), signValue.toString());
                            continue;
                        }
                    }

                    customSignParams.put(declaredField.getName(), new Gson().toJson(value));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            clazz = clazz.getSuperclass();
        }

        return customSignParams;
    }

    private Object getFieldValue(Class clazz, Field declaredField) throws IllegalAccessException {
        try {
            Method method = clazz.getMethod("get" + StringUtils.upperCaseFirstLetter(declaredField.getName()));
            return method.invoke(this);
        } catch (Exception e) {
            declaredField.setAccessible(true);
            return declaredField.get(this);
        }
    }

}
