package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.q1;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public abstract class l extends h {
    public static final Logger b = Logger.getLogger(l.class.getName());
    public static final boolean c = p1.g;
    public m a;

    public static abstract class b extends l {
        public final byte[] d;
        public final int e;
        public int f;
        public int g;

        public b(int i) {
            super();
            if (i >= 0) {
                int max = Math.max(i, 20);
                this.d = new byte[max];
                this.e = max;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int a() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void b(byte b) {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
            this.g++;
        }

        public final void e(long j) {
            byte[] bArr = this.d;
            int i = this.f;
            bArr[i] = (byte) ((int) (j & 255));
            bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
            bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
            bArr[i + 3] = (byte) ((int) (255 & (j >> 24)));
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.f = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            this.g += 8;
        }

        public final void f(long j) {
            if (l.c) {
                long j2 = (long) this.f;
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    p1.a(bArr, (long) i, (byte) ((((int) j) & WorkQueueKt.MASK) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                p1.a(bArr2, (long) i2, (byte) ((int) j));
                this.g += (int) (((long) this.f) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & WorkQueueKt.MASK) | 128);
                this.g++;
                j >>>= 7;
            }
            byte[] bArr4 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.g++;
        }

        public final void h(int i) {
            byte[] bArr = this.d;
            int i2 = this.f;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.f = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            this.g += 4;
        }

        public final void i(int i) {
            if (l.c) {
                long j = (long) this.f;
                while ((i & -128) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    p1.a(bArr, (long) i2, (byte) ((i & WorkQueueKt.MASK) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                p1.a(bArr2, (long) i3, (byte) i);
                this.g += (int) (((long) this.f) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                bArr3[i4] = (byte) ((i & WorkQueueKt.MASK) | 128);
                this.g++;
                i >>>= 7;
            }
            byte[] bArr4 = this.d;
            int i5 = this.f;
            this.f = i5 + 1;
            bArr4[i5] = (byte) i;
            this.g++;
        }
    }

    public static class d extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int a(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static l a(byte[] bArr) {
        return new c(bArr, 0, bArr.length);
    }

    public static int b(int i, int i2) {
        return b(i) + 4;
    }

    public static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int c(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int c(int i, int i2) {
        return b(i) + a(i2);
    }

    public static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int d(int i, int i2) {
        return b(i) + 4;
    }

    public static int e(int i, int i2) {
        return b(i) + c(d(i2));
    }

    public static int f(int i, int i2) {
        return b(i) + c(i2);
    }

    public abstract int a();

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i, o0 o0Var) throws IOException;

    public abstract void b(int i, i iVar) throws IOException;

    public abstract void b(int i, o0 o0Var, d1 d1Var) throws IOException;

    public abstract void b(int i, String str) throws IOException;

    public abstract void b(int i, boolean z) throws IOException;

    public abstract void c(int i, i iVar) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(long j) throws IOException;

    public abstract void e(int i) throws IOException;

    public abstract void f(int i) throws IOException;

    public abstract void f(int i, long j) throws IOException;

    public abstract void g(int i) throws IOException;

    public abstract void g(int i, int i2) throws IOException;

    public abstract void g(int i, long j) throws IOException;

    public abstract void h(int i, int i2) throws IOException;

    public abstract void i(int i, int i2) throws IOException;

    public abstract void j(int i, int i2) throws IOException;

    public static class c extends l {
        public final byte[] d;
        public final int e;
        public int f;

        public c(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.d = bArr;
                    this.f = i;
                    this.e = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final int a() {
            return this.e - this.f;
        }

        public final void a(int i, o0 o0Var) throws IOException {
            g(r1.a(1, 3));
            j(2, i);
            g(r1.a(3, 2));
            g(o0Var.getSerializedSize());
            o0Var.writeTo(this);
            g(r1.a(1, 4));
        }

        public final void b(int i, boolean z) throws IOException {
            g(r1.a(i, 0));
            a(z ? (byte) 1 : 0);
        }

        public final void c(int i, i iVar) throws IOException {
            g(r1.a(1, 3));
            j(2, i);
            b(3, iVar);
            g(r1.a(1, 4));
        }

        public final void d(long j) throws IOException {
            if (!l.c || a() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & WorkQueueKt.MASK) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    p1.a(bArr3, (long) i3, (byte) ((((int) j) & WorkQueueKt.MASK) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                p1.a(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void e(int i) throws IOException {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                bArr[i2] = (byte) (i & 255);
                bArr[i2 + 1] = (byte) ((i >> 8) & 255);
                bArr[i2 + 2] = (byte) ((i >> 16) & 255);
                this.f = i2 + 4;
                bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void f(int i, long j) throws IOException {
            g(r1.a(i, 1));
            c(j);
        }

        public final void g(int i) throws IOException {
            if (!l.c || d.a() || a() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & WorkQueueKt.MASK) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                p1.a(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.d;
                int i5 = this.f;
                this.f = i5 + 1;
                p1.a(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    p1.a(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.d;
                int i8 = this.f;
                this.f = i8 + 1;
                p1.a(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i >>> 14;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    p1.a(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.d;
                int i11 = this.f;
                this.f = i11 + 1;
                p1.a(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i >>> 21;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    p1.a(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.d;
                int i14 = this.f;
                this.f = i14 + 1;
                p1.a(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.d;
                int i15 = this.f;
                this.f = i15 + 1;
                p1.a(bArr11, (long) i15, (byte) (i >>> 28));
            }
        }

        public final void h(int i, int i2) throws IOException {
            g(r1.a(i, 0));
            if (i2 >= 0) {
                g(i2);
            } else {
                d((long) i2);
            }
        }

        public final void i(int i, int i2) throws IOException {
            g(r1.a(i, i2));
        }

        public final void j(int i, int i2) throws IOException {
            g(r1.a(i, 0));
            g(i2);
        }

        public final void b(int i, i iVar) throws IOException {
            g(r1.a(i, 2));
            b(iVar);
        }

        public final void f(int i) throws IOException {
            if (i >= 0) {
                g(i);
            } else {
                d((long) i);
            }
        }

        public final void b(int i, o0 o0Var, d1 d1Var) throws IOException {
            g(r1.a(i, 2));
            g(((a) o0Var).getSerializedSize(d1Var));
            d1Var.a(o0Var, (s1) this.a);
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                bArr[i] = (byte) (((int) j) & 255);
                bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
                bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
                bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
                bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
                bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
                bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
                this.f = i + 8;
                bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void a(byte b) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void b(int i, String str) throws IOException {
            g(r1.a(i, 2));
            b(str);
        }

        public final void b(i iVar) throws IOException {
            g(iVar.size());
            iVar.a((h) this);
        }

        public final void a(byte[] bArr, int i, int i2) throws IOException {
            b(bArr, i, i2);
        }

        public final void b(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)}), e2);
            }
        }

        public final void b(String str) throws IOException {
            int i = this.f;
            try {
                int c = l.c(str.length() * 3);
                int c2 = l.c(str.length());
                if (c2 == c) {
                    int i2 = i + c2;
                    this.f = i2;
                    int a = q1.a.a((CharSequence) str, this.d, i2, a());
                    this.f = i;
                    g((a - i) - c2);
                    this.f = a;
                    return;
                }
                g(q1.a((CharSequence) str));
                this.f = q1.a.a((CharSequence) str, this.d, this.f, a());
            } catch (q1.d e2) {
                this.f = i;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new d(e3);
            }
        }

        public final void g(int i, int i2) throws IOException {
            g(r1.a(i, 5));
            e(i2);
        }

        public final void g(int i, long j) throws IOException {
            g(r1.a(i, 0));
            d(j);
        }
    }

    public static final class e extends b {
        public final OutputStream h;

        public e(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.h = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        public void a(int i, o0 o0Var) throws IOException {
            g(r1.a(1, 3));
            j(2, i);
            g(r1.a(3, 2));
            g(o0Var.getSerializedSize());
            o0Var.writeTo(this);
            g(r1.a(1, 4));
        }

        public void b(int i, i iVar) throws IOException {
            g(r1.a(i, 2));
            b(iVar);
        }

        public void c(int i, i iVar) throws IOException {
            g(r1.a(1, 3));
            j(2, i);
            b(3, iVar);
            g(r1.a(1, 4));
        }

        public void d(long j) throws IOException {
            j(10);
            f(j);
        }

        public void e(int i) throws IOException {
            j(4);
            h(i);
        }

        public void f(int i, long j) throws IOException {
            j(18);
            i(r1.a(i, 1));
            e(j);
        }

        public void g(int i, int i2) throws IOException {
            j(14);
            i(r1.a(i, 5));
            h(i2);
        }

        public void h(int i, int i2) throws IOException {
            j(20);
            i(r1.a(i, 0));
            if (i2 >= 0) {
                i(i2);
            } else {
                f((long) i2);
            }
        }

        public void i(int i, int i2) throws IOException {
            g(r1.a(i, i2));
        }

        public void j(int i, int i2) throws IOException {
            j(20);
            i(r1.a(i, 0));
            i(i2);
        }

        public void b(int i, o0 o0Var, d1 d1Var) throws IOException {
            g(r1.a(i, 2));
            g(((a) o0Var).getSerializedSize(d1Var));
            d1Var.a(o0Var, (s1) this.a);
        }

        public void f(int i) throws IOException {
            if (i >= 0) {
                j(5);
                i(i);
                return;
            }
            d((long) i);
        }

        public void g(int i, long j) throws IOException {
            j(20);
            i(r1.a(i, 0));
            f(j);
        }

        public final void j(int i) throws IOException {
            if (this.e - this.f < i) {
                b();
            }
        }

        public void c(long j) throws IOException {
            j(8);
            e(j);
        }

        public void b(int i, String str) throws IOException {
            g(r1.a(i, 2));
            b(str);
        }

        public void a(byte b) throws IOException {
            if (this.f == this.e) {
                b();
            }
            b(b);
        }

        public void g(int i) throws IOException {
            j(5);
            i(i);
        }

        public void b(int i, boolean z) throws IOException {
            j(11);
            i(r1.a(i, 0));
            b(z ? (byte) 1 : 0);
        }

        public void b(i iVar) throws IOException {
            g(iVar.size());
            iVar.a((h) this);
        }

        public void a(byte[] bArr, int i, int i2) throws IOException {
            b(bArr, i, i2);
        }

        public void b(String str) throws IOException {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int c = l.c(length);
                int i3 = c + length;
                int i4 = this.e;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int a = q1.a.a((CharSequence) str, bArr, 0, length);
                    g(a);
                    b(bArr, 0, a);
                    return;
                }
                if (i3 > i4 - this.f) {
                    b();
                }
                int c2 = l.c(str.length());
                i = this.f;
                if (c2 == c) {
                    int i5 = i + c2;
                    this.f = i5;
                    int a2 = q1.a.a((CharSequence) str, this.d, i5, this.e - i5);
                    this.f = i;
                    i2 = (a2 - i) - c2;
                    i(i2);
                    this.f = a2;
                } else {
                    i2 = q1.a((CharSequence) str);
                    i(i2);
                    this.f = q1.a.a((CharSequence) str, this.d, this.f, i2);
                }
                this.g += i2;
            } catch (q1.d e) {
                this.g -= this.f - i;
                this.f = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new d(e2);
            } catch (q1.d e3) {
                a(str, e3);
            }
        }

        public void b(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.e;
            int i4 = this.f;
            int i5 = i3 - i4;
            if (i5 >= i2) {
                System.arraycopy(bArr, i, this.d, i4, i2);
                this.f += i2;
                this.g += i2;
                return;
            }
            System.arraycopy(bArr, i, this.d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f = this.e;
            this.g += i5;
            b();
            if (i7 <= this.e) {
                System.arraycopy(bArr, i6, this.d, 0, i7);
                this.f = i7;
            } else {
                this.h.write(bArr, i6, i7);
            }
            this.g += i7;
        }

        public final void b() throws IOException {
            this.h.write(this.d, 0, this.f);
            this.f = 0;
        }
    }

    public l() {
    }

    public static int b(int i, long j) {
        return b(i) + a(j);
    }

    public static int c(int i, long j) {
        return b(i) + 8;
    }

    public static int d(int i, long j) {
        return b(i) + a(b(j));
    }

    public static int a(b0 b0Var) {
        int i;
        if (b0Var.b != null) {
            i = b0Var.b.size();
        } else {
            i = b0Var.a != null ? b0Var.a.getSerializedSize() : 0;
        }
        return c(i) + i;
    }

    public static int e(int i, long j) {
        return b(i) + a(j);
    }

    public static int b(int i) {
        return c(r1.a(i, 0));
    }

    public static int a(int i, long j) {
        return b(i) + 8;
    }

    public static int a(int i, float f) {
        return b(i) + 4;
    }

    public static int a(int i, double d2) {
        return b(i) + 8;
    }

    public static int a(int i, boolean z) {
        return b(i) + 1;
    }

    public static int a(int i, int i2) {
        return b(i) + a(i2);
    }

    public static int a(int i, String str) {
        return b(i) + a(str);
    }

    public static int a(int i, i iVar) {
        int b2 = b(i);
        int size = iVar.size();
        return b2 + c(size) + size;
    }

    public static int a(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    public static int a(String str) {
        int i;
        try {
            i = q1.a((CharSequence) str);
        } catch (q1.d unused) {
            i = str.getBytes(y.a).length;
        }
        return c(i) + i;
    }

    public static int a(i iVar) {
        int size = iVar.size();
        return c(size) + size;
    }

    public final void a(String str, q1.d dVar) throws IOException {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(y.a);
        try {
            g(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new d(e2);
        } catch (d e3) {
            throw e3;
        }
    }

    @Deprecated
    public static int a(int i, o0 o0Var, d1 d1Var) {
        return (b(i) * 2) + ((a) o0Var).getSerializedSize(d1Var);
    }
}
