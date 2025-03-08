package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.measurement.tracker.c;
import com.fyber.inneractive.sdk.mraid.b0;
import com.fyber.inneractive.sdk.mraid.c0;
import com.fyber.inneractive.sdk.mraid.t;
import com.fyber.inneractive.sdk.mraid.u;
import com.fyber.inneractive.sdk.mraid.v;
import com.fyber.inneractive.sdk.mraid.y;
import com.fyber.inneractive.sdk.mraid.z;
import com.fyber.inneractive.sdk.network.l0;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.ui.IAcloseButton;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.d;
import com.fyber.inneractive.sdk.web.i.h;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.Partner;
import com.ironsource.m2;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public abstract class i<T extends h> extends a0<T> {
    public static final String[] p0 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    public b0 O = b0.HIDDEN;
    public final f P;
    public final j Q;
    public C0139i R;
    public ViewGroup S;
    public g T;
    public boolean U = false;
    public int V;
    public i<T>.k W;
    public IAcloseButton X;
    public boolean Y;
    public float Z;
    public int a0 = -1;
    public int b0 = -1;
    public int c0 = -1;
    public int d0 = -1;
    public int e0 = -1;
    public int f0 = -1;
    public Orientation g0 = Orientation.NONE;
    public int h0;
    public FrameLayout i0;
    public FrameLayout j0;
    public RelativeLayout k0;
    public int l0;
    public int m0;
    public OnBackInvokedCallback n0;
    public final ViewTreeObserver.OnPreDrawListener o0;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            i.this.r();
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        public boolean onPreDraw() {
            g gVar = i.this.b;
            if (gVar == null) {
                return false;
            }
            gVar.getViewTreeObserver().removeOnPreDrawListener(this);
            i iVar = i.this;
            iVar.a(iVar.b.getContext(), true);
            return false;
        }
    }

    public class c implements View.OnKeyListener {
        public c() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || !i.this.o()) {
                return false;
            }
            IAlog.d("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            i.this.r();
            return true;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            try {
                i iVar = i.this;
                if (iVar.W != null) {
                    IAlog.a("%sunregistering orientation broadcast receiver", IAlog.a((Object) iVar));
                    i.this.W.a();
                }
            } catch (IllegalArgumentException e) {
                if (e.getMessage() != null && !e.getMessage().contains("Receiver not registered")) {
                    throw e;
                }
            }
            i.this.W = null;
        }
    }

    public class e implements w<String> {
        public e() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            String str = (String) obj;
            if (exc != null || TextUtils.isEmpty(str)) {
                q.b.post(new n(this));
                return;
            }
            i iVar = i.this;
            if (iVar.l() != null) {
                g gVar = new g(iVar, str, (String) null);
                MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(iVar.l().getApplicationContext(), gVar);
                gVar.b = mediaScannerConnection;
                mediaScannerConnection.connect();
            }
        }
    }

    public enum f {
        ENABLED,
        DISABLED
    }

    public class g implements MediaScannerConnection.MediaScannerConnectionClient {
        public final String a;
        public MediaScannerConnection b;

        public g(i iVar, String str, String str2) {
            this.a = str;
        }

        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.b;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.a, (String) null);
            }
        }

        public void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.b;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    public interface h extends b0 {
        void a(InneractiveUnitController.AdDisplayError adDisplayError);

        void a(i iVar);

        void a(i iVar, b0 b0Var);

        void a(i iVar, boolean z);

        void a(i iVar, boolean z, Orientation orientation);

        boolean a(String str);

        void b(i iVar);

        void c();
    }

    /* renamed from: com.fyber.inneractive.sdk.web.i$i  reason: collision with other inner class name */
    public enum C0139i {
        INLINE,
        INTERSTITIAL
    }

    public enum j {
        ALWAYS_VISIBLE,
        ALWAYS_HIDDEN,
        AD_CONTROLLED
    }

    public class k extends BroadcastReceiver {
        public Context a;
        public int b = -1;

        public k() {
        }

        public void a() {
            try {
                i iVar = i.this;
                iVar.getClass();
                IAlog.a("%sunregister screen broadcast receiver called", IAlog.a((Object) iVar));
                if (this.a != null) {
                    i iVar2 = i.this;
                    iVar2.getClass();
                    IAlog.a("%sunregistering broadcast receiver", IAlog.a((Object) iVar2));
                    this.a.unregisterReceiver(this);
                    this.a = null;
                }
            } catch (Throwable th) {
                IAlog.e("IAmraidWebViewControllerBase: OrientationBroadcastReceiver: unregister: exception: %s", th.toString());
            }
        }

        public void onReceive(Context context, Intent intent) {
            int rotation;
            if (this.a != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) && (rotation = ((WindowManager) IAConfigManager.M.v.a().getSystemService("window")).getDefaultDisplay().getRotation()) != this.b) {
                this.b = rotation;
                i iVar = i.this;
                g gVar = iVar.b;
                if (gVar != null) {
                    gVar.getViewTreeObserver().removeOnPreDrawListener(iVar.o0);
                    iVar.b.getViewTreeObserver().addOnPreDrawListener(iVar.o0);
                }
            }
        }
    }

    public class l implements d.c {
        public com.fyber.inneractive.sdk.mraid.a a;

        public l(com.fyber.inneractive.sdk.mraid.a aVar, p0 p0Var) {
            this.a = aVar;
        }

        public String a() {
            return this.a.c();
        }

        public void d() {
            IAmraidWebViewController iAmraidWebViewController = (IAmraidWebViewController) i.this;
            if (iAmraidWebViewController.J != null) {
                iAmraidWebViewController.J.b();
            }
            this.a.a();
        }

        public String toString() {
            return "action = " + this.a.a + " url = " + this.a.c();
        }

        public void b() {
            com.fyber.inneractive.sdk.mraid.a aVar = this.a;
            if (aVar != null) {
                aVar.d();
            }
        }

        public String c() {
            return this.a.a;
        }
    }

    public interface m extends h {
        void a();
    }

    public static abstract class n implements h {
        public void a(boolean z) {
        }
    }

    public i(boolean z, boolean z2, C0139i iVar, f fVar, j jVar, com.fyber.inneractive.sdk.measurement.a aVar, s sVar) {
        super(z, z2, iVar, sVar);
        this.I = aVar;
        this.R = iVar;
        this.P = fVar;
        this.Q = jVar;
        this.o0 = new b();
    }

    public void a(boolean z) {
        a((u) new c0(z));
        super.a(z);
    }

    public void b(boolean z) {
        v();
        g gVar = this.T;
        if (!(gVar == null || gVar.getParent() == null || !(this.T.getParent() instanceof ViewGroup))) {
            ((ViewGroup) this.T.getParent()).removeView(this.T);
            this.T = null;
        }
        t();
        this.a = false;
        if (Build.VERSION.SDK_INT >= 33) {
            u();
        }
        super.b(z);
    }

    public final Date c(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = p0;
            if (i >= strArr.length) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    public final void e(boolean z) {
        try {
            Activity activity = (Activity) l();
            if (activity == null) {
                return;
            }
            if (!z || activity.getResources() == null || activity.getResources().getConfiguration() == null) {
                activity.setRequestedOrientation(this.V);
            } else {
                activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation);
            }
        } catch (Exception unused) {
            IAlog.a("Failed to modify the device orientation.", new Object[0]);
        }
    }

    public p0 f() {
        g gVar;
        if (this.O == b0.EXPANDED && (gVar = this.T) != null) {
            return gVar.getLastClickedLocation();
        }
        g gVar2 = this.b;
        return gVar2 != null ? gVar2.getLastClickedLocation() : p0.a();
    }

    public void g() {
        com.fyber.inneractive.sdk.measurement.tracker.c cVar;
        com.fyber.inneractive.sdk.measurement.tracker.c cVar2;
        com.fyber.inneractive.sdk.measurement.a aVar = this.I;
        if (aVar != null) {
            g gVar = this.b;
            com.fyber.inneractive.sdk.flow.q qVar = this.s;
            com.fyber.inneractive.sdk.measurement.b bVar = (com.fyber.inneractive.sdk.measurement.b) aVar;
            bVar.getClass();
            boolean z = false;
            IAlog.a("omsdk initMraidSession", new Object[0]);
            if (bVar.e == null) {
                IAlog.a("omsdk partner is null", new Object[0]);
                cVar = null;
            } else {
                if (!(qVar == null || qVar.d() == null || !qVar.d().H)) {
                    z = true;
                }
                com.fyber.inneractive.sdk.measurement.tracker.d dVar = bVar.f;
                Partner partner = bVar.e;
                dVar.getClass();
                if (z) {
                    cVar2 = new com.fyber.inneractive.sdk.measurement.tracker.b(partner, gVar, qVar);
                } else {
                    cVar2 = new com.fyber.inneractive.sdk.measurement.tracker.a(partner, gVar, qVar);
                }
                cVar = cVar2;
                cVar.a((WebView) gVar);
            }
            this.J = cVar;
        }
        d.C0138d dVar2 = this.f;
        if (dVar2 != null) {
            dVar2.a(this);
        }
    }

    public void h() {
        super.h();
        this.O = b0.LOADING;
        Context l2 = l();
        this.V = l2 instanceof Activity ? ((Activity) l2).getRequestedOrientation() : -1;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        this.j0 = new FrameLayout(iAConfigManager.v.a());
        this.k0 = new RelativeLayout(iAConfigManager.v.a());
        FrameLayout frameLayout = new FrameLayout(iAConfigManager.v.a());
        frameLayout.setBackgroundColor(-858993460);
        this.i0 = frameLayout;
        a(l2, false);
        this.b.setOnKeyListener(new c());
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

    public boolean o() {
        return this.O == b0.EXPANDED;
    }

    public boolean p() {
        C0139i iVar = this.R;
        return iVar != null && iVar.equals(C0139i.INTERSTITIAL);
    }

    public void r() {
        g gVar;
        RelativeLayout a2 = a((View) this.S);
        if (a2 == null) {
            a2 = a((View) this.b);
        }
        this.U = false;
        if (o() || s()) {
            d(false);
            g gVar2 = this.b;
            if (gVar2 != null) {
                b0 b0Var = this.O;
                if (b0Var == b0.EXPANDED) {
                    t();
                    ViewGroup viewGroup = (ViewGroup) this.i0.getParent();
                    if (viewGroup != null) {
                        viewGroup.addView(this.b, this.h0, com.fyber.inneractive.sdk.util.u.a(this.l0, this.m0, 13));
                        viewGroup.removeView(this.i0);
                        viewGroup.invalidate();
                        this.b.requestLayout();
                    }
                    this.e0 = this.l0;
                    this.f0 = this.m0;
                } else if (b0Var == b0.RESIZED) {
                    this.e0 = this.l0;
                    this.f0 = this.m0;
                    ViewGroup.LayoutParams layoutParams = gVar2.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.b.setLayoutParams(com.fyber.inneractive.sdk.util.u.a(this.l0, this.m0, 13));
                    } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                        this.b.setLayoutParams(new FrameLayout.LayoutParams(this.l0, this.m0, 17));
                    }
                }
            }
            if (!(a2 == null || (gVar = this.b) == null)) {
                a2.setLayoutParams(gVar.getLayoutParams());
                if (o()) {
                    com.fyber.inneractive.sdk.util.u.a((View) a2);
                    this.b.addView(a2);
                }
            }
            this.O = b0.DEFAULT;
            e(false);
            a((u) new z(this.O));
        } else if (this.O == b0.DEFAULT) {
            g gVar3 = this.b;
            if (gVar3 != null) {
                gVar3.setVisibility(4);
            }
            b0 b0Var2 = b0.HIDDEN;
            this.O = b0Var2;
            a((u) new z(b0Var2));
        }
        if (a2 != null) {
            a2.setPadding(0, 0, 0, 0);
        }
        L l2 = this.g;
        if (l2 != null) {
            ((h) l2).a(this, this.O);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            u();
        }
    }

    public boolean s() {
        return this.O == b0.RESIZED;
    }

    public void setAdDefaultSize(int i, int i2) {
        this.l0 = i;
        this.m0 = i2;
        this.e0 = i;
        this.f0 = i2;
    }

    public void setOrientationProperties(boolean z, String str) {
        if (m2.h.D.equals(str)) {
            this.g0 = Orientation.PORTRAIT;
        } else if (m2.h.C.equals(str)) {
            this.g0 = Orientation.LANDSCAPE;
        } else {
            this.g0 = Orientation.NONE;
        }
        L l2 = this.g;
        if (l2 != null) {
            ((h) l2).a(this, z, this.g0);
        }
    }

    public void setResizeProperties() {
    }

    public final void u() {
        try {
            if ((l() instanceof Activity) && this.n0 != null) {
                ((Activity) l()).getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.n0);
                this.n0 = null;
            }
        } catch (Exception e2) {
            IAlog.e("failed to unregisterOnBackInvokedCallback with error: %s", e2.getMessage());
        }
    }

    public void v() {
        g gVar = this.b;
        if (!(gVar == null || gVar.getViewTreeObserver() == null)) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.o0);
        }
        q.b.post(new d());
    }

    public final void t() {
        FrameLayout frameLayout = this.j0;
        if (frameLayout != null && this.k0 != null) {
            frameLayout.removeAllViewsInLayout();
            this.k0.removeAllViewsInLayout();
            ViewGroup viewGroup = this.S;
            if (viewGroup != null) {
                viewGroup.removeView(this.k0);
            }
        }
    }

    public void a() {
        q.b.post(new j(this));
    }

    public void c(boolean z) {
        this.Y = z;
        L l2 = this.g;
        if (l2 != null) {
            ((h) l2).a(this, z);
        }
    }

    public void d(boolean z) {
        if (this.S != null) {
            if (z) {
                int a2 = p.a(35);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = p.a(10);
                layoutParams.topMargin = p.a(10);
                if (this.X == null) {
                    IAcloseButton iAcloseButton = new IAcloseButton(l(), a2, true);
                    this.X = iAcloseButton;
                    iAcloseButton.setOnClickListener(new a());
                }
                com.fyber.inneractive.sdk.util.u.a((View) this.X);
                this.k0.addView(this.X, layoutParams);
            } else {
                this.k0.removeView(this.X);
            }
            L l2 = this.g;
            if (l2 != null) {
                ((h) l2).a(this, z);
            }
            this.Y = !z;
        }
    }

    public boolean a(WebView webView, String str) {
        IAlog.a("%shandle url for: %s webView = %s", IAlog.a((Object) this), str, webView);
        if (this.O != b0.EXPANDED || TextUtils.isEmpty(str) || !webView.equals(this.T) || this.U) {
            return super.a(webView, str);
        }
        this.U = true;
        return false;
    }

    public void a(Context context, boolean z) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) IAConfigManager.M.v.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.Z = displayMetrics.density;
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
            double d4 = 160.0d / ((double) displayMetrics.densityDpi);
            this.c0 = (int) (d2 * d4);
            this.d0 = (int) (((double) i5) * d4);
        } else {
            i3 = this.b.getWidthDp();
            i4 = this.b.getHeightDp();
            int a4 = (p.a(this.b.getHeightDp()) - a2) - a3;
            this.c0 = this.a0;
            this.d0 = (int) (((double) a4) * (160.0d / ((double) displayMetrics.densityDpi)));
        }
        if (this.a0 != i3 || this.b0 != i4) {
            this.a0 = i3;
            this.b0 = i4;
            if (z) {
                a((u) new y(i3, i4));
                a((u) new com.fyber.inneractive.sdk.mraid.w(this.c0, this.d0));
                a((u) new v(0, 0, this.c0, this.d0));
                int i6 = this.e0;
                if (i6 <= 0 || this.f0 <= 0) {
                    g gVar2 = this.b;
                    if (gVar2 != null && gVar2.getWidth() > 0 && this.b.getHeight() > 0) {
                        a((u) new t(p.b(this.b.getWidth()), p.b(this.b.getHeight())));
                        return;
                    }
                    return;
                }
                a((u) new t(p.b(i6), p.b(this.f0)));
            }
        }
    }

    public void b(String str) {
        g gVar = this.b;
        if (gVar != null) {
            gVar.a("window.mraidbridge.nativeCallComplete('" + str + "');");
        }
    }

    public void b() {
        v();
    }

    public void b(View view) {
        a.C0101a aVar = this.J;
        if (aVar != null) {
            com.fyber.inneractive.sdk.measurement.tracker.c cVar = (com.fyber.inneractive.sdk.measurement.tracker.c) aVar;
            cVar.getClass();
            try {
                AdSession adSession = cVar.a;
                if (adSession != null && view != null) {
                    adSession.removeFriendlyObstruction(view);
                }
            } catch (Throwable th) {
                cVar.a(th);
            }
        }
    }

    public final Map<String, Object> a(Map<String, String> map) throws Exception {
        String str;
        HashMap hashMap = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start")) {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        hashMap.put(m2.h.D0, map.get("description"));
        if (!map.containsKey("start") || map.get("start") == null) {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        Date c2 = c(map.get("start"));
        if (c2 != null) {
            hashMap.put("beginTime", Long.valueOf(c2.getTime()));
            if (map.containsKey("end") && map.get("end") != null) {
                Date c3 = c(map.get("end"));
                if (c3 != null) {
                    hashMap.put("endTime", Long.valueOf(c3.getTime()));
                } else {
                    throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                }
            }
            if (map.containsKey("location")) {
                hashMap.put("eventLocation", map.get("location"));
            }
            if (map.containsKey("summary")) {
                hashMap.put("description", map.get("summary"));
            }
            if (map.containsKey("transparency")) {
                hashMap.put("availability", Integer.valueOf(m2.h.T.equals(map.get("transparency")) ? 1 : 0));
            }
            StringBuilder sb = new StringBuilder();
            if (map.containsKey("frequency")) {
                String str2 = map.get("frequency");
                int parseInt = map.containsKey("interval") ? Integer.parseInt(map.get("interval")) : -1;
                if ("daily".equals(str2)) {
                    sb.append("FREQ=DAILY;");
                    if (parseInt != -1) {
                        sb.append("INTERVAL=" + parseInt + ";");
                    }
                } else {
                    if ("weekly".equals(str2)) {
                        sb.append("FREQ=WEEKLY;");
                        if (parseInt != -1) {
                            sb.append("INTERVAL=" + parseInt + ";");
                        }
                        if (map.containsKey("daysInWeek")) {
                            StringBuilder sb2 = new StringBuilder();
                            boolean[] zArr = new boolean[7];
                            String[] split = map.get("daysInWeek").split(",");
                            for (String parseInt2 : split) {
                                int parseInt3 = Integer.parseInt(parseInt2);
                                if (parseInt3 == 7) {
                                    parseInt3 = 0;
                                }
                                if (!zArr[parseInt3]) {
                                    StringBuilder sb3 = new StringBuilder();
                                    switch (parseInt3) {
                                        case 0:
                                            str = "SU";
                                            break;
                                        case 1:
                                            str = "MO";
                                            break;
                                        case 2:
                                            str = "TU";
                                            break;
                                        case 3:
                                            str = "WE";
                                            break;
                                        case 4:
                                            str = "TH";
                                            break;
                                        case 5:
                                            str = "FR";
                                            break;
                                        case 6:
                                            str = "SA";
                                            break;
                                        default:
                                            throw new IllegalArgumentException("invalid day of week " + parseInt3);
                                    }
                                    sb3.append(str);
                                    sb3.append(",");
                                    sb2.append(sb3.toString());
                                    zArr[parseInt3] = true;
                                }
                            }
                            if (split.length != 0) {
                                sb2.deleteCharAt(sb2.length() - 1);
                                String sb4 = sb2.toString();
                                if (sb4 != null) {
                                    sb.append("BYDAY=" + sb4 + ";");
                                } else {
                                    throw new IllegalArgumentException("invalid ");
                                }
                            } else {
                                throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                            }
                        }
                    } else if ("monthly".equals(str2)) {
                        sb.append("FREQ=MONTHLY;");
                        if (parseInt != -1) {
                            sb.append("INTERVAL=" + parseInt + ";");
                        }
                        if (map.containsKey("daysInMonth")) {
                            StringBuilder sb5 = new StringBuilder();
                            boolean[] zArr2 = new boolean[63];
                            String[] split2 = map.get("daysInMonth").split(",");
                            for (String parseInt4 : split2) {
                                int parseInt5 = Integer.parseInt(parseInt4);
                                int i = parseInt5 + 31;
                                if (!zArr2[i]) {
                                    StringBuilder sb6 = new StringBuilder();
                                    if (parseInt5 == 0 || parseInt5 < -31 || parseInt5 > 31) {
                                        throw new IllegalArgumentException("invalid day of month " + parseInt5);
                                    }
                                    sb6.append("" + parseInt5);
                                    sb6.append(",");
                                    sb5.append(sb6.toString());
                                    zArr2[i] = true;
                                }
                            }
                            if (split2.length != 0) {
                                sb5.deleteCharAt(sb5.length() - 1);
                                String sb7 = sb5.toString();
                                if (sb7 != null) {
                                    sb.append("BYMONTHDAY=" + sb7 + ";");
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                }
            }
            String sb8 = sb.toString();
            if (!TextUtils.isEmpty(sb8)) {
                hashMap.put("rrule", sb8);
            }
            return hashMap;
        }
        throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
    }

    public final void a(String str) {
        new File(Environment.getExternalStorageDirectory(), "Pictures").mkdirs();
        com.fyber.inneractive.sdk.flow.q qVar = this.s;
        l0 l0Var = new l0(new e(), str, qVar != null ? qVar.c : null);
        IAConfigManager.M.s.a.offer(l0Var);
        l0Var.a(r0.QUEUED);
    }

    public void a(com.fyber.inneractive.sdk.mraid.g gVar, String str) {
        String e2 = gVar.e();
        g gVar2 = this.b;
        if (gVar2 != null) {
            gVar2.a("window.mraidbridge.fireErrorEvent('" + e2 + "', '" + str + "');");
        }
    }

    public final Map<String, String> a(URI uri) throws UnsupportedEncodingException {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            for (String str : rawQuery.split(m2.i.c)) {
                int indexOf = str.indexOf(m2.i.b);
                linkedHashMap.put(indexOf > 0 ? URLDecoder.decode(str.substring(0, indexOf), "UTF-8") : str, (indexOf <= 0 || str.length() <= (i = indexOf + 1)) ? null : URLDecoder.decode(str.substring(i), "UTF-8"));
            }
        }
        return linkedHashMap;
    }

    public void a(View view, c.C0103c cVar) {
        a.C0101a aVar;
        if (view != null && (aVar = this.J) != null) {
            com.fyber.inneractive.sdk.measurement.tracker.c cVar2 = (com.fyber.inneractive.sdk.measurement.tracker.c) aVar;
            cVar2.getClass();
            try {
                AdSession adSession = cVar2.a;
                if (adSession == null) {
                    return;
                }
                if (cVar == c.C0103c.CloseButton) {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.CLOSE_AD, cVar.name());
                } else {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, cVar.name());
                }
            } catch (Throwable th) {
                cVar2.a(th);
            }
        }
    }

    public final void a(com.fyber.inneractive.sdk.mraid.g gVar) {
        s sVar;
        r rVar = r.BANNER_RESIZE_EXPAND;
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.flow.q qVar = this.s;
        com.fyber.inneractive.sdk.response.e d2 = qVar != null ? qVar.d() : null;
        com.fyber.inneractive.sdk.flow.q qVar2 = this.s;
        new s.a(rVar, inneractiveAdRequest, d2, (qVar2 == null || (sVar = qVar2.c) == null) ? null : sVar.c()).a(m2.h.h, gVar.e()).a((String) null);
    }

    public final RelativeLayout a(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ia_identifier_overlay);
        if (viewGroup instanceof RelativeLayout) {
            return (RelativeLayout) viewGroup;
        }
        return null;
    }
}
