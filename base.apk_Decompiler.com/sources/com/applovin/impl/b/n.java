package com.applovin.impl.b;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class n {
    private List<o> aXY = Collections.emptyList();
    private List<String> aXZ = Collections.emptyList();
    private Uri aXg;
    private final Set<k> aXi = new HashSet();
    private final Map<String, Set<k>> aXj = new HashMap();
    private int aYa;
    private g aYb;

    public enum a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH,
        DYNAMIC
    }

    public g LY() {
        return this.aYb;
    }

    public List<o> MG() {
        return this.aXY;
    }

    public int MH() {
        return this.aYa;
    }

    public Uri Mn() {
        return this.aXg;
    }

    public Set<k> Mp() {
        return this.aXi;
    }

    public Map<String, Set<k>> Mq() {
        return this.aXj;
    }

    private n() {
    }

    private n(e eVar) {
        this.aXZ = eVar.Mu();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
        r0 = r0.dK("Icon");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.impl.b.n a(com.applovin.impl.sdk.utils.y r4, com.applovin.impl.b.n r5, com.applovin.impl.b.e r6, com.applovin.impl.sdk.n r7) {
        /*
            if (r4 == 0) goto L_0x00de
            if (r6 == 0) goto L_0x00d6
            if (r7 == 0) goto L_0x00ce
            if (r5 == 0) goto L_0x0009
            goto L_0x000e
        L_0x0009:
            com.applovin.impl.b.n r5 = new com.applovin.impl.b.n     // Catch:{ all -> 0x00b0 }
            r5.<init>(r6)     // Catch:{ all -> 0x00b0 }
        L_0x000e:
            int r0 = r5.aYa     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "Duration"
            com.applovin.impl.sdk.utils.y r0 = r4.dK(r0)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = r0.LK()     // Catch:{ all -> 0x00b0 }
            int r0 = f(r0, r7)     // Catch:{ all -> 0x00b0 }
            if (r0 <= 0) goto L_0x0026
            r5.aYa = r0     // Catch:{ all -> 0x00b0 }
        L_0x0026:
            java.lang.String r0 = "MediaFiles"
            com.applovin.impl.sdk.utils.y r0 = r4.dK(r0)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0043
            java.util.List r0 = c(r0, r7)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0043
            int r1 = r0.size()     // Catch:{ all -> 0x00b0 }
            if (r1 <= 0) goto L_0x0043
            java.util.List<com.applovin.impl.b.o> r1 = r5.aXY     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0041
            r0.addAll(r1)     // Catch:{ all -> 0x00b0 }
        L_0x0041:
            r5.aXY = r0     // Catch:{ all -> 0x00b0 }
        L_0x0043:
            java.lang.String r0 = "VideoClicks"
            com.applovin.impl.sdk.utils.y r0 = r4.dK(r0)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0072
            android.net.Uri r1 = r5.aXg     // Catch:{ all -> 0x00b0 }
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "ClickThrough"
            com.applovin.impl.sdk.utils.y r1 = r0.dK(r1)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r1.LK()     // Catch:{ all -> 0x00b0 }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0067
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x00b0 }
            r5.aXg = r1     // Catch:{ all -> 0x00b0 }
        L_0x0067:
            java.lang.String r1 = "ClickTracking"
            java.util.List r0 = r0.dJ(r1)     // Catch:{ all -> 0x00b0 }
            java.util.Set<com.applovin.impl.b.k> r1 = r5.aXi     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.b.m.a((java.util.List<com.applovin.impl.sdk.utils.y>) r0, (java.util.Set<com.applovin.impl.b.k>) r1, (com.applovin.impl.b.e) r6, (com.applovin.impl.sdk.n) r7)     // Catch:{ all -> 0x00b0 }
        L_0x0072:
            java.lang.String r0 = "Icons"
            com.applovin.impl.sdk.utils.y r0 = r4.dK(r0)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00aa
            java.lang.String r1 = "Icon"
            com.applovin.impl.sdk.utils.y r0 = r0.dK(r1)     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.b.g r1 = com.applovin.impl.b.g.a(r0, r7)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x00aa
            java.lang.String r2 = "IconClicks"
            com.applovin.impl.sdk.utils.y r2 = r0.dK(r2)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x009b
            java.lang.String r3 = "IconClickTracking"
            java.util.List r2 = r2.dJ(r3)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x009b
            java.util.Set<com.applovin.impl.b.k> r3 = r1.aXi     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.b.m.a((java.util.List<com.applovin.impl.sdk.utils.y>) r2, (java.util.Set<com.applovin.impl.b.k>) r3, (com.applovin.impl.b.e) r6, (com.applovin.impl.sdk.n) r7)     // Catch:{ all -> 0x00b0 }
        L_0x009b:
            java.lang.String r2 = "IconViewTracking"
            java.util.List r0 = r0.dJ(r2)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a8
            java.util.Set<com.applovin.impl.b.k> r2 = r1.aXE     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.b.m.a((java.util.List<com.applovin.impl.sdk.utils.y>) r0, (java.util.Set<com.applovin.impl.b.k>) r2, (com.applovin.impl.b.e) r6, (com.applovin.impl.sdk.n) r7)     // Catch:{ all -> 0x00b0 }
        L_0x00a8:
            r5.aYb = r1     // Catch:{ all -> 0x00b0 }
        L_0x00aa:
            java.util.Map<java.lang.String, java.util.Set<com.applovin.impl.b.k>> r0 = r5.aXj     // Catch:{ all -> 0x00b0 }
            com.applovin.impl.b.m.a((com.applovin.impl.sdk.utils.y) r4, (java.util.Map<java.lang.String, java.util.Set<com.applovin.impl.b.k>>) r0, (com.applovin.impl.b.e) r6, (com.applovin.impl.sdk.n) r7)     // Catch:{ all -> 0x00b0 }
            return r5
        L_0x00b0:
            r4 = move-exception
            r7.BN()
            boolean r5 = com.applovin.impl.sdk.x.Fn()
            java.lang.String r6 = "VastVideoCreative"
            if (r5 == 0) goto L_0x00c5
            com.applovin.impl.sdk.x r5 = r7.BN()
            java.lang.String r0 = "Error occurred while initializing"
            r5.c(r6, r0, r4)
        L_0x00c5:
            com.applovin.impl.sdk.r r5 = r7.Cs()
            r5.g(r6, r4)
            r4 = 0
            return r4
        L_0x00ce:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "No sdk specified."
            r4.<init>(r5)
            throw r4
        L_0x00d6:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "No context specified."
            r4.<init>(r5)
            throw r4
        L_0x00de:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "No node specified."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.b.n.a(com.applovin.impl.sdk.utils.y, com.applovin.impl.b.n, com.applovin.impl.b.e, com.applovin.impl.sdk.n):com.applovin.impl.b.n");
    }

    private static int f(String str, com.applovin.impl.sdk.n nVar) {
        try {
            List<String> explode = CollectionUtils.explode(str, ":");
            if (explode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) StringUtils.parseInt(explode.get(0))) + TimeUnit.MINUTES.toSeconds((long) StringUtils.parseInt(explode.get(1))) + ((long) StringUtils.parseInt(explode.get(2))));
            }
        } catch (Throwable unused) {
            nVar.BN();
            if (x.Fn()) {
                x BN = nVar.BN();
                BN.i("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List<o> c(y yVar, com.applovin.impl.sdk.n nVar) {
        List<y> dJ = yVar.dJ("MediaFile");
        ArrayList arrayList = new ArrayList(dJ.size());
        List<String> explode = CollectionUtils.explode((String) nVar.a(b.aPu));
        List<String> explode2 = CollectionUtils.explode((String) nVar.a(b.aPt));
        for (y d : dJ) {
            o d2 = o.d(d, nVar);
            if (d2 != null) {
                try {
                    String MJ = d2.MJ();
                    if (!StringUtils.isValidString(MJ) || explode.contains(MJ)) {
                        if (((Boolean) nVar.a(b.aPv)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(d2.FI().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(d2);
                            }
                        }
                        nVar.BN();
                        if (x.Fn()) {
                            x BN = nVar.BN();
                            BN.h("VastVideoCreative", "Video file not supported: " + d2);
                        }
                    } else {
                        arrayList.add(d2);
                    }
                } catch (Throwable th) {
                    nVar.BN();
                    if (x.Fn()) {
                        x BN2 = nVar.BN();
                        BN2.c("VastVideoCreative", "Failed to validate video file: " + d2, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public o a(a aVar, long j) {
        List<o> list = this.aXY;
        o oVar = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<o> arrayList = new ArrayList<>(3);
        for (String next : this.aXZ) {
            for (o next2 : this.aXY) {
                String MJ = next2.MJ();
                if (StringUtils.isValidString(MJ) && next.equalsIgnoreCase(MJ)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.aXY;
        }
        Collections.sort(arrayList, new Comparator<o>() {
            /* renamed from: a */
            public int compare(o oVar, o oVar2) {
                return Long.compare(oVar.MK(), oVar2.MK());
            }
        });
        if (aVar == a.DYNAMIC) {
            for (o oVar2 : arrayList) {
                if (oVar2.MK() > j) {
                    break;
                }
                oVar = oVar2;
            }
            return oVar != null ? oVar : (o) arrayList.get(0);
        } else if (aVar == a.LOW) {
            return (o) arrayList.get(0);
        } else {
            if (aVar == a.MEDIUM) {
                return (o) arrayList.get(arrayList.size() / 2);
            }
            return (o) arrayList.get(arrayList.size() - 1);
        }
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.aXY + ", durationSeconds=" + this.aYa + ", destinationUri=" + this.aXg + ", clickTrackers=" + this.aXi + ", eventTrackers=" + this.aXj + ", industryIcon=" + this.aYb + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.aYa != nVar.aYa) {
            return false;
        }
        List<o> list = this.aXY;
        if (list == null ? nVar.aXY != null : !list.equals(nVar.aXY)) {
            return false;
        }
        Uri uri = this.aXg;
        if (uri == null ? nVar.aXg != null : !uri.equals(nVar.aXg)) {
            return false;
        }
        Set<k> set = this.aXi;
        if (set == null ? nVar.aXi != null : !set.equals(nVar.aXi)) {
            return false;
        }
        Map<String, Set<k>> map = this.aXj;
        Map<String, Set<k>> map2 = nVar.aXj;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<o> list = this.aXY;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.aYa) * 31;
        Uri uri = this.aXg;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<k> set = this.aXi;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<k>> map = this.aXj;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }
}
