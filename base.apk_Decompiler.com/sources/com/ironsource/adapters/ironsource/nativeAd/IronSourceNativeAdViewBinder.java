package com.ironsource.adapters.ironsource.nativeAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.q6;
import com.ironsource.r6;
import com.ironsource.sdk.mediation.R;
import com.ironsource.t6;
import com.ironsource.u6;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@RX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdViewBinder;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "Landroid/widget/FrameLayout$LayoutParams;", "getPrivacyIconLayoutParams", "Landroid/view/View;", "nativeAdView", "", "setNativeAdView", "Lcom/ironsource/t6;", "nativeAd", "Lcom/ironsource/t6;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/NativeAdProperties;", "nativeAdProperties", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/NativeAdProperties;", "Lcom/ironsource/q6;", "<set-?>", "networkNativeAdView", "Lcom/ironsource/q6;", "getNetworkNativeAdView", "()Lcom/ironsource/q6;", "<init>", "(Lcom/ironsource/t6;Lcom/ironsource/mediationsdk/adunit/adapter/utility/NativeAdProperties;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class IronSourceNativeAdViewBinder extends AdapterNativeAdViewBinder {
    private final t6 nativeAd;
    private final NativeAdProperties nativeAdProperties;
    private q6 networkNativeAdView;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition[] r0 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.ironsource.nativeAd.IronSourceNativeAdViewBinder.WhenMappings.<clinit>():void");
        }
    }

    public IronSourceNativeAdViewBinder(t6 t6Var, NativeAdProperties nativeAdProperties2) {
        Intrinsics.checkNotNullParameter(t6Var, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdProperties2, "nativeAdProperties");
        this.nativeAd = t6Var;
        this.nativeAdProperties = nativeAdProperties2;
    }

    private final FrameLayout.LayoutParams getPrivacyIconLayoutParams() {
        int i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.nativeAdProperties.getAdOptionsPosition().ordinal()];
        if (i2 == 1) {
            i = 51;
        } else if (i2 == 2) {
            i = 53;
        } else if (i2 == 3) {
            i = 83;
        } else if (i2 == 4) {
            i = 85;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        layoutParams.gravity = i;
        return layoutParams;
    }

    public q6 getNetworkNativeAdView() {
        return this.networkNativeAdView;
    }

    public void setNativeAdView(View view) {
        if (view == null) {
            IronLog.INTERNAL.error("nativeAdView is null");
        } else if (this.nativeAd.b() == null) {
            IronLog.INTERNAL.error("nativeAd.adData is null");
        } else {
            LevelPlayMediaView mediaView = getNativeAdViewHolder().getMediaView();
            if (mediaView != null) {
                r6 b = this.nativeAd.b();
                Intrinsics.checkNotNull(b);
                WebView l = b.l();
                if (l != null) {
                    mediaView.addView(l, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            r6 b2 = this.nativeAd.b();
            Intrinsics.checkNotNull(b2);
            View m = b2.m();
            m.setId(R.id.privacy_icon_button);
            m.setLayoutParams(getPrivacyIconLayoutParams());
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            q6 q6Var = new q6(context);
            q6Var.addView(view);
            q6Var.addView(m);
            this.networkNativeAdView = q6Var;
            q6 networkNativeAdView2 = getNetworkNativeAdView();
            Intrinsics.checkNotNull(networkNativeAdView2);
            this.nativeAd.a(new u6(networkNativeAdView2, getNativeAdViewHolder().getTitleView(), getNativeAdViewHolder().getAdvertiserView(), getNativeAdViewHolder().getIconView(), getNativeAdViewHolder().getBodyView(), getNativeAdViewHolder().getMediaView(), getNativeAdViewHolder().getCallToActionView(), m));
        }
    }
}
