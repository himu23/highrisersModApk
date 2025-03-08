package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.g8;
import com.ironsource.h0;
import com.ironsource.ka;
import com.ironsource.m1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.n7;
import com.ironsource.nb;
import com.ironsource.r3;
import com.ironsource.y3;
import com.ironsource.z1;
import java.util.Map;
import org.json.JSONObject;

public class x extends a0 implements BannerSmashListener, nb.a, z1 {
    private k h;
    private nb i;
    private a j;
    private ka k;
    private IronSourceBannerLayout l;
    private String m;
    private JSONObject n;
    private int o;
    private String p;
    private m1 q;
    private final Object r;
    private r3 s;
    private boolean t;
    private boolean u;
    private JSONObject v;

    protected enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    x(k kVar, ka kaVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, String str, JSONObject jSONObject, int i3, String str2, boolean z) {
        super(new h0(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.r = new Object();
        this.j = a.NONE;
        this.h = kVar;
        this.i = new nb(kVar.e());
        this.k = kaVar;
        this.f = i2;
        this.m = str;
        this.o = i3;
        this.p = str2;
        this.n = jSONObject;
        this.t = z;
        this.v = null;
        if (r()) {
            u();
        }
    }

    x(k kVar, ka kaVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, boolean z) {
        this(kVar, kaVar, networkSettings, abstractAdapter, i2, "", (JSONObject) null, 0, "", z);
    }

    private void A() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        D();
        try {
            if (this.a == null) {
                return;
            }
            if (p()) {
                this.a.initBannerForBidding(this.h.a(), this.h.j(), this.d, this);
            } else {
                this.a.initBanners(this.h.a(), this.h.j(), this.d, this);
            }
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to init banner from " + this.a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            onBannerInitFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean B() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.DESTROYED;
        }
        return z;
    }

    private boolean C() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.LOADED;
        }
        return z;
    }

    private void D() {
        if (this.a != null) {
            try {
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    this.a.setPluginData(pluginType);
                }
            } catch (Throwable th) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("Exception while trying to set custom params from " + this.a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                th.printStackTrace();
                a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    private void a(IronSourceError ironSourceError) {
        boolean z = ironSourceError.getErrorCode() == 606;
        boolean z2 = this.t;
        if (z) {
            a(z2 ? IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL : 3306, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.s))}});
        } else {
            a(z2 ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : 3300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.s))}});
        }
        ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.a(ironSourceError, this, z);
        }
    }

    private void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "state = " + aVar.name());
        synchronized (this.r) {
            this.j = aVar;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (a(a.READY_TO_LOAD, a.LOADING)) {
            this.s = new r3();
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD : 3002);
            if (this.a != null) {
                try {
                    if (p()) {
                        this.a.loadBannerForBidding(this.d, this.v, str, this.l, this);
                    } else {
                        this.a.loadBanner(this.d, this.v, this.l, this);
                    }
                } catch (Throwable th) {
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.error("Exception while trying to load banner from " + this.a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                    th.printStackTrace();
                    onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, th.getLocalizedMessage()));
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{"reason", th.getLocalizedMessage()}});
                }
            }
        } else {
            ironLog.error("wrong state - state = " + this.j);
        }
    }

    private boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.r) {
            if (this.j == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(y() + "set state from '" + this.j + "' to '" + aVar2 + "'");
                this.j = aVar2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private boolean b(int i2) {
        return i2 == 3005 || i2 == 3002 || i2 == 3012 || i2 == 3015 || i2 == 3008 || i2 == 3305 || i2 == 3300 || i2 == 3306 || i2 == 3307 || i2 == 3302 || i2 == 3303 || i2 == 3304 || i2 == 3009;
    }

    private void u() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.u = true;
        A();
    }

    public Map<String, Object> a(AdData adData) {
        AbstractAdapter abstractAdapter;
        JSONObject a2 = adData != null ? g8.a(adData.getAdUnitData()) : null;
        if (!p() || (abstractAdapter = this.a) == null) {
            return null;
        }
        return abstractAdapter.getBannerBiddingData(this.d, a2);
    }

    public void a() {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a aVar = a.INIT_IN_PROGRESS;
        a aVar2 = a.LOAD_FAILED;
        if (a(aVar, aVar2)) {
            ironLog.verbose("init timed out");
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, "Timed out");
        } else if (a(a.LOADING, aVar2)) {
            ironLog.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        } else {
            ironLog.error("unexpected state - " + this.j);
            return;
        }
        a(ironSourceError);
    }

    public void a(int i2) {
        a(i2, (Object[][]) null);
    }

    public void a(int i2, Object[][] objArr) {
        Map<String, Object> m2 = m();
        if (B()) {
            m2.put("reason", "banner is destroyed");
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = this.l;
            if (ironSourceBannerLayout != null) {
                l.a(m2, ironSourceBannerLayout.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.m)) {
            m2.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            m2.put("genericParams", this.n);
        }
        m1 m1Var = this.q;
        if (m1Var != null) {
            m2.put("placement", m1Var.getPlacementName());
        }
        if (b(i2)) {
            n7.i().a(m2, this.o, this.p);
        }
        m2.put("sessionDepth", Integer.valueOf(this.f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(c() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        n7.i().a(new y3(i2, new JSONObject(m2)));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, m1 m1Var, String str, JSONObject jSONObject) {
        ka kaVar;
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        this.q = m1Var;
        this.v = jSONObject;
        if (!l.b(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            kaVar = this.k;
            ironSourceError = new IronSourceError(610, str2);
        } else if (this.a == null) {
            ironLog.verbose("mAdapter is null");
            kaVar = this.k;
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, "mAdapter is null");
        } else {
            this.l = ironSourceBannerLayout;
            this.i.a(this);
            try {
                if (p()) {
                    a(str, this.v);
                    return;
                } else {
                    A();
                    return;
                }
            } catch (Throwable th) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.error("exception = " + th.getLocalizedMessage());
                th.printStackTrace();
                onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, th.getLocalizedMessage()));
                return;
            }
        }
        kaVar.a(ironSourceError, this, false);
    }

    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN);
        try {
            this.a.collectBannerBiddingData(this.d, adData != null ? g8.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to collectBannerBiddingData from " + this.a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.BANNER;
    }

    public String k() {
        return "ProgBannerSmash";
    }

    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(f());
        a(3008);
        ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.b(this);
        }
    }

    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(f());
        a(3304);
        ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.c(this);
        }
    }

    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (a(a.LOADING, a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(f());
        this.i.e();
        if (a(a.LOADING, a.LOADED)) {
            a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : 3005, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.s))}});
            ka kaVar = this.k;
            if (kaVar != null) {
                kaVar.a(this, view, layoutParams);
                return;
            }
            return;
        }
        a(this.t ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
    }

    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(f());
        a((int) IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN);
        ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.e(this);
        }
    }

    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(f());
        a((int) IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN);
        ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.d(this);
        }
    }

    public void onBannerAdShown() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (C()) {
            a(3009);
            ka kaVar = this.k;
            if (kaVar != null) {
                kaVar.a(this);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.j);
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, c()}});
    }

    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (a(a.INIT_IN_PROGRESS, a.NONE)) {
            ka kaVar = this.k;
            if (kaVar != null) {
                kaVar.a(ironSourceError, this, false);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.j);
    }

    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(f());
        if (!a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            return;
        }
        if (this.u) {
            this.u = false;
        } else if (p()) {
        } else {
            if (!l.b(this.l)) {
                this.k.a(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, this.l == null ? "banner is null" : "banner is destroyed"), this, false);
            } else {
                a((String) null, this.v);
            }
        }
    }

    public void q() {
        this.i.d();
        super.q();
    }

    public void t() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a(3305);
        a(a.DESTROYED);
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            abstractAdapter.destroyBanner(this.b.h().getBannerSettings());
        } catch (Throwable th) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("Exception while trying to destroy banner from " + this.a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    public String v() {
        return !TextUtils.isEmpty(this.b.h().getAdSourceNameForEvents()) ? this.b.h().getAdSourceNameForEvents() : i();
    }

    public AbstractAdapter w() {
        return this.a;
    }

    public String x() {
        return this.m;
    }

    public String y() {
        return String.format("%s - ", new Object[]{f()});
    }

    public String z() {
        return this.b.i();
    }
}
