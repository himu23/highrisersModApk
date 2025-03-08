package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum Skip {
    DEFAULT(-1),
    _0(0),
    _10(10),
    _15(15),
    _5(5);
    
    private static final Map<Integer, Skip> CONSTANTS = null;
    private final Integer value;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (Skip skip : values()) {
            CONSTANTS.put(skip.value, skip);
        }
    }

    private Skip(Integer num) {
        this.value = num;
    }

    public static Skip fromValue(Integer num) {
        if (num == null) {
            return null;
        }
        return CONSTANTS.get(num);
    }

    public Integer value() {
        return this.value;
    }
}
