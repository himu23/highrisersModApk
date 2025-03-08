package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

public class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ b b;

    public c(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public void run() {
        try {
            Omid.activate(this.a);
            this.b.e = Partner.createPartner("Fyber", InneractiveAdManager.getVersion());
            b.a(this.b, this.a);
            IAlog.a("OMID SDK was activated - version %s", Omid.getVersion());
        } catch (Throwable th) {
            IAlog.a("Failed starting omsdk with exception %s", th.getLocalizedMessage());
            this.b.getClass();
            t.a(th.getClass().getSimpleName(), String.format("%s - %s", new Object[]{"OpenMeasurementMeasurer", th.getMessage()}), (InneractiveAdRequest) null, (e) null);
        }
    }
}
