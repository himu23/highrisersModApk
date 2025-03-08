package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzas implements RemoteCall {
    public final /* synthetic */ int zza;

    public /* synthetic */ zzas(int i) {
        this.zza = i;
    }

    public final void accept(Object obj, Object obj2) {
        int i = this.zza;
        int i2 = zzay.zza;
        ((zzbz) obj).zzaS(i);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
