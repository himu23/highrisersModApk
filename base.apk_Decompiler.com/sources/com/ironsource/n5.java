package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.m2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ironsource/n5;", "", "Ljava/lang/Runnable;", "action", "", "delay", "", "c", "a", "b", "Landroid/os/Looper;", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Lcom/ironsource/u7;", "Lcom/ironsource/u7;", "backgroundHandler", "d", "publisherCallbackHandler", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class n5 {
    public static final n5 a = new n5();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final u7 c;
    private static final u7 d;

    static {
        u7 u7Var = new u7("isadplayer-background");
        u7Var.start();
        u7Var.a();
        c = u7Var;
        u7 u7Var2 = new u7("isadplayer-publisher-callbacks");
        u7Var2.start();
        u7Var2.a();
        d = u7Var2;
    }

    private n5() {
    }

    public static /* synthetic */ void a(n5 n5Var, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        n5Var.a(runnable, j);
    }

    public static /* synthetic */ void b(n5 n5Var, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        n5Var.b(runnable, j);
    }

    public static /* synthetic */ void c(n5 n5Var, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        n5Var.c(runnable, j);
    }

    public final Looper a() {
        return c.getLooper();
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        a(this, runnable, 0, 2, (Object) null);
    }

    public final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        c.a(runnable, j);
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        b(this, runnable, 0, 2, (Object) null);
    }

    public final void b(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        d.a(runnable, j);
    }

    public final void c(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        c(this, runnable, 0, 2, (Object) null);
    }

    public final void c(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        b.postDelayed(runnable, j);
    }
}
