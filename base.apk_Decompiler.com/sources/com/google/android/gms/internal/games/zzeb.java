package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzeb implements Snapshots.DeleteSnapshotResult {
    final /* synthetic */ Status zza;

    zzeb(zzed zzed, Status status) {
        this.zza = status;
    }

    public final String getSnapshotId() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
