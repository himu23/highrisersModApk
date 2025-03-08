package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;

public abstract class k1<T, B> {
    public abstract B a();

    public abstract B a(Object obj);

    public abstract T a(T t, T t2);

    public abstract void a(B b, int i, int i2);

    public abstract void a(B b, int i, long j);

    public abstract void a(B b, int i, i iVar);

    public abstract void a(B b, int i, T t);

    public abstract void a(T t, s1 s1Var) throws IOException;

    public abstract boolean a(c1 c1Var);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[LOOP:0: B:16:0x0032->B:19:0x003f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(B r7, com.fyber.inneractive.sdk.protobuf.c1 r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.e()
            int r1 = com.fyber.inneractive.sdk.protobuf.r1.a
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0064
            if (r0 == r2) goto L_0x005c
            r3 = 2
            if (r0 == r3) goto L_0x0054
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x002a
            if (r0 == r3) goto L_0x0028
            r3 = 5
            if (r0 != r3) goto L_0x0023
            int r8 = r8.q()
            r6.a(r7, (int) r1, (int) r8)
            return r2
        L_0x0023:
            com.fyber.inneractive.sdk.protobuf.z$a r7 = com.fyber.inneractive.sdk.protobuf.z.d()
            throw r7
        L_0x0028:
            r7 = 0
            return r7
        L_0x002a:
            java.lang.Object r0 = r6.a()
            int r3 = com.fyber.inneractive.sdk.protobuf.r1.a(r1, r3)
        L_0x0032:
            int r4 = r8.s()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0041
            boolean r4 = r6.a(r0, (com.fyber.inneractive.sdk.protobuf.c1) r8)
            if (r4 != 0) goto L_0x0032
        L_0x0041:
            int r8 = r8.e()
            if (r3 != r8) goto L_0x004f
            java.lang.Object r8 = r6.f(r0)
            r6.a(r7, (int) r1, r8)
            return r2
        L_0x004f:
            com.fyber.inneractive.sdk.protobuf.z r7 = com.fyber.inneractive.sdk.protobuf.z.a()
            throw r7
        L_0x0054:
            com.fyber.inneractive.sdk.protobuf.i r8 = r8.a()
            r6.a(r7, (int) r1, (com.fyber.inneractive.sdk.protobuf.i) r8)
            return r2
        L_0x005c:
            long r3 = r8.g()
            r6.a(r7, (int) r1, (long) r3)
            return r2
        L_0x0064:
            long r3 = r8.o()
            r6.b(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.k1.a(java.lang.Object, com.fyber.inneractive.sdk.protobuf.c1):boolean");
    }

    public abstract T b(Object obj);

    public abstract void b(B b, int i, long j);

    public abstract void b(T t, s1 s1Var) throws IOException;

    public abstract void b(Object obj, B b);

    public abstract int c(T t);

    public abstract void c(Object obj, T t);

    public abstract int d(T t);

    public abstract void e(Object obj);

    public abstract T f(B b);
}
