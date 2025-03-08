package com.fyber.inneractive.sdk.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.protobuf.y;
import java.io.IOException;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public final class e {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fyber.inneractive.sdk.protobuf.r1$b[] r0 = com.fyber.inneractive.sdk.protobuf.r1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.fyber.inneractive.sdk.protobuf.r1$b r1 = com.fyber.inneractive.sdk.protobuf.r1.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.e.a.<clinit>():void");
        }
    }

    public static final class b {
        public int a;
        public long b;
        public Object c;
        public final q d;

        public b(q qVar) {
            qVar.getClass();
            this.d = qVar;
        }
    }

    public static int a(int i, byte[] bArr, int i2, b bVar) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            bVar.a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            bVar.a = i5 | (b3 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            bVar.a = i7 | (b4 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            bVar.a = i9 | (b5 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                bVar.a = i11;
                return i12;
            }
        }
    }

    public static long b(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int c(byte[] bArr, int i, b bVar) throws z {
        int d = d(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw z.f();
        } else if (i2 == 0) {
            bVar.c = "";
            return d;
        } else {
            bVar.c = q1.a.a(bArr, d, i2);
            return d + i2;
        }
    }

    public static int d(byte[] bArr, int i, b bVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return a((int) b2, bArr, i2, bVar);
        }
        bVar.a = b2;
        return i2;
    }

    public static int e(byte[] bArr, int i, b bVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            bVar.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b2 = b3;
            i3 = i6;
        }
        bVar.b = j2;
        return i3;
    }

    public static int f(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            d = d(bArr, d, bVar);
            xVar.c(j.b(bVar.a));
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int g(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            d = e(bArr, d, bVar);
            f0Var.a(j.a(bVar.b));
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int h(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            d = d(bArr, d, bVar);
            xVar.c(bVar.a);
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int i(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            d = e(bArr, d, bVar);
            f0Var.a(bVar.b);
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int b(byte[] bArr, int i, b bVar) throws z {
        int d = d(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw z.f();
        } else if (i2 == 0) {
            bVar.c = "";
            return d;
        } else {
            bVar.c = new String(bArr, d, i2, y.a);
            return d + i2;
        }
    }

    public static int d(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        f0 f0Var = (f0) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            f0Var.a(b(bArr, d));
            d += 8;
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int c(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        x xVar = (x) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            xVar.c(a(bArr, d));
            d += 4;
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int b(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        n nVar = (n) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            nVar.a(Double.longBitsToDouble(b(bArr, d)));
            d += 8;
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int e(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        v vVar = (v) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            vVar.a(Float.intBitsToFloat(a(bArr, d)));
            d += 4;
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Ascii.DLE);
    }

    public static int a(byte[] bArr, int i, b bVar) throws z {
        int d = d(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw z.f();
        } else if (i2 > bArr.length - d) {
            throw z.i();
        } else if (i2 == 0) {
            bVar.c = i.b;
            return d;
        } else {
            bVar.c = i.a(bArr, d, i2);
            return d + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.fyber.inneractive.sdk.protobuf.d1 r6, byte[] r7, int r8, int r9, com.fyber.inneractive.sdk.protobuf.e.b r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = a((int) r8, (byte[]) r7, (int) r0, (com.fyber.inneractive.sdk.protobuf.e.b) r10)
            int r8 = r10.a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.a()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.a(r1, r2, r3, r4, r5)
            r6.c(r9)
            r10.c = r9
            return r8
        L_0x0025:
            com.fyber.inneractive.sdk.protobuf.z r6 = com.fyber.inneractive.sdk.protobuf.z.i()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.e.a(com.fyber.inneractive.sdk.protobuf.d1, byte[], int, int, com.fyber.inneractive.sdk.protobuf.e$b):int");
    }

    public static int a(d1 d1Var, byte[] bArr, int i, int i2, int i3, b bVar) throws IOException {
        r0 r0Var = (r0) d1Var;
        Object a2 = r0Var.a();
        int a3 = r0Var.a(a2, bArr, i, i2, i3, bVar);
        r0Var.c(a2);
        bVar.c = a2;
        return a3;
    }

    public static int a(int i, byte[] bArr, int i2, int i3, y.j<?> jVar, b bVar) {
        x xVar = (x) jVar;
        int d = d(bArr, i2, bVar);
        xVar.c(bVar.a);
        while (d < i3) {
            int d2 = d(bArr, d, bVar);
            if (i != bVar.a) {
                break;
            }
            d = d(bArr, d2, bVar);
            xVar.c(bVar.a);
        }
        return d;
    }

    public static int a(byte[] bArr, int i, y.j<?> jVar, b bVar) throws IOException {
        g gVar = (g) jVar;
        int d = d(bArr, i, bVar);
        int i2 = bVar.a + d;
        while (d < i2) {
            d = e(bArr, d, bVar);
            gVar.a(bVar.b != 0);
        }
        if (d == i2) {
            return d;
        }
        throw z.i();
    }

    public static int a(d1<?> d1Var, int i, byte[] bArr, int i2, int i3, y.j<?> jVar, b bVar) throws IOException {
        int a2 = a((d1) d1Var, bArr, i2, i3, bVar);
        jVar.add(bVar.c);
        while (a2 < i3) {
            int d = d(bArr, a2, bVar);
            if (i != bVar.a) {
                break;
            }
            a2 = a((d1) d1Var, bArr, d, i3, bVar);
            jVar.add(bVar.c);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01e7, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01f6, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r7, byte[] r8, int r9, int r10, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite.e<?, ?> r12, com.fyber.inneractive.sdk.protobuf.k1<com.fyber.inneractive.sdk.protobuf.l1, com.fyber.inneractive.sdk.protobuf.l1> r13, com.fyber.inneractive.sdk.protobuf.e.b r14) throws java.io.IOException {
        /*
            com.fyber.inneractive.sdk.protobuf.u<com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d> r0 = r11.extensions
            int r7 = r7 >>> 3
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r1 = r12.d
            boolean r2 = r1.d
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x00f5
            boolean r2 = r1.e
            if (r2 == 0) goto L_0x00f5
            int[] r10 = com.fyber.inneractive.sdk.protobuf.e.a.a
            com.fyber.inneractive.sdk.protobuf.r1$b r1 = r1.c
            int r1 = r1.ordinal()
            r10 = r10[r1]
            r1 = 10
            switch(r10) {
                case 1: goto L_0x00d6;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00b4;
                case 5: goto L_0x00a4;
                case 6: goto L_0x00a4;
                case 7: goto L_0x0094;
                case 8: goto L_0x0094;
                case 9: goto L_0x0084;
                case 10: goto L_0x0084;
                case 11: goto L_0x0072;
                case 12: goto L_0x0062;
                case 13: goto L_0x0052;
                case 14: goto L_0x002c;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Type cannot be packed: "
            r8.<init>(r9)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            goto L_0x00e8
        L_0x002c:
            com.fyber.inneractive.sdk.protobuf.x r10 = new com.fyber.inneractive.sdk.protobuf.x
            r10.<init>()
            int r8 = h(r8, r9, r10, r14)
            com.fyber.inneractive.sdk.protobuf.l1 r9 = r11.unknownFields
            com.fyber.inneractive.sdk.protobuf.l1 r14 = com.fyber.inneractive.sdk.protobuf.l1.f
            if (r9 != r14) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = r9
        L_0x003d:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            com.fyber.inneractive.sdk.protobuf.y$d<?> r9 = r9.a
            java.lang.Object r7 = com.fyber.inneractive.sdk.protobuf.f1.a((int) r7, (java.util.List<java.lang.Integer>) r10, (com.fyber.inneractive.sdk.protobuf.y.d<?>) r9, r3, r13)
            com.fyber.inneractive.sdk.protobuf.l1 r7 = (com.fyber.inneractive.sdk.protobuf.l1) r7
            if (r7 == 0) goto L_0x004b
            r11.unknownFields = r7
        L_0x004b:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r12.d
            r0.c(r7, r10)
            goto L_0x0227
        L_0x0052:
            com.fyber.inneractive.sdk.protobuf.f0 r7 = new com.fyber.inneractive.sdk.protobuf.f0
            r7.<init>()
            int r8 = g(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x0062:
            com.fyber.inneractive.sdk.protobuf.x r7 = new com.fyber.inneractive.sdk.protobuf.x
            r7.<init>()
            int r8 = f(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x0072:
            com.fyber.inneractive.sdk.protobuf.g r7 = new com.fyber.inneractive.sdk.protobuf.g
            boolean[] r10 = new boolean[r1]
            r7.<init>(r10, r4)
            int r8 = a((byte[]) r8, (int) r9, (com.fyber.inneractive.sdk.protobuf.y.j<?>) r7, (com.fyber.inneractive.sdk.protobuf.e.b) r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x0084:
            com.fyber.inneractive.sdk.protobuf.x r7 = new com.fyber.inneractive.sdk.protobuf.x
            r7.<init>()
            int r8 = c(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x0094:
            com.fyber.inneractive.sdk.protobuf.f0 r7 = new com.fyber.inneractive.sdk.protobuf.f0
            r7.<init>()
            int r8 = d(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x00a4:
            com.fyber.inneractive.sdk.protobuf.x r7 = new com.fyber.inneractive.sdk.protobuf.x
            r7.<init>()
            int r8 = h(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x00b4:
            com.fyber.inneractive.sdk.protobuf.f0 r7 = new com.fyber.inneractive.sdk.protobuf.f0
            r7.<init>()
            int r8 = i(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x00c4:
            com.fyber.inneractive.sdk.protobuf.v r7 = new com.fyber.inneractive.sdk.protobuf.v
            float[] r10 = new float[r1]
            r7.<init>(r10, r4)
            int r8 = e(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x00d6:
            com.fyber.inneractive.sdk.protobuf.n r7 = new com.fyber.inneractive.sdk.protobuf.n
            double[] r10 = new double[r1]
            r7.<init>(r10, r4)
            int r8 = b(r8, r9, r7, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r9 = r12.d
            r0.c(r9, r7)
            goto L_0x0227
        L_0x00e8:
            com.fyber.inneractive.sdk.protobuf.r1$b r9 = r9.c
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00f5:
            com.fyber.inneractive.sdk.protobuf.r1$b r1 = r1.c
            com.fyber.inneractive.sdk.protobuf.r1$b r2 = com.fyber.inneractive.sdk.protobuf.r1.b.ENUM
            if (r1 != r2) goto L_0x012e
            int r9 = d(r8, r9, r14)
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r8 = r12.d
            com.fyber.inneractive.sdk.protobuf.y$d<?> r8 = r8.a
            int r10 = r14.a
            com.fyber.inneractive.sdk.protobuf.y$c r8 = r8.a(r10)
            if (r8 != 0) goto L_0x0126
            com.fyber.inneractive.sdk.protobuf.l1 r8 = r11.unknownFields
            com.fyber.inneractive.sdk.protobuf.l1 r10 = com.fyber.inneractive.sdk.protobuf.l1.f
            if (r8 != r10) goto L_0x0117
            com.fyber.inneractive.sdk.protobuf.l1 r8 = com.fyber.inneractive.sdk.protobuf.l1.c()
            r11.unknownFields = r8
        L_0x0117:
            int r10 = r14.a
            java.lang.Class<?> r11 = com.fyber.inneractive.sdk.protobuf.f1.a
            if (r8 != 0) goto L_0x0121
            java.lang.Object r8 = r13.a()
        L_0x0121:
            long r10 = (long) r10
            r13.b(r8, r7, r10)
            return r9
        L_0x0126:
            int r7 = r14.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x01f8
        L_0x012e:
            int[] r11 = com.fyber.inneractive.sdk.protobuf.e.a.a
            int r13 = r1.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01ea;
                case 2: goto L_0x01db;
                case 3: goto L_0x01d0;
                case 4: goto L_0x01d0;
                case 5: goto L_0x01c5;
                case 6: goto L_0x01c5;
                case 7: goto L_0x01bc;
                case 8: goto L_0x01bc;
                case 9: goto L_0x01b3;
                case 10: goto L_0x01b3;
                case 11: goto L_0x01a1;
                case 12: goto L_0x0192;
                case 13: goto L_0x0183;
                case 14: goto L_0x017b;
                case 15: goto L_0x0173;
                case 16: goto L_0x016b;
                case 17: goto L_0x014f;
                case 18: goto L_0x013b;
                default: goto L_0x0139;
            }
        L_0x0139:
            goto L_0x01f8
        L_0x013b:
            com.fyber.inneractive.sdk.protobuf.z0 r7 = com.fyber.inneractive.sdk.protobuf.z0.c
            com.fyber.inneractive.sdk.protobuf.o0 r11 = r12.c
            java.lang.Class r11 = r11.getClass()
            com.fyber.inneractive.sdk.protobuf.d1 r7 = r7.a(r11)
            int r9 = a((com.fyber.inneractive.sdk.protobuf.d1) r7, (byte[]) r8, (int) r9, (int) r10, (com.fyber.inneractive.sdk.protobuf.e.b) r14)
            java.lang.Object r3 = r14.c
            goto L_0x01f8
        L_0x014f:
            int r7 = r7 << 3
            r5 = r7 | 4
            com.fyber.inneractive.sdk.protobuf.z0 r7 = com.fyber.inneractive.sdk.protobuf.z0.c
            com.fyber.inneractive.sdk.protobuf.o0 r11 = r12.c
            java.lang.Class r11 = r11.getClass()
            com.fyber.inneractive.sdk.protobuf.d1 r1 = r7.a(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = a((com.fyber.inneractive.sdk.protobuf.d1) r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.fyber.inneractive.sdk.protobuf.e.b) r6)
            java.lang.Object r3 = r14.c
            goto L_0x01f8
        L_0x016b:
            int r9 = b(r8, r9, r14)
            java.lang.Object r3 = r14.c
            goto L_0x01f8
        L_0x0173:
            int r9 = a(r8, r9, r14)
            java.lang.Object r3 = r14.c
            goto L_0x01f8
        L_0x017b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0183:
            int r9 = e(r8, r9, r14)
            long r7 = r14.b
            long r7 = com.fyber.inneractive.sdk.protobuf.j.a((long) r7)
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            goto L_0x01f8
        L_0x0192:
            int r9 = d(r8, r9, r14)
            int r7 = r14.a
            int r7 = com.fyber.inneractive.sdk.protobuf.j.b(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x01f8
        L_0x01a1:
            int r9 = e(r8, r9, r14)
            long r7 = r14.b
            r10 = 0
            int r13 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x01ae
            r4 = 1
        L_0x01ae:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)
            goto L_0x01f8
        L_0x01b3:
            int r7 = a(r8, r9)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x01e7
        L_0x01bc:
            long r7 = b(r8, r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            goto L_0x01f6
        L_0x01c5:
            int r9 = d(r8, r9, r14)
            int r7 = r14.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x01f8
        L_0x01d0:
            int r9 = e(r8, r9, r14)
            long r7 = r14.b
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            goto L_0x01f8
        L_0x01db:
            int r7 = a(r8, r9)
            float r7 = java.lang.Float.intBitsToFloat(r7)
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
        L_0x01e7:
            int r9 = r9 + 4
            goto L_0x01f8
        L_0x01ea:
            long r7 = b(r8, r9)
            double r7 = java.lang.Double.longBitsToDouble(r7)
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
        L_0x01f6:
            int r9 = r9 + 8
        L_0x01f8:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r12.d
            boolean r8 = r7.d
            if (r8 == 0) goto L_0x0202
            r0.a(r7, (java.lang.Object) r3)
            goto L_0x0226
        L_0x0202:
            int[] r8 = com.fyber.inneractive.sdk.protobuf.e.a.a
            com.fyber.inneractive.sdk.protobuf.r1$b r7 = r7.c
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 17
            if (r7 == r8) goto L_0x0215
            r8 = 18
            if (r7 == r8) goto L_0x0215
            goto L_0x0221
        L_0x0215:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r12.d
            java.lang.Object r7 = r0.a(r7)
            if (r7 == 0) goto L_0x0221
            java.lang.Object r3 = com.fyber.inneractive.sdk.protobuf.y.a((java.lang.Object) r7, (java.lang.Object) r3)
        L_0x0221:
            com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$d r7 = r12.d
            r0.c(r7, r3)
        L_0x0226:
            r8 = r9
        L_0x0227:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.e.a(int, byte[], int, int, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage, com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$e, com.fyber.inneractive.sdk.protobuf.k1, com.fyber.inneractive.sdk.protobuf.e$b):int");
    }

    public static int a(int i, byte[] bArr, int i2, int i3, l1 l1Var, b bVar) throws z {
        int i4 = r1.a;
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 == 0) {
                int e = e(bArr, i2, bVar);
                l1Var.a(i, (Object) Long.valueOf(bVar.b));
                return e;
            } else if (i5 == 1) {
                l1Var.a(i, (Object) Long.valueOf(b(bArr, i2)));
                return i2 + 8;
            } else if (i5 == 2) {
                int d = d(bArr, i2, bVar);
                int i6 = bVar.a;
                if (i6 < 0) {
                    throw z.f();
                } else if (i6 <= bArr.length - d) {
                    if (i6 == 0) {
                        l1Var.a(i, (Object) i.b);
                    } else {
                        l1Var.a(i, (Object) i.a(bArr, d, i6));
                    }
                    return d + i6;
                } else {
                    throw z.i();
                }
            } else if (i5 == 3) {
                l1 c = l1.c();
                int i7 = (i & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int d2 = d(bArr, i2, bVar);
                    int i9 = bVar.a;
                    if (i9 == i7) {
                        i8 = i9;
                        i2 = d2;
                        break;
                    }
                    i8 = i9;
                    i2 = a(i9, bArr, d2, i3, c, bVar);
                }
                if (i2 > i3 || i8 != i7) {
                    throw z.g();
                }
                l1Var.a(i, (Object) c);
                return i2;
            } else if (i5 == 5) {
                l1Var.a(i, (Object) Integer.valueOf(a(bArr, i2)));
                return i2 + 4;
            } else {
                throw z.b();
            }
        } else {
            throw z.b();
        }
    }

    public static int a(int i, byte[] bArr, int i2, int i3, b bVar) throws z {
        int i4 = r1.a;
        if ((i >>> 3) != 0) {
            int i5 = i & 7;
            if (i5 == 0) {
                return e(bArr, i2, bVar);
            }
            if (i5 == 1) {
                return i2 + 8;
            }
            if (i5 == 2) {
                return d(bArr, i2, bVar) + bVar.a;
            }
            if (i5 == 3) {
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (i2 < i3) {
                    i2 = d(bArr, i2, bVar);
                    i7 = bVar.a;
                    if (i7 == i6) {
                        break;
                    }
                    i2 = a(i7, bArr, i2, i3, bVar);
                }
                if (i2 <= i3 && i7 == i6) {
                    return i2;
                }
                throw z.g();
            } else if (i5 == 5) {
                return i2 + 4;
            } else {
                throw z.b();
            }
        } else {
            throw z.b();
        }
    }
}
