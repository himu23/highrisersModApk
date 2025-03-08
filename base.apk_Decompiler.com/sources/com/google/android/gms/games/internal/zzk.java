package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.video.CaptureState;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzk extends zzbr {
    zzk(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zze(int i, Bundle bundle) {
        zzw(new zzaf(new Status(i), CaptureState.zza(bundle)));
    }
}
