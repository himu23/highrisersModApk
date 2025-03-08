package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J1\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ironsource/i1;", "Lcom/ironsource/l;", "", "t", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "u", "Lcom/ironsource/k1;", "v", "userId", "providerList", "configs", "a", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "Ljava/util/List;", "j", "()Ljava/util/List;", "Lcom/ironsource/k1;", "w", "()Lcom/ironsource/k1;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/k1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class i1 extends l {
    private final String t;
    private final List<NetworkSettings> u;
    private final k1 v;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i1(java.lang.String r25, java.util.List<? extends com.ironsource.mediationsdk.model.NetworkSettings> r26, com.ironsource.k1 r27) {
        /*
            r24 = this;
            r9 = r24
            r15 = r27
            r0 = r24
            r2 = r25
            r3 = r26
            java.lang.String r1 = "configs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER
            com.ironsource.mediationsdk.utils.a r5 = r27.d()
            r4 = r5
            java.lang.String r6 = "configs.bannerAuctionSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            int r5 = r27.a()
            long r6 = r27.b()
            r8 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r8
            long r6 = r6 / r10
            int r6 = (int) r6
            boolean r7 = r27.c()
            int r8 = r27.g()
            com.ironsource.y r16 = new com.ironsource.y
            r10 = r16
            com.ironsource.y$a r17 = com.ironsource.y.a.MANUAL_WITH_AUTOMATIC_RELOAD
            com.ironsource.mediationsdk.utils.a r11 = r27.d()
            long r18 = r11.j()
            com.ironsource.mediationsdk.utils.a r11 = r27.d()
            long r20 = r11.b()
            int r11 = r27.i()
            long r11 = (long) r11
            r13 = 1000(0x3e8, double:4.94E-321)
            long r22 = r11 * r13
            r16.<init>(r17, r18, r20, r22)
            boolean r11 = r27.e()
            long r12 = r27.f()
            boolean r14 = r27.l()
            boolean r16 = r27.o()
            r15 = r16
            boolean r16 = r27.n()
            boolean r17 = r27.m()
            r18 = -1
            r9 = r18
            r18 = 0
            r19 = 65536(0x10000, float:9.18355E-41)
            r20 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20)
            r1 = r25
            r0.t = r1
            r1 = r26
            r0.u = r1
            r1 = r27
            r0.v = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.i1.<init>(java.lang.String, java.util.List, com.ironsource.k1):void");
    }

    public static /* synthetic */ i1 a(i1 i1Var, String str, List<NetworkSettings> list, k1 k1Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = i1Var.p();
        }
        if ((i & 2) != 0) {
            list = i1Var.j();
        }
        if ((i & 4) != 0) {
            k1Var = i1Var.v;
        }
        return i1Var.a(str, list, k1Var);
    }

    public final i1 a(String str, List<? extends NetworkSettings> list, k1 k1Var) {
        Intrinsics.checkNotNullParameter(k1Var, w5.p);
        return new i1(str, list, k1Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return Intrinsics.areEqual((Object) p(), (Object) i1Var.p()) && Intrinsics.areEqual((Object) j(), (Object) i1Var.j()) && Intrinsics.areEqual((Object) this.v, (Object) i1Var.v);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (p() == null ? 0 : p().hashCode()) * 31;
        if (j() != null) {
            i = j().hashCode();
        }
        return ((hashCode + i) * 31) + this.v.hashCode();
    }

    public List<NetworkSettings> j() {
        return this.u;
    }

    public String p() {
        return this.t;
    }

    public final String t() {
        return p();
    }

    public String toString() {
        return "BannerAdManagerData(userId=" + p() + ", providerList=" + j() + ", configs=" + this.v + ')';
    }

    public final List<NetworkSettings> u() {
        return j();
    }

    public final k1 v() {
        return this.v;
    }

    public final k1 w() {
        return this.v;
    }
}
