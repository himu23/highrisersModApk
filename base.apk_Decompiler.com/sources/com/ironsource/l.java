package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0001\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u0006\u0010&\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020\u0006\u0012\u0006\u0010-\u001a\u00020\u001d\u0012\u0006\u0010.\u001a\u00020\u001d\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00104\u001a\u00020\u0006\u0012\u0006\u00109\u001a\u000205\u0012\u0006\u0010;\u001a\u00020\u0006\u0012\u0006\u0010=\u001a\u00020\u0006\u0012\u0006\u0010?\u001a\u00020\u0006\u0012\u0006\u0010@\u001a\u00020\u0006\u0012\b\b\u0002\u0010A\u001a\u00020\u0006¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0005\u0010\"R\u0017\u0010&\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0013\u0010)\"\u0004\b\u0005\u0010*R\u0017\u0010-\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b'\u0010!R\u0017\u0010.\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u0005\u0010!R\u0017\u00102\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b,\u00101R\u0017\u00104\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b\u001e\u0010)R\u0017\u00109\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b$\u00108R\u0017\u0010;\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b:\u0010(\u001a\u0004\b3\u0010)R\u0017\u0010=\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010(\u001a\u0004\b<\u0010)R\u0017\u0010?\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b>\u0010(\u001a\u0004\b>\u0010)R\u0017\u0010@\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b6\u0010)R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010(\u001a\u0004\b:\u0010)\"\u0004\b\u000b\u0010*¨\u0006D"}, d2 = {"Lcom/ironsource/l;", "", "", "instanceName", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "a", "", "r", "s", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "b", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "userId", "", "c", "Ljava/util/List;", "j", "()Ljava/util/List;", "providerList", "Lcom/ironsource/mediationsdk/utils/a;", "d", "Lcom/ironsource/mediationsdk/utils/a;", "()Lcom/ironsource/mediationsdk/utils/a;", "auctionSettings", "", "e", "I", "i", "()I", "(I)V", "maxSmashesToLoad", "f", "n", "smashLoadTimeout", "g", "Z", "()Z", "(Z)V", "advancedLoading", "h", "delayLoadFailure", "adExpirationInMinutes", "Lcom/ironsource/y;", "Lcom/ironsource/y;", "()Lcom/ironsource/y;", "loadingData", "k", "collectBiddingDataAsyncEnabled", "", "l", "J", "()J", "collectBiddingDataTimeout", "m", "providersParallelInit", "q", "waitUntilAllProvidersFinishInit", "o", "threadPerManager", "sharedManagersThread", "showPriorityEnabled", "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Ljava/lang/String;Ljava/util/List;Lcom/ironsource/mediationsdk/utils/a;IIZIILcom/ironsource/y;ZJZZZZZ)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class l {
    public static final a r = new a((DefaultConstructorMarker) null);
    public static final int s = -1;
    private final IronSource.AD_UNIT a;
    private final String b;
    private final List<NetworkSettings> c;
    private final com.ironsource.mediationsdk.utils.a d;
    private int e;
    private final int f;
    private boolean g;
    private final int h;
    private final int i;
    private final y j;
    private final boolean k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private boolean q;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ironsource/l$a;", "", "", "DISABLED", "I", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(IronSource.AD_UNIT ad_unit, String str, List<? extends NetworkSettings> list, com.ironsource.mediationsdk.utils.a aVar, int i2, int i3, boolean z, int i4, int i5, y yVar, boolean z2, long j2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        Intrinsics.checkNotNullParameter(aVar, "auctionSettings");
        Intrinsics.checkNotNullParameter(yVar, "loadingData");
        this.a = ad_unit;
        this.b = str;
        this.c = list;
        this.d = aVar;
        this.e = i2;
        this.f = i3;
        this.g = z;
        this.h = i4;
        this.i = i5;
        this.j = yVar;
        this.k = z2;
        this.l = j2;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = z6;
        this.q = z7;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(IronSource.AD_UNIT ad_unit, String str, List list, com.ironsource.mediationsdk.utils.a aVar, int i2, int i3, boolean z, int i4, int i5, y yVar, boolean z2, long j2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, str, list, aVar, i2, i3, z, i4, i5, yVar, z2, j2, z3, z4, z5, z6, (i6 & 65536) != 0 ? false : z7);
    }

    public final int a() {
        return this.i;
    }

    public final NetworkSettings a(String str) {
        Intrinsics.checkNotNullParameter(str, "instanceName");
        List<NetworkSettings> j2 = j();
        T t = null;
        if (j2 == null) {
            return null;
        }
        Iterator<T> it = j2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(str)) {
                t = next;
                break;
            }
        }
        return (NetworkSettings) t;
    }

    public final void a(int i2) {
        this.e = i2;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final IronSource.AD_UNIT b() {
        return this.a;
    }

    public final void b(boolean z) {
        this.q = z;
    }

    public final boolean c() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.utils.a d() {
        return this.d;
    }

    public final boolean e() {
        return this.k;
    }

    public final long f() {
        return this.l;
    }

    public final int g() {
        return this.h;
    }

    public final y h() {
        return this.j;
    }

    public final int i() {
        return this.e;
    }

    public List<NetworkSettings> j() {
        return this.c;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.p;
    }

    public final boolean m() {
        return this.q;
    }

    public final int n() {
        return this.f;
    }

    public final boolean o() {
        return this.o;
    }

    public String p() {
        return this.b;
    }

    public final boolean q() {
        return this.n;
    }

    public final boolean r() {
        return this.d.g() > 0;
    }

    public final String s() {
        String format = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", new Object[]{d.n0, Integer.valueOf(this.e), d.o0, Boolean.valueOf(this.g), d.p0, Boolean.valueOf(this.q)});
        Intrinsics.checkNotNullExpressionValue(format, "format(\n        Locale.g…showPriorityEnabled\n    )");
        return format;
    }
}
