package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

public final class g {
    public static final int b = u.a("ID3");
    public final a a;

    public interface a {
    }

    public static final class b {
        public final int a;
        public final boolean b;
        public final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public g() {
        this((a) null);
    }

    public static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static d b(k kVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        k kVar2 = kVar;
        int i4 = kVar2.b;
        int b2 = b(kVar2.a, i4);
        String str = new String(kVar2.a, i4, b2 - i4, "ISO-8859-1");
        kVar.e(b2 + 1);
        int l = kVar.l();
        boolean z2 = (l & 2) != 0;
        boolean z3 = (l & 1) != 0;
        int l2 = kVar.l();
        String[] strArr = new String[l2];
        for (int i5 = 0; i5 < l2; i5++) {
            int i6 = kVar2.b;
            int b3 = b(kVar2.a, i6);
            strArr[i5] = new String(kVar2.a, i6, b3 - i6, "ISO-8859-1");
            kVar.e(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (kVar2.b < i7) {
            h a2 = a(i2, kVar, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z2, z3, strArr, hVarArr);
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    public static k c(k kVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i);
        kVar.b += i;
        return new k(str, (String) null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    public static j d(k kVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int l = kVar.l();
        String b2 = b(l);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i2);
        kVar.b += i2;
        int a2 = a(bArr, 0, l);
        String str = new String(bArr, 0, a2, b2);
        int a3 = a2 + a(l);
        return new j("TXXX", str, a3 < i2 ? new String(bArr, a3, a(bArr, a3, l) - a3, b2) : "");
    }

    public static k e(k kVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int l = kVar.l();
        String b2 = b(l);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i2);
        kVar.b += i2;
        int a2 = a(bArr, 0, l);
        String str = new String(bArr, 0, a2, b2);
        int a3 = a2 + a(l);
        return new k("WXXX", str, a3 < i2 ? new String(bArr, a3, b(bArr, a3) - a3, "ISO-8859-1") : "");
    }

    public static int f(k kVar, int i) {
        byte[] bArr = kVar.a;
        int i2 = kVar.b;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= i) {
                return i;
            }
            if ((bArr[i2] & UByte.MAX_VALUE) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i3, (i - i2) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.a a(byte[] r13, int r14) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            r1.<init>(r13, r14)
            int r13 = r1.a()
            r14 = 2
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Id3Decoder"
            r5 = 4
            r6 = 0
            r7 = 10
            if (r13 >= r7) goto L_0x0021
            java.lang.String r13 = "Data too short to be an ID3 tag"
            android.util.Log.w(r4, r13)
        L_0x001e:
            r10 = r6
            goto L_0x009e
        L_0x0021:
            int r13 = r1.n()
            int r8 = b
            if (r13 == r8) goto L_0x003b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Unexpected first three bytes of ID3 tag header: "
            r8.<init>(r9)
            r8.append(r13)
            java.lang.String r13 = r8.toString()
            android.util.Log.w(r4, r13)
            goto L_0x001e
        L_0x003b:
            int r13 = r1.l()
            r1.f(r3)
            int r8 = r1.l()
            int r9 = r1.k()
            if (r13 != r14) goto L_0x0056
            r10 = r8 & 64
            if (r10 == 0) goto L_0x007d
            java.lang.String r13 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            android.util.Log.w(r4, r13)
            goto L_0x001e
        L_0x0056:
            r10 = 3
            if (r13 != r10) goto L_0x0067
            r10 = r8 & 64
            if (r10 == 0) goto L_0x007d
            int r10 = r1.c()
            r1.f(r10)
            int r10 = r10 + r5
            int r9 = r9 - r10
            goto L_0x007d
        L_0x0067:
            if (r13 != r5) goto L_0x008c
            r10 = r8 & 64
            if (r10 == 0) goto L_0x0077
            int r10 = r1.k()
            int r11 = r10 + -4
            r1.f(r11)
            int r9 = r9 - r10
        L_0x0077:
            r10 = r8 & 16
            if (r10 == 0) goto L_0x007d
            int r9 = r9 + -10
        L_0x007d:
            if (r13 >= r5) goto L_0x0085
            r8 = r8 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0085
            r8 = 1
            goto L_0x0086
        L_0x0085:
            r8 = 0
        L_0x0086:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g$b r10 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g$b
            r10.<init>(r13, r8, r9)
            goto L_0x009e
        L_0x008c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Skipped ID3 tag with unsupported majorVersion="
            r8.<init>(r9)
            r8.append(r13)
            java.lang.String r13 = r8.toString()
            android.util.Log.w(r4, r13)
            goto L_0x001e
        L_0x009e:
            if (r10 != 0) goto L_0x00a1
            return r6
        L_0x00a1:
            int r13 = r1.b
            int r8 = r10.a
            if (r8 != r14) goto L_0x00a8
            r7 = 6
        L_0x00a8:
            int r14 = r10.c
            boolean r8 = r10.b
            if (r8 == 0) goto L_0x00b2
            int r14 = f(r1, r14)
        L_0x00b2:
            int r13 = r13 + r14
            r1.d(r13)
            int r13 = r10.a
            boolean r13 = a(r1, r13, r7, r2)
            if (r13 != 0) goto L_0x00de
            int r13 = r10.a
            if (r13 != r5) goto L_0x00ca
            boolean r13 = a(r1, r5, r7, r3)
            if (r13 == 0) goto L_0x00ca
            r2 = 1
            goto L_0x00de
        L_0x00ca:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Failed to validate ID3 tag with majorVersion="
            r13.<init>(r14)
            int r14 = r10.a
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            android.util.Log.w(r4, r13)
            return r6
        L_0x00de:
            int r13 = r1.a()
            if (r13 < r7) goto L_0x00f2
            int r13 = r10.a
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g$a r14 = r12.a
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h r13 = a((int) r13, (com.fyber.inneractive.sdk.player.exoplayer2.util.k) r1, (boolean) r2, (int) r7, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a) r14)
            if (r13 == 0) goto L_0x00de
            r0.add(r13)
            goto L_0x00de
        L_0x00f2:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r13 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.a
            r13.<init>((java.util.List<? extends com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b>) r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a(byte[], int):com.fyber.inneractive.sdk.player.exoplayer2.metadata.a");
    }

    public g(a aVar) {
        this.a = aVar;
    }

    public static i c(k kVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i);
        kVar.b += i;
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i2 = b2 + 1;
        return new i(str, i2 < i ? Arrays.copyOfRange(bArr, i2, i) : new byte[0]);
    }

    public static j b(k kVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int l = kVar.l();
        String b2 = b(l);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i2);
        kVar.b += i2;
        return new j(str, (String) null, new String(bArr, 0, a(bArr, 0, l), b2));
    }

    public static f b(k kVar, int i) throws UnsupportedEncodingException {
        int l = kVar.l();
        String b2 = b(l);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i2);
        kVar.b += i2;
        int b3 = b(bArr, 0);
        String str = new String(bArr, 0, b3, "ISO-8859-1");
        int i3 = b3 + 1;
        int a2 = a(bArr, i3, l);
        String str2 = new String(bArr, i3, a2 - i3, b2);
        int a3 = a2 + a(l);
        int a4 = a(bArr, a3, l);
        return new f(str, str2, new String(bArr, a3, a4 - a3, b2), Arrays.copyOfRange(bArr, a4 + a(l), i2));
    }

