package com.applovin.impl.privacy.a;

import com.applovin.impl.privacy.a;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.n;
import java.util.List;

public class b {
    public static List<e> h(n nVar) {
        if (!nVar.Cl().isEnabled()) {
            return null;
        }
        return j.m(nVar);
    }

    public static List<e> i(n nVar) {
        Boolean B;
        if (!nVar.Cl().isEnabled()) {
            return null;
        }
        if (nVar.Cl().zX() == d.a.UNIFIED && (B = a.zO().B(n.getApplicationContext())) != null && B.booleanValue()) {
            return null;
        }
        boolean BL = nVar.BL();
        Boolean bool = (Boolean) nVar.b(com.applovin.impl.sdk.c.d.aRt, false);
        if (!BL) {
            return j(nVar);
        }
        if (bool.booleanValue()) {
            return j(nVar);
        }
        return null;
    }

    private static List<e> j(n nVar) {
        if (nVar.Cl().getTermsOfServiceUri() != null) {
            return j.l(nVar);
        }
        return j.k(nVar);
    }
}
