package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzx implements Achievements.LoadAchievementsResult {
    final /* synthetic */ Status zza;

    zzx(zzz zzz, Status status) {
        this.zza = status;
    }

    public final AchievementBuffer getAchievements() {
        return new AchievementBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final void release() {
    }
}
