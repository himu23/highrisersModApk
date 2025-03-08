package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.bidder.adm.f;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.flow.l;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.network.o;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;

public class c implements w<e> {
    public final /* synthetic */ f.a a;
    public final /* synthetic */ e b;
    public final /* synthetic */ f c;

    public c(f fVar, f.a aVar, e eVar) {
        this.c = fVar;
        this.a = aVar;
        this.b = eVar;
    }

    public void a(Object obj, Exception exc, boolean z) {
        e eVar = (e) obj;
        if (exc == null) {
            com.fyber.inneractive.sdk.metrics.c cVar = com.fyber.inneractive.sdk.metrics.c.d;
            cVar.b(this.c.d).b("success");
            f.a aVar = this.a;
            if (aVar != null) {
                t.a aVar2 = (t.a) aVar;
                t tVar = t.this;
                tVar.getClass();
                IAlog.a("%s : InneractiveAdSpotImpl data available", IAlog.a((Object) tVar));
                t tVar2 = t.this;
                s sVar = aVar2.b;
                k.a aVar3 = tVar2.d;
                l lVar = tVar2.l;
                if (lVar != null) {
                    lVar.b = aVar3;
                    cVar.b(tVar2.getLocalUniqueId()).a();
                    lVar.g = eVar;
                    if (IAConfigManager.i()) {
                        lVar.c = sVar;
                        o oVar = new o(sVar, eVar, tVar2.getLocalUniqueId(), lVar);
                        lVar.d = oVar;
                        oVar.c();
                        return;
                    }
                    IAConfigManager.addListener(lVar);
                    IAConfigManager.a();
                    return;
                }
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.c.d.b(this.c.d).b(exc.getMessage());
        f.a aVar4 = this.a;
        if (aVar4 != null) {
            ((t.a) aVar4).a(exc, f.a(this.c, exc) ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.CONNECTION_ERROR, this.b);
        }
    }
}
