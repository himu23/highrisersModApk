package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.core.data.model.CacheDirectory;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u0011\u0010\u0018\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bHBø\u0001\u0000¢\u0006\u0002\u0010\u0019J#\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\b\u0003\u0010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetCacheDirectoryUseCase;", "Lcom/unity3d/ads/core/domain/GetCacheDirectoryUseCase;", "context", "Landroid/content/Context;", "cacheDirName", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "cacheDirectory", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/unity3d/ads/core/data/model/CacheDirectory;", "isInitialized", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "createCacheDirectory", "Ljava/io/File;", "baseDir", "newDir", "createNoMediaFile", "", "path", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "testCacheDirectory", "directory", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidGetCacheDirectoryUseCase.kt */
public final class AndroidGetCacheDirectoryUseCase implements GetCacheDirectoryUseCase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    /* access modifiers changed from: private */
    public final String cacheDirName;
    /* access modifiers changed from: private */
    public final CompletableDeferred<CacheDirectory> cacheDirectory = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> isInitialized = StateFlowKt.MutableStateFlow(false);
    private final CoroutineScope scope;

    public AndroidGetCacheDirectoryUseCase(Context context2, String str, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "cacheDirName");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.context = context2;
        this.cacheDirName = str;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(coroutineDispatcher), new CoroutineName("AndroidGetCacheDirectoryUseCase"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:21:0x0065, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.unity3d.ads.core.data.model.CacheDirectory> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$invoke$1 r0 = (com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$invoke$1 r0 = new com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase$invoke$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase r2 = (com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005a
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r6 = r5.isInitialized
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0059
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.initialize(r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            kotlinx.coroutines.CompletableDeferred<com.unity3d.ads.core.data.model.CacheDirectory> r6 = r2.cacheDirectory
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.await(r0)
            if (r6 != r1) goto L_0x0068
            return r1
        L_0x0068:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidGetCacheDirectoryUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object initialize(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.scope.getCoroutineContext(), new AndroidGetCacheDirectoryUseCase$initialize$2(this, (Continuation<? super AndroidGetCacheDirectoryUseCase$initialize$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final File createCacheDirectory(File file, String str) {
        if (file != null) {
            File file2 = new File(file, str);
            file2.mkdirs();
            if (!file2.isDirectory()) {
                file2 = null;
            }
            if (file2 != null) {
                return file2;
            }
            throw new Exception("Could not create cache directory");
        }
        throw new IllegalArgumentException("Base directory is null".toString());
    }

    /* access modifiers changed from: private */
    public final boolean testCacheDirectory(File file) {
        if (file != null && file.isDirectory()) {
            try {
                File file2 = new File(file, TEST_FILE_NAME);
                FilesKt.writeText$default(file2, "test", (Charset) null, 2, (Object) null);
                if (!Intrinsics.areEqual((Object) FilesKt.readText$default(file2, (Charset) null, 1, (Object) null), (Object) "test")) {
                    DeviceLog.debug("Read content mismatch");
                    return false;
                } else if (file2.delete()) {
                    return true;
                } else {
                    DeviceLog.debug("Failed to delete test file " + file2.getAbsoluteFile());
                    return false;
                }
            } catch (Exception e) {
                DeviceLog.debug("Unity Ads exception while testing cache directory " + file.getAbsolutePath() + ": " + e.getMessage());
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void createNoMediaFile(File file) {
        try {
            if (new File(file, ".nomedia").createNewFile()) {
                DeviceLog.debug("Successfully created .nomedia file");
            } else {
                DeviceLog.debug("Using existing .nomedia file");
            }
        } catch (Exception e) {
            DeviceLog.exception("Failed to create .nomedia file", e);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetCacheDirectoryUseCase$Companion;", "", "()V", "TEST_FILE_NAME", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidGetCacheDirectoryUseCase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
