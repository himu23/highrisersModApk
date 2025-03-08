package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.zzd;
import com.google.android.gms.internal.games.zzfo;
import com.google.android.gms.internal.games.zzfr;
import com.google.android.gms.internal.games.zzft;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzbz extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final zzfo zzf = new zzq(this);
    private final String zzg;
    private PlayerEntity zzh;
    private GameEntity zzi;
    private final zzcf zzj;
    private boolean zzk = false;
    private final long zzl;
    private final Games.GamesOptions zzm;
    private final zzcg zzn;

    public zzbz(Context context, Looper looper, ClientSettings clientSettings, Games.GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzcg zzcg) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzg = clientSettings.getRealClientPackageName();
        this.zzn = (zzcg) Preconditions.checkNotNull(zzcg);
        zzcf zzc = zzcf.zzc(this, clientSettings.getGravityForPopups());
        this.zzj = zzc;
        this.zzl = (long) hashCode();
        this.zzm = gamesOptions;
        boolean z = gamesOptions.zzh;
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zzc.zze(clientSettings.getViewForPopups());
        }
    }

    static /* bridge */ /* synthetic */ void zzL(zzbz zzbz, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzce) zzbz.getService()).zzf())));
        } catch (RemoteException e) {
            taskCompletionSource.setException(e);
        }
    }

    /* access modifiers changed from: private */
    public static void zzbf(RemoteException remoteException) {
        zzft.zze("GamesGmsClientImpl", "service died", remoteException);
    }

    private static void zzbg(BaseImplementation.ResultHolder resultHolder, SecurityException securityException) {
        if (resultHolder != null) {
            resultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        this.zzi = null;
        super.connect(connectionProgressReportCallbacks);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return queryLocalInterface instanceof zzce ? (zzce) queryLocalInterface : new zzce(iBinder);
    }

    public final void disconnect() {
        this.zzk = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzce) getService()).zzv(this.zzl);
            } catch (RemoteException unused) {
                zzft.zzd("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public final Feature[] getApiFeatures() {
        return zzd.zzf;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zza = this.zzm.zza();
        zza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzg);
        zza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        zza.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzj.zzb()));
        if (!zza.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            zza.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        zza.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zza;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final Set getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzce zzce = (zzce) iInterface;
        super.onConnectedLocked(zzce);
        if (this.zzk) {
            this.zzj.zzg();
            this.zzk = false;
        }
        Games.GamesOptions gamesOptions = this.zzm;
        boolean z = gamesOptions.zza;
        boolean z2 = gamesOptions.zzh;
        try {
            zzce.zzW(new zzs(new zzfr(this.zzj.zzd())), this.zzl);
        } catch (RemoteException e) {
            zzbf(e);
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzk = false;
    }

    /* access modifiers changed from: protected */
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0) {
            i = 0;
            if (bundle != null) {
                bundle.setClassLoader(zzbz.class.getClassLoader());
                this.zzk = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
                this.zzi = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
            }
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzaV(new zzx(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final boolean requiresAccount() {
        return true;
    }

    public final boolean requiresSignIn() {
        Games.GamesOptions gamesOptions = this.zzm;
        zzf zzf2 = gamesOptions.zzo;
        String str = gamesOptions.zzl;
        boolean z = gamesOptions.zzh;
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final Intent zzA() {
        try {
            return zzz();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzB(String str, boolean z, boolean z2, int i) throws RemoteException {
        return ((zzce) getService()).zzm(str, z, z2, i);
    }

    public final Intent zzC(String str, boolean z, boolean z2, int i) {
        try {
            return zzB(str, z, z2, i);
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Game zzD() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzi == null) {
                GameBuffer gameBuffer = new GameBuffer(((zzce) getService()).zzp());
                try {
                    if (gameBuffer.getCount() > 0) {
                        this.zzi = new GameEntity(gameBuffer.get(0));
                    }
                    gameBuffer.release();
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzi;
    }

    public final Game zzE() {
        try {
            return zzD();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Player zzF() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzh == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzce) getService()).zzq());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.zzh = new PlayerEntity(playerBuffer.get(0));
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzh;
    }

    public final Player zzG() {
        try {
            return zzF();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final String zzH() throws RemoteException {
        return ((zzce) getService()).zzs();
    }

    public final String zzI() {
        try {
            return zzH();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final String zzJ(boolean z) throws RemoteException {
        PlayerEntity playerEntity = this.zzh;
        return playerEntity != null ? playerEntity.getPlayerId() : ((zzce) getService()).zzt();
    }

    public final String zzK(boolean z) {
        try {
            return zzJ(true);
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN() {
        if (isConnected()) {
            try {
                ((zzce) getService()).zzu();
            } catch (RemoteException e) {
                zzbf(e);
            }
        }
    }

    public final void zzO(BaseImplementation.ResultHolder resultHolder, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzce) getService()).zzw(new zzh(resultHolder), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzP(TaskCompletionSource taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzce) getService()).zzw(new zzag(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzQ(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        try {
            ((zzce) getService()).zzx(new zzi(resultHolder), str);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzR(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzce) getService()).zzx(new zzai(taskCompletionSource), str);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzS(Snapshot snapshot) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zza = snapshotContents.zza();
        snapshotContents.zzb();
        ((zzce) getService()).zzy(zza);
    }

    public final void zzT(Snapshot snapshot) {
        try {
            zzS(snapshot);
        } catch (RemoteException e) {
            zzbf(e);
        }
    }

    public final void zzU(BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        try {
            ((zzce) getService()).zzB(new zzj(resultHolder));
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzV(TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            ((zzce) getService()).zzB(new zzbk(taskCompletionSource));
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzW(BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        try {
            ((zzce) getService()).zzz(new zzk(resultHolder));
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzX(TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            ((zzce) getService()).zzz(new zzbh(taskCompletionSource));
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzY(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzQ(new zzbp(taskCompletionSource), (String) null, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaA(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzP(new zzg(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaB(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzP(new zzbm(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaC(BaseImplementation.ResultHolder resultHolder, String str, int i, boolean z, boolean z2) throws RemoteException {
        try {
            ((zzce) getService()).zzR(new zzbn(resultHolder), "played_with", i, z, z2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaD(TaskCompletionSource taskCompletionSource, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (str.equals("played_with") || str.equals("friends_all")) {
            try {
                ((zzce) getService()).zzR(new zzbo(this, taskCompletionSource), str, i, z, z2);
            } catch (SecurityException e) {
                GamesStatusUtils.zzb(taskCompletionSource, e);
            }
        } else {
            throw new IllegalArgumentException("Invalid player collection: ".concat(str));
        }
    }

    public final void zzaE(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzS(new zzbw(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaF(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzS(new zzbi(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaG(BaseImplementation.ResultHolder resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzT(new zzas(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaH(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzT(new zzat(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaI(BaseImplementation.ResultHolder resultHolder, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzce) getService()).zzU(new zzbt(resultHolder), str, z, i);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaJ(TaskCompletionSource taskCompletionSource, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzce) getService()).zzU(new zzbv(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaK(ListenerHolder listenerHolder) {
        try {
            ((zzce) getService()).zzV(new zzp(listenerHolder), this.zzl);
        } catch (RemoteException e) {
            zzbf(e);
        }
    }

    public final void zzaL(ListenerHolder listenerHolder) throws RemoteException {
        ((zzce) getService()).zzV(new zzn(listenerHolder), this.zzl);
    }

    public final void zzaM(BaseImplementation.ResultHolder resultHolder, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzce) getService()).zzX(new zzbt(resultHolder), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaN(TaskCompletionSource taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzce) getService()).zzX(new zzbv(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaS(int i) {
        this.zzj.zzf(i);
    }

    public final void zzaT(View view) {
        this.zzj.zze(view);
    }

    /* access modifiers changed from: package-private */
    public final void zzaU(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            zzf zzf2 = this.zzm.zzo;
            try {
                ((zzce) getService()).zzaa(iBinder, bundle);
                this.zzn.zzb();
            } catch (RemoteException e) {
                zzbf(e);
            }
        }
    }

    public final void zzaV(BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce) getService()).zzab(new zzy(resultHolder));
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaW(String str, long j, String str2) throws RemoteException {
        try {
            ((zzce) getService()).zzac((zzcb) null, str, j, str2);
        } catch (SecurityException unused) {
        }
    }

    public final void zzaY(TaskCompletionSource taskCompletionSource, String str, long j, String str2) throws RemoteException {
        try {
            ((zzce) getService()).zzac(new zzbs(taskCompletionSource), str, j, str2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzab(String str, int i) {
        this.zzf.zzc(str, i);
    }

    public final void zzac(BaseImplementation.ResultHolder resultHolder, int i) throws RemoteException {
        try {
            ((zzce) getService()).zzE(new zzl(resultHolder), i);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzad(TaskCompletionSource taskCompletionSource, int i) throws RemoteException {
        try {
            ((zzce) getService()).zzE(new zzbj(taskCompletionSource), i);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzae(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzF(new zzv(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaf(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzF(new zzac(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzag(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzG(new zzbn(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzah(TaskCompletionSource taskCompletionSource, String str, int i, int i2) throws RemoteException {
        try {
            ((zzce) getService()).zzA(new zzar(this, taskCompletionSource), (String) null, str, i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzai(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce) getService()).zzH(new zzak(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaj(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce) getService()).zzH(new zzal(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzak(BaseImplementation.ResultHolder resultHolder, boolean z, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce) getService()).zzI(new zzak(resultHolder), z, strArr);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzal(TaskCompletionSource taskCompletionSource, boolean z, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzce) getService()).zzI(new zzal(taskCompletionSource), z, strArr);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzam(BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        try {
            ((zzce) getService()).zzJ(new zzw(resultHolder));
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzan(TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            ((zzce) getService()).zzJ(new zzan(taskCompletionSource));
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzao(BaseImplementation.ResultHolder resultHolder, int i, boolean z, boolean z2) throws RemoteException {
        try {
            ((zzce) getService()).zzK(new zzbn(resultHolder), i, z, z2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzap(BaseImplementation.ResultHolder resultHolder, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzM(new zzau(resultHolder), z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaq(BaseImplementation.ResultHolder resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzL(new zzau(resultHolder), str, z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzar(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzL(new zzap(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzas(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzM(new zzav(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzat(BaseImplementation.ResultHolder resultHolder, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzce) getService()).zzN(new zzas(resultHolder), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzau(TaskCompletionSource taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzce) getService()).zzN(new zzat(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzav(BaseImplementation.ResultHolder resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzQ(new zzbn(resultHolder), str, z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaw(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzQ(new zzbp(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzax(BaseImplementation.ResultHolder resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzO(new zzas(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzay(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzce) getService()).zzO(new zzat(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaz(BaseImplementation.ResultHolder resultHolder, String str, String str2, int i, int i2) throws RemoteException {
        try {
            ((zzce) getService()).zzA(new zzt(resultHolder), (String) null, str2, i, i2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzbb() throws RemoteException {
        ((zzce) getService()).zzae(this.zzl);
    }

    public final void zzbc() {
        try {
            zzbb();
        } catch (RemoteException e) {
            zzbf(e);
        }
    }

    public final boolean zzbd() throws RemoteException {
        return ((zzce) getService()).zzaf();
    }

    public final boolean zzbe() {
        try {
            return zzbd();
        } catch (RemoteException e) {
            zzbf(e);
            return false;
        }
    }

    public final int zzp() throws RemoteException {
        return ((zzce) getService()).zzd();
    }

    public final int zzq() {
        try {
            return zzp();
        } catch (RemoteException e) {
            zzbf(e);
            return -1;
        }
    }

    public final int zzr() throws RemoteException {
        return ((zzce) getService()).zze();
    }

    public final int zzs() {
        try {
            return zzr();
        } catch (RemoteException e) {
            zzbf(e);
            return -1;
        }
    }

    public final Intent zzt() {
        try {
            return ((zzce) getService()).zzg();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzu() {
        try {
            return ((zzce) getService()).zzh();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzv() throws RemoteException {
        return ((zzce) getService()).zzo();
    }

    public final Intent zzw() {
        try {
            return zzv();
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzx(PlayerEntity playerEntity) {
        try {
            return ((zzce) getService()).zzi(playerEntity);
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzy(String str, int i, int i2) {
        try {
            return ((zzce) getService()).zzk(str, i, i2);
        } catch (RemoteException e) {
            zzbf(e);
            return null;
        }
    }

    public final Intent zzz() throws RemoteException {
        return ((zzce) getService()).zzl();
    }

    public final void zzaX(BaseImplementation.ResultHolder resultHolder, String str, long j, String str2) throws RemoteException {
        zzu zzu;
        if (resultHolder == null) {
            zzu = null;
        } else {
            zzu = new zzu(resultHolder);
        }
        try {
            ((zzce) getService()).zzac(zzu, str, j, str2);
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaO(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        zzz zzz;
        if (resultHolder == null) {
            zzz = null;
        } else {
            zzz = new zzz(resultHolder);
        }
        try {
            ((zzce) getService()).zzY(zzz, str, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaP(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzab zzab;
        if (taskCompletionSource == null) {
            zzab = null;
        } else {
            zzab = new zzab(taskCompletionSource);
        }
        try {
            ((zzce) getService()).zzY(zzab, str, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaZ(BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        zzz zzz;
        if (resultHolder == null) {
            zzz = null;
        } else {
            zzz = new zzz(resultHolder);
        }
        try {
            ((zzce) getService()).zzad(zzz, str, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzba(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzab zzab;
        if (taskCompletionSource == null) {
            zzab = null;
        } else {
            zzab = new zzab(taskCompletionSource);
        }
        try {
            ((zzce) getService()).zzad(zzab, str, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzZ(BaseImplementation.ResultHolder resultHolder, String str, int i) throws RemoteException {
        zzz zzz;
        if (resultHolder == null) {
            zzz = null;
        } else {
            zzz = new zzz(resultHolder);
        }
        try {
            ((zzce) getService()).zzC(zzz, str, i, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaQ(BaseImplementation.ResultHolder resultHolder, String str, int i) throws RemoteException {
        zzz zzz;
        if (resultHolder == null) {
            zzz = null;
        } else {
            zzz = new zzz(resultHolder);
        }
        try {
            ((zzce) getService()).zzZ(zzz, str, i, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            zzbg(resultHolder, e);
        }
    }

    public final void zzaR(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzaa zzaa;
        if (taskCompletionSource == null) {
            zzaa = null;
        } else {
            zzaa = new zzaa(taskCompletionSource);
        }
        try {
            ((zzce) getService()).zzZ(zzaa, str, i, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzaa(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzaa zzaa;
        if (taskCompletionSource == null) {
            zzaa = null;
        } else {
            zzaa = new zzaa(taskCompletionSource);
        }
        try {
            ((zzce) getService()).zzC(zzaa, str, i, this.zzj.zzb(), this.zzj.zza());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }
}
