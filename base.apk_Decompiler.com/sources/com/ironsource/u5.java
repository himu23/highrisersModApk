package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;

public class u5 extends v1 {
    private static final u5 e = new u5();
    /* access modifiers changed from: private */
    public InterstitialListener b = null;
    /* access modifiers changed from: private */
    public LevelPlayInterstitialListener c;
    /* access modifiers changed from: private */
    public LevelPlayInterstitialListener d;

    class a implements Runnable {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdClosed(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClosed() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdClosed();
                u5.this.a("onInterstitialAdClosed()");
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ AdInfo a;

        c(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdClosed(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClosed() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ AdInfo a;

        d(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdShowSucceeded(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowSucceeded() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdShowSucceeded();
                u5.this.a("onInterstitialAdShowSucceeded()");
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ AdInfo a;

        f(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdShowSucceeded(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowSucceeded() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ IronSourceError a;
        final /* synthetic */ AdInfo b;

        g(IronSourceError ironSourceError, AdInfo adInfo) {
            this.a = ironSourceError;
            this.b = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdShowFailed(this.a, u5.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowFailed() adInfo = " + u5.this.a(this.b) + ", error = " + this.a.getErrorMessage());
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ IronSourceError a;

        h(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdShowFailed(this.a);
                u5 u5Var = u5.this;
                u5Var.a("onInterstitialAdShowFailed() error=" + this.a.getErrorMessage());
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ IronSourceError a;
        final /* synthetic */ AdInfo b;

        i(IronSourceError ironSourceError, AdInfo adInfo) {
            this.a = ironSourceError;
            this.b = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdShowFailed(this.a, u5.this.a(this.b));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdShowFailed() adInfo = " + u5.this.a(this.b) + ", error = " + this.a.getErrorMessage());
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ AdInfo a;

        j(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdClicked(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class k implements Runnable {
        final /* synthetic */ AdInfo a;

        k(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdReady(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdReady() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class l implements Runnable {
        l() {
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdClicked();
                u5.this.a("onInterstitialAdClicked()");
            }
        }
    }

    class m implements Runnable {
        final /* synthetic */ AdInfo a;

        m(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdClicked(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdClicked() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdReady();
                u5.this.a("onInterstitialAdReady()");
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ AdInfo a;

        o(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdReady(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdReady() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class p implements Runnable {
        final /* synthetic */ IronSourceError a;

        p(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class q implements Runnable {
        final /* synthetic */ IronSourceError a;

        q(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdLoadFailed(this.a);
                u5 u5Var = u5.this;
                u5Var.a("onInterstitialAdLoadFailed() error=" + this.a.getErrorMessage());
            }
        }
    }

    class r implements Runnable {
        final /* synthetic */ IronSourceError a;

        r(IronSourceError ironSourceError) {
            this.a = ironSourceError;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdLoadFailed(this.a);
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdLoadFailed() error = " + this.a.getErrorMessage());
            }
        }
    }

    class s implements Runnable {
        final /* synthetic */ AdInfo a;

        s(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.d != null) {
                u5.this.d.onAdOpened(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdOpened() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    class t implements Runnable {
        t() {
        }

        public void run() {
            if (u5.this.b != null) {
                u5.this.b.onInterstitialAdOpened();
                u5.this.a("onInterstitialAdOpened()");
            }
        }
    }

    class u implements Runnable {
        final /* synthetic */ AdInfo a;

        u(AdInfo adInfo) {
            this.a = adInfo;
        }

        public void run() {
            if (u5.this.c != null) {
                u5.this.c.onAdOpened(u5.this.a(this.a));
                IronLog ironLog = IronLog.CALLBACK;
                ironLog.info("onAdOpened() adInfo = " + u5.this.a(this.a));
            }
        }
    }

    private u5() {
    }

    public static synchronized u5 a() {
        u5 u5Var;
        synchronized (u5.class) {
            u5Var = e;
        }
        return u5Var;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void a(IronSourceError ironSourceError) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(ironSourceError));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new q(ironSourceError));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new r(ironSourceError));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(ironSourceError, adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(ironSourceError));
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(ironSourceError, adInfo));
        }
    }

    public synchronized void a(InterstitialListener interstitialListener) {
        this.b = interstitialListener;
    }

    public synchronized void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.c = levelPlayInterstitialListener;
    }

    public synchronized InterstitialListener b() {
        return this.b;
    }

    public void b(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public synchronized void b(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.d = levelPlayInterstitialListener;
    }

    public void c(AdInfo adInfo) {
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

    public void d(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new s(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new t());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new u(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.d != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
            return;
        }
        if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n());
        }
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
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
}
