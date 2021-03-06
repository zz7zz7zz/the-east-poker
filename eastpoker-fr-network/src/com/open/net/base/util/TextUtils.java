package com.open.net.base.util;

/**
 * author       :   long
 * created on   :   2017/11/30
 * description  :  字符工具类
 */

public class TextUtils {

    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

}
