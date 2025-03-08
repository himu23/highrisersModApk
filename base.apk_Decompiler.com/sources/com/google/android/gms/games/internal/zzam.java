package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games.zzfn;
import com.google.android.gms.internal.games.zzft;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzam extends zzfn {
    final /* synthetic */ zzbz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzbz zzbz) {
        super(zzbz.getContext().getMainLooper(), 1000);
        this.zza = zzbz;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, int i) {
        try {
            if (this.zza.isConnected()) {
                ((zzce) this.zza.getService()).zzD(str, i);
                return;
            }
            zzft.zza("GamesGmsClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
        } catch (RemoteException e) {
            zzbz.zzbf(e);
        } catch (SecurityException e2) {
            int i2 = zzbz.zze;
            zzft.zzb("GamesGmsClientImpl", "Is player signed out?", e2);
        }
    }
}
