package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzaj implements Snapshots.DeleteSnapshotResult {
    private final Status zza;
    private final String zzb;

    zzaj(int i, String str) {
        this.zza = GamesStatusCodes.zza(i);
        this.zzb = str;
    }

    public final String getSnapshotId() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
