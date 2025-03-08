package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

public class f1 extends v1 {
    private static final f1 e = new f1();
    /* access modifiers changed from: private */
    public BannerListener b = null;
    /* access modifiers changed from: private */
    public LevelPlayBannerListener c = null;
    /* access modifiers changed from: private */
    public LevelPlayBannerListener d = null;

    class a implements Runnable {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdScreenDismissed(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdScreenDismissed() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdScreenDismissed();
                IronLog.CALLBACK.info("onBannerAdScreenDismissed()");
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ AdInfo a;

        c(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdScreenDismissed(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdScreenDismissed() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ AdInfo a;

        d(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdLeftApplication(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLeftApplication() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdLeftApplication();
                IronLog.CALLBACK.info("onBannerAdLeftApplication()");
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ AdInfo a;

        f(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdLeftApplication(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLeftApplication() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ AdInfo a;

        g(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdClicked(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdClicked();
                IronLog.CALLBACK.info("onBannerAdClicked()");
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ AdInfo a;

        i(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdClicked(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ AdInfo a;

        j(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdLoaded(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoaded() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdLoaded();
                IronLog.CALLBACK.info("onBannerAdLoaded()");
            }
        }
    }

    class l implements Runnable {
        final /* synthetic */ AdInfo a;

        l(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdLoaded(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoaded() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class m implements Runnable {
        final /* synthetic */ IronSourceError a;

        m(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class n implements Runnable {
        final /* synthetic */ IronSourceError a;

        n(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onBannerAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ IronSourceError a;

        o(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class p implements Runnable {
        final /* synthetic */ AdInfo a;

        p(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.d != null) {
                f1.this.d.onAdScreenPresented(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdScreenPresented() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        public void run() {
            if (f1.this.b != null) {
                f1.this.b.onBannerAdScreenPresented();
                IronLog.CALLBACK.info("onBannerAdScreenPresented()");
            }
        }
    }

    class r implements Runnable {
        final /* synthetic */ AdInfo a;

        r(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (f1.this.c != null) {
                f1.this.c.onAdScreenPresented(f1.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdScreenPresented() adInfo = " + f1.this.a(this.a));
            }
        }
    }

    private f1() {
    }

    public static f1 a() {
        return e;
    }

    public void a(AdInfo adInfo, boolean z) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
            return;
        }
        if (this.b != null && !z) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError, boolean z) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(ironSourceError));
            return;
        }
        if (this.b != null && !z) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(ironSourceError));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(ironSourceError));
        }
    }

    public void a(BannerListener bannerListener) {
        this.b = bannerListener;
    }

    public void a(LevelPlayBannerListener levelPlayBannerListener) {
        this.c = levelPlayBannerListener;
    }

    public LevelPlayBannerListener b() {
        return this.c;
    }

    public void b(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
        }
    }

    public void b(LevelPlayBannerListener levelPlayBannerListener) {
        this.d = levelPlayBannerListener;
    }

    public BannerListener c() {
        return this.b;
    }

    public void c(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
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

    public void e(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new q());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new r(adInfo));
        }
    }
}
