package com.applovin.impl.b;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.List;

public class c {
    private final List<b> aXf;

    public List<b> Mm() {
        return this.aXf;
    }

    private c(List<b> list) {
        this.aXf = list;
    }

    public static c a(y yVar, c cVar, e eVar, n nVar) {
        List list;
        if (cVar != null) {
            try {
                list = cVar.Mm();
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("VastAdVerifications", "Error occurred while initializing", th);
                }
                nVar.Cs().g("VastAdVerifications", th);
                return null;
            }
        } else {
            list = new ArrayList();
        }
        for (y a : yVar.dJ("Verification")) {
            b a2 = b.a(a, eVar, nVar);
            if (a2 != null) {
                list.add(a2);
            }
        }
        return new c(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.aXf.equals(((c) obj).aXf);
    }

    public int hashCode() {
        return this.aXf.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.aXf + "'}";
    }
}
