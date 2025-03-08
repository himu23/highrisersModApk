package com.ironsource;

import com.ironsource.mediationsdk.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0003\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0003\u0010\u0019R.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0005\u0010\u001fR$\u0010%\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\"\u001a\u0004\b\u0017\u0010#\"\u0004\b\u0003\u0010$R.\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u0013\u0010\u001e\"\u0004\b\u0003\u0010\u001f¨\u0006*"}, d2 = {"Lcom/ironsource/b1;", "", "", "a", "", "b", "name", "bidder", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "Z", "e", "()Z", "c", "i", "(Z)V", "useTestAds", "d", "h", "(Ljava/lang/String;)V", "plumbus", "", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "biddingData", "Lcom/ironsource/mediationsdk/h;", "Lcom/ironsource/mediationsdk/h;", "()Lcom/ironsource/mediationsdk/h;", "(Lcom/ironsource/mediationsdk/h;)V", "auctionHistory", "", "additionalData", "<init>", "(Ljava/lang/String;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class b1 {
    private final String a;
    private final boolean b;
    private boolean c;
    private String d = "";
    private Map<String, ? extends Object> e = MapsKt.emptyMap();
    private h f;
    private Map<String, Object> g = new HashMap();

    public b1(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = z;
    }

    public static /* synthetic */ b1 a(b1 b1Var, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = b1Var.a;
        }
        if ((i & 2) != 0) {
            z = b1Var.b;
        }
        return b1Var.a(str, z);
    }

    public final b1 a(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new b1(str, z);
    }

    public final String a() {
        return this.a;
    }

    public final void a(h hVar) {
        this.f = hVar;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void a(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.g = map;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.e = map;
    }

    public final boolean b() {
        return this.b;
    }

    public final Map<String, Object> c() {
        return this.g;
    }

    public final h d() {
        return this.f;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) b1Var.a) && this.b == b1Var.b;
    }

    public final Map<String, Object> f() {
        return this.e;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final boolean i() {
        return this.c;
    }

    public String toString() {
        return "AuctionRequestInstanceInfo(name=" + this.a + ", bidder=" + this.b + ')';
    }
}
