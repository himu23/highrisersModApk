package com.applovin.exoplayer2.b;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda1;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.ay$$ExternalSyntheticApiModelOutline0;
import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.b.h;
import com.applovin.exoplayer2.b.j;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import com.google.android.gms.games.GamesStatusCodes;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public final class n implements h {
    public static boolean kX;
    private d N;
    private final boolean bk;
    private final boolean bl;
    private int hR;
    private float hS;
    private boolean hi;
    private ByteBuffer kT;
    private final e kY;
    private final a kZ;
    /* access modifiers changed from: private */
    public AudioTrack kc;
    private long lA;
    private f[] lB;
    private ByteBuffer[] lC;
    private ByteBuffer lD;
    private int lE;
    private byte[] lF;
    private int lG;
    private int lH;
    private boolean lI;
    private boolean lJ;
    /* access modifiers changed from: private */
    public boolean lK;
    private boolean lL;
    private k lM;
    /* access modifiers changed from: private */
    public long lN;
    private boolean lO;
    private boolean lP;
    private final m la;
    private final x lb;
    private final f[] lc;
    private final f[] ld;
    /* access modifiers changed from: private */
    public final ConditionVariable le;
    private final j lf;
    private final ArrayDeque<e> lg;
    private final int lh;
    private h li;
    private final f<h.b> lj;
    private final f<h.e> lk;
    /* access modifiers changed from: private */
    public h.c ll;
    private b lm;
    private b ln;
    private e lo;
    private e lp;
    private am lq;
    private ByteBuffer lr;
    private int ls;
    private long lt;
    private long lu;
    private long lv;
    private long lw;
    private int lx;
    private boolean ly;
    private boolean lz;

    public interface a {
        boolean H(boolean z);

        long U(long j);

        f[] ex();

        long ey();

        am f(am amVar);
    }

    private boolean et() {
        return this.kc != null;
    }

    public void a(h.c cVar) {
        this.ll = cVar;
    }

    public void dK() {
        this.ly = true;
    }

    public static final class d extends RuntimeException {
        private d(String str) {
            super(str);
        }
    }

    public static class c implements a {
        private final f[] lY;
        private final u lZ;
        private final w ma;

        public f[] ex() {
            return this.lY;
        }

        public c(f... fVarArr) {
            this(fVarArr, new u(), new w());
        }

        public c(f[] fVarArr, u uVar, w wVar) {
            f[] fVarArr2 = new f[(fVarArr.length + 2)];
            this.lY = fVarArr2;
            System.arraycopy(fVarArr, 0, fVarArr2, 0, fVarArr.length);
            this.lZ = uVar;
            this.ma = wVar;
            fVarArr2[fVarArr.length] = uVar;
            fVarArr2[fVarArr.length + 1] = wVar;
        }

        public am f(am amVar) {
            this.ma.l(amVar.gD);
            this.ma.m(amVar.gE);
            return amVar;
        }

        public boolean H(boolean z) {
            this.lZ.setEnabled(z);
            return z;
        }

        public long U(long j) {
            return this.ma.U(j);
        }

        public long ey() {
            return this.lZ.eM();
        }
    }

    public n(e eVar, a aVar, boolean z, boolean z2, int i) {
        this.kY = eVar;
        this.kZ = (a) com.applovin.exoplayer2.l.a.checkNotNull(aVar);
        this.bk = ai.acV >= 21 && z;
        this.bl = ai.acV >= 23 && z2;
        this.lh = ai.acV >= 29 ? i : 0;
        this.le = new ConditionVariable(true);
        this.lf = new j(new g());
        m mVar = new m();
        this.la = mVar;
        x xVar = new x();
        this.lb = xVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new l[]{new t(), mVar, xVar});
        Collections.addAll(arrayList, aVar.ex());
        this.lc = (f[]) arrayList.toArray(new f[0]);
        this.ld = new f[]{new p()};
        this.hS = 1.0f;
        this.N = d.jD;
        this.hR = 0;
        this.lM = new k(0, 0.0f);
        this.lp = new e(am.gC, false, 0, 0);
        this.lq = am.gC;
        this.lH = -1;
        this.lB = new f[0];
        this.lC = new ByteBuffer[0];
        this.lg = new ArrayDeque<>();
        this.lj = new f<>(100);
        this.lk = new f<>(100);
    }

    public boolean d(v vVar) {
        return e(vVar) != 0;
    }

    public int e(v vVar) {
        if (!"audio/raw".equals(vVar.dz)) {
            return ((this.lO || !a(vVar, this.N)) && !a(vVar, this.kY)) ? 0 : 2;
        }
        if (!ai.fJ(vVar.dN)) {
            q.h("DefaultAudioSink", "Invalid PCM encoding: " + vVar.dN);
            return 0;
        } else if (vVar.dN == 2 || (this.bk && vVar.dN == 4)) {
            return 2;
        } else {
            return 1;
        }
    }

    public long F(boolean z) {
        if (!et() || this.lz) {
            return Long.MIN_VALUE;
        }
        return T(S(Math.min(this.lf.F(z), this.ln.O(ev()))));
    }

    public void a(v vVar, int i, int[] iArr) throws h.a {
        f[] fVarArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr2;
        v vVar2 = vVar;
        if ("audio/raw".equals(vVar2.dz)) {
            com.applovin.exoplayer2.l.a.checkArgument(ai.fJ(vVar2.dN));
            int P = ai.P(vVar2.dN, vVar2.dL);
            f[] fVarArr2 = aB(vVar2.dN) ? this.ld : this.lc;
            this.lb.o(vVar2.dO, vVar2.dP);
            if (ai.acV < 21 && vVar2.dL == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i8 = 0; i8 < 6; i8++) {
                    iArr2[i8] = i8;
                }
            } else {
                iArr2 = iArr;
            }
            this.la.c(iArr2);
            f.a aVar = new f.a(vVar2.dM, vVar2.dL, vVar2.dN);
            int length = fVarArr2.length;
            int i9 = 0;
            while (i9 < length) {
                f fVar = fVarArr2[i9];
                try {
                    f.a a2 = fVar.a(aVar);
                    if (fVar.isActive()) {
                        aVar = a2;
                    }
                    i9++;
                } catch (f.b e2) {
                    throw new h.a((Throwable) e2, vVar);
                }
            }
            int i10 = aVar.jQ;
            i4 = aVar.dM;
            i3 = ai.fL(aVar.dL);
            fVarArr = fVarArr2;
            i2 = i10;
            i7 = P;
            i5 = ai.P(i10, aVar.dL);
            i6 = 0;
        } else {
            f[] fVarArr3 = new f[0];
            int i11 = vVar2.dM;
            i5 = -1;
            if (a(vVar, this.N)) {
                fVarArr = fVarArr3;
                i2 = u.k((String) com.applovin.exoplayer2.l.a.checkNotNull(vVar2.dz), vVar2.dw);
                i3 = ai.fL(vVar2.dL);
                i6 = 1;
            } else {
                Pair<Integer, Integer> b2 = b(vVar, this.kY);
                if (b2 != null) {
                    int intValue = ((Integer) b2.first).intValue();
                    fVarArr = fVarArr3;
                    i3 = ((Integer) b2.second).intValue();
                    i2 = intValue;
                    i6 = 2;
                } else {
                    throw new h.a("Unable to configure passthrough for: " + vVar, vVar);
                }
            }
            i4 = i11;
            i7 = -1;
        }
        if (i2 == 0) {
            throw new h.a("Invalid output encoding (mode=" + i6 + ") for: " + vVar, vVar);
        } else if (i3 != 0) {
            this.lO = false;
            b bVar = new b(vVar, i7, i6, i5, i4, i3, i2, i, this.bl, fVarArr);
            if (et()) {
                this.lm = bVar;
            } else {
                this.ln = bVar;
            }
        } else {
            throw new h.a("Invalid output channel config (mode=" + i6 + ") for: " + vVar, vVar);
        }
    }

    private void eh() {
        f[] fVarArr = this.ln.lX;
        ArrayList arrayList = new ArrayList();
        for (f fVar : fVarArr) {
            if (fVar.isActive()) {
                arrayList.add(fVar);
            } else {
                fVar.dI();
            }
        }
        int size = arrayList.size();
        this.lB = (f[]) arrayList.toArray(new f[size]);
        this.lC = new ByteBuffer[size];
        ei();
    }

    private void ei() {
        int i = 0;
        while (true) {
            f[] fVarArr = this.lB;
            if (i < fVarArr.length) {
                f fVar = fVarArr[i];
                fVar.dI();
                this.lC[i] = fVar.dH();
                i++;
            } else {
                return;
            }
        }
    }

    private void ej() throws h.b {
        this.le.block();
        AudioTrack ek = ek();
        this.kc = ek;
        if (b(ek)) {
            a(this.kc);
            if (this.lh != 3) {
                this.kc.setOffloadDelayPadding(this.ln.lS.dO, this.ln.lS.dP);
            }
        }
        this.hR = this.kc.getAudioSessionId();
        this.lf.a(this.kc, this.ln.lU == 2, this.ln.lW, this.ln.kj, this.ln.kk);
        eo();
        if (this.lM.kM != 0) {
            this.kc.attachAuxEffect(this.lM.kM);
            this.kc.setAuxEffectSendLevel(this.lM.kN);
        }
        this.lz = true;
    }

    public void dJ() {
        this.lK = true;
        if (et()) {
            this.lf.start();
            this.kc.play();
        }
    }

    public boolean a(ByteBuffer byteBuffer, long j, int i) throws h.b, h.e {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i2 = i;
        ByteBuffer byteBuffer3 = this.lD;
        com.applovin.exoplayer2.l.a.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (this.lm != null) {
            if (!em()) {
                return false;
            }
            if (!this.lm.a(this.ln)) {
                ew();
                if (dM()) {
                    return false;
                }
                dI();
            } else {
                this.ln = this.lm;
                this.lm = null;
                if (b(this.kc) && this.lh != 3) {
                    ay$$ExternalSyntheticApiModelOutline0.m(this.kc);
                    this.kc.setOffloadDelayPadding(this.ln.lS.dO, this.ln.lS.dP);
                    this.lP = true;
                }
            }
            R(j2);
        }
        if (!et()) {
            try {
                ej();
            } catch (h.b e2) {
                h.b bVar = e2;
                if (!bVar.by) {
                    this.lj.h(bVar);
                    return false;
                }
                throw bVar;
            }
        }
        this.lj.clear();
        if (this.lz) {
            this.lA = Math.max(0, j2);
            this.ly = false;
            this.lz = false;
            if (this.bl && ai.acV >= 23) {
                e(this.lq);
            }
            R(j2);
            if (this.lK) {
                dJ();
            }
        }
        if (!this.lf.H(ev())) {
            return false;
        }
        if (this.lD == null) {
            com.applovin.exoplayer2.l.a.checkArgument(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.ln.lU != 0 && this.lx == 0) {
                int a2 = a(this.ln.lW, byteBuffer2);
                this.lx = a2;
                if (a2 == 0) {
                    return true;
                }
            }
            if (this.lo != null) {
                if (!em()) {
                    return false;
                }
                R(j2);
                this.lo = null;
            }
            long V = this.lA + this.ln.V(eu() - this.lb.eR());
            if (!this.ly && Math.abs(V - j2) > 200000) {
                this.ll.b(new h.d(j2, V));
                this.ly = true;
            }
            if (this.ly) {
                if (!em()) {
                    return false;
                }
                long j3 = j2 - V;
                this.lA += j3;
                this.ly = false;
                R(j2);
                h.c cVar = this.ll;
                if (!(cVar == null || j3 == 0)) {
                    cVar.dQ();
                }
            }
            if (this.ln.lU == 0) {
                this.lt += (long) byteBuffer.remaining();
            } else {
                this.lu += (long) (this.lx * i2);
            }
            this.lD = byteBuffer2;
            this.lE = i2;
        }
        Q(j2);
        if (!this.lD.hasRemaining()) {
            this.lD = null;
            this.lE = 0;
            return true;
        } else if (!this.lf.K(ev())) {
            return false;
        } else {
            q.h("DefaultAudioSink", "Resetting stalled audio track");
            dI();
            return true;
        }
    }

    private AudioTrack ek() throws h.b {
        try {
            return ((b) com.applovin.exoplayer2.l.a.checkNotNull(this.ln)).a(this.hi, this.N, this.hR);
        } catch (h.b e2) {
            el();
            h.c cVar = this.ll;
            if (cVar != null) {
                cVar.b(e2);
            }
            throw e2;
        }
    }

    private void a(AudioTrack audioTrack) {
        if (this.li == null) {
            this.li = new h();
        }
        this.li.c(audioTrack);
    }

    private void Q(long j) throws h.e {
        ByteBuffer byteBuffer;
        int length = this.lB.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.lC[i - 1];
            } else {
                byteBuffer = this.lD;
                if (byteBuffer == null) {
                    byteBuffer = f.jO;
                }
            }
            if (i == length) {
                a(byteBuffer, j);
            } else {
                f fVar = this.lB[i];
                if (i > this.lH) {
                    fVar.d(byteBuffer);
                }
                ByteBuffer dH = fVar.dH();
                this.lC[i] = dH;
                if (dH.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private void a(ByteBuffer byteBuffer, long j) throws h.e {
        int i;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.kT;
            boolean z = true;
            if (byteBuffer2 != null) {
                com.applovin.exoplayer2.l.a.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.kT = byteBuffer;
                if (ai.acV < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.lF;
                    if (bArr == null || bArr.length < remaining) {
                        this.lF = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.lF, 0, remaining);
                    byteBuffer.position(position);
                    this.lG = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (ai.acV < 21) {
                int I = this.lf.I(this.lv);
                if (I > 0) {
                    i = this.kc.write(this.lF, this.lG, Math.min(remaining2, I));
                    if (i > 0) {
                        this.lG += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                } else {
                    i = 0;
                }
            } else if (this.hi) {
                com.applovin.exoplayer2.l.a.checkState(j != -9223372036854775807L);
                i = a(this.kc, byteBuffer, remaining2, j);
            } else {
                i = a(this.kc, byteBuffer, remaining2);
            }
            this.lN = SystemClock.elapsedRealtime();
            if (i < 0) {
                boolean aA = aA(i);
                if (aA) {
                    el();
                }
                h.e eVar = new h.e(i, this.ln.lS, aA);
                h.c cVar = this.ll;
                if (cVar != null) {
                    cVar.b(eVar);
                }
                if (!eVar.by) {
                    this.lk.h(eVar);
                    return;
                }
                throw eVar;
            }
            this.lk.clear();
            if (b(this.kc)) {
                long j2 = this.lw;
                if (j2 > 0) {
                    this.lP = false;
                }
                if (this.lK && this.ll != null && i < remaining2 && !this.lP) {
                    this.ll.F(this.lf.J(j2));
                }
            }
            if (this.ln.lU == 0) {
                this.lv += (long) i;
            }
            if (i == remaining2) {
                if (this.ln.lU != 0) {
                    if (byteBuffer != this.lD) {
                        z = false;
                    }
                    com.applovin.exoplayer2.l.a.checkState(z);
                    this.lw += (long) (this.lx * this.lE);
                }
                this.kT = null;
            }
        }
    }

    public void dL() throws h.e {
        if (!this.lI && et() && em()) {
            ew();
            this.lI = true;
        }
    }

    private void el() {
        if (this.ln.eA()) {
            this.lO = true;
        }
    }

    private static boolean aA(int i) {
        return (ai.acV >= 24 && i == -6) || i == -32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean em() throws com.applovin.exoplayer2.b.h.e {
        /*
            r9 = this;
            int r0 = r9.lH
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x000b
            r9.lH = r2
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.lH
            com.applovin.exoplayer2.b.f[] r5 = r9.lB
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.dG()
        L_0x001f:
            r9.Q(r7)
            boolean r0 = r4.cR()
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r9.lH
            int r0 = r0 + r1
            r9.lH = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.kT
            if (r0 == 0) goto L_0x003b
            r9.a((java.nio.ByteBuffer) r0, (long) r7)
            java.nio.ByteBuffer r0 = r9.kT
            if (r0 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r9.lH = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.b.n.em():boolean");
    }

    public boolean cR() {
        return !et() || (this.lI && !dM());
    }

    public boolean dM() {
        return et() && this.lf.M(ev());
    }

    public void a(am amVar) {
        am amVar2 = new am(ai.a(amVar.gD, 0.1f, 8.0f), ai.a(amVar.gE, 0.1f, 8.0f));
        if (!this.bl || ai.acV < 23) {
            b(amVar2, en());
        } else {
            e(amVar2);
        }
    }

    public am av() {
        return this.bl ? this.lq : eq();
    }

    public void G(boolean z) {
        b(eq(), z);
    }

    public boolean en() {
        return er().mb;
    }

    public void a(d dVar) {
        if (!this.N.equals(dVar)) {
            this.N = dVar;
            if (!this.hi) {
                dI();
            }
        }
    }

    public void aw(int i) {
        if (this.hR != i) {
            this.hR = i;
            this.lL = i != 0;
            dI();
        }
    }

    public void a(k kVar) {
        if (!this.lM.equals(kVar)) {
            int i = kVar.kM;
            float f2 = kVar.kN;
            if (this.kc != null) {
                if (this.lM.kM != i) {
                    this.kc.attachAuxEffect(i);
                }
                if (i != 0) {
                    this.kc.setAuxEffectSendLevel(f2);
                }
            }
            this.lM = kVar;
        }
    }

    public void dN() {
        com.applovin.exoplayer2.l.a.checkState(ai.acV >= 21);
        com.applovin.exoplayer2.l.a.checkState(this.lL);
        if (!this.hi) {
            this.hi = true;
            dI();
        }
    }

    public void dO() {
        if (this.hi) {
            this.hi = false;
            dI();
        }
    }

    public void h(float f2) {
        if (this.hS != f2) {
            this.hS = f2;
            eo();
        }
    }

    private void eo() {
        if (et()) {
            if (ai.acV >= 21) {
                a(this.kc, this.hS);
            } else {
                b(this.kc, this.hS);
            }
        }
    }

    public void pause() {
        this.lK = false;
        if (et() && this.lf.dY()) {
            this.kc.pause();
        }
    }

    public void dI() {
        if (et()) {
            ep();
            if (this.lf.v()) {
                this.kc.pause();
            }
            if (b(this.kc)) {
                ((h) com.applovin.exoplayer2.l.a.checkNotNull(this.li)).d(this.kc);
            }
            final AudioTrack audioTrack = this.kc;
            this.kc = null;
            if (ai.acV < 21 && !this.lL) {
                this.hR = 0;
            }
            b bVar = this.lm;
            if (bVar != null) {
                this.ln = bVar;
                this.lm = null;
            }
            this.lf.Y();
            this.le.close();
            new Thread("ExoPlayer:AudioTrackReleaseThread") {
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        n.this.le.open();
                    }
                }
            }.start();
        }
        this.lk.clear();
        this.lj.clear();
    }

    public void dP() {
        if (ai.acV < 25) {
            dI();
            return;
        }
        this.lk.clear();
        this.lj.clear();
        if (et()) {
            ep();
            if (this.lf.v()) {
                this.kc.pause();
            }
            this.kc.flush();
            this.lf.Y();
            this.lf.a(this.kc, this.ln.lU == 2, this.ln.lW, this.ln.kj, this.ln.kk);
            this.lz = true;
        }
    }

    public void Y() {
        dI();
        for (f Y : this.lc) {
            Y.Y();
        }
        for (f Y2 : this.ld) {
            Y2.Y();
        }
        this.lK = false;
        this.lO = false;
    }

    private void ep() {
        this.lt = 0;
        this.lu = 0;
        this.lv = 0;
        this.lw = 0;
        this.lP = false;
        this.lx = 0;
        this.lp = new e(eq(), en(), 0, 0);
        this.lA = 0;
        this.lo = null;
        this.lg.clear();
        this.lD = null;
        this.lE = 0;
        this.kT = null;
        this.lJ = false;
        this.lI = false;
        this.lH = -1;
        this.lr = null;
        this.ls = 0;
        this.lb.eQ();
        ei();
    }

    private void e(am amVar) {
        if (et()) {
            try {
                this.kc.setPlaybackParams(ay$$ExternalSyntheticApiModelOutline0.m(ay$$ExternalSyntheticApiModelOutline0.m()).setSpeed(amVar.gD).setPitch(amVar.gE).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                q.b("DefaultAudioSink", "Failed to set playback params", e2);
            }
            amVar = new am(ay$$ExternalSyntheticApiModelOutline0.m(ay$$ExternalSyntheticApiModelOutline0.m(this.kc)), ay$$ExternalSyntheticApiModelOutline0.m(this.kc).getPitch());
            this.lf.i(amVar.gD);
        }
        this.lq = amVar;
    }

    private void b(am amVar, boolean z) {
        e er = er();
        if (!amVar.equals(er.gy) || z != er.mb) {
            e eVar = new e(amVar, z, -9223372036854775807L, -9223372036854775807L);
            if (et()) {
                this.lo = eVar;
            } else {
                this.lp = eVar;
            }
        }
    }

    private am eq() {
        return er().gy;
    }

    private e er() {
        e eVar = this.lo;
        if (eVar != null) {
            return eVar;
        }
        return !this.lg.isEmpty() ? this.lg.getLast() : this.lp;
    }

    private void R(long j) {
        am amVar;
        if (es()) {
            amVar = this.kZ.f(eq());
        } else {
            amVar = am.gC;
        }
        am amVar2 = amVar;
        boolean H = es() ? this.kZ.H(en()) : false;
        this.lg.add(new e(amVar2, H, Math.max(0, j), this.ln.O(ev())));
        eh();
        h.c cVar = this.ll;
        if (cVar != null) {
            cVar.A(H);
        }
    }

    private boolean es() {
        return !this.hi && "audio/raw".equals(this.ln.lS.dz) && !aB(this.ln.lS.dN);
    }

    private boolean aB(int i) {
        return this.bk && ai.fK(i);
    }

    private long S(long j) {
        while (!this.lg.isEmpty() && j >= this.lg.getFirst().md) {
            this.lp = this.lg.remove();
        }
        long j2 = j - this.lp.md;
        if (this.lp.gy.equals(am.gC)) {
            return this.lp.mc + j2;
        }
        if (this.lg.isEmpty()) {
            return this.lp.mc + this.kZ.U(j2);
        }
        e first = this.lg.getFirst();
        return first.mc - ai.a(first.md - j, this.lp.gy.gD);
    }

    private long T(long j) {
        return j + this.ln.O(this.kZ.ey());
    }

    /* access modifiers changed from: private */
    public long eu() {
        return this.ln.lU == 0 ? this.lt / ((long) this.ln.lT) : this.lu;
    }

    /* access modifiers changed from: private */
    public long ev() {
        return this.ln.lU == 0 ? this.lv / ((long) this.ln.kj) : this.lw;
    }

    private static boolean a(v vVar, e eVar) {
        return b(vVar, eVar) != null;
    }

    private static Pair<Integer, Integer> b(v vVar, e eVar) {
        if (eVar == null) {
            return null;
        }
        int k = u.k((String) com.applovin.exoplayer2.l.a.checkNotNull(vVar.dz), vVar.dw);
        int i = 6;
        if (k != 5 && k != 6 && k != 18 && k != 17 && k != 7 && k != 8 && k != 14) {
            return null;
        }
        if (k == 18 && !eVar.av(18)) {
            k = 6;
        } else if (k == 8 && !eVar.av(8)) {
            k = 7;
        }
        if (!eVar.av(k)) {
            return null;
        }
        if (k != 18) {
            i = vVar.dL;
            if (i > eVar.dC()) {
                return null;
            }
        } else if (ai.acV >= 29 && (i = k(18, vVar.dM)) == 0) {
            q.h("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
            return null;
        }
        int aC = aC(i);
        if (aC == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(k), Integer.valueOf(aC));
    }

    private static int k(int i, int i2) {
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i3 = 8; i3 > 0; i3--) {
            if (ay$$ExternalSyntheticApiModelOutline0.m(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(ai.fL(i3)).build(), build)) {
                return i3;
            }
        }
        return 0;
    }

    private static int aC(int i) {
        if (ai.acV <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (ai.acV <= 26 && "fugu".equals(ai.acW) && i == 1) {
            i = 2;
        }
        return ai.fL(i);
    }

    private boolean a(v vVar, d dVar) {
        int k;
        int fL;
        int a2;
        if (ai.acV < 29 || this.lh == 0 || (k = u.k((String) com.applovin.exoplayer2.l.a.checkNotNull(vVar.dz), vVar.dw)) == 0 || (fL = ai.fL(vVar.dL)) == 0 || (a2 = a(c(vVar.dM, fL, k), dVar.dA())) == 0) {
            return false;
        }
        if (a2 == 1) {
            boolean z = (vVar.dO == 0 && vVar.dP == 0) ? false : true;
            boolean z2 = this.lh == 1;
            if (!z || !z2) {
                return true;
            }
            return false;
        } else if (a2 == 2) {
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    private int a(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        if (ai.acV >= 31) {
            return ay$$ExternalSyntheticApiModelOutline0.m(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        return (ai.acV != 30 || !ai.acY.startsWith("Pixel")) ? 1 : 2;
    }

    private static boolean b(AudioTrack audioTrack) {
        return ai.acV >= 29 && ay$$ExternalSyntheticApiModelOutline0.m(audioTrack);
    }

    /* access modifiers changed from: private */
    public static int aD(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED;
            case 14:
                return 3062500;
            case 15:
                return GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY;
            case 16:
                return 256000;
            case 17:
                return 336000;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static int a(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return b.a(byteBuffer);
            case 7:
            case 8:
                return o.e(byteBuffer);
            case 9:
                int aH = r.aH(ai.b(byteBuffer, byteBuffer.position()));
                if (aH != -1) {
                    return aH;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int b2 = b.b(byteBuffer);
                if (b2 == -1) {
                    return 0;
                }
                return b.a(byteBuffer, b2) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return c.c(byteBuffer);
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i);
        }
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (ai.acV >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.lr == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.lr = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.lr.putInt(1431633921);
        }
        if (this.ls == 0) {
            this.lr.putInt(4, i);
            this.lr.putLong(8, j * 1000);
            this.lr.position(0);
            this.ls = i;
        }
        int remaining = this.lr.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.lr, remaining, 1);
            if (write < 0) {
                this.ls = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.ls = 0;
            return a2;
        }
        this.ls -= a2;
        return a2;
    }

    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void ew() {
        if (!this.lJ) {
            this.lJ = true;
            this.lf.L(ev());
            this.kc.stop();
            this.ls = 0;
        }
    }

    private final class h {
        private final Handler jS = new Handler();
        private final AudioTrack.StreamEventCallback mh;

        public h() {
            this.mh = new AudioTrack.StreamEventCallback(n.this) {
                public void onDataRequest(AudioTrack audioTrack, int i) {
                    com.applovin.exoplayer2.l.a.checkState(audioTrack == n.this.kc);
                    if (n.this.ll != null && n.this.lK) {
                        n.this.ll.dR();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    com.applovin.exoplayer2.l.a.checkState(audioTrack == n.this.kc);
                    if (n.this.ll != null && n.this.lK) {
                        n.this.ll.dR();
                    }
                }
            };
        }

        public void c(AudioTrack audioTrack) {
            Handler handler = this.jS;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new ConcurrencyHelpers$$ExternalSyntheticLambda1(handler), this.mh);
        }

        public void d(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.mh);
            this.jS.removeCallbacksAndMessages((Object) null);
        }
    }

    private static final class e {
        public final am gy;
        public final boolean mb;
        public final long mc;
        public final long md;

        private e(am amVar, boolean z, long j, long j2) {
            this.gy = amVar;
            this.mb = z;
            this.mc = j;
            this.md = j2;
        }
    }

    /* access modifiers changed from: private */
    public static AudioFormat c(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private final class g implements j.a {
        private g() {
        }

        public void a(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + n.this.eu() + ", " + n.this.ev();
            if (!n.kX) {
                q.h("DefaultAudioSink", str);
                return;
            }
            throw new d(str);
        }

        public void b(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + n.this.eu() + ", " + n.this.ev();
            if (!n.kX) {
                q.h("DefaultAudioSink", str);
                return;
            }
            throw new d(str);
        }

        public void P(long j) {
            q.h("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
        }

        public void E(long j) {
            if (n.this.ll != null) {
                n.this.ll.E(j);
            }
        }

        public void c(int i, long j) {
            if (n.this.ll != null) {
                n.this.ll.e(i, j, SystemClock.elapsedRealtime() - n.this.lN);
            }
        }
    }

    private static final class b {
        public final int kj;
        public final int kk;
        public final int km;
        public final v lS;
        public final int lT;
        public final int lU;
        public final int lV;
        public final int lW;
        public final f[] lX;

        public boolean eA() {
            return this.lU == 1;
        }

        public b(v vVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, f[] fVarArr) {
            this.lS = vVar;
            this.lT = i;
            this.lU = i2;
            this.kj = i3;
            this.km = i4;
            this.lV = i5;
            this.lW = i6;
            this.lX = fVarArr;
            this.kk = g(i7, z);
        }

        public boolean a(b bVar) {
            return bVar.lU == this.lU && bVar.lW == this.lW && bVar.km == this.km && bVar.lV == this.lV && bVar.kj == this.kj;
        }

        public long V(long j) {
            return (j * 1000000) / ((long) this.lS.dM);
        }

        public long O(long j) {
            return (j * 1000000) / ((long) this.km);
        }

        public long W(long j) {
            return (j * ((long) this.km)) / 1000000;
        }

        public AudioTrack a(boolean z, d dVar, int i) throws h.b {
            try {
                AudioTrack b = b(z, dVar, i);
                int state = b.getState();
                if (state == 1) {
                    return b;
                }
                try {
                    b.release();
                } catch (Exception unused) {
                }
                throw new h.b(state, this.km, this.lV, this.kk, this.lS, eA(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new h.b(0, this.km, this.lV, this.kk, this.lS, eA(), e);
            }
        }

        private AudioTrack b(boolean z, d dVar, int i) {
            if (ai.acV >= 29) {
                return c(z, dVar, i);
            }
            if (ai.acV >= 21) {
                return d(z, dVar, i);
            }
            return a(dVar, i);
        }

        private AudioTrack c(boolean z, d dVar, int i) {
            AudioFormat d = n.c(this.km, this.lV, this.lW);
            AudioAttributes a = a(dVar, z);
            boolean z2 = true;
            AudioTrack.Builder m$2 = g$$ExternalSyntheticApiModelOutline0.m().setAudioAttributes(a).setAudioFormat(d).setTransferMode(1).setBufferSizeInBytes(this.kk).setSessionId(i);
            if (this.lU != 1) {
                z2 = false;
            }
            return m$2.setOffloadedPlayback(z2).build();
        }

        private AudioTrack d(boolean z, d dVar, int i) {
            return new AudioTrack(a(dVar, z), n.c(this.km, this.lV, this.lW), this.kk, 1, i);
        }

        private AudioTrack a(d dVar, int i) {
            int fM = ai.fM(dVar.jG);
            if (i == 0) {
                return new AudioTrack(fM, this.km, this.lV, this.lW, this.kk, 1);
            }
            return new AudioTrack(fM, this.km, this.lV, this.lW, this.kk, 1, i);
        }

        private int g(int i, boolean z) {
            if (i != 0) {
                return i;
            }
            int i2 = this.lU;
            if (i2 == 0) {
                return j(z ? 8.0f : 1.0f);
            } else if (i2 == 1) {
                return X(50000000);
            } else {
                if (i2 == 2) {
                    return X(250000);
                }
                throw new IllegalStateException();
            }
        }

        private int X(long j) {
            int aE = n.aD(this.lW);
            if (this.lW == 5) {
                aE *= 2;
            }
            return (int) ((j * ((long) aE)) / 1000000);
        }

        private int j(float f) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.km, this.lV, this.lW);
            com.applovin.exoplayer2.l.a.checkState(minBufferSize != -2);
            int k = ai.k(minBufferSize * 4, ((int) W(250000)) * this.kj, Math.max(minBufferSize, ((int) W(750000)) * this.kj));
            return f != 1.0f ? Math.round(((float) k) * f) : k;
        }

        private static AudioAttributes a(d dVar, boolean z) {
            if (z) {
                return ez();
            }
            return dVar.dA();
        }

        private static AudioAttributes ez() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
    }

    private static final class f<T extends Exception> {
        private final long me;
        private T mf;
        private long mg;

        public void clear() {
            this.mf = null;
        }

        public f(long j) {
            this.me = j;
        }

        public void h(T t) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mf == null) {
                this.mf = t;
                this.mg = this.me + elapsedRealtime;
            }
            if (elapsedRealtime >= this.mg) {
                T t2 = this.mf;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.mf;
                clear();
                throw t3;
            }
        }
    }
}
