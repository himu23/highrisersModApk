package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.mraid.t;
import com.fyber.inneractive.sdk.mraid.u;
import com.fyber.inneractive.sdk.mraid.v;
import com.fyber.inneractive.sdk.mraid.w;
import com.fyber.inneractive.sdk.mraid.x;
import com.fyber.inneractive.sdk.mraid.y;
import com.fyber.inneractive.sdk.mraid.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.b0;
import com.fyber.inneractive.sdk.web.i;
import java.util.ArrayList;

public abstract class a0<T extends b0> extends d<T> {
    public boolean A = false;
    public boolean B = true;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F;
    public com.fyber.inneractive.sdk.mraid.b0 G = com.fyber.inneractive.sdk.mraid.b0.HIDDEN;
    public i.C0139i H;
    public com.fyber.inneractive.sdk.measurement.a I;
    public a.C0101a J = null;
    public final Runnable K = new a();
    public ViewTreeObserver.OnPreDrawListener L = new b();
    public final Runnable M = new c();
    public final Runnable N = new d();
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public int z = -1;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            g gVar = a0.this.b;
            if (gVar != null) {
                gVar.getViewTreeObserver().addOnPreDrawListener(a0.this.L);
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        public boolean onPreDraw() {
            g gVar;
            g gVar2 = a0.this.b;
            if (gVar2 == null) {
                return false;
            }
            gVar2.getViewTreeObserver().removeOnPreDrawListener(this);
            a0.this.m();
            a0 a0Var = a0.this;
            a0Var.a((u) new x(a0Var.H));
            a0 a0Var2 = a0.this;
            if (a0Var2.H == i.C0139i.INTERSTITIAL && (gVar = a0Var2.b) != null) {
                gVar.a("if (window.showInterstitial) { showInterstitial(); }");
            }
            a0.this.k();
            a0 a0Var3 = a0.this;
            a0Var3.a(a0Var3.l(), true);
            a0.this.q();
            q.b.postDelayed(a0.this.M, 100);
            return false;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            a.C0101a aVar;
            a0 a0Var = a0.this;
            if (a0Var.I != null && (aVar = a0Var.J) != null) {
                aVar.a();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            g gVar = a0.this.b;
            if (gVar != null) {
                gVar.a("if (FyberMraidVideoController.getCurrentTime() < 0.2) { var ifr = document.createElement('iframe'); var container = document.body || document.documentElement; container.appendChild(ifr); ifr.setAttribute('sandbox', ''); ifr.setAttribute('style', 'position: fixed; bottom: -20px; border: none; visibility: hidden; height: 20px; z-index: -99999'); ifr.setAttribute('src','FyMraidVideo://fyMraidVideoAdPlaybackFailure'); console.log('dispatched closure event'); } else { console.log('video has progressed'); };");
            }
        }
    }

    public a0(boolean z2, boolean z3, i.C0139i iVar, s sVar) {
        super(z2, z3, sVar);
        this.H = iVar;
    }

    public void a(ArrayList<u> arrayList) {
        if (this.b != null) {
            String arrayList2 = arrayList.toString();
            if (arrayList2.length() >= 2) {
                String str = "{" + arrayList2.substring(1, arrayList2.length() - 1) + "}";
                this.b.a("window.mraidbridge.fireChangeEvent(" + str + ");");
                IAlog.d("Fire changes: %s", str);
            }
        }
    }

    public void k() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    public Context l() {
        g gVar = this.b;
        if (gVar != null) {
            return gVar.getContext();
        }
        return null;
    }

    public void m() {
        ArrayList arrayList = new ArrayList();
        g gVar = this.b;
        if (gVar == null || gVar.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new y(this.w, this.x));
            arrayList.add(new w(this.u, this.v));
        } else {
            int widthDp = this.b.getWidthDp();
            int heightDp = this.b.getHeightDp();
            arrayList.add(new y(widthDp, heightDp));
            arrayList.add(new w(widthDp, heightDp));
        }
        g gVar2 = this.b;
        int b2 = p.b(gVar2 != null ? gVar2.getWidth() : this.u);
        g gVar3 = this.b;
        arrayList.add(new v(0, 0, b2, p.b(gVar3 != null ? gVar3.getHeight() : this.v)));
        a((ArrayList<u>) arrayList);
        com.fyber.inneractive.sdk.mraid.b0 b0Var = com.fyber.inneractive.sdk.mraid.b0.DEFAULT;
        this.G = b0Var;
        a((u) new z(b0Var));
    }

    public void n() {
        g gVar = this.b;
        if (gVar != null) {
            this.C = true;
            if (this.A) {
                gVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            q.b.postDelayed(this.K, 0);
        }
    }

    public boolean o() {
        return this.G == com.fyber.inneractive.sdk.mraid.b0.EXPANDED;
    }

    public boolean p() {
        i.C0139i iVar = this.H;
        return iVar != null && iVar.equals(i.C0139i.INTERSTITIAL);
    }

    public void q() {
        g gVar;
        if (this.C && this.D && this.A && (gVar = this.b) != null) {
            gVar.a("FyberMraidVideoController.play()");
            Runnable runnable = this.N;
            if (runnable != null) {
                q.b.postDelayed(runnable, 5000);
            }
            if (this.E) {
                this.b.a("FyberMraidVideoController.mute(true)");
            }
        }
    }

    public void setAdDefaultSize(int i, int i2) {
        this.y = i;
        this.z = i2;
    }

    public void setAutoplayMRAIDVideos(boolean z2) {
        this.A = z2;
    }

    public void setCenteringTagsRequired(boolean z2) {
        this.B = z2;
    }

    public void a(u uVar) {
        if (this.b != null) {
            String str = "{" + uVar.toString() + "}";
            this.b.a("window.mraidbridge.fireChangeEvent(" + str + ");");
            IAlog.d("Fire changes: %s", str);
        }
    }

    public void a(Context context, boolean z2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        int a2 = p.a(context);
        int a3 = p.a(context, a2);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        double d2 = (double) i;
        double d3 = 160.0d / ((double) displayMetrics.densityDpi);
        int i3 = (int) (d2 * d3);
        int i4 = (int) (((double) i2) * d3);
        int i5 = (i2 - a2) - a3;
        g gVar = this.b;
        if (gVar == null || gVar.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            this.u = (int) (d2 * (160.0d / ((double) displayMetrics.densityDpi)));
        } else {
            i3 = this.b.getWidthDp();
            i4 = this.b.getHeightDp();
            i5 = (p.a(this.b.getHeightDp()) - a2) - a3;
            this.u = this.w;
        }
        this.v = (int) (((double) i5) * (160.0d / ((double) displayMetrics.densityDpi)));
        if (this.w != i3 || this.x != i4) {
            this.w = i3;
            this.x = i4;
            if (z2) {
                a((u) new y(i3, i4));
                a((u) new w(this.u, this.v));
                a((u) new v(0, 0, this.u, this.v));
                int i6 = this.y;
                if (i6 <= 0 || this.z <= 0) {
                    g gVar2 = this.b;
                    if (gVar2 != null && gVar2.getWidth() > 0 && this.b.getHeight() > 0) {
                        a((u) new t(p.b(this.b.getWidth()), p.b(this.b.getHeight())));
                        return;
                    }
                    return;
                }
                a((u) new t(p.b(i6), p.b(this.z)));
            }
        }
    }
}
