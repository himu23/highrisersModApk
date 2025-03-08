package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.d3;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.f;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.r5;
import com.ironsource.u3;
import com.ironsource.ua;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class k implements i.c {
    private final d3 a;
    private final ConcurrentHashMap<String, l> b = new ConcurrentHashMap<>();
    private final r5<ISDemandOnlyRewardedVideoListener> c;

    public k(List<NetworkSettings> list, ua uaVar, c cVar, r5<ISDemandOnlyRewardedVideoListener> r5Var, String str, String str2, d3 d3Var) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean d = uaVar.d();
        f fVar = new f(uaVar.k(), d, sessionId);
        this.a = d3Var;
        this.c = r5Var;
        for (NetworkSettings next : list) {
            if (next.isIronSource()) {
                AbstractAdapter a2 = cVar.a(next, next.getRewardedVideoSettings(), true);
                if (a2 != null) {
                    l lVar = new l(str, str2, next, this.c.a(next.getSubProviderId()), uaVar.i(), a2, new e(fVar));
                    lVar.a(d);
                    this.b.put(next.getSubProviderId(), lVar);
                }
            } else {
                c cVar2 = cVar;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    public ConcurrentHashMap<String, l> a() {
        return this.b;
    }

    public void a(h.d dVar) {
        String b2 = dVar.b();
        try {
            l lVar = this.b.get(b2);
            if (lVar == null) {
                this.a.a(j.b.p, b2);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(b2).onRewardedVideoAdLoadFailed(b2, buildNonExistentInstanceError);
            } else if (dVar.d()) {
                lVar.b(new o.a(IronSourceAES.decode(u3.b().c(), dVar.a())));
            } else {
                lVar.d();
            }
        } catch (Exception e) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo exception " + e.getMessage());
            IronLog.API.error(buildLoadFailedError.getErrorMessage());
            this.c.a(b2).onRewardedVideoAdLoadFailed(b2, buildLoadFailedError);
        }
    }

    public boolean a(String str) {
        l lVar = this.b.get(str);
        if (lVar != null) {
            return lVar.a();
        }
        this.a.a(1500, str);
        return false;
    }

    public void b(String str) {
        try {
            l lVar = this.b.get(str);
            if (lVar == null) {
                this.a.a(1507, str);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(str).onRewardedVideoAdShowFailed(str, buildNonExistentInstanceError);
                return;
            }
            lVar.e();
        } catch (Exception e) {
            IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "showRewardedVideo exception " + e.getMessage());
            IronLog.API.error(buildShowFailedError.getErrorMessage());
            this.c.a(str).onRewardedVideoAdShowFailed(str, buildShowFailedError);
        }
    }
}
