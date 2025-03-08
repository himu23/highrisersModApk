package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzdw extends zzed {
    final /* synthetic */ SnapshotMetadata zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdw(zzek zzek, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        super(googleApiClient, (zzec) null);
        this.zza = snapshotMetadata;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzQ(this, this.zza.getSnapshotId());
    }
}
