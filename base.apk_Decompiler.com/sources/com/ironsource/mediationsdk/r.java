package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.g8;
import com.ironsource.h0;
import com.ironsource.m8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.va;
import com.ironsource.w6;
import com.ironsource.w8;
import com.ironsource.y3;
import com.ironsource.z1;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class r extends a0 implements RewardedVideoSmashListener, z1 {
    /* access modifiers changed from: private */
    public b h;
    /* access modifiers changed from: private */
    public m8 i;
    private Timer j;
    private int k;
    private String l;
    private String m;
    private Placement n;
    private long o;
    private String p;
    private JSONObject q;
    private int r;
    private String s;
    private final Object t;
    private final Object u;
    private long v;
    private final w6.a w;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            boolean z;
            int i;
            b a2 = r.this.h;
            b bVar = b.LOAD_IN_PROGRESS;
            String str = "Rewarded Video - load instance time out";
            if (a2 == bVar || r.this.h == b.INIT_IN_PROGRESS) {
                if (r.this.h == bVar) {
                    i = 1025;
                } else {
                    i = IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT;
                    str = "Rewarded Video - init instance time out";
                }
                r.this.a(b.NOT_LOADED);
                z = true;
            } else {
                i = 510;
                z = false;
            }
            r.this.a(str);
            if (z) {
                r.this.a(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r.this.v())}});
                r.this.a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r.this.v())}});
                r.this.i.c(r.this);
                return;
            }
            r.this.a((int) IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r.this.v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, r.this.h.name()}});
        }
    }

    protected enum b {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r(com.ironsource.mediationsdk.r r10, com.ironsource.m8 r11, com.ironsource.mediationsdk.AbstractAdapter r12, int r13, java.lang.String r14, org.json.JSONObject r15, int r16, java.lang.String r17) {
        /*
            r9 = this;
            r8 = r9
            r0 = r10
            java.lang.String r1 = r0.l
            java.lang.String r2 = r0.m
            com.ironsource.h0 r3 = r0.b
            com.ironsource.mediationsdk.model.NetworkSettings r3 = r3.h()
            int r5 = r0.k
            r0 = r9
            r4 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r14
            r8.p = r0
            r0 = r15
            r8.q = r0
            r0 = r16
            r8.r = r0
            r0 = r17
            r8.s = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.r.<init>(com.ironsource.mediationsdk.r, com.ironsource.m8, com.ironsource.mediationsdk.AbstractAdapter, int, java.lang.String, org.json.JSONObject, int, java.lang.String):void");
    }

    public r(String str, String str2, NetworkSettings networkSettings, m8 m8Var, int i2, AbstractAdapter abstractAdapter, int i3) {
        super(new h0(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.t = new Object();
        this.u = new Object();
        this.w = w8.d().a();
        this.l = str;
        this.m = str2;
        this.i = m8Var;
        this.j = null;
        this.k = i2;
        this.f = i3;
        this.h = b.NO_INIT;
        this.v = 0;
        if (r()) {
            t();
        }
    }

    private void C() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.a.setPluginData(pluginType);
            }
        } catch (Throwable th) {
            a("setCustomParams() " + th.getMessage());
        }
    }

    private void D() {
        synchronized (this.u) {
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), (long) (this.k * 1000));
        }
    }

    private void E() {
        synchronized (this.u) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }
    }

    private void a(int i2, Object[][] objArr, boolean z) {
        Placement placement;
        Map<String, Object> m2 = m();
        if (!TextUtils.isEmpty(this.p)) {
            m2.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            m2.put("genericParams", this.q);
        }
        if (z && (placement = this.n) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            m2.put("placement", this.n.getPlacementName());
        }
        if (c(i2)) {
            va.i().a(m2, this.r, this.s);
        }
        m2.put("sessionDepth", Integer.valueOf(this.f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, c() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        va.i().a(new y3(i2, new JSONObject(m2)));
        if (i2 == 1203) {
            this.w.b(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        a("current state=" + this.h + ", new state=" + bVar);
        synchronized (this.t) {
            this.h = bVar;
        }
    }

    private void b(int i2) {
        b(i2, (Object[][]) null);
    }

    private boolean c(int i2) {
        return i2 == 1001 || i2 == 1002 || i2 == 1200 || i2 == 1212 || i2 == 1213 || i2 == 1005 || i2 == 1203 || i2 == 1201 || i2 == 1202 || i2 == 1006 || i2 == 1010;
    }

    private void t() {
        a("isBidder = " + p() + ", shouldEarlyInit = " + s());
        a(b.INIT_IN_PROGRESS);
        C();
        try {
            this.a.initRewardedVideoWithCallback(this.l, this.m, this.d, this);
        } catch (Throwable th) {
            b("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* access modifiers changed from: private */
    public long v() {
        return new Date().getTime() - this.o;
    }

    public boolean A() {
        if (this.h != b.LOADED) {
            return false;
        }
        try {
            return this.a.isRewardedVideoAvailable(this.d);
        } catch (Throwable th) {
            b("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_isReadyException)}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public void B() {
        a((int) IronSourceConstants.RV_CAP_SESSION);
    }

    public Map<String, Object> a(AdData adData) {
        JSONObject a2 = adData != null ? g8.a(adData.getAdUnitData()) : null;
        if (p()) {
            return this.a.getRewardedVideoBiddingData(this.d, a2);
        }
        return null;
    }

    public void a(int i2) {
        a(i2, (Object[][]) null, false);
    }

    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, false);
    }

    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        a(1020);
        try {
            this.a.collectRewardedVideoBiddingData(this.d, adData != null ? g8.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            b("collectBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    public void a(Placement placement) {
        E();
        a("showVideo()");
        this.n = placement;
        a(b.SHOW_IN_PROGRESS);
        b(1201);
        try {
            this.a.showRewardedVideo(this.d, this);
        } catch (Throwable th) {
            b("showVideo exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        b bVar;
        b bVar2;
        a("loadVideo() auctionId: " + this.p + " state: " + this.h);
        this.g = null;
        a(false);
        synchronized (this.t) {
            bVar = this.h;
            bVar2 = b.LOAD_IN_PROGRESS;
            if (!(bVar == bVar2 || bVar == b.SHOW_IN_PROGRESS)) {
                a(bVar2);
            }
        }
        if (bVar == bVar2) {
            a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_loadInProgress)}, new Object[]{"reason", "load during load"}});
        } else if (bVar == b.SHOW_IN_PROGRESS) {
            a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_showInProgress)}, new Object[]{"reason", "load during show"}});
        } else {
            D();
            this.o = new Date().getTime();
            a(1001);
            try {
                if (p()) {
                    this.a.loadRewardedVideoForBidding(this.d, jSONObject, str, this);
                    return;
                }
                C();
                this.a.initAndLoadRewardedVideo(this.l, this.m, this.d, jSONObject, this);
            } catch (Throwable th) {
                b("loadVideo exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                a((int) IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(p() ? IronSourceConstants.errorCode_loadException : IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    public void b(int i2, Object[][] objArr) {
        a(i2, objArr, true);
    }

    public void b(boolean z) {
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z ? "true" : "false";
        objArr[0] = objArr2;
        b(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr);
    }

    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    public String k() {
        return "LWSProgRvSmash";
    }

    public int l() {
        return 2;
    }

    public void onRewardedVideoAdClicked() {
        a("onRewardedVideoAdClicked");
        this.i.b(this, this.n);
        b(1006);
    }

    public void onRewardedVideoAdClosed() {
        a("onRewardedVideoAdClosed");
        synchronized (this.t) {
            if (this.h != b.SHOW_IN_PROGRESS) {
                b(1203);
                Object[] objArr = {"errorCode", Integer.valueOf(IronSourceConstants.errorCode_adClosed)};
                a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{"reason", "adClosed: " + this.h}});
                return;
            }
            a(b.ENDED);
            this.v = new Date().getTime();
            this.i.b(this);
        }
    }

    public void onRewardedVideoAdEnded() {
        a("onRewardedVideoAdEnded");
        this.i.f(this);
        b((int) IronSourceConstants.RV_INSTANCE_ENDED);
    }

    public void onRewardedVideoAdOpened() {
        a("onRewardedVideoAdOpened");
        this.i.d(this);
        b(1005);
    }

    public void onRewardedVideoAdRewarded() {
        a("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.i.a(this, this.n);
        Map<String, Object> m2 = m();
        Placement placement = this.n;
        if (placement != null) {
            m2.put("placement", placement.getPlacementName());
            m2.put(IronSourceConstants.EVENTS_REWARD_NAME, this.n.getRewardName());
            m2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.n.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(p.o().n())) {
            m2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, p.o().n());
        }
        if (p.o().s() != null) {
            for (String next : p.o().s().keySet()) {
                m2.put("custom_" + next, p.o().s().get(next));
            }
        }
        if (!TextUtils.isEmpty(this.p)) {
            m2.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            m2.put("genericParams", this.q);
        }
        if (c(1010)) {
            va.i().a(m2, this.r, this.s);
        }
        m2.put("sessionDepth", Integer.valueOf(this.f));
        y3 y3Var = new y3(1010, new JSONObject(m2));
        y3Var.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(y3Var.d(), c()));
        long j2 = this.v;
        if (j2 != 0) {
            long j3 = time - j2;
            a("onRewardedVideoAdRewarded timeAfterClosed=" + j3);
            y3Var.a(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j3));
        }
        va.i().a(y3Var);
    }

    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        b(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        synchronized (this.t) {
            if (this.h != b.SHOW_IN_PROGRESS) {
                Object[] objArr = {"errorCode", Integer.valueOf(IronSourceConstants.errorCode_showFailed)};
                a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{"reason", "showFailed: " + this.h}});
                return;
            }
            a(b.ENDED);
            this.i.a(ironSourceError, this);
        }
    }

    public void onRewardedVideoAdStarted() {
        a("onRewardedVideoAdStarted");
        this.i.a(this);
        b((int) IronSourceConstants.RV_INSTANCE_STARTED);
    }

    public void onRewardedVideoAdVisible() {
        a("onRewardedVideoAdVisible");
        b(1206);
    }

    public void onRewardedVideoAvailabilityChanged(boolean z) {
        boolean z2;
        a("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.h.name());
        synchronized (this.t) {
            if (this.h == b.LOAD_IN_PROGRESS) {
                a(z ? b.LOADED : b.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            E();
            a(z ? 1002 : 1200, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}});
            if (z) {
                this.i.e(this);
            } else {
                this.i.c(this);
            }
        } else if (z) {
            a((int) IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
        } else {
            a((int) IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
        }
    }

    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        E();
        a(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}});
        a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}});
        synchronized (this.t) {
            if (this.h != b.INIT_IN_PROGRESS) {
                Object[] objArr = {"errorCode", Integer.valueOf(IronSourceConstants.errorCode_initFailed)};
                a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{"reason", "initFailed: " + this.h}});
                return;
            }
            a(b.NO_INIT);
            this.i.c(this);
        }
    }

    public void onRewardedVideoInitSuccess() {
        a("onRewardedVideoInitSuccess");
        synchronized (this.t) {
            if (this.h != b.INIT_IN_PROGRESS) {
                Object[] objArr = {"errorCode", Integer.valueOf(IronSourceConstants.errorCode_initSuccess)};
                a((int) IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{"reason", "initSuccess: " + this.h}});
                return;
            }
            a(b.NOT_LOADED);
        }
    }

    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(1213, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.g = Long.valueOf(System.currentTimeMillis());
        }
        a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(v())}});
    }

    public void onRewardedVideoLoadSuccess() {
    }

    public String u() {
        return this.p;
    }

    public LoadWhileShowSupportState w() {
        try {
            return this.a.getLoadWhileShowSupportState(this.d);
        } catch (Throwable th) {
            b("Exception while calling adapter.getLoadWhileShowSupportState() - " + th.getLocalizedMessage());
            return LoadWhileShowSupportState.NONE;
        }
    }

    public Placement x() {
        return this.n;
    }

    public boolean y() {
        return this.h == b.LOADED;
    }

    public boolean z() {
        b bVar = this.h;
        return bVar == b.INIT_IN_PROGRESS || bVar == b.LOAD_IN_PROGRESS;
    }
}
