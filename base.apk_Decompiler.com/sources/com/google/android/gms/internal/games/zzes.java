package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzes implements RemoteCall {
    public final /* synthetic */ ListenerHolder zza;

    public /* synthetic */ zzes(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    public final void accept(Object obj, Object obj2) {
        ListenerHolder listenerHolder = this.zza;
        int i = zzex.zza;
        ((zzbz) obj).zzaL(listenerHolder);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
