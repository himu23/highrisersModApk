package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/services/core/network/model/HttpResponse;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OkHttp3Client.kt */
final class OkHttp3Client$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ OkHttp3Client this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttp3Client$execute$2(HttpRequest httpRequest, OkHttp3Client okHttp3Client, Continuation<? super OkHttp3Client$execute$2> continuation) {
        super(2, continuation);
        this.$request = httpRequest;
        this.this$0 = okHttp3Client;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OkHttp3Client$execute$2(this.$request, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((OkHttp3Client$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BufferedSource source;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Request okHttpProtoRequest = this.$request.isProtobuf() ? HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(this.$request) : HttpRequestToOkHttpRequestKt.toOkHttpRequest(this.$request);
            OkHttp3Client okHttp3Client = this.this$0;
            this.label = 1;
            obj = okHttp3Client.makeRequest(okHttpProtoRequest, (long) this.$request.getConnectTimeout(), (long) this.$request.getReadTimeout(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) obj;
        Object obj2 = null;
        if (this.$request.isProtobuf()) {
            ResponseBody body = response.body();
            if (!(body == null || (source = body.source()) == null)) {
                obj2 = source.readByteArray();
            }
        } else {
            ResponseBody body2 = response.body();
            if (body2 != null) {
                obj2 = body2.string();
            }
        }
        Serializable serializable = (Serializable) obj2;
        int code = response.code();
        Map<String, List<String>> multimap = response.headers().toMultimap();
        String httpUrl = response.request().url().toString();
        if (serializable == null) {
            serializable = "";
        }
        String protocol = response.protocol().toString();
        Intrinsics.checkNotNullExpressionValue(multimap, "toMultimap()");
        Intrinsics.checkNotNullExpressionValue(httpUrl, "toString()");
        Intrinsics.checkNotNullExpressionValue(protocol, "toString()");
        return new HttpResponse(serializable, code, multimap, httpUrl, protocol, "okhttp");
    }
}
