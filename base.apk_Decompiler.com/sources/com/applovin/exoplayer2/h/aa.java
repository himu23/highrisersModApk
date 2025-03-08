package com.applovin.exoplayer2.h;

import android.net.Uri;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.l.a;

public final class aa extends ba {
    private static final Object Nv = new Object();
    private static final ab Nw = new ab.b().n("SinglePeriodTimeline").b(Uri.EMPTY).bV();
    private final long NA;
    private final boolean NB;
    private final long Nx;
    private final long Ny;
    private final long Nz;
    private final ab.e eb;
    private final ab gL;
    private final Object iI;
    private final long iJ;
    private final long iK;
    private final long iL;
    private final boolean iM;
    private final boolean iN;

    public int cP() {
        return 1;
    }

    public int cQ() {
        return 1;
    }

    public aa(long j, boolean z, boolean z2, boolean z3, Object obj, ab abVar) {
        this(j, j, 0, 0, z, z2, z3, obj, abVar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aa(long r22, long r24, long r26, long r28, boolean r30, boolean r31, boolean r32, java.lang.Object r33, com.applovin.exoplayer2.ab r34) {
        /*
            r21 = this;
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = 0
            r15 = r34
            if (r32 == 0) goto L_0x0018
            com.applovin.exoplayer2.ab$e r0 = r15.eb
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            r20 = r0
            r0 = r21
            r7 = r22
            r9 = r24
            r11 = r26
            r13 = r28
            r15 = r30
            r16 = r31
            r18 = r33
            r19 = r34
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.aa.<init>(long, long, long, long, boolean, boolean, boolean, java.lang.Object, com.applovin.exoplayer2.ab):void");
    }

    public aa(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, ab abVar, ab.e eVar) {
        this.iJ = j;
        this.iK = j2;
        this.iL = j3;
        this.Nx = j4;
        this.Ny = j5;
        this.Nz = j6;
        this.NA = j7;
        this.iM = z;
        this.iN = z2;
        this.NB = z3;
        this.iI = obj;
        this.gL = (ab) a.checkNotNull(abVar);
        this.eb = eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r1 > r3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.exoplayer2.ba.c a(int r30, com.applovin.exoplayer2.ba.c r31, long r32) {
        /*
            r29 = this;
            r0 = r29
            r1 = 0
            r2 = 1
            r3 = r30
            com.applovin.exoplayer2.l.a.h(r3, r1, r2)
            long r1 = r0.NA
            boolean r3 = r0.iN
            if (r3 == 0) goto L_0x002e
            boolean r3 = r0.NB
            if (r3 != 0) goto L_0x002e
            r3 = 0
            int r5 = (r32 > r3 ? 1 : (r32 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            long r3 = r0.Ny
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0027
        L_0x0024:
            r21 = r5
            goto L_0x0030
        L_0x0027:
            long r1 = r1 + r32
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x002e
            goto L_0x0024
        L_0x002e:
            r21 = r1
        L_0x0030:
            java.lang.Object r9 = com.applovin.exoplayer2.ba.c.iF
            com.applovin.exoplayer2.ab r10 = r0.gL
            java.lang.Object r11 = r0.iI
            long r12 = r0.iJ
            long r14 = r0.iK
            long r1 = r0.iL
            r16 = r1
            boolean r1 = r0.iM
            r18 = r1
            boolean r1 = r0.iN
            r19 = r1
            com.applovin.exoplayer2.ab$e r1 = r0.eb
            r20 = r1
            long r1 = r0.Ny
            r23 = r1
            r25 = 0
            r26 = 0
            long r1 = r0.Nz
            r27 = r1
            r8 = r31
            com.applovin.exoplayer2.ba$c r1 = r8.a(r9, r10, r11, r12, r14, r16, r18, r19, r20, r21, r23, r25, r26, r27)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.aa.a(int, com.applovin.exoplayer2.ba$c, long):com.applovin.exoplayer2.ba$c");
    }

    public ba.a a(int i, ba.a aVar, boolean z) {
        a.h(i, 0, 1);
        return aVar.a((Object) null, z ? Nv : null, 0, this.Nx, -this.Nz);
    }

    public int c(Object obj) {
        return Nv.equals(obj) ? 0 : -1;
    }

    public Object b(int i) {
        a.h(i, 0, 1);
        return Nv;
    }
}
