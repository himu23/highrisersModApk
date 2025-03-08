package com.applovin.impl.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class a$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ a f$0;
    public final /* synthetic */ FrameLayout f$1;
    public final /* synthetic */ View f$2;
    public final /* synthetic */ ViewTreeObserver f$3;
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f$4;

    public /* synthetic */ a$$ExternalSyntheticLambda4(a aVar, FrameLayout frameLayout, View view, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f$0 = aVar;
        this.f$1 = frameLayout;
        this.f$2 = view;
        this.f$3 = viewTreeObserver;
        this.f$4 = onGlobalLayoutListener;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
