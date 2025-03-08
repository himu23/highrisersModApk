package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcw implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzcw(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        int i = this.zzb;
        int i2 = zzcy.zza;
        ((zzbz) obj).zzaD((TaskCompletionSource) obj2, str, i, true, false);
    }
}
