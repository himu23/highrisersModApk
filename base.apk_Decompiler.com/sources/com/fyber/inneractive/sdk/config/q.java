package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.global.l;
import com.fyber.inneractive.sdk.network.f;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

public class q implements w<l> {
    public final /* synthetic */ IAConfigManager a;

    public q(IAConfigManager iAConfigManager) {
        this.a = iAConfigManager;
    }

    public void a(Object obj, Exception exc, boolean z) {
        l lVar = (l) obj;
        if (lVar != null) {
            IAlog.a("calling mergeRemoteFeaturesConfig fromCache: %b", Boolean.valueOf(z));
            IAConfigManager iAConfigManager = this.a;
            iAConfigManager.z.a = lVar;
            if (!z) {
                iAConfigManager.L.a("", true);
                IAConfigManager.M.E.a(iAConfigManager.L);
            }
        } else if (exc == null) {
        } else {
            if (exc instanceof f) {
                IAlog.a("remote features config not modified", new Object[0]);
                IAConfigManager iAConfigManager2 = this.a;
                iAConfigManager2.L.a("", true);
                IAConfigManager.M.E.a(iAConfigManager2.L);
                return;
            }
            IAlog.a("Config manager: Error getting or parsing remote config. Resetting configurable features", new Object[0]);
            IAConfigManager iAConfigManager3 = this.a;
            IAConfigManager iAConfigManager4 = IAConfigManager.M;
            iAConfigManager3.getClass();
            new s.a(com.fyber.inneractive.sdk.network.q.FATAL_FEATURES_CONFIG_ERROR).a("exception", exc.getClass().getName(), "message", exc.getLocalizedMessage()).a((String) null);
        }
    }
}
