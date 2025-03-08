package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzds extends zzad implements SnapshotsClient {
    public static final /* synthetic */ int zza = 0;

    public zzds(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<SnapshotMetadata> commitAndClose(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return doWrite(TaskApiCall.builder().run(new zzdn(snapshot, snapshotMetadataChange)).setMethodKey(6672).build());
    }

    public final Task<String> delete(SnapshotMetadata snapshotMetadata) {
        return doWrite(TaskApiCall.builder().run(new zzdj(snapshotMetadata)).setMethodKey(6674).build());
    }

    public final Task<Void> discardAndClose(Snapshot snapshot) {
        return doWrite(TaskApiCall.builder().run(new zzdq(snapshot)).setMethodKey(6673).build());
    }

    public final Task<Integer> getMaxCoverImageSize() {
        return doRead(TaskApiCall.builder().run(zzdo.zza).setMethodKey(6668).build());
    }

    public final Task<Integer> getMaxDataSize() {
        return doRead(TaskApiCall.builder().run(zzdp.zza).setMethodKey(6667).build());
    }

    public final Task<Intent> getSelectSnapshotIntent(String str, boolean z, boolean z2, int i) {
        return doRead(TaskApiCall.builder().run(new zzdk(str, z, z2, i)).setMethodKey(6669).build());
    }

    public final Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzdr(z)).setMethodKey(6670).build());
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        SnapshotMetadataChange build = builder.build();
        return doWrite(TaskApiCall.builder().run(new zzdl(str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents())).setMethodKey(6675).build());
    }

    public zzds(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i) {
        return open(snapshotMetadata.getUniqueName(), false, i);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(String str, boolean z) {
        return open(str, z, -1);
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(String str, boolean z, int i) {
        return doWrite(TaskApiCall.builder().run(new zzdm(str, z, i)).setMethodKey(6671).build());
    }

    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return doWrite(TaskApiCall.builder().run(new zzdl(str, str2, snapshotMetadataChange, snapshotContents)).setMethodKey(6675).build());
    }
}
