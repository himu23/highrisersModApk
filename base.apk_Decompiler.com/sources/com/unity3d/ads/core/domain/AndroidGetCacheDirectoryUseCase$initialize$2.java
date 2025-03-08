package com.unity3d.ads.core.domain;

import android.os.Environment;
import com.unity3d.ads.core.data.model.CacheDirectory;
import com.unity3d.ads.core.data.model.CacheDirectoryType;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$initialize$2", f = "AndroidGetCacheDirectoryUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidGetCacheDirectoryUseCase.kt */
final class AndroidGetCacheDirectoryUseCase$initialize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AndroidGetCacheDirectoryUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidGetCacheDirectoryUseCase$initialize$2(AndroidGetCacheDirectoryUseCase androidGetCacheDirectoryUseCase, Continuation<? super AndroidGetCacheDirectoryUseCase$initialize$2> continuation) {
        super(2, continuation);
        this.this$0 = androidGetCacheDirectoryUseCase;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidGetCacheDirectoryUseCase$initialize$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidGetCacheDirectoryUseCase$initialize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File file;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isInitialized.setValue(Boxing.boxBoolean(true));
            if (Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState())) {
                try {
                    AndroidGetCacheDirectoryUseCase androidGetCacheDirectoryUseCase = this.this$0;
                    file = androidGetCacheDirectoryUseCase.createCacheDirectory(androidGetCacheDirectoryUseCase.context.getExternalCacheDir(), this.this$0.cacheDirName);
                } catch (Exception e) {
                    DeviceLog.exception("Creating external cache directory failed", e);
                    file = null;
                }
                if (this.this$0.testCacheDirectory(file)) {
                    this.this$0.createNoMediaFile(file);
                    DeviceLog.debug("Unity Ads is using external cache directory: " + file.getAbsolutePath());
                    this.this$0.cacheDirectory.complete(new CacheDirectory(file, CacheDirectoryType.EXTERNAL));
                    return Unit.INSTANCE;
                }
            }
            DeviceLog.debug("External media not mounted");
            File filesDir = this.this$0.context.getFilesDir();
            if (this.this$0.testCacheDirectory(filesDir)) {
                DeviceLog.debug("Unity Ads is using internal cache directory: " + filesDir.getAbsolutePath());
                CompletableDeferred access$getCacheDirectory$p = this.this$0.cacheDirectory;
                Intrinsics.checkNotNullExpressionValue(filesDir, "internalCache");
                access$getCacheDirectory$p.complete(new CacheDirectory(filesDir, CacheDirectoryType.INTERNAL));
                return Unit.INSTANCE;
            }
            DeviceLog.error("Unity Ads failed to initialize cache directory");
            this.this$0.cacheDirectory.complete(null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
