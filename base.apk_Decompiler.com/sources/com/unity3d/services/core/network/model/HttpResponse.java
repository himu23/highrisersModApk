package com.unity3d.services.core.network.model;

import androidx.work.impl.Scheduler;
import com.ironsource.m2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003JW\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lcom/unity3d/services/core/network/model/HttpResponse;", "", "body", "statusCode", "", "headers", "", "", "", "urlString", "protocol", "client", "(Ljava/lang/Object;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/Object;", "getClient", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getProtocol", "getStatusCode", "()I", "getUrlString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpResponse.kt */
public final class HttpResponse {
    private final Object body;
    private final String client;
    private final Map<String, List<String>> headers;
    private final String protocol;
    private final int statusCode;
    private final String urlString;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj) {
        this(obj, 0, (Map) null, (String) null, (String) null, (String) null, 62, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i) {
        this(obj, i, (Map) null, (String) null, (String) null, (String) null, 60, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i, Map<String, ? extends List<String>> map) {
        this(obj, i, map, (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i, Map<String, ? extends List<String>> map, String str) {
        this(obj, i, map, str, (String) null, (String) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str, "urlString");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i, Map<String, ? extends List<String>> map, String str, String str2) {
        this(obj, i, map, str, str2, (String) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str, "urlString");
        Intrinsics.checkNotNullParameter(str2, "protocol");
    }

    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, Object obj, int i, Map<String, List<String>> map, String str, String str2, String str3, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = httpResponse.body;
        }
        if ((i2 & 2) != 0) {
            i = httpResponse.statusCode;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            map = httpResponse.headers;
        }
        Map<String, List<String>> map2 = map;
        if ((i2 & 8) != 0) {
            str = httpResponse.urlString;
        }
        String str4 = str;
        if ((i2 & 16) != 0) {
            str2 = httpResponse.protocol;
        }
        String str5 = str2;
        if ((i2 & 32) != 0) {
            str3 = httpResponse.client;
        }
        return httpResponse.copy(obj, i3, map2, str4, str5, str3);
    }

    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final Map<String, List<String>> component3() {
        return this.headers;
    }

    public final String component4() {
        return this.urlString;
    }

    public final String component5() {
        return this.protocol;
    }

    public final String component6() {
        return this.client;
    }

    public final HttpResponse copy(Object obj, int i, Map<String, ? extends List<String>> map, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str, "urlString");
        Intrinsics.checkNotNullParameter(str2, "protocol");
        Intrinsics.checkNotNullParameter(str3, "client");
        return new HttpResponse(obj, i, map, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return Intrinsics.areEqual(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && Intrinsics.areEqual((Object) this.headers, (Object) httpResponse.headers) && Intrinsics.areEqual((Object) this.urlString, (Object) httpResponse.urlString) && Intrinsics.areEqual((Object) this.protocol, (Object) httpResponse.protocol) && Intrinsics.areEqual((Object) this.client, (Object) httpResponse.client);
    }

    public final Object getBody() {
        return this.body;
    }

    public final String getClient() {
        return this.client;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        return (((((((((this.body.hashCode() * 31) + this.statusCode) * 31) + this.headers.hashCode()) * 31) + this.urlString.hashCode()) * 31) + this.protocol.hashCode()) * 31) + this.client.hashCode();
    }

    public String toString() {
        return "HttpResponse(body=" + this.body + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", urlString=" + this.urlString + ", protocol=" + this.protocol + ", client=" + this.client + ')';
    }

    public HttpResponse(Object obj, int i, Map<String, ? extends List<String>> map, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(obj, m2.h.E0);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(str, "urlString");
        Intrinsics.checkNotNullParameter(str2, "protocol");
        Intrinsics.checkNotNullParameter(str3, "client");
        this.body = obj;
        this.statusCode = i;
        this.headers = map;
        this.urlString = str;
        this.protocol = str2;
        this.client = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpResponse(Object obj, int i, Map map, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? Scheduler.MAX_GREEDY_SCHEDULER_LIMIT : i, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? "unknown" : str3);
    }
}
