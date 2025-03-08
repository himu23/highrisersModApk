package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/ironsource/u7;", "Landroid/os/HandlerThread;", "Ljava/lang/Runnable;", "task", "", "delay", "", "a", "b", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "name", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class u7 extends HandlerThread {
    private Handler a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u7(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    public static /* synthetic */ void a(u7 u7Var, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        u7Var.a(runnable, j);
    }

    public final void a() {
        this.a = new Handler(getLooper());
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        a(this, runnable, 0, 2, (Object) null);
    }

    public final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        Handler handler = this.a;
        if (handler != null) {
            handler.postDelayed(runnable, j);
        }
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "task");
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
