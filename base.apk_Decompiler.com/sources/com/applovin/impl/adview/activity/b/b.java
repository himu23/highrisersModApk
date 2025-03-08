package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.f;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends a {
    private final com.applovin.impl.adview.activity.a.b ajm = new com.applovin.impl.adview.activity.a.b(this.aiL, this.ahM, this.sdk);
    private f ajn;
    private long ajo;
    private final AtomicBoolean ajp = new AtomicBoolean();

    public void bE(long j) {
    }

    public void pauseVideo() {
    }

    /* access modifiers changed from: protected */
    public boolean sJ() {
        return false;
    }

    public void sR() {
    }

    public void sS() {
    }

    public b(e eVar, Activity activity, Map<String, Object> map, n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        if (u.a(com.applovin.impl.sdk.c.b.aMb, nVar)) {
            checkCachedAdResourcesAsync(false);
        }
    }

    public void sA() {
        a((ViewGroup) null);
    }

    public void a(ViewGroup viewGroup) {
        this.ajm.a(this.aiR, this.agn, this.aiQ, viewGroup);
        if (!u.a(com.applovin.impl.sdk.c.b.aMb, this.sdk)) {
            checkCachedAdResourcesImmediately(false);
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.aiQ.renderAd(this.aiL);
        d("javascript:al_onPoststitialShow();", (long) this.aiL.GI());
        if (sK()) {
            long sU = sU();
            this.ajo = sU;
            if (sU > 0) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    xVar2.f("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.ajo + "ms...");
                }
                this.ajn = f.a(this.ajo, this.sdk, new b$$ExternalSyntheticLambda0(this));
            }
        }
        if (this.aiR != null) {
            if (this.aiL.Ge() >= 0) {
                a(this.aiR, this.aiL.Ge(), new b$$ExternalSyntheticLambda1(this));
            } else {
                this.aiR.setVisibility(0);
            }
        }
        sL();
        this.sdk.BO().a((d) new ab(this.sdk, "updateMainViewOM", new b$$ExternalSyntheticLambda2(this)), q.b.MAIN, TimeUnit.SECONDS.toMillis(1));
        sM();
        super.au(u.P(this.sdk));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sX() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.ajp.set(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sW() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sV() {
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
    }

    public void dismiss() {
        sD();
        f fVar = this.ajn;
        if (fVar != null) {
            fVar.tT();
            this.ajn = null;
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public boolean sI() {
        if (sK()) {
            return this.ajp.get();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void sD() {
        f fVar;
        boolean sI = sI();
        int i = 100;
        if (sK()) {
            if (!sI && (fVar = this.ajn) != null) {
                i = (int) Math.min(100.0d, (((double) (this.ajo - fVar.AH())) / ((double) this.ajo)) * 100.0d);
            }
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("AppLovinFullscreenActivity", "Ad engaged at " + i + "%");
            }
        }
        super.a(i, false, sI, -2);
    }

    /* access modifiers changed from: protected */
    public void sL() {
        long j;
        long j2 = 0;
        if (this.aiL.GT() >= 0 || this.aiL.GU() >= 0) {
            if (this.aiL.GT() >= 0) {
                j = this.aiL.GT();
            } else {
                if (this.aiL.GV()) {
                    int FM = (int) ((a) this.aiL).FM();
                    if (FM > 0) {
                        j2 = TimeUnit.SECONDS.toMillis((long) FM);
                    } else {
                        int Ge = (int) this.aiL.Ge();
                        if (Ge > 0) {
                            j2 = TimeUnit.SECONDS.toMillis((long) Ge);
                        }
                    }
                }
                j = (long) (((double) j2) * (((double) this.aiL.GU()) / 100.0d));
            }
            bF(j);
        }
    }

    public void sN() {
        super.sN();
        sT();
    }

    public void rl() {
        super.rl();
        sT();
    }

    private void sT() {
        this.ajm.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
        this.ajp.set(true);
    }

    private long sU() {
        if (!(this.aiL instanceof a)) {
            return 0;
        }
        float FM = ((a) this.aiL).FM();
        if (FM <= 0.0f) {
            FM = (float) this.aiL.Ge();
        }
        return (long) (((double) u.C(FM)) * (((double) this.aiL.GF()) / 100.0d));
    }
}
