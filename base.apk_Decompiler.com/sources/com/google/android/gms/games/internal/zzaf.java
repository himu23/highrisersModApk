package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzaf implements Videos.CaptureStateResult {
    private final Status zza;
    private final CaptureState zzb;

    zzaf(Status status, CaptureState captureState) {
        this.zza = status;
        this.zzb = captureState;
    }

    public final CaptureState getCaptureState() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
