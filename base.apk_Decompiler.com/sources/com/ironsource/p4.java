package com.ironsource;

import com.ironsource.lifecycle.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/p4;", "Lcom/ironsource/h8;", "", "f", "", "e", "c", "b", "a", "d", "Lcom/ironsource/hb;", "Lcom/ironsource/hb;", "task", "J", "sessionStartTime", "<init>", "(Lcom/ironsource/hb;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class p4 implements h8 {
    private final hb a;
    private long b;

    public p4(hb hbVar) {
        Intrinsics.checkNotNullParameter(hbVar, "task");
        this.a = hbVar;
        b.d().a((h8) this);
        f();
    }

    private final long e() {
        return System.currentTimeMillis() - this.b;
    }

    private final void f() {
        this.b = System.currentTimeMillis();
    }

    public void a() {
    }

    public void b() {
        this.a.a(Long.valueOf(e()));
        this.a.run();
    }

    public void c() {
        f();
    }

    public void d() {
    }
}
