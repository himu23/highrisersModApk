package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzcy extends zzad implements PlayersClient {
    public static final /* synthetic */ int zza = 0;

    public zzcy(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    private final Task zza(String str, int i) {
        return doRead(TaskApiCall.builder().run(new zzcw(str, i)).setMethodKey(6647).build());
    }

    private final Task zzb(String str, int i, boolean z) {
        return doRead(TaskApiCall.builder().run(new zzcp(str, i, z)).setMethodKey(6646).build());
    }

    public final Task<Intent> getCompareProfileIntent(Player player) {
        return doRead(TaskApiCall.builder().run(new zzcr(player)).setMethodKey(6643).build());
    }

    public final Task<Intent> getCompareProfileIntentWithAlternativeNameHints(String str, String str2, String str3) {
        return doRead(TaskApiCall.builder().run(new zzcv(str, str2, str3)).setMethodKey(6644).build());
    }

    public final Task<Player> getCurrentPlayer() {
        return doRead(TaskApiCall.builder().run(zzct.zza).setMethodKey(6641).build());
    }

    public final Task<String> getCurrentPlayerId() {
        return doRead(TaskApiCall.builder().run(zzcq.zza).setMethodKey(6640).build());
    }

    public final Task<Intent> getPlayerSearchIntent() {
        return doRead(TaskApiCall.builder().run(zzcs.zza).setMethodKey(6645).build());
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadFriends(int i, boolean z) {
        return zzb("friends_all", i, z);
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(int i) {
        return zza("friends_all", i);
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i) {
        return zza("played_with", i);
    }

    public final Task<AnnotatedData<Player>> loadPlayer(String str) {
        return doRead(TaskApiCall.builder().run(new zzcu(str, false)).setMethodKey(6642).build());
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return zzb("played_with", i, z);
    }

    public zzcy(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<Intent> getCompareProfileIntent(String str) {
        return doRead(TaskApiCall.builder().run(new zzcv(str, (String) null, (String) null)).setMethodKey(6644).build());
    }

    public final Task<AnnotatedData<Player>> getCurrentPlayer(boolean z) {
        return doRead(TaskApiCall.builder().run(new zzcx(z)).setMethodKey(6641).build());
    }

    public final Task<AnnotatedData<Player>> loadPlayer(String str, boolean z) {
        return doRead(TaskApiCall.builder().run(new zzcu(str, z)).setMethodKey(6642).build());
    }
}
