package com.google.android.gms.internal.drive;

import com.applovin.exoplayer2.common.base.Ascii;

final class zzni extends zznh {
    zzni() {
    }

    /* access modifiers changed from: package-private */
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        while (r10 < i3 && bArr[r10] >= 0) {
            i2 = r10 + 1;
        }
        if (r10 >= i3) {
            return 0;
        }
        while (r10 < i3) {
            int i4 = r10 + 1;
            byte b = bArr[r10];
            if (b >= 0) {
                r10 = i4;
            } else if (b < -32) {
                if (i4 >= i3) {
                    return b;
                }
                if (b >= -62) {
                    r10 += 2;
                    if (bArr[i4] > -65) {
                    }
                }
                return -1;
            } else if (b < -16) {
                if (i4 >= i3 - 1) {
                    return zznf.zzf(bArr, i4, i3);
                }
                int i5 = r10 + 2;
                byte b2 = bArr[i4];
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    r10 += 3;
                    if (bArr[i5] > -65) {
                    }
                }
                return -1;
            } else if (i4 >= i3 - 2) {
                return zznf.zzf(bArr, i4, i3);
            } else {
                int i6 = r10 + 2;
                byte b3 = bArr[i4];
                if (b3 <= -65 && (((b << Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                    int i7 = r10 + 3;
                    if (bArr[i6] <= -65) {
                        r10 += 4;
                        if (bArr[i7] > -65) {
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final String zzg(byte[] bArr, int i, int i2) throws zzkq {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r11 < i3) {
                byte b = bArr[r11];
                if (!zzng.zzd(b)) {
                    break;
                }
                i = r11 + 1;
                zzng.zza(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r11 < i3) {
                int i6 = r11 + 1;
                byte b2 = bArr[r11];
                if (zzng.zzd(b2)) {
                    int i7 = i5 + 1;
                    zzng.zza(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = bArr[i6];
                        if (!zzng.zzd(b3)) {
                            break;
                        }
                        i6++;
                        zzng.zza(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    r11 = i6;
                } else if (zzng.zze(b2)) {
                    if (i6 < i3) {
                        r11 += 2;
                        zzng.zza(b2, bArr[i6], cArr, i5);
                        i5++;
                    } else {
                        throw zzkq.zzdn();
                    }
                } else if (zzng.zzf(b2)) {
                    if (i6 < i3 - 1) {
                        int i8 = r11 + 2;
                        r11 += 3;
                        zzng.zza(b2, bArr[i6], bArr[i8], cArr, i5);
                        i5++;
                    } else {
                        throw zzkq.zzdn();
                    }
                } else if (i6 < i3 - 2) {
                    byte b4 = bArr[i6];
                    int i9 = r11 + 3;
                    byte b5 = bArr[r11 + 2];
                    r11 += 4;
                    zzng.zza(b2, b4, b5, bArr[i9], cArr, i5);
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
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
                throw new zznj(i6 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i7);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new zznj(i6, length);
            }
            i6++;
        }
        return i7;
    }
}
