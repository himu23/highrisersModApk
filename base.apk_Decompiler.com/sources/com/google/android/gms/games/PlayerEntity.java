package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.zza;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zzr();
    private String zza;
    private String zzb;
    private final Uri zzc;
    private final Uri zzd;
    private final long zze;
    private final int zzf;
    private final long zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final MostRecentGameInfoEntity zzk;
    private final PlayerLevelInfo zzl;
    private final boolean zzm;
    private final boolean zzn;
    private final String zzo;
    private final String zzp;
    private final Uri zzq;
    private final String zzr;
    private final Uri zzs;
    private final String zzt;
    private long zzu;
    private final zzv zzv;
    private final zza zzw;
    private boolean zzx;
    private final String zzy;

    /* JADX WARNING: type inference failed for: r2v17, types: [java.lang.Object, com.google.android.gms.games.PlayerRelationshipInfo] */
    public PlayerEntity(Player player) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity;
        zzv zzv2;
        this.zza = player.getPlayerId();
        this.zzb = player.getDisplayName();
        this.zzc = player.getIconImageUri();
        this.zzh = player.getIconImageUrl();
        this.zzd = player.getHiResImageUri();
        this.zzi = player.getHiResImageUrl();
        long retrievedTimestamp = player.getRetrievedTimestamp();
        this.zze = retrievedTimestamp;
        this.zzf = player.zza();
        this.zzg = player.getLastPlayedWithTimestamp();
        this.zzj = player.getTitle();
        this.zzm = player.zzi();
        zza zzc2 = player.zzc();
        Object obj = null;
        if (zzc2 == null) {
            mostRecentGameInfoEntity = null;
        } else {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzc2);
        }
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = player.getLevelInfo();
        this.zzn = player.zzg();
        this.zzo = player.zze();
        this.zzp = player.zzf();
        this.zzq = player.getBannerImageLandscapeUri();
        this.zzr = player.getBannerImageLandscapeUrl();
        this.zzs = player.getBannerImagePortraitUri();
        this.zzt = player.getBannerImagePortraitUrl();
        this.zzu = player.zzb();
        PlayerRelationshipInfo relationshipInfo = player.getRelationshipInfo();
        if (relationshipInfo == null) {
            zzv2 = null;
        } else {
            zzv2 = new zzv(relationshipInfo.freeze());
        }
        this.zzv = zzv2;
        CurrentPlayerInfo currentPlayerInfo = player.getCurrentPlayerInfo();
        this.zzw = (zza) (currentPlayerInfo != null ? currentPlayerInfo.freeze() : obj);
        this.zzx = player.zzh();
        this.zzy = player.zzd();
        Asserts.checkNotNull(this.zza);
        Asserts.checkNotNull(this.zzb);
        Asserts.checkState(retrievedTimestamp > 0);
    }

    static int zzj(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzg()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zze(), player.zzf(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Long.valueOf(player.zzb()), player.getRelationshipInfo(), player.getCurrentPlayerInfo(), Boolean.valueOf(player.zzh()), player.zzd());
    }

    static String zzl(Player player) {
        Objects.ToStringHelper add = Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzg())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zze()).add("Name", player.zzf()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("CurrentPlayerInfo", player.getCurrentPlayerInfo()).add("TotalUnlockedAchievement", Long.valueOf(player.zzb()));
        if (player.zzh()) {
            add.add("AlwaysAutoSignIn", Boolean.valueOf(player.zzh()));
        }
        if (player.getRelationshipInfo() != null) {
            add.add("RelationshipInfo", player.getRelationshipInfo());
        }
        if (player.zzd() != null) {
            add.add("GamePlayerId", player.zzd());
        }
        return add.toString();
    }

    static boolean zzo(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzg()), Boolean.valueOf(player.zzg())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zze(), player.zze()) && Objects.equal(player2.zzf(), player.zzf()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Long.valueOf(player2.zzb()), Long.valueOf(player.zzb())) && Objects.equal(player2.getCurrentPlayerInfo(), player.getCurrentPlayerInfo()) && Objects.equal(player2.getRelationshipInfo(), player.getRelationshipInfo()) && Objects.equal(Boolean.valueOf(player2.zzh()), Boolean.valueOf(player.zzh())) && Objects.equal(player2.zzd(), player.zzd());
    }

    public boolean equals(Object obj) {
        return zzo(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public Uri getBannerImageLandscapeUri() {
        return this.zzq;
    }

    public String getBannerImageLandscapeUrl() {
        return this.zzr;
    }

    public Uri getBannerImagePortraitUri() {
        return this.zzs;
    }

    public String getBannerImagePortraitUrl() {
        return this.zzt;
    }

    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzw;
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return this.zzd;
    }

    public String getHiResImageUrl() {
        return this.zzi;
    }

    public Uri getIconImageUri() {
        return this.zzc;
    }

    public String getIconImageUrl() {
        return this.zzh;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzg;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzl;
    }

    public String getPlayerId() {
        return this.zza;
    }

    public PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzv;
    }

    public long getRetrievedTimestamp() {
        return this.zze;
    }

    public String getTitle() {
        return this.zzj;
    }

    public void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzj(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzl(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        if (shouldDowngrade()) {
            parcel.writeString(this.zza);
            parcel.writeString(this.zzb);
            Uri uri = this.zzc;
            String str2 = null;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            parcel.writeString(str);
            Uri uri2 = this.zzd;
            if (uri2 != null) {
                str2 = uri2.toString();
            }
            parcel.writeString(str2);
            parcel.writeLong(this.zze);
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
        SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
        SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzn);
        SafeParcelWriter.writeString(parcel, 20, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzp, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
        SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
        SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
        SafeParcelWriter.writeLong(parcel, 29, this.zzu);
        SafeParcelWriter.writeParcelable(parcel, 33, getRelationshipInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 35, getCurrentPlayerInfo(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzx);
        SafeParcelWriter.writeString(parcel, 37, this.zzy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zzu;
    }

    public final zza zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzy;
    }

    public final String zze() {
        return this.zzo;
    }

    public final String zzf() {
        return this.zzp;
    }

    public final boolean zzg() {
        return this.zzn;
    }

    public final boolean zzh() {
        return this.zzx;
    }

    public final boolean zzi() {
        return this.zzm;
    }

    PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j, int i, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, long j3, zzv zzv2, zza zza2, boolean z3, String str10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzh = str3;
        this.zzd = uri2;
        this.zzi = str4;
        this.zze = j;
        this.zzf = i;
        this.zzg = j2;
        this.zzj = str5;
        this.zzm = z;
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = playerLevelInfo;
        this.zzn = z2;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = uri3;
        this.zzr = str8;
        this.zzs = uri4;
        this.zzt = str9;
        this.zzu = j3;
        this.zzv = zzv2;
        this.zzw = zza2;
        this.zzx = z3;
        this.zzy = str10;
    }
}
