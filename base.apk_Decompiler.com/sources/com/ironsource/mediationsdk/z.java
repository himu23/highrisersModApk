package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.g8;
import com.ironsource.h0;
import com.ironsource.la;
import com.ironsource.m2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.n7;
import com.ironsource.y3;
import com.ironsource.z1;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class z extends a0 implements InterstitialSmashListener, z1 {
    /* access modifiers changed from: private */
    public b h = b.NO_INIT;
    /* access modifiers changed from: private */
    public la i;
    private Timer j;
    private int k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public long n;
    private JSONObject o;
    private final Object p = new Object();
    private boolean q;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            z zVar = z.this;
            zVar.a("timed out state=" + z.this.h.name() + " isBidder=" + z.this.p());
            if (z.this.h != b.INIT_IN_PROGRESS || !z.this.p()) {
                z.this.a(b.LOAD_FAILED);
                z.this.i.a(ErrorBuilder.buildLoadFailedError("timed out"), z.this, new Date().getTime() - z.this.n);
                return;
            }
            z.this.a(b.NO_INIT);
        }
    }

    protected enum b {
        NO_INIT,
        INIT_IN_PROGRESS,
        INIT_SUCCESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED
    }

    public z(String str, String str2, NetworkSettings networkSettings, la laVar, int i2, AbstractAdapter abstractAdapter) {
        super(new h0(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.l = str;
        this.m = str2;
        this.i = laVar;
        this.j = null;
        this.k = i2;
        this.o = null;
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        a("current state=" + this.h + ", new state=" + bVar);
        this.h = bVar;
    }

    private void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgIsSmash " + c() + " : " + str, 0);
    }

    private void w() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.a.setPluginData(pluginType);
            }
        } catch (Throwable th) {
            a("setCustomParams() " + th.getMessage());
        }
    }

    private void y() {
        synchronized (this.p) {
            a("start timer");
            z();
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), (long) (this.k * 1000));
        }
    }

    private void z() {
        synchronized (this.p) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }
    }

    public Map<String, Object> a(AdData adData) {
        JSONObject a2 = adData != null ? g8.a(adData.getAdUnitData()) : null;
        if (p()) {
            return this.a.getInterstitialBiddingData(this.d, a2);
        }
        return null;
    }

    public void a(int i2, Object[][] objArr) {
        Map<String, Object> m2 = m();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                b("IS sendProviderEvent " + e.getMessage());
            }
        }
        n7.i().a(new y3(i2, new JSONObject(m2)));
    }

    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObject = null;
        a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN, (Object[][]) null);
        if (adData != null) {
            jSONObject = g8.a(adData.getAdUnitData());
        }
        try {
            this.a.collectInterstitialBiddingData(this.d, jSONObject, biddingDataCallback);
        } catch (Throwable th) {
            b("collectBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.n = new Date().getTime();
            this.o = jSONObject;
            a(m2.g.K);
            a(false);
            if (p()) {
                y();
                a(b.LOAD_IN_PROGRESS);
                this.a.loadInterstitialForBidding(this.d, jSONObject, str, this);
            } else if (this.h == b.NO_INIT) {
                y();
                a(b.INIT_IN_PROGRESS);
                w();
                this.a.initInterstitial(this.l, this.m, this.d, this);
            } else {
                y();
                a(b.LOAD_IN_PROGRESS);
                this.a.loadInterstitial(this.d, jSONObject, this);
            }
        } catch (Throwable th) {
            b("loadInterstitial exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onInterstitialAdLoadFailed(new IronSourceError(IronSourceConstants.errorCode_loadException, th.getLocalizedMessage()));
        }
    }

    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.INTERSTITIAL;
    }

    public String k() {
        return "ProgIsSmash";
    }

    public void onInterstitialAdClicked() {
        d("onInterstitialAdClicked");
        this.i.d(this);
    }

    public void onInterstitialAdClosed() {
        d("onInterstitialAdClosed");
        this.i.c(this);
    }

    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        d("onInterstitialAdLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + this.h.name());
        z();
        if (this.h == b.LOAD_IN_PROGRESS) {
            a(b.LOAD_FAILED);
            this.i.a(ironSourceError, this, new Date().getTime() - this.n);
        }
    }

    public void onInterstitialAdOpened() {
        d("onInterstitialAdOpened");
        this.i.a(this);
    }

    public void onInterstitialAdReady() {
        d("onInterstitialAdReady state=" + this.h.name());
        z();
        if (this.h == b.LOAD_IN_PROGRESS) {
            a(b.LOADED);
            this.i.a(this, new Date().getTime() - this.n);
        }
    }

    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        d("onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.i.b(ironSourceError, this);
    }

    public void onInterstitialAdShowSucceeded() {
        d("onInterstitialAdShowSucceeded");
        this.i.f(this);
    }

    public void onInterstitialAdVisible() {
        d("onInterstitialAdVisible");
        this.i.e(this);
    }

    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
        d("onInterstitialInitFailed error" + ironSourceError.getErrorMessage() + " state=" + this.h.name());
        if (this.h == b.INIT_IN_PROGRESS) {
            z();
            a(b.NO_INIT);
            this.i.a(ironSourceError, this);
            if (!p()) {
                this.i.a(ironSourceError, this, new Date().getTime() - this.n);
            }
        }
    }

    public void onInterstitialInitSuccess() {
        d("onInterstitialInitSuccess state=" + this.h.name());
        if (this.h == b.INIT_IN_PROGRESS) {
            z();
            if (p() || this.q) {
                this.q = false;
                a(b.INIT_SUCCESS);
            } else {
                a(b.LOAD_IN_PROGRESS);
                y();
                try {
                    this.a.loadInterstitial(this.d, this.o, this);
                } catch (Throwable th) {
                    b("onInterstitialInitSuccess exception: " + th.getLocalizedMessage());
                    th.printStackTrace();
                    onInterstitialAdLoadFailed(new IronSourceError(IronSourceConstants.errorCode_loadException, th.getLocalizedMessage()));
                }
            }
            this.i.b(this);
        }
    }

    public void t() {
        a("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.q = true;
        a(b.INIT_IN_PROGRESS);
        w();
        try {
            if (p()) {
                this.a.initInterstitialForBidding(this.l, this.m, this.d, this);
            } else {
                this.a.initInterstitial(this.l, this.m, this.d, this);
            }
        } catch (Throwable th) {
            b(c() + " initForBidding exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            onInterstitialInitFailed(new IronSourceError(IronSourceError.ERROR_IS_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public boolean u() {
        b bVar = this.h;
        return bVar == b.INIT_IN_PROGRESS || bVar == b.LOAD_IN_PROGRESS;
    }

    public boolean v() {
        if (this.h != b.LOADED) {
            return false;
        }
        try {
            return this.a.isInterstitialReady(this.d);
        } catch (Throwable th) {
            b("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_IS_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_isReadyException)}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public void x() {
        try {
            this.a.showInterstitial(this.d, this);
        } catch (Throwable th) {
            b(c() + "showInterstitial exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_IS_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }
}
