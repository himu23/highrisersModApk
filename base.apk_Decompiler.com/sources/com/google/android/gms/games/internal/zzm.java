package com.google.android.gms.games.internal;

import com.google.android.gms.games.VideosClient;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzm implements zzbq {
    public final /* synthetic */ int zza;

    public /* synthetic */ zzm(int i) {
        this.zza = i;
    }

    public final void zza(Object obj) {
        ((VideosClient.OnCaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zza);
    }
}
