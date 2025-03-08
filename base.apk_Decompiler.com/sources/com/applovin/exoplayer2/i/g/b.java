package com.applovin.exoplayer2.i.g;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.a.w;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

final class b {
    private static final Pattern Sd = Pattern.compile("\\s+");
    private static final w<String> Se = w.m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "none");
    private static final w<String> Sf = w.a("dot", "sesame", "circle");
    private static final w<String> Sg = w.m("filled", "open");
    private static final w<String> Sh = w.a("after", "before", "outside");
    public final int Rq;
    public final int Rr;
    public final int oX;

    private b(int i, int i2, int i3) {
        this.Rq = i;
        this.Rr = i2;
        this.oX = i3;
    }

    public static b an(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return a(w.e((E[]) TextUtils.split(lowerCase, Sd)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ed, code lost:
        if (r9.equals("dot") != false) goto L_0x0103;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.i.g.b a(com.applovin.exoplayer2.common.a.w<java.lang.String> r9) {
        /*
            com.applovin.exoplayer2.common.a.w<java.lang.String> r0 = Sh
            com.applovin.exoplayer2.common.a.aq$b r0 = com.applovin.exoplayer2.common.a.aq.a(r0, (java.util.Set<?>) r9)
            java.lang.String r1 = "outside"
            java.lang.Object r0 = com.applovin.exoplayer2.common.a.x.a(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            r3 = -1392885889(0xffffffffacfa3f7f, float:-7.112477E-12)
            r4 = 0
            r5 = 2
            r6 = 1
            r7 = -1
            if (r2 == r3) goto L_0x0038
            r3 = -1106037339(0xffffffffbe1335a5, float:-0.14375933)
            if (r2 == r3) goto L_0x0030
            r1 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r2 == r1) goto L_0x0026
            goto L_0x0042
        L_0x0026:
            java.lang.String r1 = "after"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x0030:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "before"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 2
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            if (r0 == 0) goto L_0x004b
            if (r0 == r6) goto L_0x0049
            r0 = 1
            goto L_0x004c
        L_0x0049:
            r0 = -2
            goto L_0x004c
        L_0x004b:
            r0 = 2
        L_0x004c:
            com.applovin.exoplayer2.common.a.w<java.lang.String> r1 = Se
            com.applovin.exoplayer2.common.a.aq$b r1 = com.applovin.exoplayer2.common.a.aq.a(r1, (java.util.Set<?>) r9)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0087
            java.util.Iterator r9 = r1.iterator()
            java.lang.Object r9 = r9.next()
            java.lang.String r9 = (java.lang.String) r9
            int r1 = r9.hashCode()
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L_0x007b
            r2 = 3387192(0x33af38, float:4.746467E-39)
            if (r1 == r2) goto L_0x0071
            goto L_0x0081
        L_0x0071:
            java.lang.String r1 = "none"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0081
            r7 = 0
            goto L_0x0081
        L_0x007b:
            java.lang.String r1 = "auto"
            boolean r9 = r9.equals(r1)
        L_0x0081:
            com.applovin.exoplayer2.i.g.b r9 = new com.applovin.exoplayer2.i.g.b
            r9.<init>(r7, r4, r0)
            return r9
        L_0x0087:
            com.applovin.exoplayer2.common.a.w<java.lang.String> r1 = Sg
            com.applovin.exoplayer2.common.a.aq$b r1 = com.applovin.exoplayer2.common.a.aq.a(r1, (java.util.Set<?>) r9)
            com.applovin.exoplayer2.common.a.w<java.lang.String> r2 = Sf
            com.applovin.exoplayer2.common.a.aq$b r9 = com.applovin.exoplayer2.common.a.aq.a(r2, (java.util.Set<?>) r9)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00a5
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x00a5
            com.applovin.exoplayer2.i.g.b r9 = new com.applovin.exoplayer2.i.g.b
            r9.<init>(r7, r4, r0)
            return r9
        L_0x00a5:
            java.lang.String r2 = "filled"
            java.lang.Object r1 = com.applovin.exoplayer2.common.a.x.a(r1, r2)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r1.hashCode()
            r8 = -1274499742(0xffffffffb408ad62, float:-1.2729063E-7)
            if (r3 == r8) goto L_0x00c6
            r2 = 3417674(0x34264a, float:4.789181E-39)
            if (r3 == r2) goto L_0x00bc
            goto L_0x00ca
        L_0x00bc:
            java.lang.String r2 = "open"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ca
            r1 = 2
            goto L_0x00cb
        L_0x00c6:
            boolean r1 = r1.equals(r2)
        L_0x00ca:
            r1 = 1
        L_0x00cb:
            java.lang.String r2 = "circle"
            java.lang.Object r9 = com.applovin.exoplayer2.common.a.x.a(r9, r2)
            java.lang.String r9 = (java.lang.String) r9
            int r3 = r9.hashCode()
            r8 = -1360216880(0xffffffffaeecbcd0, float:-1.0765577E-10)
            if (r3 == r8) goto L_0x00fa
            r2 = -905816648(0xffffffffca0255b8, float:-2135406.0)
            if (r3 == r2) goto L_0x00f0
            r2 = 99657(0x18549, float:1.39649E-40)
            if (r3 == r2) goto L_0x00e7
            goto L_0x0102
        L_0x00e7:
            java.lang.String r2 = "dot"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0102
            goto L_0x0103
        L_0x00f0:
            java.lang.String r2 = "sesame"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0102
            r4 = 1
            goto L_0x0103
        L_0x00fa:
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0102
            r4 = 2
            goto L_0x0103
        L_0x0102:
            r4 = -1
        L_0x0103:
            if (r4 == 0) goto L_0x010a
            if (r4 == r6) goto L_0x0109
            r5 = 1
            goto L_0x010a
        L_0x0109:
            r5 = 3
        L_0x010a:
            com.applovin.exoplayer2.i.g.b r9 = new com.applovin.exoplayer2.i.g.b
            r9.<init>(r5, r1, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.g.b.a(com.applovin.exoplayer2.common.a.w):com.applovin.exoplayer2.i.g.b");
    }
}
