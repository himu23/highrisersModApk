package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzbm implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ boolean zze;

    public /* synthetic */ zzbm(String str, int i, int i2, int i3, boolean z) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        int i = this.zzb;
        int i2 = this.zzc;
        int i3 = this.zzd;
        boolean z = this.zze;
        int i4 = zzbt.zza;
        ((zzbz) obj).zzaH((TaskCompletionSource) obj2, str, i, i2, i3, z);
    }
}
