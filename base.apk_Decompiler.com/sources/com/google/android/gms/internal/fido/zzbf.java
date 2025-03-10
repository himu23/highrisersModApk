package com.google.android.gms.internal.fido;

import com.ironsource.z3;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public abstract class zzbf {
    private static final zzbf zza;
    private static final zzbf zzb;
    private static final zzbf zzc;
    private static final zzbf zzd;
    private static final zzbf zze = new zzbc("base16()", "0123456789ABCDEF");

    static {
        Character valueOf = Character.valueOf(z3.R);
        zza = new zzbd("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzbd("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzbe("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzbe("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    zzbf() {
    }

    public static zzbf zzd() {
        return zze;
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzb(int i);

    public final String zze(byte[] bArr, int i, int i2) {
        zzam.zze(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzb(i2));
        try {
            zza(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
