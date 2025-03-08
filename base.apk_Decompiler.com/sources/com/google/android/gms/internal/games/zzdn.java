package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdn implements RemoteCall {
    public final /* synthetic */ Snapshot zza;
    public final /* synthetic */ SnapshotMetadataChange zzb;

    public /* synthetic */ zzdn(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        this.zza = snapshot;
        this.zzb = snapshotMetadataChange;
    }

    public final void accept(Object obj, Object obj2) {
        Snapshot snapshot = this.zza;
        SnapshotMetadataChange snapshotMetadataChange = this.zzb;
        int i = zzds.zza;
        ((zzbz) obj).zzP((TaskCompletionSource) obj2, snapshot, snapshotMetadataChange);
    }
}
