package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzx extends zzq implements PlayerRelationshipInfo {
    private final zzd zza;

    public zzx(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zza = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zzv.zzf(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new zzv(this);
    }

    public final int getFriendStatus() {
        return zzq(this.zza.zzH, -1);
    }

    public final int hashCode() {
        return zzv.zzd(this);
    }

    public final String toString() {
        return zzv.zze(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzw.zza(new zzv(this), parcel, i);
    }

    public final String zza() {
        return zzr(this.zza.zzJ, (String) null);
    }

    public final String zzb() {
        return zzr(this.zza.zzI, (String) null);
    }

    public final String zzc() {
        return zzr(this.zza.zzK, (String) null);
    }
}
