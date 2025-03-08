package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.BodyType;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00120\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHBø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidExecuteAdViewerRequest;", "Lcom/unity3d/ads/core/domain/ExecuteAdViewerRequest;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/services/core/network/core/HttpClient;)V", "createRequest", "Lcom/unity3d/services/core/network/model/HttpRequest;", "type", "Lcom/unity3d/services/core/network/model/RequestType;", "parameters", "", "", "(Lcom/unity3d/services/core/network/model/RequestType;[Ljava/lang/Object;)Lcom/unity3d/services/core/network/model/HttpRequest;", "getHeadersMap", "", "", "", "headers", "Lorg/json/JSONArray;", "invoke", "Lcom/unity3d/services/core/network/model/HttpResponse;", "(Lcom/unity3d/services/core/network/model/RequestType;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExecuteAdViewerRequest.kt */
public final class AndroidExecuteAdViewerRequest implements ExecuteAdViewerRequest {
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    private final CoroutineDispatcher ioDispatcher;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidExecuteAdViewerRequest.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.unity3d.services.core.network.model.RequestType[] r0 = com.unity3d.services.core.network.model.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.unity3d.services.core.network.model.RequestType r1 = com.unity3d.services.core.network.model.RequestType.GET     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.unity3d.services.core.network.model.RequestType r1 = com.unity3d.services.core.network.model.RequestType.HEAD     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.unity3d.services.core.network.model.RequestType r1 = com.unity3d.services.core.network.model.RequestType.POST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest.WhenMappings.<clinit>():void");
        }
    }

    public AndroidExecuteAdViewerRequest(CoroutineDispatcher coroutineDispatcher, HttpClient httpClient2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        this.ioDispatcher = coroutineDispatcher;
        this.httpClient = httpClient2;
    }

    public Object invoke(RequestType requestType, Object[] objArr, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AndroidExecuteAdViewerRequest$invoke$2(this, requestType, objArr, (Continuation<? super AndroidExecuteAdViewerRequest$invoke$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final HttpRequest createRequest(RequestType requestType, Object[] objArr) {
        int i;
        int i2;
        Object[] objArr2 = objArr;
        String str = (String) ArraysKt.getOrNull((T[]) objArr2, 1);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
            if (i3 == 1 || i3 == 2) {
                Integer num = (Integer) ArraysKt.getOrNull((T[]) objArr2, 3);
                Integer num2 = (Integer) ArraysKt.getOrNull((T[]) objArr2, 4);
                Map<String, List<String>> headersMap = getHeadersMap((JSONArray) ArraysKt.getOrNull((T[]) objArr2, 2));
                int intValue = num != null ? num.intValue() : 30000;
                if (num2 != null) {
                    i = num2.intValue();
                } else {
                    i = 30000;
                }
                return new HttpRequest(str, (String) null, requestType, (Object) null, headersMap, (Map) null, (BodyType) null, (String) null, (Integer) null, intValue, i, 0, 0, false, (OperationType) null, 31210, (DefaultConstructorMarker) null);
            } else if (i3 == 3) {
                String str2 = (String) ArraysKt.getOrNull((T[]) objArr2, 2);
                Integer num3 = (Integer) ArraysKt.getOrNull((T[]) objArr2, 4);
                Integer num4 = (Integer) ArraysKt.getOrNull((T[]) objArr2, 5);
                Map<String, List<String>> headersMap2 = getHeadersMap((JSONArray) ArraysKt.getOrNull((T[]) objArr2, 3));
                int intValue2 = num3 != null ? num3.intValue() : 30000;
                if (num4 != null) {
                    i2 = num4.intValue();
                } else {
                    i2 = 30000;
                }
                return new HttpRequest(str, (String) null, requestType, str2, headersMap2, (Map) null, (BodyType) null, (String) null, (Integer) null, intValue2, i2, 0, 0, false, (OperationType) null, 31202, (DefaultConstructorMarker) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Map<String, List<String>> getHeadersMap(JSONArray jSONArray) {
        if (jSONArray == null) {
            return MapsKt.emptyMap();
        }
        Map<String, List<String>> linkedHashMap = new LinkedHashMap<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            List list = linkedHashMap.get(jSONArray2.getString(0));
            if (list == null) {
                list = new ArrayList();
            }
            String string = jSONArray2.getString(1);
            Intrinsics.checkNotNullExpressionValue(string, "header.getString(1)");
            list.add(string);
            String string2 = jSONArray2.getString(0);
            Intrinsics.checkNotNullExpressionValue(string2, "header.getString(0)");
            linkedHashMap.put(string2, list);
        }
        return linkedHashMap;
    }
}
