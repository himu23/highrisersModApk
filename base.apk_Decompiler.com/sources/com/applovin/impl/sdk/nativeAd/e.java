package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.e.t;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.a;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.m2;
import com.ironsource.w5;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends d implements a.C0082a, AppLovinAdLoadListener {
    private final JSONObject adObject;
    private String advertiser = "";
    private final AppLovinNativeAdLoadListener awg;
    private String body = "";
    private String callToAction = "";
    private Uri clickDestinationBackupUri = null;
    private Uri clickDestinationUri = null;
    private final List<String> clickTrackingUrls = new ArrayList();
    private final JSONObject fullResponse;
    private Uri iconUri = null;
    private final List<i> impressionRequests = new ArrayList();
    private final List<String> jsTrackers = new ArrayList();
    private Uri mainImageUri = null;
    private Uri privacyDestinationUri = null;
    private Uri privacyIconUri = null;
    private Double starRating = null;
    private String title = "";
    private com.applovin.impl.b.a vastAd;
    private final List<i> viewableMRC100Requests = new ArrayList();
    private final List<i> viewableMRC50Requests = new ArrayList();
    private final List<i> viewableVideo50Requests = new ArrayList();

    public e(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super("TaskRenderNativeAd", nVar);
        this.adObject = jSONObject;
        this.fullResponse = jSONObject2;
        this.awg = appLovinNativeAdLoadListener;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v5, types: [org.json.JSONObject, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v12, types: [org.json.JSONObject, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v33 */
    public void run() {
        ? r2 = 0;
        String string = JsonUtils.getString(this.adObject, "privacy_icon_url", (String) null);
        if (URLUtil.isValidUrl(string)) {
            this.privacyIconUri = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.adObject, "privacy_url", (String) null);
        if (URLUtil.isValidUrl(string2)) {
            this.privacyDestinationUri = Uri.parse(string2);
        }
        JSONObject jSONObject = JsonUtils.getJSONObject(this.adObject, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.i(str, "No oRtb response provided: " + this.adObject);
            }
            cS("No oRtb response provided");
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, MediationMetaData.KEY_VERSION, (String) null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, m2.h.X, (JSONObject) null);
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.f(str2, "Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "native", jSONObject2);
        J(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", (JSONArray) null);
        if (jSONArray == null || jSONArray.length() == 0) {
            x xVar5 = this.logger;
            if (x.Fn()) {
                x xVar6 = this.logger;
                String str3 = this.tag;
                xVar6.i(str3, "Unable to retrieve assets - failing ad load: " + this.adObject);
            }
            cS("Unable to retrieve assets");
            return;
        }
        String str4 = "";
        int i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) r2);
            if (jSONObject4.has(m2.h.D0)) {
                this.title = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, m2.h.D0, (JSONObject) r2), m2.h.K0, r2);
                x xVar7 = this.logger;
                if (x.Fn()) {
                    x xVar8 = this.logger;
                    String str5 = this.tag;
                    xVar8.f(str5, "Processed title: " + this.title);
                }
            } else if (jSONObject4.has("link")) {
                J(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r2));
            } else if (jSONObject4.has("img")) {
                int i2 = JsonUtils.getInt(jSONObject4, w5.x, -1);
                JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r2);
                int i3 = JsonUtils.getInt(jSONObject5, "type", -1);
                String string4 = JsonUtils.getString(jSONObject5, "url", r2);
                if (i3 == 1 || 3 == i2) {
                    this.iconUri = Uri.parse(string4);
                    x xVar9 = this.logger;
                    if (x.Fn()) {
                        x xVar10 = this.logger;
                        String str6 = this.tag;
                        xVar10.f(str6, "Processed icon URL: " + this.iconUri);
                    }
                } else if (i3 == 3 || 2 == i2) {
                    this.mainImageUri = Uri.parse(string4);
                    x xVar11 = this.logger;
                    if (x.Fn()) {
                        x xVar12 = this.logger;
                        String str7 = this.tag;
                        xVar12.f(str7, "Processed main image URL: " + this.mainImageUri);
                    }
                } else {
                    x xVar13 = this.logger;
                    if (x.Fn()) {
                        x xVar14 = this.logger;
                        String str8 = this.tag;
                        xVar14.h(str8, "Unrecognized image: " + jSONObject4);
                    }
                    int i4 = JsonUtils.getInt(jSONObject5, "w", -1);
                    int i5 = JsonUtils.getInt(jSONObject5, "h", -1);
                    if (i4 <= 0 || i5 <= 0) {
                        x xVar15 = this.logger;
                        if (x.Fn()) {
                            this.logger.h(this.tag, "Skipping...");
                        }
                    } else if (((double) (((float) i4) / ((float) i5))) > 1.0d) {
                        x xVar16 = this.logger;
                        if (x.Fn()) {
                            x xVar17 = this.logger;
                            String str9 = this.tag;
                            xVar17.f(str9, "Inferring main image from " + i4 + "x" + i5 + "...");
                        }
                        this.mainImageUri = Uri.parse(string4);
                    } else {
                        x xVar18 = this.logger;
                        if (x.Fn()) {
                            x xVar19 = this.logger;
                            String str10 = this.tag;
                            xVar19.f(str10, "Inferring icon image from " + i4 + "x" + i5 + "...");
                        }
                        this.iconUri = Uri.parse(string4);
                    }
                }
            } else if (jSONObject4.has(MimeTypes.BASE_TYPE_VIDEO)) {
                str4 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, MimeTypes.BASE_TYPE_VIDEO, (JSONObject) null), "vasttag", (String) null);
                if (StringUtils.isValidString(str4)) {
                    x xVar20 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "Processed VAST video");
                    }
                } else {
                    x xVar21 = this.logger;
                    if (x.Fn()) {
                        x xVar22 = this.logger;
                        String str11 = this.tag;
                        xVar22.h(str11, "Ignoring invalid \"vasttag\" for video: " + jSONObject4);
                    }
                }
            } else if (jSONObject4.has("data")) {
                int i6 = JsonUtils.getInt(jSONObject4, w5.x, -1);
                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                int i7 = JsonUtils.getInt(jSONObject6, "type", -1);
                String string5 = JsonUtils.getString(jSONObject6, m2.h.X, (String) null);
                if (i7 == 1 || i6 == 8) {
                    this.advertiser = string5;
                    x xVar23 = this.logger;
                    if (x.Fn()) {
                        x xVar24 = this.logger;
                        String str12 = this.tag;
                        xVar24.f(str12, "Processed advertiser: " + this.advertiser);
                    }
                } else if (i7 == 2 || i6 == 4) {
                    this.body = string5;
                    x xVar25 = this.logger;
                    if (x.Fn()) {
                        x xVar26 = this.logger;
                        String str13 = this.tag;
                        xVar26.f(str13, "Processed body: " + this.body);
                    }
                } else if (i7 == 12 || i6 == 5) {
                    this.callToAction = string5;
                    x xVar27 = this.logger;
                    if (x.Fn()) {
                        x xVar28 = this.logger;
                        String str14 = this.tag;
                        xVar28.f(str14, "Processed cta: " + this.callToAction);
                    }
                } else if (i7 == 3 || i6 == 6) {
                    double a = u.a(string5, -1.0d);
                    if (a == -1.0d) {
                        x xVar29 = this.logger;
                        if (x.Fn()) {
                            x xVar30 = this.logger;
                            String str15 = this.tag;
                            xVar30.f(str15, "Received invalid star rating: " + string5);
                        }
                    } else {
                        this.starRating = Double.valueOf(a);
                        x xVar31 = this.logger;
                        if (x.Fn()) {
                            x xVar32 = this.logger;
                            String str16 = this.tag;
                            xVar32.f(str16, "Processed star rating: " + this.starRating);
                        }
                    }
                } else {
                    x xVar33 = this.logger;
                    if (x.Fn()) {
                        x xVar34 = this.logger;
                        String str17 = this.tag;
                        xVar34.h(str17, "Skipping unsupported data: " + jSONObject4);
                    }
                }
            } else {
                x xVar35 = this.logger;
                if (x.Fn()) {
                    x xVar36 = this.logger;
                    String str18 = this.tag;
                    xVar36.i(str18, "Unsupported asset object: " + jSONObject4);
                }
            }
            i++;
            r2 = 0;
        }
        String string6 = JsonUtils.getString(jSONObject3, "jstracker", (String) null);
        if (StringUtils.isValidString(string6)) {
            this.jsTrackers.add(string6);
            x xVar37 = this.logger;
            if (x.Fn()) {
                x xVar38 = this.logger;
                String str19 = this.tag;
                xVar38.f(str19, "Processed jstracker: " + string6);
            }
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", (JSONArray) null);
        if (jSONArray2 != null) {
            int i8 = 0;
            while (i8 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i8, obj);
                if (objectAtIndex instanceof String) {
                    String str20 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str20)) {
                        this.impressionRequests.add(new i.a(this.sdk).cW(str20).aU(false).aS(false).Ig());
                        x xVar39 = this.logger;
                        if (x.Fn()) {
                            x xVar40 = this.logger;
                            String str21 = this.tag;
                            xVar40.f(str21, "Processed imptracker URL: " + str20);
                        }
                    }
                }
                i8++;
                obj = null;
            }
        }
        ? r22 = 0;
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", (JSONArray) null);
        if (jSONArray3 != null) {
            int i9 = 0;
            while (i9 < jSONArray3.length()) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i9, (JSONObject) r22);
                int i10 = JsonUtils.getInt(jSONObject7, NotificationCompat.CATEGORY_EVENT, -1);
                int i11 = JsonUtils.getInt(jSONObject7, "method", -1);
                String string7 = JsonUtils.getString(jSONObject7, "url", r22);
                if (!TextUtils.isEmpty(string7)) {
                    if (i11 != 1 && i11 != 2) {
                        x xVar41 = this.logger;
                        if (x.Fn()) {
                            x xVar42 = this.logger;
                            String str22 = this.tag;
                            xVar42.i(str22, "Unsupported method for event tracker: " + jSONObject7);
                        }
                    } else if (i11 != 2 || !string7.startsWith("<script")) {
                        i IH = new i.a(this.sdk).cW(string7).aU(false).aS(false).bb(i11 == 2).Ig();
                        if (i10 == 1) {
                            this.impressionRequests.add(IH);
                            x xVar43 = this.logger;
                            if (x.Fn()) {
                                x xVar44 = this.logger;
                                String str23 = this.tag;
                                xVar44.f(str23, "Processed impression URL: " + string7);
                            }
                        } else if (i10 == 2) {
                            this.viewableMRC50Requests.add(IH);
                            x xVar45 = this.logger;
                            if (x.Fn()) {
                                x xVar46 = this.logger;
                                String str24 = this.tag;
                                xVar46.f(str24, "Processed viewable MRC50 URL: " + string7);
                            }
                        } else if (i10 == 3) {
                            this.viewableMRC100Requests.add(IH);
                            x xVar47 = this.logger;
                            if (x.Fn()) {
                                x xVar48 = this.logger;
                                String str25 = this.tag;
                                xVar48.f(str25, "Processed viewable MRC100 URL: " + string7);
                            }
                        } else {
                            if (i10 == 4) {
                                this.viewableVideo50Requests.add(IH);
                                x xVar49 = this.logger;
                                if (x.Fn()) {
                                    x xVar50 = this.logger;
                                    String str26 = this.tag;
                                    xVar50.f(str26, "Processed viewable video 50 URL: " + string7);
                                }
                            } else if (i10 == 555) {
                                x xVar51 = this.logger;
                                if (x.Fn()) {
                                    x xVar52 = this.logger;
                                    String str27 = this.tag;
                                    xVar52.f(str27, "Ignoring processing of OMID URL: " + string7);
                                }
                            } else {
                                x xVar53 = this.logger;
                                if (x.Fn()) {
                                    x xVar54 = this.logger;
                                    String str28 = this.tag;
                                    xVar54.i(str28, "Unsupported event tracker: " + jSONObject7);
                                }
                            }
                            i9++;
                            r22 = 0;
                        }
                        i9++;
                        r22 = 0;
                    } else {
                        this.jsTrackers.add(string7);
                    }
                }
                i9++;
                r22 = 0;
            }
        }
        if (StringUtils.isValidString(str4)) {
            x xVar55 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Processing VAST video...");
            }
            this.sdk.BO().b((d) t.a(str4, JsonUtils.shallowCopy(this.adObject), JsonUtils.shallowCopy(this.fullResponse), b.UNKNOWN, this, this.sdk));
            return;
        }
        HJ();
    }

    private void J(JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = JsonUtils.getString(jSONObject, "url", (String) null);
            if (StringUtils.isValidString(string)) {
                this.clickDestinationUri = Uri.parse(string);
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.f(str, "Processed click destination URL: " + this.clickDestinationUri);
                }
            }
            String string2 = JsonUtils.getString(jSONObject, "fallback", (String) null);
            if (StringUtils.isValidString(string2)) {
                this.clickDestinationBackupUri = Uri.parse(string2);
                x xVar3 = this.logger;
                if (x.Fn()) {
                    x xVar4 = this.logger;
                    String str2 = this.tag;
                    xVar4.f(str2, "Processed click destination backup URL: " + this.clickDestinationBackupUri);
                }
            }
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", (JSONArray) null);
            if (jSONArray != null) {
                try {
                    this.clickTrackingUrls.addAll(JsonUtils.toList(jSONArray));
                    x xVar5 = this.logger;
                    if (x.Fn()) {
                        x xVar6 = this.logger;
                        String str3 = this.tag;
                        xVar6.f(str3, "Processed click tracking URLs: " + this.clickTrackingUrls);
                    }
                } catch (Throwable th) {
                    x xVar7 = this.logger;
                    if (x.Fn()) {
                        this.logger.c(this.tag, "Failed to render click tracking URLs", th);
                    }
                }
            }
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "VAST ad rendered successfully");
        }
        this.vastAd = (com.applovin.impl.b.a) appLovinAd;
        HJ();
    }

    public void failedToReceiveAd(int i) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.i(this.tag, "VAST ad failed to render");
        }
        HJ();
    }

    private void HJ() {
        AppLovinNativeAdImpl build = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.adObject), JsonUtils.shallowCopy(this.fullResponse), this.sdk).setTitle(this.title).setAdvertiser(this.advertiser).setBody(this.body).setCallToAction(this.callToAction).setStarRating(this.starRating).setIconUri(this.iconUri).setMainImageUri(this.mainImageUri).setPrivacyIconUri(this.privacyIconUri).setVastAd(this.vastAd).setPrivacyDestinationUri(this.privacyDestinationUri).setClickDestinationUri(this.clickDestinationUri).setClickDestinationBackupUri(this.clickDestinationBackupUri).setClickTrackingUrls(this.clickTrackingUrls).setJsTrackers(this.jsTrackers).setImpressionRequests(this.impressionRequests).setViewableMRC50Requests(this.viewableMRC50Requests).setViewableMRC100Requests(this.viewableMRC100Requests).setViewableVideo50Requests(this.viewableVideo50Requests).build();
        build.getAdEventTracker().IJ();
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Starting cache task for type: " + build.getType() + "...");
        }
        this.sdk.BO().a((d) new a(build, this.sdk, this), q.b.MAIN);
    }

    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Successfully cached and loaded ad");
        }
        b(appLovinNativeAdImpl);
    }

    private void b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new e$$ExternalSyntheticLambda0(this, appLovinNativeAdImpl));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Preparing native ad view components...");
        }
        try {
            appLovinNativeAdImpl.setUpNativeAdViewComponents();
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Successfully prepared native ad view components");
            }
            appLovinNativeAdImpl.getAdEventTracker().IK();
            this.awg.onNativeAdLoaded(appLovinNativeAdImpl);
        } catch (Throwable th) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to prepare native ad view components", th);
            }
            cS(th.getMessage());
            this.sdk.Cs().d(this.tag, "prepareNativeComponents", th);
        }
    }

    private void cS(String str) {
        this.awg.onNativeAdLoadFailed(new AppLovinError(-6, str));
    }
}
