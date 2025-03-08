package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbo extends zza {
    final /* synthetic */ zzbz zza;
    private final TaskCompletionSource zzb;

    zzbo(zzbz zzbz, TaskCompletionSource taskCompletionSource) {
        this.zza = zzbz;
        this.zzb = taskCompletionSource;
    }

    public final void zzg(DataHolder dataHolder) {
        zzm(dataHolder);
    }

    public final void zzm(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 10003) {
            zzbz.zzL(this.zza, this.zzb);
            dataHolder.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zzb.setResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
            return;
        }
        GamesStatusUtils.zza(this.zzb, statusCode);
        dataHolder.close();
    }
}
