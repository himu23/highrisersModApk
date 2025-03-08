package com.fyber.inneractive.sdk.player.controller;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.t;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.player.enums.b;
import com.fyber.inneractive.sdk.player.ui.l;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.s0;

public class j extends n<t.a> implements t {
    public Runnable C;
    public float D = (((float) ((a0) this.b).b().b().intValue()) / 100.0f);
    public float E = 0.0f;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j.this.h(false);
            j.this.C = null;
        }
    }

    public j(c cVar, l lVar, a0 a0Var, s sVar, boolean z, String str, boolean z2) {
        super(cVar, lVar, a0Var, sVar, z, str, z2);
        I();
    }

    public void A() {
        super.A();
        J();
        this.d.b(false);
        this.F = true;
    }

    public boolean B() {
        return false;
    }

    public final void F() {
        if (this.g != null && !this.H) {
            H();
            super.l();
            ((t.a) this.g).c();
            IAlog.a("%sopening fullscreen", IAlog.a((Object) this));
            this.H = true;
            c cVar = this.a;
            if (cVar != null) {
                e eVar = (e) cVar;
                eVar.a(eVar.v, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.t.EVENT_FULLSCREEN, com.fyber.inneractive.sdk.model.vast.t.EVENT_EXPAND);
            }
        }
    }

    public final void G() {
        c cVar;
        g gVar;
        l lVar;
        if (this.E >= this.D && (cVar = this.a) != null && (gVar = cVar.b) != null && !gVar.e.equals(b.Completed) && (lVar = this.d) != null && !lVar.f() && this.a.b.j != null) {
            if (((a0) this.b).f.a.booleanValue() || this.F) {
                b(IAConfigManager.M.i.a);
            }
        }
    }

    public final void I() {
        g gVar;
        c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null && !gVar.n) {
            if (((a0) this.b).f.d.booleanValue()) {
                this.a.b.b(false);
            } else if (!t()) {
                this.a.b.d(false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r3.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J() {
        /*
            r3 = this;
            com.fyber.inneractive.sdk.config.b0 r0 = r3.b
            com.fyber.inneractive.sdk.config.a0 r0 = (com.fyber.inneractive.sdk.config.a0) r0
            com.fyber.inneractive.sdk.config.c0 r0 = r0.f
            com.fyber.inneractive.sdk.config.enums.TapAction r0 = r0.i
            com.fyber.inneractive.sdk.config.enums.TapAction r1 = com.fyber.inneractive.sdk.config.enums.TapAction.FULLSCREEN
            if (r0 == r1) goto L_0x001b
            com.fyber.inneractive.sdk.player.ui.l r0 = r3.d
            android.widget.ImageView r1 = r0.w
            if (r1 == 0) goto L_0x001b
            r2 = 0
            r1.setVisibility(r2)
            android.widget.ImageView r0 = r0.w
            r0.setSelected(r2)
        L_0x001b:
            r3.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.j.J():void");
    }

    public void a(boolean z) {
        if (z) {
            a(this.E);
        }
        super.a(z);
    }

    public void b(int i) {
        g gVar;
        c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null && gVar.e != b.Playing && this.C == null) {
            IAlog.a("%splayVideo %s", IAlog.a((Object) this), this.d);
            if (i == 0) {
                h(false);
                return;
            }
            a aVar = new a();
            this.C = aVar;
            this.d.postDelayed(aVar, (long) i);
        }
    }

    public void d(boolean z) {
        g gVar;
        c cVar = this.a;
        if (!(cVar == null || (gVar = cVar.b) == null || gVar.e.equals(b.Completed))) {
            J();
        }
        c cVar2 = this.a;
        Bitmap bitmap = cVar2 != null ? cVar2.k : null;
        if (bitmap != null) {
            this.d.b(true);
            this.d.setLastFrameBitmap(bitmap);
        }
        super.d(z);
    }

    public void destroy() {
        H();
        this.g = null;
        super.destroy();
    }

    public boolean e() {
        return true;
    }

    public void h(boolean z) {
        c cVar = this.a;
        if (cVar != null && cVar.b != null) {
            I();
            super.h(z);
        }
    }

    public boolean k() {
        super.k();
        c cVar = this.a;
        if (!(cVar == null || cVar.b == null)) {
            IAlog.a("%sconnectToTextureView playing state = %s", IAlog.a((Object) this), this.a.b.e);
            if (this.a.b.j()) {
                this.d.c(!this.a.j);
                l lVar = this.d;
                com.fyber.inneractive.sdk.player.ui.c cVar2 = new com.fyber.inneractive.sdk.player.ui.c();
                cVar2.b = false;
                lVar.d(new com.fyber.inneractive.sdk.player.ui.b(cVar2));
                this.d.b(false);
                I();
            }
        }
        a(this.E);
        return true;
    }

    public void l() {
        H();
        super.l();
    }

    public int o() {
        return IAConfigManager.M.u.b.a("VideoAdBufferingTimeout", 5, 1) * 1000;
    }

    public void pauseVideo() {
        H();
        super.pauseVideo();
    }

    public int s() {
        return 0;
    }

    public void w() {
        F();
    }

    public void x() {
        j();
        this.d.a(false);
        D();
        H();
    }

    public void y() {
        c cVar = this.a;
        if (cVar != null && cVar.b != null) {
            k();
            h(false);
        }
    }

    public void z() {
        G();
    }

    public void f() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a((Object) this));
        l();
    }

    public void u() {
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a((Object) this));
        if (this.d.e) {
            this.u = true;
            c(false);
        }
    }

    public final void H() {
        if (this.C != null) {
            IAlog.a("%sCancelling play runnable", IAlog.a((Object) this));
            this.d.removeCallbacks(this.C);
            this.C = null;
        }
    }

    public void a(p0 p0Var) {
        TapAction tapAction = ((a0) this.b).f.i;
        c cVar = this.a;
        if (cVar != null && cVar.b != null && this.E < this.D) {
            return;
        }
        if (tapAction == TapAction.CTR) {
            if (a(false, VideoClickOrigin.CTA, p0Var)) {
                a(false, (s0.a) new k(this));
            }
        } else if (tapAction == TapAction.FULLSCREEN) {
            F();
        } else if (tapAction != TapAction.DO_NOTHING) {
            IAlog.a("%sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a((Object) this), tapAction);
        } else if (cVar != null) {
            cVar.d();
        }
    }

    public void b(boolean z) {
        c cVar;
        g gVar;
        this.G = z;
        if (z && (cVar = this.a) != null && (gVar = cVar.b) != null && gVar.j == null && this.d.e && !gVar.e.equals(b.Completed)) {
            k();
            a(this.E);
        }
    }

    public void a(float f) {
        g gVar;
        this.E = f;
        if (IAlog.a >= 3) {
            IAlog.c("%sonVisibilityChanged called with: %s vfpl = %s vfpa = %s", IAlog.a((Object) this), Float.valueOf(f), Float.valueOf(this.D), Float.valueOf(1.0f - this.D));
        }
        c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null) {
            if (gVar.e != b.Playing) {
                G();
            } else if (f <= this.D) {
                IAlog.d("%sonVisibilityChanged pausing player", IAlog.a((Object) this));
                if (this.a.b.j != null) {
                    this.F = false;
                    a(false, (s0.a) null);
                    H();
                    super.pauseVideo();
                    g(false);
                }
            }
        }
    }

    public void a() {
        g gVar;
        IAlog.a("%sfullscreenExited called", IAlog.a((Object) this));
        this.H = false;
        b(this.G);
        c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null) {
            a(gVar.e);
            a(this.a.b.c());
        }
    }
}
