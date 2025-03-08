package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class q8 implements RewardedVideoListener, InterstitialListener, h7, SegmentListener {
    /* access modifiers changed from: private */
    public RewardedVideoListener a;
    /* access modifiers changed from: private */
    public InterstitialListener b;
    /* access modifiers changed from: private */
    public OfferwallListener c;
    /* access modifiers changed from: private */
    public SegmentListener d;
    private v e;
    private InterstitialPlacement f = null;
    private String g = null;
    protected long h;

    class a implements Runnable {
        a() {
        }

        public void run() {
            q8.this.b.onInterstitialAdReady();
        }
    }

    class b implements Runnable {
        final /* synthetic */ IronSourceError a;

        b(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            q8.this.b.onInterstitialAdLoadFailed(this.a);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            q8.this.b.onInterstitialAdOpened();
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            q8.this.b.onInterstitialAdShowSucceeded();
        }
    }

    class e implements Runnable {
        final /* synthetic */ IronSourceError a;

        e(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            q8.this.b.onInterstitialAdShowFailed(this.a);
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            q8.this.b.onInterstitialAdClicked();
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            q8.this.b.onInterstitialAdClosed();
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            q8.this.c.onOfferwallOpened();
        }
    }

    class i implements Runnable {
        final /* synthetic */ IronSourceError a;

        i(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            q8.this.c.onOfferwallShowFailed(this.a);
        }
    }

    class j implements Runnable {
        final /* synthetic */ IronSourceError a;

        j(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            q8.this.c.onGetOfferwallCreditsFailed(this.a);
        }
    }

    class k implements Runnable {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        public void run() {
            if (!TextUtils.isEmpty(this.a)) {
                q8.this.d.onSegmentReceived(this.a);
            }
        }
    }

    class l implements Runnable {
        l() {
        }

        public void run() {
            q8.this.c.onOfferwallClosed();
        }
    }

    class m implements Runnable {
        final /* synthetic */ boolean a;

        m(boolean z) {
            this.a = z;
        }

        public void run() {
            q8.this.c.onOfferwallAvailable(this.a);
        }
    }

    class n implements Runnable {
        n() {
        }

        public void run() {
            q8.this.a.onRewardedVideoAdOpened();
        }
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            q8.this.a.onRewardedVideoAdClosed();
        }
    }

    class p implements Runnable {
        final /* synthetic */ boolean a;

        p(boolean z) {
            this.a = z;
        }

        public void run() {
            q8.this.a.onRewardedVideoAvailabilityChanged(this.a);
        }
    }

    class q implements Runnable {
        q() {
        }

        public void run() {
            q8.this.a.onRewardedVideoAdStarted();
        }
    }

    class r implements Runnable {
        r() {
        }

        public void run() {
            q8.this.a.onRewardedVideoAdEnded();
        }
    }

    class s implements Runnable {
        final /* synthetic */ Placement a;

        s(Placement placement) {
            this.a = placement;
        }

        public void run() {
            q8.this.a.onRewardedVideoAdRewarded(this.a);
        }
    }

    class t implements Runnable {
        final /* synthetic */ Placement a;

        t(Placement placement) {
            this.a = placement;
        }

        public void run() {
            q8.this.a.onRewardedVideoAdClicked(this.a);
        }
    }

    class u implements Runnable {
        final /* synthetic */ IronSourceError a;

        u(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            q8.this.a.onRewardedVideoAdShowFailed(this.a);
        }
    }

    private class v extends Thread {
        private Handler a;

        private v() {
        }

        /* synthetic */ v(q8 q8Var, k kVar) {
            this();
        }

        public Handler a() {
            return this.a;
        }

        public void run() {
            Looper.prepare();
            this.a = new Handler();
            Looper.loop();
        }
    }

    public q8() {
        v vVar = new v(this, (k) null);
        this.e = vVar;
        vVar.start();
        this.h = new Date().getTime();
    }

    public void a(IronSourceError ironSourceError, Map<String, Object> map) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "onRewardedVideoAdShowFailed(" + ironSourceError.toString() + ")", 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("errorCode", ironSourceError.getErrorCode());
            mediationAdditionalData.put("reason", ironSourceError.getErrorMessage());
            if (!TextUtils.isEmpty(this.g)) {
                mediationAdditionalData.put("placement", this.g);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    mediationAdditionalData.put(next, map.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, mediationAdditionalData));
        if (a((Object) this.a)) {
            a((Runnable) new u(ironSourceError));
        }
    }

    public void a(InterstitialPlacement interstitialPlacement) {
        this.f = interstitialPlacement;
    }

    public void a(InterstitialListener interstitialListener) {
        this.b = interstitialListener;
    }

    public void a(OfferwallListener offerwallListener) {
        this.c = offerwallListener;
    }

    public void a(RewardedVideoListener rewardedVideoListener) {
        this.a = rewardedVideoListener;
    }

    public void a(SegmentListener segmentListener) {
        this.d = segmentListener;
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        Handler a2;
        v vVar = this.e;
        if (vVar != null && (a2 = vVar.a()) != null) {
            a2.post(runnable);
        }
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z, IronSourceError ironSourceError) {
        String str = "onOfferwallAvailable(isAvailable: " + z + ")";
        if (ironSourceError != null) {
            str = str + ", error: " + ironSourceError.getErrorMessage();
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("status", String.valueOf(z));
            if (ironSourceError != null) {
                mediationAdditionalData.put("errorCode", ironSourceError.getErrorCode());
                mediationAdditionalData.put("reason", ironSourceError.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(IronSourceConstants.OFFERWALL_AVAILABLE, mediationAdditionalData));
        if (a((Object) this.c)) {
            a((Runnable) new m(z));
        }
    }

    public void a(boolean z, Map<String, Object> map) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        long time = new Date().getTime() - this.h;
        this.h = new Date().getTime();
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_DURATION, time);
            if (map != null) {
                for (String next : map.keySet()) {
                    mediationAdditionalData.put(next, map.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(z ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, mediationAdditionalData));
        if (a((Object) this.a)) {
            a((Runnable) new p(z));
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return (obj == null || this.e == null) ? false : true;
    }

    public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.c)) {
            a((Runnable) new j(ironSourceError));
        }
    }

    public void onInterstitialAdClicked() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new f());
        }
    }

    public void onInterstitialAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new g());
        }
    }

    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onInterstitialAdLoadFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.b)) {
            a((Runnable) new b(ironSourceError));
        }
    }

    public void onInterstitialAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new c());
        }
    }

    public void onInterstitialAdReady() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new a());
        }
    }

    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onInterstitialAdShowFailed(" + ironSourceError + ")", 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("errorCode", ironSourceError.getErrorCode());
            InterstitialPlacement interstitialPlacement = this.f;
            if (interstitialPlacement != null && !TextUtils.isEmpty(interstitialPlacement.getPlacementName())) {
                mediationAdditionalData.put("placement", this.f.getPlacementName());
            }
            if (ironSourceError.getErrorMessage() != null) {
                mediationAdditionalData.put("reason", ironSourceError.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        n7.i().a(new y3(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, mediationAdditionalData));
        if (a((Object) this.b)) {
            a((Runnable) new e(ironSourceError));
        }
    }

    public void onInterstitialAdShowSucceeded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new d());
        }
    }

    public boolean onOfferwallAdCredited(int i2, int i3, boolean z) {
        OfferwallListener offerwallListener = this.c;
        boolean onOfferwallAdCredited = offerwallListener != null ? offerwallListener.onOfferwallAdCredited(i2, i3, z) : false;
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onOfferwallAdCredited(credits:" + i2 + ", totalCredits:" + i3 + ", totalCreditsFlag:" + z + "):" + onOfferwallAdCredited, 1);
        return onOfferwallAdCredited;
    }

    public void onOfferwallAvailable(boolean z) {
        a(z, (IronSourceError) null);
    }

    public void onOfferwallClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallClosed()", 1);
        if (a((Object) this.c)) {
            a((Runnable) new l());
        }
    }

    public void onOfferwallOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallOpened()", 1);
        if (a((Object) this.c)) {
            a((Runnable) new h());
        }
    }

    public void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.c)) {
            a((Runnable) new i(ironSourceError));
        }
    }

    public void onRewardedVideoAdClicked(Placement placement) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAdClicked(" + placement.getPlacementName() + ")", 1);
        if (a((Object) this.a)) {
            a((Runnable) new t(placement));
        }
    }

    public void onRewardedVideoAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new o());
        }
    }

    public void onRewardedVideoAdEnded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new r());
        }
    }

    public void onRewardedVideoAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new n());
        }
    }

    public void onRewardedVideoAdRewarded(Placement placement) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAdRewarded(" + placement.toString() + ")", 1);
        if (a((Object) this.a)) {
            a((Runnable) new s(placement));
        }
    }

    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a(ironSourceError, (Map<String, Object>) null);
    }

    public void onRewardedVideoAdStarted() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new q());
        }
    }

    public void onRewardedVideoAvailabilityChanged(boolean z) {
        a(z, (Map<String, Object>) null);
    }

    public void onSegmentReceived(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onSegmentReceived(" + str + ")", 1);
        if (a((Object) this.d)) {
            a((Runnable) new k(str));
        }
    }
}
