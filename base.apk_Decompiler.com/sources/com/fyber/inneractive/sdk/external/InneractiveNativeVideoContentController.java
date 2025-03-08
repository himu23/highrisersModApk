package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;

public class InneractiveNativeVideoContentController extends g0 {
    public WeakReference<Renderer> a;

    public interface Renderer {
        void pauseVideo();

        void playVideo();
    }

    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent().isVideoAd();
    }

    public void pauseVideo() {
        if (((Renderer) u.a(this.a)) != null) {
            ((Renderer) this.a.get()).pauseVideo();
        }
    }

    public void playVideo() {
        Renderer renderer = (Renderer) u.a(this.a);
        if (renderer != null) {
            renderer.playVideo();
        }
    }

    public void setControlledRenderer(Renderer renderer) {
        this.a = new WeakReference<>(renderer);
    }
}
