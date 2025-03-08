package com.fyber.inneractive.sdk.external;

public enum InneractiveMediationName {
    ADMOB("admob"),
    DFP(InneractiveMediationNameConsts.DFP),
    FYBER("fyber"),
    OTHER(InneractiveMediationNameConsts.OTHER);
    
    public final String key;

    /* access modifiers changed from: public */
    InneractiveMediationName(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
