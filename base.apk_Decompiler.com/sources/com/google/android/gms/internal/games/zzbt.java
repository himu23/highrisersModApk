package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzbt extends zzad implements LeaderboardsClient {
    public static final /* synthetic */ int zza = 0;

    public zzbt(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<Intent> getAllLeaderboardsIntent() {
        return doRead(TaskApiCall.builder().run(zzbk.zza).setMethodKey(6630).build());
    }

    public final Task<Intent> getLeaderboardIntent(String str) {
        return getLeaderboardIntent(str, -1, -1);
    }

    public final Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(String str, int i, int i2) {
        return doRead(TaskApiCall.builder().run(new zzbl(str, i, i2)).setMethodKey(6633).build());
    }

    public final Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(String str, boolean z) {
        return doRead(TaskApiCall.builder().run(new zzbp(str, z)).setMethodKey(6632).build());
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadMoreScores(LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return doRead(TaskApiCall.builder().run(new zzbi(leaderboardScoreBuffer, i, i2)).setMethodKey(6636).build());
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return doRead(TaskApiCall.builder().run(new zzbn(str, i, i2, i3, false)).setMethodKey(6635).build());
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3) {
        return doRead(TaskApiCall.builder().run(new zzbm(str, i, i2, i3, false)).setMethodKey(6634).build());
    }

    public final void submitScore(String str, long j) {
        doWrite(TaskApiCall.builder().run(new zzbr(str, j)).setMethodKey(6637).build());
    }

    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j) {
        return doWrite(TaskApiCall.builder().run(new zzbq(str, j)).setMethodKey(6638).build());
    }

    public zzbt(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<Intent> getLeaderboardIntent(String str, int i) {
        return getLeaderboardIntent(str, i, -1);
    }

    public final Task<Intent> getLeaderboardIntent(String str, int i, int i2) {
        return doRead(TaskApiCall.builder().run(new zzbh(str, i, i2)).setMethodKey(6631).build());
    }

    public final Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzbj(z)).setMethodKey(6632).build());
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return doRead(TaskApiCall.builder().run(new zzbn(str, i, i2, i3, z)).setMethodKey(6635).build());
    }

    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return doRead(TaskApiCall.builder().run(new zzbm(str, i, i2, i3, z)).setMethodKey(6634).build());
    }

    public final void submitScore(String str, long j, String str2) {
        doWrite(TaskApiCall.builder().run(new zzbs(str, j, str2)).setMethodKey(6637).build());
    }

    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j, String str2) {
        return doWrite(TaskApiCall.builder().run(new zzbo(str, j, str2)).setMethodKey(6638).build());
    }
}
