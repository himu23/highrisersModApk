package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.d3;
import com.ironsource.k1;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.i;
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
import com.ironsource.u3;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class c implements i.a {
    private ConcurrentHashMap<String, d> a = new ConcurrentHashMap<>();
    private d3 b;

    public c(List<NetworkSettings> list, k1 k1Var, String str, String str2, d3 d3Var) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean k = k1Var.k();
        this.b = d3Var;
        e eVar = new e(new f(k1Var.d(), k, sessionId));
        for (NetworkSettings next : list) {
            if (next.isIronSource()) {
                AbstractAdapter a2 = com.ironsource.mediationsdk.c.b().a(next, next.getBannerSettings(), true);
                if (a2 != null) {
                    d dVar = new d(str, str2, next, k1Var.b(), a2, eVar);
                    dVar.a(k);
                    this.a.put(dVar.l(), dVar);
                }
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            this.b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_LOAD, str);
            IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
            IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
            iSDemandOnlyBannerLayout.getListener().a(str, buildNonExistentInstanceError);
            return;
        }
        dVar.a(iSDemandOnlyBannerLayout);
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            this.b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_LOAD, str);
            IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
            IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
            iSDemandOnlyBannerLayout.getListener().a(str, buildNonExistentInstanceError);
            return;
        }
        dVar.a(iSDemandOnlyBannerLayout, (o) new o.a(IronSourceAES.decode(u3.b().c(), str2)));
    }

    public synchronized void a(String str) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            this.b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_DESTROY, str);
            IronLog.API.error(ErrorBuilder.buildNonExistentInstanceError("Banner").getErrorMessage());
            return;
        }
        dVar.r();
    }
}
