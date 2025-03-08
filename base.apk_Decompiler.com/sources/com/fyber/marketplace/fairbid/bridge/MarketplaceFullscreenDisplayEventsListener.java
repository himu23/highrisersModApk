package com.fyber.marketplace.fairbid.bridge;

public interface MarketplaceFullscreenDisplayEventsListener {
    void onClick();

    void onClose();

    void onShow();

    void onShowError(MarketplaceAdShowError marketplaceAdShowError);
}
