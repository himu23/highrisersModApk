package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzco extends zzad implements PlayerStatsClient {
    public static final /* synthetic */ int zza = 0;

    public zzco(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzcn(z)).setMethodKey(6639).build());
    }

    public zzco(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
