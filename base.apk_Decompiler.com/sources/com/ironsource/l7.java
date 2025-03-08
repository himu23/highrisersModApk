package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;

public class l7 extends p1<w> implements InterstitialAdListener {
    public l7(ia iaVar, p pVar, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, d1 d1Var, w wVar) {
        super(iaVar, pVar, baseAdAdapter, new h0(pVar.g(), pVar.g().getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), d1Var, wVar);
    }
}
