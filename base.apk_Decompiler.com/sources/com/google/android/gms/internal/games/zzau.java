package com.google.android.gms.internal.games;

import android.view.View;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzau implements RemoteCall {
    public final /* synthetic */ View zza;

    public /* synthetic */ zzau(View view) {
        this.zza = view;
    }

    public final void accept(Object obj, Object obj2) {
        View view = this.zza;
        int i = zzay.zza;
        ((zzbz) obj).zzaT(view);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
