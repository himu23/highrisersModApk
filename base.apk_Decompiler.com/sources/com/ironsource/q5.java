package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.p5;

public class q5 extends p5.a<ISDemandOnlyInterstitialListener> implements ISDemandOnlyInterstitialListener {

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        a(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5.this.a(this.a, "onInterstitialAdReady()");
            this.b.onInterstitialAdReady(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyInterstitialListener c;

        b(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5 q5Var = q5.this;
            String str = this.a;
            q5Var.a(str, "onInterstitialAdLoadFailed() error = " + this.b.getErrorMessage());
            this.c.onInterstitialAdLoadFailed(this.a, this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        c(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5.this.a(this.a, "onInterstitialAdOpened()");
            this.b.onInterstitialAdOpened(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyInterstitialListener c;

        d(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5 q5Var = q5.this;
            String str = this.a;
            q5Var.a(str, "onInterstitialAdShowFailed() error = " + this.b.getErrorMessage());
            this.c.onInterstitialAdShowFailed(this.a, this.b);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        e(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5.this.a(this.a, "onInterstitialAdClicked()");
            this.b.onInterstitialAdClicked(this.a);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        f(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        public void run() {
            q5.this.a(this.a, "onInterstitialAdClosed()");
            this.b.onInterstitialAdClosed(this.a);
        }
    }

    q5() {
    }

    q5(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        a(iSDemandOnlyInterstitialListener);
    }

    public void onInterstitialAdClicked(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new e(str, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }

    public void onInterstitialAdClosed(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new f(str, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }

    public void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new b(str, ironSourceError, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }

    public void onInterstitialAdOpened(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new c(str, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }

    public void onInterstitialAdReady(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new a(str, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }

    public void onInterstitialAdShowFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener = (ISDemandOnlyInterstitialListener) a();
        a((Runnable) new d(str, ironSourceError, iSDemandOnlyInterstitialListener), iSDemandOnlyInterstitialListener != null);
    }
}
