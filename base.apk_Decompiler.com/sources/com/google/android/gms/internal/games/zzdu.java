package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzdu extends zzej {
    final /* synthetic */ String zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdu(zzek zzek, GoogleApiClient googleApiClient, String str, boolean z, int i) {
        super(googleApiClient, (zzei) null);
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaI(this, this.zza, this.zzb, this.zzc);
    }
}
