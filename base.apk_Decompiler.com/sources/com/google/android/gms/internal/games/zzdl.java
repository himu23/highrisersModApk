package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdl implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ SnapshotMetadataChange zzc;
    public final /* synthetic */ SnapshotContents zzd;

    public /* synthetic */ zzdl(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = snapshotMetadataChange;
        this.zzd = snapshotContents;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        String str2 = this.zzb;
        SnapshotMetadataChange snapshotMetadataChange = this.zzc;
        SnapshotContents snapshotContents = this.zzd;
        int i = zzds.zza;
        ((zzbz) obj).zzaN((TaskCompletionSource) obj2, str, str2, snapshotMetadataChange, snapshotContents);
    }
}
