package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new zze();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final Uri zzg;
    private final Uri zzh;
    private final Uri zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final String zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final boolean zzq;
    private final String zzr;
    private final String zzs;
    private final String zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final String zzx;
    private final boolean zzy;

    public GameEntity(Game game) {
        this.zza = game.getApplicationId();
        this.zzc = game.getPrimaryCategory();
        this.zzd = game.getSecondaryCategory();
        this.zze = game.getDescription();
        this.zzf = game.getDeveloperName();
        this.zzb = game.getDisplayName();
        this.zzg = game.getIconImageUri();
        this.zzr = game.getIconImageUrl();
        this.zzh = game.getHiResImageUri();
        this.zzs = game.getHiResImageUrl();
        this.zzi = game.getFeaturedImageUri();
        this.zzt = game.getFeaturedImageUrl();
        this.zzj = game.zze();
        this.zzk = game.zzc();
        this.zzl = game.zza();
        this.zzm = 1;
        this.zzn = game.getAchievementTotalCount();
        this.zzo = game.getLeaderboardCount();
        this.zzp = game.zzf();
        this.zzq = game.zzg();
        this.zzu = game.zzd();
        this.zzv = game.zzb();
        this.zzw = game.areSnapshotsEnabled();
        this.zzx = game.getThemeColor();
        this.zzy = game.hasGamepadSupport();
    }

    static int zzh(Game game) {
        return Objects.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zze()), Boolean.valueOf(game.zzc()), game.zza(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.zzf()), Boolean.valueOf(game.zzg()), Boolean.valueOf(game.zzd()), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static String zzj(Game game) {
        return Objects.toStringHelper(game).add("ApplicationId", game.getApplicationId()).add("DisplayName", game.getDisplayName()).add("PrimaryCategory", game.getPrimaryCategory()).add("SecondaryCategory", game.getSecondaryCategory()).add("Description", game.getDescription()).add("DeveloperName", game.getDeveloperName()).add("IconImageUri", game.getIconImageUri()).add("IconImageUrl", game.getIconImageUrl()).add("HiResImageUri", game.getHiResImageUri()).add("HiResImageUrl", game.getHiResImageUrl()).add("FeaturedImageUri", game.getFeaturedImageUri()).add("FeaturedImageUrl", game.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game.zze())).add("InstanceInstalled", Boolean.valueOf(game.zzc())).add("InstancePackageName", game.zza()).add("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).add("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).add("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).add("ThemeColor", game.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    static boolean zzm(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return Objects.equal(game2.getApplicationId(), game.getApplicationId()) && Objects.equal(game2.getDisplayName(), game.getDisplayName()) && Objects.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && Objects.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && Objects.equal(game2.getDescription(), game.getDescription()) && Objects.equal(game2.getDeveloperName(), game.getDeveloperName()) && Objects.equal(game2.getIconImageUri(), game.getIconImageUri()) && Objects.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && Objects.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game2.zze()), Boolean.valueOf(game.zze())) && Objects.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && Objects.equal(game2.zza(), game.zza()) && Objects.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && Objects.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && Objects.equal(Boolean.valueOf(game2.zzf()), Boolean.valueOf(game.zzf())) && Objects.equal(Boolean.valueOf(game2.zzg()), Boolean.valueOf(game.zzg())) && Objects.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd())) && Objects.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && Objects.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && Objects.equal(game2.getThemeColor(), game.getThemeColor()) && Objects.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public boolean areSnapshotsEnabled() {
        return this.zzw;
    }

    public boolean equals(Object obj) {
        return zzm(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzn;
    }

    public String getApplicationId() {
        return this.zza;
    }

    public String getDescription() {
        return this.zze;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zze, charArrayBuffer);
    }

    public String getDeveloperName() {
        return this.zzf;
    }

    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer);
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    public Uri getFeaturedImageUri() {
        return this.zzi;
    }

    public String getFeaturedImageUrl() {
        return this.zzt;
    }

    public Uri getHiResImageUri() {
        return this.zzh;
    }

    public String getHiResImageUrl() {
        return this.zzs;
    }

    public Uri getIconImageUri() {
        return this.zzg;
    }

    public String getIconImageUrl() {
        return this.zzr;
    }

    public int getLeaderboardCount() {
        return this.zzo;
    }

    public String getPrimaryCategory() {
        return this.zzc;
    }

    public String getSecondaryCategory() {
        return this.zzd;
    }

    public String getThemeColor() {
        return this.zzx;
    }

    public boolean hasGamepadSupport() {
        return this.zzy;
    }

    public int hashCode() {
        return zzh(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzj(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        String str2;
        if (shouldDowngrade()) {
            parcel.writeString(this.zza);
            parcel.writeString(this.zzb);
            parcel.writeString(this.zzc);
            parcel.writeString(this.zzd);
            parcel.writeString(this.zze);
            parcel.writeString(this.zzf);
            Uri uri = this.zzg;
            String str3 = null;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            parcel.writeString(str);
            Uri uri2 = this.zzh;
            if (uri2 == null) {
                str2 = null;
            } else {
                str2 = uri2.toString();
            }
            parcel.writeString(str2);
            Uri uri3 = this.zzi;
            if (uri3 != null) {
                str3 = uri3.toString();
            }
            parcel.writeString(str3);
            parcel.writeInt(this.zzj ? 1 : 0);
            parcel.writeInt(this.zzk ? 1 : 0);
            parcel.writeString(this.zzl);
            parcel.writeInt(this.zzm);
            parcel.writeInt(this.zzn);
            parcel.writeInt(this.zzo);
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getApplicationId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getPrimaryCategory(), false);
        SafeParcelWriter.writeString(parcel, 4, getSecondaryCategory(), false);
        SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeveloperName(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getIconImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeInt(parcel, 14, getAchievementTotalCount());
        SafeParcelWriter.writeInt(parcel, 15, getLeaderboardCount());
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzp);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzq);
        SafeParcelWriter.writeString(parcel, 18, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 19, getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 20, getFeaturedImageUrl(), false);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, areSnapshotsEnabled());
        SafeParcelWriter.writeString(parcel, 24, getThemeColor(), false);
        SafeParcelWriter.writeBoolean(parcel, 25, hasGamepadSupport());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zzl;
    }

    public final boolean zzb() {
        return this.zzv;
    }

    public final boolean zzc() {
        return this.zzk;
    }

    public final boolean zzd() {
        return this.zzu;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzp;
    }

    public final boolean zzg() {
        return this.zzq;
    }

    GameEntity(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i, int i2, int i3, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11, boolean z8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = uri;
        this.zzr = str8;
        this.zzh = uri2;
        this.zzs = str9;
        this.zzi = uri3;
        this.zzt = str10;
        this.zzj = z;
        this.zzk = z2;
        this.zzl = str7;
        this.zzm = i;
        this.zzn = i2;
        this.zzo = i3;
        this.zzp = z3;
        this.zzq = z4;
        this.zzu = z5;
        this.zzv = z6;
        this.zzw = z7;
        this.zzx = str11;
        this.zzy = z8;
    }
}
