package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzcb implements Leaderboards.LeaderboardMetadataResult {
    final /* synthetic */ Status zza;

    zzcb(zzcd zzcd, Status status) {
        this.zza = status;
    }

    public final LeaderboardBuffer getLeaderboards() {
        return new LeaderboardBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
