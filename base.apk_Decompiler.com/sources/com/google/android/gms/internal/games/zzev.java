package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzev implements RemoteCall {
    public final /* synthetic */ int zza;

    public /* synthetic */ zzev(int i) {
        this.zza = i;
    }

    public final void accept(Object obj, Object obj2) {
        int i = this.zza;
        int i2 = zzex.zza;
        ((zzbz) obj).zzad((TaskCompletionSource) obj2, i);
    }
}
