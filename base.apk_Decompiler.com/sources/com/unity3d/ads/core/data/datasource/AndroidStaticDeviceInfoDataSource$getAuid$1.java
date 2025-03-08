package com.unity3d.ads.core.data.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource", f = "AndroidStaticDeviceInfoDataSource.kt", i = {}, l = {194}, m = "getAuid", n = {}, s = {})
/* compiled from: AndroidStaticDeviceInfoDataSource.kt */
final class AndroidStaticDeviceInfoDataSource$getAuid$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidStaticDeviceInfoDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidStaticDeviceInfoDataSource$getAuid$1(AndroidStaticDeviceInfoDataSource androidStaticDeviceInfoDataSource, Continuation<? super AndroidStaticDeviceInfoDataSource$getAuid$1> continuation) {
        super(continuation);
        this.this$0 = androidStaticDeviceInfoDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAuid(this);
    }
}
