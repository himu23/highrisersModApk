package com.ironsource;

import android.app.Activity;
import com.ironsource.c9;
import com.ironsource.e6;
import com.ironsource.m2;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.controller.e;
import com.ironsource.t6;
import com.ironsource.u6;
import com.ironsource.za;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0006\t\u0018\u0000 42\u00020\u0001:\u0001\u0011B#\b\u0000\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR(\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@RX\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0019\u0010#R(\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b%\u0010&R(\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@BX\u000e¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010*R$\u00100\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010-\u001a\u0004\b\u0011\u0010.\"\u0004\b\u0011\u0010/R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u00101¨\u00065"}, d2 = {"Lcom/ironsource/p6;", "Lcom/ironsource/t6;", "Lcom/ironsource/g6;", "c", "", "i", "com/ironsource/p6$b", "e", "()Lcom/ironsource/p6$b;", "com/ironsource/p6$c", "f", "()Lcom/ironsource/p6$c;", "Landroid/app/Activity;", "activity", "Lorg/json/JSONObject;", "loadParams", "", "a", "Lcom/ironsource/u6;", "viewHolder", "destroy", "", "Ljava/lang/String;", "id", "Lcom/ironsource/c9;", "b", "Lcom/ironsource/c9;", "controller", "Lcom/ironsource/h6;", "Lcom/ironsource/h6;", "eventTracker", "Lcom/ironsource/r6;", "<set-?>", "d", "Lcom/ironsource/r6;", "()Lcom/ironsource/r6;", "adData", "g", "()Ljava/lang/String;", "demandSourceName", "h", "isBidding", "Ljava/lang/Long;", "startTime", "Lcom/ironsource/t6$a;", "Lcom/ironsource/t6$a;", "()Lcom/ironsource/t6$a;", "(Lcom/ironsource/t6$a;)V", "listener", "Lcom/ironsource/u6;", "<init>", "(Ljava/lang/String;Lcom/ironsource/c9;Lcom/ironsource/h6;)V", "j", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class p6 implements t6 {
    public static final a j = new a((DefaultConstructorMarker) null);
    private final String a;
    /* access modifiers changed from: private */
    public final c9 b;
    /* access modifiers changed from: private */
    public final h6 c;
    /* access modifiers changed from: private */
    public r6 d;
    private String e;
    private String f;
    private Long g;
    private t6.a h;
    private u6 i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/ironsource/p6$a;", "", "Lcom/ironsource/p6;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final p6 a() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            e controllerManager = IronSourceNetwork.getControllerManager();
            Intrinsics.checkNotNullExpressionValue(controllerManager, "controllerManager");
            return new p6(uuid, new b9(uuid, controllerManager, (z6) null, (g0) null, 12, (DefaultConstructorMarker) null), new i6());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/ironsource/p6$b", "Lcom/ironsource/c9$a;", "Lcom/ironsource/r6;", "adData", "", "a", "", "reason", "b", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements c9.a {
        final /* synthetic */ p6 a;

        b(p6 p6Var) {
            this.a = p6Var;
        }

        public void a() {
            t6.a a2 = this.a.a();
            if (a2 != null) {
                a2.onNativeAdShown();
            }
        }

        public void a(r6 r6Var) {
            Intrinsics.checkNotNullParameter(r6Var, "adData");
            this.a.d = r6Var;
            h6 c = this.a.c;
            za.a aVar = za.l;
            Intrinsics.checkNotNullExpressionValue(aVar, "loadAdSuccess");
            HashMap<String, Object> a2 = this.a.c().a();
            Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
            c.a(aVar, a2);
            t6.a a3 = this.a.a();
            if (a3 != null) {
                a3.onNativeAdLoadSuccess(r6Var);
            }
        }

        public void a(String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            g6 a2 = this.a.c().a(z3.z, str);
            h6 c = this.a.c;
            za.a aVar = za.g;
            Intrinsics.checkNotNullExpressionValue(aVar, "loadAdFailed");
            HashMap<String, Object> a3 = a2.a();
            Intrinsics.checkNotNullExpressionValue(a3, "eventParams.data");
            c.a(aVar, a3);
            t6.a a4 = this.a.a();
            if (a4 != null) {
                a4.onNativeAdLoadFailed(str);
            }
        }

        public void b() {
            t6.a a2 = this.a.a();
            if (a2 != null) {
                a2.onNativeAdClicked();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/p6$c", "Lcom/ironsource/u6$a;", "Lcom/ironsource/u6$b;", "viewName", "", "a", "Lcom/ironsource/wc;", "viewVisibilityParams", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements u6.a {
        final /* synthetic */ p6 a;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[u6.b.values().length];
                try {
                    iArr[u6.b.PrivacyIcon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        c(p6 p6Var) {
            this.a = p6Var;
        }

        public void a(u6.b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "viewName");
            if (a.a[bVar.ordinal()] == 1) {
                this.a.b.b();
                return;
            }
            JSONObject put = new JSONObject().put("viewName", bVar.b());
            c9 b = this.a.b;
            Intrinsics.checkNotNullExpressionValue(put, "clickParams");
            b.a(put);
        }

        public void a(wc wcVar) {
            Intrinsics.checkNotNullParameter(wcVar, "viewVisibilityParams");
            this.a.b.a(wcVar);
        }
    }

    public p6(String str, c9 c9Var, h6 h6Var) {
        Intrinsics.checkNotNullParameter(str, w5.x);
        Intrinsics.checkNotNullParameter(c9Var, "controller");
        Intrinsics.checkNotNullParameter(h6Var, "eventTracker");
        this.a = str;
        this.b = c9Var;
        this.c = h6Var;
        c9Var.a((c9.a) e());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ p6(java.lang.String r1, com.ironsource.c9 r2, com.ironsource.h6 r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 1
            if (r4 == 0) goto L_0x0011
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x0011:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.p6.<init>(java.lang.String, com.ironsource.c9, com.ironsource.h6, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    public final g6 c() {
        g6 a2 = new g6().a(z3.w, this.f).a(z3.u, this.e).a(z3.v, e6.e.NativeAd.toString()).a(z3.G, Long.valueOf(i()));
        Intrinsics.checkNotNullExpressionValue(a2, "ISNEventParams()\n\t\t\t.add…CUSTOM_C, loadDuration())");
        return a2;
    }

    @JvmStatic
    public static final p6 d() {
        return j.a();
    }

    private final b e() {
        return new b(this);
    }

    private final c f() {
        return new c(this);
    }

    private final long i() {
        Long l = this.g;
        if (l == null) {
            return -1;
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue();
    }

    public t6.a a() {
        return this.h;
    }

    public void a(Activity activity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "loadParams");
        this.g = Long.valueOf(Calendar.getInstance().getTimeInMillis());
        this.e = jSONObject.optString("demandSourceName");
        this.f = jSONObject.optString("inAppBidding");
        h6 h6Var = this.c;
        za.a aVar = za.f;
        Intrinsics.checkNotNullExpressionValue(aVar, "loadAd");
        HashMap<String, Object> a2 = c().a();
        Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
        h6Var.a(aVar, a2);
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        jSONObject2.put(m2.h.y0, String.valueOf(this.g));
        this.b.a(activity, jSONObject2);
    }

    public void a(t6.a aVar) {
        this.h = aVar;
    }

    public void a(u6 u6Var) {
        Intrinsics.checkNotNullParameter(u6Var, "viewHolder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> a2 = c().a();
        Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
        linkedHashMap.putAll(a2);
        String jSONObject = u6Var.t().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put(z3.x, jSONObject);
        h6 h6Var = this.c;
        za.a aVar = za.n;
        Intrinsics.checkNotNullExpressionValue(aVar, "registerAd");
        h6Var.a(aVar, linkedHashMap);
        this.i = u6Var;
        u6Var.a((u6.a) f());
        this.b.a(u6Var);
    }

    public r6 b() {
        return this.d;
    }

    public void destroy() {
        u6 u6Var = this.i;
        if (u6Var != null) {
            u6Var.a((u6.a) null);
        }
        this.b.destroy();
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.f;
    }
}
