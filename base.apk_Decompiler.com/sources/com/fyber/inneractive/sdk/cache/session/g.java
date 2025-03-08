package com.fyber.inneractive.sdk.cache.session;

import java.util.Comparator;

public class g implements Comparator<e> {
    public g(h hVar) {
    }

    public int compare(Object obj, Object obj2) {
        e eVar = (e) obj;
        e eVar2 = (e) obj2;
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        return eVar2.d - eVar.d > 0 ? 1 : -1;
    }
}
