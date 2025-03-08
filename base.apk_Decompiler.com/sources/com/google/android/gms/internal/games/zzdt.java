package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzdt extends zzeg {
    final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdt(zzek zzek, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzef) null);
        this.zza = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaE(this, this.zza);
    }
}
