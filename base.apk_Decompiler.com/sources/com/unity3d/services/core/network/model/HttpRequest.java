package com.unity3d.services.core.network.model;

import com.unity3d.ads.core.data.model.OperationType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\b\u0018\u0000 G2\u00020\u0001:\u0001GB½\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003J\t\u00108\u001a\u00020\u0018HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001b\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tHÆ\u0003J\u0015\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010-JÆ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0010HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!¨\u0006H"}, d2 = {"Lcom/unity3d/services/core/network/model/HttpRequest;", "", "baseURL", "", "path", "method", "Lcom/unity3d/services/core/network/model/RequestType;", "body", "headers", "", "", "parameters", "bodyType", "Lcom/unity3d/services/core/network/model/BodyType;", "scheme", "port", "", "connectTimeout", "readTimeout", "writeTimeout", "callTimeout", "isProtobuf", "", "operationType", "Lcom/unity3d/ads/core/data/model/OperationType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/services/core/network/model/RequestType;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lcom/unity3d/services/core/network/model/BodyType;Ljava/lang/String;Ljava/lang/Integer;IIIIZLcom/unity3d/ads/core/data/model/OperationType;)V", "getBaseURL", "()Ljava/lang/String;", "getBody", "()Ljava/lang/Object;", "getBodyType", "()Lcom/unity3d/services/core/network/model/BodyType;", "getCallTimeout", "()I", "getConnectTimeout", "getHeaders", "()Ljava/util/Map;", "()Z", "getMethod", "()Lcom/unity3d/services/core/network/model/RequestType;", "getOperationType", "()Lcom/unity3d/ads/core/data/model/OperationType;", "getParameters", "getPath", "getPort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReadTimeout", "getScheme", "getWriteTimeout", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/services/core/network/model/RequestType;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lcom/unity3d/services/core/network/model/BodyType;Ljava/lang/String;Ljava/lang/Integer;IIIIZLcom/unity3d/ads/core/data/model/OperationType;)Lcom/unity3d/services/core/network/model/HttpRequest;", "equals", "other", "hashCode", "toString", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_SCHEME = "https";
    public static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final boolean isProtobuf;
    private final RequestType method;
    private final OperationType operationType;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str) {
        this(str, (String) null, (RequestType) null, (Object) null, (Map) null, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32766, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2) {
        this(str, str2, (RequestType) null, (Object) null, (Map) null, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32764, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType) {
        this(str, str2, requestType, (Object) null, (Map) null, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32760, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj) {
        this(str, str2, requestType, obj, (Map) null, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32752, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map) {
        this(str, str2, requestType, obj, map, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32736, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2) {
        this(str, str2, requestType, obj, map, map2, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32704, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2) {
        this(str, str2, requestType, obj, map, map2, bodyType2, (String) null, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32640, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, (Integer) null, 0, 0, 0, 0, false, (OperationType) null, 32512, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, 0, 0, 0, 0, false, (OperationType) null, 32256, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, i, 0, 0, 0, false, (OperationType) null, 31744, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, i, i2, 0, 0, false, (OperationType) null, 30720, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, i, i2, i3, 0, false, (OperationType) null, 28672, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, i, i2, i3, i4, false, (OperationType) null, 24576, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4, boolean z) {
        this(str, str2, requestType, obj, map, map2, bodyType2, str3, num, i, i2, i3, i4, z, (OperationType) null, 16384, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4, boolean z, OperationType operationType2, int i5, Object obj2) {
        HttpRequest httpRequest2 = httpRequest;
        int i6 = i5;
        return httpRequest.copy((i6 & 1) != 0 ? httpRequest2.baseURL : str, (i6 & 2) != 0 ? httpRequest2.path : str2, (i6 & 4) != 0 ? httpRequest2.method : requestType, (i6 & 8) != 0 ? httpRequest2.body : obj, (i6 & 16) != 0 ? httpRequest2.headers : map, (i6 & 32) != 0 ? httpRequest2.parameters : map2, (i6 & 64) != 0 ? httpRequest2.bodyType : bodyType2, (i6 & 128) != 0 ? httpRequest2.scheme : str3, (i6 & 256) != 0 ? httpRequest2.port : num, (i6 & 512) != 0 ? httpRequest2.connectTimeout : i, (i6 & 1024) != 0 ? httpRequest2.readTimeout : i2, (i6 & 2048) != 0 ? httpRequest2.writeTimeout : i3, (i6 & 4096) != 0 ? httpRequest2.callTimeout : i4, (i6 & 8192) != 0 ? httpRequest2.isProtobuf : z, (i6 & 16384) != 0 ? httpRequest2.operationType : operationType2);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final boolean component14() {
        return this.isProtobuf;
    }

    public final OperationType component15() {
        return this.operationType;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final Object component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final BodyType component7() {
        return this.bodyType;
    }

    public final String component8() {
        return this.scheme;
    }

    public final Integer component9() {
        return this.port;
    }

    public final HttpRequest copy(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4, boolean z, OperationType operationType2) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "baseURL");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "path");
        RequestType requestType2 = requestType;
        Intrinsics.checkNotNullParameter(requestType2, "method");
        Map<String, ? extends List<String>> map3 = map;
        Intrinsics.checkNotNullParameter(map3, "headers");
        Map<String, String> map4 = map2;
        Intrinsics.checkNotNullParameter(map4, "parameters");
        BodyType bodyType3 = bodyType2;
        Intrinsics.checkNotNullParameter(bodyType3, "bodyType");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "scheme");
        Intrinsics.checkNotNullParameter(operationType2, "operationType");
        return new HttpRequest(str4, str5, requestType2, obj, map3, map4, bodyType3, str6, num, i, i2, i3, i4, z, operationType2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return Intrinsics.areEqual((Object) this.baseURL, (Object) httpRequest.baseURL) && Intrinsics.areEqual((Object) this.path, (Object) httpRequest.path) && this.method == httpRequest.method && Intrinsics.areEqual(this.body, httpRequest.body) && Intrinsics.areEqual((Object) this.headers, (Object) httpRequest.headers) && Intrinsics.areEqual((Object) this.parameters, (Object) httpRequest.parameters) && this.bodyType == httpRequest.bodyType && Intrinsics.areEqual((Object) this.scheme, (Object) httpRequest.scheme) && Intrinsics.areEqual((Object) this.port, (Object) httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout && this.isProtobuf == httpRequest.isProtobuf && this.operationType == httpRequest.operationType;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final Object getBody() {
        return this.body;
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final OperationType getOperationType() {
        return this.operationType;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        int hashCode = ((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31;
        Object obj = this.body;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.bodyType.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        if (num != null) {
            i = num.hashCode();
        }
        int i2 = (((((((((hashCode2 + i) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout) * 31;
        boolean z = this.isProtobuf;
        if (z) {
            z = true;
        }
        return ((i2 + (z ? 1 : 0)) * 31) + this.operationType.hashCode();
    }

    public final boolean isProtobuf() {
        return this.isProtobuf;
    }

    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", bodyType=" + this.bodyType + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ", isProtobuf=" + this.isProtobuf + ", operationType=" + this.operationType + ')';
    }

    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4, boolean z, OperationType operationType2) {
        Map<String, String> map3 = map2;
        BodyType bodyType3 = bodyType2;
        String str4 = str3;
        OperationType operationType3 = operationType2;
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map3, "parameters");
        Intrinsics.checkNotNullParameter(bodyType3, "bodyType");
        Intrinsics.checkNotNullParameter(str4, "scheme");
        Intrinsics.checkNotNullParameter(operationType3, "operationType");
        this.baseURL = str;
        this.path = str2;
        this.method = requestType;
        this.body = obj;
        this.headers = map;
        this.parameters = map3;
        this.bodyType = bodyType3;
        this.scheme = str4;
        this.port = num;
        this.connectTimeout = i;
        this.readTimeout = i2;
        this.writeTimeout = i3;
        this.callTimeout = i4;
        this.isProtobuf = z;
        this.operationType = operationType3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HttpRequest(java.lang.String r15, java.lang.String r16, com.unity3d.services.core.network.model.RequestType r17, java.lang.Object r18, java.util.Map r19, java.util.Map r20, com.unity3d.services.core.network.model.BodyType r21, java.lang.String r22, java.lang.Integer r23, int r24, int r25, int r26, int r27, boolean r28, com.unity3d.ads.core.data.model.OperationType r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r14 = this;
            r0 = r30
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0012
            com.unity3d.services.core.network.model.RequestType r2 = com.unity3d.services.core.network.model.RequestType.GET
            goto L_0x0014
        L_0x0012:
            r2 = r17
        L_0x0014:
            r3 = r0 & 8
            r4 = 0
            if (r3 == 0) goto L_0x001b
            r3 = r4
            goto L_0x001d
        L_0x001b:
            r3 = r18
        L_0x001d:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0026
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0028
        L_0x0026:
            r5 = r19
        L_0x0028:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0031
            java.util.Map r6 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0033
        L_0x0031:
            r6 = r20
        L_0x0033:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x003a
            com.unity3d.services.core.network.model.BodyType r7 = com.unity3d.services.core.network.model.BodyType.UNKNOWN
            goto L_0x003c
        L_0x003a:
            r7 = r21
        L_0x003c:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0043
            java.lang.String r8 = "https"
            goto L_0x0045
        L_0x0043:
            r8 = r22
        L_0x0045:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r4 = r23
        L_0x004c:
            r9 = r0 & 512(0x200, float:7.175E-43)
            r10 = 30000(0x7530, float:4.2039E-41)
            if (r9 == 0) goto L_0x0055
            r9 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0057
        L_0x0055:
            r9 = r24
        L_0x0057:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x005e
            r11 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0060
        L_0x005e:
            r11 = r25
        L_0x0060:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0067
            r12 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0069
        L_0x0067:
            r12 = r26
        L_0x0069:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r10 = r27
        L_0x0070:
            r13 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x0076
            r13 = 0
            goto L_0x0078
        L_0x0076:
            r13 = r28
        L_0x0078:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007f
            com.unity3d.ads.core.data.model.OperationType r0 = com.unity3d.ads.core.data.model.OperationType.UNKNOWN
            goto L_0x0081
        L_0x007f:
            r0 = r29
        L_0x0081:
            r16 = r14
            r17 = r15
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r4
            r26 = r9
            r27 = r11
            r28 = r12
            r29 = r10
            r30 = r13
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int, int, int, boolean, com.unity3d.ads.core.data.model.OperationType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/network/model/HttpRequest$Companion;", "", "()V", "DEFAULT_SCHEME", "", "DEFAULT_TIMEOUT", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
