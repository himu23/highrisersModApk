package com.fyber.inneractive.sdk.config.enums;

import android.text.TextUtils;
import com.ironsource.m2;
import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    LANDSCAPE(m2.h.C, false),
    PORTRAIT(m2.h.D, false),
    USER("user", true),
    NONE("none", true);
    
    private static final Map<String, Orientation> CONSTANTS = null;
    public boolean allowOrientationChange;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (Orientation orientation : values()) {
            CONSTANTS.put(orientation.value, orientation);
        }
    }

    private Orientation(String str, boolean z) {
        this.value = str;
        this.allowOrientationChange = z;
    }

    public static Orientation fromValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return CONSTANTS.get(str);
    }

    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
