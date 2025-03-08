package com.fyber.inneractive.sdk.renderers;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.t;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.ui.d;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.d0;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.google.android.gms.drive.DriveFile;

public class h extends r<f0, InneractiveAdViewEventsListener> implements com.fyber.inneractive.sdk.interfaces.b, InneractiveNativeVideoContentController.Renderer, d0.e {
    public FrameLayout l;
    public com.fyber.inneractive.sdk.player.ui.h m;
    public t n;
    public VideoContentListener o;
    public final c.C0106c p = new a();
    public ViewGroup q;
    public n r;
    public float s = 0.0f;
    public Rect t = new Rect();
    public Runnable u;
    public boolean v = false;
    public final t.a w = new b();

    public class a implements c.C0106c {
        public a() {
        }

        public void a(c cVar) {
            t tVar = h.this.n;
            if (tVar != null) {
                tVar.d(false);
                h.this.n.h();
            }
        }
    }

    public class b implements t.a {
        public b() {
        }

        public void a(boolean z) {
        }

        public void a(boolean z, Orientation orientation) {
        }

        public void e() {
        }

        public void h() {
        }

        public void j() {
            h.this.a((InneractiveUnitController.AdDisplayError) new WebViewRendererProcessHasGoneError());
        }

        public void k() {
        }

        public void onCompleted() {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener != null && (hVar = hVar2.m) != null && ((d) hVar).e) {
                videoContentListener.onCompleted();
            }
        }

