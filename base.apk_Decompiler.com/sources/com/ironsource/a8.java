package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0007\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007J'\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Lcom/ironsource/a8;", "", "reference", "", "errorMessage", "", "shouldThrowException", "a", "T", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class a8 {
    public static final a8 a = new a8();

    private a8() {
    }

    @JvmStatic
    public static final <T> T a(T t, T t2) {
        return t == null ? t2 : t;
    }

    @JvmStatic
    public static final boolean a(Object obj) {
        return a(obj, (String) null, false, 6, (Object) null);
    }

    @JvmStatic
    public static final boolean a(Object obj, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        return a(obj, str, false, 4, (Object) null);
    }

    @JvmStatic
    public static final boolean a(Object obj, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        if (obj != null) {
            return true;
        }
        if (z) {
            throw new NullPointerException(str);
        } else if (!z) {
            IronLog.API.error(str);
            return false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean a(Object obj, String str, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "reference is null";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return a(obj, str, z);
    }
}
