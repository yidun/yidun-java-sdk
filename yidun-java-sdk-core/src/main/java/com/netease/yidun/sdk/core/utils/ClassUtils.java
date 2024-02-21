package com.netease.yidun.sdk.core.utils;

import com.netease.yidun.sdk.core.exception.YidunValidationException;
import com.netease.yidun.sdk.core.validation.validator.LimitationValidator;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassUtils {

    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPES;

    private static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP;

    static {
        Map<Class<?>, Class<?>> tmpMap = new HashMap<>(9);

        tmpMap.put(boolean.class, Boolean.class);
        tmpMap.put(char.class, Character.class);
        tmpMap.put(double.class, Double.class);
        tmpMap.put(float.class, Float.class);
        tmpMap.put(long.class, Long.class);
        tmpMap.put(int.class, Integer.class);
        tmpMap.put(short.class, Short.class);
        tmpMap.put(byte.class, Byte.class);
        tmpMap.put(Void.TYPE, Void.TYPE);

        PRIMITIVE_TO_WRAPPER_TYPES = Collections.unmodifiableMap(tmpMap);

        Map<Class<?>, Class<?>> tmpWrapperMap = new HashMap<>(9);
        tmpWrapperMap.put(Boolean.class, Boolean.TYPE);
        tmpWrapperMap.put(Byte.class, Byte.TYPE);
        tmpWrapperMap.put(Character.class, Character.TYPE);
        tmpWrapperMap.put(Short.class, Short.TYPE);
        tmpWrapperMap.put(Integer.class, Integer.TYPE);
        tmpWrapperMap.put(Long.class, Long.TYPE);
        tmpWrapperMap.put(Double.class, Double.TYPE);
        tmpWrapperMap.put(Float.class, Float.TYPE);
        tmpWrapperMap.put(Void.TYPE, Void.TYPE);

        WRAPPER_PRIMITIVE_MAP = Collections.unmodifiableMap(tmpWrapperMap);
    }

    /**
     * 判断是否是基本类型的包装类
     *
     * @param type
     * @return
     */
    public static boolean isPrimitiveWrapper(final Class<?> type) {
        return WRAPPER_PRIMITIVE_MAP.containsKey(type);
    }

    /**
     * 判断是否是基本类型或者基本类型的包装类
     *
     * @param type
     * @return
     */
    public static boolean isPrimitiveOrWrapper(final Class<?> type) {
        if (type == null) {
            return false;
        }
        return type.isPrimitive() || isPrimitiveWrapper(type);
    }

    public static boolean isYidunClass(Class clazz) {
        return clazz.getPackage() != null && clazz.getPackage().getName().startsWith("com.netease.yidun");
    }

    public static List<Class> getHierarchyClass(Class clazz) {
        List<Class> classes = new ArrayList<>();

        getHierarchyClass(clazz, classes);
        return classes;
    }

    private static void getHierarchyClass(Class clazz, List<Class> classes) {
        for (Class current = clazz; current != null; current = current.getSuperclass()) {
            if (classes.contains(current)) {
                return;
            }

            if (!clazz.isInterface()) {
                classes.add(current);
            }
        }
    }

    private static Class<?> internalBoxedType(Class<?> primitiveType) {
        Class<?> wrapperType = PRIMITIVE_TO_WRAPPER_TYPES.get(primitiveType);

        if (wrapperType == null) {
            throw new YidunValidationException("not support primitiveType " + primitiveType.getClass().getName());
        }

        return wrapperType;
    }

    public static Type boxedType(Type type) {
        if (type instanceof Class && ((Class<?>) type).isPrimitive()) {
            return internalBoxedType((Class<?>) type);
        } else {
            return type;
        }
    }

    /**
     * 暂时只支持了class和array，不包括泛型
     *
     * @param supertype
     * @param type
     * @return
     */
    public static boolean isAssignable(Type supertype, Type type) {
        if (supertype.equals(type)) {
            return true;
        }

        if (supertype instanceof Class<?>) {
            if (type instanceof Class<?>) {
                return isClassAssignable((Class<?>) supertype, (Class<?>) type);
            }

            if (type instanceof GenericArrayType) {
                if (((Class<?>) supertype).isArray()) {
                    return isAssignable(getComponentType(supertype), getComponentType(type));
                }

                return isArraySupertype((Class<?>) supertype);
            }

            return false;
        }

        if (supertype instanceof GenericArrayType) {
            if (isArray(type)) {
                return isAssignable(getComponentType(supertype), getComponentType(type));
            }

            return false;
        }

        return false;
    }

    public static boolean isArray(Type type) {
        return (type instanceof Class<?> && ((Class<?>) type).isArray())
                || (type instanceof GenericArrayType);
    }

    /**
     * 暂时只支持了class，不包括primitive type
     *
     * @param supertype
     * @param type
     * @return
     */
    private static boolean isClassAssignable(Class<?> supertype, Class<?> type) {

        return supertype.isAssignableFrom(type);
    }

    private static boolean isArraySupertype(Class<?> type) {
        return Object.class.equals(type)
                || Cloneable.class.equals(type)
                || Serializable.class.equals(type);
    }

    public static Type getComponentType(Type type) {
        if (type instanceof Class<?>) {
            Class<?> klass = (Class<?>) type;

            return klass.isArray() ? klass.getComponentType() : null;
        }

        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }

        return null;
    }

    public static Type getArrayType(Type componentType) {

        if (componentType instanceof Class<?>) {
            return Array.newInstance((Class<?>) componentType, 0).getClass();
        }

        return genericArrayType(componentType);
    }

    public static GenericArrayType genericArrayType(final Type componentType) {
        return new GenericArrayType() {
            @Override
            public Type getGenericComponentType() {
                return componentType;
            }
        };
    }

    public static Type resolveTypes(Map<Type, Type> resolvedTypes, Type type) {
        if (type == null) {
            return null;
        } else if (type instanceof Class) {
            Class<?> clazz = (Class<?>) type;
            final Type returnedType = resolveTypeForClassAndHierarchy(resolvedTypes, clazz);
            if (returnedType != null) {
                return returnedType;
            }
        } else if (type instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) type;
            if (!(paramType.getRawType() instanceof Class)) {
                return null;
            }
            Class<?> rawType = (Class<?>) paramType.getRawType();

            TypeVariable<?>[] originalTypes = rawType.getTypeParameters();
            Type[] partiallyResolvedTypes = paramType.getActualTypeArguments();
            int nbrOfParams = originalTypes.length;
            for (int i = 0; i < nbrOfParams; i++) {
                resolvedTypes.put(originalTypes[i], partiallyResolvedTypes[i]);
            }

            if (rawType.equals(LimitationValidator.class)) {
                return type;
            } else {
                Type returnedType = resolveTypeForClassAndHierarchy(resolvedTypes, rawType);
                if (returnedType != null) {
                    return returnedType;
                }
            }
        }
        return null;
    }

    private static Type resolveTypeForClassAndHierarchy(Map<Type, Type> resolvedTypes, Class<?> clazz) {
        Type returnedType = resolveTypes(resolvedTypes, clazz.getGenericSuperclass());
        if (returnedType != null) {
            return returnedType;
        }
        for (Type genericInterface : clazz.getGenericInterfaces()) {
            returnedType = resolveTypes(resolvedTypes, genericInterface);
            if (returnedType != null) {
                return returnedType;
            }
        }
        return null;
    }
}
