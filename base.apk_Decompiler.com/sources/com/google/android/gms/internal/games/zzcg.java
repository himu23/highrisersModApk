package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
abstract class zzcg extends zzj {
    /* synthetic */ zzcg(GoogleApiClient googleApiClient, zzcf zzcf) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzce(this, status);
    }
}
