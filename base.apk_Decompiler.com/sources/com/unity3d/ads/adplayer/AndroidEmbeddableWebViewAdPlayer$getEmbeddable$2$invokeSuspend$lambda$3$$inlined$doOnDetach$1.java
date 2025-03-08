package com.unity3d.ads.adplayer;

import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: View.kt */
public final class AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$invokeSuspend$lambda$3$$inlined$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ CoroutineScope $$this$coroutineScope$inlined;
    final /* synthetic */ RelativeLayout $this_apply$inlined;
    final /* synthetic */ View $this_doOnDetach;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$invokeSuspend$lambda$3$$inlined$doOnDetach$1(View view, RelativeLayout relativeLayout, CoroutineScope coroutineScope, AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer) {
        this.$this_doOnDetach = view;
        this.$this_apply$inlined = relativeLayout;
        this.$$this$coroutineScope$inlined = coroutineScope;
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$this_apply$inlined.removeAllViews();
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope$inlined, (CoroutineContext) null, (CoroutineStart) null, new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$3$1(this.this$0, (Continuation<? super AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2$bannerContainer$1$3$1>) null), 3, (Object) null);
    }
}
