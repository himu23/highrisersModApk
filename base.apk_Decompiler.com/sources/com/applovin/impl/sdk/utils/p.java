package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.ironsource.z3;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class p {
    private static final byte[] aVS = {-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77};
    private static final byte[] aVT;

    public enum a {
        NONE(-1),
        DEFAULT(0),
        V2(1);
        
        private final int ahF;

        public static a gW(int i) {
            return i == 0 ? DEFAULT : i == 1 ? V2 : DEFAULT;
        }

        public int getValue() {
            return this.ahF;
        }

        private a(int i) {
            this.ahF = i;
        }
    }

    static {
        byte[] bArr = new byte[32];
        aVT = bArr;
        System.arraycopy(new byte[]{Ascii.DC2, Ascii.FF, Ascii.FS, Ascii.DC4, 17, Ascii.ETB, Ascii.SUB, 9, Ascii.NAK, 3, Ascii.SO, Ascii.GS, 4, 0, 2, 7, 10, Ascii.GS, 6, Ascii.DC4, 1}, 0, bArr, 0, 21);
    }

    public static String a(String str, long j, a aVar, String str2, n nVar) {
        byte[] bArr;
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (TextUtils.isEmpty(str) || a.NONE == aVar) {
            return str;
        } else {
            if (a.V2 == aVar) {
                bArr = a(str, j, true, str2, nVar);
            } else {
                bArr = a(str, j, str2, nVar);
            }
            if (bArr != null) {
                return new String(bArr);
            }
            return null;
        }
    }

    public static byte[] b(String str, long j, a aVar, String str2, n nVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (TextUtils.isEmpty(str)) {
            return str.getBytes();
        } else {
            if (a.NONE == aVar) {
                return str.getBytes();
            }
            if (a.V2 == aVar) {
                return a(str, j, false, str2, nVar);
            }
            return a(str, j, str2, nVar);
        }
    }

    public static String a(byte[] bArr, String str, n nVar) {
        if (str == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (bArr == null) {
            return null;
        } else {
            if (bArr.length == 0) {
                return "";
            }
            a N = N(bArr);
            if (a.NONE == N) {
                return new String(bArr);
            }
            if (N == a.V2) {
                return b(bArr, str, nVar);
            }
            return b(new String(bArr), str, nVar);
        }
    }

    public static a N(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return a.NONE;
        }
        char c = (char) bArr[0];
        if (c == '2') {
            return a.V2;
        }
        if (c == '{') {
            return a.NONE;
        }
        return a.DEFAULT;
    }

    private static byte[] a(String str, long j, String str2, n nVar) {
        String str3 = str2;
        n nVar2 = nVar;
        char c = ' ';
        try {
            String substring = str3.substring(32);
            String substring2 = str3.substring(0, 32);
            byte[] bytes = str.getBytes("UTF-8");
            byte[] a2 = a(substring2, aVS, nVar2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(((byte) ((int) (j & 255))) ^ a2[0]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 8) & 255))) ^ a2[1]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 16) & 255))) ^ a2[2]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 24) & 255))) ^ a2[3]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 32) & 255))) ^ a2[4]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 40) & 255))) ^ a2[5]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 48) & 255))) ^ a2[6]);
            byteArrayOutputStream.write(((byte) ((int) ((j >> 56) & 255))) ^ a2[7]);
            int i = 0;
            while (i < bytes.length) {
                long j2 = j + ((long) i);
                long j3 = (j2 ^ (j2 >> 33)) * -4417276706812531889L;
                long j4 = (j3 ^ (j3 >> 29)) * -8796714831421723037L;
                long j5 = j4 ^ (j4 >> c);
                String str4 = substring;
                byteArrayOutputStream.write((byte) ((int) (((long) ((i >= bytes.length ? 0 : bytes[i]) ^ a2[i % a2.length])) ^ (j5 & 255))));
                int i2 = i + 1;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i2 % a2.length] ^ (i2 >= bytes.length ? 0 : bytes[i2]))) ^ ((j5 >> 8) & 255))));
                int i3 = i + 2;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i3 % a2.length] ^ (i3 >= bytes.length ? 0 : bytes[i3]))) ^ ((j5 >> 16) & 255))));
                int i4 = i + 3;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i4 % a2.length] ^ (i4 >= bytes.length ? 0 : bytes[i4]))) ^ ((j5 >> 24) & 255))));
                int i5 = i + 4;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i5 % a2.length] ^ (i5 >= bytes.length ? 0 : bytes[i5]))) ^ ((j5 >> 32) & 255))));
                int i6 = i + 5;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i6 % a2.length] ^ (i6 >= bytes.length ? 0 : bytes[i6]))) ^ ((j5 >> 40) & 255))));
                int i7 = i + 6;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i7 % a2.length] ^ (i7 >= bytes.length ? 0 : bytes[i7]))) ^ ((j5 >> 48) & 255))));
                int i8 = i + 7;
                byteArrayOutputStream.write((byte) ((int) (((long) (a2[i8 % a2.length] ^ (i8 >= bytes.length ? 0 : bytes[i8]))) ^ ((j5 >> 56) & 255))));
                i += 8;
                substring = str4;
                c = ' ';
            }
            String str5 = substring;
            String O = O(byteArrayOutputStream.toByteArray());
            String a3 = a(aVS, nVar2);
            return ("1:" + a3 + ":" + str5 + ":" + O).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            nVar.Cs().d("AppLovinSdk", "encode", e);
            return null;
        }
    }

    private static byte[] a(String str, long j, boolean z, String str2, n nVar) {
        ByteBuffer byteBuffer;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            String substring = str2.substring(32);
            String substring2 = str2.substring(0, 32);
            byte[] bArr = aVT;
            byte[] a2 = a(substring2, bArr, nVar);
            byte[] bytes2 = String.format("2:%s:%s:", new Object[]{a(bArr, nVar), substring}).getBytes();
            ByteBuffer allocate = ByteBuffer.allocate(16);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putLong((long) length);
            allocate.putLong(u.T(a2) ^ j);
            allocate.flip();
            byte[] a3 = a(u.R(bytes), j, a2);
            if (z) {
                byte[] bytes3 = O(allocate.array()).getBytes();
                byte[] bytes4 = O(a3).getBytes();
                byteBuffer = ByteBuffer.allocate(bytes2.length + bytes3.length + bytes4.length);
                byteBuffer.put(bytes2);
                byteBuffer.put(bytes3);
                byteBuffer.put(bytes4);
            } else {
                byteBuffer = ByteBuffer.allocate(bytes2.length + allocate.remaining() + a3.length);
                byteBuffer.put(bytes2);
                byteBuffer.put(allocate);
                byteBuffer.put(a3);
            }
            byteBuffer.flip();
            return byteBuffer.array();
        } catch (UnsupportedEncodingException e) {
            nVar.Cs().d("AppLovinSdk", "encode2", e);
            throw new RuntimeException("UTF-8 encoding not found", e);
        } catch (IOException e2) {
            nVar.Cs().d("AppLovinSdk", "encode2", e2);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, long j, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        long j2 = j;
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i % 8;
            if (i2 == 0) {
                long j3 = ((long) i) + j;
                long j4 = (j3 ^ (j3 >>> 33)) * -4417276706812531889L;
                long j5 = (j4 ^ (j4 >>> 29)) * -8796714831421723037L;
                j2 = j5 ^ (j5 >>> 32);
            }
            copyOf[i] = (byte) ((int) (((long) copyOf[i]) ^ (((j2 >> (i2 * 8)) & 255) ^ ((long) bArr2[i % bArr2.length]))));
        }
        return copyOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x01d0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x01d1, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x01e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01e5, code lost:
        r34.Cs().d("AppLovinSdk", "decode", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01f3, code lost:
        throw new java.lang.RuntimeException("UTF-8 encoding not found", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01e4 A[ExcHandler: UnsupportedEncodingException (r0v1 'e' java.io.UnsupportedEncodingException A[CUSTOM_DECLARE]), Splitter:B:1:0x0016] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r32, java.lang.String r33, com.applovin.impl.sdk.n r34) {
        /*
            r0 = r33
            r1 = r34
            java.lang.String r2 = "decode"
            java.lang.String r3 = "AppLovinSdk"
            java.lang.String r4 = ":"
            r5 = r32
            java.lang.String[] r4 = r5.split(r4)
            r5 = 0
            r6 = r4[r5]
            r7 = 0
            java.lang.String r8 = "1"
            boolean r6 = r8.equals(r6)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d5 }
            if (r6 == 0) goto L_0x01d3
            int r6 = r4.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r8 = 4
            if (r6 == r8) goto L_0x0021
            return r7
        L_0x0021:
            r6 = 1
            r9 = r4[r6]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r10 = 2
            r11 = r4[r10]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r12 = 3
            r4 = r4[r12]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte[] r4 = dB(r4)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            boolean r11 = r0.endsWith(r11)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            if (r11 != 0) goto L_0x0035
            return r7
        L_0x0035:
            byte[] r11 = aVS     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            java.lang.String r13 = a((byte[]) r11, (com.applovin.impl.sdk.n) r1)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            boolean r9 = r13.equals(r9)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            if (r9 == 0) goto L_0x01ce
            r9 = 32
            java.lang.String r0 = r0.substring(r5, r9)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte[] r0 = a((java.lang.String) r0, (byte[]) r11, (com.applovin.impl.sdk.n) r1)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            java.io.ByteArrayInputStream r11 = new java.io.ByteArrayInputStream     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r11.<init>(r4)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r4 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r13 = r0[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r13
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r13 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r4 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r15 = r0[r6]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r15
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r6 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = 8
            long r6 = r6 << r4
            long r6 = r6 | r13
            int r13 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r14 = r0[r10]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = r13 ^ r14
            r13 = r13 & 255(0xff, float:3.57E-43)
            long r13 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r16 = 16
            long r13 = r13 << r16
            long r6 = r6 | r13
            int r13 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r14 = r0[r12]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = r13 ^ r14
            r13 = r13 & 255(0xff, float:3.57E-43)
            long r13 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r17 = 24
            long r13 = r13 << r17
            long r6 = r6 | r13
            int r13 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r14 = r0[r8]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = r13 ^ r14
            r13 = r13 & 255(0xff, float:3.57E-43)
            long r13 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r13 = r13 << r9
            long r6 = r6 | r13
            int r13 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14 = 5
            byte r18 = r0[r14]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = r13 ^ r18
            r13 = r13 & 255(0xff, float:3.57E-43)
            long r14 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = 40
            long r14 = r14 << r13
            long r6 = r6 | r14
            int r14 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r15 = 6
            byte r19 = r0[r15]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14 = r14 ^ r19
            r14 = r14 & 255(0xff, float:3.57E-43)
            long r13 = (long) r14     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r20 = 48
            long r13 = r13 << r20
            long r6 = r6 | r13
            int r13 = r11.read()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14 = 7
            byte r21 = r0[r14]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = r13 ^ r21
            r13 = r13 & 255(0xff, float:3.57E-43)
            long r14 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = 56
            long r14 = r14 << r13
            long r6 = r6 | r14
            java.io.ByteArrayOutputStream r14 = new java.io.ByteArrayOutputStream     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte[] r15 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r22 = r11.read(r15)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r13 = 0
        L_0x00cf:
            if (r22 < 0) goto L_0x01be
            r23 = r11
            long r10 = (long) r13     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r10 = r10 + r6
            r24 = 33
            long r24 = r10 >> r24
            long r10 = r10 ^ r24
            r24 = -4417276706812531889(0xc2b2ae3d27d4eb4f, double:-2.053955963005931E13)
            long r10 = r10 * r24
            r24 = 29
            long r24 = r10 >> r24
            long r10 = r10 ^ r24
            r24 = -8796714831421723037(0x85ebca77c2b2ae63, double:-3.827511455475344E-280)
            long r10 = r10 * r24
            long r24 = r10 >> r9
            long r10 = r10 ^ r24
            byte r24 = r15[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r5 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r5 = r13 % r5
            byte r5 = r0[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = r24 ^ r5
            long r8 = (long) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r26 = 255(0xff, double:1.26E-321)
            long r28 = r10 & r26
            long r8 = r8 ^ r28
            int r5 = (int) r8     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r5 = (byte) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r5)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = 1
            byte r8 = r15[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r13 + 1
            int r5 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r9 % r5
            byte r5 = r0[r9]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = r5 ^ r8
            long r8 = (long) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r28 = r10 >> r4
            long r28 = r28 & r26
            long r8 = r8 ^ r28
            int r5 = (int) r8     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r5 = (byte) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r5)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = 2
            byte r8 = r15[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r13 + 2
            int r4 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r9 % r4
            byte r4 = r0[r9]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r8
            long r8 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r28 = r10 >> r16
            long r28 = r28 & r26
            long r8 = r8 ^ r28
            int r4 = (int) r8     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r4 = (byte) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r4)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r4 = r15[r12]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r8 = r13 + 3
            int r9 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r8 = r8 % r9
            byte r8 = r0[r8]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r8
            long r8 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r28 = r10 >> r17
            long r28 = r28 & r26
            long r8 = r8 ^ r28
            int r4 = (int) r8     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r4 = (byte) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r4)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = 4
            byte r8 = r15[r4]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r13 + 4
            int r4 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r9 % r4
            byte r4 = r0[r9]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r8
            long r8 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = 32
            long r28 = r10 >> r4
            long r28 = r28 & r26
            long r8 = r8 ^ r28
            int r9 = (int) r8     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r8 = (byte) r9     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r8)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r8 = 5
            byte r9 = r15[r8]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r18 = r13 + 5
            int r4 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r18 = r18 % r4
            byte r4 = r0[r18]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r9
            r28 = r6
            long r5 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = 40
            long r18 = r10 >> r4
            long r18 = r18 & r26
            long r5 = r5 ^ r18
            int r6 = (int) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r5 = (byte) r6     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r5)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = 6
            byte r6 = r15[r5]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r13 + 6
            int r4 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r9 = r9 % r4
            byte r4 = r0[r9]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = r4 ^ r6
            long r5 = (long) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            long r30 = r10 >> r20
            long r30 = r30 & r26
            long r4 = r5 ^ r30
            int r5 = (int) r4     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r4 = (byte) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r4)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r4 = 7
            byte r5 = r15[r4]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r6 = r13 + 7
            int r9 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r6 = r6 % r9
            byte r6 = r0[r6]     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = r5 ^ r6
            long r5 = (long) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r9 = 56
            long r10 = r10 >> r9
            long r10 = r10 & r26
            long r5 = r5 ^ r10
            int r6 = (int) r5     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte r5 = (byte) r6     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r14.write(r5)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            r5 = r23
            int r6 = r5.read(r15)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            int r13 = r13 + 8
            r11 = r5
            r22 = r6
            r6 = r28
            r4 = 8
            r5 = 0
            r8 = 4
            r9 = 32
            r10 = 2
            goto L_0x00cf
        L_0x01be:
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            byte[] r4 = r14.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            java.lang.String r5 = "UTF-8"
            r0.<init>(r4, r5)     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            java.lang.String r0 = r0.trim()     // Catch:{ UnsupportedEncodingException -> 0x01e4, IOException -> 0x01d0 }
            return r0
        L_0x01ce:
            r4 = r7
            return r4
        L_0x01d0:
            r0 = move-exception
            r4 = 0
            goto L_0x01d7
        L_0x01d3:
            r4 = r7
            return r4
        L_0x01d5:
            r0 = move-exception
            r4 = r7
        L_0x01d7:
            java.lang.String r5 = "Failed to read bytes"
            com.applovin.impl.sdk.x.f(r3, r5, r0)
            com.applovin.impl.sdk.r r1 = r34.Cs()
            r1.d(r3, r2, r0)
            return r4
        L_0x01e4:
            r0 = move-exception
            com.applovin.impl.sdk.r r1 = r34.Cs()
            r1.d(r3, r2, r0)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "UTF-8 encoding not found"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.p.b(java.lang.String, java.lang.String, com.applovin.impl.sdk.n):java.lang.String");
    }

    private static String b(byte[] bArr, String str, n nVar) {
        try {
            int c = c(bArr, str, nVar);
            if (c == 0) {
                return null;
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, c, bArr.length);
            if (copyOfRange.length < 16) {
                return null;
            }
            long n = u.n(copyOfRange, 8);
            byte[] a2 = a(str.substring(0, 32), aVT, nVar);
            return new String(u.S(a(Arrays.copyOfRange(copyOfRange, 16, copyOfRange.length), n ^ u.T(a2), a2)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            nVar.Cs().d("AppLovinSdk", "decode2", e);
            throw new RuntimeException("UTF-8 encoding not found", e);
        } catch (IOException e2) {
            x.f("AppLovinSdk", "Failed to ungzip decode", e2);
            nVar.Cs().d("AppLovinSdk", "decode2", e2);
            return null;
        }
    }

    private static int c(byte[] bArr, String str, n nVar) {
        int a2;
        int i;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || (a2 = a(bArr, (byte) 58)) < 0) {
            return 0;
        }
        byte[] bytes = a(aVT, nVar).getBytes();
        int i2 = a2 + 1;
        int length = bytes.length + i2;
        if (bArr.length <= length || bArr[length] != 58 || bArr.length <= (i = length + 55) || bArr[i] != 58 || !Arrays.equals(Arrays.copyOfRange(bArr, i2, bytes.length + i2), bytes)) {
            return 0;
        }
        int i3 = length + 56;
        if (length + 64 > bArr.length) {
            return 0;
        }
        return i3;
    }

    private static int a(byte[] bArr, byte b) {
        if (!(bArr == null || bArr.length == 0)) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == b) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static byte[] a(String str, byte[] bArr, n nVar) throws UnsupportedEncodingException {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            instance.update(str.getBytes("UTF-8"));
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            nVar.Cs().d("AppLovinSdk", "SHA256", e);
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    private static String a(byte[] bArr, n nVar) {
        try {
            MessageDigest instance = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
            instance.update(bArr);
            return StringUtils.toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            nVar.Cs().d("AppLovinSdk", "SHA1", e);
            throw new RuntimeException("SHA-1 algorithm not found", e);
        }
    }

    private static byte[] dB(String str) {
        return Base64.decode(dC(str), 0);
    }

    private static String O(byte[] bArr) throws UnsupportedEncodingException {
        return P(Base64.encode(bArr, 2));
    }

    private static String dC(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', z3.R);
    }

    private static String P(byte[] bArr) throws UnsupportedEncodingException {
        return new String(bArr, "UTF-8").replace('+', '-').replace('/', '_').replace(z3.R, '*');
    }
}
