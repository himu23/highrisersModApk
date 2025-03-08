package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i, int i2, zzgc zzgc, int i3, boolean z, int[] iArr2, int i4, int i5, zzgh zzgh, zzfq zzfq, zzhd zzhd, zzek zzek, zzfx zzfx) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzek != null && zzek.zzc(zzgc)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzgh;
        this.zzl = zzfq;
        this.zzm = zzhd;
        this.zzn = zzek;
        this.zzg = zzgc;
        this.zzp = zzfx;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzs = (long) (zzs(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgm zzv = zzv(i);
                if (!zzI(obj, i)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        Object zze2 = zzv.zze();
                        zzv.zzg(zze2, object);
                        unsafe.putObject(obj, zzs, zze2);
                    }
                    zzD(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    Object zze3 = zzv.zze();
                    zzv.zzg(zze3, object2);
                    unsafe.putObject(obj, zzs, zze3);
                    object2 = zze3;
                }
                zzv.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzs = (long) (zzs(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgm zzv = zzv(i);
                if (!zzM(obj, i2, i)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        Object zze2 = zzv.zze();
                        zzv.zzg(zze2, object);
                        unsafe.putObject(obj, zzs, zze2);
                    }
                    zzE(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    Object zze3 = zzv.zze();
                    zzv.zzg(zze3, object2);
                    unsafe.putObject(obj, zzs, zze3);
                    object2 = zze3;
                }
                zzv.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp2 = zzp(i);
        long j = (long) (1048575 & zzp2);
        if (j != 1048575) {
            zzhn.zzq(obj, j, (1 << (zzp2 >>> 20)) | zzhn.zzc(obj, j));
        }
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhn.zzq(obj, (long) (zzp(i2) & 1048575), i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzs(i) & 1048575), obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzs(i2) & 1048575), obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp2 = zzp(i);
        long j = (long) (zzp2 & 1048575);
        if (j == 1048575) {
            int zzs = zzs(i);
            long j2 = (long) (zzs & 1048575);
            switch (zzr(zzs)) {
                case 0:
                    return Double.doubleToRawLongBits(zzhn.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzhn.zzb(obj, j2)) != 0;
                case 2:
                    return zzhn.zzd(obj, j2) != 0;
                case 3:
                    return zzhn.zzd(obj, j2) != 0;
                case 4:
                    return zzhn.zzc(obj, j2) != 0;
                case 5:
                    return zzhn.zzd(obj, j2) != 0;
                case 6:
                    return zzhn.zzc(obj, j2) != 0;
                case 7:
                    return zzhn.zzw(obj, j2);
                case 8:
                    Object zzf2 = zzhn.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdw) {
                        return !zzdw.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhn.zzf(obj, j2) != null;
                case 10:
                    return !zzdw.zzb.equals(zzhn.zzf(obj, j2));
                case 11:
                    return zzhn.zzc(obj, j2) != 0;
                case 12:
                    return zzhn.zzc(obj, j2) != 0;
                case 13:
                    return zzhn.zzc(obj, j2) != 0;
                case 14:
                    return zzhn.zzd(obj, j2) != 0;
                case 15:
                    return zzhn.zzc(obj, j2) != 0;
                case 16:
                    return zzhn.zzd(obj, j2) != 0;
                case 17:
                    return zzhn.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzhn.zzc(obj, j) & (1 << (zzp2 >>> 20))) != 0;
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgm zzgm) {
        return zzgm.zzk(zzhn.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzhn.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzhn.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhv zzhv) throws IOException {
        if (obj instanceof String) {
            zzhv.zzF(i, (String) obj);
        } else {
            zzhv.zzd(i, (zzdw) obj);
        }
    }

    static zzhe zzd(Object obj) {
        zzex zzex = (zzex) obj;
        zzhe zzhe = zzex.zzc;
        if (zzhe != zzhe.zzc()) {
            return zzhe;
        }
        zzhe zzf2 = zzhe.zzf();
        zzex.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0281  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.play_billing.zzgf zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzfz r34, com.google.android.gms.internal.play_billing.zzgh r35, com.google.android.gms.internal.play_billing.zzfq r36, com.google.android.gms.internal.play_billing.zzhd r37, com.google.android.gms.internal.play_billing.zzek r38, com.google.android.gms.internal.play_billing.zzfx r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.zzgl
            if (r1 == 0) goto L_0x0401
            com.google.android.gms.internal.play_billing.zzgl r0 = (com.google.android.gms.internal.play_billing.zzgl) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = zza
            r17 = r7
            r7 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            goto L_0x0166
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0166:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.play_billing.zzgc r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r22 = r18
            r23 = r19
            r20 = 0
            r21 = 0
        L_0x0186:
            if (r4 >= r2) goto L_0x03da
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01ae
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0196:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0196
        L_0x01a8:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b0
        L_0x01ae:
            r3 = r24
        L_0x01b0:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01be:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01be
        L_0x01d0:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d8
        L_0x01d6:
            r8 = r24
        L_0x01d8:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e2
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e2:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = r3 & 2048(0x800, float:2.87E-42)
            r26 = r2
            r2 = 51
            if (r6 < r2) goto L_0x029b
            int r2 = r8 + 1
            char r8 = r1.charAt(r8)
            r27 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0220
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
            r32 = r27
            r27 = r8
            r8 = r32
        L_0x0203:
            int r31 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r2) goto L_0x0219
            r2 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r30
            r27 = r27 | r2
            int r30 = r30 + 13
            r8 = r31
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0203
        L_0x0219:
            int r2 = r8 << r30
            r8 = r27 | r2
            r2 = r31
            goto L_0x0222
        L_0x0220:
            r2 = r27
        L_0x0222:
            r27 = r2
            int r2 = r6 + -51
            r30 = r14
            r14 = 9
            if (r2 == r14) goto L_0x024e
            r14 = 17
            if (r2 != r14) goto L_0x0231
            goto L_0x024e
        L_0x0231:
            r14 = 12
            if (r2 != r14) goto L_0x025d
            int r2 = r0.zzc()
            r14 = 1
            if (r2 == r14) goto L_0x0241
            if (r5 == 0) goto L_0x023f
            goto L_0x0241
        L_0x023f:
            r5 = 0
            goto L_0x025d
        L_0x0241:
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r16 = r10[r16]
            r12[r24] = r16
            goto L_0x025b
        L_0x024e:
            r14 = 1
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r28 = r24 + 1
            r14 = r10[r16]
            r12[r28] = r14
        L_0x025b:
            r16 = r2
        L_0x025d:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r14 = r2 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0267
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x026f
        L_0x0267:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzz(r15, r2)
            r10[r8] = r2
        L_0x026f:
            r31 = r13
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0281
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x0289
        L_0x0281:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzz(r15, r13)
            r10[r8] = r13
        L_0x0289:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r28 = r0
            r29 = r1
            r0 = r16
            r25 = r27
            r16 = r8
            r8 = 0
            goto L_0x039a
        L_0x029b:
            r31 = r13
            r30 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzz(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x031e
            r14 = 17
            if (r6 != r14) goto L_0x02b3
            goto L_0x031e
        L_0x02b3:
            r14 = 27
            if (r6 == r14) goto L_0x030e
            r14 = 49
            if (r6 != r14) goto L_0x02c1
            int r16 = r16 + 2
            r28 = r0
            r0 = 1
            goto L_0x0313
        L_0x02c1:
            r14 = 12
            if (r6 == r14) goto L_0x02f5
            r14 = 30
            if (r6 == r14) goto L_0x02f5
            r14 = 44
            if (r6 != r14) goto L_0x02ce
            goto L_0x02f5
        L_0x02ce:
            r14 = 50
            if (r6 != r14) goto L_0x02f1
            int r14 = r16 + 2
            int r28 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            if (r5 == 0) goto L_0x02ed
            int r22 = r22 + 1
            int r2 = r16 + 3
            r14 = r10[r14]
            r12[r22] = r14
            r22 = r28
            goto L_0x02f1
        L_0x02ed:
            r2 = r14
            r22 = r28
            r5 = 0
        L_0x02f1:
            r28 = r0
            r0 = 1
            goto L_0x032b
        L_0x02f5:
            int r14 = r0.zzc()
            r28 = r0
            r0 = 1
            if (r14 == r0) goto L_0x0303
            if (r5 == 0) goto L_0x0301
            goto L_0x0303
        L_0x0301:
            r5 = 0
            goto L_0x032b
        L_0x0303:
            int r16 = r16 + 2
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r0
            r2 = r10[r2]
            r12[r14] = r2
            goto L_0x031b
        L_0x030e:
            r28 = r0
            r0 = 1
            int r16 = r16 + 2
        L_0x0313:
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r0
            r2 = r10[r2]
            r12[r14] = r2
        L_0x031b:
            r2 = r16
            goto L_0x032b
        L_0x031e:
            r28 = r0
            r0 = 1
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r0
            java.lang.Class r16 = r13.getType()
            r12[r14] = r16
        L_0x032b:
            long r13 = r9.objectFieldOffset(r13)
            int r14 = (int) r13
            r13 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r13 == 0) goto L_0x0385
            r13 = 17
            if (r6 > r13) goto L_0x0385
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r0) goto L_0x0360
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x034a:
            int r25 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r0) goto L_0x035c
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r16
            r8 = r8 | r13
            int r16 = r16 + 13
            r13 = r25
            goto L_0x034a
        L_0x035c:
            int r13 = r13 << r16
            r8 = r8 | r13
            goto L_0x0362
        L_0x0360:
            r25 = r13
        L_0x0362:
            int r13 = r7 + r7
            int r16 = r8 / 32
            int r13 = r13 + r16
            r0 = r10[r13]
            r29 = r1
            boolean r1 = r0 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0373
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x037b
        L_0x0373:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zzz(r15, r0)
            r10[r13] = r0
        L_0x037b:
            long r0 = r9.objectFieldOffset(r0)
            int r1 = (int) r0
            int r8 = r8 % 32
            r16 = r1
            goto L_0x038a
        L_0x0385:
            r29 = r1
            r25 = r8
            r8 = 0
        L_0x038a:
            r0 = 18
            if (r6 < r0) goto L_0x0398
            r0 = 49
            if (r6 > r0) goto L_0x0398
            int r0 = r23 + 1
            r17[r23] = r14
            r23 = r0
        L_0x0398:
            r0 = r2
            r2 = r14
        L_0x039a:
            int r1 = r21 + 1
            r11[r21] = r4
            int r4 = r21 + 2
            r13 = r3 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x03a7
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a8
        L_0x03a7:
            r13 = 0
        L_0x03a8:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03af
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b0
        L_0x03af:
            r3 = 0
        L_0x03b0:
            if (r5 == 0) goto L_0x03b5
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b6
        L_0x03b5:
            r5 = 0
        L_0x03b6:
            int r6 = r6 << 20
            r3 = r3 | r13
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r1] = r2
            int r21 = r21 + 3
            int r1 = r8 << 20
            r1 = r1 | r16
            r11[r4] = r1
            r16 = r0
            r4 = r25
            r2 = r26
            r0 = r28
            r1 = r29
            r14 = r30
            r13 = r31
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0186
        L_0x03da:
            r28 = r0
            r31 = r13
            r30 = r14
            com.google.android.gms.internal.play_billing.zzgf r0 = new com.google.android.gms.internal.play_billing.zzgf
            com.google.android.gms.internal.play_billing.zzgc r14 = r28.zza()
            int r15 = r28.zzc()
            r16 = 0
            r9 = r0
            r10 = r11
            r11 = r12
            r12 = r31
            r13 = r30
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r24 = r39
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        L_0x0401:
            com.google.android.gms.internal.play_billing.zzha r0 = (com.google.android.gms.internal.play_billing.zzha) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzfz, com.google.android.gms.internal.play_billing.zzgh, com.google.android.gms.internal.play_billing.zzfq, com.google.android.gms.internal.play_billing.zzhd, com.google.android.gms.internal.play_billing.zzek, com.google.android.gms.internal.play_billing.zzfx):com.google.android.gms.internal.play_billing.zzgf");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzhn.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzhn.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzhn.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzhn.zzf(obj, j)).longValue();
    }

    private final zzfb zzu(int i) {
        int i2 = i / 3;
        return (zzfb) this.zzd[i2 + i2 + 1];
    }

    private final zzgm zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgm zzgm = (zzgm) objArr[i3];
        if (zzgm != null) {
            return zzgm;
        }
        zzgm zzb2 = zzgk.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgm zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, (long) zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze2 = zzv.zze();
        if (object != null) {
            zzv.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgm zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzs(i2) & 1048575));
        if (zzL(object)) {
            return object;
        }
        Object zze2 = zzv.zze();
        if (object != null) {
            zzv.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037e, code lost:
        r1 = (r1 + r2) + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0380, code lost:
        r12 = r12 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x039e, code lost:
        r1 = r1 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0558, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x056b, code lost:
        r12 = r12 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0675, code lost:
        r0 = r0 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x06dd, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0761, code lost:
        r0 = r0 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0777, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x078e, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0792, code lost:
        r11 = r11 + 3;
        r0 = r13;
        r1 = r15;
        r9 = false;
        r10 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            sun.misc.Unsafe r8 = zzb
            r9 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 0
            r11 = 0
            r12 = 0
        L_0x0010:
            int[] r2 = r6.zzc
            int r2 = r2.length
            r3 = 0
            if (r11 >= r2) goto L_0x079c
            int r2 = r6.zzs(r11)
            int r4 = zzr(r2)
            int[] r5 = r6.zzc
            int r13 = r11 + 2
            r14 = r5[r11]
            r5 = r5[r13]
            r13 = r5 & r10
            r15 = 17
            r16 = 1
            if (r4 > r15) goto L_0x0042
            if (r13 == r0) goto L_0x003b
            if (r13 != r10) goto L_0x0034
            r0 = 0
            goto L_0x0039
        L_0x0034:
            long r0 = (long) r13
            int r0 = r8.getInt(r7, r0)
        L_0x0039:
            r1 = r0
            r0 = r13
        L_0x003b:
            int r5 = r5 >>> 20
            int r5 = r16 << r5
            r13 = r0
            r15 = r1
            goto L_0x0045
        L_0x0042:
            r13 = r0
            r15 = r1
            r5 = 0
        L_0x0045:
            r0 = r2 & r10
            com.google.android.gms.internal.play_billing.zzep r1 = com.google.android.gms.internal.play_billing.zzep.DOUBLE_LIST_PACKED
            int r1 = r1.zza()
            if (r4 < r1) goto L_0x0054
            com.google.android.gms.internal.play_billing.zzep r1 = com.google.android.gms.internal.play_billing.zzep.SINT64_LIST_PACKED
            r1.zza()
        L_0x0054:
            long r1 = (long) r0
            r17 = 63
            switch(r4) {
                case 0: goto L_0x077b;
                case 1: goto L_0x0764;
                case 2: goto L_0x0745;
                case 3: goto L_0x0728;
                case 4: goto L_0x070b;
                case 5: goto L_0x06f6;
                case 6: goto L_0x06e1;
                case 7: goto L_0x06ca;
                case 8: goto L_0x0694;
                case 9: goto L_0x0678;
                case 10: goto L_0x0650;
                case 11: goto L_0x0632;
                case 12: goto L_0x0614;
                case 13: goto L_0x05ff;
                case 14: goto L_0x05ea;
                case 15: goto L_0x05c7;
                case 16: goto L_0x05a4;
                case 17: goto L_0x0586;
                case 18: goto L_0x0579;
                case 19: goto L_0x056e;
                case 20: goto L_0x054a;
                case 21: goto L_0x052e;
                case 22: goto L_0x0512;
                case 23: goto L_0x0506;
                case 24: goto L_0x04fa;
                case 25: goto L_0x04de;
                case 26: goto L_0x047c;
                case 27: goto L_0x043b;
                case 28: goto L_0x0408;
                case 29: goto L_0x03ee;
                case 30: goto L_0x03d4;
                case 31: goto L_0x03c8;
                case 32: goto L_0x03bc;
                case 33: goto L_0x03a2;
                case 34: goto L_0x0383;
                case 35: goto L_0x0368;
                case 36: goto L_0x0351;
                case 37: goto L_0x033a;
                case 38: goto L_0x0323;
                case 39: goto L_0x030c;
                case 40: goto L_0x02f4;
                case 41: goto L_0x02dc;
                case 42: goto L_0x02c2;
                case 43: goto L_0x02aa;
                case 44: goto L_0x0292;
                case 45: goto L_0x027a;
                case 46: goto L_0x0262;
                case 47: goto L_0x024a;
                case 48: goto L_0x0232;
                case 49: goto L_0x0209;
                case 50: goto L_0x01da;
                case 51: goto L_0x01cc;
                case 52: goto L_0x01be;
                case 53: goto L_0x01a8;
                case 54: goto L_0x0192;
                case 55: goto L_0x017c;
                case 56: goto L_0x016e;
                case 57: goto L_0x0160;
                case 58: goto L_0x0152;
                case 59: goto L_0x0123;
                case 60: goto L_0x010f;
                case 61: goto L_0x00f0;
                case 62: goto L_0x00da;
                case 63: goto L_0x00c4;
                case 64: goto L_0x00b6;
                case 65: goto L_0x00a8;
                case 66: goto L_0x008d;
                case 67: goto L_0x0072;
                case 68: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x0792
        L_0x005c:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzgc r0 = (com.google.android.gms.internal.play_billing.zzgc) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r0, r1)
            goto L_0x0583
        L_0x0072:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            goto L_0x0761
        L_0x008d:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x0761
        L_0x00a8:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x078e
        L_0x00b6:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0777
        L_0x00c4:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x00da:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x00f0:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0675
        L_0x010f:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzh(r14, r0, r1)
            goto L_0x0583
        L_0x0123:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r2 == 0) goto L_0x0146
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0675
        L_0x0146:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzw(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0152:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x06dd
        L_0x0160:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0777
        L_0x016e:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x078e
        L_0x017c:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0192:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x01a8:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x01be:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0777
        L_0x01cc:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x078e
        L_0x01da:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.lang.Object r1 = r6.zzw(r11)
            com.google.android.gms.internal.play_billing.zzfw r0 = (com.google.android.gms.internal.play_billing.zzfw) r0
            com.google.android.gms.internal.play_billing.zzfv r1 = (com.google.android.gms.internal.play_billing.zzfv) r1
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0792
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x01fc
            goto L_0x0792
        L_0x01fc:
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r0.getKey()
            r0.getValue()
            throw r3
        L_0x0209:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x021d
            r4 = 0
            goto L_0x022f
        L_0x021d:
            r3 = 0
            r4 = 0
        L_0x021f:
            if (r3 >= r2) goto L_0x022f
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.play_billing.zzgc r5 = (com.google.android.gms.internal.play_billing.zzgc) r5
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r5, r1)
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x021f
        L_0x022f:
            int r12 = r12 + r4
            goto L_0x0792
        L_0x0232:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzj(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x024a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzi(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x0262:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x027a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x0292:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zza(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x02aa:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzk(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x02c2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x02dc:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x02f4:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x030c:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzf(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x0323:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzl(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x033a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzg(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x0351:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037e
        L_0x0368:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x0792
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
        L_0x037e:
            int r1 = r1 + r2
            int r1 = r1 + r0
        L_0x0380:
            int r12 = r12 + r1
            goto L_0x0792
        L_0x0383:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0394
        L_0x0391:
            r0 = 0
            goto L_0x0583
        L_0x0394:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzj(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
        L_0x039e:
            int r1 = r1 * r2
            goto L_0x0761
        L_0x03a2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03b1
            goto L_0x0391
        L_0x03b1:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzi(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039e
        L_0x03bc:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r9)
            goto L_0x0583
        L_0x03c8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r9)
            goto L_0x0583
        L_0x03d4:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03e3
            goto L_0x0391
        L_0x03e3:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zza(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039e
        L_0x03ee:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03fd
            goto L_0x0391
        L_0x03fd:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzk(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039e
        L_0x0408:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0419
            r1 = 0
            goto L_0x0380
        L_0x0419:
            int r2 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            int r1 = r1 * r2
            r2 = 0
        L_0x0422:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0380
            java.lang.Object r3 = r0.get(r2)
            com.google.android.gms.internal.play_billing.zzdw r3 = (com.google.android.gms.internal.play_billing.zzdw) r3
            int r3 = r3.zzd()
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzx(r3)
            int r4 = r4 + r3
            int r1 = r1 + r4
            int r2 = r2 + 1
            goto L_0x0422
        L_0x043b:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x044f
            r3 = 0
            goto L_0x0479
        L_0x044f:
            int r3 = r14 << 3
            int r3 = com.google.android.gms.internal.play_billing.zzee.zzx(r3)
            int r3 = r3 * r2
            r4 = 0
        L_0x0458:
            if (r4 >= r2) goto L_0x0479
            java.lang.Object r5 = r0.get(r4)
            boolean r14 = r5 instanceof com.google.android.gms.internal.play_billing.zzfi
            if (r14 == 0) goto L_0x046f
            com.google.android.gms.internal.play_billing.zzfi r5 = (com.google.android.gms.internal.play_billing.zzfi) r5
            int r5 = r5.zza()
            int r14 = com.google.android.gms.internal.play_billing.zzee.zzx(r5)
            int r14 = r14 + r5
            int r3 = r3 + r14
            goto L_0x0476
        L_0x046f:
            com.google.android.gms.internal.play_billing.zzgc r5 = (com.google.android.gms.internal.play_billing.zzgc) r5
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzv(r5, r1)
            int r3 = r3 + r5
        L_0x0476:
            int r4 = r4 + 1
            goto L_0x0458
        L_0x0479:
            int r12 = r12 + r3
            goto L_0x0792
        L_0x047c:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x048c
            goto L_0x0558
        L_0x048c:
            int r2 = r14 << 3
            boolean r3 = r0 instanceof com.google.android.gms.internal.play_billing.zzfk
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            int r2 = r2 * r1
            if (r3 == 0) goto L_0x04bc
            com.google.android.gms.internal.play_billing.zzfk r0 = (com.google.android.gms.internal.play_billing.zzfk) r0
            r3 = 0
        L_0x049b:
            if (r3 >= r1) goto L_0x056b
            java.lang.Object r4 = r0.zzf(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r5 == 0) goto L_0x04b2
            com.google.android.gms.internal.play_billing.zzdw r4 = (com.google.android.gms.internal.play_billing.zzdw) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzx(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04b9
        L_0x04b2:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzw(r4)
            int r2 = r2 + r4
        L_0x04b9:
            int r3 = r3 + 1
            goto L_0x049b
        L_0x04bc:
            r3 = 0
        L_0x04bd:
            if (r3 >= r1) goto L_0x056b
            java.lang.Object r4 = r0.get(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r5 == 0) goto L_0x04d4
            com.google.android.gms.internal.play_billing.zzdw r4 = (com.google.android.gms.internal.play_billing.zzdw) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzx(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04db
        L_0x04d4:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzw(r4)
            int r2 = r2 + r4
        L_0x04db:
            int r3 = r3 + 1
            goto L_0x04bd
        L_0x04de:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r0 = r0.size()
            if (r0 != 0) goto L_0x04ee
            goto L_0x0391
        L_0x04ee:
            int r1 = r14 << 3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r1 = r1 + 1
            int r0 = r0 * r1
            goto L_0x0583
        L_0x04fa:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r9)
            goto L_0x0583
        L_0x0506:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r9)
            goto L_0x0583
        L_0x0512:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0522
            goto L_0x0391
        L_0x0522:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzf(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039e
        L_0x052e:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x053e
            goto L_0x0391
        L_0x053e:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzl(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039e
        L_0x054a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x055a
        L_0x0558:
            r2 = 0
            goto L_0x056b
        L_0x055a:
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zzg(r0)
            int r0 = r0.size()
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = r0 * r1
            int r2 = r2 + r0
        L_0x056b:
            int r12 = r12 + r2
            goto L_0x0792
        L_0x056e:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r9)
            goto L_0x0583
        L_0x0579:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r9)
        L_0x0583:
            int r12 = r12 + r0
            goto L_0x0792
        L_0x0586:
            r0 = r18
            r3 = r1
            r1 = r19
            r2 = r11
            r9 = r3
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzgc r0 = (com.google.android.gms.internal.play_billing.zzgc) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r0, r1)
            goto L_0x0583
        L_0x05a4:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            goto L_0x0761
        L_0x05c7:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x0761
        L_0x05ea:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x078e
        L_0x05ff:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0777
        L_0x0614:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0632:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0650:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x0675:
            int r0 = r0 + r2
            goto L_0x0583
        L_0x0678:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzh(r14, r0, r1)
            goto L_0x0583
        L_0x0694:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            boolean r2 = r1 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r2 == 0) goto L_0x06be
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0675
        L_0x06be:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzw(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x06ca:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x06dd:
            int r0 = r0 + 1
            goto L_0x0583
        L_0x06e1:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0777
        L_0x06f6:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x078e
        L_0x070b:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0728:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0761
        L_0x0745:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x0761:
            int r0 = r0 + r1
            goto L_0x0583
        L_0x0764:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x0777:
            int r0 = r0 + 4
            goto L_0x0583
        L_0x077b:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0792
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x078e:
            int r0 = r0 + 8
            goto L_0x0583
        L_0x0792:
            int r11 = r11 + 3
            r0 = r13
            r1 = r15
            r9 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0010
        L_0x079c:
            com.google.android.gms.internal.play_billing.zzhd r0 = r6.zzm
            java.lang.Object r1 = r0.zzd(r7)
            int r0 = r0.zza(r1)
            int r12 = r12 + r0
            boolean r0 = r6.zzh
            if (r0 != 0) goto L_0x07ac
            return r12
        L_0x07ac:
            com.google.android.gms.internal.play_billing.zzek r0 = r6.zzn
            r0.zza(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b6, code lost:
        r1 = r1 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0203, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0211, code lost:
        r1 = r1 + ((int) (r2 ^ (r2 >>> 32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0216, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int[] r2 = r8.zzc
            int r2 = r2.length
            if (r0 >= r2) goto L_0x021a
            int r2 = r8.zzs(r0)
            int[] r3 = r8.zzc
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r2
            int r2 = zzr(r2)
            r3 = r3[r0]
            long r4 = (long) r4
            r6 = 37
            r7 = 32
            switch(r2) {
                case 0: goto L_0x0205;
                case 1: goto L_0x01f9;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01e7;
                case 4: goto L_0x01e0;
                case 5: goto L_0x01d7;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01c5;
                case 8: goto L_0x01b8;
                case 9: goto L_0x01aa;
                case 10: goto L_0x019f;
                case 11: goto L_0x0198;
                case 12: goto L_0x0190;
                case 13: goto L_0x0188;
                case 14: goto L_0x017e;
                case 15: goto L_0x0176;
                case 16: goto L_0x016c;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0216
        L_0x0021:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x0033:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0043:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x0051:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0061:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x006f:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x007d:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x008b:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x009d:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x00af:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x00c3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            boolean r2 = zzN(r9, r4)
            int r2 = com.google.android.gms.internal.play_billing.zzfd.zza(r2)
            goto L_0x0203
        L_0x00d5:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x00e3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x00f3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0203
        L_0x0101:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0111:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0121:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            float r2 = zzn(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0203
        L_0x0133:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0216
            int r1 = r1 * 53
            double r2 = zzm(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0147:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x0153:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x015f:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b6
            int r6 = r2.hashCode()
            goto L_0x01b6
        L_0x016c:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0176:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x017e:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x0188:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x0190:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x0198:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x019f:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x01aa:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b6
            int r6 = r2.hashCode()
        L_0x01b6:
            int r1 = r1 + r6
            goto L_0x0216
        L_0x01b8:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0203
        L_0x01c5:
            int r1 = r1 * 53
            boolean r2 = com.google.android.gms.internal.play_billing.zzhn.zzw(r9, r4)
            int r2 = com.google.android.gms.internal.play_billing.zzfd.zza(r2)
            goto L_0x0203
        L_0x01d0:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x01d7:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x01e0:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0203
        L_0x01e7:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x01f0:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0211
        L_0x01f9:
            int r1 = r1 * 53
            float r2 = com.google.android.gms.internal.play_billing.zzhn.zzb(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
        L_0x0203:
            int r1 = r1 + r2
            goto L_0x0216
        L_0x0205:
            int r1 = r1 * 53
            double r2 = com.google.android.gms.internal.play_billing.zzhn.zza(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
        L_0x0211:
            long r4 = r2 >>> r7
            long r2 = r2 ^ r4
            int r3 = (int) r2
            int r1 = r1 + r3
        L_0x0216:
            int r0 = r0 + 3
            goto L_0x0002
        L_0x021a:
            int r1 = r1 * 53
            com.google.android.gms.internal.play_billing.zzhd r0 = r8.zzm
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x022c
            return r1
        L_0x022c:
            com.google.android.gms.internal.play_billing.zzek r0 = r8.zzn
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x038a, code lost:
        r4 = r13;
        r3 = r14;
        r6 = r17;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0390, code lost:
        r14 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0396, code lost:
        r2 = r37;
        r8 = r5;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x039a, code lost:
        r5 = r11;
        r1 = r12;
        r20 = r13;
        r6 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x039f, code lost:
        r3 = r21;
        r29 = r5;
        r10 = r6;
        r21 = r8;
        r6 = r15;
        r4 = r20;
        r8 = r38;
        r5 = r1;
        r1 = r3;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0539, code lost:
        r9 = r11;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x053b, code lost:
        r11 = r29;
        r10 = r30;
        r8 = r31;
        r13 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05e0, code lost:
        r13 = r10;
        r10 = r8;
        r8 = r9;
        r9 = r11;
        r11 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05ea, code lost:
        r9 = r11;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05ec, code lost:
        r11 = r29;
        r10 = r30;
        r8 = r31;
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x068d, code lost:
        r0 = r33;
        r7 = r13;
        r13 = r10;
        r10 = r8;
        r8 = r9;
        r9 = r11;
        r11 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0753, code lost:
        r8 = r1;
        r10 = r3;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0863, code lost:
        r8 = r1;
        r1 = r2;
        r10 = r3;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:436:0x0999, code lost:
        if (r1 == r7) goto L_0x09a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x099b, code lost:
        r7 = r34;
        r2 = r8;
        r4 = r9;
        r3 = r10;
        r12 = r13;
        r6 = r17;
        r5 = r21;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x09a8, code lost:
        r7 = r34;
        r3 = r1;
        r1 = r8;
        r4 = r9;
        r29 = r11;
        r5 = r13;
        r6 = r15;
        r8 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x0a09, code lost:
        r20 = r1;
        r1 = r3;
        r4 = r5;
        r9 = r6;
        r6 = r35;
        r5 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0ad8, code lost:
        r20 = r1;
        r1 = r3;
        r9 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:477:0x0add, code lost:
        r32 = r5;
        r5 = r4;
        r4 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:478:0x0ae4, code lost:
        r20 = r1;
        r1 = r3;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x0b1d, code lost:
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0b1e, code lost:
        r32 = r5;
        r5 = r4;
        r4 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0b8c, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x0c05, code lost:
        r2 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:526:0x0c4b, code lost:
        if (r2 == r9) goto L_0x0c63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:527:0x0c4d, code lost:
        r14 = r37;
        r13 = r38;
        r12 = r5;
        r15 = r6;
        r6 = r17;
        r3 = r20;
        r5 = r21;
        r11 = r29;
        r10 = 0;
        r32 = r2;
        r2 = r1;
        r1 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:528:0x0c63, code lost:
        r8 = r38;
        r3 = r2;
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01a6, code lost:
        r4 = r13;
        r3 = r14;
        r6 = r17;
        r2 = r21;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01af, code lost:
        r2 = r37;
        r9 = r1;
        r8 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x061d  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x06c8  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0716  */
    /* JADX WARNING: Removed duplicated region for block: B:536:0x0c7f  */
    /* JADX WARNING: Removed duplicated region for block: B:541:0x0ca0  */
    /* JADX WARNING: Removed duplicated region for block: B:625:0x064b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:627:0x0863 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:631:0x0863 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzdj r39) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r7 = r34
            r15 = r35
            r14 = r37
            r13 = r38
            r12 = r39
            zzA(r34)
            sun.misc.Unsafe r11 = zzb
            r10 = 0
            r1 = r36
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001b:
            r16 = 0
            if (r1 >= r14) goto L_0x0cc5
            int r4 = r1 + 1
            byte r1 = r15[r1]
            if (r1 >= 0) goto L_0x002c
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzi(r1, r15, r4, r12)
            int r4 = r12.zza
            goto L_0x0031
        L_0x002c:
            r32 = r4
            r4 = r1
            r1 = r32
        L_0x0031:
            int r8 = r4 >>> 3
            r9 = 3
            if (r8 <= r2) goto L_0x0046
            int r3 = r3 / r9
            int r2 = r0.zze
            if (r8 < r2) goto L_0x0044
            int r2 = r0.zzf
            if (r8 > r2) goto L_0x0044
            int r2 = r0.zzq(r8, r3)
            goto L_0x0052
        L_0x0044:
            r2 = -1
            goto L_0x0052
        L_0x0046:
            int r2 = r0.zze
            if (r8 < r2) goto L_0x0055
            int r2 = r0.zzf
            if (r8 > r2) goto L_0x0055
            int r2 = r0.zzq(r8, r10)
        L_0x0052:
            r3 = r2
            r2 = -1
            goto L_0x0057
        L_0x0055:
            r2 = -1
            r3 = -1
        L_0x0057:
            if (r3 != r2) goto L_0x006a
            r3 = r1
            r21 = r5
            r17 = r6
            r1 = r8
            r29 = r11
            r5 = r12
            r8 = r13
            r6 = r15
            r18 = -1
            r19 = 0
            goto L_0x0c68
        L_0x006a:
            r2 = r4 & 7
            int[] r9 = r0.zzc
            int r19 = r3 + 1
            r10 = r9[r19]
            r19 = r4
            int r4 = zzr(r10)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r10 & r17
            long r13 = (long) r13
            r21 = r8
            r22 = 536870912(0x20000000, float:1.0842022E-19)
            r23 = 0
            java.lang.String r8 = ""
            r27 = r8
            r8 = 17
            if (r4 > r8) goto L_0x03b7
            int r8 = r3 + 2
            r8 = r9[r8]
            int r9 = r8 >>> 20
            r25 = 1
            int r9 = r25 << r9
            r29 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            r30 = r13
            if (r8 == r6) goto L_0x00b2
            if (r6 == r10) goto L_0x00a6
            long r13 = (long) r6
            r11.putInt(r7, r13, r5)
        L_0x00a6:
            if (r8 != r10) goto L_0x00aa
            r5 = 0
            goto L_0x00af
        L_0x00aa:
            long r5 = (long) r8
            int r5 = r11.getInt(r7, r5)
        L_0x00af:
            r17 = r8
            goto L_0x00b4
        L_0x00b2:
            r17 = r6
        L_0x00b4:
            switch(r4) {
                case 0: goto L_0x0372;
                case 1: goto L_0x0359;
                case 2: goto L_0x033f;
                case 3: goto L_0x033f;
                case 4: goto L_0x032b;
                case 5: goto L_0x0310;
                case 6: goto L_0x02fa;
                case 7: goto L_0x02de;
                case 8: goto L_0x01b5;
                case 9: goto L_0x0185;
                case 10: goto L_0x0172;
                case 11: goto L_0x032b;
                case 12: goto L_0x0140;
                case 13: goto L_0x02fa;
                case 14: goto L_0x0310;
                case 15: goto L_0x0129;
                case 16: goto L_0x0100;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            r6 = r1
            r14 = r3
            r13 = r19
            r1 = 3
            r10 = 0
            if (r2 != r1) goto L_0x0396
            r5 = r5 | r9
            java.lang.Object r1 = r0.zzx(r7, r14)
            int r2 = r21 << 3
            r2 = r2 | 4
            com.google.android.gms.internal.play_billing.zzgm r9 = r0.zzv(r14)
            r3 = r21
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r1
            r18 = -1
            r19 = 0
            r10 = r35
            r36 = r5
            r5 = r11
            r11 = r6
            r6 = r12
            r12 = r37
            r20 = r13
            r13 = r2
            r2 = r37
            r6 = r14
            r14 = r39
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzl(r8, r9, r10, r11, r12, r13, r14)
            r0.zzF(r7, r6, r1)
            r13 = r38
            r12 = r39
            r14 = r2
            r2 = r3
            r11 = r5
            r3 = r6
            r1 = r8
            r6 = r17
            r4 = r20
            r10 = 0
            r5 = r36
            goto L_0x001b
        L_0x0100:
            if (r2 != 0) goto L_0x011e
            r8 = r5 | r9
            int r9 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r1, r12)
            long r1 = r12.zzb
            long r5 = com.google.android.gms.internal.play_billing.zzea.zzc(r1)
            r1 = r11
            r13 = -1
            r2 = r34
            r14 = r3
            r13 = r19
            r3 = r30
            r1.putLong(r2, r3, r5)
            r5 = r8
            r1 = r9
            goto L_0x01a6
        L_0x011e:
            r2 = r37
            r9 = r1
            r6 = r3
            r8 = r5
            r5 = r11
            r1 = r12
            r20 = r19
            goto L_0x039f
        L_0x0129:
            r14 = r3
            r13 = r19
            if (r2 != 0) goto L_0x01af
            r5 = r5 | r9
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r12)
            int r2 = r12.zza
            int r2 = com.google.android.gms.internal.play_billing.zzea.zzb(r2)
            r3 = r30
            r11.putInt(r7, r3, r2)
            goto L_0x01a6
        L_0x0140:
            r14 = r3
            r13 = r19
            r3 = r30
            if (r2 != 0) goto L_0x01af
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r12)
            int r2 = r12.zza
            com.google.android.gms.internal.play_billing.zzfb r6 = r0.zzu(r14)
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r29 & r8
            if (r8 == 0) goto L_0x016d
            if (r6 == 0) goto L_0x016d
            boolean r6 = r6.zza(r2)
            if (r6 == 0) goto L_0x0160
            goto L_0x016d
        L_0x0160:
            com.google.android.gms.internal.play_billing.zzhe r3 = zzd(r34)
            long r8 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r3.zzj(r13, r2)
            goto L_0x01a6
        L_0x016d:
            r5 = r5 | r9
            r11.putInt(r7, r3, r2)
            goto L_0x01a6
        L_0x0172:
            r14 = r3
            r13 = r19
            r3 = r30
            r6 = 2
            if (r2 != r6) goto L_0x01af
            r5 = r5 | r9
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zza(r15, r1, r12)
            java.lang.Object r2 = r12.zzc
            r11.putObject(r7, r3, r2)
            goto L_0x01a6
        L_0x0185:
            r14 = r3
            r13 = r19
            r6 = 2
            if (r2 != r6) goto L_0x01af
            r8 = r5 | r9
            java.lang.Object r9 = r0.zzx(r7, r14)
            com.google.android.gms.internal.play_billing.zzgm r2 = r0.zzv(r14)
            r6 = r1
            r1 = r9
            r3 = r35
            r4 = r6
            r5 = r37
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzF(r7, r14, r9)
            r5 = r8
        L_0x01a6:
            r4 = r13
            r3 = r14
            r6 = r17
            r2 = r21
            r10 = 0
            goto L_0x0390
        L_0x01af:
            r2 = r37
            r9 = r1
            r8 = r5
            goto L_0x039a
        L_0x01b5:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r1 = 2
            if (r2 != r1) goto L_0x0396
            r1 = r29 & r22
            if (r1 == 0) goto L_0x02b7
            r1 = r5 | r9
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r6, r12)
            int r5 = r12.zza
            if (r5 < 0) goto L_0x02b2
            if (r5 != 0) goto L_0x01d7
            r8 = r27
            r12.zzc = r8
            r16 = r1
            r10 = 0
            goto L_0x028a
        L_0x01d7:
            int r6 = com.google.android.gms.internal.play_billing.zzhs.zza
            int r6 = r15.length
            int r8 = r6 - r2
            r9 = r2 | r5
            int r8 = r8 - r5
            r8 = r8 | r9
            if (r8 < 0) goto L_0x028e
            int r6 = r2 + r5
            char[] r5 = new char[r5]
            r8 = 0
        L_0x01e7:
            if (r2 >= r6) goto L_0x01fb
            byte r9 = r15[r2]
            boolean r16 = com.google.android.gms.internal.play_billing.zzho.zzd(r9)
            if (r16 == 0) goto L_0x01fb
            int r2 = r2 + 1
            int r16 = r8 + 1
            char r9 = (char) r9
            r5[r8] = r9
            r8 = r16
            goto L_0x01e7
        L_0x01fb:
            if (r2 >= r6) goto L_0x027f
            int r9 = r2 + 1
            byte r10 = r15[r2]
            boolean r16 = com.google.android.gms.internal.play_billing.zzho.zzd(r10)
            if (r16 == 0) goto L_0x0225
            int r2 = r8 + 1
            char r10 = (char) r10
            r5[r8] = r10
            r8 = r2
            r2 = r9
        L_0x020e:
            if (r2 >= r6) goto L_0x0221
            byte r9 = r15[r2]
            boolean r10 = com.google.android.gms.internal.play_billing.zzho.zzd(r9)
            if (r10 == 0) goto L_0x0221
            int r2 = r2 + 1
            int r10 = r8 + 1
            char r9 = (char) r9
            r5[r8] = r9
            r8 = r10
            goto L_0x020e
        L_0x0221:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x01fb
        L_0x0225:
            r16 = r1
            r1 = -32
            if (r10 >= r1) goto L_0x023f
            if (r9 >= r6) goto L_0x023a
            int r1 = r8 + 1
            int r2 = r2 + 2
            byte r9 = r15[r9]
            com.google.android.gms.internal.play_billing.zzho.zzc(r10, r9, r5, r8)
            r8 = r1
        L_0x0237:
            r1 = r16
            goto L_0x0221
        L_0x023a:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x023f:
            r1 = -16
            if (r10 >= r1) goto L_0x025e
            int r1 = r6 + -1
            if (r9 >= r1) goto L_0x0259
            int r1 = r8 + 1
            int r22 = r2 + 2
            byte r9 = r15[r9]
            int r2 = r2 + 3
            r36 = r1
            byte r1 = r15[r22]
            com.google.android.gms.internal.play_billing.zzho.zzb(r10, r9, r1, r5, r8)
            r8 = r36
            goto L_0x0237
        L_0x0259:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x025e:
            int r1 = r6 + -2
            if (r9 >= r1) goto L_0x027a
            int r1 = r2 + 2
            byte r23 = r15[r9]
            int r9 = r2 + 3
            byte r24 = r15[r1]
            int r2 = r2 + 4
            byte r25 = r15[r9]
            r22 = r10
            r26 = r5
            r27 = r8
            com.google.android.gms.internal.play_billing.zzho.zza(r22, r23, r24, r25, r26, r27)
            int r8 = r8 + 2
            goto L_0x0237
        L_0x027a:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x027f:
            r16 = r1
            java.lang.String r1 = new java.lang.String
            r10 = 0
            r1.<init>(r5, r10, r8)
            r12.zzc = r1
            r2 = r6
        L_0x028a:
            r1 = r2
            r5 = r16
            goto L_0x02d2
        L_0x028e:
            r10 = 0
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3[r10] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4 = 1
            r3[r4] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r4 = 2
            r3[r4] = r2
            java.lang.String r2 = "buffer length=%d, index=%d, size=%d"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x02b2:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x02b7:
            r8 = r27
            r10 = 0
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r6, r12)
            int r2 = r12.zza
            if (r2 < 0) goto L_0x02d9
            r5 = r5 | r9
            if (r2 != 0) goto L_0x02c8
            r12.zzc = r8
            goto L_0x02d2
        L_0x02c8:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r6.<init>(r15, r1, r2, r8)
            r12.zzc = r6
            int r1 = r1 + r2
        L_0x02d2:
            java.lang.Object r2 = r12.zzc
            r11.putObject(r7, r3, r2)
            goto L_0x038a
        L_0x02d9:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x02de:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r10 = 0
            if (r2 != 0) goto L_0x0396
            r5 = r5 | r9
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r6, r12)
            long r8 = r12.zzb
            int r2 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x02f4
            r8 = 1
            goto L_0x02f5
        L_0x02f4:
            r8 = 0
        L_0x02f5:
            com.google.android.gms.internal.play_billing.zzhn.zzm(r7, r3, r8)
            goto L_0x038a
        L_0x02fa:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r1 = 5
            r10 = 0
            if (r2 != r1) goto L_0x0396
            int r1 = r6 + 4
            r5 = r5 | r9
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r6)
            r11.putInt(r7, r3, r2)
            goto L_0x038a
        L_0x0310:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r1 = 1
            r10 = 0
            if (r2 != r1) goto L_0x0396
            int r8 = r6 + 8
            r9 = r9 | r5
            long r5 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r6)
            r1 = r11
            r2 = r34
            r1.putLong(r2, r3, r5)
            r1 = r8
            r5 = r9
            goto L_0x038a
        L_0x032b:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r10 = 0
            if (r2 != 0) goto L_0x0396
            r5 = r5 | r9
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r6, r12)
            int r2 = r12.zza
            r11.putInt(r7, r3, r2)
            goto L_0x038a
        L_0x033f:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r10 = 0
            if (r2 != 0) goto L_0x0396
            r8 = r5 | r9
            int r9 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r6, r12)
            long r5 = r12.zzb
            r1 = r11
            r2 = r34
            r1.putLong(r2, r3, r5)
            r5 = r8
            r1 = r9
            goto L_0x038a
        L_0x0359:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r1 = 5
            r10 = 0
            if (r2 != r1) goto L_0x0396
            int r1 = r6 + 4
            r5 = r5 | r9
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r6)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            com.google.android.gms.internal.play_billing.zzhn.zzp(r7, r3, r2)
            goto L_0x038a
        L_0x0372:
            r6 = r1
            r14 = r3
            r13 = r19
            r3 = r30
            r1 = 1
            r10 = 0
            if (r2 != r1) goto L_0x0396
            int r1 = r6 + 8
            r5 = r5 | r9
            long r8 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r6)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            com.google.android.gms.internal.play_billing.zzhn.zzo(r7, r3, r8)
        L_0x038a:
            r4 = r13
            r3 = r14
            r6 = r17
            r2 = r21
        L_0x0390:
            r14 = r37
        L_0x0392:
            r13 = r38
            goto L_0x001b
        L_0x0396:
            r2 = r37
            r8 = r5
            r9 = r6
        L_0x039a:
            r5 = r11
            r1 = r12
            r20 = r13
            r6 = r14
        L_0x039f:
            r3 = r21
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r18 = -1
            r19 = 0
            r29 = r5
            r10 = r6
            r21 = r8
            r6 = r15
            r4 = r20
            r8 = r38
            r5 = r1
            r1 = r3
            r3 = r9
            goto L_0x0c68
        L_0x03b7:
            r17 = r6
            r29 = r10
            r20 = r19
            r8 = r27
            r18 = -1
            r19 = 0
            r6 = r3
            r3 = r21
            r21 = r5
            r5 = r11
            r10 = r13
            r14 = r37
            r13 = r1
            r1 = r12
            r12 = 27
            r27 = 10
            if (r4 != r12) goto L_0x042a
            r12 = 2
            if (r2 != r12) goto L_0x041e
            java.lang.Object r2 = r5.getObject(r7, r10)
            com.google.android.gms.internal.play_billing.zzfc r2 = (com.google.android.gms.internal.play_billing.zzfc) r2
            boolean r4 = r2.zzc()
            if (r4 != 0) goto L_0x03f7
            int r4 = r2.size()
            if (r4 != 0) goto L_0x03ec
            r4 = 10
            goto L_0x03f0
        L_0x03ec:
            int r27 = r4 + r4
            r4 = r27
        L_0x03f0:
            com.google.android.gms.internal.play_billing.zzfc r2 = r2.zzd(r4)
            r5.putObject(r7, r10, r2)
        L_0x03f7:
            com.google.android.gms.internal.play_billing.zzgm r8 = r0.zzv(r6)
            r9 = r20
            r10 = r35
            r11 = r13
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r37
            r13 = r2
            r2 = r14
            r14 = r39
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zze(r8, r9, r10, r11, r12, r13, r14)
            r13 = r38
            r12 = r1
            r14 = r2
            r2 = r3
            r11 = r5
            r3 = r6
            r1 = r8
            r6 = r17
            r4 = r20
            r5 = r21
            r10 = 0
            goto L_0x001b
        L_0x041e:
            r29 = r5
            r5 = r20
            r32 = r13
            r13 = r1
            r1 = r6
            r6 = r32
            goto L_0x09ee
        L_0x042a:
            r12 = 49
            if (r4 > r12) goto L_0x09b5
            r30 = r6
            r12 = r29
            r29 = r5
            long r5 = (long) r12
            sun.misc.Unsafe r9 = zzb
            java.lang.Object r12 = r9.getObject(r7, r10)
            com.google.android.gms.internal.play_billing.zzfc r12 = (com.google.android.gms.internal.play_billing.zzfc) r12
            boolean r22 = r12.zzc()
            if (r22 != 0) goto L_0x045d
            int r22 = r12.size()
            if (r22 != 0) goto L_0x044e
            r31 = r3
            r3 = 10
            goto L_0x0454
        L_0x044e:
            int r27 = r22 + r22
            r31 = r3
            r3 = r27
        L_0x0454:
            com.google.android.gms.internal.play_billing.zzfc r3 = r12.zzd(r3)
            r9.putObject(r7, r10, r3)
            r12 = r3
            goto L_0x045f
        L_0x045d:
            r31 = r3
        L_0x045f:
            switch(r4) {
                case 18: goto L_0x0922;
                case 19: goto L_0x08c9;
                case 20: goto L_0x087d;
                case 21: goto L_0x087d;
                case 22: goto L_0x0852;
                case 23: goto L_0x0806;
                case 24: goto L_0x07b9;
                case 25: goto L_0x0758;
                case 26: goto L_0x0698;
                case 27: goto L_0x065a;
                case 28: goto L_0x05f5;
                case 29: goto L_0x0852;
                case 30: goto L_0x0545;
                case 31: goto L_0x07b9;
                case 32: goto L_0x0806;
                case 33: goto L_0x04ea;
                case 34: goto L_0x048d;
                case 35: goto L_0x0922;
                case 36: goto L_0x08c9;
                case 37: goto L_0x087d;
                case 38: goto L_0x087d;
                case 39: goto L_0x0852;
                case 40: goto L_0x0806;
                case 41: goto L_0x07b9;
                case 42: goto L_0x0758;
                case 43: goto L_0x0852;
                case 44: goto L_0x0545;
                case 45: goto L_0x07b9;
                case 46: goto L_0x0806;
                case 47: goto L_0x04ea;
                case 48: goto L_0x048d;
                default: goto L_0x0462;
            }
        L_0x0462:
            r7 = r13
            r9 = r20
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            r1 = 3
            if (r2 != r1) goto L_0x0998
            r1 = r9 & -8
            r20 = r1 | 4
            com.google.android.gms.internal.play_billing.zzgm r22 = r0.zzv(r10)
            r1 = r22
            r2 = r35
            r3 = r7
            r4 = r37
            r5 = r20
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r13.zzc
            r12.add(r2)
            goto L_0x097a
        L_0x048d:
            r3 = 2
            if (r2 != r3) goto L_0x04b5
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r13, r1)
            int r3 = r1.zza
            int r3 = r3 + r2
        L_0x0499:
            if (r2 >= r3) goto L_0x04a9
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r1)
            long r4 = r1.zzb
            long r4 = com.google.android.gms.internal.play_billing.zzea.zzc(r4)
            r12.zzf(r4)
            goto L_0x0499
        L_0x04a9:
            if (r2 != r3) goto L_0x04b0
            r7 = r13
            r9 = r20
            goto L_0x053b
        L_0x04b0:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x04b5:
            if (r2 != 0) goto L_0x04e5
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r13, r1)
            long r3 = r1.zzb
            long r3 = com.google.android.gms.internal.play_billing.zzea.zzc(r3)
            r12.zzf(r3)
        L_0x04c6:
            if (r2 >= r14) goto L_0x04e2
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            r11 = r20
            if (r11 != r4) goto L_0x0539
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r3, r1)
            long r3 = r1.zzb
            long r3 = com.google.android.gms.internal.play_billing.zzea.zzc(r3)
            r12.zzf(r3)
            r20 = r11
            goto L_0x04c6
        L_0x04e2:
            r11 = r20
            goto L_0x0539
        L_0x04e5:
            r7 = r13
            r9 = r20
            goto L_0x05ec
        L_0x04ea:
            r11 = r20
            r3 = 2
            if (r2 != r3) goto L_0x0510
            com.google.android.gms.internal.play_billing.zzey r12 = (com.google.android.gms.internal.play_billing.zzey) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r13, r1)
            int r3 = r1.zza
            int r3 = r3 + r2
        L_0x04f8:
            if (r2 >= r3) goto L_0x0508
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            int r4 = com.google.android.gms.internal.play_billing.zzea.zzb(r4)
            r12.zzf(r4)
            goto L_0x04f8
        L_0x0508:
            if (r2 != r3) goto L_0x050b
            goto L_0x0539
        L_0x050b:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x0510:
            if (r2 != 0) goto L_0x05ea
            com.google.android.gms.internal.play_billing.zzey r12 = (com.google.android.gms.internal.play_billing.zzey) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r13, r1)
            int r3 = r1.zza
            int r3 = com.google.android.gms.internal.play_billing.zzea.zzb(r3)
            r12.zzf(r3)
        L_0x0521:
            if (r2 >= r14) goto L_0x0539
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            if (r11 != r4) goto L_0x0539
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r3, r1)
            int r3 = r1.zza
            int r3 = com.google.android.gms.internal.play_billing.zzea.zzb(r3)
            r12.zzf(r3)
            goto L_0x0521
        L_0x0539:
            r9 = r11
            r7 = r13
        L_0x053b:
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            r1 = r2
            goto L_0x0999
        L_0x0545:
            r11 = r20
            r3 = 2
            if (r2 != r3) goto L_0x0554
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzf(r15, r13, r12, r1)
            r10 = r1
            r8 = r30
            r9 = r31
            goto L_0x056a
        L_0x0554:
            if (r2 != 0) goto L_0x05e8
            r10 = r1
            r1 = r11
            r2 = r35
            r9 = r31
            r3 = r13
            r4 = r37
            r8 = r29
            r5 = r12
            r8 = r30
            r6 = r39
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzj(r1, r2, r3, r4, r5, r6)
        L_0x056a:
            com.google.android.gms.internal.play_billing.zzfb r1 = r0.zzu(r8)
            com.google.android.gms.internal.play_billing.zzhd r3 = r0.zzm
            int r4 = com.google.android.gms.internal.play_billing.zzgo.zza
            if (r1 == 0) goto L_0x05d9
            boolean r4 = r12 instanceof java.util.RandomAccess
            if (r4 == 0) goto L_0x05b3
            int r4 = r12.size()
            r36 = r2
            r2 = r16
            r5 = 0
            r6 = 0
        L_0x0582:
            if (r5 >= r4) goto L_0x05a9
            java.lang.Object r20 = r12.get(r5)
            java.lang.Integer r20 = (java.lang.Integer) r20
            int r0 = r20.intValue()
            boolean r20 = r1.zza(r0)
            if (r20 == 0) goto L_0x05a0
            if (r5 == r6) goto L_0x059d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r12.set(r6, r0)
        L_0x059d:
            int r6 = r6 + 1
            goto L_0x05a4
        L_0x05a0:
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzgo.zzo(r7, r9, r0, r2, r3)
        L_0x05a4:
            int r5 = r5 + 1
            r0 = r33
            goto L_0x0582
        L_0x05a9:
            if (r6 == r4) goto L_0x05db
            java.util.List r0 = r12.subList(r6, r4)
            r0.clear()
            goto L_0x05db
        L_0x05b3:
            r36 = r2
            java.util.Iterator r0 = r12.iterator()
            r2 = r16
        L_0x05bb:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x05db
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r5 = r1.zza(r4)
            if (r5 != 0) goto L_0x05bb
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzgo.zzo(r7, r9, r4, r2, r3)
            r0.remove()
            goto L_0x05bb
        L_0x05d9:
            r36 = r2
        L_0x05db:
            r0 = r33
            r1 = r36
            r7 = r13
        L_0x05e0:
            r13 = r10
            r10 = r8
            r8 = r9
            r9 = r11
            r11 = r29
            goto L_0x0999
        L_0x05e8:
            r0 = r33
        L_0x05ea:
            r9 = r11
            r7 = r13
        L_0x05ec:
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            goto L_0x0998
        L_0x05f5:
            r10 = r1
            r11 = r20
            r8 = r30
            r9 = r31
            r0 = 2
            if (r2 != r0) goto L_0x068d
            int r0 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r13, r10)
            int r1 = r10.zza
            if (r1 < 0) goto L_0x0655
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x0650
            if (r1 != 0) goto L_0x0613
            com.google.android.gms.internal.play_billing.zzdw r1 = com.google.android.gms.internal.play_billing.zzdw.zzb
            r12.add(r1)
            goto L_0x061b
        L_0x0613:
            com.google.android.gms.internal.play_billing.zzdw r2 = com.google.android.gms.internal.play_billing.zzdw.zzl(r15, r0, r1)
            r12.add(r2)
        L_0x061a:
            int r0 = r0 + r1
        L_0x061b:
            if (r0 >= r14) goto L_0x064b
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r0, r10)
            int r2 = r10.zza
            if (r11 != r2) goto L_0x064b
            int r0 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r10)
            int r1 = r10.zza
            if (r1 < 0) goto L_0x0646
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x0641
            if (r1 != 0) goto L_0x0639
            com.google.android.gms.internal.play_billing.zzdw r1 = com.google.android.gms.internal.play_billing.zzdw.zzb
            r12.add(r1)
            goto L_0x061b
        L_0x0639:
            com.google.android.gms.internal.play_billing.zzdw r2 = com.google.android.gms.internal.play_billing.zzdw.zzl(r15, r0, r1)
            r12.add(r2)
            goto L_0x061a
        L_0x0641:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r0
        L_0x0646:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r0
        L_0x064b:
            r1 = r0
            r7 = r13
            r0 = r33
            goto L_0x05e0
        L_0x0650:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r0
        L_0x0655:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r0
        L_0x065a:
            r10 = r1
            r11 = r20
            r8 = r30
            r9 = r31
            r0 = 2
            if (r2 != r0) goto L_0x068d
            r0 = r33
            com.google.android.gms.internal.play_billing.zzgm r1 = r0.zzv(r8)
            r3 = r8
            r4 = r29
            r8 = r1
            r1 = r9
            r9 = r11
            r2 = r10
            r10 = r35
            r5 = r11
            r11 = r13
            r6 = r12
            r12 = r37
            r7 = r13
            r13 = r6
            r6 = r14
            r14 = r39
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zze(r8, r9, r10, r11, r12, r13, r14)
            r13 = r2
            r10 = r3
            r11 = r4
            r9 = r5
            r14 = r6
            r32 = r8
            r8 = r1
            r1 = r32
            goto L_0x0999
        L_0x068d:
            r0 = r33
            r7 = r13
            r13 = r10
            r10 = r8
            r8 = r9
            r9 = r11
            r11 = r29
            goto L_0x0998
        L_0x0698:
            r7 = r13
            r9 = r20
            r4 = r29
            r3 = r30
            r10 = 2
            r13 = r1
            r1 = r31
            if (r2 != r10) goto L_0x0753
            r10 = 536870912(0x20000000, double:2.652494739E-315)
            long r5 = r5 & r10
            int r2 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x06f3
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r5 = r13.zza
            if (r5 < 0) goto L_0x06ee
            if (r5 != 0) goto L_0x06bb
            r12.add(r8)
            goto L_0x06c6
        L_0x06bb:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r6.<init>(r15, r2, r5, r10)
            r12.add(r6)
        L_0x06c5:
            int r2 = r2 + r5
        L_0x06c6:
            if (r2 >= r14) goto L_0x0863
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r13)
            int r6 = r13.zza
            if (r9 != r6) goto L_0x0863
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r5, r13)
            int r5 = r13.zza
            if (r5 < 0) goto L_0x06e9
            if (r5 != 0) goto L_0x06de
            r12.add(r8)
            goto L_0x06c6
        L_0x06de:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r6.<init>(r15, r2, r5, r10)
            r12.add(r6)
            goto L_0x06c5
        L_0x06e9:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x06ee:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x06f3:
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r5 = r13.zza
            if (r5 < 0) goto L_0x074e
            if (r5 != 0) goto L_0x0701
            r12.add(r8)
            goto L_0x0714
        L_0x0701:
            int r6 = r2 + r5
            boolean r10 = com.google.android.gms.internal.play_billing.zzhs.zze(r15, r2, r6)
            if (r10 == 0) goto L_0x0749
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r10.<init>(r15, r2, r5, r11)
            r12.add(r10)
        L_0x0713:
            r2 = r6
        L_0x0714:
            if (r2 >= r14) goto L_0x0863
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r13)
            int r6 = r13.zza
            if (r9 != r6) goto L_0x0863
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r5, r13)
            int r5 = r13.zza
            if (r5 < 0) goto L_0x0744
            if (r5 != 0) goto L_0x072c
            r12.add(r8)
            goto L_0x0714
        L_0x072c:
            int r6 = r2 + r5
            boolean r10 = com.google.android.gms.internal.play_billing.zzhs.zze(r15, r2, r6)
            if (r10 == 0) goto L_0x073f
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r10.<init>(r15, r2, r5, r11)
            r12.add(r10)
            goto L_0x0713
        L_0x073f:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0744:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x0749:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x074e:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x0753:
            r8 = r1
            r10 = r3
            r11 = r4
            goto L_0x0998
        L_0x0758:
            r7 = r13
            r9 = r20
            r4 = r29
            r3 = r30
            r5 = 2
            r13 = r1
            r1 = r31
            if (r2 != r5) goto L_0x078a
            com.google.android.gms.internal.play_billing.zzdl r12 = (com.google.android.gms.internal.play_billing.zzdl) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r5 = r13.zza
            int r5 = r5 + r2
        L_0x076e:
            if (r2 >= r5) goto L_0x0781
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r13)
            long r10 = r13.zzb
            int r6 = (r10 > r23 ? 1 : (r10 == r23 ? 0 : -1))
            if (r6 == 0) goto L_0x077c
            r10 = 1
            goto L_0x077d
        L_0x077c:
            r10 = 0
        L_0x077d:
            r12.zze(r10)
            goto L_0x076e
        L_0x0781:
            if (r2 != r5) goto L_0x0785
            goto L_0x0863
        L_0x0785:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x078a:
            if (r2 != 0) goto L_0x0753
            com.google.android.gms.internal.play_billing.zzdl r12 = (com.google.android.gms.internal.play_billing.zzdl) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r7, r13)
            long r5 = r13.zzb
            int r8 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x079a
            r10 = 1
            goto L_0x079b
        L_0x079a:
            r10 = 0
        L_0x079b:
            r12.zze(r10)
        L_0x079e:
            if (r2 >= r14) goto L_0x0863
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r13)
            int r6 = r13.zza
            if (r9 != r6) goto L_0x0863
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r5, r13)
            long r5 = r13.zzb
            int r8 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x07b4
            r10 = 1
            goto L_0x07b5
        L_0x07b4:
            r10 = 0
        L_0x07b5:
            r12.zze(r10)
            goto L_0x079e
        L_0x07b9:
            r7 = r13
            r9 = r20
            r4 = r29
            r3 = r30
            r5 = 2
            r13 = r1
            r1 = r31
            if (r2 != r5) goto L_0x07e4
            com.google.android.gms.internal.play_billing.zzey r12 = (com.google.android.gms.internal.play_billing.zzey) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r5 = r13.zza
            int r5 = r5 + r2
        L_0x07cf:
            if (r2 >= r5) goto L_0x07db
            int r6 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r2)
            r12.zzf(r6)
            int r2 = r2 + 4
            goto L_0x07cf
        L_0x07db:
            if (r2 != r5) goto L_0x07df
            goto L_0x0863
        L_0x07df:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x07e4:
            r5 = 5
            if (r2 != r5) goto L_0x0753
            int r2 = r7 + 4
            com.google.android.gms.internal.play_billing.zzey r12 = (com.google.android.gms.internal.play_billing.zzey) r12
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r7)
            r12.zzf(r5)
        L_0x07f2:
            if (r2 >= r14) goto L_0x0863
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r13)
            int r6 = r13.zza
            if (r9 != r6) goto L_0x0863
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r5)
            r12.zzf(r2)
            int r2 = r5 + 4
            goto L_0x07f2
        L_0x0806:
            r7 = r13
            r9 = r20
            r4 = r29
            r3 = r30
            r5 = 2
            r13 = r1
            r1 = r31
            if (r2 != r5) goto L_0x0830
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r5 = r13.zza
            int r5 = r5 + r2
        L_0x081c:
            if (r2 >= r5) goto L_0x0828
            long r10 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r2)
            r12.zzf(r10)
            int r2 = r2 + 8
            goto L_0x081c
        L_0x0828:
            if (r2 != r5) goto L_0x082b
            goto L_0x0863
        L_0x082b:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x0830:
            r5 = 1
            if (r2 != r5) goto L_0x0753
            int r2 = r7 + 8
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            long r5 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r7)
            r12.zzf(r5)
        L_0x083e:
            if (r2 >= r14) goto L_0x0863
            int r5 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r13)
            int r6 = r13.zza
            if (r9 != r6) goto L_0x0863
            long r10 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r5)
            r12.zzf(r10)
            int r2 = r5 + 8
            goto L_0x083e
        L_0x0852:
            r7 = r13
            r9 = r20
            r4 = r29
            r3 = r30
            r5 = 2
            r13 = r1
            r1 = r31
            if (r2 != r5) goto L_0x0869
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzf(r15, r7, r12, r13)
        L_0x0863:
            r8 = r1
            r1 = r2
            r10 = r3
            r11 = r4
            goto L_0x0999
        L_0x0869:
            if (r2 != 0) goto L_0x0753
            r8 = r1
            r1 = r9
            r2 = r35
            r10 = r3
            r3 = r7
            r11 = r4
            r4 = r37
            r5 = r12
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzj(r1, r2, r3, r4, r5, r6)
            goto L_0x0999
        L_0x087d:
            r7 = r13
            r9 = r20
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            r1 = 2
            if (r2 != r1) goto L_0x08a8
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r2 = r13.zza
            int r2 = r2 + r1
        L_0x0893:
            if (r1 >= r2) goto L_0x089f
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r1, r13)
            long r3 = r13.zzb
            r12.zzf(r3)
            goto L_0x0893
        L_0x089f:
            if (r1 != r2) goto L_0x08a3
            goto L_0x0999
        L_0x08a3:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x08a8:
            if (r2 != 0) goto L_0x0998
            com.google.android.gms.internal.play_billing.zzfr r12 = (com.google.android.gms.internal.play_billing.zzfr) r12
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r7, r13)
            long r2 = r13.zzb
            r12.zzf(r2)
        L_0x08b5:
            if (r1 >= r14) goto L_0x0999
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r13)
            int r3 = r13.zza
            if (r9 != r3) goto L_0x0999
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r13)
            long r2 = r13.zzb
            r12.zzf(r2)
            goto L_0x08b5
        L_0x08c9:
            r7 = r13
            r9 = r20
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            r1 = 2
            if (r2 != r1) goto L_0x08f8
            com.google.android.gms.internal.play_billing.zzeq r12 = (com.google.android.gms.internal.play_billing.zzeq) r12
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r2 = r13.zza
            int r2 = r2 + r1
        L_0x08df:
            if (r1 >= r2) goto L_0x08ef
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r1)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            r12.zze(r3)
            int r1 = r1 + 4
            goto L_0x08df
        L_0x08ef:
            if (r1 != r2) goto L_0x08f3
            goto L_0x0999
        L_0x08f3:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x08f8:
            r1 = 5
            if (r2 != r1) goto L_0x0998
            int r1 = r7 + 4
            com.google.android.gms.internal.play_billing.zzeq r12 = (com.google.android.gms.internal.play_billing.zzeq) r12
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r7)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r12.zze(r2)
        L_0x090a:
            if (r1 >= r14) goto L_0x0999
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r13)
            int r3 = r13.zza
            if (r9 != r3) goto L_0x0999
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            int r1 = r2 + 4
            goto L_0x090a
        L_0x0922:
            r7 = r13
            r9 = r20
            r11 = r29
            r10 = r30
            r8 = r31
            r13 = r1
            r1 = 2
            if (r2 != r1) goto L_0x0950
            com.google.android.gms.internal.play_billing.zzeg r12 = (com.google.android.gms.internal.play_billing.zzeg) r12
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r7, r13)
            int r2 = r13.zza
            int r2 = r2 + r1
        L_0x0938:
            if (r1 >= r2) goto L_0x0948
            long r3 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r1)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            r12.zze(r3)
            int r1 = r1 + 8
            goto L_0x0938
        L_0x0948:
            if (r1 != r2) goto L_0x094b
            goto L_0x0999
        L_0x094b:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x0950:
            r1 = 1
            if (r2 != r1) goto L_0x0998
            int r1 = r7 + 8
            com.google.android.gms.internal.play_billing.zzeg r12 = (com.google.android.gms.internal.play_billing.zzeg) r12
            long r2 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r7)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            r12.zze(r2)
        L_0x0962:
            if (r1 >= r14) goto L_0x0999
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r13)
            int r3 = r13.zza
            if (r9 != r3) goto L_0x0999
            long r3 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r2)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            r12.zze(r3)
            int r1 = r2 + 8
            goto L_0x0962
        L_0x097a:
            if (r1 >= r14) goto L_0x0999
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r13)
            int r2 = r13.zza
            if (r9 != r2) goto L_0x0999
            r1 = r22
            r2 = r35
            r4 = r37
            r5 = r20
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r13.zzc
            r12.add(r2)
            goto L_0x097a
        L_0x0998:
            r1 = r7
        L_0x0999:
            if (r1 == r7) goto L_0x09a8
            r7 = r34
            r2 = r8
            r4 = r9
            r3 = r10
            r12 = r13
            r6 = r17
            r5 = r21
            r10 = 0
            goto L_0x0392
        L_0x09a8:
            r7 = r34
            r3 = r1
            r1 = r8
            r4 = r9
            r29 = r11
            r5 = r13
            r6 = r15
            r8 = r38
            goto L_0x0c68
        L_0x09b5:
            r7 = r13
            r12 = r29
            r13 = r1
            r29 = r5
            r1 = r6
            r5 = r20
            r6 = 50
            if (r4 != r6) goto L_0x09f8
            r6 = 2
            if (r2 != r6) goto L_0x09eb
            sun.misc.Unsafe r2 = zzb
            java.lang.Object r1 = r0.zzw(r1)
            r7 = r34
            java.lang.Object r3 = r2.getObject(r7, r10)
            r4 = r3
            com.google.android.gms.internal.play_billing.zzfw r4 = (com.google.android.gms.internal.play_billing.zzfw) r4
            boolean r4 = r4.zze()
            if (r4 != 0) goto L_0x09e8
            com.google.android.gms.internal.play_billing.zzfw r4 = com.google.android.gms.internal.play_billing.zzfw.zza()
            com.google.android.gms.internal.play_billing.zzfw r4 = r4.zzb()
            com.google.android.gms.internal.play_billing.zzfx.zza(r4, r3)
            r2.putObject(r7, r10, r4)
        L_0x09e8:
            com.google.android.gms.internal.play_billing.zzfv r1 = (com.google.android.gms.internal.play_billing.zzfv) r1
            throw r16
        L_0x09eb:
            r6 = r7
            r7 = r34
        L_0x09ee:
            r8 = r38
            r10 = r1
            r1 = r3
            r4 = r5
            r3 = r6
            r5 = r13
            r6 = r15
            goto L_0x0c68
        L_0x09f8:
            r6 = r7
            r7 = r34
            int r20 = r1 + 2
            sun.misc.Unsafe r13 = zzb
            r9 = r9[r20]
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r15
            long r14 = (long) r9
            switch(r4) {
                case 51: goto L_0x0c29;
                case 52: goto L_0x0c08;
                case 53: goto L_0x0be8;
                case 54: goto L_0x0be8;
                case 55: goto L_0x0bcb;
                case 56: goto L_0x0bad;
                case 57: goto L_0x0b8f;
                case 58: goto L_0x0b63;
                case 59: goto L_0x0b25;
                case 60: goto L_0x0ae9;
                case 61: goto L_0x0ac3;
                case 62: goto L_0x0bcb;
                case 63: goto L_0x0a8c;
                case 64: goto L_0x0b8f;
                case 65: goto L_0x0bad;
                case 66: goto L_0x0a6f;
                case 67: goto L_0x0a42;
                case 68: goto L_0x0a14;
                default: goto L_0x0a09;
            }
        L_0x0a09:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r6 = r35
            r5 = r39
            goto L_0x0c4a
        L_0x0a14:
            r4 = 3
            if (r2 != r4) goto L_0x0a3f
            r2 = r5 & -8
            r13 = r2 | 4
            java.lang.Object r2 = r0.zzy(r7, r3, r1)
            com.google.android.gms.internal.play_billing.zzgm r9 = r0.zzv(r1)
            r8 = r2
            r10 = r35
            r11 = r6
            r12 = r37
            r4 = r39
            r15 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzl(r8, r9, r10, r11, r12, r13, r14)
            r0.zzG(r7, r3, r1, r2)
            r20 = r1
            r1 = r3
            r9 = r6
            r2 = r8
            r6 = r35
            goto L_0x0add
        L_0x0a3f:
            r15 = r37
            goto L_0x0a09
        L_0x0a42:
            r9 = r37
            r4 = r39
            if (r2 != 0) goto L_0x0a67
            r8 = r35
            r12 = 1048575(0xfffff, float:1.469367E-39)
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r8, r6, r4)
            r36 = r13
            long r12 = r4.zzb
            long r12 = com.google.android.gms.internal.play_billing.zzea.zzc(r12)
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r13 = r36
            r13.putObject(r7, r10, r12)
            r13.putInt(r7, r14, r3)
            goto L_0x0ad8
        L_0x0a67:
            r20 = r1
            r1 = r3
            r9 = r6
            r6 = r35
            goto L_0x0b1e
        L_0x0a6f:
            r8 = r35
            r9 = r37
            r4 = r39
            if (r2 != 0) goto L_0x0ae4
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r8, r6, r4)
            int r12 = r4.zza
            int r12 = com.google.android.gms.internal.play_billing.zzea.zzb(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13.putObject(r7, r10, r12)
            r13.putInt(r7, r14, r3)
            goto L_0x0ad8
        L_0x0a8c:
            r8 = r35
            r9 = r37
            r4 = r39
            if (r2 != 0) goto L_0x0ae4
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r8, r6, r4)
            int r12 = r4.zza
            r36 = r2
            com.google.android.gms.internal.play_billing.zzfb r2 = r0.zzu(r1)
            if (r2 == 0) goto L_0x0ab6
            boolean r2 = r2.zza(r12)
            if (r2 == 0) goto L_0x0aa9
            goto L_0x0ab6
        L_0x0aa9:
            com.google.android.gms.internal.play_billing.zzhe r2 = zzd(r34)
            long r10 = (long) r12
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r2.zzj(r5, r10)
            goto L_0x0ac0
        L_0x0ab6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r13.putObject(r7, r10, r2)
            r13.putInt(r7, r14, r3)
        L_0x0ac0:
            r2 = r36
            goto L_0x0ad8
        L_0x0ac3:
            r8 = r35
            r9 = r37
            r4 = r39
            r12 = 2
            if (r2 != r12) goto L_0x0ae4
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zza(r8, r6, r4)
            java.lang.Object r12 = r4.zzc
            r13.putObject(r7, r10, r12)
            r13.putInt(r7, r14, r3)
        L_0x0ad8:
            r20 = r1
            r1 = r3
            r9 = r6
            r6 = r8
        L_0x0add:
            r32 = r5
            r5 = r4
            r4 = r32
            goto L_0x0c4b
        L_0x0ae4:
            r20 = r1
            r1 = r3
            r9 = r6
            goto L_0x0b1d
        L_0x0ae9:
            r8 = r35
            r9 = r37
            r4 = r39
            r12 = 2
            if (r2 != r12) goto L_0x0b19
            java.lang.Object r10 = r0.zzy(r7, r3, r1)
            com.google.android.gms.internal.play_billing.zzgm r2 = r0.zzv(r1)
            r11 = r1
            r1 = r10
            r12 = r3
            r3 = r35
            r13 = r4
            r4 = r6
            r14 = r5
            r5 = r37
            r9 = r6
            r15 = r29
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzG(r7, r12, r11, r10)
            r2 = r1
            r6 = r8
            r20 = r11
            r1 = r12
            r5 = r13
            r4 = r14
            goto L_0x0c4b
        L_0x0b19:
            r9 = r6
            r20 = r1
            r1 = r3
        L_0x0b1d:
            r6 = r8
        L_0x0b1e:
            r32 = r5
            r5 = r4
            r4 = r32
            goto L_0x0c4a
        L_0x0b25:
            r20 = r1
            r1 = r3
            r3 = r5
            r9 = r6
            r4 = 2
            r6 = r35
            r5 = r39
            if (r2 != r4) goto L_0x0b8c
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r6, r9, r5)
            int r4 = r5.zza
            if (r4 != 0) goto L_0x0b3d
            r13.putObject(r7, r10, r8)
            goto L_0x0b5d
        L_0x0b3d:
            r8 = r12 & r22
            int r12 = r2 + r4
            if (r8 == 0) goto L_0x0b4f
            boolean r8 = com.google.android.gms.internal.play_billing.zzhs.zze(r6, r2, r12)
            if (r8 == 0) goto L_0x0b4a
            goto L_0x0b4f
        L_0x0b4a:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0b4f:
            java.lang.String r8 = new java.lang.String
            r36 = r12
            java.nio.charset.Charset r12 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r8.<init>(r6, r2, r4, r12)
            r13.putObject(r7, r10, r8)
            r2 = r36
        L_0x0b5d:
            r13.putInt(r7, r14, r1)
            r4 = r3
            goto L_0x0c4b
        L_0x0b63:
            r20 = r1
            r1 = r3
            r3 = r5
            r9 = r6
            r6 = r35
            r5 = r39
            if (r2 != 0) goto L_0x0b8c
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r6, r9, r5)
            r36 = r2
            r4 = r3
            long r2 = r5.zzb
            int r8 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x0b7e
            r28 = 1
            goto L_0x0b80
        L_0x0b7e:
            r28 = 0
        L_0x0b80:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r28)
            r13.putObject(r7, r10, r2)
            r13.putInt(r7, r14, r1)
            goto L_0x0c05
        L_0x0b8c:
            r4 = r3
            goto L_0x0c4a
        L_0x0b8f:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r3 = 5
            r6 = r35
            r5 = r39
            if (r2 != r3) goto L_0x0c4a
            int r2 = r9 + 4
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzb(r6, r9)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r13.putObject(r7, r10, r3)
            r13.putInt(r7, r14, r1)
            goto L_0x0c4b
        L_0x0bad:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r3 = 1
            r6 = r35
            r5 = r39
            if (r2 != r3) goto L_0x0c4a
            int r2 = r9 + 8
            long r22 = com.google.android.gms.internal.play_billing.zzdk.zzn(r6, r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            r13.putObject(r7, r10, r3)
            r13.putInt(r7, r14, r1)
            goto L_0x0c4b
        L_0x0bcb:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r6 = r35
            r5 = r39
            if (r2 != 0) goto L_0x0c4a
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r6, r9, r5)
            int r3 = r5.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r13.putObject(r7, r10, r3)
            r13.putInt(r7, r14, r1)
            goto L_0x0c4b
        L_0x0be8:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r6 = r35
            r5 = r39
            if (r2 != 0) goto L_0x0c4a
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r6, r9, r5)
            r36 = r2
            long r2 = r5.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r13.putObject(r7, r10, r2)
            r13.putInt(r7, r14, r1)
        L_0x0c05:
            r2 = r36
            goto L_0x0c4b
        L_0x0c08:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r3 = 5
            r6 = r35
            r5 = r39
            if (r2 != r3) goto L_0x0c4a
            int r2 = r9 + 4
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzb(r6, r9)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r13.putObject(r7, r10, r3)
            r13.putInt(r7, r14, r1)
            goto L_0x0c4b
        L_0x0c29:
            r20 = r1
            r1 = r3
            r4 = r5
            r9 = r6
            r3 = 1
            r6 = r35
            r5 = r39
            if (r2 != r3) goto L_0x0c4a
            int r2 = r9 + 8
            long r22 = com.google.android.gms.internal.play_billing.zzdk.zzn(r6, r9)
            double r22 = java.lang.Double.longBitsToDouble(r22)
            java.lang.Double r3 = java.lang.Double.valueOf(r22)
            r13.putObject(r7, r10, r3)
            r13.putInt(r7, r14, r1)
            goto L_0x0c4b
        L_0x0c4a:
            r2 = r9
        L_0x0c4b:
            if (r2 == r9) goto L_0x0c63
            r14 = r37
            r13 = r38
            r12 = r5
            r15 = r6
            r6 = r17
            r3 = r20
            r5 = r21
            r11 = r29
            r10 = 0
            r32 = r2
            r2 = r1
            r1 = r32
            goto L_0x001b
        L_0x0c63:
            r8 = r38
            r3 = r2
            r10 = r20
        L_0x0c68:
            if (r4 != r8) goto L_0x0c75
            if (r8 == 0) goto L_0x0c75
            r1 = r3
            r6 = r17
            r5 = r21
            r13 = r29
            goto L_0x0ccb
        L_0x0c75:
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0ca0
            com.google.android.gms.internal.play_billing.zzej r2 = r5.zzd
            com.google.android.gms.internal.play_billing.zzej r9 = com.google.android.gms.internal.play_billing.zzej.zza
            if (r2 == r9) goto L_0x0ca0
            com.google.android.gms.internal.play_billing.zzgc r9 = r0.zzg
            com.google.android.gms.internal.play_billing.zzev r2 = r2.zzb(r9, r1)
            if (r2 != 0) goto L_0x0c9c
            com.google.android.gms.internal.play_billing.zzhe r9 = zzd(r34)
            r11 = r1
            r1 = r4
            r2 = r35
            r12 = r4
            r13 = r29
            r4 = r37
            r5 = r9
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzg(r1, r2, r3, r4, r5, r6)
            goto L_0x0cb3
        L_0x0c9c:
            r1 = r7
            com.google.android.gms.internal.play_billing.zzeu r1 = (com.google.android.gms.internal.play_billing.zzeu) r1
            throw r16
        L_0x0ca0:
            r11 = r1
            r12 = r4
            r13 = r29
            com.google.android.gms.internal.play_billing.zzhe r5 = zzd(r34)
            r1 = r12
            r2 = r35
            r4 = r37
            r6 = r39
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzg(r1, r2, r3, r4, r5, r6)
        L_0x0cb3:
            r15 = r35
            r14 = r37
            r3 = r10
            r2 = r11
            r4 = r12
            r11 = r13
            r6 = r17
            r5 = r21
            r10 = 0
            r12 = r39
            r13 = r8
            goto L_0x001b
        L_0x0cc5:
            r21 = r5
            r17 = r6
            r8 = r13
            r13 = r11
        L_0x0ccb:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x0cd4
            long r9 = (long) r6
            r13.putInt(r7, r9, r5)
        L_0x0cd4:
            int r3 = r0.zzj
        L_0x0cd6:
            int r5 = r0.zzk
            if (r3 >= r5) goto L_0x0d01
            int[] r5 = r0.zzi
            int[] r6 = r0.zzc
            r5 = r5[r3]
            r6 = r6[r5]
            int r6 = r0.zzs(r5)
            r6 = r6 & r2
            long r9 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.play_billing.zzhn.zzf(r7, r9)
            if (r6 != 0) goto L_0x0cef
            goto L_0x0cf5
        L_0x0cef:
            com.google.android.gms.internal.play_billing.zzfb r9 = r0.zzu(r5)
            if (r9 != 0) goto L_0x0cf8
        L_0x0cf5:
            int r3 = r3 + 1
            goto L_0x0cd6
        L_0x0cf8:
            com.google.android.gms.internal.play_billing.zzfw r6 = (com.google.android.gms.internal.play_billing.zzfw) r6
            java.lang.Object r1 = r0.zzw(r5)
            com.google.android.gms.internal.play_billing.zzfv r1 = (com.google.android.gms.internal.play_billing.zzfv) r1
            throw r16
        L_0x0d01:
            if (r8 != 0) goto L_0x0d0d
            r2 = r37
            if (r1 != r2) goto L_0x0d08
            goto L_0x0d13
        L_0x0d08:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zze()
            throw r1
        L_0x0d0d:
            r2 = r37
            if (r1 > r2) goto L_0x0d14
            if (r4 != r8) goto L_0x0d14
        L_0x0d13:
            return r1
        L_0x0d14:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zze()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzex = (zzex) obj;
                zzex.zzq(Integer.MAX_VALUE);
                zzex.zza = 0;
                zzex.zzo();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = (long) i2;
                if (zzr != 9) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, this.zzc[i], i)) {
                            zzv(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzr) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzl.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = (long) i2;
            switch (zzr) {
                case 0:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzo(obj, j, zzhn.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 1:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzp(obj, j, zzhn.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 2:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 3:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 4:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 5:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 6:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 7:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzm(obj, j, zzhn.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 8:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 11:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 12:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 13:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 14:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 15:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 16:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzgo.zza;
                    zzhn.zzs(obj, j, zzfx.zza(zzhn.zzf(obj, j), zzhn.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdj zzdj) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdj);
    }

    public final void zzi(Object obj, zzhv zzhv) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        Object obj2 = obj;
        zzhv zzhv2 = zzhv;
        if (!this.zzh) {
            int[] iArr = this.zzc;
            Unsafe unsafe = zzb;
            int i5 = 1048575;
            int i6 = 1048575;
            int i7 = 0;
            int i8 = 0;
            while (i8 < iArr.length) {
                int zzs = zzs(i8);
                int[] iArr2 = this.zzc;
                int zzr = zzr(zzs);
                int i9 = iArr2[i8];
                if (zzr <= 17) {
                    int i10 = iArr2[i8 + 2];
                    int i11 = i10 & i5;
                    if (i11 != i6) {
                        if (i11 == i5) {
                            i4 = 0;
                        } else {
                            i4 = unsafe.getInt(obj2, (long) i11);
                        }
                        i7 = i4;
                        i6 = i11;
                    }
                    i2 = i6;
                    i = i7;
                    i3 = 1 << (i10 >>> 20);
                } else {
                    i2 = i6;
                    i = i7;
                    i3 = 0;
                }
                long j = (long) (zzs & i5);
                switch (zzr) {
                    case 0:
                        long j2 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzf(i9, zzhn.zza(obj2, j2));
                            break;
                        }
                    case 1:
                        long j3 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzo(i9, zzhn.zzb(obj2, j3));
                            break;
                        }
                    case 2:
                        long j4 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzt(i9, unsafe.getLong(obj2, j4));
                            break;
                        }
                    case 3:
                        long j5 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzJ(i9, unsafe.getLong(obj2, j5));
                            break;
                        }
                    case 4:
                        long j6 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzr(i9, unsafe.getInt(obj2, j6));
                            break;
                        }
                    case 5:
                        long j7 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzm(i9, unsafe.getLong(obj2, j7));
                            break;
                        }
                    case 6:
                        long j8 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzk(i9, unsafe.getInt(obj2, j8));
                            break;
                        }
                    case 7:
                        long j9 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzb(i9, zzhn.zzw(obj2, j9));
                            break;
                        }
                    case 8:
                        long j10 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzO(i9, unsafe.getObject(obj2, j10), zzhv2);
                            break;
                        }
                    case 9:
                        long j11 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzv(i9, unsafe.getObject(obj2, j11), zzv(i8));
                            break;
                        }
                    case 10:
                        long j12 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzd(i9, (zzdw) unsafe.getObject(obj2, j12));
                            break;
                        }
                    case 11:
                        long j13 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzH(i9, unsafe.getInt(obj2, j13));
                            break;
                        }
                    case 12:
                        long j14 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzi(i9, unsafe.getInt(obj2, j14));
                            break;
                        }
                    case 13:
                        long j15 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzw(i9, unsafe.getInt(obj2, j15));
                            break;
                        }
                    case 14:
                        long j16 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzy(i9, unsafe.getLong(obj2, j16));
                            break;
                        }
                    case 15:
                        long j17 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzA(i9, unsafe.getInt(obj2, j17));
                            break;
                        }
                    case 16:
                        long j18 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzC(i9, unsafe.getLong(obj2, j18));
                            break;
                        }
                    case 17:
                        long j19 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzq(i9, unsafe.getObject(obj2, j19), zzv(i8));
                            break;
                        }
                    case 18:
                        zzgo.zzs(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 19:
                        zzgo.zzw(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 20:
                        zzgo.zzy(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 21:
                        zzgo.zzE(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 22:
                        zzgo.zzx(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 23:
                        zzgo.zzv(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 24:
                        zzgo.zzu(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 25:
                        zzgo.zzr(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 26:
                        int i12 = this.zzc[i8];
                        List list = (List) unsafe.getObject(obj2, j);
                        int i13 = zzgo.zza;
                        if (list != null && !list.isEmpty()) {
                            zzhv2.zzG(i12, list);
                            break;
                        }
                    case 27:
                        int i14 = this.zzc[i8];
                        List list2 = (List) unsafe.getObject(obj2, j);
                        zzgm zzv = zzv(i8);
                        int i15 = zzgo.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i16 = 0; i16 < list2.size(); i16++) {
                                ((zzef) zzhv2).zzv(i14, list2.get(i16), zzv);
                            }
                            break;
                        }
                    case 28:
                        int i17 = this.zzc[i8];
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i18 = zzgo.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzhv2.zze(i17, list3);
                            break;
                        }
                    case 29:
                        zzgo.zzD(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 30:
                        zzgo.zzt(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 31:
                        zzgo.zzz(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 32:
                        zzgo.zzA(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 33:
                        zzgo.zzB(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 34:
                        zzgo.zzC(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 35:
                        zzgo.zzs(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 36:
                        zzgo.zzw(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 37:
                        zzgo.zzy(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 38:
                        zzgo.zzE(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 39:
                        zzgo.zzx(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 40:
                        zzgo.zzv(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 41:
                        zzgo.zzu(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 42:
                        zzgo.zzr(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 43:
                        zzgo.zzD(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 44:
                        zzgo.zzt(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 45:
                        zzgo.zzz(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 46:
                        zzgo.zzA(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 47:
                        zzgo.zzB(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 48:
                        zzgo.zzC(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 49:
                        int i19 = this.zzc[i8];
                        List list4 = (List) unsafe.getObject(obj2, j);
                        zzgm zzv2 = zzv(i8);
                        int i20 = zzgo.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i21 = 0; i21 < list4.size(); i21++) {
                                ((zzef) zzhv2).zzq(i19, list4.get(i21), zzv2);
                            }
                            break;
                        }
                    case 50:
                        if (unsafe.getObject(obj2, j) == null) {
                            break;
                        } else {
                            zzfv zzfv = (zzfv) zzw(i8);
                            throw null;
                        }
                    case 51:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzf(i9, zzm(obj2, j));
                            break;
                        }
                    case 52:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzo(i9, zzn(obj2, j));
                            break;
                        }
                    case 53:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzt(i9, zzt(obj2, j));
                            break;
                        }
                    case 54:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzJ(i9, zzt(obj2, j));
                            break;
                        }
                    case 55:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzr(i9, zzo(obj2, j));
                            break;
                        }
                    case 56:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzm(i9, zzt(obj2, j));
                            break;
                        }
                    case 57:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzk(i9, zzo(obj2, j));
                            break;
                        }
                    case 58:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzb(i9, zzN(obj2, j));
                            break;
                        }
                    case 59:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzO(i9, unsafe.getObject(obj2, j), zzhv2);
                            break;
                        }
                    case 60:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzv(i9, unsafe.getObject(obj2, j), zzv(i8));
                            break;
                        }
                    case 61:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzd(i9, (zzdw) unsafe.getObject(obj2, j));
                            break;
                        }
                    case 62:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzH(i9, zzo(obj2, j));
                            break;
                        }
                    case 63:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzi(i9, zzo(obj2, j));
                            break;
                        }
                    case 64:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzw(i9, zzo(obj2, j));
                            break;
                        }
                    case 65:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzy(i9, zzt(obj2, j));
                            break;
                        }
                    case 66:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzA(i9, zzo(obj2, j));
                            break;
                        }
                    case 67:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzC(i9, zzt(obj2, j));
                            break;
                        }
                    case 68:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzq(i9, unsafe.getObject(obj2, j), zzv(i8));
                            break;
                        }
                }
                i8 += 3;
                i6 = i2;
                i7 = i;
                i5 = 1048575;
            }
            zzhd zzhd = this.zzm;
            zzhd.zzi(zzhd.zzd(obj2), zzhv2);
            return;
        }
        this.zzn.zza(obj2);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = (long) (zzs & 1048575);
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzhn.zza(obj, j)) == Double.doubleToLongBits(zzhn.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzhn.zzb(obj, j)) == Float.floatToIntBits(zzhn.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzH(obj, obj2, i) && zzhn.zzw(obj, j) == zzhn.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j));
                    break;
                case 50:
                    z = zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzp2 = (long) (zzp(i) & 1048575);
                    if (zzhn.zzc(obj, zzp2) == zzhn.zzc(obj2, zzp2) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i5];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj2, i7, i6) && !zzK(obj2, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfw) zzhn.zzf(obj2, (long) (zzs & 1048575))).isEmpty()) {
                            zzfv zzfv = (zzfv) zzw(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhn.zzf(obj2, (long) (zzs & 1048575));
                if (!list.isEmpty()) {
                    zzgm zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzJ(obj, i6, i2, i, i10) && !zzK(obj2, zzs, zzv(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj2);
        throw null;
    }
}
