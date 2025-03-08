package com.ironsource;

import com.ironsource.w6;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"Lcom/ironsource/w8;", "Lcom/ironsource/i5;", "Lcom/ironsource/h5;", "Lcom/ironsource/w6;", "b", "Lcom/ironsource/w6$a;", "a", "Lcom/ironsource/lb;", "Lcom/ironsource/lb;", "sessionDepthManager", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class w8 implements i5, h5 {
    public static final b b = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<w8> c = LazyKt.lazy(a.a);
    private final lb a;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/w8;", "a", "()Lcom/ironsource/w8;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<w8> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final w8 invoke() {
            return new w8((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0012\u001a\u00020\u000e8FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ironsource/w8$b;", "", "Lcom/ironsource/w8;", "instance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/ironsource/w8;", "instance", "Lcom/ironsource/i5;", "d", "()Lcom/ironsource/i5;", "getProvider$annotations", "()V", "provider", "Lcom/ironsource/h5;", "a", "()Lcom/ironsource/h5;", "getEditor$annotations", "editor", "<init>", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void b() {
        }

        private final w8 c() {
            return (w8) w8.c.getValue();
        }

        @JvmStatic
        public static /* synthetic */ void e() {
        }

        public final h5 a() {
            return c();
        }

        public final i5 d() {
            return c();
        }
    }

    private w8() {
        this.a = new lb();
    }

    public /* synthetic */ w8(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final h5 d() {
        return b.a();
    }

    public static final i5 e() {
        return b.d();
    }

    public w6.a a() {
        return this.a;
    }

    public w6 b() {
        return this.a;
    }
}
