package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    private final int zza;
    private final Game zzb;

    LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
        this.zzb = new GameRef(dataHolder, i);
    }

    public final boolean equals(Object obj) {
        return LeaderboardEntity.zzd(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardEntity(this);
    }

    public final String getDisplayName() {
        return getString("name");
    }

    public final Uri getIconImageUri() {
        return parseUri("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public final String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public final int getScoreOrder() {
        return getInteger("score_order");
    }

    public final ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.zza);
        for (int i = 0; i < this.zza; i++) {
            arrayList.add(new zzb(this.mDataHolder, this.mDataRow + i));
        }
        return arrayList;
    }

    public final int hashCode() {
        return LeaderboardEntity.zzb(this);
    }

    public final String toString() {
        return LeaderboardEntity.zzc(this);
    }

    public final Game zza() {
        return this.zzb;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}
