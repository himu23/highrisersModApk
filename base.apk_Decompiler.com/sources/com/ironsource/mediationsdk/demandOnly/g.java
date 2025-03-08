package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.a1;
import com.ironsource.b1;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.h0;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.e;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.i;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
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
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public class g extends m implements n.a, InterstitialSmashListener, y0 {
    private r3 n;
    private r3 o;
    private ISDemandOnlyInterstitialListener p;
    private a1 q;
    private e r;
    private p s = new p.b();
    private final w6 t = w8.e().b();
    private final w6.a u = w8.d().a();

    class a extends TimerTask {
        a() {
        }

        public void run() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    public g(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener, long j, AbstractAdapter abstractAdapter, e eVar) {
        super(new h0(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.p = iSDemandOnlyInterstitialListener;
        this.f = j;
        this.r = eVar;
        this.a.initInterstitial(str, str2, this.c, this);
    }

    private void a(int i, Object[][] objArr) {
        Map<String, Object> j = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    j.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e));
            }
        }
        n7.i().a(new y3(i, new JSONObject(j)));
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 1158) {
            a(2213, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}});
            return;
        }
        a(2200, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    private void c(o oVar) {
        this.n = new r3();
        a((TimerTask) new a());
        if (!n()) {
            a(new IronSourceError(2303, "loadInterstitialWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new v3());
            d1 a2 = new a.C0015a(aVar.h()).a(h());
            if (a2 == null) {
                IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm invalid enriched adm");
                a(2303, (Object[][]) null);
                a(buildLoadFailedError);
                return;
            }
            String j = a2.j();
            if (j == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(e.a.i, "No available ad to load"));
                return;
            }
            b(j);
            a(aVar.a());
            a(aVar.f());
            a((int) e.c.b, (Object[][]) null);
            this.q.a(a2.b());
            this.o = new r3();
            this.a.loadInterstitialForBidding(this.c, (JSONObject) null, j, this);
        } catch (Exception e) {
            a(ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm: Exception= " + e.getMessage()));
        }
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(e.a.i, "No available ad to load"));
                return;
            }
            a((int) e.c.b, (Object[][]) null);
            this.a.loadInterstitialForBidding(this.c, (JSONObject) null, str, this);
        }
    }

    private i q() {
        i iVar = new i(this.m);
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.b(i() + h());
        iVar.a(l());
        iVar.a(this.t.a(this.m));
        b1 b1Var = new b1(h(), false);
        b1Var.a(this.s.value());
        Map<String, Object> interstitialBiddingData = this.a.getInterstitialBiddingData(this.c, new JSONObject());
        if (interstitialBiddingData != null) {
            b1Var.b(interstitialBiddingData);
        }
        iVar.a(b1Var);
        return iVar;
    }

    private void r() {
        this.o = new r3();
        this.a.loadInterstitial(this.c, (JSONObject) null, this);
    }

    private void s() {
        if (!this.r.a()) {
            IronLog.INTERNAL.verbose("can't load the interstitial the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a((int) e.c.h, (Object[][]) null);
        i q2 = q();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + q2.o());
        a((int) e.c.i, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, q2.o()}});
        this.r.a(ContextProvider.getInstance().getApplicationContext(), q2, (t0) this);
    }

    private void t() {
        this.g = null;
        this.h = null;
        this.j = null;
        this.q = new a1();
    }

    private void u() {
        this.n = new r3();
        a((TimerTask) new b());
        if (n()) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial must be called by non bidder instances");
            a(2303, (Object[][]) null);
            a(buildLoadFailedError);
        } else if (o()) {
            s();
        } else {
            r();
        }
    }

    public void a(int i, String str, int i2, String str2, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error " + i + " - " + str);
        this.g = null;
        this.h = null;
        a((int) e.c.e, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(e.a.j, "No available ad to load"));
        }
    }

    public void a(d.a aVar, int i, long j, int i2, String str) {
        String str2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        this.s = aVar.a(l());
        a.C0015a aVar2 = new a.C0015a(aVar.h());
        if (!aVar2.isEmpty()) {
            d1 d1Var = aVar2.get(0);
            this.q.a(d1Var.b());
            this.q.c(d1Var.g());
            this.q.b(d1Var.f());
            str2 = d1Var.j();
            b(str2);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}});
        }
        a((int) e.c.f, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        a((int) e.c.g, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, aVar2.a()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (aVar2.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(1158, "There is no available ad to load");
                ironLog.error("interstitial - empty waterfall");
                a(ironSourceError);
                return;
            }
            c(str2);
        }
    }

    public void a(o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 == aVar || a2 == aVar2) {
            t();
            a(2002, (Object[][]) null);
            c(oVar);
            return;
        }
        a(new IronSourceError(1050, a2 == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
    }

    /* access modifiers changed from: package-private */
    public void a(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, r3.a(this.n));
            a(this.q.b(), IronSourceUtils.getCurrentMethodName());
            this.p.onInterstitialAdLoadFailed(l(), ironSourceError);
        }
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    public boolean a() {
        boolean z = false;
        if (!a(m.a.LOADED)) {
            return false;
        }
        try {
            z = this.a.isInterstitialReady(this.c);
            a(z ? 2211 : 2212, (Object[][]) null);
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception=" + e.getMessage());
        }
        return z;
    }

    public void b() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + h() + ", state=" + k());
        a(2201, (Object[][]) null);
        m.a aVar = m.a.LOADED;
        m.a aVar2 = m.a.SHOW_IN_PROGRESS;
        if (a(aVar, aVar2)) {
            this.a.showInterstitial(this.c, this);
        } else {
            onInterstitialAdShowFailed(a(aVar2) ? new IronSourceError(1064, "showInterstitial error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1065, "showInterstitial error: can't show ad while an ad is loading") : new IronSourceError(1066, "showInterstitial error: no available ads to show"));
        }
    }

    public void c() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 == aVar || a2 == aVar2) {
            t();
            a(2002, (Object[][]) null);
            u();
            return;
        }
        this.p.onInterstitialAdLoadFailed(l(), new IronSourceError(1050, a2 == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
    }

    public void onInterstitialAdClicked() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(2006, new Object[0][]);
        this.p.onInterstitialAdClicked(l());
    }

    public void onInterstitialAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(2204, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.t.a(this.m))}});
        this.u.b(this.m);
        this.p.onInterstitialAdClosed(l());
    }

    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.getErrorMessage() + " instance name= " + h() + " state=" + k());
        long a2 = r3.a(this.o);
        a((int) e.c.d, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(a2)}});
        a(ironSourceError);
    }

    public void onInterstitialAdOpened() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(2005, new Object[0][]);
        a(this.q.a(), IronSourceUtils.getCurrentMethodName());
        this.p.onInterstitialAdOpened(l());
    }

    public void onInterstitialAdReady() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h() + " state=" + k());
        p();
        a((int) e.c.c, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(2003, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.n))}});
            a(this.q.c(), IronSourceUtils.getCurrentMethodName());
            this.p.onInterstitialAdReady(l());
        }
    }

    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(2203, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.p.onInterstitialAdShowFailed(l(), ironSourceError);
    }

    public void onInterstitialAdShowSucceeded() {
    }

    public void onInterstitialAdVisible() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(2210, new Object[0][]);
    }

    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    public void onInterstitialInitSuccess() {
    }
}
