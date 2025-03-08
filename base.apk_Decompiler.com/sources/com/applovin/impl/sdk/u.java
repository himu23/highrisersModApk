package com.applovin.impl.sdk;

import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.c.b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class u {
    private static final a aEW = new a();
    private final AtomicBoolean aEX = new AtomicBoolean();
    private long aEY;
    private final Object aEZ = new Object();
    private final AtomicBoolean aFa = new AtomicBoolean();
    private long aFb;
    private Object aFc;
    private final Map<String, a> aFd = new HashMap();
    private final Object aFe = new Object();
    private final n sdk;

    public Object Fd() {
        return this.aFc;
    }

    public static class a {
        /* access modifiers changed from: private */
        public long aFf = -1;
        private int aFg;

        public long Fe() {
            return this.aFf;
        }

        public int Ff() {
            return this.aFg;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.canEqual(this) && Fe() == aVar.Fe() && Ff() == aVar.Ff();
        }

        public int hashCode() {
            long Fe = Fe();
            return ((((int) (Fe ^ (Fe >>> 32))) + 59) * 59) + Ff();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + Fe() + ", attemptCount=" + Ff() + ")";
        }

        static /* synthetic */ int a(a aVar) {
            int i = aVar.aFg;
            aVar.aFg = i + 1;
            return i;
        }
    }

    u(n nVar) {
        this.sdk = nVar;
    }

    public boolean Fb() {
        return this.aFa.get();
    }

    public void aM(boolean z) {
        synchronized (this.aEZ) {
            this.aFa.set(z);
            if (z) {
                this.aFb = System.currentTimeMillis();
                this.sdk.BN();
                if (x.Fn()) {
                    x BN = this.sdk.BN();
                    BN.f("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.aFb);
                }
                Long l = (Long) this.sdk.a(b.aMO);
                if (l.longValue() >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new u$$ExternalSyntheticLambda1(this, l), l.longValue());
                }
            } else {
                this.aFb = 0;
                this.sdk.BN();
                if (x.Fn()) {
                    x BN2 = this.sdk.BN();
                    BN2.f("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        if (Fb() && System.currentTimeMillis() - this.aFb >= l.longValue()) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.aFa.set(false);
        }
    }

    public boolean Fc() {
        return this.aEX.get();
    }

    public void ab(Object obj) {
        if (!c.Z(obj) && this.aEX.compareAndSet(false, true)) {
            this.aFc = obj;
            this.aEY = System.currentTimeMillis();
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.aEY);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            Long l = (Long) this.sdk.a(b.aMP);
            if (l.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new u$$ExternalSyntheticLambda0(this, l, obj), l.longValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Long l, Object obj) {
        if (this.aEX.get() && System.currentTimeMillis() - this.aEY >= l.longValue()) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            ac(obj);
        }
    }

    public void ac(Object obj) {
        if (!c.Z(obj) && this.aEX.compareAndSet(true, false)) {
            this.aFc = null;
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public void cG(String str) {
        synchronized (this.aFe) {
            a aVar = this.aFd.get(str);
            if (aVar == null) {
                aVar = new a();
                this.aFd.put(str, aVar);
            }
            long unused = aVar.aFf = System.currentTimeMillis();
            a.a(aVar);
        }
    }

    public a cH(String str) {
        a aVar;
        synchronized (this.aFe) {
            aVar = this.aFd.get(str);
            if (aVar == null) {
                aVar = aEW;
            }
        }
        return aVar;
    }

    public void cI(String str) {
        synchronized (this.aFe) {
            this.aFd.remove(str);
        }
    }
}
