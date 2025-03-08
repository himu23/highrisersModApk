package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzdv extends zzea {
    final /* synthetic */ Snapshot zza;
    final /* synthetic */ SnapshotMetadataChange zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdv(zzek zzek, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        super(googleApiClient, (zzdz) null);
        this.zza = snapshot;
        this.zzb = snapshotMetadataChange;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzO(this, this.zza, this.zzb);
    }
}
