package com.applovin.impl.mediation.debugger;

import com.applovin.impl.mediation.debugger.c.a;
import com.applovin.impl.mediation.debugger.c.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a implements a.C0074a, b.a {
    private final C0071a anR;
    private com.applovin.impl.mediation.debugger.b.b.a anS;
    private String anT;
    private final n sdk;

    /* renamed from: com.applovin.impl.mediation.debugger.a$a  reason: collision with other inner class name */
    public interface C0071a {
        void a(com.applovin.impl.mediation.debugger.b.b.a aVar, String str);

        void b(b bVar, String str);
    }

    public enum b {
        DEVELOPER_URI_NOT_FOUND,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public a(n nVar, C0071a aVar) {
        this.sdk = nVar;
        this.anR = aVar;
    }

    public void uA() {
        com.applovin.impl.mediation.debugger.b.b.a aVar = this.anS;
        if (aVar != null) {
            this.anR.a(aVar, this.anT);
            return;
        }
        this.sdk.BO().b((d) new com.applovin.impl.mediation.debugger.c.b(this.sdk, this));
    }

    public void bG(String str) {
        this.sdk.BO().b((d) new com.applovin.impl.mediation.debugger.c.a(this.sdk, str, this));
    }

    public void a(b bVar) {
        this.anR.b(bVar, (String) null);
    }

    public void t(String str, String str2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("\n");
        int length = split.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            com.applovin.impl.mediation.debugger.b.b.b bVar = new com.applovin.impl.mediation.debugger.b.b.b(split[i2], i);
            if (bVar.vi()) {
                String vd = bVar.vd();
                List arrayList2 = hashMap.containsKey(vd) ? (List) hashMap.get(vd) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(bVar);
                    hashMap.put(vd, arrayList2);
                }
            } else {
                arrayList.add(bVar);
            }
            i2++;
            i = i3;
        }
        this.anS = new com.applovin.impl.mediation.debugger.b.b.a(hashMap, arrayList);
        this.anT = str2;
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("AppAdsTxtService", "app-ads.txt fetched: " + this.anS);
        }
        this.anR.a(this.anS, str2);
    }

    public void a(b bVar, String str) {
        this.anR.b(bVar, str);
    }
}
