package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzae implements Videos.CaptureCapabilitiesResult {
    private final Status zza;
    private final VideoCapabilities zzb;

    zzae(Status status, VideoCapabilities videoCapabilities) {
        this.zza = status;
        this.zzb = videoCapabilities;
    }

    public final VideoCapabilities getCapabilities() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
