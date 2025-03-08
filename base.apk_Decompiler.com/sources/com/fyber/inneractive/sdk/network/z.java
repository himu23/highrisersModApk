package com.fyber.inneractive.sdk.network;

import com.ironsource.i9;

public enum z {
    POST(i9.b),
    PUT("PUT"),
    DELETE("DELETE"),
    GET(i9.a);
    
    public final String key;

    /* access modifiers changed from: public */
    z(String str) {
        this.key = str;
    }
}
