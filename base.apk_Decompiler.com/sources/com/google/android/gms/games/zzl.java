package com.google.android.gms.games;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzcg;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
class zzl extends Api.AbstractClientBuilder {
    /* synthetic */ zzl(zzk zzk) {
    }

    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Games.GamesOptions gamesOptions = (Games.GamesOptions) obj;
        if (gamesOptions == null) {
            gamesOptions = new Games.GamesOptions.Builder((zzm) null).build();
        }
        return new zzbz(context, looper, clientSettings, gamesOptions, connectionCallbacks, onConnectionFailedListener, zzcg.zza());
    }

    public final int getPriority() {
        return 1;
    }
}
