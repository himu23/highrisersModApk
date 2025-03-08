package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J1\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/ironsource/mediationsdk/b;", "", "Lcom/ironsource/mediationsdk/s$d;", "a", "", "b", "c", "d", "sdkState", "isRetryForMoreThan15Secs", "isDemandOnlyInitRequested", "isAdUnitInitRequested", "", "toString", "", "hashCode", "other", "equals", "Lcom/ironsource/mediationsdk/s$d;", "e", "()Lcom/ironsource/mediationsdk/s$d;", "Z", "h", "()Z", "g", "f", "<init>", "(Lcom/ironsource/mediationsdk/s$d;ZZZ)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
final class b {
    private final s.d a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public b(s.d dVar, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(dVar, "sdkState");
        this.a = dVar;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public static /* synthetic */ b a(b bVar, s.d dVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = bVar.a;
        }
        if ((i & 2) != 0) {
            z = bVar.b;
        }
        if ((i & 4) != 0) {
            z2 = bVar.c;
        }
        if ((i & 8) != 0) {
            z3 = bVar.d;
        }
        return bVar.a(dVar, z, z2, z3);
    }

    public final b a(s.d dVar, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(dVar, "sdkState");
        return new b(dVar, z, z2, z3);
    }

    public final s.d a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final s.d e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
    }

    public final boolean f() {
        return this.d;
    }

    public final boolean g() {
        return this.c;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.c;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.d;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "AdUnitInitStateInfo(sdkState=" + this.a + ", isRetryForMoreThan15Secs=" + this.b + ", isDemandOnlyInitRequested=" + this.c + ", isAdUnitInitRequested=" + this.d + ')';
    }
}
