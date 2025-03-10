package com.google.android.gms.internal.auth;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdt {
    static int zza(byte[] bArr, int i, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i, zzds);
        int i2 = zzds.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        } else if (i2 > bArr.length - zzj) {
            throw zzfa.zzf();
        } else if (i2 == 0) {
            zzds.zzc = zzee.zzb;
            return zzj;
        } else {
            zzds.zzc = zzee.zzk(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Ascii.DLE);
    }

    static int zzc(zzgh zzgh, byte[] bArr, int i, int i2, int i3, zzds zzds) throws IOException {
        zzfz zzfz = (zzfz) zzgh;
        Object zzd = zzfz.zzd();
        int zzb = zzfz.zzb(zzd, bArr, i, i2, i3, zzds);
        zzfz.zze(zzd);
        zzds.zzc = zzd;
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.auth.zzgh r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.auth.zzds r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zzd()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzg(r1, r2, r3, r4, r5)
            r6.zze(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.auth.zzfa r6 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzdt.zzd(com.google.android.gms.internal.auth.zzgh, byte[], int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    static int zze(zzgh zzgh, int i, byte[] bArr, int i2, int i3, zzey zzey, zzds zzds) throws IOException {
        int zzd = zzd(zzgh, bArr, i2, i3, zzds);
        zzey.add(zzds.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzds);
            if (i != zzds.zza) {
                break;
            }
            zzd = zzd(zzgh, bArr, zzj, i3, zzds);
            zzey.add(zzds.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzey zzey, zzds zzds) throws IOException {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i, zzds);
        int i2 = zzds.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzds);
            zzev.zze(zzds.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    static int zzg(byte[] bArr, int i, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i, zzds);
        int i2 = zzds.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        } else if (i2 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = new String(bArr, zzj, i2, zzez.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i, zzds);
        int i2 = zzds.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        } else if (i2 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = zzhm.zzb(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzgz zzgz, zzds zzds) throws zzfa {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzds);
                zzgz.zzf(i, Long.valueOf(zzds.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzgz.zzf(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzds);
                int i5 = zzds.zza;
                if (i5 < 0) {
                    throw zzfa.zzc();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzgz.zzf(i, zzee.zzb);
                    } else {
                        zzgz.zzf(i, zzee.zzk(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzfa.zzf();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzgz zzc = zzgz.zzc();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzds);
                    int i8 = zzds.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zzc, zzds);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzfa.zzd();
                }
                zzgz.zzf(i, zzc);
                return i2;
            } else if (i4 == 5) {
                zzgz.zzf(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzfa.zza();
            }
        } else {
            throw zzfa.zza();
        }
    }

    static int zzj(byte[] bArr, int i, zzds zzds) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzds);
        }
        zzds.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzds zzds) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzds.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzds.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzds.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzds.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzds.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzey zzey, zzds zzds) {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i2, zzds);
        zzev.zze(zzds.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzds);
            if (i != zzds.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzds);
            zzev.zze(zzds.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzds zzds) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzds.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzds.zzb = j2;
        return i3;
    }

    static long zzn(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
