package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.d;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.a.e;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinNativeAdImpl extends AppLovinAdBase implements View.OnClickListener, AppLovinTouchToClickListener.OnClickListener, AppLovinNativeAd {
    private static final String AD_RESPONSE_TYPE_APPLOVIN = "applovin";
    private static final String AD_RESPONSE_TYPE_ORTB = "ortb";
    private static final String AD_RESPONSE_TYPE_UNDEFINED = "undefined";
    private static final String DEFAULT_APPLOVIN_PRIVACY_URL = "https://www.applovin.com/privacy/";
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private static final String TAG = "AppLovinNativeAd";
    private static final int VIEWABLE_MRC100_PERCENTAGE = 100;
    private static final int VIEWABLE_MRC50_PERCENTAGE = 50;
    private static final int VIEWABLE_MRC_REQUIRED_SECONDS = 1;
    private static final int VIEWABLE_VIDEO_MRC_REQUIRED_SECONDS = 2;
    private final e adEventTracker;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final Uri clickDestinationBackupUri;
    private final Uri clickDestinationUri;
    private final List<String> clickTrackingUrls;
    private AppLovinNativeAdEventListener eventListener;
    private Uri iconUri;
    private final List<i> impressionRequests;
    private final AtomicBoolean impressionTracked;
    private final List<String> jsTrackers;
    private Uri mainImageUri;
    private AppLovinMediaView mediaView;
    private ViewGroup nativeAdView;
    private final a onAttachStateChangeHandler;
    private AppLovinOptionsView optionsView;
    private Uri privacyDestinationUri;
    private Uri privacyIconUri;
    private final List<View> registeredViews;
    private final Double starRating;
    private final String tag;
    private final String title;
    private final com.applovin.impl.b.a vastAd;
    private View videoView;
    private final b viewableMRC100Callback;
    private ad viewableMRC100Tracker;
    private final b viewableMRC50Callback;
    private ad viewableMRC50Tracker;
    private b viewableVideoMRC50Callback;
    private ad viewableVideoMRC50Tracker;

    public e getAdEventTracker() {
        return this.adEventTracker;
    }

    public String getAdvertiser() {
        return this.advertiser;
    }

    public String getBody() {
        return this.body;
    }

    public String getCallToAction() {
        return this.callToAction;
    }

    public Uri getIconUri() {
        return this.iconUri;
    }

    public Uri getMainImageUri() {
        return this.mainImageUri;
    }

    public AppLovinMediaView getMediaView() {
        return this.mediaView;
    }

    public AppLovinOptionsView getOptionsView() {
        return this.optionsView;
    }

    public Uri getPrivacyDestinationUri() {
        return this.privacyDestinationUri;
    }

    public Uri getPrivacyIconUri() {
        return this.privacyIconUri;
    }

    public Double getStarRating() {
        return this.starRating;
    }

    public String getTitle() {
        return this.title;
    }

    public com.applovin.impl.b.a getVastAd() {
        return this.vastAd;
    }

    public void setEventListener(AppLovinNativeAdEventListener appLovinNativeAdEventListener) {
        this.eventListener = appLovinNativeAdEventListener;
    }

    public void setIconUri(Uri uri) {
        this.iconUri = uri;
    }

    public void setMainImageUri(Uri uri) {
        this.mainImageUri = uri;
    }

    public void setPrivacyIconUri(Uri uri) {
        this.privacyIconUri = uri;
    }

    public void setVideoView(View view) {
        this.videoView = view;
    }

    public boolean shouldInjectOpenMeasurementScriptDuringCaching() {
        return false;
    }

    private AppLovinNativeAdImpl(Builder builder) {
        super(builder.adObject, builder.fullResponse, builder.sdk);
        this.impressionTracked = new AtomicBoolean();
        this.registeredViews = new ArrayList();
        this.onAttachStateChangeHandler = new a(this);
        this.adEventTracker = new e(this);
        this.title = builder.title;
        this.advertiser = builder.advertiser;
        this.body = builder.body;
        this.callToAction = builder.callToAction;
        this.iconUri = builder.iconUri;
        this.mainImageUri = builder.mainImageUri;
        this.privacyIconUri = builder.privacyIconUri;
        com.applovin.impl.b.a access$1000 = builder.vastAd;
        this.vastAd = access$1000;
        this.clickDestinationUri = builder.clickDestinationUri;
        this.clickDestinationBackupUri = builder.clickDestinationBackupUri;
        this.clickTrackingUrls = builder.clickTrackingUrls;
        this.jsTrackers = builder.jsTrackers;
        this.impressionRequests = builder.impressionRequests;
        Double access$1600 = builder.starRating;
        this.starRating = (access$1600 == null || access$1600.doubleValue() < 3.0d) ? null : access$1600;
        if (builder.privacyDestinationUri != null) {
            this.privacyDestinationUri = builder.privacyDestinationUri;
        } else if (!isDspAd() || getSdk().CE().isEnabled()) {
            this.privacyDestinationUri = Uri.parse(DEFAULT_APPLOVIN_PRIVACY_URL);
        }
        this.viewableMRC50Callback = new b(builder.viewableMRC50Requests);
        this.viewableMRC100Callback = new b(builder.viewableMRC100Requests);
        if (access$1000 != null && access$1000.hasVideoUrl()) {
            this.viewableVideoMRC50Callback = new b(builder.viewableVideo50Requests);
        }
        this.tag = "AppLovinNativeAd:" + getAdIdNumber();
    }

    public void registerViewsForInteraction(List<View> list, ViewGroup viewGroup) {
        this.nativeAdView = viewGroup;
        if (h.KW() && this.nativeAdView.isAttachedToWindow()) {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        } else if (h.KW() || this.nativeAdView.getParent() == null) {
            this.nativeAdView.addOnAttachStateChangeListener(this.onAttachStateChangeHandler);
        } else {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        }
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            String str = this.tag;
            BN.f(str, "Registered ad view for impressions: " + this.nativeAdView);
        }
        if (this.clickDestinationUri == null && this.clickDestinationBackupUri == null) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f(this.tag, "Skipping click registration - no click URLs provided");
                return;
            }
            return;
        }
        for (View next : list) {
            if (next.hasOnClickListeners()) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN2 = this.sdk.BN();
                    String str2 = this.tag;
                    BN2.h(str2, "View has an onClickListener already - " + next);
                }
            }
            if (!next.isClickable()) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN3 = this.sdk.BN();
                    String str3 = this.tag;
                    BN3.h(str3, "View is not clickable - " + next);
                }
            }
            if (!next.isEnabled()) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN4 = this.sdk.BN();
                    String str4 = this.tag;
                    BN4.i(str4, "View is not enabled - " + next);
                }
            }
            if (next instanceof Button) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN5 = this.sdk.BN();
                    String str5 = this.tag;
                    BN5.f(str5, "Registering click for button: " + next);
                }
            } else {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN6 = this.sdk.BN();
                    String str6 = this.tag;
                    BN6.f(str6, "Registering click for view: " + next);
                }
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNB)).booleanValue()) {
                next.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, com.applovin.impl.sdk.c.b.aLp, viewGroup.getContext(), this));
            } else {
                next.setOnClickListener(this);
            }
            this.registeredViews.add(next);
        }
        this.sdk.BN();
        if (x.Fn()) {
            x BN7 = this.sdk.BN();
            String str7 = this.tag;
            BN7.f(str7, "Registered views: " + this.registeredViews);
        }
    }

    public void unregisterViewsForInteraction() {
        for (View next : this.registeredViews) {
            next.setOnTouchListener((View.OnTouchListener) null);
            next.setOnClickListener((View.OnClickListener) null);
        }
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            String str = this.tag;
            BN.f(str, "Unregistered views: " + this.registeredViews);
        }
        this.registeredViews.clear();
        ad adVar = this.viewableMRC50Tracker;
        if (adVar != null) {
            adVar.Fw();
        }
        ad adVar2 = this.viewableMRC100Tracker;
        if (adVar2 != null) {
            adVar2.Fw();
        }
        ad adVar3 = this.viewableVideoMRC50Tracker;
        if (adVar3 != null) {
            adVar3.Fw();
        }
        ViewGroup viewGroup = this.nativeAdView;
        if (viewGroup != null) {
            viewGroup.removeOnAttachStateChangeListener(this.onAttachStateChangeHandler);
            this.nativeAdView = null;
        }
        AppLovinMediaView appLovinMediaView = this.mediaView;
        if (appLovinMediaView != null) {
            appLovinMediaView.destroy();
        }
        AppLovinOptionsView appLovinOptionsView = this.optionsView;
        if (appLovinOptionsView != null) {
            appLovinOptionsView.destroy();
        }
    }

    public void destroy() {
        unregisterViewsForInteraction();
        this.eventListener = null;
        this.adEventTracker.IM();
    }

    public void setUpNativeAdViewComponents() {
        com.applovin.impl.b.a aVar = this.vastAd;
        if (aVar == null || !aVar.hasVideoUrl()) {
            n nVar = this.sdk;
            n nVar2 = this.sdk;
            this.mediaView = new AppLovinMediaView(this, nVar, n.getApplicationContext());
        } else {
            try {
                n nVar3 = this.sdk;
                n nVar4 = this.sdk;
                this.mediaView = new AppLovinVastMediaView(this, nVar3, n.getApplicationContext());
            } catch (Throwable th) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().b(this.tag, "Failed to create ExoPlayer VAST media view. Falling back to static image for media view.", th);
                }
                this.sdk.Cs().d(TAG, "createExoPlayerVASTMediaView", th);
                n nVar5 = this.sdk;
                n nVar6 = this.sdk;
                this.mediaView = new AppLovinMediaView(this, nVar5, n.getApplicationContext());
            }
        }
        if (this.privacyDestinationUri != null) {
            n nVar7 = this.sdk;
            n nVar8 = this.sdk;
            this.optionsView = new AppLovinOptionsView(this, nVar7, n.getApplicationContext());
            return;
        }
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f(this.tag, "Privacy icon will not render because no native ad privacy URL is provided.");
        }
    }

    /* access modifiers changed from: private */
    public void maybeHandleOnAttachedToWindow(View view) {
        if (this.impressionTracked.compareAndSet(false, true)) {
            ad adVar = new ad(this.nativeAdView, this.sdk, this.viewableMRC50Callback);
            this.viewableMRC50Tracker = adVar;
            adVar.a(0, 50.0f, 50.0f, TimeUnit.SECONDS.toMillis(1), this.nativeAdView);
            ad adVar2 = new ad(this.nativeAdView, this.sdk, this.viewableMRC100Callback);
            this.viewableMRC100Tracker = adVar2;
            adVar2.a(0, 100.0f, 100.0f, TimeUnit.SECONDS.toMillis(1), this.nativeAdView);
            com.applovin.impl.b.a aVar = this.vastAd;
            if (aVar != null && aVar.hasVideoUrl()) {
                ad adVar3 = new ad(this.nativeAdView, this.sdk, this.viewableVideoMRC50Callback);
                this.viewableVideoMRC50Tracker = adVar3;
                adVar3.a(0, 50.0f, 50.0f, TimeUnit.SECONDS.toMillis(2), this.videoView);
            }
            List<String> list = this.jsTrackers;
            if (list != null && list.size() > 0) {
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQL)).booleanValue()) {
                    for (String cM : this.jsTrackers) {
                        this.sdk.Cg().cM(cM);
                    }
                } else {
                    String str = this.jsTrackers.get(0);
                    if (StringUtils.isValidString(str)) {
                        d dVar = new d((com.applovin.impl.adview.e) null, this.sdk, view.getContext());
                        dVar.loadData(str, "text/html", "UTF-8");
                        AppLovinSdkUtils.runOnUiThreadDelayed(new AppLovinNativeAdImpl$$ExternalSyntheticLambda0(dVar), TimeUnit.SECONDS.toMillis(5));
                    }
                }
            }
            for (i dispatchPostbackRequest : this.impressionRequests) {
                this.sdk.Ct().dispatchPostbackRequest(dispatchPostbackRequest, (AppLovinPostbackListener) null);
            }
            this.adEventTracker.x(view);
            this.adEventTracker.IL();
            if (this.sdk.BW() != null) {
                this.sdk.BW().I(getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    private List<String> getPrivacySandboxImpressionAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
    }

    private List<com.applovin.impl.sdk.d.a> getDirectClickTrackingPostbacks() {
        List<com.applovin.impl.sdk.d.a> a2;
        synchronized (this.adObjectLock) {
            a2 = u.a("click_tracking_urls", this.adObject, getClCode(), getStringFromAdObject("click_tracking_url", (String) null), this.sdk);
        }
        return a2;
    }

    private List<String> getPrivacySandboxClickAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
    }

    private boolean isDspAd() {
        return AD_RESPONSE_TYPE_ORTB.equalsIgnoreCase(getType());
    }

    public String getType() {
        return getStringFromAdObject("type", AD_RESPONSE_TYPE_UNDEFINED);
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public void onClick(View view) {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f(this.tag, "Handle view clicked");
        }
        this.sdk.BD().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, view.getContext());
    }

    public void onClick(View view, MotionEvent motionEvent) {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f(this.tag, "Handle view clicked");
        }
        this.sdk.BD().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, motionEvent, view.getContext());
    }

    /* access modifiers changed from: protected */
    public void handleNativeAdClick(Uri uri, Uri uri2, MotionEvent motionEvent, Context context) {
        if (this.sdk.BW() != null) {
            this.sdk.BW().a(getPrivacySandboxClickAttributionUrls(), motionEvent);
        }
        handleNativeAdClick(uri, uri2, context);
    }

    private void handleNativeAdClick(final Uri uri, final Uri uri2, final Context context) {
        for (String dispatchPostbackAsync : this.clickTrackingUrls) {
            this.sdk.Ct().dispatchPostbackAsync(dispatchPostbackAsync, (AppLovinPostbackListener) null);
        }
        m.a(this.eventListener, (AppLovinNativeAd) this);
        if (isDirectDownloadEnabled()) {
            this.sdk.Cr().startDirectInstallOrDownloadProcess(this, (Bundle) null, new ArrayService.DirectDownloadListener() {
                public void onAppDetailsDismissed() {
                }

                public void onAppDetailsDisplayed() {
                }

                public void onFailure() {
                    AppLovinNativeAdImpl.this.launchUri(uri, uri2, context);
                }
            });
        } else {
            launchUri(uri, uri2, context);
        }
    }

    /* access modifiers changed from: private */
    public void launchUri(Uri uri, Uri uri2, Context context) {
        if (s.a(uri, context, this.sdk)) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                String str = this.tag;
                BN.f(str, "Opening URL: " + uri);
            }
        } else if (s.a(uri2, context, this.sdk)) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN2 = this.sdk.BN();
                String str2 = this.tag;
                BN2.f(str2, "Opening backup URL: " + uri2);
            }
        }
    }

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", false);
    }

    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", (String) null);
    }

    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.adObjectLock) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.adObject, "omid_verification_script_resources", (JSONArray) null);
            if (jSONArray != null) {
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
                    try {
                        URL url = new URL(JsonUtils.getString(jSONObject, "url", (String) null));
                        String string = JsonUtils.getString(jSONObject, "vendor_key", (String) null);
                        String string2 = JsonUtils.getString(jSONObject, "parameters", (String) null);
                        if (!StringUtils.isValidString(string) || !StringUtils.isValidString(string2)) {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                            i++;
                        } else {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                            i++;
                        }
                    } catch (Throwable th) {
                        this.sdk.BN();
                        if (x.Fn()) {
                            this.sdk.BN().c(this.tag, "Failed to parse OMID verification script resource", th);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", (String) null);
    }

    public Bundle getDirectDownloadParameters() {
        return JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", (JSONObject) null));
    }

    private class b implements ad.a {
        private final List<i> aHf;

        public List<i> HG() {
            return this.aHf;
        }

        public b(List<i> list) {
            this.aHf = list;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.canEqual(this)) {
                return false;
            }
            List<i> HG = HG();
            List<i> HG2 = bVar.HG();
            return HG != null ? HG.equals(HG2) : HG2 == null;
        }

        public int hashCode() {
            List<i> HG = HG();
            return 59 + (HG == null ? 43 : HG.hashCode());
        }

        public String toString() {
            return "AppLovinNativeAdImpl.VisibilityCallback(requests=" + HG() + ")";
        }

        public void onLogVisibilityImpression() {
            for (i dispatchPostbackRequest : this.aHf) {
                AppLovinNativeAdImpl.this.sdk.Ct().dispatchPostbackRequest(dispatchPostbackRequest, (AppLovinPostbackListener) null);
            }
        }
    }

    private static class a implements View.OnAttachStateChangeListener {
        private final AppLovinNativeAdImpl aHe;

        public AppLovinNativeAdImpl HF() {
            return this.aHe;
        }

        public void onViewDetachedFromWindow(View view) {
        }

        public a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.aHe = appLovinNativeAdImpl;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.canEqual(this)) {
                return false;
            }
            AppLovinNativeAdImpl HF = HF();
            AppLovinNativeAdImpl HF2 = aVar.HF();
            return HF != null ? HF.equals(HF2) : HF2 == null;
        }

        public int hashCode() {
            AppLovinNativeAdImpl HF = HF();
            return 59 + (HF == null ? 43 : HF.hashCode());
        }

        public String toString() {
            return "AppLovinNativeAdImpl.OnAttachStateChangeHandler(ad=" + HF() + ")";
        }

        public void onViewAttachedToWindow(View view) {
            this.aHe.maybeHandleOnAttachedToWindow(view);
        }
    }

    public String toString() {
        return "AppLovinNativeAd{adIdNumber=" + getAdIdNumber() + " - " + getTitle() + "}";
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final JSONObject adObject;
        /* access modifiers changed from: private */
        public String advertiser;
        /* access modifiers changed from: private */
        public String body;
        /* access modifiers changed from: private */
        public String callToAction;
        /* access modifiers changed from: private */
        public Uri clickDestinationBackupUri;
        /* access modifiers changed from: private */
        public Uri clickDestinationUri;
        /* access modifiers changed from: private */
        public List<String> clickTrackingUrls;
        /* access modifiers changed from: private */
        public final JSONObject fullResponse;
        /* access modifiers changed from: private */
        public Uri iconUri;
        /* access modifiers changed from: private */
        public List<i> impressionRequests;
        /* access modifiers changed from: private */
        public List<String> jsTrackers;
        /* access modifiers changed from: private */
        public Uri mainImageUri;
        /* access modifiers changed from: private */
        public Uri privacyDestinationUri;
        /* access modifiers changed from: private */
        public Uri privacyIconUri;
        /* access modifiers changed from: private */
        public final n sdk;
        /* access modifiers changed from: private */
        public Double starRating;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public com.applovin.impl.b.a vastAd;
        /* access modifiers changed from: private */
        public List<i> viewableMRC100Requests;
        /* access modifiers changed from: private */
        public List<i> viewableMRC50Requests;
        /* access modifiers changed from: private */
        public List<i> viewableVideo50Requests;

        public Builder setAdvertiser(String str) {
            this.advertiser = str;
            return this;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.callToAction = str;
            return this;
        }

        public Builder setClickDestinationBackupUri(Uri uri) {
            this.clickDestinationBackupUri = uri;
            return this;
        }

        public Builder setClickDestinationUri(Uri uri) {
            this.clickDestinationUri = uri;
            return this;
        }

        public Builder setClickTrackingUrls(List<String> list) {
            this.clickTrackingUrls = list;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        public Builder setImpressionRequests(List<i> list) {
            this.impressionRequests = list;
            return this;
        }

        public Builder setJsTrackers(List<String> list) {
            this.jsTrackers = list;
            return this;
        }

        public Builder setMainImageUri(Uri uri) {
            this.mainImageUri = uri;
            return this;
        }

        public Builder setPrivacyDestinationUri(Uri uri) {
            this.privacyDestinationUri = uri;
            return this;
        }

        public Builder setPrivacyIconUri(Uri uri) {
            this.privacyIconUri = uri;
            return this;
        }

        public Builder setStarRating(Double d) {
            this.starRating = d;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setVastAd(com.applovin.impl.b.a aVar) {
            this.vastAd = aVar;
            return this;
        }

        public Builder setViewableMRC100Requests(List<i> list) {
            this.viewableMRC100Requests = list;
            return this;
        }

        public Builder setViewableMRC50Requests(List<i> list) {
            this.viewableMRC50Requests = list;
            return this;
        }

        public Builder setViewableVideo50Requests(List<i> list) {
            this.viewableVideo50Requests = list;
            return this;
        }

        public Builder(JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.sdk = nVar;
        }

        public AppLovinNativeAdImpl build() {
            return new AppLovinNativeAdImpl(this);
        }
    }
}
