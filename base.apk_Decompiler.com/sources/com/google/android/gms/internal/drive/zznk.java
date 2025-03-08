package com.google.android.gms.internal.drive;

final class zznk extends zznh {
    zznk() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c1, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
            r17 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r6 = 0
            if (r3 < 0) goto L_0x00c2
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r2 = (int) r1
            r1 = 16
            r9 = 1
            if (r2 >= r1) goto L_0x001b
            r1 = 0
            goto L_0x002d
        L_0x001b:
            r11 = r7
            r1 = 0
        L_0x001d:
            if (r1 >= r2) goto L_0x002c
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.drive.zznd.zza(r0, r11)
            if (r3 >= 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            int r1 = r1 + 1
            r11 = r13
            goto L_0x001d
        L_0x002c:
            r1 = r2
        L_0x002d:
            int r2 = r2 - r1
            long r11 = (long) r1
            long r7 = r7 + r11
        L_0x0030:
            r1 = 0
        L_0x0031:
            if (r2 <= 0) goto L_0x0040
            long r11 = r7 + r9
            byte r1 = com.google.android.gms.internal.drive.zznd.zza(r0, r7)
            if (r1 < 0) goto L_0x003f
            int r2 = r2 + -1
            r7 = r11
            goto L_0x0031
        L_0x003f:
            r7 = r11
        L_0x0040:
            if (r2 != 0) goto L_0x0043
            return r6
        L_0x0043:
            int r3 = r2 + -1
            r11 = -32
            r12 = -1
            r13 = -65
            if (r1 >= r11) goto L_0x0061
            if (r3 != 0) goto L_0x004f
            return r1
        L_0x004f:
            int r2 = r2 + -2
            r3 = -62
            if (r1 < r3) goto L_0x0060
            long r14 = r7 + r9
            byte r1 = com.google.android.gms.internal.drive.zznd.zza(r0, r7)
            if (r1 <= r13) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r7 = r14
            goto L_0x00bc
        L_0x0060:
            return r12
        L_0x0061:
            r14 = -16
            r15 = 2
            if (r1 >= r14) goto L_0x008f
            if (r3 >= r4) goto L_0x006e
            int r0 = zza(r0, r1, r7, r3)
            return r0
        L_0x006e:
            int r2 = r2 + -3
            long r4 = r7 + r9
            byte r3 = com.google.android.gms.internal.drive.zznd.zza(r0, r7)
            if (r3 > r13) goto L_0x008e
            r14 = -96
            if (r1 != r11) goto L_0x007e
            if (r3 < r14) goto L_0x008e
        L_0x007e:
            r11 = -19
            if (r1 != r11) goto L_0x0084
            if (r3 >= r14) goto L_0x008e
        L_0x0084:
            long r7 = r7 + r15
            byte r1 = com.google.android.gms.internal.drive.zznd.zza(r0, r4)
            if (r1 <= r13) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r4 = 2
            goto L_0x0030
        L_0x008e:
            return r12
        L_0x008f:
            r4 = 3
            if (r3 >= r4) goto L_0x0097
            int r0 = zza(r0, r1, r7, r3)
            return r0
        L_0x0097:
            int r2 = r2 + -4
            long r3 = r7 + r9
            byte r5 = com.google.android.gms.internal.drive.zznd.zza(r0, r7)
            if (r5 > r13) goto L_0x00c1
            int r1 = r1 << 28
            int r5 = r5 + 112
            int r1 = r1 + r5
            int r1 = r1 >> 30
            if (r1 != 0) goto L_0x00c1
            long r9 = r7 + r15
            byte r1 = com.google.android.gms.internal.drive.zznd.zza(r0, r3)
            if (r1 > r13) goto L_0x00c1
            r3 = 3
            long r7 = r7 + r3
            byte r1 = com.google.android.gms.internal.drive.zznd.zza(r0, r9)
            if (r1 <= r13) goto L_0x00bc
            goto L_0x00c1
        L_0x00bc:
            r4 = 2
            r9 = 1
            goto L_0x0030
        L_0x00c1:
            return r12
        L_0x00c2:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r1 = 1
            r4[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            r1 = 2
            r4[r1] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r4)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zznk.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzg(byte[] bArr, int i, int i2) throws zzkq {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r11 < i3) {
                byte zza = zznd.zza(bArr, (long) r11);
                if (!zzng.zzd(zza)) {
                    break;
                }
                i = r11 + 1;
                zzng.zza(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r11 < i3) {
                int i6 = r11 + 1;
                byte zza2 = zznd.zza(bArr, (long) r11);
                if (zzng.zzd(zza2)) {
                    int i7 = i5 + 1;
                    zzng.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zznd.zza(bArr, (long) i6);
                        if (!zzng.zzd(zza3)) {
                            break;
                        }
                        i6++;
                        zzng.zza(zza3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    r11 = i6;
                } else if (zzng.zze(zza2)) {
                    if (i6 < i3) {
                        r11 += 2;
                        zzng.zza(zza2, zznd.zza(bArr, (long) i6), cArr, i5);
                        i5++;
                    } else {
                        throw zzkq.zzdn();
                    }
                } else if (zzng.zzf(zza2)) {
                    if (i6 < i3 - 1) {
                        int i8 = r11 + 2;
                        r11 += 3;
                        zzng.zza(zza2, zznd.zza(bArr, (long) i6), zznd.zza(bArr, (long) i8), cArr, i5);
                        i5++;
                    } else {
                        throw zzkq.zzdn();
                    }
                } else if (i6 < i3 - 2) {
                    byte zza4 = zznd.zza(bArr, (long) i6);
                    int i9 = r11 + 3;
                    r11 += 4;
                    zzng.zza(zza2, zza4, zznd.zza(bArr, (long) (r11 + 2)), zznd.zza(bArr, (long) i9), cArr, i5);
                    i5 += 2;
                } else {
                    throw zzkq.zzdn();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00f8, LOOP_START, PHI: r2 r4 r6 r9 r10 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v3 long) = (r6v1 long), (r6v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v1 java.lang.String) = (r10v0 java.lang.String), (r10v2 java.lang.String) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.CharSequence r25, byte[] r26, int r27, int r28) {
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
            if (r8 > r3) goto L_0x0146
            int r11 = r1.length
            int r11 = r11 - r3
            if (r11 < r2) goto L_0x0146
            r2 = 0
        L_0x001a:
            r11 = 1
            r3 = 128(0x80, float:1.794E-43)
            if (r2 >= r8) goto L_0x002f
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x002f
            long r11 = r11 + r4
            byte r3 = (byte) r13
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r4, (byte) r3)
            int r2 = r2 + 1
            r4 = r11
            goto L_0x001a
        L_0x002f:
            if (r2 != r8) goto L_0x0033
            int r0 = (int) r4
            return r0
        L_0x0033:
            if (r2 >= r8) goto L_0x0144
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x004f
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x004f
            long r14 = r4 + r11
            byte r13 = (byte) r13
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r4, (byte) r13)
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
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r4, (byte) r11)
            long r4 = r4 + r15
            r11 = r13 & 63
            r11 = r11 | r3
            byte r11 = (byte) r11
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r9, (byte) r11)
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
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r4, (byte) r11)
            long r11 = r4 + r15
            int r15 = r13 >>> 6
            r15 = r15 & 63
            r15 = r15 | r3
            byte r15 = (byte) r15
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r9, (byte) r15)
            r9 = 3
            long r4 = r4 + r9
            r9 = r13 & 63
            r9 = r9 | r3
            byte r9 = (byte) r9
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r11, (byte) r9)
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
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r4, (byte) r10)
            r22 = r6
            long r6 = r4 + r15
            int r10 = r2 >>> 12
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r11, (byte) r10)
            r10 = 3
            long r11 = r4 + r10
            int r10 = r2 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r6, (byte) r10)
            r6 = 4
            long r4 = r4 + r6
            r2 = r2 & 63
            r2 = r2 | r3
            byte r2 = (byte) r2
            com.google.android.gms.internal.drive.zznd.zza((byte[]) r1, (long) r11, (byte) r2)
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
            com.google.android.gms.internal.drive.zznj r0 = new com.google.android.gms.internal.drive.zznj
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
            com.google.android.gms.internal.drive.zznj r0 = new com.google.android.gms.internal.drive.zznj
            r0.<init>(r2, r8)
            throw r0
        L_0x0124:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 46
            r1.<init>(r2)
            r6 = r17
            r1.append(r6)
            r1.append(r13)
            r7 = r14
            r1.append(r7)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r0 = (int) r4
            return r0
        L_0x0146:
            r7 = r9
            r6 = r10
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 37
            r3.<init>(r4)
            r3.append(r6)
            r3.append(r0)
            r3.append(r7)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zznk.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zznf.zzay(i);
        }
        if (i2 == 1) {
            return zznf.zzr(i, zznd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zznf.zzc(i, zznd.zza(bArr, j), zznd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
