package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzfb implements Videos.CaptureAvailableResult {
    final /* synthetic */ Status zza;

    zzfb(zzfd zzfd, Status status) {
        this.zza = status;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final boolean isAvailable() {
        return false;
    }
}
