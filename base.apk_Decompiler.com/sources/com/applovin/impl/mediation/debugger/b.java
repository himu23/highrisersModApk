package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.c.c;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.m2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements b.d<JSONObject> {
    /* access modifiers changed from: private */
    public static final AtomicBoolean akq = new AtomicBoolean();
    /* access modifiers changed from: private */
    public static WeakReference<MaxDebuggerActivity> anZ;
    private final Context E;
    private final AtomicBoolean akD = new AtomicBoolean();
    private boolean akp;
    /* access modifiers changed from: private */
    public final com.applovin.impl.mediation.debugger.ui.b.b aoa;
    private final Map<String, com.applovin.impl.mediation.debugger.b.c.b> aob = new HashMap();
    private boolean aoc;
    private int aod = 2;
    private Map<String, List<?>> aoe;
    private final a aof;
    private final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public void h(boolean z, int i) {
        this.aoc = z;
        this.aod = i;
    }

    public boolean uC() {
        return this.aoc;
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        com.applovin.impl.mediation.debugger.ui.b.b bVar = new com.applovin.impl.mediation.debugger.ui.b.b(applicationContext);
        this.aoa = bVar;
        this.aof = new a(nVar, bVar);
    }

    public void uB() {
        if (this.akD.compareAndSet(false, true)) {
            this.sdk.BO().a((d) new c(this, this.sdk), q.b.MEDIATION_MAIN);
        }
    }

    public void showMediationDebugger() {
        showMediationDebugger((Map<String, List<?>>) null);
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        this.aoe = map;
        uB();
        if (uD() || !akq.compareAndSet(false, true)) {
            x.H("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        if (!this.akp) {
            ty();
            this.akp = true;
        }
        Intent intent = new Intent(this.E, MaxDebuggerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        x.D("AppLovinSdk", "Starting mediation debugger...");
        this.E.startActivity(intent);
    }

    public List<?> bH(String str) {
        Map<String, List<?>> map = this.aoe;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.aoe.get(str);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.aoa + "}";
    }

    private void ty() {
        this.sdk.BM().a(new a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof MaxDebuggerActivity) {
                    x.D("AppLovinSdk", "Started mediation debugger");
                    if (!b.this.uD() || b.anZ.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = b.anZ = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(b.this.aoa, b.this.sdk.BM());
                    }
                    b.akq.set(false);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    x.D("AppLovinSdk", "Mediation debugger destroyed");
                    WeakReference unused = b.anZ = null;
                }
            }
        });
    }

    private void o(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b next : list) {
            if (next.vp() && next.vl() == b.a.INVALID_INTEGRATION) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new b$$ExternalSyntheticLambda2(this), TimeUnit.SECONDS.toMillis(2));
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uE() {
        Activity CF = this.sdk.CF();
        if (CF == null || CF.isFinishing()) {
            x.H("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
        } else {
            new AlertDialog.Builder(CF).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new b$$ExternalSyntheticLambda0(this)).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        showMediationDebugger();
    }

    /* access modifiers changed from: private */
    public boolean uD() {
        WeakReference<MaxDebuggerActivity> weakReference = anZ;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private List<com.applovin.impl.mediation.debugger.b.c.b> a(JSONObject jSONObject, n nVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                com.applovin.impl.mediation.debugger.b.c.b bVar = new com.applovin.impl.mediation.debugger.b.c.b(jSONObject2, nVar);
                arrayList.add(bVar);
                this.aob.put(bVar.vt(), bVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.a.a> a(JSONObject jSONObject, List<com.applovin.impl.mediation.debugger.b.c.b> list, n nVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new com.applovin.impl.mediation.debugger.b.a.a(jSONObject2, this.aob, nVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.a.a> a(List<com.applovin.impl.mediation.debugger.b.a.a> list, n nVar) {
        List<String> initializationAdUnitIds = nVar.getSettings().getInitializationAdUnitIds();
        if (initializationAdUnitIds == null || initializationAdUnitIds.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(initializationAdUnitIds.size());
        for (com.applovin.impl.mediation.debugger.b.a.a next : list) {
            if (initializationAdUnitIds.contains(next.mQ())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.b.b> c(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : JsonUtils.getList(jSONObject, "required_app_ads_txt_entries", new ArrayList())) {
            com.applovin.impl.mediation.debugger.b.b.b bVar = new com.applovin.impl.mediation.debugger.b.b.b(str);
            if (bVar.vi()) {
                arrayList.add(bVar);
            } else if (x.Fn()) {
                x xVar = this.logger;
                xVar.i("MediationDebuggerService", "app-ads.txt entry passed down for validation is misformatted: " + str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void d(JSONObject jSONObject, int i) {
        List<com.applovin.impl.mediation.debugger.b.c.b> a = a(jSONObject, this.sdk);
        List<com.applovin.impl.mediation.debugger.b.a.a> a2 = a(jSONObject, a, this.sdk);
        List<com.applovin.impl.mediation.debugger.b.a.a> a3 = a(a2, this.sdk);
        List<com.applovin.impl.mediation.debugger.b.b.b> c = c(jSONObject);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        List<com.applovin.impl.mediation.debugger.b.c.b> list = a;
        List<com.applovin.impl.mediation.debugger.b.b.b> list2 = c;
        this.aoa.a(list, a2, a3, list2, JsonUtils.getString(jSONObject2, m2.h.D0, (String) null), JsonUtils.getString(jSONObject2, "message", (String) null), JsonUtils.getString(jSONObject, "account_id", (String) null), JsonUtils.getBoolean(jSONObject, "complies_with_google_families_policy", (Boolean) null), JsonUtils.getBoolean(jSONObject, "should_display_cmp_details", true).booleanValue(), this.sdk);
        if (!c.isEmpty()) {
            this.aof.uA();
        }
        if (uC()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new b$$ExternalSyntheticLambda1(this), TimeUnit.SECONDS.toMillis((long) this.aod));
        } else {
            o(a);
        }
    }

    public void a(int i, String str, JSONObject jSONObject) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.i("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        }
        x.H("AppLovinSdk", "Unable to show mediation debugger.");
        this.aoa.a((List<com.applovin.impl.mediation.debugger.b.c.b>) null, (List<com.applovin.impl.mediation.debugger.b.a.a>) null, (List<com.applovin.impl.mediation.debugger.b.a.a>) null, (List<com.applovin.impl.mediation.debugger.b.b.b>) null, (String) null, (String) null, (String) null, (Boolean) null, false, this.sdk);
        this.akD.set(false);
    }
}
