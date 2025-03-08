package com.unity3d.services.core.di;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.CronetClient;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$buildNetworkClient$2$1<TResult> implements OnCompleteListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ CancellableContinuation<HttpClient> $continuation;
    final /* synthetic */ ISDKDispatchers $dispatchers;

    ServiceProvider$buildNetworkClient$2$1(Context context, CancellableContinuation<? super HttpClient> cancellableContinuation, ISDKDispatchers iSDKDispatchers) {
        this.$context = context;
        this.$continuation = cancellableContinuation;
        this.$dispatchers = iSDKDispatchers;
    }

    public final void onComplete(Task<Void> task) {
        Intrinsics.checkNotNullParameter(task, "it");
        if (task.isSuccessful()) {
            CronetEngine build = new CronetEngine.Builder(this.$context).setStoragePath(this.$context.getFilesDir().getAbsolutePath()).enableHttpCache(3, ServiceProvider.HTTP_CACHE_DISK_SIZE).enableQuic(true).addQuicHint(ServiceProvider.GATEWAY_HOST, ServiceProvider.GATEWAY_PORT, ServiceProvider.GATEWAY_PORT).build();
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNullExpressionValue(build, "cronetEngine");
            this.$continuation.resumeWith(Result.m144constructorimpl(new CronetClient(build, this.$dispatchers)));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        this.$continuation.resumeWith(Result.m144constructorimpl(new OkHttp3Client(this.$dispatchers, new OkHttpClient())));
    }
}
