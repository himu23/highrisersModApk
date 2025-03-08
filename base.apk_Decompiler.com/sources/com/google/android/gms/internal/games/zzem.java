package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzem implements Stats.LoadPlayerStatsResult {
    final /* synthetic */ Status zza;

    zzem(zzeo zzeo, Status status) {
        this.zza = status;
    }

    public final PlayerStats getPlayerStats() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
