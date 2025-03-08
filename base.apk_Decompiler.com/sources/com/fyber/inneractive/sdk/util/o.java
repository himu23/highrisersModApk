package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.cache.a;

public class o implements Runnable {
    public final /* synthetic */ a a;

    public o(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a aVar;
        try {
            if (p.a != null && (aVar = this.a) != null) {
                p.a.getSharedPreferences("IAConfigurationPreferences", 0).edit().remove(aVar.b()).apply();
            }
        } catch (Throwable unused) {
        }
    }
}
