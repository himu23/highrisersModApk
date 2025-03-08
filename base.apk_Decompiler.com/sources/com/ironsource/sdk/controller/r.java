package com.ironsource.sdk.controller;

import com.ironsource.u8;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.UByte;

final class r {
    private static final String b = "MD5";
    private String a;

    r(String str) {
        this.a = str;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    private String a(String str) {
        try {
            return u8.a(str);
        } catch (Exception e) {
            e.printStackTrace();
            return b(str);
        }
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(b);
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(a(str + str2 + this.a));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.a;
    }
}
