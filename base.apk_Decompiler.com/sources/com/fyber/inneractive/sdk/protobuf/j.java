package com.fyber.inneractive.sdk.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.i;
import com.fyber.inneractive.sdk.protobuf.o0;
import com.fyber.inneractive.sdk.protobuf.p1;
import com.fyber.inneractive.sdk.protobuf.q1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public abstract class j {
    public int a;
    public int b;
    public int c;
    public k d;

    public static final class b extends j {
        public final byte[] e;
        public final boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l = Integer.MAX_VALUE;

        public b(byte[] bArr, int i2, int i3, boolean z) {
            super();
            this.e = bArr;
            this.g = i3 + i2;
            this.i = i2;
            this.j = i2;
            this.f = z;
        }

        public long A() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte w = w();
                j2 |= ((long) (w & Byte.MAX_VALUE)) << i2;
                if ((w & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j2;
                }
            }
            throw z.e();
        }

        public final void B() {
            int i2 = this.g + this.h;
            this.g = i2;
            int i3 = i2 - this.j;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.h = i5;
                this.g = i2 - i5;
                return;
            }
            this.h = 0;
        }

        public int b() {
            return this.i - this.j;
        }

        public boolean c() throws IOException {
            return this.i == this.g;
        }

        public boolean d() throws IOException {
            return z() != 0;
        }

        public boolean e(int i2) throws IOException {
            int t;
            int i3 = r1.a;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 == 0) {
                if (this.g - this.i >= 10) {
                    while (i5 < 10) {
                        byte[] bArr = this.e;
                        int i6 = this.i;
                        this.i = i6 + 1;
                        if (bArr[i6] < 0) {
                            i5++;
                        }
                    }
                    throw z.e();
                }
                while (i5 < 10) {
                    if (w() < 0) {
                        i5++;
                    }
                }
                throw z.e();
                return true;
            } else if (i4 == 1) {
                f(8);
                return true;
            } else if (i4 == 2) {
                f(m());
                return true;
            } else if (i4 == 3) {
                do {
                    t = t();
                    if (t == 0 || !e(t)) {
                        a(r1.a(i2 >>> 3, 4));
                    }
                    t = t();
                    break;
                } while (!e(t));
                a(r1.a(i2 >>> 3, 4));
                return true;
            } else if (i4 == 4) {
                return false;
            } else {
                if (i4 == 5) {
                    f(4);
                    return true;
                }
                throw z.d();
            }
        }

        public double f() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public int g() throws IOException {
            return m();
        }

        public int h() throws IOException {
            return x();
        }

        public long i() throws IOException {
            return y();
        }

        public float j() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public int k() throws IOException {
            return m();
        }

        public long l() throws IOException {
            return z();
        }

        public int n() throws IOException {
            return x();
        }

        public long o() throws IOException {
            return y();
        }

        public int p() throws IOException {
            return j.b(m());
        }

        public long q() throws IOException {
            return j.a(z());
        }

        public String r() throws IOException {
            int m = m();
            if (m > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (m <= i2 - i3) {
                    String str = new String(this.e, i3, m, y.a);
                    this.i += m;
                    return str;
                }
            }
            if (m == 0) {
                return "";
            }
            if (m < 0) {
                throw z.f();
            }
            throw z.i();
        }

        public String s() throws IOException {
            int m = m();
            if (m > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (m <= i2 - i3) {
                    String a = q1.a.a(this.e, i3, m);
                    this.i += m;
                    return a;
                }
            }
            if (m == 0) {
                return "";
            }
            if (m <= 0) {
                throw z.f();
            }
            throw z.i();
        }

        public int t() throws IOException {
            if (c()) {
                this.k = 0;
                return 0;
            }
            int m = m();
            this.k = m;
            int i2 = r1.a;
            if ((m >>> 3) != 0) {
                return m;
            }
            throw z.b();
        }

        public int u() throws IOException {
            return m();
        }

        public long v() throws IOException {
            return z();
        }

        public void a(int i2) throws z {
            if (this.k != i2) {
                throw z.a();
            }
        }

        public void c(int i2) {
            this.l = i2;
            B();
        }

        public int d(int i2) throws z {
            if (i2 >= 0) {
                int b = i2 + b();
                int i3 = this.l;
                if (b <= i3) {
                    this.l = b;
                    B();
                    return i3;
                }
                throw z.i();
            }
            throw z.f();
        }

        public void a(int i2, o0.a aVar, q qVar) throws IOException {
            int i3 = this.a;
            if (i3 < this.b) {
                this.a = i3 + 1;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(r1.a(i2, 4));
                this.a--;
                return;
            }
            throw z.h();
        }

        public byte w() throws IOException {
            int i2 = this.i;
            if (i2 != this.g) {
                byte[] bArr = this.e;
                this.i = i2 + 1;
                return bArr[i2];
            }
            throw z.i();
        }

        public void f(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.g;
                int i4 = this.i;
                if (i2 <= i3 - i4) {
                    this.i = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw z.f();
            }
            throw z.i();
        }

        public int m() throws IOException {
            byte b;
            byte b2;
            int i2 = this.i;
            int i3 = this.g;
            if (i3 != i2) {
                byte[] bArr = this.e;
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    this.i = i4;
                    return b3;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b4 = (bArr[i4] << 7) ^ b3;
                    if (b4 < 0) {
                        b = b4 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b5 = (bArr[i5] << Ascii.SO) ^ b4;
                        if (b5 >= 0) {
                            b2 = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            int i7 = i2 + 4;
                            byte b6 = b5 ^ (bArr[i6] << Ascii.NAK);
                            if (b6 < 0) {
                                b = -2080896 ^ b6;
                            } else {
                                i6 = i2 + 5;
                                byte b7 = bArr[i7];
                                byte b8 = (b6 ^ (b7 << Ascii.FS)) ^ ByteCompanionObject.MIN_VALUE;
                                if (b7 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b9 = b8;
                                                        i5 = i8;
                                                        b = b9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b = b8;
                                }
                                b2 = b8;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.i = i5;
                    return b;
                }
            }
            return (int) A();
        }

        public int x() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 4) {
                byte[] bArr = this.e;
                this.i = i2 + 4;
                return ((bArr[i2 + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i2] & UByte.MAX_VALUE) | ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UByte.MAX_VALUE) << Ascii.DLE);
            }
            throw z.i();
        }

        public long y() throws IOException {
            int i2 = this.i;
            if (this.g - i2 >= 8) {
                byte[] bArr = this.e;
                this.i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw z.i();
        }

        public long z() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2 = this.i;
            int i3 = this.g;
            if (i3 != i2) {
                byte[] bArr = this.e;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.i = i4;
                    return (long) b;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b2 = (bArr[i4] << 7) ^ b;
                    if (b2 < 0) {
                        j2 = (long) (b2 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b3 = (bArr[i5] << Ascii.SO) ^ b2;
                        if (b3 >= 0) {
                            j2 = (long) (b3 ^ ByteCompanionObject.MIN_VALUE);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b4 = b3 ^ (bArr[i6] << Ascii.NAK);
                            if (b4 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b4);
                            } else {
                                long j5 = (long) b4;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.i = i5;
                    return j2;
                }
            }
            return A();
        }

        public void a(o0.a aVar, q qVar) throws IOException {
            int m = m();
            if (this.a < this.b) {
                int d = d(m);
                this.a++;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(0);
                this.a--;
                this.l = d;
                B();
                return;
            }
            throw z.h();
        }

        public int a() {
            int i2 = this.l;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - b();
        }

        public i e() throws IOException {
            byte[] bArr;
            int m = m();
            if (m > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (m <= i2 - i3) {
                    i a = i.a(this.e, i3, m);
                    this.i += m;
                    return a;
                }
            }
            if (m == 0) {
                return i.b;
            }
            if (m > 0) {
                int i4 = this.g;
                int i5 = this.i;
                if (m <= i4 - i5) {
                    int i6 = m + i5;
                    this.i = i6;
                    bArr = Arrays.copyOfRange(this.e, i5, i6);
                    i iVar = i.b;
                    return new i.h(bArr);
                }
            }
            if (m > 0) {
                throw z.i();
            } else if (m == 0) {
                bArr = y.b;
                i iVar2 = i.b;
                return new i.h(bArr);
            } else {
                throw z.f();
            }
        }
    }

    public static final class c extends j {
        public final InputStream e;
        public final byte[] f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l = Integer.MAX_VALUE;

        public c(InputStream inputStream, int i2) {
            super();
            y.a(inputStream, "input");
            this.e = inputStream;
            this.f = new byte[i2];
            this.g = 0;
            this.i = 0;
            this.k = 0;
        }

        public long A() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte w = w();
                j2 |= ((long) (w & Byte.MAX_VALUE)) << i2;
                if ((w & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j2;
                }
            }
            throw z.e();
        }

        public final void B() {
            int i2 = this.g + this.h;
            this.g = i2;
            int i3 = this.k + i2;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.h = i5;
                this.g = i2 - i5;
                return;
            }
            this.h = 0;
        }

        public int a() {
            int i2 = this.l;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - (this.k + this.i);
        }

        public int b() {
            return this.k + this.i;
        }

        public boolean d() throws IOException {
            return z() != 0;
        }

        public boolean e(int i2) throws IOException {
            int t;
            int i3 = r1.a;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 == 0) {
                if (this.g - this.i >= 10) {
                    while (i5 < 10) {
                        byte[] bArr = this.f;
                        int i6 = this.i;
                        this.i = i6 + 1;
                        if (bArr[i6] < 0) {
                            i5++;
                        }
                    }
                    throw z.e();
                }
                while (i5 < 10) {
                    if (w() < 0) {
                        i5++;
                    }
                }
                throw z.e();
                return true;
            } else if (i4 == 1) {
                i(8);
                return true;
            } else if (i4 == 2) {
                i(m());
                return true;
            } else if (i4 == 3) {
                do {
                    t = t();
                    if (t == 0 || !e(t)) {
                        a(r1.a(i2 >>> 3, 4));
                    }
                    t = t();
                    break;
                } while (!e(t));
                a(r1.a(i2 >>> 3, 4));
                return true;
            } else if (i4 == 4) {
                return false;
            } else {
                if (i4 == 5) {
                    i(4);
                    return true;
                }
                throw z.d();
            }
        }

        public double f() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public int g() throws IOException {
            return m();
        }

        public int h() throws IOException {
            return x();
        }

        public long i() throws IOException {
            return y();
        }

        public float j() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public int k() throws IOException {
            return m();
        }

        public long l() throws IOException {
            return z();
        }

        public int n() throws IOException {
            return x();
        }

        public long o() throws IOException {
            return y();
        }

        public int p() throws IOException {
            return j.b(m());
        }

        public long q() throws IOException {
            return j.a(z());
        }

        public String r() throws IOException {
            int m = m();
            if (m > 0) {
                int i2 = this.g;
                int i3 = this.i;
                if (m <= i2 - i3) {
                    String str = new String(this.f, i3, m, y.a);
                    this.i += m;
                    return str;
                }
            }
            if (m == 0) {
                return "";
            }
            if (m > this.g) {
                return new String(a(m, false), y.a);
            }
            h(m);
            String str2 = new String(this.f, this.i, m, y.a);
            this.i += m;
            return str2;
        }

        public String s() throws IOException {
            byte[] bArr;
            int m = m();
            int i2 = this.i;
            int i3 = this.g;
            if (m <= i3 - i2 && m > 0) {
                bArr = this.f;
                this.i = i2 + m;
            } else if (m == 0) {
                return "";
            } else {
                i2 = 0;
                if (m <= i3) {
                    h(m);
                    bArr = this.f;
                    this.i = m;
                } else {
                    bArr = a(m, false);
                }
            }
            return q1.a.a(bArr, i2, m);
        }

        public int t() throws IOException {
            if (c()) {
                this.j = 0;
                return 0;
            }
            int m = m();
            this.j = m;
            int i2 = r1.a;
            if ((m >>> 3) != 0) {
                return m;
            }
            throw z.b();
        }

        public int u() throws IOException {
            return m();
        }

        public long v() throws IOException {
            return z();
        }

        public void a(int i2) throws z {
            if (this.j != i2) {
                throw z.a();
            }
        }

        public void c(int i2) {
            this.l = i2;
            B();
        }

        public final byte[] f(int i2) throws IOException {
            if (i2 == 0) {
                return y.b;
            }
            if (i2 >= 0) {
                int i3 = this.k;
                int i4 = this.i;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.l;
                    if (i5 <= i6) {
                        int i7 = this.g - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f, this.i, bArr, 0, i7);
                        this.k += this.g;
                        this.i = 0;
                        this.g = 0;
                        while (i7 < i2) {
                            int read = this.e.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.k += read;
                                i7 += read;
                            } else {
                                throw z.i();
                            }
                        }
                        return bArr;
                    }
                    i((i6 - i3) - i4);
                    throw z.i();
                }
                throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw z.f();
        }

        public final List<byte[]> g(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.e.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.k += read;
                        i3 += read;
                    } else {
                        throw z.i();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final void h(int i2) throws IOException {
            if (j(i2)) {
                return;
            }
            if (i2 > (this.c - this.k) - this.i) {
                throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw z.i();
        }

        public byte w() throws IOException {
            if (this.i == this.g) {
                h(1);
            }
            byte[] bArr = this.f;
            int i2 = this.i;
            this.i = i2 + 1;
            return bArr[i2];
        }

        public void a(int i2, o0.a aVar, q qVar) throws IOException {
            int i3 = this.a;
            if (i3 < this.b) {
                this.a = i3 + 1;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(r1.a(i2, 4));
                this.a--;
                return;
            }
            throw z.h();
        }

        public boolean c() throws IOException {
            return this.i == this.g && !j(1);
        }

        public int x() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 4) {
                h(4);
                i2 = this.i;
            }
            byte[] bArr = this.f;
            this.i = i2 + 4;
            return ((bArr[i2 + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i2] & UByte.MAX_VALUE) | ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UByte.MAX_VALUE) << Ascii.DLE);
        }

        public long y() throws IOException {
            int i2 = this.i;
            if (this.g - i2 < 8) {
                h(8);
                i2 = this.i;
            }
            byte[] bArr = this.f;
            this.i = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        public int d(int i2) throws z {
            if (i2 >= 0) {
                int i3 = i2 + this.k + this.i;
                int i4 = this.l;
                if (i3 <= i4) {
                    this.l = i3;
                    B();
                    return i4;
                }
                throw z.i();
            }
            throw z.f();
        }

        public int m() throws IOException {
            byte b;
            byte b2;
            int i2 = this.i;
            int i3 = this.g;
            if (i3 != i2) {
                byte[] bArr = this.f;
                int i4 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 >= 0) {
                    this.i = i4;
                    return b3;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b4 = (bArr[i4] << 7) ^ b3;
                    if (b4 < 0) {
                        b = b4 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        int i6 = i2 + 3;
                        byte b5 = (bArr[i5] << Ascii.SO) ^ b4;
                        if (b5 >= 0) {
                            b2 = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            int i7 = i2 + 4;
                            byte b6 = b5 ^ (bArr[i6] << Ascii.NAK);
                            if (b6 < 0) {
                                b = -2080896 ^ b6;
                            } else {
                                i6 = i2 + 5;
                                byte b7 = bArr[i7];
                                byte b8 = (b6 ^ (b7 << Ascii.FS)) ^ ByteCompanionObject.MIN_VALUE;
                                if (b7 < 0) {
                                    i7 = i2 + 6;
                                    if (bArr[i6] < 0) {
                                        i6 = i2 + 7;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 8;
                                            if (bArr[i6] < 0) {
                                                i6 = i2 + 9;
                                                if (bArr[i7] < 0) {
                                                    int i8 = i2 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        byte b9 = b8;
                                                        i5 = i8;
                                                        b = b9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b = b8;
                                }
                                b2 = b8;
                            }
                            i5 = i7;
                        }
                        i5 = i6;
                    }
                    this.i = i5;
                    return b;
                }
            }
            return (int) A();
        }

        public final boolean j(int i2) throws IOException {
            int i3 = this.i;
            int i4 = i3 + i2;
            int i5 = this.g;
            if (i4 > i5) {
                int i6 = this.c;
                int i7 = this.k;
                if (i2 > (i6 - i7) - i3 || i7 + i3 + i2 > this.l) {
                    return false;
                }
                if (i3 > 0) {
                    if (i5 > i3) {
                        byte[] bArr = this.f;
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.k += i3;
                    this.g -= i3;
                    this.i = 0;
                }
                InputStream inputStream = this.e;
                byte[] bArr2 = this.f;
                int i8 = this.g;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.c - this.k) - i8));
                if (read == 0 || read < -1 || read > this.f.length) {
                    throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.g += read;
                    B();
                    if (this.g >= i2) {
                        return true;
                    }
                    return j(i2);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
            }
        }

        public long z() throws IOException {
            long j2;
            long j3;
            long j4;
            int i2 = this.i;
            int i3 = this.g;
            if (i3 != i2) {
                byte[] bArr = this.f;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.i = i4;
                    return (long) b;
                } else if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    byte b2 = (bArr[i4] << 7) ^ b;
                    if (b2 < 0) {
                        j2 = (long) (b2 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        int i6 = i2 + 3;
                        byte b3 = (bArr[i5] << Ascii.SO) ^ b2;
                        if (b3 >= 0) {
                            j2 = (long) (b3 ^ ByteCompanionObject.MIN_VALUE);
                            i5 = i6;
                        } else {
                            int i7 = i2 + 4;
                            byte b4 = b3 ^ (bArr[i6] << Ascii.NAK);
                            if (b4 < 0) {
                                i5 = i7;
                                j2 = (long) (-2080896 ^ b4);
                            } else {
                                long j5 = (long) b4;
                                int i8 = i2 + 5;
                                long j6 = j5 ^ (((long) bArr[i7]) << 28);
                                if (j6 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    int i9 = i2 + 6;
                                    long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                    if (j7 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i8 = i2 + 7;
                                        j6 = j7 ^ (((long) bArr[i9]) << 42);
                                        if (j6 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j7 = j6 ^ (((long) bArr[i8]) << 49);
                                            if (j7 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i10 = i2 + 10;
                                                    if (((long) bArr[i5]) >= 0) {
                                                        i5 = i10;
                                                    }
                                                }
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    j2 = j7 ^ j3;
                                    i5 = i9;
                                }
                                j2 = j6 ^ j4;
                            }
                        }
                    }
                    this.i = i5;
                    return j2;
                }
            }
            return A();
        }

        public void a(o0.a aVar, q qVar) throws IOException {
            int m = m();
            if (this.a < this.b) {
                int d = d(m);
                this.a++;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(0);
                this.a--;
                this.l = d;
                B();
                return;
            }
            throw z.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
            throw new java.lang.IllegalStateException(r8.e.getClass() + "#skip returned invalid result: " + r1 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i(int r9) throws java.io.IOException {
            /*
                r8 = this;
                int r0 = r8.g
                int r1 = r8.i
                int r0 = r0 - r1
                if (r9 > r0) goto L_0x000e
                if (r9 < 0) goto L_0x000e
                int r1 = r1 + r9
                r8.i = r1
                goto L_0x0090
            L_0x000e:
                if (r9 < 0) goto L_0x009b
                int r2 = r8.k
                int r3 = r2 + r1
                int r4 = r3 + r9
                int r5 = r8.l
                if (r4 > r5) goto L_0x0091
                r8.k = r3
                r1 = 0
                r8.g = r1
                r8.i = r1
            L_0x0021:
                if (r0 >= r9) goto L_0x006b
                int r1 = r9 - r0
                java.io.InputStream r2 = r8.e     // Catch:{ all -> 0x0061 }
                long r3 = (long) r1     // Catch:{ all -> 0x0061 }
                long r1 = r2.skip(r3)     // Catch:{ all -> 0x0061 }
                r5 = 0
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x003c
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 > 0) goto L_0x003c
                if (r7 != 0) goto L_0x0039
                goto L_0x006b
            L_0x0039:
                int r2 = (int) r1     // Catch:{ all -> 0x0061 }
                int r0 = r0 + r2
                goto L_0x0021
            L_0x003c:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                java.io.InputStream r4 = r8.e     // Catch:{ all -> 0x0061 }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x0061 }
                r3.append(r4)     // Catch:{ all -> 0x0061 }
                java.lang.String r4 = "#skip returned invalid result: "
                r3.append(r4)     // Catch:{ all -> 0x0061 }
                r3.append(r1)     // Catch:{ all -> 0x0061 }
                java.lang.String r1 = "\nThe InputStream implementation is buggy."
                r3.append(r1)     // Catch:{ all -> 0x0061 }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0061 }
                r9.<init>(r1)     // Catch:{ all -> 0x0061 }
                throw r9     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r9 = move-exception
                int r1 = r8.k
                int r1 = r1 + r0
                r8.k = r1
                r8.B()
                throw r9
            L_0x006b:
                int r1 = r8.k
                int r1 = r1 + r0
                r8.k = r1
                r8.B()
                if (r0 >= r9) goto L_0x0090
                int r0 = r8.g
                int r1 = r8.i
                int r1 = r0 - r1
                r8.i = r0
                r0 = 1
                r8.h(r0)
            L_0x0081:
                int r2 = r9 - r1
                int r3 = r8.g
                if (r2 <= r3) goto L_0x008e
                int r1 = r1 + r3
                r8.i = r3
                r8.h(r0)
                goto L_0x0081
            L_0x008e:
                r8.i = r2
            L_0x0090:
                return
            L_0x0091:
                int r5 = r5 - r2
                int r5 = r5 - r1
                r8.i(r5)
                com.fyber.inneractive.sdk.protobuf.z r9 = com.fyber.inneractive.sdk.protobuf.z.i()
                throw r9
            L_0x009b:
                com.fyber.inneractive.sdk.protobuf.z r9 = com.fyber.inneractive.sdk.protobuf.z.f()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.j.c.i(int):void");
        }

        public final byte[] a(int i2, boolean z) throws IOException {
            byte[] f2 = f(i2);
            if (f2 != null) {
                return z ? (byte[]) f2.clone() : f2;
            }
            int i3 = this.i;
            int i4 = this.g;
            int i5 = i4 - i3;
            this.k += i4;
            this.i = 0;
            this.g = 0;
            List<byte[]> g2 = g(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f, i3, bArr, 0, i5);
            Iterator it = ((ArrayList) g2).iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public i e() throws IOException {
            int m = m();
            int i2 = this.g;
            int i3 = this.i;
            if (m <= i2 - i3 && m > 0) {
                i a = i.a(this.f, i3, m);
                this.i += m;
                return a;
            } else if (m == 0) {
                return i.b;
            } else {
                byte[] f2 = f(m);
                if (f2 != null) {
                    i iVar = i.b;
                    return i.a(f2, 0, f2.length);
                }
                int i4 = this.i;
                int i5 = this.g;
                int i6 = i5 - i4;
                this.k += i5;
                this.i = 0;
                this.g = 0;
                List<byte[]> g2 = g(m - i6);
                byte[] bArr = new byte[m];
                System.arraycopy(this.f, i4, bArr, 0, i6);
                Iterator it = ((ArrayList) g2).iterator();
                while (it.hasNext()) {
                    byte[] bArr2 = (byte[]) it.next();
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                i iVar2 = i.b;
                return new i.h(bArr);
            }
        }
    }

    public static final class d extends j {
        public final ByteBuffer e;
        public final boolean f;
        public final long g;
        public long h;
        public long i;
        public long j;
        public int k;
        public int l;
        public int m = Integer.MAX_VALUE;

        public d(ByteBuffer byteBuffer, boolean z) {
            super();
            this.e = byteBuffer;
            long a = p1.a(byteBuffer);
            this.g = a;
            this.h = ((long) byteBuffer.limit()) + a;
            long position = a + ((long) byteBuffer.position());
            this.i = position;
            this.j = position;
            this.f = z;
        }

        public long A() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte w = w();
                j2 |= ((long) (w & Byte.MAX_VALUE)) << i2;
                if ((w & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j2;
                }
            }
            throw z.e();
        }

        public final void B() {
            long j2 = this.h + ((long) this.k);
            this.h = j2;
            int i2 = (int) (j2 - this.j);
            int i3 = this.m;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.k = i4;
                this.h = j2 - ((long) i4);
                return;
            }
            this.k = 0;
        }

        public final int C() {
            return (int) (this.h - this.i);
        }

        public int b() {
            return (int) (this.i - this.j);
        }

        public final int b(long j2) {
            return (int) (j2 - this.g);
        }

        public boolean c() throws IOException {
            return this.i == this.h;
        }

        public boolean d() throws IOException {
            return z() != 0;
        }

        public boolean e(int i2) throws IOException {
            int t;
            int i3 = r1.a;
            int i4 = i2 & 7;
            int i5 = 0;
            if (i4 == 0) {
                if (C() >= 10) {
                    while (i5 < 10) {
                        long j2 = this.i;
                        this.i = 1 + j2;
                        if (p1.e.a(j2) < 0) {
                            i5++;
                        }
                    }
                    throw z.e();
                }
                while (i5 < 10) {
                    if (w() < 0) {
                        i5++;
                    }
                }
                throw z.e();
                return true;
            } else if (i4 == 1) {
                f(8);
                return true;
            } else if (i4 == 2) {
                f(m());
                return true;
            } else if (i4 == 3) {
                do {
                    t = t();
                    if (t == 0 || !e(t)) {
                        a(r1.a(i2 >>> 3, 4));
                    }
                    t = t();
                    break;
                } while (!e(t));
                a(r1.a(i2 >>> 3, 4));
                return true;
            } else if (i4 == 4) {
                return false;
            } else {
                if (i4 == 5) {
                    f(4);
                    return true;
                }
                throw z.d();
            }
        }

        public double f() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public int g() throws IOException {
            return m();
        }

        public int h() throws IOException {
            return x();
        }

        public long i() throws IOException {
            return y();
        }

        public float j() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public int k() throws IOException {
            return m();
        }

        public long l() throws IOException {
            return z();
        }

        public int n() throws IOException {
            return x();
        }

        public long o() throws IOException {
            return y();
        }

        public int p() throws IOException {
            return j.b(m());
        }

        public long q() throws IOException {
            return j.a(z());
        }

        public String r() throws IOException {
            int m2 = m();
            if (m2 > 0 && m2 <= C()) {
                byte[] bArr = new byte[m2];
                long j2 = (long) m2;
                p1.e.a(this.i, bArr, 0, j2);
                String str = new String(bArr, y.a);
                this.i += j2;
                return str;
            } else if (m2 == 0) {
                return "";
            } else {
                if (m2 < 0) {
                    throw z.f();
                }
                throw z.i();
            }
        }

        public String s() throws IOException {
            String str;
            int m2 = m();
            if (m2 > 0 && m2 <= C()) {
                int b = b(this.i);
                ByteBuffer byteBuffer = this.e;
                q1.b bVar = q1.a;
                bVar.getClass();
                if (byteBuffer.hasArray()) {
                    str = bVar.a(byteBuffer.array(), byteBuffer.arrayOffset() + b, m2);
                } else if (byteBuffer.isDirect()) {
                    str = bVar.b(byteBuffer, b, m2);
                } else {
                    str = bVar.a(byteBuffer, b, m2);
                }
                this.i += (long) m2;
                return str;
            } else if (m2 == 0) {
                return "";
            } else {
                if (m2 <= 0) {
                    throw z.f();
                }
                throw z.i();
            }
        }

        public int t() throws IOException {
            if (c()) {
                this.l = 0;
                return 0;
            }
            int m2 = m();
            this.l = m2;
            int i2 = r1.a;
            if ((m2 >>> 3) != 0) {
                return m2;
            }
            throw z.b();
        }

        public int u() throws IOException {
            return m();
        }

        public long v() throws IOException {
            return z();
        }

        public void a(int i2) throws z {
            if (this.l != i2) {
                throw z.a();
            }
        }

        public void c(int i2) {
            this.m = i2;
            B();
        }

        public int d(int i2) throws z {
            if (i2 >= 0) {
                int b = i2 + b();
                int i3 = this.m;
                if (b <= i3) {
                    this.m = b;
                    B();
                    return i3;
                }
                throw z.i();
            }
            throw z.f();
        }

        public void f(int i2) throws IOException {
            if (i2 >= 0 && i2 <= C()) {
                this.i += (long) i2;
            } else if (i2 < 0) {
                throw z.f();
            } else {
                throw z.i();
            }
        }

        public void a(int i2, o0.a aVar, q qVar) throws IOException {
            int i3 = this.a;
            if (i3 < this.b) {
                this.a = i3 + 1;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(r1.a(i2, 4));
                this.a--;
                return;
            }
            throw z.h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
            if (r4.a(r8) < 0) goto L_0x0093;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int m() throws java.io.IOException {
            /*
                r12 = this;
                long r0 = r12.i
                long r2 = r12.h
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto L_0x000a
                goto L_0x0093
            L_0x000a:
                r2 = 1
                long r2 = r2 + r0
                com.fyber.inneractive.sdk.protobuf.p1$d r4 = com.fyber.inneractive.sdk.protobuf.p1.e
                byte r5 = r4.a(r0)
                if (r5 < 0) goto L_0x0018
                r12.i = r2
                return r5
            L_0x0018:
                long r6 = r12.h
                long r6 = r6 - r2
                r8 = 9
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 >= 0) goto L_0x0023
                goto L_0x0093
            L_0x0023:
                r6 = 2
                long r6 = r6 + r0
                byte r2 = r4.a(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r5
                if (r2 >= 0) goto L_0x0033
                r0 = r2 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x00a0
            L_0x0033:
                r10 = 3
                long r10 = r10 + r0
                byte r3 = r4.a(r6)
                int r3 = r3 << 14
                r2 = r2 ^ r3
                if (r2 < 0) goto L_0x0043
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L_0x0041:
                r6 = r10
                goto L_0x00a0
            L_0x0043:
                r5 = 4
                long r6 = r0 + r5
                byte r3 = r4.a(r10)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L_0x0055
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x00a0
            L_0x0055:
                r10 = 5
                long r10 = r10 + r0
                byte r3 = r4.a(r6)
                int r5 = r3 << 28
                r2 = r2 ^ r5
                r5 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r5
                if (r3 >= 0) goto L_0x009e
                r5 = 6
                long r6 = r0 + r5
                byte r3 = r4.a(r10)
                if (r3 >= 0) goto L_0x009c
                r10 = 7
                long r10 = r10 + r0
                byte r3 = r4.a(r6)
                if (r3 >= 0) goto L_0x009e
                r5 = 8
                long r6 = r0 + r5
                byte r3 = r4.a(r10)
                if (r3 >= 0) goto L_0x009c
                long r8 = r8 + r0
                byte r3 = r4.a(r6)
                if (r3 >= 0) goto L_0x0099
                r5 = 10
                long r6 = r0 + r5
                byte r0 = r4.a(r8)
                if (r0 >= 0) goto L_0x009c
            L_0x0093:
                long r0 = r12.A()
                int r1 = (int) r0
                return r1
            L_0x0099:
                r0 = r2
                r6 = r8
                goto L_0x00a0
            L_0x009c:
                r0 = r2
                goto L_0x00a0
            L_0x009e:
                r0 = r2
                goto L_0x0041
            L_0x00a0:
                r12.i = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.j.d.m():int");
        }

        public long z() throws IOException {
            long j2;
            long j3;
            long j4;
            byte b;
            long j5 = this.i;
            if (this.h != j5) {
                long j6 = 1 + j5;
                p1.d dVar = p1.e;
                byte a = dVar.a(j5);
                if (a >= 0) {
                    this.i = j6;
                    return (long) a;
                } else if (this.h - j6 >= 9) {
                    long j7 = 2 + j5;
                    byte a2 = (dVar.a(j6) << 7) ^ a;
                    if (a2 < 0) {
                        b = a2 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        long j8 = 3 + j5;
                        byte a3 = a2 ^ (dVar.a(j7) << Ascii.SO);
                        if (a3 >= 0) {
                            j2 = (long) (a3 ^ ByteCompanionObject.MIN_VALUE);
                        } else {
                            j7 = j5 + 4;
                            byte a4 = a3 ^ (dVar.a(j8) << Ascii.NAK);
                            if (a4 < 0) {
                                b = -2080896 ^ a4;
                            } else {
                                j8 = 5 + j5;
                                long a5 = ((long) a4) ^ (((long) dVar.a(j7)) << 28);
                                if (a5 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = 6 + j5;
                                    long a6 = a5 ^ (((long) dVar.a(j8)) << 35);
                                    if (a6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j8 = 7 + j5;
                                        a5 = a6 ^ (((long) dVar.a(j9)) << 42);
                                        if (a5 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = 8 + j5;
                                            a6 = a5 ^ (((long) dVar.a(j8)) << 49);
                                            if (a6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                long j10 = j5 + 9;
                                                long a7 = (a6 ^ (((long) dVar.a(j9)) << 56)) ^ 71499008037633920L;
                                                if (a7 < 0) {
                                                    long j11 = j5 + 10;
                                                    if (((long) dVar.a(j10)) >= 0) {
                                                        j7 = j11;
                                                        j2 = a7;
                                                    }
                                                } else {
                                                    j2 = a7;
                                                    j7 = j10;
                                                }
                                                this.i = j7;
                                                return j2;
                                            }
                                        }
                                    }
                                    j2 = j3 ^ a6;
                                    j7 = j9;
                                    this.i = j7;
                                    return j2;
                                }
                                j2 = j4 ^ a5;
                            }
                        }
                        j7 = j8;
                        this.i = j7;
                        return j2;
                    }
                    j2 = (long) b;
                    this.i = j7;
                    return j2;
                }
            }
            return A();
        }

        public byte w() throws IOException {
            long j2 = this.i;
            if (j2 != this.h) {
                this.i = 1 + j2;
                return p1.e.a(j2);
            }
            throw z.i();
        }

        public int x() throws IOException {
            long j2 = this.i;
            if (this.h - j2 >= 4) {
                this.i = 4 + j2;
                p1.d dVar = p1.e;
                return ((dVar.a(j2 + 3) & UByte.MAX_VALUE) << Ascii.CAN) | (dVar.a(j2) & UByte.MAX_VALUE) | ((dVar.a(1 + j2) & UByte.MAX_VALUE) << 8) | ((dVar.a(2 + j2) & UByte.MAX_VALUE) << Ascii.DLE);
            }
            throw z.i();
        }

        public long y() throws IOException {
            long j2 = this.i;
            if (this.h - j2 >= 8) {
                this.i = 8 + j2;
                p1.d dVar = p1.e;
                return ((((long) dVar.a(j2 + 7)) & 255) << 56) | (((long) dVar.a(j2)) & 255) | ((((long) dVar.a(1 + j2)) & 255) << 8) | ((((long) dVar.a(2 + j2)) & 255) << 16) | ((((long) dVar.a(3 + j2)) & 255) << 24) | ((((long) dVar.a(4 + j2)) & 255) << 32) | ((((long) dVar.a(5 + j2)) & 255) << 40) | ((((long) dVar.a(6 + j2)) & 255) << 48);
            }
            throw z.i();
        }

        public void a(o0.a aVar, q qVar) throws IOException {
            int m2 = m();
            if (this.a < this.b) {
                int d = d(m2);
                this.a++;
                ((GeneratedMessageLite.b) aVar).a((j) this, qVar);
                a(0);
                this.a--;
                this.m = d;
                B();
                return;
            }
            throw z.h();
        }

        public int a() {
            int i2 = this.m;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - b();
        }

        public i e() throws IOException {
            int m2 = m();
            if (m2 > 0 && m2 <= C()) {
                byte[] bArr = new byte[m2];
                long j2 = (long) m2;
                p1.e.a(this.i, bArr, 0, j2);
                this.i += j2;
                i iVar = i.b;
                return new i.h(bArr);
            } else if (m2 == 0) {
                return i.b;
            } else {
                if (m2 < 0) {
                    throw z.f();
                }
                throw z.i();
            }
        }
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static j a(InputStream inputStream) {
        if (inputStream != null) {
            return new c(inputStream, 4096);
        }
        byte[] bArr = y.b;
        return a(bArr, 0, bArr.length, false);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int a();

    public abstract void a(int i) throws z;

    public abstract void a(int i, o0.a aVar, q qVar) throws IOException;

    public abstract void a(o0.a aVar, q qVar) throws IOException;

    public abstract int b();

    public abstract void c(int i);

    public abstract boolean c() throws IOException;

    public abstract int d(int i) throws z;

    public abstract boolean d() throws IOException;

    public abstract i e() throws IOException;

    public abstract boolean e(int i) throws IOException;

    public abstract double f() throws IOException;

    public abstract int g() throws IOException;

    public abstract int h() throws IOException;

    public abstract long i() throws IOException;

    public abstract float j() throws IOException;

    public abstract int k() throws IOException;

    public abstract long l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract long o() throws IOException;

    public abstract int p() throws IOException;

    public abstract long q() throws IOException;

    public abstract String r() throws IOException;

    public abstract String s() throws IOException;

    public abstract int t() throws IOException;

    public abstract int u() throws IOException;

    public abstract long v() throws IOException;

    public j() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
    }

    public static j a(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z);
        try {
            bVar.d(i2);
            return bVar;
        } catch (z e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static j a(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && p1.f) {
            return new d(byteBuffer, z);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return a(bArr, 0, remaining, true);
    }
}
