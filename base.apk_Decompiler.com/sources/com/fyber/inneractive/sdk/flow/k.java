package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.interfaces.a;
import com.fyber.inneractive.sdk.metrics.b;
import com.fyber.inneractive.sdk.metrics.c;
import com.fyber.inneractive.sdk.network.k;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;

public abstract class k implements k.a, a.C0100a, a.b {
    public com.fyber.inneractive.sdk.interfaces.a a;
    public a b;
    public s c;
    public com.fyber.inneractive.sdk.network.k d;
    public final String e;
    public boolean f = false;

    public interface a {
    }

    public k(String str) {
        this.e = str;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest) {
        T t;
        e0 e0Var;
        IAlog.d("%sgot onAdLoaded!", d());
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar != null) {
            a aVar2 = this.b;
            if (aVar2 != null) {
                Content content = ((h) aVar).c;
                u uVar = (u) aVar2;
                t tVar = uVar.a;
                if (tVar.j || (e0Var = tVar.f) == null || !e0Var.supportsRefresh()) {
                    boolean unused = uVar.a.j = false;
                    t tVar2 = uVar.a;
                    tVar2.e = content;
                    content.a = inneractiveAdRequest;
                    if (!tVar2.e()) {
                        t tVar3 = uVar.a;
                        tVar3.getClass();
                        IAlog.a("%sCannot find appropriate unit controller for unit: %s", IAlog.a((Object) tVar3), uVar.a.e.d);
                        j jVar = uVar.a.h;
                        e a2 = jVar != null ? jVar.a() : null;
                        InneractiveErrorCode inneractiveErrorCode = InneractiveErrorCode.INVALID_INPUT;
                        g gVar = g.COULD_NOT_SELECT_UNIT_CONTROLLER;
                        uVar.a(inneractiveAdRequest, a2, new InneractiveInfrastructureError(inneractiveErrorCode, gVar, new Exception("Cannot find appropriate unit controller for unit: " + uVar.a.e.d)));
                        uVar.a.e = null;
                    } else {
                        t tVar4 = uVar.a;
                        InneractiveAdSpot.RequestListener requestListener = tVar4.b;
                        if (requestListener != null) {
                            requestListener.onInneractiveSuccessfulAdRequest(tVar4);
                        }
                    }
                } else if (uVar.a.f.canRefreshAd()) {
                    t tVar5 = uVar.a;
                    tVar5.e = content;
                    content.a = inneractiveAdRequest;
                    t.c cVar = tVar5.i;
                    if (cVar != null) {
                        cVar.onAdRefreshed(tVar5);
                    } else {
                        e0 e0Var2 = tVar5.f;
                        if (e0Var2 instanceof InneractiveAdViewUnitController) {
                            ((InneractiveAdViewUnitController) e0Var2).onAdRefreshed(tVar5);
                        }
                    }
                } else {
                    t tVar6 = uVar.a;
                    tVar6.getClass();
                    IAlog.a("%sad loaded successfully, but the selected unit controller has rejected the refresh!", IAlog.a((Object) tVar6));
                    t tVar7 = uVar.a;
                    tVar7.i.onAdRefreshFailed(tVar7, InneractiveErrorCode.CANCELLED);
                }
                String str = uVar.a.a;
                c cVar2 = c.d;
                cVar2.a(str).e();
                cVar2.a(str).b();
                t tVar8 = uVar.a;
                q qVar = tVar8.e;
                if (!(qVar == null || (t = qVar.b) == null || t.n == null)) {
                    q qVar2 = tVar8.e;
                    T t2 = qVar2.b;
                    new b(t2, tVar8.c, tVar8.a, t2.n, qVar2.c.c()).a();
                }
            }
            this.a = null;
        }
        b(inneractiveAdRequest);
    }

    public void a(e eVar, InneractiveAdRequest inneractiveAdRequest) {
    }

    public void b(InneractiveAdRequest inneractiveAdRequest) {
    }

    public void b(InneractiveAdRequest inneractiveAdRequest, e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (IAlog.a <= 3) {
            Thread.dumpStack();
        }
        IAlog.d("%sgot onAdRequestFailed! with: %s", d(), inneractiveInfrastructureError.getErrorCode());
        if (this.b != null) {
            if (!(eVar == null || eVar.i == null)) {
                inneractiveInfrastructureError.setCause(new Exception(eVar.i + ": " + eVar.j));
            }
            ((u) this.b).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }

    public String d() {
        return IAlog.a((Object) this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r0 = ((com.fyber.inneractive.sdk.flow.h) r0).c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.external.InneractiveInfrastructureError r4) {
        /*
            r3 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = r3.d()
            r2 = 0
            r0[r2] = r1
            r1 = 1
            r0[r1] = r4
            java.lang.String r1 = "%sgot onFailedLoading! with: %s"
            com.fyber.inneractive.sdk.util.IAlog.d(r1, r0)
            com.fyber.inneractive.sdk.interfaces.a r0 = r3.a
            if (r0 == 0) goto L_0x001f
            com.fyber.inneractive.sdk.flow.h r0 = (com.fyber.inneractive.sdk.flow.h) r0
            Content r0 = r0.c
            if (r0 == 0) goto L_0x001f
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r0.a
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            com.fyber.inneractive.sdk.response.e r1 = r3.a()
            r3.a(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.k.a(com.fyber.inneractive.sdk.external.InneractiveInfrastructureError):void");
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.d("%sgot handleFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        a aVar = this.b;
        if (aVar != null) {
            ((u) aVar).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
        a(eVar, inneractiveAdRequest);
    }

    public e a() {
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        h hVar = (h) aVar;
        if (hVar.c != null) {
            return hVar.c.d();
        }
        return null;
    }

    public void a(boolean z) {
        this.f = true;
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar != null && z) {
            aVar.a();
            this.a = null;
        }
    }
}
