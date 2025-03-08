package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzca extends zzcl {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzca(zzcm zzcm, GoogleApiClient googleApiClient, String str, long j, String str2) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = j;
        this.zzc = str2;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaX(this, this.zza, this.zzb, this.zzc);
    }
}
