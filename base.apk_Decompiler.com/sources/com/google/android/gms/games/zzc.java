package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzc extends zzq implements CurrentPlayerInfo {
    private final zzd zza;

    public zzc(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zza = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza.zzc(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new zza((CurrentPlayerInfo) this);
    }

    public final int getFriendsListVisibilityStatus() {
        return zzq(this.zza.zzL, 0);
    }

    public final int hashCode() {
        return zza.zza(this);
    }

    public final String toString() {
        return zza.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new zza((CurrentPlayerInfo) this), parcel, i);
    }

    public final boolean zza() {
        return hasColumn(this.zza.zzL) && !hasNull(this.zza.zzL);
    }
}
