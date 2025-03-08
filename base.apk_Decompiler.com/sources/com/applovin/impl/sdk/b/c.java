package com.applovin.impl.sdk.b;

import java.util.Map;

public class c {
    private final String aJc;
    private Map<String, String> aJd;

    public Map<String, String> JB() {
        return this.aJd;
    }

    public String JC() {
        return this.aJc;
    }

    public static c dn(String str) {
        return e(str, (Map<String, String>) null);
    }

    public static c e(String str, Map<String, String> map) {
        return new c(str, map);
    }

    private c(String str, Map<String, String> map) {
        this.aJc = str;
        this.aJd = map;
    }

    public String toString() {
        return "PendingReward{result='" + this.aJc + "'params='" + this.aJd + "'}";
    }
}
