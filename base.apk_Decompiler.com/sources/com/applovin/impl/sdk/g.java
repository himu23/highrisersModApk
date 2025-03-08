package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class g {
    private static final g azq = new g();
    /* access modifiers changed from: private */
    public final AtomicLong azg = new AtomicLong(0);
    /* access modifiers changed from: private */
    public Handler azh;
    private final HandlerThread azi = new HandlerThread("AppLovinSdk:anr_detector");
    /* access modifiers changed from: private */
    public Handler azj;
    /* access modifiers changed from: private */
    public final AtomicBoolean azk = new AtomicBoolean();
    private final AtomicBoolean azl = new AtomicBoolean();
    /* access modifiers changed from: private */
    public Thread azm;
    /* access modifiers changed from: private */
    public long azn = TimeUnit.SECONDS.toMillis(4);
    /* access modifiers changed from: private */
    public long azo = TimeUnit.SECONDS.toMillis(3);
    /* access modifiers changed from: private */
    public long azp = TimeUnit.SECONDS.toMillis(3);
    /* access modifiers changed from: private */
    public n sdk;

    private g() {
    }

    private void n(n nVar) {
        if (this.azl.compareAndSet(false, true)) {
            this.sdk = nVar;
            AppLovinSdkUtils.runOnUiThread(new g$$ExternalSyntheticLambda0(this));
            this.azn = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQw)).longValue();
            this.azo = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQx)).longValue();
            this.azp = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQy)).longValue();
            this.azh = new Handler(n.getApplicationContext().getMainLooper());
            this.azi.start();
            this.azh.post(new b());
            Handler handler = new Handler(this.azi.getLooper());
            this.azj = handler;
            handler.postDelayed(new a(), this.azp / 2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AR() {
        this.azm = Thread.currentThread();
    }

    /* access modifiers changed from: private */
    public void X() {
        if (this.azl.get()) {
            this.azk.set(true);
        }
    }

    public static void o(n nVar) {
        if (nVar == null) {
            return;
        }
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQv)).booleanValue() || u.b(n.getApplicationContext(), nVar)) {
            azq.X();
        } else {
            azq.n(nVar);
        }
    }

    private class b implements Runnable {
        private b() {
        }

        public void run() {
            if (!g.this.azk.get()) {
                g.this.azg.set(System.currentTimeMillis());
                g.this.azh.postDelayed(this, g.this.azo);
            }
        }
    }

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            String str;
            if (!g.this.azk.get()) {
                long currentTimeMillis = System.currentTimeMillis() - g.this.azg.get();
                if (currentTimeMillis < 0 || currentTimeMillis > g.this.azn) {
                    g.this.X();
                    if (g.this.azm == null || g.this.azm.getStackTrace().length <= 0) {
                        str = "None";
                    } else {
                        StackTraceElement stackTraceElement = g.this.azm.getStackTrace()[0];
                        str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                    }
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - n.CH());
                    HashMap hashMap = new HashMap(3);
                    hashMap.put("top_main_method", str);
                    hashMap.put("source", g.this.sdk.BL() ? "non_first_session" : "first_session");
                    hashMap.put("details", "seconds_since_app_launch=" + seconds);
                    g.this.sdk.Cs().a(r.a.ANR, (Map<String, String>) hashMap);
                }
                g.this.azj.postDelayed(this, g.this.azp);
            }
        }
    }
}
