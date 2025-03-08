package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.c.b;
import java.util.Collections;
import java.util.List;

public class c implements Comparable<c> {
    private final String aow;
    private final boolean aox;
    private final b aoy;
    private final String name;

    public String getDisplayName() {
        return this.aow;
    }

    public String getName() {
        return this.name;
    }

    public b uP() {
        return this.aoy;
    }

    c(String str, String str2, boolean z, b bVar) {
        this.name = str;
        this.aow = str2;
        this.aox = z;
        this.aoy = bVar;
    }

    public List<String> uO() {
        List<String> vv = this.aoy.vv();
        if (vv == null || vv.isEmpty()) {
            return Collections.singletonList(this.name);
        }
        return vv;
    }

    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aow.compareToIgnoreCase(cVar.aow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.name;
        if (str == null ? cVar.name != null : !str.equals(cVar.name)) {
            return false;
        }
        String str2 = this.aow;
        if (str2 == null ? cVar.aow != null : !str2.equals(cVar.aow)) {
            return false;
        }
        if (this.aox == cVar.aox) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aow;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + (this.aox ? 1 : 0);
    }
}
