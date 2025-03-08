package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
/* synthetic */ class AndroidFullscreenWebViewAdPlayer$show$2 extends AdaptedFunctionReference implements Function2<DisplayMessage, Continuation<? super Unit>, Object>, SuspendFunction {
    AndroidFullscreenWebViewAdPlayer$show$2(Object obj) {
        super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "displayEventsRouter", "displayEventsRouter(Lcom/unity3d/ads/adplayer/DisplayMessage;)Lkotlinx/coroutines/Job;", 12);
    }

    public final Object invoke(DisplayMessage displayMessage, Continuation<? super Unit> continuation) {
        return ((AndroidFullscreenWebViewAdPlayer) this.receiver).displayEventsRouter(displayMessage);
    }
}
