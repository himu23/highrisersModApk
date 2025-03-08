package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

public class j7 extends o1<l7, AdapterAdInteractionListener> {
    public j7(List<NetworkSettings> list, m7 m7Var, String str, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z) {
        super(new k7(str, list, m7Var), k8Var, ironSourceSegment, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public l7 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, int i, String str, d1 d1Var) {
        return new l7(this, new p(IronSource.AD_UNIT.INTERSTITIAL, this.o.p(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter, d1Var, this);
    }

    /* access modifiers changed from: protected */
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }

    /* access modifiers changed from: protected */
    public x e() {
        return new o7();
    }

    /* access modifiers changed from: protected */
    public String i() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    /* access modifiers changed from: protected */
    public String l() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }
}
