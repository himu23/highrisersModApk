package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final /* synthetic */ class zzbi implements RemoteCall {
    public final /* synthetic */ LeaderboardScoreBuffer zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzbi(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        this.zza = leaderboardScoreBuffer;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void accept(Object obj, Object obj2) {
        LeaderboardScoreBuffer leaderboardScoreBuffer = this.zza;
        int i = this.zzb;
        int i2 = this.zzc;
        int i3 = zzbt.zza;
        ((zzbz) obj).zzau((TaskCompletionSource) obj2, leaderboardScoreBuffer, i, i2);
    }
}
