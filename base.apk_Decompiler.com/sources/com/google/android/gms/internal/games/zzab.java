package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
abstract class zzab extends zzj {
    /* access modifiers changed from: private */
    public final String zza;

    public zzab(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zza = str;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzaa(this, status);
    }
}
