package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController.EventsListener;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;

public abstract class x<EventsListenerT extends InneractiveContentController.EventsListener> implements InneractiveContentController<EventsListenerT> {
    public WeakReference<InneractiveAdSpot> mAdSpot;
    public EventsListenerT mEventsListener;

    public abstract boolean canControl(InneractiveAdSpot inneractiveAdSpot);

    public void destroy() {
        this.mEventsListener = null;
        this.mAdSpot = null;
    }

    public InneractiveAdSpot getAdSpot() {
        return (InneractiveAdSpot) u.a(this.mAdSpot);
    }

    public EventsListenerT getEventsListener() {
        return this.mEventsListener;
    }

    public void setAdSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.mAdSpot = new WeakReference<>(inneractiveAdSpot);
    }

    public void setEventsListener(EventsListenerT eventslistenert) {
        this.mEventsListener = eventslistenert;
    }
}
