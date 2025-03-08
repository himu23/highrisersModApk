package com.ironsource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J-\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\tJ\u0016\u0010\u000b\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002R\u0014\u0010\r\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/ironsource/cc;", "", "", "list", "", "a", "elem", "", "items", "([Ljava/lang/Object;)Ljava/util/List;", "methodArgs", "b", "Ljava/lang/String;", "CONST_COMMA", "c", "CONST_START_OF_ARRAY", "d", "CONST_END_OF_ARRAY", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class cc {
    public static final cc a = new cc();
    private static final String b = ",";
    private static final String c = "[";
    private static final String d = "]";

    private cc() {
    }

    private final String a(Object obj) {
        if (!(obj instanceof String)) {
            return String.valueOf(obj);
        }
        return "'" + obj + '\'';
    }

    private final String a(List<?> list) {
        Iterator<T> it = list.iterator();
        String str = "[";
        while (it.hasNext()) {
            str = str + a.a((Object) it.next()) + ',';
        }
        return StringsKt.removeSuffix(str, (CharSequence) b) + ']';
    }

    public final List<Object> a(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "items");
        return CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length));
    }

    public final String b(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "methodArgs");
        String str = new String();
        for (T next : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(next instanceof List ? a.a((List<?>) (List) next) : a.a((Object) next));
            str = sb.toString() + ',';
        }
        return StringsKt.removeSuffix(str, (CharSequence) b);
    }
}
