package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbb extends zzao implements GamesMetadata.LoadGamesResult {
    private final GameBuffer zza;

    zzbb(DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new GameBuffer(dataHolder);
    }

    public final GameBuffer getGames() {
        return this.zza;
    }
}
