package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class PlayerLevel extends zzc {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new zzt();
    private final int zza;
    private final long zzb;
    private final long zzc;

    public PlayerLevel(int i, long j, long j2) {
        boolean z = true;
        Preconditions.checkState(j >= 0, "Min XP must be positive!");
        Preconditions.checkState(j2 <= j ? false : z, "Max XP must be more than min XP!");
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return Objects.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && Objects.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && Objects.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zza;
    }

    public long getMaxXp() {
        return this.zzc;
    }

    public long getMinXp() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("LevelNumber", Integer.valueOf(getLevelNumber())).add("MinXp", Long.valueOf(getMinXp())).add("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getLevelNumber());
        SafeParcelWriter.writeLong(parcel, 2, getMinXp());
        SafeParcelWriter.writeLong(parcel, 3, getMaxXp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
