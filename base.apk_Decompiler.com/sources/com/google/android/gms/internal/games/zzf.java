package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzf implements RemoteCall {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzf(String str) {
        this.zza = str;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        int i = zzn.zza;
        ((zzbz) obj).zzba((TaskCompletionSource) null, str);
    }
}
