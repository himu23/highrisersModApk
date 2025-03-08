package com.fyber.inneractive.sdk.config.global.features;

public class n extends g {
    public n() {
        super("single_tap");
    }

    public g b() {
        n nVar = new n();
        a((g) nVar);
        return nVar;
    }

    public String d() {
        String a = a("app_info_button_text", "App Info");
        return (a == null || a.length() <= 30) ? a : a.substring(0, 30);
    }
}
