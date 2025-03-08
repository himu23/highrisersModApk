package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzac;
import com.google.android.gms.internal.games.zzah;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.internal.games.zzay;
import com.google.android.gms.internal.games.zzbb;
import com.google.android.gms.internal.games.zzbg;
import com.google.android.gms.internal.games.zzbt;
import com.google.android.gms.internal.games.zzcm;
import com.google.android.gms.internal.games.zzco;
import com.google.android.gms.internal.games.zzcy;
import com.google.android.gms.internal.games.zzdi;
import com.google.android.gms.internal.games.zzds;
import com.google.android.gms.internal.games.zzek;
import com.google.android.gms.internal.games.zzep;
import com.google.android.gms.internal.games.zzex;
import com.google.android.gms.internal.games.zzfk;
import com.google.android.gms.internal.games.zzn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class Games {
    @Deprecated
    public static final Api<GamesOptions> API;
    @Deprecated
    public static final Achievements Achievements = new zzac();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    @Deprecated
    public static final Events Events = new zzar();
    @Deprecated
    public static final GamesMetadata GamesMetadata = new zzbg();
    @Deprecated
    public static final Leaderboards Leaderboards = new zzcm();
    @Deprecated
    public static final Players Players = new zzdi();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    public static final Scope SCOPE_GAMES_SNAPSHOTS = new Scope(Scopes.DRIVE_APPFOLDER);
    @Deprecated
    public static final Snapshots Snapshots = new zzek();
    @Deprecated
    public static final Stats Stats = new zzep();
    @Deprecated
    public static final Videos Videos = new zzfk();
    static final Api.ClientKey zza;
    public static final Scope zzb = new Scope(FirstPartyScopes.GAMES_1P);
    public static final Api zzc;
    private static final Api.AbstractClientBuilder zzd;
    private static final Api.AbstractClientBuilder zze;

    /* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
    public static final class GamesOptions implements Api.ApiOptions.Optional, GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions {
        public static final /* synthetic */ int zzp = 0;
        public final boolean zza = false;
        public final boolean zzb;
        public final int zzc;
        public final boolean zzd;
        public final int zze;
        public final String zzf;
        public final ArrayList zzg;
        public final boolean zzh;
        public final boolean zzi;
        public final boolean zzj;
        public final GoogleSignInAccount zzk;
        public final String zzl;
        public final int zzm;
        public final String zzn;
        public zzf zzo;
        private final int zzq;

        /* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
        public static final class Builder {
            private static final AtomicInteger zzh = new AtomicInteger(0);
            boolean zza = true;
            int zzb = 17;
            int zzc = 4368;
            ArrayList zzd = new ArrayList();
            GoogleSignInAccount zze = null;
            int zzf = 9;
            zzf zzg = zzf.zza;

            private Builder() {
            }

            public GamesOptions build() {
                return new GamesOptions(false, this.zza, this.zzb, false, this.zzc, (String) null, this.zzd, false, false, false, this.zze, (String) null, 0, this.zzf, (String) null, this.zzg, (zzn) null);
            }

            public Builder setSdkVariant(int i) {
                this.zzc = i;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zza = z;
                this.zzb = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int i) {
                this.zza = z;
                this.zzb = i;
                return this;
            }

            /* synthetic */ Builder(zzm zzm) {
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, zzm zzm) {
                if (gamesOptions != null) {
                    this.zza = gamesOptions.zzb;
                    this.zzb = gamesOptions.zzc;
                    this.zzc = gamesOptions.zze;
                    this.zzd = gamesOptions.zzg;
                    this.zze = gamesOptions.zzk;
                    this.zzf = gamesOptions.zzm;
                    this.zzg = gamesOptions.zzo;
                }
            }
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2, int i3, int i4, String str3, zzf zzf2, zzn zzn2) {
            this.zzb = z2;
            this.zzc = i;
            this.zzd = false;
            this.zze = i2;
            this.zzf = null;
            this.zzg = arrayList;
            this.zzh = false;
            this.zzi = false;
            this.zzj = false;
            this.zzk = googleSignInAccount;
            this.zzl = null;
            this.zzq = 0;
            this.zzm = i4;
            this.zzn = null;
            this.zzo = zzf2;
        }

        public static Builder builder() {
            return new Builder((zzm) null);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GamesOptions)) {
                return false;
            }
            GamesOptions gamesOptions = (GamesOptions) obj;
            boolean z = gamesOptions.zza;
            if (this.zzb == gamesOptions.zzb && this.zzc == gamesOptions.zzc) {
                boolean z2 = gamesOptions.zzd;
                if (this.zze == gamesOptions.zze) {
                    String str = gamesOptions.zzf;
                    if (this.zzg.equals(gamesOptions.zzg)) {
                        boolean z3 = gamesOptions.zzh;
                        boolean z4 = gamesOptions.zzi;
                        boolean z5 = gamesOptions.zzj;
                        GoogleSignInAccount googleSignInAccount = this.zzk;
                        if (googleSignInAccount != null ? googleSignInAccount.equals(gamesOptions.zzk) : gamesOptions.zzk == null) {
                            String str2 = gamesOptions.zzl;
                            if (TextUtils.equals((CharSequence) null, (CharSequence) null)) {
                                int i = gamesOptions.zzq;
                                if (this.zzm == gamesOptions.zzm) {
                                    String str3 = gamesOptions.zzn;
                                    if (Objects.equal((Object) null, (Object) null)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public final int getExtensionType() {
            return 1;
        }

        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzk;
        }

        public final List getImpliedScopes() {
            return Collections.singletonList(Games.SCOPE_GAMES_LITE);
        }

        public final int hashCode() {
            int i;
            int hashCode = ((((((((this.zzb ? 1 : 0) + true) * 31) + this.zzc) * 961) + this.zze) * 961) + this.zzg.hashCode()) * 923521;
            GoogleSignInAccount googleSignInAccount = this.zzk;
            if (googleSignInAccount == null) {
                i = 0;
            } else {
                i = googleSignInAccount.hashCode();
            }
            return (((hashCode + i) * 29791) + this.zzm) * 31;
        }

        public final Bundle toBundle() {
            return zza();
        }

        public final Bundle zza() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzb);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzc);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zze);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", (String) null);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzg);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
            bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzk);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", (String) null);
            bundle.putInt("com.google.android.gms.games.key.API_VERSION", this.zzm);
            bundle.putString("com.google.android.gms.games.key.gameRunToken", (String) null);
            return bundle;
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzg zzg = new zzg();
        zzd = zzg;
        zzh zzh = new zzh();
        zze = zzh;
        API = new Api<>("Games.API", zzg, clientKey);
        zzc = new Api("Games.API_1P", zzh, clientKey);
    }

    private Games() {
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzn(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzI();
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzah(activity, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzay(activity, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbb(activity, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbt(activity, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzco(activity, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzcy(activity, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzds(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzex(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzi(googleApiClient));
    }

    public static GamesOptions zza(GoogleSignInAccount googleSignInAccount) {
        int i = GamesOptions.zzp;
        GamesOptions.Builder builder = new GamesOptions.Builder((GamesOptions) null, (zzm) null);
        builder.zze = googleSignInAccount;
        builder.setSdkVariant(1052947);
        return builder.build();
    }

    public static GamesOptions zzb(GamesOptions gamesOptions, GoogleSignInAccount googleSignInAccount) {
        int i = GamesOptions.zzp;
        GamesOptions.Builder builder = new GamesOptions.Builder(gamesOptions, (zzm) null);
        builder.zze = googleSignInAccount;
        builder.setSdkVariant(1052947);
        return builder.build();
    }

    public static zzbz zzc(GoogleApiClient googleApiClient, boolean z) {
        Api<GamesOptions> api = API;
        Preconditions.checkState(googleApiClient.hasApi(api), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(api);
        if (z) {
            if (!hasConnectedApi) {
                throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
            }
        } else if (!hasConnectedApi) {
            return null;
        }
        return (zzbz) googleApiClient.getClient(zza);
    }

    public static zzbz zzd(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzn(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzah(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzay(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbb(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbt(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzco(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzcy(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzds(activity, zzb(gamesOptions, googleSignInAccount));
    }

    @Deprecated
    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzex(activity, zzb(gamesOptions, googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzn(context, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzah(context, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzay(context, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbb(context, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbt(context, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzco(context, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzcy(context, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzds(context, zza(googleSignInAccount));
    }

    @Deprecated
    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzex(context, zza(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzn(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzah(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzay(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbb(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbt(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzco(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzcy(context, zzb(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzds(context, zzb(gamesOptions, googleSignInAccount));
    }

    @Deprecated
    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzex(context, zzb(gamesOptions, googleSignInAccount));
    }
}
