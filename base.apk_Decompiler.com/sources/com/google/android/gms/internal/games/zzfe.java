package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzfe implements Videos.CaptureCapabilitiesResult {
    final /* synthetic */ Status zza;

    zzfe(zzfg zzfg, Status status) {
        this.zza = status;
    }

    public final VideoCapabilities getCapabilities() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
