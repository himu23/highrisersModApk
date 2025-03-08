package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.j;
import com.fyber.inneractive.sdk.network.c;

public class m implements j.b {
    public final /* synthetic */ IAConfigManager a;

    public m(IAConfigManager iAConfigManager) {
        this.a = iAConfigManager;
    }

    public void onGlobalConfigChanged(j jVar, i iVar) {
        int i = 0;
        if (iVar.a("dv_enabled_v2", 0, 0) == 1) {
            this.a.F.a();
        }
        this.a.G.a();
        c cVar = this.a.H;
        cVar.getClass();
        int i2 = 30;
        int a2 = IAConfigManager.M.u.b.a("send_events_batch_interval", 30, -1);
        if (a2 >= 0) {
            i2 = a2;
        }
        String property = System.getProperty("fyber.marketplace.use_batch_interval");
        if (property == null || Boolean.getBoolean(property)) {
            i = i2;
        }
        cVar.a(i);
    }
}
