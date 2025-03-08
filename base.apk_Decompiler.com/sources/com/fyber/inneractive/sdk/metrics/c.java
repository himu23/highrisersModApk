package com.fyber.inneractive.sdk.metrics;

import java.util.HashMap;
import java.util.Map;

public class c {
    public static final c d = new c();
    public final Map<String, f> a = new HashMap();
    public final Map<String, g> b = new HashMap();
    public final f c = new e();

    public g b(String str) {
        g gVar = this.b.get(str);
        if (gVar == null) {
            gVar = new h();
        }
        this.b.put(str, gVar);
        return gVar;
    }

    public f a(String str) {
        if (str == null) {
            try {
                return this.c;
            } catch (Exception unused) {
                return this.c;
            }
        } else {
            f fVar = this.a.get(str);
            if (fVar != null) {
                return fVar;
            }
            d dVar = new d();
            this.a.put(str, dVar);
            return dVar;
        }
    }
}
