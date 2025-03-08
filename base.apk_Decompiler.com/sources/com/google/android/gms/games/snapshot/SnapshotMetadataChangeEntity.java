package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class SnapshotMetadataChangeEntity extends zzc implements SnapshotMetadataChange {
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    private final String zza;
    private final Long zzb;
    private final Uri zzc;
    private BitmapTeleporter zzd;
    private final Long zze;

    SnapshotMetadataChangeEntity() {
        this((String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzd;
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    public final String getDescription() {
        return this.zza;
    }

    public final Long getPlayedTimeMillis() {
        return this.zzb;
    }

    public final Long getProgressValue() {
        return this.zze;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLongObject(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeLongObject(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final BitmapTeleporter zza() {
        return this.zzd;
    }

    SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this.zza = str;
        this.zzb = l;
        this.zzd = bitmapTeleporter;
        this.zzc = uri;
        this.zze = l2;
        boolean z = true;
        if (!(bitmapTeleporter == null || uri == null)) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot set both a URI and an image");
    }
}
