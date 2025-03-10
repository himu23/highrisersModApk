package com.google.android.gms.internal.drive;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class zziy {
    static int zza(byte[] bArr, int i, zziz zziz) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zziz);
        }
        zziz.zznk = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zziz zziz) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zziz.zznk = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zziz.zznk = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zziz.zznk = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zziz.zznk = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zziz.zznk = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zziz zziz) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zziz.zznl = j;
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
        zziz.zznl = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Ascii.DLE);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zziz zziz) throws zzkq {
        int zza = zza(bArr, i, zziz);
        int i2 = zziz.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        } else if (i2 == 0) {
            zziz.zznm = "";
            return zza;
        } else {
            zziz.zznm = new String(bArr, zza, i2, zzkm.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zziz zziz) throws zzkq {
        int zza = zza(bArr, i, zziz);
        int i2 = zziz.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        } else if (i2 == 0) {
            zziz.zznm = "";
            return zza;
        } else {
            zziz.zznm = zznf.zzg(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zziz zziz) throws zzkq {
        int zza = zza(bArr, i, zziz);
        int i2 = zziz.zznk;
        if (i2 < 0) {
            throw zzkq.zzdj();
        } else if (i2 > bArr.length - zza) {
            throw zzkq.zzdi();
        } else if (i2 == 0) {
            zziz.zznm = zzjc.zznq;
            return zza;
        } else {
            zziz.zznm = zzjc.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.drive.zzmf r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.drive.zziz r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.drive.zziz) r10)
            int r8 = r10.zznk
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzd(r9)
            r10.zznm = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.drive.zzkq r6 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zziy.zza(com.google.android.gms.internal.drive.zzmf, byte[], int, int, com.google.android.gms.internal.drive.zziz):int");
    }

    static int zza(zzmf zzmf, byte[] bArr, int i, int i2, int i3, zziz zziz) throws IOException {
        zzlu zzlu = (zzlu) zzmf;
        Object newInstance = zzlu.newInstance();
        int zza = zzlu.zza(newInstance, bArr, i, i2, i3, zziz);
        zzlu.zzd(newInstance);
        zziz.zznm = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzkp<?> zzkp, zziz zziz) {
        zzkl zzkl = (zzkl) zzkp;
        int zza = zza(bArr, i2, zziz);
        zzkl.zzam(zziz.zznk);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zziz);
            if (i != zziz.zznk) {
                break;
            }
            zza = zza(bArr, zza2, zziz);
            zzkl.zzam(zziz.zznk);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzkp<?> zzkp, zziz zziz) throws IOException {
        zzkl zzkl = (zzkl) zzkp;
        int zza = zza(bArr, i, zziz);
        int i2 = zziz.zznk + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zziz);
            zzkl.zzam(zziz.zznk);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzkq.zzdi();
    }

    static int zza(zzmf<?> zzmf, int i, byte[] bArr, int i2, int i3, zzkp<?> zzkp, zziz zziz) throws IOException {
        int zza = zza((zzmf) zzmf, bArr, i2, i3, zziz);
        zzkp.add(zziz.zznm);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zziz);
            if (i != zziz.zznk) {
                break;
            }
            zza = zza((zzmf) zzmf, bArr, zza2, i3, zziz);
            zzkp.add(zziz.zznm);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzmy zzmy, zziz zziz) throws zzkq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zziz);
                zzmy.zzb(i, Long.valueOf(zziz.zznl));
                return zzb;
            } else if (i4 == 1) {
                zzmy.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zziz);
                int i5 = zziz.zznk;
                if (i5 < 0) {
                    throw zzkq.zzdj();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzmy.zzb(i, zzjc.zznq);
                    } else {
                        zzmy.zzb(i, zzjc.zzb(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzkq.zzdi();
                }
            } else if (i4 == 3) {
                zzmy zzfb = zzmy.zzfb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zziz);
                    int i8 = zziz.zznk;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzfb, zziz);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzkq.zzdm();
                }
                zzmy.zzb(i, zzfb);
                return i2;
            } else if (i4 == 5) {
                zzmy.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzkq.zzdk();
            }
        } else {
            throw zzkq.zzdk();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zziz zziz) throws zzkq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zziz);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zziz) + zziz.zznk;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zziz);
                    i6 = zziz.zznk;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zziz);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzkq.zzdm();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzkq.zzdk();
            }
        } else {
            throw zzkq.zzdk();
        }
    }
}