    public static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static c a(k kVar, int i, int i2, boolean z, int i3, a aVar) throws UnsupportedEncodingException {
        k kVar2 = kVar;
        int i4 = kVar2.b;
        int b2 = b(kVar2.a, i4);
        String str = new String(kVar2.a, i4, b2 - i4, "ISO-8859-1");
        kVar.e(b2 + 1);
        int c = kVar.c();
        int c2 = kVar.c();
        long m = kVar.m();
        long j = m == 4294967295L ? -1 : m;
        long m2 = kVar.m();
        long j2 = m2 == 4294967295L ? -1 : m2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (kVar2.b < i5) {
            h a2 = a(i2, kVar, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, c, c2, j, j2, hVarArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        if ((r10 & 1) != 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0082, code lost:
        if ((r10 & 128) != 0) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.b
        L_0x0006:
            int r3 = r18.a()     // Catch:{ all -> 0x00ab }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00a7
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0020
            int r7 = r18.c()     // Catch:{ all -> 0x00ab }
            long r8 = r18.m()     // Catch:{ all -> 0x00ab }
            int r10 = r18.q()     // Catch:{ all -> 0x00ab }
            goto L_0x002a
        L_0x0020:
            int r7 = r18.n()     // Catch:{ all -> 0x00ab }
            int r8 = r18.n()     // Catch:{ all -> 0x00ab }
            long r8 = (long) r8
            r10 = 0
        L_0x002a:
            r11 = 0
            if (r7 != 0) goto L_0x0038
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0038
            if (r10 != 0) goto L_0x0038
            r1.e(r2)
            return r4
        L_0x0038:
            r7 = 4
            if (r0 != r7) goto L_0x0069
            if (r21 != 0) goto L_0x0069
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x0049
            r1.e(r2)
            return r6
        L_0x0049:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x0069:
            if (r0 != r7) goto L_0x0077
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0071
            r3 = 1
            goto L_0x0072
        L_0x0071:
            r3 = 0
        L_0x0072:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0077:
            if (r0 != r3) goto L_0x0085
            r3 = r10 & 32
            if (r3 == 0) goto L_0x007f
            r3 = 1
            goto L_0x0080
        L_0x007f:
            r3 = 0
        L_0x0080:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0085:
            r3 = 0
        L_0x0086:
            r4 = 0
        L_0x0087:
            if (r4 == 0) goto L_0x008b
            int r3 = r3 + 4
        L_0x008b:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0094
            r1.e(r2)
            return r6
        L_0x0094:
            int r3 = r18.a()     // Catch:{ all -> 0x00ab }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a1
            r1.e(r2)
            return r6
        L_0x00a1:
            int r3 = (int) r8
            r1.f(r3)     // Catch:{ all -> 0x00ab }
            goto L_0x0006
        L_0x00a7:
            r1.e(r2)
            return r4
        L_0x00ab:
            r0 = move-exception
            r1.e(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k, int, int, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0186, code lost:
        if (r12 == 67) goto L_0x0188;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h a(int r20, com.fyber.inneractive.sdk.player.exoplayer2.util.k r21, boolean r22, int r23, com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a r24) {
        /*
            r0 = r20
            r7 = r21
            java.lang.String r8 = "Failed to decode frame: id="
            int r9 = r21.l()
            int r10 = r21.l()
            int r11 = r21.l()
            r2 = 3
            if (r0 < r2) goto L_0x001b
            int r3 = r21.l()
            r12 = r3
            goto L_0x001c
        L_0x001b:
            r12 = 0
        L_0x001c:
            r3 = 4
            if (r0 != r3) goto L_0x003d
            int r4 = r21.o()
            if (r22 != 0) goto L_0x0048
            r5 = r4 & 255(0xff, float:3.57E-43)
            int r6 = r4 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 7
            r5 = r5 | r6
            int r6 = r4 >> 16
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 14
            r5 = r5 | r6
            int r4 = r4 >> 24
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 21
            r4 = r4 | r5
            goto L_0x0048
        L_0x003d:
            if (r0 != r2) goto L_0x0044
            int r4 = r21.o()
            goto L_0x0048
        L_0x0044:
            int r4 = r21.n()
        L_0x0048:
            if (r0 < r2) goto L_0x004f
            int r5 = r21.q()
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            r13 = 0
            if (r9 != 0) goto L_0x0063
            if (r10 != 0) goto L_0x0063
            if (r11 != 0) goto L_0x0063
            if (r12 != 0) goto L_0x0063
            if (r4 != 0) goto L_0x0063
            if (r5 != 0) goto L_0x0063
            int r0 = r7.c
            r7.e(r0)
            return r13
        L_0x0063:
            int r6 = r7.b
            int r14 = r6 + r4
            int r6 = r7.c
            java.lang.String r15 = "Id3Decoder"
            if (r14 <= r6) goto L_0x0078
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r15, r0)
            int r0 = r7.c
            r7.e(r0)
            return r13
        L_0x0078:
            r6 = 77
            r1 = 79
            r3 = 2
            r2 = 67
            if (r24 == 0) goto L_0x0090
            if (r9 != r2) goto L_0x008c
            if (r10 != r1) goto L_0x008c
            if (r11 != r6) goto L_0x008c
            if (r12 == r6) goto L_0x0090
            if (r0 != r3) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            r7.e(r14)
            return r13
        L_0x0090:
            r13 = 1
            r6 = 3
            if (r0 != r6) goto L_0x00b5
            r6 = r5 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x009a
            r6 = 1
            goto L_0x009b
        L_0x009a:
            r6 = 0
        L_0x009b:
            r17 = r5 & 64
            if (r17 == 0) goto L_0x00a2
            r17 = 1
            goto L_0x00a4
        L_0x00a2:
            r17 = 0
        L_0x00a4:
            r5 = r5 & 32
            if (r5 == 0) goto L_0x00aa
            r5 = 1
            goto L_0x00ab
        L_0x00aa:
            r5 = 0
        L_0x00ab:
            r16 = r6
            r18 = r17
            r19 = 0
            r6 = r5
            r17 = r16
            goto L_0x00ec
        L_0x00b5:
            r6 = 4
            if (r0 != r6) goto L_0x00e3
            r6 = r5 & 64
            if (r6 == 0) goto L_0x00be
            r6 = 1
            goto L_0x00bf
        L_0x00be:
            r6 = 0
        L_0x00bf:
            r17 = r5 & 8
            if (r17 == 0) goto L_0x00c6
            r17 = 1
            goto L_0x00c8
        L_0x00c6:
            r17 = 0
        L_0x00c8:
            r18 = r5 & 4
            if (r18 == 0) goto L_0x00cf
            r18 = 1
            goto L_0x00d1
        L_0x00cf:
            r18 = 0
        L_0x00d1:
            r19 = r5 & 2
            if (r19 == 0) goto L_0x00d8
            r19 = 1
            goto L_0x00da
        L_0x00d8:
            r19 = 0
        L_0x00da:
            r5 = r5 & r13
            if (r5 == 0) goto L_0x00e0
            r16 = 1
            goto L_0x00ec
        L_0x00e0:
            r16 = 0
            goto L_0x00ec
        L_0x00e3:
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x00ec:
            if (r17 != 0) goto L_0x0209
            if (r18 == 0) goto L_0x00f2
            goto L_0x0209
        L_0x00f2:
            if (r6 == 0) goto L_0x00f9
            int r4 = r4 + -1
            r7.f(r13)
        L_0x00f9:
            if (r16 == 0) goto L_0x0101
            int r4 = r4 + -4
            r5 = 4
            r7.f(r5)
        L_0x0101:
            if (r19 == 0) goto L_0x0107
            int r4 = f(r7, r4)
        L_0x0107:
            r13 = r4
            r4 = 84
            r5 = 88
            if (r9 != r4) goto L_0x011c
            if (r10 != r5) goto L_0x011c
            if (r11 != r5) goto L_0x011c
            if (r0 == r3) goto L_0x0116
            if (r12 != r5) goto L_0x011c
        L_0x0116:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r1 = d(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x011c:
            if (r9 != r4) goto L_0x012b
            java.lang.String r1 = a((int) r0, (int) r9, (int) r10, (int) r11, (int) r12)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j r1 = b(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x0128:
            r0 = move-exception
            goto L_0x0205
        L_0x012b:
            r6 = 87
            if (r9 != r6) goto L_0x013d
            if (r10 != r5) goto L_0x013d
            if (r11 != r5) goto L_0x013d
            if (r0 == r3) goto L_0x0137
            if (r12 != r5) goto L_0x013d
        L_0x0137:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.k r1 = e(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x013d:
            if (r9 != r6) goto L_0x0149
            java.lang.String r1 = a((int) r0, (int) r9, (int) r10, (int) r11, (int) r12)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.k r1 = c(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x0149:
            r5 = 73
            r6 = 80
            if (r9 != r6) goto L_0x015f
            r4 = 82
            if (r10 != r4) goto L_0x015f
            if (r11 != r5) goto L_0x015f
            r4 = 86
            if (r12 != r4) goto L_0x015f
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i r1 = c(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x015f:
            r4 = 71
            if (r9 != r4) goto L_0x0175
            r4 = 69
            if (r10 != r4) goto L_0x0175
            if (r11 != r1) goto L_0x0175
            r4 = 66
            if (r12 == r4) goto L_0x016f
            if (r0 != r3) goto L_0x0175
        L_0x016f:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.f r1 = b((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r7, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x0175:
            r4 = 65
            if (r0 != r3) goto L_0x0180
            if (r9 != r6) goto L_0x018d
            if (r10 != r5) goto L_0x018d
            if (r11 != r2) goto L_0x018d
            goto L_0x0188
        L_0x0180:
            if (r9 != r4) goto L_0x018d
            if (r10 != r6) goto L_0x018d
            if (r11 != r5) goto L_0x018d
            if (r12 != r2) goto L_0x018d
        L_0x0188:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.a r1 = a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r7, (int) r13, (int) r0)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x018d:
            if (r9 != r2) goto L_0x019e
            if (r10 != r1) goto L_0x019e
            r5 = 77
            if (r11 != r5) goto L_0x019e
            if (r12 == r5) goto L_0x0199
            if (r0 != r3) goto L_0x019e
        L_0x0199:
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e r1 = a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r7, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x019e:
            if (r9 != r2) goto L_0x01b8
            r3 = 72
            if (r10 != r3) goto L_0x01b8
            if (r11 != r4) goto L_0x01b8
            if (r12 != r6) goto L_0x01b8
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.c r1 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x01b8:
            if (r9 != r2) goto L_0x01d2
            r3 = 84
            if (r10 != r3) goto L_0x01d2
            if (r11 != r1) goto L_0x01d2
            if (r12 != r2) goto L_0x01d2
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.d r1 = b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            goto L_0x01da
        L_0x01d2:
            java.lang.String r1 = a((int) r0, (int) r9, (int) r10, (int) r11, (int) r12)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b r1 = a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r7, (int) r13, (java.lang.String) r1)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
        L_0x01da:
            if (r1 != 0) goto L_0x01f7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            r2.<init>(r8)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            java.lang.String r0 = a((int) r0, (int) r9, (int) r10, (int) r11, (int) r12)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            r2.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            java.lang.String r0 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x01fb }
            android.util.Log.w(r15, r0)     // Catch:{ UnsupportedEncodingException -> 0x01fb }
        L_0x01f7:
            r7.e(r14)
            return r1
        L_0x01fb:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r15, r0)     // Catch:{ all -> 0x0128 }
            r7.e(r14)
            r0 = 0
            return r0
        L_0x0205:
            r7.e(r14)
            throw r0
        L_0x0209:
            r0 = 0
            java.lang.String r1 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r15, r1)
            r7.e(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a(int, com.fyber.inneractive.sdk.player.exoplayer2.util.k, boolean, int, com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g$a):com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.h");
    }

    public static a a(k kVar, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int l = kVar.l();
        String b2 = b(l);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i4);
        kVar.b += i4;
        if (i2 == 2) {
            str = "image/" + new String(bArr, 0, 3, "ISO-8859-1").toLowerCase(Locale.US);
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = b(bArr, 0);
            String lowerCase = new String(bArr, 0, i3, "ISO-8859-1").toLowerCase(Locale.US);
            if (lowerCase.indexOf(47) == -1) {
                str = "image/" + lowerCase;
            } else {
                str = lowerCase;
            }
        }
        byte b3 = bArr[i3 + 1] & UByte.MAX_VALUE;
        int i5 = i3 + 2;
        int a2 = a(bArr, i5, l);
        return new a(str, new String(bArr, i5, a2 - i5, b2), b3, Arrays.copyOfRange(bArr, a2 + a(l), i4));
    }

    public static e a(k kVar, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int l = kVar.l();
        String b2 = b(l);
        byte[] bArr = new byte[3];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, 3);
        kVar.b += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(kVar.a, kVar.b, bArr2, 0, i2);
        kVar.b += i2;
        int a2 = a(bArr2, 0, l);
        String str2 = new String(bArr2, 0, a2, b2);
        int a3 = a2 + a(l);
        return new e(str, str2, a3 < i2 ? new String(bArr2, a3, a(bArr2, a3, l) - a3, b2) : "");
    }

    public static b a(k kVar, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, i);
        kVar.b += i;
        return new b(str, bArr);
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    public static int a(byte[] bArr, int i, int i2) {
        int b2 = b(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }
}
