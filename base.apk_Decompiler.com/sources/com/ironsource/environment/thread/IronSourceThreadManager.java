package com.ironsource.environment.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ironsource.db;
import com.ironsource.m2;
import com.ironsource.u7;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010(\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010/\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u001b\u00104\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\u0005\u00103R\u001b\u00108\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/ironsource/environment/thread/IronSourceThreadManager;", "", "Ljava/lang/Runnable;", "action", "", "a", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "shouldExecuteAsync", "shouldWaitUntilAllOperationsCompleted", "", "tasks", "", "executeTasks", "", "delay", "postOnUiThreadTask", "removeUiThreadTask", "postMediationBackgroundTask", "removeMediationBackgroundTask", "postAdapterBackgroundTask", "removeAdapterBackgroundTask", "postPublisherCallback", "", "name", "Lcom/ironsource/u7;", "createAndStartThread", "Z", "getUseSharedExecutorService", "()Z", "setUseSharedExecutorService", "(Z)V", "useSharedExecutorService", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "uiHandler", "c", "getInitHandler", "()Landroid/os/Handler;", "initHandler", "d", "Lcom/ironsource/u7;", "mediationBackgroundHandler", "e", "adapterBackgroundHandler", "f", "publisherCallbackHandler", "Lcom/ironsource/db;", "g", "Lkotlin/Lazy;", "()Lcom/ironsource/db;", "executorService", "h", "getSharedManagersThread", "()Lcom/ironsource/u7;", "sharedManagersThread", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class IronSourceThreadManager {
    public static final IronSourceThreadManager INSTANCE = new IronSourceThreadManager();
    private static boolean a;
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final Handler c;
    private static final u7 d;
    private static final u7 e;
    private static final u7 f;
    private static final Lazy g = LazyKt.lazy(a.a);
    private static final Lazy h = LazyKt.lazy(b.a);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/db;", "a", "()Lcom/ironsource/db;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<db> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final db invoke() {
            return new db(0, (Function1) null, (Function1) null, 7, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/u7;", "a", "()Lcom/ironsource/u7;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0<u7> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final u7 invoke() {
            u7 u7Var = new u7("managersThread");
            u7Var.start();
            u7Var.a();
            return u7Var;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        handlerThread.start();
        c = new Handler(handlerThread.getLooper());
        u7 u7Var = new u7("mediationBackground");
        u7Var.start();
        u7Var.a();
        d = u7Var;
        u7 u7Var2 = new u7("adapterBackground");
        u7Var2.start();
        u7Var2.a();
        e = u7Var2;
        u7 u7Var3 = new u7("publisher-callbacks");
        u7Var3.start();
        u7Var3.a();
        f = u7Var3;
    }

    private IronSourceThreadManager() {
    }

    private final db a() {
        return (db) g.getValue();
    }

    /* access modifiers changed from: private */
    public static final void a(Runnable runnable, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(runnable, "$it");
        Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
        runnable.run();
        new IronSourceThreadManager$$ExternalSyntheticLambda0(countDownLatch).run();
    }

    /* access modifiers changed from: private */
    public static final void a(CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
        countDownLatch.countDown();
    }

    private final boolean a(Runnable runnable) {
        return a && a().getQueue().contains(runnable);
    }

    public static /* synthetic */ void postAdapterBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postAdapterBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postMediationBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postMediationBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postOnUiThreadTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postOnUiThreadTask(runnable, j);
    }

    public static /* synthetic */ void postPublisherCallback$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postPublisherCallback(runnable, j);
    }

    public final u7 createAndStartThread(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        u7 u7Var = new u7(str);
        u7Var.start();
        u7Var.a();
        return u7Var;
    }

    public final void executeTasks(boolean z, boolean z2, List<? extends Runnable> list) {
        Intrinsics.checkNotNullParameter(list, "tasks");
        if (!z) {
            for (Runnable run : list) {
                run.run();
            }
        } else if (!z2) {
            for (Runnable postMediationBackgroundTask$default : list) {
                postMediationBackgroundTask$default(INSTANCE, postMediationBackgroundTask$default, 0, 2, (Object) null);
            }
        } else {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            for (Runnable ironSourceThreadManager$$ExternalSyntheticLambda1 : list) {
                postMediationBackgroundTask$default(INSTANCE, new IronSourceThreadManager$$ExternalSyntheticLambda1(ironSourceThreadManager$$ExternalSyntheticLambda1, countDownLatch), 0, 2, (Object) null);
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public final Handler getInitHandler() {
        return c;
    }

    public final u7 getSharedManagersThread() {
        return (u7) h.getValue();
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
    }

    public final boolean getUseSharedExecutorService() {
        return a;
    }

    public final void postAdapterBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        postAdapterBackgroundTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postAdapterBackgroundTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        if (a) {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            e.a(runnable, j);
        }
    }

    public final void postMediationBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        postMediationBackgroundTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postMediationBackgroundTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        if (a) {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            d.a(runnable, j);
        }
    }

    public final void postOnUiThreadTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        postOnUiThreadTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postOnUiThreadTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        b.postDelayed(runnable, j);
    }

    public final void postPublisherCallback(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        postPublisherCallback$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postPublisherCallback(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        f.a(runnable, j);
    }

    public final void removeAdapterBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        if (a(runnable)) {
            a().remove(runnable);
        } else {
            e.b(runnable);
        }
    }

    public final void removeMediationBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        if (a(runnable)) {
            a().remove(runnable);
        } else {
            d.b(runnable);
        }
    }

    public final void removeUiThreadTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, m2.h.h);
        b.removeCallbacks(runnable);
    }

    public final void setUseSharedExecutorService(boolean z) {
        a = z;
    }
}
