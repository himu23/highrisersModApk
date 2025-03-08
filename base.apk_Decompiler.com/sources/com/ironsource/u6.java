package com.ironsource;

import android.view.View;
import com.ironsource.m2;
import com.ironsource.q6;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0002\t\u000bB_\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u0011\u001a\u00020\nHÆ\u0003Je\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001cHÖ\u0001J\u0013\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b\t\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\u0010\u0010(R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b)\u0010'\"\u0004\b\t\u0010(R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b*\u0010'\"\u0004\b\r\u0010(R$\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b+\u0010'\"\u0004\b\u000b\u0010(R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b,\u0010'\"\u0004\b\u000e\u0010(R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b-\u0010'\"\u0004\b\f\u0010(R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b.\u0010'\"\u0004\b\u000f\u0010(R$\u00104\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u00100\u001a\u0004\b1\u00102\"\u0004\b\t\u00103¨\u00067"}, d2 = {"Lcom/ironsource/u6;", "", "", "r", "s", "Lorg/json/JSONObject;", "t", "()Lorg/json/JSONObject;", "Lcom/ironsource/q6;", "a", "Landroid/view/View;", "b", "c", "d", "e", "f", "g", "h", "containerView", "titleView", "advertiserView", "iconView", "bodyView", "mediaView", "ctaView", "privacyIconView", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/ironsource/q6;", "k", "()Lcom/ironsource/q6;", "(Lcom/ironsource/q6;)V", "Landroid/view/View;", "q", "()Landroid/view/View;", "(Landroid/view/View;)V", "i", "m", "j", "o", "l", "p", "Lcom/ironsource/u6$a;", "Lcom/ironsource/u6$a;", "n", "()Lcom/ironsource/u6$a;", "(Lcom/ironsource/u6$a;)V", "listener", "<init>", "(Lcom/ironsource/q6;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class u6 {
    private q6 a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private a i;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/ironsource/u6$a;", "", "Lcom/ironsource/u6$b;", "viewName", "", "a", "Lcom/ironsource/wc;", "viewVisibilityParams", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(b bVar);

        void a(wc wcVar);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0005j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ironsource/u6$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "c", "d", "e", "f", "g", "h", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public enum b {
        Title(m2.h.D0),
        Advertiser(m2.h.F0),
        Body(m2.h.E0),
        Cta(m2.h.G0),
        Icon(m2.h.H0),
        Container("container"),
        PrivacyIcon(m2.h.J0);
        
        private final String a;

        private b(String str) {
            this.a = str;
        }

        public final String b() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/u6$c", "Lcom/ironsource/q6$a;", "Lcom/ironsource/wc;", "viewVisibilityParams", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements q6.a {
        final /* synthetic */ u6 a;

        c(u6 u6Var) {
            this.a = u6Var;
        }

        public void a(wc wcVar) {
            Intrinsics.checkNotNullParameter(wcVar, "viewVisibilityParams");
            a n = this.a.n();
            if (n != null) {
                n.a(wcVar);
            }
        }
    }

    public u6(q6 q6Var, View view, View view2, View view3, View view4, View view5, View view6, View view7) {
        Intrinsics.checkNotNullParameter(q6Var, "containerView");
        Intrinsics.checkNotNullParameter(view7, "privacyIconView");
        this.a = q6Var;
        this.b = view;
        this.c = view2;
        this.d = view3;
        this.e = view4;
        this.f = view5;
        this.g = view6;
        this.h = view7;
        r();
        s();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u6(q6 q6Var, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(q6Var, (i2 & 2) != 0 ? null : view, (i2 & 4) != 0 ? null : view2, (i2 & 8) != 0 ? null : view3, (i2 & 16) != 0 ? null : view4, (i2 & 32) != 0 ? null : view5, (i2 & 64) != 0 ? null : view6, view7);
    }

    public static /* synthetic */ u6 a(u6 u6Var, q6 q6Var, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i2, Object obj) {
        u6 u6Var2 = u6Var;
        int i3 = i2;
        return u6Var.a((i3 & 1) != 0 ? u6Var2.a : q6Var, (i3 & 2) != 0 ? u6Var2.b : view, (i3 & 4) != 0 ? u6Var2.c : view2, (i3 & 8) != 0 ? u6Var2.d : view3, (i3 & 16) != 0 ? u6Var2.e : view4, (i3 & 32) != 0 ? u6Var2.f : view5, (i3 & 64) != 0 ? u6Var2.g : view6, (i3 & 128) != 0 ? u6Var2.h : view7);
    }

    private static final void a(u6 u6Var, View view, b bVar) {
        if (view != null) {
            view.setOnClickListener(new u6$$ExternalSyntheticLambda0(u6Var, bVar));
        }
    }

    /* access modifiers changed from: private */
    public static final void a(u6 u6Var, b bVar, View view) {
        Intrinsics.checkNotNullParameter(u6Var, "this$0");
        Intrinsics.checkNotNullParameter(bVar, "$viewName");
        a aVar = u6Var.i;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    private final void r() {
        a(this, this.b, b.Title);
        a(this, this.c, b.Advertiser);
        a(this, this.e, b.Body);
        a(this, this.g, b.Cta);
        a(this, this.d, b.Icon);
        a(this, (View) this.a, b.Container);
        a(this, this.h, b.PrivacyIcon);
    }

    private final void s() {
        this.a.setListener$mediationsdk_release(new c(this));
    }

    public final q6 a() {
        return this.a;
    }

    public final u6 a(q6 q6Var, View view, View view2, View view3, View view4, View view5, View view6, View view7) {
        Intrinsics.checkNotNullParameter(q6Var, "containerView");
        View view8 = view7;
        Intrinsics.checkNotNullParameter(view8, "privacyIconView");
        return new u6(q6Var, view, view2, view3, view4, view5, view6, view8);
    }

    public final void a(View view) {
        this.c = view;
    }

    public final void a(q6 q6Var) {
        Intrinsics.checkNotNullParameter(q6Var, "<set-?>");
        this.a = q6Var;
    }

    public final void a(a aVar) {
        this.i = aVar;
    }

    public final View b() {
        return this.b;
    }

    public final void b(View view) {
        this.e = view;
    }

    public final View c() {
        return this.c;
    }

    public final void c(View view) {
        this.g = view;
    }

    public final View d() {
        return this.d;
    }

    public final void d(View view) {
        this.d = view;
    }

    public final View e() {
        return this.e;
    }

    public final void e(View view) {
        this.f = view;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u6)) {
            return false;
        }
        u6 u6Var = (u6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) u6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) u6Var.b) && Intrinsics.areEqual((Object) this.c, (Object) u6Var.c) && Intrinsics.areEqual((Object) this.d, (Object) u6Var.d) && Intrinsics.areEqual((Object) this.e, (Object) u6Var.e) && Intrinsics.areEqual((Object) this.f, (Object) u6Var.f) && Intrinsics.areEqual((Object) this.g, (Object) u6Var.g) && Intrinsics.areEqual((Object) this.h, (Object) u6Var.h);
    }

    public final View f() {
        return this.f;
    }

    public final void f(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.h = view;
    }

    public final View g() {
        return this.g;
    }

    public final void g(View view) {
        this.b = view;
    }

    public final View h() {
        return this.h;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        View view = this.b;
        int i2 = 0;
        int hashCode2 = (hashCode + (view == null ? 0 : view.hashCode())) * 31;
        View view2 = this.c;
        int hashCode3 = (hashCode2 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.d;
        int hashCode4 = (hashCode3 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.e;
        int hashCode5 = (hashCode4 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.f;
        int hashCode6 = (hashCode5 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.g;
        if (view6 != null) {
            i2 = view6.hashCode();
        }
        return ((hashCode6 + i2) * 31) + this.h.hashCode();
    }

    public final View i() {
        return this.c;
    }

    public final View j() {
        return this.e;
    }

    public final q6 k() {
        return this.a;
    }

    public final View l() {
        return this.g;
    }

    public final View m() {
        return this.d;
    }

    public final a n() {
        return this.i;
    }

    public final View o() {
        return this.f;
    }

    public final View p() {
        return this.h;
    }

    public final View q() {
        return this.b;
    }

    public final JSONObject t() {
        boolean z = true;
        JSONObject put = new JSONObject().put(m2.h.D0, this.b != null).put(m2.h.F0, this.c != null).put(m2.h.E0, this.e != null).put(m2.h.G0, this.g != null).put(m2.h.I0, this.f != null);
        if (this.d == null) {
            z = false;
        }
        JSONObject put2 = put.put(m2.h.H0, z);
        Intrinsics.checkNotNullExpressionValue(put2, "JSONObject()\n\t\t\t.put(\"ti…\"icon\", iconView != null)");
        return put2;
    }

    public String toString() {
        return "ISNNativeAdViewHolder(containerView=" + this.a + ", titleView=" + this.b + ", advertiserView=" + this.c + ", iconView=" + this.d + ", bodyView=" + this.e + ", mediaView=" + this.f + ", ctaView=" + this.g + ", privacyIconView=" + this.h + ')';
    }
}
