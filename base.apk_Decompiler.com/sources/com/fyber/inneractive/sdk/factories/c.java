package com.fyber.inneractive.sdk.factories;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import java.util.HashSet;
import java.util.Set;

public final class c {
    public final Set<a> a = new HashSet();

    public interface a {
        boolean a(InneractiveAdSpot inneractiveAdSpot);

        com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot);
    }

    public static class b {
        public static c a = new c();
    }

    public com.fyber.inneractive.sdk.interfaces.c a(InneractiveAdSpot inneractiveAdSpot) {
        for (a next : this.a) {
            if (next.a(inneractiveAdSpot)) {
                return next.b(inneractiveAdSpot);
            }
        }
        return null;
    }
}
