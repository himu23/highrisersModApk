package com.applovin.impl.privacy.b;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class d {
    public static boolean e(String str, int i) {
        if (str == null || i < 0 || str.length() <= i || str.charAt(i) != '1') {
            return false;
        }
        return true;
    }

    public static boolean cr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String cs : str.split("\\.")) {
            if (!cs(cs)) {
                return false;
            }
        }
        return true;
    }

    private static boolean cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_-]*$");
    }

    public static boolean ct(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        String[] split = str.split("~", -1);
        if (split.length == 2 && "1".equals(split[0])) {
            return Pattern.matches("(\\d+(\\.\\d+)*)?", split[1]);
        }
        if (split.length != 3 || !"2".equals(split[0]) || !Pattern.matches("(\\d+(\\.\\d+)*)?", split[1]) || split[2].length() < 3 || !split[2].startsWith("dv.") || !Pattern.matches("(\\d+(\\.\\d+)*)?", split[2].substring(3))) {
            return false;
        }
        return true;
    }

    public static Boolean f(int i, String str) {
        if (!ct(str)) {
            return null;
        }
        String[] split = str.split("~", -1);
        List asList = Arrays.asList(split[1].split("\\."));
        String valueOf = String.valueOf(i);
        boolean contains = asList.contains(valueOf);
        if (split[0].equals("1")) {
            return Boolean.valueOf(contains);
        }
        if (contains) {
            return true;
        }
        if (Arrays.asList(split[2].split("\\.")).contains(valueOf)) {
            return false;
        }
        return null;
    }
}
