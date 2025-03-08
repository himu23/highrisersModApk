package com.ironsource;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.t1;
import java.util.Map;

public class j1 extends t1<q> implements BannerAdListener, u {
    public static final String t = "bannerLayout";
    public static final String u = "bannerSize";
    private final IronSourceBannerLayout r;
    private final boolean s;

    public j1(ia iaVar, p pVar, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, IronSourceBannerLayout ironSourceBannerLayout, Placement placement, boolean z, d1 d1Var, q qVar) {
        super(iaVar, pVar, baseAdAdapter, new h0(pVar.g(), pVar.g().getBannerSettings(), IronSource.AD_UNIT.BANNER), d1Var, qVar);
        this.r = ironSourceBannerLayout;
        this.g = placement;
        this.s = z;
    }

    /* access modifiers changed from: protected */
    public void F() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
        if (baseAdAdapter instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) baseAdAdapter).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this.r.getSize(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
        }
    }

    /* access modifiers changed from: protected */
    public boolean N() {
        return false;
    }

    public void O() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(t1.h.NONE);
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
        if (baseAdAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (baseAdAdapter instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) baseAdAdapter).destroyAd(this.k);
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            v vVar = this.d;
            if (vVar != null) {
                vVar.k.c(str);
            }
        }
        v vVar2 = this.d;
        if (vVar2 != null) {
            vVar2.g.a(r().intValue());
        }
    }

    /* access modifiers changed from: protected */
    public AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    public Map<String, Object> a(t tVar) {
        Map<String, Object> a = super.a(tVar);
        IronSourceBannerLayout ironSourceBannerLayout = this.r;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            l.a(a, this.r.getSize());
        }
        if (this.g != null) {
            a.put("placement", j());
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> a = super.a(map);
        p pVar = this.a;
        if (!(pVar == null || this.r == null || !TextUtils.isEmpty(pVar.g().getCustomNetwork()))) {
            a.put("bannerLayout", this.r);
        }
        return a;
    }

    public void onAdLeftApplication() {
        v vVar;
        Placement placement = this.g;
        if (!(placement == null || (vVar = this.d) == null)) {
            vVar.j.d(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != null) {
            ((q) listener).d(this);
        }
    }

    public void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams) {
        Listener listener;
        super.onAdLoadSuccess();
        if (x() && (listener = this.b) != null) {
            ((q) listener).a(this, view, layoutParams);
        }
    }

    public void onAdOpened() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (x()) {
            super.onAdOpened();
        } else if (this.e != t1.h.FAILED) {
            ironLog.error(String.format("unexpected onAdOpened for %s, state - %s", new Object[]{k(), this.e}));
            if (this.d != null) {
                this.d.k.l(String.format("unexpected onAdOpened, state - %s", new Object[]{this.e}));
            }
        }
    }

    public void onAdScreenDismissed() {
        v vVar;
        Placement placement = this.g;
        if (!(placement == null || (vVar = this.d) == null)) {
            vVar.j.b(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != null) {
            ((q) listener).c(this);
        }
    }

    public void onAdScreenPresented() {
        v vVar;
        Placement placement = this.g;
        if (!(placement == null || (vVar = this.d) == null)) {
            vVar.j.f(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != null) {
            ((q) listener).a(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return this.s;
    }
}
