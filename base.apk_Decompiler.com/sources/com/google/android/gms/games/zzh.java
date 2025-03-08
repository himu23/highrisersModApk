package com.google.android.gms.games;

import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzh extends zzl {
    zzh() {
        super((zzk) null);
    }

    public final /* synthetic */ List getImpliedScopes(Object obj) {
        Games.GamesOptions gamesOptions = (Games.GamesOptions) obj;
        return Collections.singletonList(Games.zzb);
    }
}
