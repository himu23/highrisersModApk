package com.fyber.marketplace.fairbid.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBannerDisplayEventsListener;
import java.util.Map;
import org.json.JSONObject;

public class d extends a implements MarketplaceBannerAd, InneractiveAdViewEventsListener {
    private FrameLayout mContainer;
    private final InneractiveAdViewUnitController mController;
    private MarketplaceBannerDisplayEventsListener mEventsListener;
    private boolean mInternalBrowserPossiblyOpen = false;
    private final MarketplaceAdLoadListener<MarketplaceBannerAd> mLoadListener;

    public static class a extends FrameLayout {
        public a(Context context) {
            super(context);
        }

        public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) super.generateLayoutParams(layoutParams);
            layoutParams2.gravity = 17;
            return layoutParams2;
        }

        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (size2 > 0) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else {
                super.onMeasure(i, i2);
            }
        }
    }

    public d(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAdLoadListener<MarketplaceBannerAd> marketplaceAdLoadListener, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        super(str, jSONObject, map, z, marketplaceAuctionParameters);
        this.mLoadListener = marketplaceAdLoadListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = new InneractiveAdViewUnitController(true);
        this.mController = inneractiveAdViewUnitController;
        inneractiveAdViewUnitController.setEventsListener(this);
    }

    public boolean canRefresh() {
        return !this.mInternalBrowserPossiblyOpen && this.mController.canRefreshAd();
    }

    public int getAdWidth() {
        return this.mController != null ? -1 : 0;
    }

    public boolean isFullscreen() {
        return false;
    }

    public boolean isUsingFullWidth() {
        return true;
    }

    public void load() {
        loadAd(this.mController, this.mLoadListener);
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = false;
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = false;
    }

    public void showInView(ViewGroup viewGroup, MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener) {
        if (this.mController == null || this.adSpot == null) {
            IAlog.b("Banner is not ready to be shown", new Object[0]);
            return;
        }
        this.mContainer = new a(viewGroup.getContext());
        viewGroup.removeAllViews();
        viewGroup.addView(this.mContainer);
        this.mController.bindView(this.mContainer);
        this.mEventsListener = marketplaceBannerDisplayEventsListener;
    }

    public int getAdHeight() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController != null) {
            return inneractiveAdViewUnitController.getAdContentHeight();
        }
        return 0;
    }

    public void internalOnAdLoaded(a aVar, e eVar) {
        if (!(this.mController == null || eVar == null)) {
            InneractiveAdSpotManager.get().bindSpot(eVar);
            this.mController.setAdSpot(eVar);
        }
        MarketplaceAdLoadListener<MarketplaceBannerAd> marketplaceAdLoadListener = this.mLoadListener;
        if (marketplaceAdLoadListener != null) {
            marketplaceAdLoadListener.onAdLoaded(this);
        }
    }

    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController != null && (marketplaceBannerDisplayEventsListener = this.mEventsListener) != null) {
            marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
        }
    }

    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController != null && (marketplaceBannerDisplayEventsListener = this.mEventsListener) != null) {
            marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
        }
    }

    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener = this.mEventsListener;
        if (marketplaceBannerDisplayEventsListener != null) {
            marketplaceBannerDisplayEventsListener.onShow();
        }
    }

    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController != null && (marketplaceBannerDisplayEventsListener = this.mEventsListener) != null) {
            marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
        }
    }

    public void destroy() {
        if (this.mController != null) {
            FrameLayout frameLayout = this.mContainer;
            if (frameLayout != null) {
                ViewParent parent = frameLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeAllViews();
                }
                this.mController.unbindView(this.mContainer);
                this.mContainer = null;
            }
            InneractiveAdSpot adSpot = this.mController.getAdSpot();
            if (adSpot != null) {
                adSpot.destroy();
            }
        }
    }

    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = true;
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener = this.mEventsListener;
        if (marketplaceBannerDisplayEventsListener != null) {
            marketplaceBannerDisplayEventsListener.onClick();
        }
    }
}
