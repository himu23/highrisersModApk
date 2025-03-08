package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzai extends zzan {
    final /* synthetic */ boolean zza;
    final /* synthetic */ String[] zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzar zzar, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
        super(googleApiClient, (zzam) null);
        this.zza = z;
        this.zzb = strArr;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzak(this, this.zza, this.zzb);
    }
}
