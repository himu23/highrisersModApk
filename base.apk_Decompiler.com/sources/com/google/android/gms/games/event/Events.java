package com.google.android.gms.games.event;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public interface Events {

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
    public interface LoadEventsResult extends Result, Releasable {
        EventBuffer getEvents();
    }

    void increment(GoogleApiClient googleApiClient, String str, int i);

    PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z);

    PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr);
}
