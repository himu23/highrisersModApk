package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class k {
    static boolean a(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static StringBuilder aS(int i) {
        j.a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }
}
