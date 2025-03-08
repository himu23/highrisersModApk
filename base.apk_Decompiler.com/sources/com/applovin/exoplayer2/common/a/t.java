package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.common.a.v;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class t<K, V> extends v<K, V> implements z<K, V> {
    public static <K, V> t<K, V> ge() {
        return o.qa;
    }

    public static <K, V> a<K, V> gf() {
        return new a<>();
    }

    public static final class a<K, V> extends v.a<K, V> {
        /* renamed from: a */
        public a<K, V> b(K k, Iterable<? extends V> iterable) {
            super.b(k, iterable);
            return this;
        }

        /* renamed from: a */
        public a<K, V> b(K k, V... vArr) {
            super.b(k, vArr);
            return this;
        }

        /* renamed from: gg */
        public t<K, V> gh() {
            return (t) super.gh();
        }
    }

    static <K, V> t<K, V> a(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        s<E> sVar;
        if (collection.isEmpty()) {
            return ge();
        }
        u.a aVar = new u.a(collection.size());
        int i = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                sVar = s.d(collection2);
            } else {
                sVar = s.a(comparator, collection2);
            }
            if (!sVar.isEmpty()) {
                aVar.l(key, sVar);
                i += sVar.size();
            }
        }
        return new t<>(aVar.gq(), i);
    }

    t(u<K, s<V>> uVar, int i) {
        super(uVar, i);
    }

    /* renamed from: w */
    public s<V> x(@NullableDecl K k) {
        s<V> sVar = (s) this.qn.get(k);
        return sVar == null ? s.ga() : sVar;
    }
}
