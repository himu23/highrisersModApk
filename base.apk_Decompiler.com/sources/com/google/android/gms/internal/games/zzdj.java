package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdj implements RemoteCall {
    public final /* synthetic */ SnapshotMetadata zza;

    public /* synthetic */ zzdj(SnapshotMetadata snapshotMetadata) {
        this.zza = snapshotMetadata;
    }

    public final void accept(Object obj, Object obj2) {
        SnapshotMetadata snapshotMetadata = this.zza;
        int i = zzds.zza;
        ((zzbz) obj).zzR((TaskCompletionSource) obj2, snapshotMetadata.getSnapshotId());
    }
}
