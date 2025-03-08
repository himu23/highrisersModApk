package com.fyber.inneractive.sdk.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.protobuf.p1;
import java.nio.ByteBuffer;
import kotlin.UByte;

public final class q1 {
    public static final b a;

    public static abstract class b {
        public abstract int a(int i, byte[] bArr, int i2, int i3);

        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        public final String a(ByteBuffer byteBuffer, int i, int i2) throws z {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r11 < i3) {
                    byte b = byteBuffer.get(r11);
                    if (!a.a(b)) {
                        break;
                    }
                    i = r11 + 1;
                    cArr[i4] = (char) b;
                    i4++;
                }
                int i5 = i4;
                while (r11 < i3) {
                    int i6 = r11 + 1;
                    byte b2 = byteBuffer.get(r11);
                    if (a.a(b2)) {
                        cArr[i5] = (char) b2;
                        i5++;
                        r11 = i6;
                        while (r11 < i3) {
                            byte b3 = byteBuffer.get(r11);
                            if (!a.a(b3)) {
                                break;
                            }
                            r11++;
                            cArr[i5] = (char) b3;
                            i5++;
                        }
                    } else if (a.b(b2)) {
                        if (i6 < i3) {
                            r11 += 2;
                            a.a(b2, byteBuffer.get(i6), cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (a.c(b2)) {
                        if (i6 < i3 - 1) {
                            int i7 = r11 + 2;
                            r11 += 3;
                            a.a(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (i6 < i3 - 2) {
                        byte b4 = byteBuffer.get(i6);
                        int i8 = r11 + 3;
                        byte b5 = byteBuffer.get(r11 + 2);
                        r11 += 4;
                        a.a(b2, b4, b5, byteBuffer.get(i8), cArr, i5);
                        i5 += 2;
                    } else {
                        throw z.c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public abstract String a(byte[] bArr, int i, int i2) throws z;

        public abstract String b(ByteBuffer byteBuffer, int i, int i2) throws z;
    }

    public static class d extends IllegalArgumentException {
        public d(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    static {
        b bVar;
        if (!p1.g || !p1.f || d.a()) {
            bVar = new c();
        } else {
            bVar = new e();
        }
        a = bVar;
    }

    public static int a(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int a(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int a(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean a(byte[] bArr) {
        if (a.a(0, bArr, 0, bArr.length) == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(byte[] bArr, int i, int i2) {
        return a.a(0, bArr, i, i2) == 0;
    }

    public static int a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return a((int) b2);
        }
        if (i3 == 1) {
            return a(b2, bArr[i]);
        }
        if (i3 == 2) {
            return a((int) b2, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static class a {
        public static void a(byte b, byte b2, char[] cArr, int i) throws z {
            if (b < -62 || d(b2)) {
                throw z.c();
            }
            cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & 63));
        }

        public static boolean a(byte b) {
            return b >= 0;
        }

        public static boolean b(byte b) {
            return b < -32;
        }

        public static boolean c(byte b) {
            return b < -16;
        }

        public static boolean d(byte b) {
            return b > -65;
        }

        public static void a(byte b, byte b2, byte b3, char[] cArr, int i) throws z {
            if (d(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || d(b3)))) {
                throw z.c();
            }
            cArr[i] = (char) (((b & Ascii.SI) << Ascii.FF) | ((b2 & 63) << 6) | (b3 & 63));
        }

        public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws z {
            if (d(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || d(b3) || d(b4)) {
                throw z.c();
            }
            byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & 63) << Ascii.FF) | ((b3 & 63) << 6) | (b4 & 63);
            cArr[i] = (char) ((b5 >>> 10) + 55232);
            cArr[i + 1] = (char) ((b5 & UByte.MAX_VALUE) + 56320);
        }
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new d(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    public static final class c extends b {
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = -19
                r1 = 0
                r2 = -62
                r3 = -16
                r4 = -96
                r5 = -1
                r6 = -32
                r7 = -65
                if (r12 == 0) goto L_0x0085
                if (r14 < r15) goto L_0x0013
                return r12
            L_0x0013:
                byte r8 = (byte) r12
                if (r8 >= r6) goto L_0x0023
                if (r8 < r2) goto L_0x0022
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
                goto L_0x0022
            L_0x001f:
                r14 = r12
                goto L_0x0085
            L_0x0022:
                return r5
            L_0x0023:
                if (r8 >= r3) goto L_0x004a
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0039
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x0036
                int r12 = com.fyber.inneractive.sdk.protobuf.q1.a(r8, r14)
                return r12
            L_0x0036:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x0039:
                if (r12 > r7) goto L_0x0049
                if (r8 != r6) goto L_0x003f
                if (r12 < r4) goto L_0x0049
            L_0x003f:
                if (r8 != r0) goto L_0x0043
                if (r12 >= r4) goto L_0x0049
            L_0x0043:
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
            L_0x0049:
                return r5
            L_0x004a:
                int r9 = r12 >> 8
                int r9 = ~r9
                byte r9 = (byte) r9
                if (r9 != 0) goto L_0x005e
                int r12 = r14 + 1
                byte r9 = r13[r14]
                if (r12 < r15) goto L_0x005b
                int r12 = com.fyber.inneractive.sdk.protobuf.q1.a(r8, r9)
                return r12
            L_0x005b:
                r14 = r12
                r12 = 0
                goto L_0x0061
            L_0x005e:
                int r12 = r12 >> 16
                byte r12 = (byte) r12
            L_0x0061:
                if (r12 != 0) goto L_0x0071
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x006e
                int r12 = com.fyber.inneractive.sdk.protobuf.q1.a((int) r8, (int) r9, (int) r14)
                return r12
            L_0x006e:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x0071:
                if (r9 > r7) goto L_0x0084
                int r8 = r8 << 28
                int r9 = r9 + 112
                int r8 = r8 + r9
                int r8 = r8 >> 30
                if (r8 != 0) goto L_0x0084
                if (r12 > r7) goto L_0x0084
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
            L_0x0084:
                return r5
            L_0x0085:
                if (r14 >= r15) goto L_0x008e
                byte r12 = r13[r14]
                if (r12 < 0) goto L_0x008e
                int r14 = r14 + 1
                goto L_0x0085
            L_0x008e:
                if (r14 < r15) goto L_0x0092
                goto L_0x00ef
            L_0x0092:
                if (r14 < r15) goto L_0x0095
                goto L_0x00ef
            L_0x0095:
                int r12 = r14 + 1
                byte r8 = r13[r14]
                if (r8 >= 0) goto L_0x00f0
                if (r8 >= r6) goto L_0x00aa
                if (r12 < r15) goto L_0x00a1
                r1 = r8
                goto L_0x00ef
            L_0x00a1:
                if (r8 < r2) goto L_0x00ee
                int r14 = r14 + 2
                byte r12 = r13[r12]
                if (r12 <= r7) goto L_0x0092
                goto L_0x00ee
            L_0x00aa:
                if (r8 >= r3) goto L_0x00ca
                int r9 = r15 + -1
                if (r12 < r9) goto L_0x00b5
                int r1 = com.fyber.inneractive.sdk.protobuf.q1.a((byte[]) r13, (int) r12, (int) r15)
                goto L_0x00ef
            L_0x00b5:
                int r9 = r14 + 2
                byte r12 = r13[r12]
                if (r12 > r7) goto L_0x00ee
                if (r8 != r6) goto L_0x00bf
                if (r12 < r4) goto L_0x00ee
            L_0x00bf:
                if (r8 != r0) goto L_0x00c3
                if (r12 >= r4) goto L_0x00ee
            L_0x00c3:
                int r14 = r14 + 3
                byte r12 = r13[r9]
                if (r12 <= r7) goto L_0x0092
                goto L_0x00ee
            L_0x00ca:
                int r9 = r15 + -2
                if (r12 < r9) goto L_0x00d3
                int r1 = com.fyber.inneractive.sdk.protobuf.q1.a((byte[]) r13, (int) r12, (int) r15)
                goto L_0x00ef
            L_0x00d3:
                int r9 = r14 + 2
                byte r12 = r13[r12]
                if (r12 > r7) goto L_0x00ee
                int r8 = r8 << 28
                int r12 = r12 + 112
                int r8 = r8 + r12
                int r12 = r8 >> 30
                if (r12 != 0) goto L_0x00ee
                int r12 = r14 + 3
                byte r8 = r13[r9]
                if (r8 > r7) goto L_0x00ee
                int r14 = r14 + 4
                byte r12 = r13[r12]
                if (r12 <= r7) goto L_0x0092
            L_0x00ee:
                r1 = -1
            L_0x00ef:
                return r1
            L_0x00f0:
                r14 = r12
                goto L_0x0092
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.q1.c.a(int, byte[], int, int):int");
        }

        public String b(ByteBuffer byteBuffer, int i, int i2) throws z {
            return a(byteBuffer, i, i2);
        }

        public String a(byte[] bArr, int i, int i2) throws z {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r11 < i3) {
                    byte b = bArr[r11];
                    if (!a.a(b)) {
                        break;
                    }
                    i = r11 + 1;
                    cArr[i4] = (char) b;
                    i4++;
                }
                int i5 = i4;
                while (r11 < i3) {
                    int i6 = r11 + 1;
                    byte b2 = bArr[r11];
                    if (a.a(b2)) {
                        cArr[i5] = (char) b2;
                        i5++;
                        r11 = i6;
                        while (r11 < i3) {
                            byte b3 = bArr[r11];
                            if (!a.a(b3)) {
                                break;
                            }
                            r11++;
                            cArr[i5] = (char) b3;
                            i5++;
                        }
                    } else if (a.b(b2)) {
                        if (i6 < i3) {
                            r11 += 2;
                            a.a(b2, bArr[i6], cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (a.c(b2)) {
                        if (i6 < i3 - 1) {
                            int i7 = r11 + 2;
                            r11 += 3;
                            a.a(b2, bArr[i6], bArr[i7], cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (i6 < i3 - 2) {
                        byte b4 = bArr[i6];
                        int i8 = r11 + 3;
                        byte b5 = bArr[r11 + 2];
                        r11 += 4;
                        a.a(b2, b4, b5, bArr[i8], cArr, i5);
                        i5 += 2;
                    } else {
                        throw z.c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char charAt;
            int length = charSequence.length();
            int i5 = i2 + i;
            int i6 = 0;
            while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
                bArr[i4] = (byte) charAt;
                i6++;
            }
            if (i6 == length) {
                return i + length;
            }
            int i7 = i + i6;
            while (i6 < length) {
                char charAt2 = charSequence.charAt(i6);
                if (charAt2 < 128 && i7 < i5) {
                    bArr[i7] = (byte) charAt2;
                    i7++;
                } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                    i7 += 2;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                    bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                    int i9 = i7 + 2;
                    bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i7 += 3;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                } else if (i7 <= i5 - 4) {
                    int i10 = i6 + 1;
                    if (i10 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i10);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i11 = i7 + 3;
                            bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i11] = (byte) ((codePoint & 63) | 128);
                            i6 = i10;
                        } else {
                            i6 = i10;
                        }
                    }
                    throw new d(i6 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                } else {
                    throw new d(i6, length);
                }
                i6++;
            }
            return i7;
        }
    }

    public static final class e extends b {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
            if (com.fyber.inneractive.sdk.protobuf.p1.a(r1, r8) > -65) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
            if (com.fyber.inneractive.sdk.protobuf.p1.a(r1, r8) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00aa, code lost:
            if (com.fyber.inneractive.sdk.protobuf.p1.a(r1, r8) > -65) goto L_0x00ac;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r22, byte[] r23, int r24, int r25) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                r2 = r24
                r3 = r25
                r4 = r2 | r3
                int r5 = r1.length
                int r5 = r5 - r3
                r4 = r4 | r5
                r5 = 2
                if (r4 < 0) goto L_0x0157
                long r8 = (long) r2
                long r2 = (long) r3
                r4 = -19
                r10 = -62
                r11 = -16
                r12 = 16
                r13 = -96
                r14 = -32
                r15 = -1
                r16 = 1
                r7 = -65
                if (r0 == 0) goto L_0x00ad
                int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r18 < 0) goto L_0x002a
                return r0
            L_0x002a:
                byte r6 = (byte) r0
                if (r6 >= r14) goto L_0x003d
                if (r6 < r10) goto L_0x003c
                long r19 = r8 + r16
                byte r0 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r0 <= r7) goto L_0x0038
                goto L_0x003c
            L_0x0038:
                r8 = r19
                goto L_0x00ad
            L_0x003c:
                return r15
            L_0x003d:
                if (r6 >= r11) goto L_0x0069
                int r0 = r0 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0056
                long r19 = r8 + r16
                byte r0 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0054
                int r0 = com.fyber.inneractive.sdk.protobuf.q1.a(r6, r0)
                return r0
            L_0x0054:
                r8 = r19
            L_0x0056:
                if (r0 > r7) goto L_0x0068
                if (r6 != r14) goto L_0x005c
                if (r0 < r13) goto L_0x0068
            L_0x005c:
                if (r6 != r4) goto L_0x0060
                if (r0 >= r13) goto L_0x0068
            L_0x0060:
                long r19 = r8 + r16
                byte r0 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r0 <= r7) goto L_0x0038
            L_0x0068:
                return r15
            L_0x0069:
                int r4 = r0 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0082
                long r19 = r8 + r16
                byte r4 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
                if (r0 < 0) goto L_0x007e
                int r0 = com.fyber.inneractive.sdk.protobuf.q1.a(r6, r4)
                return r0
            L_0x007e:
                r8 = r19
                r0 = 0
                goto L_0x0084
            L_0x0082:
                int r0 = r0 >> r12
                byte r0 = (byte) r0
            L_0x0084:
                if (r0 != 0) goto L_0x0097
                long r19 = r8 + r16
                byte r0 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0095
                int r0 = com.fyber.inneractive.sdk.protobuf.q1.a((int) r6, (int) r4, (int) r0)
                return r0
            L_0x0095:
                r8 = r19
            L_0x0097:
                if (r4 > r7) goto L_0x00ac
                int r6 = r6 << 28
                int r4 = r4 + 112
                int r6 = r6 + r4
                int r4 = r6 >> 30
                if (r4 != 0) goto L_0x00ac
                if (r0 > r7) goto L_0x00ac
                long r19 = r8 + r16
                byte r0 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r0 <= r7) goto L_0x0038
            L_0x00ac:
                return r15
            L_0x00ad:
                long r2 = r2 - r8
                int r0 = (int) r2
                if (r0 >= r12) goto L_0x00b3
                r2 = 0
                goto L_0x00c6
            L_0x00b3:
                r3 = r8
                r2 = 0
            L_0x00b5:
                if (r2 >= r0) goto L_0x00c5
                long r19 = r3 + r16
                byte r3 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r3)
                if (r3 >= 0) goto L_0x00c0
                goto L_0x00c6
            L_0x00c0:
                int r2 = r2 + 1
                r3 = r19
                goto L_0x00b5
            L_0x00c5:
                r2 = r0
            L_0x00c6:
                int r0 = r0 - r2
                long r2 = (long) r2
                long r8 = r8 + r2
            L_0x00c9:
                r2 = 0
            L_0x00ca:
                if (r0 <= 0) goto L_0x00db
                long r2 = r8 + r16
                byte r4 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r4 < 0) goto L_0x00d9
                int r0 = r0 + -1
                r8 = r2
                r2 = r4
                goto L_0x00ca
            L_0x00d9:
                r8 = r2
                r2 = r4
            L_0x00db:
                if (r0 != 0) goto L_0x00e0
                r7 = 0
                goto L_0x0156
            L_0x00e0:
                int r3 = r0 + -1
                if (r2 >= r14) goto L_0x00f8
                if (r3 != 0) goto L_0x00e9
                r7 = r2
                goto L_0x0156
            L_0x00e9:
                int r0 = r0 + -2
                if (r2 < r10) goto L_0x0155
                long r2 = r8 + r16
                byte r4 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r4 <= r7) goto L_0x00f6
                goto L_0x0155
            L_0x00f6:
                r8 = r2
                goto L_0x00c9
            L_0x00f8:
                r19 = 2
                if (r2 >= r11) goto L_0x0120
                if (r3 >= r5) goto L_0x0103
                int r7 = a((byte[]) r1, (int) r2, (long) r8, (int) r3)
                goto L_0x0156
            L_0x0103:
                int r0 = r0 + -3
                long r3 = r8 + r16
                byte r6 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r6 > r7) goto L_0x0155
                if (r2 != r14) goto L_0x0111
                if (r6 < r13) goto L_0x0155
            L_0x0111:
                r12 = -19
                if (r2 != r12) goto L_0x0117
                if (r6 >= r13) goto L_0x0155
            L_0x0117:
                long r8 = r8 + r19
                byte r2 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r3)
                if (r2 <= r7) goto L_0x00c9
                goto L_0x0155
            L_0x0120:
                r4 = 3
                r12 = -19
                if (r3 >= r4) goto L_0x012a
                int r7 = a((byte[]) r1, (int) r2, (long) r8, (int) r3)
                goto L_0x0156
            L_0x012a:
                int r0 = r0 + -4
                long r3 = r8 + r16
                byte r6 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r8)
                if (r6 > r7) goto L_0x0155
                int r2 = r2 << 28
                int r6 = r6 + 112
                int r2 = r2 + r6
                int r2 = r2 >> 30
                if (r2 != 0) goto L_0x0155
                long r10 = r8 + r19
                byte r2 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r3)
                if (r2 > r7) goto L_0x0155
                r2 = 3
                long r8 = r8 + r2
                byte r2 = com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r10)
                if (r2 <= r7) goto L_0x014f
                goto L_0x0155
            L_0x014f:
                r10 = -62
                r11 = -16
                goto L_0x00c9
            L_0x0155:
                r7 = -1
            L_0x0156:
                return r7
            L_0x0157:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                int r1 = r1.length
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r6 = 0
                r4[r6] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r24)
                r2 = 1
                r4[r2] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r25)
                r4[r5] = r1
                java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r1 = java.lang.String.format(r1, r4)
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.q1.e.a(int, byte[], int, int):int");
        }

        public String b(ByteBuffer byteBuffer, int i, int i2) throws z {
            long j;
            int i3;
            long j2;
            int i4 = i;
            int i5 = i2;
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
                long a = p1.a(byteBuffer) + ((long) i4);
                long j3 = ((long) i5) + a;
                char[] cArr = new char[i5];
                int i6 = 0;
                while (true) {
                    j2 = 1;
                    if (j >= j3) {
                        break;
                    }
                    byte a2 = p1.e.a(j);
                    if (!a.a(a2)) {
                        break;
                    }
                    a = j + 1;
                    cArr[i3] = (char) a2;
                    i6 = i3 + 1;
                }
                while (j < j3) {
                    long j4 = j + j2;
                    p1.d dVar = p1.e;
                    byte a3 = dVar.a(j);
                    if (a.a(a3)) {
                        cArr[i3] = (char) a3;
                        i3++;
                        j = j4;
                        while (j < j3) {
                            byte a4 = p1.e.a(j);
                            if (!a.a(a4)) {
                                break;
                            }
                            j += j2;
                            cArr[i3] = (char) a4;
                            i3++;
                        }
                    } else if (a.b(a3)) {
                        if (j4 < j3) {
                            j += 2;
                            a.a(a3, dVar.a(j4), cArr, i3);
                            i3++;
                        } else {
                            throw z.c();
                        }
                    } else if (a.c(a3)) {
                        if (j4 < j3 - j2) {
                            long j5 = 2 + j;
                            j += 3;
                            a.a(a3, dVar.a(j4), dVar.a(j5), cArr, i3);
                            i3++;
                        } else {
                            throw z.c();
                        }
                    } else if (j4 < j3 - 2) {
                        byte a5 = dVar.a(j4);
                        long j6 = j + 3;
                        byte a6 = dVar.a(2 + j);
                        j += 4;
                        a.a(a3, a5, a6, dVar.a(j6), cArr, i3);
                        i3 += 2;
                        j2 = 1;
                    } else {
                        throw z.c();
                    }
                }
                return new String(cArr, 0, i3);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public String a(byte[] bArr, int i, int i2) throws z {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r11 < i3) {
                    byte a = p1.a(bArr, (long) r11);
                    if (!a.a(a)) {
                        break;
                    }
                    i = r11 + 1;
                    cArr[i4] = (char) a;
                    i4++;
                }
                int i5 = i4;
                while (r11 < i3) {
                    int i6 = r11 + 1;
                    byte a2 = p1.a(bArr, (long) r11);
                    if (a.a(a2)) {
                        cArr[i5] = (char) a2;
                        i5++;
                        r11 = i6;
                        while (r11 < i3) {
                            byte a3 = p1.a(bArr, (long) r11);
                            if (!a.a(a3)) {
                                break;
                            }
                            r11++;
                            cArr[i5] = (char) a3;
                            i5++;
                        }
                    } else if (a.b(a2)) {
                        if (i6 < i3) {
                            r11 += 2;
                            a.a(a2, p1.a(bArr, (long) i6), cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (a.c(a2)) {
                        if (i6 < i3 - 1) {
                            int i7 = r11 + 2;
                            r11 += 3;
                            a.a(a2, p1.a(bArr, (long) i6), p1.a(bArr, (long) i7), cArr, i5);
                            i5++;
                        } else {
                            throw z.c();
                        }
                    } else if (i6 < i3 - 2) {
                        byte a4 = p1.a(bArr, (long) i6);
                        int i8 = r11 + 3;
                        r11 += 4;
                        a.a(a2, a4, p1.a(bArr, (long) (r11 + 2)), p1.a(bArr, (long) i8), cArr, i5);
                        i5 += 2;
                    } else {
                        throw z.c();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00f8, LOOP_START, PHI: r2 r4 r6 r9 r10 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 long) = (r6v1 long), (r6v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 java.lang.String) = (r10v0 java.lang.String), (r10v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(java.lang.CharSequence r25, byte[] r26, int r27, int r28) {
            /*
                r24 = this;
                r0 = r25
                r1 = r26
                r2 = r27
                r3 = r28
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r25.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0141
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0141
                r2 = 0
            L_0x001a:
                r11 = 1
                r3 = 128(0x80, float:1.794E-43)
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r4, (byte) r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x013f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004f
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004f
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r4, (byte) r13)
                r22 = r6
                r17 = r10
                r20 = r11
                r4 = r14
                r14 = r9
                goto L_0x00f8
            L_0x004f:
                r14 = 2048(0x800, float:2.87E-42)
                r15 = 2
                if (r13 >= r14) goto L_0x0076
                long r17 = r6 - r15
                int r14 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r14 > 0) goto L_0x0076
                r14 = r9
                r17 = r10
                long r9 = r4 + r11
                int r11 = r13 >>> 6
                r11 = r11 | 960(0x3c0, float:1.345E-42)
                byte r11 = (byte) r11
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r4, (byte) r11)
                long r4 = r4 + r15
                r11 = r13 & 63
                r11 = r11 | r3
                byte r11 = (byte) r11
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r9, (byte) r11)
            L_0x0070:
                r22 = r6
                r20 = 1
                goto L_0x00f8
            L_0x0076:
                r14 = r9
                r17 = r10
                r9 = 57343(0xdfff, float:8.0355E-41)
                r10 = 55296(0xd800, float:7.7486E-41)
                r11 = 3
                if (r13 < r10) goto L_0x0085
                if (r9 >= r13) goto L_0x00ad
            L_0x0085:
                long r18 = r6 - r11
                int r20 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
                if (r20 > 0) goto L_0x00ad
                r18 = 1
                long r9 = r4 + r18
                int r11 = r13 >>> 12
                r11 = r11 | 480(0x1e0, float:6.73E-43)
                byte r11 = (byte) r11
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r4, (byte) r11)
                long r11 = r4 + r15
                int r15 = r13 >>> 6
                r15 = r15 & 63
                r15 = r15 | r3
                byte r15 = (byte) r15
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r9, (byte) r15)
                r9 = 3
                long r4 = r4 + r9
                r9 = r13 & 63
                r9 = r9 | r3
                byte r9 = (byte) r9
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r11, (byte) r9)
                goto L_0x0070
            L_0x00ad:
                r11 = 4
                long r20 = r6 - r11
                int r22 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
                if (r22 > 0) goto L_0x010c
                int r9 = r2 + 1
                if (r9 == r8) goto L_0x0104
                char r2 = r0.charAt(r9)
                boolean r10 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r10 == 0) goto L_0x0103
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r20 = 1
                long r11 = r4 + r20
                int r10 = r2 >>> 18
                r10 = r10 | 240(0xf0, float:3.36E-43)
                byte r10 = (byte) r10
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r4, (byte) r10)
                r22 = r6
                long r6 = r4 + r15
                int r10 = r2 >>> 12
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r11, (byte) r10)
                r10 = 3
                long r11 = r4 + r10
                int r10 = r2 >>> 6
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r6, (byte) r10)
                r6 = 4
                long r4 = r4 + r6
                r2 = r2 & 63
                r2 = r2 | r3
                byte r2 = (byte) r2
                com.fyber.inneractive.sdk.protobuf.p1.a((byte[]) r1, (long) r11, (byte) r2)
                r2 = r9
            L_0x00f8:
                int r2 = r2 + 1
                r9 = r14
                r10 = r17
                r11 = r20
                r6 = r22
                goto L_0x0033
            L_0x0103:
                r2 = r9
            L_0x0104:
                com.fyber.inneractive.sdk.protobuf.q1$d r0 = new com.fyber.inneractive.sdk.protobuf.q1$d
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010c:
                if (r10 > r13) goto L_0x0124
                if (r13 > r9) goto L_0x0124
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x011e
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0124
            L_0x011e:
                com.fyber.inneractive.sdk.protobuf.q1$d r0 = new com.fyber.inneractive.sdk.protobuf.q1$d
                r0.<init>(r2, r8)
                throw r0
            L_0x0124:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r6 = r17
                r1.<init>(r6)
                r1.append(r13)
                r7 = r14
                r1.append(r7)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x013f:
                int r0 = (int) r4
                return r0
            L_0x0141:
                r7 = r9
                r6 = r10
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r6)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r7)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.q1.e.a(java.lang.CharSequence, byte[], int, int):int");
        }

        public static int a(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return q1.a(i);
            }
            if (i2 == 1) {
                return q1.a(i, p1.a(bArr, j));
            }
            if (i2 == 2) {
                return q1.a(i, (int) p1.a(bArr, j), (int) p1.a(bArr, j + 1));
            }
            throw new AssertionError();
        }
    }
}
