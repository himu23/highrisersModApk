package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdq implements RemoteCall {
    public final /* synthetic */ Snapshot zza;

    public /* synthetic */ zzdq(Snapshot snapshot) {
        this.zza = snapshot;
    }

    public final void accept(Object obj, Object obj2) {
        Snapshot snapshot = this.zza;
        int i = zzds.zza;
        ((zzbz) obj).zzS(snapshot);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
