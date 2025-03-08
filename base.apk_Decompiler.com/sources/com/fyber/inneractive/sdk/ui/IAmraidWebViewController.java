package com.fyber.inneractive.sdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.mraid.a0;
import com.fyber.inneractive.sdk.mraid.b0;
import com.fyber.inneractive.sdk.mraid.d;
import com.fyber.inneractive.sdk.mraid.e;
import com.fyber.inneractive.sdk.mraid.f;
import com.fyber.inneractive.sdk.mraid.h;
import com.fyber.inneractive.sdk.mraid.j;
import com.fyber.inneractive.sdk.mraid.k;
import com.fyber.inneractive.sdk.mraid.l;
import com.fyber.inneractive.sdk.mraid.m;
import com.fyber.inneractive.sdk.mraid.n;
import com.fyber.inneractive.sdk.mraid.o;
import com.fyber.inneractive.sdk.mraid.p;
import com.fyber.inneractive.sdk.mraid.r;
import com.fyber.inneractive.sdk.mraid.u;
import com.fyber.inneractive.sdk.mraid.v;
import com.fyber.inneractive.sdk.mraid.w;
import com.fyber.inneractive.sdk.mraid.x;
import com.fyber.inneractive.sdk.mraid.y;
import com.fyber.inneractive.sdk.mraid.z;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.d;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.i;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;

public class IAmraidWebViewController extends i<i.h> {
    public i.C0139i q0;
    public final Runnable r0 = new a();
    public final Runnable s0 = new b();

    public static class MraidVideoFailedToDisplayError extends InneractiveUnitController.AdDisplayError {
        public MraidVideoFailedToDisplayError(String str) {
            super(str);
        }
    }

    public class a implements Runnable {

        /* renamed from: com.fyber.inneractive.sdk.ui.IAmraidWebViewController$a$a  reason: collision with other inner class name */
        public class C0136a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: com.fyber.inneractive.sdk.ui.IAmraidWebViewController$a$a$a  reason: collision with other inner class name */
            public class C0137a implements Runnable {
                public C0137a() {
                }

                public void run() {
                    a.C0101a aVar;
                    IAmraidWebViewController iAmraidWebViewController = IAmraidWebViewController.this;
                    if (iAmraidWebViewController.I != null && (aVar = iAmraidWebViewController.J) != null) {
                        aVar.a();
                    }
                }
            }

            public C0136a() {
            }

            public boolean onPreDraw() {
                g gVar;
                g gVar2 = IAmraidWebViewController.this.b;
                if (gVar2 == null) {
                    return false;
                }
                gVar2.getViewTreeObserver().removeOnPreDrawListener(this);
                IAmraidWebViewController.this.m();
                IAmraidWebViewController iAmraidWebViewController = IAmraidWebViewController.this;
                iAmraidWebViewController.a((u) new x(iAmraidWebViewController.q0));
                IAmraidWebViewController iAmraidWebViewController2 = IAmraidWebViewController.this;
                if (iAmraidWebViewController2.q0 == i.C0139i.INTERSTITIAL && (gVar = iAmraidWebViewController2.b) != null) {
                    gVar.a("if (window.showInterstitial) { showInterstitial(); }");
                }
                g gVar3 = IAmraidWebViewController.this.b;
                if (gVar3 != null) {
                    gVar3.a("window.mraidbridge.fireReadyEvent();");
                }
                IAmraidWebViewController iAmraidWebViewController3 = IAmraidWebViewController.this;
                iAmraidWebViewController3.a(iAmraidWebViewController3.b.getContext(), true);
                IAmraidWebViewController.this.q();
                q.b.postDelayed(new C0137a(), 100);
                return false;
            }
        }

        public a() {
        }

