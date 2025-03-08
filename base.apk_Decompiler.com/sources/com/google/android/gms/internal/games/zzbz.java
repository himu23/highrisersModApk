package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzbz extends zzcj {
    final /* synthetic */ LeaderboardScoreBuffer zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbz(zzcm zzcm, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        super(googleApiClient, (zzci) null);
        this.zza = leaderboardScoreBuffer;
        this.zzb = i;
        this.zzc = i2;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((com.google.android.gms.games.internal.zzbz) anyClient).zzat(this, this.zza, this.zzb, this.zzc);
    }
}
