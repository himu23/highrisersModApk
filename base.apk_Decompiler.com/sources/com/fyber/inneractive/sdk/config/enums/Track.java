package com.fyber.inneractive.sdk.config.enums;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public enum Track {
    ERRORS("errors"),
    NETWORKING("networking"),
    VIEWABILITY("viewability");
    
    private static final Map<String, Track> CONSTANTS = null;
    private final String stringValue;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (Track track : values()) {
            CONSTANTS.put(track.stringValue, track);
        }
    }

    private Track(String str) {
        this.stringValue = str;
    }

    public static Track fromValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return CONSTANTS.get(str);
    }

    public String toString() {
        return this.stringValue;
    }

    public String value() {
        return this.stringValue;
    }
}
