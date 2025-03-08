package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class ad<K0, V0> {
    /* synthetic */ ad(AnonymousClass1 r1) {
        this();
    }

    private ad() {
    }

    /* renamed from: com.applovin.exoplayer2.common.a.ad$1  reason: invalid class name */
    class AnonymousClass1 extends c<Object> {
        final /* synthetic */ int qH;

        /* access modifiers changed from: package-private */
        public <K, V> Map<K, Collection<V>> gJ() {
            return aj.bn(this.qH);
        }
    }

    public static c<Comparable> gI() {
        return a(ai.gP());
    }

    public static <K0> c<K0> a(final Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new c<K0>() {
            /* access modifiers changed from: package-private */
            public <K extends K0, V> Map<K, Collection<V>> gJ() {
                return new TreeMap(comparator);
            }
        };
    }

    private static final class a<V> implements Supplier<List<V>>, Serializable {
        private final int qJ;

        a(int i) {
            this.qJ = j.a(i, "expectedValuesPerKey");
        }

        /* renamed from: gK */
        public List<V> get() {
            return new ArrayList(this.qJ);
        }
    }

    public static abstract class c<K0> {
        /* access modifiers changed from: package-private */
        public abstract <K extends K0, V> Map<K, Collection<V>> gJ();

        c() {
        }

        public b<K0, Object> gM() {
            return bm(2);
        }

        public b<K0, Object> bm(final int i) {
            j.a(i, "expectedValuesPerKey");
            return new b<K0, Object>() {
                public <K extends K0, V> z<K, V> gL() {
                    return ae.a(c.this.gJ(), new a(i));
                }
            };
        }
    }

    public static abstract class b<K0, V0> extends ad<K0, V0> {
        public abstract <K extends K0, V extends V0> z<K, V> gL();

        b() {
            super((AnonymousClass1) null);
        }
    }
}
