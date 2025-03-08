package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzfh implements Videos.CaptureStateResult {
    final /* synthetic */ Status zza;

    zzfh(zzfj zzfj, Status status) {
        this.zza = status;
    }

    public final CaptureState getCaptureState() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
