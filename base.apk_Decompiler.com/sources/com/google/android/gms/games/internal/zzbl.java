package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbl extends zzao implements Snapshots.OpenSnapshotResult {
    private final Snapshot zza;
    private final String zzb;
    private final Snapshot zzc;
    private final SnapshotContents zzd;

    /* JADX INFO: finally extract failed */
    zzbl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
        super(dataHolder);
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            if (snapshotMetadataBuffer.getCount() == 0) {
                this.zza = null;
                this.zzc = null;
            } else {
                boolean z = true;
                if (snapshotMetadataBuffer.getCount() == 1) {
                    if (dataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    Asserts.checkState(z);
                    this.zza = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzc = null;
                } else {
                    this.zza = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzc = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                }
            }
            snapshotMetadataBuffer.release();
            this.zzb = str;
            this.zzd = new SnapshotContentsEntity(contents3);
        } catch (Throwable th) {
            snapshotMetadataBuffer.release();
            throw th;
        }
    }

    public final String getConflictId() {
        return this.zzb;
    }

    public final Snapshot getConflictingSnapshot() {
        return this.zzc;
    }

    public final SnapshotContents getResolutionSnapshotContents() {
        return this.zzd;
    }

    public final Snapshot getSnapshot() {
        return this.zza;
    }
}
