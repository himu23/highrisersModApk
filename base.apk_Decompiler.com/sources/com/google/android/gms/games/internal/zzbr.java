package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
class zzbr extends zza {
    private final BaseImplementation.ResultHolder zza;

    zzbr(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
    }

    /* access modifiers changed from: package-private */
    public final void zzw(Object obj) {
        this.zza.setResult(obj);
    }
}
