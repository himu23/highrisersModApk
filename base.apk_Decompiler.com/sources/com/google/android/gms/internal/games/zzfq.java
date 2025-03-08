package com.google.android.gms.internal.games;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzfq {
    public IBinder zza;
    public int zzb;
    public int zzc = -1;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;
    public int zzg = 0;

    public zzfq(int i, IBinder iBinder) {
        this.zzb = i;
        this.zza = null;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", this.zzb);
        bundle.putInt("popupLocationInfo.displayId", this.zzc);
        bundle.putInt("popupLocationInfo.left", this.zzd);
        bundle.putInt("popupLocationInfo.top", this.zze);
        bundle.putInt("popupLocationInfo.right", this.zzf);
        bundle.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle;
    }
}
