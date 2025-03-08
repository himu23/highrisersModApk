package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.EventsClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzah extends zzad implements EventsClient {
    public static final /* synthetic */ int zza = 0;

    public zzah(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final void increment(String str, int i) {
        doWrite(TaskApiCall.builder().run(new zzae(str, i)).setMethodKey(6615).build());
    }

    public final Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzaf(z)).setMethodKey(6613).build());
    }

    public final Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, String... strArr) {
        return doRead(TaskApiCall.builder().run(new zzag(z, strArr)).setMethodKey(6614).build());
    }

    public zzah(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
