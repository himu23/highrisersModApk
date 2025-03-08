package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadataClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzbb extends zzad implements GamesMetadataClient {
    public static final /* synthetic */ int zza = 0;

    public zzbb(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<Game> getCurrentGame() {
        return doRead(TaskApiCall.builder().run(zzaz.zza).setMethodKey(6628).build());
    }

    public final Task<AnnotatedData<Game>> loadGame() {
        return doRead(TaskApiCall.builder().run(zzba.zza).setMethodKey(6629).build());
    }

    public zzbb(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
