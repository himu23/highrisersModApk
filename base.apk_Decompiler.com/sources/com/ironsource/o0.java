package com.ironsource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006#"}, d2 = {"Lcom/ironsource/o0;", "", "Lorg/json/JSONObject;", "a", "config", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "Z", "h", "()Z", "isExternalArmEventsEnabled", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "externalArmEventsUrl", "d", "e", "shouldUseAppSet", "shouldReuseAdvId", "f", "I", "g", "()I", "userAgentExpirationThresholdInHours", "shouldUseSharedThreadPool", "<init>", "(Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class o0 {
    private final JSONObject a;
    private final boolean b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final boolean g;

    public o0(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        this.a = jSONObject;
        this.b = jSONObject.optBoolean("isExternalArmEventsEnabled", true);
        String optString = jSONObject.optString("externalArmEventsUrl", k4.j);
        Intrinsics.checkNotNullExpressionValue(optString, "config.optString(EXTERNA…AL_EVENTS_IMPRESSION_URL)");
        this.c = optString;
        this.d = jSONObject.optBoolean(t4.D0, true);
        this.e = jSONObject.optBoolean("radvid", false);
        this.f = jSONObject.optInt("uaeh", 0);
        this.g = jSONObject.optBoolean("sharedThreadPool", false);
    }

    public static /* synthetic */ o0 a(o0 o0Var, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = o0Var.a;
        }
        return o0Var.a(jSONObject);
    }

    public final o0 a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        return new o0(jSONObject);
    }

    public final JSONObject a() {
        return this.a;
    }

    public final JSONObject b() {
        return this.a;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o0) && Intrinsics.areEqual((Object) this.a, (Object) ((o0) obj).a);
    }

    public final boolean f() {
        return this.g;
    }

    public final int g() {
        return this.f;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ApplicationGeneralSettings(config=" + this.a + ')';
    }
}
