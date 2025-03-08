package com.applovin.impl.sdk.c;

import android.content.SharedPreferences;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class e$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SharedPreferences.Editor f$0;

    public /* synthetic */ e$$ExternalSyntheticLambda0(SharedPreferences.Editor editor) {
        this.f$0 = editor;
    }

    public final void run() {
        this.f$0.commit();
    }
}
