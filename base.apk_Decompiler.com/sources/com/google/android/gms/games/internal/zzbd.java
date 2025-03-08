package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbd extends zzao implements Stats.LoadPlayerStatsResult {
    private final PlayerStats zza;

    zzbd(DataHolder dataHolder) {
        super(dataHolder);
        PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
        try {
            if (playerStatsBuffer.getCount() > 0) {
                this.zza = new PlayerStatsEntity(playerStatsBuffer.get(0));
            } else {
                this.zza = null;
            }
        } finally {
            playerStatsBuffer.release();
        }
    }

    public final PlayerStats getPlayerStats() {
        return this.zza;
    }
}