        public void onPlayerError() {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener != null && (hVar = hVar2.m) != null && ((d) hVar).e) {
                videoContentListener.onPlayerError();
            }
        }

        public void onProgress(int i, int i2) {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener != null && (hVar = hVar2.m) != null && ((d) hVar).e) {
                videoContentListener.onProgress(i, i2);
            }
        }

        public k q() {
            return k.NONE;
        }

        public void a(String str, String str2) {
            h hVar = h.this;
            hVar.getClass();
            IAlog.a("%s ad view video ad renderer callback: onSuspiciousNoUserWebActionDetected", IAlog.a((Object) hVar));
            ViewGroup viewGroup = h.this.q;
            if (viewGroup != null && viewGroup.getContext() != null) {
                h hVar2 = h.this;
                if (!hVar2.v) {
                    u.a(hVar2.q.getContext(), str, str2, h.this.b);
                    boolean unused = h.this.v = true;
                    h hVar3 = h.this;
                    hVar3.getClass();
                    IAlog.a("%s reporting auto redirect", IAlog.a((Object) hVar3));
                    return;
                }
                hVar2.getClass();
                IAlog.a("%s redirect already reported for this ad", IAlog.a((Object) hVar2));
            }
        }

        public void c() {
            Object obj;
            h hVar = h.this;
            EventsListener eventslistener = hVar.c;
            if (eventslistener != null) {
                ((InneractiveAdViewEventsListener) eventslistener).onAdExpanded(hVar.a);
            }
            ViewGroup viewGroup = h.this.q;
            if (viewGroup != null && viewGroup.getContext() != null) {
                h hVar2 = h.this;
                if (hVar2.b instanceof com.fyber.inneractive.sdk.dv.a) {
                    obj = new com.fyber.inneractive.sdk.display.b();
                } else {
                    obj = new com.fyber.inneractive.sdk.display.c();
                }
                if (obj instanceof com.fyber.inneractive.sdk.display.c) {
                    com.fyber.inneractive.sdk.display.c cVar = (com.fyber.inneractive.sdk.display.c) obj;
                    Context context = hVar2.q.getContext();
                    InneractiveAdSpot inneractiveAdSpot = h.this.a;
                    Intent intent = new Intent(context, InneractiveFullscreenAdActivity.class);
                    intent.putExtra("spotId", inneractiveAdSpot.getLocalUniqueId());
                    if (!(context instanceof Activity)) {
                        intent.setFlags(DriveFile.MODE_READ_ONLY);
                    }
                    try {
                        IAlog.a("%sIAInterstitialUtil: Opening interstitial for spot id: %s", IAlog.a((Object) context), inneractiveAdSpot.getLocalUniqueId());
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        IAlog.c("%sIAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?", IAlog.a((Object) context));
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            r0 = (r0 = r0.h).b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r2 = this;
                com.fyber.inneractive.sdk.renderers.h r0 = com.fyber.inneractive.sdk.renderers.h.this
                AdContent r0 = r0.b
                if (r0 == 0) goto L_0x002b
                com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r1 = r0.a
                if (r1 == 0) goto L_0x002b
                T r1 = r0.b
                if (r1 == 0) goto L_0x002b
                T r0 = r0.b
                com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
                com.fyber.inneractive.sdk.model.vast.b r0 = r0.K
                if (r0 == 0) goto L_0x0025
                com.fyber.inneractive.sdk.model.vast.c r0 = r0.h
                if (r0 == 0) goto L_0x0025
                com.fyber.inneractive.sdk.model.vast.i r0 = r0.b
                if (r0 == 0) goto L_0x0025
                java.lang.String r0 = r0.toString()
                goto L_0x0026
            L_0x0025:
                r0 = 0
            L_0x0026:
                com.fyber.inneractive.sdk.renderers.h r1 = com.fyber.inneractive.sdk.renderers.h.this
                r1.a((java.lang.String) r0)
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.h.b.g():void");
        }

        public void l() {
            h hVar = h.this;
            f0 f0Var = (f0) hVar.b;
            if (!f0Var.j) {
                f0Var.j = true;
                hVar.E();
            }
        }

        public void s() {
            h hVar = h.this;
            if (hVar.c != null) {
                hVar.D();
            }
        }

        public void a(View view, String str) {
            if (view != null && view.getContext() != null) {
                InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
                h.this.D();
            }
        }

        public b0.a a(p0 p0Var, i iVar) {
            Context context;
            h hVar = h.this;
            if (hVar.m.getContext() == null) {
                context = p.a;
            } else {
                context = h.this.m.getContext();
            }
            AdContent adcontent = h.this.b;
            return hVar.a(context, adcontent != null ? ((f0) adcontent).k() : null, p0Var, iVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r5 = (r5 = r5.h).b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.fyber.inneractive.sdk.util.b0.a a(java.lang.String r3, com.fyber.inneractive.sdk.util.p0 r4, com.fyber.inneractive.sdk.web.b.a r5, boolean r6) {
            /*
                r2 = this;
                com.fyber.inneractive.sdk.renderers.h r5 = com.fyber.inneractive.sdk.renderers.h.this
                AdContent r5 = r5.b
                r0 = 0
                if (r5 == 0) goto L_0x002e
                com.fyber.inneractive.sdk.flow.f0 r5 = (com.fyber.inneractive.sdk.flow.f0) r5
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r1 = r5.a
                if (r1 == 0) goto L_0x002e
                T r1 = r5.b
                if (r1 == 0) goto L_0x002e
                T r5 = r5.b
                com.fyber.inneractive.sdk.response.g r5 = (com.fyber.inneractive.sdk.response.g) r5
                com.fyber.inneractive.sdk.model.vast.b r5 = r5.K
                if (r5 == 0) goto L_0x0028
                if (r6 != 0) goto L_0x0028
                com.fyber.inneractive.sdk.model.vast.c r5 = r5.h
                if (r5 == 0) goto L_0x0028
                com.fyber.inneractive.sdk.model.vast.i r5 = r5.b
                if (r5 == 0) goto L_0x0028
                java.lang.String r5 = r5.toString()
                goto L_0x0029
            L_0x0028:
                r5 = r0
            L_0x0029:
                com.fyber.inneractive.sdk.renderers.h r1 = com.fyber.inneractive.sdk.renderers.h.this
                r1.a((java.lang.String) r5)
            L_0x002e:
                boolean r5 = android.text.TextUtils.isEmpty(r3)
                if (r5 == 0) goto L_0x0050
                com.fyber.inneractive.sdk.renderers.h r3 = com.fyber.inneractive.sdk.renderers.h.this
                AdContent r3 = r3.b
                com.fyber.inneractive.sdk.flow.f0 r3 = (com.fyber.inneractive.sdk.flow.f0) r3
                T r5 = r3.b
                if (r5 == 0) goto L_0x004f
                com.fyber.inneractive.sdk.response.g r5 = (com.fyber.inneractive.sdk.response.g) r5
                com.fyber.inneractive.sdk.model.vast.b r5 = r5.K
                com.fyber.inneractive.sdk.model.vast.c r5 = r5.h
                if (r5 == 0) goto L_0x0048
                java.lang.String r0 = r5.g
            L_0x0048:
                if (r0 != 0) goto L_0x004f
                java.lang.String r3 = r3.k()
                goto L_0x0050
            L_0x004f:
                r3 = r0
            L_0x0050:
                com.fyber.inneractive.sdk.renderers.h r5 = com.fyber.inneractive.sdk.renderers.h.this
                android.app.Application r0 = com.fyber.inneractive.sdk.util.p.a
                android.view.ViewGroup r1 = r5.q
                if (r1 == 0) goto L_0x0064
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0064
                android.view.ViewGroup r0 = r5.q
                android.content.Context r0 = r0.getContext()
            L_0x0064:
                if (r6 == 0) goto L_0x0069
                com.fyber.inneractive.sdk.util.i r6 = com.fyber.inneractive.sdk.util.i.DEFAULT_ENDCARD
                goto L_0x006b
            L_0x0069:
                com.fyber.inneractive.sdk.util.i r6 = com.fyber.inneractive.sdk.util.i.VAST_ENDCARD
            L_0x006b:
                com.fyber.inneractive.sdk.util.b0$a r3 = r5.a(r0, r3, r4, r6)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.h.b.a(java.lang.String, com.fyber.inneractive.sdk.util.p0, com.fyber.inneractive.sdk.web.b$a, boolean):com.fyber.inneractive.sdk.util.b0$a");
        }
    }

    public void a(int i) {
    }

    public void destroy() {
        u();
        super.destroy();
    }

    public int f() {
        return 0;
    }

    public int p() {
        return 0;
    }

    public void r() {
    }

    public void u() {
        J();
        d0.d.a.a(this.q);
        IAlog.a("%sunbind called. root is %s", IAlog.a((Object) this), this.q);
        if (this.n != null) {
            IAlog.a("%sdestroying video ui controller", IAlog.a((Object) this));
            this.n.a(null);
            this.n.destroy();
            this.n = null;
        }
        if (this.m != null) {
            this.q.setLayoutTransition((LayoutTransition) null);
            this.q.removeView(this.l);
            this.m.destroy();
            this.m = null;
        }
    }

    public View y() {
        return this.l;
    }

    public final void J() {
        ViewGroup viewGroup;
        Runnable runnable = this.u;
        if (runnable != null && (viewGroup = this.q) != null) {
            viewGroup.removeCallbacks(runnable);
            this.u = null;
        }
    }

    public boolean a(q qVar) {
        return qVar instanceof f0;
    }

    public void n() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.d(false);
        }
    }

    public void pauseVideo() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.pauseVideo();
        }
    }

    public void playVideo() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.b(0);
        }
    }

    public void a(ViewGroup viewGroup) {
        Bitmap bitmap;
        InneractiveAdSpot inneractiveAdSpot = this.a;
        if (inneractiveAdSpot == null) {
            IAlog.e("%sYou must set the spot to render before calling renderAd", IAlog.a((Object) this));
            return;
        }
        this.q = viewGroup;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (!(selectedUnitController instanceof InneractiveAdViewUnitController)) {
            IAlog.e("%sWrong type of unit controller found. Expecting InneractiveAdViewUnitController", IAlog.a((Object) this));
        } else {
            InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
            if (selectedContentController != null) {
                if (selectedContentController instanceof InneractiveAdViewVideoContentController) {
                    this.o = (VideoContentListener) ((InneractiveAdViewVideoContentController) selectedContentController).getEventsListener();
                } else {
                    IAlog.e("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a((Object) this), selectedContentController.getClass().getSimpleName());
                }
            }
        }
        this.v = false;
        this.l = new FrameLayout(viewGroup.getContext());
        AdContent adcontent = this.b;
        com.fyber.inneractive.sdk.player.h hVar = adcontent != null ? ((f0) adcontent).i : null;
        Context context = viewGroup.getContext();
        if (hVar != null) {
            ((e) hVar.f).getClass();
            a aVar = new a(hVar);
            this.r = aVar;
            this.m = aVar.a(context, ((f0) this.b).c);
            this.n = (t) this.r.a(this.a, (f0) this.b);
            this.q.addView(this.l, new ViewGroup.LayoutParams(-1, -2));
            this.q.setLayoutTransition((LayoutTransition) null);
            this.l.addView((View) this.m, new FrameLayout.LayoutParams(-2, -2, 17));
            this.n.a(this.w);
            this.n.d(this.r.c());
            this.r.a(this.p);
            if ((this.r instanceof a) && (bitmap = ((e) hVar.f).k) != null) {
                this.n.a(bitmap);
            }
            d0 d0Var = d0.d.a;
            ViewGroup viewGroup2 = this.q;
            d0Var.getClass();
            d0Var.a(viewGroup2.getContext(), (View) viewGroup2, (d0.e) this);
        }
    }

    public void a(View view, float f, Rect rect) {
        if (this.s != f || !this.t.equals(rect)) {
            this.s = f;
            this.t.set(rect);
            t tVar = this.n;
            if (tVar != null) {
                tVar.b(false);
                ((d) this.m).b();
                this.n.a(f);
            }
            if (f > 0.0f) {
                J();
                i iVar = new i(this);
                this.u = iVar;
                this.q.postDelayed(iVar, 100);
                return;
            }
            J();
        }
    }

    public boolean a(View view) {
        return view.equals(this.q);
    }

    public void a() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.a();
        }
    }
}
