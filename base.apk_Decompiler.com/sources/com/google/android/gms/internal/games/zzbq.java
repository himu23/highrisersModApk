package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzbq implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzbq(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        long j = this.zzb;
        int i = zzbt.zza;
        ((zzbz) obj).zzaY((TaskCompletionSource) obj2, str, j, (String) null);
    }
}
