package com.fyber.inneractive.sdk.config.global.features;

public class p extends g {

    public enum a {
        Modal("modal"),
        FullScreen("full");
        
        public String value;

        /* access modifiers changed from: public */
        a(String str) {
            this.value = str;
        }
    }

    public p() {
        super("store_webpage");
    }

    public g b() {
        p pVar = new p();
        a((g) pVar);
        return pVar;
    }
}
