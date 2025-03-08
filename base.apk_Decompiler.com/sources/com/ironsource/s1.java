package com.ironsource;

import com.ironsource.c0;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashMap;

public class s1<Listener extends c0> extends p1<Listener> implements AdapterAdRewardListener {
    private r3 r;

    class a extends cb {
        a() {
        }

        public void a() {
            s1.this.T();
        }
    }

    public s1(ia iaVar, p pVar, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, h0 h0Var, d1 d1Var, Listener listener) {
        super(iaVar, pVar, baseAdAdapter, h0Var, d1Var, listener);
    }

    /* access modifiers changed from: private */
    public void T() {
        if (this.g != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(a("placement name = " + j()));
            if (this.d != null) {
                HashMap hashMap = new HashMap();
                if (p.o().s() != null) {
                    for (String next : p.o().s().keySet()) {
                        hashMap.put("custom_" + next, p.o().s().get(next));
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.d.j.a(j(), this.g.getRewardName(), this.g.getRewardAmount(), currentTimeMillis, IronSourceUtils.getTransId(currentTimeMillis, c()), r3.a(this.r), hashMap, p.o().n());
            }
            ((c0) this.b).a(this, this.g);
            return;
        }
        IronLog.INTERNAL.verbose(a("placement is null "));
        v vVar = this.d;
        if (vVar != null) {
            oc ocVar = vVar.k;
            ocVar.c("mCurrentPlacement is null state = " + this.e);
        }
    }

    public void onAdClosed() {
        this.r = new r3();
        super.onAdClosed();
    }

    public void onAdOpened() {
        this.r = null;
        super.onAdOpened();
    }

    public void onAdRewarded() {
        if (!t().c()) {
            T();
        } else {
            t().a(new a());
        }
    }
}
