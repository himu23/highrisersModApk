package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzn extends zzad implements AchievementsClient {
    public static final /* synthetic */ int zza = 0;

    public zzn(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<Intent> getAchievementsIntent() {
        return doRead(TaskApiCall.builder().run(zzk.zza).setMethodKey(6601).build());
    }

    public final void increment(String str, int i) {
        doWrite(TaskApiCall.builder().run(new zzl(str, i)).setMethodKey(6607).build());
    }

    public final Task<Boolean> incrementImmediate(String str, int i) {
        return doWrite(TaskApiCall.builder().run(new zzi(str, i)).setMethodKey(6608).build());
    }

    public final Task<AnnotatedData<AchievementBuffer>> load(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzj(z)).setMethodKey(6602).build());
    }

    public final void reveal(String str) {
        doWrite(TaskApiCall.builder().run(new zze(str)).setMethodKey(6603).build());
    }

    public final Task<Void> revealImmediate(String str) {
        return doWrite(TaskApiCall.builder().run(new zzm(str)).setMethodKey(6604).build());
    }

    public final void setSteps(String str, int i) {
        doWrite(TaskApiCall.builder().run(new zzg(str, i)).setMethodKey(6609).build());
    }

    public final Task<Boolean> setStepsImmediate(String str, int i) {
        return doWrite(TaskApiCall.builder().run(new zzd(str, i)).setMethodKey(6610).build());
    }

    public final void unlock(String str) {
        doWrite(TaskApiCall.builder().run(new zzf(str)).setMethodKey(6605).build());
    }

    public final Task<Void> unlockImmediate(String str) {
        return doWrite(TaskApiCall.builder().run(new zzh(str)).setMethodKey(6606).build());
    }

    public zzn(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
