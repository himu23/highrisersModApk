package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzar extends zza {
    final /* synthetic */ zzbz zza;
    private final TaskCompletionSource zzb;

    zzar(zzbz zzbz, TaskCompletionSource taskCompletionSource) {
        this.zza = zzbz;
        this.zzb = taskCompletionSource;
    }

    public final void zzk(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 10003) {
            zzbz.zzL(this.zza, this.zzb);
            dataHolder.close();
            return;
        } else if (statusCode == 0 || z) {
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                LeaderboardScoreEntity leaderboardScoreEntity = leaderboardScoreBuffer.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer.get(0)) : null;
                leaderboardScoreBuffer.close();
                this.zzb.setResult(new AnnotatedData(leaderboardScoreEntity, z));
                return;
            } catch (Throwable th) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(th, new Object[]{th});
                } catch (Exception unused) {
                }
            }
        } else {
            GamesStatusUtils.zza(this.zzb, statusCode);
            dataHolder.close();
            return;
        }
        throw th;
    }
}
