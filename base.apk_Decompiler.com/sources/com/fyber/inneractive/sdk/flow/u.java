package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.response.e;
import org.json.JSONArray;

public class u implements k.a {
    public final /* synthetic */ t a;

    public u(t tVar) {
        this.a = tVar;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        s sVar;
        if (this.a.b != null) {
            if (inneractiveInfrastructureError.getErrorCode().shouldSendTimeMetric()) {
                this.a.a(inneractiveAdRequest, eVar);
            }
            t tVar = this.a;
            if (tVar.j) {
                j jVar = tVar.h;
                l lVar = tVar.l;
                JSONArray jSONArray = null;
                s sVar2 = lVar != null ? lVar.c : null;
                if (jVar != null && (sVar = jVar.c) != null) {
                    jSONArray = sVar.c();
                } else if (sVar2 != null) {
                    jSONArray = sVar2.c();
                }
                a.a(inneractiveAdRequest, inneractiveInfrastructureError, tVar.e, eVar, jSONArray);
                t tVar2 = this.a;
                InneractiveAdSpot.RequestListener requestListener = tVar2.b;
                if (requestListener != null) {
                    requestListener.onInneractiveFailedAdRequest(tVar2, inneractiveInfrastructureError.getErrorCode());
                    return;
                }
                return;
            }
            t.c cVar = tVar.i;
            if (cVar != null) {
                cVar.onAdRefreshFailed(tVar, inneractiveInfrastructureError.getErrorCode());
            }
        }
    }
}
