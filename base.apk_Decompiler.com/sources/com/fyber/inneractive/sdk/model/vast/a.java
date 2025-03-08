package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;

public class a {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    public a(String str, String str2, String str3) {
        String str4 = null;
        String trim = str != null ? str.trim() : null;
        this.a = trim;
        String trim2 = str2 != null ? str2.trim() : null;
        this.b = trim2;
        str4 = str3 != null ? str3.trim() : str4;
        this.c = str4;
        this.d = !TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(str4) && str4.contains("[TIME]");
    }
}
