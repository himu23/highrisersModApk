package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbv extends zzcd {
    final /* synthetic */ String zza;
    final /* synthetic */ boolean zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbv(zzcm zzcm, GoogleApiClient googleApiClient, String str, boolean z) {
        super(googleApiClient, (zzcc) null);
        this.zza = str;
        this.zzb = z;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaq(this, this.zza, this.zzb);
    }
}
