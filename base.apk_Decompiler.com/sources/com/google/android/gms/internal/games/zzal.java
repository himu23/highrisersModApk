package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzal implements Events.LoadEventsResult {
    final /* synthetic */ Status zza;

    zzal(zzan zzan, Status status) {
        this.zza = status;
    }

    public final EventBuffer getEvents() {
        return new EventBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
