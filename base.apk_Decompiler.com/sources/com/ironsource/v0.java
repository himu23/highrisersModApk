package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/ironsource/v0;", "", "", "instanceId", "Lcom/ironsource/mediationsdk/demandOnly/p;", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface v0 {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ironsource/v0$a;", "Lcom/ironsource/v0;", "", "instanceId", "Lcom/ironsource/mediationsdk/demandOnly/p;", "a", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "instances", "<init>", "(Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements v0 {
        private final JSONObject a;

        public a() {
            this((JSONObject) null, 1, (DefaultConstructorMarker) null);
        }

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new JSONObject() : jSONObject);
        }

        public p a(String str) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            JSONObject jSONObject = this.a;
            String str2 = null;
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(str) : null;
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("plumbus");
            }
            return str2 != null ? new p.a(str2) : new p.b();
        }
    }

    p a(String str);
}
