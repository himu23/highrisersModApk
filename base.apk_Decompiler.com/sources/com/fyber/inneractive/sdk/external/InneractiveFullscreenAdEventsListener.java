package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.external.InneractiveUnitController;

public interface InneractiveFullscreenAdEventsListener extends InneractiveUnitController.EventsListener {
    void onAdClicked(InneractiveAdSpot inneractiveAdSpot);

    void onAdDismissed(InneractiveAdSpot inneractiveAdSpot);

    void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError);

    void onAdImpression(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot);

    void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot);
}
