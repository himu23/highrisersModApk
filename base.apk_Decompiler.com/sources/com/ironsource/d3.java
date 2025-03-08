package com.ironsource;

import com.ironsource.m2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/ironsource/d3;", "", "", "eventId", "", "instanceId", "", "a", "b", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface d3 {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\r"}, d2 = {"Lcom/ironsource/d3$a;", "", "", "key", "value", "", "a", "", "Ljava/util/Map;", "data", "providerName", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private final Map<String, Object> a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "providerName");
            this.a = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_PROVIDER, str), TuplesKt.to("isDemandOnly", 1));
        }

        public final Map<String, Object> a() {
            return MapsKt.toMutableMap(this.a);
        }

        public final void a(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            Intrinsics.checkNotNullParameter(obj, m2.h.X);
            this.a.put(str, obj);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/d3$b;", "Lcom/ironsource/d3;", "", "eventId", "", "instanceId", "", "a", "Lcom/ironsource/d5;", "Lcom/ironsource/d5;", "eventManager", "Lcom/ironsource/d3$a;", "b", "Lcom/ironsource/d3$a;", "eventBaseData", "<init>", "(Lcom/ironsource/d5;Lcom/ironsource/d3$a;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements d3 {
        private final d5 a;
        private final a b;

        public b(d5 d5Var, a aVar) {
            Intrinsics.checkNotNullParameter(d5Var, "eventManager");
            Intrinsics.checkNotNullParameter(aVar, "eventBaseData");
            this.a = d5Var;
            this.b = aVar;
        }

        public void a(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "instanceId");
            Map<String, Object> a2 = this.b.a();
            a2.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, str);
            this.a.a(new y3(i, new JSONObject(MapsKt.toMap(a2))));
        }
    }

    void a(int i, String str);
}
