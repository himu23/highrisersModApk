package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.util.Collections;
import java.util.List;

public abstract class e0 {
    public static final e0 a = new b();
    public static final e0 b = new c();

    public abstract void a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract <L> List<L> b(Object obj, long j);

    public static final class c extends e0 {
        public c() {
            super();
        }

        public void a(Object obj, long j) {
            ((y.j) p1.g(obj, j)).b();
        }

        public <L> List<L> b(Object obj, long j) {
            y.j jVar = (y.j) p1.g(obj, j);
            if (jVar.d()) {
                return jVar;
            }
            int size = jVar.size();
            y.j b = jVar.b(size == 0 ? 10 : size * 2);
            p1.a(obj, j, (Object) b);
            return b;
        }

        public <E> void a(Object obj, Object obj2, long j) {
            y.j jVar = (y.j) p1.g(obj, j);
            y.j jVar2 = (y.j) p1.g(obj2, j);
            int size = jVar.size();
            int size2 = jVar2.size();
            if (size > 0 && size2 > 0) {
                if (!jVar.d()) {
                    jVar = jVar.b(size2 + size);
                }
                jVar.addAll(jVar2);
            }
            if (size > 0) {
                jVar2 = jVar;
            }
            p1.a(obj, j, (Object) jVar2);
        }
    }

    public e0() {
    }

    public static final class b extends e0 {
        public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) p1.g(obj, j);
            if (list instanceof d0) {
                obj2 = ((d0) list).a();
            } else if (!c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof x0) || !(list instanceof y.j)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    y.j jVar = (y.j) list;
                    if (jVar.d()) {
                        jVar.b();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            p1.a(obj, j, obj2);
        }

        public <L> List<L> b(Object obj, long j) {
            return a(obj, j, 10);
        }

        public <E> void a(Object obj, Object obj2, long j) {
            List list = (List) p1.g(obj2, j);
            List a = a(obj, j, list.size());
            int size = a.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                a.addAll(list);
            }
            if (size > 0) {
                list = a;
            }
            p1.a(obj, j, (Object) list);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.fyber.inneractive.sdk.protobuf.c0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.fyber.inneractive.sdk.protobuf.c0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.fyber.inneractive.sdk.protobuf.c0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <L> java.util.List<L> a(java.lang.Object r3, long r4, int r6) {
            /*
                java.lang.Object r0 = com.fyber.inneractive.sdk.protobuf.p1.g(r3, r4)
                java.util.List r0 = (java.util.List) r0
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002f
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.d0
                if (r1 == 0) goto L_0x0016
                com.fyber.inneractive.sdk.protobuf.c0 r0 = new com.fyber.inneractive.sdk.protobuf.c0
                r0.<init>((int) r6)
                goto L_0x002b
            L_0x0016:
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.x0
                if (r1 == 0) goto L_0x0026
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.y.j
                if (r1 == 0) goto L_0x0026
                com.fyber.inneractive.sdk.protobuf.y$j r0 = (com.fyber.inneractive.sdk.protobuf.y.j) r0
                com.fyber.inneractive.sdk.protobuf.y$j r6 = r0.b(r6)
                r0 = r6
                goto L_0x002b
            L_0x0026:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x002b:
                com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
                goto L_0x0087
            L_0x002f:
                java.lang.Class<?> r1 = c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004d
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            L_0x004b:
                r0 = r1
                goto L_0x0087
            L_0x004d:
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.n1
                if (r1 == 0) goto L_0x006a
                com.fyber.inneractive.sdk.protobuf.c0 r1 = new com.fyber.inneractive.sdk.protobuf.c0
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                com.fyber.inneractive.sdk.protobuf.n1 r0 = (com.fyber.inneractive.sdk.protobuf.n1) r0
                java.util.List<java.lang.Object> r6 = r1.b
                int r6 = r6.size()
                r1.addAll(r6, r0)
                com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
                goto L_0x004b
            L_0x006a:
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.x0
                if (r1 == 0) goto L_0x0087
                boolean r1 = r0 instanceof com.fyber.inneractive.sdk.protobuf.y.j
                if (r1 == 0) goto L_0x0087
                r1 = r0
                com.fyber.inneractive.sdk.protobuf.y$j r1 = (com.fyber.inneractive.sdk.protobuf.y.j) r1
                boolean r2 = r1.d()
                if (r2 != 0) goto L_0x0087
                int r0 = r0.size()
                int r0 = r0 + r6
                com.fyber.inneractive.sdk.protobuf.y$j r0 = r1.b(r0)
                com.fyber.inneractive.sdk.protobuf.p1.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            L_0x0087:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.e0.b.a(java.lang.Object, long, int):java.util.List");
        }
    }
}
