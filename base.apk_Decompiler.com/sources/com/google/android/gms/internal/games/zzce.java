package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzce implements Leaderboards.LoadPlayerScoreResult {
    final /* synthetic */ Status zza;

    zzce(zzcg zzcg, Status status) {
        this.zza = status;
    }

    public final LeaderboardScore getScore() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
