package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzex extends zzad implements VideosClient {
    public static final /* synthetic */ int zza = 0;

    public zzex(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public final Task<VideoCapabilities> getCaptureCapabilities() {
        return doRead(TaskApiCall.builder().run(zzeu.zza).setMethodKey(6677).build());
    }

    public final Task<Intent> getCaptureOverlayIntent() {
        return doRead(TaskApiCall.builder().run(zzer.zza).setMethodKey(6678).build());
    }

    public final Task<CaptureState> getCaptureState() {
        return doRead(TaskApiCall.builder().run(zzew.zza).setMethodKey(6679).build());
    }

    public final Task<Boolean> isCaptureAvailable(int i) {
        return doRead(TaskApiCall.builder().run(new zzev(i)).setMethodKey(6680).build());
    }

    public final Task<Boolean> isCaptureSupported() {
        return doRead(TaskApiCall.builder().run(zzeq.zza).setMethodKey(6681).build());
    }

    public final Task<Void> registerOnCaptureOverlayStateChangedListener(VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        ListenerHolder registerListener = registerListener(onCaptureOverlayStateListener, VideosClient.OnCaptureOverlayStateListener.class.getSimpleName());
        Preconditions.checkNotNull(registerListener.getListenerKey(), "Key must not be null");
        zzes zzes = new zzes(registerListener);
        return doRegisterEventListener(RegistrationMethods.builder().register(zzes).unregister(zzet.zza).withHolder(registerListener).setMethodKey(6682).build());
    }

    public final Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(onCaptureOverlayStateListener, VideosClient.OnCaptureOverlayStateListener.class.getSimpleName()), 6683);
    }

    public zzex(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }
}
