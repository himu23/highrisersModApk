package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.u;
import com.ironsource.m2;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";
    private final AtomicBoolean aFD = new AtomicBoolean();
    private final AtomicBoolean aFE = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicInteger aFF = new AtomicInteger();
    private final AtomicLong aFG = new AtomicLong();
    private final AtomicLong aFH = new AtomicLong();
    private Date aFI;
    private Date aFJ;
    final n mSdk;

    SessionTracker(n nVar) {
        this.mSdk = nVar;
        Application application = (Application) n.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                SessionTracker.this.AC();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                SessionTracker.this.aFF.set(i);
                if (i == 20) {
                    SessionTracker.this.AB();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (u.Ly()) {
                        SessionTracker.this.AC();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    SessionTracker.this.AB();
                }
            }
        }, intentFilter);
    }

    public boolean isApplicationPaused() {
        return this.aFE.get();
    }

    public int getLastTrimMemoryLevel() {
        return this.aFF.get();
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.aFG.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.aFH.get();
    }

    public void pauseForClick() {
        this.aFD.set(true);
    }

    public void resumeForClick() {
        this.aFD.set(false);
    }

    /* access modifiers changed from: private */
    public void AC() {
        if (this.aFE.compareAndSet(true, false)) {
            Fv();
        }
    }

    /* access modifiers changed from: private */
    public void AB() {
        if (this.aFE.compareAndSet(false, true)) {
            Fu();
        }
    }

    private void Fu() {
        this.mSdk.BN();
        if (x.Fn()) {
            this.mSdk.BN().f("SessionTracker", "Application Paused");
        }
        this.aFG.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), (Map<String, Object>) null);
        if (!this.aFD.get()) {
            boolean booleanValue = ((Boolean) this.mSdk.a(b.aOl)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.mSdk.a(b.aOn)).longValue());
            if (this.aFI == null || System.currentTimeMillis() - this.aFI.getTime() >= millis) {
                this.mSdk.BF().trackEvent(m2.h.f0);
                if (booleanValue) {
                    this.aFI = new Date();
                }
            }
            if (!booleanValue) {
                this.aFI = new Date();
            }
        }
    }

    private void Fv() {
        this.mSdk.BN();
        if (x.Fn()) {
            this.mSdk.BN().f("SessionTracker", "Application Resumed");
        }
        this.aFH.set(System.currentTimeMillis());
        boolean booleanValue = ((Boolean) this.mSdk.a(b.aOl)).booleanValue();
        long longValue = ((Long) this.mSdk.a(b.aOm)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), (Map<String, Object>) null);
        if (!this.aFD.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.aFJ == null || System.currentTimeMillis() - this.aFJ.getTime() >= millis) {
                this.mSdk.BF().trackEvent("resumed");
                if (booleanValue) {
                    this.aFJ = new Date();
                }
            }
            if (!booleanValue) {
                this.aFJ = new Date();
            }
            this.mSdk.BR().a(f.aTe);
        }
    }
}
