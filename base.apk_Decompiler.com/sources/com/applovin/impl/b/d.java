package com.applovin.impl.b;

import android.net.Uri;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class d {
    private Uri aXg;
    private i aXh;
    private final Set<k> aXi = new HashSet();
    private final Map<String, Set<k>> aXj = new HashMap();
    private int dE;
    private int height;

    public Uri Mn() {
        return this.aXg;
    }

    public i Mo() {
        return this.aXh;
    }

    public Set<k> Mp() {
        return this.aXi;
    }

    public Map<String, Set<k>> Mq() {
        return this.aXj;
    }

    private d() {
    }

    public static d a(y yVar, d dVar, e eVar, n nVar) {
        y dK;
        if (yVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (nVar != null) {
            if (dVar == null) {
                try {
                    dVar = new d();
                } catch (Throwable th) {
                    nVar.BN();
                    if (x.Fn()) {
                        nVar.BN().c("VastCompanionAd", "Error occurred while initializing", th);
                    }
                    nVar.Cs().g("VastCompanionAd", th);
                    return null;
                }
            }
            if (dVar.dE == 0 && dVar.height == 0) {
                int parseInt = StringUtils.parseInt(yVar.LJ().get("width"));
                int parseInt2 = StringUtils.parseInt(yVar.LJ().get("height"));
                if (parseInt > 0 && parseInt2 > 0) {
                    dVar.dE = parseInt;
                    dVar.height = parseInt2;
                }
            }
            dVar.aXh = i.a(yVar, dVar.aXh, nVar);
            if (dVar.aXg == null && (dK = yVar.dK("CompanionClickThrough")) != null) {
                String LK = dK.LK();
                if (StringUtils.isValidString(LK)) {
                    dVar.aXg = Uri.parse(LK);
                }
            }
            m.a(yVar.dJ("CompanionClickTracking"), dVar.aXi, eVar, nVar);
            m.a(yVar, dVar.aXj, eVar, nVar);
            return dVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.dE + ", height=" + this.height + ", destinationUri=" + this.aXg + ", nonVideoResource=" + this.aXh + ", clickTrackers=" + this.aXi + ", eventTrackers=" + this.aXj + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.dE != dVar.dE || this.height != dVar.height) {
            return false;
        }
        Uri uri = this.aXg;
        if (uri == null ? dVar.aXg != null : !uri.equals(dVar.aXg)) {
            return false;
        }
        i iVar = this.aXh;
        if (iVar == null ? dVar.aXh != null : !iVar.equals(dVar.aXh)) {
            return false;
        }
        Set<k> set = this.aXi;
        if (set == null ? dVar.aXi != null : !set.equals(dVar.aXi)) {
            return false;
        }
        Map<String, Set<k>> map = this.aXj;
        Map<String, Set<k>> map2 = dVar.aXj;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.dE * 31) + this.height) * 31;
        Uri uri = this.aXg;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        i iVar = this.aXh;
        int hashCode2 = (hashCode + (iVar != null ? iVar.hashCode() : 0)) * 31;
        Set<k> set = this.aXi;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<k>> map = this.aXj;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }
}
