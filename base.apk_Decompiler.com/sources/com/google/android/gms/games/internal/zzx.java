package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzx implements BaseImplementation.ResultHolder {
    final /* synthetic */ BaseGmsClient.SignOutCallbacks zza;

    zzx(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.zza = signOutCallbacks;
    }

    public final void setFailedResult(Status status) {
        this.zza.onSignOutComplete();
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        this.zza.onSignOutComplete();
    }
}