        public void run() {
            g gVar = IAmraidWebViewController.this.b;
            if (gVar != null) {
                gVar.getViewTreeObserver().addOnPreDrawListener(new C0136a());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            g gVar = IAmraidWebViewController.this.b;
            if (gVar != null) {
                gVar.a("if (FyberMraidVideoController.getCurrentTime() < 0.2) { var ifr = document.createElement('iframe'); var container = document.body || document.documentElement; container.appendChild(ifr); ifr.setAttribute('sandbox', ''); ifr.setAttribute('style', 'position: fixed; bottom: -20px; border: none; visibility: hidden; height: 20px; z-index: -99999'); ifr.setAttribute('src','FyMraidVideo://fyMraidVideoAdPlaybackFailure'); console.log('dispatched closure event'); } else { console.log('video has progressed'); };");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            g gVar = IAmraidWebViewController.this.b;
            if (gVar != null) {
                try {
                    gVar.invalidate();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public IAmraidWebViewController(boolean z, i.C0139i iVar, i.f fVar, i.j jVar, boolean z2, com.fyber.inneractive.sdk.measurement.a aVar, s sVar) {
        super(z, false, iVar, fVar, jVar, aVar, sVar);
        this.F = z2;
        this.b.setId(R.id.inneractive_webview_mraid);
        this.q0 = iVar;
    }

    public boolean a(String str, p0 p0Var) {
        com.fyber.inneractive.sdk.mraid.b bVar;
        g gVar;
        Uri parse = Uri.parse(str);
        String uri = parse.toString();
        parse.getScheme();
        if (uri.startsWith("iaadfinishedloading")) {
            if (uri.endsWith("success")) {
                IAlog.d("received iaadfinishedloading success", new Object[0]);
                if (!(this.a || this.f == null || (gVar = this.b) == null)) {
                    gVar.a();
                    this.a = true;
                    g();
                }
            }
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        g gVar2 = this.b;
        if (gVar2 != null && gVar2.isShown()) {
            if (!"mraid".equals(scheme)) {
                return false;
            }
            URI create = URI.create(str);
            String host = create.getHost();
            try {
                Map<String, String> a2 = a(create);
                switch (f.a[com.fyber.inneractive.sdk.mraid.g.a(host).ordinal()]) {
                    case 1:
                        bVar = new com.fyber.inneractive.sdk.mraid.c(a2, this, p0Var);
                        break;
                    case 2:
                        bVar = new e(a2, this, p0Var);
                        break;
                    case 3:
                        bVar = new com.fyber.inneractive.sdk.mraid.s(a2, this, p0Var);
                        break;
                    case 4:
                        bVar = new m(a2, this, p0Var);
                        break;
                    case 5:
                        bVar = new o(a2, this, p0Var);
                        break;
                    case 6:
                        bVar = new k(a2, this, p0Var);
                        break;
                    case 7:
                        bVar = new com.fyber.inneractive.sdk.mraid.q(a2, this, p0Var);
                        break;
                    case 8:
                        bVar = new p(a2, this, p0Var);
                        break;
                    case 9:
                        bVar = new n(a2, this, p0Var);
                        break;
                    case 10:
                        bVar = new r(a2, this, p0Var);
                        break;
                    case 11:
                        bVar = new h(a2, this, p0Var);
                        break;
                    case 12:
                        bVar = new com.fyber.inneractive.sdk.mraid.i(a2, this, p0Var);
                        break;
                    case 13:
                        bVar = new j(a2, this, p0Var);
                        break;
                    case 14:
                        bVar = new l(a2, this, p0Var);
                        break;
                    case 15:
                        bVar = new d(a2, this, p0Var);
                        break;
                    default:
                        bVar = null;
                        break;
                }
                if (bVar == null || ((bVar instanceof e) && this.R == i.C0139i.INTERSTITIAL)) {
                    b(host);
                } else {
                    bVar.a = host;
                    IAlog.d("Processing MRaid command: %s", host);
                    if (bVar instanceof com.fyber.inneractive.sdk.mraid.a) {
                        a((d.c) new i.l((com.fyber.inneractive.sdk.mraid.a) bVar, p0Var));
                    } else {
                        if (bVar.b()) {
                            j();
                        }
                        bVar.a();
                    }
                    b(host);
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public void c() {
        b(false);
        Handler handler = q.b;
        handler.removeCallbacks(this.s0);
        handler.removeCallbacks(this.r0);
    }

    public a.C0101a d() {
        return this.J;
    }

    public void m() {
        int i;
        ArrayList arrayList = new ArrayList();
        g gVar = this.b;
        if (gVar == null || gVar.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new y(this.a0, this.b0));
            arrayList.add(new w(this.c0, this.d0));
        } else {
            arrayList.add(new y(this.b.getWidthDp(), this.b.getHeightDp()));
            arrayList.add(new w(this.b.getWidthDp(), this.b.getHeightDp()));
        }
        g gVar2 = this.b;
        int b2 = com.fyber.inneractive.sdk.util.p.b(gVar2 != null ? gVar2.getWidth() : this.c0);
        g gVar3 = this.b;
        if (gVar3 != null) {
            i = gVar3.getHeight();
        } else {
            i = this.d0;
        }
        boolean z = false;
        arrayList.add(new v(0, 0, b2, com.fyber.inneractive.sdk.util.p.b(i)));
        a((ArrayList<u>) arrayList);
        b0 b0Var = b0.DEFAULT;
        this.O = b0Var;
        a((u) new z(b0Var));
        g gVar4 = this.b;
        if (!(gVar4 == null || gVar4.getContext() == null)) {
            z = com.fyber.inneractive.sdk.util.n.a(new Intent(this.b.getContext(), InneractiveRichMediaVideoPlayerActivityCore.class));
        }
        a0 a0Var = new a0();
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        a0Var.b = com.fyber.inneractive.sdk.util.n.a(intent);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        a0Var.a = com.fyber.inneractive.sdk.util.n.a(intent2);
        a0Var.c = com.fyber.inneractive.sdk.util.n.a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"));
        a0Var.e = z;
        a0Var.d = com.fyber.inneractive.sdk.util.n.n();
        a((u) a0Var);
    }

    public void q() {
        g gVar;
        if (this.C && this.D && this.A && (gVar = this.b) != null) {
            gVar.a("FyberMraidVideoController.play()");
            Runnable runnable = this.s0;
            if (runnable != null) {
                q.b.postDelayed(runnable, 5000);
            }
            if (this.E) {
                this.b.a("FyberMraidVideoController.mute(true)");
            }
        }
    }

    public void setMuteMraidVideo(boolean z) {
        this.E = z;
    }

    public final void a(long j) {
        q.b.postDelayed(new c(), j);
    }

    public boolean a(WebView webView, String str) {
        JSONArray jSONArray;
        s sVar;
        IAlog.a("IAmraidWebViewController: handleUrl = %s", str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        } else if (str == null || !str.toLowerCase().startsWith("FyMraidVideo".toLowerCase())) {
            return super.a(webView, str);
        } else {
            if (str.toLowerCase().endsWith("fyMraidVideoAd".toLowerCase())) {
                IAlog.d("Dispatching MRAID Video detection event", new Object[0]);
                com.fyber.inneractive.sdk.response.e eVar = this.t;
                if (eVar == null) {
                    com.fyber.inneractive.sdk.flow.q qVar = this.s;
                    eVar = qVar == null ? null : qVar.d();
                }
                com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.MRAID_VIDEO_DETECTED;
                InneractiveAdRequest inneractiveAdRequest = this.r;
                com.fyber.inneractive.sdk.flow.q qVar2 = this.s;
                new s.a(rVar, inneractiveAdRequest, eVar, (qVar2 == null || (sVar = qVar2.c) == null) ? null : sVar.c()).a((String) null);
                this.D = true;
                q();
            } else if (str.toLowerCase().endsWith("fyMraidVideoAdPlaybackFailure".toLowerCase())) {
                IAlog.b("MRAID Video has not started in a timely fashion, showing close button", new Object[0]);
                if (this.g != null) {
                    c(false);
                    com.fyber.inneractive.sdk.network.q qVar3 = com.fyber.inneractive.sdk.network.q.MRAID_VIDEO_HAS_NOT_STARTED_PLAYING_IN_A_TIMELY_FASHION;
                    InneractiveAdRequest inneractiveAdRequest2 = this.r;
                    com.fyber.inneractive.sdk.flow.q qVar4 = this.s;
                    com.fyber.inneractive.sdk.response.e d = qVar4 == null ? null : qVar4.d();
                    com.fyber.inneractive.sdk.flow.q qVar5 = this.s;
                    if (qVar5 == null) {
                        jSONArray = null;
                    } else {
                        jSONArray = qVar5.c.c();
                    }
                    new s.a(qVar3, inneractiveAdRequest2, d, jSONArray).a("video_timeout_in_msecs", String.valueOf(5000)).a((String) null);
                }
                L l = this.g;
                if (l != null) {
                    ((i.h) l).a((InneractiveUnitController.AdDisplayError) new MraidVideoFailedToDisplayError("an MRAID video has not started playing in a timely fashion"));
                }
            } else if (str.toLowerCase().endsWith("fyMraidVideoAdCompleted".toLowerCase())) {
                L l2 = this.g;
                if (l2 instanceof i.m) {
                    ((i.m) l2).a();
                }
            }
            return true;
        }
    }

    public void a(boolean z) {
        g gVar;
        super.a(z);
        if (this.D && this.C && this.A && (gVar = this.b) != null) {
            StringBuilder sb = new StringBuilder("FyberMraidVideoController.");
            sb.append(z ? "play" : "pause");
            sb.append("();");
            gVar.a(sb.toString());
        }
        if (this.b != null && z) {
            a(1);
            a(100);
            a(250);
            a(1000);
        }
    }
}
