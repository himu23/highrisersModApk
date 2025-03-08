package com.ironsource.adapters.applovin;

import android.widget.FrameLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;

public class AppLovinBannerListener implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private final WeakReference<AppLovinAdapter> mAdapter;
    /* access modifiers changed from: private */
    public final FrameLayout.LayoutParams mBannerLayout;
    /* access modifiers changed from: private */
    public final BannerSmashListener mListener;
    private final String mZoneId;

    public AppLovinBannerListener(AppLovinAdapter appLovinAdapter, BannerSmashListener bannerSmashListener, String str, FrameLayout.LayoutParams layoutParams) {
        this.mAdapter = new WeakReference<>(appLovinAdapter);
        this.mZoneId = str;
        this.mListener = bannerSmashListener;
        this.mBannerLayout = layoutParams;
    }

    public void adReceived(final AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else if (this.mAdapter.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else if (this.mBannerLayout == null) {
            IronLog.INTERNAL.verbose("banner layout is null");
        } else {
            final AppLovinAdView appLovinAdView = ((AppLovinAdapter) this.mAdapter.get()).mZoneIdToBannerAd.get(this.mZoneId);
            if (appLovinAdView == null) {
                IronLog.INTERNAL.verbose("adView is null");
            } else {
                AppLovinAdapter.postOnUIThread(new Runnable() {
                    public void run() {
                        appLovinAdView.renderAd(appLovinAd);
                        AppLovinBannerListener.this.mListener.onBannerAdLoaded(appLovinAdView, AppLovinBannerListener.this.mBannerLayout);
                    }
                });
            }
        }
    }

    public void failedToReceiveAd(int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId + ", errorCode = " + i);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else if (this.mAdapter.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(i == 204 ? 606 : i, ((AppLovinAdapter) this.mAdapter.get()).getErrorString(i)));
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void adClicked(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenPresented();
        }
    }

    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }
}
