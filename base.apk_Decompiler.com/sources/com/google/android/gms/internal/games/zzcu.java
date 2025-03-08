package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcu implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzcu(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        boolean z = this.zzb;
        int i = zzcy.zza;
        ((zzbz) obj).zzaw((TaskCompletionSource) obj2, str, z);
    }
}
