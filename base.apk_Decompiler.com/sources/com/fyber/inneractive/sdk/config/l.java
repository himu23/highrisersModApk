package com.fyber.inneractive.sdk.config;

import android.content.Context;
import java.io.Serializable;

public class l implements v {
    public Context a;
    public c b = new c();

    public static class b {
        public static l a = new l();
    }

    public static class c implements Serializable {
        public static final long serialVersionUID = 2;
        public String a;
        public boolean b;
        public boolean c;

        public c() {
        }
    }

    public static String a() {
        c cVar = b.a.b;
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    public static boolean b() {
        c cVar = b.a.b;
        if (cVar != null) {
            return cVar.c;
        }
        return false;
    }

    public static boolean c() {
        c cVar = b.a.b;
        if (cVar != null) {
            return cVar.b;
        }
        return false;
    }
}
