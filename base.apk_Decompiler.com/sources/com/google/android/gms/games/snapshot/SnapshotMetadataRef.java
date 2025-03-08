package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.ironsource.m2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    private final Game zza;
    private final Player zzb;

    public SnapshotMetadataRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zza = new GameRef(dataHolder, i);
        this.zzb = new PlayerRef(dataHolder, i, (String) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return SnapshotMetadataEntity.zzd(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new SnapshotMetadataEntity(this);
    }

    public final float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        float f2 = getFloat("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public final Uri getCoverImageUri() {
        return parseUri("cover_icon_image_uri");
    }

    public String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public final String getDescription() {
        return getString("description");
    }

    public final String getDeviceName() {
        return getString("device_name");
    }

    public final Game getGame() {
        return this.zza;
    }

    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public final Player getOwner() {
        return this.zzb;
    }

    public final long getPlayedTime() {
        return getLong(IronSourceConstants.EVENTS_DURATION);
    }

    public final long getProgressValue() {
        return getLong("progress_value");
    }

    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    public final String getUniqueName() {
        return getString("unique_name");
    }

    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public final int hashCode() {
        return SnapshotMetadataEntity.zzb(this);
    }

    public final String toString() {
        return SnapshotMetadataEntity.zzc(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new SnapshotMetadataEntity(this).writeToParcel(parcel, i);
    }

    public final String zza() {
        return getString(m2.h.D0);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }
}
