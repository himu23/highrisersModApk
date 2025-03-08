package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbw extends zzcg {
    final /* synthetic */ String zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbw(zzcm zzcm, GoogleApiClient googleApiClient, String str, int i, int i2) {
        super(googleApiClient, (zzcf) null);
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaz(this, (String) null, this.zza, this.zzb, this.zzc);
    }
}
