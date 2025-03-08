package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.ironsource.m2;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class GameRef extends DataBufferRef implements Game {
    public GameRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return GameEntity.zzm(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new GameEntity(this);
    }

    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final String getDescription() {
        return getString("game_description");
    }

    public final String getDeveloperName() {
        return getString("developer_name");
    }

    public final String getDisplayName() {
        return getString("display_name");
    }

    public final Uri getFeaturedImageUri() {
        return parseUri("featured_image_uri");
    }

    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    public final Uri getHiResImageUri() {
        return parseUri("game_hi_res_image_uri");
    }

    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    public final Uri getIconImageUri() {
        return parseUri("game_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    public final String getThemeColor() {
        return getString("theme_color");
    }

    public final boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    public final int hashCode() {
        return GameEntity.zzh(this);
    }

    public final String toString() {
        return GameEntity.zzj(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new GameEntity(this).writeToParcel(parcel, i);
    }

    public final String zza() {
        return getString(m2.h.V);
    }

    public final boolean zzb() {
        return getBoolean("identity_sharing_confirmed");
    }

    public final boolean zzc() {
        return getInteger("installed") > 0;
    }

    public final boolean zzd() {
        return getBoolean("muted");
    }

    public final boolean zze() {
        return getBoolean("play_enabled_game");
    }

    public final boolean zzf() {
        return getInteger("real_time_support") > 0;
    }

    public final boolean zzg() {
        return getInteger("turn_based_support") > 0;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("game_description", charArrayBuffer);
    }

    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("developer_name", charArrayBuffer);
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_name", charArrayBuffer);
    }
}
