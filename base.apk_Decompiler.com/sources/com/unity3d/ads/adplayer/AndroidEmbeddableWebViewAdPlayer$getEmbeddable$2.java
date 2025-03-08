package com.unity3d.ads.adplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.misc.ViewUtilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/widget/RelativeLayout;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2", f = "AndroidEmbeddableWebViewAdPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidEmbeddableWebViewAdPlayer.kt */
final class AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RelativeLayout>, Object> {
    final /* synthetic */ ShowOptions $showOptions;
    final /* synthetic */ UnityBannerSize $size;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2(ShowOptions showOptions, AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, UnityBannerSize unityBannerSize, Continuation<? super AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2> continuation) {
        super(2, continuation);
        this.$showOptions = showOptions;
        this.this$0 = androidEmbeddableWebViewAdPlayer;
        this.$size = unityBannerSize;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2 androidEmbeddableWebViewAdPlayer$getEmbeddable$2 = new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2(this.$showOptions, this.this$0, this.$size, continuation);
        androidEmbeddableWebViewAdPlayer$getEmbeddable$2.L$0 = obj;
        return androidEmbeddableWebViewAdPlayer$getEmbeddable$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RelativeLayout> continuation) {
        return ((AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ShowOptions showOptions = this.$showOptions;
            if (showOptions instanceof AndroidShowOptions) {
                Context context = ((AndroidShowOptions) showOptions).getContext();
                RelativeLayout relativeLayout = new RelativeLayout(context);
                AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer = this.this$0;
                UnityBannerSize unityBannerSize = this.$size;
                relativeLayout.setBackgroundColor(0);
                relativeLayout.setGravity(17);
                View view = relativeLayout;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.width = (int) ViewUtilities.dpFromPx(context, (float) unityBannerSize.getWidth());
                    layoutParams3.height = (int) ViewUtilities.dpFromPx(context, (float) unityBannerSize.getHeight());
                    view.setLayoutParams(layoutParams2);
                    relativeLayout.addView(androidEmbeddableWebViewAdPlayer.webViewContainer.getWebView());
                    if (ViewCompat.isAttachedToWindow(view)) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$2$1(androidEmbeddableWebViewAdPlayer, (Continuation<? super AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$2$1>) null), 3, (Object) null);
                    } else {
                        view.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$invokeSuspend$lambda$3$$inlined$doOnAttach$1(view, coroutineScope, androidEmbeddableWebViewAdPlayer));
                    }
                    if (!ViewCompat.isAttachedToWindow(view)) {
                        relativeLayout.removeAllViews();
                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$3$1(androidEmbeddableWebViewAdPlayer, (Continuation<? super AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$3$1>) null), 3, (Object) null);
                    } else {
                        view.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$invokeSuspend$lambda$3$$inlined$doOnDetach$1(view, relativeLayout, coroutineScope, androidEmbeddableWebViewAdPlayer));
                    }
                    return relativeLayout;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
