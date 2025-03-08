package com.applovin.impl.mediation.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.hybridAds.MaxHybridMRecAdActivity;
import com.applovin.mediation.hybridAds.MaxHybridNativeAdActivity;

public class d {
    private final n sdk;

    public d(n nVar) {
        this.sdk = nVar;
    }

    public void a(c cVar, Activity activity, MaxAdapterListener maxAdapterListener) {
        u.LF();
        if (activity == null) {
            activity = this.sdk.BM().Az();
        }
        if (cVar.getNativeAd() != null) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("MaxHybridAdService", "Showing fullscreen native ad...");
            }
            this.sdk.BM().a(new b(cVar, this.sdk, maxAdapterListener));
            activity.startActivity(new Intent(activity, MaxHybridNativeAdActivity.class));
        } else if (cVar.getAdView() != null) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("MaxHybridAdService", "Showing fullscreen MREC ad...");
            }
            this.sdk.BM().a(new a(cVar, this.sdk, maxAdapterListener));
            activity.startActivity(new Intent(activity, MaxHybridMRecAdActivity.class));
        } else if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        } else if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        } else {
            throw new IllegalStateException("Failed to display hybrid ad: neither native nor adview ad");
        }
    }

    private static class b extends com.applovin.impl.sdk.utils.a {
        private final MaxAdapterListener aur;
        private final c aut;
        private final n sdk;

        public b(c cVar, n nVar, MaxAdapterListener maxAdapterListener) {
            this.aut = cVar;
            this.sdk = nVar;
            this.aur = maxAdapterListener;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridNativeAdActivity) {
                ((MaxHybridNativeAdActivity) activity).a(this.aut.xG(), this.aut.getNativeAd(), this.sdk, this.aur);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridNativeAdActivity) && !activity.isChangingConfigurations() && this.aut.xP().get()) {
                this.sdk.BM().b(this);
            }
        }
    }

    private static class a extends com.applovin.impl.sdk.utils.a {
        private final MaxAdapterListener aur;
        private final c aut;
        private final n sdk;

        public a(c cVar, n nVar, MaxAdapterListener maxAdapterListener) {
            this.aut = cVar;
            this.sdk = nVar;
            this.aur = maxAdapterListener;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridMRecAdActivity) {
                ((MaxHybridMRecAdActivity) activity).a(this.aut.xG(), this.aut.getAdView(), this.sdk, this.aur);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridMRecAdActivity) && !activity.isChangingConfigurations() && this.aut.xP().get()) {
                this.sdk.BM().b(this);
            }
        }
    }
}
