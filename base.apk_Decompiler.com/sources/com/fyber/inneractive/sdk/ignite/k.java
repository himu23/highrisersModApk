package com.fyber.inneractive.sdk.ignite;

import java.util.HashMap;
import java.util.Map;

public enum k {
    TRUE_SINGLE_TAP("tst"),
    SINGLE_TAP("st"),
    NONE("none");
    
    private static final Map<String, k> CONSTANTS = null;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (k kVar : values()) {
            CONSTANTS.put(kVar.value, kVar);
        }
    }

    /* access modifiers changed from: public */
    k(String str) {
        this.value = str;
    }

    public static k a(String str) {
        return CONSTANTS.get(str);
    }

    public boolean e() {
        return this == TRUE_SINGLE_TAP;
    }

    public String f() {
        return this.value;
    }
}
