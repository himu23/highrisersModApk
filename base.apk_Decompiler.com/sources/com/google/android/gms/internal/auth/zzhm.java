package com.google.android.gms.internal.auth;

import com.applovin.exoplayer2.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << Ascii.DLE);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b > -12) {
            return -1;
        } else {
            return b;
        }
        return -1;
    }

    static String zzb(byte[] bArr, int i, int i2) throws zzfa {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r10 < i4) {
                byte b = bArr[r10];
                if (!zzhj.zzd(b)) {
                    break;
                }
                i = r10 + 1;
                cArr[i3] = (char) b;
                i5 = i3 + 1;
            }
            while (r10 < i4) {
                int i6 = r10 + 1;
                byte b2 = bArr[r10];
                if (zzhj.zzd(b2)) {
                    cArr[i3] = (char) b2;
                    i3++;
                    r10 = i6;
                    while (r10 < i4) {
                        byte b3 = bArr[r10];
                        if (!zzhj.zzd(b3)) {
                            break;
                        }
                        r10++;
                        cArr[i3] = (char) b3;
                        i3++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i4) {
                        r10 += 2;
                        zzhj.zzc(b2, bArr[i6], cArr, i3);
                        i3++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b2 < -16) {
                    if (i6 < i4 - 1) {
                        int i7 = r10 + 2;
                        r10 += 3;
                        zzhj.zzb(b2, bArr[i6], bArr[i7], cArr, i3);
                        i3++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i6 < i4 - 2) {
                    int i8 = r10 + 2;
                    int i9 = r10 + 3;
                    r10 += 4;
                    byte b4 = bArr[i6];
                    zzhj.zza(b2, b4, bArr[i8], bArr[i9], cArr, i3);
                    i3 += 2;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
