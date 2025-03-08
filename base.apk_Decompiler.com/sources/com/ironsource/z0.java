package com.ironsource;

import com.ironsource.t4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006R$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ironsource/z0;", "", "Lorg/json/JSONObject;", "tokenData", "a", "Lcom/ironsource/t4$a;", "Lcom/ironsource/t4$a;", "adUnit", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "mAuctionKeyList", "Lcom/ironsource/v4;", "c", "Lcom/ironsource/v4;", "mGlobalDataReader", "<init>", "(Lcom/ironsource/t4$a;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class z0 {
    private final t4.a a;
    private final ArrayList<String> b = new ArrayList<>(new x0().a());
    private final v4 c = new v4();

    public z0(t4.a aVar) {
        this.a = aVar;
    }

    private final JSONObject a(JSONObject jSONObject) {
        JSONObject b2 = w4.b(jSONObject.optJSONObject(t4.r));
        if (b2 != null) {
            jSONObject.put(t4.r, b2);
        }
        return jSONObject;
    }

    public final JSONObject a() {
        t4.a aVar = this.a;
        JSONObject a2 = aVar != null ? this.c.a((List<String>) this.b, aVar) : null;
        if (a2 == null) {
            a2 = this.c.a((List<String>) this.b);
            Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        }
        return a(a2);
    }
}
