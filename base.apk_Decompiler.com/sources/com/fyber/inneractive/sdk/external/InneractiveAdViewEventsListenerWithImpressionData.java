package com.fyber.inneractive.sdk.external;

public interface InneractiveAdViewEventsListenerWithImpressionData extends InneractiveAdViewEventsListener {
    void onAdImpression(InneractiveAdSpot inneractiveAdSpot, ImpressionData impressionData);
}
