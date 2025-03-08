package com.ironsource.mediationsdk.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.NativeAdViewHolder;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010 J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018¨\u0006!"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/NativeAdLayout;", "Landroid/widget/FrameLayout;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdViewBinderInterface;", "Landroid/view/ViewGroup;", "viewGroup", "", "Landroid/view/View;", "views", "", "a", "view", "setBodyView", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayMediaView;", "mediaView", "setMediaView", "setCallToActionView", "setTitleView", "setIconView", "setAdvertiserView", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "nativeAd", "setNativeAd", "registerNativeAdViews", "Lcom/ironsource/mediationsdk/ads/nativead/internal/NativeAdViewHolder;", "Lcom/ironsource/mediationsdk/ads/nativead/internal/NativeAdViewHolder;", "mAdViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class NativeAdLayout extends FrameLayout implements NativeAdViewBinderInterface {
    private final NativeAdViewHolder a = new NativeAdViewHolder();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<View> a(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "child");
            arrayList.add(childAt);
        }
        return arrayList;
    }

    private final void a(ViewGroup viewGroup, List<? extends View> list) {
        for (View addView : list) {
            viewGroup.addView(addView);
        }
    }

    public final void registerNativeAdViews(LevelPlayNativeAd levelPlayNativeAd) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "nativeAd");
        List<View> a2 = a(this);
        removeAllViews();
        FrameLayout frameLayout = new FrameLayout(getContext());
        a(frameLayout, a2);
        AdapterNativeAdViewBinder nativeAdViewBinder = levelPlayNativeAd.getNativeAdViewBinder();
        if (nativeAdViewBinder != null) {
            nativeAdViewBinder.setBodyView(this.a.getBodyView());
            nativeAdViewBinder.setMediaView(this.a.getMediaView());
            nativeAdViewBinder.setCallToActionView(this.a.getCallToActionView());
            nativeAdViewBinder.setTitleView(this.a.getTitleView());
            nativeAdViewBinder.setIconView(this.a.getIconView());
            nativeAdViewBinder.setAdvertiserView(this.a.getAdvertiserView());
            nativeAdViewBinder.setNativeAdView(frameLayout);
            addView(nativeAdViewBinder.getNetworkNativeAdView());
        }
    }

    public void setAdvertiserView(View view) {
        this.a.setAdvertiserView(view);
    }

    public void setBodyView(View view) {
        this.a.setBodyView(view);
    }

    public void setCallToActionView(View view) {
        this.a.setCallToActionView(view);
    }

    public void setIconView(View view) {
        this.a.setIconView(view);
    }

    public void setMediaView(LevelPlayMediaView levelPlayMediaView) {
        this.a.setMediaView(levelPlayMediaView);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated - use registerNativeAdViews instead", replaceWith = @ReplaceWith(expression = "registerNativeAdViews", imports = {}))
    public final void setNativeAd(LevelPlayNativeAd levelPlayNativeAd) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "nativeAd");
        registerNativeAdViews(levelPlayNativeAd);
    }

    public void setTitleView(View view) {
        this.a.setTitleView(view);
    }
}
