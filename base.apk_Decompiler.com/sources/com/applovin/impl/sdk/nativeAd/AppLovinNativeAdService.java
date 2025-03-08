package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.x;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final x logger;
    private final n sdk;

    public AppLovinNativeAdService(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            x.H(TAG, "Empty ad token");
            m.a(appLovinNativeAdLoadListener, new AppLovinError(-8, "Empty ad token"));
            return;
        }
        c cVar = new c(trim, this.sdk);
        if (cVar.FP() == c.a.REGULAR) {
            if (x.Fn()) {
                this.logger.f(TAG, "Loading next ad for token: " + cVar);
            }
            this.sdk.BO().a((d) new b(cVar, appLovinNativeAdLoadListener, this.sdk), q.b.MAIN);
        } else if (cVar.FP() == c.a.AD_RESPONSE_JSON) {
            JSONObject FR = cVar.FR();
            if (FR != null) {
                i.j(FR, this.sdk);
                i.i(FR, this.sdk);
                i.k(FR, this.sdk);
                if (JsonUtils.getJSONArray(FR, "ads", new JSONArray()).length() > 0) {
                    if (x.Fn()) {
                        this.logger.f(TAG, "Rendering ad for token: " + cVar);
                    }
                    this.sdk.BO().a((d) new d(FR, appLovinNativeAdLoadListener, this.sdk), q.b.MAIN);
                    return;
                }
                if (x.Fn()) {
                    this.logger.i(TAG, "No ad returned from the server for token: " + cVar);
                }
                m.a(appLovinNativeAdLoadListener, AppLovinError.NO_FILL);
                return;
            }
            String str2 = "Unable to retrieve ad response JSON from token: " + cVar.mQ();
            AppLovinError appLovinError = new AppLovinError(-8, str2);
            x.H(TAG, str2);
            m.a(appLovinNativeAdLoadListener, appLovinError);
        } else {
            AppLovinError appLovinError2 = new AppLovinError(-8, "Invalid token type");
            x.H(TAG, "Invalid token type");
            m.a(appLovinNativeAdLoadListener, appLovinError2);
        }
    }
}
