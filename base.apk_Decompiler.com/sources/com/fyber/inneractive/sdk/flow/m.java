package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.flow.vast.a;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.model.vast.i;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.network.f;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.m0;
import com.fyber.inneractive.sdk.network.n0;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.v;
import com.fyber.inneractive.sdk.util.x;
import com.fyber.inneractive.sdk.web.a0;
import com.fyber.inneractive.sdk.web.d;
import com.unity3d.ads.metadata.MediationMetaData;
import java.net.UnknownHostException;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {
    public final int a;
    public final InneractiveAdRequest b;
    public final g c;
    public s d;
    public com.fyber.inneractive.sdk.model.vast.b e;
    public Context f;
    public boolean g;
    public n0 h;
    public m0 i;
    public final com.fyber.inneractive.sdk.flow.vast.b j;
    public int k;
    public final PriorityQueue<com.fyber.inneractive.sdk.flow.vast.a> l = new PriorityQueue<>(10, new a.b());
    public final com.fyber.inneractive.sdk.flow.vast.c m;
    public com.fyber.inneractive.sdk.player.controller.c n = null;
    public final d.C0138d o = new a();
    public final w<String> p = new b();
    public final w<String> q = new c();

    public class a implements d.C0138d {
        public a() {
        }

        public void a(com.fyber.inneractive.sdk.web.d dVar) {
            IAlog.a("%s Fetching companion fmp successfully ", IAlog.a((Object) m.this));
            m.this.m.a = true;
        }

        public void a(com.fyber.inneractive.sdk.web.d dVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
            IAlog.a("%s Fetching companion fmp failed! will load default companion", IAlog.a((Object) m.this));
            m mVar = m.this;
            mVar.m.a = false;
            m.a(mVar, inneractiveInfrastructureError.getCause());
        }
    }

    public class b implements w<String> {
        public b() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            String str = (String) obj;
            if (str != null) {
                m mVar = m.this;
                if (mVar.e != null) {
                    com.fyber.inneractive.sdk.flow.vast.c cVar = mVar.m;
                    if (!cVar.i) {
                        IAlog.a("FmpEndcardLoadingStarted", new Object[0]);
                        cVar.i = true;
                        m mVar2 = m.this;
                        com.fyber.inneractive.sdk.flow.vast.c cVar2 = mVar2.m;
                        cVar2.j = z;
                        cVar2.g.a(str + "<title>DigitalTurbine FMPEndcard</title>", mVar2.o, false);
                        return;
                    }
                }
            }
            if (exc != null && !(exc instanceof f) && !z) {
                m.a(m.this, exc);
            }
        }
    }

    public class c implements w<String> {
        public c() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            l lVar;
            String str = (String) obj;
            if (str != null && exc == null) {
                m mVar = m.this;
                com.fyber.inneractive.sdk.model.vast.b bVar = mVar.e;
                if (bVar != null && (lVar = bVar.f) != null) {
                    lVar.d = str;
                    IAlog.a("sending fmpHtmlRequest", new Object[0]);
                    int i = IAlog.a;
                    String str2 = null;
                    IAlog.a(1, (Exception) null, "%s: %s", "COMPANION_TYPE", h.FMP_End_Card.name());
                    s sVar = mVar.d;
                    if (sVar != null) {
                        str2 = ((com.fyber.inneractive.sdk.config.global.features.f) sVar.a(com.fyber.inneractive.sdk.config.global.features.f.class)).a("endcard_url", "");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        g0 g0Var = new g0(mVar.p, mVar.f, new com.fyber.inneractive.sdk.cache.c(str2));
                        IAConfigManager.M.s.a.offer(g0Var);
                        g0Var.a(r0.QUEUED);
                    }
                }
            } else if (m.a(m.this)) {
                m.this.a();
            } else {
                m.a(m.this, new Exception(String.format("Fail to load image: %s", new Object[]{m.this.i.r}), exc));
            }
        }
    }

    public class d implements d.C0138d {
        public final /* synthetic */ com.fyber.inneractive.sdk.flow.vast.e a;
        public final /* synthetic */ com.fyber.inneractive.sdk.model.vast.c b;

        public d(com.fyber.inneractive.sdk.flow.vast.e eVar, com.fyber.inneractive.sdk.model.vast.c cVar) {
            this.a = eVar;
            this.b = cVar;
        }

        public void a(com.fyber.inneractive.sdk.web.d dVar) {
            com.fyber.inneractive.sdk.flow.vast.e eVar = this.a;
            eVar.a = true;
            m.this.l.add(eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.fyber.inneractive.sdk.web.d r5, com.fyber.inneractive.sdk.external.InneractiveInfrastructureError r6) {
            /*
                r4 = this;
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                com.fyber.inneractive.sdk.flow.m r6 = com.fyber.inneractive.sdk.flow.m.this
                java.lang.String r6 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r6)
                r5.append(r6)
                java.lang.String r6 = " Fetching companion html failed!"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                r6 = 0
                java.lang.Object[] r0 = new java.lang.Object[r6]
                com.fyber.inneractive.sdk.util.IAlog.a(r5, r0)
                com.fyber.inneractive.sdk.model.vast.i r5 = com.fyber.inneractive.sdk.model.vast.i.Gif
                com.fyber.inneractive.sdk.model.vast.c r0 = r4.b
                com.fyber.inneractive.sdk.model.vast.i r0 = r0.b
                boolean r5 = r5.equals(r0)
                r0 = 1
                if (r5 == 0) goto L_0x0039
                com.fyber.inneractive.sdk.model.vast.c r5 = r4.b
                java.lang.String r1 = r5.f
                com.fyber.inneractive.sdk.model.vast.i r5 = r5.b
                boolean r5 = com.fyber.inneractive.sdk.util.a1.a(r1, r5)
                if (r5 == 0) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r5 = 0
                goto L_0x003a
            L_0x0039:
                r5 = 1
            L_0x003a:
                com.fyber.inneractive.sdk.flow.vast.e r1 = r4.a
                r1.a = r6
                com.fyber.inneractive.sdk.flow.m r1 = com.fyber.inneractive.sdk.flow.m.this
                int r2 = r1.k
                int r3 = r1.a
                if (r2 > r3) goto L_0x005d
                if (r5 == 0) goto L_0x005d
                java.lang.Object[] r5 = new java.lang.Object[r0]
                java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r4)
                r5[r6] = r0
                java.lang.String r6 = "%sloadHtmlCompanion retry"
                com.fyber.inneractive.sdk.util.IAlog.a(r6, r5)
                com.fyber.inneractive.sdk.flow.m r5 = com.fyber.inneractive.sdk.flow.m.this
                com.fyber.inneractive.sdk.model.vast.c r6 = r4.b
                r5.a((com.fyber.inneractive.sdk.model.vast.c) r6)
                goto L_0x0082
            L_0x005d:
                r0 = 0
                if (r5 != 0) goto L_0x006e
                com.fyber.inneractive.sdk.network.s$a r5 = new com.fyber.inneractive.sdk.network.s$a
                com.fyber.inneractive.sdk.network.q r2 = com.fyber.inneractive.sdk.network.q.VAST_COMPANION_INCOMPATIBLE_MIMETYPE
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r3 = r1.b
                com.fyber.inneractive.sdk.response.g r1 = r1.c
                r5.<init>((com.fyber.inneractive.sdk.network.q) r2, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r3, (com.fyber.inneractive.sdk.response.e) r1, (org.json.JSONArray) r0)
                r5.a((java.lang.String) r0)
            L_0x006e:
                com.fyber.inneractive.sdk.flow.m r5 = com.fyber.inneractive.sdk.flow.m.this
                com.fyber.inneractive.sdk.model.vast.c r1 = r4.b
                org.json.JSONObject r1 = r1.a()
                com.fyber.inneractive.sdk.flow.m.a(r5, r1, r0)
                com.fyber.inneractive.sdk.flow.vast.e r5 = r4.a
                r5.a = r6
                com.fyber.inneractive.sdk.flow.m r5 = com.fyber.inneractive.sdk.flow.m.this
                r5.b()
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.m.d.a(com.fyber.inneractive.sdk.web.d, com.fyber.inneractive.sdk.external.InneractiveInfrastructureError):void");
        }
    }

    public class e implements w<n0.a> {
        public final /* synthetic */ com.fyber.inneractive.sdk.model.vast.c a;

        public e(com.fyber.inneractive.sdk.model.vast.c cVar) {
            this.a = cVar;
        }

        public void a(Object obj, Exception exc, boolean z) {
            View view;
            n0.a aVar = (n0.a) obj;
            m.this.getClass();
            com.fyber.inneractive.sdk.flow.vast.a aVar2 = new com.fyber.inneractive.sdk.flow.vast.a();
            ImageView imageView = new ImageView(IAConfigManager.M.v.a());
            aVar2.b = imageView;
            imageView.setId(R.id.inneractive_vast_endcard_static);
            aVar2.b.setContentDescription("inneractive_vast_endcard_static");
            m.this.getClass();
            if (exc != null || aVar == null || aVar.b != null || aVar.a == null || (view = aVar2.b) == null) {
                IAlog.a("%s Fetching companion image failed!", IAlog.a((Object) m.this));
                com.fyber.inneractive.sdk.model.vast.c cVar = this.a;
                boolean a2 = a1.a(cVar.f, cVar.b);
                m.this.getClass();
                if ((aVar == null || (aVar.b != null && ((exc instanceof com.fyber.inneractive.sdk.network.b) || (exc instanceof UnknownHostException)))) && a2) {
                    m mVar = m.this;
                    if (mVar.k <= mVar.a) {
                        IAlog.a("%sloadStaticCompanion retry", IAlog.a((Object) this));
                        m.this.b(this.a);
                        return;
                    }
                }
                String str = null;
                if (!a2) {
                    m mVar2 = m.this;
                    mVar2.getClass();
                    new s.a(q.VAST_COMPANION_INCOMPATIBLE_MIMETYPE, mVar2.b, (com.fyber.inneractive.sdk.response.e) mVar2.c, (JSONArray) null).a((String) null);
                }
                if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                    str = aVar.b;
                }
                m.a(m.this, this.a.a(), str);
                m.this.b();
                return;
            }
            ((ImageView) view).setImageBitmap(aVar.a);
            aVar2.a = true;
            m.this.l.add(aVar2);
        }
    }

    public m(Context context, g gVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.s sVar, com.fyber.inneractive.sdk.flow.vast.b bVar) {
        this.e = gVar.e();
        this.f = context;
        this.c = gVar;
        this.b = inneractiveAdRequest;
        this.d = sVar;
        this.a = IAConfigManager.c().a().a("companion_retry_count", 2, 0);
        this.j = bVar;
        com.fyber.inneractive.sdk.web.b bVar2 = new com.fyber.inneractive.sdk.web.b(inneractiveAdRequest, gVar, this.d, this.e);
        com.fyber.inneractive.sdk.flow.vast.c cVar = new com.fyber.inneractive.sdk.flow.vast.c(new com.fyber.inneractive.sdk.player.controller.c(this.f, bVar, h.FMP_End_Card, bVar2));
        this.m = cVar;
        bVar2.a(cVar);
    }

    public static void a(m mVar, JSONObject jSONObject, String str) {
        mVar.getClass();
        s.a aVar = new s.a(q.VAST_COMPANION_FAILED_LOADING, mVar.b, (com.fyber.inneractive.sdk.response.e) mVar.c, mVar.d.c());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("companion_data", jSONObject);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "companion_data", jSONObject);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put("reason", str);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "reason", str);
            }
        }
        aVar.f.put(jSONObject2);
        aVar.a((String) null);
    }

    public void b() {
        boolean z;
        if (this.l.size() != 1) {
            IAlog.a("%sloadNextVastCompanion called", IAlog.a((Object) this));
            this.g = false;
            if (this.e == null) {
                IAlog.a("%svast data is null! Object must have already been destroyed", IAlog.a((Object) this));
                z = false;
            } else {
                z = true;
            }
            if (this.e.g.size() == 0) {
                IAlog.b("%sgetNextIAvastCompanion - No companion ads found", IAlog.a((Object) this));
            } else if (z) {
                com.fyber.inneractive.sdk.model.vast.b bVar = this.e;
                com.fyber.inneractive.sdk.model.vast.c poll = bVar.g.poll();
                bVar.h = poll;
                IAlog.a("%sgetNextIAvastCompanion returning: %s", IAlog.a((Object) this), poll);
                this.k = 0;
                if (poll == null) {
                    return;
                }
                if (poll.a != h.Static || i.Gif.equals(poll.b)) {
                    a(poll);
                    return;
                } else {
                    b(poll);
                    return;
                }
            }
            IAlog.a("%sno more companion ads available.", IAlog.a((Object) this));
        }
    }

    public final void c() {
        JSONArray jSONArray;
        r rVar = r.VAST_COMPANION_LOAD_ATTEMPT;
        InneractiveAdRequest inneractiveAdRequest = this.b;
        g gVar = this.c;
        com.fyber.inneractive.sdk.config.global.s sVar = this.d;
        if (sVar == null) {
            jSONArray = null;
        } else {
            jSONArray = sVar.c();
        }
        new s.a(rVar, inneractiveAdRequest, (com.fyber.inneractive.sdk.response.e) gVar, jSONArray).a((String) null);
    }

    public void d() {
        com.fyber.inneractive.sdk.config.global.s sVar = this.d;
        if (sVar != null && ((com.fyber.inneractive.sdk.config.global.features.f) sVar.a(com.fyber.inneractive.sdk.config.global.features.f.class)).a("enabled_fmp_endcard", false) && this.e.f != null) {
            a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.f).c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.fyber.inneractive.sdk.flow.m r0) {
        /*
            com.fyber.inneractive.sdk.model.vast.b r0 = r0.e
            if (r0 == 0) goto L_0x0014
            com.fyber.inneractive.sdk.model.vast.l r0 = r0.f
            if (r0 == 0) goto L_0x0014
            java.util.List<java.lang.String> r0 = r0.c
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.m.a(com.fyber.inneractive.sdk.flow.m):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            com.fyber.inneractive.sdk.model.vast.b r0 = r4.e
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.fyber.inneractive.sdk.model.vast.l r0 = r0.f
            if (r0 == 0) goto L_0x000c
            java.util.List<java.lang.String> r0 = r0.c
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            if (r0 == 0) goto L_0x0032
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0032
            r2 = 0
            java.lang.Object r0 = r0.remove(r2)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0032
            com.fyber.inneractive.sdk.network.m0 r2 = new com.fyber.inneractive.sdk.network.m0
            com.fyber.inneractive.sdk.network.w<java.lang.String> r3 = r4.q
            r2.<init>(r3, r0, r1)
            r4.i = r2
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.network.y r0 = r0.s
            r0.b(r2)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.m.a():void");
    }

    public static void a(m mVar, Throwable th) {
        JSONArray jSONArray;
        com.fyber.inneractive.sdk.config.global.s sVar = mVar.d;
        if (sVar == null) {
            jSONArray = null;
        } else {
            jSONArray = sVar.c();
        }
        com.fyber.inneractive.sdk.flow.vast.c cVar = mVar.m;
        InneractiveAdRequest inneractiveAdRequest = mVar.b;
        g gVar = mVar.c;
        cVar.getClass();
        IAlog.a("sending FMP_COMPANION_FAILED_LOADING event", new Object[0]);
        s.a aVar = new s.a(q.FMP_COMPANION_FAILED_LOADING, inneractiveAdRequest, (com.fyber.inneractive.sdk.response.e) gVar, jSONArray);
        JSONObject jSONObject = new JSONObject();
        String message = th != null ? th.getMessage() : null;
        String b2 = cVar.b();
        if (!TextUtils.isEmpty(message)) {
            try {
                jSONObject.put("error", message);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "error", message);
            }
        }
        if (!TextUtils.isEmpty(b2)) {
            try {
                jSONObject.put(MediationMetaData.KEY_VERSION, b2);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", MediationMetaData.KEY_VERSION, b2);
            }
        }
        Boolean valueOf = Boolean.valueOf(cVar.j);
        try {
            jSONObject.put("loaded_from_cache", valueOf);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", "loaded_from_cache", valueOf);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public final void b(com.fyber.inneractive.sdk.model.vast.c cVar) {
        c();
        int i2 = IAlog.a;
        IAlog.a(1, (Exception) null, "%s: %s", "COMPANION_TYPE", cVar.a.name());
        this.k++;
        n0 n0Var = new n0(new e(cVar), cVar.f, this.d);
        this.h = n0Var;
        IAConfigManager.M.s.b(n0Var);
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.c cVar) {
        boolean z;
        String str;
        com.fyber.inneractive.sdk.web.g gVar;
        int i2 = v.a[x.Mraid.ordinal()];
        if (i2 == 1) {
            z = b.a.a.a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML);
        } else if (i2 == 2) {
            z = b.a.a.a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST);
        } else {
            return;
        }
        if (z) {
            c();
            this.k++;
            int i3 = IAlog.a;
            IAlog.a(1, (Exception) null, "%s: %s", "COMPANION_TYPE", cVar.a.name());
            com.fyber.inneractive.sdk.player.controller.c cVar2 = new com.fyber.inneractive.sdk.player.controller.c(this.f, this.j, cVar.a, (com.fyber.inneractive.sdk.web.b) null);
            com.fyber.inneractive.sdk.flow.vast.e eVar = new com.fyber.inneractive.sdk.flow.vast.e(cVar2);
            d dVar = new d(eVar, cVar);
            String str2 = cVar.f;
            h hVar = cVar.a;
            if (hVar == h.Iframe) {
                String c2 = p.c("fyb_iframe_endcard_tmpl.html");
                if (!TextUtils.isEmpty(c2)) {
                    str2 = c2.replace("$__IMGSRC__$", cVar.f).replace("$__SrcIframeUrl__$", cVar.f);
                }
            } else if (hVar == h.Static && cVar.b == i.Gif) {
                a0 a0Var = eVar.g.a;
                if (!(a0Var == null || (gVar = a0Var.b) == null)) {
                    WebSettings settings = gVar.getSettings();
                    settings.setMediaPlaybackRequiresUserGesture(false);
                    settings.setLoadWithOverviewMode(true);
                    settings.setUseWideViewPort(true);
                }
                a0 a0Var2 = eVar.g.a;
                if (a0Var2 != null) {
                    a0Var2.F = false;
                }
                String c3 = p.c("fyb_static_endcard_tmpl.html");
                if (!TextUtils.isEmpty(c3)) {
                    str2 = c3.replace("$__IMGSRC__$", cVar.f);
                }
                if (!TextUtils.isEmpty(str2) && (str = cVar.g) != null) {
                    str2 = str2.replace("$__IMGHREF__$", str.replace("\"", "\\\""));
                }
            }
            a0 a0Var3 = cVar2.a;
            if (a0Var3 != null) {
                if (a0Var3.r == null) {
                    a0Var3.setAdRequest(this.b);
                }
                if (a0Var3.t == null) {
                    a0Var3.setAdResponse(this.c);
                }
            }
            cVar2.a(str2, (d.C0138d) dVar, true);
        }
    }
}
