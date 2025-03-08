package com.ironsource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0003\u0010\u0012R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0005\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0004\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/ironsource/d2;", "", "", "a", "b", "c", "cachedAppKey", "cachedUserId", "cachedSettings", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "f", "e", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class d2 {
    private String a;
    private String b;
    private String c;

    public d2(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "cachedAppKey");
        Intrinsics.checkNotNullParameter(str2, "cachedUserId");
        Intrinsics.checkNotNullParameter(str3, "cachedSettings");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ d2 a(d2 d2Var, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = d2Var.a;
        }
        if ((i & 2) != 0) {
            str2 = d2Var.b;
        }
        if ((i & 4) != 0) {
            str3 = d2Var.c;
        }
        return d2Var.a(str, str2, str3);
    }

    public final d2 a(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "cachedAppKey");
        Intrinsics.checkNotNullParameter(str2, "cachedUserId");
        Intrinsics.checkNotNullParameter(str3, "cachedSettings");
        return new d2(str, str2, str3);
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) d2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) d2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) d2Var.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CachedResponse(cachedAppKey=" + this.a + ", cachedUserId=" + this.b + ", cachedSettings=" + this.c + ')';
    }
}
