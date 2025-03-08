package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzaa implements Achievements.UpdateAchievementResult {
    final /* synthetic */ Status zza;
    final /* synthetic */ zzab zzb;

    zzaa(zzab zzab, Status status) {
        this.zzb = zzab;
        this.zza = status;
    }

    public final String getAchievementId() {
        return this.zzb.zza;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
