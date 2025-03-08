package com.fyber.inneractive.sdk.config.enums;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public enum TapAction {
    CTR("ctr"),
    FULLSCREEN("fullscreen"),
    DO_NOTHING("noAction");
    
    private static final Map<String, TapAction> CONSTANTS = null;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (TapAction tapAction : values()) {
            CONSTANTS.put(tapAction.value, tapAction);
        }
    }

    private TapAction(String str) {
        this.value = str;
    }

    public static TapAction fromValue(String str) {
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
