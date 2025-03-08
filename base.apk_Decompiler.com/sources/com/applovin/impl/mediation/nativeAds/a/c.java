package com.applovin.impl.mediation.nativeAds.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class c {
    private final WeakHashMap<View, Integer> auU = new WeakHashMap<>();
    private final Object auV = new Object();
    private final Handler auW = new Handler();
    private boolean auX = false;
    private final WeakReference<View> auY;
    private final ViewTreeObserver.OnPreDrawListener auZ;
    private a ava;

    public interface a {
        void S(int i, int i2);
    }

    public void a(a aVar) {
        this.ava = aVar;
    }

    public c(View view) {
        this.auY = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            c$$ExternalSyntheticLambda0 c__externalsyntheticlambda0 = new c$$ExternalSyntheticLambda0(this);
            this.auZ = c__externalsyntheticlambda0;
            viewTreeObserver.addOnPreDrawListener(c__externalsyntheticlambda0);
            return;
        }
        this.auZ = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean yS() {
        yQ();
        return true;
    }

    public void destroy() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.ava = null;
        View view = (View) this.auY.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.auZ) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.auY.clear();
        }
    }

    public void a(View view, int i) {
        synchronized (this.auV) {
            this.auU.put(view, Integer.valueOf(i));
            yQ();
        }
    }

    public void k(View view) {
        synchronized (this.auV) {
            this.auU.remove(view);
        }
    }

    private void yQ() {
        if (!this.auX) {
            this.auX = true;
            this.auW.postDelayed(new c$$ExternalSyntheticLambda1(this), 100);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yR() {
        synchronized (this.auV) {
            this.auX = false;
            int i = -1;
            int i2 = -1;
            for (Map.Entry next : this.auU.entrySet()) {
                if (t((View) next.getKey())) {
                    Integer num = (Integer) next.getValue();
                    if (i == -1 && i2 == -1) {
                        i = num.intValue();
                        i2 = num.intValue();
                    } else {
                        i = Math.min(i, ((Integer) next.getValue()).intValue());
                        i2 = Math.max(i2, ((Integer) next.getValue()).intValue());
                    }
                }
            }
            a aVar = this.ava;
            if (aVar != null) {
                aVar.S(i, i2);
            }
        }
    }

    private boolean t(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }
}
