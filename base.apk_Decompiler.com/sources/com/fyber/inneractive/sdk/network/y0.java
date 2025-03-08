package com.fyber.inneractive.sdk.network;

public enum y0 {
    EVENT_TABLE("sdk_event_"),
    ERROR_TABLE("sdk_error_");
    
    private final String tableName;

    /* access modifiers changed from: public */
    y0(String str) {
        this.tableName = str;
    }

    public String e() {
        return this.tableName;
    }
}
