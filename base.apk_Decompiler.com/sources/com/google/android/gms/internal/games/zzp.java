package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzp extends zzz {
    final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(zzac zzac, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzy) null);
        this.zza = z;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzae(this, this.zza);
    }
}
