package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzaq extends zzai {
    static final zzai zza = new zzaq((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.play_billing.zzaq zzf(int r17, java.lang.Object[] r18, com.google.android.gms.internal.play_billing.zzah r19) {
        /*
            r0 = r17
            r1 = r18
            if (r0 != 0) goto L_0x000b
            com.google.android.gms.internal.play_billing.zzai r0 = zza
            com.google.android.gms.internal.play_billing.zzaq r0 = (com.google.android.gms.internal.play_billing.zzaq) r0
            return r0
        L_0x000b:
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L_0x0023
            r0 = r1[r3]
            r0.getClass()
            r3 = r1[r4]
            r3.getClass()
            com.google.android.gms.internal.play_billing.zzaa.zza(r0, r3)
            com.google.android.gms.internal.play_billing.zzaq r0 = new com.google.android.gms.internal.play_billing.zzaq
            r0.<init>(r2, r1, r4)
            return r0
        L_0x0023:
            int r5 = r1.length
            int r5 = r5 >> r4
            java.lang.String r6 = "index"
            com.google.android.gms.internal.play_billing.zzx.zzb(r0, r5, r6)
            r5 = 2
            int r6 = java.lang.Math.max(r0, r5)
            r7 = 751619276(0x2ccccccc, float:5.8207657E-12)
            if (r6 >= r7) goto L_0x0049
            int r7 = r6 + -1
            int r7 = java.lang.Integer.highestOneBit(r7)
        L_0x003a:
            int r7 = r7 + r7
            double r8 = (double) r7
            r10 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r8 = r8 * r10
            double r10 = (double) r6
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x004d
            goto L_0x003a
        L_0x0049:
            r7 = 1073741824(0x40000000, float:2.0)
            if (r6 >= r7) goto L_0x01d1
        L_0x004d:
            if (r0 != r4) goto L_0x005f
            r0 = r1[r3]
            r0.getClass()
            r6 = r1[r4]
            r6.getClass()
            com.google.android.gms.internal.play_billing.zzaa.zza(r0, r6)
            r0 = 1
            goto L_0x01a7
        L_0x005f:
            int r6 = r7 + -1
            r8 = 128(0x80, float:1.794E-43)
            r9 = 3
            r10 = -1
            if (r7 > r8) goto L_0x00d4
            byte[] r7 = new byte[r7]
            java.util.Arrays.fill(r7, r10)
            r8 = 0
            r10 = 0
        L_0x006e:
            if (r8 >= r0) goto L_0x00bf
            int r11 = r10 + r10
            int r12 = r8 + r8
            r13 = r1[r12]
            r13.getClass()
            r12 = r12 ^ r4
            r12 = r1[r12]
            r12.getClass()
            com.google.android.gms.internal.play_billing.zzaa.zza(r13, r12)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.play_billing.zzab.zza(r14)
        L_0x008a:
            r14 = r14 & r6
            byte r15 = r7[r14]
            r5 = 255(0xff, float:3.57E-43)
            r15 = r15 & r5
            if (r15 != r5) goto L_0x00a0
            byte r5 = (byte) r11
            r7[r14] = r5
            if (r10 >= r8) goto L_0x009d
            r1[r11] = r13
            r5 = r11 ^ 1
            r1[r5] = r12
        L_0x009d:
            int r10 = r10 + 1
            goto L_0x00b7
        L_0x00a0:
            r5 = r1[r15]
            boolean r5 = r13.equals(r5)
            if (r5 == 0) goto L_0x00bb
            r2 = r15 ^ 1
            com.google.android.gms.internal.play_billing.zzag r5 = new com.google.android.gms.internal.play_billing.zzag
            r11 = r1[r2]
            r11.getClass()
            r5.<init>(r13, r12, r11)
            r1[r2] = r12
            r2 = r5
        L_0x00b7:
            int r8 = r8 + 1
            r5 = 2
            goto L_0x006e
        L_0x00bb:
            int r14 = r14 + 1
            r5 = 2
            goto L_0x008a
        L_0x00bf:
            if (r10 != r0) goto L_0x00c3
            r2 = r7
            goto L_0x00d1
        L_0x00c3:
            java.lang.Object[] r5 = new java.lang.Object[r9]
            r5[r3] = r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r5[r4] = r6
            r6 = 2
            r5[r6] = r2
        L_0x00d0:
            r2 = r5
        L_0x00d1:
            r5 = 2
            goto L_0x01a7
        L_0x00d4:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r7 > r5) goto L_0x0141
            short[] r5 = new short[r7]
            java.util.Arrays.fill(r5, r10)
            r7 = 0
            r8 = 0
        L_0x00e0:
            if (r7 >= r0) goto L_0x0130
            int r10 = r8 + r8
            int r11 = r7 + r7
            r12 = r1[r11]
            r12.getClass()
            r11 = r11 ^ r4
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.play_billing.zzaa.zza(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.play_billing.zzab.zza(r13)
        L_0x00fc:
            r13 = r13 & r6
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x0113
            short r14 = (short) r10
            r5[r13] = r14
            if (r8 >= r7) goto L_0x0110
            r1[r10] = r12
            r10 = r10 ^ 1
            r1[r10] = r11
        L_0x0110:
            int r8 = r8 + 1
            goto L_0x012a
        L_0x0113:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x012d
            r2 = r14 ^ 1
            com.google.android.gms.internal.play_billing.zzag r10 = new com.google.android.gms.internal.play_billing.zzag
            r13 = r1[r2]
            r13.getClass()
            r10.<init>(r12, r11, r13)
            r1[r2] = r11
            r2 = r10
        L_0x012a:
            int r7 = r7 + 1
            goto L_0x00e0
        L_0x012d:
            int r13 = r13 + 1
            goto L_0x00fc
        L_0x0130:
            if (r8 != r0) goto L_0x0133
            goto L_0x0197
        L_0x0133:
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r6[r4] = r5
            r5 = 2
            r6[r5] = r2
            goto L_0x01a6
        L_0x0141:
            int[] r5 = new int[r7]
            java.util.Arrays.fill(r5, r10)
            r7 = 0
            r8 = 0
        L_0x0148:
            if (r7 >= r0) goto L_0x0195
            int r11 = r8 + r8
            int r12 = r7 + r7
            r13 = r1[r12]
            r13.getClass()
            r12 = r12 ^ r4
            r12 = r1[r12]
            r12.getClass()
            com.google.android.gms.internal.play_billing.zzaa.zza(r13, r12)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.play_billing.zzab.zza(r14)
        L_0x0164:
            r14 = r14 & r6
            r15 = r5[r14]
            if (r15 != r10) goto L_0x0176
            r5[r14] = r11
            if (r8 >= r7) goto L_0x0173
            r1[r11] = r13
            r11 = r11 ^ 1
            r1[r11] = r12
        L_0x0173:
            int r8 = r8 + 1
            goto L_0x018d
        L_0x0176:
            r10 = r1[r15]
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x0191
            r2 = r15 ^ 1
            com.google.android.gms.internal.play_billing.zzag r10 = new com.google.android.gms.internal.play_billing.zzag
            r11 = r1[r2]
            r11.getClass()
            r10.<init>(r13, r12, r11)
            r1[r2] = r12
            r2 = r10
        L_0x018d:
            int r7 = r7 + 1
            r10 = -1
            goto L_0x0148
        L_0x0191:
            int r14 = r14 + 1
            r10 = -1
            goto L_0x0164
        L_0x0195:
            if (r8 != r0) goto L_0x0199
        L_0x0197:
            goto L_0x00d0
        L_0x0199:
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r6[r4] = r5
            r5 = 2
            r6[r5] = r2
        L_0x01a6:
            r2 = r6
        L_0x01a7:
            boolean r6 = r2 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01cb
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r0 = r2[r5]
            com.google.android.gms.internal.play_billing.zzag r0 = (com.google.android.gms.internal.play_billing.zzag) r0
            r5 = r19
            r5.zzc = r0
            r0 = r2[r3]
            r2 = r2[r4]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r16 = r2
            r2 = r0
            r0 = r16
        L_0x01cb:
            com.google.android.gms.internal.play_billing.zzaq r3 = new com.google.android.gms.internal.play_billing.zzaq
            r3.<init>(r2, r1, r0)
            return r3
        L_0x01d1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "collection too large"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzaq.zzf(int, java.lang.Object[], com.google.android.gms.internal.play_billing.zzah):com.google.android.gms.internal.play_billing.zzaq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0006
        L_0x0003:
            r10 = r0
            goto L_0x009c
        L_0x0006:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L_0x0020
            r1 = 0
            r1 = r2[r1]
            r1.getClass()
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x0003
            r10 = r2[r3]
            r10.getClass()
            goto L_0x009c
        L_0x0020:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L_0x0025
            goto L_0x0003
        L_0x0025:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L_0x0051
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzab.zza(r1)
        L_0x0038:
            r1 = r1 & r6
            byte r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0003
        L_0x0041:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009c
        L_0x004e:
            int r1 = r1 + 1
            goto L_0x0038
        L_0x0051:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L_0x007d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzab.zza(r1)
        L_0x0063:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0003
        L_0x006d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009c
        L_0x007a:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x007d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzab.zza(r6)
        L_0x0089:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0003
        L_0x0090:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r0
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzaq.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzac zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzaj zzc() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzaj zzd() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
