package com.applovin.exoplayer2.e.g;

import android.util.Pair;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.e.g.a;
import com.applovin.exoplayer2.e.k;
import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class b {
    private static final byte[] zp = ai.bk("OpusHead");

    /* renamed from: com.applovin.exoplayer2.e.g.b$b  reason: collision with other inner class name */
    private interface C0042b {
        int iI();

        int iJ();

        int iK();
    }

    private static int ck(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<n> a(a.C0041a aVar, r rVar, long j, com.applovin.exoplayer2.d.e eVar, boolean z, boolean z2, Function<k, k> function) throws com.applovin.exoplayer2.ai {
        a.C0041a aVar2 = aVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar2.zn.size(); i++) {
            a.C0041a aVar3 = aVar2.zn.get(i);
            if (aVar3.bs != 1953653099) {
                r rVar2 = rVar;
                Function<k, k> function2 = function;
            } else {
                k apply = function.apply(a(aVar3, (a.b) com.applovin.exoplayer2.l.a.checkNotNull(aVar.ci(1836476516)), j, eVar, z, z2));
                if (apply == null) {
                    r rVar3 = rVar;
                } else {
                    r rVar4 = rVar;
                    arrayList.add(a(apply, (a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.cj(1835297121))).cj(1835626086))).cj(1937007212)), rVar));
                }
            }
        }
        return arrayList;
    }

    public static Pair<com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.g.a> b(a.b bVar) {
        y yVar = bVar.zo;
        yVar.fx(8);
        com.applovin.exoplayer2.g.a aVar = null;
        com.applovin.exoplayer2.g.a aVar2 = null;
        while (yVar.pj() >= 8) {
            int il = yVar.il();
            int px = yVar.px();
            int px2 = yVar.px();
            if (px2 == 1835365473) {
                yVar.fx(il);
                aVar = g(yVar, il + px);
            } else if (px2 == 1936553057) {
                yVar.fx(il);
                aVar2 = i(yVar, il + px);
            }
            yVar.fx(il + px);
        }
        return Pair.create(aVar, aVar2);
    }

    public static com.applovin.exoplayer2.g.a b(a.C0041a aVar) {
        a.b ci = aVar.ci(1751411826);
        a.b ci2 = aVar.ci(1801812339);
        a.b ci3 = aVar.ci(1768715124);
        if (ci == null || ci2 == null || ci3 == null || s(ci.zo) != 1835299937) {
            return null;
        }
        y yVar = ci2.zo;
        yVar.fx(12);
        int px = yVar.px();
        String[] strArr = new String[px];
        for (int i = 0; i < px; i++) {
            int px2 = yVar.px();
            yVar.fz(4);
            strArr[i] = yVar.fB(px2 - 8);
        }
        y yVar2 = ci3.zo;
        yVar2.fx(8);
        ArrayList arrayList = new ArrayList();
        while (yVar2.pj() > 8) {
            int il = yVar2.il();
            int px3 = yVar2.px();
            int px4 = yVar2.px() - 1;
            if (px4 < 0 || px4 >= px) {
                q.h("AtomParsers", "Skipped metadata with unknown key index: " + px4);
            } else {
                com.applovin.exoplayer2.g.f.a a2 = f.a(yVar2, il + px3, strArr[px4]);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            yVar2.fx(il + px3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.applovin.exoplayer2.g.a((List<? extends a.C0047a>) arrayList);
    }

    public static void p(y yVar) {
        int il = yVar.il();
        yVar.fz(4);
        if (yVar.px() != 1751411826) {
            il += 4;
        }
        yVar.fx(il);
    }

    private static k a(a.C0041a aVar, a.b bVar, long j, com.applovin.exoplayer2.d.e eVar, boolean z, boolean z2) throws com.applovin.exoplayer2.ai {
        long j2;
        a.b bVar2;
        long[] jArr;
        long[] jArr2;
        a.C0041a cj;
        Pair<long[], long[]> c2;
        a.C0041a aVar2 = aVar;
        a.C0041a aVar3 = (a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(aVar2.cj(1835297121));
        int ck = ck(s(((a.b) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.ci(1751411826))).zo));
        if (ck == -1) {
            return null;
        }
        f r = r(((a.b) com.applovin.exoplayer2.l.a.checkNotNull(aVar2.ci(1953196132))).zo);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = r.zE;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long q = q(bVar2.zo);
        if (j2 != -9223372036854775807L) {
            j3 = ai.e(j2, 1000000, q);
        }
        long j4 = j3;
        Pair<Long, String> t = t(((a.b) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.ci(1835296868))).zo);
        c a2 = a(((a.b) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(((a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(aVar3.cj(1835626086))).cj(1937007212))).ci(1937011556))).zo, r.zD, r.dG, (String) t.second, eVar, z2);
        if (z || (cj = aVar2.cj(1701082227)) == null || (c2 = c(cj)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr = (long[]) c2.second;
            jArr2 = (long[]) c2.first;
        }
        if (a2.dU == null) {
            return null;
        }
        return new k(r.zD, ck, ((Long) t.first).longValue(), q, j4, a2.dU, a2.zy, a2.zx, a2.wo, jArr2, jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.e.g.n a(com.applovin.exoplayer2.e.g.k r38, com.applovin.exoplayer2.e.g.a.C0041a r39, com.applovin.exoplayer2.e.r r40) throws com.applovin.exoplayer2.ai {
        /*
            r1 = r38
            r0 = r39
            r2 = r40
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.applovin.exoplayer2.e.g.a$b r3 = r0.ci(r3)
            if (r3 == 0) goto L_0x0017
            com.applovin.exoplayer2.e.g.b$d r5 = new com.applovin.exoplayer2.e.g.b$d
            com.applovin.exoplayer2.v r6 = r1.dU
            r5.<init>(r3, r6)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.applovin.exoplayer2.e.g.a$b r3 = r0.ci(r3)
            if (r3 == 0) goto L_0x051e
            com.applovin.exoplayer2.e.g.b$e r5 = new com.applovin.exoplayer2.e.g.b$e
            r5.<init>(r3)
        L_0x0025:
            int r3 = r5.iI()
            r6 = 0
            if (r3 != 0) goto L_0x0040
            com.applovin.exoplayer2.e.g.n r9 = new com.applovin.exoplayer2.e.g.n
            long[] r2 = new long[r6]
            int[] r3 = new int[r6]
            r4 = 0
            long[] r5 = new long[r6]
            int[] r6 = new int[r6]
            r7 = 0
            r0 = r9
            r1 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0040:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.applovin.exoplayer2.e.g.a$b r7 = r0.ci(r7)
            r8 = 1
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.applovin.exoplayer2.e.g.a$b r7 = r0.ci(r7)
            java.lang.Object r7 = com.applovin.exoplayer2.l.a.checkNotNull(r7)
            com.applovin.exoplayer2.e.g.a$b r7 = (com.applovin.exoplayer2.e.g.a.b) r7
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            com.applovin.exoplayer2.l.y r7 = r7.zo
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            com.applovin.exoplayer2.e.g.a$b r10 = r0.ci(r10)
            java.lang.Object r10 = com.applovin.exoplayer2.l.a.checkNotNull(r10)
            com.applovin.exoplayer2.e.g.a$b r10 = (com.applovin.exoplayer2.e.g.a.b) r10
            com.applovin.exoplayer2.l.y r10 = r10.zo
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            com.applovin.exoplayer2.e.g.a$b r11 = r0.ci(r11)
            java.lang.Object r11 = com.applovin.exoplayer2.l.a.checkNotNull(r11)
            com.applovin.exoplayer2.e.g.a$b r11 = (com.applovin.exoplayer2.e.g.a.b) r11
            com.applovin.exoplayer2.l.y r11 = r11.zo
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            com.applovin.exoplayer2.e.g.a$b r12 = r0.ci(r12)
            if (r12 == 0) goto L_0x0086
            com.applovin.exoplayer2.l.y r12 = r12.zo
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.applovin.exoplayer2.e.g.a$b r0 = r0.ci(r13)
            if (r0 == 0) goto L_0x0093
            com.applovin.exoplayer2.l.y r0 = r0.zo
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            com.applovin.exoplayer2.e.g.b$a r13 = new com.applovin.exoplayer2.e.g.b$a
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.fx(r7)
            int r9 = r11.pD()
            int r9 = r9 - r8
            int r10 = r11.pD()
            int r14 = r11.pD()
            if (r0 == 0) goto L_0x00b5
            r0.fx(r7)
            int r15 = r0.pD()
            goto L_0x00b6
        L_0x00b5:
            r15 = 0
        L_0x00b6:
            r4 = -1
            if (r12 == 0) goto L_0x00cb
            r12.fx(r7)
            int r7 = r12.pD()
            if (r7 <= 0) goto L_0x00c9
            int r16 = r12.pD()
            int r16 = r16 + -1
            goto L_0x00ce
        L_0x00c9:
            r12 = 0
            goto L_0x00cc
        L_0x00cb:
            r7 = 0
        L_0x00cc:
            r16 = -1
        L_0x00ce:
            int r6 = r5.iJ()
            com.applovin.exoplayer2.v r8 = r1.dU
            java.lang.String r8 = r8.dz
            if (r6 == r4) goto L_0x00fa
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f0
            java.lang.String r4 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f0
            java.lang.String r4 = "audio/g711-alaw"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00fa
        L_0x00f0:
            if (r9 != 0) goto L_0x00fa
            if (r15 != 0) goto L_0x00fa
            if (r7 != 0) goto L_0x00fa
            r39 = r7
            r4 = 1
            goto L_0x00fd
        L_0x00fa:
            r39 = r7
            r4 = 0
        L_0x00fd:
            if (r4 == 0) goto L_0x0135
            int r0 = r13.fR
            long[] r0 = new long[r0]
            int r4 = r13.fR
            int[] r4 = new int[r4]
        L_0x0107:
            boolean r5 = r13.iH()
            if (r5 == 0) goto L_0x011a
            int r5 = r13.Y
            long r9 = r13.zr
            r0[r5] = r9
            int r5 = r13.Y
            int r9 = r13.zq
            r4[r5] = r9
            goto L_0x0107
        L_0x011a:
            long r9 = (long) r14
            com.applovin.exoplayer2.e.g.d$a r0 = com.applovin.exoplayer2.e.g.d.a(r6, r0, r4, r9)
            long[] r4 = r0.tS
            int[] r5 = r0.tR
            int r6 = r0.zH
            long[] r9 = r0.zI
            int[] r10 = r0.zJ
            long r11 = r0.zE
            r14 = r1
            r0 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r13 = r10
            r15 = r11
            r12 = r9
            goto L_0x029d
        L_0x0135:
            long[] r4 = new long[r3]
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            int[] r8 = new int[r3]
            r24 = r11
            r2 = r16
            r1 = 0
            r11 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r16 = r15
            r15 = r14
            r14 = r10
            r37 = r9
            r9 = r39
        L_0x0155:
            r39 = r37
            java.lang.String r10 = "AtomParsers"
            if (r1 >= r3) goto L_0x0219
            r28 = r27
            r27 = r22
            r22 = 1
        L_0x0161:
            if (r27 != 0) goto L_0x017e
            boolean r22 = r13.iH()
            if (r22 == 0) goto L_0x017e
            r30 = r14
            r31 = r15
            long r14 = r13.zr
            r32 = r3
            int r3 = r13.zq
            r27 = r3
            r28 = r14
            r14 = r30
            r15 = r31
            r3 = r32
            goto L_0x0161
        L_0x017e:
            r32 = r3
            r30 = r14
            r31 = r15
            if (r22 != 0) goto L_0x01a2
            java.lang.String r2 = "Unexpected end of chunk data"
            com.applovin.exoplayer2.l.q.h(r10, r2)
            long[] r4 = java.util.Arrays.copyOf(r4, r1)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r7 = java.util.Arrays.copyOf(r7, r1)
            int[] r8 = java.util.Arrays.copyOf(r8, r1)
            r3 = r1
            r2 = r21
            r1 = r27
            goto L_0x0221
        L_0x01a2:
            if (r0 == 0) goto L_0x01b5
        L_0x01a4:
            if (r23 != 0) goto L_0x01b3
            if (r16 <= 0) goto L_0x01b3
            int r23 = r0.pD()
            int r21 = r0.px()
            int r16 = r16 + -1
            goto L_0x01a4
        L_0x01b3:
            int r23 = r23 + -1
        L_0x01b5:
            r3 = r21
            r4[r1] = r28
            int r10 = r5.iK()
            r6[r1] = r10
            if (r10 <= r11) goto L_0x01c2
            r11 = r10
        L_0x01c2:
            long r14 = (long) r3
            long r14 = r25 + r14
            r7[r1] = r14
            if (r12 != 0) goto L_0x01cb
            r10 = 1
            goto L_0x01cc
        L_0x01cb:
            r10 = 0
        L_0x01cc:
            r8[r1] = r10
            if (r1 != r2) goto L_0x01e2
            r10 = 1
            r8[r1] = r10
            int r9 = r9 + -1
            if (r9 <= 0) goto L_0x01e2
            java.lang.Object r2 = com.applovin.exoplayer2.l.a.checkNotNull(r12)
            com.applovin.exoplayer2.l.y r2 = (com.applovin.exoplayer2.l.y) r2
            int r2 = r2.pD()
            int r2 = r2 - r10
        L_0x01e2:
            r15 = r2
            r10 = r3
            r14 = r31
            long r2 = (long) r14
            long r25 = r25 + r2
            int r2 = r30 + -1
            if (r2 != 0) goto L_0x01fa
            if (r39 <= 0) goto L_0x01fa
            int r2 = r24.pD()
            int r3 = r24.px()
            int r14 = r39 + -1
            goto L_0x01fd
        L_0x01fa:
            r3 = r14
            r14 = r39
        L_0x01fd:
            r39 = r2
            r2 = r6[r1]
            r21 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r22 = r27 + -1
            int r1 = r1 + 1
            r27 = r2
            r2 = r15
            r15 = r21
            r3 = r32
            r21 = r10
            r37 = r14
            r14 = r39
            goto L_0x0155
        L_0x0219:
            r32 = r3
            r30 = r14
            r2 = r21
            r1 = r22
        L_0x0221:
            long r12 = (long) r2
            long r12 = r25 + r12
            if (r0 == 0) goto L_0x0236
        L_0x0226:
            if (r16 <= 0) goto L_0x0236
            int r2 = r0.pD()
            if (r2 == 0) goto L_0x0230
            r0 = 0
            goto L_0x0237
        L_0x0230:
            r0.px()
            int r16 = r16 + -1
            goto L_0x0226
        L_0x0236:
            r0 = 1
        L_0x0237:
            if (r9 != 0) goto L_0x0249
            if (r30 != 0) goto L_0x0249
            if (r1 != 0) goto L_0x0249
            if (r39 != 0) goto L_0x0249
            r2 = r23
            if (r2 != 0) goto L_0x024b
            if (r0 != 0) goto L_0x0246
            goto L_0x024b
        L_0x0246:
            r14 = r38
            goto L_0x0296
        L_0x0249:
            r2 = r23
        L_0x024b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r14 = "Inconsistent stbl box for track "
            r5.<init>(r14)
            r14 = r38
            int r15 = r14.zD
            r5.append(r15)
            java.lang.String r15 = ": remainingSynchronizationSamples "
            r5.append(r15)
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesAtTimestampDelta "
            r5.append(r9)
            r9 = r30
            r5.append(r9)
            java.lang.String r9 = ", remainingSamplesInChunk "
            r5.append(r9)
            r5.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r5.append(r1)
            r9 = r39
            r5.append(r9)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r5.append(r1)
            r5.append(r2)
            if (r0 != 0) goto L_0x028a
            java.lang.String r0 = ", ctts invalid"
            goto L_0x028c
        L_0x028a:
            java.lang.String r0 = ""
        L_0x028c:
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.applovin.exoplayer2.l.q.h(r10, r0)
        L_0x0296:
            r0 = r3
            r2 = r4
            r3 = r6
            r4 = r11
            r15 = r12
            r12 = r7
            r13 = r8
        L_0x029d:
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r14.AP
            r5 = r15
            long r7 = com.applovin.exoplayer2.l.ai.e(r5, r7, r9)
            long[] r1 = r14.AS
            r10 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02be
            long r0 = r14.AP
            com.applovin.exoplayer2.l.ai.a((long[]) r12, (long) r10, (long) r0)
            com.applovin.exoplayer2.e.g.n r9 = new com.applovin.exoplayer2.e.g.n
            r0 = r9
            r1 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02be:
            long[] r1 = r14.AS
            int r1 = r1.length
            r5 = 1
            if (r1 != r5) goto L_0x035d
            int r1 = r14.bs
            if (r1 != r5) goto L_0x035d
            int r1 = r12.length
            r5 = 2
            if (r1 < r5) goto L_0x035d
            long[] r1 = r14.AT
            java.lang.Object r1 = com.applovin.exoplayer2.l.a.checkNotNull(r1)
            long[] r1 = (long[]) r1
            r5 = 0
            r21 = r1[r5]
            long[] r1 = r14.AS
            r23 = r1[r5]
            long r5 = r14.AP
            long r7 = r14.AQ
            r25 = r5
            r27 = r7
            long r5 = com.applovin.exoplayer2.l.ai.e(r23, r25, r27)
            long r23 = r21 + r5
            r5 = r12
            r6 = r15
            r8 = r21
            r25 = r0
            r0 = r10
            r10 = r23
            boolean r5 = a((long[]) r5, (long) r6, (long) r8, (long) r10)
            if (r5 == 0) goto L_0x035f
            long r6 = r15 - r23
            r5 = 0
            r8 = r12[r5]
            long r26 = r21 - r8
            com.applovin.exoplayer2.v r5 = r14.dU
            int r5 = r5.dM
            long r8 = (long) r5
            long r10 = r14.AP
            r28 = r8
            r30 = r10
            long r10 = com.applovin.exoplayer2.l.ai.e(r26, r28, r30)
            com.applovin.exoplayer2.v r5 = r14.dU
            int r5 = r5.dM
            long r8 = (long) r5
            long r0 = r14.AP
            r39 = r4
            r4 = r10
            r10 = r0
            long r0 = com.applovin.exoplayer2.l.ai.e(r6, r8, r10)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0327
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0361
        L_0x0327:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0361
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0361
            int r5 = (int) r4
            r4 = r40
            r4.dO = r5
            int r1 = (int) r0
            r4.dP = r1
            long r0 = r14.AP
            r4 = 1000000(0xf4240, double:4.940656E-318)
            com.applovin.exoplayer2.l.ai.a((long[]) r12, (long) r4, (long) r0)
            long[] r0 = r14.AS
            r1 = 0
            r4 = r0[r1]
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r14.AQ
            long r7 = com.applovin.exoplayer2.l.ai.e(r4, r6, r8)
            com.applovin.exoplayer2.e.g.n r9 = new com.applovin.exoplayer2.e.g.n
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x035d:
            r25 = r0
        L_0x035f:
            r39 = r4
        L_0x0361:
            long[] r0 = r14.AS
            int r0 = r0.length
            r1 = 1
            if (r0 != r1) goto L_0x03ae
            long[] r0 = r14.AS
            r1 = 0
            r4 = r0[r1]
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x03ae
            long[] r0 = r14.AT
            java.lang.Object r0 = com.applovin.exoplayer2.l.a.checkNotNull(r0)
            long[] r0 = (long[]) r0
            r4 = r0[r1]
            r6 = 0
        L_0x037d:
            int r0 = r12.length
            if (r6 >= r0) goto L_0x0394
            r0 = r12[r6]
            long r17 = r0 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.AP
            r21 = r0
            long r0 = com.applovin.exoplayer2.l.ai.e(r17, r19, r21)
            r12[r6] = r0
            int r6 = r6 + 1
            goto L_0x037d
        L_0x0394:
            long r17 = r15 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.AP
            r21 = r0
            long r7 = com.applovin.exoplayer2.l.ai.e(r17, r19, r21)
            com.applovin.exoplayer2.e.g.n r9 = new com.applovin.exoplayer2.e.g.n
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03ae:
            int r0 = r14.bs
            r1 = 1
            if (r0 != r1) goto L_0x03b5
            r10 = 1
            goto L_0x03b6
        L_0x03b5:
            r10 = 0
        L_0x03b6:
            long[] r0 = r14.AS
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r1 = r14.AS
            int r1 = r1.length
            int[] r1 = new int[r1]
            long[] r4 = r14.AT
            java.lang.Object r4 = com.applovin.exoplayer2.l.a.checkNotNull(r4)
            long[] r4 = (long[]) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x03cc:
            long[] r9 = r14.AS
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0432
            r9 = r2
            r11 = r3
            r2 = r4[r5]
            r15 = -1
            int r21 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r21 == 0) goto L_0x041e
            long[] r15 = r14.AS
            r26 = r15[r5]
            r15 = r8
            r16 = r9
            long r8 = r14.AP
            r40 = r6
            r21 = r7
            long r6 = r14.AQ
            r28 = r8
            r30 = r6
            long r6 = com.applovin.exoplayer2.l.ai.e(r26, r28, r30)
            r8 = 1
            int r9 = com.applovin.exoplayer2.l.ai.a((long[]) r12, (long) r2, (boolean) r8, (boolean) r8)
            r0[r5] = r9
            long r2 = r2 + r6
            r6 = 0
            int r2 = com.applovin.exoplayer2.l.ai.b((long[]) r12, (long) r2, (boolean) r10, (boolean) r6)
            r1[r5] = r2
        L_0x0401:
            r2 = r0[r5]
            r3 = r1[r5]
            if (r2 >= r3) goto L_0x0411
            r7 = r13[r2]
            r7 = r7 & r8
            if (r7 != 0) goto L_0x0411
            int r2 = r2 + 1
            r0[r5] = r2
            goto L_0x0401
        L_0x0411:
            int r7 = r3 - r2
            int r7 = r21 + r7
            r9 = r15
            if (r9 == r2) goto L_0x041a
            r2 = 1
            goto L_0x041b
        L_0x041a:
            r2 = 0
        L_0x041b:
            r2 = r40 | r2
            goto L_0x042a
        L_0x041e:
            r40 = r6
            r21 = r7
            r16 = r9
            r6 = 0
            r9 = r8
            r8 = 1
            r2 = r40
            r3 = r9
        L_0x042a:
            int r5 = r5 + 1
            r6 = r2
            r8 = r3
            r3 = r11
            r2 = r16
            goto L_0x03cc
        L_0x0432:
            r16 = r2
            r11 = r3
            r40 = r6
            r3 = r25
            r6 = 0
            r8 = 1
            if (r7 == r3) goto L_0x043e
            goto L_0x043f
        L_0x043e:
            r8 = 0
        L_0x043f:
            r2 = r40 | r8
            if (r2 == 0) goto L_0x0446
            long[] r3 = new long[r7]
            goto L_0x0448
        L_0x0446:
            r3 = r16
        L_0x0448:
            if (r2 == 0) goto L_0x044d
            int[] r4 = new int[r7]
            goto L_0x044e
        L_0x044d:
            r4 = r11
        L_0x044e:
            if (r2 == 0) goto L_0x0452
            r5 = 0
            goto L_0x0454
        L_0x0452:
            r5 = r39
        L_0x0454:
            if (r2 == 0) goto L_0x0459
            int[] r8 = new int[r7]
            goto L_0x045a
        L_0x0459:
            r8 = r13
        L_0x045a:
            long[] r7 = new long[r7]
            r39 = r5
            r9 = 0
            r15 = 0
        L_0x0461:
            long[] r5 = r14.AS
            int r5 = r5.length
            if (r6 >= r5) goto L_0x04fe
            long[] r5 = r14.AT
            r17 = r5[r6]
            r5 = r0[r6]
            r27 = r0
            r0 = r1[r6]
            r28 = r1
            if (r2 == 0) goto L_0x0484
            int r1 = r0 - r5
            r29 = r6
            r6 = r16
            java.lang.System.arraycopy(r6, r5, r3, r15, r1)
            java.lang.System.arraycopy(r11, r5, r4, r15, r1)
            java.lang.System.arraycopy(r13, r5, r8, r15, r1)
            goto L_0x0488
        L_0x0484:
            r29 = r6
            r6 = r16
        L_0x0488:
            r1 = r39
        L_0x048a:
            if (r5 >= r0) goto L_0x04da
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r40 = r0
            r16 = r1
            long r0 = r14.AQ
            r21 = r9
            r25 = r0
            long r0 = com.applovin.exoplayer2.l.ai.e(r21, r23, r25)
            r21 = r12[r5]
            r23 = r12
            r24 = r13
            long r12 = r21 - r17
            r30 = r8
            r21 = r9
            r8 = 0
            long r31 = java.lang.Math.max(r8, r12)
            r33 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r14.AP
            r35 = r12
            long r12 = com.applovin.exoplayer2.l.ai.e(r31, r33, r35)
            long r0 = r0 + r12
            r7[r15] = r0
            if (r2 == 0) goto L_0x04c9
            r0 = r4[r15]
            r1 = r16
            if (r0 <= r1) goto L_0x04cb
            r0 = r11[r5]
            r1 = r0
            goto L_0x04cb
        L_0x04c9:
            r1 = r16
        L_0x04cb:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r0 = r40
            r9 = r21
            r12 = r23
            r13 = r24
            r8 = r30
            goto L_0x048a
        L_0x04da:
            r30 = r8
            r21 = r9
            r23 = r12
            r24 = r13
            r8 = 0
            long[] r0 = r14.AS
            r12 = r0[r29]
            long r12 = r21 + r12
            int r0 = r29 + 1
            r39 = r1
            r16 = r6
            r9 = r12
            r12 = r23
            r13 = r24
            r1 = r28
            r8 = r30
            r6 = r0
            r0 = r27
            goto L_0x0461
        L_0x04fe:
            r30 = r8
            r21 = r9
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.AQ
            r25 = r0
            long r8 = com.applovin.exoplayer2.l.ai.e(r21, r23, r25)
            com.applovin.exoplayer2.e.g.n r10 = new com.applovin.exoplayer2.e.g.n
            r0 = r10
            r1 = r38
            r2 = r3
            r3 = r4
            r4 = r39
            r5 = r7
            r6 = r30
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x051e:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            com.applovin.exoplayer2.ai r0 = com.applovin.exoplayer2.ai.c(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.b.a(com.applovin.exoplayer2.e.g.k, com.applovin.exoplayer2.e.g.a$a, com.applovin.exoplayer2.e.r):com.applovin.exoplayer2.e.g.n");
    }

    private static com.applovin.exoplayer2.g.a g(y yVar, int i) {
        yVar.fz(8);
        p(yVar);
        while (yVar.il() < i) {
            int il = yVar.il();
            int px = yVar.px();
            if (yVar.px() == 1768715124) {
                yVar.fx(il);
                return h(yVar, il + px);
            }
            yVar.fx(il + px);
        }
        return null;
    }

    private static com.applovin.exoplayer2.g.a h(y yVar, int i) {
        yVar.fz(8);
        ArrayList arrayList = new ArrayList();
        while (yVar.il() < i) {
            a.C0047a z = f.z(yVar);
            if (z != null) {
                arrayList.add(z);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.applovin.exoplayer2.g.a((List<? extends a.C0047a>) arrayList);
    }

    private static com.applovin.exoplayer2.g.a i(y yVar, int i) {
        yVar.fz(12);
        while (yVar.il() < i) {
            int il = yVar.il();
            int px = yVar.px();
            if (yVar.px() != 1935766900) {
                yVar.fx(il + px);
            } else if (px < 14) {
                return null;
            } else {
                yVar.fz(5);
                int po = yVar.po();
                if (po != 12 && po != 13) {
                    return null;
                }
                float f2 = po == 12 ? 240.0f : 120.0f;
                yVar.fz(1);
                return new com.applovin.exoplayer2.g.a(new com.applovin.exoplayer2.g.f.d(f2, yVar.po()));
            }
        }
        return null;
    }

    private static long q(y yVar) {
        int i = 8;
        yVar.fx(8);
        if (a.cf(yVar.px()) != 0) {
            i = 16;
        }
        yVar.fz(i);
        return yVar.pv();
    }

    private static f r(y yVar) {
        long j;
        int i = 8;
        yVar.fx(8);
        int cf = a.cf(yVar.px());
        yVar.fz(cf == 0 ? 8 : 16);
        int px = yVar.px();
        yVar.fz(4);
        int il = yVar.il();
        if (cf == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i3 >= i) {
                yVar.fz(i);
                break;
            } else if (yVar.hO()[il + i3] != -1) {
                long pv = cf == 0 ? yVar.pv() : yVar.pF();
                if (pv != 0) {
                    j = pv;
                }
            } else {
                i3++;
            }
        }
        yVar.fz(16);
        int px2 = yVar.px();
        int px3 = yVar.px();
        yVar.fz(4);
        int px4 = yVar.px();
        int px5 = yVar.px();
        if (px2 == 0 && px3 == 65536 && px4 == -65536 && px5 == 0) {
            i2 = 90;
        } else if (px2 == 0 && px3 == -65536 && px4 == 65536 && px5 == 0) {
            i2 = 270;
        } else if (px2 == -65536 && px3 == 0 && px4 == 0 && px5 == -65536) {
            i2 = 180;
        }
        return new f(px, j, i2);
    }

    private static int s(y yVar) {
        yVar.fx(16);
        return yVar.px();
    }

    private static Pair<Long, String> t(y yVar) {
        int i = 8;
        yVar.fx(8);
        int cf = a.cf(yVar.px());
        yVar.fz(cf == 0 ? 8 : 16);
        long pv = yVar.pv();
        if (cf == 0) {
            i = 4;
        }
        yVar.fz(i);
        int pp = yVar.pp();
        return Pair.create(Long.valueOf(pv), "" + ((char) (((pp >> 10) & 31) + 96)) + ((char) (((pp >> 5) & 31) + 96)) + ((char) ((pp & 31) + 96)));
    }

    private static c a(y yVar, int i, int i2, String str, com.applovin.exoplayer2.d.e eVar, boolean z) throws com.applovin.exoplayer2.ai {
        int i3;
        y yVar2 = yVar;
        int i4 = i;
        yVar2.fx(12);
        int px = yVar.px();
        c cVar = new c(px);
        for (int i5 = 0; i5 < px; i5++) {
            int il = yVar.il();
            int px2 = yVar.px();
            k.a(px2 > 0, "childAtomSize must be positive");
            int px3 = yVar.px();
            if (px3 == 1635148593 || px3 == 1635148595 || px3 == 1701733238 || px3 == 1831958048 || px3 == 1836070006 || px3 == 1752589105 || px3 == 1751479857 || px3 == 1932670515 || px3 == 1211250227 || px3 == 1987063864 || px3 == 1987063865 || px3 == 1635135537 || px3 == 1685479798 || px3 == 1685479729 || px3 == 1685481573 || px3 == 1685481521) {
                i3 = il;
                a(yVar, px3, i3, px2, i, i2, eVar, cVar, i5);
            } else if (px3 == 1836069985 || px3 == 1701733217 || px3 == 1633889587 || px3 == 1700998451 || px3 == 1633889588 || px3 == 1685353315 || px3 == 1685353317 || px3 == 1685353320 || px3 == 1685353324 || px3 == 1685353336 || px3 == 1935764850 || px3 == 1935767394 || px3 == 1819304813 || px3 == 1936684916 || px3 == 1953984371 || px3 == 778924082 || px3 == 778924083 || px3 == 1835557169 || px3 == 1835560241 || px3 == 1634492771 || px3 == 1634492791 || px3 == 1970037111 || px3 == 1332770163 || px3 == 1716281667) {
                i3 = il;
                a(yVar, px3, il, px2, i, str, z, eVar, cVar, i5);
            } else {
                if (px3 == 1414810956 || px3 == 1954034535 || px3 == 2004251764 || px3 == 1937010800 || px3 == 1664495672) {
                    a(yVar, px3, il, px2, i, str, cVar);
                } else if (px3 == 1835365492) {
                    a(yVar2, px3, il, i4, cVar);
                } else if (px3 == 1667329389) {
                    cVar.dU = new v.a().D(i4).m("application/x-camera-motion").bT();
                }
                i3 = il;
            }
            yVar2.fx(i3 + px2);
        }
        return cVar;
    }

    private static void a(y yVar, int i, int i2, int i3, int i4, String str, c cVar) {
        yVar.fx(i2 + 16);
        String str2 = "application/ttml+xml";
        s sVar = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                yVar.r(bArr, 0, i5);
                sVar = s.u(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                cVar.zy = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.dU = new v.a().D(i4).m(str2).j(str).p(j).c((List<byte[]>) sVar).bT();
    }

    private static void a(y yVar, int i, int i2, int i3, int i4, int i5, com.applovin.exoplayer2.d.e eVar, c cVar, int i6) throws com.applovin.exoplayer2.ai {
        com.applovin.exoplayer2.d.e eVar2;
        String str;
        y yVar2 = yVar;
        int i7 = i2;
        int i8 = i3;
        com.applovin.exoplayer2.d.e eVar3 = eVar;
        c cVar2 = cVar;
        yVar2.fx(i7 + 16);
        yVar2.fz(16);
        int pp = yVar.pp();
        int pp2 = yVar.pp();
        yVar2.fz(50);
        int il = yVar.il();
        int i9 = i;
        if (i9 == 1701733238) {
            Pair<Integer, l> c2 = c(yVar2, i7, i8);
            if (c2 != null) {
                i9 = ((Integer) c2.first).intValue();
                if (eVar3 == null) {
                    eVar3 = null;
                } else {
                    eVar3 = eVar3.B(((l) c2.second).tc);
                }
                cVar2.zx[i6] = (l) c2.second;
            }
            yVar2.fx(il);
        }
        String str2 = "video/3gpp";
        String str3 = i9 == 1831958048 ? "video/mpeg" : i9 == 1211250227 ? str2 : null;
        float f2 = 1.0f;
        int i10 = -1;
        String str4 = null;
        List list = null;
        byte[] bArr = null;
        com.applovin.exoplayer2.m.b bVar = null;
        boolean z = false;
        while (true) {
            if (il - i7 >= i8) {
                eVar2 = eVar3;
                break;
            }
            yVar2.fx(il);
            int il2 = yVar.il();
            String str5 = str2;
            int px = yVar.px();
            if (px == 0) {
                eVar2 = eVar3;
                if (yVar.il() - i7 == i8) {
                    break;
                }
            } else {
                eVar2 = eVar3;
            }
            k.a(px > 0, "childAtomSize must be positive");
            int px2 = yVar.px();
            if (px2 == 1635148611) {
                k.a(str3 == null, (String) null);
                yVar2.fx(il2 + 8);
                com.applovin.exoplayer2.m.a as = com.applovin.exoplayer2.m.a.as(yVar);
                list = as.dB;
                cVar2.wo = as.wo;
                if (!z) {
                    f2 = as.acy;
                }
                str4 = as.dw;
                str = MimeTypes.VIDEO_H264;
            } else if (px2 == 1752589123) {
                k.a(str3 == null, (String) null);
                yVar2.fx(il2 + 8);
                com.applovin.exoplayer2.m.f av = com.applovin.exoplayer2.m.f.av(yVar);
                list = av.dB;
                cVar2.wo = av.wo;
                str4 = av.dw;
                str = MimeTypes.VIDEO_H265;
            } else if (px2 == 1685480259 || px2 == 1685485123) {
                com.applovin.exoplayer2.m.c au = com.applovin.exoplayer2.m.c.au(yVar);
                if (au != null) {
                    str4 = au.dw;
                    str3 = "video/dolby-vision";
                }
                il += px;
                yVar2 = yVar;
                i7 = i2;
                i8 = i3;
                str2 = str5;
                eVar3 = eVar2;
            } else if (px2 == 1987076931) {
                k.a(str3 == null, (String) null);
                str = i9 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else {
                if (px2 == 1635135811) {
                    k.a(str3 == null, (String) null);
                    str3 = MimeTypes.VIDEO_AV1;
                } else if (px2 == 1681012275) {
                    k.a(str3 == null, (String) null);
                    str3 = str5;
                } else if (px2 == 1702061171) {
                    k.a(str3 == null, (String) null);
                    Pair<String, byte[]> k = k(yVar2, il2);
                    String str6 = (String) k.first;
                    byte[] bArr2 = (byte[]) k.second;
                    if (bArr2 != null) {
                        list = s.u(bArr2);
                    }
                    str3 = str6;
                } else if (px2 == 1885434736) {
                    f2 = j(yVar2, il2);
                    z = true;
                } else if (px2 == 1937126244) {
                    bArr = e(yVar2, il2, px);
                } else if (px2 == 1936995172) {
                    int po = yVar.po();
                    yVar2.fz(3);
                    if (po == 0) {
                        int po2 = yVar.po();
                        if (po2 == 0) {
                            i10 = 0;
                        } else if (po2 == 1) {
                            i10 = 1;
                        } else if (po2 == 2) {
                            i10 = 2;
                        } else if (po2 == 3) {
                            i10 = 3;
                        }
                    }
                } else if (px2 == 1668246642) {
                    int px3 = yVar.px();
                    boolean z2 = px3 == 1852009592;
                    if (z2 || px3 == 1852009571) {
                        int pp3 = yVar.pp();
                        int pp4 = yVar.pp();
                        yVar2.fz(2);
                        bVar = new com.applovin.exoplayer2.m.b(com.applovin.exoplayer2.m.b.fN(pp3), z2 && (yVar.po() & 128) != 0 ? 1 : 2, com.applovin.exoplayer2.m.b.fO(pp4), (byte[]) null);
                    } else {
                        q.h("AtomParsers", "Unsupported color type: " + a.ch(px3));
                    }
                }
                il += px;
                yVar2 = yVar;
                i7 = i2;
                i8 = i3;
                str2 = str5;
                eVar3 = eVar2;
            }
            str3 = str;
            il += px;
            yVar2 = yVar;
            i7 = i2;
            i8 = i3;
            str2 = str5;
            eVar3 = eVar2;
        }
        if (str3 != null) {
            cVar2.dU = new v.a().D(i4).m(str3).k(str4).J(pp).K(pp2).e(f2).L(i5).a(bArr).M(i10).c((List<byte[]>) list).a(eVar2).a(bVar).bT();
        }
    }

    private static void a(y yVar, int i, int i2, int i3, c cVar) {
        yVar.fx(i2 + 16);
        if (i == 1835365492) {
            yVar.pI();
            String pI = yVar.pI();
            if (pI != null) {
                cVar.dU = new v.a().D(i3).m(pI).bT();
            }
        }
    }

    private static Pair<long[], long[]> c(a.C0041a aVar) {
        a.b ci = aVar.ci(1701606260);
        if (ci == null) {
            return null;
        }
        y yVar = ci.zo;
        yVar.fx(8);
        int cf = a.cf(yVar.px());
        int pD = yVar.pD();
        long[] jArr = new long[pD];
        long[] jArr2 = new long[pD];
        int i = 0;
        while (i < pD) {
            jArr[i] = cf == 1 ? yVar.pF() : yVar.pv();
            jArr2[i] = cf == 1 ? yVar.pz() : (long) yVar.px();
            if (yVar.pr() == 1) {
                yVar.fz(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float j(y yVar, int i) {
        yVar.fx(i + 8);
        return ((float) yVar.pD()) / ((float) yVar.pD());
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.applovin.exoplayer2.l.y r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, com.applovin.exoplayer2.d.e r27, com.applovin.exoplayer2.e.g.b.c r28, int r29) throws com.applovin.exoplayer2.ai {
        /*
            r0 = r20
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r27
            r6 = r28
            int r7 = r1 + 16
            r0.fx(r7)
            r7 = 6
            if (r26 == 0) goto L_0x001e
            int r9 = r20.pp()
            r0.fz(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.fz(r9)
            r9 = 0
        L_0x0024:
            r10 = 2
            r11 = 1
            r12 = 16
            if (r9 == 0) goto L_0x0046
            if (r9 != r11) goto L_0x002d
            goto L_0x0046
        L_0x002d:
            if (r9 != r10) goto L_0x0045
            r0.fz(r12)
            double r12 = r20.pH()
            long r12 = java.lang.Math.round(r12)
            int r7 = (int) r12
            int r9 = r20.pD()
            r12 = 20
            r0.fz(r12)
            goto L_0x0057
        L_0x0045:
            return
        L_0x0046:
            int r13 = r20.pp()
            r0.fz(r7)
            int r7 = r20.pB()
            if (r9 != r11) goto L_0x0056
            r0.fz(r12)
        L_0x0056:
            r9 = r13
        L_0x0057:
            int r12 = r20.il()
            r13 = 1701733217(0x656e6361, float:7.0359778E22)
            r15 = r21
            if (r15 != r13) goto L_0x008d
            android.util.Pair r13 = c(r0, r1, r2)
            if (r13 == 0) goto L_0x0088
            java.lang.Object r15 = r13.first
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            if (r5 != 0) goto L_0x0074
            r14 = 0
            goto L_0x007f
        L_0x0074:
            java.lang.Object r14 = r13.second
            com.applovin.exoplayer2.e.g.l r14 = (com.applovin.exoplayer2.e.g.l) r14
            java.lang.String r14 = r14.tc
            com.applovin.exoplayer2.d.e r5 = r5.B(r14)
            r14 = r5
        L_0x007f:
            com.applovin.exoplayer2.e.g.l[] r5 = r6.zx
            java.lang.Object r13 = r13.second
            com.applovin.exoplayer2.e.g.l r13 = (com.applovin.exoplayer2.e.g.l) r13
            r5[r29] = r13
            goto L_0x0089
        L_0x0088:
            r14 = r5
        L_0x0089:
            r0.fx(r12)
            goto L_0x008e
        L_0x008d:
            r14 = r5
        L_0x008e:
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            r13 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r15 != r5) goto L_0x009d
            java.lang.String r5 = "audio/ac3"
        L_0x0098:
            r18 = r5
            r5 = -1
            goto L_0x0148
        L_0x009d:
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r15 != r5) goto L_0x00a5
            java.lang.String r5 = "audio/eac3"
            goto L_0x0098
        L_0x00a5:
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r15 != r5) goto L_0x00ad
            java.lang.String r5 = "audio/ac4"
            goto L_0x0098
        L_0x00ad:
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r15 != r5) goto L_0x00b5
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x0098
        L_0x00b5:
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r15 == r5) goto L_0x0144
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r15 != r5) goto L_0x00c1
            goto L_0x0144
        L_0x00c1:
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r15 != r5) goto L_0x00c9
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0098
        L_0x00c9:
            r5 = 1685353336(0x64747378, float:1.8037304E22)
            if (r15 != r5) goto L_0x00d1
            java.lang.String r5 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x0098
        L_0x00d1:
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r15 != r5) goto L_0x00d9
            java.lang.String r5 = "audio/3gpp"
            goto L_0x0098
        L_0x00d9:
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r15 != r5) goto L_0x00e1
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x0098
        L_0x00e1:
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            java.lang.String r18 = "audio/raw"
            if (r15 == r5) goto L_0x0142
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            if (r15 != r5) goto L_0x00ee
            goto L_0x0142
        L_0x00ee:
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r15 != r5) goto L_0x00f6
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0148
        L_0x00f6:
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r15 == r5) goto L_0x013e
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r15 != r5) goto L_0x0101
            goto L_0x013e
        L_0x0101:
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r15 != r5) goto L_0x0109
            java.lang.String r5 = "audio/mha1"
            goto L_0x0098
        L_0x0109:
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r15 != r5) goto L_0x0111
            java.lang.String r5 = "audio/mhm1"
            goto L_0x0098
        L_0x0111:
            if (r15 != r13) goto L_0x0116
            java.lang.String r5 = "audio/alac"
            goto L_0x0098
        L_0x0116:
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r15 != r5) goto L_0x011f
            java.lang.String r5 = "audio/g711-alaw"
            goto L_0x0098
        L_0x011f:
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r15 != r5) goto L_0x0128
            java.lang.String r5 = "audio/g711-mlaw"
            goto L_0x0098
        L_0x0128:
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r15 != r5) goto L_0x0131
            java.lang.String r5 = "audio/opus"
            goto L_0x0098
        L_0x0131:
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r15 != r5) goto L_0x013a
            java.lang.String r5 = "audio/flac"
            goto L_0x0098
        L_0x013a:
            r5 = -1
            r18 = 0
            goto L_0x0148
        L_0x013e:
            java.lang.String r5 = "audio/mpeg"
            goto L_0x0098
        L_0x0142:
            r5 = 2
            goto L_0x0148
        L_0x0144:
            java.lang.String r5 = "audio/vnd.dts.hd"
            goto L_0x0098
        L_0x0148:
            r10 = r18
            r15 = 0
            r19 = 0
        L_0x014d:
            int r13 = r12 - r1
            if (r13 >= r2) goto L_0x02c8
            r0.fx(r12)
            int r13 = r20.px()
            if (r13 <= 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r11 = 0
        L_0x015c:
            java.lang.String r8 = "childAtomSize must be positive"
            com.applovin.exoplayer2.e.k.a((boolean) r11, (java.lang.String) r8)
            int r8 = r20.px()
            r11 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r8 != r11) goto L_0x0185
            int r8 = r13 + -13
            byte[] r11 = new byte[r8]
            int r1 = r12 + 13
            r0.fx(r1)
            r1 = 0
            r0.r(r11, r1, r8)
            com.applovin.exoplayer2.common.a.s r1 = com.applovin.exoplayer2.common.a.s.u(r11)
        L_0x017b:
            r19 = r1
            r8 = -1
            r11 = 1
            r16 = 2
        L_0x0181:
            r17 = 0
            goto L_0x02c1
        L_0x0185:
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r8 == r1) goto L_0x028a
            if (r26 == 0) goto L_0x0193
            r11 = 2002876005(0x77617665, float:4.5729223E33)
            if (r8 != r11) goto L_0x0193
            goto L_0x028a
        L_0x0193:
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r8 != r1) goto L_0x01b0
            int r1 = r12 + 8
            r0.fx(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.applovin.exoplayer2.v r1 = com.applovin.exoplayer2.b.b.a(r0, r1, r4, r14)
            r6.dU = r1
        L_0x01a7:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r8 = 0
            r11 = 1
            r16 = 2
            goto L_0x0287
        L_0x01b0:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r8 != r1) goto L_0x01c5
            int r1 = r12 + 8
            r0.fx(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.applovin.exoplayer2.v r1 = com.applovin.exoplayer2.b.b.b(r0, r1, r4, r14)
            r6.dU = r1
            goto L_0x01a7
        L_0x01c5:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r8 != r1) goto L_0x01da
            int r1 = r12 + 8
            r0.fx(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.applovin.exoplayer2.v r1 = com.applovin.exoplayer2.b.c.c(r0, r1, r4, r14)
            r6.dU = r1
            goto L_0x01a7
        L_0x01da:
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r8 != r1) goto L_0x0203
            com.applovin.exoplayer2.v$a r1 = new com.applovin.exoplayer2.v$a
            r1.<init>()
            com.applovin.exoplayer2.v$a r1 = r1.D((int) r3)
            com.applovin.exoplayer2.v$a r1 = r1.m((java.lang.String) r10)
            com.applovin.exoplayer2.v$a r1 = r1.N(r9)
            com.applovin.exoplayer2.v$a r1 = r1.O(r7)
            com.applovin.exoplayer2.v$a r1 = r1.a((com.applovin.exoplayer2.d.e) r14)
            com.applovin.exoplayer2.v$a r1 = r1.j((java.lang.String) r4)
            com.applovin.exoplayer2.v r1 = r1.bT()
            r6.dU = r1
            goto L_0x01a7
        L_0x0203:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r8 != r1) goto L_0x0221
            int r1 = r13 + -8
            byte[] r8 = zp
            int r11 = r8.length
            int r11 = r11 + r1
            byte[] r11 = java.util.Arrays.copyOf(r8, r11)
            int r2 = r12 + 8
            r0.fx(r2)
            int r2 = r8.length
            r0.r(r11, r2, r1)
            java.util.List r1 = com.applovin.exoplayer2.b.s.j(r11)
            goto L_0x017b
        L_0x0221:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r8 != r1) goto L_0x0251
            int r1 = r13 + -12
            int r2 = r13 + -8
            byte[] r2 = new byte[r2]
            r8 = 102(0x66, float:1.43E-43)
            r11 = 0
            r2[r11] = r8
            r8 = 76
            r11 = 1
            r2[r11] = r8
            r8 = 97
            r16 = 2
            r2[r16] = r8
            r8 = 3
            r17 = 67
            r2[r8] = r17
            int r8 = r12 + 12
            r0.fx(r8)
            r8 = 4
            r0.r(r2, r8, r1)
            com.applovin.exoplayer2.common.a.s r1 = com.applovin.exoplayer2.common.a.s.u(r2)
            r19 = r1
            goto L_0x0287
        L_0x0251:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r11 = 1
            r16 = 2
            if (r8 != r2) goto L_0x0286
            int r1 = r13 + -12
            byte[] r7 = new byte[r1]
            int r8 = r12 + 12
            r0.fx(r8)
            r8 = 0
            r0.r(r7, r8, r1)
            android.util.Pair r1 = com.applovin.exoplayer2.l.e.H(r7)
            java.lang.Object r9 = r1.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.applovin.exoplayer2.common.a.s r7 = com.applovin.exoplayer2.common.a.s.u(r7)
            r19 = r7
            r7 = r9
            r8 = -1
            r17 = 0
            r9 = r1
            goto L_0x02c1
        L_0x0286:
            r8 = 0
        L_0x0287:
            r8 = -1
            goto L_0x0181
        L_0x028a:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r11 = 1
            r16 = 2
            r17 = 0
            if (r8 != r1) goto L_0x0296
            r1 = r12
            goto L_0x029a
        L_0x0296:
            int r1 = b(r0, r12, r13)
        L_0x029a:
            r8 = -1
            if (r1 == r8) goto L_0x02c1
            android.util.Pair r1 = k(r0, r1)
            java.lang.Object r10 = r1.first
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r1 = r1.second
            byte[] r1 = (byte[]) r1
            if (r1 == 0) goto L_0x02c1
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x02bd
            com.applovin.exoplayer2.b.a$a r2 = com.applovin.exoplayer2.b.a.b((byte[]) r1)
            int r7 = r2.js
            int r9 = r2.dL
            java.lang.String r15 = r2.dw
        L_0x02bd:
            com.applovin.exoplayer2.common.a.s r19 = com.applovin.exoplayer2.common.a.s.u(r1)
        L_0x02c1:
            int r12 = r12 + r13
            r1 = r22
            r2 = r23
            goto L_0x014d
        L_0x02c8:
            com.applovin.exoplayer2.v r0 = r6.dU
            if (r0 != 0) goto L_0x02ff
            if (r10 == 0) goto L_0x02ff
            com.applovin.exoplayer2.v$a r0 = new com.applovin.exoplayer2.v$a
            r0.<init>()
            com.applovin.exoplayer2.v$a r0 = r0.D((int) r3)
            com.applovin.exoplayer2.v$a r0 = r0.m((java.lang.String) r10)
            com.applovin.exoplayer2.v$a r0 = r0.k((java.lang.String) r15)
            com.applovin.exoplayer2.v$a r0 = r0.N(r9)
            com.applovin.exoplayer2.v$a r0 = r0.O(r7)
            com.applovin.exoplayer2.v$a r0 = r0.P(r5)
            r1 = r19
            com.applovin.exoplayer2.v$a r0 = r0.c((java.util.List<byte[]>) r1)
            com.applovin.exoplayer2.v$a r0 = r0.a((com.applovin.exoplayer2.d.e) r14)
            com.applovin.exoplayer2.v$a r0 = r0.j((java.lang.String) r4)
            com.applovin.exoplayer2.v r0 = r0.bT()
            r6.dU = r0
        L_0x02ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.b.a(com.applovin.exoplayer2.l.y, int, int, int, int, java.lang.String, boolean, com.applovin.exoplayer2.d.e, com.applovin.exoplayer2.e.g.b$c, int):void");
    }

    private static int b(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        int il = yVar.il();
        while (il - i < i2) {
            yVar.fx(il);
            int px = yVar.px();
            k.a(px > 0, "childAtomSize must be positive");
            if (yVar.px() == 1702061171) {
                return il;
            }
            il += px;
        }
        return -1;
    }

    private static Pair<String, byte[]> k(y yVar, int i) {
        yVar.fx(i + 12);
        yVar.fz(1);
        u(yVar);
        yVar.fz(2);
        int po = yVar.po();
        if ((po & 128) != 0) {
            yVar.fz(2);
        }
        if ((po & 64) != 0) {
            yVar.fz(yVar.pp());
        }
        if ((po & 32) != 0) {
            yVar.fz(2);
        }
        yVar.fz(1);
        u(yVar);
        String fv = u.fv(yVar.po());
        if ("audio/mpeg".equals(fv) || "audio/vnd.dts".equals(fv) || "audio/vnd.dts.hd".equals(fv)) {
            return Pair.create(fv, (Object) null);
        }
        yVar.fz(12);
        yVar.fz(1);
        int u = u(yVar);
        byte[] bArr = new byte[u];
        yVar.r(bArr, 0, u);
        return Pair.create(fv, bArr);
    }

    private static Pair<Integer, l> c(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        Pair<Integer, l> d2;
        int il = yVar.il();
        while (il - i < i2) {
            yVar.fx(il);
            int px = yVar.px();
            k.a(px > 0, "childAtomSize must be positive");
            if (yVar.px() == 1936289382 && (d2 = d(yVar, il, px)) != null) {
                return d2;
            }
            il += px;
        }
        return null;
    }

    static Pair<Integer, l> d(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        int i3 = i + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            yVar.fx(i3);
            int px = yVar.px();
            int px2 = yVar.px();
            if (px2 == 1718775137) {
                num = Integer.valueOf(yVar.px());
            } else if (px2 == 1935894637) {
                yVar.fz(4);
                str = yVar.fB(4);
            } else if (px2 == 1935894633) {
                i4 = i3;
                i5 = px;
            }
            i3 += px;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        k.a(num != null, "frma atom is mandatory");
        k.a(i4 != -1, "schi atom is mandatory");
        l a2 = a(yVar, i4, i5, str);
        if (a2 != null) {
            z = true;
        }
        k.a(z, "tenc atom is mandatory");
        return Pair.create(num, (l) ai.R(a2));
    }

    private static l a(y yVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            yVar.fx(i5);
            int px = yVar.px();
            if (yVar.px() == 1952804451) {
                int cf = a.cf(yVar.px());
                yVar.fz(1);
                if (cf == 0) {
                    yVar.fz(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int po = yVar.po();
                    i3 = po & 15;
                    i4 = (po & 240) >> 4;
                }
                boolean z = yVar.po() == 1;
                int po2 = yVar.po();
                byte[] bArr2 = new byte[16];
                yVar.r(bArr2, 0, 16);
                if (z && po2 == 0) {
                    int po3 = yVar.po();
                    bArr = new byte[po3];
                    yVar.r(bArr, 0, po3);
                }
                return new l(z, str, po2, bArr2, i4, i3, bArr);
            }
            i5 += px;
        }
    }

    private static byte[] e(y yVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            yVar.fx(i3);
            int px = yVar.px();
            if (yVar.px() == 1886547818) {
                return Arrays.copyOfRange(yVar.hO(), i3, px + i3);
            }
            i3 += px;
        }
        return null;
    }

    private static int u(y yVar) {
        int po = yVar.po();
        int i = po & WorkQueueKt.MASK;
        while ((po & 128) == 128) {
            po = yVar.po();
            i = (i << 7) | (po & WorkQueueKt.MASK);
        }
        return i;
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int k = ai.k(4, 0, length);
        int k2 = ai.k(jArr.length - 4, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[k] || jArr[k2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private static final class a {
        public int Y;
        public final int fR;
        public int zq;
        public long zr;
        private final boolean zs;
        private final y zt;
        private final y zu;
        private int zv;
        private int zw;

        public a(y yVar, y yVar2, boolean z) throws com.applovin.exoplayer2.ai {
            this.zu = yVar;
            this.zt = yVar2;
            this.zs = z;
            yVar2.fx(12);
            this.fR = yVar2.pD();
            yVar.fx(12);
            this.zw = yVar.pD();
            k.a(yVar.px() != 1 ? false : true, "first_chunk must be 1");
            this.Y = -1;
        }

        public boolean iH() {
            long j;
            int i = this.Y + 1;
            this.Y = i;
            if (i == this.fR) {
                return false;
            }
            if (this.zs) {
                j = this.zt.pF();
            } else {
                j = this.zt.pv();
            }
            this.zr = j;
            if (this.Y == this.zv) {
                this.zq = this.zu.pD();
                this.zu.fz(4);
                int i2 = this.zw - 1;
                this.zw = i2;
                this.zv = i2 > 0 ? this.zu.pD() - 1 : -1;
            }
            return true;
        }
    }

    private static final class f {
        /* access modifiers changed from: private */
        public final int dG;
        /* access modifiers changed from: private */
        public final int zD;
        /* access modifiers changed from: private */
        public final long zE;

        public f(int i, long j, int i2) {
            this.zD = i;
            this.zE = j;
            this.dG = i2;
        }
    }

    private static final class c {
        public v dU;
        public int wo;
        public final l[] zx;
        public int zy = 0;

        public c(int i) {
            this.zx = new l[i];
        }
    }

    static final class d implements C0042b {
        private final int jA;
        private final y zo;
        private final int zz;

        public int iI() {
            return this.jA;
        }

        public int iJ() {
            return this.zz;
        }

        public d(a.b bVar, v vVar) {
            y yVar = bVar.zo;
            this.zo = yVar;
            yVar.fx(12);
            int pD = yVar.pD();
            if ("audio/raw".equals(vVar.dz)) {
                int P = ai.P(vVar.dN, vVar.dL);
                if (pD == 0 || pD % P != 0) {
                    q.h("AtomParsers", "Audio sample size mismatch. stsd sample size: " + P + ", stsz sample size: " + pD);
                    pD = P;
                }
            }
            this.zz = pD == 0 ? -1 : pD;
            this.jA = yVar.pD();
        }

        public int iK() {
            int i = this.zz;
            return i == -1 ? this.zo.pD() : i;
        }
    }

    static final class e implements C0042b {
        private final int jA;
        private final int zA;
        private int zB;
        private int zC;
        private final y zo;

        public int iI() {
            return this.jA;
        }

        public int iJ() {
            return -1;
        }

        public e(a.b bVar) {
            y yVar = bVar.zo;
            this.zo = yVar;
            yVar.fx(12);
            this.zA = yVar.pD() & 255;
            this.jA = yVar.pD();
        }

        public int iK() {
            int i = this.zA;
            if (i == 8) {
                return this.zo.po();
            }
            if (i == 16) {
                return this.zo.pp();
            }
            int i2 = this.zB;
            this.zB = i2 + 1;
            if (i2 % 2 != 0) {
                return this.zC & 15;
            }
            int po = this.zo.po();
            this.zC = po;
            return (po & 240) >> 4;
        }
    }
}
