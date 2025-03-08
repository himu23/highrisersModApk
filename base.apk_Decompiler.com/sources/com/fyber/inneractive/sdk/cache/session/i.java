package com.fyber.inneractive.sdk.cache.session;

import java.util.Comparator;

public class i implements Comparator<e> {
    public int compare(Object obj, Object obj2) {
        e eVar = (e) obj;
        e eVar2 = (e) obj2;
        if (eVar == null || eVar2 == null) {
            return 0;
        }
        return eVar.d < eVar2.d ? -1 : 1;
    }
}
