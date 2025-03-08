package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzv extends zzab {
    final /* synthetic */ String zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzac zzac, String str, GoogleApiClient googleApiClient, String str2, int i) {
        super(str, googleApiClient);
        this.zza = str2;
        this.zzb = i;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzZ(this, this.zza, this.zzb);
    }
}
