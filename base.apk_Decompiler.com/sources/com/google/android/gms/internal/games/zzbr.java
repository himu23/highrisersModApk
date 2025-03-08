package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzbr implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzbr(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        long j = this.zzb;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        int i = zzbt.zza;
        ((zzbz) obj).zzaW(str, j, (String) null);
    }
}
