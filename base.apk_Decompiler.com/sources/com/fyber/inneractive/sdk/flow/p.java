package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.ignite.c;
import com.fyber.inneractive.sdk.ignite.i;
import com.fyber.inneractive.sdk.ignite.j;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.r;
import com.fyber.inneractive.sdk.web.t;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class p<T extends e> extends q<T> {
    public r g;
    public final j h = new a();

    public p(b0 b0Var, s sVar) {
        super(b0Var, sVar);
    }

    public void a(String str) {
        k kVar;
        String str2;
        k kVar2 = k.NONE;
        T t = this.b;
        String str3 = null;
        if (t != null) {
            k kVar3 = t.F;
            kVar3.getClass();
            kVar = k.SINGLE_TAP;
            if (kVar3 != kVar) {
                if (!this.b.F.e() || isVideoAd()) {
                    kVar = this.b.F;
                } else {
                    ((a) this.h).a(q.IGNITE_FLOW_MODE_NOT_COMPATIBLE, (String) null, (String) null, (k) null);
                }
            }
        } else {
            kVar = kVar2;
        }
        if (j()) {
            T t2 = this.b;
            String str4 = t2 != null ? t2.y : null;
            t tVar = new t();
            tVar.a = str4;
            tVar.b = kVar;
            tVar.c = str;
            tVar.d = this.c;
            tVar.e = t2 != null ? t2.E : null;
            if (t2 != null) {
                str3 = t2.G;
            }
            tVar.f = str3;
            tVar.g = this.h;
            r rVar = new r(tVar);
            this.g = rVar;
            com.fyber.inneractive.sdk.config.global.features.p pVar = (com.fyber.inneractive.sdk.config.global.features.p) this.c.a(com.fyber.inneractive.sdk.config.global.features.p.class);
            if (pVar != null && str4 != null) {
                String a2 = pVar.a("detail_url", "https://cdn2.inner-active.mobi/app-detail-page-v0/[BUNDLE_ID].html");
                if (a2 == null) {
                    str2 = "";
                } else {
                    str2 = a2.replace("[BUNDLE_ID]", str4);
                }
                rVar.g(str2);
                return;
            }
            return;
        }
        T t3 = this.b;
        if (t3 != null) {
            t3.a(kVar2);
        }
    }

    public r c() {
        return this.g;
    }

    public void i() {
        T t;
        if (j()) {
            r rVar = this.g;
            if ((rVar == null || !rVar.l) && (t = this.b) != null && t.F != k.NONE) {
                IAlog.a("ignite webpage was not loaded yet, stopping the loading process", new Object[0]);
                this.b.a(k.NONE);
                r rVar2 = this.g;
                if (rVar2 != null) {
                    Runnable runnable = rVar2.p;
                    if (runnable != null) {
                        com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
                        rVar2.p = null;
                    }
                    if (!rVar2.y) {
                        rVar2.a.stopLoading();
                    }
                    ((a) this.h).a(q.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, this.g.k, i.WEBPAGE_NOT_LOADED_BEFORE_SHOW.e(), this.b.F);
                }
            }
        }
    }

    public final boolean j() {
        c cVar = IAConfigManager.M.E;
        T t = this.b;
        return t != null && t.b() && cVar != null && cVar.d();
    }

    public boolean f() {
        r rVar = this.g;
        return rVar != null && rVar.l;
    }

    public class a implements j {
        public a() {
        }

        public void a(com.fyber.inneractive.sdk.network.r rVar, k kVar) {
            p pVar = p.this;
            InneractiveAdRequest inneractiveAdRequest = pVar.a;
            T t = pVar.b;
            s sVar = pVar.c;
            JSONArray c = sVar != null ? sVar.c() : null;
            s.a aVar = new s.a((e) t);
            aVar.c = rVar;
            aVar.a = inneractiveAdRequest;
            aVar.d = c;
            JSONObject jSONObject = new JSONObject();
            String f = kVar.f();
            try {
                jSONObject.put("ignitem", f);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "ignitem", f);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }

        public void a(q qVar, String str, String str2, k kVar) {
            p pVar = p.this;
            InneractiveAdRequest inneractiveAdRequest = pVar.a;
            T t = pVar.b;
            com.fyber.inneractive.sdk.config.global.s sVar = pVar.c;
            JSONArray c = sVar != null ? sVar.c() : null;
            s.a aVar = new s.a((e) t);
            aVar.b = qVar;
            aVar.a = inneractiveAdRequest;
            aVar.d = c;
            JSONObject jSONObject = new JSONObject();
            if (kVar != null) {
                String f = kVar.f();
                try {
                    jSONObject.put("ignitem", f);
                } catch (Exception unused) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "ignitem", f);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("message", str);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "message", str);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put("error_code", str2);
                } catch (Exception unused3) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "error_code", str2);
                }
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    public boolean a(boolean z, com.fyber.inneractive.sdk.util.i iVar) {
        k kVar;
        T t = this.b;
        if (t != null) {
            kVar = t.F;
        } else {
            kVar = k.NONE;
        }
        return !z && kVar != null && kVar.e() && (iVar == com.fyber.inneractive.sdk.util.i.VIDEO_CTA || iVar == com.fyber.inneractive.sdk.util.i.DEFAULT_ENDCARD);
    }
}
