package com.ironsource;

import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.t1;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u001d\u0010\u0007\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J \u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/ironsource/cd;", "Lcom/ironsource/t1;", "Smash", "", "", "waterfall", "b", "c", "(Ljava/util/List;)Lcom/ironsource/t1;", "", "a", "smash", "Lcom/ironsource/dd;", "d", "Lcom/ironsource/l;", "Lcom/ironsource/l;", "managerData", "<init>", "(Lcom/ironsource/l;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class cd<Smash extends t1<?>> {
    private final l a;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((t1) t).i().k()), Integer.valueOf(((t1) t2).i().k()));
        }
    }

    public cd(l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "managerData");
        this.a = lVar;
    }

    public final boolean a(t1<?> t1Var, List<? extends Smash> list) {
        T t;
        Intrinsics.checkNotNullParameter(t1Var, "smash");
        Intrinsics.checkNotNullParameter(list, d.g);
        Iterator<T> it = b(list).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (!((t1) t).w()) {
                break;
            }
        }
        return Intrinsics.areEqual((Object) t, (Object) t1Var);
    }

    public final boolean a(List<? extends Smash> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, d.g);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((t1) it.next()).x() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i = 0;
        }
        return i >= this.a.i();
    }

    public final List<Smash> b(List<? extends Smash> list) {
        Intrinsics.checkNotNullParameter(list, d.g);
        return CollectionsKt.sortedWith(list, new a());
    }

    public final Smash c(List<? extends Smash> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, d.g);
        Iterator<T> it = b(list).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((t1) t).A()) {
                break;
            }
        }
        return (t1) t;
    }

    public final dd<Smash> d(List<? extends Smash> list) {
        Intrinsics.checkNotNullParameter(list, d.g);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(this.a.b().name() + " waterfall size: " + list.size());
        ed<Smash> a2 = ed.g.a(this.a.c() ? bd.BIDDER_SENSITIVE : bd.DEFAULT, this.a.i(), this.a.m(), list);
        Iterator<? extends Smash> it = list.iterator();
        while (it.hasNext()) {
            a2.d((t1) it.next());
            if (a2.e()) {
                return new dd<>(a2);
            }
        }
        return new dd<>(a2);
    }
}
