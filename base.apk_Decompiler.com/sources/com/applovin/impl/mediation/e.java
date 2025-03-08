package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.mediation.d.a;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private final AtomicBoolean akD = new AtomicBoolean();
    private final JSONArray alW = new JSONArray();
    private final LinkedHashMap<String, Integer> alX = new LinkedHashMap<>();
    private final Object alY = new Object();
    private List<f> alZ;
    private final x logger;
    private final n sdk;

    public e(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    public boolean isInitialized() {
        return this.akD.get();
    }

    public void b(Activity activity) {
        if (this.akD.compareAndSet(false, true)) {
            String str = (String) this.sdk.a(d.aRL);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<f> a = a(JsonUtils.getJSONArray(jSONObject, this.sdk.CE().isEnabled() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.alZ = a;
                    long parseLong = StringUtils.parseLong(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.ADAPTER_INITIALIZATION_DELAY_MILLIS), -1);
                    a aVar = new a(a, activity, this.sdk);
                    if (parseLong > 0) {
                        this.sdk.BO().a((com.applovin.impl.sdk.e.d) aVar, q.b.BACKGROUND, parseLong);
                    } else {
                        this.sdk.BO().b((com.applovin.impl.sdk.e.d) aVar);
                    }
                } catch (JSONException e) {
                    if (x.Fn()) {
                        this.logger.c("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e);
                    }
                }
            }
        }
    }

    public void a(f fVar, Activity activity) {
        a(fVar, activity, (Runnable) null);
    }

    public void a(f fVar, Activity activity, Runnable runnable) {
        List<f> list;
        if (this.sdk.CE().isEnabled() && (list = this.alZ) != null) {
            Iterator<f> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                f next = it.next();
                if (next.vt().equals(fVar.vt())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar != null) {
            g c = this.sdk.Cw().c(fVar);
            if (c != null) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.g("MediationAdapterInitializationManager", "Initializing adapter " + fVar);
                }
                c.a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.a(fVar), activity, runnable);
            } else if (runnable != null) {
                runnable.run();
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public LinkedHashMap<String, Integer> tV() {
        LinkedHashMap<String, Integer> linkedHashMap;
        synchronized (this.alY) {
            linkedHashMap = this.alX;
        }
        return linkedHashMap;
    }

    public JSONArray tW() {
        JSONArray jSONArray;
        synchronized (this.alY) {
            jSONArray = this.alW;
        }
        return jSONArray;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.alY) {
                z = !b(fVar);
                if (z) {
                    this.alX.put(fVar.vt(), Integer.valueOf(initializationStatus.getCode()));
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, "class", fVar.vt());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                    this.alW.put(jSONObject);
                }
            }
            if (z) {
                this.sdk.e(fVar);
                this.sdk.Cy().processAdapterInitializationPostback(fVar, j, initializationStatus, str);
                this.sdk.Ch().b(initializationStatus, fVar.vt());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(f fVar) {
        boolean containsKey;
        synchronized (this.alY) {
            containsKey = this.alX.containsKey(fVar.vt());
        }
        return containsKey;
    }

    private List<f> a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new f(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.sdk));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.alY) {
            this.alX.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.sdk.Ch().b(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
