package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzaz extends zzao implements Achievements.LoadAchievementsResult {
    private final AchievementBuffer zza;

    zzaz(DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new AchievementBuffer(dataHolder);
    }

    public final AchievementBuffer getAchievements() {
        return this.zza;
    }
}
