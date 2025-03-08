package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J;\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ironsource/qa;", "Lcom/ironsource/l;", "", "t", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "u", "Lcom/ironsource/ua;", "v", "", "w", "userId", "providerList", "configs", "isManual", "a", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "Ljava/util/List;", "j", "()Ljava/util/List;", "Lcom/ironsource/ua;", "x", "()Lcom/ironsource/ua;", "Z", "y", "()Z", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/ua;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class qa extends l {
    private final String t;
    private final List<NetworkSettings> u;
    private final ua v;
    private final boolean w;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public qa(java.lang.String r22, java.util.List<? extends com.ironsource.mediationsdk.model.NetworkSettings> r23, com.ironsource.ua r24, boolean r25) {
        /*
            r21 = this;
            r15 = r21
            r14 = r24
            r0 = r21
            r2 = r22
            r3 = r23
            java.lang.String r1 = "configs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO
            com.ironsource.mediationsdk.utils.a r5 = r24.k()
            r4 = r5
            java.lang.String r6 = "configs.rewardedVideoAuctionSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            int r5 = r24.g()
            int r6 = r24.h()
            boolean r7 = r24.j()
            int r8 = r24.b()
            int r9 = r24.c()
            com.ironsource.y r10 = com.ironsource.ra.a(r24, r25)
            boolean r11 = r24.l()
            long r12 = r24.m()
            boolean r16 = r24.f()
            r14 = r16
            boolean r16 = r24.q()
            r15 = r16
            boolean r16 = r24.p()
            boolean r17 = r24.o()
            r18 = 0
            r19 = 65536(0x10000, float:9.18355E-41)
            r20 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20)
            r1 = r22
            r0.t = r1
            r1 = r23
            r0.u = r1
            r1 = r24
            r0.v = r1
            r1 = r25
            r0.w = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.qa.<init>(java.lang.String, java.util.List, com.ironsource.ua, boolean):void");
    }

    public static /* synthetic */ qa a(qa qaVar, String str, List<NetworkSettings> list, ua uaVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qaVar.p();
        }
        if ((i & 2) != 0) {
            list = qaVar.j();
        }
        if ((i & 4) != 0) {
            uaVar = qaVar.v;
        }
        if ((i & 8) != 0) {
            z = qaVar.w;
        }
        return qaVar.a(str, list, uaVar, z);
    }

    public final qa a(String str, List<? extends NetworkSettings> list, ua uaVar, boolean z) {
        Intrinsics.checkNotNullParameter(uaVar, w5.p);
        return new qa(str, list, uaVar, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qa)) {
            return false;
        }
        qa qaVar = (qa) obj;
        return Intrinsics.areEqual((Object) p(), (Object) qaVar.p()) && Intrinsics.areEqual((Object) j(), (Object) qaVar.j()) && Intrinsics.areEqual((Object) this.v, (Object) qaVar.v) && this.w == qaVar.w;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (p() == null ? 0 : p().hashCode()) * 31;
        if (j() != null) {
            i = j().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + this.v.hashCode()) * 31;
        boolean z = this.w;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
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
        return "RewardedVideoAdDataManager(userId=" + p() + ", providerList=" + j() + ", configs=" + this.v + ", isManual=" + this.w + ')';
    }

    public final List<NetworkSettings> u() {
        return j();
    }

    public final ua v() {
        return this.v;
    }

    public final boolean w() {
        return this.w;
    }

    public final ua x() {
        return this.v;
    }

    public final boolean y() {
        return this.w;
    }
}
