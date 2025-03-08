package com.ironsource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"Lcom/ironsource/qc;", "", "", "lastUpdateTimeInMills", "expirationThresholdInMillis", "", "a", "Lcom/ironsource/gc;", "Lcom/ironsource/gc;", "time", "<init>", "(Lcom/ironsource/gc;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class qc {
    private final gc a;

    public qc(gc gcVar) {
        Intrinsics.checkNotNullParameter(gcVar, "time");
        this.a = gcVar;
    }

    public final boolean a(long j, long j2) {
        long a2 = this.a.a();
        return j2 <= 0 || j <= 0 || a2 < j || a2 - j > j2;
    }
}
