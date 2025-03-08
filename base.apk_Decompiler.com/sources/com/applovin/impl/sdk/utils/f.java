package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.n;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f implements AppLovinBroadcastManager.Receiver {
    private static final Set<f> aVB = new HashSet();
    private final r ayU;
    private final n sdk;

    public static f a(long j, n nVar, Runnable runnable) {
        return new f(j, nVar, runnable);
    }

    private f(long j, n nVar, Runnable runnable) {
        this.ayU = r.b(j, nVar, new f$$ExternalSyntheticLambda0(this, runnable));
        this.sdk = nVar;
        aVB.add(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Runnable runnable) {
        tT();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void tT() {
        this.ayU.tT();
        AppLovinBroadcastManager.unregisterReceiver(this);
        aVB.remove(this);
    }

    public long AH() {
        return this.ayU.AH();
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.ayU.pause();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.ayU.resume();
        }
    }
}
