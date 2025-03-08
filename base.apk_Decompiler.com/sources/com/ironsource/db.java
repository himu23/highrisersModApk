package com.ironsource;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\"\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/ironsource/db;", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "", "msg", "a", "Ljava/lang/Runnable;", "runnable", "", "throwable", "", "afterExecute", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "report", "b", "log", "", "threadCount", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class db extends ScheduledThreadPoolExecutor {
    private final Function1<Throwable, Unit> a;
    private final Function1<String, Unit> b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function1<Throwable, Unit> {
        public static final a a = new a();

        a() {
            super(1);
        }

        public final void a(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1<String, Unit> {
        public static final b a = new b();

        b() {
            super(1);
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public db() {
        this(0, (Function1) null, (Function1) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public db(int i, Function1<? super Throwable, Unit> function1, Function1<? super String, Unit> function12) {
        super(i, new e8());
        Intrinsics.checkNotNullParameter(function1, "report");
        Intrinsics.checkNotNullParameter(function12, "log");
        this.a = function1;
        this.b = function12;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ db(int i, Function1 function1, Function1 function12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? eb.a() : i, (i2 & 2) != 0 ? a.a : function1, (i2 & 4) != 0 ? b.a : function12);
    }

    private final String a(String str) {
        return db.class.getName() + " RuntimeException caught: " + str;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        Function1<Throwable, Unit> function1;
        super.afterExecute(runnable, th);
        if (th != null) {
            this.b.invoke(a(th.toString()));
            this.a.invoke(th);
            return;
        } else if ((runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                ((Future) runnable).get();
                return;
            } catch (CancellationException e) {
                e = e;
                this.b.invoke(a(e.toString()));
                function1 = this.a;
            } catch (ExecutionException e2) {
                this.b.invoke(a(e2.toString()));
                function1 = this.a;
                e = e2.getCause();
            } catch (InterruptedException e3) {
                this.b.invoke(a(e3.toString()));
                Thread.currentThread().interrupt();
                return;
            }
        } else {
            return;
        }
        function1.invoke(e);
    }
}
