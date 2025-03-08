package com.applovin.impl.privacy.a;

public class a {
    public static int ERROR_CODE_UNSPECIFIED = -1;
    public static int axI = -100;
    public static int axJ = -200;
    private final String axt;
    private final int code;

    public a(int i, String str) {
        this.code = i;
        this.axt = str;
    }

    public String toString() {
        return "AppLovinConsentFlowErrorImpl{code=" + this.code + ", message='" + this.axt + "'}";
    }
}
