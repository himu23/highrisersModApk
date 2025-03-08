package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzdi implements Players {
    public final Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzd(googleApiClient, true).zzx(new PlayerEntity(player));
    }

    public final Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient, true).zzG();
    }

    public final String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient, true).zzK(true);
    }

    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient, true).zzA();
    }

    public final PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzdf(this, googleApiClient, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new zzdb(this, googleApiClient, i, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzdc(this, googleApiClient, i));
    }

    public final PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzde(this, googleApiClient, i));
    }

    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzcz(this, googleApiClient, str));
    }

    public final PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.enqueue(new zzdd(this, googleApiClient, i, z));
    }

    public final PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.enqueue(new zzda(this, googleApiClient, str, z));
    }
}
