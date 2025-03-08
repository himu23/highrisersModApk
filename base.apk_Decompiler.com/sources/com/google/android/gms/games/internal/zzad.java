package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzad implements Videos.CaptureAvailableResult {
    private final Status zza;
    private final boolean zzb;

    zzad(Status status, boolean z) {
        this.zza = status;
        this.zzb = z;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final boolean isAvailable() {
        return this.zzb;
    }
}
