package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.c0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.flow.w;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class e implements w, c0 {
    public InneractiveUnitController<?> a;
    public q b;
    public final String c;
    public boolean d = false;

    public e(InneractiveUnitController<?> inneractiveUnitController, q qVar) {
        this.a = inneractiveUnitController;
        this.b = qVar;
        this.c = UUID.randomUUID().toString();
    }

    public void a(t.c cVar) {
    }

    public void addUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    public q getAdContent() {
        return this.b;
    }

    public InneractiveAdRequest getCurrentProcessedRequest() {
        return null;
    }

    public String getLocalUniqueId() {
        return this.c;
    }

    public InneractiveMediationName getMediationName() {
        return null;
    }

    public String getMediationNameString() {
        return null;
    }

    public String getMediationVersion() {
        return "";
    }

    public String getRequestedSpotId() {
        return "";
    }

    public InneractiveUnitController getSelectedUnitController() {
        return this.a;
    }

    public void loadAd(String str) {
    }

    public void removeUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    public void requestAd(InneractiveAdRequest inneractiveAdRequest) {
    }

    public void setMediationName(InneractiveMediationName inneractiveMediationName) {
    }

    public void setMediationName(String str) {
    }

    public void setMediationVersion(String str) {
    }

    public void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
    }

    public void a() {
        q qVar = this.b;
        if (qVar != null) {
            qVar.a();
        }
        this.b = null;
        this.a = null;
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    public void destroy() {
        InneractiveUnitController<?> inneractiveUnitController = this.a;
        if (inneractiveUnitController != null) {
            inneractiveUnitController.destroy();
        }
        a();
    }

    public boolean isReady() {
        q qVar = this.b;
        if (qVar == null) {
            return false;
        }
        boolean z = qVar.d() != null && this.b.d().c();
        if (z) {
            q qVar2 = this.b;
            com.fyber.inneractive.sdk.response.e d2 = qVar2.d();
            if (!this.d && d2 != null && d2.c != 0 && d2.c()) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(d2.a - System.currentTimeMillis());
                long j = d2.b;
                IAlog.a(String.format("Firing Event 802 - AdExpired - time passed- %s, sessionTimeOut - %s", new Object[]{Long.valueOf(minutes), Long.valueOf(j)}), new Object[0]);
                s.a aVar = new s.a(com.fyber.inneractive.sdk.network.q.IA_AD_EXPIRED, qVar2.a, d2, qVar2.c.c());
                JSONObject jSONObject = new JSONObject();
                Long valueOf = Long.valueOf(minutes);
                try {
                    jSONObject.put("time_passed", valueOf);
                } catch (Exception unused) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "time_passed", valueOf);
                }
                Long valueOf2 = Long.valueOf(j);
                try {
                    jSONObject.put("timeout", valueOf2);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "timeout", valueOf2);
                }
                aVar.f.put(jSONObject);
                aVar.a((String) null);
                this.d = true;
            }
        }
        return !z;
    }
}
