package com.google.android.gms.internal.drive;

final class zzjk {
    private final byte[] buffer;
    private final zzjr zznx;

    private zzjk(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zznx = zzjr.zzb(bArr);
    }

    public final zzjr zzby() {
        return this.zznx;
    }

    public final zzjc zzbx() {
        this.zznx.zzcb();
        return new zzjm(this.buffer);
    }

    /* synthetic */ zzjk(int i, zzjd zzjd) {
        this(i);
    }
}
