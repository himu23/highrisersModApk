package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001\u0005Bg\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010>\u001a\u00020\u0011\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010/\u001a\u00020\u0018\u0012\u0006\u0010?\u001a\u00020\t\u0012\u0006\u0010@\u001a\u00020\u001e\u0012\u0006\u0010A\u001a\u00020\t\u0012\u0006\u0010B\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0006H\u0016R\u001a\u0010\r\u001a\u00020\t8\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\t8\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0005\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u0005\u0010\u001cR\"\u0010#\u001a\u00020\u001e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010!\"\u0004\b\u0005\u0010\"R\"\u0010&\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b\u0005\u0010\f\"\u0004\b\u0005\u0010%R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00020'j\b\u0012\u0004\u0012\u00020\u0002`(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020\u00188\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b$\u0010\u001b\"\u0004\b\u000e\u0010\u001cR\"\u00105\u001a\u0002008\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\u0019\u00103\"\u0004\b\u0005\u00104R\"\u00106\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b\u000e\u0010%R\"\u00107\u001a\u00020\u001e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b.\u0010!\"\u0004\b\u000e\u0010\"R\"\u00109\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b8\u0010\n\u001a\u0004\b1\u0010\f\"\u0004\b\u0012\u0010%R\"\u0010;\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b:\u0010\n\u001a\u0004\b8\u0010\f\"\u0004\b\u0019\u0010%R\u0013\u0010=\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010<¨\u0006F"}, d2 = {"Lcom/ironsource/a9;", "", "Lcom/ironsource/g9;", "placement", "", "a", "", "placementName", "toString", "", "Z", "l", "()Z", "mThreadPerManager", "b", "k", "mSharedManagersThread", "Lcom/ironsource/m0;", "c", "Lcom/ironsource/m0;", "g", "()Lcom/ironsource/m0;", "(Lcom/ironsource/m0;)V", "eventsConfigurations", "", "d", "I", "()I", "(I)V", "adaptersSmartLoadAmount", "", "e", "J", "()J", "(J)V", "adaptersSmartLoadTimeoutInMills", "f", "(Z)V", "adapterAdvancedLoading", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mPlacements", "h", "Lcom/ironsource/g9;", "mDefaultPlacement", "i", "delayLoadFailure", "Lcom/ironsource/mediationsdk/utils/a;", "j", "Lcom/ironsource/mediationsdk/utils/a;", "()Lcom/ironsource/mediationsdk/utils/a;", "(Lcom/ironsource/mediationsdk/utils/a;)V", "auctionSettings", "mCollectBiddingDataAsyncEnabled", "mCollectBiddingDataTimeout", "m", "mProvidersParallelInit", "n", "mWaitUntilAllProvidersFinishInit", "()Lcom/ironsource/g9;", "defaultPlacement", "events", "collectBiddingDataAsyncEnabled", "collectBiddingDataTimeout", "providersParallelInit", "waitUntilAllProvidersFinishInit", "<init>", "(IJZLcom/ironsource/m0;Lcom/ironsource/mediationsdk/utils/a;IZJZZZZ)V", "o", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class a9 {
    public static final a o = new a((DefaultConstructorMarker) null);
    private static final int p = 0;
    private final boolean a;
    private final boolean b;
    private m0 c;
    private int d;
    private long e;
    private boolean f;
    private final ArrayList<g9> g = new ArrayList<>();
    private g9 h;
    private int i;
    private com.ironsource.mediationsdk.utils.a j;
    private boolean k;
    private long l;
    private boolean m;
    private boolean n;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ironsource/a9$a;", "", "", "DEFAULT_NA_PLACEMENT_ID", "I", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a9(int i2, long j2, boolean z, m0 m0Var, com.ironsource.mediationsdk.utils.a aVar, int i3, boolean z2, long j3, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(m0Var, "events");
        Intrinsics.checkNotNullParameter(aVar, "auctionSettings");
        this.a = z5;
        this.b = z6;
        this.d = i2;
        this.e = j2;
        this.f = z;
        this.c = m0Var;
        this.i = i3;
        this.j = aVar;
        this.k = z2;
        this.l = j3;
        this.m = z3;
        this.n = z4;
    }

    public final g9 a(String str) {
        Intrinsics.checkNotNullParameter(str, "placementName");
        Iterator<g9> it = this.g.iterator();
        while (it.hasNext()) {
            g9 next = it.next();
            if (Intrinsics.areEqual((Object) next.getPlacementName(), (Object) str)) {
                return next;
            }
        }
        return null;
    }

    public final void a(int i2) {
        this.d = i2;
    }

    public final void a(long j2) {
        this.e = j2;
    }

    public final void a(g9 g9Var) {
        if (g9Var != null) {
            this.g.add(g9Var);
            if (this.h == null || g9Var.getPlacementId() == 0) {
                this.h = g9Var;
            }
        }
    }

    public final void a(m0 m0Var) {
        Intrinsics.checkNotNullParameter(m0Var, "<set-?>");
        this.c = m0Var;
    }

    public final void a(com.ironsource.mediationsdk.utils.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.j = aVar;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final boolean a() {
        return this.f;
    }

    public final int b() {
        return this.d;
    }

    public final void b(int i2) {
        this.i = i2;
    }

    public final void b(long j2) {
        this.l = j2;
    }

    public final void b(boolean z) {
        this.k = z;
    }

    public final long c() {
        return this.e;
    }

    public final void c(boolean z) {
        this.m = z;
    }

    public final com.ironsource.mediationsdk.utils.a d() {
        return this.j;
    }

    public final void d(boolean z) {
        this.n = z;
    }

    public final g9 e() {
        Iterator<g9> it = this.g.iterator();
        while (it.hasNext()) {
            g9 next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.h;
    }

    public final int f() {
        return this.i;
    }

    public final m0 g() {
        return this.c;
    }

    public final boolean h() {
        return this.k;
    }

    public final long i() {
        return this.l;
    }

    public final boolean j() {
        return this.m;
    }

    public final boolean k() {
        return this.b;
    }

    public final boolean l() {
        return this.a;
    }

    public final boolean m() {
        return this.n;
    }

    public String toString() {
        return "NativeAdConfigurations{parallelLoad=" + this.d + ", bidderExclusive=" + this.f + '}';
    }
}
