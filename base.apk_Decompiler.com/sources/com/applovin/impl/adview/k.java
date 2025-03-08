package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private final Set<b> ahH = new HashSet();
    private final AtomicInteger ahI = new AtomicInteger();
    private final Handler jS;
    private final x logger;

    public interface a {
        void rB();

        boolean rC();
    }

    public k(Handler handler, n nVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (nVar != null) {
            this.jS = handler;
            this.logger = nVar.BN();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public void start() {
        HashSet<b> hashSet = new HashSet<>(this.ahH);
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int incrementAndGet = this.ahI.incrementAndGet();
        for (b bVar : hashSet) {
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("CountdownManager", "Starting countdown: " + bVar.getIdentifier() + " for generation " + incrementAndGet + "...");
            }
            a(bVar, incrementAndGet);
        }
    }

    public void rA() {
        if (x.Fn()) {
            this.logger.f("CountdownManager", "Removing all countdowns...");
        }
        W();
        this.ahH.clear();
    }

    public void W() {
        if (x.Fn()) {
            this.logger.f("CountdownManager", "Stopping countdowns...");
        }
        this.ahI.incrementAndGet();
        this.jS.removeCallbacksAndMessages((Object) null);
    }

    public void a(String str, long j, a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.jS != null) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("CountdownManager", "Adding countdown: " + str);
            }
            this.ahH.add(new b(str, j, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    private void a(b bVar, int i) {
        this.jS.postDelayed(new k$$ExternalSyntheticLambda0(this, bVar, i), bVar.rD());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(b bVar, int i) {
        a c = bVar.rE();
        if (c.rC()) {
            if (this.ahI.get() == i) {
                try {
                    c.rB();
                    a(bVar, i);
                } catch (Throwable th) {
                    if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.c("CountdownManager", "Encountered error on countdown step for: " + bVar.getIdentifier(), th);
                    }
                    rA();
                }
            } else if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("CountdownManager", "Killing duplicate countdown from previous generation: " + bVar.getIdentifier());
            }
        } else if (x.Fn()) {
            x xVar3 = this.logger;
            xVar3.f("CountdownManager", "Ending countdown for " + bVar.getIdentifier());
        }
    }

    private static class b {
        private final String ahJ;
        private final a ahK;
        private final long ahL;

        /* access modifiers changed from: private */
        public String getIdentifier() {
            return this.ahJ;
        }

        /* access modifiers changed from: private */
        public long rD() {
            return this.ahL;
        }

        /* access modifiers changed from: private */
        public a rE() {
            return this.ahK;
        }

        private b(String str, long j, a aVar) {
            this.ahJ = str;
            this.ahL = j;
            this.ahK = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            String str = this.ahJ;
            String str2 = ((b) obj).ahJ;
            if (str != null) {
                return str.equalsIgnoreCase(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.ahJ;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.ahJ + "', countdownStepMillis=" + this.ahL + '}';
        }
    }
}
