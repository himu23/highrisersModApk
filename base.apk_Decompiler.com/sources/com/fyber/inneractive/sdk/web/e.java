package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.t;
import com.fyber.inneractive.sdk.web.d;
import com.iab.omid.library.fyber.ScriptInjector;
import com.ironsource.z3;

public class e extends b<Void, Void, String> {
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ d l;

    public e(d dVar, String str, boolean z, String str2, String str3, String str4) {
        this.l = dVar;
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = str3;
        this.k = str4;
    }

    public Object a(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.g;
        if (this.h) {
            d dVar = this.l;
            String str2 = this.i;
            String str3 = this.j;
            a0 a0Var = (a0) dVar;
            a0Var.getClass();
            StringBuilder sb = new StringBuilder("<html><title>DigitalTurbine Ad</title><head><link rel=\"icon\" href=\"data:,\">");
            if (TextUtils.isEmpty(str)) {
                IAlog.a("loadHtml called with an empty HTML!", new Object[0]);
            } else {
                if (a0Var.F) {
                    String c = p.c("ia_js_load_monitor.txt");
                    if (!TextUtils.isEmpty(c)) {
                        sb.append(c);
                    }
                }
                sb.append("<script> window.iaPreCachedAd = true; </script>");
                IAConfigManager iAConfigManager = IAConfigManager.M;
                boolean a = iAConfigManager.u.b.a("use_js_inline", false);
                if (!a || iAConfigManager.G.b == null) {
                    sb.append("<script src=\"https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js\"></script>");
                } else {
                    sb.append("<script type=\"text/javascript\">");
                    sb.append(iAConfigManager.G.b);
                    sb.append("</script>");
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
                sb.append("<script>var prevWindowOnError = window.onerror; window.onerror = function(err) {if (typeof prevWindowOnError === 'function') {prevWindowOnError.apply();} console.log('WINDOW.ONERROR Javascript Error: ' + err);};</script></head><style>body{text-align:center !important;margin:0;padding:0;}");
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str3);
                }
                sb.append("</style><body id=\"iaBody\">");
                if (a0Var.B && a0Var.p()) {
                    if (!a || iAConfigManager.G.c == null) {
                        sb.append("<link rel=\"stylesheet\" href=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css\">");
                    } else {
                        sb.append("<style type=\"text/css\">");
                        sb.append(iAConfigManager.G.c);
                        sb.append("</style>");
                    }
                    if (!a || iAConfigManager.G.d == null) {
                        sb.append("<script src=\"https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js\"></script>");
                    } else {
                        sb.append("<script type=\"text/javascript\">");
                        sb.append(iAConfigManager.G.d);
                        sb.append("</script>");
                    }
                }
                String c2 = p.c("ia_mraid_bridge.txt");
                if (!TextUtils.isEmpty(c2)) {
                    sb.append("<div id='iaScriptBr' style='display:none;'>");
                    sb.append(c2);
                    sb.append("</div>");
                    if (IAlog.a >= 2) {
                        sb.append("<script type=\"text/javascript\">window.mraidbridge.loggingEnabled = true;</script>");
                    }
                }
                sb.append(str);
                sb.append("</body></html>");
                if (a0Var.I != null) {
                    com.fyber.inneractive.sdk.response.e d = a0Var.s.d();
                    boolean z = d != null && d.H;
                    a aVar = a0Var.I;
                    String sb2 = sb.toString();
                    com.fyber.inneractive.sdk.measurement.b bVar = (com.fyber.inneractive.sdk.measurement.b) aVar;
                    if (z) {
                        StringBuilder sb3 = new StringBuilder();
                        if (!TextUtils.isEmpty(bVar.c)) {
                            sb3.append(bVar.c);
                        }
                        if (!TextUtils.isEmpty(bVar.d)) {
                            sb3.append(bVar.d);
                        }
                        str = ScriptInjector.injectScriptContentIntoHtml(sb3.toString(), sb2);
                    } else {
                        str = sb2;
                    }
                    if (!TextUtils.isEmpty(bVar.b)) {
                        str = ScriptInjector.injectScriptContentIntoHtml(bVar.b, str);
                    }
                } else {
                    str = sb.toString();
                }
            }
            str = null;
        }
        d dVar2 = this.l;
        dVar2.getClass();
        IAlog.a("%sbuild html string took %d msec", IAlog.a((Object) dVar2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return str;
    }

    public void a(Object obj) {
        String str = (String) obj;
        String str2 = t.a() ? "http://" : "https://";
        if (!TextUtils.isEmpty(str) && !b()) {
            if (!TextUtils.isEmpty(this.k)) {
                d dVar = this.l;
                dVar.p = str2 + this.k;
            } else {
                this.l.p = str2.concat("wv.inner-active.mobi/");
            }
            if (!this.f) {
                d dVar2 = this.l;
                g gVar = dVar2.b;
                if (gVar != null) {
                    gVar.loadDataWithBaseURL(dVar2.p, str, "text/html", z3.L, (String) null);
                    this.l.q = str;
                } else {
                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.COULD_NOT_LOAD_TO_WEBVIEW);
                    d.C0138d dVar3 = dVar2.f;
                    if (dVar3 != null) {
                        dVar3.a(dVar2, inneractiveInfrastructureError);
                    }
                    dVar2.b(true);
                }
            } else {
                return;
            }
        } else if (!b()) {
            d dVar4 = this.l;
            InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.EMPTY_FINAL_HTML);
            d.C0138d dVar5 = dVar4.f;
            if (dVar5 != null) {
                dVar5.a(dVar4, inneractiveInfrastructureError2);
            }
            dVar4.b(true);
        }
        c();
        this.l.o = null;
    }
}
