package com.applovin.exoplayer2.b;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.ar;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.b.g;
import com.applovin.exoplayer2.b.h;
import com.applovin.exoplayer2.f.g;
import com.applovin.exoplayer2.f.i;
import com.applovin.exoplayer2.f.j;
import com.applovin.exoplayer2.f.k;
import com.applovin.exoplayer2.f.l;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.s;
import com.applovin.exoplayer2.l.t;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q extends j implements s {
    private final Context E;
    /* access modifiers changed from: private */
    public final g.a mo;
    private final h mp;
    private int mq;
    private boolean mr;
    private v ms;
    private long mt;
    private boolean mu;
    private boolean mv;
    private boolean mw;
    private boolean mx;
    /* access modifiers changed from: private */
    public ar.a my;

    public s O() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void dQ() {
        this.mv = true;
    }

    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    public q(Context context, k kVar, boolean z, Handler handler, g gVar, h hVar) {
        this(context, g.b.Hp, kVar, z, handler, gVar, hVar);
    }

    public q(Context context, g.b bVar, k kVar, boolean z, Handler handler, g gVar, h hVar) {
        super(1, bVar, kVar, z, 44100.0f);
        this.E = context.getApplicationContext();
        this.mp = hVar;
        this.mo = new g.a(handler, gVar);
        hVar.a((h.c) new a());
    }

    /* access modifiers changed from: protected */
    public int a(k kVar, v vVar) throws l.b {
        if (!u.aW(vVar.dz)) {
            return as.CC.ae(0);
        }
        int i = ai.acV >= 21 ? 32 : 0;
        boolean z = vVar.dR != 0;
        boolean q = q(vVar);
        int i2 = 8;
        int i3 = 4;
        if (q && this.mp.d(vVar) && (!z || l.ky() != null)) {
            return as.CC.a(4, 8, i);
        }
        if ("audio/raw".equals(vVar.dz) && !this.mp.d(vVar)) {
            return as.CC.ae(1);
        }
        if (!this.mp.d(ai.l(2, vVar.dL, vVar.dM))) {
            return as.CC.ae(1);
        }
        List<i> a2 = a(kVar, vVar, false);
        if (a2.isEmpty()) {
            return as.CC.ae(1);
        }
        if (!q) {
            return as.CC.ae(2);
        }
        i iVar = a2.get(0);
        boolean l = iVar.l(vVar);
        if (l && iVar.n(vVar)) {
            i2 = 16;
        }
        if (!l) {
            i3 = 3;
        }
        return as.CC.a(i3, i2, i);
    }

    /* access modifiers changed from: protected */
    public List<i> a(k kVar, v vVar, boolean z) throws l.b {
        i ky;
        String str = vVar.dz;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.mp.d(vVar) && (ky = l.ky()) != null) {
            return Collections.singletonList(ky);
        }
        List<i> a2 = l.a(kVar.getDecoderInfos(str, z, false), vVar);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(a2);
            arrayList.addAll(kVar.getDecoderInfos("audio/eac3", z, false));
            a2 = arrayList;
        }
        return Collections.unmodifiableList(a2);
    }

    /* access modifiers changed from: protected */
    public boolean f(v vVar) {
        return this.mp.d(vVar);
    }

    /* access modifiers changed from: protected */
    public g.a a(i iVar, v vVar, MediaCrypto mediaCrypto, float f) {
        this.mq = a(iVar, vVar, af());
        this.mr = x(iVar.name);
        MediaFormat a2 = a(vVar, iVar.Hr, this.mq, f);
        this.ms = (!"audio/raw".equals(iVar.eg) || "audio/raw".equals(vVar.dz)) ? null : vVar;
        return g.a.a(iVar, a2, vVar, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.c.h a(i iVar, v vVar, v vVar2) {
        int i;
        com.applovin.exoplayer2.c.h a2 = iVar.a(vVar, vVar2);
        int i2 = a2.rR;
        if (a(iVar, vVar2) > this.mq) {
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
    public float a(float f, v vVar, v[] vVarArr) {
        int i = -1;
        for (v vVar2 : vVarArr) {
            int i2 = vVar2.dM;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * ((float) i);
    }

    /* access modifiers changed from: protected */
    public void e(String str, long j, long j2) {
        this.mo.c(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public void v(String str) {
        this.mo.t(str);
    }

    /* access modifiers changed from: protected */
    public void i(Exception exc) {
        com.applovin.exoplayer2.l.q.c("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.mo.e(exc);
    }

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.c.h a(w wVar) throws p {
        com.applovin.exoplayer2.c.h a2 = super.a(wVar);
        this.mo.c(wVar.dU, a2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(v vVar, MediaFormat mediaFormat) throws p {
        int i;
        v vVar2 = this.ms;
        int[] iArr = null;
        if (vVar2 != null) {
            vVar = vVar2;
        } else if (jZ() != null) {
            if ("audio/raw".equals(vVar.dz)) {
                i = vVar.dN;
            } else if (ai.acV >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = ai.fI(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = "audio/raw".equals(vVar.dz) ? vVar.dN : 2;
            }
            v bT = new v.a().m("audio/raw").P(i).Q(vVar.dO).R(vVar.dP).N(mediaFormat.getInteger("channel-count")).O(mediaFormat.getInteger("sample-rate")).bT();
            if (this.mr && bT.dL == 6 && vVar.dL < 6) {
                iArr = new int[vVar.dL];
                for (int i2 = 0; i2 < vVar.dL; i2++) {
                    iArr[i2] = i2;
                }
            }
            vVar = bT;
        }
        try {
            this.mp.a(vVar, 0, iArr);
        } catch (h.a e) {
            throw a((Throwable) e, e.dU, (int) IronSourceConstants.errorCode_biddingDataException);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2) throws p {
        super.a(z, z2);
        this.mo.e(this.IL);
        if (ag().hi) {
            this.mp.dN();
        } else {
            this.mp.dO();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws p {
        super.a(j, z);
        if (this.mx) {
            this.mp.dP();
        } else {
            this.mp.dI();
        }
        this.mt = j;
        this.mu = true;
        this.mv = true;
    }

    /* access modifiers changed from: protected */
    public void aa() {
        super.aa();
        this.mp.dJ();
    }

    /* access modifiers changed from: protected */
    public void ab() {
        eD();
        this.mp.pause();
        super.ab();
    }

    /* access modifiers changed from: protected */
    public void ac() {
        this.mw = true;
        try {
            this.mp.dI();
            try {
                super.ac();
            } finally {
                this.mo.f(this.IL);
            }
        } catch (Throwable th) {
            super.ac();
            throw th;
        } finally {
            this.mo.f(this.IL);
        }
    }

    /* access modifiers changed from: protected */
    public void ad() {
        try {
            super.ad();
        } finally {
            if (this.mw) {
                this.mw = false;
                this.mp.Y();
            }
        }
    }

    public boolean cR() {
        return super.cR() && this.mp.cR();
    }

    public boolean isReady() {
        return this.mp.dM() || super.isReady();
    }

    public long au() {
        if (P() == 2) {
            eD();
        }
        return this.mt;
    }

    public void a(am amVar) {
        this.mp.a(amVar);
    }

    public am av() {
        return this.mp.av();
    }

    /* access modifiers changed from: protected */
    public void a(com.applovin.exoplayer2.c.g gVar) {
        if (this.mu && !gVar.gX()) {
            if (Math.abs(gVar.rJ - this.mt) > 500000) {
                this.mt = gVar.rJ;
            }
            this.mu = false;
        }
    }

    /* access modifiers changed from: protected */
    public void eB() {
        super.eB();
        this.mp.dK();
    }

    /* access modifiers changed from: protected */
    public boolean a(long j, long j2, com.applovin.exoplayer2.f.g gVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, v vVar) throws p {
        com.applovin.exoplayer2.l.a.checkNotNull(byteBuffer);
        if (this.ms != null && (i2 & 2) != 0) {
            ((com.applovin.exoplayer2.f.g) com.applovin.exoplayer2.l.a.checkNotNull(gVar)).l(i, false);
            return true;
        } else if (z) {
            if (gVar != null) {
                gVar.l(i, false);
            }
            this.IL.rA += i3;
            this.mp.dK();
            return true;
        } else {
            try {
                if (!this.mp.a(byteBuffer, j3, i3)) {
                    return false;
                }
                if (gVar != null) {
                    gVar.l(i, false);
                }
                this.IL.rz += i3;
                return true;
            } catch (h.b e) {
                throw a((Throwable) e, e.dU, e.by, (int) IronSourceConstants.errorCode_biddingDataException);
            } catch (h.e e2) {
                throw a((Throwable) e2, vVar, e2.by, (int) IronSourceConstants.errorCode_isReadyException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void eC() throws p {
        try {
            this.mp.dL();
        } catch (h.e e) {
            throw a((Throwable) e, e.dU, e.by, (int) IronSourceConstants.errorCode_isReadyException);
        }
    }

    public void a(int i, Object obj) throws p {
        if (i == 2) {
            this.mp.h(((Float) obj).floatValue());
        } else if (i == 3) {
            this.mp.a((d) obj);
        } else if (i != 6) {
            switch (i) {
                case 9:
                    this.mp.G(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.mp.aw(((Integer) obj).intValue());
                    return;
                case 11:
                    this.my = (ar.a) obj;
                    return;
                default:
                    super.a(i, obj);
                    return;
            }
        } else {
            this.mp.a((k) obj);
        }
    }

    /* access modifiers changed from: protected */
    public int a(i iVar, v vVar, v[] vVarArr) {
        int a2 = a(iVar, vVar);
        if (vVarArr.length == 1) {
            return a2;
        }
        for (v vVar2 : vVarArr) {
            if (iVar.a(vVar, vVar2).pZ != 0) {
                a2 = Math.max(a2, a(iVar, vVar2));
            }
        }
        return a2;
    }

    private int a(i iVar, v vVar) {
        if (!"OMX.google.raw.decoder".equals(iVar.name) || ai.acV >= 24 || (ai.acV == 23 && ai.isTv(this.E))) {
            return vVar.dA;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public MediaFormat a(v vVar, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", vVar.dL);
        mediaFormat.setInteger("sample-rate", vVar.dM);
        t.a(mediaFormat, vVar.dB);
        t.a(mediaFormat, "max-input-size", i);
        if (ai.acV >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !eE()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (ai.acV <= 28 && "audio/ac4".equals(vVar.dz)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (ai.acV >= 24 && this.mp.e(ai.l(4, vVar.dL, vVar.dM)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    private void eD() {
        long F = this.mp.F(cR());
        if (F != Long.MIN_VALUE) {
            if (!this.mv) {
                F = Math.max(this.mt, F);
            }
            this.mt = F;
            this.mv = false;
        }
    }

    private static boolean eE() {
        return ai.acV == 23 && ("ZTE B2017G".equals(ai.acY) || "AXON 7 mini".equals(ai.acY));
    }

    private static boolean x(String str) {
        return ai.acV < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(ai.acX) && (ai.acW.startsWith("zeroflte") || ai.acW.startsWith("herolte") || ai.acW.startsWith("heroqlte"));
    }

    private final class a implements h.c {
        private a() {
        }

        public void dQ() {
            q.this.dQ();
        }

        public void E(long j) {
            q.this.mo.C(j);
        }

        public void e(int i, long j, long j2) {
            q.this.mo.c(i, j, j2);
        }

        public void A(boolean z) {
            q.this.mo.D(z);
        }

        public void dR() {
            if (q.this.my != null) {
                q.this.my.bP();
            }
        }

        public void F(long j) {
            if (q.this.my != null) {
                q.this.my.o(j);
            }
        }

        public void b(Exception exc) {
            com.applovin.exoplayer2.l.q.c("MediaCodecAudioRenderer", "Audio sink error", exc);
            q.this.mo.d(exc);
        }
    }
}
