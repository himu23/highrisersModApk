package com.fyber.inneractive.sdk.external;

public interface InneractiveFullscreenAdEventsListenerWithImpressionData extends InneractiveFullscreenAdEventsListener {
    void onAdImpression(InneractiveAdSpot inneractiveAdSpot, ImpressionData impressionData);
}
