package com.fyber.inneractive.sdk.player.controller;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.work.impl.Scheduler;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.m;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.controller.w;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.player.ui.f;
import com.fyber.inneractive.sdk.player.ui.i;
import com.fyber.inneractive.sdk.player.ui.l;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.s0;
import com.fyber.inneractive.sdk.web.b;
import com.iab.omid.library.fyber.adsession.media.InteractionType;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class n<ListenerT extends w> implements b<ListenerT>, g.f, g.e, i {
    public Skip A;
    public boolean B;
    public com.fyber.inneractive.sdk.player.c a;
    public b0 b;
    public s c;
    public l d;
    public g.C0109g e;
    public int f;
    public ListenerT g;
    public boolean h;
    public float i;
    public Runnable j;
    public boolean k;
    public boolean l;
    public Application.ActivityLifecycleCallbacks m;
    public boolean n;
    public boolean o;
    public Bitmap p;
    public com.fyber.inneractive.sdk.util.b<?, ?, ?> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public k w;
    public f x;
    public String y;
    public boolean z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fyber.inneractive.sdk.player.enums.b[] r0 = com.fyber.inneractive.sdk.player.enums.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Prepared     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Buffering     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Playing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Paused     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Completed     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Error     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Preparing     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Seeking     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.n.a.<clinit>():void");
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b(n nVar) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }
    }

    public class c implements s0.a {
        public c() {
        }

        public void a(Bitmap bitmap) {
            n nVar = n.this;
            nVar.a(nVar.d, bitmap, true, true);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ s0.a b;

        public class a implements Runnable {
            public final /* synthetic */ Bitmap a;

            public a(Bitmap bitmap) {
                this.a = bitmap;
            }

            public void run() {
                s0.a aVar = e.this.b;
                if (aVar != null) {
                    aVar.a(this.a);
                }
            }
        }

        public e(boolean z, s0.a aVar) {
            this.a = z;
            this.b = aVar;
        }

        public void run() {
            com.fyber.inneractive.sdk.player.c cVar;
            g gVar;
            n nVar = n.this;
            boolean z = this.a;
            Bitmap bitmap = null;
            if (!(nVar.p == null || (cVar = nVar.a) == null || (gVar = cVar.b) == null)) {
                if (nVar.o) {
                    bitmap = cVar.k;
                } else {
                    TextureView textureView = gVar.j;
                    Object[] objArr = new Object[3];
                    objArr[0] = IAlog.a((Object) nVar);
                    objArr[1] = textureView;
                    objArr[2] = Boolean.valueOf(textureView != null && textureView.isAvailable());
                    IAlog.a("%sSave snapshot entered: tv = %s avail = %s", objArr);
                    if (textureView != null && textureView.isAvailable()) {
                        try {
                            IAlog.d("creating bitmap on object - %s", nVar.p);
                            Bitmap bitmap2 = textureView.getBitmap(nVar.p);
                            if (nVar.d.getVideoWidth() > 0 && nVar.d.getVideoHeight() > 0) {
                                nVar.p = null;
                                nVar.a(nVar.d.getVideoWidth(), nVar.d.getVideoHeight());
                            }
                            if (z) {
                                nVar.a.a(s0.a(nVar.d.getContext(), bitmap2));
                                nVar.o = true;
                            } else {
                                nVar.a.a(bitmap2);
                            }
                            IAlog.d("%ssave snapshot succeeded", IAlog.a((Object) nVar));
                            bitmap = nVar.a.k;
                        } catch (Exception unused) {
                            IAlog.d("%ssave snapshot failed with exception", IAlog.a((Object) nVar));
                        }
                    }
                }
            }
            q.b.post(new a(bitmap));
        }
    }

    public n(com.fyber.inneractive.sdk.player.c cVar, l lVar, b0 b0Var, s sVar, boolean z2, String str, boolean z3) {
        this(cVar, lVar, b0Var, sVar, z2, (Skip) null, str, z3);
    }

    public void A() {
        g gVar;
        this.d.a(false);
        this.d.c(false);
        l lVar = this.d;
        com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
        cVar.b = false;
        lVar.d(new com.fyber.inneractive.sdk.player.ui.b(cVar));
        j();
        if (this.a != null && B() && !this.h) {
            int d2 = this.a.b.d();
            com.fyber.inneractive.sdk.player.c cVar2 = this.a;
            if (com.fyber.inneractive.sdk.player.c.a(d2, ((com.fyber.inneractive.sdk.player.e) cVar2).y, com.fyber.inneractive.sdk.player.c.a(cVar2))) {
                if (this.f <= 0) {
                    this.d.d(true);
                    n();
                } else {
                    com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                    if (cVar3 != null && (gVar = cVar3.b) != null && this.f >= gVar.d() / 1000) {
                        this.d.d(false);
                    } else if (!this.s) {
                        this.d.d(true);
                        c(this.f);
                        this.s = true;
                    }
                }
            }
        }
        ListenerT listenert = this.g;
        if (listenert != null && !this.k) {
            this.k = true;
            listenert.l();
        }
        this.o = false;
        this.t = false;
    }

    public abstract boolean B();

    public void C() {
        s sVar;
        s sVar2 = this.c;
        String str = null;
        r rVar = sVar2 != null ? (r) sVar2.a(r.class) : null;
        boolean z2 = true;
        boolean a2 = rVar != null ? rVar.a("show_cta", true) : true;
        ListenerT listenert = this.g;
        if (listenert != null) {
            this.w = listenert.q();
        }
        k kVar = this.w;
        if (kVar == k.NONE) {
            z2 = a2;
        }
        l lVar = this.d;
        if (lVar.k != null) {
            int i2 = 0;
            lVar.k.setAllCaps((!z2 || (sVar = lVar.L) == null || sVar.a(r.class) == null) ? false : ((r) lVar.L.a(r.class)).d());
            s sVar3 = lVar.L;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar3 != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar3.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.a;
                }
            }
            if (IAConfigManager.M.E.d() && kVar.e()) {
                lVar.k.setText(R.string.ia_video_instant_install_text);
            } else if (!TextUtils.isEmpty(str)) {
                lVar.k.setText(str);
            } else {
                lVar.k.setText(R.string.ia_video_install_now_text);
            }
            if (!TextUtils.isEmpty(lVar.O)) {
                lVar.k.setText(lVar.O);
            }
            TextView textView = lVar.k;
            if (!z2) {
                i2 = 4;
            }
            textView.setVisibility(i2);
        }
    }

    public void E() {
        l lVar = this.d;
        if (lVar.v != null) {
            lVar.setMuteButtonState(t());
        }
    }

    public final int a(r rVar) {
        if (rVar == null) {
            return 500;
        }
        Integer b2 = rVar.b("endcard_animation_duration");
        int intValue = b2 != null ? b2.intValue() : 500;
        if (intValue < 500 || intValue > 3000) {
            return 500;
        }
        return intValue;
    }

    public void a(ListenerT listenert) {
        this.g = listenert;
    }

    public abstract void a(p0 p0Var);

    public void a(Exception exc) {
    }

    public final r.c b(r rVar) {
        if (rVar == null) {
            return r.f;
        }
        String a2 = rVar.a("endcard_animation_type", r.f.mKey);
        for (r.c cVar : r.c.values()) {
            if (a2.equalsIgnoreCase(cVar.mKey)) {
                return cVar;
            }
        }
        return r.c.NONE;
    }

    public void b() {
    }

    public final int c(r rVar) {
        if (rVar == null) {
            return 3;
        }
        Integer b2 = rVar.b("autoClickDelay");
        int intValue = b2 != null ? b2.intValue() : 3;
        if (intValue < 0 || intValue > 10) {
            return 3;
        }
        return intValue;
    }

    public boolean d() {
        return this.z;
    }

    public final boolean d(r rVar) {
        return rVar != null && rVar.a("shouldEnableEndCardAutoClick", false);
    }

    public void e(boolean z2) {
    }

    public void n() {
        if (B()) {
            s sVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.b;
                }
            }
            if (!TextUtils.isEmpty(this.y) || str == null) {
                l lVar = this.d;
                lVar.setSkipText(lVar.getContext().getString(R.string.ia_video_skip_text));
            } else {
                this.d.setSkipText(str);
            }
            this.d.c();
            this.f = 0;
            ListenerT listenert = this.g;
            if (listenert != null) {
                listenert.e();
            }
        }
    }

    public abstract int o();

    public com.fyber.inneractive.sdk.config.global.features.b p() {
        s sVar = this.c;
        if (sVar == null || sVar.a(com.fyber.inneractive.sdk.config.global.features.b.class) == null || ((ArrayList) ((com.fyber.inneractive.sdk.config.global.features.b) this.c.a(com.fyber.inneractive.sdk.config.global.features.b.class)).c()).size() <= 0) {
            return null;
        }
        return (com.fyber.inneractive.sdk.config.global.features.b) this.c.a(com.fyber.inneractive.sdk.config.global.features.b.class);
    }

    public int q() {
        int i2;
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.b;
        String num = Integer.toString(30);
        if (iVar.a.containsKey("max_rv_tsec")) {
            num = iVar.a.get("max_rv_tsec");
        }
        try {
            i2 = Integer.parseInt(num);
        } catch (Throwable unused) {
            i2 = 30;
        }
        if (i2 < 1) {
            return 30;
        }
        return i2;
    }

    public abstract int s();

    public abstract void u();

    public void v() {
        if (!this.d.f()) {
            this.d.a(false);
            j();
            D();
            this.k = false;
            this.h = true;
        }
    }

    public abstract void w();

    public void x() {
        j();
        this.d.a(false);
        D();
    }

    public abstract void y();

    public void z() {
    }

    public n(com.fyber.inneractive.sdk.player.c cVar, l lVar, b0 b0Var, s sVar, boolean z2, Skip skip, String str, boolean z3) {
        this.f = 0;
        this.h = false;
        this.i = -0.1f;
        this.l = false;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = k.NONE;
        this.B = false;
        this.A = skip;
        this.a = cVar;
        this.b = b0Var;
        this.c = sVar;
        this.d = lVar;
        this.n = z2;
        this.y = str;
        this.z = z3;
        lVar.setListener(this);
        i();
        new GestureDetector(lVar.getContext(), new b(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.fyber.inneractive.sdk.config.global.features.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.fyber.inneractive.sdk.model.vast.h} */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D() {
        /*
            r8 = this;
            com.fyber.inneractive.sdk.player.c r0 = r8.a
            if (r0 == 0) goto L_0x001f
            com.fyber.inneractive.sdk.player.controller.g r0 = r0.b
            if (r0 == 0) goto L_0x0012
            com.fyber.inneractive.sdk.player.enums.b r0 = r0.e
            com.fyber.inneractive.sdk.player.enums.b r1 = com.fyber.inneractive.sdk.player.enums.b.Completed
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0016
        L_0x0012:
            boolean r0 = r8.t
            if (r0 == 0) goto L_0x001f
        L_0x0016:
            com.fyber.inneractive.sdk.player.c r0 = r8.a
            com.fyber.inneractive.sdk.measurement.d r0 = r0.h
            if (r0 == 0) goto L_0x001f
            r0.a()
        L_0x001f:
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.j r1 = r0.u
            com.fyber.inneractive.sdk.config.i r1 = r1.b
            java.lang.String r2 = "endcard"
            com.fyber.inneractive.sdk.config.g r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = "dsos"
            r3 = 0
            boolean r1 = r1.a(r2, r3)
            com.fyber.inneractive.sdk.player.c r2 = r8.a
            r4 = 1
            if (r2 == 0) goto L_0x0046
            com.fyber.inneractive.sdk.player.controller.g r2 = r2.b
            if (r2 == 0) goto L_0x0046
            com.fyber.inneractive.sdk.player.enums.b r2 = r2.e
            com.fyber.inneractive.sdk.player.enums.b r5 = com.fyber.inneractive.sdk.player.enums.b.Completed
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0046
            goto L_0x0050
        L_0x0046:
            boolean r2 = r8.t
            if (r2 == 0) goto L_0x004c
            if (r1 == 0) goto L_0x0050
        L_0x004c:
            boolean r5 = r8.u
            if (r5 == 0) goto L_0x0295
        L_0x0050:
            com.fyber.inneractive.sdk.player.c r1 = r8.a
            r2 = 0
            if (r1 == 0) goto L_0x005a
            android.view.View r1 = r1.b()
            goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            if (r1 == 0) goto L_0x005f
            r5 = 1
            goto L_0x0060
        L_0x005f:
            r5 = 0
        L_0x0060:
            com.fyber.inneractive.sdk.player.ui.l r6 = r8.d
            r6.d()
            com.fyber.inneractive.sdk.config.global.s r6 = r8.c
            if (r6 == 0) goto L_0x0072
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r7 = com.fyber.inneractive.sdk.config.global.features.r.class
            com.fyber.inneractive.sdk.config.global.features.g r6 = r6.a(r7)
            com.fyber.inneractive.sdk.config.global.features.r r6 = (com.fyber.inneractive.sdk.config.global.features.r) r6
            goto L_0x0073
        L_0x0072:
            r6 = r2
        L_0x0073:
            if (r5 == 0) goto L_0x0134
            boolean r0 = r1 instanceof com.fyber.inneractive.sdk.web.g
            if (r0 == 0) goto L_0x00b5
            com.fyber.inneractive.sdk.player.c r0 = r8.a
            if (r0 == 0) goto L_0x0086
            com.fyber.inneractive.sdk.player.e r0 = (com.fyber.inneractive.sdk.player.e) r0
            com.fyber.inneractive.sdk.flow.m r0 = r0.z
            if (r0 == 0) goto L_0x0086
            com.fyber.inneractive.sdk.player.controller.c r0 = r0.n
            goto L_0x0087
        L_0x0086:
            r0 = r2
        L_0x0087:
            if (r0 == 0) goto L_0x00a8
            com.fyber.inneractive.sdk.player.controller.s r5 = new com.fyber.inneractive.sdk.player.controller.s
            r5.<init>(r8)
            com.fyber.inneractive.sdk.web.a0 r7 = r0.a
            if (r7 == 0) goto L_0x0095
            r7.setListener(r5)
        L_0x0095:
            com.fyber.inneractive.sdk.web.a0 r5 = r0.a
            if (r5 == 0) goto L_0x00a1
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r7 = r0.c
            com.fyber.inneractive.sdk.util.c0.a(r7)
            r5.n()
        L_0x00a1:
            com.fyber.inneractive.sdk.web.a0 r5 = r0.a
            if (r5 == 0) goto L_0x00a8
            r5.a((boolean) r4)
        L_0x00a8:
            if (r0 == 0) goto L_0x00b5
            com.fyber.inneractive.sdk.web.a0 r0 = r0.a
            if (r0 == 0) goto L_0x00b5
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x00b5
            return
        L_0x00b5:
            r8.l()
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.b((boolean) r3)
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            android.view.ViewGroup r0 = r0.j
            if (r0 == 0) goto L_0x00c7
            r5 = 4
            r0.setVisibility(r5)
        L_0x00c7:
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.c((boolean) r3)
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            com.fyber.inneractive.sdk.player.c r5 = r8.a
            if (r5 == 0) goto L_0x00d7
            com.fyber.inneractive.sdk.model.vast.c r5 = r5.c()
            goto L_0x00d8
        L_0x00d7:
            r5 = r2
        L_0x00d8:
            com.fyber.inneractive.sdk.player.ui.c r7 = new com.fyber.inneractive.sdk.player.ui.c
            r7.<init>()
            r7.b = r4
            r7.g = r1
            if (r5 == 0) goto L_0x00e5
            com.fyber.inneractive.sdk.model.vast.h r2 = r5.a
        L_0x00e5:
            r7.h = r2
            if (r6 == 0) goto L_0x00f1
            boolean r2 = r6.d()
            if (r2 == 0) goto L_0x00f1
            r2 = 1
            goto L_0x00f2
        L_0x00f1:
            r2 = 0
        L_0x00f2:
            r7.c = r2
            com.fyber.inneractive.sdk.config.global.features.r$c r2 = r8.b(r6)
            int r5 = r8.a((com.fyber.inneractive.sdk.config.global.features.r) r6)
            r7.i = r2
            r7.j = r5
            boolean r2 = r8.d((com.fyber.inneractive.sdk.config.global.features.r) r6)
            if (r2 == 0) goto L_0x0116
            com.fyber.inneractive.sdk.flow.vast.e r2 = r8.c()
            if (r2 == 0) goto L_0x0115
            boolean r5 = r2.a
            if (r5 == 0) goto L_0x0115
            android.view.View r2 = r2.b
            if (r2 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r3 = 1
        L_0x0116:
            int r2 = r8.c((com.fyber.inneractive.sdk.config.global.features.r) r6)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r3 == 0) goto L_0x0122
            r7.f = r2
        L_0x0122:
            com.fyber.inneractive.sdk.player.ui.b r2 = new com.fyber.inneractive.sdk.player.ui.b
            r2.<init>(r7)
            r0.a((com.fyber.inneractive.sdk.player.ui.b) r2)
            com.fyber.inneractive.sdk.model.vast.h r0 = com.fyber.inneractive.sdk.model.vast.h.Other
            r8.a((com.fyber.inneractive.sdk.model.vast.h) r0, (int) r4)
            r1.requestFocus()
            goto L_0x02a9
        L_0x0134:
            boolean r1 = r8.z
            if (r1 != 0) goto L_0x0141
            ListenerT r1 = r8.g
            if (r1 == 0) goto L_0x0141
            r1.k()
            goto L_0x02a9
        L_0x0141:
            com.fyber.inneractive.sdk.player.ui.f r1 = r8.x
            if (r1 == 0) goto L_0x014e
            com.fyber.inneractive.sdk.player.controller.p r1 = new com.fyber.inneractive.sdk.player.controller.p
            r1.<init>(r8)
            r8.a((boolean) r4, (com.fyber.inneractive.sdk.util.s0.a) r1)
            goto L_0x015b
        L_0x014e:
            com.fyber.inneractive.sdk.player.c r1 = r8.a
            if (r1 == 0) goto L_0x0155
            android.graphics.Bitmap r1 = r1.k
            goto L_0x0156
        L_0x0155:
            r1 = r2
        L_0x0156:
            com.fyber.inneractive.sdk.player.ui.l r5 = r8.d
            r8.a(r5, r1, r3, r3)
        L_0x015b:
            com.fyber.inneractive.sdk.flow.vast.e r1 = r8.c()
            if (r1 == 0) goto L_0x01aa
            boolean r5 = r1.a
            if (r5 == 0) goto L_0x01aa
            android.view.View r5 = r1.b
            if (r5 == 0) goto L_0x01aa
            com.fyber.inneractive.sdk.player.controller.c r0 = r1.g
            com.fyber.inneractive.sdk.player.controller.s r2 = new com.fyber.inneractive.sdk.player.controller.s
            r2.<init>(r8)
            com.fyber.inneractive.sdk.web.a0 r0 = r0.a
            if (r0 == 0) goto L_0x0177
            r0.setListener(r2)
        L_0x0177:
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.b((boolean) r4)
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            com.fyber.inneractive.sdk.player.ui.c r2 = new com.fyber.inneractive.sdk.player.ui.c
            r2.<init>()
            r2.b = r4
            android.view.View r1 = r1.b
            r2.g = r1
            com.fyber.inneractive.sdk.model.vast.h r1 = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card
            r2.h = r1
            boolean r3 = r8.d((com.fyber.inneractive.sdk.config.global.features.r) r6)
            int r5 = r8.c((com.fyber.inneractive.sdk.config.global.features.r) r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            if (r3 == 0) goto L_0x019d
            r2.f = r5
        L_0x019d:
            com.fyber.inneractive.sdk.player.ui.b r3 = new com.fyber.inneractive.sdk.player.ui.b
            r3.<init>(r2)
            r0.a((com.fyber.inneractive.sdk.player.ui.b) r3)
            r8.a((com.fyber.inneractive.sdk.model.vast.h) r1, (int) r4)
            goto L_0x02a9
        L_0x01aa:
            com.fyber.inneractive.sdk.player.ui.l r1 = r8.d
            r1.b((boolean) r4)
            com.fyber.inneractive.sdk.player.ui.l r1 = r8.d
            r1.c((boolean) r3)
            com.fyber.inneractive.sdk.player.ui.c r1 = new com.fyber.inneractive.sdk.player.ui.c
            r1.<init>()
            boolean r5 = r8.z
            r1.b = r5
            if (r6 == 0) goto L_0x01c7
            boolean r5 = r6.d()
            if (r5 == 0) goto L_0x01c7
            r5 = 1
            goto L_0x01c8
        L_0x01c7:
            r5 = 0
        L_0x01c8:
            r1.c = r5
            java.lang.String r5 = r8.y
            if (r5 == 0) goto L_0x01cf
            goto L_0x01ec
        L_0x01cf:
            com.fyber.inneractive.sdk.config.global.s r5 = r8.c
            if (r5 == 0) goto L_0x01eb
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r7 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.g r5 = r5.a(r7)
            com.fyber.inneractive.sdk.config.global.features.c r5 = (com.fyber.inneractive.sdk.config.global.features.c) r5
            java.lang.String r0 = r0.p
            r5.e(r0)
            com.fyber.inneractive.sdk.model.vast.a r0 = r5.e
            if (r0 == 0) goto L_0x01eb
            boolean r5 = r0.d
            if (r5 == 0) goto L_0x01eb
            java.lang.String r5 = r0.a
            goto L_0x01ec
        L_0x01eb:
            r5 = r2
        L_0x01ec:
            r1.e = r5
            boolean r0 = r8.d((com.fyber.inneractive.sdk.config.global.features.r) r6)
            int r5 = r8.c((com.fyber.inneractive.sdk.config.global.features.r) r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            if (r0 == 0) goto L_0x01fe
            r1.f = r5
        L_0x01fe:
            com.fyber.inneractive.sdk.config.global.features.r$c r0 = r8.b(r6)
            int r5 = r8.a((com.fyber.inneractive.sdk.config.global.features.r) r6)
            r1.i = r0
            r1.j = r5
            com.fyber.inneractive.sdk.config.global.s r0 = r8.c
            if (r0 == 0) goto L_0x0217
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.h> r5 = com.fyber.inneractive.sdk.config.global.features.h.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r5)
            com.fyber.inneractive.sdk.config.global.features.h r0 = (com.fyber.inneractive.sdk.config.global.features.h) r0
            goto L_0x0218
        L_0x0217:
            r0 = r2
        L_0x0218:
            if (r0 == 0) goto L_0x0248
            java.lang.String r5 = "should_show_hand"
            boolean r5 = r0.a((java.lang.String) r5, (boolean) r3)
            r1.a = r5
            java.lang.String r5 = "scale_up_to"
            java.lang.Double r0 = r0.a((java.lang.String) r5)
            if (r0 == 0) goto L_0x022f
            double r5 = r0.doubleValue()
            goto L_0x0234
        L_0x022f:
            r5 = 4608533498473480192(0x3ff4ccccc0000000, double:1.2999999523162842)
        L_0x0234:
            float r0 = (float) r5
            r5 = 1071225242(0x3fd9999a, float:1.7)
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0243
            r5 = 1066192077(0x3f8ccccd, float:1.1)
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0246
        L_0x0243:
            r0 = 1067869798(0x3fa66666, float:1.3)
        L_0x0246:
            r1.d = r0
        L_0x0248:
            com.fyber.inneractive.sdk.player.c r0 = r8.a
            if (r0 == 0) goto L_0x0257
            com.fyber.inneractive.sdk.config.global.s r5 = r8.c
            com.fyber.inneractive.sdk.ignite.k r6 = r8.w
            boolean r0 = r0.a((com.fyber.inneractive.sdk.config.global.s) r5, (com.fyber.inneractive.sdk.ignite.k) r6)
            if (r0 == 0) goto L_0x0257
            r3 = 1
        L_0x0257:
            r1.l = r3
            com.fyber.inneractive.sdk.config.global.s r0 = r8.c
            if (r0 == 0) goto L_0x0266
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.n> r2 = com.fyber.inneractive.sdk.config.global.features.n.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r2)
            r2 = r0
            com.fyber.inneractive.sdk.config.global.features.n r2 = (com.fyber.inneractive.sdk.config.global.features.n) r2
        L_0x0266:
            if (r2 == 0) goto L_0x026d
            java.lang.String r0 = r2.d()
            goto L_0x0279
        L_0x026d:
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            android.content.Context r0 = r0.getContext()
            int r2 = com.fyber.inneractive.sdk.R.string.ia_video_app_info_text
            java.lang.String r0 = r0.getString(r2)
        L_0x0279:
            r1.m = r0
            ListenerT r0 = r8.g
            if (r0 == 0) goto L_0x0285
            com.fyber.inneractive.sdk.ignite.k r0 = r0.q()
            r1.k = r0
        L_0x0285:
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            com.fyber.inneractive.sdk.player.ui.b r2 = new com.fyber.inneractive.sdk.player.ui.b
            r2.<init>(r1)
            r0.d((com.fyber.inneractive.sdk.player.ui.b) r2)
            com.fyber.inneractive.sdk.model.vast.h r0 = com.fyber.inneractive.sdk.model.vast.h.Default_End_Card
            r8.a((com.fyber.inneractive.sdk.model.vast.h) r0, (int) r4)
            goto L_0x02a9
        L_0x0295:
            if (r2 == 0) goto L_0x02a4
            if (r1 == 0) goto L_0x02a4
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.b((boolean) r3)
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.c((boolean) r3)
            goto L_0x02a9
        L_0x02a4:
            com.fyber.inneractive.sdk.player.ui.l r0 = r8.d
            r0.c((boolean) r4)
        L_0x02a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.n.D():void");
    }

    public void destroy() {
        g gVar;
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.m;
        if (!(activityLifecycleCallbacks == null || (application = p.a) == null)) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        IAlog.a("%sdestroy called", IAlog.a((Object) this));
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (!(cVar == null || (gVar = cVar.b) == null)) {
            gVar.b.remove(this);
            this.a.b.c.remove(this);
        }
        l();
        j();
        com.fyber.inneractive.sdk.util.b<?, ?, ?> bVar = this.q;
        if (bVar != null) {
            bVar.c();
        }
        this.g = null;
    }

    public void f() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a((Object) this));
        l();
    }

    public void h(boolean z2) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        if (!cVar.j) {
            D();
        } else if (!z2 || (gVar = cVar.b) == null) {
            cVar.d();
        } else {
            gVar.a(0, true);
        }
    }

    public void i() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null) {
            if (!gVar.b.contains(this)) {
                gVar.b.add(this);
            }
            g gVar2 = this.a.b;
            if (!gVar2.c.contains(this)) {
                gVar2.c.add(this);
            }
        }
    }

    public final void j() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        r3 = r9.x;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k() {
        /*
            r9 = this;
            com.fyber.inneractive.sdk.player.ui.f r0 = r9.x
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0067
            com.fyber.inneractive.sdk.player.ui.f r0 = new com.fyber.inneractive.sdk.player.ui.f
            com.fyber.inneractive.sdk.player.ui.l r3 = r9.d
            r0.<init>(r3)
            r9.x = r0
            com.fyber.inneractive.sdk.player.c r3 = r9.a
            if (r3 == 0) goto L_0x0067
            com.fyber.inneractive.sdk.measurement.d r3 = r3.h
            if (r3 == 0) goto L_0x0067
            com.fyber.inneractive.sdk.player.ui.l r4 = r9.d
            android.view.View[] r4 = r4.getTrackingFriendlyView()
            com.iab.omid.library.fyber.adsession.AdSession r5 = r3.a
            if (r5 == 0) goto L_0x0029
            r5.registerAdView(r0)     // Catch:{ all -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r0 = move-exception
            r3.a((java.lang.Throwable) r0)
        L_0x0029:
            com.iab.omid.library.fyber.adsession.AdSession r0 = r3.a
            if (r0 == 0) goto L_0x0046
            if (r4 == 0) goto L_0x0046
            int r0 = r4.length
            r5 = 0
        L_0x0031:
            if (r5 >= r0) goto L_0x0046
            r6 = r4[r5]
            if (r6 == 0) goto L_0x0043
            com.iab.omid.library.fyber.adsession.AdSession r7 = r3.a     // Catch:{ all -> 0x003f }
            com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose r8 = com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose.VIDEO_CONTROLS     // Catch:{ all -> 0x003f }
            r7.addFriendlyObstruction(r6, r8, r1)     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r6 = move-exception
            r3.a((java.lang.Throwable) r6)
        L_0x0043:
            int r5 = r5 + 1
            goto L_0x0031
        L_0x0046:
            com.fyber.inneractive.sdk.player.ui.l r0 = r9.d
            android.view.View[] r0 = r0.getTrackingFriendlyViewObstructionPurposeOther()
            com.iab.omid.library.fyber.adsession.AdSession r4 = r3.a
            if (r4 == 0) goto L_0x0067
            int r4 = r0.length
            r5 = 0
        L_0x0052:
            if (r5 >= r4) goto L_0x0067
            r6 = r0[r5]
            if (r6 == 0) goto L_0x0064
            com.iab.omid.library.fyber.adsession.AdSession r7 = r3.a     // Catch:{ all -> 0x0060 }
            com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose r8 = com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose.OTHER     // Catch:{ all -> 0x0060 }
            r7.addFriendlyObstruction(r6, r8, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r6 = move-exception
            r3.a((java.lang.Throwable) r6)
        L_0x0064:
            int r5 = r5 + 1
            goto L_0x0052
        L_0x0067:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r9)
            r0[r2] = r3
            com.fyber.inneractive.sdk.player.ui.l r3 = r9.d
            android.view.ViewGroup r3 = r3.getTextureHost()
            r4 = 1
            r0[r4] = r3
            java.lang.String r3 = "%sconnectToTextureView called %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r0)
            com.fyber.inneractive.sdk.player.ui.f r0 = r9.x
            if (r0 == 0) goto L_0x00a3
            com.fyber.inneractive.sdk.player.ui.l r0 = r9.d
            android.view.ViewGroup r0 = r0.getTextureHost()
            com.fyber.inneractive.sdk.player.ui.f r3 = r9.x
            android.view.ViewParent r3 = r3.getParent()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00a3
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r9)
            r0[r2] = r1
            java.lang.String r1 = "%sconnectToTextureView called but already connected"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            goto L_0x015e
        L_0x00a3:
            com.fyber.inneractive.sdk.player.c r0 = r9.a
            if (r0 == 0) goto L_0x0115
            com.fyber.inneractive.sdk.player.controller.g r0 = r0.b
            if (r0 == 0) goto L_0x0115
            com.fyber.inneractive.sdk.player.ui.f r3 = r9.x
            android.view.TextureView r5 = r0.j
            if (r5 == r3) goto L_0x0115
            if (r5 == 0) goto L_0x00b6
            r5.setSurfaceTextureListener(r1)
        L_0x00b6:
            r0.j = r3
            android.view.TextureView$SurfaceTextureListener r1 = r0.m
            if (r1 == 0) goto L_0x00bd
            goto L_0x00c4
        L_0x00bd:
            com.fyber.inneractive.sdk.player.controller.f r1 = new com.fyber.inneractive.sdk.player.controller.f
            r1.<init>(r0)
            r0.m = r1
        L_0x00c4:
            if (r3 == 0) goto L_0x00cb
            android.view.TextureView$SurfaceTextureListener r1 = r0.m
            r3.setSurfaceTextureListener(r1)
        L_0x00cb:
            android.graphics.SurfaceTexture r1 = r0.k
            if (r1 == 0) goto L_0x0115
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r3 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r0)
            r1[r2] = r3
            java.lang.String r3 = "%scalling setSurfaceTexture with cached texture"
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r1)
            android.view.TextureView r1 = r0.j
            android.graphics.SurfaceTexture r1 = r1.getSurfaceTexture()
            if (r1 == 0) goto L_0x0101
            android.view.TextureView r1 = r0.j
            android.graphics.SurfaceTexture r1 = r1.getSurfaceTexture()
            android.graphics.SurfaceTexture r3 = r0.k
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00f3
            goto L_0x0101
        L_0x00f3:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r0)
            r1[r2] = r0
            java.lang.String r0 = "%scalling setSurfaceTexture with cached texture failed"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r1)
            goto L_0x0115
        L_0x0101:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r3 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r0)
            r1[r2] = r3
            java.lang.String r3 = "%scalling setSurfaceTexture with cached texture success"
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r1)
            android.view.TextureView r1 = r0.j
            android.graphics.SurfaceTexture r0 = r0.k
            r1.setSurfaceTexture(r0)
        L_0x0115:
            com.fyber.inneractive.sdk.player.ui.f r0 = r9.x
            if (r0 == 0) goto L_0x011e
            int r1 = com.fyber.inneractive.sdk.R.id.inn_texture_view
            r0.setId(r1)
        L_0x011e:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r9)
            r0[r2] = r1
            java.lang.String r1 = "%supdateView adding texture to parent"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r1)
            r0.setMargins(r2, r2, r2, r2)
            r1 = 17
            r0.gravity = r1
            com.fyber.inneractive.sdk.player.ui.f r1 = r9.x
            android.view.ViewParent r1 = r1.getParent()
            if (r1 != 0) goto L_0x014b
            com.fyber.inneractive.sdk.player.ui.l r1 = r9.d
            android.view.ViewGroup r1 = r1.getTextureHost()
            com.fyber.inneractive.sdk.player.ui.f r3 = r9.x
            r1.addView(r3, r0)
        L_0x014b:
            r9.l = r2
            com.fyber.inneractive.sdk.player.controller.m r0 = new com.fyber.inneractive.sdk.player.controller.m
            r0.<init>(r9)
            r9.e = r0
            com.fyber.inneractive.sdk.player.c r1 = r9.a
            if (r1 == 0) goto L_0x015e
            com.fyber.inneractive.sdk.player.controller.g r1 = r1.b
            if (r1 == 0) goto L_0x015e
            r1.d = r0
        L_0x015e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.n.k():boolean");
    }

    public final void m() {
        l lVar = this.d;
        if (lVar != null) {
            lVar.g();
            lVar.I = true;
        }
    }

    public void pauseVideo() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null) {
            if (gVar.e != com.fyber.inneractive.sdk.player.enums.b.Paused) {
                IAlog.a("%spauseVideo %s", IAlog.a((Object) this), this.d);
                TextureView textureView = this.a.b.j;
                if (textureView != null && textureView.getParent() != null && textureView.getParent().equals(this.d.getTextureHost())) {
                    this.a.b.k();
                    return;
                }
                return;
            }
            IAlog.a("%spauseVideo called in bad state! %s", IAlog.a((Object) this), this.a.b.e);
        }
    }

    public final float r() {
        try {
            return (float) ((AudioManager) this.d.getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3);
        } catch (Throwable unused) {
            return 1.0f;
        }
    }

    public boolean t() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.b) == null) {
            return false;
        }
        if (!gVar.i() && r() != 0.0f) {
            return false;
        }
        return true;
    }

    public void d(boolean z2) {
        IAlog.a("%sinitUI", IAlog.a((Object) this));
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && cVar.b != null) {
            this.d.setUnitConfig(this.b);
            l lVar = this.d;
            int h2 = this.a.b.h();
            int g2 = this.a.b.g();
            boolean z3 = this.n;
            lVar.s = h2;
            lVar.t = g2;
            lVar.u = z3;
            if (this.a.b.h() > 0 && this.a.b.g() > 0) {
                a(this.a.b.h(), this.a.b.g());
            }
            if (B()) {
                this.f = s();
            } else {
                this.d.d(false);
            }
            if (!z2) {
                a(this.a.b.c());
                a(this.a.b.e, false);
            }
            E();
        }
    }

    public void l() {
        if (this.x != null) {
            IAlog.a("%sdestroyTextureView", IAlog.a((Object) this));
            if (this.p != null) {
                a(false, (s0.a) new c());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = ((com.fyber.inneractive.sdk.config.a0) r0).f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(boolean r5) {
        /*
            r4 = this;
            com.fyber.inneractive.sdk.config.b0 r0 = r4.b
            if (r0 == 0) goto L_0x0012
            com.fyber.inneractive.sdk.config.a0 r0 = (com.fyber.inneractive.sdk.config.a0) r0
            com.fyber.inneractive.sdk.config.c0 r0 = r0.f
            if (r0 == 0) goto L_0x0012
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r0.j
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r0 != r1) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            boolean r1 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
            if (r1 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            com.fyber.inneractive.sdk.player.ui.l r0 = r4.d
            if (r0 == 0) goto L_0x005a
            com.fyber.inneractive.sdk.player.c r0 = r4.a
            if (r0 == 0) goto L_0x005a
            com.fyber.inneractive.sdk.player.controller.g r0 = r0.b
            if (r0 == 0) goto L_0x005a
            int r0 = r0.c()
            int r0 = r0 / 1000
            int r1 = r4.q()
            com.fyber.inneractive.sdk.player.c r2 = r4.a
            com.fyber.inneractive.sdk.player.controller.g r2 = r2.b
            int r2 = r2.d()
            int r2 = r2 / 1000
            int r2 = r2 - r0
            if (r2 <= 0) goto L_0x0040
            if (r0 >= r1) goto L_0x005a
        L_0x0040:
            com.fyber.inneractive.sdk.player.controller.v r0 = new com.fyber.inneractive.sdk.player.controller.v
            com.fyber.inneractive.sdk.player.ui.l r1 = r4.d
            android.content.Context r1 = r1.getContext()
            com.fyber.inneractive.sdk.config.global.features.b r2 = r4.p()
            com.fyber.inneractive.sdk.player.controller.r r3 = new com.fyber.inneractive.sdk.player.controller.r
            r3.<init>(r4, r5)
            r0.<init>(r1, r2, r3)
            android.app.Dialog r5 = r0.c
            r5.show()
            goto L_0x005d
        L_0x005a:
            r4.f(r5)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.n.c(boolean):void");
    }

    public final void a(int i2, int i3) {
        Bitmap bitmap = this.p;
        if (!(bitmap != null && bitmap.getWidth() == i2 && this.p.getHeight() == i3) && i3 > 0 && i2 > 0) {
            com.fyber.inneractive.sdk.util.b<?, ?, ?> bVar = this.q;
            if (bVar != null) {
                bVar.c();
            }
            this.p = null;
            d dVar = new d();
            this.q = dVar;
            dVar.a().post(new com.fyber.inneractive.sdk.util.c(dVar, new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
    }

    public boolean e() {
        l lVar;
        TextView textView;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        if (!this.h && cVar.b != null && ((lVar = this.d) == null || (textView = lVar.o) == null || textView.getVisibility() != 0 || !lVar.o.isEnabled())) {
            int d2 = this.a.b.d();
            com.fyber.inneractive.sdk.player.c cVar2 = this.a;
            if (!com.fyber.inneractive.sdk.player.c.a(d2, ((com.fyber.inneractive.sdk.player.e) cVar2).y, com.fyber.inneractive.sdk.player.c.a(cVar2)) || this.h || this.f != 0) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z2) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        c0 c0Var;
        ListenerT listenert;
        com.fyber.inneractive.sdk.player.c cVar2;
        g gVar2;
        g gVar3;
        com.fyber.inneractive.sdk.measurement.d dVar;
        b0 b0Var;
        c0 c0Var2;
        this.t = true;
        f0 f0Var = IAConfigManager.M.x;
        if (!(!z2 || f0Var == null || (b0Var = this.b) == null || (c0Var2 = ((a0) b0Var).f) == null)) {
            f0Var.a(c0Var2.j, "LAST_VAST_SKIPED", "1");
        }
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        if (!(cVar3 == null || (gVar3 = cVar3.b) == null)) {
            gVar3.m();
            this.a.b.k();
            if (!(!z2 || (dVar = this.a.h) == null || dVar.c == null)) {
                IAlog.a("%s skipped", "OMVideo");
                try {
                    dVar.c.skipped();
                } catch (Throwable th) {
                    dVar.a(th);
                }
            }
        }
        if (!this.d.f()) {
            this.d.a(false);
            j();
            D();
            this.k = false;
            this.h = true;
            b0 b0Var2 = this.b;
            if (!(b0Var2 == null || (c0Var = ((a0) b0Var2).f) == null || c0Var.j != UnitDisplayType.REWARDED || (listenert = this.g) == null)) {
                if (!this.t || (cVar2 = this.a) == null || (gVar2 = cVar2.b) == null) {
                    listenert.onCompleted();
                } else {
                    int c2 = gVar2.c();
                    int d2 = gVar2.d() - c2;
                    int q2 = q() * 1000;
                    if (d2 <= 0 || c2 >= q2) {
                        this.g.onCompleted();
                    } else {
                        this.B = true;
                    }
                }
            }
        }
        if (this.g != null && (this.f <= 0 || this.h || !((cVar = this.a) == null || (gVar = cVar.b) == null || !gVar.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed)))) {
            this.g.a(z2);
        }
        l();
    }

    public void g() {
        if (this.r && !this.l) {
            this.l = true;
            this.d.b(false);
        }
    }

    public void g(boolean z2) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (!(cVar == null || (gVar = cVar.b) == null)) {
            gVar.b(z2);
        }
        this.d.setMuteButtonState(true);
    }

    public void h() {
        f fVar;
        l lVar = this.d;
        if (lVar != null) {
            lVar.j();
        }
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (!(cVar == null || cVar.b == null || (fVar = this.x) == null)) {
            fVar.invalidate();
            this.x.requestLayout();
        }
        l lVar2 = this.d;
        if (lVar2 != null) {
            lVar2.invalidate();
            this.d.requestLayout();
        }
    }

    public void i(boolean z2) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (!(cVar == null || (gVar = cVar.b) == null)) {
            gVar.d(z2);
        }
        this.d.setMuteButtonState(false);
    }

    public class d extends com.fyber.inneractive.sdk.util.b<Integer, Void, Bitmap> {
        public d() {
        }

        public Object a(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            n.this.getClass();
            Application application = p.a;
            Bitmap bitmap = null;
            if (!(application == null || application.getResources() == null || application.getResources().getDisplayMetrics() == null)) {
                DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
                try {
                    bitmap = Bitmap.createBitmap(intValue, intValue2, Bitmap.Config.ARGB_8888);
                    if (bitmap != null) {
                        bitmap.setDensity(displayMetrics.densityDpi);
                    }
                } catch (Throwable unused) {
                }
            }
            return bitmap;
        }

        public void a(Object obj) {
            n nVar = n.this;
            nVar.p = (Bitmap) obj;
            com.fyber.inneractive.sdk.util.b<?, ?, ?> bVar = nVar.q;
            if (bVar != null) {
                bVar.c();
                nVar.q = null;
            }
        }
    }

    public com.fyber.inneractive.sdk.flow.vast.e c() {
        m mVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (mVar = ((com.fyber.inneractive.sdk.player.e) cVar).z) == null) {
            return null;
        }
        return mVar.m;
    }

    public final void c(int i2) {
        if (this.d != null) {
            s sVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.c;
                }
            }
            if (!TextUtils.isEmpty(this.y) || str == null) {
                this.d.setSkipText(String.valueOf(i2));
            } else {
                this.d.setSkipText(str.replaceFirst("\\[TIME\\]", Integer.toString(i2)));
            }
        }
    }

    public void a(boolean z2, s0.a aVar) {
        q.a(new e(z2, aVar));
    }

    public final void a(String str) {
        f0 f0Var = IAConfigManager.M.x;
        b0 b0Var = this.b;
        if (b0Var != null) {
            a0 a0Var = (a0) b0Var;
            if (a0Var.f != null) {
                f0Var.a(a0Var.f.j, "LAST_VAST_CLICKED_TYPE", str);
            }
        }
    }

    public void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%sonPlayerStateChanged with %s", IAlog.a((Object) this), bVar);
        a(bVar, true);
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar, boolean z2) {
        ListenerT listenert;
        switch (a.a[bVar.ordinal()]) {
            case 1:
                if (this.r) {
                    this.d.b(true);
                    D();
                    z();
                    return;
                }
                return;
            case 2:
                if (this.r) {
                    this.d.a(true);
                    this.d.c(false);
                    Runnable runnable = this.j;
                    if (runnable == null) {
                        if (runnable == null) {
                            this.j = new o(this);
                        }
                        int o2 = o();
                        IAlog.a("%s Starting buffering timeout with %d", IAlog.a((Object) this), Integer.valueOf(o2));
                        this.d.postDelayed(this.j, (long) o2);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (this.r) {
                    A();
                    return;
                }
                return;
            case 4:
                x();
                return;
            case 5:
                if (this.r || (!this.z && !this.v)) {
                    this.v = true;
                    v();
                    if (z2 && (listenert = this.g) != null) {
                        listenert.onCompleted();
                        return;
                    }
                    return;
                }
                return;
            case 6:
                if (this.r) {
                    c(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(int i2) {
        b0 b0Var;
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && cVar.b != null) {
            float r2 = r();
            com.fyber.inneractive.sdk.player.c cVar2 = this.a;
            if (!(cVar2 == null || (gVar = cVar2.b) == null || !gVar.j())) {
                float f2 = this.i;
                if (r2 != f2) {
                    int i3 = (r2 > 0.0f ? 1 : (r2 == 0.0f ? 0 : -1));
                    if (i3 > 0 && f2 >= 0.0f && t()) {
                        i(true);
                    } else if (i3 == 0 && !t()) {
                        g(true);
                    }
                }
                E();
            }
            this.i = r2;
            int d2 = this.a.b.d();
            int c2 = this.a.b.c();
            int i4 = c2 / 1000;
            int i5 = d2 / 1000;
            int i6 = i5 - i4;
            if (i6 < 0 || (!this.a.b.j() && c2 == d2)) {
                i6 = 0;
            }
            l lVar = this.d;
            if (lVar.n != null || lVar.x != null) {
                lVar.setRemainingTime(Integer.toString(i6));
                if (this.f < i5) {
                    if (B()) {
                        int d3 = this.a.b.d();
                        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                        if (com.fyber.inneractive.sdk.player.c.a(d3, ((com.fyber.inneractive.sdk.player.e) cVar3).y, com.fyber.inneractive.sdk.player.c.a(cVar3)) && !this.h) {
                            int i7 = this.f;
                            if (i4 < i7) {
                                c(i7 - i4);
                            } else {
                                this.f = 0;
                                n();
                            }
                            this.d.d(true);
                        }
                    }
                    this.d.d(false);
                } else {
                    this.d.d(false);
                    c(i6);
                }
                if (this.a.b.e != com.fyber.inneractive.sdk.player.enums.b.Paused) {
                    l lVar2 = this.d;
                    if (lVar2.x != null) {
                        Runnable runnable = lVar2.G;
                        if (runnable != null) {
                            lVar2.removeCallbacks(runnable);
                            lVar2.G = null;
                        }
                        int i8 = i5 * 1000;
                        lVar2.x.setMax(i8);
                        int i9 = i8 - (i6 * 1000);
                        int i10 = i9 + 1000;
                        lVar2.F = i10;
                        int i11 = i9 + Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
                        if (i10 > 0 && i10 <= i8) {
                            int i12 = lVar2.E;
                            if (i11 >= i12 || i12 <= 0) {
                                lVar2.E = i11;
                                lVar2.x.setProgress(i11);
                                com.fyber.inneractive.sdk.player.ui.n nVar = new com.fyber.inneractive.sdk.player.ui.n(lVar2);
                                lVar2.G = nVar;
                                lVar2.postDelayed(nVar, 200);
                            } else {
                                lVar2.x.setProgress(i10);
                            }
                        }
                    }
                    int q2 = q();
                    if (i5 > q2 && i4 > q2 && (b0Var = this.b) != null) {
                        a0 a0Var = (a0) b0Var;
                        if (a0Var.f != null && a0Var.f.j == UnitDisplayType.REWARDED) {
                            n();
                            this.d.d(true);
                        }
                    }
                }
                ListenerT listenert = this.g;
                if (listenert != null) {
                    listenert.onProgress(d2, c2);
                }
            }
        }
    }

    public void a(boolean z2) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        g.C0109g gVar2;
        l lVar;
        Application application;
        if (this.r != z2 && (cVar = this.a) != null && cVar.b != null) {
            IAlog.a("%sonVisibilityChanged: %s my video view is%s", IAlog.a((Object) this), Boolean.valueOf(z2), this.d);
            if (z2) {
                this.r = true;
                com.fyber.inneractive.sdk.player.enums.b bVar = this.a.b.e;
                if (bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Completed) || this.d.f()) {
                    if (!this.v) {
                        this.v = true;
                        if (!this.B) {
                            v();
                            ListenerT listenert = this.g;
                            if (listenert != null) {
                                listenert.onCompleted();
                            }
                        }
                    }
                    l lVar2 = this.d;
                    if (lVar2 != null && lVar2.H != null) {
                        IAlog.a("Autoclick resumed", new Object[0]);
                        lVar2.H.b();
                        return;
                    }
                    return;
                }
                if (!bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Error)) {
                    if (bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Idle)) {
                        this.a.getClass();
                    } else {
                        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress || bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                            A();
                        }
                        com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                        if (!cVar2.p) {
                            com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar2;
                            eVar.a(eVar.v, VideoClickOrigin.InvalidOrigin, t.EVENT_CREATIVE_VIEW);
                            cVar2.p = true;
                        }
                        k();
                        if (this.m == null && (application = p.a) != null) {
                            q qVar = new q(this);
                            this.m = qVar;
                            application.registerActivityLifecycleCallbacks(qVar);
                            return;
                        }
                        return;
                    }
                }
                c(false);
                return;
            }
            this.r = false;
            com.fyber.inneractive.sdk.player.c cVar3 = this.a;
            if (!(cVar3 == null || (gVar = cVar3.b) == null || (gVar2 = gVar.d) == null || !gVar2.equals(this.e))) {
                IAlog.a("%sonVisibilityChanged pausing video", IAlog.a((Object) this));
                pauseVideo();
                if (this.a.b.e == com.fyber.inneractive.sdk.player.enums.b.Completed || ((lVar = this.d) != null && lVar.f())) {
                    l lVar3 = this.d;
                    if (lVar3.H != null) {
                        IAlog.a("Autoclick paused", new Object[0]);
                        lVar3.H.a();
                    }
                }
            }
            l();
        }
    }

    public void a(int i2, p0 p0Var) {
        String str;
        IAlog.a("onClicked called with %d", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                if (t()) {
                    i(true);
                    com.fyber.inneractive.sdk.player.c cVar = this.a;
                    if (cVar != null) {
                        com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar;
                        eVar.a(eVar.v, VideoClickOrigin.MUTE, t.EVENT_UNMUTE);
                    }
                } else {
                    g(true);
                    com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                    if (cVar2 != null) {
                        com.fyber.inneractive.sdk.player.e eVar2 = (com.fyber.inneractive.sdk.player.e) cVar2;
                        eVar2.a(eVar2.v, VideoClickOrigin.MUTE, t.EVENT_MUTE);
                    }
                }
                E();
                return;
            case 2:
                y();
                return;
            case 3:
                a(f0.b.CTA_BUTTON.value);
                a(false, VideoClickOrigin.CTA, p0Var);
                return;
            case 4:
                a(f0.b.COMPANION.value);
                com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                com.fyber.inneractive.sdk.model.vast.c c2 = cVar3 != null ? cVar3.c() : null;
                if (c2 == null || c2.a != h.Static) {
                    str = null;
                } else {
                    str = c2.g;
                    com.fyber.inneractive.sdk.player.c cVar4 = this.a;
                    if (cVar4 != null) {
                        cVar4.a((com.fyber.inneractive.sdk.response.i) c2, VideoClickOrigin.COMPANION, t.EVENT_CLICK);
                    }
                }
                m();
                ListenerT listenert = this.g;
                if (listenert != null) {
                    listenert.a(str, p0Var, (b.a) null, false);
                    return;
                }
                return;
            case 5:
                w();
                return;
            case 6:
                c(true);
                return;
            case 7:
                a(p0Var);
                return;
            case 8:
                a(f0.b.COMPANION.value);
                a(true, VideoClickOrigin.COMPANION, p0Var);
                return;
            case 9:
                com.fyber.inneractive.sdk.player.c cVar5 = this.a;
                if (cVar5 != null && !this.d.h) {
                    cVar5.j = true;
                    h(false);
                    return;
                }
                return;
            case 10:
                a(f0.b.APP_INFO.value);
                a(false, VideoClickOrigin.APP_INFO, p0Var);
                return;
            default:
                return;
        }
    }

    public boolean a(boolean z2, VideoClickOrigin videoClickOrigin, p0 p0Var) {
        m();
        ListenerT listenert = this.g;
        boolean z3 = false;
        if (listenert != null) {
            if (z2) {
                com.fyber.inneractive.sdk.player.c cVar = this.a;
                if (cVar != null) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.player.e) cVar).v;
                    listenert.a(bVar != null ? bVar.b : null, p0Var, (b.a) null, true);
                    com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) this.a;
                    eVar.a(eVar.v, videoClickOrigin, t.EVENT_CLICK);
                }
            } else {
                b0.a a2 = listenert.a(p0Var, videoClickOrigin == VideoClickOrigin.VIDEO ? com.fyber.inneractive.sdk.util.i.VIDEO_CLICK : videoClickOrigin == VideoClickOrigin.APP_INFO ? com.fyber.inneractive.sdk.util.i.VIDEO_APP_INFO : com.fyber.inneractive.sdk.util.i.VIDEO_CTA);
                com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                if (cVar2 != null) {
                    com.fyber.inneractive.sdk.player.e eVar2 = (com.fyber.inneractive.sdk.player.e) cVar2;
                    eVar2.a(eVar2.v, videoClickOrigin, t.EVENT_CLICK);
                    com.fyber.inneractive.sdk.measurement.d dVar = this.a.h;
                    if (!(dVar == null || dVar.c == null)) {
                        IAlog.a("%s click", "OMVideo");
                        try {
                            dVar.c.adUserInteraction(InteractionType.CLICK);
                        } catch (Throwable th) {
                            dVar.a(th);
                        }
                    }
                }
                if (a2.a != b0.d.FAILED) {
                    z3 = true;
                }
            }
        }
        if (videoClickOrigin == VideoClickOrigin.VIDEO) {
            a(f0.b.VIDEO.value);
        }
        return z3;
    }

    public void a(h hVar, int i2) {
        s sVar;
        com.fyber.inneractive.sdk.flow.vast.c cVar;
        JSONArray jSONArray;
        m mVar;
        com.fyber.inneractive.sdk.model.vast.c cVar2;
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        if (cVar3 != null) {
            com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar3;
            eVar.getClass();
            IAlog.a("notifyCompanionDisplayed", new Object[0]);
            int i3 = e.b.a[hVar.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    m mVar2 = eVar.z;
                    if (mVar2 != null && (cVar = mVar2.m) != null) {
                        cVar.c = true;
                        InneractiveAdRequest inneractiveAdRequest = mVar2.b;
                        com.fyber.inneractive.sdk.response.g gVar = mVar2.c;
                        s sVar2 = mVar2.d;
                        cVar.d = i2;
                        String b2 = cVar.b();
                        cVar.e = b2;
                        if (!cVar.h) {
                            com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.FMP_COMPANION_SUCCESSFULLY_SHOWN;
                            if (sVar2 == null) {
                                jSONArray = null;
                            } else {
                                jSONArray = sVar2.c();
                            }
                            s.a aVar = new s.a(rVar, inneractiveAdRequest, (com.fyber.inneractive.sdk.response.e) gVar, jSONArray);
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(b2)) {
                                try {
                                    jSONObject.put(MediationMetaData.KEY_VERSION, b2);
                                } catch (Exception unused) {
                                    IAlog.e("Got exception adding param to json object: %s, %s", MediationMetaData.KEY_VERSION, b2);
                                }
                            }
                            Boolean valueOf = Boolean.valueOf(cVar.j);
                            try {
                                jSONObject.put("loaded_from_cache", valueOf);
                            } catch (Exception unused2) {
                                IAlog.e("Got exception adding param to json object: %s, %s", "loaded_from_cache", valueOf);
                            }
                            aVar.f.put(jSONObject);
                            aVar.a((String) null);
                            cVar.h = true;
                        }
                    }
                } else if (eVar.b() != null && (mVar = eVar.z) != null && !mVar.g && (cVar2 = eVar.v.h) != null) {
                    eVar.a(cVar2, VideoClickOrigin.COMPANION, t.EVENT_CREATIVE_VIEW);
                    m mVar3 = eVar.z;
                    if (!mVar3.g) {
                        com.fyber.inneractive.sdk.network.r rVar2 = com.fyber.inneractive.sdk.network.r.VAST_COMPANION_DISPLAYED;
                        InneractiveAdRequest inneractiveAdRequest2 = mVar3.b;
                        com.fyber.inneractive.sdk.response.g gVar2 = mVar3.c;
                        com.fyber.inneractive.sdk.config.global.s sVar3 = mVar3.d;
                        s.a aVar2 = new s.a(rVar2, inneractiveAdRequest2, (com.fyber.inneractive.sdk.response.e) gVar2, sVar3 == null ? null : sVar3.c());
                        aVar2.a("companion_data", mVar3.e.h.a());
                        aVar2.a((String) null);
                    }
                    mVar3.g = true;
                }
            } else if (!eVar.A) {
                com.fyber.inneractive.sdk.network.r rVar3 = com.fyber.inneractive.sdk.network.r.VAST_DEFAULT_COMPANION_DISPLAYED;
                InneractiveAdRequest inneractiveAdRequest3 = eVar.f;
                com.fyber.inneractive.sdk.flow.f0 f0Var = eVar.e;
                new s.a(rVar3, inneractiveAdRequest3, (com.fyber.inneractive.sdk.response.e) f0Var != null ? (com.fyber.inneractive.sdk.response.g) f0Var.b : null, (f0Var == null || (sVar = f0Var.c) == null) ? null : sVar.c()).a((String) null);
                eVar.A = true;
            }
        }
    }

    public void a(c cVar) {
        s sVar = new s(this);
        com.fyber.inneractive.sdk.web.a0 a0Var = cVar.a;
        if (a0Var != null) {
            a0Var.setListener(sVar);
        }
    }

    public static boolean a(n nVar) {
        return nVar.c() != null && nVar.c().c;
    }

    public void a(Bitmap bitmap) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.b) != null && gVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            this.d.a(cVar.j);
            this.d.b(true);
            this.d.setLastFrameBitmap(bitmap);
        }
    }

    public void a(long j2) {
        View view;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        View b2 = cVar != null ? cVar.b() : null;
        l lVar = this.d;
        boolean z2 = b2 == null;
        ObjectAnimator objectAnimator = lVar.M;
        if (objectAnimator != null) {
            if (objectAnimator.getDuration() <= j2) {
                ViewGroup viewGroup = lVar.A;
                if (viewGroup != null) {
                    lVar.a((View) viewGroup.getParent(), 4);
                }
                lVar.M.start();
                lVar.M.addListener(new com.fyber.inneractive.sdk.player.ui.m(lVar));
            } else {
                lVar.N = true;
                lVar.M = null;
                ViewGroup viewGroup2 = lVar.A;
                if (!(viewGroup2 == null || viewGroup2.getParent() == null)) {
                    ((View) lVar.A.getParent()).setOnTouchListener((View.OnTouchListener) null);
                }
            }
            if (!z2 || (view = lVar.z) == null) {
                ViewGroup viewGroup3 = lVar.A;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    return;
                }
                return;
            }
            view.setVisibility(0);
        }
    }

    public void a(l lVar, Bitmap bitmap, boolean z2, boolean z3) {
        if (bitmap == null) {
            IAlog.a("IAVideoUIControllerBase : Unable set bitmap it is null", new Object[0]);
        } else if (lVar == null) {
            IAlog.a("IAVideoUIControllerBase : Unable set last frame", new Object[0]);
        } else {
            lVar.setLastFrameBitmap(bitmap);
            if (z2) {
                lVar.b(z3);
            }
        }
    }
}
