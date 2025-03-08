package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.adview.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.z3;
import java.util.HashMap;
import java.util.Map;

public class s {
    public static boolean a(Uri uri, Context context, n nVar) {
        boolean z = false;
        if (uri == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            if ("market".equals(intent.getScheme()) || (((Boolean) nVar.a(b.aQQ)).booleanValue() && "play.google.com".equals(uri.getHost()))) {
                intent.setPackage("com.android.vending");
            }
            nVar.Ce().pauseForClick();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                x BN = nVar.BN();
                BN.c("UriUtils", "Unable to open \"" + uri + "\".", th);
            }
            r Cs = nVar.Cs();
            Cs.d("UriUtils", "openUri:" + uri.getHost(), th);
        }
        if (!z) {
            nVar.Ce().resumeForClick();
        }
        return z;
    }

    public static boolean s(Uri uri) {
        return uri != null && "applovin".equalsIgnoreCase(uri.getScheme()) && "com.applovin.sdk".equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }

    public static void a(Uri uri, final com.applovin.impl.adview.b bVar, final n nVar) {
        d qZ = bVar.qZ();
        final String queryParameter = uri.getQueryParameter(z3.p);
        if (TextUtils.isEmpty(queryParameter)) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("UriUtils", "Could not find url to load from query in original uri");
                return;
            }
            return;
        }
        String queryParameter2 = uri.getQueryParameter("load_type");
        if ("external".equalsIgnoreCase(queryParameter2)) {
            nVar.BN();
            if (x.Fn()) {
                x BN = nVar.BN();
                BN.f("UriUtils", "Loading new page externally: " + queryParameter);
            }
            a(Uri.parse(queryParameter), qZ.getContext(), nVar);
            m.c(bVar.qQ(), (AppLovinAd) bVar.getCurrentAd(), bVar.qY());
        } else if ("internal".equalsIgnoreCase(queryParameter2)) {
            nVar.BN();
            if (x.Fn()) {
                x BN2 = nVar.BN();
                BN2.f("UriUtils", "Loading new page in WebView: " + queryParameter);
            }
            qZ.loadUrl(queryParameter);
            String queryParameter3 = uri.getQueryParameter("bg_color");
            if (StringUtils.isValidString(queryParameter3)) {
                qZ.setBackgroundColor(Color.parseColor(queryParameter3));
            }
        } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
            nVar.BN();
            if (x.Fn()) {
                x BN3 = nVar.BN();
                BN3.f("UriUtils", "Loading new page in slide-up webview: " + queryParameter);
            }
            nVar.BM().a(new a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (activity instanceof AppLovinWebViewActivity) {
                        ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                        m.a(bVar.qQ(), (AppLovinAd) bVar.getCurrentAd(), bVar.qY());
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    if (activity instanceof AppLovinWebViewActivity) {
                        m.b(bVar.qQ(), (AppLovinAd) bVar.getCurrentAd(), bVar.qY());
                        nVar.BM().b(this);
                    }
                }
            });
            Intent intent = new Intent(n.getApplicationContext(), AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, nVar.getSdkKey());
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            n.getApplicationContext().startActivity(intent);
        } else {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("UriUtils", "Could not find load type in original uri");
            }
        }
    }

    public static void a(Uri uri, e eVar, n nVar) {
        String queryParameter = uri.getQueryParameter(z3.p);
        if (URLUtil.isValidUrl(queryParameter)) {
            String appendQueryParameter = StringUtils.appendQueryParameter(queryParameter, "clcode", eVar.getClCode());
            nVar.Cu().a(h.ID().dd(appendQueryParameter).aV(false).aY(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).IF());
            return;
        }
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.i("UriUtils", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    public static Bundle t(Uri uri) {
        Bundle bundle = new Bundle();
        for (String next : uri.getQueryParameterNames()) {
            bundle.putString(next, uri.getQueryParameter(next));
        }
        return bundle;
    }

    public static void b(Uri uri, e eVar, n nVar) {
        String emptyIfNull = StringUtils.emptyIfNull(uri.getQueryParameter("error"));
        String emptyIfNull2 = StringUtils.emptyIfNull(uri.getQueryParameter("exception"));
        String emptyIfNull3 = StringUtils.emptyIfNull(uri.getQueryParameter("details"));
        HashMap hashMap = new HashMap();
        hashMap.put("source", emptyIfNull);
        hashMap.put("top_main_method", emptyIfNull2);
        if (eVar != null) {
            hashMap.put("details", "size=" + eVar.getSize() + ",ad_id=" + eVar.getAdIdNumber() + ",dsp=" + eVar.getDspName() + ",extra=" + emptyIfNull3);
        } else {
            hashMap.put("details", "extra=" + emptyIfNull3);
        }
        nVar.Cs().a(r.a.TEMPLATE_ERROR, (Map<String, String>) hashMap);
    }
}
