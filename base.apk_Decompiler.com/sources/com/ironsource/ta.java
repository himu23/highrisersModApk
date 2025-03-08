package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;

public class ta extends s1<c0> implements RewardedVideoAdListener {
    public ta(ia iaVar, p pVar, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, d1 d1Var, c0 c0Var) {
        super(iaVar, pVar, baseAdAdapter, new h0(pVar.g(), pVar.g().getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), d1Var, c0Var);
    }
}
