package com.ironsource;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.i;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.n;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.b;
import com.ironsource.q1;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class h1 extends q1<j1, AdapterAdViewListener> implements q {
    private boolean I = false;
    private IronSourceBannerLayout J;

    public h1(List<NetworkSettings> list, k1 k1Var, String str, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z) {
        super(new i1(str, list, k1Var), k8Var, ironSourceSegment, z);
    }

    private ISBannerSize I() {
        IronSourceBannerLayout ironSourceBannerLayout = this.J;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.J.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? l.a() : ISBannerSize.BANNER : this.J.getSize();
    }

    private void a(View view, FrameLayout.LayoutParams layoutParams) {
        l.a(this.J, view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        IronLog ironLog;
        String str;
        if (!this.J.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else if (!this.J.hasWindowFocus()) {
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        } else {
            boolean globalVisibleRect = this.J.getGlobalVisibleRect(new Rect());
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("visible = " + globalVisibleRect);
            return globalVisibleRect;
        }
        ironLog.verbose(str);
        return false;
    }

    public void K() {
        IronSourceBannerLayout ironSourceBannerLayout = this.J;
        if (ironSourceBannerLayout != null) {
            a(ironSourceBannerLayout);
        }
    }

    /* access modifiers changed from: protected */
    public AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.o.b(), str, this.J);
    }

    public Map<String, Object> a(t tVar) {
        Map<String, Object> a = super.a(tVar);
        if (b(this.J)) {
            l.a(a, this.J.getSize());
        }
        if (this.i != null) {
            a.put("placement", k());
        }
        return a;
    }

    public void a() {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        try {
            if (this.J == null) {
                ironLog.error("mIronSourceBanner is null");
                this.s.g.b(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL);
            } else if (J()) {
                synchronized (this.x) {
                    if (a(q1.f.SHOWING, q1.f.READY_TO_LOAD)) {
                        ironLog.verbose("start reload");
                        z = true;
                        this.I = true;
                    } else {
                        ironLog.error("wrong state = " + this.p);
                        z = false;
                    }
                }
                if (z) {
                    a(this.J, this.i);
                }
            } else {
                ironLog.verbose("banner is not visible, reload skipped");
                this.s.g.b(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE);
                this.q.i();
            }
        } catch (Throwable th) {
            this.s.k.b(th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, boolean z) {
        if (r()) {
            if (!z) {
                this.s.g.b(r3.a(this.n), i, str);
                n.a().b(this.o.b(), new IronSourceError(i, str), true);
            }
            if (this.I) {
                a(q1.f.SHOWING);
            }
            this.q.i();
            return;
        }
        super.a(i, str, z);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, i iVar, t0 t0Var) {
        if (this.c != null) {
            iVar.a(I());
            this.c.a(context, iVar, t0Var);
            return;
        }
        IronLog.INTERNAL.error(b("mAuctionHandler is null"));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        try {
            if (!b(ironSourceBannerLayout)) {
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                String format = String.format("can't destroy banner - %s", objArr);
                IronLog.API.error("destroy banner failed - errorMessage = " + format);
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            this.q.a();
            j1 j1Var = (j1) this.a.d();
            if (j1Var != null) {
                this.s.g.a(j1Var.r() != null ? j1Var.r().intValue() : this.C.a(this.o.b()));
                j1Var.O();
                this.a.a((t1<?>) null);
            }
            l.a(ironSourceBannerLayout);
            this.J = null;
            this.i = null;
            this.I = false;
            a(q1.f.READY_TO_LOAD);
        } catch (Throwable th) {
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str));
            v vVar = this.s;
            if (vVar != null) {
                vVar.k.c(str);
            }
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, Placement placement) {
        String str;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placement = " + placement);
        int i = 510;
        if (!b(ironSourceBannerLayout)) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        } else if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
            i = s.b(this.o.b());
        } else if (b.b(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName(), this.o.b())) {
            str = String.format("placement %s is capped", new Object[]{placement.getPlacementName()});
            i = s.f(this.o.b());
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(b(str));
            a(i, str, false);
            return;
        }
        this.J = ironSourceBannerLayout;
        this.i = placement;
        w();
    }

    public void a(t1<?> t1Var) {
        IronLog.INTERNAL.verbose(b(t1Var.k()));
        this.t.f(t1Var.f());
    }

    public void a(t1<?> t1Var, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("mState = " + this.p);
        super.e(t1Var);
        if (a(q1.f.READY_TO_SHOW, q1.f.SHOWING)) {
            this.a.a(t1Var);
            a(view, layoutParams);
            this.q.i();
            this.t.a(t1Var.f(), r());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public j1 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, int i, String str, d1 d1Var) {
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        String p = this.o.p();
        JSONObject jSONObject = this.g;
        int i2 = this.e;
        return new j1(this, new p(ad_unit, p, i, jSONObject, str, i2, this.f, networkSettings, this.o.n()), baseAdAdapter, this.J, this.i, r(), d1Var, this);
    }

    /* access modifiers changed from: protected */
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    /* access modifiers changed from: package-private */
    public boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    public void c(t1<?> t1Var) {
        IronLog.INTERNAL.verbose(b(t1Var.k()));
        this.t.e(t1Var.f());
    }

    public void d(t1<?> t1Var) {
        IronLog.INTERNAL.verbose(b(t1Var.k()));
        this.t.b(t1Var.f());
    }

    /* access modifiers changed from: protected */
    public x e() {
        return new l1();
    }

    /* access modifiers changed from: protected */
    public void g(t1<?> t1Var) {
    }

    /* access modifiers changed from: protected */
    public void h(t1<?> t1Var) {
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "BN";
    }

    /* access modifiers changed from: protected */
    public String l() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.I;
    }
}
