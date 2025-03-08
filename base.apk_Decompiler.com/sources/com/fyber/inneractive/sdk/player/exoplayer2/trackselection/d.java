package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import java.util.Map;

public abstract class d extends g {
    public final SparseArray<Map<s, b>> a = new SparseArray<>();
    public final SparseBooleanArray b = new SparseBooleanArray();

    public static final class a {
        public a(int[] iArr, s[] sVarArr, int[] iArr2, int[][][] iArr3, s sVar) {
        }
    }

    public static final class b {
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x027c A[LOOP:8: B:64:0x015d->B:109:0x027c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0277 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h a(com.fyber.inneractive.sdk.player.exoplayer2.a[] r48, com.fyber.inneractive.sdk.player.exoplayer2.source.s r49) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r47 = this;
            r1 = r47
            r0 = r48
            r2 = r49
            int r3 = r0.length
            r4 = 1
            int r3 = r3 + r4
            int[] r3 = new int[r3]
            int r5 = r0.length
            int r5 = r5 + r4
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[][] r6 = new com.fyber.inneractive.sdk.player.exoplayer2.source.r[r5][]
            int r7 = r0.length
            int r7 = r7 + r4
            int[][][] r12 = new int[r7][][]
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x0023
            int r9 = r2.a
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r10 = new com.fyber.inneractive.sdk.player.exoplayer2.source.r[r9]
            r6[r8] = r10
            int[][] r9 = new int[r9][]
            r12[r8] = r9
            int r8 = r8 + 1
            goto L_0x0014
        L_0x0023:
            int r5 = r0.length
            int[] r11 = new int[r5]
            r8 = 0
        L_0x0027:
            r9 = 4
            if (r8 >= r5) goto L_0x0034
            r10 = r0[r8]
            r10.getClass()
            r11[r8] = r9
            int r8 = r8 + 1
            goto L_0x0027
        L_0x0034:
            r5 = 0
        L_0x0035:
            int r8 = r2.a
            if (r5 >= r8) goto L_0x00bc
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r8 = r2.b
            r8 = r8[r5]
            int r13 = r0.length
            r14 = 0
            r15 = 0
        L_0x0040:
            int r9 = r0.length
            if (r14 >= r9) goto L_0x0077
            r9 = r0[r14]
            r7 = 0
        L_0x0046:
            int r4 = r8.a
            if (r7 >= r4) goto L_0x0073
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r4 = r8.b
            r4 = r4[r7]
            r10 = r9
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b r10 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b) r10
            r10.getClass()
            r18 = r9
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c r9 = r10.i     // Catch:{ b -> 0x006b }
            int r4 = r10.a((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) r9, (com.fyber.inneractive.sdk.player.exoplayer2.i) r4)     // Catch:{ b -> 0x006b }
            r9 = 3
            r4 = r4 & r9
            if (r4 <= r15) goto L_0x0066
            if (r4 != r9) goto L_0x0064
            r13 = r14
            goto L_0x0077
        L_0x0064:
            r15 = r4
            r13 = r14
        L_0x0066:
            int r7 = r7 + 1
            r9 = r18
            goto L_0x0046
        L_0x006b:
            r0 = move-exception
            int r2 = r10.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r0, r2)
            throw r0
        L_0x0073:
            int r14 = r14 + 1
            r4 = 1
            goto L_0x0040
        L_0x0077:
            int r4 = r0.length
            if (r13 != r4) goto L_0x007f
            int r4 = r8.a
            int[] r4 = new int[r4]
            goto L_0x00a8
        L_0x007f:
            r4 = r0[r13]
            int r7 = r8.a
            int[] r7 = new int[r7]
            r9 = 0
        L_0x0086:
            int r10 = r8.a
            if (r9 >= r10) goto L_0x00a7
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r10 = r8.b
            r10 = r10[r9]
            r14 = r4
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b r14 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b) r14
            r14.getClass()
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c r15 = r14.i     // Catch:{ b -> 0x009f }
            int r10 = r14.a((com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) r15, (com.fyber.inneractive.sdk.player.exoplayer2.i) r10)     // Catch:{ b -> 0x009f }
            r7[r9] = r10
            int r9 = r9 + 1
            goto L_0x0086
        L_0x009f:
            r0 = move-exception
            int r2 = r14.c
            com.fyber.inneractive.sdk.player.exoplayer2.d r0 = com.fyber.inneractive.sdk.player.exoplayer2.d.a(r0, r2)
            throw r0
        L_0x00a7:
            r4 = r7
        L_0x00a8:
            r7 = r3[r13]
            r9 = r6[r13]
            r9[r7] = r8
            r8 = r12[r13]
            r8[r7] = r4
            r4 = 1
            int r7 = r7 + r4
            r3[r13] = r7
            int r5 = r5 + 1
            r4 = 1
            r9 = 4
            goto L_0x0035
        L_0x00bc:
            int r4 = r0.length
            com.fyber.inneractive.sdk.player.exoplayer2.source.s[] r10 = new com.fyber.inneractive.sdk.player.exoplayer2.source.s[r4]
            int r4 = r0.length
            int[] r9 = new int[r4]
            r4 = 0
        L_0x00c3:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x00ea
            r5 = r3[r4]
            com.fyber.inneractive.sdk.player.exoplayer2.source.s r7 = new com.fyber.inneractive.sdk.player.exoplayer2.source.s
            r8 = r6[r4]
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r5)
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r8 = (com.fyber.inneractive.sdk.player.exoplayer2.source.r[]) r8
            r7.<init>(r8)
            r10[r4] = r7
            r7 = r12[r4]
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r7, r5)
            int[][] r5 = (int[][]) r5
            r12[r4] = r5
            r5 = r0[r4]
            int r5 = r5.a
            r9[r4] = r5
            int r4 = r4 + 1
            goto L_0x00c3
        L_0x00ea:
            int r4 = r0.length
            r3 = r3[r4]
            com.fyber.inneractive.sdk.player.exoplayer2.source.s r13 = new com.fyber.inneractive.sdk.player.exoplayer2.source.s
            int r4 = r0.length
            r4 = r6[r4]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r3 = (com.fyber.inneractive.sdk.player.exoplayer2.source.r[]) r3
            r13.<init>(r3)
            r3 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b) r3
            int r4 = r0.length
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] r5 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[r4]
            java.util.concurrent.atomic.AtomicReference<com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$b> r6 = r3.d
            java.lang.Object r6 = r6.get()
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$b r6 = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0127b) r6
            r7 = 0
            r8 = 0
            r14 = 0
        L_0x010c:
            if (r7 >= r4) goto L_0x03e5
            r15 = r0[r7]
            int r15 = r15.a
            r2 = 2
            if (r2 != r15) goto L_0x03b3
            if (r8 != 0) goto L_0x0390
            r2 = r0[r7]
            r8 = r10[r7]
            r15 = r12[r7]
            r26 = r13
            int r13 = r6.e
            r27 = r11
            int r11 = r6.f
            r28 = r9
            int r9 = r6.g
            boolean r1 = r6.d
            r29 = r12
            boolean r12 = r6.c
            int r0 = r6.j
            r30 = r4
            int r4 = r6.k
            r31 = r14
            boolean r14 = r6.l
            r32 = r10
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e$a r10 = r3.c
            r33 = r3
            boolean r3 = r6.h
            r34 = r5
            boolean r5 = r6.i
            if (r10 == 0) goto L_0x0299
            if (r1 == 0) goto L_0x014c
            r1 = 12
            goto L_0x014e
        L_0x014c:
            r1 = 8
        L_0x014e:
            if (r12 == 0) goto L_0x0159
            r2.getClass()
            r2 = r1 & 4
            if (r2 == 0) goto L_0x0159
            r2 = 1
            goto L_0x015a
        L_0x0159:
            r2 = 0
        L_0x015a:
            r35 = r6
            r12 = 0
        L_0x015d:
            int r6 = r8.a
            if (r12 >= r6) goto L_0x0290
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r6 = r8.b
            r6 = r6[r12]
            r36 = r15[r12]
            r37 = r7
            int r7 = r6.a
            r38 = r3
            r3 = 2
            if (r7 >= r3) goto L_0x0180
            int[] r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e
            r43 = r0
            r40 = r2
            r45 = r4
            r39 = r5
        L_0x017a:
            r46 = r14
            r42 = r15
            goto L_0x0274
        L_0x0180:
            java.util.List r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r6, r0, r4, r14)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r39 = r5
            int r5 = r7.size()
            if (r5 >= r3) goto L_0x0197
            int[] r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e
            r43 = r0
            r40 = r2
            r45 = r4
            goto L_0x017a
        L_0x0197:
            if (r2 != 0) goto L_0x0215
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r40 = r2
            r42 = r15
            r2 = 0
            r5 = 0
            r41 = 0
        L_0x01a6:
            int r15 = r7.size()
            if (r5 >= r15) goto L_0x020e
            java.lang.Object r15 = r7.get(r5)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            r43 = r0
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r0 = r6.b
            r0 = r0[r15]
            java.lang.String r0 = r0.f
            boolean r15 = r3.add(r0)
            r44 = r3
            r45 = r4
            if (r15 == 0) goto L_0x0201
            r3 = 0
            r15 = 0
        L_0x01ca:
            int r4 = r7.size()
            if (r15 >= r4) goto L_0x01f9
            java.lang.Object r4 = r7.get(r15)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r46 = r14
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r14 = r6.b
            r19 = r14[r4]
            r21 = r36[r4]
            r20 = r0
            r22 = r1
            r23 = r13
            r24 = r11
            r25 = r9
            boolean r4 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r19, r20, r21, r22, r23, r24, r25)
            if (r4 == 0) goto L_0x01f4
            int r3 = r3 + 1
        L_0x01f4:
            int r15 = r15 + 1
            r14 = r46
            goto L_0x01ca
        L_0x01f9:
            r46 = r14
            if (r3 <= r2) goto L_0x0203
            r41 = r0
            r2 = r3
            goto L_0x0203
        L_0x0201:
            r46 = r14
        L_0x0203:
            int r5 = r5 + 1
            r0 = r43
            r3 = r44
            r4 = r45
            r14 = r46
            goto L_0x01a6
        L_0x020e:
            r43 = r0
            r45 = r4
            r46 = r14
            goto L_0x0221
        L_0x0215:
            r43 = r0
            r40 = r2
            r45 = r4
            r46 = r14
            r42 = r15
            r41 = 0
        L_0x0221:
            int r0 = r7.size()
            r2 = 1
            int r0 = r0 - r2
        L_0x0227:
            if (r0 < 0) goto L_0x024f
            java.lang.Object r2 = r7.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r3 = r6.b
            r19 = r3[r2]
            r21 = r36[r2]
            r20 = r41
            r22 = r1
            r23 = r13
            r24 = r11
            r25 = r9
            boolean r2 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r19, r20, r21, r22, r23, r24, r25)
            if (r2 != 0) goto L_0x024c
            r7.remove(r0)
        L_0x024c:
            int r0 = r0 + -1
            goto L_0x0227
        L_0x024f:
            int r0 = r7.size()
            r2 = 2
            if (r0 >= r2) goto L_0x0259
            int[] r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e
            goto L_0x0274
        L_0x0259:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            int r0 = r7.size()
            int[] r2 = new int[r0]
            r3 = 0
        L_0x0262:
            if (r3 >= r0) goto L_0x0273
            java.lang.Object r4 = r7.get(r3)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x0262
        L_0x0273:
            r7 = r2
        L_0x0274:
            int r0 = r7.length
            if (r0 <= 0) goto L_0x027c
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r0 = r10.a(r6, r7)
            goto L_0x02aa
        L_0x027c:
            int r12 = r12 + 1
            r7 = r37
            r3 = r38
            r5 = r39
            r2 = r40
            r15 = r42
            r0 = r43
            r4 = r45
            r14 = r46
            goto L_0x015d
        L_0x0290:
            r43 = r0
            r38 = r3
            r45 = r4
            r39 = r5
            goto L_0x02a3
        L_0x0299:
            r43 = r0
            r38 = r3
            r45 = r4
            r39 = r5
            r35 = r6
        L_0x02a3:
            r37 = r7
            r46 = r14
            r42 = r15
            r0 = 0
        L_0x02aa:
            if (r0 != 0) goto L_0x0385
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = -1
            r4 = -1
            r5 = 0
        L_0x02b2:
            int r6 = r8.a
            if (r0 >= r6) goto L_0x037a
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r6 = r8.b
            r6 = r6[r0]
            r7 = r43
            r10 = r45
            r12 = r46
            java.util.List r14 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r6, r7, r10, r12)
            r15 = r42[r0]
            r19 = r1
            r20 = r5
            r1 = 0
        L_0x02cb:
            int r5 = r6.a
            if (r1 >= r5) goto L_0x0368
            r5 = r15[r1]
            r43 = r7
            r7 = r39
            boolean r5 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r5, (boolean) r7)
            if (r5 == 0) goto L_0x0354
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r5 = r6.b
            r5 = r5[r1]
            r21 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r39 = r7
            r7 = r14
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x0305
            int r6 = r5.j
            r7 = -1
            if (r6 == r7) goto L_0x02f7
            if (r6 > r13) goto L_0x0305
        L_0x02f7:
            int r6 = r5.k
            if (r6 == r7) goto L_0x02fd
            if (r6 > r11) goto L_0x0305
        L_0x02fd:
            int r6 = r5.b
            if (r6 == r7) goto L_0x0303
            if (r6 > r9) goto L_0x0305
        L_0x0303:
            r6 = 1
            goto L_0x0306
        L_0x0305:
            r6 = 0
        L_0x0306:
            if (r6 != 0) goto L_0x030b
            if (r38 != 0) goto L_0x030b
            goto L_0x0358
        L_0x030b:
            r22 = r8
            if (r6 == 0) goto L_0x0311
            r7 = 2
            goto L_0x0312
        L_0x0311:
            r7 = 1
        L_0x0312:
            r8 = r15[r1]
            r23 = r9
            r9 = 0
            boolean r8 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r8, (boolean) r9)
            if (r8 == 0) goto L_0x031f
            int r7 = r7 + 1000
        L_0x031f:
            if (r7 <= r2) goto L_0x0323
            r9 = 1
            goto L_0x0324
        L_0x0323:
            r9 = 0
        L_0x0324:
            if (r7 != r2) goto L_0x0345
            int r9 = r5.b()
            if (r9 == r3) goto L_0x0335
            int r9 = r5.b()
            int r9 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r9, (int) r3)
            goto L_0x033b
        L_0x0335:
            int r9 = r5.b
            int r9 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r9, (int) r4)
        L_0x033b:
            if (r8 == 0) goto L_0x0342
            if (r6 == 0) goto L_0x0342
            if (r9 <= 0) goto L_0x035c
            goto L_0x0347
        L_0x0342:
            if (r9 >= 0) goto L_0x035c
            goto L_0x0347
        L_0x0345:
            if (r9 == 0) goto L_0x035c
        L_0x0347:
            int r2 = r5.b
            int r3 = r5.b()
            r19 = r1
            r4 = r2
            r2 = r7
            r20 = r21
            goto L_0x035c
        L_0x0354:
            r21 = r6
            r39 = r7
        L_0x0358:
            r22 = r8
            r23 = r9
        L_0x035c:
            int r1 = r1 + 1
            r6 = r21
            r8 = r22
            r9 = r23
            r7 = r43
            goto L_0x02cb
        L_0x0368:
            r43 = r7
            r22 = r8
            r23 = r9
            int r0 = r0 + 1
            r45 = r10
            r46 = r12
            r1 = r19
            r5 = r20
            goto L_0x02b2
        L_0x037a:
            if (r5 != 0) goto L_0x037e
            r15 = 0
            goto L_0x0386
        L_0x037e:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c r0 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c
            r2 = 0
            r3 = 0
            r0.<init>(r5, r1, r3, r2)
        L_0x0385:
            r15 = r0
        L_0x0386:
            r34[r37] = r15
            r0 = r34[r37]
            if (r0 == 0) goto L_0x038e
            r8 = 1
            goto L_0x03a6
        L_0x038e:
            r8 = 0
            goto L_0x03a6
        L_0x0390:
            r33 = r3
            r30 = r4
            r34 = r5
            r35 = r6
            r37 = r7
            r28 = r9
            r32 = r10
            r27 = r11
            r29 = r12
            r26 = r13
            r31 = r14
        L_0x03a6:
            r0 = r32[r37]
            int r0 = r0.a
            if (r0 <= 0) goto L_0x03ae
            r0 = 1
            goto L_0x03af
        L_0x03ae:
            r0 = 0
        L_0x03af:
            r0 = r31 | r0
            r14 = r0
            goto L_0x03c9
        L_0x03b3:
            r33 = r3
            r30 = r4
            r34 = r5
            r35 = r6
            r37 = r7
            r28 = r9
            r32 = r10
            r27 = r11
            r29 = r12
            r26 = r13
            r31 = r14
        L_0x03c9:
            int r7 = r37 + 1
            r1 = r47
            r0 = r48
            r2 = r49
            r13 = r26
            r11 = r27
            r9 = r28
            r12 = r29
            r4 = r30
            r10 = r32
            r3 = r33
            r5 = r34
            r6 = r35
            goto L_0x010c
        L_0x03e5:
            r33 = r3
            r34 = r5
            r35 = r6
            r28 = r9
            r32 = r10
            r27 = r11
            r29 = r12
            r26 = r13
            r31 = r14
            r1 = r4
            r0 = 0
            r4 = 0
            r9 = 0
        L_0x03fb:
            if (r9 >= r1) goto L_0x0656
            r2 = r48
            r3 = r2[r9]
            int r3 = r3.a
            r5 = 1
            if (r3 == r5) goto L_0x052b
            r5 = 2
            if (r3 == r5) goto L_0x0525
            r6 = 3
            if (r3 == r6) goto L_0x047d
            r3 = r2[r9]
            r3.getClass()
            r3 = r32[r9]
            r7 = r29[r9]
            r8 = r35
            boolean r10 = r8.i
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x041d:
            int r15 = r3.a
            if (r11 >= r15) goto L_0x046c
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r15 = r3.b
            r15 = r15[r11]
            r17 = r7[r11]
            r5 = 0
        L_0x0428:
            int r6 = r15.a
            if (r5 >= r6) goto L_0x0463
            r6 = r17[r5]
            boolean r6 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r6, (boolean) r10)
            if (r6 == 0) goto L_0x0458
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r6 = r15.b
            r6 = r6[r5]
            int r6 = r6.x
            r16 = 1
            r6 = r6 & 1
            r30 = r1
            if (r6 == 0) goto L_0x0444
            r6 = 2
            goto L_0x0445
        L_0x0444:
            r6 = 1
        L_0x0445:
            r1 = r17[r5]
            r20 = r3
            r3 = 0
            boolean r1 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r1, (boolean) r3)
            if (r1 == 0) goto L_0x0452
            int r6 = r6 + 1000
        L_0x0452:
            if (r6 <= r13) goto L_0x045c
            r12 = r5
            r13 = r6
            r14 = r15
            goto L_0x045c
        L_0x0458:
            r30 = r1
            r20 = r3
        L_0x045c:
            int r5 = r5 + 1
            r3 = r20
            r1 = r30
            goto L_0x0428
        L_0x0463:
            r30 = r1
            r20 = r3
            int r11 = r11 + 1
            r5 = 2
            r6 = 3
            goto L_0x041d
        L_0x046c:
            r30 = r1
            if (r14 != 0) goto L_0x0472
            r1 = 0
            goto L_0x0479
        L_0x0472:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c r1 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c
            r3 = 0
            r5 = 0
            r1.<init>(r14, r12, r5, r3)
        L_0x0479:
            r34[r9] = r1
            goto L_0x0649
        L_0x047d:
            r30 = r1
            r8 = r35
            if (r0 != 0) goto L_0x0649
            r0 = r32[r9]
            r1 = r29[r9]
            java.lang.String r3 = r8.b
            java.lang.String r5 = r8.a
            boolean r6 = r8.i
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0491:
            int r13 = r0.a
            if (r7 >= r13) goto L_0x0508
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r13 = r0.b
            r13 = r13[r7]
            r14 = r1[r7]
            r17 = r0
            r15 = 0
        L_0x049e:
            int r0 = r13.a
            if (r15 >= r0) goto L_0x04ff
            r0 = r14[r15]
            boolean r0 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r0, (boolean) r6)
            if (r0 == 0) goto L_0x04f4
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r0 = r13.b
            r0 = r0[r15]
            r20 = r1
            int r1 = r0.x
            r21 = r1 & 1
            if (r21 == 0) goto L_0x04b9
            r21 = 1
            goto L_0x04bb
        L_0x04b9:
            r21 = 0
        L_0x04bb:
            r1 = r1 & 2
            if (r1 == 0) goto L_0x04c1
            r1 = 1
            goto L_0x04c2
        L_0x04c1:
            r1 = 0
        L_0x04c2:
            boolean r22 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r0, (java.lang.String) r3)
            if (r22 == 0) goto L_0x04d2
            if (r21 == 0) goto L_0x04cc
            r0 = 6
            goto L_0x04e1
        L_0x04cc:
            if (r1 != 0) goto L_0x04d0
            r0 = 5
            goto L_0x04e1
        L_0x04d0:
            r0 = 4
            goto L_0x04e1
        L_0x04d2:
            if (r21 == 0) goto L_0x04d6
            r0 = 3
            goto L_0x04e1
        L_0x04d6:
            if (r1 == 0) goto L_0x04f6
            boolean r0 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r0, (java.lang.String) r5)
            if (r0 == 0) goto L_0x04e0
            r0 = 2
            goto L_0x04e1
        L_0x04e0:
            r0 = 1
        L_0x04e1:
            r1 = r14[r15]
            r21 = r3
            r3 = 0
            boolean r1 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r1, (boolean) r3)
            if (r1 == 0) goto L_0x04ee
            int r0 = r0 + 1000
        L_0x04ee:
            if (r0 <= r11) goto L_0x04f8
            r11 = r0
            r12 = r13
            r10 = r15
            goto L_0x04f8
        L_0x04f4:
            r20 = r1
        L_0x04f6:
            r21 = r3
        L_0x04f8:
            int r15 = r15 + 1
            r1 = r20
            r3 = r21
            goto L_0x049e
        L_0x04ff:
            r20 = r1
            r21 = r3
            int r7 = r7 + 1
            r0 = r17
            goto L_0x0491
        L_0x0508:
            if (r12 != 0) goto L_0x050c
            r0 = 0
            goto L_0x0513
        L_0x050c:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c r0 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c
            r1 = 0
            r3 = 0
            r0.<init>(r12, r10, r3, r1)
        L_0x0513:
            r34[r9] = r0
            r0 = r34[r9]
            r35 = r8
            if (r0 == 0) goto L_0x0520
            r0 = 1
            r20 = 1
            goto L_0x064e
        L_0x0520:
            r0 = 1
            r20 = 0
            goto L_0x064e
        L_0x0525:
            r30 = r1
            r20 = r0
            goto L_0x064d
        L_0x052b:
            r30 = r1
            r8 = r35
            if (r4 != 0) goto L_0x0649
            r1 = r32[r9]
            r3 = r29[r9]
            java.lang.String r4 = r8.a
            boolean r5 = r8.i
            boolean r6 = r8.c
            if (r31 == 0) goto L_0x0541
            r7 = r33
            r10 = 0
            goto L_0x0545
        L_0x0541:
            r7 = r33
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e$a r10 = r7.c
        L_0x0545:
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
        L_0x0549:
            int r15 = r1.a
            if (r13 >= r15) goto L_0x05b5
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r15 = r1.b
            r15 = r15[r13]
            r17 = r3[r13]
            r20 = r0
            r33 = r7
            r0 = r14
            r14 = r12
            r12 = r11
            r11 = 0
        L_0x055b:
            int r7 = r15.a
            if (r11 >= r7) goto L_0x05a7
            r7 = r17[r11]
            boolean r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r7, (boolean) r5)
            if (r7 == 0) goto L_0x059c
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r7 = r15.b
            r7 = r7[r11]
            r21 = r5
            r5 = r17[r11]
            r35 = r8
            int r8 = r7.x
            r16 = 1
            r8 = r8 & 1
            if (r8 == 0) goto L_0x057b
            r8 = 1
            goto L_0x057c
        L_0x057b:
            r8 = 0
        L_0x057c:
            boolean r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r7, (java.lang.String) r4)
            if (r7 == 0) goto L_0x0588
            if (r8 == 0) goto L_0x0586
            r7 = 4
            goto L_0x058d
        L_0x0586:
            r7 = 3
            goto L_0x058d
        L_0x0588:
            if (r8 == 0) goto L_0x058c
            r7 = 2
            goto L_0x058d
        L_0x058c:
            r7 = 1
        L_0x058d:
            r8 = 0
            boolean r5 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a((int) r5, (boolean) r8)
            if (r5 == 0) goto L_0x0596
            int r7 = r7 + 1000
        L_0x0596:
            if (r7 <= r0) goto L_0x05a0
            r0 = r7
            r14 = r11
            r12 = r13
            goto L_0x05a0
        L_0x059c:
            r21 = r5
            r35 = r8
        L_0x05a0:
            int r11 = r11 + 1
            r5 = r21
            r8 = r35
            goto L_0x055b
        L_0x05a7:
            r21 = r5
            r35 = r8
            int r13 = r13 + 1
            r11 = r12
            r12 = r14
            r7 = r33
            r14 = r0
            r0 = r20
            goto L_0x0549
        L_0x05b5:
            r20 = r0
            r33 = r7
            r35 = r8
            r0 = -1
            if (r11 != r0) goto L_0x05c2
            r0 = 1
            r1 = 0
            goto L_0x063f
        L_0x05c2:
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r1 = r1.b
            r1 = r1[r11]
            if (r10 == 0) goto L_0x0638
            r3 = r3[r11]
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x05d2:
            int r11 = r1.a
            if (r5 >= r11) goto L_0x060f
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r11 = r1.b
            r11 = r11[r5]
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$a r13 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$a
            int r14 = r11.r
            int r15 = r11.s
            if (r6 == 0) goto L_0x05e4
            r11 = 0
            goto L_0x05e6
        L_0x05e4:
            java.lang.String r11 = r11.f
        L_0x05e6:
            r13.<init>(r14, r15, r11)
            boolean r11 = r4.add(r13)
            if (r11 == 0) goto L_0x060b
            r11 = 0
            r14 = 0
        L_0x05f1:
            int r15 = r1.a
            if (r11 >= r15) goto L_0x0607
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r15 = r1.b
            r15 = r15[r11]
            r0 = r3[r11]
            boolean r0 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r15, r0, r13)
            if (r0 == 0) goto L_0x0603
            int r14 = r14 + 1
        L_0x0603:
            int r11 = r11 + 1
            r0 = -1
            goto L_0x05f1
        L_0x0607:
            if (r14 <= r7) goto L_0x060b
            r8 = r13
            r7 = r14
        L_0x060b:
            int r5 = r5 + 1
            r0 = -1
            goto L_0x05d2
        L_0x060f:
            r0 = 1
            if (r7 <= r0) goto L_0x062e
            int[] r4 = new int[r7]
            r5 = 0
            r6 = 0
        L_0x0616:
            int r7 = r1.a
            if (r5 >= r7) goto L_0x0630
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r7 = r1.b
            r7 = r7[r5]
            r11 = r3[r5]
            boolean r7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(r7, r11, r8)
            if (r7 == 0) goto L_0x062b
            int r7 = r6 + 1
            r4[r6] = r5
            r6 = r7
        L_0x062b:
            int r5 = r5 + 1
            goto L_0x0616
        L_0x062e:
            int[] r4 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e
        L_0x0630:
            int r3 = r4.length
            if (r3 <= 0) goto L_0x0639
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r1 = r10.a(r1, r4)
            goto L_0x063f
        L_0x0638:
            r0 = 1
        L_0x0639:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c r3 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.c
            r3.<init>(r1, r12)
            r1 = r3
        L_0x063f:
            r34[r9] = r1
            r1 = r34[r9]
            if (r1 == 0) goto L_0x0647
            r4 = 1
            goto L_0x064e
        L_0x0647:
            r4 = 0
            goto L_0x064e
        L_0x0649:
            r20 = r0
            r35 = r8
        L_0x064d:
            r0 = 1
        L_0x064e:
            int r9 = r9 + 1
            r0 = r20
            r1 = r30
            goto L_0x03fb
        L_0x0656:
            r2 = r48
            r9 = 0
        L_0x0659:
            int r0 = r2.length
            if (r9 >= r0) goto L_0x069e
            r1 = r47
            android.util.SparseBooleanArray r0 = r1.b
            boolean r0 = r0.get(r9)
            if (r0 == 0) goto L_0x066c
            r0 = 0
            r34[r9] = r0
            r3 = r0
        L_0x066a:
            r4 = 0
            goto L_0x069b
        L_0x066c:
            r0 = r32[r9]
            android.util.SparseArray<java.util.Map<com.fyber.inneractive.sdk.player.exoplayer2.source.s, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d$b>> r3 = r1.a
            java.lang.Object r3 = r3.get(r9)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 == 0) goto L_0x0699
            boolean r3 = r3.containsKey(r0)
            if (r3 == 0) goto L_0x0699
            android.util.SparseArray<java.util.Map<com.fyber.inneractive.sdk.player.exoplayer2.source.s, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d$b>> r3 = r1.a
            java.lang.Object r3 = r3.get(r9)
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r3 = r3.get(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d$b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d.b) r3
            if (r3 != 0) goto L_0x0692
            r3 = 0
            r34[r9] = r3
            goto L_0x066a
        L_0x0692:
            r3 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r0 = r0.b
            r4 = 0
            r0 = r0[r4]
            throw r3
        L_0x0699:
            r3 = 0
            goto L_0x066a
        L_0x069b:
            int r9 = r9 + 1
            goto L_0x0659
        L_0x069e:
            r1 = r47
            r3 = 0
            r4 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d$a r0 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d$a
            r8 = r0
            r9 = r28
            r10 = r32
            r11 = r27
            r12 = r29
            r13 = r26
            r8.<init>(r9, r10, r11, r12, r13)
            int r5 = r2.length
            com.fyber.inneractive.sdk.player.exoplayer2.o[] r5 = new com.fyber.inneractive.sdk.player.exoplayer2.o[r5]
            r7 = 0
        L_0x06b6:
            int r4 = r2.length
            if (r7 >= r4) goto L_0x06c6
            r4 = r34[r7]
            if (r4 == 0) goto L_0x06c0
            com.fyber.inneractive.sdk.player.exoplayer2.o r4 = com.fyber.inneractive.sdk.player.exoplayer2.o.b
            goto L_0x06c1
        L_0x06c0:
            r4 = r3
        L_0x06c1:
            r5[r7] = r4
            int r7 = r7 + 1
            goto L_0x06b6
        L_0x06c6:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h r2 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f r3 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f
            r4 = r34
            r3.<init>(r4)
            r4 = r49
            r2.<init>(r4, r3, r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d.a(com.fyber.inneractive.sdk.player.exoplayer2.a[], com.fyber.inneractive.sdk.player.exoplayer2.source.s):com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h");
    }

    public final void a(Object obj) {
        a aVar = (a) obj;
    }
}
