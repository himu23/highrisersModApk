package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzay extends zzad implements GamesClient {
    public static final /* synthetic */ int zza = 0;

    public zzay(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<Bundle> getActivationHint() {
        return doRead(TaskApiCall.builder().run(zzav.zza).setMethodKey(6622).build());
    }

    public final Task<String> getAppId() {
        return doRead(TaskApiCall.builder().run(zzaw.zza).setMethodKey(6620).build());
    }

    public final Task<String> getCurrentAccountName() {
        return doRead(TaskApiCall.builder().run(zzax.zza).setMethodKey(6618).build());
    }

    public final Task<Intent> getSettingsIntent() {
        return doRead(TaskApiCall.builder().run(zzat.zza).setMethodKey(6621).build());
    }

    public final Task<Void> setGravityForPopups(int i) {
        return doWrite(TaskApiCall.builder().run(new zzas(i)).setMethodKey(6616).build());
    }

    public final Task<Void> setViewForPopups(View view) {
        return doWrite(TaskApiCall.builder().run(new zzau(view)).setMethodKey(6617).build());
    }

    public zzay(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
