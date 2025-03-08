package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
abstract class zzed extends zzj {
    /* synthetic */ zzed(GoogleApiClient googleApiClient, zzec zzec) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzeb(this, status);
    }
}
