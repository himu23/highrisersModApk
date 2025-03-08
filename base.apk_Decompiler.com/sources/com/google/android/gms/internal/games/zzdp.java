package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdp implements RemoteCall {
    public static final /* synthetic */ zzdp zza = new zzdp();

    private /* synthetic */ zzdp() {
    }

    public final void accept(Object obj, Object obj2) {
        int i = zzds.zza;
        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((zzbz) obj).zzr()));
    }
}
