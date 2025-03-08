package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
class zzaw extends zza {
    private final ListenerHolder zza;

    zzaw(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
    }

    /* access modifiers changed from: package-private */
    public final void zzw(zzbq zzbq) {
        ListenerHolder listenerHolder = this.zza;
        int i = zzbz.zze;
        listenerHolder.notifyListener(new zzr(zzbq));
    }
}
