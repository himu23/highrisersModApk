package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdm implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdm(String str, boolean z, int i) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        int i2 = zzds.zza;
        ((zzbz) obj).zzaJ((TaskCompletionSource) obj2, str, z, i);
    }
}
