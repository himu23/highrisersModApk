package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.p5;

public class s5 extends p5.a<ISDemandOnlyRewardedVideoListener> implements ISDemandOnlyRewardedVideoListener {

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        a(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5.this.a(this.a, "onRewardedVideoAdLoadSuccess()");
            this.b.onRewardedVideoAdLoadSuccess(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener c;

        b(String str, IronSourceError ironSourceError, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5 s5Var = s5.this;
            String str = this.a;
            s5Var.a(str, "onRewardedVideoAdLoadFailed() error = " + this.b.getErrorMessage());
            this.c.onRewardedVideoAdLoadFailed(this.a, this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        c(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5.this.a(this.a, "onRewardedVideoAdOpened()");
            this.b.onRewardedVideoAdOpened(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener c;

        d(String str, IronSourceError ironSourceError, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5 s5Var = s5.this;
            String str = this.a;
            s5Var.a(str, "onRewardedVideoAdShowFailed() error = " + this.b.getErrorMessage());
            this.c.onRewardedVideoAdShowFailed(this.a, this.b);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        e(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5.this.a(this.a, "onRewardedVideoAdClicked()");
            this.b.onRewardedVideoAdClicked(this.a);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        f(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5.this.a(this.a, "onRewardedVideoAdRewarded()");
            this.b.onRewardedVideoAdRewarded(this.a);
        }
    }

    class g implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        g(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        public void run() {
            s5.this.a(this.a, "onRewardedVideoAdClosed()");
            this.b.onRewardedVideoAdClosed(this.a);
        }
    }

    s5() {
    }

    s5(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        a(iSDemandOnlyRewardedVideoListener);
    }

    public void onRewardedVideoAdClicked(String str) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new e(str, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdClosed(String str) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new g(str, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdLoadFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new b(str, ironSourceError, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdLoadSuccess(String str) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new a(str, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdOpened(String str) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new c(str, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdRewarded(String str) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new f(str, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }

    public void onRewardedVideoAdShowFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener = (ISDemandOnlyRewardedVideoListener) a();
        a((Runnable) new d(str, ironSourceError, iSDemandOnlyRewardedVideoListener), iSDemandOnlyRewardedVideoListener != null);
    }
}
