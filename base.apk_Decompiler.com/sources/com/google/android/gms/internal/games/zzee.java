package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzee implements Snapshots.LoadSnapshotsResult {
    final /* synthetic */ Status zza;

    zzee(zzeg zzeg, Status status) {
        this.zza = status;
    }

    public final SnapshotMetadataBuffer getSnapshots() {
        return new SnapshotMetadataBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
