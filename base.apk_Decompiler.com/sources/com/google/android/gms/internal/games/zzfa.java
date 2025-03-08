package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzfa extends zzfd {
    final /* synthetic */ int zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfa(zzfk zzfk, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient, (zzfc) null);
        this.zza = i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzac(this, this.zza);
    }
}
