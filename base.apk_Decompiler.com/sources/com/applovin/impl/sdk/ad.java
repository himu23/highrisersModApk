package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.mediation.b.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class ad {
    private final Rect aFM = new Rect();
    private final Runnable aFN;
    private final WeakReference<View> aFO;
    private final long aFP;
    private WeakReference<ViewTreeObserver> aFQ = new WeakReference<>((Object) null);
    private WeakReference<View> aFR = new WeakReference<>((Object) null);
    private int aFS;
    private float aFT;
    private float aFU;
    private long aFV;
    private final Handler auW;
    private final ViewTreeObserver.OnPreDrawListener auZ;
    private final x logger;
    private final Object rT = new Object();
    private long startTimeMillis = Long.MIN_VALUE;

    public interface a {
        void onLogVisibilityImpression();
    }

    public ad(View view, n nVar, a aVar) {
        this.logger = nVar.BN();
        this.aFP = ((Long) nVar.a(b.aMD)).longValue();
        this.auW = new Handler(Looper.getMainLooper());
        this.aFO = new WeakReference<>(view);
        this.aFN = new ad$$ExternalSyntheticLambda0(this, new WeakReference(aVar));
        this.auZ = new ad$$ExternalSyntheticLambda1(this, view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(WeakReference weakReference) {
        View view = (View) this.aFO.get();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View view2 = (View) this.aFR.get();
        if (viewGroup != null && view2 != null) {
            if (b(viewGroup, view2)) {
                if (x.Fn()) {
                    this.logger.f("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                }
                Fw();
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.onLogVisibilityImpression();
                    return;
                }
                return;
            }
            yQ();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean h(View view) {
        yQ();
        w(view);
        return true;
    }

    public void b(e eVar) {
        View yl;
        if (eVar instanceof com.applovin.impl.mediation.b.b) {
            yl = eVar.getAdView();
        } else if (eVar instanceof d) {
            yl = ((d) eVar).yl();
        } else {
            return;
        }
        a(eVar.yt(), eVar.yu(), eVar.yv(), eVar.yx(), yl);
    }

    public void a(int i, float f, float f2, long j, View view) {
        synchronized (this.rT) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("VisibilityTracker", "Tracking visibility for " + view);
            }
            Fw();
            WeakReference<View> weakReference = new WeakReference<>(view);
            this.aFR = weakReference;
            this.aFS = i;
            this.aFT = f;
            this.aFU = f2;
            this.aFV = j;
            v((View) weakReference.get());
        }
    }

    public void Fw() {
        synchronized (this.rT) {
            this.auW.removeMessages(0);
            w((View) this.aFO.get());
            this.startTimeMillis = Long.MIN_VALUE;
            this.aFR.clear();
        }
    }

    private void v(View view) {
        View A = u.A((View) this.aFO.get());
        if (A == null) {
            A = u.A(view);
        }
        if (A != null) {
            ViewTreeObserver viewTreeObserver = A.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                this.aFQ = new WeakReference<>(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(this.auZ);
            } else if (x.Fn()) {
                this.logger.h("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            }
        } else if (x.Fn()) {
            this.logger.f("VisibilityTracker", "Unable to set view tree observer due to no root view.");
        }
    }

    private void yQ() {
        this.auW.postDelayed(this.aFN, this.aFP);
    }

    private boolean a(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.aFM)) {
            return false;
        }
        long pxToDp = (long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.aFM.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.aFM.height()));
        if (pxToDp < ((long) this.aFS)) {
            return false;
        }
        if ((((float) pxToDp) / ((float) ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))))) * 100.0f < this.aFT) {
            return false;
        }
        if ((((float) ((long) (this.aFM.width() * this.aFM.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f < this.aFU) {
            return false;
        }
        return true;
    }

    private boolean b(View view, View view2) {
        if (!a(view, view2)) {
            return false;
        }
        if (this.startTimeMillis == Long.MIN_VALUE) {
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
        if (SystemClock.uptimeMillis() - this.startTimeMillis >= this.aFV) {
            return true;
        }
        return false;
    }

    private void w(View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.aFQ.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.auZ);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.auZ);
            } else if (x.Fn()) {
                this.logger.f("VisibilityTracker", "Could not remove on pre-draw listener. View tree observer is not alive.");
            }
        } else if (x.Fn()) {
            this.logger.f("VisibilityTracker", "Could not remove on pre-draw listener. Root view is null.");
        }
        this.aFQ.clear();
    }
}
