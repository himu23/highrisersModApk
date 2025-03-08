package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.b;

public class i implements IAConfigManager.OnConfigurationReadyAndValidListener {
    public final /* synthetic */ InneractiveAdRequest a;
    public final /* synthetic */ j b;

    public i(j jVar, InneractiveAdRequest inneractiveAdRequest) {
        this.b = jVar;
        this.a = inneractiveAdRequest;
    }

    public void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        InneractiveErrorCode inneractiveErrorCode;
        IAConfigManager.removeListener(this);
        if (z) {
            this.b.c(this.a);
            return;
        }
        if (exc instanceof b) {
            inneractiveErrorCode = InneractiveErrorCode.CONNECTION_ERROR;
        } else {
            inneractiveErrorCode = InneractiveErrorCode.SDK_NOT_INITIALIZED_OR_CONFIG_ERROR;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, g.NO_APP_CONFIG_AVAILABLE, exc);
        j jVar = this.b;
        jVar.b(this.a, jVar.a(), inneractiveInfrastructureError);
    }
}
