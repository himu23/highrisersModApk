package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/unity3d/services/SDKErrorHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;)V", "key", "Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "getKey", "()Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "sendDiagnostic", "name", "", "value", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SDKErrorHandler.kt */
public final class SDKErrorHandler implements CoroutineExceptionHandler {
    private final AlternativeFlowReader alternativeFlowReader;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
    private final CoroutineScope scope;
    private final SDKMetricsSender sdkMetricsSender;
    /* access modifiers changed from: private */
    public final SendDiagnosticEvent sendDiagnosticEvent;

    public CoroutineExceptionHandler.Key getKey() {
        return this.key;
    }

    public SDKErrorHandler(CoroutineDispatcher coroutineDispatcher, AlternativeFlowReader alternativeFlowReader2, SendDiagnosticEvent sendDiagnosticEvent2, SDKMetricsSender sDKMetricsSender) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(alternativeFlowReader2, "alternativeFlowReader");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(sDKMetricsSender, "sdkMetricsSender");
        this.ioDispatcher = coroutineDispatcher;
        this.alternativeFlowReader = alternativeFlowReader2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
        this.sdkMetricsSender = sDKMetricsSender;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(coroutineDispatcher), new CoroutineName("SDKErrorHandler"));
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineExceptionHandler.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key2) {
        return CoroutineExceptionHandler.DefaultImpls.get(this, key2);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key2) {
        return CoroutineExceptionHandler.DefaultImpls.minusKey(this, key2);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.plus(this, coroutineContext);
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(th, "exception");
        int i = 0;
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        String fileName = stackTraceElement != null ? stackTraceElement.getFileName() : null;
        if (fileName == null) {
            fileName = "unknown";
        }
        StackTraceElement stackTraceElement2 = th.getStackTrace()[0];
        if (stackTraceElement2 != null) {
            i = stackTraceElement2.getLineNumber();
        }
        if (th instanceof NullPointerException) {
            str = "native_exception_npe";
        } else if (th instanceof OutOfMemoryError) {
            str = "native_exception_oom";
        } else if (th instanceof IllegalStateException) {
            str = "native_exception_ise";
        } else if (th instanceof SecurityException) {
            str = "native_exception_se";
        } else {
            str = th instanceof RuntimeException ? "native_exception_re" : "native_exception";
        }
        String str2 = str;
        boolean invoke = this.alternativeFlowReader.invoke();
        String str3 = fileName + '_' + i;
        DeviceLog.error("Unity Ads SDK encountered an exception: " + str3);
        if (invoke) {
            sendDiagnostic(str2, str3);
        } else {
            sendMetric(new Metric(str2, str3, (Map) null, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void sendDiagnostic(String str, String str2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SDKErrorHandler$sendDiagnostic$1(this, str, str2, (Continuation<? super SDKErrorHandler$sendDiagnostic$1>) null), 3, (Object) null);
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }
}
