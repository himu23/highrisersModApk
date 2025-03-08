package com.applovin.impl.b;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    private final String aXc;
    private final List<h> aXd;
    private final Set<k> aXe;
    private final String verificationParameters;

    public String Mj() {
        return this.aXc;
    }

    public List<h> Mk() {
        return this.aXd;
    }

    public Set<k> Ml() {
        return this.aXe;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }

    private b(String str, List<h> list, String str2, Set<k> set) {
        this.aXc = str;
        this.aXd = list;
        this.verificationParameters = str2;
        this.aXe = set;
    }

    public static b a(y yVar, e eVar, n nVar) {
        try {
            String str = yVar.LJ().get("vendor");
            y dL = yVar.dL("VerificationParameters");
            String LK = dL != null ? dL.LK() : null;
            List<y> dJ = yVar.dJ("JavaScriptResource");
            ArrayList arrayList = new ArrayList(dJ.size());
            for (y b : dJ) {
                h b2 = h.b(b, nVar);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            HashMap hashMap = new HashMap();
            m.a(yVar, (Map<String, Set<k>>) hashMap, eVar, nVar);
            return new b(str, arrayList, LK, (Set) hashMap.get("verificationNotExecuted"));
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().c("VastAdVerification", "Error occurred while initializing", th);
            }
            nVar.Cs().g("VastAdVerification", th);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.aXc;
        if (str == null ? bVar.aXc != null : !str.equals(bVar.aXc)) {
            return false;
        }
        List<h> list = this.aXd;
        if (list == null ? bVar.aXd != null : !list.equals(bVar.aXd)) {
            return false;
        }
        String str2 = this.verificationParameters;
        if (str2 == null ? bVar.verificationParameters != null : !str2.equals(bVar.verificationParameters)) {
            return false;
        }
        Set<k> set = this.aXe;
        Set<k> set2 = bVar.aXe;
        if (set != null) {
            return set.equals(set2);
        }
        if (set2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.aXc;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<h> list = this.aXd;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.verificationParameters;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<k> set = this.aXe;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.aXc + "'javascriptResources='" + this.aXd + "'verificationParameters='" + this.verificationParameters + "'errorEventTrackers='" + this.aXe + "'}";
    }
}
