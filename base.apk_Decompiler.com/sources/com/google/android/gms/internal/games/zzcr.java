package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzcr implements RemoteCall {
    public final /* synthetic */ Player zza;

    public /* synthetic */ zzcr(Player player) {
        this.zza = player;
    }

    public final void accept(Object obj, Object obj2) {
        Player player = this.zza;
        int i = zzcy.zza;
        PlayerEntity playerEntity = new PlayerEntity(player);
        Intent zzi = ((zzce) ((zzbz) obj).getService()).zzi(playerEntity);
        zzi.setExtrasClassLoader(playerEntity.getClass().getClassLoader());
        ((TaskCompletionSource) obj2).setResult(zzi);
    }
}
