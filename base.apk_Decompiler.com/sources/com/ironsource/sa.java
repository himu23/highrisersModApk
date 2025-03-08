package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.y;
import java.util.List;
import org.json.JSONObject;

public class sa extends r1<ta> {
    public sa(List<NetworkSettings> list, ua uaVar, String str, boolean z, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z2) {
        super(new qa(str, list, uaVar, z), k8Var, ironSourceSegment, z2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ta a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, int i, String str, d1 d1Var) {
        return new ta(this, new p(IronSource.AD_UNIT.REWARDED_VIDEO, this.o.p(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter, d1Var, this);
    }

    /* access modifiers changed from: protected */
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }

    /* access modifiers changed from: protected */
    public x e() {
        return new wa();
    }

    /* access modifiers changed from: protected */
    public String i() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    /* access modifiers changed from: protected */
    public String l() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return this.o.h().a() == y.a.MANUAL;
    }
}
