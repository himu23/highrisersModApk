package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.interfaces.a;
import com.fyber.inneractive.sdk.metrics.c;
import com.fyber.inneractive.sdk.metrics.g;
import com.fyber.inneractive.sdk.network.k;
import com.fyber.inneractive.sdk.response.e;

public class l extends k implements IAConfigManager.OnConfigurationReadyAndValidListener {
    public e g;

    public l(String str) {
        super(str);
    }

    public void a(InneractiveAdRequest inneractiveAdRequest) {
        c.d.b(this.e).a("success");
        super.a(inneractiveAdRequest);
    }

    public void b() {
        c.d.b(this.e).a("dyn_timeout");
    }

    public void c() {
        c.d.b(this.e).a("retrying");
    }

    public void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (!z) {
            b((InneractiveAdRequest) null, a(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.NO_APP_CONFIG_AVAILABLE, exc));
        }
    }

    public void a(boolean z) {
        k kVar = this.d;
        if (kVar != null) {
            kVar.a();
        }
        this.f = true;
        a aVar = this.a;
        if (aVar != null && z) {
            aVar.a();
            this.a = null;
        }
    }

    public void b(InneractiveAdRequest inneractiveAdRequest) {
        String str;
        e eVar = this.g;
        if (eVar != null && (str = eVar.z) != null) {
            g b = c.d.b(str);
            s sVar = this.c;
            if (sVar == null) {
                sVar = s.b();
            }
            b.a(eVar, inneractiveAdRequest, sVar);
        }
    }

    public void a(e eVar, InneractiveAdRequest inneractiveAdRequest) {
        String str;
        if (eVar != null && (str = eVar.z) != null) {
            g b = c.d.b(str);
            s sVar = this.c;
            if (sVar == null) {
                sVar = s.b();
            }
            b.a(eVar, inneractiveAdRequest, sVar);
        }
    }
}
