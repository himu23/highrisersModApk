package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.n;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class w {
    private static final Set<w> aVB = new HashSet();
    private final Timer aWf;
    /* access modifiers changed from: private */
    public final boolean aWw;
    private final Object ayX = new Object();
    /* access modifiers changed from: private */
    public final n sdk;
    private Runnable v;

    public static w a(long j, boolean z, n nVar, Runnable runnable) {
        return new w(j, z, nVar, runnable);
    }

    private w(long j, boolean z, n nVar, Runnable runnable) {
        Timer timer = new Timer();
        this.aWf = timer;
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j);
        } else if (nVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        } else if (runnable != null) {
            this.aWw = z;
            this.sdk = nVar;
            this.v = runnable;
            aVB.add(this);
            timer.schedule(Lt(), j);
        } else {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
    }

    public void tT() {
        synchronized (this.ayX) {
            this.aWf.cancel();
            this.v = null;
            aVB.remove(this);
        }
    }

    private TimerTask Lt() {
        return new TimerTask() {
            public void run() {
                if (!w.this.sdk.Ce().isApplicationPaused() || w.this.aWw) {
                    w.this.LH();
                } else {
                    AppLovinBroadcastManager.registerReceiver(new AppLovinBroadcastManager.Receiver() {
                        public void onReceive(Intent intent, Map<String, Object> map) {
                            AppLovinBroadcastManager.unregisterReceiver(this);
                            w.this.LH();
                        }
                    }, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void LH() {
        Runnable runnable = this.v;
        if (runnable != null) {
            runnable.run();
            tT();
        }
    }
}
