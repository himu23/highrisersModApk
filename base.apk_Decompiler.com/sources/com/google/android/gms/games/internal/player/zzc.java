package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzc extends DataBufferRef implements zza {
    private final zzd zza;

    public zzc(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zza = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zzi(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzh(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new MostRecentGameInfoEntity(this), parcel, i);
    }

    public final long zza() {
        return getLong(this.zza.zzv);
    }

    public final Uri zzb() {
        return parseUri(this.zza.zzy);
    }

    public final Uri zzc() {
        return parseUri(this.zza.zzx);
    }

    public final Uri zzd() {
        return parseUri(this.zza.zzw);
    }

    public final String zze() {
        return getString(this.zza.zzt);
    }

    public final String zzf() {
        return getString(this.zza.zzu);
    }
}
