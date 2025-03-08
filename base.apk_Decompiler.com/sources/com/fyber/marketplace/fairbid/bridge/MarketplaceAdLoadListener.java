package com.fyber.marketplace.fairbid.bridge;

import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;

public interface MarketplaceAdLoadListener<T extends MarketplaceBridgeAd> {
    void onAdLoadFailed(MarketplaceAdLoadError marketplaceAdLoadError);

    void onAdLoaded(T t);
}
