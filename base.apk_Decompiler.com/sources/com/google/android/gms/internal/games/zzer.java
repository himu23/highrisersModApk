package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzer implements RemoteCall {
    public static final /* synthetic */ zzer zza = new zzer();

    private /* synthetic */ zzer() {
    }

    public final void accept(Object obj, Object obj2) {
        int i = zzex.zza;
        ((TaskCompletionSource) obj2).setResult(((zzbz) obj).zzv());
    }
}
