package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzbo implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbo(String str, long j, String str2) {
        this.zza = str;
        this.zzb = j;
        this.zzc = str2;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        long j = this.zzb;
        String str2 = this.zzc;
        int i = zzbt.zza;
        ((zzbz) obj).zzaY((TaskCompletionSource) obj2, str, j, str2);
    }
}
