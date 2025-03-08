package com.fyber.inneractive.sdk.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.protobuf.h0;
import com.fyber.inneractive.sdk.protobuf.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public abstract class f implements c1 {

    public static final class b extends f {
        public final boolean a;
        public final byte[] b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b(ByteBuffer byteBuffer, boolean z) {
            super();
            this.a = z;
            this.b = byteBuffer.array();
            this.c = byteBuffer.arrayOffset() + byteBuffer.position();
            this.d = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        public final long C() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte v = v();
                j |= ((long) (v & Byte.MAX_VALUE)) << i;
                if ((v & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw z.e();
        }

        public String a(boolean z) throws IOException {
            c(2);
            int A = A();
            if (A == 0) {
                return "";
            }
            a(A);
            if (z) {
                byte[] bArr = this.b;
                int i = this.c;
                if (!q1.b(bArr, i, i + A)) {
                    throw z.c();
                }
            }
            String str = new String(this.b, this.c, A, y.a);
            this.c += A;
            return str;
        }

        public <T> T b(Class<T> cls, q qVar) throws IOException {
            c(2);
            return d(z0.c.a(cls), qVar);
        }

        public int d() throws IOException {
            c(0);
            return A();
        }

        public int e() {
            return this.e;
        }

        public long f() throws IOException {
            c(0);
            return B();
        }

        public long g() throws IOException {
            c(1);
            return y();
        }

        public double h() throws IOException {
            c(1);
            return Double.longBitsToDouble(y());
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[LOOP:0: B:18:0x0032->B:21:0x003f, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean i() throws java.io.IOException {
            /*
                r7 = this;
                boolean r0 = r7.u()
                r1 = 0
                if (r0 != 0) goto L_0x0089
                int r0 = r7.e
                int r2 = r7.f
                if (r0 != r2) goto L_0x000f
                goto L_0x0089
            L_0x000f:
                int r3 = com.fyber.inneractive.sdk.protobuf.r1.a
                r3 = r0 & 7
                r4 = 1
                if (r3 == 0) goto L_0x005d
                if (r3 == r4) goto L_0x0057
                r1 = 2
                if (r3 == r1) goto L_0x004f
                r1 = 4
                r5 = 3
                if (r3 == r5) goto L_0x002b
                r0 = 5
                if (r3 != r0) goto L_0x0026
                r7.d((int) r1)
                return r4
            L_0x0026:
                com.fyber.inneractive.sdk.protobuf.z$a r0 = com.fyber.inneractive.sdk.protobuf.z.d()
                throw r0
            L_0x002b:
                int r0 = r0 >>> r5
                int r0 = com.fyber.inneractive.sdk.protobuf.r1.a(r0, r1)
                r7.f = r0
            L_0x0032:
                int r0 = r7.s()
                r1 = 2147483647(0x7fffffff, float:NaN)
                if (r0 == r1) goto L_0x0041
                boolean r0 = r7.i()
                if (r0 != 0) goto L_0x0032
            L_0x0041:
                int r0 = r7.e
                int r1 = r7.f
                if (r0 != r1) goto L_0x004a
                r7.f = r2
                return r4
            L_0x004a:
                com.fyber.inneractive.sdk.protobuf.z r0 = com.fyber.inneractive.sdk.protobuf.z.g()
                throw r0
            L_0x004f:
                int r0 = r7.A()
                r7.d((int) r0)
                return r4
            L_0x0057:
                r0 = 8
                r7.d((int) r0)
                return r4
            L_0x005d:
                int r0 = r7.d
                int r2 = r7.c
                int r0 = r0 - r2
                r3 = 10
                if (r0 < r3) goto L_0x0078
                byte[] r0 = r7.b
                r5 = 0
            L_0x0069:
                if (r5 >= r3) goto L_0x0078
                int r6 = r2 + 1
                byte r2 = r0[r2]
                if (r2 < 0) goto L_0x0074
                r7.c = r6
                goto L_0x0080
            L_0x0074:
                int r5 = r5 + 1
                r2 = r6
                goto L_0x0069
            L_0x0078:
                if (r1 >= r3) goto L_0x0084
                byte r0 = r7.v()
                if (r0 < 0) goto L_0x0081
            L_0x0080:
                return r4
            L_0x0081:
                int r1 = r1 + 1
                goto L_0x0078
            L_0x0084:
                com.fyber.inneractive.sdk.protobuf.z r0 = com.fyber.inneractive.sdk.protobuf.z.e()
                throw r0
            L_0x0089:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.f.b.i():boolean");
        }

        public int j() throws IOException {
            c(0);
            return j.b(A());
        }

        public float k() throws IOException {
            c(5);
            return Float.intBitsToFloat(w());
        }

        public long l() throws IOException {
            c(0);
            return j.a(B());
        }

        public int m() throws IOException {
            c(5);
            return w();
        }

        public String n() throws IOException {
            return a(false);
        }

        public long o() throws IOException {
            c(0);
            return B();
        }

        public String p() throws IOException {
            return a(true);
        }

        public int q() throws IOException {
            c(5);
            return w();
        }

        public boolean r() throws IOException {
            c(0);
            if (A() != 0) {
                return true;
            }
            return false;
        }

        public int s() throws IOException {
            if (u()) {
                return Integer.MAX_VALUE;
            }
            int A = A();
            this.e = A;
            if (A == this.f) {
                return Integer.MAX_VALUE;
            }
            int i = r1.a;
            return A >>> 3;
        }

        public long t() throws IOException {
            c(1);
            return y();
        }

        public final boolean u() {
            return this.c == this.d;
        }

        public final int w() throws IOException {
            a(4);
            return x();
        }

        public final long y() throws IOException {
            a(8);
            return z();
        }

        public final <T> T c(d1<T> d1Var, q qVar) throws IOException {
            int i = this.f;
            int i2 = this.e;
            int i3 = r1.a;
            this.f = r1.a(i2 >>> 3, 4);
            try {
                T a2 = d1Var.a();
                d1Var.a(a2, this, qVar);
                d1Var.c(a2);
                if (this.e == this.f) {
                    return a2;
                }
                throw z.g();
            } finally {
                this.f = i;
            }
        }

        public void e(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int A = A();
                    e(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        xVar.c(x());
                    }
                } else if (i5 == 5) {
                    do {
                        xVar.c(q());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 2) {
                    int A2 = A();
                    e(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Integer.valueOf(x()));
                    }
                } else if (i9 == 5) {
                    do {
                        list.add(Integer.valueOf(q()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else {
                    throw z.d();
                }
            }
        }

        public void n(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        f0Var.a(g());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = A();
                    f(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        f0Var.a(z());
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 1) {
                    do {
                        list.add(Long.valueOf(g()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i9 == 2) {
                    int A2 = A();
                    f(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Long.valueOf(z()));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public void p(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        xVar.c(b());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        xVar.c(A());
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Integer.valueOf(b()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Integer.valueOf(A()));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public final <T> T d(d1<T> d1Var, q qVar) throws IOException {
            int A = A();
            a(A);
            int i = this.d;
            int i2 = this.c + A;
            this.d = i2;
            try {
                T a2 = d1Var.a();
                d1Var.a(a2, this, qVar);
                d1Var.c(a2);
                if (this.c == i2) {
                    return a2;
                }
                throw z.g();
            } finally {
                this.d = i;
            }
        }

        public void f(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int A = A();
                    e(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        xVar.c(x());
                    }
                } else if (i5 == 5) {
                    do {
                        xVar.c(m());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 2) {
                    int A2 = A();
                    e(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Integer.valueOf(x()));
                    }
                } else if (i9 == 5) {
                    do {
                        list.add(Integer.valueOf(m()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else {
                    throw z.d();
                }
            }
        }

        public void g(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        f0Var.a(l());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        f0Var.a(j.a(B()));
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Long.valueOf(l()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Long.valueOf(j.a(B())));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public void h(List<i> list) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 2) {
                do {
                    list.add(a());
                    if (!u()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            throw z.d();
        }

        public void j(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof n) {
                n nVar = (n) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        nVar.a(h());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = A();
                    f(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        nVar.a(Double.longBitsToDouble(z()));
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 1) {
                    do {
                        list.add(Double.valueOf(h()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i9 == 2) {
                    int A2 = A();
                    f(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Double.valueOf(Double.longBitsToDouble(z())));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public void k(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        f0Var.a(o());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        f0Var.a(B());
                    }
                    b(A);
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Long.valueOf(o()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Long.valueOf(B()));
                    }
                    b(A2);
                } else {
                    throw z.d();
                }
            }
        }

        public void l(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof g) {
                g gVar = (g) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        gVar.a(r());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        gVar.a(A() != 0);
                    }
                    b(A);
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Boolean.valueOf(r()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Boolean.valueOf(A() != 0));
                    }
                    b(A2);
                } else {
                    throw z.d();
                }
            }
        }

        public void m(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        f0Var.a(t());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = A();
                    f(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        f0Var.a(z());
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 1) {
                    do {
                        list.add(Long.valueOf(t()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i9 == 2) {
                    int A2 = A();
                    f(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Long.valueOf(z()));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public void o(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        xVar.c(d());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        xVar.c(A());
                    }
                    b(A);
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Integer.valueOf(d()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Integer.valueOf(A()));
                    }
                    b(A2);
                } else {
                    throw z.d();
                }
            }
        }

        public void q(List<String> list) throws IOException {
            a(list, false);
        }

        public <T> T b(d1<T> d1Var, q qVar) throws IOException {
            c(2);
            return d(d1Var, qVar);
        }

        public final byte v() throws IOException {
            int i = this.c;
            if (i != this.d) {
                byte[] bArr = this.b;
                this.c = i + 1;
                return bArr[i];
            }
            throw z.i();
        }

        public final int x() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Ascii.DLE);
        }

        public final long z() {
            int i = this.c;
            byte[] bArr = this.b;
            this.c = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public int b() throws IOException {
            c(0);
            return A();
        }

        public final int A() throws IOException {
            byte b2;
            byte b3;
            int i = this.c;
            int i2 = this.d;
            if (i2 != i) {
                byte[] bArr = this.b;
                int i3 = i + 1;
                byte b4 = bArr[i];
                if (b4 >= 0) {
                    this.c = i3;
                    return b4;
                } else if (i2 - i3 < 9) {
                    return (int) C();
                } else {
                    int i4 = i + 2;
                    byte b5 = (bArr[i3] << 7) ^ b4;
                    if (b5 < 0) {
                        b2 = b5 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        int i5 = i + 3;
                        byte b6 = (bArr[i4] << Ascii.SO) ^ b5;
                        if (b6 >= 0) {
                            b3 = b6 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            int i6 = i + 4;
                            byte b7 = b6 ^ (bArr[i5] << Ascii.NAK);
                            if (b7 < 0) {
                                b2 = -2080896 ^ b7;
                            } else {
                                i5 = i + 5;
                                byte b8 = bArr[i6];
                                byte b9 = (b7 ^ (b8 << Ascii.FS)) ^ ByteCompanionObject.MIN_VALUE;
                                if (b8 < 0) {
                                    i6 = i + 6;
                                    if (bArr[i5] < 0) {
                                        i5 = i + 7;
                                        if (bArr[i6] < 0) {
                                            i6 = i + 8;
                                            if (bArr[i5] < 0) {
                                                i5 = i + 9;
                                                if (bArr[i6] < 0) {
                                                    int i7 = i + 10;
                                                    if (bArr[i5] >= 0) {
                                                        byte b10 = b9;
                                                        i4 = i7;
                                                        b2 = b10;
                                                    } else {
                                                        throw z.e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b2 = b9;
                                }
                                b3 = b9;
                            }
                            i4 = i6;
                        }
                        i4 = i5;
                    }
                    this.c = i4;
                    return b2;
                }
            } else {
                throw z.i();
            }
        }

        public void b(List<String> list) throws IOException {
            a(list, true);
        }

        public <T> void b(List<T> list, d1<T> d1Var, q qVar) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 2) {
                do {
                    list.add(d(d1Var, qVar));
                    if (!u()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (A() == i2);
                this.c = i;
                return;
            }
            throw z.d();
        }

        public long B() throws IOException {
            long j;
            long j2;
            long j3;
            int i = this.c;
            int i2 = this.d;
            if (i2 != i) {
                byte[] bArr = this.b;
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.c = i3;
                    return (long) b2;
                } else if (i2 - i3 < 9) {
                    return C();
                } else {
                    int i4 = i + 2;
                    byte b3 = (bArr[i3] << 7) ^ b2;
                    if (b3 < 0) {
                        j = (long) (b3 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        int i5 = i + 3;
                        byte b4 = (bArr[i4] << Ascii.SO) ^ b3;
                        if (b4 >= 0) {
                            j = (long) (b4 ^ ByteCompanionObject.MIN_VALUE);
                            i4 = i5;
                        } else {
                            int i6 = i + 4;
                            byte b5 = b4 ^ (bArr[i5] << Ascii.NAK);
                            if (b5 < 0) {
                                i4 = i6;
                                j = (long) (-2080896 ^ b5);
                            } else {
                                long j4 = (long) b5;
                                int i7 = i + 5;
                                long j5 = j4 ^ (((long) bArr[i6]) << 28);
                                if (j5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i8 = i + 6;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i7 = i + 7;
                                        j5 = j6 ^ (((long) bArr[i8]) << 42);
                                        if (j5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i8 = i + 8;
                                            j6 = j5 ^ (((long) bArr[i7]) << 49);
                                            if (j6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j7 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                                if (j7 < 0) {
                                                    int i9 = i + 10;
                                                    if (((long) bArr[i4]) >= 0) {
                                                        i4 = i9;
                                                    } else {
                                                        throw z.e();
                                                    }
                                                }
                                                j = j7;
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                    i4 = i8;
                                }
                                j = j5 ^ j3;
                            }
                        }
                    }
                    this.c = i4;
                    return j;
                }
            } else {
                throw z.i();
            }
        }

        public <T> T a(Class<T> cls, q qVar) throws IOException {
            c(3);
            return c(z0.c.a(cls), qVar);
        }

        public <T> T a(d1<T> d1Var, q qVar) throws IOException {
            c(3);
            return c(d1Var, qVar);
        }

        public i a() throws IOException {
            i iVar;
            c(2);
            int A = A();
            if (A == 0) {
                return i.b;
            }
            a(A);
            if (this.a) {
                byte[] bArr = this.b;
                int i = this.c;
                i iVar2 = i.b;
                iVar = new i.d(bArr, i, A);
            } else {
                iVar = i.a(this.b, this.c, A);
            }
            this.c += A;
            return iVar;
        }

        public int c() throws IOException {
            c(0);
            return A();
        }

        public void c(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        xVar.c(j());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        xVar.c(j.b(A()));
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Integer.valueOf(j()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Integer.valueOf(j.b(A())));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public final void b(int i) throws IOException {
            if (this.c != i) {
                throw z.i();
            }
        }

        public void a(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        f0Var.a(f());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        f0Var.a(B());
                    }
                    b(A);
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Long.valueOf(B()));
                    }
                    b(A2);
                } else {
                    throw z.d();
                }
            }
        }

        public void d(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof v) {
                v vVar = (v) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int A = A();
                    e(A);
                    int i6 = this.c + A;
                    while (this.c < i6) {
                        vVar.a(Float.intBitsToFloat(x()));
                    }
                } else if (i5 == 5) {
                    do {
                        vVar.a(k());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else {
                    throw z.d();
                }
            } else {
                int i7 = this.e;
                int i8 = r1.a;
                int i9 = i7 & 7;
                if (i9 == 2) {
                    int A2 = A();
                    e(A2);
                    int i10 = this.c + A2;
                    while (this.c < i10) {
                        list.add(Float.valueOf(Float.intBitsToFloat(x())));
                    }
                } else if (i9 == 5) {
                    do {
                        list.add(Float.valueOf(k()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else {
                    throw z.d();
                }
            }
        }

        public void i(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        xVar.c(c());
                        if (!u()) {
                            i2 = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                } else if (i5 == 2) {
                    int A = this.c + A();
                    while (this.c < A) {
                        xVar.c(A());
                    }
                } else {
                    throw z.d();
                }
            } else {
                int i6 = this.e;
                int i7 = r1.a;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    do {
                        list.add(Integer.valueOf(c()));
                        if (!u()) {
                            i = this.c;
                        } else {
                            return;
                        }
                    } while (A() == this.e);
                    this.c = i;
                } else if (i8 == 2) {
                    int A2 = this.c + A();
                    while (this.c < A2) {
                        list.add(Integer.valueOf(A()));
                    }
                } else {
                    throw z.d();
                }
            }
        }

        public final void e(int i) throws IOException {
            a(i);
            if ((i & 3) != 0) {
                throw z.g();
            }
        }

        public final void f(int i) throws IOException {
            a(i);
            if ((i & 7) != 0) {
                throw z.g();
            }
        }

        public final void c(int i) throws IOException {
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) != i) {
                throw z.d();
            }
        }

        public void a(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            int i3 = this.e;
            int i4 = r1.a;
            if ((i3 & 7) != 2) {
                throw z.d();
            } else if (!(list instanceof d0) || z) {
                do {
                    list.add(a(z));
                    if (!u()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (A() == this.e);
                this.c = i;
            } else {
                d0 d0Var = (d0) list;
                do {
                    d0Var.a(a());
                    if (!u()) {
                        i2 = this.c;
                    } else {
                        return;
                    }
                } while (A() == this.e);
                this.c = i2;
            }
        }

        public final void d(int i) throws IOException {
            a(i);
            this.c += i;
        }

        public <T> void a(List<T> list, d1<T> d1Var, q qVar) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 3) {
                do {
                    list.add(c(d1Var, qVar));
                    if (!u()) {
                        i = this.c;
                    } else {
                        return;
                    }
                } while (A() == i2);
                this.c = i;
                return;
            }
            throw z.d();
        }

        public <K, V> void a(Map<K, V> map, h0.a<K, V> aVar, q qVar) throws IOException {
            c(2);
            int A = A();
            a(A);
            int i = this.d;
            this.d = this.c + A;
            try {
                throw null;
            } catch (Throwable th) {
                this.d = i;
                throw th;
            }
        }

        public final void a(int i) throws IOException {
            if (i < 0 || i > this.d - this.c) {
                throw z.i();
            }
        }
    }

    public f() {
    }
}
