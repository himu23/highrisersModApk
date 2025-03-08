package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public abstract class b {
    public String a;
    public Map<String, String> b;
    public i c;
    public p0 d;

    public b(Map<String, String> map, i iVar, p0 p0Var) {
        this.b = map;
        this.d = p0Var;
        this.c = iVar;
    }

    public int a(String str) {
        String str2 = this.b.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public abstract void a();

    public abstract boolean b();
}
