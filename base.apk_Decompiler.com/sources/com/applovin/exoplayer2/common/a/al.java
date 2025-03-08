package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class al<K, V> extends u<K, V> {
    static final u<Object, Object> qP = new al((int[]) null, new Object[0], 0);
    private final transient int oW;
    private final transient int[] qQ;
    final transient Object[] ql;

    /* access modifiers changed from: package-private */
    public boolean fZ() {
        return false;
    }

    public int size() {
        return this.oW;
    }

    static <K, V> al<K, V> b(int i, Object[] objArr) {
        if (i == 0) {
            return (al) qP;
        }
        if (i == 1) {
            j.j(objArr[0], objArr[1]);
            return new al<>((int[]) null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new al<>(a(objArr, i, w.bk(i), 0), objArr, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int[] a(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            r0 = 1
            if (r11 != r0) goto L_0x000e
            r11 = r10[r13]
            r12 = r13 ^ 1
            r10 = r10[r12]
            com.applovin.exoplayer2.common.a.j.j(r11, r10)
            r10 = 0
            return r10
        L_0x000e:
            int r1 = r12 + -1
            int[] r12 = new int[r12]
            r2 = -1
            java.util.Arrays.fill(r12, r2)
            r3 = 0
        L_0x0017:
            if (r3 >= r11) goto L_0x0074
            int r4 = r3 * 2
            int r5 = r4 + r13
            r6 = r10[r5]
            r7 = r13 ^ 1
            int r4 = r4 + r7
            r4 = r10[r4]
            com.applovin.exoplayer2.common.a.j.j(r6, r4)
            int r7 = r6.hashCode()
            int r7 = com.applovin.exoplayer2.common.a.p.bg(r7)
        L_0x002f:
            r7 = r7 & r1
            r8 = r12[r7]
            if (r8 != r2) goto L_0x0039
            r12[r7] = r5
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0039:
            r9 = r10[r8]
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x0044
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0044:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Multiple entries with same key: "
            r12.<init>(r13)
            r12.append(r6)
            java.lang.String r13 = "="
            r12.append(r13)
            r12.append(r4)
            java.lang.String r1 = " and "
            r12.append(r1)
            r1 = r10[r8]
            r12.append(r1)
            r12.append(r13)
            r13 = r8 ^ 1
            r10 = r10[r13]
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x0074:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.common.a.al.a(java.lang.Object[], int, int, int):int[]");
    }

    private al(int[] iArr, Object[] objArr, int i) {
        this.qQ = iArr;
        this.ql = objArr;
        this.oW = i;
    }

    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return a(this.qQ, this.ql, this.oW, 0, obj);
    }

    static Object a(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i, int i2, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int bg = p.bg(obj.hashCode());
            while (true) {
                int i3 = bg & length;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    return null;
                }
                if (objArr[i4].equals(obj)) {
                    return objArr[i4 ^ 1];
                }
                bg = i3 + 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public w<Map.Entry<K, V>> gl() {
        return new a(this, this.ql, 0, this.oW);
    }

    static class a<K, V> extends w<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient int oW;
        /* access modifiers changed from: private */
        public final transient int qR;
        /* access modifiers changed from: private */
        public final transient Object[] ql;
        private final transient u<K, V> qn;

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return true;
        }

        public int size() {
            return this.oW;
        }

        a(u<K, V> uVar, Object[] objArr, int i, int i2) {
            this.qn = uVar;
            this.ql = objArr;
            this.qR = i;
            this.oW = i2;
        }

        /* renamed from: fU */
        public ax<Map.Entry<K, V>> iterator() {
            return fY().iterator();
        }

        /* access modifiers changed from: package-private */
        public int a(Object[] objArr, int i) {
            return fY().a(objArr, i);
        }

        /* access modifiers changed from: package-private */
        public s<Map.Entry<K, V>> gA() {
            return new s<Map.Entry<K, V>>() {
                public boolean fZ() {
                    return true;
                }

                /* renamed from: bo */
                public Map.Entry<K, V> get(int i) {
                    Preconditions.checkElementIndex(i, a.this.oW);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(a.this.ql[a.this.qR + i2], a.this.ql[i2 + (a.this.qR ^ 1)]);
                }

                public int size() {
                    return a.this.oW;
                }
            };
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.qn.get(key))) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public w<K> gn() {
        return new b(this, new c(this.ql, 0, this.oW));
    }

    static final class c extends s<Object> {
        private final transient int oU;
        private final transient int oW;
        private final transient Object[] ql;

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return true;
        }

        public int size() {
            return this.oW;
        }

        c(Object[] objArr, int i, int i2) {
            this.ql = objArr;
            this.oU = i;
            this.oW = i2;
        }

        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.oW);
            return this.ql[(i * 2) + this.oU];
        }
    }

    static final class b<K> extends w<K> {
        private final transient s<K> ai;
        private final transient u<K, ?> qn;

        public s<K> fY() {
            return this.ai;
        }

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return true;
        }

        b(u<K, ?> uVar, s<K> sVar) {
            this.qn = uVar;
            this.ai = sVar;
        }

        /* renamed from: fU */
        public ax<K> iterator() {
            return fY().iterator();
        }

        /* access modifiers changed from: package-private */
        public int a(Object[] objArr, int i) {
            return fY().a(objArr, i);
        }

        public boolean contains(@NullableDecl Object obj) {
            return this.qn.get(obj) != null;
        }

        public int size() {
            return this.qn.size();
        }
    }

    /* access modifiers changed from: package-private */
    public q<V> gp() {
        return new c(this.ql, 1, this.oW);
    }
}
