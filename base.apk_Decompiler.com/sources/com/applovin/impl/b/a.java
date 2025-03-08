package com.applovin.impl.b;

import android.net.Uri;
import com.applovin.impl.b.n;
import com.applovin.impl.sdk.a.g;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class a extends e {
    private final String aGc;
    private final String aWI;
    private final j aWJ;
    private final n aWK;
    private final d aWL;
    private final c aWM;
    private final g aWN;
    private final Set<k> aWO;
    private final Set<k> aWP;
    private final long createdAtMillis;
    private final String title;

    public enum b {
        COMPANION_AD,
        VIDEO
    }

    public enum c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    public void FA() {
    }

    public String FD() {
        return this.aGc;
    }

    /* renamed from: LO */
    public g getAdEventTracker() {
        return this.aWN;
    }

    public j LT() {
        return this.aWJ;
    }

    public n LU() {
        return this.aWK;
    }

    public d LX() {
        return this.aWL;
    }

    public c Mf() {
        return this.aWM;
    }

    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    private a(C0064a aVar) {
        super(aVar.adObject, aVar.fullResponse, aVar.source, aVar.sdk);
        this.title = aVar.title;
        this.aWJ = aVar.aWJ;
        this.aWI = aVar.aWI;
        this.aWK = aVar.aWK;
        this.aWL = aVar.aWL;
        this.aWM = aVar.aWM;
        this.aWO = aVar.aWO;
        this.aWP = aVar.aWP;
        this.aWN = new g(this);
        Uri FI = FI();
        if (FI != null) {
            this.aGc = FI.toString();
        } else {
            this.aGc = "";
        }
        this.createdAtMillis = aVar.createdAtMillis;
    }

    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    public boolean hasVideoUrl() {
        List<o> MG;
        n nVar = this.aWK;
        if (nVar == null || (MG = nVar.MG()) == null || MG.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean FF() {
        return getBooleanFromAdObject("vast_is_streaming", false);
    }

    public void FH() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", true) && this.aWM != null;
    }

    public boolean LM() {
        return getBooleanFromAdObject("iopms", false);
    }

    public boolean LN() {
        return getBooleanFromAdObject("iopmsfsr", true);
    }

    public long LP() {
        return getLongFromAdObject("real_close_delay", 0);
    }

    public b LQ() {
        if ("companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad"))) {
            return b.COMPANION_AD;
        }
        return b.VIDEO;
    }

    public boolean LR() {
        return getBooleanFromAdObject("vast_immediate_ad_load", true);
    }

    public Uri FI() {
        o LV = LV();
        if (LV != null) {
            return LV.FI();
        }
        return null;
    }

    public Uri FK() {
        n nVar = this.aWK;
        if (nVar != null) {
            return nVar.Mn();
        }
        return null;
    }

    public Uri FL() {
        return FK();
    }

    public boolean Gq() {
        return getBooleanFromAdObject("video_clickable", false) && FK() != null;
    }

    public List<com.applovin.impl.sdk.d.a> Hj() {
        List<com.applovin.impl.sdk.d.a> a;
        synchronized (this.adObjectLock) {
            a = u.a("vimp_urls", this.adObject, getClCode(), (Map<String, String>) null, LS(), Hl(), Gl(), this.sdk);
        }
        return a;
    }

    private String LS() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    public o LV() {
        Long K = i.K(this.sdk);
        return this.aWK.a(LW(), K != null ? K.longValue() : 0);
    }

    private n.a LW() {
        n.a[] values = n.a.values();
        int intValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPw)).intValue();
        if (intValue < 0 || intValue >= values.length) {
            return n.a.UNSPECIFIED;
        }
        return values[intValue];
    }

    public g LY() {
        n nVar = this.aWK;
        if (nVar != null) {
            return nVar.LY();
        }
        return null;
    }

    public boolean LZ() {
        return LY() != null;
    }

    public boolean Ma() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
    }

    public void dO(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    public String Mb() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri Mc() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean Md() {
        return getBooleanFromAdObject("cache_companion_ad", true);
    }

    public boolean Me() {
        return getBooleanFromAdObject("cache_video", true);
    }

    public Set<k> a(c cVar, String str) {
        return a(cVar, new String[]{str});
    }

    public Set<k> a(c cVar, String[] strArr) {
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        }
        if (cVar == c.IMPRESSION) {
            return this.aWO;
        }
        if (cVar == c.VIDEO_CLICK) {
            return Mg();
        }
        if (cVar == c.COMPANION_CLICK) {
            return Mh();
        }
        if (cVar == c.VIDEO) {
            return a(b.VIDEO, strArr);
        }
        if (cVar == c.COMPANION) {
            return a(b.COMPANION_AD, strArr);
        }
        if (cVar == c.INDUSTRY_ICON_CLICK) {
            return LY().Mp();
        }
        if (cVar == c.INDUSTRY_ICON_IMPRESSION) {
            return LY().Mx();
        }
        if (cVar == c.ERROR) {
            return this.aWP;
        }
        this.sdk.BN();
        if (x.Fn()) {
            x BN2 = this.sdk.BN();
            BN2.i("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
        }
        return Collections.emptySet();
    }

    private Set<k> Mg() {
        n nVar = this.aWK;
        if (nVar != null) {
            return nVar.Mp();
        }
        return Collections.emptySet();
    }

    private Set<k> Mh() {
        d dVar = this.aWL;
        if (dVar != null) {
            return dVar.Mp();
        }
        return Collections.emptySet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r6 = r5.aWL;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.applovin.impl.b.k> a(com.applovin.impl.b.a.b r6, java.lang.String[] r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x004a
            int r0 = r7.length
            if (r0 <= 0) goto L_0x004a
            com.applovin.impl.b.a$b r0 = com.applovin.impl.b.a.b.VIDEO
            if (r6 != r0) goto L_0x0012
            com.applovin.impl.b.n r0 = r5.aWK
            if (r0 == 0) goto L_0x0012
            java.util.Map r6 = r0.Mq()
            goto L_0x0020
        L_0x0012:
            com.applovin.impl.b.a$b r0 = com.applovin.impl.b.a.b.COMPANION_AD
            if (r6 != r0) goto L_0x001f
            com.applovin.impl.b.d r6 = r5.aWL
            if (r6 == 0) goto L_0x001f
            java.util.Map r6 = r6.Mq()
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r6 == 0) goto L_0x0045
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0045
            int r1 = r7.length
            r2 = 0
        L_0x002f:
            if (r2 >= r1) goto L_0x0045
            r3 = r7[r2]
            boolean r4 = r6.containsKey(r3)
            if (r4 == 0) goto L_0x0042
            java.lang.Object r3 = r6.get(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r0.addAll(r3)
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0045:
            java.util.Set r6 = java.util.Collections.unmodifiableSet(r0)
            return r6
        L_0x004a:
            java.util.Set r6 = java.util.Collections.emptySet()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.b.a.a(com.applovin.impl.b.a$b, java.lang.String[]):java.util.Set");
    }

    public String toString() {
        return "VastAd{title='" + this.title + "', adDescription='" + this.aWI + "', systemInfo=" + this.aWJ + ", videoCreative=" + this.aWK + ", companionAd=" + this.aWL + ", adVerifications=" + this.aWM + ", impressionTrackers=" + this.aWO + ", errorTrackers=" + this.aWP + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a) || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.title;
        if (str == null ? aVar.title != null : !str.equals(aVar.title)) {
            return false;
        }
        String str2 = this.aWI;
        if (str2 == null ? aVar.aWI != null : !str2.equals(aVar.aWI)) {
            return false;
        }
        j jVar = this.aWJ;
        if (jVar == null ? aVar.aWJ != null : !jVar.equals(aVar.aWJ)) {
            return false;
        }
        n nVar = this.aWK;
        if (nVar == null ? aVar.aWK != null : !nVar.equals(aVar.aWK)) {
            return false;
        }
        d dVar = this.aWL;
        if (dVar == null ? aVar.aWL != null : !dVar.equals(aVar.aWL)) {
            return false;
        }
        c cVar = this.aWM;
        if (cVar == null ? aVar.aWM != null : !cVar.equals(aVar.aWM)) {
            return false;
        }
        Set<k> set = this.aWO;
        if (set == null ? aVar.aWO != null : !set.equals(aVar.aWO)) {
            return false;
        }
        Set<k> set2 = this.aWP;
        Set<k> set3 = aVar.aWP;
        if (set2 != null) {
            return set2.equals(set3);
        }
        if (set3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.title;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.aWI;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        j jVar = this.aWJ;
        int hashCode4 = (hashCode3 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        n nVar = this.aWK;
        int hashCode5 = (hashCode4 + (nVar != null ? nVar.hashCode() : 0)) * 31;
        d dVar = this.aWL;
        int hashCode6 = (hashCode5 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        c cVar = this.aWM;
        int hashCode7 = (hashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Set<k> set = this.aWO;
        int hashCode8 = (hashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set<k> set2 = this.aWP;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode8 + i;
    }

    /* renamed from: com.applovin.impl.b.a$a  reason: collision with other inner class name */
    public static class C0064a {
        /* access modifiers changed from: private */
        public String aWI;
        /* access modifiers changed from: private */
        public j aWJ;
        /* access modifiers changed from: private */
        public n aWK;
        /* access modifiers changed from: private */
        public d aWL;
        /* access modifiers changed from: private */
        public c aWM;
        /* access modifiers changed from: private */
        public Set<k> aWO;
        /* access modifiers changed from: private */
        public Set<k> aWP;
        /* access modifiers changed from: private */
        public JSONObject adObject;
        /* access modifiers changed from: private */
        public long createdAtMillis;
        /* access modifiers changed from: private */
        public JSONObject fullResponse;
        /* access modifiers changed from: private */
        public com.applovin.impl.sdk.n sdk;
        /* access modifiers changed from: private */
        public com.applovin.impl.sdk.ad.b source;
        /* access modifiers changed from: private */
        public String title;

        public C0064a a(c cVar) {
            this.aWM = cVar;
            return this;
        }

        public C0064a a(d dVar) {
            this.aWL = dVar;
            return this;
        }

        public C0064a a(j jVar) {
            this.aWJ = jVar;
            return this;
        }

        public C0064a a(n nVar) {
            this.aWK = nVar;
            return this;
        }

        public C0064a a(com.applovin.impl.sdk.ad.b bVar) {
            this.source = bVar;
            return this;
        }

        public C0064a b(Set<k> set) {
            this.aWO = set;
            return this;
        }

        public C0064a c(Set<k> set) {
            this.aWP = set;
            return this;
        }

        public C0064a cc(long j) {
            this.createdAtMillis = j;
            return this;
        }

        public C0064a dP(String str) {
            this.title = str;
            return this;
        }

        public C0064a dQ(String str) {
            this.aWI = str;
            return this;
        }

        public C0064a V(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.adObject = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public C0064a W(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.fullResponse = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }

        public C0064a R(com.applovin.impl.sdk.n nVar) {
            if (nVar != null) {
                this.sdk = nVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public a Mi() {
            return new a(this);
        }
    }
}
