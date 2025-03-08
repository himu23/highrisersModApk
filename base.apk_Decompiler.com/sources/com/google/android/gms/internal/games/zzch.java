package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzch implements Leaderboards.LoadScoresResult {
    final /* synthetic */ Status zza;

    zzch(zzcj zzcj, Status status) {
        this.zza = status;
    }

    public final Leaderboard getLeaderboard() {
        return null;
    }

    public final LeaderboardScoreBuffer getScores() {
        return new LeaderboardScoreBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
