package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.b;
import com.fyber.inneractive.sdk.web.i;
import java.util.Map;

public class m extends a {
    public m(Map<String, String> map, i iVar, p0 p0Var) {
        super(map, iVar, p0Var);
    }

    public void d() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.a(g.OPEN, "No native click was detected in a timely fashion");
        }
    }

    public void a() {
        b0.a aVar;
        String str;
        String str2;
        String str3 = this.b.get("url");
        IAlog.d("IAmraidActionOpen: opening Internal Browser For Url: %s", str3);
        i iVar = this.c;
        if (iVar != null) {
            p0 p0Var = this.d;
            L l = iVar.g;
            if (l != null) {
                aVar = ((i.h) l).a(str3, p0Var, (b.a) null);
            } else {
                b0.d dVar = b0.d.FAILED;
                Exception exc = new Exception("No webview listener available");
                if (iVar.l() == null) {
                    str2 = "null";
                } else {
                    str2 = iVar.l().getClass().getName();
                }
                aVar = new b0.a(dVar, exc, str2);
            }
            if (aVar.a == b0.d.FAILED) {
                i iVar2 = this.c;
                g gVar = g.OPEN;
                Throwable th = aVar.b;
                if (th == null) {
                    str = "unknown error";
                } else {
                    str = th.getMessage();
                }
                iVar2.a(gVar, str);
            }
        }
    }

    public String c() {
        return this.b.get("url");
    }
}
