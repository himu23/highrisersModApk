package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.oa;
import com.ironsource.u5;
import java.util.HashMap;
import java.util.Map;

public class n {
    private static final n f = new n();
    private final Map<String, Long> a = new HashMap();
    /* access modifiers changed from: private */
    public final Map<String, Boolean> b = new HashMap();
    private int c;
    private int d;
    private int e;

    class a implements Runnable {
        final /* synthetic */ IronSource.AD_UNIT a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;

        a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, boolean z, String str) {
            this.a = ad_unit;
            this.b = ironSourceError;
            this.c = z;
            this.d = str;
        }

        public void run() {
            IronLog.INTERNAL.verbose("onAdLoadFailed - invokeCallback after delaying");
            n.this.a(this.a, this.b, this.c);
            n.this.b.put(this.d, Boolean.FALSE);
        }
    }

    private n() {
    }

    private int a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.d;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.c;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.e;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 0;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = f;
        }
        return nVar;
    }

    /* access modifiers changed from: private */
    public void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, boolean z) {
        this.a.put(ad_unit.toString(), Long.valueOf(System.currentTimeMillis()));
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            oa.a().a(ironSourceError);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            u5.a().a(ironSourceError);
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            f1.a().a(ironSourceError, z);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + ad_unit);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, int i) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.d = i;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.c = i;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.e = i;
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + ad_unit);
        }
    }

    public synchronized void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        b(ad_unit, ironSourceError, false);
    }

    public synchronized void b(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, boolean z) {
        if (!b(ad_unit)) {
            String ad_unit2 = ad_unit.toString();
            if (!this.a.containsKey(ad_unit2)) {
                a(ad_unit, ironSourceError, z);
                return;
            }
            long a2 = ((long) a(ad_unit)) * 1000;
            long currentTimeMillis = System.currentTimeMillis() - this.a.get(ad_unit2).longValue();
            if (currentTimeMillis > a2) {
                a(ad_unit, ironSourceError, z);
                return;
            }
            this.b.put(ad_unit2, Boolean.TRUE);
            long j = a2 - currentTimeMillis;
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("delaying callback by " + j);
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(ad_unit, ironSourceError, z, ad_unit2), j);
        }
    }

    public synchronized boolean b(IronSource.AD_UNIT ad_unit) {
        if (!this.b.containsKey(ad_unit.toString())) {
            return false;
        }
        return this.b.get(ad_unit.toString()).booleanValue();
    }
}
