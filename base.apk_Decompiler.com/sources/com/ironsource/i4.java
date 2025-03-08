package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class i4 {
    public static final int e = -1;
    private Runnable a = new a();
    private int b;
    /* access modifiers changed from: private */
    public i c;
    private p8 d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            IronLog.INTERNAL.verbose("loaded ads are expired");
            if (i4.this.c != null) {
                i4.this.c.b();
            }
        }
    }

    public i4(int i, i iVar) {
        this.c = iVar;
        this.b = i;
    }

    public void a() {
        if (b() && this.d != null) {
            IronLog.INTERNAL.verbose("canceling expiration timer");
            this.d.e();
            this.d = null;
        }
    }

    public void a(long j) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis((long) this.b) - Math.max(j, 0);
            if (millis > 0) {
                a();
                this.d = new p8(millis, this.a, true);
                Calendar instance = Calendar.getInstance();
                instance.add(14, (int) millis);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("loaded ads will expire on: " + instance.getTime() + " in " + String.format("%.2f", new Object[]{Double.valueOf((((double) millis) / 1000.0d) / 60.0d)}) + " minutes");
                return;
            }
            IronLog.INTERNAL.verbose("no delay - onAdExpired called");
            this.c.b();
        }
    }

    public boolean b() {
        return this.b > 0;
    }
}
