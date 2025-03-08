package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.exoplayer2.c.b;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.d.n;
import com.applovin.exoplayer2.e;
import com.applovin.exoplayer2.f.a;
import com.applovin.exoplayer2.f.g;
import com.applovin.exoplayer2.f.l;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.l.af;
import com.applovin.exoplayer2.l.ah;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import com.google.android.gms.games.GamesStatusCodes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class j extends e {
    private static final byte[] Hz = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private final g.b HA;
    private final float HB;
    private final com.applovin.exoplayer2.c.g HC = com.applovin.exoplayer2.c.g.hf();
    private final com.applovin.exoplayer2.c.g HD = new com.applovin.exoplayer2.c.g(0);
    private final com.applovin.exoplayer2.c.g HE = new com.applovin.exoplayer2.c.g(2);
    private final d HF;
    private final af<v> HG;
    private final ArrayList<Long> HH;
    private final MediaCodec.BufferInfo HI;
    private final long[] HJ;
    private final long[] HK;
    private final long[] HL;
    private v HM;
    private f HN;
    private f HO;
    private MediaCrypto HP;
    private boolean HQ;
    private long HR;
    private float HS;
    private float HU;
    private g HV;
    private v HW;
    private MediaFormat HX;
    private boolean HY;
    private float HZ;
    private i Hk;
    private boolean IA;
    private boolean IB;
    private boolean IC;
    private long ID;
    private long IE;
    private boolean IF;
    private boolean IG;
    private boolean IH;
    private boolean II;
    private boolean IJ;
    private p IK;
    protected com.applovin.exoplayer2.c.e IL;
    private long IM;
    private long IN;
    private int IO;
    private ArrayDeque<i> Ia;
    private a Ib;
    private int Ic;
    private boolean Id;
    private boolean Ie;
    private boolean If;
    private boolean Ig;
    private boolean Ih;
    private boolean Ii;
    private boolean Ij;
    private boolean Ik;
    private boolean Il;
    private boolean Im;
    private e In;
    private long Io;
    private int Ip;
    private int Iq;
    private boolean Ir;
    private boolean Is;
    private boolean It;
    private boolean Iu;
    private boolean Iv;
    private boolean Iw;
    private int Ix;
    private int Iy;
    private int Iz;
    private final boolean bf;
    private final k bg;
    private boolean bi;
    private boolean bj;
    private ByteBuffer kT;
    private v lS;

    private boolean kj() {
        return this.Iq >= 0;
    }

    private void kl() {
        this.Iq = -1;
        this.kT = null;
    }

    private boolean ko() {
        if (this.IA) {
            this.Iy = 1;
            if (this.Ie || this.Ig) {
                this.Iz = 3;
                return false;
            }
            this.Iz = 1;
        }
        return true;
    }

    public void M(boolean z) {
        this.IJ = z;
    }

    public void N(boolean z) {
        this.bi = z;
    }

    public void O(boolean z) {
        this.bj = z;
    }

    public final int Z() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public float a(float f, v vVar, v[] vVarArr) {
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public abstract int a(k kVar, v vVar) throws l.b;

    /* access modifiers changed from: protected */
    public abstract g.a a(i iVar, v vVar, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List<i> a(k kVar, v vVar, boolean z) throws l.b;

    /* access modifiers changed from: protected */
    public void a(com.applovin.exoplayer2.c.g gVar) throws p {
    }

    /* access modifiers changed from: protected */
    public void a(v vVar, MediaFormat mediaFormat) throws p {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(long j, long j2, g gVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, v vVar) throws p;

    /* access modifiers changed from: protected */
    public boolean a(i iVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void aa() {
    }

    /* access modifiers changed from: protected */
    public void ab() {
    }

    /* access modifiers changed from: protected */
    public final void b(p pVar) {
        this.IK = pVar;
    }

    public boolean cR() {
        return this.IG;
    }

    /* access modifiers changed from: protected */
    public void e(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void eB() {
    }

    /* access modifiers changed from: protected */
    public void eC() throws p {
    }

    /* access modifiers changed from: protected */
    public void f(com.applovin.exoplayer2.c.g gVar) throws p {
    }

    /* access modifiers changed from: protected */
    public boolean f(v vVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void i(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public boolean jY() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final g jZ() {
        return this.HV;
    }

    /* access modifiers changed from: protected */
    public final MediaFormat ka() {
        return this.HX;
    }

    /* access modifiers changed from: protected */
    public final i kb() {
        return this.Hk;
    }

    /* access modifiers changed from: protected */
    public float kn() {
        return this.HS;
    }

    /* access modifiers changed from: protected */
    public final void kt() {
        this.II = true;
    }

    /* access modifiers changed from: protected */
    public final long ku() {
        return this.IN;
    }

    /* access modifiers changed from: protected */
    public void v(String str) {
    }

    public static class a extends Exception {
        public final i Hk;
        public final String Hq;
        public final boolean IP;
        public final a IQ;
        public final String eg;

        public a(v vVar, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + vVar, th, vVar.dz, z, (i) null, cV(i), (a) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(v vVar, Throwable th, boolean z, i iVar) {
            this("Decoder init failed: " + iVar.name + ", " + vVar, th, vVar.dz, z, iVar, ai.acV >= 21 ? g(th) : null, (a) null);
        }

        private a(String str, Throwable th, String str2, boolean z, i iVar, String str3, a aVar) {
            super(str, th);
            this.eg = str2;
            this.IP = z;
            this.Hk = iVar;
            this.Hq = str3;
            this.IQ = aVar;
        }

        /* access modifiers changed from: private */
        public a a(a aVar) {
            return new a(getMessage(), getCause(), this.eg, this.IP, this.Hk, this.Hq, aVar);
        }

        private static String g(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String cV(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.applovin.exoplayer2.mediacodec.MediaCodecRenderer_" + str + Math.abs(i);
        }
    }

    public j(int i, g.b bVar, k kVar, boolean z, float f) {
        super(i);
        this.HA = bVar;
        this.bg = (k) com.applovin.exoplayer2.l.a.checkNotNull(kVar);
        this.bf = z;
        this.HB = f;
        d dVar = new d();
        this.HF = dVar;
        this.HG = new af<>();
        this.HH = new ArrayList<>();
        this.HI = new MediaCodec.BufferInfo();
        this.HS = 1.0f;
        this.HU = 1.0f;
        this.HR = -9223372036854775807L;
        this.HJ = new long[10];
        this.HK = new long[10];
        this.HL = new long[10];
        this.IM = -9223372036854775807L;
        this.IN = -9223372036854775807L;
        dVar.by(0);
        dVar.rH.order(ByteOrder.nativeOrder());
        this.HZ = -1.0f;
        this.Ic = 0;
        this.Ix = 0;
        this.Ip = -1;
        this.Iq = -1;
        this.Io = -9223372036854775807L;
        this.ID = -9223372036854775807L;
        this.IE = -9223372036854775807L;
        this.Iy = 0;
        this.Iz = 0;
    }

    public final int b(v vVar) throws p {
        try {
            return a(this.bg, vVar);
        } catch (l.b e) {
            throw a((Throwable) e, vVar, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public final void jX() throws p {
        v vVar;
        if (this.HV == null && !this.It && (vVar = this.lS) != null) {
            if (this.HO != null || !f(vVar)) {
                d(this.HO);
                String str = this.lS.dz;
                f fVar = this.HN;
                if (fVar != null) {
                    if (this.HP == null) {
                        n e = e(fVar);
                        if (e != null) {
                            try {
                                this.HP = new MediaCrypto(e.ey, e.su);
                                this.HQ = !e.tp && this.HP.requiresSecureDecoderComponent(str);
                            } catch (MediaCryptoException e2) {
                                throw a((Throwable) e2, this.lS, 6006);
                            }
                        } else if (this.HN.ht() == null) {
                            return;
                        }
                    }
                    if (n.to) {
                        int P = this.HN.P();
                        if (P == 1) {
                            f.a aVar = (f.a) com.applovin.exoplayer2.l.a.checkNotNull(this.HN.ht());
                            throw a((Throwable) aVar, this.lS, aVar.errorCode);
                        } else if (P != 4) {
                            return;
                        }
                    }
                }
                try {
                    a(this.HP, this.HQ);
                } catch (a e3) {
                    throw a((Throwable) e3, this.lS, 4001);
                }
            } else {
                o(this.lS);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void aL(long j) throws p {
        v bp = this.HG.bp(j);
        if (bp == null && this.HY) {
            bp = this.HG.pollFirst();
        }
        if (bp != null) {
            this.HM = bp;
        } else if (!this.HY || this.HM == null) {
            return;
        }
        a(this.HM, this.HX);
        this.HY = false;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2) throws p {
        this.IL = new com.applovin.exoplayer2.c.e();
    }

    /* access modifiers changed from: protected */
    public void a(v[] vVarArr, long j, long j2) throws p {
        boolean z = true;
        if (this.IN == -9223372036854775807L) {
            if (this.IM != -9223372036854775807L) {
                z = false;
            }
            com.applovin.exoplayer2.l.a.checkState(z);
            this.IM = j;
            this.IN = j2;
            return;
        }
        int i = this.IO;
        if (i == this.HK.length) {
            q.h("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.HK[this.IO - 1]);
        } else {
            this.IO = i + 1;
        }
        long[] jArr = this.HJ;
        int i2 = this.IO;
        jArr[i2 - 1] = j;
        this.HK[i2 - 1] = j2;
        this.HL[i2 - 1] = this.ID;
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws p {
        this.IF = false;
        this.IG = false;
        this.II = false;
        if (this.It) {
            this.HF.clear();
            this.HE.clear();
            this.Iu = false;
        } else {
            ke();
        }
        if (this.HG.size() > 0) {
            this.IH = true;
        }
        this.HG.clear();
        int i = this.IO;
        if (i != 0) {
            this.IN = this.HK[i - 1];
            this.IM = this.HJ[i - 1];
            this.IO = 0;
        }
    }

    public void a(float f, float f2) throws p {
        this.HS = f;
        this.HU = f2;
        p(this.HW);
    }

    /* access modifiers changed from: protected */
    public void ac() {
        this.lS = null;
        this.IM = -9223372036854775807L;
        this.IN = -9223372036854775807L;
        this.IO = 0;
        kf();
    }

    /* access modifiers changed from: protected */
    public void ad() {
        try {
            kc();
            kd();
        } finally {
            c((f) null);
        }
    }

    private void kc() {
        this.Iv = false;
        this.HF.clear();
        this.HE.clear();
        this.Iu = false;
        this.It = false;
    }

    /* access modifiers changed from: protected */
    public void kd() {
        try {
            g gVar = this.HV;
            if (gVar != null) {
                gVar.release();
                this.IL.rw++;
                v(this.Hk.name);
            }
            this.HV = null;
            try {
                MediaCrypto mediaCrypto = this.HP;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.HP = null;
                d((f) null);
                ki();
            }
        } catch (Throwable th) {
            this.HV = null;
            MediaCrypto mediaCrypto2 = this.HP;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        } finally {
            this.HP = null;
            d((f) null);
            ki();
        }
    }

    public void g(long j, long j2) throws p {
        boolean z = false;
        if (this.II) {
            this.II = false;
            ks();
        }
        p pVar = this.IK;
        if (pVar == null) {
            try {
                if (this.IG) {
                    eC();
                } else if (this.lS != null || cU(2)) {
                    jX();
                    if (this.It) {
                        ah.bg("bypassRender");
                        while (u(j, j2)) {
                        }
                        ah.pV();
                    } else if (this.HV != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        ah.bg("drainAndFeed");
                        while (t(j, j2) && aM(elapsedRealtime)) {
                        }
                        while (km() && aM(elapsedRealtime)) {
                        }
                        ah.pV();
                    } else {
                        this.IL.ry += e(j);
                        cU(1);
                    }
                    this.IL.he();
                }
            } catch (IllegalStateException e) {
                if (b(e)) {
                    i(e);
                    if (ai.acV >= 21 && d(e)) {
                        z = true;
                    }
                    if (z) {
                        kd();
                    }
                    throw a((Throwable) a((Throwable) e, kb()), this.lS, z, (int) GamesStatusCodes.STATUS_SNAPSHOT_COMMIT_FAILED);
                }
                throw e;
            }
        } else {
            this.IK = null;
            throw pVar;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean ke() throws p {
        boolean kf = kf();
        if (kf) {
            jX();
        }
        return kf;
    }

    /* access modifiers changed from: protected */
    public boolean kf() {
        if (this.HV == null) {
            return false;
        }
        if (this.Iz == 3 || this.Ie || ((this.If && !this.IC) || (this.Ig && this.IB))) {
            kd();
            return true;
        }
        kg();
        return false;
    }

    private void kg() {
        try {
            this.HV.dI();
        } finally {
            kh();
        }
    }

    /* access modifiers changed from: protected */
    public void kh() {
        kk();
        kl();
        this.Io = -9223372036854775807L;
        this.IB = false;
        this.IA = false;
        this.Ik = false;
        this.Il = false;
        this.Ir = false;
        this.Is = false;
        this.HH.clear();
        this.ID = -9223372036854775807L;
        this.IE = -9223372036854775807L;
        e eVar = this.In;
        if (eVar != null) {
            eVar.Y();
        }
        this.Iy = 0;
        this.Iz = 0;
        this.Ix = this.Iw ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void ki() {
        kh();
        this.IK = null;
        this.In = null;
        this.Ia = null;
        this.Hk = null;
        this.HW = null;
        this.HX = null;
        this.HY = false;
        this.IC = false;
        this.HZ = -1.0f;
        this.Ic = 0;
        this.Id = false;
        this.Ie = false;
        this.If = false;
        this.Ig = false;
        this.Ih = false;
        this.Ii = false;
        this.Ij = false;
        this.Im = false;
        this.Iw = false;
        this.Ix = 0;
        this.HQ = false;
    }

    /* access modifiers changed from: protected */
    public h a(Throwable th, i iVar) {
        return new h(th, iVar);
    }

    private boolean cU(int i) throws p {
        w ae = ae();
        this.HC.clear();
        int a2 = a(ae, this.HC, i | 4);
        if (a2 == -5) {
            a(ae);
            return true;
        } else if (a2 != -4 || !this.HC.gY()) {
            return false;
        } else {
            this.IF = true;
            ks();
            return false;
        }
    }

    private void a(MediaCrypto mediaCrypto, boolean z) throws a {
        if (this.Ia == null) {
            try {
                List<i> P = P(z);
                ArrayDeque<i> arrayDeque = new ArrayDeque<>();
                this.Ia = arrayDeque;
                if (this.bf) {
                    arrayDeque.addAll(P);
                } else if (!P.isEmpty()) {
                    this.Ia.add(P.get(0));
                }
                this.Ib = null;
            } catch (l.b e) {
                throw new a(this.lS, (Throwable) e, z, -49998);
            }
        }
        if (!this.Ia.isEmpty()) {
            while (this.HV == null) {
                i peekFirst = this.Ia.peekFirst();
                if (a(peekFirst)) {
                    try {
                        a(peekFirst, mediaCrypto);
                    } catch (Exception e2) {
                        q.b("MediaCodecRenderer", "Failed to initialize decoder: " + peekFirst, e2);
                        this.Ia.removeFirst();
                        a aVar = new a(this.lS, (Throwable) e2, z, peekFirst);
                        i(aVar);
                        if (this.Ib == null) {
                            this.Ib = aVar;
                        } else {
                            this.Ib = this.Ib.a(aVar);
                        }
                        if (this.Ia.isEmpty()) {
                            throw this.Ib;
                        }
                    }
                } else {
                    return;
                }
            }
            this.Ia = null;
            return;
        }
        throw new a(this.lS, (Throwable) null, z, -49999);
    }

    private List<i> P(boolean z) throws l.b {
        List<i> a2 = a(this.bg, this.lS, z);
        if (a2.isEmpty() && z) {
            a2 = a(this.bg, this.lS, false);
            if (!a2.isEmpty()) {
                q.h("MediaCodecRenderer", "Drm session requires secure decoder for " + this.lS.dz + ", but no secure decoder available. Trying to proceed with " + a2 + ".");
            }
        }
        return a2;
    }

    private void o(v vVar) {
        kc();
        String str = vVar.dz;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.HF.cQ(32);
        } else {
            this.HF.cQ(1);
        }
        this.It = true;
    }

    private void a(i iVar, MediaCrypto mediaCrypto) throws Exception {
        float f;
        g gVar;
        String str = iVar.name;
        float f2 = -1.0f;
        if (ai.acV < 23) {
            f = -1.0f;
        } else {
            f = a(this.HU, this.lS, af());
        }
        if (f > this.HB) {
            f2 = f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ah.bg("createCodec:" + str);
        g.a a2 = a(iVar, this.lS, mediaCrypto, f2);
        if (!this.IJ || ai.acV < 23) {
            gVar = this.HA.b(a2);
        } else {
            gVar = new a.C0046a(M(), this.bi, this.bj).b(a2);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        this.HV = gVar;
        this.Hk = iVar;
        this.HZ = f2;
        this.HW = this.lS;
        this.Ic = R(str);
        this.Id = a(str, this.HW);
        this.Ie = Q(str);
        this.If = S(str);
        this.Ig = T(str);
        this.Ih = V(str);
        this.Ii = U(str);
        this.Ij = b(str, this.HW);
        boolean z = false;
        this.Im = b(iVar) || jY();
        if (gVar.jC()) {
            this.Iw = true;
            this.Ix = 1;
            if (this.Ic != 0) {
                z = true;
            }
            this.Ik = z;
        }
        if ("c2.android.mp3.decoder".equals(iVar.name)) {
            this.In = new e();
        }
        if (P() == 2) {
            this.Io = SystemClock.elapsedRealtime() + 1000;
        }
        this.IL.rv++;
        e(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
    }

    private boolean aM(long j) {
        return this.HR == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.HR;
    }

    private void kk() {
        this.Ip = -1;
        this.HD.rH = null;
    }

    private void c(f fVar) {
        f.CC.a(this.HO, fVar);
        this.HO = fVar;
    }

    private void d(f fVar) {
        f.CC.a(this.HN, fVar);
        this.HN = fVar;
    }

    private boolean km() throws p {
        g gVar = this.HV;
        if (gVar == null || this.Iy == 2 || this.IF) {
            return false;
        }
        if (this.Ip < 0) {
            int jD = gVar.jD();
            this.Ip = jD;
            if (jD < 0) {
                return false;
            }
            this.HD.rH = this.HV.cH(jD);
            this.HD.clear();
        }
        if (this.Iy == 1) {
            if (!this.Im) {
                this.IB = true;
                this.HV.a(this.Ip, 0, 0, 0, 4);
                kk();
            }
            this.Iy = 2;
            return false;
        } else if (this.Ik) {
            this.Ik = false;
            ByteBuffer byteBuffer = this.HD.rH;
            byte[] bArr = Hz;
            byteBuffer.put(bArr);
            this.HV.a(this.Ip, 0, bArr.length, 0, 0);
            kk();
            this.IA = true;
            return true;
        } else {
            if (this.Ix == 1) {
                for (int i = 0; i < this.HW.dB.size(); i++) {
                    this.HD.rH.put(this.HW.dB.get(i));
                }
                this.Ix = 2;
            }
            int position = this.HD.rH.position();
            w ae = ae();
            try {
                int a2 = a(ae, this.HD, 0);
                if (R()) {
                    this.IE = this.ID;
                }
                if (a2 == -3) {
                    return false;
                }
                if (a2 == -5) {
                    if (this.Ix == 2) {
                        this.HD.clear();
                        this.Ix = 1;
                    }
                    a(ae);
                    return true;
                } else if (this.HD.gY()) {
                    if (this.Ix == 2) {
                        this.HD.clear();
                        this.Ix = 1;
                    }
                    this.IF = true;
                    if (!this.IA) {
                        ks();
                        return false;
                    }
                    try {
                        if (!this.Im) {
                            this.IB = true;
                            this.HV.a(this.Ip, 0, 0, 0, 4);
                            kk();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw a((Throwable) e, this.lS, h.r(e.getErrorCode()));
                    }
                } else if (this.IA || this.HD.gZ()) {
                    boolean hg = this.HD.hg();
                    if (hg) {
                        this.HD.rG.bw(position);
                    }
                    if (this.Id && !hg) {
                        com.applovin.exoplayer2.l.v.m(this.HD.rH);
                        if (this.HD.rH.position() == 0) {
                            return true;
                        }
                        this.Id = false;
                    }
                    long j = this.HD.rJ;
                    e eVar = this.In;
                    if (eVar != null) {
                        j = eVar.a(this.lS, this.HD);
                        this.ID = Math.max(this.ID, this.In.k(this.lS));
                    }
                    long j2 = j;
                    if (this.HD.gX()) {
                        this.HH.add(Long.valueOf(j2));
                    }
                    if (this.IH) {
                        this.HG.a(j2, this.lS);
                        this.IH = false;
                    }
                    this.ID = Math.max(this.ID, j2);
                    this.HD.hh();
                    if (this.HD.ha()) {
                        f(this.HD);
                    }
                    a(this.HD);
                    if (hg) {
                        try {
                            this.HV.a(this.Ip, 0, this.HD.rG, j2, 0);
                        } catch (MediaCodec.CryptoException e2) {
                            throw a((Throwable) e2, this.lS, h.r(e2.getErrorCode()));
                        }
                    } else {
                        this.HV.a(this.Ip, 0, this.HD.rH.limit(), j2, 0);
                    }
                    kk();
                    this.IA = true;
                    this.Ix = 0;
                    this.IL.rx++;
                    return true;
                } else {
                    this.HD.clear();
                    if (this.Ix == 2) {
                        this.Ix = 1;
                    }
                    return true;
                }
            } catch (g.a e3) {
                i(e3);
                cU(0);
                kg();
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (kp() == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b2, code lost:
        if (kp() == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00cf, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00eb A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.exoplayer2.c.h a(com.applovin.exoplayer2.w r12) throws com.applovin.exoplayer2.p {
        /*
            r11 = this;
            r0 = 1
            r11.IH = r0
            com.applovin.exoplayer2.v r1 = r12.dU
            java.lang.Object r1 = com.applovin.exoplayer2.l.a.checkNotNull(r1)
            r5 = r1
            com.applovin.exoplayer2.v r5 = (com.applovin.exoplayer2.v) r5
            java.lang.String r1 = r5.dz
            if (r1 == 0) goto L_0x00ec
            com.applovin.exoplayer2.d.f r12 = r12.dT
            r11.c((com.applovin.exoplayer2.d.f) r12)
            r11.lS = r5
            boolean r12 = r11.It
            r1 = 0
            if (r12 == 0) goto L_0x001f
            r11.Iv = r0
            return r1
        L_0x001f:
            com.applovin.exoplayer2.f.g r12 = r11.HV
            if (r12 != 0) goto L_0x0029
            r11.Ia = r1
            r11.jX()
            return r1
        L_0x0029:
            com.applovin.exoplayer2.f.i r1 = r11.Hk
            com.applovin.exoplayer2.v r4 = r11.HW
            com.applovin.exoplayer2.d.f r2 = r11.HN
            com.applovin.exoplayer2.d.f r3 = r11.HO
            boolean r2 = r11.a((com.applovin.exoplayer2.f.i) r1, (com.applovin.exoplayer2.v) r5, (com.applovin.exoplayer2.d.f) r2, (com.applovin.exoplayer2.d.f) r3)
            if (r2 == 0) goto L_0x0046
            r11.kq()
            com.applovin.exoplayer2.c.h r12 = new com.applovin.exoplayer2.c.h
            java.lang.String r3 = r1.name
            r6 = 0
            r7 = 128(0x80, float:1.794E-43)
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x0046:
            com.applovin.exoplayer2.d.f r2 = r11.HO
            com.applovin.exoplayer2.d.f r3 = r11.HN
            r6 = 0
            if (r2 == r3) goto L_0x004f
            r2 = 1
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            if (r2 == 0) goto L_0x005b
            int r3 = com.applovin.exoplayer2.l.ai.acV
            r7 = 23
            if (r3 < r7) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r3 = 0
            goto L_0x005c
        L_0x005b:
            r3 = 1
        L_0x005c:
            com.applovin.exoplayer2.l.a.checkState(r3)
            com.applovin.exoplayer2.c.h r3 = r11.a((com.applovin.exoplayer2.f.i) r1, (com.applovin.exoplayer2.v) r4, (com.applovin.exoplayer2.v) r5)
            int r7 = r3.pZ
            r8 = 3
            if (r7 == 0) goto L_0x00d1
            r9 = 16
            r10 = 2
            if (r7 == r0) goto L_0x00b5
            if (r7 == r10) goto L_0x0089
            if (r7 != r8) goto L_0x0083
            boolean r0 = r11.p(r5)
            if (r0 != 0) goto L_0x0078
            goto L_0x00bb
        L_0x0078:
            r11.HW = r5
            if (r2 == 0) goto L_0x00d4
            boolean r0 = r11.kp()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x0083:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x0089:
            boolean r7 = r11.p(r5)
            if (r7 != 0) goto L_0x0090
            goto L_0x00bb
        L_0x0090:
            r11.Iw = r0
            r11.Ix = r0
            int r7 = r11.Ic
            if (r7 == r10) goto L_0x00a8
            if (r7 != r0) goto L_0x00a7
            int r7 = r5.dE
            int r9 = r4.dE
            if (r7 != r9) goto L_0x00a7
            int r7 = r5.height
            int r9 = r4.height
            if (r7 != r9) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r0 = 0
        L_0x00a8:
            r11.Ik = r0
            r11.HW = r5
            if (r2 == 0) goto L_0x00d4
            boolean r0 = r11.kp()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x00b5:
            boolean r0 = r11.p(r5)
            if (r0 != 0) goto L_0x00be
        L_0x00bb:
            r7 = 16
            goto L_0x00d5
        L_0x00be:
            r11.HW = r5
            if (r2 == 0) goto L_0x00c9
            boolean r0 = r11.kp()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x00c9:
            boolean r0 = r11.ko()
            if (r0 != 0) goto L_0x00d4
        L_0x00cf:
            r7 = 2
            goto L_0x00d5
        L_0x00d1:
            r11.kq()
        L_0x00d4:
            r7 = 0
        L_0x00d5:
            int r0 = r3.pZ
            if (r0 == 0) goto L_0x00eb
            com.applovin.exoplayer2.f.g r0 = r11.HV
            if (r0 != r12) goto L_0x00e1
            int r12 = r11.Iz
            if (r12 != r8) goto L_0x00eb
        L_0x00e1:
            com.applovin.exoplayer2.c.h r12 = new com.applovin.exoplayer2.c.h
            java.lang.String r3 = r1.name
            r6 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x00eb:
            return r3
        L_0x00ec:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.applovin.exoplayer2.p r12 = r11.a((java.lang.Throwable) r12, (com.applovin.exoplayer2.v) r5, (int) r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.j.a(com.applovin.exoplayer2.w):com.applovin.exoplayer2.c.h");
    }

    /* access modifiers changed from: protected */
    public void aN(long j) {
        while (true) {
            int i = this.IO;
            if (i != 0 && j >= this.HL[0]) {
                long[] jArr = this.HJ;
                this.IM = jArr[0];
                this.IN = this.HK[0];
                int i2 = i - 1;
                this.IO = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.HK;
                System.arraycopy(jArr2, 1, jArr2, 0, this.IO);
                long[] jArr3 = this.HL;
                System.arraycopy(jArr3, 1, jArr3, 0, this.IO);
                eB();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.c.h a(i iVar, v vVar, v vVar2) {
        return new com.applovin.exoplayer2.c.h(iVar.name, vVar, vVar2, 0, 1);
    }

    public boolean isReady() {
        return this.lS != null && (ai() || kj() || (this.Io != -9223372036854775807L && SystemClock.elapsedRealtime() < this.Io));
    }

    private boolean p(v vVar) throws p {
        if (!(ai.acV < 23 || this.HV == null || this.Iz == 3 || P() == 0)) {
            float a2 = a(this.HU, vVar, af());
            float f = this.HZ;
            if (f == a2) {
                return true;
            }
            if (a2 == -1.0f) {
                kq();
                return false;
            } else if (f == -1.0f && a2 <= this.HB) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", a2);
                this.HV.u(bundle);
                this.HZ = a2;
            }
        }
        return true;
    }

    private boolean kp() throws p {
        if (this.IA) {
            this.Iy = 1;
            if (this.Ie || this.Ig) {
                this.Iz = 3;
                return false;
            }
            this.Iz = 2;
        } else {
            kw();
        }
        return true;
    }

    private void kq() throws p {
        if (this.IA) {
            this.Iy = 1;
            this.Iz = 3;
            return;
        }
        kv();
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean t(long r20, long r22) throws com.applovin.exoplayer2.p {
        /*
            r19 = this;
            r15 = r19
            boolean r0 = r19.kj()
            r16 = 1
            r14 = 0
            if (r0 != 0) goto L_0x00ce
            boolean r0 = r15.Ih
            if (r0 == 0) goto L_0x0028
            boolean r0 = r15.IB
            if (r0 == 0) goto L_0x0028
            com.applovin.exoplayer2.f.g r0 = r15.HV     // Catch:{ IllegalStateException -> 0x001c }
            android.media.MediaCodec$BufferInfo r1 = r15.HI     // Catch:{ IllegalStateException -> 0x001c }
            int r0 = r0.a(r1)     // Catch:{ IllegalStateException -> 0x001c }
            goto L_0x0030
        L_0x001c:
            r19.ks()
            boolean r0 = r15.IG
            if (r0 == 0) goto L_0x0027
            r19.kd()
        L_0x0027:
            return r14
        L_0x0028:
            com.applovin.exoplayer2.f.g r0 = r15.HV
            android.media.MediaCodec$BufferInfo r1 = r15.HI
            int r0 = r0.a(r1)
        L_0x0030:
            if (r0 >= 0) goto L_0x004a
            r1 = -2
            if (r0 != r1) goto L_0x0039
            r19.kr()
            return r16
        L_0x0039:
            boolean r0 = r15.Im
            if (r0 == 0) goto L_0x0049
            boolean r0 = r15.IF
            if (r0 != 0) goto L_0x0046
            int r0 = r15.Iy
            r1 = 2
            if (r0 != r1) goto L_0x0049
        L_0x0046:
            r19.ks()
        L_0x0049:
            return r14
        L_0x004a:
            boolean r1 = r15.Il
            if (r1 == 0) goto L_0x0056
            r15.Il = r14
            com.applovin.exoplayer2.f.g r1 = r15.HV
            r1.l(r0, r14)
            return r16
        L_0x0056:
            android.media.MediaCodec$BufferInfo r1 = r15.HI
            int r1 = r1.size
            if (r1 != 0) goto L_0x0068
            android.media.MediaCodec$BufferInfo r1 = r15.HI
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0068
            r19.ks()
            return r14
        L_0x0068:
            r15.Iq = r0
            com.applovin.exoplayer2.f.g r1 = r15.HV
            java.nio.ByteBuffer r0 = r1.cI(r0)
            r15.kT = r0
            if (r0 == 0) goto L_0x0089
            android.media.MediaCodec$BufferInfo r1 = r15.HI
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.kT
            android.media.MediaCodec$BufferInfo r1 = r15.HI
            int r1 = r1.offset
            android.media.MediaCodec$BufferInfo r2 = r15.HI
            int r2 = r2.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x0089:
            boolean r0 = r15.Ii
            if (r0 == 0) goto L_0x00ae
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            long r0 = r0.presentationTimeUs
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00ae
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x00ae
            long r0 = r15.ID
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ae
            android.media.MediaCodec$BufferInfo r2 = r15.HI
            r2.presentationTimeUs = r0
        L_0x00ae:
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            long r0 = r0.presentationTimeUs
            boolean r0 = r15.aO(r0)
            r15.Ir = r0
            long r0 = r15.IE
            android.media.MediaCodec$BufferInfo r2 = r15.HI
            long r2 = r2.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00c4
            r0 = 1
            goto L_0x00c5
        L_0x00c4:
            r0 = 0
        L_0x00c5:
            r15.Is = r0
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            long r0 = r0.presentationTimeUs
            r15.aL(r0)
        L_0x00ce:
            boolean r0 = r15.Ih
            if (r0 == 0) goto L_0x010a
            boolean r0 = r15.IB
            if (r0 == 0) goto L_0x010a
            com.applovin.exoplayer2.f.g r5 = r15.HV     // Catch:{ IllegalStateException -> 0x00fc }
            java.nio.ByteBuffer r6 = r15.kT     // Catch:{ IllegalStateException -> 0x00fc }
            int r7 = r15.Iq     // Catch:{ IllegalStateException -> 0x00fc }
            android.media.MediaCodec$BufferInfo r0 = r15.HI     // Catch:{ IllegalStateException -> 0x00fc }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x00fc }
            r9 = 1
            android.media.MediaCodec$BufferInfo r0 = r15.HI     // Catch:{ IllegalStateException -> 0x00fc }
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00fc }
            boolean r12 = r15.Ir     // Catch:{ IllegalStateException -> 0x00fc }
            boolean r13 = r15.Is     // Catch:{ IllegalStateException -> 0x00fc }
            com.applovin.exoplayer2.v r3 = r15.HM     // Catch:{ IllegalStateException -> 0x00fc }
            r0 = r19
            r1 = r20
            r17 = r3
            r3 = r22
            r18 = 0
            r14 = r17
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x00fe }
            goto L_0x012b
        L_0x00fc:
            r18 = 0
        L_0x00fe:
            r19.ks()
            boolean r0 = r15.IG
            if (r0 == 0) goto L_0x0109
            r19.kd()
        L_0x0109:
            return r18
        L_0x010a:
            r18 = 0
            com.applovin.exoplayer2.f.g r5 = r15.HV
            java.nio.ByteBuffer r6 = r15.kT
            int r7 = r15.Iq
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            int r8 = r0.flags
            r9 = 1
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            long r10 = r0.presentationTimeUs
            boolean r12 = r15.Ir
            boolean r13 = r15.Is
            com.applovin.exoplayer2.v r14 = r15.HM
            r0 = r19
            r1 = r20
            r3 = r22
            boolean r0 = r0.a(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x012b:
            if (r0 == 0) goto L_0x0148
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            long r0 = r0.presentationTimeUs
            r15.aN(r0)
            android.media.MediaCodec$BufferInfo r0 = r15.HI
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x013e
            r14 = 1
            goto L_0x013f
        L_0x013e:
            r14 = 0
        L_0x013f:
            r19.kl()
            if (r14 != 0) goto L_0x0145
            return r16
        L_0x0145:
            r19.ks()
        L_0x0148:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.j.t(long, long):boolean");
    }

    private void kr() {
        this.IC = true;
        MediaFormat jE = this.HV.jE();
        if (this.Ic != 0 && jE.getInteger("width") == 32 && jE.getInteger("height") == 32) {
            this.Il = true;
            return;
        }
        if (this.Ij) {
            jE.setInteger("channel-count", 1);
        }
        this.HX = jE;
        this.HY = true;
    }

    private void ks() throws p {
        int i = this.Iz;
        if (i == 1) {
            kg();
        } else if (i == 2) {
            kg();
            kw();
        } else if (i != 3) {
            this.IG = true;
            eC();
        } else {
            kv();
        }
    }

    protected static boolean q(v vVar) {
        return vVar.dR == 0 || vVar.dR == 2;
    }

    private boolean a(i iVar, v vVar, f fVar, f fVar2) throws p {
        n e;
        boolean z;
        if (fVar == fVar2) {
            return false;
        }
        if (fVar2 == null || fVar == null || ai.acV < 23 || h.an.equals(fVar.hu()) || h.an.equals(fVar2.hu()) || (e = e(fVar2)) == null) {
            return true;
        }
        if (e.tp) {
            z = false;
        } else {
            z = fVar2.A(vVar.dz);
        }
        return !iVar.Hu && z;
    }

    private void kv() throws p {
        kd();
        jX();
    }

    private boolean aO(long j) {
        int size = this.HH.size();
        for (int i = 0; i < size; i++) {
            if (this.HH.get(i).longValue() == j) {
                this.HH.remove(i);
                return true;
            }
        }
        return false;
    }

    private void kw() throws p {
        try {
            this.HP.setMediaDrmSession(e(this.HO).su);
            d(this.HO);
            this.Iy = 0;
            this.Iz = 0;
        } catch (MediaCryptoException e) {
            throw a((Throwable) e, this.lS, 6006);
        }
    }

    private n e(f fVar) throws p {
        b hv = fVar.hv();
        if (hv == null || (hv instanceof n)) {
            return (n) hv;
        }
        throw a((Throwable) new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + hv), this.lS, (int) GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER);
    }

    private boolean u(long j, long j2) throws p {
        com.applovin.exoplayer2.l.a.checkState(!this.IG);
        if (this.HF.jS()) {
            if (!a(j, j2, (g) null, this.HF.rH, this.Iq, 0, this.HF.iI(), this.HF.jQ(), this.HF.gX(), this.HF.gY(), this.HM)) {
                return false;
            }
            aN(this.HF.jR());
            this.HF.clear();
        }
        if (this.IF) {
            this.IG = true;
            return false;
        }
        if (this.Iu) {
            com.applovin.exoplayer2.l.a.checkState(this.HF.d(this.HE));
            this.Iu = false;
        }
        if (this.Iv) {
            if (this.HF.jS()) {
                return true;
            }
            kc();
            this.Iv = false;
            jX();
            if (!this.It) {
                return false;
            }
        }
        kx();
        if (this.HF.jS()) {
            this.HF.hh();
        }
        return this.HF.jS() || this.IF || this.Iv;
    }

    private void kx() throws p {
        com.applovin.exoplayer2.l.a.checkState(!this.IF);
        w ae = ae();
        this.HE.clear();
        do {
            this.HE.clear();
            int a2 = a(ae, this.HE, 0);
            if (a2 == -5) {
                a(ae);
                return;
            } else if (a2 != -4) {
                if (a2 != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else if (this.HE.gY()) {
                this.IF = true;
                return;
            } else {
                if (this.IH) {
                    v vVar = (v) com.applovin.exoplayer2.l.a.checkNotNull(this.lS);
                    this.HM = vVar;
                    a(vVar, (MediaFormat) null);
                    this.IH = false;
                }
                this.HE.hh();
            }
        } while (this.HF.d(this.HE));
        this.Iu = true;
    }

    private static boolean b(IllegalStateException illegalStateException) {
        if (ai.acV >= 21 && c(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return false;
        }
        return true;
    }

    private static boolean c(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean d(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private static boolean Q(String str) {
        return ai.acV < 18 || (ai.acV == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (ai.acV == 19 && ai.acY.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int R(String str) {
        if (ai.acV <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (ai.acY.startsWith("SM-T585") || ai.acY.startsWith("SM-A510") || ai.acY.startsWith("SM-A520") || ai.acY.startsWith("SM-J700"))) {
            return 2;
        }
        if (ai.acV >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(ai.acW) || "flounder_lte".equals(ai.acW) || "grouper".equals(ai.acW) || "tilapia".equals(ai.acW)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean a(String str, v vVar) {
        return ai.acV < 21 && vVar.dB.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean S(String str) {
        return ai.acV == 29 && "c2.android.aac.decoder".equals(str);
    }

    private static boolean b(i iVar) {
        String str = iVar.name;
        return (ai.acV <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (ai.acV <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((ai.acV <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(ai.acX) && "AFTS".equals(ai.acY) && iVar.Hu));
    }

    private static boolean T(String str) {
        return (ai.acV <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (ai.acV <= 19 && (("hb2000".equals(ai.acW) || "stvm8".equals(ai.acW)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private static boolean U(String str) {
        return ai.acV < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(ai.acX) && (ai.acW.startsWith("baffin") || ai.acW.startsWith("grand") || ai.acW.startsWith("fortuna") || ai.acW.startsWith("gprimelte") || ai.acW.startsWith("j2y18lte") || ai.acW.startsWith("ms01"));
    }

    private static boolean V(String str) {
        return ai.acV == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, v vVar) {
        if (ai.acV > 18 || vVar.dL != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }
}
