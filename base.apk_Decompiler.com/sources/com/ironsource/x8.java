package com.ironsource;

import com.ironsource.sdk.controller.f;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0003B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ironsource/x8;", "", "", "a", "b", "Lorg/json/JSONObject;", "c", "adId", "command", "params", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "Lorg/json/JSONObject;", "f", "()Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class x8 {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final String a;
    private final String b;
    private final JSONObject c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/ironsource/x8$a;", "", "", "jsonStr", "Lcom/ironsource/x8;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final x8 a(String str) throws JSONException {
            Intrinsics.checkNotNullParameter(str, "jsonStr");
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(f.b.c);
            String string2 = jSONObject.getString(f.b.g);
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            Intrinsics.checkNotNullExpressionValue(string, f.b.c);
            Intrinsics.checkNotNullExpressionValue(string2, f.b.g);
            return new x8(string, string2, optJSONObject);
        }
    }

    public x8(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, f.b.c);
        Intrinsics.checkNotNullParameter(str2, f.b.g);
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
    }

    public static /* synthetic */ x8 a(x8 x8Var, String str, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = x8Var.a;
        }
        if ((i & 2) != 0) {
            str2 = x8Var.b;
        }
        if ((i & 4) != 0) {
            jSONObject = x8Var.c;
        }
        return x8Var.a(str, str2, jSONObject);
    }

    @JvmStatic
    public static final x8 a(String str) throws JSONException {
        return d.a(str);
    }

    public final x8 a(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, f.b.c);
        Intrinsics.checkNotNullParameter(str2, f.b.g);
        return new x8(str, str2, jSONObject);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x8)) {
            return false;
        }
        x8 x8Var = (x8) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) x8Var.a) && Intrinsics.areEqual((Object) this.b, (Object) x8Var.b) && Intrinsics.areEqual((Object) this.c, (Object) x8Var.c);
    }

    public final JSONObject f() {
        return this.c;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        JSONObject jSONObject = this.c;
        return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "MessageToNative(adId=" + this.a + ", command=" + this.b + ", params=" + this.c + ')';
    }
}
