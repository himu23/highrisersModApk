package com.applovin.impl.mediation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class h {
    private final List<a> amM = Collections.synchronizedList(new ArrayList());

    public interface a {
        void f(com.applovin.impl.mediation.b.a aVar);
    }

    public void a(a aVar) {
        this.amM.add(aVar);
    }

    public void b(a aVar) {
        this.amM.remove(aVar);
    }

    public void e(com.applovin.impl.mediation.b.a aVar) {
        Iterator it = new ArrayList(this.amM).iterator();
        while (it.hasNext()) {
            ((a) it.next()).f(aVar);
        }
    }
}
