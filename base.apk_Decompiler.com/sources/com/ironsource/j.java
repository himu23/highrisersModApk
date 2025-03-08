package com.ironsource;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R3\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000b8\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\u0007\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/j;", "", "", "instance", "", "timingValue", "", "a", "c", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "instanceToTimingValuesMapping", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class j {
    public static final j a = new j();
    private static final HashMap<String, Long> b = new HashMap<>();

    private j() {
    }

    public final HashMap<String, Long> a() {
        return b;
    }

    public final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, d1.o);
        HashMap<String, Long> hashMap = b;
        if (hashMap.get(str) == null) {
            return false;
        }
        hashMap.remove(str);
        return true;
    }

    public final boolean a(String str, long j) {
        Intrinsics.checkNotNullParameter(str, d1.o);
        if (str.length() == 0) {
            return false;
        }
        HashMap<String, Long> hashMap = b;
        if (hashMap.containsKey(str)) {
            return false;
        }
        hashMap.put(str, Long.valueOf(j));
        return true;
    }

    public final long b(String str) {
        Intrinsics.checkNotNullParameter(str, d1.o);
        Long l = b.get(str);
        if (l != null) {
            return System.currentTimeMillis() - l.longValue();
        }
        return -1;
    }

    public final long c(String str) {
        Intrinsics.checkNotNullParameter(str, d1.o);
        Long l = b.get(str);
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }
}
