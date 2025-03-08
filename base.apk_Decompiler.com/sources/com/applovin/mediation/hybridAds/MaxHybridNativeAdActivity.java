package com.applovin.mediation.hybridAds;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.mediation.a.b;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.R;

public class MaxHybridNativeAdActivity extends b {
    /* access modifiers changed from: private */
    public MaxNativeAdView nativeAdView;

    public void a(c cVar, final MaxNativeAd maxNativeAd, n nVar, MaxAdapterListener maxAdapterListener) {
        super.a(cVar, nVar, maxAdapterListener);
        MaxNativeAdView maxNativeAdView = new MaxNativeAdView(maxNativeAd, new MaxNativeAdViewBinder.Builder(R.layout.max_hybrid_native_ad_view).setTitleTextViewId(R.id.applovin_native_title_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setIconImageViewId(R.id.applovin_native_icon_image_view).setMediaContentViewGroupId(R.id.applovin_native_media_content_view).setOptionsContentViewGroupId(R.id.applovin_native_options_view).setCallToActionButtonId(R.id.applovin_native_cta_button).build(), (Context) this);
        this.nativeAdView = maxNativeAdView;
        maxNativeAdView.renderCustomNativeAdView(maxNativeAd);
        AnonymousClass1 r2 = new Runnable() {
            public void run() {
                if (!maxNativeAd.prepareForInteraction(MaxHybridNativeAdActivity.this.nativeAdView.getClickableViews(), MaxHybridNativeAdActivity.this.nativeAdView)) {
                    maxNativeAd.prepareViewForInteraction(MaxHybridNativeAdActivity.this.nativeAdView);
                }
            }
        };
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            runOnUiThread(r2);
        } else {
            nVar.BO().a((d) new ab(nVar, "MaxHybridNativeAdPrepareForInteraction", r2), q.b.MEDIATION_MAIN);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.nativeAdView, "MaxHybridNativeAdActivity");
    }
}
