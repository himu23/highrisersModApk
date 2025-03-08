package com.applovin.impl.sdk.utils;

import android.content.Context;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class u$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ WeakReference f$0;
    public final /* synthetic */ e f$1;
    public final /* synthetic */ n f$2;
    public final /* synthetic */ Context f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ u$$ExternalSyntheticLambda2(WeakReference weakReference, e eVar, n nVar, Context context, boolean z) {
        this.f$0 = weakReference;
        this.f$1 = eVar;
        this.f$2 = nVar;
        this.f$3 = context;
        this.f$4 = z;
    }

    public final void run() {
        u.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
