package com.fyber.marketplace.fairbid.impl;

import android.app.Activity;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdShowError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenDisplayEventsListener;
import java.util.Map;
import org.json.JSONObject;

public abstract class g<T extends MarketplaceFullscreenDisplayEventsListener> extends a implements MarketplaceFullscreenAd<T>, InneractiveFullscreenAdEventsListener {
    public final InneractiveFullscreenUnitController mController;
    public T mEventsListener;
    private final MarketplaceAdLoadListener<MarketplaceFullscreenAd<T>> mLoadListener;

    public g(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAdLoadListener<MarketplaceFullscreenAd<T>> marketplaceAdLoadListener, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        super(str, jSONObject, map, z, marketplaceAuctionParameters);
        this.mLoadListener = marketplaceAdLoadListener;
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = new InneractiveFullscreenUnitController();
        this.mController = inneractiveFullscreenUnitController;
        inneractiveFullscreenUnitController.setEventsListener(this);
    }

    public boolean isAvailable() {
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = this.mController;
        return inneractiveFullscreenUnitController != null && inneractiveFullscreenUnitController.isAvailable();
    }

    public boolean isFullscreen() {
        return true;
    }

    public void load() {
        loadAd(this.mController, this.mLoadListener);
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
    }

    public void destroy() {
        InneractiveAdSpot adSpot;
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = this.mController;
        if (inneractiveFullscreenUnitController != null && (adSpot = inneractiveFullscreenUnitController.getAdSpot()) != null) {
            adSpot.destroy();
        }
    }

    public void internalOnAdLoaded(a aVar, e eVar) {
        if (!(this.mController == null || eVar == null)) {
            InneractiveAdSpotManager.get().bindSpot(eVar);
            this.mController.setAdSpot(eVar);
        }
        MarketplaceAdLoadListener<MarketplaceFullscreenAd<T>> marketplaceAdLoadListener = this.mLoadListener;
        if (marketplaceAdLoadListener != null) {
            marketplaceAdLoadListener.onAdLoaded(this);
        }
    }

    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        T t = this.mEventsListener;
        if (t != null) {
            t.onClick();
        }
    }

    public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
        T t = this.mEventsListener;
        if (t != null) {
            t.onClose();
        }
    }

    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        T t = this.mEventsListener;
        if (t != null) {
            t.onShow();
        }
    }

    public void show(Activity activity, T t) {
        if (this.mController != null) {
            this.mEventsListener = t;
            if (this.adSpot.isReady()) {
                this.mController.show(activity);
            } else {
                t.onShowError(MarketplaceAdShowError.EXPIRED_AD_ERROR);
            }
        } else if (t != null) {
            t.onShowError(MarketplaceAdShowError.GENERIC_SHOW_ERROR);
        }
    }
}
