package com.ironsource;

import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.s1;

public abstract class r1<Smash extends s1<?>> extends o1<Smash, AdapterAdRewardListener> implements c0 {
    public r1(l lVar, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z) {
        super(lVar, k8Var, ironSourceSegment, z);
    }

    public void a(s1<?> s1Var, Placement placement) {
        IronLog.INTERNAL.verbose(b(s1Var.k()));
        this.t.b(placement, s1Var.f());
    }
}
