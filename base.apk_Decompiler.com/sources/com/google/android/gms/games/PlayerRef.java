package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzc;
import com.google.android.gms.games.internal.player.zzd;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class PlayerRef extends zzq implements Player {
    private final zzd zza;
    private final PlayerLevelInfo zzb;
    private final zzc zzc;
    private final zzx zzd;
    private final zzc zze;

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        PlayerLevel playerLevel;
        zzd zzd2 = new zzd((String) null);
        this.zza = zzd2;
        this.zzc = new zzc(dataHolder, i, zzd2);
        this.zzd = new zzx(dataHolder, i, zzd2);
        this.zze = new zzc(dataHolder, i, zzd2);
        if (!hasNull(zzd2.zzk) && getLong(zzd2.zzk) != -1) {
            int integer = getInteger(zzd2.zzl);
            int integer2 = getInteger(zzd2.zzo);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(zzd2.zzm), getLong(zzd2.zzn));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(zzd2.zzn), getLong(zzd2.zzp));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzb = new PlayerLevelInfo(getLong(zzd2.zzk), getLong(zzd2.zzq), playerLevel2, playerLevel);
            return;
        }
        this.zzb = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return PlayerEntity.zzo(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new PlayerEntity(this);
    }

    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zza.zzC);
    }

    public String getBannerImageLandscapeUrl() {
        return getString(this.zza.zzD);
    }

    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zza.zzE);
    }

    public String getBannerImagePortraitUrl() {
        return getString(this.zza.zzF);
    }

    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        if (this.zze.zza()) {
            return this.zze;
        }
        return null;
    }

    public final String getDisplayName() {
        return getString(this.zza.zzc);
    }

    public final Uri getHiResImageUri() {
        return parseUri(this.zza.zzf);
    }

    public String getHiResImageUrl() {
        return getString(this.zza.zzg);
    }

    public final Uri getIconImageUri() {
        return parseUri(this.zza.zzd);
    }

    public String getIconImageUrl() {
        return getString(this.zza.zze);
    }

    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zza.zzj) || hasNull(this.zza.zzj)) {
            return -1;
        }
        return getLong(this.zza.zzj);
    }

    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    public final String getPlayerId() {
        return getString(this.zza.zza);
    }

    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzx zzx = this.zzd;
        if (zzx.getFriendStatus() == -1 && zzx.zzb() == null && zzx.zza() == null) {
            return null;
        }
        return this.zzd;
    }

    public final long getRetrievedTimestamp() {
        return getLong(this.zza.zzh);
    }

    public final String getTitle() {
        return getString(this.zza.zzr);
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return PlayerEntity.zzj(this);
    }

    public final String toString() {
        return PlayerEntity.zzl(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new PlayerEntity(this).writeToParcel(parcel, i);
    }

    public final int zza() {
        return getInteger(this.zza.zzi);
    }

    public final long zzb() {
        String str = this.zza.zzG;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final zza zzc() {
        if (hasNull(this.zza.zzt)) {
            return null;
        }
        return this.zzc;
    }

    public final String zzd() {
        return zzr(this.zza.zzb, (String) null);
    }

    public final String zze() {
        return getString(this.zza.zzA);
    }

    public final String zzf() {
        return getString(this.zza.zzB);
    }

    public final boolean zzg() {
        return getBoolean(this.zza.zzz);
    }

    public final boolean zzh() {
        return hasColumn(this.zza.zzM) && getBoolean(this.zza.zzM);
    }

    public final boolean zzi() {
        return getBoolean(this.zza.zzs);
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzc, charArrayBuffer);
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzr, charArrayBuffer);
    }
}
