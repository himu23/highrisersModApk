package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.flow.c;
import com.fyber.inneractive.sdk.flow.d;
import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.flow.u;
import com.fyber.inneractive.sdk.ignite.h;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;

public abstract class k {
    public a a;
    public volatile boolean b = false;
    public s c;
    public final String d;

    public interface a {
    }

    public k(s sVar, String str, a aVar) {
        this.a = aVar;
        this.c = sVar;
        this.d = str;
    }

    public void a() {
        this.b = true;
        this.a = null;
    }

    public String b() {
        return null;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, e eVar) {
        InneractiveErrorCode inneractiveErrorCode;
        a aVar;
        if (this.a != null) {
            if (this.b) {
                IAlog.d("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
                return;
            }
            a0 b2 = com.fyber.inneractive.sdk.config.a.b(eVar.m);
            if (inneractiveAdRequest != null) {
                inneractiveAdRequest.setSelectedUnitConfig(b2);
            }
            com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
            ImpressionData impressionData = eVar.r;
            com.fyber.inneractive.sdk.interfaces.a aVar2 = null;
            eVar2.a = impressionData != null ? impressionData.getDemandId() : null;
            try {
                eVar2.b = Long.valueOf(IAConfigManager.M.d);
            } catch (NumberFormatException unused) {
                IAlog.a("invalid publisherId", new Object[0]);
            }
            this.c.a(eVar2);
            if (b2 == null) {
                inneractiveErrorCode = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
            } else {
                inneractiveErrorCode = eVar.a(inneractiveAdRequest, this.c);
            }
            if (inneractiveErrorCode == null) {
                com.fyber.inneractive.sdk.flow.k kVar = (com.fyber.inneractive.sdk.flow.k) this.a;
                if (kVar.f) {
                    IAlog.d("IAAdSourceBase: load cancelled: ignoring response. Previous load request was cancelled", new Object[0]);
                    return;
                }
                s sVar = kVar.c;
                IAlog.d("%sonAdDataAvailable: got response data: %s", kVar.d(), eVar);
                IAConfigManager iAConfigManager = IAConfigManager.M;
                if (iAConfigManager.E != null && eVar.b()) {
                    iAConfigManager.E.a((h) null);
                }
                com.fyber.inneractive.sdk.response.a a2 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
                b.C0096b bVar = b.a.a.a.get(a2);
                if (bVar != null) {
                    aVar2 = bVar.a();
                }
                kVar.a = aVar2;
                if (aVar2 == null) {
                    IAlog.e("%sonAdDataAvailable: Cannot find content handler for ad type: %s", kVar.d(), a2);
                    k.a aVar3 = kVar.b;
                    if (aVar3 != null) {
                        ((u) aVar3).a(inneractiveAdRequest, eVar, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.NO_CONTENT_LOADER_AVAILABLE));
                    }
                } else {
                    IAlog.d("%sonAdDataAvailable: found response loader: %s", kVar.d(), kVar.a);
                }
                ((com.fyber.inneractive.sdk.flow.h) kVar.a).a(inneractiveAdRequest, eVar, sVar, kVar, kVar);
                return;
            }
            g gVar = g.CONTENT_ERROR_UNSPECIFIED;
            if (b2 == null || inneractiveErrorCode == InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH) {
                gVar = g.NO_APP_CONFIG_AVAILABLE;
                IAlog.b("%sGot configuration mismatch!", IAlog.a((Object) this));
                IAConfigManager.a();
            }
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, gVar);
            Exception exc = eVar.x;
            if (exc != null) {
                inneractiveInfrastructureError.setCause(exc);
            }
            com.fyber.inneractive.sdk.response.a a3 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
            if (a3 != null) {
                Exception exc2 = eVar.x;
                if (exc2 != null) {
                    inneractiveInfrastructureError.setCause(exc2);
                }
                q.a(new c(new d(eVar, inneractiveAdRequest, a3 == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML ? "send_failed_display_creatives" : "send_failed_vast_creatives", this.c.c()), inneractiveInfrastructureError));
            }
            s sVar2 = this.c;
            if (sVar2 == null) {
                InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(this.d);
                sVar2 = (spot == null || spot.getAdContent() == null) ? null : spot.getAdContent().c;
            }
            com.fyber.inneractive.sdk.flow.a.a(inneractiveAdRequest, inneractiveInfrastructureError, (com.fyber.inneractive.sdk.flow.q) null, eVar, sVar2 != null ? sVar2.c() : null);
            if (!this.b && (aVar = this.a) != null) {
                ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
            }
        }
    }
}
