package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController;

public abstract class InneractiveAdViewEventsListenerAdapter implements InneractiveAdViewEventsListener {
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
    }
}
