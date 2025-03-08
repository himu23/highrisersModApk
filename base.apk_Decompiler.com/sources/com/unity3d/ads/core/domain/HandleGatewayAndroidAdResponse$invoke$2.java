package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.WebViewAdPlayer;
import gateway.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleGatewayAndroidAdResponse.kt */
/* synthetic */ class HandleGatewayAndroidAdResponse$invoke$2 extends FunctionReferenceImpl implements Function2<AllowedPiiOuterClass.AllowedPii, Continuation<? super Unit>, Object>, SuspendFunction {
    HandleGatewayAndroidAdResponse$invoke$2(Object obj) {
        super(2, obj, WebViewAdPlayer.class, "onAllowedPiiChange", "onAllowedPiiChange(Lgateway/v1/AllowedPiiOuterClass$AllowedPii;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(AllowedPiiOuterClass.AllowedPii allowedPii, Continuation<? super Unit> continuation) {
        return ((WebViewAdPlayer) this.receiver).onAllowedPiiChange(allowedPii, continuation);
    }
}
