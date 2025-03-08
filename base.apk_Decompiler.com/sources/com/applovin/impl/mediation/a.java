package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;

public class a extends com.applovin.impl.sdk.utils.a {
    private boolean GL;
    private final com.applovin.impl.sdk.a akM;
    private final String akN = u.af(n.getApplicationContext());
    private C0065a akO;
    private c akP;
    private boolean akQ;
    private int akR;
    private final x logger;

    /* renamed from: com.applovin.impl.mediation.a$a  reason: collision with other inner class name */
    public interface C0065a {
        void a(c cVar);
    }

    public void ay(boolean z) {
        this.akQ = z;
    }

    a(n nVar) {
        this.logger = nVar.BN();
        this.akM = nVar.BM();
    }

    public void a(c cVar, C0065a aVar) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        }
        W();
        this.akO = aVar;
        this.akP = cVar;
        this.akM.a(this);
    }

    public void W() {
        if (x.Fn()) {
            this.logger.f("AdActivityObserver", "Cancelling...");
        }
        this.akM.b(this);
        this.akO = null;
        this.akP = null;
        this.akR = 0;
        this.GL = false;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!activity.getClass().getName().equals(this.akN) || (!this.akP.xY() && !this.akQ)) {
            if (!this.GL) {
                this.GL = true;
            }
            this.akR++;
            if (x.Fn()) {
                this.logger.f("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.akR);
                return;
            }
            return;
        }
        if (x.Fn()) {
            this.logger.f("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
        }
        if (this.akO != null) {
            if (x.Fn()) {
                this.logger.f("AdActivityObserver", "Invoking callback...");
            }
            this.akO.a(this.akP);
        }
        W();
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.GL) {
            this.akR--;
            if (x.Fn()) {
                this.logger.f("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.akR);
            }
            if (this.akR <= 0) {
                if (x.Fn()) {
                    this.logger.f("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.akO != null) {
                    if (x.Fn()) {
                        this.logger.f("AdActivityObserver", "Invoking callback...");
                    }
                    this.akO.a(this.akP);
                }
                W();
            }
        }
    }
}
