package com.unity3d.ads.network.model;

import com.ironsource.m2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u001b\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nHÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010#J\t\u00103\u001a\u00020\u000fHÆ\u0003J¦\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u000fHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006<"}, d2 = {"Lcom/unity3d/ads/network/model/HttpRequest;", "", "baseURL", "", "path", "method", "Lcom/unity3d/ads/network/model/RequestType;", "body", "Lcom/unity3d/ads/network/model/HttpBody;", "headers", "", "", "parameters", "scheme", "port", "", "connectTimeout", "readTimeout", "writeTimeout", "callTimeout", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/network/model/RequestType;Lcom/unity3d/ads/network/model/HttpBody;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;IIII)V", "getBaseURL", "()Ljava/lang/String;", "getBody", "()Lcom/unity3d/ads/network/model/HttpBody;", "getCallTimeout", "()I", "getConnectTimeout", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Lcom/unity3d/ads/network/model/RequestType;", "getParameters", "getPath", "getPort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReadTimeout", "getScheme", "getWriteTimeout", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/network/model/RequestType;Lcom/unity3d/ads/network/model/HttpBody;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;IIII)Lcom/unity3d/ads/network/model/HttpRequest;", "equals", "", "other", "hashCode", "toString", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final HttpBody body;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final RequestType method;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4094(0xffe, float:5.737E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4092(0xffc, float:5.734E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4088(0xff8, float:5.729E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4080(0xff0, float:5.717E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4064(0xfe0, float:5.695E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 4032(0xfc0, float:5.65E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "scheme"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 3968(0xf80, float:5.56E-42)
            r15 = 0
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.lang.Integer r24) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "scheme"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 3840(0xf00, float:5.381E-42)
            r15 = 0
            r1 = r16
            r9 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.lang.Integer r24, int r25) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "scheme"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 3584(0xe00, float:5.022E-42)
            r15 = 0
            r1 = r16
            r9 = r24
            r10 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String, java.lang.Integer, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.lang.Integer r24, int r25, int r26) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "scheme"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r12 = 0
            r13 = 0
            r14 = 3072(0xc00, float:4.305E-42)
            r15 = 0
            r1 = r16
            r9 = r24
            r10 = r25
            r11 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String, java.lang.Integer, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r17, java.lang.String r18, com.unity3d.ads.network.model.RequestType r19, com.unity3d.ads.network.model.HttpBody r20, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.lang.Integer r24, int r25, int r26, int r27) {
        /*
            r16 = this;
            java.lang.String r0 = "baseURL"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "scheme"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r13 = 0
            r14 = 2048(0x800, float:2.87E-42)
            r15 = 0
            r1 = r16
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String, java.lang.Integer, int, int, int):void");
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, HttpBody httpBody, Map map, Map map2, String str3, Integer num, int i, int i2, int i3, int i4, int i5, Object obj) {
        HttpRequest httpRequest2 = httpRequest;
        int i6 = i5;
        return httpRequest.copy((i6 & 1) != 0 ? httpRequest2.baseURL : str, (i6 & 2) != 0 ? httpRequest2.path : str2, (i6 & 4) != 0 ? httpRequest2.method : requestType, (i6 & 8) != 0 ? httpRequest2.body : httpBody, (i6 & 16) != 0 ? httpRequest2.headers : map, (i6 & 32) != 0 ? httpRequest2.parameters : map2, (i6 & 64) != 0 ? httpRequest2.scheme : str3, (i6 & 128) != 0 ? httpRequest2.port : num, (i6 & 256) != 0 ? httpRequest2.connectTimeout : i, (i6 & 512) != 0 ? httpRequest2.readTimeout : i2, (i6 & 1024) != 0 ? httpRequest2.writeTimeout : i3, (i6 & 2048) != 0 ? httpRequest2.callTimeout : i4);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.readTimeout;
    }

    public final int component11() {
        return this.writeTimeout;
    }

    public final int component12() {
        return this.callTimeout;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final HttpBody component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final String component7() {
        return this.scheme;
    }

    public final Integer component8() {
        return this.port;
    }

    public final int component9() {
        return this.connectTimeout;
    }

    public final HttpRequest copy(String str, String str2, RequestType requestType, HttpBody httpBody, Map<String, ? extends List<String>> map, Map<String, String> map2, String str3, Integer num, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "baseURL");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "path");
        RequestType requestType2 = requestType;
        Intrinsics.checkNotNullParameter(requestType2, "method");
        HttpBody httpBody2 = httpBody;
        Intrinsics.checkNotNullParameter(httpBody2, m2.h.E0);
        Map<String, ? extends List<String>> map3 = map;
        Intrinsics.checkNotNullParameter(map3, "headers");
        Map<String, String> map4 = map2;
        Intrinsics.checkNotNullParameter(map4, "parameters");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "scheme");
        return new HttpRequest(str, str4, requestType2, httpBody2, map3, map4, str5, num, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return Intrinsics.areEqual((Object) this.baseURL, (Object) httpRequest.baseURL) && Intrinsics.areEqual((Object) this.path, (Object) httpRequest.path) && this.method == httpRequest.method && Intrinsics.areEqual((Object) this.body, (Object) httpRequest.body) && Intrinsics.areEqual((Object) this.headers, (Object) httpRequest.headers) && Intrinsics.areEqual((Object) this.parameters, (Object) httpRequest.parameters) && Intrinsics.areEqual((Object) this.scheme, (Object) httpRequest.scheme) && Intrinsics.areEqual((Object) this.port, (Object) httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final HttpBody getBody() {
        return this.body;
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
        int hashCode = ((((((((((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31) + this.body.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        return ((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ')';
    }

    public HttpRequest(String str, String str2, RequestType requestType, HttpBody httpBody, Map<String, ? extends List<String>> map, Map<String, String> map2, String str3, Integer num, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, "method");
        Intrinsics.checkNotNullParameter(httpBody, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(str3, "scheme");
        this.baseURL = str;
        this.path = str2;
        this.method = requestType;
        this.body = httpBody;
        this.headers = map;
        this.parameters = map2;
        this.scheme = str3;
        this.port = num;
        this.connectTimeout = i;
        this.readTimeout = i2;
        this.writeTimeout = i3;
        this.callTimeout = i4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HttpRequest(java.lang.String r13, java.lang.String r14, com.unity3d.ads.network.model.RequestType r15, com.unity3d.ads.network.model.HttpBody r16, java.util.Map r17, java.util.Map r18, java.lang.String r19, java.lang.Integer r20, int r21, int r22, int r23, int r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            com.unity3d.ads.network.model.RequestType r2 = com.unity3d.ads.network.model.RequestType.GET
            goto L_0x0012
        L_0x0011:
            r2 = r15
        L_0x0012:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x001b
            com.unity3d.ads.network.model.HttpBody$EmptyBody r3 = com.unity3d.ads.network.model.HttpBody.EmptyBody.INSTANCE
            com.unity3d.ads.network.model.HttpBody r3 = (com.unity3d.ads.network.model.HttpBody) r3
            goto L_0x001d
        L_0x001b:
            r3 = r16
        L_0x001d:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x0026
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0028
        L_0x0026:
            r4 = r17
        L_0x0028:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x0031
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0033
        L_0x0031:
            r5 = r18
        L_0x0033:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x003a
            java.lang.String r6 = "https"
            goto L_0x003c
        L_0x003a:
            r6 = r19
        L_0x003c:
            r7 = r0 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0042
            r7 = 0
            goto L_0x0044
        L_0x0042:
            r7 = r20
        L_0x0044:
            r8 = r0 & 256(0x100, float:3.59E-43)
            r9 = 30000(0x7530, float:4.2039E-41)
            if (r8 == 0) goto L_0x004d
            r8 = 30000(0x7530, float:4.2039E-41)
            goto L_0x004f
        L_0x004d:
            r8 = r21
        L_0x004f:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0056
            r10 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0058
        L_0x0056:
            r10 = r22
        L_0x0058:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x005f
            r11 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0061
        L_0x005f:
            r11 = r23
        L_0x0061:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r9 = r24
        L_0x0068:
            r14 = r12
            r15 = r13
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r10
            r25 = r11
            r26 = r9
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.ads.network.model.RequestType, com.unity3d.ads.network.model.HttpBody, java.util.Map, java.util.Map, java.lang.String, java.lang.Integer, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/network/model/HttpRequest$Companion;", "", "()V", "DEFAULT_SCHEME", "", "DEFAULT_TIMEOUT", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
