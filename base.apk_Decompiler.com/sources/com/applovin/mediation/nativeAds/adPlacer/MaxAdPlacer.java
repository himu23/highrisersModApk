package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.mediation.nativeAds.a.a;
import com.applovin.impl.mediation.nativeAds.a.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxAdPlacer implements b.a {
    private AppLovinSdkUtils.Size aYT;
    private MaxNativeAdViewBinder aYU;
    private final a aYV;
    private final b aYW;
    private Listener aYX;
    protected final x logger;
    protected final n sdk;

    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i);

        void onAdRemoved(int i);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public void setListener(Listener listener) {
        this.aYX = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.aYU = maxNativeAdViewBinder;
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.aYT = AppLovinSdkUtils.Size.ZERO;
        n a = appLovinSdk.a();
        this.sdk = a;
        x BN = a.BN();
        this.logger = BN;
        this.aYV = new a(maxAdPlacerSettings);
        this.aYW = new b(maxAdPlacerSettings, context, this);
        if (x.Fn()) {
            BN.f("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
        }
    }

    public void destroy() {
        if (x.Fn()) {
            this.logger.f("MaxAdPlacer", "Destroying ad placer");
        }
        clearAds();
        this.aYW.destroy();
    }

    public void setAdSize(int i, int i2) {
        this.aYT = new AppLovinSdkUtils.Size(i, i2);
    }

    public void loadAds() {
        if (x.Fn()) {
            this.logger.f("MaxAdPlacer", "Loading ads");
        }
        this.aYW.loadAds();
    }

    public void clearAds() {
        a(this.aYV.yN(), (Runnable) new MaxAdPlacer$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void MO() {
        if (x.Fn()) {
            this.logger.f("MaxAdPlacer", "Clearing all cached ads");
        }
        this.aYV.clearAds();
        this.aYW.clearAds();
    }

    public Collection<Integer> clearTrailingAds(int i) {
        Collection<Integer> gr = this.aYV.gr(i);
        if (!gr.isEmpty()) {
            a(gr, (Runnable) new MaxAdPlacer$$ExternalSyntheticLambda0(this, i, gr));
        }
        return gr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i, Collection collection) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("MaxAdPlacer", "Clearing trailing ads after position " + i);
        }
        this.aYV.g(collection);
    }

    public boolean isAdPosition(int i) {
        return this.aYV.isAdPosition(i);
    }

    public boolean isFilledPosition(int i) {
        return this.aYV.isFilledPosition(i);
    }

    public long getAdItemId(int i) {
        if (isFilledPosition(i)) {
            return (long) (-System.identityHashCode(this.aYV.gq(i)));
        }
        return 0;
    }

    public AppLovinSdkUtils.Size getAdSize(int i, int i2) {
        if (isFilledPosition(i)) {
            boolean z = this.aYT != AppLovinSdkUtils.Size.ZERO;
            int min = Math.min(z ? this.aYT.getWidth() : 360, i2);
            d dVar = (d) this.aYV.gq(i);
            if ("small_template_1".equalsIgnoreCase(dVar.yn())) {
                return new AppLovinSdkUtils.Size(min, z ? this.aYT.getHeight() : 120);
            } else if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(dVar.yn())) {
                return new AppLovinSdkUtils.Size(min, (int) (((double) min) / (z ? ((double) this.aYT.getWidth()) / ((double) this.aYT.getHeight()) : 1.2d)));
            } else if (z) {
                return this.aYT;
            } else {
                if (dVar.yl() != null) {
                    View mainView = dVar.yl().getMainView();
                    return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
                }
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public void renderAd(int i, ViewGroup viewGroup) {
        MaxAd gq = this.aYV.gq(i);
        if (gq != null) {
            MaxNativeAdView yl = ((d) gq).yl();
            if (yl != null) {
                if (x.Fn()) {
                    this.logger.f("MaxAdPlacer", "Using pre-rendered ad at position: " + i);
                }
            } else if (this.aYU != null) {
                yl = new MaxNativeAdView(this.aYU, viewGroup.getContext());
                if (this.aYW.render(yl, gq)) {
                    if (x.Fn()) {
                        this.logger.f("MaxAdPlacer", "Rendered ad at position: " + i);
                    }
                } else if (x.Fn()) {
                    this.logger.i("MaxAdPlacer", "Unable to render ad at position: " + i);
                }
            } else if (x.Fn()) {
                this.logger.i("MaxAdPlacer", "Unable to render ad at position: " + i + ". If you're using a custom ad template, check that nativeAdViewBinder is set.");
                return;
            } else {
                return;
            }
            for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
                if (viewGroup.getChildAt(childCount) instanceof MaxNativeAdView) {
                    viewGroup.removeViewAt(childCount);
                }
            }
            if (yl.getParent() != null) {
                ((ViewGroup) yl.getParent()).removeView(yl);
            }
            viewGroup.addView(yl, -1, -1);
        } else if (x.Fn()) {
            this.logger.f("MaxAdPlacer", "An ad is not available for position: " + i);
        }
    }

    public void updateFillablePositions(int i, int i2) {
        this.aYV.Q(i, i2);
        if (i != -1 && i2 != -1) {
            MN();
        }
    }

    public int getAdjustedCount(int i) {
        return this.aYV.getAdjustedCount(i);
    }

    public int getAdjustedPosition(int i) {
        return this.aYV.getAdjustedPosition(i);
    }

    public int getOriginalPosition(int i) {
        return this.aYV.getOriginalPosition(i);
    }

    public void insertItem(int i) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("MaxAdPlacer", "Inserting item at position: " + i);
        }
        this.aYV.insertItem(i);
    }

    public void removeItem(int i) {
        List list;
        if (isFilledPosition(i)) {
            list = Collections.singletonList(Integer.valueOf(i));
        } else {
            list = Collections.emptyList();
        }
        a((Collection<Integer>) list, (Runnable) new MaxAdPlacer$$ExternalSyntheticLambda1(this, i));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hb(int i) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("MaxAdPlacer", "Removing item at position: " + i);
        }
        this.aYV.removeItem(i);
    }

    public void moveItem(int i, int i2) {
        this.aYV.moveItem(i, i2);
    }

    private void MN() {
        int yM;
        while (this.aYW.yO() && (yM = this.aYV.yM()) != -1) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("MaxAdPlacer", "Placing ad at position: " + yM);
            }
            this.aYV.a(this.aYW.yP(), yM);
            Listener listener = this.aYX;
            if (listener != null) {
                listener.onAdLoaded(yM);
            }
        }
    }

    private void a(Collection<Integer> collection, Runnable runnable) {
        for (Integer intValue : collection) {
            this.aYW.destroyAd(this.aYV.gq(intValue.intValue()));
        }
        runnable.run();
        if (!collection.isEmpty()) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
            }
            if (this.aYX != null) {
                for (Integer intValue2 : collection) {
                    this.aYX.onAdRemoved(intValue2.intValue());
                }
            }
        }
    }

    public void onNativeAdLoaded() {
        if (x.Fn()) {
            this.logger.f("MaxAdPlacer", "Native ad enqueued");
        }
        MN();
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.i("MaxAdPlacer", "Native ad failed to load: " + maxError);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.aYX;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }
}
