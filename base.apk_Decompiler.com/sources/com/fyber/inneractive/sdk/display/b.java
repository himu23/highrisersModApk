package com.fyber.inneractive.sdk.display;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.util.IAlog;

public class b extends a implements c.a {
    public InneractiveAdSpot a;
    public c b;

    public void a(Activity activity, InneractiveAdSpot inneractiveAdSpot, String str) {
        InneractiveAdSpot inneractiveAdSpot2;
        if (TextUtils.isEmpty(str) || (inneractiveAdSpot2 = InneractiveAdSpotManager.get().getSpot(str)) == null || inneractiveAdSpot2.getAdContent() == null) {
            inneractiveAdSpot2 = null;
        }
        this.a = inneractiveAdSpot2;
        if (inneractiveAdSpot2 != null) {
            InneractiveUnitController selectedUnitController = inneractiveAdSpot2.getSelectedUnitController();
            if (selectedUnitController instanceof InneractiveFullscreenAdActivity.FullScreenRendererProvider) {
                c fullscreenRenderer = ((InneractiveFullscreenAdActivity.FullScreenRendererProvider) selectedUnitController).getFullscreenRenderer();
                this.b = fullscreenRenderer;
                if (fullscreenRenderer != null) {
                    InneractiveAdSpot inneractiveAdSpot3 = this.a;
                    z zVar = (z) fullscreenRenderer;
                    zVar.a = inneractiveAdSpot3;
                    zVar.b = inneractiveAdSpot3.getAdContent();
                    zVar.c = inneractiveAdSpot3.getSelectedUnitController().getEventsListener();
                    zVar.v.a = inneractiveAdSpot3;
                    try {
                        this.b.a(this, activity);
                    } catch (InneractiveUnitController.AdDisplayError e) {
                        IAlog.e("Interstitial Activity: %s", e.getMessage());
                    } catch (Resources.NotFoundException e2) {
                        IAlog.e("Interstitial Activity: %s", e2.getMessage());
                    }
                }
            }
        }
    }

    public void destroy() {
    }

    public void disableCloseButton() {
    }

    public View getCloseButton() {
        return null;
    }

    public ViewGroup getLayout() {
        return null;
    }

    public boolean isCloseButtonDisplay() {
        return false;
    }

    public void secondEndCardWasDisplayed() {
    }

    public void setActivityOrientation(boolean z, Orientation orientation) {
    }

    public void showCloseButton(boolean z, int i, int i2) {
    }

    public void showCloseCountdown() {
    }

    public void updateCloseCountdown(int i) {
    }

    public boolean wasDismissedByUser() {
        return false;
    }

    public void dismissAd(boolean z) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.destroy();
            this.b = null;
        }
    }
}
