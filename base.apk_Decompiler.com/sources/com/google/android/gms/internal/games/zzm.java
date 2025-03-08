package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzm implements RemoteCall {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzm(String str) {
        this.zza = str;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        int i = zzn.zza;
        ((zzbz) obj).zzaP((TaskCompletionSource) obj2, str);
    }
}
