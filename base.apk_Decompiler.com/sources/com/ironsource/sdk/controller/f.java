package com.ironsource.sdk.controller;

import com.ironsource.w5;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/ironsource/sdk/controller/f;", "", "a", "b", "c", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface f {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ironsource/sdk/controller/f$a;", "", "", "a", "Lorg/json/JSONObject;", "b", "msgId", "params", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Lorg/json/JSONObject;", "d", "()Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public static final C0023a c = new C0023a((DefaultConstructorMarker) null);
        private final String a;
        private final JSONObject b;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/ironsource/sdk/controller/f$a$a;", "", "", "jsonStr", "Lcom/ironsource/sdk/controller/f$a;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
        /* renamed from: com.ironsource.sdk.controller.f$a$a  reason: collision with other inner class name */
        public static final class C0023a {
            private C0023a() {
            }

            public /* synthetic */ C0023a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final a a(String str) throws JSONException {
                Intrinsics.checkNotNullParameter(str, "jsonStr");
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(b.b);
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                Intrinsics.checkNotNullExpressionValue(string, w5.x);
                return new a(string, optJSONObject);
            }
        }

        public a(String str, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, b.b);
            this.a = str;
            this.b = jSONObject;
        }

        public static /* synthetic */ a a(a aVar, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.a;
            }
            if ((i & 2) != 0) {
                jSONObject = aVar.b;
            }
            return aVar.a(str, jSONObject);
        }

        @JvmStatic
        public static final a a(String str) throws JSONException {
            return c.a(str);
        }

        public final a a(String str, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, b.b);
            return new a(str, jSONObject);
        }

        public final String a() {
            return this.a;
        }

        public final JSONObject b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public final JSONObject d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual((Object) this.a, (Object) aVar.a) && Intrinsics.areEqual((Object) this.b, (Object) aVar.b);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            JSONObject jSONObject = this.b;
            return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public String toString() {
            return "CallbackToNative(msgId=" + this.a + ", params=" + this.b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/ironsource/sdk/controller/f$b;", "", "", "b", "Ljava/lang/String;", "MSG_ID", "c", "AD_ID", "d", "PARAMS", "e", "SUCCESS", "f", "REASON", "g", "COMMAND", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        public static final b a = new b();
        public static final String b = "msgId";
        public static final String c = "adId";
        public static final String d = "params";
        public static final String e = "success";
        public static final String f = "reason";
        public static final String g = "command";

        private b() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\t\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/sdk/controller/f$c;", "", "", "h", "other", "", "equals", "", "hashCode", "a", "b", "Lorg/json/JSONObject;", "c", "adId", "command", "params", "toString", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "Lorg/json/JSONObject;", "g", "()Lorg/json/JSONObject;", "f", "(Ljava/lang/String;)V", "msgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c {
        private final String a;
        private final String b;
        private final JSONObject c;
        private String d;

        public c(String str, String str2, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, b.c);
            Intrinsics.checkNotNullParameter(str2, b.g);
            Intrinsics.checkNotNullParameter(jSONObject, "params");
            this.a = str;
            this.b = str2;
            this.c = jSONObject;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.d = uuid;
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.a;
            }
            if ((i & 2) != 0) {
                str2 = cVar.b;
            }
            if ((i & 4) != 0) {
                jSONObject = cVar.c;
            }
            return cVar.a(str, str2, jSONObject);
        }

        public final c a(String str, String str2, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, b.c);
            Intrinsics.checkNotNullParameter(str2, b.g);
            Intrinsics.checkNotNullParameter(jSONObject, "params");
            return new c(str, str2, jSONObject);
        }

        public final String a() {
            return this.a;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
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
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar == null) {
                return false;
            }
            if (this == cVar) {
                return true;
            }
            return Intrinsics.areEqual((Object) this.d, (Object) cVar.d) && Intrinsics.areEqual((Object) this.a, (Object) cVar.a) && Intrinsics.areEqual((Object) this.b, (Object) cVar.b) && Intrinsics.areEqual((Object) this.c.toString(), (Object) cVar.c.toString());
        }

        public final String f() {
            return this.d;
        }

        public final JSONObject g() {
            return this.c;
        }

        public final String h() {
            String jSONObject = new JSONObject().put(b.b, this.d).put(b.c, this.a).put("params", this.c).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n\t\t\t\t.put(Co…, params)\n\t\t\t\t.toString()");
            return jSONObject;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            return "MessageToController(adId=" + this.a + ", command=" + this.b + ", params=" + this.c + ')';
        }
    }
}
