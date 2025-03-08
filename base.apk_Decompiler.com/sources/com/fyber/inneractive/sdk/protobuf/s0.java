package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.a0;
import com.fyber.inneractive.sdk.protobuf.r1;
import com.fyber.inneractive.sdk.protobuf.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class s0<T> implements d1<T> {
    public final o0 a;
    public final k1<?, ?> b;
    public final boolean c;
    public final r<?> d;

    public s0(k1<?, ?> k1Var, r<?> rVar, o0 o0Var) {
        this.b = k1Var;
        this.c = rVar.a(o0Var);
        this.d = rVar;
        this.a = o0Var;
    }

    public T a() {
        return ((GeneratedMessageLite.b) this.a.newBuilderForType()).b();
    }

    public boolean b(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a((Object) t).equals(this.d.a((Object) t2));
        }
        return true;
    }

    public void c(T t) {
        this.b.e(t);
        this.d.c(t);
    }

    public int d(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a((Object) t).a.hashCode() : hashCode;
    }

    public void a(T t, T t2) {
        k1<?, ?> k1Var = this.b;
        Class<?> cls = f1.a;
        k1Var.c(t, k1Var.a(k1Var.b(t), k1Var.b(t2)));
        if (this.c) {
            r<?> rVar = this.d;
            u<?> a2 = rVar.a((Object) t2);
            if (!a2.a.isEmpty()) {
                rVar.b(t).a(a2);
            }
        }
    }

    public int b(T t) {
        k1<?, ?> k1Var = this.b;
        int d2 = k1Var.d(k1Var.b(t));
        return this.c ? d2 + this.d.a((Object) t).c() : d2;
    }

    public void a(T t, s1 s1Var) throws IOException {
        Iterator<Map.Entry<?, Object>> f = this.d.a((Object) t).f();
        while (f.hasNext()) {
            Map.Entry next = f.next();
            u.b bVar = (u.b) next.getKey();
            if (bVar.d() != r1.c.MESSAGE || bVar.b() || bVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof a0.a) {
                ((m) s1Var).a(bVar.a(), (Object) ((a0.a) next).a.getValue().a());
            } else {
                ((m) s1Var).a(bVar.a(), next.getValue());
            }
        }
        k1<?, ?> k1Var = this.b;
        k1Var.a(k1Var.b(t), s1Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r11, byte[] r12, int r13, int r14, com.fyber.inneractive.sdk.protobuf.e.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite r0 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite) r0
            com.fyber.inneractive.sdk.protobuf.l1 r1 = r0.unknownFields
            com.fyber.inneractive.sdk.protobuf.l1 r2 = com.fyber.inneractive.sdk.protobuf.l1.f
            if (r1 != r2) goto L_0x000f
            com.fyber.inneractive.sdk.protobuf.l1 r1 = com.fyber.inneractive.sdk.protobuf.l1.c()
            r0.unknownFields = r1
        L_0x000f:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.fyber.inneractive.sdk.protobuf.u r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L_0x0017:
            if (r13 >= r14) goto L_0x00c5
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r13, r15)
            int r13 = r15.a
            int r3 = com.fyber.inneractive.sdk.protobuf.r1.a
            r5 = 2
            if (r13 == r3) goto L_0x0061
            r3 = r13 & 7
            if (r3 != r5) goto L_0x005c
            com.fyber.inneractive.sdk.protobuf.r<?> r2 = r10.d
            com.fyber.inneractive.sdk.protobuf.q r3 = r15.d
            com.fyber.inneractive.sdk.protobuf.o0 r5 = r10.a
            int r6 = r13 >>> 3
            java.lang.Object r2 = r2.a(r3, r5, r6)
            r8 = r2
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e r8 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.e) r8
            if (r8 == 0) goto L_0x0051
            com.fyber.inneractive.sdk.protobuf.z0 r13 = com.fyber.inneractive.sdk.protobuf.z0.c
            com.fyber.inneractive.sdk.protobuf.o0 r2 = r8.c
            java.lang.Class r2 = r2.getClass()
            com.fyber.inneractive.sdk.protobuf.d1 r13 = r13.a(r2)
            int r13 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r13, (byte[]) r12, (int) r4, (int) r14, (com.fyber.inneractive.sdk.protobuf.e.b) r15)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r2 = r8.d
            java.lang.Object r3 = r15.c
            r11.c(r2, r3)
            goto L_0x005a
        L_0x0051:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.fyber.inneractive.sdk.protobuf.e.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.fyber.inneractive.sdk.protobuf.l1) r6, (com.fyber.inneractive.sdk.protobuf.e.b) r7)
        L_0x005a:
            r2 = r8
            goto L_0x0017
        L_0x005c:
            int r13 = com.fyber.inneractive.sdk.protobuf.e.a((int) r13, (byte[]) r12, (int) r4, (int) r14, (com.fyber.inneractive.sdk.protobuf.e.b) r15)
            goto L_0x0017
        L_0x0061:
            r13 = 0
            r3 = r0
        L_0x0063:
            if (r4 >= r14) goto L_0x00b9
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r4, r15)
            int r6 = r15.a
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto L_0x009a
            r9 = 3
            if (r7 == r9) goto L_0x0075
            goto L_0x00af
        L_0x0075:
            if (r2 == 0) goto L_0x008f
            com.fyber.inneractive.sdk.protobuf.z0 r6 = com.fyber.inneractive.sdk.protobuf.z0.c
            com.fyber.inneractive.sdk.protobuf.o0 r7 = r2.c
            java.lang.Class r7 = r7.getClass()
            com.fyber.inneractive.sdk.protobuf.d1 r6 = r6.a(r7)
            int r4 = com.fyber.inneractive.sdk.protobuf.e.a((com.fyber.inneractive.sdk.protobuf.d1) r6, (byte[]) r12, (int) r4, (int) r14, (com.fyber.inneractive.sdk.protobuf.e.b) r15)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r6 = r2.d
            java.lang.Object r7 = r15.c
            r11.c(r6, r7)
            goto L_0x0063
        L_0x008f:
            if (r8 != r5) goto L_0x00af
            int r4 = com.fyber.inneractive.sdk.protobuf.e.a(r12, r4, r15)
            java.lang.Object r3 = r15.c
            com.fyber.inneractive.sdk.protobuf.i r3 = (com.fyber.inneractive.sdk.protobuf.i) r3
            goto L_0x0063
        L_0x009a:
            if (r8 != 0) goto L_0x00af
            int r4 = com.fyber.inneractive.sdk.protobuf.e.d(r12, r4, r15)
            int r13 = r15.a
            com.fyber.inneractive.sdk.protobuf.r<?> r2 = r10.d
            com.fyber.inneractive.sdk.protobuf.q r6 = r15.d
            com.fyber.inneractive.sdk.protobuf.o0 r7 = r10.a
            java.lang.Object r2 = r2.a(r6, r7, r13)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e r2 = (com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.e) r2
            goto L_0x0063
        L_0x00af:
            int r7 = com.fyber.inneractive.sdk.protobuf.r1.b
            if (r6 != r7) goto L_0x00b4
            goto L_0x00b9
        L_0x00b4:
            int r4 = com.fyber.inneractive.sdk.protobuf.e.a((int) r6, (byte[]) r12, (int) r4, (int) r14, (com.fyber.inneractive.sdk.protobuf.e.b) r15)
            goto L_0x0063
        L_0x00b9:
            if (r3 == 0) goto L_0x00c2
            int r13 = com.fyber.inneractive.sdk.protobuf.r1.a(r13, r5)
            r1.a((int) r13, (java.lang.Object) r3)
        L_0x00c2:
            r13 = r4
            goto L_0x0017
        L_0x00c5:
            if (r13 != r14) goto L_0x00c8
            return
        L_0x00c8:
            com.fyber.inneractive.sdk.protobuf.z r11 = com.fyber.inneractive.sdk.protobuf.z.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.s0.a(java.lang.Object, byte[], int, int, com.fyber.inneractive.sdk.protobuf.e$b):void");
    }

    public void a(T t, c1 c1Var, q qVar) throws IOException {
        k1<?, ?> k1Var = this.b;
        r<?> rVar = this.d;
        Object a2 = k1Var.a((Object) t);
        u<?> b2 = rVar.b(t);
        while (true) {
            try {
                if (c1Var.s() != Integer.MAX_VALUE) {
                    if (!a(c1Var, qVar, rVar, b2, k1Var, a2)) {
                        break;
                    }
                } else {
                    break;
                }
            } finally {
                k1Var.b((Object) t, a2);
            }
        }
    }

    public final <UT, UB, ET extends u.b<ET>> boolean a(c1 c1Var, q qVar, r<ET> rVar, u<ET> uVar, k1<UT, UB> k1Var, UB ub) throws IOException {
        int e = c1Var.e();
        if (e == r1.a) {
            Object obj = null;
            i iVar = null;
            int i = 0;
            while (c1Var.s() != Integer.MAX_VALUE) {
                int e2 = c1Var.e();
                if (e2 == r1.c) {
                    i = c1Var.c();
                    obj = rVar.a(qVar, this.a, i);
                } else if (e2 == r1.d) {
                    if (obj != null) {
                        rVar.a(c1Var, obj, qVar, uVar);
                    } else {
                        iVar = c1Var.a();
                    }
                } else if (!c1Var.i()) {
                    break;
                }
            }
            if (c1Var.e() == r1.b) {
                if (iVar != null) {
                    if (obj != null) {
                        rVar.a(iVar, obj, qVar, uVar);
                    } else {
                        k1Var.a(ub, i, iVar);
                    }
                }
                return true;
            }
            throw z.a();
        } else if ((e & 7) != 2) {
            return c1Var.i();
        } else {
            Object a2 = rVar.a(qVar, this.a, e >>> 3);
            if (a2 == null) {
                return k1Var.a(ub, c1Var);
            }
            rVar.a(c1Var, a2, qVar, uVar);
            return true;
        }
    }

    public final boolean a(T t) {
        return this.d.a((Object) t).e();
    }
}
