package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcn implements RemoteCall {
    public final /* synthetic */ boolean zza;

    public /* synthetic */ zzcn(boolean z) {
        this.zza = z;
    }

    public final void accept(Object obj, Object obj2) {
        boolean z = this.zza;
        int i = zzco.zza;
        ((zzbz) obj).zzaB((TaskCompletionSource) obj2, z);
    }
}
