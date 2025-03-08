package com.fyber.inneractive.sdk.cache;

import com.fyber.inneractive.sdk.network.w;

public class f implements w<String> {
    public final /* synthetic */ i a;

    public f(i iVar) {
        this.a = iVar;
    }

    public void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null) {
            this.a.b = str;
        }
    }
}
