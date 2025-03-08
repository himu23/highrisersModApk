package com.applovin.exoplayer2.l;

import java.util.concurrent.ThreadFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ai$$ExternalSyntheticLambda3 implements ThreadFactory {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ai$$ExternalSyntheticLambda3(String str) {
        this.f$0 = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ai.a(this.f$0, runnable);
    }
}
