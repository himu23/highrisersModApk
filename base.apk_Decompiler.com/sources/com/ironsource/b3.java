package com.ironsource;

import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.t1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/ironsource/b3;", "Lcom/ironsource/t1;", "Smash", "Lcom/ironsource/ed;", "smash", "", "c", "(Lcom/ironsource/t1;)V", "", "maxSmashesToLoad", "", "showPriorityEnabled", "", "waterfall", "<init>", "(IZLjava/util/List;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class b3<Smash extends t1<?>> extends ed<Smash> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b3(int i, boolean z, List<? extends Smash> list) {
        super(i, z, list);
        Intrinsics.checkNotNullParameter(list, d.g);
    }

    public void c(Smash smash) {
        Intrinsics.checkNotNullParameter(smash, "smash");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(smash.g().name() + " - Smash " + smash.k() + " is ready to load");
        smash.a(true);
        c().add(smash);
    }
}
