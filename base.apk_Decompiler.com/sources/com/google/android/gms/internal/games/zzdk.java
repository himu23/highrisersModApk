package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzdk implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdk(String str, boolean z, boolean z2, int i) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        int i = this.zzd;
        int i2 = zzds.zza;
        ((TaskCompletionSource) obj2).setResult(((zzbz) obj).zzB(str, z, z2, i));
    }
}
