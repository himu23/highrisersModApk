package com.applovin.impl.sdk.e;

import com.applovin.impl.b.e;
import com.applovin.impl.b.f;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.ironsource.i9;

class z extends d {
    /* access modifiers changed from: private */
    public final AppLovinAdLoadListener aTG;
    /* access modifiers changed from: private */
    public final e aUX;

    z(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskResolveVastWrapper", nVar);
        this.aTG = appLovinAdLoadListener;
        this.aUX = eVar;
    }

    public void run() {
        String a = m.a(this.aUX);
        if (StringUtils.isValidString(a)) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Resolving VAST ad with depth " + this.aUX.Mr() + " at " + a);
            }
            try {
                this.sdk.BO().b((d) new w<y>(c.D(this.sdk).cW(a).cX(i9.a).ad(y.aWz).gE(((Integer) this.sdk.a(b.aPx)).intValue()).gF(((Integer) this.sdk.a(b.aPy)).intValue()).aS(false).Ig(), this.sdk) {
                    /* renamed from: a */
                    public void d(y yVar, int i) {
                        this.sdk.BO().b((d) t.a(yVar, z.this.aUX, z.this.aTG, z.this.sdk));
                    }

                    public void a(int i, String str, y yVar) {
                        x xVar = this.logger;
                        if (x.Fn()) {
                            x xVar2 = this.logger;
                            String str2 = this.tag;
                            xVar2.i(str2, "Unable to resolve VAST wrapper. Server returned " + i);
                        }
                        z.this.gP(i);
                    }
                });
            } catch (Throwable th) {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.c(this.tag, "Unable to resolve VAST wrapper", th);
                }
                gP(-1);
            }
        } else {
            x xVar4 = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Resolving VAST failed. Could not find resolution URL");
            }
            gP(-1);
        }
    }

    /* access modifiers changed from: private */
    public void gP(int i) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.i(str, "Failed to resolve VAST wrapper due to error code " + i);
        }
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.aTG;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        m.a(this.aUX, this.aTG, i == -1001 ? f.TIMED_OUT : f.GENERAL_WRAPPER_ERROR, i, this.sdk);
    }
}
