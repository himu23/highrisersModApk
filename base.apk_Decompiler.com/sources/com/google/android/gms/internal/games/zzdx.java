package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzdx extends zzej {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ SnapshotMetadataChange zzc;
    final /* synthetic */ SnapshotContents zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdx(zzek zzek, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        super(googleApiClient, (zzei) null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = snapshotMetadataChange;
        this.zzd = snapshotContents;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) anyClient).zzaM(this, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
