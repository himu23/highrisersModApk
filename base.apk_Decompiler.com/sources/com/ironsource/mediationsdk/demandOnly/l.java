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
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.i;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.r3;
import com.ironsource.t0;
import com.ironsource.v3;
import com.ironsource.va;
import com.ironsource.w6;
import com.ironsource.w8;
import com.ironsource.y0;
import com.ironsource.y3;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public class l extends m implements n.b, RewardedVideoSmashListener, y0 {
    private r3 n;
    private r3 o;
    private ISDemandOnlyRewardedVideoListener p;
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
            ironLog.verbose("load timed out state=" + l.this.k());
            l.this.a(new IronSourceError(1055, "load timed out"));
        }
    }

    l(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener, long j, AbstractAdapter abstractAdapter, e eVar) {
        super(new h0(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.p = iSDemandOnlyRewardedVideoListener;
        this.f = j;
        this.r = eVar;
        this.a.initRewardedVideoForDemandOnly(str, str2, this.c, this);
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
        va.i().a(new y3(i, new JSONObject(j)));
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(1213, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}});
            return;
        }
        a(1200, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    private void c(o oVar) {
        this.n = new r3();
        a(s());
        if (!n()) {
            a(new IronSourceError(j.a.k, "loadRewardedVideoWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new v3());
            d1 a2 = new a.C0015a(aVar.h()).a(h());
            if (a2 == null) {
                IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm invalid enriched adm");
                a((int) j.a.k, (Object[][]) null);
                a(buildLoadFailedError);
                return;
            }
            String j = a2.j();
            if (j == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
                return;
            }
            b(j);
            a(aVar.a());
            a(aVar.f());
            a((int) j.c.b, (Object[][]) null);
            this.q.a(a2.b());
            this.o = new r3();
            this.a.loadRewardedVideoForBidding(this.c, (JSONObject) null, j, this);
        } catch (Exception e) {
            a(ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm: Exception= " + e.getMessage()));
        }
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
                return;
            }
            a((int) j.c.b, (Object[][]) null);
            this.a.loadRewardedVideoForBidding(this.c, (JSONObject) null, str, this);
        }
    }

    private IronSourceError q() {
        return a(m.a.SHOW_IN_PROGRESS) ? new IronSourceError(1067, "showRewardedVideo error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1068, "showRewardedVideo error: can't show ad while an ad is loading") : new IronSourceError(1069, "showRewardedVideo error: no available ads to show");
    }

    private i r() {
        i iVar = new i(this.m);
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.b(i() + h());
        iVar.a(l());
        iVar.a(this.t.a(this.m));
        b1 b1Var = new b1(h(), false);
        b1Var.a(this.s.value());
        Map<String, Object> rewardedVideoBiddingData = this.a.getRewardedVideoBiddingData(this.c, new JSONObject());
        if (rewardedVideoBiddingData != null) {
            b1Var.b(rewardedVideoBiddingData);
        }
        iVar.a(b1Var);
        return iVar;
    }

    private TimerTask s() {
        return new a();
    }

    private void t() {
        this.o = new r3();
        this.a.loadRewardedVideo(this.c, (JSONObject) null, this);
    }

    private void u() {
        if (!this.r.a()) {
            IronLog.INTERNAL.verbose("can't load the rewarded video the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a((int) j.c.h, (Object[][]) null);
        i r2 = r();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + r2.o());
        a((int) j.c.i, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, r2.o()}});
        this.r.a(ContextProvider.getInstance().getApplicationContext(), r2, (t0) this);
    }

    private void v() {
        this.g = null;
        this.h = null;
        this.j = null;
        this.q = new a1();
    }

    private void w() {
        this.n = new r3();
        a(s());
        if (n()) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo must be called by non bidder instances");
            a((int) j.a.k, (Object[][]) null);
            a(buildLoadFailedError);
        } else if (o()) {
            u();
        } else {
            t();
        }
    }

    public void a(int i, String str, int i2, String str2, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("Auction failed. error " + i + " - " + str);
        this.g = null;
        this.h = null;
        a((int) j.c.e, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(j.a.j, "No available ad to load"));
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
        a((int) j.c.f, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        a((int) j.c.g, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, aVar2.a()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (aVar2.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(1058, "There is no available ad to load");
                ironLog.error("rewardedVideo - empty waterfall");
                a(ironSourceError);
                return;
            }
            c(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, r3.a(this.n));
            a(this.q.b(), IronSourceUtils.getCurrentMethodName());
            this.p.onRewardedVideoAdLoadFailed(l(), ironSourceError);
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
            z = this.a.isRewardedVideoAvailable(this.c);
            a(z ? 1210 : 1211, (Object[][]) null);
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception=" + e.getMessage());
        }
        return z;
    }

    public void b(o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 == aVar || a2 == aVar2) {
            v();
            a(1001, (Object[][]) null);
            c(oVar);
            return;
        }
        a(new IronSourceError(1053, a2 == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
    }

    public void d() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 == aVar || a2 == aVar2) {
            v();
            a(1001, (Object[][]) null);
            w();
            return;
        }
        this.p.onRewardedVideoAdLoadFailed(l(), new IronSourceError(1053, a2 == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
    }

    public void e() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + h() + ", state=" + k());
        a(1201, (Object[][]) null);
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            this.a.showRewardedVideo(this.c, this);
        } else {
            onRewardedVideoAdShowFailed(q());
        }
    }

    public void onRewardedVideoAdClicked() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(1006, new Object[0][]);
        this.p.onRewardedVideoAdClicked(l());
    }

    public void onRewardedVideoAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(1203, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.t.a(this.m))}});
        this.u.b(this.m);
        this.p.onRewardedVideoAdClosed(l());
    }

    public void onRewardedVideoAdEnded() {
    }

    public void onRewardedVideoAdOpened() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(1005, new Object[0][]);
        a(this.q.a(), IronSourceUtils.getCurrentMethodName());
        this.p.onRewardedVideoAdOpened(l());
    }

    public void onRewardedVideoAdRewarded() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        Map<String, Object> j = j();
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.p.o().n())) {
            j.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, com.ironsource.mediationsdk.p.o().n());
        }
        if (com.ironsource.mediationsdk.p.o().s() != null) {
            for (String next : com.ironsource.mediationsdk.p.o().s().keySet()) {
                j.put("custom_" + next, com.ironsource.mediationsdk.p.o().s().get(next));
            }
        }
        Placement a2 = com.ironsource.mediationsdk.p.o().k().b().g().a();
        if (a2 != null) {
            j.put("placement", a2.getPlacementName());
            j.put(IronSourceConstants.EVENTS_REWARD_NAME, a2.getRewardName());
            j.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(a2.getRewardAmount()));
        } else {
            IronLog.INTERNAL.error("defaultPlacement is null");
        }
        y3 y3Var = new y3(1010, new JSONObject(j));
        y3Var.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(y3Var.d(), h()));
        va.i().a(y3Var);
        this.p.onRewardedVideoAdRewarded(l());
    }

    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.p.onRewardedVideoAdShowFailed(l(), ironSourceError);
    }

    public void onRewardedVideoAdStarted() {
    }

    public void onRewardedVideoAdVisible() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h());
        a(1206, new Object[0][]);
    }

    public void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    public void onRewardedVideoInitSuccess() {
    }

    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.getErrorMessage() + "instance name= " + h() + " state=" + k());
        long a2 = r3.a(this.o);
        a((int) j.c.d, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(a2)}});
        a(ironSourceError);
    }

    public void onRewardedVideoLoadSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + h() + " state=" + k());
        p();
        a((int) j.c.c, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(1002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.n))}});
            a(this.q.c(), IronSourceUtils.getCurrentMethodName());
            this.p.onRewardedVideoAdLoadSuccess(l());
        }
    }
}
