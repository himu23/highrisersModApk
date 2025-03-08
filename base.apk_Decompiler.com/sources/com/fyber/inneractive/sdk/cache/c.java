package com.fyber.inneractive.sdk.cache;

import com.fyber.inneractive.sdk.util.p;

public class c implements a<String> {
    public final String a;

    public c(String str) {
        this.a = str;
    }

    public Object a(String str) throws Exception {
        return str;
    }

    public String a() {
        return this.a;
    }

    public void a(Object obj) {
        String str = (String) obj;
        if (str != null) {
            p.a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("fmp.endcard.data", str).apply();
        }
    }

    public String b() {
        return "IALastModifiedFromHeader.endcard";
    }

    public String c() {
        return String.valueOf(("fmp.endcard_" + this.a).hashCode());
    }

    public boolean d() {
        return true;
    }
}
