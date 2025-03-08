package com.applovin.impl.mediation.debugger.b.b;

import java.util.List;
import java.util.Map;

public class a {
    private final Map<String, List<b>> aoJ;
    private final List<b> aoK;

    public Map<String, List<b>> va() {
        return this.aoJ;
    }

    public List<b> vb() {
        return this.aoK;
    }

    public a(Map<String, List<b>> map, List<b> list) {
        this.aoJ = map;
        this.aoK = list;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.canEqual(this)) {
            return false;
        }
        Map<String, List<b>> va = va();
        Map<String, List<b>> va2 = aVar.va();
        if (va != null ? !va.equals(va2) : va2 != null) {
            return false;
        }
        List<b> vb = vb();
        List<b> vb2 = aVar.vb();
        return vb != null ? vb.equals(vb2) : vb2 == null;
    }

    public int hashCode() {
        Map<String, List<b>> va = va();
        int i = 43;
        int hashCode = va == null ? 43 : va.hashCode();
        List<b> vb = vb();
        int i2 = (hashCode + 59) * 59;
        if (vb != null) {
            i = vb.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "AppAdsTxt(domainEntries=" + va() + ", invalidEntries=" + vb() + ")";
    }
}
