package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.z;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.network.p;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends k {
    public IAConfigManager.OnConfigurationReadyAndValidListener g;

    public j(String str) {
        super(str);
    }

    public final void a(boolean z, e eVar, InneractiveAdRequest inneractiveAdRequest) {
        String str;
        String spotId = inneractiveAdRequest.getSpotId();
        IAConfigManager iAConfigManager = IAConfigManager.M;
        String str2 = iAConfigManager.x.c.get("KEY_MISSMATCH_STATS_SPOTS");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (!str2.contains(String.format("-%s-", new Object[]{spotId}))) {
            s.a aVar = new s.a(q.MISSMATCH_SPOTID, inneractiveAdRequest, eVar, (JSONArray) null);
            if (z) {
                str = String.format("There is no %s spot ID in current app config", new Object[]{spotId});
            } else {
                str = String.format("spot ID %s is not active in current app config", new Object[]{spotId});
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("reason", str);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "reason", str);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
            f0 f0Var = iAConfigManager.x;
            f0Var.c.put("KEY_MISSMATCH_STATS_SPOTS", String.format("%s -%s-", new Object[]{str2, spotId}));
        }
    }

    public final void c(InneractiveAdRequest inneractiveAdRequest) {
        c0 c0Var;
        UnitDisplayType unitDisplayType;
        k.a aVar;
        if (!InneractiveAdManager.wasInitialized() && (aVar = this.b) != null) {
            ((u) aVar).a(inneractiveAdRequest, a(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_NOT_INITIALIZED, g.NO_APP_CONFIG_AVAILABLE));
        }
        z a = a.a(inneractiveAdRequest.getSpotId());
        e a2 = a();
        if (a != null && !a.b) {
            a(false, a2, inneractiveAdRequest);
            ((u) this.b).a(inneractiveAdRequest, a(), new InneractiveInfrastructureError(InneractiveErrorCode.SPOT_DISABLED, g.NO_APP_CONFIG_AVAILABLE));
        } else if (a == null || !a.a.iterator().hasNext()) {
            if (a == null) {
                a(true, a2, inneractiveAdRequest);
                IAConfigManager.a();
            }
            IAlog.e("************************************************************************************************************************", new Object[0]);
            IAlog.e("*** Requested spot id '%s' doesn't exist within this application config - application Id: '%s'", inneractiveAdRequest.getSpotId(), IAConfigManager.M.c);
            IAlog.e("*** Are you sure that you are using the correct application and spot ids, as defined for this application in the Inneractive console?", new Object[0]);
            IAlog.e("************************************************************************************************************************", new Object[0]);
            ((u) this.b).a(inneractiveAdRequest, a2, new InneractiveInfrastructureError(InneractiveErrorCode.ERROR_CONFIGURATION_NO_SUCH_SPOT, g.NO_APP_CONFIG_AVAILABLE));
        } else {
            a0 c = a.c(0);
            if (c.c == null && ((c0Var = c.f) == null || !((unitDisplayType = c0Var.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED))) {
                ((u) this.b).a(inneractiveAdRequest, a(), new InneractiveInfrastructureError(InneractiveErrorCode.UNSUPPORTED_SPOT, g.NO_APP_CONFIG_AVAILABLE));
                return;
            }
            com.fyber.inneractive.sdk.config.global.s b = com.fyber.inneractive.sdk.config.global.s.b();
            this.c = b;
            b.a(inneractiveAdRequest.getSpotId(), false);
            p pVar = new p(inneractiveAdRequest, inneractiveAdRequest.b, this.c, this);
            this.d = pVar;
            pVar.d();
        }
    }

    public String d() {
        return IAlog.a((Object) this);
    }

    public void b(boolean z) {
        IAConfigManager.OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener = this.g;
        if (onConfigurationReadyAndValidListener != null) {
            IAConfigManager.removeListener(onConfigurationReadyAndValidListener);
        }
        com.fyber.inneractive.sdk.network.k kVar = this.d;
        if (kVar != null) {
            kVar.a();
            this.d = null;
        }
        a(z);
        this.b = null;
    }

    public void b() {
        IAlog.a("%s onTimeout()", IAlog.a((Object) this));
    }

    public void c() {
        IAlog.a("%s onRetry()", IAlog.a((Object) this));
    }
}
