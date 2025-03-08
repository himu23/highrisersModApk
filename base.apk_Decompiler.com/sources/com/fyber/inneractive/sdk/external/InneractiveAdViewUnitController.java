package com.fyber.inneractive.sdk.external;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.factories.a;
import com.fyber.inneractive.sdk.factories.c;
import com.fyber.inneractive.sdk.flow.c0;
import com.fyber.inneractive.sdk.flow.e0;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.flow.w;
import com.fyber.inneractive.sdk.interfaces.b;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InneractiveAdViewUnitController extends e0<InneractiveAdViewEventsListener> implements t.c, InneractiveFullscreenAdActivity.FullScreenRendererProvider {
    public static final int DISABLED_REFRESH_INTERVAL = -1;
    public Set<InneractiveAdRenderer> a;
    public boolean b;
    public View c;
    public int d;
    public int mAdContentHeight;
    public int mAdContentWidth;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            InneractiveAdViewUnitController.this.a();
        }
    }

    public InneractiveAdViewUnitController() {
        this.b = false;
        this.mAdContentWidth = -1;
        this.mAdContentHeight = -1;
        this.d = 0;
        this.a = new HashSet();
    }

    public void bindView(ViewGroup viewGroup) {
        b bVar;
        IAlog.a("%sPPPP bindView called with parent: %s", logPrefix(), viewGroup);
        InneractiveAdSpot adSpot = getAdSpot();
        if (adSpot == null) {
            IAlog.e("InneractiveFullscreenUnitController was not attached to an ad spot", new Object[0]);
            return;
        }
        IAlog.a("%sPPPP bindView spot is %s", logPrefix(), adSpot);
        Iterator it = new HashSet(this.a).iterator();
        while (it.hasNext()) {
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof b) {
                b bVar2 = (b) inneractiveAdRenderer;
                if (bVar2.a((View) viewGroup)) {
                    bVar2.n();
                    IAlog.a("%sPPPP bindAdToRenderer returning an already attached renderer %s", logPrefix(), bVar2);
                    return;
                }
            }
        }
        this.c = viewGroup;
        Iterator<a.C0095a> it2 = a.b.a.a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                bVar = null;
                break;
            }
            a.C0095a next = it2.next();
            if (next.a(adSpot)) {
                bVar = next.b(adSpot);
                break;
            }
        }
        int i = this.d;
        if (i != 0) {
            bVar.a(i);
        }
        if (bVar != null) {
            bVar.initialize(adSpot);
            selectContentController();
            bVar.a(viewGroup);
            this.a.add(bVar);
            IAlog.a("%sPPPP bindView created renderer %s", logPrefix(), bVar);
            return;
        }
        IAlog.e("%sCould not find a renderer for the given spot! Did you add the appropriate module to your project?", logPrefix());
    }

    public boolean canRefreshAd() {
        if (!supportsRefresh()) {
            return false;
        }
        for (InneractiveAdRenderer canRefreshAd : this.a) {
            if (!canRefreshAd.canRefreshAd()) {
                return false;
            }
        }
        return true;
    }

    public void destroy() {
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            q.b.post(new a());
        } else {
            a();
        }
    }

    public int getAdContentHeight() {
        int p;
        for (InneractiveAdRenderer next : this.a) {
            if ((next instanceof b) && (p = ((b) next).p()) > 0) {
                return p;
            }
        }
        return this.mAdContentHeight;
    }

    public int getAdContentWidth() {
        int f;
        for (InneractiveAdRenderer next : this.a) {
            if ((next instanceof b) && (f = ((b) next).f()) > 0) {
                return f;
            }
        }
        return this.mAdContentWidth;
    }

    public c getFullscreenRenderer() {
        c a2 = c.b.a.a((InneractiveAdSpot) u.a(this.mAdSpot));
        this.a.add(a2);
        return a2;
    }

    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    public void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        Iterator it = new HashSet(this.a).iterator();
        while (it.hasNext()) {
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof b) {
                ((b) inneractiveAdRenderer).r();
                return;
            }
        }
    }

    public void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot) {
        b bVar;
        Iterator it = new HashSet(this.a).iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof b) {
                bVar = (b) inneractiveAdRenderer;
                if (bVar.a(inneractiveAdSpot.getAdContent())) {
                    break;
                }
            }
        }
        if (bVar != null) {
            bVar.a((ViewGroup) null);
        } else {
            onAdRefreshFailed(inneractiveAdSpot, InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
        try {
            if (inneractiveAdSpot instanceof t) {
                int i = IAlog.a;
                IAlog.a(1, (Exception) null, "%s %s", "AD_REFRESH", ((t) inneractiveAdSpot).h.d.b());
            }
        } catch (Exception unused) {
        }
        IAlog.a("InneractiveFullscreenUnitController onAdRefreshed called", new Object[0]);
    }

    public void refreshAd() {
        IAlog.a("InneractiveFullscreenUnitController refreshAd called", new Object[0]);
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) u.a(this.mAdSpot);
        if (inneractiveAdSpot != null && (inneractiveAdSpot instanceof c0)) {
            ((c0) inneractiveAdSpot).a(this);
        }
    }

    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        a0 a0Var = (a0) inneractiveAdSpot.getAdContent().d;
        if (a0Var.e != null) {
            return false;
        }
        com.fyber.inneractive.sdk.config.t tVar = a0Var.c;
        if (tVar != null) {
            if (UnitDisplayType.BANNER.equals(tVar.b) || UnitDisplayType.MRECT.equals(tVar.b)) {
                return true;
            }
            if (UnitDisplayType.INTERSTITIAL.equals(tVar.b)) {
                return !inneractiveAdSpot.getCurrentProcessedRequest().getAllowFullscreen();
            }
        }
        com.fyber.inneractive.sdk.config.c0 c0Var = a0Var.f;
        if (c0Var == null || (!UnitDisplayType.LANDSCAPE.equals(c0Var.j) && !UnitDisplayType.SQUARE.equals(c0Var.j) && !UnitDisplayType.MRECT.equals(c0Var.j))) {
            return false;
        }
        return true;
    }

    public boolean supportsRefresh() {
        return true;
    }

    public void unbindFullscreenRenderer(com.fyber.inneractive.sdk.interfaces.c cVar) {
        WeakReference<w> weakReference;
        IAlog.a("%sremoving full screen ad renderer %s", logPrefix(), cVar);
        Set<InneractiveAdRenderer> set = this.a;
        if (set != null) {
            set.remove(cVar);
        }
        if (!this.b) {
            Iterator it = new HashSet(this.a).iterator();
            while (it.hasNext()) {
                InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
                if (inneractiveAdRenderer instanceof b) {
                    ((b) inneractiveAdRenderer).a();
                    if (!(this.mEventsListener == null || (weakReference = this.mAdSpot) == null || weakReference.get() == null)) {
                        ((InneractiveAdViewEventsListener) this.mEventsListener).onAdCollapsed((InneractiveAdSpot) this.mAdSpot.get());
                    }
                }
            }
        }
    }

    public final void a() {
        this.b = true;
        Iterator it = new HashSet(this.a).iterator();
        while (it.hasNext()) {
            ((InneractiveAdRenderer) it.next()).destroy();
        }
        this.a.clear();
        this.c = null;
        super.destroy();
    }

    public void unbindView(View view) {
        if (this.c != view) {
            IAlog.e("%s unbindView invoked with incorrect view, was - %s received - %s", logPrefix(), this.c, view);
        } else {
            this.c = null;
        }
        IAlog.a("%sPPPP unbindView called with %s", logPrefix(), view);
        IAlog.a("%sPPPP spot is %s", logPrefix(), this.mAdSpot);
        Iterator it = new HashSet(this.a).iterator();
        while (it.hasNext()) {
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof b) {
                b bVar = (b) inneractiveAdRenderer;
                if (bVar.a(view)) {
                    IAlog.a("%sPPPP unbindView unbinding renderer %s", logPrefix(), inneractiveAdRenderer);
                    bVar.u();
                    this.a.remove(bVar);
                    return;
                }
            }
        }
    }

    public InneractiveAdViewUnitController(int i) {
        this();
        if (i >= 30) {
            IAlog.a("InneractiveAdViewUnitController: Overriding remote config refresh interval to: %d", Integer.valueOf(i));
            this.d = i;
            return;
        }
        IAlog.a("InneractiveAdViewUnitController: Overriding remote config refresh interval - value too low. Setting to default: %d -> %d", Integer.valueOf(i), 30);
        this.d = 30;
    }

    public InneractiveAdViewUnitController(boolean z) {
        this();
        if (z) {
            this.d = -1;
        }
    }
}
