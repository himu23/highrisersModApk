package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.a1;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.h0;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.b;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.i;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n7;
import com.ironsource.r3;
import com.ironsource.t0;
import com.ironsource.v3;
import com.ironsource.w6;
import com.ironsource.w8;
import com.ironsource.y0;
import com.ironsource.y3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public class d extends m implements BannerSmashListener, y0 {
    private r3 n;
    private r3 o;
    private String p;
    private String q;
    private a1 r;
    /* access modifiers changed from: private */
    public e s;
    private ISDemandOnlyBannerLayout t;
    private final w6 u = w8.e().b();
    private final w6.a v = w8.d().a();

    class a implements Runnable {
        final /* synthetic */ i a;

        a(i iVar) {
            this.a = iVar;
        }

        public void run() {
            d.this.a((int) b.c.f, (Object[][]) null);
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("auction waterfallString = " + this.a.o());
            d.this.a((int) b.c.i, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.o()}});
            d.this.s.a(ContextProvider.getInstance().getApplicationContext(), this.a, (t0) d.this);
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("load timed out state=" + d.this.k());
            d.this.a(new IronSourceError(608, "load timed out"));
        }
    }

    public d(String str, String str2, NetworkSettings networkSettings, long j, AbstractAdapter abstractAdapter, e eVar) {
        super(new h0(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.f = j;
        this.p = str;
        this.q = str2;
        this.r = new a1();
        this.a.initBannerForBidding(str, str2, this.c, this);
        this.s = eVar;
    }

    /* access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        Map<String, Object> j = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    if (objArr2[1] != null) {
                        j.put(objArr2[0].toString(), objArr2[1]);
                    }
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(e.getMessage());
            }
        }
        n7.i().a(new y3(i, new JSONObject(j)));
    }

    /* access modifiers changed from: private */
    public void a(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError.getErrorMessage() + " smash - " + s());
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            p();
            a(ironSourceError, r3.a(this.n));
            a(this.r.b(), IronSourceUtils.getCurrentMethodName());
            if (!t()) {
                this.t.getListener().a(l(), ironSourceError);
            }
        }
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 606) {
            a(3306, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            return;
        }
        a(3300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(618, "No available ad to load"));
                return;
            }
            a((int) b.c.c, (Object[][]) null);
            this.o = new r3();
            this.a.initBannerForBidding(this.p, this.q, this.c, this);
            this.a.loadBannerForDemandOnlyForBidding(this.c, str, this.t, this);
        }
    }

    private boolean t() {
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.t;
        return iSDemandOnlyBannerLayout == null || iSDemandOnlyBannerLayout.isDestroyed();
    }

    private void u() {
        IronLog.INTERNAL.verbose();
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(q()));
    }

    private void v() {
        this.g = null;
        this.h = null;
        this.r = new a1();
    }

    private void w() {
        IronLog.INTERNAL.verbose();
        a((TimerTask) new b());
    }

    public void a(int i, String str, int i2, String str2, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("Auction failed. error " + i + " - " + str);
        this.g = null;
        this.h = null;
        a((int) b.c.g, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(621, "No available ad to load"));
        }
    }

    public void a(d.a aVar, int i, long j, int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        a.C0015a aVar2 = new a.C0015a(aVar.h());
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}});
        }
        a((int) b.c.h, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        a((int) b.c.j, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, aVar2.a()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (aVar2.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(3306, "There is no available ad to load");
                ironLog.error("loadBanner - empty waterfall");
                a(ironSourceError);
                return;
            }
            d1 d1Var = aVar2.get(0);
            this.r.a(d1Var.b());
            this.r.c(d1Var.g());
            this.r.b(d1Var.f());
            String j2 = d1Var.j();
            b(j2);
            c(j2);
        }
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a((int) b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(aVarArr, aVar);
        if (a2 != aVar && a2 != m.a.SHOW_IN_PROGRESS) {
            v();
            a(3002, (Object[][]) null);
            if (!o()) {
                ironLog.verbose("can't load banner when isOneFlow = false");
                a(new IronSourceError(1063, "Missing configuration settings"));
                return;
            }
            this.t = iSDemandOnlyBannerLayout;
            this.n = new r3();
            w();
            if (this.s.a()) {
                u();
                return;
            }
            ironLog.verbose("can't load the banner the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
        } else if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a((int) b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
        } else {
            String str = "banner layout in blocking state | state: " + k();
            iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
            a((int) b.c.e, new Object[][]{new Object[]{"reason", str}});
        }
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a((int) b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(aVarArr, aVar);
        if (a2 != aVar && a2 != m.a.SHOW_IN_PROGRESS) {
            v();
            a(3002, (Object[][]) null);
            if (iSDemandOnlyBannerLayout.isDestroyed()) {
                a(new IronSourceError(610, "bannerLayout is destroyed"));
                return;
            }
            this.t = iSDemandOnlyBannerLayout;
            if (!n()) {
                IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadBannerForBidder in IAB flow must be called by bidder instances");
                a(3300, (Object[][]) null);
                a(buildLoadFailedError);
                return;
            }
            try {
                d.a aVar2 = (d.a) oVar.a(new v3());
                d1 a3 = new a.C0015a(aVar2.h()).a(h());
                if (a3 == null) {
                    IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadBannerForBidder invalid enriched ADM");
                    a(3300, (Object[][]) null);
                    a(buildLoadFailedError2);
                    return;
                }
                String j = a3.j();
                if (j == null) {
                    ironLog.error("serverData is null");
                    a(new IronSourceError(618, "No available ad to load"));
                    return;
                }
                b(j);
                a(aVar2.a());
                a(aVar2.f());
                a((int) b.c.c, (Object[][]) null);
                this.r.a(a3.b());
                this.n = new r3();
                w();
                this.a.initBannerForBidding(this.p, this.q, this.c, this);
                this.a.loadBannerForDemandOnlyForBidding(this.c, j, iSDemandOnlyBannerLayout, this);
            } catch (Exception e) {
                a(ErrorBuilder.buildLoadFailedError("loadBannerForBidder: Exception= " + e.getMessage()));
            }
        } else if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a((int) b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
        } else {
            String str = "banner layout in blocking state | state: " + k();
            iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
            a((int) b.c.e, new Object[][]{new Object[]{"reason", str}});
        }
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog.INTERNAL.error("onAuctionSuccess - Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    public Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        try {
            if (t()) {
                hashMap.put("reason", "banner is destroyed");
            } else {
                l.a((Map<String, Object>) hashMap, this.t.getSize());
            }
            AbstractAdapter abstractAdapter = this.a;
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : str);
            AbstractAdapter abstractAdapter2 = this.a;
            if (abstractAdapter2 != null) {
                str = abstractAdapter2.getCoreSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.b.i());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a());
            hashMap.put("isDemandOnly", 1);
            if (o()) {
                hashMap.put("isOneFlow", 1);
            }
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            hashMap.put("instanceType", Integer.valueOf(this.b.d()));
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put("auctionId", this.g);
            }
            JSONObject jSONObject = this.h;
            if (jSONObject != null && jSONObject.length() > 0) {
                hashMap.put("genericParams", this.h);
            }
            if (!TextUtils.isEmpty(this.j)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.j);
            }
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Instance: " + h() + " " + e.getMessage());
        }
        return hashMap;
    }

    public void onBannerAdClicked() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + s());
        a(3008, (Object[][]) null);
        if (!t()) {
            this.t.getListener().a(l());
        }
    }

    public void onBannerAdLeftApplication() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + s());
        a(3304, (Object[][]) null);
        if (!t()) {
            this.t.getListener().b(l());
        }
    }

    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + s());
        long a2 = r3.a(this.o);
        a((int) b.c.b, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(a2)}});
        a(ironSourceError);
    }

    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + s());
        w6 w6Var = this.u;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        int a2 = w6Var.a(ad_unit);
        long a3 = r3.a(this.o);
        a((int) b.c.d, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(a2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(a3)}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            p();
            if (!t()) {
                this.t.a(view, layoutParams);
            }
            long a4 = r3.a(this.n);
            a(3005, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(a2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(a4)}});
            this.v.b(ad_unit);
            a(this.r.c(), IronSourceUtils.getCurrentMethodName());
            if (!t()) {
                this.t.getListener().c(l());
            }
        }
    }

    public void onBannerAdScreenDismissed() {
    }

    public void onBannerAdScreenPresented() {
    }

    public void onBannerAdShown() {
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("smash - " + s());
            a(3009, (Object[][]) null);
            a(this.r.a(), IronSourceUtils.getCurrentMethodName());
            if (!t()) {
                this.t.getListener().d(l());
            }
        }
    }

    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + s() + " " + ironSourceError.toString());
    }

    public void onBannerInitSuccess() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + s());
    }

    /* access modifiers changed from: package-private */
    public i q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h());
        i iVar = new i(IronSource.AD_UNIT.BANNER);
        iVar.a((List<String>) arrayList);
        iVar.b("" + i() + h());
        iVar.a(l());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.a(this.t.getSize());
        return iVar;
    }

    public void r() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(new m.a[]{m.a.LOADED, m.a.LOAD_IN_PROGRESS, m.a.SHOW_IN_PROGRESS}, m.a.NOT_LOADED);
        if (t()) {
            ironLog.error("Banner is null or already destroyed and can't be used anymore");
            return;
        }
        p();
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.t;
        if (iSDemandOnlyBannerLayout != null) {
            iSDemandOnlyBannerLayout.a();
        }
        this.t = null;
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter == null) {
            ironLog.error("can't destroy adapter. mAdapter == null");
        } else {
            abstractAdapter.destroyBanner(this.c);
        }
        a(3305, (Object[][]) null);
        ironLog.verbose("banner layout was destroyed. bannerId: " + l());
    }

    public String s() {
        return this.b.h().isMultipleInstances() ? this.b.h().getProviderTypeForReflection() : this.b.h().getProviderName();
    }
}
