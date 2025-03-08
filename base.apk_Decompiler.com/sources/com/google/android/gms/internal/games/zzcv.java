package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcv implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzcv(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        int i = zzcy.zza;
        ((TaskCompletionSource) obj2).setResult(((zzce) ((zzbz) obj).getService()).zzj(str, str2, str3));
    }
}
