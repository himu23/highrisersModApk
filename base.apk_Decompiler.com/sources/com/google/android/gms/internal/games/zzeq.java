package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzeq implements RemoteCall {
    public static final /* synthetic */ zzeq zza = new zzeq();

    private /* synthetic */ zzeq() {
    }

    public final void accept(Object obj, Object obj2) {
        int i = zzex.zza;
        ((TaskCompletionSource) obj2).setResult(Boolean.valueOf(((zzbz) obj).zzbd()));
    }
}
