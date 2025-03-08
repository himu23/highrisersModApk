package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.model.vast.i;

public class a1 {
    public static boolean a(String str, i iVar) {
        String substring = str != null ? str.substring(str.lastIndexOf(".") + 1) : "";
        String str2 = iVar.toString();
        if (str2.equalsIgnoreCase(substring)) {
            return true;
        }
        if (!substring.equals("jpeg") && !substring.equals("jpg")) {
            return false;
        }
        if (str2.equals("Jpeg") || str2.equals("Jpg")) {
            return true;
        }
        return false;
    }
}
