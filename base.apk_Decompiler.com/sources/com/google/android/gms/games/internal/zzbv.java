package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbv extends zza {
    private final TaskCompletionSource zza;

    zzbv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzq(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            if (snapshotMetadataBuffer.getCount() >= 2 && str != null) {
                if (contents3 != null) {
                    SnapshotEntity snapshotEntity = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    SnapshotEntity snapshotEntity2 = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    snapshotMetadataBuffer.close();
                    this.zza.setResult(new SnapshotsClient.DataOrConflict((Object) null, new SnapshotsClient.SnapshotConflict(snapshotEntity, str, snapshotEntity2, new SnapshotContentsEntity(contents3))));
                    return;
                }
            }
            this.zza.setResult(null);
            snapshotMetadataBuffer.close();
            return;
        } catch (Throwable th) {
            zzbu.zza(th, th);
        }
        throw th;
    }

    public final void zzs(DataHolder dataHolder, Contents contents) {
        int statusCode = dataHolder.getStatusCode();
        SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
        try {
            SnapshotEntity snapshotEntity = snapshotMetadataBuffer.getCount() > 0 ? new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents)) : null;
            snapshotMetadataBuffer.close();
            if (statusCode == 0) {
                this.zza.setResult(new SnapshotsClient.DataOrConflict(snapshotEntity, (SnapshotsClient.SnapshotConflict) null));
                return;
            }
            if (statusCode == 4002) {
                if (snapshotEntity == null || snapshotEntity.getMetadata() == null) {
                    statusCode = 4002;
                } else {
                    this.zza.setException(new SnapshotsClient.SnapshotContentUnavailableApiException(GamesStatusCodes.zza(4002), snapshotEntity.getMetadata()));
                    return;
                }
            }
            GamesStatusUtils.zza(this.zza, statusCode);
            return;
        } catch (Throwable th) {
            zzbu.zza(th, th);
        }
        throw th;
    }
}
