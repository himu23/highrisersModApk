package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.b.a.e;
import com.applovin.impl.mediation.debugger.ui.a.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
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
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0072a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private ListView akx;
    private com.applovin.impl.mediation.debugger.b.a.a apU;
    private e apV;
    private b apW;
    private MaxAdView apX;
    private MaxInterstitialAd apY;
    private MaxAppOpenAd apZ;
    private MaxRewardedInterstitialAd aqa;
    private MaxRewardedAd aqb;
    /* access modifiers changed from: private */
    public MaxNativeAdLoader aqc;
    /* access modifiers changed from: private */
    public MaxAd aqd;
    private e aqe;
    private List<String> aqf;
    private View aqg;
    private AdControlButton aqh;
    private TextView aqi;
    private com.applovin.impl.mediation.debugger.a.a aqj;
    /* access modifiers changed from: private */
    public MaxNativeAdView nativeAdView;
    /* access modifiers changed from: private */
    public n sdk;

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.aqe = null;
    }

    /* access modifiers changed from: protected */
    public n getSdk() {
        return this.sdk;
    }

    public void initialize(com.applovin.impl.mediation.debugger.b.a.a aVar, b bVar, e eVar, n nVar) {
        List<?> bH;
        this.sdk = nVar;
        this.apU = aVar;
        this.apV = eVar;
        this.aqf = nVar.CE().xk();
        b bVar2 = new b(aVar, bVar, eVar, this);
        this.apW = bVar2;
        bVar2.a(new a$$ExternalSyntheticLambda2(this, nVar, aVar, bVar));
        vT();
        if (!aVar.uG().uN()) {
            return;
        }
        if ((eVar == null || eVar.uR().uP().uN()) && (bH = nVar.CB().bH(aVar.mQ())) != null && !bH.isEmpty()) {
            this.aqj = new com.applovin.impl.mediation.debugger.a.a(bH, aVar.getFormat(), (a.C0072a) this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, com.applovin.impl.mediation.debugger.b.a.a aVar, b bVar, com.applovin.impl.mediation.debugger.ui.d.a aVar2, c cVar) {
        if (cVar instanceof b.C0075b) {
            com.applovin.impl.sdk.utils.b.a(this, MaxDebuggerAdUnitDetailActivity.class, nVar.BM(), new a$$ExternalSyntheticLambda1(cVar, aVar, bVar, nVar));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.apW.getTitle());
        this.akx = (ListView) findViewById(R.id.listView);
        this.aqg = findViewById(R.id.ad_presenter_view);
        this.aqh = (AdControlButton) findViewById(R.id.ad_control_button);
        this.aqi = (TextView) findViewById(R.id.status_textview);
        this.akx.setAdapter(this.apW);
        this.aqi.setText(vU());
        this.aqi.setTypeface(Typeface.DEFAULT_BOLD);
        this.aqh.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer((float) 10, 0.0f, (float) -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.aqg.setBackground(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        if (this.apV != null) {
            this.sdk.CE().C(this.aqf);
        }
        MaxAdView maxAdView = this.apX;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.apY;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxAppOpenAd maxAppOpenAd = this.apZ;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.destroy();
        }
        MaxRewardedInterstitialAd maxRewardedInterstitialAd = this.aqa;
        if (maxRewardedInterstitialAd != null) {
            maxRewardedInterstitialAd.destroy();
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

    private void vT() {
        String mQ = this.apU.mQ();
        if (this.apU.getFormat().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(mQ, this.apU.getFormat(), this.sdk.getWrappingSdk(), this);
            this.apX = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, "false");
            this.apX.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apX.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_PRECACHE, "true");
            this.apX.setExtraParameter(AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE, "true");
            this.apX.stopAutoRefresh();
            this.apX.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.apU.getFormat()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(mQ, this.sdk.getWrappingSdk(), this);
            this.apY = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apY.setListener(this);
        } else if (MaxAdFormat.APP_OPEN == this.apU.getFormat()) {
            MaxAppOpenAd maxAppOpenAd = new MaxAppOpenAd(mQ, this.sdk.getWrappingSdk());
            this.apZ = maxAppOpenAd;
            maxAppOpenAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apZ.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.apU.getFormat()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(mQ, this.sdk.getWrappingSdk(), this);
            this.aqa = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.aqa.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.apU.getFormat()) {
            MaxRewardedAd instance = MaxRewardedAd.getInstance(mQ, this.sdk.getWrappingSdk(), this);
            this.aqb = instance;
            instance.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.aqb.setListener(this);
        } else if (MaxAdFormat.NATIVE == this.apU.getFormat()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(mQ, this.sdk.getWrappingSdk(), this);
            this.aqc = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.aqc.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (a.this.aqd != null) {
                        a.this.aqc.destroy(a.this.aqd);
                    }
                    MaxAd unused = a.this.aqd = maxAd;
                    if (maxNativeAdView != null) {
                        MaxNativeAdView unused2 = a.this.nativeAdView = maxNativeAdView;
                    } else {
                        a aVar = a.this;
                        n unused3 = a.this.sdk;
                        MaxNativeAdView unused4 = aVar.nativeAdView = new MaxNativeAdView(MaxNativeAdView.MEDIUM_TEMPLATE_1, n.getApplicationContext());
                        a.this.aqc.render(a.this.nativeAdView, maxAd);
                    }
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
        }
    }

    public void onClick(AdControlButton adControlButton) {
        if (this.sdk.CE().isEnabled()) {
            u.a("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", (Context) this);
        } else if (this.apW.vV() != this.apU.uG()) {
            u.a("Not Supported", "You cannot load an ad from this waterfall because it does not target the current device. To load an ad, please select the targeted waterfall.", (Context) this);
        } else {
            MaxAdFormat format = this.apU.getFormat();
            if (AdControlButton.b.LOAD == adControlButton.getControlState()) {
                adControlButton.setControlState(AdControlButton.b.LOADING);
                com.applovin.impl.mediation.debugger.a.a aVar = this.aqj;
                if (aVar != null) {
                    aVar.loadAd();
                } else {
                    b(format);
                }
            } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
                if (!format.isAdViewAd() && format != MaxAdFormat.NATIVE) {
                    adControlButton.setControlState(AdControlButton.b.LOAD);
                }
                c(format);
            }
        }
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (this.apV != null) {
            this.sdk.CE().C(this.apV.uR().uO());
        }
        if (maxAdFormat.isAdViewAd()) {
            this.apX.setPlacement("[Mediation Debugger Live Ad]");
            this.apX.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.apU.getFormat()) {
            this.apY.loadAd();
        } else if (MaxAdFormat.APP_OPEN == this.apU.getFormat()) {
            this.apZ.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.apU.getFormat()) {
            this.aqa.loadAd();
        } else if (MaxAdFormat.REWARDED == this.apU.getFormat()) {
            this.aqb.loadAd();
        } else if (MaxAdFormat.NATIVE == this.apU.getFormat()) {
            this.aqc.setPlacement("[Mediation Debugger Live Ad]");
            this.aqc.loadAd();
        } else {
            u.e("Live ads currently unavailable for ad format", this);
        }
    }

    private void c(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            a((ViewGroup) this.apX, maxAdFormat.getSize());
        } else if (MaxAdFormat.INTERSTITIAL == this.apU.getFormat()) {
            this.apY.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.APP_OPEN == this.apU.getFormat()) {
            this.apZ.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.apU.getFormat()) {
            this.aqa.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.apU.getFormat()) {
            this.aqb.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.apU.getFormat()) {
            a((ViewGroup) this.nativeAdView, MaxAdFormat.MREC.getSize());
        }
    }

    private void a(ViewGroup viewGroup, AppLovinSdkUtils.Size size) {
        if (this.aqe == null) {
            e eVar = new e(viewGroup, size, this);
            this.aqe = eVar;
            eVar.setOnDismissListener(new a$$ExternalSyntheticLambda0(this));
            this.aqe.show();
        }
    }

    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.aqi;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.aqh.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a((ViewGroup) this.apX, maxAd.getFormat().getSize());
        } else if (MaxAdFormat.NATIVE == this.apU.getFormat()) {
            a((ViewGroup) this.nativeAdView, MaxAdFormat.MREC.getSize());
        }
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        this.aqh.setControlState(AdControlButton.b.LOAD);
        this.aqi.setText("");
        if (204 == maxError.getCode()) {
            u.a("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", (Context) this);
            return;
        }
        u.a("", "Failed to load with error code: " + maxError.getCode(), (Context) this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.aqh.setControlState(AdControlButton.b.LOAD);
        this.aqi.setText("");
        u.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), (Context) this);
    }

    public void onAdClicked(MaxAd maxAd) {
        u.a(ac.f, maxAd, (Context) this);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        u.a("onAdRevenuePaid", maxAd, (Context) this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        u.a("onAdDisplayed", maxAd, (Context) this);
    }

    public void onAdHidden(MaxAd maxAd) {
        u.a("onAdHidden", maxAd, (Context) this);
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
        if (maxAdFormat.isAdViewAd()) {
            this.apX.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
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
        if (maxAdFormat.isAdViewAd()) {
            this.apX.setLocalExtraParameter("amazon_ad_error", adError);
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

    private String vU() {
        if (this.sdk.CE().isEnabled()) {
            return "Not supported while Test Mode is enabled";
        }
        return this.apW.vV() != this.apU.uG() ? "This waterfall is not targeted for the current device" : "Tap to load an ad";
    }
}
