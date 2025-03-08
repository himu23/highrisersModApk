package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

class q {
    private r a;
    private boolean b = false;

    q(r rVar) {
        this.a = rVar;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.b) {
            return "";
        }
        this.b = true;
        return this.a.b();
    }
}
