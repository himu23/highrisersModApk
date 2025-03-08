package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbd implements GamesMetadata.LoadGamesResult {
    final /* synthetic */ Status zza;

    zzbd(zzbf zzbf, Status status) {
        this.zza = status;
    }

    public final GameBuffer getGames() {
        return new GameBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
