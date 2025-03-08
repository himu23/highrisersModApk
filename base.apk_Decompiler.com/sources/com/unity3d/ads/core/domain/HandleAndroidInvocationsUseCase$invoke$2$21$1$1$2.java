package com.unity3d.ads.core.domain;

import gateway.v1.AllowedPiiKt;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleAndroidInvocationsUseCase.kt */
/* synthetic */ class HandleAndroidInvocationsUseCase$invoke$2$21$1$1$2 extends MutablePropertyReference0Impl {
    HandleAndroidInvocationsUseCase$invoke$2$21$1$1$2(Object obj) {
        super(obj, AllowedPiiKt.Dsl.class, "idfa", "getIdfa()Z", 0);
    }

    public Object get() {
        return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getIdfa());
    }

    public void set(Object obj) {
        ((AllowedPiiKt.Dsl) this.receiver).setIdfa(((Boolean) obj).booleanValue());
    }
}
