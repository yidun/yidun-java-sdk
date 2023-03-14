

package com.netease.yidun.sdk.core.utils;

import java.util.List;

public class StringUtils {

    public static final String EMPTY = "";
    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    public static <T extends CharSequence> T defaultIfBlank(final T str, final T defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    public static String upperCase(final String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String upperCaseFirstLetter(final String str) {
        if (isBlank(str)) {
            return str;
        }
        char firstChar = str.charAt(0);
        char upperCaseChar = Character.toUpperCase(firstChar);
        if (firstChar == upperCaseChar) {
            return str;
        }

        char[] chars = str.toCharArray();
        chars[0] = upperCaseChar;
        return new String(chars, 0, chars.length);
    }

    public static String join(List<String> array, String separator) {
        return array == null ? null : join(array.toArray(), separator, 0, array.size());
    }

    public static String join(final Object[] array, final String separator, final int startIndex, final int endIndex) {
        if (array == null) {
            return null;
        }
        final int noOfItems = endIndex - startIndex;
        if (noOfItems <= 0) {
            return EMPTY;
        }
        final StringBuilder buf = newStringBuilder(noOfItems);
        if (array[startIndex] != null) {
            buf.append(array[startIndex]);
        }
        for (int i = startIndex + 1; i < endIndex; i++) {
            buf.append(separator);
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }
    private static StringBuilder newStringBuilder(final int noOfItems) {
        return new StringBuilder(noOfItems * 16);
    }
}
