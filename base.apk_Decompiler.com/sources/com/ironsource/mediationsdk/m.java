package com.ironsource.mediationsdk;

import com.ironsource.d1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.r;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public abstract class m {
    private HashSet<ImpressionDataListener> a;
    protected r b = new r();
    protected IronSourceSegment c;
    protected AdInfo d;

    public m(HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        new HashSet();
        this.a = hashSet;
        this.c = ironSourceSegment;
    }

    /* access modifiers changed from: protected */
    public void a(d1 d1Var, String str) {
        if (d1Var != null) {
            ImpressionData a2 = d1Var.a(str);
            if (a2 != null) {
                Iterator<ImpressionDataListener> it = this.a.iterator();
                while (it.hasNext()) {
                    ImpressionDataListener next = it.next();
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info("onImpressionSuccess " + next.getClass().getSimpleName() + ": " + a2);
                    next.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }

    /* access modifiers changed from: protected */
    public void a(IronSource.AD_UNIT ad_unit) {
        this.b.a(ad_unit, false);
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.c = ironSourceSegment;
    }

    public void a(ImpressionData impressionData) {
        if (impressionData != null) {
            this.d = new AdInfo(impressionData);
        }
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.a.remove(impressionDataListener);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        boolean z = false;
        if (jSONObject != null) {
            z = jSONObject.optBoolean(d.e, false);
        }
        this.b.a(ad_unit, z);
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.a.add(impressionDataListener);
        }
    }

    public void c() {
        synchronized (this) {
            this.a.clear();
        }
    }

    /* access modifiers changed from: protected */
    public String e() {
        return "fallback_" + System.currentTimeMillis();
    }

    public void f() {
        this.d = null;
    }
}
