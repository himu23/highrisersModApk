package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.mediation.c.a.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class NimbusMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter {
    private static final String ADAPTER_VERSION = "1.0.0.0";
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static a nimbusApiService;
    private static MaxAdapter.InitializationStatus status;
    /* access modifiers changed from: private */
    public AppLovinAdView loadedAdView;

    public String getAdapterVersion() {
        return ADAPTER_VERSION;
    }

    public String getSdkVersion() {
        return "2.0.0";
    }

    public NimbusMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    public void onDestroy() {
        AppLovinAdView appLovinAdView = this.loadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.loadedAdView = null;
        }
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject(maxAdapterInitializationParameters.getServerParameters().getString("app_id", ""));
                String string = JsonUtils.getString(jSONObject, "api_key", (String) null);
                String string2 = JsonUtils.getString(jSONObject, "pub_id", (String) null);
                String string3 = JsonUtils.getString(jSONObject, "base_url", (String) null);
                if (TextUtils.isEmpty(string)) {
                    MaxAdapter.InitializationStatus initializationStatus = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    status = initializationStatus;
                    onCompletionListener.onCompletion(initializationStatus, "API Key cannot be null.");
                    return;
                }
                status = MaxAdapter.InitializationStatus.INITIALIZING;
                a aVar = new a(string, string2, string3, getWrappingSdk().a());
                nimbusApiService = aVar;
                aVar.a(maxAdapterInitializationParameters);
                log("Nimbus API successfully initialized");
                status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
            } catch (JSONException unused) {
                MaxAdapter.InitializationStatus initializationStatus2 = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                status = initializationStatus2;
                onCompletionListener.onCompletion(initializationStatus2, "Failed to serialize app id json string.");
            }
        } else {
            onCompletionListener.onCompletion(status, (String) null);
        }
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        if (nimbusApiService == null) {
            log("Nimbus Service is not initialized");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        nimbusApiService.a(maxAdapterResponseParameters, maxAdFormat, new NimbusAdapterAdViewListener(this, maxAdFormat, maxAdViewAdapterListener));
    }

    protected static MaxAdapterError toMaxError(int i) {
        MaxAdapterError maxAdapterError;
        if (i == -1009) {
            maxAdapterError = MaxAdapterError.NO_CONNECTION;
        } else if (i == 204) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else if (i >= 500) {
            maxAdapterError = MaxAdapterError.SERVER_ERROR;
        } else {
            maxAdapterError = MaxAdapterError.UNSPECIFIED;
        }
        return new MaxAdapterError(maxAdapterError.getCode(), maxAdapterError.getErrorMessage(), i, "");
    }

    protected static Bundle getExtraInfo(AppLovinAd appLovinAd) {
        Bundle bundle = new Bundle(1);
        bundle.putBundle("ad_values", ((AppLovinAdImpl) appLovinAd).getMAXAdValues());
        return bundle;
    }

    public class NimbusAdapterAdViewListener implements AppLovinAdViewEventListener, AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdLoadListener {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;
        private final NimbusMediationAdapter parentAdapter;

        public NimbusAdapterAdViewListener(NimbusMediationAdapter nimbusMediationAdapter, MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.parentAdapter = nimbusMediationAdapter;
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad loaded");
            AppLovinSdkUtils.runOnUiThread(new NimbusMediationAdapter$NimbusAdapterAdViewListener$$ExternalSyntheticLambda0(this, appLovinAd));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$adReceived$0$com-applovin-mediation-adapters-NimbusMediationAdapter$NimbusAdapterAdViewListener  reason: not valid java name */
        public /* synthetic */ void m1913lambda$adReceived$0$comapplovinmediationadaptersNimbusMediationAdapter$NimbusAdapterAdViewListener(AppLovinAd appLovinAd) {
            AppLovinAdView unused = this.parentAdapter.loadedAdView = new AppLovinAdView(this.parentAdapter.getWrappingSdk(), appLovinAd.getSize(), this.parentAdapter.getApplicationContext());
            this.parentAdapter.loadedAdView.setAdDisplayListener(this);
            this.parentAdapter.loadedAdView.setAdClickListener(this);
            this.parentAdapter.loadedAdView.setAdViewEventListener(this);
            this.listener.onAdViewAdLoaded(this.parentAdapter.loadedAdView);
            this.parentAdapter.loadedAdView.renderAd(appLovinAd);
        }

        public void failedToReceiveAd(int i) {
            MaxAdapterError maxError = NimbusMediationAdapter.toMaxError(i);
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad failed to load with error code: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad shown");
            this.listener.onAdViewAdDisplayed();
        }

        public void adClicked(AppLovinAd appLovinAd) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad clicked");
            this.listener.onAdViewAdClicked(NimbusMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void adHidden(AppLovinAd appLovinAd) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad hidden");
            this.listener.onAdViewAdHidden(NimbusMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad expanded");
            this.listener.onAdViewAdExpanded();
        }

        public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad collapsed");
            this.listener.onAdViewAdCollapsed();
        }

        public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " ad left application");
        }

        public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
            NimbusMediationAdapter nimbusMediationAdapter = this.parentAdapter;
            nimbusMediationAdapter.log(this.adFormat.getLabel() + " failed to display with error code: " + appLovinAdViewDisplayErrorCode);
            this.listener.onAdViewAdDisplayFailed(MaxAdapterError.UNSPECIFIED);
        }
    }
}
