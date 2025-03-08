package com.google.android.gms.games.internal;

import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzo implements zzbq {
    public final /* synthetic */ int zza;

    public /* synthetic */ zzo(int i) {
        this.zza = i;
    }

    public final void zza(Object obj) {
        ((Videos.CaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zza);
    }
}
