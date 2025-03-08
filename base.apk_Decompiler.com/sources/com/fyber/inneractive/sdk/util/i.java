package com.fyber.inneractive.sdk.util;

import java.util.Locale;

public enum i {
    DISPLAY("DISPLAY"),
    VIDEO_CTA("VIDEO_CTA"),
    VIDEO_CLICK("VIDEO_CLICK"),
    VAST_ENDCARD("VAST_ENDCARD"),
    DEFAULT_ENDCARD("DEFAULT_ENDCARD"),
    VIDEO_APP_INFO("VIDEO_APP_INFO"),
    FMP_ENDCARD("FMP_ENDCARD");
    
    private final String key;
    private int mOrderShown;
    private String mVersion;

    /* access modifiers changed from: public */
    i(String str) {
        this.mVersion = "";
        this.mOrderShown = 0;
        this.key = str;
    }

    public void a(int i) {
        this.mOrderShown = i;
    }

    public void a(String str) {
        this.mVersion = str;
    }

    public String e() {
        return this.mVersion;
    }

    public String toString() {
        if ((this != FMP_ENDCARD || this.mOrderShown != 1) && this.mOrderShown != 2) {
            return this.key;
        }
        return String.format(Locale.US, "%s_%d", new Object[]{this.key, Integer.valueOf(this.mOrderShown)});
    }
}
