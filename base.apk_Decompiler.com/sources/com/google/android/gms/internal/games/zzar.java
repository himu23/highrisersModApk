package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzbz;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzar implements Events {
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        zzbz zzc = Games.zzc(googleApiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzab(str, i);
            } else {
                googleApiClient.execute(new zzak(this, googleApiClient, str, i));
            }
        }
    }

    public final PendingResult<Events.LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzaj(this, googleApiClient, z));
    }

    public final PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new zzai(this, googleApiClient, z, strArr));
    }
}
