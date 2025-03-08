package com.ironsource;

import com.ironsource.mediationsdk.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/ironsource/v3;", "Lcom/ironsource/v8;", "", "Lcom/ironsource/mediationsdk/d$a;", "input", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class v3 implements v8<String, d.a> {
    public d.a a(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        d.a b = d.c().b(new JSONObject(str));
        Intrinsics.checkNotNullExpressionValue(b, "getInstance().getAuction…sponse(JSONObject(input))");
        return b;
    }
}
