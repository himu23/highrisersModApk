package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.ironsource.ac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0072a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private MaxInterstitialAd apY;
    private MaxAppOpenAd apZ;
    private MaxRewardedInterstitialAd aqa;
    private MaxRewardedAd aqb;
    /* access modifiers changed from: private */
    public MaxNativeAdLoader aqc;
    /* access modifiers changed from: private */
    public MaxAd aqd;
    private List<String> aqf;
    private b arV;
    private MaxAdView atS;
    private MaxAdView atT;
    private String atU;
    private AdControlButton atV;
    private AdControlButton atW;
    private AdControlButton atX;
    private AdControlButton atY;
    private AdControlButton atZ;
    private AdControlButton aua;
    private AdControlButton aub;
    private Button auc;
    private Button aud;
    private FrameLayout aue;
    /* access modifiers changed from: private */
    public FrameLayout auf;
    private Switch aug;
    private Switch auh;
    private Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> aui;
    private n sdk;

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(b bVar) {
        this.arV = bVar;
        this.sdk = bVar.getSdk();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.arV == null) {
            x.H("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.arV.getDisplayName() + " Test Ads");
        this.aqf = this.sdk.CE().xk();
        xe();
        xf();
        xg();
        xh();
        xi();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        findViewById(R.id.app_open_ad_control_view).setVisibility(8);
        this.auc = (Button) findViewById(R.id.show_mrec_button);
        this.aud = (Button) findViewById(R.id.show_native_button);
        if (!this.arV.vz() || !this.arV.vy().contains(MaxAdFormat.MREC)) {
            this.auc.setVisibility(8);
            this.aud.setVisibility(8);
        } else {
            this.auf.setVisibility(8);
            this.auc.setBackgroundColor(-1);
            this.aud.setBackgroundColor(-3355444);
            this.auc.setOnClickListener(new a$$ExternalSyntheticLambda0(this));
            this.aud.setOnClickListener(new a$$ExternalSyntheticLambda1(this));
        }
        this.aug = (Switch) findViewById(R.id.native_banner_switch);
        this.auh = (Switch) findViewById(R.id.native_mrec_switch);
        if (this.arV.vA()) {
            this.aug.setOnClickListener(new a$$ExternalSyntheticLambda2(this));
            this.auh.setOnClickListener(new a$$ExternalSyntheticLambda3(this));
        } else {
            this.aug.setVisibility(8);
            this.auh.setVisibility(8);
        }
        if (StringUtils.isValidString(this.arV.vK()) && this.arV.vL() != null && this.arV.vL().size() > 0) {
            AdRegistration.getInstance(this.arV.vK(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap hashMap = new HashMap(this.arV.vL().size());
            for (MaxAdFormat next : this.arV.vL().keySet()) {
                hashMap.put(next, new com.applovin.impl.mediation.debugger.a.a(this.arV.vL().get(next), next, (a.C0072a) this));
            }
            this.aui = hashMap;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            x.e("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.aue.setVisibility(0);
        this.auf.setVisibility(8);
        this.auc.setBackgroundColor(-1);
        this.aud.setBackgroundColor(-3355444);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        this.auf.setVisibility(0);
        this.aue.setVisibility(8);
        this.aud.setBackgroundColor(-1);
        this.auc.setBackgroundColor(-3355444);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.atS.removeAllViews();
        this.atV.setControlState(AdControlButton.b.LOAD);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        this.atT.removeAllViews();
        this.atW.setControlState(AdControlButton.b.LOAD);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.sdk.CE().C(this.aqf);
        MaxAdView maxAdView = this.atS;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.atT;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.apY;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.aqb;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.aqc;
        if (maxNativeAdLoader != null && (maxAd = this.aqd) != null) {
            maxNativeAdLoader.destroy(maxAd);
        }
    }

    private void xe() {
        String str;
        MaxAdFormat maxAdFormat;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.arV.vy().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.sdk.getWrappingSdk(), this);
            this.atS = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, "false");
            this.atS.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.atS.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_PRECACHE, "true");
            this.atS.setExtraParameter(AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE, "true");
            this.atS.stopAutoRefresh();
            this.atS.setListener(this);
            frameLayout.addView(this.atS, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.atV = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atV.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void xf() {
        this.aue = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        if (this.arV.vy().contains(MaxAdFormat.MREC)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", MaxAdFormat.MREC, this.sdk.getWrappingSdk(), this);
            this.atT = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.atT.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_PRECACHE, "true");
            this.atT.setExtraParameter(AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE, "true");
            this.atT.stopAutoRefresh();
            this.atT.setListener(this);
            this.aue.addView(this.atT, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.atW = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atW.setFormat(MaxAdFormat.MREC);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.aue.setVisibility(8);
    }

    private void xg() {
        if (this.arV.vy().contains(MaxAdFormat.INTERSTITIAL)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.sdk.getWrappingSdk(), this);
            this.apY = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apY.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.atX = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atX.setFormat(MaxAdFormat.INTERSTITIAL);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void xh() {
        if (this.arV.vy().contains(MaxAdFormat.REWARDED)) {
            String str = "test_mode_rewarded_" + this.arV.getName();
            this.atU = str;
            MaxRewardedAd instance = MaxRewardedAd.getInstance(str, this.sdk.getWrappingSdk(), this);
            this.aqb = instance;
            instance.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.aqb.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
            this.aua = adControlButton;
            adControlButton.setOnClickListener(this);
            this.aua.setFormat(MaxAdFormat.REWARDED);
            return;
        }
        findViewById(R.id.rewarded_control_view).setVisibility(8);
    }

    private void xi() {
        this.auf = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.arV.vz()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.sdk.getWrappingSdk(), this);
            this.aqc = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.aqc.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (a.this.aqd != null) {
                        a.this.aqc.destroy(a.this.aqd);
                    }
                    MaxAd unused = a.this.aqd = maxAd;
                    a.this.auf.removeAllViews();
                    a.this.auf.addView(maxNativeAdView);
                    a.this.onAdLoaded(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }
            });
            this.aqc.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.aub = adControlButton;
            adControlButton.setOnClickListener(this);
            this.aub.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.auf.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        boolean z = true;
        boolean z2 = (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) && this.aug.isChecked();
        if (MaxAdFormat.MREC != maxAdFormat || !this.auh.isChecked()) {
            z = false;
        }
        if (z2 || z) {
            this.sdk.CE().bT(this.arV.vu());
        } else {
            this.sdk.CE().bT(getTestModeNetwork(maxAdFormat));
        }
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atS.loadAd();
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.atT.loadAd();
            this.auc.callOnClick();
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apY.loadAd();
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apZ.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.aqa.loadAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.aqb.loadAd();
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.aqc.loadAd();
            this.aud.callOnClick();
        }
    }

    private void c(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apY.showAd();
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apZ.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.aqa.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.aqb.showAd();
        }
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        if (this.arV.vF() == null || !this.arV.vF().containsKey(maxAdFormat)) {
            return this.arV.getName();
        }
        return this.arV.vF().get(maxAdFormat);
    }

    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        if (AdControlButton.b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> map = this.aui;
            if (map == null || map.get(format) == null) {
                b(format);
            } else {
                this.aui.get(format).loadAd();
            }
        } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOAD);
            c(format);
        }
    }

    private AdControlButton bS(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.atV;
        }
        if (str.equals("test_mode_mrec")) {
            return this.atW;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.atX;
        }
        if (str.equals("test_mode_app_open")) {
            return this.atY;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.atZ;
        }
        if (str.equals(this.atU)) {
            return this.aua;
        }
        if (str.equals("test_mode_native")) {
            return this.aub;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    public void onAdLoaded(MaxAd maxAd) {
        AdControlButton bS = bS(maxAd.getAdUnitId());
        if (maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) {
            bS.setControlState(AdControlButton.b.LOAD);
        } else {
            bS.setControlState(AdControlButton.b.SHOW);
        }
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton bS = bS(str);
        bS.setControlState(AdControlButton.b.LOAD);
        u.a(maxError, bS.getFormat().getLabel(), (Context) this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        u.a("onAdDisplayed", maxAd, (Context) this);
    }

    public void onAdHidden(MaxAd maxAd) {
        u.a("onAdHidden", maxAd, (Context) this);
    }

    public void onAdClicked(MaxAd maxAd) {
        u.a(ac.f, maxAd, (Context) this);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        u.a("onAdRevenuePaid", maxAd, (Context) this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        bS(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
        u.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), (Context) this);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        u.a("onRewardedVideoStarted", maxAd, (Context) this);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        u.a("onRewardedVideoCompleted", maxAd, (Context) this);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        u.a("onUserRewarded", maxAd, (Context) this);
    }

    public void onAdExpanded(MaxAd maxAd) {
        u.a("onAdExpanded", maxAd, (Context) this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        u.a("onAdCollapsed", maxAd, (Context) this);
    }

    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atS.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.atT.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apY.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apZ.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.aqa.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.aqb.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.aqc.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        b(maxAdFormat);
    }

    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atS.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.atT.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apY.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apZ.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.aqa.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.aqb.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.aqc.setLocalExtraParameter("amazon_ad_error", adError);
        }
        b(maxAdFormat);
    }
}
