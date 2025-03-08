package com.applovin.impl.sdk;

import android.os.Process;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.ironsource.m2;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final AppLovinExceptionHandler azQ = new AppLovinExceptionHandler();
    private final AtomicBoolean ams = new AtomicBoolean();
    private final Set<n> azR = new HashSet(2);
    private Thread.UncaughtExceptionHandler azS;

    public static AppLovinExceptionHandler shared() {
        return azQ;
    }

    public void enable() {
        if (this.ams.compareAndSet(false, true)) {
            this.azS = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void addSdk(n nVar) {
        this.azR.add(nVar);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        long j = 500;
        for (n next : this.azR) {
            if (!next.Bq()) {
                next.BN();
                if (x.Fn()) {
                    next.BN().f("AppLovinExceptionHandler", "Detected unhandled exception");
                }
                next.Cs().a(r.a.CRASH, (Map<String, String>) CollectionUtils.map("top_main_method", th.toString()));
                next.BF().trackEventSynchronously(m2.h.f0);
                j = ((Long) next.a(b.aOg)).longValue();
            }
        }
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.azS;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
