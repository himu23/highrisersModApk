package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.c1;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.utils.a;
import com.ironsource.t0;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0007\u001a\u00020\u000bH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/ironsource/mediationsdk/f;", "Lcom/ironsource/mediationsdk/g;", "Landroid/content/Context;", "context", "Lcom/ironsource/mediationsdk/i;", "auctionRequestParams", "Lorg/json/JSONObject;", "a", "Lcom/ironsource/t0;", "auctionListener", "Lcom/ironsource/mediationsdk/e$a;", "", "Lcom/ironsource/mediationsdk/utils/a;", "Lcom/ironsource/mediationsdk/utils/a;", "settings", "b", "Z", "isOneToken", "", "c", "Ljava/lang/String;", "sessionId", "<init>", "(Lcom/ironsource/mediationsdk/utils/a;ZLjava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class f implements g {
    private final a a;
    private final boolean b;
    private final String c;

    public f(a aVar, boolean z, String str) {
        Intrinsics.checkNotNullParameter(aVar, d.f);
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.a = aVar;
        this.b = z;
        this.c = str;
    }

    private final JSONObject a(Context context, i iVar) throws JSONException {
        new JSONObject();
        if (this.b) {
            JSONObject a2 = d.c().a(iVar);
            Intrinsics.checkNotNullExpressionValue(a2, "getInstance().enrichToke…low(auctionRequestParams)");
            return a2;
        }
        IronSourceSegment k = iVar.k();
        JSONObject a3 = d.c().a(context, iVar.e(), iVar.i(), iVar.c(), iVar.l(), this.c, this.a, iVar.d(), k != null ? k.toJson() : null, iVar.m(), iVar.n());
        Intrinsics.checkNotNullExpressionValue(a3, "getInstance().enrichToke….useTestAds\n            )");
        a3.put("adUnit", iVar.b());
        a3.put(d.k0, iVar.q() ? "false" : "true");
        if (iVar.p()) {
            a3.put("isDemandOnly", 1);
        }
        if (!iVar.r()) {
            return a3;
        }
        a3.put("isOneFlow", 1);
        return a3;
    }

    public e.a a(Context context, i iVar, t0 t0Var) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iVar, "auctionRequestParams");
        Intrinsics.checkNotNullParameter(t0Var, "auctionListener");
        JSONObject a2 = a(context, iVar);
        String a3 = this.a.a(iVar.p());
        if (iVar.p()) {
            return new c1(t0Var, new URL(a3), a2, iVar.q(), this.a.g(), this.a.m(), this.a.n(), this.a.o(), this.a.d());
        }
        return new e.a(t0Var, new URL(a3), a2, iVar.q(), this.a.g(), this.a.m(), this.a.n(), this.a.o(), this.a.d());
    }

    public boolean a() {
        return this.a.g() > 0;
    }
}
