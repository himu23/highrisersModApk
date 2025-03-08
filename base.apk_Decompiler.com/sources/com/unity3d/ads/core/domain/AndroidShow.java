package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.adplayer.FullscreenAdPlayer;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidShow;", "Lcom/unity3d/ads/core/domain/Show;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "gameServerIdReader", "Lcom/unity3d/ads/core/configuration/GameServerIdReader;", "(Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/configuration/GameServerIdReader;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "context", "Landroid/content/Context;", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "terminate", "", "(Lcom/unity3d/ads/core/data/model/AdObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidShow.kt */
public final class AndroidShow implements Show {
    /* access modifiers changed from: private */
    public final AdRepository adRepository;
    /* access modifiers changed from: private */
    public final GameServerIdReader gameServerIdReader;

    public AndroidShow(AdRepository adRepository2, GameServerIdReader gameServerIdReader2) {
        Intrinsics.checkNotNullParameter(adRepository2, "adRepository");
        Intrinsics.checkNotNullParameter(gameServerIdReader2, "gameServerIdReader");
        this.adRepository = adRepository2;
        this.gameServerIdReader = gameServerIdReader2;
    }

    public Flow<ShowEvent> invoke(Context context, AdObject adObject) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        return FlowKt.flow(new AndroidShow$invoke$1(adObject, this, context, (Continuation<? super AndroidShow$invoke$1>) null));
    }

    public Object terminate(AdObject adObject, Continuation<? super Unit> continuation) {
        FullscreenAdPlayer fullscreenAdPlayer = adObject.getFullscreenAdPlayer();
        if (fullscreenAdPlayer == null) {
            return Unit.INSTANCE;
        }
        Object terminate = fullscreenAdPlayer.terminate(continuation);
        return terminate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? terminate : Unit.INSTANCE;
    }
}
