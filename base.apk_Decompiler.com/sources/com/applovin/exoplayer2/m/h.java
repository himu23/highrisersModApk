package com.applovin.exoplayer2.m;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.f.g;
import com.applovin.exoplayer2.f.i;
import com.applovin.exoplayer2.f.j;
import com.applovin.exoplayer2.f.k;
import com.applovin.exoplayer2.f.l;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.t;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.m.n;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import com.google.android.gms.common.Scopes;
import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class h extends j {
    private static final int[] adL = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean adM;
    private static boolean adN;
    private final Context E;
    private Surface Hm;
    private final m adO;
    private final n.a adP;
    private final long adQ;
    private final int adR;
    private final boolean adS;
    private a adT;
    private boolean adU;
    private boolean adV;
    private d adW;
    private boolean adX;
    private int adY;
    private boolean adZ;
    private boolean aea;
    private boolean aeb;
    private long aec;
    private long aed;
    private long aee;
    private int aef;
    private int aeg;
    private int aeh;
    private long aei;
    private long aej;
    private int aek;
    private int ael;
    private int aem;
    private float aen;
    private o aeo;
    private int aep;
    b aeq;
    private l aer;
    private boolean hi;
    private long rE;
    private int rF;

    private static boolean bA(long j) {
        return j < -30000;
    }

    private static boolean bB(long j) {
        return j < -500000;
    }

    private void qo() {
        this.aeo = null;
    }

    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public h(Context context, k kVar, long j, boolean z, Handler handler, n nVar, int i) {
        this(context, g.b.Hp, kVar, j, z, handler, nVar, i);
    }

    public h(Context context, g.b bVar, k kVar, long j, boolean z, Handler handler, n nVar, int i) {
        super(2, bVar, kVar, z, 30.0f);
        this.adQ = j;
        this.adR = i;
        Context applicationContext = context.getApplicationContext();
        this.E = applicationContext;
        this.adO = new m(applicationContext);
        this.adP = new n.a(handler, nVar);
        this.adS = qt();
        this.aed = -9223372036854775807L;
        this.aek = -1;
        this.ael = -1;
        this.aen = -1.0f;
        this.adY = 1;
        this.aep = 0;
        qo();
    }

    /* access modifiers changed from: protected */
    public int a(k kVar, v vVar) throws l.b {
        int i = 0;
        if (!u.aX(vVar.dz)) {
            return as.CC.ae(0);
        }
        boolean z = vVar.dC != null;
        List<i> a2 = a(kVar, vVar, z, false);
        if (z && a2.isEmpty()) {
            a2 = a(kVar, vVar, false, false);
        }
        if (a2.isEmpty()) {
            return as.CC.ae(1);
        }
        if (!q(vVar)) {
            return as.CC.ae(2);
        }
        i iVar = a2.get(0);
        boolean l = iVar.l(vVar);
        int i2 = iVar.n(vVar) ? 16 : 8;
        if (l) {
            List<i> a3 = a(kVar, vVar, z, true);
            if (!a3.isEmpty()) {
                i iVar2 = a3.get(0);
                if (iVar2.l(vVar) && iVar2.n(vVar)) {
                    i = 32;
                }
            }
        }
        return as.CC.a(l ? 4 : 3, i2, i);
    }

    /* access modifiers changed from: protected */
    public List<i> a(k kVar, v vVar, boolean z) throws l.b {
        return a(kVar, vVar, z, this.hi);
    }

    private static List<i> a(k kVar, v vVar, boolean z, boolean z2) throws l.b {
        Pair<Integer, Integer> r;
        String str = vVar.dz;
        if (str == null) {
            return Collections.emptyList();
        }
        List<i> a2 = l.a(kVar.getDecoderInfos(str, z, z2), vVar);
        if ("video/dolby-vision".equals(str) && (r = l.r(vVar)) != null) {
            int intValue = ((Integer) r.first).intValue();
            if (intValue == 16 || intValue == 256) {
                a2.addAll(kVar.getDecoderInfos(MimeTypes.VIDEO_H265, z, z2));
            } else if (intValue == 512) {
                a2.addAll(kVar.getDecoderInfos(MimeTypes.VIDEO_H264, z, z2));
            }
        }
        return Collections.unmodifiableList(a2);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2) throws p {
        super.a(z, z2);
        boolean z3 = ag().hi;
        com.applovin.exoplayer2.l.a.checkState(!z3 || this.aep != 0);
        if (this.hi != z3) {
            this.hi = z3;
            kd();
        }
        this.adP.e(this.IL);
        this.adO.qw();
        this.aea = z2;
        this.aeb = false;
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws p {
        super.a(j, z);
        ql();
        this.adO.qx();
        this.aei = -9223372036854775807L;
        this.aec = -9223372036854775807L;
        this.aeg = 0;
        if (z) {
            qk();
        } else {
            this.aed = -9223372036854775807L;
        }
    }

    public boolean isReady() {
        d dVar;
        if (super.isReady() && (this.adZ || (((dVar = this.adW) != null && this.Hm == dVar) || jZ() == null || this.hi))) {
            this.aed = -9223372036854775807L;
            return true;
        } else if (this.aed == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.aed) {
                return true;
            }
            this.aed = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void aa() {
        super.aa();
        this.aef = 0;
        this.aee = SystemClock.elapsedRealtime();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.rE = 0;
        this.rF = 0;
        this.adO.aa();
    }

    /* access modifiers changed from: protected */
    public void ab() {
        this.aed = -9223372036854775807L;
        qr();
        qs();
        this.adO.ab();
        super.ab();
    }

    /* access modifiers changed from: protected */
    public void ac() {
        qo();
        ql();
        this.adX = false;
        this.adO.ac();
        this.aeq = null;
        try {
            super.ac();
        } finally {
            this.adP.f(this.IL);
        }
    }

    /* access modifiers changed from: protected */
    public void ad() {
        try {
            super.ad();
            d dVar = this.adW;
            if (dVar != null) {
                if (this.Hm == dVar) {
                    this.Hm = null;
                }
                dVar.release();
                this.adW = null;
            }
        } catch (Throwable th) {
            if (this.adW != null) {
                Surface surface = this.Hm;
                d dVar2 = this.adW;
                if (surface == dVar2) {
                    this.Hm = null;
                }
                dVar2.release();
                this.adW = null;
            }
            throw th;
        }
    }

    public void a(int i, Object obj) throws p {
        if (i == 1) {
            S(obj);
        } else if (i == 7) {
            this.aer = (l) obj;
        } else if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.aep != intValue) {
                this.aep = intValue;
                if (this.hi) {
                    kd();
                }
            }
        } else if (i == 4) {
            this.adY = ((Integer) obj).intValue();
            g jZ = jZ();
            if (jZ != null) {
                jZ.cJ(this.adY);
            }
        } else if (i != 5) {
            super.a(i, obj);
        } else {
            this.adO.fS(((Integer) obj).intValue());
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S(java.lang.Object r5) throws com.applovin.exoplayer2.p {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            com.applovin.exoplayer2.m.d r0 = r4.adW
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            com.applovin.exoplayer2.f.i r0 = r4.kb()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.e(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.E
            boolean r0 = r0.Hu
            com.applovin.exoplayer2.m.d r5 = com.applovin.exoplayer2.m.d.c(r5, r0)
            r4.adW = r5
        L_0x0026:
            android.view.Surface r0 = r4.Hm
            if (r0 == r5) goto L_0x006e
            r4.Hm = r5
            com.applovin.exoplayer2.m.m r0 = r4.adO
            r0.c(r5)
            r0 = 0
            r4.adX = r0
            int r0 = r4.P()
            com.applovin.exoplayer2.f.g r1 = r4.jZ()
            if (r1 == 0) goto L_0x0054
            int r2 = com.applovin.exoplayer2.l.ai.acV
            r3 = 23
            if (r2 < r3) goto L_0x004e
            if (r5 == 0) goto L_0x004e
            boolean r2 = r4.adU
            if (r2 != 0) goto L_0x004e
            r4.a((com.applovin.exoplayer2.f.g) r1, (android.view.Surface) r5)
            goto L_0x0054
        L_0x004e:
            r4.kd()
            r4.jX()
        L_0x0054:
            if (r5 == 0) goto L_0x0067
            com.applovin.exoplayer2.m.d r1 = r4.adW
            if (r5 == r1) goto L_0x0067
            r4.qq()
            r4.ql()
            r5 = 2
            if (r0 != r5) goto L_0x007a
            r4.qk()
            goto L_0x007a
        L_0x0067:
            r4.qo()
            r4.ql()
            goto L_0x007a
        L_0x006e:
            if (r5 == 0) goto L_0x007a
            com.applovin.exoplayer2.m.d r0 = r4.adW
            if (r5 == r0) goto L_0x007a
            r4.qq()
            r4.qn()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.h.S(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean a(i iVar) {
        return this.Hm != null || e(iVar);
    }

    /* access modifiers changed from: protected */
    public boolean jY() {
        return this.hi && ai.acV < 23;
    }

    /* access modifiers changed from: protected */
    public g.a a(i iVar, v vVar, MediaCrypto mediaCrypto, float f) {
        d dVar = this.adW;
        if (!(dVar == null || dVar.Hu == iVar.Hu)) {
            this.adW.release();
            this.adW = null;
        }
        String str = iVar.Hr;
        a b2 = b(iVar, vVar, af());
        this.adT = b2;
        MediaFormat a2 = a(vVar, str, b2, f, this.adS, this.hi ? this.aep : 0);
        if (this.Hm == null) {
            if (e(iVar)) {
                if (this.adW == null) {
                    this.adW = d.c(this.E, iVar.Hu);
                }
                this.Hm = this.adW;
            } else {
                throw new IllegalStateException();
            }
        }
        return g.a.a(iVar, a2, vVar, this.Hm, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.c.h a(i iVar, v vVar, v vVar2) {
        int i;
        com.applovin.exoplayer2.c.h a2 = iVar.a(vVar, vVar2);
        int i2 = a2.rR;
        if (vVar2.dE > this.adT.dE || vVar2.height > this.adT.height) {
            i2 |= 256;
        }
        if (c(iVar, vVar2) > this.adT.aes) {
            i2 |= 64;
        }
        int i3 = i2;
        String str = iVar.name;
        if (i3 != 0) {
            i = 0;
        } else {
            i = a2.pZ;
        }
        return new com.applovin.exoplayer2.c.h(str, vVar, vVar2, i, i3);
    }

    /* access modifiers changed from: protected */
    public void kh() {
        super.kh();
        this.aeh = 0;
    }

    public void a(float f, float f2) throws p {
        super.a(f, f2);
        this.adO.v(f);
    }

    /* access modifiers changed from: protected */
    public float a(float f, v vVar, v[] vVarArr) {
        float f2 = -1.0f;
        for (v vVar2 : vVarArr) {
            float f3 = vVar2.dF;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void e(String str, long j, long j2) {
        this.adP.c(str, j, j2);
        this.adU = bo(str);
        this.adV = ((i) com.applovin.exoplayer2.l.a.checkNotNull(kb())).jW();
        if (ai.acV >= 23 && this.hi) {
            this.aeq = new b((g) com.applovin.exoplayer2.l.a.checkNotNull(jZ()));
        }
    }

    /* access modifiers changed from: protected */
    public void v(String str) {
        this.adP.t(str);
    }

    /* access modifiers changed from: protected */
    public void i(Exception exc) {
        q.c("MediaCodecVideoRenderer", "Video codec error", exc);
        this.adP.k(exc);
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.c.h a(w wVar) throws p {
        com.applovin.exoplayer2.c.h a2 = super.a(wVar);
        this.adP.c(wVar.dU, a2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(com.applovin.exoplayer2.c.g gVar) throws p {
        if (!this.hi) {
            this.aeh++;
        }
        if (ai.acV < 23 && this.hi) {
            by(gVar.rJ);
        }
    }

    /* access modifiers changed from: protected */
    public void a(v vVar, MediaFormat mediaFormat) {
        int i;
        int i2;
        g jZ = jZ();
        if (jZ != null) {
            jZ.cJ(this.adY);
        }
        if (this.hi) {
            this.aek = vVar.dE;
            this.ael = vVar.height;
        } else {
            com.applovin.exoplayer2.l.a.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.aek = i;
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.ael = i2;
        }
        this.aen = vVar.dH;
        if (ai.acV < 21) {
            this.aem = vVar.dG;
        } else if (vVar.dG == 90 || vVar.dG == 270) {
            int i3 = this.aek;
            this.aek = this.ael;
            this.ael = i3;
            this.aen = 1.0f / this.aen;
        }
        this.adO.y(vVar.dF);
    }

    /* access modifiers changed from: protected */
    public void f(com.applovin.exoplayer2.c.g gVar) throws p {
        if (this.adV) {
            ByteBuffer byteBuffer = (ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(gVar.rK);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    a(jZ(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(long j, long j2, g gVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, v vVar) throws p {
        long j4;
        boolean z3;
        long j5 = j;
        g gVar2 = gVar;
        int i4 = i;
        long j6 = j3;
        com.applovin.exoplayer2.l.a.checkNotNull(gVar);
        if (this.aec == -9223372036854775807L) {
            this.aec = j5;
        }
        if (j6 != this.aei) {
            this.adO.bw(j6);
            this.aei = j6;
        }
        long ku = ku();
        long j7 = j6 - ku;
        if (!z || z2) {
            double kn = (double) kn();
            boolean z4 = P() == 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j8 = (long) (((double) (j6 - j5)) / kn);
            if (z4) {
                j8 -= elapsedRealtime - j2;
            }
            if (this.Hm != this.adW) {
                long j9 = elapsedRealtime - this.aej;
                if (this.aeb ? this.adZ : !z4 && !this.aea) {
                    j4 = j9;
                    z3 = false;
                } else {
                    j4 = j9;
                    z3 = true;
                }
                if (this.aed != -9223372036854775807L || j5 < ku || (!z3 && (!z4 || !C(j8, j4)))) {
                    if (z4 && j5 != this.aec) {
                        long nanoTime = System.nanoTime();
                        long bD = this.adO.bD((j8 * 1000) + nanoTime);
                        long j10 = (bD - nanoTime) / 1000;
                        long j11 = j10;
                        boolean z5 = this.aed != -9223372036854775807L;
                        if (b(j10, j2, z2) && h(j5, z5)) {
                            return false;
                        }
                        if (a(j11, j2, z2)) {
                            if (z5) {
                                a(gVar2, i4, j7);
                            } else {
                                b(gVar2, i4, j7);
                            }
                            bz(j11);
                            return true;
                        }
                        long j12 = j11;
                        if (ai.acV >= 21) {
                            if (j12 < 50000) {
                                a(j7, bD, vVar);
                                a(gVar, i, j7, bD);
                                bz(j12);
                                return true;
                            }
                        } else if (j12 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                            if (j12 > 11000) {
                                try {
                                    Thread.sleep((j12 - 10000) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            a(j7, bD, vVar);
                            c(gVar2, i4, j7);
                            bz(j12);
                            return true;
                        }
                    }
                    return false;
                }
                long nanoTime2 = System.nanoTime();
                a(j7, nanoTime2, vVar);
                if (ai.acV >= 21) {
                    a(gVar, i, j7, nanoTime2);
                } else {
                    c(gVar2, i4, j7);
                }
                bz(j8);
                return true;
            } else if (!bA(j8)) {
                return false;
            } else {
                a(gVar2, i4, j7);
                bz(j8);
                return true;
            }
        } else {
            a(gVar2, i4, j7);
            return true;
        }
    }

    private void a(long j, long j2, v vVar) {
        l lVar = this.aer;
        if (lVar != null) {
            lVar.a(j, j2, vVar, ka());
        }
    }

    /* access modifiers changed from: protected */
    public void by(long j) throws p {
        aL(j);
        qp();
        this.IL.rz++;
        qm();
        aN(j);
    }

    /* access modifiers changed from: private */
    public void qj() {
        kt();
    }

    /* access modifiers changed from: protected */
    public void aN(long j) {
        super.aN(j);
        if (!this.hi) {
            this.aeh--;
        }
    }

    /* access modifiers changed from: protected */
    public void eB() {
        super.eB();
        ql();
    }

    /* access modifiers changed from: protected */
    public boolean a(long j, long j2, boolean z) {
        return bA(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean b(long j, long j2, boolean z) {
        return bB(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean C(long j, long j2) {
        return bA(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, int i, long j) {
        ah.bg("skipVideoBuffer");
        gVar.l(i, false);
        ah.pV();
        this.IL.rA++;
    }

    /* access modifiers changed from: protected */
    public void b(g gVar, int i, long j) {
        ah.bg("dropVideoBuffer");
        gVar.l(i, false);
        ah.pV();
        fR(1);
    }

    /* access modifiers changed from: protected */
    public boolean h(long j, boolean z) throws p {
        int e = e(j);
        if (e == 0) {
            return false;
        }
        this.IL.rD++;
        int i = this.aeh + e;
        if (z) {
            this.IL.rA += i;
        } else {
            fR(i);
        }
        ke();
        return true;
    }

    /* access modifiers changed from: protected */
    public void fR(int i) {
        this.IL.rB += i;
        this.aef += i;
        this.aeg += i;
        this.IL.rC = Math.max(this.aeg, this.IL.rC);
        int i2 = this.adR;
        if (i2 > 0 && this.aef >= i2) {
            qr();
        }
    }

    /* access modifiers changed from: protected */
    public void bz(long j) {
        this.IL.af(j);
        this.rE += j;
        this.rF++;
    }

    /* access modifiers changed from: protected */
    public void c(g gVar, int i, long j) {
        qp();
        ah.bg("releaseOutputBuffer");
        gVar.l(i, true);
        ah.pV();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.IL.rz++;
        this.aeg = 0;
        qm();
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, int i, long j, long j2) {
        qp();
        ah.bg("releaseOutputBuffer");
        gVar.i(i, j2);
        ah.pV();
        this.aej = SystemClock.elapsedRealtime() * 1000;
        this.IL.rz++;
        this.aeg = 0;
        qm();
    }

    private boolean e(i iVar) {
        return ai.acV >= 23 && !this.hi && !bo(iVar.name) && (!iVar.Hu || d.p(this.E));
    }

    private void qk() {
        this.aed = this.adQ > 0 ? SystemClock.elapsedRealtime() + this.adQ : -9223372036854775807L;
    }

    private void ql() {
        g jZ;
        this.adZ = false;
        if (ai.acV >= 23 && this.hi && (jZ = jZ()) != null) {
            this.aeq = new b(jZ);
        }
    }

    /* access modifiers changed from: package-private */
    public void qm() {
        this.aeb = true;
        if (!this.adZ) {
            this.adZ = true;
            this.adP.T(this.Hm);
            this.adX = true;
        }
    }

    private void qn() {
        if (this.adX) {
            this.adP.T(this.Hm);
        }
    }

    private void qp() {
        if (this.aek != -1 || this.ael != -1) {
            o oVar = this.aeo;
            if (oVar == null || oVar.dE != this.aek || this.aeo.height != this.ael || this.aeo.afl != this.aem || this.aeo.dH != this.aen) {
                o oVar2 = new o(this.aek, this.ael, this.aem, this.aen);
                this.aeo = oVar2;
                this.adP.b(oVar2);
            }
        }
    }

    private void qq() {
        o oVar = this.aeo;
        if (oVar != null) {
            this.adP.b(oVar);
        }
    }

    private void qr() {
        if (this.aef > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.adP.l(this.aef, elapsedRealtime - this.aee);
            this.aef = 0;
            this.aee = elapsedRealtime;
        }
    }

    private void qs() {
        int i = this.rF;
        if (i != 0) {
            this.adP.f(this.rE, i);
            this.rE = 0;
            this.rF = 0;
        }
    }

    private static void a(g gVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        gVar.u(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, Surface surface) {
        gVar.b(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat a(v vVar, String str, a aVar, float f, boolean z, int i) {
        Pair<Integer, Integer> r;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", vVar.dE);
        mediaFormat.setInteger("height", vVar.height);
        t.a(mediaFormat, vVar.dB);
        t.a(mediaFormat, "frame-rate", vVar.dF);
        t.a(mediaFormat, "rotation-degrees", vVar.dG);
        t.a(mediaFormat, vVar.dK);
        if ("video/dolby-vision".equals(vVar.dz) && (r = l.r(vVar)) != null) {
            t.a(mediaFormat, Scopes.PROFILE, ((Integer) r.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.dE);
        mediaFormat.setInteger("max-height", aVar.height);
        t.a(mediaFormat, "max-input-size", aVar.aes);
        if (ai.acV >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            a(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public a b(i iVar, v vVar, v[] vVarArr) {
        int a2;
        int i = vVar.dE;
        int i2 = vVar.height;
        int c = c(iVar, vVar);
        if (vVarArr.length == 1) {
            if (!(c == -1 || (a2 = a(iVar, vVar)) == -1)) {
                c = Math.min((int) (((float) c) * 1.5f), a2);
            }
            return new a(i, i2, c);
        }
        int length = vVarArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            v vVar2 = vVarArr[i3];
            if (vVar.dK != null && vVar2.dK == null) {
                vVar2 = vVar2.bR().a(vVar.dK).bT();
            }
            if (iVar.a(vVar, vVar2).pZ != 0) {
                z |= vVar2.dE == -1 || vVar2.height == -1;
                i = Math.max(i, vVar2.dE);
                i2 = Math.max(i2, vVar2.height);
                c = Math.max(c, c(iVar, vVar2));
            }
        }
        if (z) {
            q.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point b2 = b(iVar, vVar);
            if (b2 != null) {
                i = Math.max(i, b2.x);
                i2 = Math.max(i2, b2.y);
                c = Math.max(c, a(iVar, vVar.bR().J(i).K(i2).bT()));
                q.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new a(i, i2, c);
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.f.h a(Throwable th, i iVar) {
        return new g(th, iVar, this.Hm);
    }

    private static Point b(i iVar, v vVar) {
        boolean z = vVar.height > vVar.dE;
        int i = z ? vVar.height : vVar.dE;
        int i2 = z ? vVar.dE : vVar.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : adL) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (ai.acV >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point D = iVar.D(i5, i3);
                if (iVar.a(D.x, D.y, (double) vVar.dF)) {
                    return D;
                }
            } else {
                try {
                    int N = ai.N(i3, 16) * 16;
                    int N2 = ai.N(i4, 16) * 16;
                    if (N * N2 <= l.kz()) {
                        int i6 = z ? N2 : N;
                        if (!z) {
                            N = N2;
                        }
                        return new Point(i6, N);
                    }
                } catch (l.b unused) {
                }
            }
        }
        return null;
    }

    protected static int c(i iVar, v vVar) {
        if (vVar.dA == -1) {
            return a(iVar, vVar);
        }
        int size = vVar.dB.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += vVar.dB.get(i2).length;
        }
        return vVar.dA + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r3.equals(com.unity3d.services.core.device.MimeTypes.VIDEO_H265) == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.applovin.exoplayer2.f.i r10, com.applovin.exoplayer2.v r11) {
        /*
            int r0 = r11.dE
            int r1 = r11.height
            r2 = -1
            if (r0 == r2) goto L_0x00ca
            if (r1 != r2) goto L_0x000b
            goto L_0x00ca
        L_0x000b:
            java.lang.String r3 = r11.dz
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            r6 = 1
            java.lang.String r7 = "video/hevc"
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r11 = com.applovin.exoplayer2.f.l.r(r11)
            if (r11 == 0) goto L_0x0033
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0031
            if (r11 == r6) goto L_0x0031
            if (r11 != r8) goto L_0x0033
        L_0x0031:
            r3 = r5
            goto L_0x0034
        L_0x0033:
            r3 = r7
        L_0x0034:
            r3.hashCode()
            int r11 = r3.hashCode()
            r4 = 4
            r9 = 3
            switch(r11) {
                case -1664118616: goto L_0x0073;
                case -1662541442: goto L_0x006c;
                case 1187890754: goto L_0x0061;
                case 1331836730: goto L_0x0058;
                case 1599127256: goto L_0x004d;
                case 1599127257: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            r6 = -1
            goto L_0x007d
        L_0x0042:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x004b
            goto L_0x0040
        L_0x004b:
            r6 = 5
            goto L_0x007d
        L_0x004d:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x0056
            goto L_0x0040
        L_0x0056:
            r6 = 4
            goto L_0x007d
        L_0x0058:
            boolean r11 = r3.equals(r5)
            if (r11 != 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            r6 = 3
            goto L_0x007d
        L_0x0061:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x006a
            goto L_0x0040
        L_0x006a:
            r6 = 2
            goto L_0x007d
        L_0x006c:
            boolean r11 = r3.equals(r7)
            if (r11 != 0) goto L_0x007d
            goto L_0x0040
        L_0x0073:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x007c
            goto L_0x0040
        L_0x007c:
            r6 = 0
        L_0x007d:
            switch(r6) {
                case 0: goto L_0x00c1;
                case 1: goto L_0x00be;
                case 2: goto L_0x00c1;
                case 3: goto L_0x0081;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00be;
                default: goto L_0x0080;
            }
        L_0x0080:
            return r2
        L_0x0081:
            java.lang.String r11 = "BRAVIA 4K 2015"
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.acY
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L_0x00bd
            java.lang.String r11 = "Amazon"
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.acX
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x00ae
            java.lang.String r11 = "KFSOWI"
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.acY
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L_0x00bd
            java.lang.String r11 = "AFTS"
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.acY
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x00ae
            boolean r10 = r10.Hu
            if (r10 == 0) goto L_0x00ae
            goto L_0x00bd
        L_0x00ae:
            r10 = 16
            int r11 = com.applovin.exoplayer2.l.ai.N(r0, r10)
            int r10 = com.applovin.exoplayer2.l.ai.N(r1, r10)
            int r11 = r11 * r10
            int r0 = r11 * 256
            goto L_0x00c3
        L_0x00bd:
            return r2
        L_0x00be:
            int r0 = r0 * r1
            goto L_0x00c4
        L_0x00c1:
            int r0 = r0 * r1
        L_0x00c3:
            r4 = 2
        L_0x00c4:
            int r0 = r0 * 3
            int r4 = r4 * 2
            int r0 = r0 / r4
            return r0
        L_0x00ca:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.h.a(com.applovin.exoplayer2.f.i, com.applovin.exoplayer2.v):int");
    }

    private static boolean qt() {
        return "NVIDIA".equals(ai.acX);
    }

    /* access modifiers changed from: protected */
    public boolean bo(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (h.class) {
            if (!adM) {
                adN = qu();
                adM = true;
            }
        }
        return adN;
    }

    protected static final class a {
        public final int aes;
        public final int dE;
        public final int height;

        public a(int i, int i2, int i3) {
            this.dE = i;
            this.height = i2;
            this.aes = i3;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x07d3, code lost:
        if (r0.equals("NX573J") == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:462:0x0835, code lost:
        if (r0.equals("AFTN") == false) goto L_0x082d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x0851, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean qu() {
        /*
            int r0 = com.applovin.exoplayer2.l.ai.acV
            r1 = 6
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = -1
            r7 = 0
            r8 = 1
            r9 = 28
            if (r0 > r9) goto L_0x006d
            java.lang.String r0 = com.applovin.exoplayer2.l.ai.acW
            r0.hashCode()
            int r10 = r0.hashCode()
            switch(r10) {
                case -1339091551: goto L_0x005e;
                case -1220081023: goto L_0x0053;
                case -1220066608: goto L_0x0048;
                case -1012436106: goto L_0x003d;
                case -64886864: goto L_0x0032;
                case 3415681: goto L_0x0027;
                case 825323514: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            r0 = -1
            goto L_0x0068
        L_0x001c:
            java.lang.String r10 = "machuca"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0025
            goto L_0x001a
        L_0x0025:
            r0 = 6
            goto L_0x0068
        L_0x0027:
            java.lang.String r10 = "once"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0030
            goto L_0x001a
        L_0x0030:
            r0 = 5
            goto L_0x0068
        L_0x0032:
            java.lang.String r10 = "magnolia"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x003b
            goto L_0x001a
        L_0x003b:
            r0 = 4
            goto L_0x0068
        L_0x003d:
            java.lang.String r10 = "oneday"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0046
            goto L_0x001a
        L_0x0046:
            r0 = 3
            goto L_0x0068
        L_0x0048:
            java.lang.String r10 = "dangalUHD"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0051
            goto L_0x001a
        L_0x0051:
            r0 = 2
            goto L_0x0068
        L_0x0053:
            java.lang.String r10 = "dangalFHD"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x005c
            goto L_0x001a
        L_0x005c:
            r0 = 1
            goto L_0x0068
        L_0x005e:
            java.lang.String r10 = "dangal"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0067
            goto L_0x001a
        L_0x0067:
            r0 = 0
        L_0x0068:
            switch(r0) {
                case 0: goto L_0x006c;
                case 1: goto L_0x006c;
                case 2: goto L_0x006c;
                case 3: goto L_0x006c;
                case 4: goto L_0x006c;
                case 5: goto L_0x006c;
                case 6: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x006d
        L_0x006c:
            return r8
        L_0x006d:
            int r0 = com.applovin.exoplayer2.l.ai.acV
            r10 = 27
            if (r0 > r10) goto L_0x007e
            java.lang.String r0 = "HWEML"
            java.lang.String r11 = com.applovin.exoplayer2.l.ai.acW
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x007e
            return r8
        L_0x007e:
            int r0 = com.applovin.exoplayer2.l.ai.acV
            r11 = 26
            if (r0 > r11) goto L_0x0852
            java.lang.String r0 = com.applovin.exoplayer2.l.ai.acW
            r0.hashCode()
            int r12 = r0.hashCode()
            switch(r12) {
                case -2144781245: goto L_0x0813;
                case -2144781185: goto L_0x0807;
                case -2144781160: goto L_0x07fb;
                case -2097309513: goto L_0x07ef;
                case -2022874474: goto L_0x07e3;
                case -1978993182: goto L_0x07d7;
                case -1978990237: goto L_0x07cd;
                case -1936688988: goto L_0x07c1;
                case -1936688066: goto L_0x07b4;
                case -1936688065: goto L_0x07a6;
                case -1931988508: goto L_0x0798;
                case -1885099851: goto L_0x078a;
                case -1696512866: goto L_0x077c;
                case -1680025915: goto L_0x076e;
                case -1615810839: goto L_0x0760;
                case -1600724499: goto L_0x0752;
                case -1554255044: goto L_0x0744;
                case -1481772737: goto L_0x0736;
                case -1481772730: goto L_0x0728;
                case -1481772729: goto L_0x071a;
                case -1320080169: goto L_0x070c;
                case -1217592143: goto L_0x06fe;
                case -1180384755: goto L_0x06f0;
                case -1139198265: goto L_0x06e2;
                case -1052835013: goto L_0x06d4;
                case -993250464: goto L_0x06c6;
                case -993250458: goto L_0x06b8;
                case -965403638: goto L_0x06aa;
                case -958336948: goto L_0x069c;
                case -879245230: goto L_0x068e;
                case -842500323: goto L_0x0680;
                case -821392978: goto L_0x0672;
                case -797483286: goto L_0x0664;
                case -794946968: goto L_0x0656;
                case -788334647: goto L_0x0648;
                case -782144577: goto L_0x063a;
                case -575125681: goto L_0x062c;
                case -521118391: goto L_0x061e;
                case -430914369: goto L_0x0610;
                case -290434366: goto L_0x0602;
                case -282781963: goto L_0x05f4;
                case -277133239: goto L_0x05e6;
                case -173639913: goto L_0x05d8;
                case -56598463: goto L_0x05ca;
                case 2126: goto L_0x05bc;
                case 2564: goto L_0x05ae;
                case 2715: goto L_0x05a0;
                case 2719: goto L_0x0592;
                case 3091: goto L_0x0584;
                case 3483: goto L_0x0576;
                case 73405: goto L_0x0568;
                case 75537: goto L_0x055a;
                case 75739: goto L_0x054c;
                case 76779: goto L_0x053e;
                case 78669: goto L_0x0530;
                case 79305: goto L_0x0522;
                case 80618: goto L_0x0514;
                case 88274: goto L_0x0506;
                case 98846: goto L_0x04f8;
                case 98848: goto L_0x04ea;
                case 99329: goto L_0x04dc;
                case 101481: goto L_0x04ce;
                case 1513190: goto L_0x04c0;
                case 1514184: goto L_0x04b2;
                case 1514185: goto L_0x04a4;
                case 2133089: goto L_0x0496;
                case 2133091: goto L_0x0488;
                case 2133120: goto L_0x047a;
                case 2133151: goto L_0x046c;
                case 2133182: goto L_0x045e;
                case 2133184: goto L_0x0450;
                case 2436959: goto L_0x0442;
                case 2463773: goto L_0x0434;
                case 2464648: goto L_0x0426;
                case 2689555: goto L_0x0418;
                case 3154429: goto L_0x040a;
                case 3284551: goto L_0x03fc;
                case 3351335: goto L_0x03ee;
                case 3386211: goto L_0x03e0;
                case 41325051: goto L_0x03d2;
                case 51349633: goto L_0x03c4;
                case 51350594: goto L_0x03b6;
                case 55178625: goto L_0x03a8;
                case 61542055: goto L_0x039a;
                case 65355429: goto L_0x038c;
                case 66214468: goto L_0x037e;
                case 66214470: goto L_0x0370;
                case 66214473: goto L_0x0362;
                case 66215429: goto L_0x0354;
                case 66215431: goto L_0x0346;
                case 66215433: goto L_0x0338;
                case 66216390: goto L_0x032a;
                case 76402249: goto L_0x031c;
                case 76404105: goto L_0x030e;
                case 76404911: goto L_0x0300;
                case 80963634: goto L_0x02f2;
                case 82882791: goto L_0x02e4;
                case 98715550: goto L_0x02d6;
                case 101370885: goto L_0x02c8;
                case 102844228: goto L_0x02ba;
                case 165221241: goto L_0x02ac;
                case 182191441: goto L_0x029e;
                case 245388979: goto L_0x0290;
                case 287431619: goto L_0x0282;
                case 307593612: goto L_0x0274;
                case 308517133: goto L_0x0266;
                case 316215098: goto L_0x0258;
                case 316215116: goto L_0x024a;
                case 316246811: goto L_0x023c;
                case 316246818: goto L_0x022e;
                case 407160593: goto L_0x0220;
                case 507412548: goto L_0x0212;
                case 793982701: goto L_0x0204;
                case 794038622: goto L_0x01f6;
                case 794040393: goto L_0x01e8;
                case 835649806: goto L_0x01da;
                case 917340916: goto L_0x01cc;
                case 958008161: goto L_0x01be;
                case 1060579533: goto L_0x01b0;
                case 1150207623: goto L_0x01a2;
                case 1176899427: goto L_0x0194;
                case 1280332038: goto L_0x0186;
                case 1306947716: goto L_0x0178;
                case 1349174697: goto L_0x016a;
                case 1522194893: goto L_0x015c;
                case 1691543273: goto L_0x014e;
                case 1691544261: goto L_0x0140;
                case 1709443163: goto L_0x0132;
                case 1865889110: goto L_0x0124;
                case 1906253259: goto L_0x0116;
                case 1977196784: goto L_0x0108;
                case 2006372676: goto L_0x00fb;
                case 2019281702: goto L_0x00ee;
                case 2029784656: goto L_0x00e1;
                case 2030379515: goto L_0x00d4;
                case 2033393791: goto L_0x00c7;
                case 2047190025: goto L_0x00ba;
                case 2047252157: goto L_0x00ad;
                case 2048319463: goto L_0x00a0;
                case 2048855701: goto L_0x0093;
                default: goto L_0x0090;
            }
        L_0x0090:
            r1 = -1
            goto L_0x081e
        L_0x0093:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x0090
        L_0x009c:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x081e
        L_0x00a0:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x0090
        L_0x00a9:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x081e
        L_0x00ad:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b6
            goto L_0x0090
        L_0x00b6:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x081e
        L_0x00ba:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c3
            goto L_0x0090
        L_0x00c3:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x081e
        L_0x00c7:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d0
            goto L_0x0090
        L_0x00d0:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x081e
        L_0x00d4:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0090
        L_0x00dd:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x081e
        L_0x00e1:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ea
            goto L_0x0090
        L_0x00ea:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x081e
        L_0x00ee:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f7
            goto L_0x0090
        L_0x00f7:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x081e
        L_0x00fb:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0104
            goto L_0x0090
        L_0x0104:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x081e
        L_0x0108:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0112
            goto L_0x0090
        L_0x0112:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x081e
        L_0x0116:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0120
            goto L_0x0090
        L_0x0120:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x081e
        L_0x0124:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012e
            goto L_0x0090
        L_0x012e:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x081e
        L_0x0132:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013c
            goto L_0x0090
        L_0x013c:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x081e
        L_0x0140:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014a
            goto L_0x0090
        L_0x014a:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x081e
        L_0x014e:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0158
            goto L_0x0090
        L_0x0158:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x081e
        L_0x015c:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0166
            goto L_0x0090
        L_0x0166:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x081e
        L_0x016a:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0174
            goto L_0x0090
        L_0x0174:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x081e
        L_0x0178:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0182
            goto L_0x0090
        L_0x0182:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x081e
        L_0x0186:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0190
            goto L_0x0090
        L_0x0190:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x081e
        L_0x0194:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x019e
            goto L_0x0090
        L_0x019e:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x081e
        L_0x01a2:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ac
            goto L_0x0090
        L_0x01ac:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x081e
        L_0x01b0:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ba
            goto L_0x0090
        L_0x01ba:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x081e
        L_0x01be:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c8
            goto L_0x0090
        L_0x01c8:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x081e
        L_0x01cc:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d6
            goto L_0x0090
        L_0x01d6:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x081e
        L_0x01da:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e4
            goto L_0x0090
        L_0x01e4:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x081e
        L_0x01e8:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f2
            goto L_0x0090
        L_0x01f2:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x081e
        L_0x01f6:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0200
            goto L_0x0090
        L_0x0200:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x081e
        L_0x0204:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x020e
            goto L_0x0090
        L_0x020e:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x081e
        L_0x0212:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x021c
            goto L_0x0090
        L_0x021c:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x081e
        L_0x0220:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022a
            goto L_0x0090
        L_0x022a:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x081e
        L_0x022e:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0238
            goto L_0x0090
        L_0x0238:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x081e
        L_0x023c:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0246
            goto L_0x0090
        L_0x0246:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x081e
        L_0x024a:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0254
            goto L_0x0090
        L_0x0254:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x081e
        L_0x0258:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0262
            goto L_0x0090
        L_0x0262:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x081e
        L_0x0266:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0270
            goto L_0x0090
        L_0x0270:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x081e
        L_0x0274:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x027e
            goto L_0x0090
        L_0x027e:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x081e
        L_0x0282:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028c
            goto L_0x0090
        L_0x028c:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x081e
        L_0x0290:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029a
            goto L_0x0090
        L_0x029a:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x081e
        L_0x029e:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02a8
            goto L_0x0090
        L_0x02a8:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x081e
        L_0x02ac:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b6
            goto L_0x0090
        L_0x02b6:
            r1 = 100
            goto L_0x081e
        L_0x02ba:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c4
            goto L_0x0090
        L_0x02c4:
            r1 = 99
            goto L_0x081e
        L_0x02c8:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d2
            goto L_0x0090
        L_0x02d2:
            r1 = 98
            goto L_0x081e
        L_0x02d6:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e0
            goto L_0x0090
        L_0x02e0:
            r1 = 97
            goto L_0x081e
        L_0x02e4:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ee
            goto L_0x0090
        L_0x02ee:
            r1 = 96
            goto L_0x081e
        L_0x02f2:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02fc
            goto L_0x0090
        L_0x02fc:
            r1 = 95
            goto L_0x081e
        L_0x0300:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030a
            goto L_0x0090
        L_0x030a:
            r1 = 94
            goto L_0x081e
        L_0x030e:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0318
            goto L_0x0090
        L_0x0318:
            r1 = 93
            goto L_0x081e
        L_0x031c:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0326
            goto L_0x0090
        L_0x0326:
            r1 = 92
            goto L_0x081e
        L_0x032a:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0334
            goto L_0x0090
        L_0x0334:
            r1 = 91
            goto L_0x081e
        L_0x0338:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0342
            goto L_0x0090
        L_0x0342:
            r1 = 90
            goto L_0x081e
        L_0x0346:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0350
            goto L_0x0090
        L_0x0350:
            r1 = 89
            goto L_0x081e
        L_0x0354:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x035e
            goto L_0x0090
        L_0x035e:
            r1 = 88
            goto L_0x081e
        L_0x0362:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x036c
            goto L_0x0090
        L_0x036c:
            r1 = 87
            goto L_0x081e
        L_0x0370:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037a
            goto L_0x0090
        L_0x037a:
            r1 = 86
            goto L_0x081e
        L_0x037e:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0388
            goto L_0x0090
        L_0x0388:
            r1 = 85
            goto L_0x081e
        L_0x038c:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0396
            goto L_0x0090
        L_0x0396:
            r1 = 84
            goto L_0x081e
        L_0x039a:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a4
            goto L_0x0090
        L_0x03a4:
            r1 = 83
            goto L_0x081e
        L_0x03a8:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b2
            goto L_0x0090
        L_0x03b2:
            r1 = 82
            goto L_0x081e
        L_0x03b6:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c0
            goto L_0x0090
        L_0x03c0:
            r1 = 81
            goto L_0x081e
        L_0x03c4:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ce
            goto L_0x0090
        L_0x03ce:
            r1 = 80
            goto L_0x081e
        L_0x03d2:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03dc
            goto L_0x0090
        L_0x03dc:
            r1 = 79
            goto L_0x081e
        L_0x03e0:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ea
            goto L_0x0090
        L_0x03ea:
            r1 = 78
            goto L_0x081e
        L_0x03ee:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03f8
            goto L_0x0090
        L_0x03f8:
            r1 = 77
            goto L_0x081e
        L_0x03fc:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0406
            goto L_0x0090
        L_0x0406:
            r1 = 76
            goto L_0x081e
        L_0x040a:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0414
            goto L_0x0090
        L_0x0414:
            r1 = 75
            goto L_0x081e
        L_0x0418:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0422
            goto L_0x0090
        L_0x0422:
            r1 = 74
            goto L_0x081e
        L_0x0426:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0430
            goto L_0x0090
        L_0x0430:
            r1 = 73
            goto L_0x081e
        L_0x0434:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x043e
            goto L_0x0090
        L_0x043e:
            r1 = 72
            goto L_0x081e
        L_0x0442:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x044c
            goto L_0x0090
        L_0x044c:
            r1 = 71
            goto L_0x081e
        L_0x0450:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045a
            goto L_0x0090
        L_0x045a:
            r1 = 70
            goto L_0x081e
        L_0x045e:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0468
            goto L_0x0090
        L_0x0468:
            r1 = 69
            goto L_0x081e
        L_0x046c:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0476
            goto L_0x0090
        L_0x0476:
            r1 = 68
            goto L_0x081e
        L_0x047a:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0484
            goto L_0x0090
        L_0x0484:
            r1 = 67
            goto L_0x081e
        L_0x0488:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0492
            goto L_0x0090
        L_0x0492:
            r1 = 66
            goto L_0x081e
        L_0x0496:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a0
            goto L_0x0090
        L_0x04a0:
            r1 = 65
            goto L_0x081e
        L_0x04a4:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ae
            goto L_0x0090
        L_0x04ae:
            r1 = 64
            goto L_0x081e
        L_0x04b2:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04bc
            goto L_0x0090
        L_0x04bc:
            r1 = 63
            goto L_0x081e
        L_0x04c0:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ca
            goto L_0x0090
        L_0x04ca:
            r1 = 62
            goto L_0x081e
        L_0x04ce:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04d8
            goto L_0x0090
        L_0x04d8:
            r1 = 61
            goto L_0x081e
        L_0x04dc:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e6
            goto L_0x0090
        L_0x04e6:
            r1 = 60
            goto L_0x081e
        L_0x04ea:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f4
            goto L_0x0090
        L_0x04f4:
            r1 = 59
            goto L_0x081e
        L_0x04f8:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0502
            goto L_0x0090
        L_0x0502:
            r1 = 58
            goto L_0x081e
        L_0x0506:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0510
            goto L_0x0090
        L_0x0510:
            r1 = 57
            goto L_0x081e
        L_0x0514:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x051e
            goto L_0x0090
        L_0x051e:
            r1 = 56
            goto L_0x081e
        L_0x0522:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x052c
            goto L_0x0090
        L_0x052c:
            r1 = 55
            goto L_0x081e
        L_0x0530:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053a
            goto L_0x0090
        L_0x053a:
            r1 = 54
            goto L_0x081e
        L_0x053e:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0548
            goto L_0x0090
        L_0x0548:
            r1 = 53
            goto L_0x081e
        L_0x054c:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0556
            goto L_0x0090
        L_0x0556:
            r1 = 52
            goto L_0x081e
        L_0x055a:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0564
            goto L_0x0090
        L_0x0564:
            r1 = 51
            goto L_0x081e
        L_0x0568:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0572
            goto L_0x0090
        L_0x0572:
            r1 = 50
            goto L_0x081e
        L_0x0576:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0580
            goto L_0x0090
        L_0x0580:
            r1 = 49
            goto L_0x081e
        L_0x0584:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x058e
            goto L_0x0090
        L_0x058e:
            r1 = 48
            goto L_0x081e
        L_0x0592:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x059c
            goto L_0x0090
        L_0x059c:
            r1 = 47
            goto L_0x081e
        L_0x05a0:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05aa
            goto L_0x0090
        L_0x05aa:
            r1 = 46
            goto L_0x081e
        L_0x05ae:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05b8
            goto L_0x0090
        L_0x05b8:
            r1 = 45
            goto L_0x081e
        L_0x05bc:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c6
            goto L_0x0090
        L_0x05c6:
            r1 = 44
            goto L_0x081e
        L_0x05ca:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d4
            goto L_0x0090
        L_0x05d4:
            r1 = 43
            goto L_0x081e
        L_0x05d8:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e2
            goto L_0x0090
        L_0x05e2:
            r1 = 42
            goto L_0x081e
        L_0x05e6:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f0
            goto L_0x0090
        L_0x05f0:
            r1 = 41
            goto L_0x081e
        L_0x05f4:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05fe
            goto L_0x0090
        L_0x05fe:
            r1 = 40
            goto L_0x081e
        L_0x0602:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060c
            goto L_0x0090
        L_0x060c:
            r1 = 39
            goto L_0x081e
        L_0x0610:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061a
            goto L_0x0090
        L_0x061a:
            r1 = 38
            goto L_0x081e
        L_0x061e:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0628
            goto L_0x0090
        L_0x0628:
            r1 = 37
            goto L_0x081e
        L_0x062c:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0636
            goto L_0x0090
        L_0x0636:
            r1 = 36
            goto L_0x081e
        L_0x063a:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0644
            goto L_0x0090
        L_0x0644:
            r1 = 35
            goto L_0x081e
        L_0x0648:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0652
            goto L_0x0090
        L_0x0652:
            r1 = 34
            goto L_0x081e
        L_0x0656:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0660
            goto L_0x0090
        L_0x0660:
            r1 = 33
            goto L_0x081e
        L_0x0664:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x066e
            goto L_0x0090
        L_0x066e:
            r1 = 32
            goto L_0x081e
        L_0x0672:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067c
            goto L_0x0090
        L_0x067c:
            r1 = 31
            goto L_0x081e
        L_0x0680:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068a
            goto L_0x0090
        L_0x068a:
            r1 = 30
            goto L_0x081e
        L_0x068e:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0698
            goto L_0x0090
        L_0x0698:
            r1 = 29
            goto L_0x081e
        L_0x069c:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a6
            goto L_0x0090
        L_0x06a6:
            r1 = 28
            goto L_0x081e
        L_0x06aa:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b4
            goto L_0x0090
        L_0x06b4:
            r1 = 27
            goto L_0x081e
        L_0x06b8:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c2
            goto L_0x0090
        L_0x06c2:
            r1 = 26
            goto L_0x081e
        L_0x06c6:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d0
            goto L_0x0090
        L_0x06d0:
            r1 = 25
            goto L_0x081e
        L_0x06d4:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06de
            goto L_0x0090
        L_0x06de:
            r1 = 24
            goto L_0x081e
        L_0x06e2:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ec
            goto L_0x0090
        L_0x06ec:
            r1 = 23
            goto L_0x081e
        L_0x06f0:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fa
            goto L_0x0090
        L_0x06fa:
            r1 = 22
            goto L_0x081e
        L_0x06fe:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0708
            goto L_0x0090
        L_0x0708:
            r1 = 21
            goto L_0x081e
        L_0x070c:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0716
            goto L_0x0090
        L_0x0716:
            r1 = 20
            goto L_0x081e
        L_0x071a:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0724
            goto L_0x0090
        L_0x0724:
            r1 = 19
            goto L_0x081e
        L_0x0728:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0732
            goto L_0x0090
        L_0x0732:
            r1 = 18
            goto L_0x081e
        L_0x0736:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0740
            goto L_0x0090
        L_0x0740:
            r1 = 17
            goto L_0x081e
        L_0x0744:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x074e
            goto L_0x0090
        L_0x074e:
            r1 = 16
            goto L_0x081e
        L_0x0752:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075c
            goto L_0x0090
        L_0x075c:
            r1 = 15
            goto L_0x081e
        L_0x0760:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076a
            goto L_0x0090
        L_0x076a:
            r1 = 14
            goto L_0x081e
        L_0x076e:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0778
            goto L_0x0090
        L_0x0778:
            r1 = 13
            goto L_0x081e
        L_0x077c:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0786
            goto L_0x0090
        L_0x0786:
            r1 = 12
            goto L_0x081e
        L_0x078a:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0794
            goto L_0x0090
        L_0x0794:
            r1 = 11
            goto L_0x081e
        L_0x0798:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a2
            goto L_0x0090
        L_0x07a2:
            r1 = 10
            goto L_0x081e
        L_0x07a6:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b0
            goto L_0x0090
        L_0x07b0:
            r1 = 9
            goto L_0x081e
        L_0x07b4:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07be
            goto L_0x0090
        L_0x07be:
            r1 = 8
            goto L_0x081e
        L_0x07c1:
            java.lang.String r1 = "PGN528"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cb
            goto L_0x0090
        L_0x07cb:
            r1 = 7
            goto L_0x081e
        L_0x07cd:
            java.lang.String r2 = "NX573J"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x081e
            goto L_0x0090
        L_0x07d7:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e1
            goto L_0x0090
        L_0x07e1:
            r1 = 5
            goto L_0x081e
        L_0x07e3:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07ed
            goto L_0x0090
        L_0x07ed:
            r1 = 4
            goto L_0x081e
        L_0x07ef:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f9
            goto L_0x0090
        L_0x07f9:
            r1 = 3
            goto L_0x081e
        L_0x07fb:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0805
            goto L_0x0090
        L_0x0805:
            r1 = 2
            goto L_0x081e
        L_0x0807:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0811
            goto L_0x0090
        L_0x0811:
            r1 = 1
            goto L_0x081e
        L_0x0813:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x081d
            goto L_0x0090
        L_0x081d:
            r1 = 0
        L_0x081e:
            switch(r1) {
                case 0: goto L_0x0851;
                case 1: goto L_0x0851;
                case 2: goto L_0x0851;
                case 3: goto L_0x0851;
                case 4: goto L_0x0851;
                case 5: goto L_0x0851;
                case 6: goto L_0x0851;
                case 7: goto L_0x0851;
                case 8: goto L_0x0851;
                case 9: goto L_0x0851;
                case 10: goto L_0x0851;
                case 11: goto L_0x0851;
                case 12: goto L_0x0851;
                case 13: goto L_0x0851;
                case 14: goto L_0x0851;
                case 15: goto L_0x0851;
                case 16: goto L_0x0851;
                case 17: goto L_0x0851;
                case 18: goto L_0x0851;
                case 19: goto L_0x0851;
                case 20: goto L_0x0851;
                case 21: goto L_0x0851;
                case 22: goto L_0x0851;
                case 23: goto L_0x0851;
                case 24: goto L_0x0851;
                case 25: goto L_0x0851;
                case 26: goto L_0x0851;
                case 27: goto L_0x0851;
                case 28: goto L_0x0851;
                case 29: goto L_0x0851;
                case 30: goto L_0x0851;
                case 31: goto L_0x0851;
                case 32: goto L_0x0851;
                case 33: goto L_0x0851;
                case 34: goto L_0x0851;
                case 35: goto L_0x0851;
                case 36: goto L_0x0851;
                case 37: goto L_0x0851;
                case 38: goto L_0x0851;
                case 39: goto L_0x0851;
                case 40: goto L_0x0851;
                case 41: goto L_0x0851;
                case 42: goto L_0x0851;
                case 43: goto L_0x0851;
                case 44: goto L_0x0851;
                case 45: goto L_0x0851;
                case 46: goto L_0x0851;
                case 47: goto L_0x0851;
                case 48: goto L_0x0851;
                case 49: goto L_0x0851;
                case 50: goto L_0x0851;
                case 51: goto L_0x0851;
                case 52: goto L_0x0851;
                case 53: goto L_0x0851;
                case 54: goto L_0x0851;
                case 55: goto L_0x0851;
                case 56: goto L_0x0851;
                case 57: goto L_0x0851;
                case 58: goto L_0x0851;
                case 59: goto L_0x0851;
                case 60: goto L_0x0851;
                case 61: goto L_0x0851;
                case 62: goto L_0x0851;
                case 63: goto L_0x0851;
                case 64: goto L_0x0851;
                case 65: goto L_0x0851;
                case 66: goto L_0x0851;
                case 67: goto L_0x0851;
                case 68: goto L_0x0851;
                case 69: goto L_0x0851;
                case 70: goto L_0x0851;
                case 71: goto L_0x0851;
                case 72: goto L_0x0851;
                case 73: goto L_0x0851;
                case 74: goto L_0x0851;
                case 75: goto L_0x0851;
                case 76: goto L_0x0851;
                case 77: goto L_0x0851;
                case 78: goto L_0x0851;
                case 79: goto L_0x0851;
                case 80: goto L_0x0851;
                case 81: goto L_0x0851;
                case 82: goto L_0x0851;
                case 83: goto L_0x0851;
                case 84: goto L_0x0851;
                case 85: goto L_0x0851;
                case 86: goto L_0x0851;
                case 87: goto L_0x0851;
                case 88: goto L_0x0851;
                case 89: goto L_0x0851;
                case 90: goto L_0x0851;
                case 91: goto L_0x0851;
                case 92: goto L_0x0851;
                case 93: goto L_0x0851;
                case 94: goto L_0x0851;
                case 95: goto L_0x0851;
                case 96: goto L_0x0851;
                case 97: goto L_0x0851;
                case 98: goto L_0x0851;
                case 99: goto L_0x0851;
                case 100: goto L_0x0851;
                case 101: goto L_0x0851;
                case 102: goto L_0x0851;
                case 103: goto L_0x0851;
                case 104: goto L_0x0851;
                case 105: goto L_0x0851;
                case 106: goto L_0x0851;
                case 107: goto L_0x0851;
                case 108: goto L_0x0851;
                case 109: goto L_0x0851;
                case 110: goto L_0x0851;
                case 111: goto L_0x0851;
                case 112: goto L_0x0851;
                case 113: goto L_0x0851;
                case 114: goto L_0x0851;
                case 115: goto L_0x0851;
                case 116: goto L_0x0851;
                case 117: goto L_0x0851;
                case 118: goto L_0x0851;
                case 119: goto L_0x0851;
                case 120: goto L_0x0851;
                case 121: goto L_0x0851;
                case 122: goto L_0x0851;
                case 123: goto L_0x0851;
                case 124: goto L_0x0851;
                case 125: goto L_0x0851;
                case 126: goto L_0x0851;
                case 127: goto L_0x0851;
                case 128: goto L_0x0851;
                case 129: goto L_0x0851;
                case 130: goto L_0x0851;
                case 131: goto L_0x0851;
                case 132: goto L_0x0851;
                case 133: goto L_0x0851;
                case 134: goto L_0x0851;
                case 135: goto L_0x0851;
                case 136: goto L_0x0851;
                case 137: goto L_0x0851;
                case 138: goto L_0x0851;
                case 139: goto L_0x0851;
                default: goto L_0x0821;
            }
        L_0x0821:
            java.lang.String r0 = com.applovin.exoplayer2.l.ai.acY
            r0.hashCode()
            int r1 = r0.hashCode()
            switch(r1) {
                case -594534941: goto L_0x0843;
                case 2006354: goto L_0x0838;
                case 2006367: goto L_0x082f;
                default: goto L_0x082d;
            }
        L_0x082d:
            r5 = -1
            goto L_0x084d
        L_0x082f:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x084d
            goto L_0x082d
        L_0x0838:
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0841
            goto L_0x082d
        L_0x0841:
            r5 = 1
            goto L_0x084d
        L_0x0843:
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x084c
            goto L_0x082d
        L_0x084c:
            r5 = 0
        L_0x084d:
            switch(r5) {
                case 0: goto L_0x0851;
                case 1: goto L_0x0851;
                case 2: goto L_0x0851;
                default: goto L_0x0850;
            }
        L_0x0850:
            goto L_0x0852
        L_0x0851:
            return r8
        L_0x0852:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.m.h.qu():boolean");
    }

    private final class b implements Handler.Callback, g.c {
        private final Handler jS;

        public b(g gVar) {
            Handler a = ai.a((Handler.Callback) this);
            this.jS = a;
            gVar.a(this, a);
        }

        public void a(g gVar, long j, long j2) {
            if (ai.acV < 30) {
                this.jS.sendMessageAtFrontOfQueue(Message.obtain(this.jS, 0, (int) (j >> 32), (int) j));
                return;
            }
            bC(j);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            bC(ai.O(message.arg1, message.arg2));
            return true;
        }

        private void bC(long j) {
            if (this == h.this.aeq) {
                if (j == Long.MAX_VALUE) {
                    h.this.qj();
                    return;
                }
                try {
                    h.this.by(j);
                } catch (p e) {
                    h.this.b(e);
                }
            }
        }
    }
}
