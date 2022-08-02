package com.netease.yidun.sdk.antispam.image.v5.common;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public abstract class ImageV5Request<T extends BaseResponse> extends BizPostFormRequest<T> {

    public ImageV5Request() {
        productCode = "imageCheck";
        version = "v5.1";
        uriPattern = requestUriPath();
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        Class clazz = this.getClass();
        // 所有图像都请求都是继承这个父类，所以这个父类底下的子类的进行序列化的参数检查
        while (clazz != ImageV5Request.class) {
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
                    if (declaredField.getName().equals("checkLabels")) {
                        // 由于接收端参数声明限制，数组类型的只能以100,200,300这种形式传输，这里做转换
                        String jsonValue = new Gson().toJson(value);
                        String finalValue = jsonValue.substring(1, jsonValue.length() - 1);
                        customSignParams.put(declaredField.getName(), finalValue);
                        continue;
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

    /**
     * request path for different api
     *
     * @return
     */
    protected abstract String requestUriPath();

}
