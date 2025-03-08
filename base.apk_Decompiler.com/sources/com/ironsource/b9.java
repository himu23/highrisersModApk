package com.ironsource;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.ironsource.c9;
import com.ironsource.m2;
import com.ironsource.r6;
import com.ironsource.sdk.controller.e;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B+\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020#¢\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001bR$\u0010.\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\u0007\u0010,\"\u0004\b\u0007\u0010-¨\u00061"}, d2 = {"Lcom/ironsource/b9;", "Lcom/ironsource/c9;", "Landroid/app/Activity;", "activity", "Lcom/ironsource/sdk/controller/f$a;", "response", "", "a", "Lcom/ironsource/r6$b;", "report", "Lcom/ironsource/r6;", "adData", "Lorg/json/JSONObject;", "d", "b", "Lcom/ironsource/sdk/controller/k$b;", "c", "Lcom/ironsource/x8;", "msg", "loadParams", "destroy", "Lcom/ironsource/u6;", "viewHolder", "Lcom/ironsource/wc;", "viewVisibilityParams", "clickParams", "", "Ljava/lang/String;", "id", "Lcom/ironsource/sdk/controller/e;", "Lcom/ironsource/sdk/controller/e;", "controllerManager", "Lcom/ironsource/z6;", "Lcom/ironsource/z6;", "imageLoader", "Lcom/ironsource/g0;", "Lcom/ironsource/g0;", "adViewManagement", "kotlin.jvm.PlatformType", "e", "logTag", "Lcom/ironsource/c9$a;", "f", "Lcom/ironsource/c9$a;", "()Lcom/ironsource/c9$a;", "(Lcom/ironsource/c9$a;)V", "listener", "<init>", "(Ljava/lang/String;Lcom/ironsource/sdk/controller/e;Lcom/ironsource/z6;Lcom/ironsource/g0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class b9 implements c9 {
    private final String a;
    private final e b;
    private final z6 c;
    private final g0 d;
    private final String e;
    private c9.a f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/ironsource/b9$a;", "", "", "b", "Ljava/lang/String;", "LOAD", "c", "LOAD_REPORT", "d", "REGISTER", "e", "CLICK", "f", "PRIVACY_CLICK", "g", "VISIBILITY_CHANGED", "h", "DESTROY", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public static final a a = new a();
        public static final String b = "nativeAd.load";
        public static final String c = "nativeAd.loadReport";
        public static final String d = "nativeAd.register";
        public static final String e = "nativeAd.click";
        public static final String f = "nativeAd.privacyClick";
        public static final String g = "nativeAd.visibilityChanged";
        public static final String h = "nativeAd.destroy";

        private a() {
        }
    }

    public b9(String str, e eVar, z6 z6Var, g0 g0Var) {
        Intrinsics.checkNotNullParameter(str, w5.x);
        Intrinsics.checkNotNullParameter(eVar, "controllerManager");
        Intrinsics.checkNotNullParameter(z6Var, "imageLoader");
        Intrinsics.checkNotNullParameter(g0Var, "adViewManagement");
        this.a = str;
        this.b = eVar;
        this.c = z6Var;
        this.d = g0Var;
        this.e = "b9";
        eVar.a(str, c());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b9(java.lang.String r2, com.ironsource.sdk.controller.e r3, com.ironsource.z6 r4, com.ironsource.g0 r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 4
            if (r7 == 0) goto L_0x000b
            com.ironsource.y6 r4 = new com.ironsource.y6
            r7 = 1
            r0 = 0
            r4.<init>(r0, r7, r0)
        L_0x000b:
            r6 = r6 & 8
            if (r6 == 0) goto L_0x0018
            com.ironsource.d6 r5 = com.ironsource.d6.a()
            java.lang.String r6 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        L_0x0018:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.b9.<init>(java.lang.String, com.ironsource.sdk.controller.e, com.ironsource.z6, com.ironsource.g0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final void a(Activity activity, f.a aVar) {
        if (aVar.d() == null) {
            c9.a a2 = a();
            if (a2 != null) {
                a2.a("failed to load native ad: missing params");
            }
        } else if (!aVar.d().optBoolean("success", false)) {
            String optString = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            c9.a a3 = a();
            if (a3 != null) {
                Intrinsics.checkNotNullExpressionValue(optString, "reason");
                a3.a(optString);
            }
        } else {
            r6.b a4 = new r6.a(this.c, this.d).a(activity, aVar.d());
            a(a4, a4.a().h());
        }
    }

    /* access modifiers changed from: private */
    public static final void a(b9 b9Var, Activity activity, f.a aVar) {
        Intrinsics.checkNotNullParameter(b9Var, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(aVar, "it");
        b9Var.a(activity, aVar);
    }

    /* access modifiers changed from: private */
    public static final void a(b9 b9Var, r6 r6Var, f.a aVar) {
        Intrinsics.checkNotNullParameter(b9Var, "this$0");
        Intrinsics.checkNotNullParameter(r6Var, "$adData");
        Intrinsics.checkNotNullParameter(aVar, "it");
        b9Var.a(r6Var, aVar);
    }

    /* access modifiers changed from: private */
    public static final void a(b9 b9Var, f.a aVar) {
        Intrinsics.checkNotNullParameter(b9Var, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "it");
        b9Var.a(aVar);
    }

    /* access modifiers changed from: private */
    public static final void a(b9 b9Var, x8 x8Var) {
        Intrinsics.checkNotNullParameter(b9Var, "this$0");
        Intrinsics.checkNotNullParameter(x8Var, NotificationCompat.CATEGORY_MESSAGE);
        if (Intrinsics.areEqual((Object) x8Var.e(), (Object) a.e)) {
            b9Var.a(x8Var);
        }
    }

    private final void a(r6.b bVar, r6 r6Var) {
        this.b.a(new f.c(this.a, "nativeAd.loadReport." + this.a, bVar.b()), (k.a) new b9$$ExternalSyntheticLambda4(this, r6Var));
    }

    private final void a(r6 r6Var, f.a aVar) {
        if (aVar.d() == null) {
            c9.a a2 = a();
            if (a2 != null) {
                a2.a("failed to load native ad: missing report params");
            }
        } else if (!aVar.d().optBoolean("success", false)) {
            String optString = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            c9.a a3 = a();
            if (a3 != null) {
                Intrinsics.checkNotNullExpressionValue(optString, "reason");
                a3.a(optString);
            }
        } else {
            c9.a a4 = a();
            if (a4 != null) {
                a4.a(r6Var);
            }
        }
    }

    private final void a(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
        } else if (!aVar.d().optBoolean("success", false)) {
            String optString = aVar.d().optString("reason", "unexpected error");
            String str = this.e;
            Logger.i(str, "failed to handle click on native ad: " + optString);
        } else {
            c9.a a2 = a();
            if (a2 != null) {
                a2.b();
            }
        }
    }

    private final void a(x8 x8Var) {
        if (x8Var.f() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
        } else if (!x8Var.f().optBoolean("success", false)) {
            String optString = x8Var.f().optString("reason", "unexpected error");
            String str = this.e;
            Logger.i(str, "failed to handle click on native ad: " + optString);
        } else {
            c9.a a2 = a();
            if (a2 != null) {
                a2.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b(b9 b9Var, f.a aVar) {
        Intrinsics.checkNotNullParameter(b9Var, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "it");
        b9Var.b(aVar);
    }

    private final void b(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle show on native ad: missing params");
        } else if (!aVar.d().optBoolean("success", false)) {
            String optString = aVar.d().optString("reason", "unexpected error");
            String str = this.e;
            Logger.i(str, "failed to handle show on native ad: " + optString);
        } else {
            c9.a a2 = a();
            if (a2 != null) {
                a2.a();
            }
        }
    }

    private final k.b c() {
        return new b9$$ExternalSyntheticLambda1(this);
    }

    private final JSONObject d() {
        JSONObject put = new JSONObject().put(f.b.g, a.e).put("sdkCallback", m2.g.Z);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n\t\t\t.put(Con…hods.ON_RECEIVED_MESSAGE)");
        return put;
    }

    public c9.a a() {
        return this.f;
    }

    public void a(Activity activity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "loadParams");
        this.b.a(activity);
        this.b.a(new f.c(this.a, a.b, jSONObject), (k.a) new b9$$ExternalSyntheticLambda2(this, activity));
    }

    public void a(c9.a aVar) {
        this.f = aVar;
    }

    public void a(u6 u6Var) {
        Intrinsics.checkNotNullParameter(u6Var, "viewHolder");
        JSONObject put = new JSONObject().put("assetViews", u6Var.t()).put("adViewClickCommand", d());
        String str = this.a;
        Intrinsics.checkNotNullExpressionValue(put, "params");
        this.b.a(new f.c(str, a.d, put), (k.a) null);
    }

    public void a(wc wcVar) {
        Intrinsics.checkNotNullParameter(wcVar, "viewVisibilityParams");
        this.b.a(new f.c(this.a, a.g, wcVar.g()), (k.a) new b9$$ExternalSyntheticLambda3(this));
    }

    public void a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "clickParams");
        this.b.a(new f.c(this.a, a.e, jSONObject), (k.a) new b9$$ExternalSyntheticLambda0(this));
    }

    public void b() {
        this.b.a(new f.c(this.a, a.f, new JSONObject()), (k.a) null);
    }

    public void destroy() {
        this.b.a(new f.c(this.a, a.h, new JSONObject()), (k.a) null);
    }
}
