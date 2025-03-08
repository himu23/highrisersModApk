package com.applovin.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ao;
import com.applovin.exoplayer2.ay;
import com.applovin.exoplayer2.b;
import com.applovin.exoplayer2.b.d;
import com.applovin.exoplayer2.b.g;
import com.applovin.exoplayer2.c;
import com.applovin.exoplayer2.c.e;
import com.applovin.exoplayer2.e.f;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.r;
import com.applovin.exoplayer2.j.h;
import com.applovin.exoplayer2.j.j;
import com.applovin.exoplayer2.k;
import com.applovin.exoplayer2.k.n;
import com.applovin.exoplayer2.l.aa;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.g;
import com.applovin.exoplayer2.m.a.i;
import com.applovin.exoplayer2.m.n;
import com.applovin.exoplayer2.m.o;
import com.applovin.exoplayer2.q;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public class aw extends d implements q {
    private d N;
    protected final ar[] bB;
    /* access modifiers changed from: private */
    public final com.applovin.exoplayer2.a.a bM;
    private final bc hA;
    private final long hB;
    /* access modifiers changed from: private */
    public v hC;
    /* access modifiers changed from: private */
    public v hD;
    private AudioTrack hE;
    /* access modifiers changed from: private */
    public Object hF;
    private Surface hG;
    private SurfaceHolder hH;
    private i hI;
    /* access modifiers changed from: private */
    public boolean hJ;
    private TextureView hK;
    private int hL;
    private int hM;
    private int hN;
    private int hO;
    /* access modifiers changed from: private */
    public e hP;
    /* access modifiers changed from: private */
    public e hQ;
    private int hR;
    private float hS;
    /* access modifiers changed from: private */
    public boolean hT;
    /* access modifiers changed from: private */
    public List<com.applovin.exoplayer2.i.a> hU;
    private boolean hV;
    private boolean hW;
    /* access modifiers changed from: private */
    public aa hX;
    /* access modifiers changed from: private */
    public boolean hY;
    private boolean hZ;
    private final g hq;
    private final Context hr;
    /* access modifiers changed from: private */
    public final r hs;
    private final b ht;
    private final c hu;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<an.d> hv;
    private final b hw;
    private final c hx;
    /* access modifiers changed from: private */
    public final ay hy;
    private final bb hz;
    /* access modifiers changed from: private */
    public o ia;
    /* access modifiers changed from: private */
    public o ib;

    /* access modifiers changed from: private */
    public static int f(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public o aY() {
        return this.ib;
    }

    @Deprecated
    public static final class a {
        /* access modifiers changed from: private */
        public final Context E;
        /* access modifiers changed from: private */
        public d N;
        /* access modifiers changed from: private */
        public j bC;
        /* access modifiers changed from: private */
        public boolean bK;
        /* access modifiers changed from: private */
        public r bL;
        /* access modifiers changed from: private */
        public com.applovin.exoplayer2.a.a bM;
        /* access modifiers changed from: private */
        public com.applovin.exoplayer2.k.d bO;
        /* access modifiers changed from: private */
        public long bP;
        /* access modifiers changed from: private */
        public long bQ;
        /* access modifiers changed from: private */
        public com.applovin.exoplayer2.l.d bR;
        /* access modifiers changed from: private */
        public av bY;
        /* access modifiers changed from: private */
        public boolean bZ;
        /* access modifiers changed from: private */
        public aa cl;
        /* access modifiers changed from: private */
        public z ct;
        /* access modifiers changed from: private */
        public long cu;
        /* access modifiers changed from: private */
        public Looper gU;
        /* access modifiers changed from: private */
        public long hB;
        /* access modifiers changed from: private */
        public int hL;
        /* access modifiers changed from: private */
        public int hM;
        /* access modifiers changed from: private */
        public boolean hT;
        /* access modifiers changed from: private */
        public aa hX;
        /* access modifiers changed from: private */
        public final au ic;
        /* access modifiers changed from: private */
        public long id;
        /* access modifiers changed from: private */
        public boolean ie;
        /* access modifiers changed from: private */

        /* renamed from: if  reason: not valid java name */
        public int f4if;
        /* access modifiers changed from: private */
        public boolean ig;
        private boolean ih;

        @Deprecated
        public a(Context context) {
            this(context, new n(context), new f());
        }

        @Deprecated
        public a(Context context, au auVar, l lVar) {
            this(context, auVar, new com.applovin.exoplayer2.j.c(context), new com.applovin.exoplayer2.h.f(context, lVar), new l(), n.i(context), new com.applovin.exoplayer2.a.a(com.applovin.exoplayer2.l.d.abJ));
        }

        @Deprecated
        public a(Context context, au auVar, j jVar, r rVar, aa aaVar, com.applovin.exoplayer2.k.d dVar, com.applovin.exoplayer2.a.a aVar) {
            this.E = context;
            this.ic = auVar;
            this.bC = jVar;
            this.bL = rVar;
            this.cl = aaVar;
            this.bO = dVar;
            this.bM = aVar;
            this.gU = ai.pZ();
            this.N = d.jD;
            this.f4if = 0;
            this.hL = 1;
            this.hM = 0;
            this.bK = true;
            this.bY = av.hn;
            this.bP = 5000;
            this.bQ = 15000;
            this.ct = new k.a().ao();
            this.bR = com.applovin.exoplayer2.l.d.abJ;
            this.cu = 500;
            this.hB = 2000;
        }

        @Deprecated
        public aw cY() {
            com.applovin.exoplayer2.l.a.checkState(!this.ih);
            this.ih = true;
            return new aw(this);
        }
    }

    protected aw(a aVar) {
        aw awVar;
        g gVar = new g();
        this.hq = gVar;
        try {
            Context applicationContext = aVar.E.getApplicationContext();
            this.hr = applicationContext;
            com.applovin.exoplayer2.a.a b2 = aVar.bM;
            this.bM = b2;
            this.hX = aVar.hX;
            this.N = aVar.N;
            this.hL = aVar.hL;
            this.hM = aVar.hM;
            this.hT = aVar.hT;
            this.hB = aVar.hB;
            b bVar = new b();
            this.ht = bVar;
            c cVar = new c();
            this.hu = cVar;
            this.hv = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(aVar.gU);
            ar[] a2 = aVar.ic.a(handler, bVar, bVar, bVar, bVar);
            this.bB = a2;
            this.hS = 1.0f;
            if (ai.acV < 21) {
                this.hR = ah(0);
            } else {
                this.hR = h.c(applicationContext);
            }
            this.hU = Collections.emptyList();
            this.hV = true;
            g gVar2 = gVar;
            c cVar2 = cVar;
            Handler handler2 = handler;
            r rVar = r1;
            b bVar2 = bVar;
            try {
                r rVar2 = new r(a2, aVar.bC, aVar.bL, aVar.cl, aVar.bO, b2, aVar.bK, aVar.bY, aVar.bP, aVar.bQ, aVar.ct, aVar.cu, aVar.bZ, aVar.bR, aVar.gU, this, new an.a.C0030a().a(20, 21, 22, 23, 24, 25, 26, 27).cC());
                awVar = this;
                try {
                    awVar.hs = rVar;
                    b bVar3 = bVar2;
                    rVar.a((an.b) bVar3);
                    rVar.a((q.a) bVar3);
                    if (aVar.id > 0) {
                        rVar.j(aVar.id);
                    }
                    Handler handler3 = handler2;
                    b bVar4 = new b(aVar.E, handler3, bVar3);
                    awVar.hw = bVar4;
                    bVar4.setEnabled(aVar.ig);
                    c cVar3 = new c(aVar.E, handler3, bVar3);
                    awVar.hx = cVar3;
                    cVar3.a(aVar.ie ? awVar.N : null);
                    ay ayVar = new ay(aVar.E, handler3, bVar3);
                    awVar.hy = ayVar;
                    ayVar.aj(ai.fM(awVar.N.jG));
                    bb bbVar = new bb(aVar.E);
                    awVar.hz = bbVar;
                    bbVar.setEnabled(aVar.f4if != 0);
                    bc bcVar = new bc(aVar.E);
                    awVar.hA = bcVar;
                    bcVar.setEnabled(aVar.f4if == 2);
                    awVar.ia = a(ayVar);
                    awVar.ib = o.afk;
                    awVar.a(1, 10, (Object) Integer.valueOf(awVar.hR));
                    awVar.a(2, 10, (Object) Integer.valueOf(awVar.hR));
                    awVar.a(1, 3, (Object) awVar.N);
                    awVar.a(2, 4, (Object) Integer.valueOf(awVar.hL));
                    awVar.a(2, 5, (Object) Integer.valueOf(awVar.hM));
                    awVar.a(1, 9, (Object) Boolean.valueOf(awVar.hT));
                    c cVar4 = cVar2;
                    awVar.a(2, 7, (Object) cVar4);
                    awVar.a(6, 8, (Object) cVar4);
                    gVar2.oN();
                } catch (Throwable th) {
                    th = th;
                    awVar.hq.oN();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                awVar = this;
                awVar.hq.oN();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            awVar = this;
            awVar.hq.oN();
            throw th;
        }
    }

    public boolean ay() {
        cX();
        return this.hs.ay();
    }

    public void cS() {
        cX();
        cT();
        i((Object) null);
        g(0, 0);
    }

    public void a(SurfaceHolder surfaceHolder) {
        cX();
        if (surfaceHolder == null) {
            cS();
            return;
        }
        cT();
        this.hJ = true;
        this.hH = surfaceHolder;
        surfaceHolder.addCallback(this.ht);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            i((Object) null);
            g(0, 0);
            return;
        }
        i((Object) surface);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        g(surfaceFrame.width(), surfaceFrame.height());
    }

    public void b(SurfaceHolder surfaceHolder) {
        cX();
        if (surfaceHolder != null && surfaceHolder == this.hH) {
            cS();
        }
    }

    public void a(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        cX();
        if (surfaceView instanceof com.applovin.exoplayer2.m.k) {
            cT();
            i((Object) surfaceView);
            c(surfaceView.getHolder());
        } else if (surfaceView instanceof i) {
            cT();
            this.hI = (i) surfaceView;
            this.hs.a((ao.b) this.hu).ad(10000).h(this.hI).cM();
            this.hI.a(this.ht);
            i((Object) this.hI.getVideoSurface());
            c(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder = null;
            } else {
                surfaceHolder = surfaceView.getHolder();
            }
            a(surfaceHolder);
        }
    }

    public void b(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        cX();
        if (surfaceView == null) {
            surfaceHolder = null;
        } else {
            surfaceHolder = surfaceView.getHolder();
        }
        b(surfaceHolder);
    }

    public void a(TextureView textureView) {
        cX();
        if (textureView == null) {
            cS();
            return;
        }
        cT();
        this.hK = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            com.applovin.exoplayer2.l.q.h("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.ht);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            i((Object) null);
            g(0, 0);
            return;
        }
        a(surfaceTexture);
        g(textureView.getWidth(), textureView.getHeight());
    }

    public void b(TextureView textureView) {
        cX();
        if (textureView != null && textureView == this.hK) {
            cS();
        }
    }

    public void h(float f) {
        cX();
        float a2 = ai.a(f, 0.0f, 1.0f);
        if (this.hS != a2) {
            this.hS = a2;
            cU();
            this.bM.g(a2);
            Iterator<an.d> it = this.hv.iterator();
            while (it.hasNext()) {
                it.next().g(a2);
            }
        }
    }

    public List<com.applovin.exoplayer2.i.a> bd() {
        cX();
        return this.hU;
    }

    public Looper az() {
        return this.hs.az();
    }

    public void a(an.d dVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.hv.add(dVar);
        f((an.b) dVar);
    }

    @Deprecated
    public void f(an.b bVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(bVar);
        this.hs.a(bVar);
    }

    public void b(an.d dVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.hv.remove(dVar);
        g((an.b) dVar);
    }

    @Deprecated
    public void g(an.b bVar) {
        this.hs.b(bVar);
    }

    public int aB() {
        cX();
        return this.hs.aB();
    }

    public int aC() {
        cX();
        return this.hs.aC();
    }

    /* renamed from: aw */
    public p ax() {
        cX();
        return this.hs.ax();
    }

    public an.a aA() {
        cX();
        return this.hs.aA();
    }

    public void aD() {
        cX();
        boolean aE = aE();
        int a2 = this.hx.a(aE, 2);
        b(aE, a2, f(aE, a2));
        this.hs.aD();
    }

    public void a(p pVar) {
        cX();
        this.hs.a(pVar);
    }

    public void k(boolean z) {
        cX();
        int a2 = this.hx.a(z, aB());
        b(z, a2, f(z, a2));
    }

    public boolean aE() {
        cX();
        return this.hs.aE();
    }

    public int aF() {
        cX();
        return this.hs.aF();
    }

    public void u(int i) {
        cX();
        this.hs.u(i);
    }

    public void l(boolean z) {
        cX();
        this.hs.l(z);
    }

    public boolean aG() {
        cX();
        return this.hs.aG();
    }

    public void a(int i, long j) {
        cX();
        this.bM.dq();
        this.hs.a(i, j);
    }

    public long aH() {
        cX();
        return this.hs.aH();
    }

    public long aI() {
        cX();
        return this.hs.aI();
    }

    public long aJ() {
        cX();
        return this.hs.aJ();
    }

    public am av() {
        cX();
        return this.hs.av();
    }

    public void release() {
        AudioTrack audioTrack;
        cX();
        if (ai.acV < 21 && (audioTrack = this.hE) != null) {
            audioTrack.release();
            this.hE = null;
        }
        this.hw.setEnabled(false);
        this.hy.release();
        this.hz.C(false);
        this.hA.C(false);
        this.hx.release();
        this.hs.release();
        this.bM.release();
        cT();
        Surface surface = this.hG;
        if (surface != null) {
            surface.release();
            this.hG = null;
        }
        if (this.hY) {
            ((aa) com.applovin.exoplayer2.l.a.checkNotNull(this.hX)).fF(0);
            this.hY = false;
        }
        this.hU = Collections.emptyList();
        this.hZ = true;
    }

    public ad aU() {
        cX();
        return this.hs.aU();
    }

    public h aV() {
        cX();
        return this.hs.aV();
    }

    public ac aW() {
        return this.hs.aW();
    }

    public ba aX() {
        cX();
        return this.hs.aX();
    }

    public int aK() {
        cX();
        return this.hs.aK();
    }

    public int aL() {
        cX();
        return this.hs.aL();
    }

    public long aM() {
        cX();
        return this.hs.aM();
    }

    public long aN() {
        cX();
        return this.hs.aN();
    }

    public long aO() {
        cX();
        return this.hs.aO();
    }

    public boolean aP() {
        cX();
        return this.hs.aP();
    }

    public int aQ() {
        cX();
        return this.hs.aQ();
    }

    public int aR() {
        cX();
        return this.hs.aR();
    }

    public long aS() {
        cX();
        return this.hs.aS();
    }

    public long aT() {
        cX();
        return this.hs.aT();
    }

    private void cT() {
        if (this.hI != null) {
            this.hs.a((ao.b) this.hu).ad(10000).h((Object) null).cM();
            this.hI.b(this.ht);
            this.hI = null;
        }
        TextureView textureView = this.hK;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.ht) {
                com.applovin.exoplayer2.l.q.h("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.hK.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.hK = null;
        }
        SurfaceHolder surfaceHolder = this.hH;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.ht);
            this.hH = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        i((Object) surface);
        this.hG = surface;
    }

    /* access modifiers changed from: private */
    public void i(Object obj) {
        boolean z;
        ArrayList<ao> arrayList = new ArrayList<>();
        ar[] arVarArr = this.bB;
        int length = arVarArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            ar arVar = arVarArr[i];
            if (arVar.M() == 2) {
                arrayList.add(this.hs.a((ao.b) arVar).ad(1).h(obj).cM());
            }
            i++;
        }
        Object obj2 = this.hF;
        if (obj2 == null || obj2 == obj) {
            z = false;
        } else {
            try {
                for (ao y : arrayList) {
                    y.y(this.hB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.hF;
            Surface surface = this.hG;
            if (obj3 == surface) {
                surface.release();
                this.hG = null;
            }
        }
        this.hF = obj;
        if (z) {
            this.hs.a(false, p.a((RuntimeException) new u(3), 1003));
        }
    }

    private void c(SurfaceHolder surfaceHolder) {
        this.hJ = false;
        this.hH = surfaceHolder;
        surfaceHolder.addCallback(this.ht);
        Surface surface = this.hH.getSurface();
        if (surface == null || !surface.isValid()) {
            g(0, 0);
            return;
        }
        Rect surfaceFrame = this.hH.getSurfaceFrame();
        g(surfaceFrame.width(), surfaceFrame.height());
    }

    /* access modifiers changed from: private */
    public void g(int i, int i2) {
        if (i != this.hN || i2 != this.hO) {
            this.hN = i;
            this.hO = i2;
            this.bM.f(i, i2);
            Iterator<an.d> it = this.hv.iterator();
            while (it.hasNext()) {
                it.next().f(i, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void cU() {
        a(1, 2, (Object) Float.valueOf(this.hS * this.hx.n()));
    }

    /* access modifiers changed from: private */
    public void cV() {
        this.bM.A(this.hT);
        Iterator<an.d> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().A(this.hT);
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        this.hs.a(z2, i3, i2);
    }

    /* access modifiers changed from: private */
    public void cW() {
        int aB = aB();
        boolean z = true;
        if (aB != 1) {
            if (aB == 2 || aB == 3) {
                boolean ay = ay();
                bb bbVar = this.hz;
                if (!aE() || ay) {
                    z = false;
                }
                bbVar.C(z);
                this.hA.C(aE());
                return;
            } else if (aB != 4) {
                throw new IllegalStateException();
            }
        }
        this.hz.C(false);
        this.hA.C(false);
    }

    private void cX() {
        IllegalStateException illegalStateException;
        this.hq.oQ();
        if (Thread.currentThread() != az().getThread()) {
            String a2 = ai.a("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), az().getThread().getName());
            if (!this.hV) {
                if (this.hW) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                com.applovin.exoplayer2.l.q.b("SimpleExoPlayer", a2, illegalStateException);
                this.hW = true;
                return;
            }
            throw new IllegalStateException(a2);
        }
    }

    private void a(int i, int i2, Object obj) {
        for (ar arVar : this.bB) {
            if (arVar.M() == i) {
                this.hs.a((ao.b) arVar).ad(i2).h(obj).cM();
            }
        }
    }

    private int ah(int i) {
        AudioTrack audioTrack = this.hE;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i)) {
            this.hE.release();
            this.hE = null;
        }
        if (this.hE == null) {
            this.hE = new AudioTrack(3, GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND, 4, 2, 2, 0, i);
        }
        return this.hE.getAudioSessionId();
    }

    /* access modifiers changed from: private */
    public static o a(ay ayVar) {
        return new o(0, ayVar.da(), ayVar.db());
    }

    private final class b implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, an.b, ay.a, b.C0032b, com.applovin.exoplayer2.b.g, c.b, com.applovin.exoplayer2.g.e, com.applovin.exoplayer2.i.l, i.a, com.applovin.exoplayer2.m.n, q.a {
        public /* synthetic */ void a(ab abVar, int i) {
            an.b.CC.$default$a((an.b) this, abVar, i);
        }

        public /* synthetic */ void a(ac acVar) {
            an.b.CC.$default$a((an.b) this, acVar);
        }

        public /* synthetic */ void a(ak akVar) {
            an.b.CC.$default$a((an.b) this, akVar);
        }

        public /* synthetic */ void a(an.e eVar, an.e eVar2, int i) {
            an.b.CC.$default$a(this, eVar, eVar2, i);
        }

        public /* synthetic */ void a(an anVar, an.c cVar) {
            an.b.CC.$default$a((an.b) this, anVar, cVar);
        }

        public /* synthetic */ void a(ad adVar, h hVar) {
            an.b.CC.$default$a((an.b) this, adVar, hVar);
        }

        public /* synthetic */ void aa(int i) {
            an.b.CC.$default$aa(this, i);
        }

        public /* synthetic */ void ab(int i) {
            an.b.CC.$default$ab(this, i);
        }

        public /* synthetic */ void ac(int i) {
            an.b.CC.$default$ac(this, i);
        }

        public /* synthetic */ void b(ak akVar) {
            an.b.CC.$default$b((an.b) this, akVar);
        }

        public /* synthetic */ void b(am amVar) {
            an.b.CC.$default$b((an.b) this, amVar);
        }

        public /* synthetic */ void b(ba baVar, int i) {
            an.b.CC.$default$b(this, baVar, i);
        }

        public /* synthetic */ void c(v vVar) {
            g.CC.$default$c((com.applovin.exoplayer2.b.g) this, vVar);
        }

        public /* synthetic */ void cD() {
            an.b.CC.$default$cD(this);
        }

        public /* synthetic */ void d(an.a aVar) {
            an.b.CC.$default$d(this, aVar);
        }

        public /* synthetic */ void d(boolean z, int i) {
            an.b.CC.$default$d(this, z, i);
        }

        public /* synthetic */ void i(boolean z) {
            q.a.CC.$default$i(this, z);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public /* synthetic */ void x(boolean z) {
            an.b.CC.$default$x(this, z);
        }

        public /* synthetic */ void y(v vVar) {
            n.CC.$default$y(this, vVar);
        }

        public /* synthetic */ void y(boolean z) {
            an.b.CC.$default$y(this, z);
        }

        public /* synthetic */ void z(boolean z) {
            an.b.CC.$default$z(this, z);
        }

        private b() {
        }

        public void a(e eVar) {
            e unused = aw.this.hP = eVar;
            aw.this.bM.a(eVar);
        }

        public void a(String str, long j, long j2) {
            aw.this.bM.a(str, j, j2);
        }

        public void a(v vVar, com.applovin.exoplayer2.c.h hVar) {
            v unused = aw.this.hC = vVar;
            aw.this.bM.a(vVar, hVar);
        }

        public void b(int i, long j) {
            aw.this.bM.b(i, j);
        }

        public void a(o oVar) {
            o unused = aw.this.ib = oVar;
            aw.this.bM.a(oVar);
            Iterator it = aw.this.hv.iterator();
            while (it.hasNext()) {
                ((an.d) it.next()).a(oVar);
            }
        }

        public void a(Object obj, long j) {
            aw.this.bM.a(obj, j);
            if (aw.this.hF == obj) {
                Iterator it = aw.this.hv.iterator();
                while (it.hasNext()) {
                    ((an.d) it.next()).cE();
                }
            }
        }

        public void r(String str) {
            aw.this.bM.r(str);
        }

        public void b(e eVar) {
            aw.this.bM.b(eVar);
            v unused = aw.this.hC = null;
            e unused2 = aw.this.hP = null;
        }

        public void a(long j, int i) {
            aw.this.bM.a(j, i);
        }

        public void a(Exception exc) {
            aw.this.bM.a(exc);
        }

        public void c(e eVar) {
            e unused = aw.this.hQ = eVar;
            aw.this.bM.c(eVar);
        }

        public void b(String str, long j, long j2) {
            aw.this.bM.b(str, j, j2);
        }

        public void b(v vVar, com.applovin.exoplayer2.c.h hVar) {
            v unused = aw.this.hD = vVar;
            aw.this.bM.b(vVar, hVar);
        }

        public void z(long j) {
            aw.this.bM.z(j);
        }

        public void a(int i, long j, long j2) {
            aw.this.bM.a(i, j, j2);
        }

        public void s(String str) {
            aw.this.bM.s(str);
        }

        public void d(e eVar) {
            aw.this.bM.d(eVar);
            v unused = aw.this.hD = null;
            e unused2 = aw.this.hQ = null;
        }

        public void A(boolean z) {
            if (aw.this.hT != z) {
                boolean unused = aw.this.hT = z;
                aw.this.cV();
            }
        }

        public void b(Exception exc) {
            aw.this.bM.b(exc);
        }

        public void c(Exception exc) {
            aw.this.bM.c(exc);
        }

        public void e(List<com.applovin.exoplayer2.i.a> list) {
            List unused = aw.this.hU = list;
            Iterator it = aw.this.hv.iterator();
            while (it.hasNext()) {
                ((an.d) it.next()).e(list);
            }
        }

        public void a(com.applovin.exoplayer2.g.a aVar) {
            aw.this.bM.a(aVar);
            aw.this.hs.a(aVar);
            Iterator it = aw.this.hv.iterator();
            while (it.hasNext()) {
                ((an.d) it.next()).a(aVar);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (aw.this.hJ) {
                aw.this.i((Object) surfaceHolder.getSurface());
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            aw.this.g(i2, i3);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (aw.this.hJ) {
                aw.this.i((Object) null);
            }
            aw.this.g(0, 0);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            aw.this.a(surfaceTexture);
            aw.this.g(i, i2);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            aw.this.g(i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            aw.this.i((Object) null);
            aw.this.g(0, 0);
            return true;
        }

        public void a(Surface surface) {
            aw.this.i((Object) null);
        }

        public void b(float f) {
            aw.this.cU();
        }

        public void l(int i) {
            boolean aE = aw.this.aE();
            aw.this.b(aE, i, aw.f(aE, i));
        }

        public void m() {
            aw.this.b(false, -1, 3);
        }

        public void ai(int i) {
            o b = aw.a(aw.this.hy);
            if (!b.equals(aw.this.ia)) {
                o unused = aw.this.ia = b;
                Iterator it = aw.this.hv.iterator();
                while (it.hasNext()) {
                    ((an.d) it.next()).a(b);
                }
            }
        }

        public void f(int i, boolean z) {
            Iterator it = aw.this.hv.iterator();
            while (it.hasNext()) {
                ((an.d) it.next()).e(i, z);
            }
        }

        public void w(boolean z) {
            if (aw.this.hX == null) {
                return;
            }
            if (z && !aw.this.hY) {
                aw.this.hX.cR(0);
                boolean unused = aw.this.hY = true;
            } else if (!z && aw.this.hY) {
                aw.this.hX.fF(0);
                boolean unused2 = aw.this.hY = false;
            }
        }

        public void Z(int i) {
            aw.this.cW();
        }

        public void e(boolean z, int i) {
            aw.this.cW();
        }

        public void j(boolean z) {
            aw.this.cW();
        }
    }

    private static final class c implements ao.b, com.applovin.exoplayer2.m.a.a, com.applovin.exoplayer2.m.l {
        private com.applovin.exoplayer2.m.l ij;
        private com.applovin.exoplayer2.m.a.a ik;
        private com.applovin.exoplayer2.m.l il;
        private com.applovin.exoplayer2.m.a.a im;

        private c() {
        }

        public void a(int i, Object obj) {
            if (i == 7) {
                this.ij = (com.applovin.exoplayer2.m.l) obj;
            } else if (i == 8) {
                this.ik = (com.applovin.exoplayer2.m.a.a) obj;
            } else if (i == 10000) {
                i iVar = (i) obj;
                if (iVar == null) {
                    this.il = null;
                    this.im = null;
                    return;
                }
                this.il = iVar.getVideoFrameMetadataListener();
                this.im = iVar.getCameraMotionListener();
            }
        }

        public void a(long j, long j2, v vVar, MediaFormat mediaFormat) {
            com.applovin.exoplayer2.m.l lVar = this.il;
            if (lVar != null) {
                lVar.a(j, j2, vVar, mediaFormat);
            }
            com.applovin.exoplayer2.m.l lVar2 = this.ij;
            if (lVar2 != null) {
                lVar2.a(j, j2, vVar, mediaFormat);
            }
        }

        public void a(long j, float[] fArr) {
            com.applovin.exoplayer2.m.a.a aVar = this.im;
            if (aVar != null) {
                aVar.a(j, fArr);
            }
            com.applovin.exoplayer2.m.a.a aVar2 = this.ik;
            if (aVar2 != null) {
                aVar2.a(j, fArr);
            }
        }

        public void cZ() {
            com.applovin.exoplayer2.m.a.a aVar = this.im;
            if (aVar != null) {
                aVar.cZ();
            }
            com.applovin.exoplayer2.m.a.a aVar2 = this.ik;
            if (aVar2 != null) {
                aVar2.cZ();
            }
        }
    }
}
