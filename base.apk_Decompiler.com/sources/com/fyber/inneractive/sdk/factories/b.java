package com.fyber.inneractive.sdk.factories;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

public final class b {
    public final HashMap<com.fyber.inneractive.sdk.response.a, C0096b> a = new HashMap<>();

    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.fyber.inneractive.sdk.factories.b$b  reason: collision with other inner class name */
    public interface C0096b {
        com.fyber.inneractive.sdk.interfaces.a a();

        com.fyber.inneractive.sdk.response.b b();
    }

    public com.fyber.inneractive.sdk.response.b a(com.fyber.inneractive.sdk.response.a aVar) {
        C0096b bVar = this.a.get(aVar);
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public void a(com.fyber.inneractive.sdk.response.a aVar, C0096b bVar) {
        if (this.a.containsKey(aVar)) {
            IAlog.e("Handler already exists for ad type %s! : %s", aVar, this.a.get(aVar));
            return;
        }
        this.a.put(aVar, bVar);
    }
}
