package com.fyber.inneractive.sdk.external;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.i;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;
import org.json.JSONObject;

public final class BidTokenProvider {
    public static String getBidderToken() {
        if (!InneractiveAdManager.wasInitialized()) {
            IAlog.b("BidTokenProvider: Cannot generate token. Please init Fyber Marketplace SDK.", new Object[0]);
            return null;
        }
        a aVar = a.h;
        if (aVar.e.get() == null) {
            synchronized (aVar.g) {
                aVar.a();
            }
        } else {
            aVar.b();
        }
        String str = aVar.e.get();
        IAConfigManager iAConfigManager = IAConfigManager.M;
        String str2 = iAConfigManager.m;
        i iVar = iAConfigManager.u.b;
        String str3 = "token_size_limit";
        int a = iVar.a(str3, 2000, 1);
        if (!TextUtils.isEmpty(str2)) {
            str3 = String.format("%s_%s", new Object[]{"token_size_limit", str2.toLowerCase(Locale.US)});
        }
        int a2 = iVar.a(str3, a, 1);
        if (str == null || str.getBytes().length <= a2) {
            return str;
        }
        s.a aVar2 = new s.a(q.TOKEN_EXCEEDS_LIMIT);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown";
        }
        try {
            jSONObject.put("mediator", str2);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "mediator", str2);
        }
        Integer valueOf = Integer.valueOf(str.getBytes().length);
        try {
            jSONObject.put("token_size", valueOf);
        } catch (Exception unused2) {
            IAlog.e("Got exception adding param to json object: %s, %s", "token_size", valueOf);
        }
        Integer valueOf2 = Integer.valueOf(a2);
        try {
            jSONObject.put("token_limit", valueOf2);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", "token_limit", valueOf2);
        }
        aVar2.f.put(jSONObject);
        aVar2.a((String) null);
        return null;
    }
}
