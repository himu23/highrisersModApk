package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.e.r;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinAdServiceImpl implements b.a, AppLovinAdService {
    private final Map<d, c> als;
    private final Object alt = new Object();
    private final Map<String, String> azs = new HashMap();
    private final AtomicReference<JSONObject> azt = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    AppLovinAdServiceImpl(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        HashMap hashMap = new HashMap(6);
        this.als = hashMap;
        hashMap.put(d.FU(), new c());
        hashMap.put(d.FV(), new c());
        hashMap.put(d.FW(), new c());
        hashMap.put(d.FX(), new c());
        hashMap.put(d.FY(), new c());
        hashMap.put(d.FZ(), new c());
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            }
            a(d.cQ(str), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public String getBidToken() {
        String str;
        if (x.Fn()) {
            this.logger.f("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (this.sdk.BV() != null) {
            str = this.sdk.BV().getBidToken();
        } else {
            str = this.sdk.BS().getBidToken();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (StringUtils.isValidString(str) && x.Fn()) {
            this.logger.f("AppLovinAdService", "Successfully retrieved bid token");
        }
        return str;
    }

    public void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            x.H("AppLovinAdService", "Empty ad token");
            a(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.sdk.ad.c cVar = new com.applovin.impl.sdk.ad.c(trim, this.sdk);
        a aVar = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKE)).booleanValue() ? new a(appLovinAdLoadListener) : appLovinAdLoadListener;
        if (cVar.FP() == c.a.REGULAR) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Loading next ad for token: " + cVar);
            }
            a((com.applovin.impl.sdk.e.d) new o(cVar, aVar, this.sdk));
        } else if (cVar.FP() == c.a.AD_RESPONSE_JSON) {
            JSONObject FR = cVar.FR();
            if (FR != null) {
                i.j(FR, this.sdk);
                i.i(FR, this.sdk);
                i.k(FR, this.sdk);
                g.o(this.sdk);
                if (JsonUtils.getJSONArray(FR, "ads", new JSONArray()).length() > 0) {
                    if (x.Fn()) {
                        this.logger.f("AppLovinAdService", "Rendering ad for token: " + cVar);
                    }
                    a((com.applovin.impl.sdk.e.d) new r(FR, u.l(FR, this.sdk), com.applovin.impl.sdk.ad.b.DECODED_AD_TOKEN_JSON, aVar, this.sdk));
                    return;
                }
                if (x.Fn()) {
                    this.logger.i("AppLovinAdService", "No ad returned from the server for token: " + cVar);
                }
                a(AppLovinError.NO_FILL, appLovinAdLoadListener);
                return;
            }
            String str2 = "Unable to retrieve ad response JSON from token: " + cVar.mQ();
            AppLovinError appLovinError = new AppLovinError(-8, str2);
            x.H("AppLovinAdService", str2);
            a(appLovinError, appLovinAdLoadListener);
        } else {
            AppLovinError appLovinError2 = new AppLovinError(-8, "Invalid token type");
            x.H("AppLovinAdService", "Invalid token type");
            a(appLovinError2, appLovinAdLoadListener);
        }
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (removeTrimmedEmptyStrings == null || removeTrimmedEmptyStrings.isEmpty()) {
            x.H("AppLovinAdService", "No zones were provided");
            b(new AppLovinError(-7, ""), appLovinAdLoadListener);
            return;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Loading next ad for zones: " + removeTrimmedEmptyStrings);
        }
        a((com.applovin.impl.sdk.e.d) new m(removeTrimmedEmptyStrings, appLovinAdLoadListener, this.sdk));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(d.cR(str), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    private void a(d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            }
            c g = g(dVar);
            synchronized (g.azC) {
                g.azF.add(appLovinAdLoadListener);
                if (!g.azD) {
                    g.azD = true;
                    a(dVar, new b(dVar, g));
                } else if (x.Fn()) {
                    this.logger.f("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    private void a(com.applovin.impl.sdk.e.d dVar) {
        if (!this.sdk.isEnabled()) {
            x.F("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.sdk.Bl();
        this.sdk.BO().a(dVar, q.b.MAIN);
    }

    /* access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd, AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new AppLovinAdServiceImpl$$ExternalSyntheticLambda2(this, appLovinAdLoadListener, appLovinAd));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th) {
            x.e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            this.sdk.Cs().d("AppLovinAdService", "notifyAdLoadedCallback", th);
        }
    }

    private void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i) {
            ((com.applovin.impl.sdk.ad.i) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    /* access modifiers changed from: private */
    public void b(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new AppLovinAdServiceImpl$$ExternalSyntheticLambda1(this, appLovinError, appLovinAdLoadListener));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            a(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th) {
            x.e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            this.sdk.Cs().d("AppLovinAdService", "notifyAdLoadFailedCallback".concat(appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i ? "V2" : ""), th);
        }
    }

    public AppLovinAd dequeueAd(d dVar) {
        AppLovinAdImpl b2 = this.sdk.Ca().b(dVar);
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Dequeued ad: " + b2 + " for zone: " + dVar + "...");
        }
        return b2;
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.azs) {
            this.azs.putAll(map);
        }
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.azs) {
            map = CollectionUtils.map(this.azs);
            this.azs.clear();
        }
        return map;
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.azt.set(jSONObject);
    }

    public JSONObject getAndResetCustomPostBody() {
        return this.azt.getAndSet((Object) null);
    }

    public void trackAndLaunchVideoClick(e eVar, Uri uri, MotionEvent motionEvent, Bundle bundle, com.applovin.impl.adview.activity.b.a aVar, Context context) {
        if (eVar != null) {
            if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
                if (x.Fn()) {
                    this.logger.f("AppLovinAdService", "Tracking VIDEO click on an ad...");
                }
                boolean z = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
                maybeSubmitPersistentPostbacks(eVar.a(motionEvent, z));
                if (this.sdk.BW() != null) {
                    this.sdk.BW().a(eVar.d(motionEvent, true, z), motionEvent);
                }
            } else if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
            }
            if (eVar.isDirectDownloadEnabled()) {
                final e eVar2 = eVar;
                final Uri uri2 = uri;
                final com.applovin.impl.adview.activity.b.a aVar2 = aVar;
                final Context context2 = context;
                this.sdk.Cr().startDirectInstallOrDownloadProcess(eVar, bundle, new ArrayService.DirectDownloadListener() {
                    public void onAppDetailsDisplayed() {
                        AppLovinAdServiceImpl.this.sdk.Ce().pauseForClick();
                    }

                    public void onAppDetailsDismissed() {
                        AppLovinAdServiceImpl.this.sdk.Ce().resumeForClick();
                    }

                    public void onFailure() {
                        x unused = AppLovinAdServiceImpl.this.logger;
                        if (x.Fn()) {
                            AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
                        }
                        AppLovinAdServiceImpl.this.a(eVar2, uri2, aVar2, context2);
                    }
                });
                return;
            }
            a(eVar, uri, aVar, context);
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track video click. No ad specified");
        }
    }

    public void trackAndLaunchClick(e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Uri uri, MotionEvent motionEvent, boolean z, Bundle bundle) {
        if (eVar != null) {
            if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
                if (x.Fn()) {
                    this.logger.f("AppLovinAdService", "Tracking click on an ad...");
                }
                boolean z2 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
                maybeSubmitPersistentPostbacks(eVar.a(motionEvent, z, z2));
                if (this.sdk.BW() != null) {
                    this.sdk.BW().a(eVar.d(motionEvent, false, z2), motionEvent);
                }
            } else if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Skipping tracking for click on an ad...");
            }
            if (appLovinAdView == null || uri == null) {
                if (x.Fn()) {
                    this.logger.i("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
                }
            } else if (eVar.isDirectDownloadEnabled()) {
                final com.applovin.impl.adview.b bVar2 = bVar;
                final e eVar2 = eVar;
                final AppLovinAdView appLovinAdView2 = appLovinAdView;
                final Uri uri2 = uri;
                this.sdk.Cr().startDirectInstallOrDownloadProcess(eVar, bundle, new ArrayService.DirectDownloadListener() {
                    public void onAppDetailsDisplayed() {
                        AppLovinAdServiceImpl.this.sdk.Ce().pauseForClick();
                        com.applovin.impl.adview.b bVar = bVar2;
                        if (bVar != null) {
                            bVar.qX();
                            com.applovin.impl.sdk.utils.m.a(bVar2.qQ(), (AppLovinAd) eVar2, appLovinAdView2);
                        }
                    }

                    public void onAppDetailsDismissed() {
                        if (bVar2 != null) {
                            AppLovinAdServiceImpl.this.sdk.Ce().resumeForClick();
                            com.applovin.impl.sdk.utils.m.b(bVar2.qQ(), (AppLovinAd) eVar2, appLovinAdView2);
                        }
                    }

                    public void onFailure() {
                        x unused = AppLovinAdServiceImpl.this.logger;
                        if (x.Fn()) {
                            AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
                        }
                        AppLovinAdServiceImpl.this.a(eVar2, appLovinAdView2, bVar2, uri2);
                    }
                });
            } else {
                a(eVar, appLovinAdView, bVar, uri);
            }
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track ad view click. No ad specified");
        }
    }

    /* access modifiers changed from: private */
    public void a(e eVar, Uri uri, com.applovin.impl.adview.activity.b.a aVar, Context context) {
        if (cx(uri.getScheme())) {
            a(uri, eVar, (com.applovin.impl.adview.b) null, aVar);
        } else if (s.s(uri)) {
            a(uri, eVar, (AppLovinAdView) null, (com.applovin.impl.adview.b) null, context, this.sdk);
        } else {
            s.a(uri, context, this.sdk);
        }
    }

    /* access modifiers changed from: private */
    public void a(e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Uri uri) {
        if (cx(uri.getScheme())) {
            a(uri, eVar, bVar, (com.applovin.impl.adview.activity.b.a) null);
        } else if (s.s(uri)) {
            a(uri, eVar, appLovinAdView, bVar, appLovinAdView.getContext(), this.sdk);
        } else {
            a(uri, eVar, appLovinAdView, bVar);
        }
    }

    public void trackImpression(e eVar) {
        if (eVar != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.Hj());
            if (this.sdk.BW() != null) {
                this.sdk.BW().I(eVar.getPrivacySandboxImpressionAttributionUrls());
            }
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track impression click. No ad specified");
        }
    }

    public void trackVideoEnd(e eVar, long j, int i, boolean z) {
        if (eVar != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Tracking video end on ad...");
            }
            List<com.applovin.impl.sdk.d.a> Hg = eVar.Hg();
            if (Hg != null && !Hg.isEmpty()) {
                String l = Long.toString(System.currentTimeMillis());
                for (com.applovin.impl.sdk.d.a next : Hg) {
                    if (StringUtils.isValidString(next.JK())) {
                        long j2 = j;
                        int i2 = i;
                        String str = l;
                        boolean z2 = z;
                        String a2 = a(next.JK(), j2, i2, str, z2);
                        String a3 = a(next.Iv(), j2, i2, str, z2);
                        if (a2 != null) {
                            a(new com.applovin.impl.sdk.d.a(a2, a3));
                        } else if (x.Fn()) {
                            x xVar = this.logger;
                            xVar.i("AppLovinAdService", "Failed to parse url: " + next.JK());
                        }
                    } else if (x.Fn()) {
                        this.logger.h("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
                    }
                }
            } else if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("AppLovinAdService", "Unable to submit persistent postback for AD #" + eVar.getAdIdNumber() + ". Missing video end tracking URL.");
            }
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track video end. No ad specified");
        }
    }

    private String a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.c("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            this.sdk.Cs().d("AppLovinAdService", "buildVideoEndUrl", th);
            return null;
        }
    }

    private void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar) {
        if (s.a(uri, appLovinAdView.getContext(), this.sdk)) {
            com.applovin.impl.sdk.utils.m.c(bVar.qQ(), (AppLovinAd) eVar, appLovinAdView);
        }
        bVar.qX();
    }

    private boolean cx(String str) {
        String str2 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.FORWARDING_CLICK_SCHEME);
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private void a(Uri uri, e eVar, com.applovin.impl.adview.b bVar, com.applovin.impl.adview.activity.b.a aVar) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Forwarding click " + uri);
        }
        eVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.CLOSE_AD_ON_FORWARDING_CLICK_SCHEME);
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (aVar != null) {
                AppLovinSdkUtils.runOnUiThread(true, new AppLovinAdServiceImpl$$ExternalSyntheticLambda0(this, aVar));
            } else if (bVar != null && !u.c(eVar.getSize())) {
                if (x.Fn()) {
                    this.logger.f("AppLovinAdService", "Closing ad after forwarding click");
                }
                bVar.qU();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(com.applovin.impl.adview.activity.b.a aVar) {
        if (aVar != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Dismissing ad after forwarding click");
            }
            aVar.dismiss();
        }
    }

    private void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, n nVar) {
        if (uri == null || !StringUtils.isValidString(uri.getQuery())) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
                return;
            }
            return;
        }
        Uri a2 = a(uri, "primaryUrl");
        List<Uri> b2 = b(uri, "primaryTrackingUrl");
        Uri a3 = a(uri, "fallbackUrl");
        List<Uri> b3 = b(uri, "fallbackTrackingUrl");
        if (a2 == null && a3 == null) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                return;
            }
            return;
        }
        if (!a(a2, "primary", b2, eVar, appLovinAdView, bVar, context, nVar)) {
            a(a3, "backup", b3, eVar, appLovinAdView, bVar, context, nVar);
        }
        if (bVar != null) {
            bVar.qX();
        }
    }

    private boolean a(Uri uri, String str, List<Uri> list, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, n nVar) {
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.f("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean a2 = s.a(uri, context, nVar);
        if (a2) {
            nVar.BN();
            if (x.Fn()) {
                x BN2 = nVar.BN();
                BN2.f("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            for (Uri uri2 : list) {
                nVar.Ct().dispatchPostbackAsync(uri2.toString(), (AppLovinPostbackListener) null);
            }
            if (bVar != null) {
                com.applovin.impl.sdk.utils.m.c(bVar.qQ(), (AppLovinAd) eVar, appLovinAdView);
            }
        } else {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("AppLovinAdService", "URL failed to open");
            }
        }
        return a2;
    }

    private Uri a(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.h("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.sdk.Cs().d("AppLovinAdService", "buildDeepLinkPlusUrl", th);
            return null;
        }
    }

    private List<Uri> b(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        for (String parse : queryParameters) {
            try {
                arrayList.add(Uri.parse(parse));
            } catch (Throwable th) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN = this.sdk.BN();
                    BN.h("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.sdk.Cs().d("AppLovinAdService", "buildDeepLinkPlusUrlList", th);
            }
        }
        return arrayList;
    }

    public void trackFullScreenAdClosed(e eVar, long j, List<Long> list, long j2, boolean z, int i) {
        if (eVar != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Tracking ad closed...");
            }
            List<com.applovin.impl.sdk.d.a> Hh = eVar.Hh();
            if (Hh != null && !Hh.isEmpty()) {
                for (com.applovin.impl.sdk.d.a next : Hh) {
                    long j3 = j;
                    long j4 = j2;
                    List<Long> list2 = list;
                    boolean z2 = z;
                    int i2 = i;
                    String a2 = a(next.JK(), j3, j4, list2, z2, i2);
                    String a3 = a(next.Iv(), j3, j4, list2, z2, i2);
                    if (StringUtils.isValidString(a2)) {
                        a(new com.applovin.impl.sdk.d.a(a2, a3));
                    } else if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.i("AppLovinAdService", "Failed to parse url: " + next.JK());
                    }
                }
            } else if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("AppLovinAdService", "Unable to track ad closed for AD #" + eVar.getAdIdNumber() + ". Missing ad close tracking URL." + eVar.getAdIdNumber());
            }
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track ad closed. No ad specified.");
        }
    }

    private String a(String str, long j, long j2, List<Long> list, boolean z, int i) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i != i.aAb) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(i.gx(i)));
        }
        return appendQueryParameter.build().toString();
    }

    public void trackAppKilled(e eVar) {
        if (eVar != null) {
            if (x.Fn()) {
                this.logger.f("AppLovinAdService", "Tracking app killed during ad...");
            }
            List<com.applovin.impl.sdk.d.a> Hi = eVar.Hi();
            if (Hi != null && !Hi.isEmpty()) {
                for (com.applovin.impl.sdk.d.a next : Hi) {
                    a(new com.applovin.impl.sdk.d.a(next.JK(), next.Iv()));
                }
            } else if (x.Fn()) {
                x xVar = this.logger;
                xVar.h("AppLovinAdService", "Unable to track app killed during AD #" + eVar.getAdIdNumber() + ". Missing app killed tracking URL.");
            }
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdService", "Unable to track app killed. No ad specified");
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.sdk.d.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.applovin.impl.sdk.d.a a2 : list) {
                a(a2);
            }
        }
    }

    private void a(com.applovin.impl.sdk.d.a aVar) {
        if (StringUtils.isValidString(aVar.JK())) {
            this.sdk.Cu().a(h.ID().dd(aVar.JK()).de(StringUtils.isValidString(aVar.Iv()) ? aVar.Iv() : null).o(aVar.HS()).aV(false).aY(aVar.Ix()).IF());
        } else if (x.Fn()) {
            this.logger.h("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, b bVar) {
        AppLovinAdImpl a2 = this.sdk.Ca().a(dVar);
        if (a2 == null || a2.isExpired()) {
            a((com.applovin.impl.sdk.e.d) new n(dVar, bVar, this.sdk));
            return;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AppLovinAdService", "Using pre-loaded ad: " + a2 + " for " + dVar);
        }
        bVar.adReceived(a2);
    }

    private c g(d dVar) {
        c cVar;
        synchronized (this.alt) {
            cVar = this.als.get(dVar);
            if (cVar == null) {
                cVar = new c();
                this.als.put(dVar, cVar);
            }
        }
        return cVar;
    }

    public void onAdExpired(g gVar) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) gVar;
        d adZone = appLovinAdImpl.getAdZone();
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.h("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.sdk.Ca().b(appLovinAdImpl);
        if (!this.sdk.Br() && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aMe)).booleanValue()) {
            c g = g(adZone);
            synchronized (g.azC) {
                if (!g.azD) {
                    this.sdk.BN();
                    if (x.Fn()) {
                        x BN = this.sdk.BN();
                        BN.f("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                    }
                    g.azD = true;
                    g.azE = true;
                    a(adZone, new b(adZone, g));
                } else if (x.Fn()) {
                    this.logger.f("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
                }
            }
        }
    }

    private class b implements com.applovin.impl.sdk.ad.i {
        private final int alS;
        private final d azA;
        private final c azB;

        private b(d dVar, c cVar) {
            this.azA = dVar;
            this.azB = cVar;
            if (Boolean.parseBoolean(AppLovinAdServiceImpl.this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES))) {
                this.alS = -1;
            } else {
                this.alS = ((Integer) AppLovinAdServiceImpl.this.sdk.a(com.applovin.impl.sdk.c.b.aKJ)).intValue();
            }
        }

        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof f)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.sdk.Ca().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.sdk.Cb().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new f(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.sdk);
            }
            Collection<AppLovinAdLoadListener> emptySet = Collections.emptySet();
            synchronized (this.azB.azC) {
                if (!this.azB.azE) {
                    emptySet = new HashSet<>(this.azB.azF);
                    this.azB.azF.clear();
                }
                this.azB.alU = 0;
                this.azB.azD = false;
                this.azB.azE = false;
            }
            for (AppLovinAdLoadListener a : emptySet) {
                AppLovinAdServiceImpl.this.a(appLovinAd, a);
            }
        }

        public void failedToReceiveAd(int i) {
            failedToReceiveAdV2(new AppLovinError(i, ""));
        }

        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            Collections.emptySet();
            synchronized (this.azB.azC) {
                AppLovinAdSize size = this.azA.getSize();
                if (!b(size) || this.azB.alU >= this.alS) {
                    HashSet<AppLovinAdLoadListener> hashSet = new HashSet<>(this.azB.azF);
                    this.azB.azF.clear();
                    this.azB.alU = 0;
                    this.azB.azD = false;
                    this.azB.azE = false;
                    for (AppLovinAdLoadListener a : hashSet) {
                        AppLovinAdServiceImpl.this.b(appLovinError, a);
                    }
                } else {
                    this.azB.alU++;
                    int pow = (int) Math.pow(2.0d, (double) this.azB.alU);
                    x unused = AppLovinAdServiceImpl.this.logger;
                    if (x.Fn()) {
                        AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Failed to load ad of zone {" + this.azA.mQ() + "} with size " + size + ". Current retry attempt: " + this.azB.alU + " of " + this.alS + ". Retrying again in " + pow + " seconds...");
                    }
                    AppLovinSdkUtils.runOnUiThreadDelayed(new AppLovinAdServiceImpl$b$$ExternalSyntheticLambda0(this), TimeUnit.SECONDS.toMillis((long) pow));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void AS() {
            AppLovinAdServiceImpl.this.a(this.azA, this);
        }

        private boolean b(AppLovinAdSize appLovinAdSize) {
            if (appLovinAdSize == null) {
                return ((Boolean) AppLovinAdServiceImpl.this.sdk.a(com.applovin.impl.sdk.c.b.aKL)).booleanValue();
            }
            return AppLovinAdServiceImpl.this.sdk.b(com.applovin.impl.sdk.c.b.aKK).contains(appLovinAdSize.getLabel());
        }
    }

    private class a implements com.applovin.impl.sdk.ad.i {
        private AppLovinAdLoadListener avU;

        public a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.avU = appLovinAdLoadListener;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof f)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.sdk.Ca().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.sdk.Cb().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new f(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.sdk);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.avU;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            } else if (((Boolean) AppLovinAdServiceImpl.this.sdk.a(com.applovin.impl.sdk.c.b.aKF)).booleanValue()) {
                throw new IllegalStateException("Unable to notify listener about ad load");
            }
        }

        public void failedToReceiveAd(int i) {
            failedToReceiveAdV2(new AppLovinError(i, ""));
        }

        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            AppLovinAdServiceImpl.this.b(appLovinError, this.avU);
            this.avU = null;
        }
    }

    private static class c {
        int alU;
        final Object azC;
        boolean azD;
        boolean azE;
        final Collection<AppLovinAdLoadListener> azF;

        private c() {
            this.azC = new Object();
            this.azF = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.azD + ", isReloadingExpiredAd=" + this.azE + ", pendingAdListeners=" + this.azF + '}';
        }
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.als + '}';
    }
}
