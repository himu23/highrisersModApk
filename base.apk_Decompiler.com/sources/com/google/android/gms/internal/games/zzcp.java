package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcp implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzcp(String str, int i, boolean z) {
        this.zza = str;
        this.zzb = i;
        this.zzc = z;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        int i = this.zzb;
        boolean z = this.zzc;
        int i2 = zzcy.zza;
        ((zzbz) obj).zzaD((TaskCompletionSource) obj2, str, i, false, z);
    }
}
