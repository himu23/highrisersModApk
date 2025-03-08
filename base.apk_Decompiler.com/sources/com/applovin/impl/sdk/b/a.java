package com.applovin.impl.sdk.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.ac;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class a {
    /* access modifiers changed from: private */
    public AppLovinAd aIN;
    private SoftReference<AppLovinAdLoadListener> aIO;
    private final Object aIP = new Object();
    private volatile String aIQ;
    /* access modifiers changed from: private */
    public volatile boolean aIR = false;
    protected final AppLovinAdServiceImpl age;
    public final Map<String, Object> agg = Collections.synchronizedMap(new HashMap());
    private String agi;
    protected final n sdk;

    public boolean Js() {
        return this.aIN != null;
    }

    public String getZoneId() {
        return this.agi;
    }

    public a(String str, AppLovinSdk appLovinSdk) {
        this.sdk = appLovinSdk.a();
        this.age = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.agi = str;
    }

    public void preload(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.aIO = new SoftReference<>(appLovinAdLoadListener);
        if (Js()) {
            x.H("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.aIN);
                return;
            }
            return;
        }
        b((AppLovinAdLoadListener) new C0081a(appLovinAdLoadListener));
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = Jv();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void show(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        a(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? Jv() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    private void Jt() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.aIO;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    private void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.age.loadNextIncentivizedAd(this.agi, appLovinAdLoadListener);
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.aIN;
        }
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        if (appLovinAdImpl2 != null) {
            a(appLovinAdImpl2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        x.H("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        Jt();
    }

    private void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.aIN;
        }
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        x.H("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        Jt();
    }

    private void a(e eVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.sdk.BO().a((d) new ac(eVar, appLovinAdRewardListener, this.sdk), q.b.REWARD);
    }

    /* access modifiers changed from: private */
    public String Ju() {
        String str;
        synchronized (this.aIP) {
            str = this.aIQ;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public void dm(String str) {
        synchronized (this.aIP) {
            this.aIQ = str;
        }
    }

    public void setExtraInfo(String str, Object obj) {
        this.agg.put(str, obj);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        b bVar = new b(appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        AppLovinAd a = u.a((AppLovinAd) appLovinAdImpl, this.sdk);
        String a2 = a(a, (AppLovinAd) appLovinAdImpl);
        if (StringUtils.isValidString(a2)) {
            a(appLovinAdImpl, a2, bVar, bVar);
            return;
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.sdk.getWrappingSdk(), context);
        for (String next : this.agg.keySet()) {
            create.setExtraInfo(next, this.agg.get(next));
        }
        create.setAdDisplayListener(bVar);
        create.setAdVideoPlaybackListener(bVar);
        create.setAdClickListener(bVar);
        create.showAndRender(a);
        a((e) a, (AppLovinAdRewardListener) bVar);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        b bVar = new b(appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        AppLovinAd a = u.a((AppLovinAd) appLovinAdImpl, this.sdk);
        String a2 = a(a, (AppLovinAd) appLovinAdImpl);
        if (StringUtils.isValidString(a2)) {
            a(appLovinAdImpl, a2, bVar, bVar);
            return;
        }
        Context context2 = context;
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.sdk.getWrappingSdk(), context);
        for (String next : this.agg.keySet()) {
            create.setExtraInfo(next, this.agg.get(next));
        }
        create.setAdDisplayListener(bVar);
        create.setAdVideoPlaybackListener(bVar);
        create.setAdClickListener(bVar);
        ViewGroup viewGroup2 = viewGroup;
        Lifecycle lifecycle2 = lifecycle;
        create.showAndRender(a, viewGroup, lifecycle);
        a((e) a, (AppLovinAdRewardListener) bVar);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2) {
        if (appLovinAd == null) {
            x.H("IncentivizedAdController", "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.: " + appLovinAd2);
            return "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.";
        } else if (appLovinAd2.getType() == AppLovinAdType.INCENTIVIZED || appLovinAd2.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return null;
        } else {
            x.H("IncentivizedAdController", "Attempting to display ad with invalid ad type: " + appLovinAd2.getType());
            return "Attempting to display ad with invalid ad type";
        }
    }

    private void a(AppLovinAd appLovinAd, String str, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, h hVar) {
        this.sdk.BR().a(f.aTd);
        m.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        m.a((AppLovinAdDisplayListener) hVar, str);
    }

    private class b implements h, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
        private final AppLovinAd aIU;
        private final AppLovinAdDisplayListener aIV;
        private final AppLovinAdClickListener aIW;
        private final AppLovinAdVideoPlaybackListener aIX;
        private final AppLovinAdRewardListener aIY;

        private b(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.aIU = appLovinAd;
            this.aIV = appLovinAdDisplayListener;
            this.aIW = appLovinAdClickListener;
            this.aIX = appLovinAdVideoPlaybackListener;
            this.aIY = appLovinAdRewardListener;
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            m.a(this.aIV, appLovinAd);
        }

        public void onAdDisplayFailed(String str) {
            String str2;
            AppLovinAd appLovinAd = this.aIU;
            if (appLovinAd instanceof com.applovin.impl.sdk.ad.f) {
                appLovinAd = ((com.applovin.impl.sdk.ad.f) appLovinAd).HB();
            }
            boolean z = this.aIV instanceof h;
            if (appLovinAd instanceof e) {
                f((e) appLovinAd);
            } else {
                if (appLovinAd == null) {
                    str2 = "null/expired ad";
                } else {
                    str2 = "invalid ad of type: " + appLovinAd;
                }
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    StringBuilder sb = new StringBuilder("Received `");
                    sb.append(z ? "adDisplayFailed" : "adHidden");
                    sb.append("` callback for ");
                    sb.append(str2);
                    BN.i("IncentivizedAdController", sb.toString());
                }
            }
            a.this.f(appLovinAd);
            if (z) {
                m.a(this.aIV, str);
            } else {
                m.b(this.aIV, this.aIU);
            }
        }

        public void adHidden(AppLovinAd appLovinAd) {
            String str;
            AppLovinAd HB = appLovinAd instanceof com.applovin.impl.sdk.ad.f ? ((com.applovin.impl.sdk.ad.f) appLovinAd).HB() : appLovinAd;
            if (HB instanceof e) {
                f((e) HB);
            } else {
                if (HB == null) {
                    str = "null/expired ad";
                } else {
                    str = "invalid ad of type: " + HB;
                }
                a.this.sdk.BN();
                if (x.Fn()) {
                    a.this.sdk.BN().i("IncentivizedAdController", "Received `adHidden` callback for " + str);
                }
            }
            a.this.f(HB);
            a.this.sdk.BN();
            if (x.Fn()) {
                a.this.sdk.BN().f("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            m.b(this.aIV, appLovinAd);
        }

        private void f(e eVar) {
            int i;
            String str;
            a.this.sdk.BN();
            if (x.Fn()) {
                a.this.sdk.BN().f("IncentivizedAdController", "Finishing direct ad...");
            }
            String a = a.this.Ju();
            if (!StringUtils.isValidString(a) || !a.this.aIR) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    BN.i("IncentivizedAdController", "Invalid reward state - result: " + a + " and wasFullyEngaged: " + a.this.aIR);
                }
                a.this.sdk.BN();
                if (x.Fn()) {
                    a.this.sdk.BN().f("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                eVar.yg();
                if (a.this.aIR) {
                    a.this.sdk.BN();
                    if (x.Fn()) {
                        a.this.sdk.BN().i("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    a.this.sdk.BN();
                    if (x.Fn()) {
                        a.this.sdk.BN().i("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                eVar.a(c.dn(str));
                a.this.sdk.BN();
                if (x.Fn()) {
                    a.this.sdk.BN().f("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                m.a(this.aIY, (AppLovinAd) eVar, i);
            }
            if (!eVar.GW().getAndSet(true)) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    a.this.sdk.BN().f("IncentivizedAdController", "Scheduling report rewarded ad...");
                }
                a.this.sdk.BO().a((d) new com.applovin.impl.sdk.e.x(eVar, a.this.sdk), q.b.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            m.a(this.aIW, appLovinAd);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            m.a(this.aIX, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            m.a(this.aIX, appLovinAd, d, z);
            boolean unused = a.this.aIR = z;
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dm("accepted");
            m.a(this.aIY, appLovinAd, map);
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dm("quota_exceeded");
            m.b(this.aIY, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dm("rejected");
            m.c(this.aIY, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            a.this.dm("network_timeout");
            m.a(this.aIY, appLovinAd, i);
        }
    }

    /* access modifiers changed from: private */
    public void f(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.aIN;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof com.applovin.impl.sdk.ad.f) {
                com.applovin.impl.sdk.ad.f fVar = (com.applovin.impl.sdk.ad.f) appLovinAd2;
                if (fVar.HB() == null || appLovinAd == fVar.HB()) {
                    this.aIN = null;
                }
            } else if (appLovinAd == appLovinAd2) {
                this.aIN = null;
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.b.a$a  reason: collision with other inner class name */
    private class C0081a implements AppLovinAdLoadListener {
        private final AppLovinAdLoadListener aIT;

        C0081a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.aIT = appLovinAdLoadListener;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            AppLovinAd unused = a.this.aIN = appLovinAd;
            if (this.aIT != null) {
                AppLovinSdkUtils.runOnUiThread(new a$a$$ExternalSyntheticLambda0(this, appLovinAd));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$adReceived$0$com-applovin-impl-sdk-b-a$a  reason: not valid java name */
        public /* synthetic */ void m1873lambda$adReceived$0$comapplovinimplsdkba$a(AppLovinAd appLovinAd) {
            try {
                this.aIT.adReceived(appLovinAd);
            } catch (Throwable th) {
                x.e("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                a.this.sdk.Cs().d("IncentivizedAdController", "adLoaded", th);
            }
        }

        public void failedToReceiveAd(int i) {
            if (this.aIT != null) {
                AppLovinSdkUtils.runOnUiThread(new a$a$$ExternalSyntheticLambda1(this, i));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void gN(int i) {
            try {
                this.aIT.failedToReceiveAd(i);
            } catch (Throwable th) {
                x.e("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                a.this.sdk.Cs().d("IncentivizedAdController", "adLoadFailed", th);
            }
        }
    }

    private AppLovinAdRewardListener Jv() {
        return new AppLovinAdRewardListener() {
            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    BN.f("IncentivizedAdController", "Reward validated: " + map);
                }
            }

            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    BN.i("IncentivizedAdController", "User over quota: " + map);
                }
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    BN.i("IncentivizedAdController", "Reward rejected: " + map);
                }
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                a.this.sdk.BN();
                if (x.Fn()) {
                    x BN = a.this.sdk.BN();
                    BN.i("IncentivizedAdController", "Reward validation failed: " + i);
                }
            }
        };
    }
}
