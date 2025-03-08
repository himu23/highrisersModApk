package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbk extends zza {
    final TaskCompletionSource zza;

    zzbk(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzv(int i, VideoCapabilities videoCapabilities) {
        if (i == 0) {
            this.zza.setResult(videoCapabilities);
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
