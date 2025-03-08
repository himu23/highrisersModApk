package com.applovin.impl.sdk.d;

import java.util.Map;

public class a {
    private final String aRW;
    private final String aRX;
    private final Map<String, String> aRY;
    private final boolean aRZ;

    public Map<String, String> HS() {
        return this.aRY;
    }

    public String Iv() {
        return this.aRX;
    }

    public boolean Ix() {
        return this.aRZ;
    }

    public String JK() {
        return this.aRW;
    }

    public a(String str, String str2) {
        this(str, str2, (Map<String, String>) null, false);
    }

    public a(String str, String str2, Map<String, String> map, boolean z) {
        this.aRW = str;
        this.aRX = str2;
        this.aRY = map;
        this.aRZ = z;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.aRW + "', backupUrl='" + this.aRX + "', headers='" + this.aRY + "', shouldFireInWebView='" + this.aRZ + "'}";
    }
}
