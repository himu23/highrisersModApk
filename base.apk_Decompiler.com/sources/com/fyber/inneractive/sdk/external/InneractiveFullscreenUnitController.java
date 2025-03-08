package com.fyber.inneractive.sdk.external;

import android.app.Activity;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.display.b;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.factories.c;
import com.fyber.inneractive.sdk.flow.e0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.w;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;

public class InneractiveFullscreenUnitController extends e0<InneractiveFullscreenAdEventsListener> implements InneractiveFullscreenAdActivity.FullScreenRendererProvider, InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDestroyListener {
    public boolean a = false;
    public InneractiveFullScreenAdRewardedListener b;
    public final c.b c = new a();
    public c mRenderer;

    public static class AdExpiredError extends InneractiveUnitController.AdDisplayError {
        public AdExpiredError(String str) {
            super(str);
        }
    }

    public class a implements c.b {
        public a() {
        }

        public void a() {
            w wVar = (w) u.a(InneractiveFullscreenUnitController.this.mAdSpot);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = InneractiveFullscreenUnitController.this.b;
            if (inneractiveFullScreenAdRewardedListener != null && wVar != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(wVar);
            }
        }
    }

    public c getFullscreenRenderer() {
        return this.mRenderer;
    }

    public InneractiveFullScreenAdRewardedListener getRewardedListener() {
        return this.b;
    }

    public boolean isAvailable() {
        w wVar = (w) u.a(this.mAdSpot);
        return wVar != null && wVar.isReady();
    }

    public void onActivityDestroyed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.a = false;
    }

    public void setRewardedListener(InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener) {
        this.b = inneractiveFullScreenAdRewardedListener;
    }

    public void show(Activity activity) {
        com.fyber.inneractive.sdk.display.a aVar;
        if (activity == null) {
            IAlog.e("show() called with a null activity", new Object[0]);
        } else if (!this.a) {
            InneractiveAdSpot adSpot = getAdSpot();
            if (adSpot == null) {
                IAlog.e("InneractiveFullscreenUnitController was not attached to an ad spot", new Object[0]);
                return;
            }
            q adContent = adSpot.getAdContent();
            if (adContent != null) {
                new s.a(r.IA_PUBLISHER_REQUESTED_SHOW, adContent.a, adContent.d(), adContent.c.c()).a((String) null);
            }
            if (!adSpot.isReady()) {
                EL el = this.mEventsListener;
                if (el != null) {
                    ((InneractiveFullscreenAdEventsListener) el).onAdEnteredErrorState(adSpot, new AdExpiredError("Ad Expired"));
                    return;
                }
                return;
            }
            if (this.mRenderer == null) {
                this.mRenderer = c.b.a.a(getAdSpot());
            }
            selectContentController();
            if (adContent instanceof com.fyber.inneractive.sdk.dv.a) {
                aVar = new b();
            } else {
                aVar = new com.fyber.inneractive.sdk.display.c();
            }
            aVar.a(activity, adSpot, adSpot.getLocalUniqueId());
            this.a = true;
            com.fyber.inneractive.sdk.interfaces.c cVar = this.mRenderer;
            if (cVar != null) {
                cVar.a(this.c);
            }
        } else {
            IAlog.e("InneractiveFullscreenUnitController->show(android.content.Context) called while an ad is already showing", new Object[0]);
        }
    }

    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        a0 a0Var = (a0) inneractiveAdSpot.getAdContent().d;
        if (a0Var.e != null) {
            return false;
        }
        t tVar = a0Var.c;
        if (tVar != null && UnitDisplayType.INTERSTITIAL.equals(tVar.b)) {
            return true;
        }
        c0 c0Var = a0Var.f;
        if (c0Var == null || (!UnitDisplayType.REWARDED.equals(c0Var.j) && !UnitDisplayType.INTERSTITIAL.equals(c0Var.j) && !UnitDisplayType.VERTICAL.equals(c0Var.j))) {
            return false;
        }
        return true;
    }

    public boolean supportsRefresh() {
        return false;
    }

    public void destroy() {
        com.fyber.inneractive.sdk.interfaces.c cVar = this.mRenderer;
        if (cVar != null) {
            cVar.destroy();
            this.mRenderer = null;
        }
        super.destroy();
    }
}
