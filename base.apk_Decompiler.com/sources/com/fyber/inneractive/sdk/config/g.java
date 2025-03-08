package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import java.util.Map;

public class g {
    public final Map<String, String> a = new HashMap();

    public boolean a(String str, boolean z) {
        try {
            if (this.a.containsKey(str)) {
                return Boolean.parseBoolean(this.a.get(str));
            }
        } catch (Exception unused) {
        }
        return z;
    }
}
