package com.ironsource;

import android.webkit.JavascriptInterface;

public class z5 {
    private c6 a;

    z5(c6 c6Var) {
        this.a = c6Var;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.a.handleMessageFromAd(str);
    }
}
