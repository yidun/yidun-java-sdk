

package com.netease.yidun.sdk.core.utils;

public class StringUtils {

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
}
