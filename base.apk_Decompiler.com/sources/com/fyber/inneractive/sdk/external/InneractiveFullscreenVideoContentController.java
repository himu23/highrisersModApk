package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.renderers.m;
import java.lang.ref.WeakReference;

public class InneractiveFullscreenVideoContentController extends g0 {
    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() instanceof f0;
    }

    public void setControlledRenderer(m mVar) {
        new WeakReference(mVar);
    }
}
