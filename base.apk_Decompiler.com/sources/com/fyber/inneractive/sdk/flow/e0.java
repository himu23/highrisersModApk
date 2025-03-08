package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public abstract class e0<EL extends InneractiveUnitController.EventsListener> implements InneractiveUnitController<EL> {
    public WeakReference<w> mAdSpot;
    public Set<InneractiveContentController> mContentControllers = new HashSet();
    public EL mEventsListener;
    public InneractiveContentController mSelectedContentController;

    public void addContentController(InneractiveContentController inneractiveContentController) {
        this.mContentControllers.add(inneractiveContentController);
    }

    public boolean canRefreshAd() {
        return supportsRefresh();
    }

    public void destroy() {
        for (InneractiveContentController destroy : this.mContentControllers) {
            destroy.destroy();
        }
        this.mContentControllers.clear();
        this.mSelectedContentController = null;
        this.mAdSpot = null;
    }

    public InneractiveAdSpot getAdSpot() {
        return (w) u.a(this.mAdSpot);
    }

    public EL getEventsListener() {
        return this.mEventsListener;
    }

    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    public String logPrefix() {
        return IAlog.a((Object) this);
    }

    public void selectContentController() {
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) u.a(this.mAdSpot);
        if (inneractiveAdSpot == null) {
            IAlog.e("selectContentController called, but ad spot is null", new Object[0]);
            return;
        }
        for (InneractiveContentController next : this.mContentControllers) {
            x xVar = (x) next;
            if (xVar.canControl(inneractiveAdSpot)) {
                this.mSelectedContentController = next;
                xVar.setAdSpot(inneractiveAdSpot);
            }
        }
    }

    public void setAdSpot(w wVar) {
        this.mAdSpot = new WeakReference<>(wVar);
    }

    public void setEventsListener(EL el) {
        this.mEventsListener = el;
    }

    public abstract boolean supports(InneractiveAdSpot inneractiveAdSpot);

    public abstract boolean supportsRefresh();
}
