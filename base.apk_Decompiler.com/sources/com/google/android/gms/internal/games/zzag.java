package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzag implements RemoteCall {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String[] zzb;

    public /* synthetic */ zzag(boolean z, String[] strArr) {
        this.zza = z;
        this.zzb = strArr;
    }

    public final void accept(Object obj, Object obj2) {
        boolean z = this.zza;
        String[] strArr = this.zzb;
        int i = zzah.zza;
        ((zzbz) obj).zzal((TaskCompletionSource) obj2, z, strArr);
    }
}
