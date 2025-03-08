package com.ironsource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import com.ironsource.m2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001:\u0002\u0003\u0004BK\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J[\u0010\u0003\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/ironsource/r6;", "", "", "a", "b", "c", "d", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/webkit/WebView;", "f", "Landroid/view/View;", "g", "title", "advertiser", "body", "cta", "icon", "mediaView", "privacyIcon", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "h", "i", "j", "Landroid/graphics/drawable/Drawable;", "k", "()Landroid/graphics/drawable/Drawable;", "Landroid/webkit/WebView;", "l", "()Landroid/webkit/WebView;", "Landroid/view/View;", "m", "()Landroid/view/View;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/webkit/WebView;Landroid/view/View;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class r6 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final Drawable e;
    private final WebView f;
    private final View g;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0016\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/ironsource/r6$a;", "", "", "adViewId", "Lkotlin/Result;", "Landroid/webkit/WebView;", "a", "(Ljava/lang/String;)Lkotlin/Result;", "iconUrl", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/content/Context;", "activityContext", "Lorg/json/JSONObject;", "json", "Lcom/ironsource/r6$b;", "Lcom/ironsource/z6;", "Lcom/ironsource/z6;", "imageLoader", "Lcom/ironsource/g0;", "Lcom/ironsource/g0;", "adViewManagement", "<init>", "(Lcom/ironsource/z6;Lcom/ironsource/g0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private final z6 a;
        private final g0 b;

        public a(z6 z6Var, g0 g0Var) {
            Intrinsics.checkNotNullParameter(z6Var, "imageLoader");
            Intrinsics.checkNotNullParameter(g0Var, "adViewManagement");
            this.a = z6Var;
            this.b = g0Var;
        }

        private final Result<WebView> a(String str) {
            Object obj;
            WebView webView = null;
            if (str == null) {
                return null;
            }
            v6 a2 = this.b.a(str);
            if (a2 != null) {
                webView = a2.getPresentingView();
            }
            if (webView == null) {
                Result.Companion companion = Result.Companion;
                obj = Result.m144constructorimpl(ResultKt.createFailure(new Exception("missing adview for id: '" + str + '\'')));
            } else {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m144constructorimpl(webView);
            }
            return Result.m143boximpl(obj);
        }

        private final Result<Drawable> b(String str) {
            if (str == null) {
                return null;
            }
            return Result.m143boximpl(this.a.a(str));
        }

        public final b a(Context context, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(context, "activityContext");
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject optJSONObject = jSONObject.optJSONObject(m2.h.D0);
            String str = null;
            String a2 = optJSONObject != null ? s6.b(optJSONObject, m2.h.K0) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(m2.h.F0);
            String a3 = optJSONObject2 != null ? s6.b(optJSONObject2, m2.h.K0) : null;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(m2.h.E0);
            String a4 = optJSONObject3 != null ? s6.b(optJSONObject3, m2.h.K0) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject(m2.h.G0);
            String a5 = optJSONObject4 != null ? s6.b(optJSONObject4, m2.h.K0) : null;
            JSONObject optJSONObject5 = jSONObject.optJSONObject(m2.h.H0);
            String a6 = optJSONObject5 != null ? s6.b(optJSONObject5, "url") : null;
            JSONObject optJSONObject6 = jSONObject.optJSONObject(m2.h.I0);
            String a7 = optJSONObject6 != null ? s6.b(optJSONObject6, "adViewId") : null;
            JSONObject optJSONObject7 = jSONObject.optJSONObject(m2.h.J0);
            if (optJSONObject7 != null) {
                str = s6.b(optJSONObject7, "url");
            }
            return new b(new b.a(a2, a3, a4, a5, b(a6), a(a7), ja.a.a(context, str, this.a)));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ironsource/r6$b;", "", "Lorg/json/JSONObject;", "b", "Lcom/ironsource/r6$b$a;", "a", "Lcom/ironsource/r6$b$a;", "()Lcom/ironsource/r6$b$a;", "data", "<init>", "(Lcom/ironsource/r6$b$a;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        private final a a;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BZ\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\u0006\u0010\u0017\u001a\u00020\u000fø\u0001\u0002¢\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\fJ\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003Jj\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001ø\u0001\u0002J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b!\u0010 R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\"\u0010 R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b#\u0010 R(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010\fR(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t8\u0006ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b&\u0010\fR\u0017\u0010\u0017\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010)\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/ironsource/r6$b$a;", "", "Lcom/ironsource/r6;", "h", "", "a", "b", "c", "d", "Lkotlin/Result;", "Landroid/graphics/drawable/Drawable;", "e", "()Lkotlin/Result;", "Landroid/webkit/WebView;", "f", "Landroid/view/View;", "g", "title", "advertiser", "body", "cta", "icon", "media", "privacyIcon", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "i", "j", "k", "Lkotlin/Result;", "l", "m", "Landroid/view/View;", "n", "()Landroid/view/View;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/Result;Lkotlin/Result;Landroid/view/View;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {
            private final String a;
            private final String b;
            private final String c;
            private final String d;
            private final Result<Drawable> e;
            private final Result<WebView> f;
            private final View g;

            public a(String str, String str2, String str3, String str4, Result<? extends Drawable> result, Result<? extends WebView> result2, View view) {
                Intrinsics.checkNotNullParameter(view, m2.h.J0);
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = result;
                this.f = result2;
                this.g = view;
            }

            public static /* synthetic */ a a(a aVar, String str, String str2, String str3, String str4, Result<Drawable> result, Result<WebView> result2, View view, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = aVar.a;
                }
                if ((i & 2) != 0) {
                    str2 = aVar.b;
                }
                String str5 = str2;
                if ((i & 4) != 0) {
                    str3 = aVar.c;
                }
                String str6 = str3;
                if ((i & 8) != 0) {
                    str4 = aVar.d;
                }
                String str7 = str4;
                if ((i & 16) != 0) {
                    result = aVar.e;
                }
                Result<Drawable> result3 = result;
                if ((i & 32) != 0) {
                    result2 = aVar.f;
                }
                Result<WebView> result4 = result2;
                if ((i & 64) != 0) {
                    view = aVar.g;
                }
                return aVar.a(str, str5, str6, str7, result3, result4, view);
            }

            public final a a(String str, String str2, String str3, String str4, Result<? extends Drawable> result, Result<? extends WebView> result2, View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, m2.h.J0);
                return new a(str, str2, str3, str4, result, result2, view2);
            }

            public final String a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }

            public final String c() {
                return this.c;
            }

            public final String d() {
                return this.d;
            }

            public final Result<Drawable> e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics.areEqual((Object) this.a, (Object) aVar.a) && Intrinsics.areEqual((Object) this.b, (Object) aVar.b) && Intrinsics.areEqual((Object) this.c, (Object) aVar.c) && Intrinsics.areEqual((Object) this.d, (Object) aVar.d) && Intrinsics.areEqual((Object) this.e, (Object) aVar.e) && Intrinsics.areEqual((Object) this.f, (Object) aVar.f) && Intrinsics.areEqual((Object) this.g, (Object) aVar.g);
            }

            public final Result<WebView> f() {
                return this.f;
            }

            public final View g() {
                return this.g;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: android.webkit.WebView} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.webkit.WebView} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.webkit.WebView} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.webkit.WebView} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.ironsource.r6 h() {
                /*
                    r10 = this;
                    com.ironsource.r6 r8 = new com.ironsource.r6
                    java.lang.String r1 = r10.a
                    java.lang.String r2 = r10.b
                    java.lang.String r3 = r10.c
                    java.lang.String r4 = r10.d
                    kotlin.Result<android.graphics.drawable.Drawable> r0 = r10.e
                    r5 = 0
                    if (r0 == 0) goto L_0x001e
                    java.lang.Object r0 = r0.m153unboximpl()
                    boolean r6 = kotlin.Result.m150isFailureimpl(r0)
                    if (r6 == 0) goto L_0x001a
                    r0 = r5
                L_0x001a:
                    android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
                    r6 = r0
                    goto L_0x001f
                L_0x001e:
                    r6 = r5
                L_0x001f:
                    kotlin.Result<android.webkit.WebView> r0 = r10.f
                    if (r0 == 0) goto L_0x0031
                    java.lang.Object r0 = r0.m153unboximpl()
                    boolean r7 = kotlin.Result.m150isFailureimpl(r0)
                    if (r7 == 0) goto L_0x002e
                    goto L_0x002f
                L_0x002e:
                    r5 = r0
                L_0x002f:
                    android.webkit.WebView r5 = (android.webkit.WebView) r5
                L_0x0031:
                    r7 = r5
                    android.view.View r9 = r10.g
                    r0 = r8
                    r5 = r6
                    r6 = r7
                    r7 = r9
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.r6.b.a.h():com.ironsource.r6");
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Result<Drawable> result = this.e;
                int r0 = (hashCode4 + (result == null ? 0 : Result.m149hashCodeimpl(result.m153unboximpl()))) * 31;
                Result<WebView> result2 = this.f;
                if (result2 != null) {
                    i = Result.m149hashCodeimpl(result2.m153unboximpl());
                }
                return ((r0 + i) * 31) + this.g.hashCode();
            }

            public final String i() {
                return this.b;
            }

            public final String j() {
                return this.c;
            }

            public final String k() {
                return this.d;
            }

            public final Result<Drawable> l() {
                return this.e;
            }

            public final Result<WebView> m() {
                return this.f;
            }

            public final View n() {
                return this.g;
            }

            public final String o() {
                return this.a;
            }

            public String toString() {
                return "Data(title=" + this.a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", media=" + this.f + ", privacyIcon=" + this.g + ')';
            }
        }

        public b(a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "data");
            this.a = aVar;
        }

        private static final void a(JSONObject jSONObject, String str) {
            jSONObject.put(str, new JSONObject().put("success", true));
        }

        private static final <T> void a(JSONObject jSONObject, String str, Object obj) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", Result.m151isSuccessimpl(obj));
            Throwable r5 = Result.m147exceptionOrNullimpl(obj);
            if (r5 != null) {
                String message = r5.getMessage();
                if (message == null) {
                    message = "unknown reason";
                }
                jSONObject2.put("reason", message);
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put(str, jSONObject2);
        }

        public final a a() {
            return this.a;
        }

        public final JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            if (this.a.o() != null) {
                a(jSONObject, m2.h.D0);
            }
            if (this.a.i() != null) {
                a(jSONObject, m2.h.F0);
            }
            if (this.a.j() != null) {
                a(jSONObject, m2.h.E0);
            }
            if (this.a.k() != null) {
                a(jSONObject, m2.h.G0);
            }
            Result<Drawable> l = this.a.l();
            if (l != null) {
                a(jSONObject, m2.h.H0, l.m153unboximpl());
            }
            Result<WebView> m = this.a.m();
            if (m != null) {
                a(jSONObject, m2.h.I0, m.m153unboximpl());
            }
            return jSONObject;
        }
    }

    public r6(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view) {
        Intrinsics.checkNotNullParameter(view, m2.h.J0);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = drawable;
        this.f = webView;
        this.g = view;
    }

    public static /* synthetic */ r6 a(r6 r6Var, String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            str = r6Var.a;
        }
        if ((i & 2) != 0) {
            str2 = r6Var.b;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = r6Var.c;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = r6Var.d;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            drawable = r6Var.e;
        }
        Drawable drawable2 = drawable;
        if ((i & 32) != 0) {
            webView = r6Var.f;
        }
        WebView webView2 = webView;
        if ((i & 64) != 0) {
            view = r6Var.g;
        }
        return r6Var.a(str, str5, str6, str7, drawable2, webView2, view);
    }

    public final r6 a(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, m2.h.J0);
        return new r6(str, str2, str3, str4, drawable, webView, view2);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final Drawable e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r6)) {
            return false;
        }
        r6 r6Var = (r6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) r6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) r6Var.b) && Intrinsics.areEqual((Object) this.c, (Object) r6Var.c) && Intrinsics.areEqual((Object) this.d, (Object) r6Var.d) && Intrinsics.areEqual((Object) this.e, (Object) r6Var.e) && Intrinsics.areEqual((Object) this.f, (Object) r6Var.f) && Intrinsics.areEqual((Object) this.g, (Object) r6Var.g);
    }

    public final WebView f() {
        return this.f;
    }

    public final View g() {
        return this.g;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Drawable drawable = this.e;
        int hashCode5 = (hashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        WebView webView = this.f;
        if (webView != null) {
            i = webView.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.g.hashCode();
    }

    public final String i() {
        return this.c;
    }

    public final String j() {
        return this.d;
    }

    public final Drawable k() {
        return this.e;
    }

    public final WebView l() {
        return this.f;
    }

    public final View m() {
        return this.g;
    }

    public final String n() {
        return this.a;
    }

    public String toString() {
        return "ISNNativeAdData(title=" + this.a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", mediaView=" + this.f + ", privacyIcon=" + this.g + ')';
    }
}
