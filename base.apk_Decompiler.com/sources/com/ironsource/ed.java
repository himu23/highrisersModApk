package com.ironsource;

import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\b&\u0018\u0000 \u001f*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003:\u0001\tB%\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0006\u001a\u00020\bH\u0002J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u0005H\u0016J\u0015\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000f\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\t\u0010\u0018¨\u0006 "}, d2 = {"Lcom/ironsource/ed;", "Lcom/ironsource/t1;", "Smash", "", "smash", "", "b", "(Lcom/ironsource/t1;)Z", "", "a", "(Lcom/ironsource/t1;)I", "d", "e", "", "(Lcom/ironsource/t1;)V", "c", "I", "maxSmashesToLoad", "Z", "showPriorityEnabled", "", "Ljava/util/List;", "waterfall", "", "()Ljava/util/List;", "smashesToLoad", "loadedSmashes", "f", "loadingInProgressSmashes", "<init>", "(IZLjava/util/List;)V", "g", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class ed<Smash extends t1<?>> {
    public static final a g = new a((DefaultConstructorMarker) null);
    private final int a;
    private final boolean b;
    private final List<Smash> c;
    private final List<Smash> d = new ArrayList();
    private final List<Smash> e = new ArrayList();
    private final List<Smash> f = new ArrayList();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f\"\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n¨\u0006\u0010"}, d2 = {"Lcom/ironsource/ed$a;", "", "Lcom/ironsource/t1;", "Smash", "Lcom/ironsource/bd;", "loadingStrategy", "", "maxSmashesToLoad", "", "showPriorityEnabled", "", "waterfall", "Lcom/ironsource/ed;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: com.ironsource.ed$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0012a {
            public static final /* synthetic */ int[] a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.ironsource.bd[] r0 = com.ironsource.bd.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.ironsource.bd r1 = com.ironsource.bd.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.ironsource.bd r1 = com.ironsource.bd.BIDDER_SENSITIVE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ed.a.C0012a.<clinit>():void");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <Smash extends t1<?>> ed<Smash> a(bd bdVar, int i, boolean z, List<? extends Smash> list) {
            Intrinsics.checkNotNullParameter(bdVar, "loadingStrategy");
            Intrinsics.checkNotNullParameter(list, d.g);
            int i2 = C0012a.a[bdVar.ordinal()];
            if (i2 == 1) {
                return new b3(i, z, list);
            }
            if (i2 == 2) {
                return new w1(i, z, list, false, 8, (DefaultConstructorMarker) null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public ed(int i, boolean z, List<? extends Smash> list) {
        Intrinsics.checkNotNullParameter(list, d.g);
        this.a = i;
        this.b = z;
        this.c = list;
    }

    private final int a(Smash smash) {
        return smash.i().k();
    }

    private final int b() {
        Integer num;
        List<Smash> list = this.c;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((t1) next).x()) {
                arrayList.add(next);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            num = null;
        } else {
            Integer valueOf = Integer.valueOf(a((t1) it.next()));
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(a((t1) it.next()));
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    private final boolean b(Smash smash) {
        return b() < a(smash);
    }

    public final List<Smash> a() {
        return this.f;
    }

    public final List<Smash> c() {
        return this.d;
    }

    public abstract void c(Smash smash);

    public final int d() {
        return this.d.size() + this.e.size() + this.f.size();
    }

    public final void d(Smash smash) {
        IronLog ironLog;
        String str;
        IronLog ironLog2;
        StringBuilder sb;
        String str2;
        List<Smash> list;
        Intrinsics.checkNotNullParameter(smash, "smash");
        if (smash.w()) {
            ironLog = IronLog.INTERNAL;
            str = smash.g().name() + " - smash " + smash.k() + " is failed to load";
        } else {
            if (smash.x()) {
                IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is already loaded");
                list = this.e;
            } else {
                if (smash.y()) {
                    ironLog2 = IronLog.INTERNAL;
                    sb = new StringBuilder();
                    sb.append(smash.g().name());
                    sb.append(" - Smash ");
                    sb.append(smash.k());
                    str2 = " still loading";
                } else if (smash.z().get()) {
                    ironLog2 = IronLog.INTERNAL;
                    sb = new StringBuilder();
                    sb.append(smash.g().name());
                    sb.append(" - Smash ");
                    sb.append(smash.k());
                    str2 = " marked as loading candidate";
                } else if (!this.b || !b(smash)) {
                    c(smash);
                    return;
                } else {
                    ironLog = IronLog.INTERNAL;
                    str = smash.g().name() + " - Smash " + smash.k() + " is not better than already loaded smashes";
                }
                sb.append(str2);
                ironLog2.verbose(sb.toString());
                list = this.f;
            }
            list.add(smash);
            return;
        }
        ironLog.verbose(str);
    }

    public boolean e() {
        return d() >= this.a;
    }
}
