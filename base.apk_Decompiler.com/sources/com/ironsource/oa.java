package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;

public class oa extends v1 {
    private static final oa e = new oa();
    /* access modifiers changed from: private */
    public RewardedVideoListener b = null;
    /* access modifiers changed from: private */
    public LevelPlayRewardedVideoBaseListener c;
    /* access modifiers changed from: private */
    public LevelPlayRewardedVideoBaseListener d;

    class a implements Runnable {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                oa.this.d.onAdClosed(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClosed() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdClosed();
                oa.this.a("onRewardedVideoAdClosed()");
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ AdInfo a;

        c(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                oa.this.c.onAdClosed(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClosed() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ AdInfo b;

        d(boolean z, AdInfo adInfo) {
            this.a = z;
            this.b = adInfo;
        }

        public void run() {
            String str;
            IronLog ironLog;
            if (oa.this.d != null) {
                if (this.a) {
                    ((LevelPlayRewardedVideoListener) oa.this.d).onAdAvailable(oa.this.a(this.b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + oa.this.a(this.b);
                } else {
                    ((LevelPlayRewardedVideoListener) oa.this.d).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ boolean a;

        e(boolean z) {
            this.a = z;
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAvailabilityChanged(this.a);
                oa oaVar = oa.this;
                oaVar.a("onRewardedVideoAvailabilityChanged() available=" + this.a);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ AdInfo b;

        f(boolean z, AdInfo adInfo) {
            this.a = z;
            this.b = adInfo;
        }

        public void run() {
            String str;
            IronLog ironLog;
            if (oa.this.c != null) {
                if (this.a) {
                    ((LevelPlayRewardedVideoListener) oa.this.c).onAdAvailable(oa.this.a(this.b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + oa.this.a(this.b);
                } else {
                    ((LevelPlayRewardedVideoListener) oa.this.c).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdStarted();
                oa.this.a("onRewardedVideoAdStarted()");
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdEnded();
                oa.this.a("onRewardedVideoAdEnded()");
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ Placement a;
        final /* synthetic */ AdInfo b;

        i(Placement placement, AdInfo adInfo) {
            this.a = placement;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                oa.this.d.onAdRewarded(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdRewarded() placement = " + this.a + ", adInfo = " + oa.this.a(this.b));
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ Placement a;

        j(Placement placement) {
            this.a = placement;
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdRewarded(this.a);
                oa oaVar = oa.this;
                oaVar.a("onRewardedVideoAdRewarded(" + this.a + ")");
            }
        }
    }

    class k implements Runnable {
        final /* synthetic */ AdInfo a;

        k(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                ((LevelPlayRewardedVideoManualListener) oa.this.d).onAdReady(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdReady() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    class l implements Runnable {
        final /* synthetic */ Placement a;
        final /* synthetic */ AdInfo b;

        l(Placement placement, AdInfo adInfo) {
            this.a = placement;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                oa.this.c.onAdRewarded(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdRewarded() placement = " + this.a + ", adInfo = " + oa.this.a(this.b));
            }
        }
    }

    class m implements Runnable {
        final /* synthetic */ IronSourceError a;
        final /* synthetic */ AdInfo b;

        m(IronSourceError ironSourceError, AdInfo adInfo) {
            this.a = ironSourceError;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                oa.this.d.onAdShowFailed(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowFailed() adInfo = " + oa.this.a(this.b) + ", error = " + this.a.getErrorMessage());
            }
        }
    }

    class n implements Runnable {
        final /* synthetic */ IronSourceError a;

        n(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdShowFailed(this.a);
                oa oaVar = oa.this;
                oaVar.a("onRewardedVideoAdShowFailed() error=" + this.a.getErrorMessage());
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ IronSourceError a;
        final /* synthetic */ AdInfo b;

        o(IronSourceError ironSourceError, AdInfo adInfo) {
            this.a = ironSourceError;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                oa.this.c.onAdShowFailed(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowFailed() adInfo = " + oa.this.a(this.b) + ", error = " + this.a.getErrorMessage());
            }
        }
    }

    class p implements Runnable {
        final /* synthetic */ Placement a;
        final /* synthetic */ AdInfo b;

        p(Placement placement, AdInfo adInfo) {
            this.a = placement;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                oa.this.d.onAdClicked(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() placement = " + this.a + ", adInfo = " + oa.this.a(this.b));
            }
        }
    }

    class q implements Runnable {
        final /* synthetic */ Placement a;

        q(Placement placement) {
            this.a = placement;
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdClicked(this.a);
                oa oaVar = oa.this;
                oaVar.a("onRewardedVideoAdClicked(" + this.a + ")");
            }
        }
    }

    class r implements Runnable {
        final /* synthetic */ Placement a;
        final /* synthetic */ AdInfo b;

        r(Placement placement, AdInfo adInfo) {
            this.a = placement;
            this.b = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                oa.this.c.onAdClicked(this.a, oa.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() placement = " + this.a + ", adInfo = " + oa.this.a(this.b));
            }
        }
    }

    class s implements Runnable {
        s() {
        }

        public void run() {
            if (oa.this.b != null) {
                ((RewardedVideoManualListener) oa.this.b).onRewardedVideoAdReady();
                oa.this.a("onRewardedVideoAdReady()");
            }
        }
    }

    class t implements Runnable {
        final /* synthetic */ AdInfo a;

        t(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                ((LevelPlayRewardedVideoManualListener) oa.this.c).onAdReady(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdReady() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    class u implements Runnable {
        final /* synthetic */ IronSourceError a;

        u(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (oa.this.d != null) {
                ((LevelPlayRewardedVideoManualListener) oa.this.d).onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class v implements Runnable {
        final /* synthetic */ IronSourceError a;

        v(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (oa.this.b != null) {
                ((RewardedVideoManualListener) oa.this.b).onRewardedVideoAdLoadFailed(this.a);
                oa oaVar = oa.this;
                oaVar.a("onRewardedVideoAdLoadFailed() error=" + this.a.getErrorMessage());
            }
        }
    }

    class w implements Runnable {
        final /* synthetic */ IronSourceError a;

        w(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (oa.this.c != null) {
                ((LevelPlayRewardedVideoManualListener) oa.this.c).onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class x implements Runnable {
        final /* synthetic */ AdInfo a;

        x(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.d != null) {
                oa.this.d.onAdOpened(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdOpened() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    class y implements Runnable {
        y() {
        }

        public void run() {
            if (oa.this.b != null) {
                oa.this.b.onRewardedVideoAdOpened();
                oa.this.a("onRewardedVideoAdOpened()");
            }
        }
    }

    class z implements Runnable {
        final /* synthetic */ AdInfo a;

        z(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (oa.this.c != null) {
                oa.this.c.onAdOpened(oa.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdOpened() adInfo = " + oa.this.a(this.a));
            }
        }
    }

    private oa() {
    }

    public static oa a() {
        return e;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void a(IronSourceError ironSourceError) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new u(ironSourceError));
            return;
        }
        RewardedVideoListener rewardedVideoListener = this.b;
        if (rewardedVideoListener != null && (rewardedVideoListener instanceof RewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new v(ironSourceError));
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.c;
        if (levelPlayRewardedVideoBaseListener != null && (levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new w(ironSourceError));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(ironSourceError, adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(ironSourceError));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(ironSourceError, adInfo));
        }
    }

    public void a(Placement placement, AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(placement, adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new q(placement));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new r(placement, adInfo));
        }
    }

    public void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.c = levelPlayRewardedVideoBaseListener;
    }

    public void a(RewardedVideoListener rewardedVideoListener) {
        this.b = rewardedVideoListener;
    }

    public void a(boolean z2, AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(z2, adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(z2));
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.c;
        if (levelPlayRewardedVideoBaseListener != null && (levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(z2, adInfo));
        }
    }

    public void b() {
        if (this.d == null && this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h());
        }
    }

    public void b(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(adInfo));
        }
    }

    public void b(Placement placement, AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(placement, adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(placement));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(placement, adInfo));
        }
    }

    public void b(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.d = levelPlayRewardedVideoBaseListener;
    }

    public void c() {
        if (this.d == null && this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g());
        }
    }

    public void c(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new x(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new y());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new z(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
            return;
        }
        RewardedVideoListener rewardedVideoListener = this.b;
        if (rewardedVideoListener != null && (rewardedVideoListener instanceof RewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new s());
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.c;
        if (levelPlayRewardedVideoBaseListener != null && (levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new t(adInfo));
        }
    }
}
