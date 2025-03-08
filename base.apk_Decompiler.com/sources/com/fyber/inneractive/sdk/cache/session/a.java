package com.fyber.inneractive.sdk.cache.session;

import com.fyber.inneractive.sdk.cache.session.enums.b;
import java.util.HashMap;

public class a extends HashMap<b, h> {
    public final /* synthetic */ int a;

    public a(d dVar, int i) {
        this.a = i;
        for (b bVar : b.values()) {
            if (bVar != b.NONE) {
                put(bVar, new h(this.a));
            }
        }
    }
}
